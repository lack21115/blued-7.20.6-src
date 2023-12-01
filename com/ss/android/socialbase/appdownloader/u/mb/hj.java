package com.ss.android.socialbase.appdownloader.u.mb;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/appdownloader/u/mb/hj.class */
public class hj {
    private int b;
    private InputStream mb;
    private boolean ox;

    public hj() {
    }

    public hj(InputStream inputStream, boolean z) {
        mb(inputStream, z);
    }

    public final void b() throws IOException {
        b(4);
    }

    public final void b(int i) throws IOException {
        if (i > 0) {
            long j = i;
            long skip = this.mb.skip(j);
            this.b = (int) (this.b + skip);
            if (skip != j) {
                throw new EOFException();
            }
        }
    }

    public final int mb(int i) throws IOException {
        int i2;
        if (i < 0 || i > 4) {
            throw new IllegalArgumentException();
        }
        if (!this.ox) {
            int i3 = 0;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 == i * 8) {
                    i2 = i3;
                    break;
                }
                int read = this.mb.read();
                if (read == -1) {
                    throw new EOFException();
                }
                this.b++;
                i3 |= read << i5;
                i4 = i5 + 8;
            }
        } else {
            int i6 = (i - 1) * 8;
            int i7 = 0;
            while (true) {
                i2 = i7;
                if (i6 < 0) {
                    break;
                }
                int read2 = this.mb.read();
                if (read2 == -1) {
                    throw new EOFException();
                }
                this.b++;
                i7 |= read2 << i6;
                i6 -= 8;
            }
        }
        return i2;
    }

    public final void mb() {
        InputStream inputStream = this.mb;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
            }
            mb(null, false);
        }
    }

    public final void mb(InputStream inputStream, boolean z) {
        this.mb = inputStream;
        this.ox = z;
        this.b = 0;
    }

    public final void mb(int[] iArr, int i, int i2) throws IOException {
        while (i2 > 0) {
            iArr[i] = ox();
            i2--;
            i++;
        }
    }

    public final int ox() throws IOException {
        return mb(4);
    }

    public final int[] ox(int i) throws IOException {
        int[] iArr = new int[i];
        mb(iArr, 0, i);
        return iArr;
    }
}
