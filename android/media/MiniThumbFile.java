package android.media;

import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Hashtable;

/* loaded from: source-9557208-dex2jar.jar:android/media/MiniThumbFile.class */
public class MiniThumbFile {
    public static final int BYTES_PER_MINTHUMB = 10000;
    private static final int HEADER_SIZE = 13;
    private static final int MINI_THUMB_DATA_FILE_VERSION = 3;
    private static final String TAG = "MiniThumbFile";
    private static final Hashtable<String, MiniThumbFile> sThumbFiles = new Hashtable<>();
    private ByteBuffer mBuffer = ByteBuffer.allocateDirect(10000);
    private FileChannel mChannel;
    private RandomAccessFile mMiniThumbFile;
    private Uri mUri;

    public MiniThumbFile(Uri uri) {
        this.mUri = uri;
    }

    public static MiniThumbFile instance(Uri uri) {
        MiniThumbFile miniThumbFile;
        synchronized (MiniThumbFile.class) {
            try {
                String str = uri.getPathSegments().get(1);
                MiniThumbFile miniThumbFile2 = sThumbFiles.get(str);
                miniThumbFile = miniThumbFile2;
                if (miniThumbFile2 == null) {
                    miniThumbFile = new MiniThumbFile(Uri.parse("content://media/external/" + str + "/media"));
                    sThumbFiles.put(str, miniThumbFile);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return miniThumbFile;
    }

    private RandomAccessFile miniThumbDataFile() {
        if (this.mMiniThumbFile == null) {
            removeOldFile();
            String randomAccessFilePath = randomAccessFilePath(3);
            File parentFile = new File(randomAccessFilePath).getParentFile();
            if (!parentFile.isDirectory() && !parentFile.mkdirs()) {
                Log.e(TAG, "Unable to create .thumbnails directory " + parentFile.toString());
            }
            File file = new File(randomAccessFilePath);
            try {
                this.mMiniThumbFile = new RandomAccessFile(file, "rw");
            } catch (IOException e) {
                try {
                    this.mMiniThumbFile = new RandomAccessFile(file, "r");
                } catch (IOException e2) {
                }
            }
            if (this.mMiniThumbFile != null) {
                this.mChannel = this.mMiniThumbFile.getChannel();
            }
        }
        return this.mMiniThumbFile;
    }

    private String randomAccessFilePath(int i) {
        return (Environment.getExternalStorageDirectory().toString() + "/DCIM/.thumbnails") + "/.thumbdata" + i + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.mUri.hashCode();
    }

    private void removeOldFile() {
        File file = new File(randomAccessFilePath(2));
        if (file.exists()) {
            try {
                file.delete();
            } catch (SecurityException e) {
            }
        }
    }

    public static void reset() {
        synchronized (MiniThumbFile.class) {
            try {
                for (MiniThumbFile miniThumbFile : sThumbFiles.values()) {
                    miniThumbFile.deactivate();
                }
                sThumbFiles.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void deactivate() {
        synchronized (this) {
            if (this.mMiniThumbFile != null) {
                try {
                    this.mMiniThumbFile.close();
                    this.mMiniThumbFile = null;
                } catch (IOException e) {
                }
            }
        }
    }

    public long getMagic(long j) {
        long j2;
        FileLock lock;
        synchronized (this) {
            if (miniThumbDataFile() != null) {
                long j3 = j * 10000;
                FileLock fileLock = null;
                FileLock fileLock2 = null;
                try {
                    try {
                        this.mBuffer.clear();
                        this.mBuffer.limit(9);
                        lock = this.mChannel.lock(j3, 9L, true);
                    } catch (IOException e) {
                        Log.v(TAG, "Got exception checking file magic: ", e);
                        if (fileLock != null) {
                            try {
                                fileLock.release();
                            } catch (IOException e2) {
                            }
                        }
                    }
                } catch (RuntimeException e3) {
                    Log.e(TAG, "Got exception when reading magic, id = " + j + ", disk full or mount read-only? " + e3.getClass());
                    if (fileLock2 != null) {
                        try {
                            fileLock2.release();
                        } catch (IOException e4) {
                        }
                    }
                }
                if (this.mChannel.read(this.mBuffer, j3) == 9) {
                    this.mBuffer.position(0);
                    if (this.mBuffer.get() == 1) {
                        fileLock = lock;
                        fileLock2 = lock;
                        long j4 = this.mBuffer.getLong();
                        j2 = j4;
                        if (lock != null) {
                            try {
                                lock.release();
                                j2 = j4;
                            } catch (IOException e5) {
                                j2 = j4;
                            }
                        }
                    }
                }
                if (lock != null) {
                    try {
                        lock.release();
                    } catch (IOException e6) {
                    }
                }
            }
            j2 = 0;
        }
        return j2;
    }

    public byte[] getMiniThumbFromFile(long j, byte[] bArr) {
        byte[] bArr2;
        synchronized (this) {
            if (miniThumbDataFile() == null) {
                bArr2 = null;
            } else {
                long j2 = j * 10000;
                FileLock fileLock = null;
                FileLock fileLock2 = null;
                try {
                    this.mBuffer.clear();
                    FileLock lock = this.mChannel.lock(j2, 10000L, true);
                    int read = this.mChannel.read(this.mBuffer, j2);
                    if (read > 13) {
                        this.mBuffer.position(0);
                        byte b = this.mBuffer.get();
                        long j3 = this.mBuffer.getLong();
                        int i = this.mBuffer.getInt();
                        if (read >= i + 13 && i != 0 && j3 != 0 && b == 1 && bArr.length >= i) {
                            fileLock = lock;
                            fileLock2 = lock;
                            this.mBuffer.get(bArr, 0, i);
                            bArr2 = bArr;
                            if (lock != null) {
                                try {
                                    lock.release();
                                    bArr2 = bArr;
                                } catch (IOException e) {
                                    bArr2 = bArr;
                                }
                            }
                        }
                    }
                    if (lock != null) {
                        try {
                            lock.release();
                        } catch (IOException e2) {
                        }
                    }
                } catch (IOException e3) {
                    Log.w(TAG, "got exception when reading thumbnail id=" + j + ", exception: " + e3);
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (IOException e4) {
                        }
                    }
                } catch (RuntimeException e5) {
                    Log.e(TAG, "Got exception when reading thumbnail, id = " + j + ", disk full or mount read-only? " + e5.getClass());
                    if (fileLock2 != null) {
                        try {
                            fileLock2.release();
                        } catch (IOException e6) {
                        }
                    }
                }
                bArr2 = null;
            }
        }
        return bArr2;
    }

    public void saveMiniThumbToFile(byte[] bArr, long j, long j2) throws IOException {
        synchronized (this) {
            if (miniThumbDataFile() != null) {
                long j3 = j * 10000;
                FileLock fileLock = null;
                if (bArr != null) {
                    FileLock fileLock2 = null;
                    FileLock fileLock3 = null;
                    try {
                        if (bArr.length <= 9987) {
                            this.mBuffer.clear();
                            this.mBuffer.put((byte) 1);
                            this.mBuffer.putLong(j2);
                            this.mBuffer.putInt(bArr.length);
                            this.mBuffer.put(bArr);
                            this.mBuffer.flip();
                            FileLock lock = this.mChannel.lock(j3, 10000L, false);
                            fileLock2 = lock;
                            fileLock3 = lock;
                            this.mChannel.write(this.mBuffer, j3);
                            fileLock = lock;
                        } else if (0 != 0) {
                            try {
                                throw new NullPointerException();
                            } catch (IOException e) {
                            }
                        }
                    } catch (IOException e2) {
                        Log.e(TAG, "couldn't save mini thumbnail data for " + j + "; ", e2);
                        FileLock fileLock4 = fileLock2;
                        throw e2;
                    } catch (RuntimeException e3) {
                        Log.e(TAG, "couldn't save mini thumbnail data for " + j + "; disk full or mount read-only? " + e3.getClass());
                        if (fileLock3 != null) {
                            try {
                                fileLock3.release();
                            } catch (IOException e4) {
                            }
                        }
                    }
                }
                if (fileLock != null) {
                    try {
                        fileLock.release();
                    } catch (IOException e5) {
                    }
                }
            }
        }
    }
}
