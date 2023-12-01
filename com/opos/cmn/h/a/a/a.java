package com.opos.cmn.h.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/h/a/a/a.class */
public class a {
    public static boolean a(Context context) {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        try {
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.c("MiniProgramUtils", "isSupportMiniProgram", th);
        }
        if (context == null) {
            com.opos.cmn.an.f.a.b("MiniProgramUtils", "isSupportMiniProgram failed, context is null!");
        } else {
            Context applicationContext = context.getApplicationContext();
            if (b.a() && com.opos.cmn.an.h.d.a.d(applicationContext, com.opos.cmn.an.a.b.a("Y29tLnRlbmNlbnQubW0=")) && com.opos.cmn.an.h.d.a.b(applicationContext, com.opos.cmn.an.a.b.a("Y29tLnRlbmNlbnQubW0=")) >= 980) {
                z = true;
                com.opos.cmn.an.f.a.b("MiniProgramUtils", "isSupportMiniProgram result:" + z + " costTime:" + (System.currentTimeMillis() - currentTimeMillis));
                return z;
            }
        }
        z = false;
        com.opos.cmn.an.f.a.b("MiniProgramUtils", "isSupportMiniProgram result:" + z + " costTime:" + (System.currentTimeMillis() - currentTimeMillis));
        return z;
    }

    public static boolean a(Context context, com.opos.cmn.h.a.b.a aVar) {
        String str;
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        if (context == null || aVar == null) {
            str = "openMiniProgram failed, context or miniProgramParams is null!";
        } else {
            try {
            } catch (Throwable th) {
                com.opos.cmn.an.f.a.c("MiniProgramUtils", "openMiniProgram", th);
                z = false;
            }
            if (!TextUtils.isEmpty(aVar.f11280a)) {
                z = false;
                if (a(context)) {
                    IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context.getApplicationContext(), aVar.f11280a, false);
                    WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
                    req.userName = aVar.b;
                    req.path = aVar.f11281c;
                    req.miniprogramType = 0;
                    z = createWXAPI.sendReq(req);
                }
                com.opos.cmn.an.f.a.b("MiniProgramUtils", "openMiniProgram result:" + z + " costTime:" + (System.currentTimeMillis() - currentTimeMillis));
                return z;
            }
            str = "openMiniProgram failed, appId is null!";
        }
        com.opos.cmn.an.f.a.b("MiniProgramUtils", str);
        z = false;
        com.opos.cmn.an.f.a.b("MiniProgramUtils", "openMiniProgram result:" + z + " costTime:" + (System.currentTimeMillis() - currentTimeMillis));
        return z;
    }
}
