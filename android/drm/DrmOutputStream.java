package android.drm;

import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.UnknownServiceException;
import java.util.Arrays;
import libcore.io.IoBridge;
import libcore.io.Streams;

/* loaded from: source-9557208-dex2jar.jar:android/drm/DrmOutputStream.class */
public class DrmOutputStream extends OutputStream {
    private static final String TAG = "DrmOutputStream";
    private final DrmManagerClient mClient;
    private final FileDescriptor mFd;
    private final ParcelFileDescriptor mPfd;
    private int mSessionId;

    public DrmOutputStream(DrmManagerClient drmManagerClient, ParcelFileDescriptor parcelFileDescriptor, String str) throws IOException {
        this.mSessionId = -1;
        this.mClient = drmManagerClient;
        this.mPfd = parcelFileDescriptor;
        this.mFd = parcelFileDescriptor.getFileDescriptor();
        this.mSessionId = this.mClient.openConvertSession(str);
        if (this.mSessionId == -1) {
            throw new UnknownServiceException("Failed to open DRM session for " + str);
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.mSessionId != -1) {
            Log.w(TAG, "Closing stream without finishing");
        }
        this.mPfd.close();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v103, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v104, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v37, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v38, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v51, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v52, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v65, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v66, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v79, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v80, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r7v13, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r7v18, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r7v23, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r7v32, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r7v8, types: [java.lang.Exception] */
    public void finish() throws IOException {
        String str;
        FileNotFoundException e;
        int read;
        DrmConvertedStatus closeConvertSession = this.mClient.closeConvertSession(this.mSessionId);
        if (closeConvertSession.statusCode != 1) {
            throw new IOException("Unexpected DRM status: " + closeConvertSession.statusCode);
        }
        try {
            Os.lseek(this.mFd, closeConvertSession.offset, OsConstants.SEEK_SET);
        } catch (ErrnoException e2) {
            e2.rethrowAsIOException();
        }
        String str2 = null;
        try {
            try {
                str = new String(closeConvertSession.convertedData);
                FileInputStream fileInputStream = null;
                if (str != null) {
                    try {
                        fileInputStream = new FileInputStream(str);
                    } catch (FileNotFoundException e3) {
                        e = e3;
                        Log.w(TAG, "File: " + this.mFd + " could not be found.", e);
                        String str3 = null;
                        if (str != null) {
                            try {
                                str3 = new File(str);
                            } catch (Exception e4) {
                                Log.e(TAG, "exeption");
                                str2 = e4;
                            }
                        }
                        if (str3.delete()) {
                            Log.i(TAG, "deleted the temp file ");
                            str2 = str3;
                        } else {
                            Log.i(TAG, "could not deleted the temp file ");
                            str2 = str3;
                        }
                        this.mSessionId = -1;
                    } catch (IOException e5) {
                        e = e5;
                        Log.w(TAG, "Could not access File: " + this.mFd + " .", e);
                        String str4 = null;
                        if (str != null) {
                            try {
                                str4 = new File(str);
                            } catch (Exception e6) {
                                Log.e(TAG, "exeption");
                                str2 = e6;
                            }
                        }
                        if (str4.delete()) {
                            Log.i(TAG, "deleted the temp file ");
                            str2 = str4;
                        } else {
                            Log.i(TAG, "could not deleted the temp file ");
                            str2 = str4;
                        }
                        this.mSessionId = -1;
                    } catch (IllegalArgumentException e7) {
                        e = e7;
                        Log.w(TAG, "Could not open file in mode: rw", e);
                        String str5 = null;
                        if (str != null) {
                            try {
                                str5 = new File(str);
                            } catch (Exception e8) {
                                Log.e(TAG, "exeption");
                                str2 = e8;
                            }
                        }
                        if (str5.delete()) {
                            Log.i(TAG, "deleted the temp file ");
                            str2 = str5;
                        } else {
                            Log.i(TAG, "could not deleted the temp file ");
                            str2 = str5;
                        }
                        this.mSessionId = -1;
                    } catch (SecurityException e9) {
                        e = e9;
                        Log.w(TAG, "Access to File: " + this.mFd + " was denied denied by SecurityManager.", e);
                        String str6 = null;
                        if (str != null) {
                            try {
                                str6 = new File(str);
                            } catch (Exception e10) {
                                Log.e(TAG, "exeption");
                                str2 = e10;
                            }
                        }
                        if (str6.delete()) {
                            Log.i(TAG, "deleted the temp file ");
                            str2 = str6;
                        } else {
                            Log.i(TAG, "could not deleted the temp file ");
                            str2 = str6;
                        }
                        this.mSessionId = -1;
                    } catch (Throwable th) {
                        str2 = str;
                        th = th;
                        File file = null;
                        if (str2 != null) {
                            try {
                                file = new File(str2);
                            } catch (Exception e11) {
                                Log.e(TAG, "exeption");
                                throw th;
                            }
                        }
                        if (file.delete()) {
                            Log.i(TAG, "deleted the temp file ");
                        } else {
                            Log.i(TAG, "could not deleted the temp file ");
                        }
                        throw th;
                    }
                }
                byte[] bArr = new byte[4096];
                do {
                    read = fileInputStream.read(bArr);
                    if (read > 0) {
                        IoBridge.write(this.mFd, bArr, 0, read);
                    }
                } while (read > 0);
                String str7 = null;
                if (str != null) {
                    try {
                        str7 = new File(str);
                    } catch (Exception e12) {
                        Log.e(TAG, "exeption");
                        str2 = e12;
                    }
                }
                if (str7.delete()) {
                    Log.i(TAG, "deleted the temp file ");
                    str2 = str7;
                } else {
                    Log.i(TAG, "could not deleted the temp file ");
                    str2 = str7;
                }
            } catch (FileNotFoundException e13) {
                str = null;
                e = e13;
            } catch (IOException e14) {
                e = e14;
                str = null;
            } catch (IllegalArgumentException e15) {
                e = e15;
                str = null;
            } catch (SecurityException e16) {
                e = e16;
                str = null;
            }
            this.mSessionId = -1;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        Streams.writeSingleByte(this, i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        Arrays.checkOffsetAndCount(bArr.length, i, i2);
        if (i2 != bArr.length) {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            bArr = bArr2;
        }
        DrmConvertedStatus convertData = this.mClient.convertData(this.mSessionId, bArr);
        if (convertData.statusCode != 1) {
            throw new IOException("Unexpected DRM status: " + convertData.statusCode);
        }
    }
}
