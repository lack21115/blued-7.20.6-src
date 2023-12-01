package com.blued.android.module.common.svg_android;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/svg_android/ParserHelper.class */
public class ParserHelper {
    private static final double[] e = new double[128];

    /* renamed from: a  reason: collision with root package name */
    public int f10825a;
    private char b;

    /* renamed from: c  reason: collision with root package name */
    private CharSequence f10826c;
    private int d;

    static {
        int i = 0;
        while (true) {
            int i2 = i;
            double[] dArr = e;
            if (i2 >= dArr.length) {
                return;
            }
            dArr[i2] = Math.pow(10.0d, i2);
            i = i2 + 1;
        }
    }

    public ParserHelper(CharSequence charSequence, int i) {
        this.f10826c = charSequence;
        this.f10825a = i;
        this.d = charSequence.length();
        this.b = charSequence.charAt(i);
    }

    public static float a(int i, int i2) {
        if (i2 < -125 || i == 0) {
            return 0.0f;
        }
        if (i2 >= 128) {
            return i > 0 ? Float.POSITIVE_INFINITY : Float.NEGATIVE_INFINITY;
        } else if (i2 == 0) {
            return i;
        } else {
            int i3 = i;
            if (i >= 67108864) {
                i3 = i + 1;
            }
            double d = i3;
            double[] dArr = e;
            return (float) (i2 > 0 ? d * dArr[i2] : d / dArr[-i2]);
        }
    }

    private void a(char c2) {
        throw new RuntimeException("Unexpected char '" + c2 + "'.");
    }

    private char f() {
        int i = this.f10825a;
        if (i < this.d) {
            this.f10825a = i + 1;
        }
        int i2 = this.f10825a;
        if (i2 == this.d) {
            return (char) 0;
        }
        return this.f10826c.charAt(i2);
    }

    public void a() {
        while (true) {
            int i = this.f10825a;
            if (i >= this.d || !Character.isWhitespace(this.f10826c.charAt(i))) {
                return;
            }
            c();
        }
    }

    public void b() {
        while (true) {
            int i = this.f10825a;
            if (i >= this.d) {
                return;
            }
            char charAt = this.f10826c.charAt(i);
            if (charAt != '\t' && charAt != '\n' && charAt != ' ' && charAt != ',') {
                return;
            }
            c();
        }
    }

    public void c() {
        this.b = f();
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x049c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x007c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x007f A[LOOP:0: B:14:0x007f->B:21:0x009c, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x03e1 A[LOOP:3: B:76:0x03e1->B:77:0x03ec, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x042d  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0441  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x04a6  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x04b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public float d() {
        /*
            Method dump skipped, instructions count: 1214
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.svg_android.ParserHelper.d():float");
    }

    public float e() {
        a();
        float d = d();
        b();
        return d;
    }
}
