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
    private int f27720a;

    /* renamed from: a  reason: collision with other field name */
    private fq f414a;

    /* renamed from: a  reason: collision with other field name */
    private OutputStream f415a;

    /* renamed from: a  reason: collision with other field name */
    ByteBuffer f416a;

    /* renamed from: a  reason: collision with other field name */
    private Adler32 f417a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f418a;
    private int b;

    /* renamed from: b  reason: collision with other field name */
    private ByteBuffer f419b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public fm(OutputStream outputStream, fq fqVar) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public int a(fj fjVar) {
        int c2 = fjVar.c();
        if (c2 > 32768) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("Blob size=" + c2 + " should be less than 32768 Drop blob chid=" + fjVar.a() + " id=" + fjVar.e());
            return 0;
        }
        this.f416a.clear();
        int i = c2 + 8 + 4;
        if (i > this.f416a.capacity() || this.f416a.capacity() > 4096) {
            this.f416a = ByteBuffer.allocate(i);
        }
        this.f416a.putShort((short) -15618);
        this.f416a.putShort((short) 5);
        this.f416a.putInt(c2);
        int position = this.f416a.position();
        this.f416a = fjVar.mo8709a(this.f416a);
        if (!"CONN".equals(fjVar.m8708a())) {
            if (this.f418a == null) {
                this.f418a = this.f414a.m8726a();
            }
            com.xiaomi.push.service.bp.a(this.f418a, this.f416a.array(), true, position, c2);
        }
        this.f417a.reset();
        this.f417a.update(this.f416a.array(), 0, this.f416a.position());
        this.f419b.putInt(0, (int) this.f417a.getValue());
        this.f415a.write(this.f416a.array(), 0, this.f416a.position());
        this.f415a.write(this.f419b.array(), 0, 4);
        this.f415a.flush();
        int position2 = this.f416a.position() + 4;
        com.xiaomi.channel.commonutils.logger.b.c("[Slim] Wrote {cmd=" + fjVar.m8708a() + ";chid=" + fjVar.a() + ";len=" + position2 + "}");
        return position2;
    }

    public void a() {
        dv.e eVar = new dv.e();
        eVar.a(106);
        eVar.a(Build.MODEL);
        eVar.b(r.m9017a());
        eVar.c(com.xiaomi.push.service.bv.m9118a());
        eVar.b(48);
        eVar.d(this.f414a.b());
        eVar.e(this.f414a.mo8759a());
        eVar.f(Locale.getDefault().toString());
        eVar.c(Build.VERSION.SDK_INT);
        byte[] mo8744a = this.f414a.mo8759a().mo8744a();
        if (mo8744a != null) {
            eVar.a(dv.b.a(mo8744a));
        }
        fj fjVar = new fj();
        fjVar.a(0);
        fjVar.a("CONN", (String) null);
        fjVar.a(0L, "xiaomi.com", null);
        fjVar.a(eVar.a(), (String) null);
        a(fjVar);
        com.xiaomi.channel.commonutils.logger.b.m8344a("[slim] open conn: andver=" + Build.VERSION.SDK_INT + " sdk=48 tz=" + this.f27720a + ":" + this.b + " Model=" + Build.MODEL + " os=" + Build.VERSION.INCREMENTAL);
    }

    public void b() {
        fj fjVar = new fj();
        fjVar.a("CLOSE", (String) null);
        a(fjVar);
        this.f415a.close();
    }
}
