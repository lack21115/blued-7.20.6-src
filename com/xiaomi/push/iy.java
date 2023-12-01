package com.xiaomi.push;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/iy.class */
public class iy extends jc {

    /* renamed from: a  reason: collision with root package name */
    private static final jh f41540a = new jh();

    /* renamed from: a  reason: collision with other field name */
    protected int f880a;

    /* renamed from: a  reason: collision with other field name */
    protected boolean f881a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f882a;
    protected boolean b;

    /* renamed from: b  reason: collision with other field name */
    private byte[] f883b;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f41541c;

    /* renamed from: c  reason: collision with other field name */
    private byte[] f884c;
    private byte[] d;
    private byte[] e;
    private byte[] f;
    private byte[] g;
    private byte[] h;

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/iy$a.class */
    public static class a implements je {

        /* renamed from: a  reason: collision with root package name */
        protected int f41542a;

        /* renamed from: a  reason: collision with other field name */
        protected boolean f885a;
        protected boolean b;

        public a() {
            this(false, true);
        }

        public a(boolean z, boolean z2) {
            this(z, z2, 0);
        }

        public a(boolean z, boolean z2, int i) {
            this.f885a = false;
            this.b = true;
            this.f885a = z;
            this.b = z2;
            this.f41542a = i;
        }

        @Override // com.xiaomi.push.je
        public jc a(jm jmVar) {
            iy iyVar = new iy(jmVar, this.f885a, this.b);
            int i = this.f41542a;
            if (i != 0) {
                iyVar.b(i);
            }
            return iyVar;
        }
    }

    public iy(jm jmVar, boolean z, boolean z2) {
        super(jmVar);
        this.f881a = false;
        this.b = true;
        this.f41541c = false;
        this.f882a = new byte[1];
        this.f883b = new byte[2];
        this.f884c = new byte[4];
        this.d = new byte[8];
        this.e = new byte[1];
        this.f = new byte[2];
        this.g = new byte[4];
        this.h = new byte[8];
        this.f881a = z;
        this.b = z2;
    }

    private int a(byte[] bArr, int i, int i2) {
        c(i2);
        return this.f41547a.b(bArr, i, i2);
    }

    @Override // com.xiaomi.push.jc
    public byte a() {
        if (this.f41547a.b() <= 0) {
            a(this.e, 0, 1);
            return this.e[0];
        }
        byte b = this.f41547a.mo12058a()[this.f41547a.a()];
        this.f41547a.a(1);
        return b;
    }

    @Override // com.xiaomi.push.jc
    /* renamed from: a  reason: collision with other method in class */
    public double mo12029a() {
        return Double.longBitsToDouble(mo12031a());
    }

