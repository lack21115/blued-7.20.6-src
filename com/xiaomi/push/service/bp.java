package com.xiaomi.push.service;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/bp.class */
public class bp {

    /* renamed from: a  reason: collision with root package name */
    private static int f27955a = 8;
    private int d = -666;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f975a = new byte[256];

    /* renamed from: c  reason: collision with root package name */
    private int f27956c = 0;
    private int b = 0;

    public static int a(byte b) {
        return b >= 0 ? b : b + 256;
    }

    private void a() {
        this.f27956c = 0;
        this.b = 0;
    }

    private void a(int i, byte[] bArr, boolean z) {
        int length = bArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 256) {
                break;
            }
            this.f975a[i3] = (byte) i3;
            i2 = i3 + 1;
        }
        this.f27956c = 0;
        this.b = 0;
        while (true) {
            int i4 = this.b;
            if (i4 >= i) {
                break;
            }
            int a2 = ((this.f27956c + a(this.f975a[i4])) + a(bArr[this.b % length])) % 256;
            this.f27956c = a2;
            a(this.f975a, this.b, a2);
            this.b++;
        }
        if (i != 256) {
            this.d = ((this.f27956c + a(this.f975a[i])) + a(bArr[i % length])) % 256;
        }
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append("S_");
            int i5 = i - 1;
            sb.append(i5);
            sb.append(":");
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 > i) {
                    break;
                }
                sb.append(" ");
                sb.append(a(this.f975a[i7]));
                i6 = i7 + 1;
            }
            sb.append("   j_");
            sb.append(i5);
            sb.append("=");
            sb.append(this.f27956c);
            sb.append("   j_");
            sb.append(i);
            sb.append("=");
            sb.append(this.d);
            sb.append("   S_");
            sb.append(i5);
            sb.append("[j_");
            sb.append(i5);
            sb.append("]=");
            sb.append(a(this.f975a[this.f27956c]));
            sb.append("   S_");
            sb.append(i5);
            sb.append("[j_");
            sb.append(i);
            sb.append("]=");
            sb.append(a(this.f975a[this.d]));
            if (this.f975a[1] != 0) {
                sb.append("   S[1]!=0");
            }
            com.xiaomi.channel.commonutils.logger.b.m8344a(sb.toString());
        }
    }

    private void a(byte[] bArr) {
        a(256, bArr, false);
    }

    private static void a(byte[] bArr, int i, int i2) {
        byte b = bArr[i];
        bArr[i] = bArr[i2];
        bArr[i2] = b;
    }

    public static byte[] a(String str, String str2) {
        byte[] m8496a = com.xiaomi.push.bk.m8496a(str);
        byte[] bytes = str2.getBytes();
        byte[] bArr = new byte[m8496a.length + 1 + bytes.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= m8496a.length) {
                break;
            }
            bArr[i2] = m8496a[i2];
            i = i2 + 1;
        }
        bArr[m8496a.length] = 95;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= bytes.length) {
                return bArr;
            }
            bArr[m8496a.length + 1 + i4] = bytes[i4];
            i3 = i4 + 1;
        }
    }

    public static byte[] a(byte[] bArr, String str) {
        return a(bArr, com.xiaomi.push.bk.m8496a(str));
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr2.length];
        bp bpVar = new bp();
        bpVar.a(bArr);
        bpVar.a();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr2.length) {
                return bArr3;
            }
            bArr3[i2] = (byte) (bArr2[i2] ^ bpVar.m9113a());
            i = i2 + 1;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z, int i, int i2) {
        byte[] bArr3;
        int i3;
        if (i < 0 || i > bArr2.length || i + i2 > bArr2.length) {
            throw new IllegalArgumentException("start = " + i + " len = " + i2);
        }
        if (z) {
            bArr3 = bArr2;
            i3 = i;
        } else {
            bArr3 = new byte[i2];
            i3 = 0;
        }
        bp bpVar = new bp();
        bpVar.a(bArr);
        bpVar.a();
        for (int i4 = 0; i4 < i2; i4++) {
            bArr3[i3 + i4] = (byte) (bArr2[i + i4] ^ bpVar.m9113a());
        }
        return bArr3;
    }

    /* renamed from: a  reason: collision with other method in class */
    byte m9113a() {
        int i = (this.b + 1) % 256;
        this.b = i;
        int a2 = (this.f27956c + a(this.f975a[i])) % 256;
        this.f27956c = a2;
        a(this.f975a, this.b, a2);
        byte[] bArr = this.f975a;
        return bArr[(a(bArr[this.b]) + a(this.f975a[this.f27956c])) % 256];
    }
}
