package com.xiaomi.push;

import android.os.Build;
import com.xiaomi.push.dv;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.zip.Adler32;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/fm.class */
public class fm {

    /* renamed from: a  reason: collision with root package name */
    private int f41411a;

    /* renamed from: a  reason: collision with other field name */
    private fq f461a;

    /* renamed from: a  reason: collision with other field name */
    private OutputStream f462a;

    /* renamed from: a  reason: collision with other field name */
    ByteBuffer f463a;

    /* renamed from: a  reason: collision with other field name */
    private Adler32 f464a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f465a;
    private int b;

    /* renamed from: b  reason: collision with other field name */
    private ByteBuffer f466b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public fm(OutputStream outputStream, fq fqVar) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public int a(fj fjVar) {
        int c2 = fjVar.c();
        if (c2 > 32768) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("Blob size=" + c2 + " should be less than 32768 Drop blob chid=" + fjVar.a() + " id=" + fjVar.e());
            return 0;
        }
        this.f463a.clear();
        int i = c2 + 8 + 4;
        if (i > this.f463a.capacity() || this.f463a.capacity() > 4096) {
            this.f463a = ByteBuffer.allocate(i);
        }
        this.f463a.putShort((short) -15618);
        this.f463a.putShort((short) 5);
        this.f463a.putInt(c2);
        int position = this.f463a.position();
        this.f463a = fjVar.mo11759a(this.f463a);
        if (!"CONN".equals(fjVar.m11758a())) {
            if (this.f465a == null) {
                this.f465a = this.f461a.m11776a();
            }
            com.xiaomi.push.service.bp.a(this.f465a, this.f463a.array(), true, position, c2);
        }
        this.f464a.reset();
        this.f464a.update(this.f463a.array(), 0, this.f463a.position());
        this.f466b.putInt(0, (int) this.f464a.getValue());
        this.f462a.write(this.f463a.array(), 0, this.f463a.position());
        this.f462a.write(this.f466b.array(), 0, 4);
        this.f462a.flush();
        int position2 = this.f463a.position() + 4;
        com.xiaomi.channel.commonutils.logger.b.c("[Slim] Wrote {cmd=" + fjVar.m11758a() + ";chid=" + fjVar.a() + ";len=" + position2 + com.alipay.sdk.util.i.d);
        return position2;
    }

    public void a() {
        dv.e eVar = new dv.e();
        eVar.a(106);
        eVar.a(Build.MODEL);
        eVar.b(r.m12067a());
        eVar.c(com.xiaomi.push.service.bv.m12168a());
        eVar.b(48);
        eVar.d(this.f461a.b());
        eVar.e(this.f461a.mo11809a());
        eVar.f(Locale.getDefault().toString());
        eVar.c(Build.VERSION.SDK_INT);
        byte[] mo11794a = this.f461a.mo11809a().mo11794a();
        if (mo11794a != null) {
            eVar.a(dv.b.a(mo11794a));
        }
        fj fjVar = new fj();
        fjVar.a(0);
        fjVar.a("CONN", (String) null);
        fjVar.a(0L, "xiaomi.com", null);
        fjVar.a(eVar.a(), (String) null);
        a(fjVar);
        com.xiaomi.channel.commonutils.logger.b.m11394a("[slim] open conn: andver=" + Build.VERSION.SDK_INT + " sdk=48 tz=" + this.f41411a + ":" + this.b + " Model=" + Build.MODEL + " os=" + Build.VERSION.INCREMENTAL);
    }

    public void b() {
        fj fjVar = new fj();
        fjVar.a("CLOSE", (String) null);
        a(fjVar);
        this.f462a.close();
    }
}