    @Override // com.xiaomi.push.jc
    /* renamed from: a  reason: collision with other method in class */
    public int mo12030a() {
        byte[] bArr = this.g;
        int i = 0;
        if (this.f41547a.b() >= 4) {
            bArr = this.f41547a.mo12058a();
            i = this.f41547a.a();
            this.f41547a.a(4);
        } else {
            a(this.g, 0, 4);
        }
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    @Override // com.xiaomi.push.jc
    /* renamed from: a  reason: collision with other method in class */
    public long mo12031a() {
        byte[] bArr = this.h;
        int i = 0;
        if (this.f41547a.b() >= 8) {
            bArr = this.f41547a.mo12058a();
            i = this.f41547a.a();
            this.f41547a.a(8);
        } else {
            a(this.h, 0, 8);
        }
        return (bArr[i + 7] & 255) | ((bArr[i] & 255) << 56) | ((bArr[i + 1] & 255) << 48) | ((bArr[i + 2] & 255) << 40) | ((bArr[i + 3] & 255) << 32) | ((bArr[i + 4] & 255) << 24) | ((bArr[i + 5] & 255) << 16) | ((bArr[i + 6] & 255) << 8);
    }

    @Override // com.xiaomi.push.jc
    /* renamed from: a  reason: collision with other method in class */
    public iz mo12032a() {
        byte a2 = a();
        return new iz("", a2, a2 == 0 ? (short) 0 : mo12039a());
    }

    @Override // com.xiaomi.push.jc
    /* renamed from: a  reason: collision with other method in class */
    public ja mo12033a() {
        return new ja(a(), mo12030a());
    }

    @Override // com.xiaomi.push.jc
    /* renamed from: a  reason: collision with other method in class */
    public jb mo12034a() {
        return new jb(a(), a(), mo12030a());
    }

    @Override // com.xiaomi.push.jc
    /* renamed from: a  reason: collision with other method in class */
    public jg mo12035a() {
        return new jg(a(), mo12030a());
    }

    @Override // com.xiaomi.push.jc
    /* renamed from: a  reason: collision with other method in class */
    public jh mo12036a() {
        return f41540a;
    }

    @Override // com.xiaomi.push.jc
    /* renamed from: a  reason: collision with other method in class */
    public String mo12037a() {
        int mo12030a = mo12030a();
        if (this.f41547a.b() >= mo12030a) {
            try {
                String str = new String(this.f41547a.mo12058a(), this.f41547a.a(), mo12030a, "UTF-8");
                this.f41547a.a(mo12030a);
                return str;
            } catch (UnsupportedEncodingException e) {
                throw new iw("JVM DOES NOT SUPPORT UTF-8");
            }
        }
        return a(mo12030a);
    }

    public String a(int i) {
        try {
            c(i);
            byte[] bArr = new byte[i];
            this.f41547a.b(bArr, 0, i);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new iw("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.xiaomi.push.jc
    /* renamed from: a  reason: collision with other method in class */
    public ByteBuffer mo12038a() {
        int mo12030a = mo12030a();
        c(mo12030a);
        if (this.f41547a.b() >= mo12030a) {
            ByteBuffer wrap = ByteBuffer.wrap(this.f41547a.mo12058a(), this.f41547a.a(), mo12030a);
            this.f41547a.a(mo12030a);
            return wrap;
        }
        byte[] bArr = new byte[mo12030a];
        this.f41547a.b(bArr, 0, mo12030a);
        return ByteBuffer.wrap(bArr);
    }

    @Override // com.xiaomi.push.jc
    /* renamed from: a  reason: collision with other method in class */
    public short mo12039a() {
        byte[] bArr = this.f;
        int i = 0;
        if (this.f41547a.b() >= 2) {
            bArr = this.f41547a.mo12058a();
            i = this.f41547a.a();
            this.f41547a.a(2);
        } else {
            a(this.f, 0, 2);
        }
        return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    @Override // com.xiaomi.push.jc
    /* renamed from: a  reason: collision with other method in class */
    public void mo12040a() {
    }

    @Override // com.xiaomi.push.jc
    public void a(byte b) {
        this.f882a[0] = b;
        this.f41547a.mo12057a(this.f882a, 0, 1);
    }

    @Override // com.xiaomi.push.jc
    /* renamed from: a  reason: collision with other method in class */
    public void mo12041a(int i) {
        byte[] bArr = this.f884c;
        bArr[0] = (byte) ((i >> 24) & 255);
        bArr[1] = (byte) ((i >> 16) & 255);
        bArr[2] = (byte) ((i >> 8) & 255);
        bArr[3] = (byte) (i & 255);
        this.f41547a.mo12057a(this.f884c, 0, 4);
    }

    @Override // com.xiaomi.push.jc
    public void a(long j) {
        byte[] bArr = this.d;
        bArr[0] = (byte) ((j >> 56) & 255);
        bArr[1] = (byte) ((j >> 48) & 255);
        bArr[2] = (byte) ((j >> 40) & 255);
        bArr[3] = (byte) ((j >> 32) & 255);
        bArr[4] = (byte) ((j >> 24) & 255);
        bArr[5] = (byte) ((j >> 16) & 255);
        bArr[6] = (byte) ((j >> 8) & 255);
        bArr[7] = (byte) (j & 255);
        this.f41547a.mo12057a(this.d, 0, 8);
    }

    @Override // com.xiaomi.push.jc
    public void a(iz izVar) {
        a(izVar.f41543a);
        a(izVar.f887a);
    }

    @Override // com.xiaomi.push.jc
    public void a(ja jaVar) {
        a(jaVar.f41545a);
        mo12041a(jaVar.f889a);
    }

    @Override // com.xiaomi.push.jc
    public void a(jb jbVar) {
        a(jbVar.f41546a);
        a(jbVar.b);
        mo12041a(jbVar.f890a);
    }

    @Override // com.xiaomi.push.jc
    public void a(jh jhVar) {
    }

    @Override // com.xiaomi.push.jc
    public void a(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            mo12041a(bytes.length);
            this.f41547a.mo12057a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException e) {
            throw new iw("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.xiaomi.push.jc
    public void a(ByteBuffer byteBuffer) {
        int limit = (byteBuffer.limit() - byteBuffer.position()) - byteBuffer.arrayOffset();
        mo12041a(limit);
        this.f41547a.mo12057a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit);
    }

    @Override // com.xiaomi.push.jc
    public void a(short s) {
        byte[] bArr = this.f883b;
        bArr[0] = (byte) ((s >> 8) & 255);
        bArr[1] = (byte) (s & 255);
        this.f41547a.mo12057a(this.f883b, 0, 2);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    @Override // com.xiaomi.push.jc
    public void a(boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    @Override // com.xiaomi.push.jc
    /* renamed from: a  reason: collision with other method in class */
    public boolean mo12042a() {
        return a() == 1;
    }

    @Override // com.xiaomi.push.jc
    public void b() {
    }

    public void b(int i) {
        this.f880a = i;
        this.f41541c = true;
    }

    @Override // com.xiaomi.push.jc
    public void c() {
        a((byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(int i) {
        if (i < 0) {
            throw new iw("Negative length: ".concat(String.valueOf(i)));
        }
        if (this.f41541c) {
            int i2 = this.f880a - i;
            this.f880a = i2;
            if (i2 < 0) {
                throw new iw("Message length exceeded: ".concat(String.valueOf(i)));
            }
        }
    }

    @Override // com.xiaomi.push.jc
    public void d() {
    }

    @Override // com.xiaomi.push.jc
    public void e() {
    }

    @Override // com.xiaomi.push.jc
    public void f() {
    }

    @Override // com.xiaomi.push.jc
    public void g() {
    }

    @Override // com.xiaomi.push.jc
    public void h() {
    }

    @Override // com.xiaomi.push.jc
    public void i() {
    }

    @Override // com.xiaomi.push.jc
    public void j() {
    }
}
