package com.oplus.quickgame.sdk.hall.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.oplus.quickgame.sdk.engine.utils.i;
import com.oplus.quickgame.sdk.hall.Constant;
import com.oplus.quickgame.sdk.hall.b.c;
import com.oplus.quickgame.sdk.hall.behavior.Request;
import com.oplus.quickgame.sdk.hall.exception.HallRouterException;
import com.oplus.quickgame.sdk.hall.exception.NotContainsKeyException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/quickgame/sdk/hall/a/b.class */
public class b implements Request {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, Object> f24430a;

    private void a(Context context, String str) throws HallRouterException {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.setFlags(268435456);
        if (context.getPackageManager().resolveActivity(intent, 65536) == null) {
            throw new HallRouterException(HallRouterException.ErrorEnum.NO_ACTIVITY_SUPPORT_ERROR);
        }
        context.startActivity(intent);
    }

    public void a(Map<String, Object> map) {
        this.f24430a = map;
    }

    @Override // com.oplus.quickgame.sdk.hall.behavior.Request
    public void request(Context context) throws HallRouterException {
        String a2 = com.oplus.quickgame.sdk.hall.b.a.a(this.f24430a);
        if (c.a(context)) {
            if (!c.a(context, this.f24430a)) {
                throw new HallRouterException(HallRouterException.ErrorEnum.VERSION_ERROR);
            }
            a(context, a2);
        } else if (!c.b(context)) {
            HashMap hashMap = new HashMap();
            this.f24430a = hashMap;
            com.oplus.quickgame.sdk.hall.c.b.b((Map<String, Object>) hashMap).d("oaps").b("mk").c("/dt").a("pkg", Constant.Pkg.HALL_PKG);
            a(context, com.oplus.quickgame.sdk.hall.b.a.a(this.f24430a));
        } else {
            try {
                i.a("UriOaps2HapUtil", a2);
                String a3 = com.oplus.quickgame.sdk.hall.b.b.a(a2);
                i.a("UriOaps2HapUtil", a3);
                a(context, a3);
            } catch (NotContainsKeyException e) {
                throw new HallRouterException(e.getMessage());
            }
        }
    }
}
