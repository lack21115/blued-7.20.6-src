package com.xiaomi.push.service;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.xiaomi.push.ct;
import com.xiaomi.push.du;
import com.xiaomi.push.dv;
import com.xiaomi.push.fh;
import com.xiaomi.push.fu;
import com.xiaomi.push.gw;
import com.xiaomi.push.service.bv;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/bl.class */
public class bl extends bv.a implements ct.a {

    /* renamed from: a  reason: collision with root package name */
    private long f41643a;

    /* renamed from: a  reason: collision with other field name */
    private XMPushService f1019a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/bl$a.class */
    public static class a implements ct.b {
        a() {
        }

        @Override // com.xiaomi.push.ct.b
        public String a(String str) {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.appendQueryParameter("sdkver", com.huawei.openalliance.ad.beans.inner.a.Code);
            buildUpon.appendQueryParameter("osver", String.valueOf(Build.VERSION.SDK_INT));
            buildUpon.appendQueryParameter(com.umeng.analytics.pro.bh.x, gw.a(Build.MODEL + ":" + Build.VERSION.INCREMENTAL));
            buildUpon.appendQueryParameter("mi", String.valueOf(com.xiaomi.push.r.a()));
            String builder = buildUpon.toString();
            com.xiaomi.channel.commonutils.logger.b.c("fetch bucket from : ".concat(String.valueOf(builder)));
            URL url = new URL(builder);
            int port = url.getPort() == -1 ? 80 : url.getPort();
            try {
                long currentTimeMillis = System.currentTimeMillis();
                String a2 = com.xiaomi.push.bh.a(com.xiaomi.push.r.m12066a(), url);
                long currentTimeMillis2 = System.currentTimeMillis();
                fh.a(url.getHost() + ":" + port, (int) (currentTimeMillis2 - currentTimeMillis), null);
                return a2;
            } catch (IOException e) {
                fh.a(url.getHost() + ":" + port, -1, e);
                throw e;
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/bl$b.class */
    static class b extends com.xiaomi.push.ct {
        protected b(Context context, com.xiaomi.push.cs csVar, ct.b bVar, String str) {
            super(context, csVar, bVar, str);
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
        @Override // com.xiaomi.push.ct
        public String a(ArrayList<String> arrayList, String str, String str2, boolean z) {
            throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        }
    }

    bl(XMPushService xMPushService) {
        this.f1019a = xMPushService;
    }

    public static void a(XMPushService xMPushService) {
        bl blVar = new bl(xMPushService);
        bv.a().a(blVar);
        synchronized (com.xiaomi.push.ct.class) {
            try {
                com.xiaomi.push.ct.a(blVar);
                com.xiaomi.push.ct.a(xMPushService, null, new a(), "0", "push", "2.2");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.xiaomi.push.ct.a
    public com.xiaomi.push.ct a(Context context, com.xiaomi.push.cs csVar, ct.b bVar, String str) {
        return new b(context, csVar, bVar, str);
    }

    @Override // com.xiaomi.push.service.bv.a
    public void a(du.a aVar) {
    }

    @Override // com.xiaomi.push.service.bv.a
    public void a(dv.b bVar) {
        com.xiaomi.push.cp b2;
        boolean z;
        if (bVar.m11651b() && bVar.m11650a() && System.currentTimeMillis() - this.f41643a > 3600000) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("fetch bucket :" + bVar.m11650a());
            this.f41643a = System.currentTimeMillis();
            com.xiaomi.push.ct a2 = com.xiaomi.push.ct.a();
            a2.m11601a();
            a2.m11604b();
            fu m12092a = this.f1019a.m12092a();
            if (m12092a == null || (b2 = a2.b(m12092a.m11784a().c())) == null) {
                return;
            }
            ArrayList<String> m11587a = b2.m11587a();
            Iterator<String> it = m11587a.iterator();
            while (true) {
                z = true;
                if (!it.hasNext()) {
                    break;
                } else if (it.next().equals(m12092a.mo11785a())) {
                    z = false;
                    break;
                }
            }
            if (!z || m11587a.isEmpty()) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m11394a("bucket changed, force reconnect");
            this.f1019a.a(0, (Exception) null);
            this.f1019a.a(false);
        }
    }
}
