package com.ss.android.socialbase.appdownloader.u.mb;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/appdownloader/u/mb/mb.class */
class mb implements lz {
    private int[] h;
    private u hj;
    private int jb;
    private int[] je;
    private boolean ko;
    private int lc;
    private int lz;
    private int nk;
    private int o;
    private hj ox;
    private int ww;
    private int x;
    private boolean b = false;
    private C0716mb u = new C0716mb();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ss.android.socialbase.appdownloader.u.mb.mb$mb  reason: collision with other inner class name */
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/appdownloader/u/mb/mb$mb.class */
    public static final class C0716mb {
        private int b;
        private int[] mb = new int[32];
        private int ox;

        private void mb(int i) {
            int[] iArr = this.mb;
            int length = iArr.length;
            int i2 = this.ox;
            int i3 = length - i2;
            if (i3 <= i) {
                int[] iArr2 = new int[(iArr.length + i3) * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i2);
                this.mb = iArr2;
            }
        }

        public final boolean b() {
            int i;
            int[] iArr;
            int i2;
            int i3 = this.ox;
            if (i3 == 0 || (i2 = (iArr = this.mb)[(i = i3 - 1)]) == 0) {
                return false;
            }
            int i4 = i2 - 1;
            int i5 = i - 2;
            iArr[i5] = i4;
            iArr[i5 - ((i4 * 2) + 1)] = i4;
            this.ox = i3 - 2;
            return true;
        }

        public final void h() {
            mb(2);
            int i = this.ox;
            int[] iArr = this.mb;
            iArr[i] = 0;
            iArr[i + 1] = 0;
            this.ox = i + 2;
            this.b++;
        }

        public final int hj() {
            return this.b;
        }

        public final void mb() {
            this.ox = 0;
            this.b = 0;
        }

        public final void mb(int i, int i2) {
            if (this.b == 0) {
                h();
            }
            mb(2);
            int i3 = this.ox;
            int i4 = i3 - 1;
            int[] iArr = this.mb;
            int i5 = iArr[i4];
            int i6 = i5 + 1;
            iArr[(i4 - 1) - (i5 * 2)] = i6;
            iArr[i4] = i;
            iArr[i4 + 1] = i2;
            iArr[i4 + 2] = i6;
            this.ox = i3 + 2;
        }

        public final int ox() {
            int i = this.ox;
            if (i == 0) {
                return 0;
            }
            return this.mb[i - 1];
        }

        public final void u() {
            int i = this.ox;
            if (i != 0) {
                int i2 = i - 1;
                int i3 = this.mb[i2] * 2;
                if ((i2 - 1) - i3 != 0) {
                    this.ox = i - (i3 + 2);
                    this.b--;
                }
            }
        }
    }

    public mb() {
        ko();
    }

    private final int h(int i) {
        if (this.ww == 2) {
            int i2 = i * 5;
            if (i2 < this.je.length) {
                return i2;
            }
            throw new IndexOutOfBoundsException("Invalid attribute index (" + i + ").");
        }
        throw new IndexOutOfBoundsException("Current event is not START_TAG.");
    }

    private final void ko() {
        this.ww = -1;
        this.lz = -1;
        this.x = -1;
        this.jb = -1;
        this.je = null;
        this.nk = -1;
        this.o = -1;
        this.lc = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00dc, code lost:
        throw new java.io.IOException("Invalid resource ids size (" + r0 + ").");
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0271, code lost:
        throw new java.io.IOException("Invalid chunk type (" + r6 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void ww() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 627
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.u.mb.mb.ww():void");
    }

    @Override // com.ss.android.socialbase.appdownloader.u.mb.ko
    public int b() {
        return this.lz;
    }

    public int b(int i) {
        return this.je[h(i) + 4];
    }

    public int h() {
        if (this.ww != 2) {
            return -1;
        }
        return this.je.length / 5;
    }

    @Override // com.ss.android.socialbase.appdownloader.u.mb.ko
    public String hj() {
        return "XML line #" + b();
    }

    public String hj(int i) {
        int h = h(i);
        int[] iArr = this.je;
        if (iArr[h + 3] == 3) {
            return this.hj.mb(iArr[h + 2]);
        }
        int i2 = iArr[h + 4];
        return "";
    }

    public String mb(int i) {
        int i2 = this.je[h(i) + 1];
        return i2 == -1 ? "" : this.hj.mb(i2);
    }

    public void mb() {
        if (this.b) {
            this.b = false;
            this.ox.mb();
            this.ox = null;
            this.hj = null;
            this.h = null;
            this.u.mb();
            ko();
        }
    }

    public void mb(InputStream inputStream) {
        mb();
        if (inputStream != null) {
            this.ox = new hj(inputStream, false);
        }
    }

    public int ox() throws ww, IOException {
        if (this.ox != null) {
            try {
                ww();
                return this.ww;
            } catch (IOException e) {
                mb();
                throw e;
            }
        }
        throw new ww("Parser is not opened.", this, null);
    }

    public int ox(int i) {
        return this.je[h(i) + 3];
    }

    @Override // com.ss.android.socialbase.appdownloader.u.mb.ko
    public int u() {
        return -1;
    }
}
