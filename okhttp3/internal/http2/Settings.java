package okhttp3.internal.http2;

import java.util.Arrays;

/* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/http2/Settings.class */
public final class Settings {
    private int a;
    private final int[] b = new int[10];

    /* JADX INFO: Access modifiers changed from: package-private */
    public Settings a(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.b;
            if (i >= iArr.length) {
                return this;
            }
            this.a = (1 << i) | this.a;
            iArr[i] = i2;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.a = 0;
        Arrays.fill(this.b, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Settings settings) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 10) {
                return;
            }
            if (settings.a(i2)) {
                a(i2, settings.b(i2));
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i) {
        return ((1 << i) & this.a) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return Integer.bitCount(this.a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i) {
        return this.b[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        if ((this.a & 2) != 0) {
            return this.b[1];
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i) {
        if ((this.a & 16) != 0) {
            i = this.b[4];
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        if ((this.a & 128) != 0) {
            return this.b[7];
        }
        return 65535;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d(int i) {
        if ((this.a & 32) != 0) {
            i = this.b[5];
        }
        return i;
    }
}
