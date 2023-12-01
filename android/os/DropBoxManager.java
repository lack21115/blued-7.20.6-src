package android.os;

import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.android.internal.os.IDropBoxManagerService;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

/* loaded from: source-9557208-dex2jar.jar:android/os/DropBoxManager.class */
public class DropBoxManager {
    public static final String ACTION_DROPBOX_ENTRY_ADDED = "android.intent.action.DROPBOX_ENTRY_ADDED";
    public static final String EXTRA_TAG = "tag";
    public static final String EXTRA_TIME = "time";
    private static final int HAS_BYTE_ARRAY = 8;
    public static final int IS_EMPTY = 1;
    public static final int IS_GZIPPED = 4;
    public static final int IS_TEXT = 2;
    private static final String TAG = "DropBoxManager";
    private final IDropBoxManagerService mService;

    /* loaded from: source-9557208-dex2jar.jar:android/os/DropBoxManager$Entry.class */
    public static class Entry implements Parcelable, Closeable {
        public static final Parcelable.Creator<Entry> CREATOR = new Parcelable.Creator() { // from class: android.os.DropBoxManager.Entry.1
            @Override // android.os.Parcelable.Creator
            public Entry createFromParcel(Parcel parcel) {
                String readString = parcel.readString();
                long readLong = parcel.readLong();
                int readInt = parcel.readInt();
                return (readInt & 8) != 0 ? new Entry(readString, readLong, parcel.createByteArray(), readInt & (-9)) : new Entry(readString, readLong, parcel.readFileDescriptor(), readInt);
            }

            @Override // android.os.Parcelable.Creator
            public Entry[] newArray(int i) {
                return new Entry[i];
            }
        };
        private final byte[] mData;
        private final ParcelFileDescriptor mFileDescriptor;
        private final int mFlags;
        private final String mTag;
        private final long mTimeMillis;

        public Entry(String str, long j) {
            if (str == null) {
                throw new NullPointerException("tag == null");
            }
            this.mTag = str;
            this.mTimeMillis = j;
            this.mData = null;
            this.mFileDescriptor = null;
            this.mFlags = 1;
        }

        public Entry(String str, long j, ParcelFileDescriptor parcelFileDescriptor, int i) {
            boolean z = true;
            if (str == null) {
                throw new NullPointerException("tag == null");
            }
            if (((i & 1) != 0) != (parcelFileDescriptor != null ? false : z)) {
                throw new IllegalArgumentException("Bad flags: " + i);
            }
            this.mTag = str;
            this.mTimeMillis = j;
            this.mData = null;
            this.mFileDescriptor = parcelFileDescriptor;
            this.mFlags = i;
        }

        public Entry(String str, long j, File file, int i) throws IOException {
            if (str == null) {
                throw new NullPointerException("tag == null");
            }
            if ((i & 1) != 0) {
                throw new IllegalArgumentException("Bad flags: " + i);
            }
            this.mTag = str;
            this.mTimeMillis = j;
            this.mData = null;
            this.mFileDescriptor = ParcelFileDescriptor.open(file, 268435456);
            this.mFlags = i;
        }

        public Entry(String str, long j, String str2) {
            if (str == null) {
                throw new NullPointerException("tag == null");
            }
            if (str2 == null) {
                throw new NullPointerException("text == null");
            }
            this.mTag = str;
            this.mTimeMillis = j;
            this.mData = str2.getBytes();
            this.mFileDescriptor = null;
            this.mFlags = 2;
        }

