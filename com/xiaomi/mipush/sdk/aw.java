package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.Cif;
import com.xiaomi.push.ay;
import com.xiaomi.push.bn;
import com.xiaomi.push.hg;
import com.xiaomi.push.hq;
import com.xiaomi.push.ht;
import com.xiaomi.push.service.bd;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/aw.class */
public final class aw implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f41217a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ boolean f144a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(Context context, boolean z) {
        this.f41217a = context;
        this.f144a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String d;
        String d2;
        Map<String, String> map;
        String d3;
        String str;
        String str2;
        String c2;
        String c3;
        String c4;
        com.xiaomi.channel.commonutils.logger.b.m11394a("do sync info");
        Cif cif = new Cif(bd.a(), false);
        b m11457a = b.m11457a(this.f41217a);
        cif.c(hq.SyncInfo.f583a);
        cif.b(m11457a.m11458a());
        cif.d(this.f41217a.getPackageName());
        cif.f725a = new HashMap();
        Map<String, String> map2 = cif.f725a;
        Context context = this.f41217a;
        com.xiaomi.push.k.a(map2, "app_version", com.xiaomi.push.g.m11798a(context, context.getPackageName()));
        Map<String, String> map3 = cif.f725a;
        Context context2 = this.f41217a;
        com.xiaomi.push.k.a(map3, "app_version_code", Integer.toString(com.xiaomi.push.g.a(context2, context2.getPackageName())));
        com.xiaomi.push.k.a(cif.f725a, "push_sdk_vn", "5_1_0-C");
        com.xiaomi.push.k.a(cif.f725a, "push_sdk_vc", Integer.toString(50010));
        com.xiaomi.push.k.a(cif.f725a, "token", m11457a.b());
        if (!com.xiaomi.push.j.m12053d()) {
            String a2 = bn.a(com.xiaomi.push.i.c(this.f41217a));
            String e = com.xiaomi.push.i.e(this.f41217a);
            String str3 = a2;
            if (!TextUtils.isEmpty(e)) {
                str3 = a2 + "," + e;
            }
            if (!TextUtils.isEmpty(str3)) {
                com.xiaomi.push.k.a(cif.f725a, Constants.EXTRA_KEY_IMEI_MD5, str3);
            }
        }
        ay.a(this.f41217a).a(cif.f725a);
        com.xiaomi.push.k.a(cif.f725a, Constants.EXTRA_KEY_REG_ID, m11457a.m11465c());
        com.xiaomi.push.k.a(cif.f725a, Constants.EXTRA_KEY_REG_SECRET, m11457a.d());
        com.xiaomi.push.k.a(cif.f725a, Constants.EXTRA_KEY_ACCEPT_TIME, MiPushClient.getAcceptTime(this.f41217a).replace(",", "-"));
        if (this.f144a) {
            Map<String, String> map4 = cif.f725a;
            c2 = av.c(MiPushClient.getAllAlias(this.f41217a));
            com.xiaomi.push.k.a(map4, Constants.EXTRA_KEY_ALIASES_MD5, c2);
            Map<String, String> map5 = cif.f725a;
            c3 = av.c(MiPushClient.getAllTopic(this.f41217a));
            com.xiaomi.push.k.a(map5, Constants.EXTRA_KEY_TOPICS_MD5, c3);
            map = cif.f725a;
            c4 = av.c(MiPushClient.getAllUserAccount(this.f41217a));
            str = c4;
            str2 = Constants.EXTRA_KEY_ACCOUNTS_MD5;
        } else {
            Map<String, String> map6 = cif.f725a;
            d = av.d(MiPushClient.getAllAlias(this.f41217a));
            com.xiaomi.push.k.a(map6, Constants.EXTRA_KEY_ALIASES, d);
            Map<String, String> map7 = cif.f725a;
            d2 = av.d(MiPushClient.getAllTopic(this.f41217a));
            com.xiaomi.push.k.a(map7, Constants.EXTRA_KEY_TOPICS, d2);
            map = cif.f725a;
            d3 = av.d(MiPushClient.getAllUserAccount(this.f41217a));
            str = d3;
            str2 = Constants.EXTRA_KEY_ACCOUNTS;
        }
        com.xiaomi.push.k.a(map, str2, str);
        ao.a(this.f41217a).a((ao) cif, hg.Notification, false, (ht) null);
    }
}
