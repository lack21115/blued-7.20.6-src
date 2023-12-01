package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.huawei.hms.support.api.entity.auth.AuthCode;
import com.igexin.assist.sdk.AssistPushConsts;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.push.Cif;
import com.xiaomi.push.bn;
import com.xiaomi.push.bv;
import com.xiaomi.push.cz;
import com.xiaomi.push.el;
import com.xiaomi.push.em;
import com.xiaomi.push.ew;
import com.xiaomi.push.hg;
import com.xiaomi.push.hl;
import com.xiaomi.push.hq;
import com.xiaomi.push.hs;
import com.xiaomi.push.ht;
import com.xiaomi.push.hu;
import com.xiaomi.push.hw;
import com.xiaomi.push.hx;
import com.xiaomi.push.ib;
import com.xiaomi.push.ic;
import com.xiaomi.push.id;
import com.xiaomi.push.ie;
import com.xiaomi.push.ih;
import com.xiaomi.push.ij;
import com.xiaomi.push.il;
import com.xiaomi.push.in;
import com.xiaomi.push.ip;
import com.xiaomi.push.iq;
import com.xiaomi.push.ir;
import com.xiaomi.push.iw;
import com.xiaomi.push.service.ay;
import com.xiaomi.push.service.ba;
import com.xiaomi.push.service.bb;
import com.xiaomi.push.service.bk;
import com.xiaomi.push.service.br;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TimeZone;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/am.class */
public class am {

    /* renamed from: a  reason: collision with root package name */
    private static am f27514a;

    /* renamed from: a  reason: collision with other field name */
    private static Object f80a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private static Queue<String> f81a;

    /* renamed from: a  reason: collision with other field name */
    private Context f82a;

    private am(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f82a = applicationContext;
        if (applicationContext == null) {
            this.f82a = context;
        }
    }

    public static Intent a(Context context, String str, Map<String, String> map, int i) {
        return com.xiaomi.push.service.ak.b(context, str, map, i);
    }