        public Entry(String str, long j, byte[] bArr, int i) {
            boolean z = true;
            if (str == null) {
                throw new NullPointerException("tag == null");
            }
            if (((i & 1) != 0) != (bArr != null ? false : z)) {
                throw new IllegalArgumentException("Bad flags: " + i);
            }
            this.mTag = str;
            this.mTimeMillis = j;
            this.mData = bArr;
            this.mFileDescriptor = null;
            this.mFlags = i;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            try {
                if (this.mFileDescriptor != null) {
                    this.mFileDescriptor.close();
                }
            } catch (IOException e) {
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return this.mFileDescriptor != null ? 1 : 0;
        }

        public int getFlags() {
            return this.mFlags & (-5);
        }

        public InputStream getInputStream() throws IOException {
            InputStream autoCloseInputStream;
            if (this.mData != null) {
                autoCloseInputStream = new ByteArrayInputStream(this.mData);
            } else if (this.mFileDescriptor == null) {
                return null;
            } else {
                autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(this.mFileDescriptor);
            }
            InputStream inputStream = autoCloseInputStream;
            if ((this.mFlags & 4) != 0) {
                inputStream = new GZIPInputStream(autoCloseInputStream);
            }
            return inputStream;
        }

        public String getTag() {
            return this.mTag;
        }

        public String getText(int i) {
            int i2;
            if ((this.mFlags & 2) == 0) {
                return null;
            }
            if (this.mData != null) {
                return new String(this.mData, 0, Math.min(i, this.mData.length));
            }
            InputStream inputStream = null;
            InputStream inputStream2 = null;
            try {
                InputStream inputStream3 = getInputStream();
                if (inputStream3 == null) {
                    if (inputStream3 != null) {
                        try {
                            inputStream3.close();
                            return null;
                        } catch (IOException e) {
                            return null;
                        }
                    }
                    return null;
                }
                byte[] bArr = new byte[i];
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    i2 = i3;
                    if (i4 < 0) {
                        break;
                    }
                    i3 += i4;
                    i2 = i3;
                    if (i3 >= i) {
                        break;
                    }
                    i4 = inputStream3.read(bArr, i3, i - i3);
                }
                inputStream2 = inputStream3;
                inputStream = inputStream3;
                String str = new String(bArr, 0, i2);
                if (inputStream3 != null) {
                    try {
                        inputStream3.close();
                    } catch (IOException e2) {
                    }
                }
                return str;
            } catch (IOException e3) {
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                        return null;
                    } catch (IOException e4) {
                        return null;
                    }
                }
                return null;
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e5) {
                    }
                }
                throw th;
            }
        }

        public long getTimeMillis() {
            return this.mTimeMillis;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.mTag);
            parcel.writeLong(this.mTimeMillis);
            if (this.mFileDescriptor != null) {
                parcel.writeInt(this.mFlags & (-9));
                this.mFileDescriptor.writeToParcel(parcel, i);
                return;
            }
            parcel.writeInt(this.mFlags | 8);
            parcel.writeByteArray(this.mData);
        }
    }

    protected DropBoxManager() {
        this.mService = null;
    }

    public DropBoxManager(IDropBoxManagerService iDropBoxManagerService) {
        this.mService = iDropBoxManagerService;
    }

    public void addData(String str, byte[] bArr, int i) {
        if (bArr == null) {
            throw new NullPointerException("data == null");
        }
        try {
            this.mService.add(new Entry(str, 0L, bArr, i));
        } catch (RemoteException e) {
        }
    }

    public void addFile(String str, File file, int i) throws IOException {
        if (file == null) {
            throw new NullPointerException("file == null");
        }
        Entry entry = new Entry(str, 0L, file, i);
        try {
            this.mService.add(entry);
        } catch (RemoteException e) {
        } finally {
            entry.close();
        }
    }

    public void addText(String str, String str2) {
        try {
            this.mService.add(new Entry(str, 0L, str2));
        } catch (RemoteException e) {
        }
    }

    public Entry getNextEntry(String str, long j) {
        try {
            return this.mService.getNextEntry(str, j);
        } catch (RemoteException e) {
            return null;
        }
    }

    public boolean isTagEnabled(String str) {
        try {
            return this.mService.isTagEnabled(str);
        } catch (RemoteException e) {
            return false;
        }
    }
}
