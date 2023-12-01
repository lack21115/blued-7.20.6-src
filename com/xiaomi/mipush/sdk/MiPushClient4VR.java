package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.Cif;
import com.xiaomi.push.hg;
import com.xiaomi.push.hq;
import com.xiaomi.push.ht;
import com.xiaomi.push.service.bd;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/MiPushClient4VR.class */
public class MiPushClient4VR {
    public static void uploadData(Context context, String str) {
        Cif cif = new Cif();
        cif.c(hq.VRUpload.f583a);
        cif.b(b.m11457a(context).m11458a());
        cif.d(context.getPackageName());
        cif.a("data", str);
        cif.a(bd.a());
        ao.a(context).a((ao) cif, hg.Notification, (ht) null);
    }
}