    private PushMessageHandler.a a(ic icVar, boolean z, byte[] bArr, String str, int i, Intent intent) {
        em a2;
        String packageName;
        String m8665a;
        String str2;
        String str3;
        String str4;
        MiPushMessage miPushMessage;
        em a3;
        String packageName2;
        String m8665a2;
        String str5;
        try {
            ir a4 = ai.a(this.f82a, icVar);
            if (a4 == null) {
                com.xiaomi.channel.commonutils.logger.b.d("receiving an un-recognized message. " + icVar.f659a);
                em.a(this.f82a).b(this.f82a.getPackageName(), el.m8665a(i), str, "18");
                s.c(this.f82a, icVar, z);
                return null;
            }
            hg a5 = icVar.a();
            com.xiaomi.channel.commonutils.logger.b.m8344a("processing a message, action=".concat(String.valueOf(a5)));
            switch (an.f27515a[a5.ordinal()]) {
                case 1:
                    if (!icVar.m8903b()) {
                        com.xiaomi.channel.commonutils.logger.b.d("receiving an un-encrypt message(SendMessage).");
                        return null;
                    } else if (b.m8407a(this.f82a).m8418e() && !z) {
                        com.xiaomi.channel.commonutils.logger.b.m8344a("receive a message in pause state. drop it");
                        em.a(this.f82a).a(this.f82a.getPackageName(), el.m8665a(i), str, "12");
                        return null;
                    } else {
                        ij ijVar = (ij) a4;
                        hs a6 = ijVar.a();
                        if (a6 == null) {
                            com.xiaomi.channel.commonutils.logger.b.d("receive an empty message without push content, drop it");
                            em.a(this.f82a).b(this.f82a.getPackageName(), el.m8665a(i), str, "22");
                            s.d(this.f82a, icVar, z);
                            return null;
                        }
                        int intExtra = intent.getIntExtra("notification_click_button", 0);
                        if (z) {
                            if (com.xiaomi.push.service.ak.m9063a(icVar)) {
                                MiPushClient.reportIgnoreRegMessageClicked(this.f82a, a6.m8836a(), icVar.m8895a(), icVar.f666b, a6.b());
                            } else {
                                ht htVar = icVar.m8895a() != null ? new ht(icVar.m8895a()) : new ht();
                                if (htVar.m8846a() == null) {
                                    htVar.a(new HashMap());
                                }
                                htVar.m8846a().put("notification_click_button", String.valueOf(intExtra));
                                MiPushClient.reportMessageClicked(this.f82a, a6.m8836a(), htVar, a6.b());
                            }
                        }
                        if (!z) {
                            if (!TextUtils.isEmpty(ijVar.d()) && MiPushClient.aliasSetTime(this.f82a, ijVar.d()) < 0) {
                                MiPushClient.addAlias(this.f82a, ijVar.d());
                            } else if (!TextUtils.isEmpty(ijVar.c()) && MiPushClient.topicSubscribedTime(this.f82a, ijVar.c()) < 0) {
                                MiPushClient.addTopic(this.f82a, ijVar.c());
                            }
                        }
                        if (icVar.f660a == null || icVar.f660a.m8846a() == null) {
                            str3 = null;
                            str4 = null;
                        } else {
                            str3 = icVar.f660a.f571a.get("jobkey");
                            str4 = str3;
                        }
                        String str6 = str3;
                        if (TextUtils.isEmpty(str3)) {
                            str6 = a6.m8836a();
                        }
                        if (z || !m8382a(this.f82a, str6)) {
                            MiPushMessage generateMessage = PushMessageHelper.generateMessage(ijVar, icVar.m8895a(), z);
                            if (generateMessage.getPassThrough() == 0 && !z && com.xiaomi.push.service.ak.m9064a(generateMessage.getExtra())) {
                                com.xiaomi.push.service.ak.m9059a(this.f82a, icVar, bArr);
                                return null;
                            }
                            com.xiaomi.channel.commonutils.logger.b.m8344a("receive a message, msgid=" + a6.m8836a() + ", jobkey=" + str6 + ", btn=" + intExtra);
                            String a7 = com.xiaomi.push.service.ak.a(generateMessage.getExtra(), intExtra);
                            if (z && generateMessage.getExtra() != null && !TextUtils.isEmpty(a7)) {
                                Map<String, String> extra = generateMessage.getExtra();
                                if (intExtra != 0 && icVar.m8895a() != null) {
                                    ao.a(this.f82a).a(icVar.m8895a().c(), intExtra);
                                }
                                if (com.xiaomi.push.service.ak.m9063a(icVar)) {
                                    Intent a8 = a(this.f82a, icVar.f666b, extra, intExtra);
                                    a8.putExtra("eventMessageType", i);
                                    a8.putExtra("messageId", str);
                                    a8.putExtra("jobkey", str4);
                                    if (a8 == null) {
                                        com.xiaomi.channel.commonutils.logger.b.m8344a("Getting Intent fail from ignore reg message. ");
                                        em.a(this.f82a).b(this.f82a.getPackageName(), el.m8665a(i), str, "23");
                                        return null;
                                    }
                                    String c2 = a6.c();
                                    if (!TextUtils.isEmpty(c2)) {
                                        a8.putExtra(AssistPushConsts.MSG_TYPE_PAYLOAD, c2);
                                    }
                                    this.f82a.startActivity(a8);
                                    s.a(this.f82a, icVar);
                                    em.a(this.f82a).a(this.f82a.getPackageName(), el.m8665a(i), str, 3006, a7);
                                    return null;
                                }
                                Context context = this.f82a;
                                Intent a9 = a(context, context.getPackageName(), extra, intExtra);
                                if (a9 != null) {
                                    if (!a7.equals(bk.f27951c)) {
                                        a9.putExtra(PushMessageHelper.KEY_MESSAGE, generateMessage);
                                        a9.putExtra("eventMessageType", i);
                                        a9.putExtra("messageId", str);
                                        a9.putExtra("jobkey", str4);
                                    }
                                    this.f82a.startActivity(a9);
                                    s.a(this.f82a, icVar);
                                    com.xiaomi.channel.commonutils.logger.b.m8344a("start activity succ");
                                    em.a(this.f82a).a(this.f82a.getPackageName(), el.m8665a(i), str, 1006, a7);
                                    if (a7.equals(bk.f27951c)) {
                                        em.a(this.f82a).a(this.f82a.getPackageName(), el.m8665a(i), str, "13");
                                        return null;
                                    }
                                    return null;
                                }
                                return null;
                            }
                            miPushMessage = generateMessage;
                        } else {
                            com.xiaomi.channel.commonutils.logger.b.m8344a("drop a duplicate message, key=".concat(String.valueOf(str6)));
                            em.a(this.f82a).c(this.f82a.getPackageName(), el.m8665a(i), str, "2:".concat(String.valueOf(str6)));
                            miPushMessage = null;
                        }
                        if (icVar.m8895a() == null && !z) {
                            a(ijVar, icVar);
                        }
                        return miPushMessage;
                    }
                case 2:
                    ih ihVar = (ih) a4;
                    String str7 = b.m8407a(this.f82a).f100a;
                    if (TextUtils.isEmpty(str7) || !TextUtils.equals(str7, ihVar.m8929a())) {
                        com.xiaomi.channel.commonutils.logger.b.m8344a("bad Registration result:");
                        em.a(this.f82a).b(this.f82a.getPackageName(), el.m8665a(i), str, "21");
                        return null;
                    }
                    long m8394a = ao.a(this.f82a).m8394a();
                    if (m8394a > 0 && SystemClock.elapsedRealtime() - m8394a > 900000) {
                        com.xiaomi.channel.commonutils.logger.b.m8344a("The received registration result has expired.");
                        em.a(this.f82a).b(this.f82a.getPackageName(), el.m8665a(i), str, "26");
                        return null;
                    }
                    b.m8407a(this.f82a).f100a = null;
                    long j = ihVar.f722a;
                    Context context2 = this.f82a;
                    if (j == 0) {
                        b.m8407a(context2).b(ihVar.f734e, ihVar.f735f, ihVar.f741l);
                        FCMPushHelper.persistIfXmsfSupDecrypt(this.f82a);
                        a3 = em.a(this.f82a);
                        packageName2 = this.f82a.getPackageName();
                        m8665a2 = el.m8665a(i);
                        str5 = "1";
                    } else {
                        a3 = em.a(context2);
                        packageName2 = this.f82a.getPackageName();
                        m8665a2 = el.m8665a(i);
                        str5 = "2";
                    }
                    a3.a(packageName2, m8665a2, str, AuthCode.StatusCode.PERMISSION_EXPIRED, str5);
                    ArrayList arrayList = null;
                    if (!TextUtils.isEmpty(ihVar.f734e)) {
                        arrayList = new ArrayList();
                        arrayList.add(ihVar.f734e);
                    }
                    MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ew.COMMAND_REGISTER.f364a, arrayList, ihVar.f722a, ihVar.f733d, null, ihVar.m8930a());
                    ao.a(this.f82a).m8403d();
                    return generateCommandMessage;
                case 3:
                    if (!icVar.m8903b()) {
                        com.xiaomi.channel.commonutils.logger.b.d("receiving an un-encrypt message(UnRegistration).");
                        return null;
                    }
                    if (((in) a4).f800a == 0) {
                        b.m8407a(this.f82a).m8409a();
                        MiPushClient.clearExtras(this.f82a);
                    }
                    PushMessageHandler.a();
                    return null;
                case 4:
                    il ilVar = (il) a4;
                    if (ilVar.f775a == 0) {
                        MiPushClient.addTopic(this.f82a, ilVar.b());
                    }
                    ArrayList arrayList2 = null;
                    if (!TextUtils.isEmpty(ilVar.b())) {
                        arrayList2 = new ArrayList();
                        arrayList2.add(ilVar.b());
                    }
                    com.xiaomi.channel.commonutils.logger.b.e("resp-cmd:" + ew.COMMAND_SUBSCRIBE_TOPIC + ", " + ilVar.a());
                    return PushMessageHelper.generateCommandMessage(ew.COMMAND_SUBSCRIBE_TOPIC.f364a, arrayList2, ilVar.f775a, ilVar.f781d, ilVar.c(), null);
                case 5:
                    ip ipVar = (ip) a4;
                    if (ipVar.f820a == 0) {
                        MiPushClient.removeTopic(this.f82a, ipVar.b());
                    }
                    ArrayList arrayList3 = null;
                    if (!TextUtils.isEmpty(ipVar.b())) {
                        arrayList3 = new ArrayList();
                        arrayList3.add(ipVar.b());
                    }
                    com.xiaomi.channel.commonutils.logger.b.e("resp-cmd:" + ew.COMMAND_UNSUBSCRIBE_TOPIC + ", " + ipVar.a());
                    return PushMessageHelper.generateCommandMessage(ew.COMMAND_UNSUBSCRIBE_TOPIC.f364a, arrayList3, ipVar.f820a, ipVar.f826d, ipVar.c(), null);
                case 6:
                    cz.a(this.f82a.getPackageName(), this.f82a, a4, hg.Command, bArr.length);
                    ib ibVar = (ib) a4;
                    String b = ibVar.b();
                    List<String> m8888a = ibVar.m8888a();
                    List<String> list = m8888a;
                    if (ibVar.f647a == 0) {
                        if (TextUtils.equals(b, ew.COMMAND_SET_ACCEPT_TIME.f364a) && m8888a != null && m8888a.size() > 1) {
                            MiPushClient.addAcceptTime(this.f82a, m8888a.get(0), m8888a.get(1));
                            if ("00:00".equals(m8888a.get(0)) && "00:00".equals(m8888a.get(1))) {
                                b.m8407a(this.f82a).a(true);
                            } else {
                                b.m8407a(this.f82a).a(false);
                            }
                            list = a(TimeZone.getTimeZone("GMT+08"), TimeZone.getDefault(), m8888a);
                        } else if (TextUtils.equals(b, ew.COMMAND_SET_ALIAS.f364a) && m8888a != null && m8888a.size() > 0) {
                            MiPushClient.addAlias(this.f82a, m8888a.get(0));
                            list = m8888a;
                        } else if (TextUtils.equals(b, ew.COMMAND_UNSET_ALIAS.f364a) && m8888a != null && m8888a.size() > 0) {
                            MiPushClient.removeAlias(this.f82a, m8888a.get(0));
                            list = m8888a;
                        } else if (TextUtils.equals(b, ew.COMMAND_SET_ACCOUNT.f364a) && m8888a != null && m8888a.size() > 0) {
                            MiPushClient.addAccount(this.f82a, m8888a.get(0));
                            list = m8888a;
                        } else if (!TextUtils.equals(b, ew.COMMAND_UNSET_ACCOUNT.f364a) || m8888a == null || m8888a.size() <= 0) {
                            list = m8888a;
                            if (TextUtils.equals(b, ew.COMMAND_CHK_VDEVID.f364a)) {
                                return null;
                            }
                        } else {
                            MiPushClient.removeAccount(this.f82a, m8888a.get(0));
                            list = m8888a;
                        }
                    }
                    com.xiaomi.channel.commonutils.logger.b.e("resp-cmd:" + b + ", " + ibVar.a());
                    return PushMessageHelper.generateCommandMessage(b, list, ibVar.f647a, ibVar.f655d, ibVar.c(), null);
                case 7:
                    cz.a(this.f82a.getPackageName(), this.f82a, a4, hg.Notification, bArr.length);
                    if (a4 instanceof hx) {
                        hx hxVar = (hx) a4;
                        String a10 = hxVar.a();
                        com.xiaomi.channel.commonutils.logger.b.e("resp-type:" + hxVar.b() + ", code:" + hxVar.f614a + ", " + a10);
                        if (hq.DisablePushMessage.f536a.equalsIgnoreCase(hxVar.f621d)) {
                            if (hxVar.f614a == 0) {
                                synchronized (af.class) {
                                    try {
                                        if (af.a(this.f82a).m8378a(a10)) {
                                            af.a(this.f82a).c(a10);
                                            if ("syncing".equals(af.a(this.f82a).a(au.DISABLE_PUSH))) {
                                                af.a(this.f82a).a(au.DISABLE_PUSH, "synced");
                                                MiPushClient.clearNotification(this.f82a);
                                                MiPushClient.clearLocalNotificationType(this.f82a);
                                                PushMessageHandler.a();
                                                ao.a(this.f82a).m8400b();
                                            }
                                        }
                                    } finally {
                                    }
                                }
                                return null;
                            } else if ("syncing".equals(af.a(this.f82a).a(au.DISABLE_PUSH))) {
                                synchronized (af.class) {
                                    try {
                                        if (af.a(this.f82a).m8378a(a10)) {
                                            if (af.a(this.f82a).a(a10) < 10) {
                                                af.a(this.f82a).b(a10);
                                                ao.a(this.f82a).a(true, a10);
                                            } else {
                                                af.a(this.f82a).c(a10);
                                            }
                                        }
                                    } finally {
                                    }
                                }
                                return null;
                            }
                        } else if (!hq.EnablePushMessage.f536a.equalsIgnoreCase(hxVar.f621d)) {
                            if (hq.ThirdPartyRegUpdate.f536a.equalsIgnoreCase(hxVar.f621d)) {
                                b(hxVar);
                                return null;
                            } else if (hq.UploadTinyData.f536a.equalsIgnoreCase(hxVar.f621d)) {
                                a(hxVar);
                                return null;
                            } else {
                                return null;
                            }
                        } else if (hxVar.f614a == 0) {
                            synchronized (af.class) {
                                try {
                                    if (af.a(this.f82a).m8378a(a10)) {
                                        af.a(this.f82a).c(a10);
                                        if ("syncing".equals(af.a(this.f82a).a(au.ENABLE_PUSH))) {
                                            af.a(this.f82a).a(au.ENABLE_PUSH, "synced");
                                        }
                                    }
                                } finally {
                                }
                            }
                            return null;
                        } else if ("syncing".equals(af.a(this.f82a).a(au.ENABLE_PUSH))) {
                            synchronized (af.class) {
                                try {
                                    if (af.a(this.f82a).m8378a(a10)) {
                                        if (af.a(this.f82a).a(a10) < 10) {
                                            af.a(this.f82a).b(a10);
                                            ao.a(this.f82a).a(false, a10);
                                        } else {
                                            af.a(this.f82a).c(a10);
                                        }
                                    }
                                } finally {
                                }
                            }
                            return null;
                        }
                        af.a(this.f82a).c(a10);
                        return null;
                    } else if (a4 instanceof Cif) {
                        Cif cif = (Cif) a4;
                        if ("registration id expired".equalsIgnoreCase(cif.f683d)) {
                            List<String> allAlias = MiPushClient.getAllAlias(this.f82a);
                            List<String> allTopic = MiPushClient.getAllTopic(this.f82a);
                            List<String> allUserAccount = MiPushClient.getAllUserAccount(this.f82a);
                            String acceptTime = MiPushClient.getAcceptTime(this.f82a);
                            com.xiaomi.channel.commonutils.logger.b.e("resp-type:" + cif.f683d + ", " + cif.m8913a());
                            MiPushClient.reInitialize(this.f82a, hu.RegIdExpired);
                            for (String str8 : allAlias) {
                                MiPushClient.removeAlias(this.f82a, str8);
                                MiPushClient.setAlias(this.f82a, str8, null);
                            }
                            for (String str9 : allTopic) {
                                MiPushClient.removeTopic(this.f82a, str9);
                                MiPushClient.subscribe(this.f82a, str9, null);
                            }
                            for (String str10 : allUserAccount) {
                                MiPushClient.removeAccount(this.f82a, str10);
                                MiPushClient.setUserAccount(this.f82a, str10, null);
                            }
                            String[] split = acceptTime.split(",");
                            if (split.length == 2) {
                                MiPushClient.removeAcceptTime(this.f82a);
                                MiPushClient.addAcceptTime(this.f82a, split[0], split[1]);
                                return null;
                            }
                            return null;
                        } else if (hq.ClientInfoUpdateOk.f536a.equalsIgnoreCase(cif.f683d)) {
                            if (cif.m8914a() == null || !cif.m8914a().containsKey("app_version")) {
                                return null;
                            }
                            b.m8407a(this.f82a).m8410a(cif.m8914a().get("app_version"));
                            return null;
                        } else if (hq.AwakeApp.f536a.equalsIgnoreCase(cif.f683d)) {
                            if (icVar.m8903b() && cif.m8914a() != null && cif.m8914a().containsKey("awake_info")) {
                                String str11 = cif.m8914a().get("awake_info");
                                Context context3 = this.f82a;
                                o.a(context3, b.m8407a(context3).m8408a(), ba.a(this.f82a).a(hl.AwakeInfoUploadWaySwitch.a(), 0), str11);
                                return null;
                            }
                            return null;
                        } else {
                            try {
                                if (hq.NormalClientConfigUpdate.f536a.equalsIgnoreCase(cif.f683d)) {
                                    ie ieVar = new ie();
                                    iq.a(ieVar, cif.m8919a());
                                    bb.a(ba.a(this.f82a), ieVar);
                                } else if (!hq.CustomClientConfigUpdate.f536a.equalsIgnoreCase(cif.f683d)) {
                                    if (hq.SyncInfoResult.f536a.equalsIgnoreCase(cif.f683d)) {
                                        av.a(this.f82a, cif);
                                        return null;
                                    } else if (hq.ForceSync.f536a.equalsIgnoreCase(cif.f683d)) {
                                        com.xiaomi.channel.commonutils.logger.b.m8344a("receive force sync notification");
                                        av.a(this.f82a, false);
                                        return null;
                                    } else if (hq.CancelPushMessage.f536a.equals(cif.f683d)) {
                                        com.xiaomi.channel.commonutils.logger.b.e("resp-type:" + cif.f683d + ", " + cif.m8913a());
                                        if (cif.m8914a() != null) {
                                            int i2 = -2;
                                            if (cif.m8914a().containsKey(bk.M)) {
                                                String str12 = cif.m8914a().get(bk.M);
                                                i2 = -2;
                                                if (!TextUtils.isEmpty(str12)) {
                                                    try {
                                                        i2 = Integer.parseInt(str12);
                                                    } catch (NumberFormatException e) {
                                                        e.printStackTrace();
                                                        i2 = -2;
                                                    }
                                                }
                                            }
                                            if (i2 >= -1) {
                                                MiPushClient.clearNotification(this.f82a, i2);
                                            } else {
                                                MiPushClient.clearNotification(this.f82a, cif.m8914a().containsKey(bk.K) ? cif.m8914a().get(bk.K) : "", cif.m8914a().containsKey(bk.L) ? cif.m8914a().get(bk.L) : "");
                                            }
                                        }
                                        a(cif);
                                        return null;
                                    } else {
                                        try {
                                            if (hq.HybridRegisterResult.f536a.equals(cif.f683d)) {
                                                ih ihVar2 = new ih();
                                                iq.a(ihVar2, cif.m8919a());
                                                MiPushClient4Hybrid.onReceiveRegisterResult(this.f82a, ihVar2);
                                            } else if (!hq.HybridUnregisterResult.f536a.equals(cif.f683d)) {
                                                if (hq.PushLogUpload.f536a.equals(cif.f683d)) {
                                                    return null;
                                                }
                                                if (hq.DetectAppAlive.f536a.equals(cif.f683d)) {
                                                    com.xiaomi.channel.commonutils.logger.b.b("receive detect msg");
                                                    b(cif);
                                                    return null;
                                                } else if (com.xiaomi.push.service.i.a(cif)) {
                                                    com.xiaomi.channel.commonutils.logger.b.b("receive notification handle by cpra");
                                                    return null;
                                                } else {
                                                    return null;
                                                }
                                            } else {
                                                in inVar = new in();
                                                iq.a(inVar, cif.m8919a());
                                                MiPushClient4Hybrid.onReceiveUnregisterResult(this.f82a, inVar);
                                            }
                                            return null;
                                        } catch (iw e2) {
                                            com.xiaomi.channel.commonutils.logger.b.a(e2);
                                            return null;
                                        }
                                    }
                                } else {
                                    id idVar = new id();
                                    iq.a(idVar, cif.m8919a());
                                    bb.a(ba.a(this.f82a), idVar);
                                }
                                return null;
                            } catch (iw e3) {
                                return null;
                            }
                        }
                    } else {
                        return null;
                    }
                default:
                    return null;
            }
        } catch (u e4) {
            com.xiaomi.channel.commonutils.logger.b.a(e4);
            a(icVar);
            a2 = em.a(this.f82a);
            packageName = this.f82a.getPackageName();
            m8665a = el.m8665a(i);
            str2 = "19";
            a2.b(packageName, m8665a, str, str2);
            s.c(this.f82a, icVar, z);
            return null;
        } catch (iw e5) {
            com.xiaomi.channel.commonutils.logger.b.a(e5);
            com.xiaomi.channel.commonutils.logger.b.d("receive a message which action string is not valid. is the reg expired?");
            a2 = em.a(this.f82a);
            packageName = this.f82a.getPackageName();
            m8665a = el.m8665a(i);
            str2 = BaseWrapper.ENTER_ID_SYSTEM_HELPER;
            a2.b(packageName, m8665a, str, str2);
            s.c(this.f82a, icVar, z);
            return null;
        }
    }

    private PushMessageHandler.a a(ic icVar, byte[] bArr) {
        String str;
        ir a2;
        hs a3;
        try {
            a2 = ai.a(this.f82a, icVar);
        } catch (u e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            str = "message arrived: receive a message but decrypt failed. report when click.";
        } catch (iw e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            str = "message arrived: receive a message which action string is not valid. is the reg expired?";
        }
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.d("message arrived: receiving an un-recognized message. " + icVar.f659a);
            return null;
        }
        hg a4 = icVar.a();
        com.xiaomi.channel.commonutils.logger.b.m8344a("message arrived: processing an arrived message, action=".concat(String.valueOf(a4)));
        if (an.f27515a[a4.ordinal()] != 1) {
            return null;
        }
        if (icVar.m8903b()) {
            ij ijVar = (ij) a2;
            if (ijVar.a() != null) {
                String str2 = null;
                if (icVar.f660a != null) {
                    str2 = null;
                    if (icVar.f660a.m8846a() != null) {
                        str2 = icVar.f660a.f571a.get("jobkey");
                    }
                }
                MiPushMessage generateMessage = PushMessageHelper.generateMessage(ijVar, icVar.m8895a(), false);
                generateMessage.setArrivedMessage(true);
                com.xiaomi.channel.commonutils.logger.b.m8344a("message arrived: receive a message, msgid=" + a3.m8836a() + ", jobkey=" + str2);
                return generateMessage;
            }
            str = "message arrived: receive an empty message without push content, drop it";
        } else {
            str = "message arrived: receiving an un-encrypt message(SendMessage).";
        }
        com.xiaomi.channel.commonutils.logger.b.d(str);
        return null;
    }

    public static am a(Context context) {
        if (f27514a == null) {
            f27514a = new am(context);
        }
        return f27514a;
    }

    private void a() {
        SharedPreferences sharedPreferences = this.f82a.getSharedPreferences("mipush_extra", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - sharedPreferences.getLong(Constants.SP_KEY_LAST_REINITIALIZE, 0L)) > 1800000) {
            MiPushClient.reInitialize(this.f82a, hu.PackageUnregistered);
            sharedPreferences.edit().putLong(Constants.SP_KEY_LAST_REINITIALIZE, currentTimeMillis).commit();
        }
    }

    public static void a(Context context, String str) {
        synchronized (f80a) {
            f81a.remove(str);
            b.m8407a(context);
            SharedPreferences a2 = b.a(context);
            String a3 = bn.a(f81a, ",");
            SharedPreferences.Editor edit = a2.edit();
            edit.putString("pref_msg_ids", a3);
            com.xiaomi.push.p.a(edit);
        }
    }

    private void a(hx hxVar) {
        String a2 = hxVar.a();
        com.xiaomi.channel.commonutils.logger.b.b("receive ack ".concat(String.valueOf(a2)));
        Map<String, String> m8864a = hxVar.m8864a();
        if (m8864a != null) {
            String str = m8864a.get("real_source");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.b("receive ack : messageId = " + a2 + "  realSource = " + str);
            bv.a(this.f82a).a(a2, str, Boolean.valueOf(hxVar.f614a == 0));
        }
    }

    private void a(ic icVar) {
        com.xiaomi.channel.commonutils.logger.b.m8344a("receive a message but decrypt failed. report now.");
        Cif cif = new Cif(icVar.m8895a().f569a, false);
        cif.c(hq.DecryptMessageFail.f536a);
        cif.b(icVar.m8896a());
        cif.d(icVar.f666b);
        cif.f678a = new HashMap();
        cif.f678a.put("regid", MiPushClient.getRegId(this.f82a));
        ao.a(this.f82a).a((ao) cif, hg.Notification, false, (ht) null);
    }

    private void a(Cif cif) {
        hx hxVar = new hx();
        hxVar.c(hq.CancelPushMessageACK.f536a);
        hxVar.a(cif.m8913a());
        hxVar.a(cif.a());
        hxVar.b(cif.b());
        hxVar.e(cif.c());
        hxVar.a(0L);
        hxVar.d("success clear push message.");
        ao.a(this.f82a).a(hxVar, hg.Notification, false, true, null, false, this.f82a.getPackageName(), b.m8407a(this.f82a).m8408a(), false);
    }

    private void a(ij ijVar, ic icVar) {
        ht m8895a = icVar.m8895a();
        ht htVar = m8895a;
        if (m8895a != null) {
            htVar = br.a(m8895a.m8844a());
        }
        hw hwVar = new hw();
        hwVar.b(ijVar.b());
        hwVar.a(ijVar.m8940a());
        hwVar.a(ijVar.a().a());
        if (!TextUtils.isEmpty(ijVar.c())) {
            hwVar.c(ijVar.c());
        }
        if (!TextUtils.isEmpty(ijVar.d())) {
            hwVar.d(ijVar.d());
        }
        hwVar.a(iq.a(this.f82a, icVar));
        ao.a(this.f82a).a((ao) hwVar, hg.AckMessage, htVar);
    }

    private void a(String str, long j, e eVar) {
        au a2 = l.a(eVar);
        if (a2 == null) {
            return;
        }
        if (j == 0) {
            synchronized (af.class) {
                try {
                    if (af.a(this.f82a).m8378a(str)) {
                        af.a(this.f82a).c(str);
                        if ("syncing".equals(af.a(this.f82a).a(a2))) {
                            af.a(this.f82a).a(a2, "synced");
                        }
                    }
                } finally {
                }
            }
        } else if (!"syncing".equals(af.a(this.f82a).a(a2))) {
            af.a(this.f82a).c(str);
        } else {
            synchronized (af.class) {
                try {
                    if (af.a(this.f82a).m8378a(str)) {
                        if (af.a(this.f82a).a(str) < 10) {
                            af.a(this.f82a).b(str);
                            ao.a(this.f82a).a(str, a2, eVar, "retry");
                        } else {
                            af.a(this.f82a).c(str);
                        }
                    }
                } finally {
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private static boolean m8382a(Context context, String str) {
        synchronized (f80a) {
            b.m8407a(context);
            SharedPreferences a2 = b.a(context);
            if (f81a == null) {
                String[] split = a2.getString("pref_msg_ids", "").split(",");
                f81a = new LinkedList();
                int length = split.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    f81a.add(split[i2]);
                    i = i2 + 1;
                }
            }
            if (f81a.contains(str)) {
                return true;
            }
            f81a.add(str);
            if (f81a.size() > 25) {
                f81a.poll();
            }
            String a3 = bn.a(f81a, ",");
            SharedPreferences.Editor edit = a2.edit();
            edit.putString("pref_msg_ids", a3);
            com.xiaomi.push.p.a(edit);
            return false;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m8383a(ic icVar) {
        Map<String, String> m8846a = icVar.m8895a() == null ? null : icVar.m8895a().m8846a();
        if (m8846a == null) {
            return false;
        }
        String str = m8846a.get(Constants.EXTRA_KEY_PUSH_SERVER_ACTION);
        return TextUtils.equals(str, Constants.EXTRA_VALUE_HYBRID_MESSAGE) || TextUtils.equals(str, Constants.EXTRA_VALUE_PLATFORM_MESSAGE);
    }

    private void b(hx hxVar) {
        long j;
        e eVar;
        com.xiaomi.channel.commonutils.logger.b.c("ASSEMBLE_PUSH : " + hxVar.toString());
        String a2 = hxVar.a();
        Map<String, String> m8864a = hxVar.m8864a();
        if (m8864a != null) {
            String str = m8864a.get(Constants.ASSEMBLE_PUSH_REG_INFO);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (str.contains("brand:" + ag.FCM.name())) {
                com.xiaomi.channel.commonutils.logger.b.m8344a("ASSEMBLE_PUSH : receive fcm token sync ack");
                i.b(this.f82a, e.ASSEMBLE_PUSH_FCM, str);
                j = hxVar.f614a;
                eVar = e.ASSEMBLE_PUSH_FCM;
            } else {
                if (!str.contains("brand:" + ag.HUAWEI.name())) {
                    if (!str.contains("channel:" + ag.HUAWEI.name())) {
                        if (!str.contains("brand:" + ag.OPPO.name())) {
                            if (!str.contains("channel:" + ag.OPPO.name())) {
                                if (!str.contains("brand:" + ag.VIVO.name())) {
                                    if (!str.contains("channel:" + ag.VIVO.name())) {
                                        return;
                                    }
                                }
                                com.xiaomi.channel.commonutils.logger.b.m8344a("ASSEMBLE_PUSH : receive FTOS token sync ack");
                                i.b(this.f82a, e.ASSEMBLE_PUSH_FTOS, str);
                                a(a2, hxVar.f614a, e.ASSEMBLE_PUSH_FTOS);
                                return;
                            }
                        }
                        com.xiaomi.channel.commonutils.logger.b.m8344a("ASSEMBLE_PUSH : receive COS token sync ack");
                        i.b(this.f82a, e.ASSEMBLE_PUSH_COS, str);
                        j = hxVar.f614a;
                        eVar = e.ASSEMBLE_PUSH_COS;
                    }
                }
                com.xiaomi.channel.commonutils.logger.b.m8344a("ASSEMBLE_PUSH : receive hw token sync ack");
                i.b(this.f82a, e.ASSEMBLE_PUSH_HUAWEI, str);
                j = hxVar.f614a;
                eVar = e.ASSEMBLE_PUSH_HUAWEI;
            }
            a(a2, j, eVar);
        }
    }

    private void b(ic icVar) {
        ht m8895a = icVar.m8895a();
        ht htVar = m8895a;
        if (m8895a != null) {
            htVar = br.a(m8895a.m8844a());
        }
        hw hwVar = new hw();
        hwVar.b(icVar.m8896a());
        hwVar.a(htVar.m8845a());
        hwVar.a(htVar.m8843a());
        if (!TextUtils.isEmpty(htVar.m8850b())) {
            hwVar.c(htVar.m8850b());
        }
        hwVar.a(iq.a(this.f82a, icVar));
        ao.a(this.f82a).a((ao) hwVar, hg.AckMessage, false, htVar);
    }

    private void b(Cif cif) {
        Map<String, String> m8914a = cif.m8914a();
        if (m8914a == null) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("detect failed because null");
            return;
        }
        String str = (String) ay.a(m8914a, "pkgList", (Object) null);
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("detect failed because empty");
            return;
        }
        Map<String, String> m8749a = com.xiaomi.push.g.m8749a(this.f82a, str);
        if (m8749a == null) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("detect failed because get status illegal");
            return;
        }
        String str2 = m8749a.get("alive");
        String str3 = m8749a.get("notAlive");
        if (TextUtils.isEmpty(str2)) {
            com.xiaomi.channel.commonutils.logger.b.b("detect failed because no alive process");
            return;
        }
        Cif cif2 = new Cif();
        cif2.a(cif.m8913a());
        cif2.b(cif.b());
        cif2.d(cif.c());
        cif2.c(hq.DetectAppAliveResult.f536a);
        cif2.f678a = new HashMap();
        cif2.f678a.put("alive", str2);
        if (Boolean.parseBoolean((String) ay.a(m8914a, "reportNotAliveApp", "false")) && !TextUtils.isEmpty(str3)) {
            cif2.f678a.put("notAlive", str3);
        }
        ao.a(this.f82a).a((ao) cif2, hg.Notification, false, (ht) null);
    }

    public PushMessageHandler.a a(Intent intent) {
        String str;
        em a2;
        String packageName;
        String str2;
        em a3;
        String packageName2;
        String format;
        String action = intent.getAction();
        com.xiaomi.channel.commonutils.logger.b.m8344a("receive an intent from server, action=".concat(String.valueOf(action)));
        String stringExtra = intent.getStringExtra("mrt");
        String str3 = stringExtra;
        if (stringExtra == null) {
            str3 = Long.toString(System.currentTimeMillis());
        }
        String stringExtra2 = intent.getStringExtra("messageId");
        int intExtra = intent.getIntExtra("eventMessageType", -1);
        if (!"com.xiaomi.mipush.RECEIVE_MESSAGE".equals(action)) {
            if ("com.xiaomi.mipush.ERROR".equals(action)) {
                MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
                ic icVar = new ic();
                try {
                    byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
                    if (byteArrayExtra != null) {
                        iq.a(icVar, byteArrayExtra);
                    }
                } catch (iw e) {
                }
                miPushCommandMessage.setCommand(String.valueOf(icVar.a()));
                miPushCommandMessage.setResultCode(intent.getIntExtra("mipush_error_code", 0));
                miPushCommandMessage.setReason(intent.getStringExtra("mipush_error_msg"));
                com.xiaomi.channel.commonutils.logger.b.d("receive a error message. code = " + intent.getIntExtra("mipush_error_code", 0) + ", msg= " + intent.getStringExtra("mipush_error_msg"));
                return miPushCommandMessage;
            } else if ("com.xiaomi.mipush.MESSAGE_ARRIVED".equals(action)) {
                byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
                if (byteArrayExtra2 == null) {
                    com.xiaomi.channel.commonutils.logger.b.d("message arrived: receiving an empty message, drop");
                    return null;
                }
                ic icVar2 = new ic();
                try {
                    iq.a(icVar2, byteArrayExtra2);
                    b m8407a = b.m8407a(this.f82a);
                    if (com.xiaomi.push.service.ak.m9063a(icVar2)) {
                        str = "message arrived: receive ignore reg message, ignore!";
                    } else if (!m8407a.m8416c()) {
                        str = "message arrived: receive message without registration. need unregister or re-register!";
                    } else if (!m8407a.m8416c() || !m8407a.m8419f()) {
                        return a(icVar2, byteArrayExtra2);
                    } else {
                        str = "message arrived: app info is invalidated";
                    }
                    com.xiaomi.channel.commonutils.logger.b.d(str);
                    return null;
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.d("fail to deal with arrived message. ".concat(String.valueOf(e2)));
                    return null;
                }
            } else {
                return null;
            }
        }
        byte[] byteArrayExtra3 = intent.getByteArrayExtra("mipush_payload");
        boolean booleanExtra = intent.getBooleanExtra("mipush_notified", false);
        if (byteArrayExtra3 == null) {
            com.xiaomi.channel.commonutils.logger.b.d("receiving an empty message, drop");
            em.a(this.f82a).a(this.f82a.getPackageName(), intent, "12");
            return null;
        }
        ic icVar3 = new ic();
        try {
            iq.a(icVar3, byteArrayExtra3);
            b m8407a2 = b.m8407a(this.f82a);
            ht m8895a = icVar3.m8895a();
            if (icVar3.a() == hg.SendMessage && m8895a != null && !m8407a2.m8418e() && !booleanExtra) {
                m8895a.a("mrt", str3);
                m8895a.a("mat", Long.toString(System.currentTimeMillis()));
                if (m8383a(icVar3)) {
                    com.xiaomi.channel.commonutils.logger.b.b("this is a mina's message, ack later");
                    m8895a.a(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS, String.valueOf(m8895a.m8843a()));
                    m8895a.a(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS, String.valueOf((int) iq.a(this.f82a, icVar3)));
                } else {
                    b(icVar3);
                }
            }
            if (icVar3.a() == hg.SendMessage && !icVar3.m8903b()) {
                if (com.xiaomi.push.service.ak.m9063a(icVar3)) {
                    com.xiaomi.channel.commonutils.logger.b.m8344a(String.format("drop an un-encrypted wake-up messages. %1$s, %2$s", icVar3.b(), m8895a != null ? m8895a.m8845a() : ""));
                    a3 = em.a(this.f82a);
                    packageName2 = this.f82a.getPackageName();
                    format = String.format("13: %1$s", icVar3.b());
                } else {
                    com.xiaomi.channel.commonutils.logger.b.m8344a(String.format("drop an un-encrypted messages. %1$s, %2$s", icVar3.b(), m8895a != null ? m8895a.m8845a() : ""));
                    a3 = em.a(this.f82a);
                    packageName2 = this.f82a.getPackageName();
                    format = String.format("14: %1$s", icVar3.b());
                }
                a3.a(packageName2, intent, format);
                s.a(this.f82a, icVar3, booleanExtra);
                return null;
            } else if (icVar3.a() == hg.SendMessage && icVar3.m8903b() && com.xiaomi.push.service.ak.m9063a(icVar3) && (!booleanExtra || m8895a == null || m8895a.m8846a() == null || !m8895a.m8846a().containsKey("notify_effect"))) {
                com.xiaomi.channel.commonutils.logger.b.m8344a(String.format("drop a wake-up messages which not has 'notify_effect' attr. %1$s, %2$s", icVar3.b(), m8895a != null ? m8895a.m8845a() : ""));
                em.a(this.f82a).a(this.f82a.getPackageName(), intent, String.format("25: %1$s", icVar3.b()));
                s.b(this.f82a, icVar3, booleanExtra);
                return null;
            } else if (!m8407a2.m8416c() && icVar3.f659a != hg.Registration) {
                if (com.xiaomi.push.service.ak.m9063a(icVar3)) {
                    return a(icVar3, booleanExtra, byteArrayExtra3, stringExtra2, intExtra, intent);
                }
                s.e(this.f82a, icVar3, booleanExtra);
                boolean m8417d = m8407a2.m8417d();
                com.xiaomi.channel.commonutils.logger.b.d("receive message without registration. need re-register!registered?".concat(String.valueOf(m8417d)));
                em.a(this.f82a).a(this.f82a.getPackageName(), intent, "15");
                if (m8417d) {
                    a();
                    return null;
                }
                return null;
            } else if (m8407a2.m8416c() && m8407a2.m8419f()) {
                if (icVar3.f659a != hg.UnRegistration) {
                    s.e(this.f82a, icVar3, booleanExtra);
                    MiPushClient.unregisterPush(this.f82a);
                    return null;
                } else if (!icVar3.m8903b()) {
                    com.xiaomi.channel.commonutils.logger.b.d("receiving an un-encrypt unregistration message");
                    return null;
                } else {
                    m8407a2.m8409a();
                    MiPushClient.clearExtras(this.f82a);
                    PushMessageHandler.a();
                    return null;
                }
            } else {
                return a(icVar3, booleanExtra, byteArrayExtra3, stringExtra2, intExtra, intent);
            }
        } catch (iw e3) {
            e = e3;
            a2 = em.a(this.f82a);
            packageName = this.f82a.getPackageName();
            str2 = "16";
            a2.a(packageName, intent, str2);
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return null;
        } catch (Exception e4) {
            e = e4;
            a2 = em.a(this.f82a);
            packageName = this.f82a.getPackageName();
            str2 = "17";
            a2.a(packageName, intent, str2);
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return null;
        }
    }

    public List<String> a(TimeZone timeZone, TimeZone timeZone2, List<String> list) {
        if (timeZone.equals(timeZone2)) {
            return list;
        }
        long rawOffset = ((timeZone.getRawOffset() - timeZone2.getRawOffset()) / 1000) / 60;
        long parseLong = Long.parseLong(list.get(0).split(":")[0]);
        long parseLong2 = ((((parseLong * 60) + Long.parseLong(list.get(0).split(":")[1])) - rawOffset) + 1440) % 1440;
        long parseLong3 = ((((Long.parseLong(list.get(1).split(":")[0]) * 60) + Long.parseLong(list.get(1).split(":")[1])) - rawOffset) + 1440) % 1440;
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(parseLong2 / 60), Long.valueOf(parseLong2 % 60)));
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(parseLong3 / 60), Long.valueOf(parseLong3 % 60)));
        return arrayList;
    }
}
