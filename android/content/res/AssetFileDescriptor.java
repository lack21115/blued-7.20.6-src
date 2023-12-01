package android.content.res;

import android.os.Bundle;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.alipay.sdk.util.i;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: source-9557208-dex2jar.jar:android/content/res/AssetFileDescriptor.class */
public class AssetFileDescriptor implements Parcelable, Closeable {
    public static final Parcelable.Creator<AssetFileDescriptor> CREATOR = new Parcelable.Creator<AssetFileDescriptor>() { // from class: android.content.res.AssetFileDescriptor.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AssetFileDescriptor createFromParcel(Parcel parcel) {
            return new AssetFileDescriptor(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AssetFileDescriptor[] newArray(int i) {
            return new AssetFileDescriptor[i];
        }
    };
    public static final long UNKNOWN_LENGTH = -1;
    private final Bundle mExtras;
    private final ParcelFileDescriptor mFd;
    private final long mLength;
    private final long mStartOffset;

    /* loaded from: source-9557208-dex2jar.jar:android/content/res/AssetFileDescriptor$AutoCloseInputStream.class */
    public static class AutoCloseInputStream extends ParcelFileDescriptor.AutoCloseInputStream {
        private long mRemaining;

        public AutoCloseInputStream(AssetFileDescriptor assetFileDescriptor) throws IOException {
            super(assetFileDescriptor.getParcelFileDescriptor());
            super.skip(assetFileDescriptor.getStartOffset());
            this.mRemaining = (int) assetFileDescriptor.getLength();
        }

        @Override // java.io.FileInputStream, java.io.InputStream
        public int available() throws IOException {
            if (this.mRemaining >= 0) {
                if (this.mRemaining < 2147483647L) {
                    return (int) this.mRemaining;
                }
                return Integer.MAX_VALUE;
            }
            return super.available();
        }

        @Override // java.io.InputStream
        public void mark(int i) {
            if (this.mRemaining >= 0) {
                return;
            }
            super.mark(i);
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            if (this.mRemaining >= 0) {
                return false;
            }
            return super.markSupported();
        }

        @Override // java.io.FileInputStream, java.io.InputStream
        public int read() throws IOException {
            byte[] bArr = new byte[1];
            if (read(bArr, 0, 1) == -1) {
                return -1;
            }
            return bArr[0] & 255;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr) throws IOException {
            return read(bArr, 0, bArr.length);
        }

        @Override // java.io.FileInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3;
            if (this.mRemaining >= 0) {
                if (this.mRemaining == 0) {
                    i3 = -1;
                } else {
                    int i4 = i2;
                    if (i2 > this.mRemaining) {
                        i4 = (int) this.mRemaining;
                    }
                    int read = super.read(bArr, i, i4);
                    i3 = read;
                    if (read >= 0) {
                        this.mRemaining -= read;
                        return read;
                    }
                }
                return i3;
            }
            return super.read(bArr, i, i2);
        }

        @Override // java.io.InputStream
        public void reset() throws IOException {
            synchronized (this) {
                if (this.mRemaining < 0) {
                    super.reset();
                }
            }
        }

        @Override // java.io.FileInputStream, java.io.InputStream
        public long skip(long j) throws IOException {
            long j2;
            if (this.mRemaining >= 0) {
                if (this.mRemaining == 0) {
                    j2 = -1;
                } else {
                    long j3 = j;
                    if (j > this.mRemaining) {
                        j3 = this.mRemaining;
                    }
                    long skip = super.skip(j3);
                    j2 = skip;
                    if (skip >= 0) {
                        this.mRemaining -= skip;
                        return skip;
                    }
                }
                return j2;
            }
            return super.skip(j);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/content/res/AssetFileDescriptor$AutoCloseOutputStream.class */
    public static class AutoCloseOutputStream extends ParcelFileDescriptor.AutoCloseOutputStream {
        private long mRemaining;

        public AutoCloseOutputStream(AssetFileDescriptor assetFileDescriptor) throws IOException {
            super(assetFileDescriptor.getParcelFileDescriptor());
            if (assetFileDescriptor.getParcelFileDescriptor().seekTo(assetFileDescriptor.getStartOffset()) < 0) {
                throw new IOException("Unable to seek");
            }
            this.mRemaining = (int) assetFileDescriptor.getLength();
        }

        @Override // java.io.FileOutputStream, java.io.OutputStream
        public void write(int i) throws IOException {
            if (this.mRemaining < 0) {
                super.write(i);
            } else if (this.mRemaining == 0) {
            } else {
                super.write(i);
                this.mRemaining--;
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            if (this.mRemaining < 0) {
                super.write(bArr);
            } else if (this.mRemaining == 0) {
            } else {
                int length = bArr.length;
                int i = length;
                if (length > this.mRemaining) {
                    i = (int) this.mRemaining;
                }
                super.write(bArr);
                this.mRemaining -= i;
            }
        }

        @Override // java.io.FileOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            if (this.mRemaining < 0) {
                super.write(bArr, i, i2);
            } else if (this.mRemaining == 0) {
            } else {
                int i3 = i2;
                if (i2 > this.mRemaining) {
                    i3 = (int) this.mRemaining;
                }
                super.write(bArr, i, i3);
                this.mRemaining -= i3;
            }
        }
    }

    AssetFileDescriptor(Parcel parcel) {
        this.mFd = ParcelFileDescriptor.CREATOR.createFromParcel(parcel);
        this.mStartOffset = parcel.readLong();
        this.mLength = parcel.readLong();
        if (parcel.readInt() != 0) {
            this.mExtras = parcel.readBundle();
        } else {
            this.mExtras = null;
        }
    }

    public AssetFileDescriptor(ParcelFileDescriptor parcelFileDescriptor, long j, long j2) {
        this(parcelFileDescriptor, j, j2, null);
    }

    public AssetFileDescriptor(ParcelFileDescriptor parcelFileDescriptor, long j, long j2, Bundle bundle) {
        if (parcelFileDescriptor == null) {
            throw new IllegalArgumentException("fd must not be null");
        }
        if (j2 < 0 && j != 0) {
            throw new IllegalArgumentException("startOffset must be 0 when using UNKNOWN_LENGTH");
        }
        this.mFd = parcelFileDescriptor;
        this.mStartOffset = j;
        this.mLength = j2;
        this.mExtras = bundle;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mFd.close();
    }

    public FileInputStream createInputStream() throws IOException {
        return this.mLength < 0 ? new ParcelFileDescriptor.AutoCloseInputStream(this.mFd) : new AutoCloseInputStream(this);
    }

    public FileOutputStream createOutputStream() throws IOException {
        return this.mLength < 0 ? new ParcelFileDescriptor.AutoCloseOutputStream(this.mFd) : new AutoCloseOutputStream(this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return this.mFd.describeContents();
    }

    public long getDeclaredLength() {
        return this.mLength;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public FileDescriptor getFileDescriptor() {
        return this.mFd.getFileDescriptor();
    }

    public long getLength() {
        long j;
        if (this.mLength >= 0) {
            j = this.mLength;
        } else {
            long statSize = this.mFd.getStatSize();
            j = statSize;
            if (statSize < 0) {
                return -1L;
            }
        }
        return j;
    }

    public ParcelFileDescriptor getParcelFileDescriptor() {
        return this.mFd;
    }

    public long getStartOffset() {
        return this.mStartOffset;
    }

    public String toString() {
        return "{AssetFileDescriptor: " + this.mFd + " start=" + this.mStartOffset + " len=" + this.mLength + i.d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        this.mFd.writeToParcel(parcel, i);
        parcel.writeLong(this.mStartOffset);
        parcel.writeLong(this.mLength);
        if (this.mExtras == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeBundle(this.mExtras);
    }
}
