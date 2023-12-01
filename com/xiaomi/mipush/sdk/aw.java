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
    final /* synthetic */ Context f27526a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ boolean f97a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(Context context, boolean z) {
        this.f27526a = context;
        this.f97a = z;
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
        com.xiaomi.channel.commonutils.logger.b.m8344a("do sync info");
        Cif cif = new Cif(bd.a(), false);
        b m8407a = b.m8407a(this.f27526a);
        cif.c(hq.SyncInfo.f536a);
        cif.b(m8407a.m8408a());
        cif.d(this.f27526a.getPackageName());
        cif.f678a = new HashMap();
        Map<String, String> map2 = cif.f678a;
        Context context = this.f27526a;
        com.xiaomi.push.k.a(map2, "app_version", com.xiaomi.push.g.m8748a(context, context.getPackageName()));
        Map<String, String> map3 = cif.f678a;
        Context context2 = this.f27526a;
        com.xiaomi.push.k.a(map3, "app_version_code", Integer.toString(com.xiaomi.push.g.a(context2, context2.getPackageName())));
        com.xiaomi.push.k.a(cif.f678a, "push_sdk_vn", "5_1_0-C");
        com.xiaomi.push.k.a(cif.f678a, "push_sdk_vc", Integer.toString(50010));
        com.xiaomi.push.k.a(cif.f678a, "token", m8407a.b());
        if (!com.xiaomi.push.j.m9003d()) {
            String a2 = bn.a(com.xiaomi.push.i.c(this.f27526a));
            String e = com.xiaomi.push.i.e(this.f27526a);
            String str3 = a2;
            if (!TextUtils.isEmpty(e)) {
                str3 = a2 + "," + e;
            }
            if (!TextUtils.isEmpty(str3)) {
                com.xiaomi.push.k.a(cif.f678a, Constants.EXTRA_KEY_IMEI_MD5, str3);
            }
        }
        ay.a(this.f27526a).a(cif.f678a);
        com.xiaomi.push.k.a(cif.f678a, Constants.EXTRA_KEY_REG_ID, m8407a.m8415c());
        com.xiaomi.push.k.a(cif.f678a, Constants.EXTRA_KEY_REG_SECRET, m8407a.d());
        com.xiaomi.push.k.a(cif.f678a, Constants.EXTRA_KEY_ACCEPT_TIME, MiPushClient.getAcceptTime(this.f27526a).replace(",", Constants.ACCEPT_TIME_SEPARATOR_SERVER));
        if (this.f97a) {
            Map<String, String> map4 = cif.f678a;
            c2 = av.c(MiPushClient.getAllAlias(this.f27526a));
            com.xiaomi.push.k.a(map4, Constants.EXTRA_KEY_ALIASES_MD5, c2);
            Map<String, String> map5 = cif.f678a;
            c3 = av.c(MiPushClient.getAllTopic(this.f27526a));
            com.xiaomi.push.k.a(map5, Constants.EXTRA_KEY_TOPICS_MD5, c3);
            map = cif.f678a;
            c4 = av.c(MiPushClient.getAllUserAccount(this.f27526a));
            str = c4;
            str2 = Constants.EXTRA_KEY_ACCOUNTS_MD5;
        } else {
            Map<String, String> map6 = cif.f678a;
            d = av.d(MiPushClient.getAllAlias(this.f27526a));
            com.xiaomi.push.k.a(map6, Constants.EXTRA_KEY_ALIASES, d);
            Map<String, String> map7 = cif.f678a;
            d2 = av.d(MiPushClient.getAllTopic(this.f27526a));
            com.xiaomi.push.k.a(map7, Constants.EXTRA_KEY_TOPICS, d2);
            map = cif.f678a;
            d3 = av.d(MiPushClient.getAllUserAccount(this.f27526a));
            str = d3;
            str2 = Constants.EXTRA_KEY_ACCOUNTS;
        }
        com.xiaomi.push.k.a(map, str2, str);
        ao.a(this.f27526a).a((ao) cif, hg.Notification, false, (ht) null);
    }
}
