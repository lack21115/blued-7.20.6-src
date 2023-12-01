package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.huawei.hms.support.api.entity.auth.AuthCode;
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
    private static am f41205a;

    /* renamed from: a  reason: collision with other field name */
    private static Object f127a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private static Queue<String> f128a;

    /* renamed from: a  reason: collision with other field name */
    private Context f129a;

    private am(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f129a = applicationContext;
        if (applicationContext == null) {
            this.f129a = context;
        }
    }

    public static Intent a(Context context, String str, Map<String, String> map, int i) {
        return com.xiaomi.push.service.ak.b(context, str, map, i);
    }

    private PushMessageHandler.a a(ic icVar, boolean z, byte[] bArr, String str, int i, Intent intent) {
        em a2;
        String packageName;
        String m11715a;
        String str2;
        String str3;
        String str4;
        MiPushMessage miPushMessage;
        em a3;
        String packageName2;
        String m11715a2;
        String str5;
        try {
            ir a4 = ai.a(this.f129a, icVar);
            if (a4 == null) {
                com.xiaomi.channel.commonutils.logger.b.d("receiving an un-recognized message. " + icVar.f706a);
                em.a(this.f129a).b(this.f129a.getPackageName(), el.m11715a(i), str, "18");
                s.c(this.f129a, icVar, z);
                return null;
            }
            hg a5 = icVar.a();
            com.xiaomi.channel.commonutils.logger.b.m11394a("processing a message, action=".concat(String.valueOf(a5)));
            switch (an.f41206a[a5.ordinal()]) {
                case 1:
                    if (!icVar.m11953b()) {
                        com.xiaomi.channel.commonutils.logger.b.d("receiving an un-encrypt message(SendMessage).");
                        return null;
                    } else if (b.m11457a(this.f129a).m11468e() && !z) {
                        com.xiaomi.channel.commonutils.logger.b.m11394a("receive a message in pause state. drop it");
                        em.a(this.f129a).a(this.f129a.getPackageName(), el.m11715a(i), str, "12");
                        return null;
                    } else {
                        ij ijVar = (ij) a4;
                        hs a6 = ijVar.a();
                        if (a6 == null) {
                            com.xiaomi.channel.commonutils.logger.b.d("receive an empty message without push content, drop it");
                            em.a(this.f129a).b(this.f129a.getPackageName(), el.m11715a(i), str, "22");
                            s.d(this.f129a, icVar, z);
                            return null;
                        }
                        int intExtra = intent.getIntExtra("notification_click_button", 0);
                        if (z) {
                            if (com.xiaomi.push.service.ak.m12113a(icVar)) {
                                MiPushClient.reportIgnoreRegMessageClicked(this.f129a, a6.m11886a(), icVar.m11945a(), icVar.f713b, a6.b());
                            } else {
                                ht htVar = icVar.m11945a() != null ? new ht(icVar.m11945a()) : new ht();
                                if (htVar.m11896a() == null) {
                                    htVar.a(new HashMap());
                                }
                                htVar.m11896a().put("notification_click_button", String.valueOf(intExtra));
                                MiPushClient.reportMessageClicked(this.f129a, a6.m11886a(), htVar, a6.b());
                            }
                        }
                        if (!z) {
                            if (!TextUtils.isEmpty(ijVar.d()) && MiPushClient.aliasSetTime(this.f129a, ijVar.d()) < 0) {
                                MiPushClient.addAlias(this.f129a, ijVar.d());
                            } else if (!TextUtils.isEmpty(ijVar.c()) && MiPushClient.topicSubscribedTime(this.f129a, ijVar.c()) < 0) {
                                MiPushClient.addTopic(this.f129a, ijVar.c());
                            }
                        }
                        if (icVar.f707a == null || icVar.f707a.m11896a() == null) {
                            str3 = null;
                            str4 = null;
                        } else {
                            str3 = icVar.f707a.f618a.get("jobkey");
                            str4 = str3;
                        }
                        String str6 = str3;
                        if (TextUtils.isEmpty(str3)) {
                            str6 = a6.m11886a();
                        }
                        if (z || !m11432a(this.f129a, str6)) {
                            MiPushMessage generateMessage = PushMessageHelper.generateMessage(ijVar, icVar.m11945a(), z);
                            if (generateMessage.getPassThrough() == 0 && !z && com.xiaomi.push.service.ak.m12114a(generateMessage.getExtra())) {
                                com.xiaomi.push.service.ak.m12109a(this.f129a, icVar, bArr);
                                return null;
                            }
                            com.xiaomi.channel.commonutils.logger.b.m11394a("receive a message, msgid=" + a6.m11886a() + ", jobkey=" + str6 + ", btn=" + intExtra);
                            String a7 = com.xiaomi.push.service.ak.a(generateMessage.getExtra(), intExtra);
                            if (z && generateMessage.getExtra() != null && !TextUtils.isEmpty(a7)) {
                                Map<String, String> extra = generateMessage.getExtra();
                                if (intExtra != 0 && icVar.m11945a() != null) {
                                    ao.a(this.f129a).a(icVar.m11945a().c(), intExtra);
                                }
                                if (com.xiaomi.push.service.ak.m12113a(icVar)) {
                                    Intent a8 = a(this.f129a, icVar.f713b, extra, intExtra);
                                    a8.putExtra("eventMessageType", i);
                                    a8.putExtra("messageId", str);
                                    a8.putExtra("jobkey", str4);
                                    if (a8 == null) {
                                        com.xiaomi.channel.commonutils.logger.b.m11394a("Getting Intent fail from ignore reg message. ");
                                        em.a(this.f129a).b(this.f129a.getPackageName(), el.m11715a(i), str, "23");
                                        return null;
                                    }
                                    String c2 = a6.c();
                                    if (!TextUtils.isEmpty(c2)) {
                                        a8.putExtra("payload", c2);
                                    }
                                    this.f129a.startActivity(a8);
                                    s.a(this.f129a, icVar);
                                    em.a(this.f129a).a(this.f129a.getPackageName(), el.m11715a(i), str, 3006, a7);
                                    return null;
                                }
                                Context context = this.f129a;
                                Intent a9 = a(context, context.getPackageName(), extra, intExtra);
                                if (a9 != null) {
                                    if (!a7.equals(bk.f41642c)) {
                                        a9.putExtra(PushMessageHelper.KEY_MESSAGE, generateMessage);
                                        a9.putExtra("eventMessageType", i);
                                        a9.putExtra("messageId", str);
                                        a9.putExtra("jobkey", str4);
                                    }
                                    this.f129a.startActivity(a9);
                                    s.a(this.f129a, icVar);
                                    com.xiaomi.channel.commonutils.logger.b.m11394a("start activity succ");
                                    em.a(this.f129a).a(this.f129a.getPackageName(), el.m11715a(i), str, 1006, a7);
                                    if (a7.equals(bk.f41642c)) {
                                        em.a(this.f129a).a(this.f129a.getPackageName(), el.m11715a(i), str, "13");
                                        return null;
                                    }
                                    return null;
                                }
                                return null;
                            }
                            miPushMessage = generateMessage;
                        } else {
                            com.xiaomi.channel.commonutils.logger.b.m11394a("drop a duplicate message, key=".concat(String.valueOf(str6)));
                            em.a(this.f129a).c(this.f129a.getPackageName(), el.m11715a(i), str, "2:".concat(String.valueOf(str6)));
                            miPushMessage = null;
                        }
                        if (icVar.m11945a() == null && !z) {
                            a(ijVar, icVar);
                        }
                        return miPushMessage;
                    }
                case 2:
                    ih ihVar = (ih) a4;
                    String str7 = b.m11457a(this.f129a).f147a;
                    if (TextUtils.isEmpty(str7) || !TextUtils.equals(str7, ihVar.m11979a())) {
                        com.xiaomi.channel.commonutils.logger.b.m11394a("bad Registration result:");
                        em.a(this.f129a).b(this.f129a.getPackageName(), el.m11715a(i), str, "21");
                        return null;
                    }
                    long m11444a = ao.a(this.f129a).m11444a();
                    if (m11444a > 0 && SystemClock.elapsedRealtime() - m11444a > 900000) {
                        com.xiaomi.channel.commonutils.logger.b.m11394a("The received registration result has expired.");
                        em.a(this.f129a).b(this.f129a.getPackageName(), el.m11715a(i), str, "26");
                        return null;
                    }
                    b.m11457a(this.f129a).f147a = null;
                    long j = ihVar.f769a;
                    Context context2 = this.f129a;
                    if (j == 0) {
                        b.m11457a(context2).b(ihVar.f781e, ihVar.f782f, ihVar.f788l);
                        FCMPushHelper.persistIfXmsfSupDecrypt(this.f129a);
                        a3 = em.a(this.f129a);
                        packageName2 = this.f129a.getPackageName();
                        m11715a2 = el.m11715a(i);
                        str5 = "1";
                    } else {
                        a3 = em.a(context2);
                        packageName2 = this.f129a.getPackageName();
                        m11715a2 = el.m11715a(i);
                        str5 = "2";
                    }
                    a3.a(packageName2, m11715a2, str, AuthCode.StatusCode.PERMISSION_EXPIRED, str5);
                    ArrayList arrayList = null;
                    if (!TextUtils.isEmpty(ihVar.f781e)) {
                        arrayList = new ArrayList();
                        arrayList.add(ihVar.f781e);
                    }
                    MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ew.COMMAND_REGISTER.f411a, arrayList, ihVar.f769a, ihVar.f780d, null, ihVar.m11980a());
                    ao.a(this.f129a).m11453d();
                    return generateCommandMessage;
                case 3:
                    if (!icVar.m11953b()) {
                        com.xiaomi.channel.commonutils.logger.b.d("receiving an un-encrypt message(UnRegistration).");
                        return null;
                    }
                    if (((in) a4).f847a == 0) {
                        b.m11457a(this.f129a).m11459a();
                        MiPushClient.clearExtras(this.f129a);
                    }
                    PushMessageHandler.a();
                    return null;
                case 4:
                    il ilVar = (il) a4;
                    if (ilVar.f822a == 0) {
                        MiPushClient.addTopic(this.f129a, ilVar.b());
                    }
                    ArrayList arrayList2 = null;
                    if (!TextUtils.isEmpty(ilVar.b())) {
                        arrayList2 = new ArrayList();
                        arrayList2.add(ilVar.b());
                    }
                    com.xiaomi.channel.commonutils.logger.b.e("resp-cmd:" + ew.COMMAND_SUBSCRIBE_TOPIC + ", " + ilVar.a());
                    return PushMessageHelper.generateCommandMessage(ew.COMMAND_SUBSCRIBE_TOPIC.f411a, arrayList2, ilVar.f822a, ilVar.f828d, ilVar.c(), null);
                case 5:
                    ip ipVar = (ip) a4;
                    if (ipVar.f867a == 0) {
                        MiPushClient.removeTopic(this.f129a, ipVar.b());
                    }
                    ArrayList arrayList3 = null;
                    if (!TextUtils.isEmpty(ipVar.b())) {
                        arrayList3 = new ArrayList();
                        arrayList3.add(ipVar.b());
                    }
                    com.xiaomi.channel.commonutils.logger.b.e("resp-cmd:" + ew.COMMAND_UNSUBSCRIBE_TOPIC + ", " + ipVar.a());
                    return PushMessageHelper.generateCommandMessage(ew.COMMAND_UNSUBSCRIBE_TOPIC.f411a, arrayList3, ipVar.f867a, ipVar.f873d, ipVar.c(), null);
                case 6:
                    cz.a(this.f129a.getPackageName(), this.f129a, a4, hg.Command, bArr.length);
                    ib ibVar = (ib) a4;
                    String b = ibVar.b();
                    List<String> m11938a = ibVar.m11938a();
                    List<String> list = m11938a;
                    if (ibVar.f694a == 0) {
                        if (TextUtils.equals(b, ew.COMMAND_SET_ACCEPT_TIME.f411a) && m11938a != null && m11938a.size() > 1) {
                            MiPushClient.addAcceptTime(this.f129a, m11938a.get(0), m11938a.get(1));
                            if ("00:00".equals(m11938a.get(0)) && "00:00".equals(m11938a.get(1))) {
                                b.m11457a(this.f129a).a(true);
                            } else {
                                b.m11457a(this.f129a).a(false);
                            }
                            list = a(TimeZone.getTimeZone("GMT+08"), TimeZone.getDefault(), m11938a);
                        } else if (TextUtils.equals(b, ew.COMMAND_SET_ALIAS.f411a) && m11938a != null && m11938a.size() > 0) {
                            MiPushClient.addAlias(this.f129a, m11938a.get(0));
                            list = m11938a;
                        } else if (TextUtils.equals(b, ew.COMMAND_UNSET_ALIAS.f411a) && m11938a != null && m11938a.size() > 0) {
                            MiPushClient.removeAlias(this.f129a, m11938a.get(0));
                            list = m11938a;
                        } else if (TextUtils.equals(b, ew.COMMAND_SET_ACCOUNT.f411a) && m11938a != null && m11938a.size() > 0) {
                            MiPushClient.addAccount(this.f129a, m11938a.get(0));
                            list = m11938a;
                        } else if (!TextUtils.equals(b, ew.COMMAND_UNSET_ACCOUNT.f411a) || m11938a == null || m11938a.size() <= 0) {
                            list = m11938a;
                            if (TextUtils.equals(b, ew.COMMAND_CHK_VDEVID.f411a)) {
                                return null;
                            }
                        } else {
                            MiPushClient.removeAccount(this.f129a, m11938a.get(0));
                            list = m11938a;
                        }
                    }
                    com.xiaomi.channel.commonutils.logger.b.e("resp-cmd:" + b + ", " + ibVar.a());
                    return PushMessageHelper.generateCommandMessage(b, list, ibVar.f694a, ibVar.f702d, ibVar.c(), null);
                case 7:
                    cz.a(this.f129a.getPackageName(), this.f129a, a4, hg.Notification, bArr.length);
                    if (a4 instanceof hx) {
                        hx hxVar = (hx) a4;
                        String a10 = hxVar.a();
                        com.xiaomi.channel.commonutils.logger.b.e("resp-type:" + hxVar.b() + ", code:" + hxVar.f661a + ", " + a10);
                        if (hq.DisablePushMessage.f583a.equalsIgnoreCase(hxVar.f668d)) {
                            if (hxVar.f661a == 0) {
                                synchronized (af.class) {
                                    try {
                                        if (af.a(this.f129a).m11428a(a10)) {
                                            af.a(this.f129a).c(a10);
                                            if ("syncing".equals(af.a(this.f129a).a(au.DISABLE_PUSH))) {
                                                af.a(this.f129a).a(au.DISABLE_PUSH, "synced");
                                                MiPushClient.clearNotification(this.f129a);
                                                MiPushClient.clearLocalNotificationType(this.f129a);
                                                PushMessageHandler.a();
                                                ao.a(this.f129a).m11450b();
                                            }
                                        }
                                    } finally {
                                    }
                                }
                                return null;
                            } else if ("syncing".equals(af.a(this.f129a).a(au.DISABLE_PUSH))) {
                                synchronized (af.class) {
                                    try {
                                        if (af.a(this.f129a).m11428a(a10)) {
                                            if (af.a(this.f129a).a(a10) < 10) {
                                                af.a(this.f129a).b(a10);
                                                ao.a(this.f129a).a(true, a10);
                                            } else {
                                                af.a(this.f129a).c(a10);
                                            }
                                        }
                                    } finally {
                                    }
                                }
                                return null;
                            }
                        } else if (!hq.EnablePushMessage.f583a.equalsIgnoreCase(hxVar.f668d)) {
                            if (hq.ThirdPartyRegUpdate.f583a.equalsIgnoreCase(hxVar.f668d)) {
                                b(hxVar);
                                return null;
                            } else if (hq.UploadTinyData.f583a.equalsIgnoreCase(hxVar.f668d)) {
                                a(hxVar);
                                return null;
                            } else {
                                return null;
                            }
                        } else if (hxVar.f661a == 0) {
                            synchronized (af.class) {
                                try {
                                    if (af.a(this.f129a).m11428a(a10)) {
                                        af.a(this.f129a).c(a10);
                                        if ("syncing".equals(af.a(this.f129a).a(au.ENABLE_PUSH))) {
                                            af.a(this.f129a).a(au.ENABLE_PUSH, "synced");
                                        }
                                    }
                                } finally {
                                }
                            }
                            return null;
                        } else if ("syncing".equals(af.a(this.f129a).a(au.ENABLE_PUSH))) {
                            synchronized (af.class) {
                                try {
                                    if (af.a(this.f129a).m11428a(a10)) {
                                        if (af.a(this.f129a).a(a10) < 10) {
                                            af.a(this.f129a).b(a10);
                                            ao.a(this.f129a).a(false, a10);
                                        } else {
                                            af.a(this.f129a).c(a10);
                                        }
                                    }
                                } finally {
                                }
                            }
                            return null;
                        }
                        af.a(this.f129a).c(a10);
                        return null;
                    } else if (a4 instanceof Cif) {
                        Cif cif = (Cif) a4;
                        if ("registration id expired".equalsIgnoreCase(cif.f730d)) {
                            List<String> allAlias = MiPushClient.getAllAlias(this.f129a);
                            List<String> allTopic = MiPushClient.getAllTopic(this.f129a);
                            List<String> allUserAccount = MiPushClient.getAllUserAccount(this.f129a);
                            String acceptTime = MiPushClient.getAcceptTime(this.f129a);
                            com.xiaomi.channel.commonutils.logger.b.e("resp-type:" + cif.f730d + ", " + cif.m11963a());
                            MiPushClient.reInitialize(this.f129a, hu.RegIdExpired);
                            for (String str8 : allAlias) {
                                MiPushClient.removeAlias(this.f129a, str8);
                                MiPushClient.setAlias(this.f129a, str8, null);
                            }
                            for (String str9 : allTopic) {
                                MiPushClient.removeTopic(this.f129a, str9);
                                MiPushClient.subscribe(this.f129a, str9, null);
                            }
                            for (String str10 : allUserAccount) {
                                MiPushClient.removeAccount(this.f129a, str10);
                                MiPushClient.setUserAccount(this.f129a, str10, null);
                            }
                            String[] split = acceptTime.split(",");
                            if (split.length == 2) {
                                MiPushClient.removeAcceptTime(this.f129a);
                                MiPushClient.addAcceptTime(this.f129a, split[0], split[1]);
                                return null;
                            }
                            return null;
                        } else if (hq.ClientInfoUpdateOk.f583a.equalsIgnoreCase(cif.f730d)) {
                            if (cif.m11964a() == null || !cif.m11964a().containsKey("app_version")) {
                                return null;
                            }
                            b.m11457a(this.f129a).m11460a(cif.m11964a().get("app_version"));
                            return null;
                        } else if (hq.AwakeApp.f583a.equalsIgnoreCase(cif.f730d)) {
                            if (icVar.m11953b() && cif.m11964a() != null && cif.m11964a().containsKey("awake_info")) {
                                String str11 = cif.m11964a().get("awake_info");
                                Context context3 = this.f129a;
                                o.a(context3, b.m11457a(context3).m11458a(), ba.a(this.f129a).a(hl.AwakeInfoUploadWaySwitch.a(), 0), str11);
                                return null;
                            }
                            return null;
                        } else {
                            try {
                                if (hq.NormalClientConfigUpdate.f583a.equalsIgnoreCase(cif.f730d)) {
                                    ie ieVar = new ie();
                                    iq.a(ieVar, cif.m11969a());
                                    bb.a(ba.a(this.f129a), ieVar);
                                } else if (!hq.CustomClientConfigUpdate.f583a.equalsIgnoreCase(cif.f730d)) {
                                    if (hq.SyncInfoResult.f583a.equalsIgnoreCase(cif.f730d)) {
                                        av.a(this.f129a, cif);
                                        return null;
                                    } else if (hq.ForceSync.f583a.equalsIgnoreCase(cif.f730d)) {
                                        com.xiaomi.channel.commonutils.logger.b.m11394a("receive force sync notification");
                                        av.a(this.f129a, false);
                                        return null;
                                    } else if (hq.CancelPushMessage.f583a.equals(cif.f730d)) {
                                        com.xiaomi.channel.commonutils.logger.b.e("resp-type:" + cif.f730d + ", " + cif.m11963a());
                                        if (cif.m11964a() != null) {
                                            int i2 = -2;
                                            if (cif.m11964a().containsKey(bk.M)) {
                                                String str12 = cif.m11964a().get(bk.M);
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
                                                MiPushClient.clearNotification(this.f129a, i2);
                                            } else {
                                                MiPushClient.clearNotification(this.f129a, cif.m11964a().containsKey(bk.K) ? cif.m11964a().get(bk.K) : "", cif.m11964a().containsKey(bk.L) ? cif.m11964a().get(bk.L) : "");
                                            }
                                        }
                                        a(cif);
                                        return null;
                                    } else {
                                        try {
                                            if (hq.HybridRegisterResult.f583a.equals(cif.f730d)) {
                                                ih ihVar2 = new ih();
                                                iq.a(ihVar2, cif.m11969a());
                                                MiPushClient4Hybrid.onReceiveRegisterResult(this.f129a, ihVar2);
                                            } else if (!hq.HybridUnregisterResult.f583a.equals(cif.f730d)) {
                                                if (hq.PushLogUpload.f583a.equals(cif.f730d)) {
                                                    return null;
                                                }
                                                if (hq.DetectAppAlive.f583a.equals(cif.f730d)) {
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
                                                iq.a(inVar, cif.m11969a());
                                                MiPushClient4Hybrid.onReceiveUnregisterResult(this.f129a, inVar);
                                            }
                                            return null;
                                        } catch (iw e2) {
                                            com.xiaomi.channel.commonutils.logger.b.a(e2);
                                            return null;
                                        }
                                    }
                                } else {
                                    id idVar = new id();
                                    iq.a(idVar, cif.m11969a());
                                    bb.a(ba.a(this.f129a), idVar);
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
            a2 = em.a(this.f129a);
            packageName = this.f129a.getPackageName();
            m11715a = el.m11715a(i);
            str2 = "19";
            a2.b(packageName, m11715a, str, str2);
            s.c(this.f129a, icVar, z);
            return null;
        } catch (iw e5) {
            com.xiaomi.channel.commonutils.logger.b.a(e5);
            com.xiaomi.channel.commonutils.logger.b.d("receive a message which action string is not valid. is the reg expired?");
            a2 = em.a(this.f129a);
            packageName = this.f129a.getPackageName();
            m11715a = el.m11715a(i);
            str2 = BaseWrapper.ENTER_ID_SYSTEM_HELPER;
            a2.b(packageName, m11715a, str, str2);
            s.c(this.f129a, icVar, z);
            return null;
        }
    }

    private PushMessageHandler.a a(ic icVar, byte[] bArr) {
        String str;
        ir a2;
        hs a3;
        try {
            a2 = ai.a(this.f129a, icVar);
        } catch (u e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            str = "message arrived: receive a message but decrypt failed. report when click.";
        } catch (iw e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            str = "message arrived: receive a message which action string is not valid. is the reg expired?";
        }
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.d("message arrived: receiving an un-recognized message. " + icVar.f706a);
            return null;
        }
        hg a4 = icVar.a();
        com.xiaomi.channel.commonutils.logger.b.m11394a("message arrived: processing an arrived message, action=".concat(String.valueOf(a4)));
        if (an.f41206a[a4.ordinal()] != 1) {
            return null;
        }
        if (icVar.m11953b()) {
            ij ijVar = (ij) a2;
            if (ijVar.a() != null) {
                String str2 = null;
                if (icVar.f707a != null) {
                    str2 = null;
                    if (icVar.f707a.m11896a() != null) {
                        str2 = icVar.f707a.f618a.get("jobkey");
                    }
                }
                MiPushMessage generateMessage = PushMessageHelper.generateMessage(ijVar, icVar.m11945a(), false);
                generateMessage.setArrivedMessage(true);
                com.xiaomi.channel.commonutils.logger.b.m11394a("message arrived: receive a message, msgid=" + a3.m11886a() + ", jobkey=" + str2);
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
        if (f41205a == null) {
            f41205a = new am(context);
        }
        return f41205a;
    }

    private void a() {
        SharedPreferences sharedPreferences = this.f129a.getSharedPreferences("mipush_extra", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - sharedPreferences.getLong(Constants.SP_KEY_LAST_REINITIALIZE, 0L)) > 1800000) {
            MiPushClient.reInitialize(this.f129a, hu.PackageUnregistered);
            sharedPreferences.edit().putLong(Constants.SP_KEY_LAST_REINITIALIZE, currentTimeMillis).commit();
        }
    }

    public static void a(Context context, String str) {
        synchronized (f127a) {
            f128a.remove(str);
            b.m11457a(context);
            SharedPreferences a2 = b.a(context);
            String a3 = bn.a(f128a, ",");
            SharedPreferences.Editor edit = a2.edit();
            edit.putString("pref_msg_ids", a3);
            com.xiaomi.push.p.a(edit);
        }
    }

    private void a(hx hxVar) {
        String a2 = hxVar.a();
        com.xiaomi.channel.commonutils.logger.b.b("receive ack ".concat(String.valueOf(a2)));
        Map<String, String> m11914a = hxVar.m11914a();
        if (m11914a != null) {
            String str = m11914a.get("real_source");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.b("receive ack : messageId = " + a2 + "  realSource = " + str);
            bv.a(this.f129a).a(a2, str, Boolean.valueOf(hxVar.f661a == 0));
        }
    }

    private void a(ic icVar) {
        com.xiaomi.channel.commonutils.logger.b.m11394a("receive a message but decrypt failed. report now.");
        Cif cif = new Cif(icVar.m11945a().f616a, false);
        cif.c(hq.DecryptMessageFail.f583a);
        cif.b(icVar.m11946a());
        cif.d(icVar.f713b);
        cif.f725a = new HashMap();
        cif.f725a.put("regid", MiPushClient.getRegId(this.f129a));
        ao.a(this.f129a).a((ao) cif, hg.Notification, false, (ht) null);
    }

    private void a(Cif cif) {
        hx hxVar = new hx();
        hxVar.c(hq.CancelPushMessageACK.f583a);
        hxVar.a(cif.m11963a());
        hxVar.a(cif.a());
        hxVar.b(cif.b());
        hxVar.e(cif.c());
        hxVar.a(0L);
        hxVar.d("success clear push message.");
        ao.a(this.f129a).a(hxVar, hg.Notification, false, true, null, false, this.f129a.getPackageName(), b.m11457a(this.f129a).m11458a(), false);
    }

    private void a(ij ijVar, ic icVar) {
        ht m11945a = icVar.m11945a();
        ht htVar = m11945a;
        if (m11945a != null) {
            htVar = br.a(m11945a.m11894a());
        }
        hw hwVar = new hw();
        hwVar.b(ijVar.b());
        hwVar.a(ijVar.m11990a());
        hwVar.a(ijVar.a().a());
        if (!TextUtils.isEmpty(ijVar.c())) {
            hwVar.c(ijVar.c());
        }
        if (!TextUtils.isEmpty(ijVar.d())) {
            hwVar.d(ijVar.d());
        }
        hwVar.a(iq.a(this.f129a, icVar));
        ao.a(this.f129a).a((ao) hwVar, hg.AckMessage, htVar);
    }

    private void a(String str, long j, e eVar) {
        au a2 = l.a(eVar);
        if (a2 == null) {
            return;
        }
        if (j == 0) {
            synchronized (af.class) {
                try {
                    if (af.a(this.f129a).m11428a(str)) {
                        af.a(this.f129a).c(str);
                        if ("syncing".equals(af.a(this.f129a).a(a2))) {
                            af.a(this.f129a).a(a2, "synced");
                        }
                    }
                } finally {
                }
            }
        } else if (!"syncing".equals(af.a(this.f129a).a(a2))) {
            af.a(this.f129a).c(str);
        } else {
            synchronized (af.class) {
                try {
                    if (af.a(this.f129a).m11428a(str)) {
                        if (af.a(this.f129a).a(str) < 10) {
                            af.a(this.f129a).b(str);
                            ao.a(this.f129a).a(str, a2, eVar, "retry");
                        } else {
                            af.a(this.f129a).c(str);
                        }
                    }
                } finally {
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private static boolean m11432a(Context context, String str) {
        synchronized (f127a) {
            b.m11457a(context);
            SharedPreferences a2 = b.a(context);
            if (f128a == null) {
                String[] split = a2.getString("pref_msg_ids", "").split(",");
                f128a = new LinkedList();
                int length = split.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    f128a.add(split[i2]);
                    i = i2 + 1;
                }
            }
            if (f128a.contains(str)) {
                return true;
            }
            f128a.add(str);
            if (f128a.size() > 25) {
                f128a.poll();
            }
            String a3 = bn.a(f128a, ",");
            SharedPreferences.Editor edit = a2.edit();
            edit.putString("pref_msg_ids", a3);
            com.xiaomi.push.p.a(edit);
            return false;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m11433a(ic icVar) {
        Map<String, String> m11896a = icVar.m11945a() == null ? null : icVar.m11945a().m11896a();
        if (m11896a == null) {
            return false;
        }
        String str = m11896a.get(Constants.EXTRA_KEY_PUSH_SERVER_ACTION);
        return TextUtils.equals(str, Constants.EXTRA_VALUE_HYBRID_MESSAGE) || TextUtils.equals(str, Constants.EXTRA_VALUE_PLATFORM_MESSAGE);
    }

    private void b(hx hxVar) {
        long j;
        e eVar;
        com.xiaomi.channel.commonutils.logger.b.c("ASSEMBLE_PUSH : " + hxVar.toString());
        String a2 = hxVar.a();
        Map<String, String> m11914a = hxVar.m11914a();
        if (m11914a != null) {
            String str = m11914a.get(Constants.ASSEMBLE_PUSH_REG_INFO);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (str.contains("brand:" + ag.FCM.name())) {
                com.xiaomi.channel.commonutils.logger.b.m11394a("ASSEMBLE_PUSH : receive fcm token sync ack");
                i.b(this.f129a, e.ASSEMBLE_PUSH_FCM, str);
                j = hxVar.f661a;
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
                                com.xiaomi.channel.commonutils.logger.b.m11394a("ASSEMBLE_PUSH : receive FTOS token sync ack");
                                i.b(this.f129a, e.ASSEMBLE_PUSH_FTOS, str);
                                a(a2, hxVar.f661a, e.ASSEMBLE_PUSH_FTOS);
                                return;
                            }
                        }
                        com.xiaomi.channel.commonutils.logger.b.m11394a("ASSEMBLE_PUSH : receive COS token sync ack");
                        i.b(this.f129a, e.ASSEMBLE_PUSH_COS, str);
                        j = hxVar.f661a;
                        eVar = e.ASSEMBLE_PUSH_COS;
                    }
                }
                com.xiaomi.channel.commonutils.logger.b.m11394a("ASSEMBLE_PUSH : receive hw token sync ack");
                i.b(this.f129a, e.ASSEMBLE_PUSH_HUAWEI, str);
                j = hxVar.f661a;
                eVar = e.ASSEMBLE_PUSH_HUAWEI;
            }
            a(a2, j, eVar);
        }
    }

    private void b(ic icVar) {
        ht m11945a = icVar.m11945a();
        ht htVar = m11945a;
        if (m11945a != null) {
            htVar = br.a(m11945a.m11894a());
        }
        hw hwVar = new hw();
        hwVar.b(icVar.m11946a());
        hwVar.a(htVar.m11895a());
        hwVar.a(htVar.m11893a());
        if (!TextUtils.isEmpty(htVar.m11900b())) {
            hwVar.c(htVar.m11900b());
        }
        hwVar.a(iq.a(this.f129a, icVar));
        ao.a(this.f129a).a((ao) hwVar, hg.AckMessage, false, htVar);
    }

    private void b(Cif cif) {
        Map<String, String> m11964a = cif.m11964a();
        if (m11964a == null) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("detect failed because null");
            return;
        }
        String str = (String) ay.a(m11964a, "pkgList", (Object) null);
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("detect failed because empty");
            return;
        }
        Map<String, String> m11799a = com.xiaomi.push.g.m11799a(this.f129a, str);
        if (m11799a == null) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("detect failed because get status illegal");
            return;
        }
        String str2 = m11799a.get("alive");
        String str3 = m11799a.get("notAlive");
        if (TextUtils.isEmpty(str2)) {
            com.xiaomi.channel.commonutils.logger.b.b("detect failed because no alive process");
            return;
        }
        Cif cif2 = new Cif();
        cif2.a(cif.m11963a());
        cif2.b(cif.b());
        cif2.d(cif.c());
        cif2.c(hq.DetectAppAliveResult.f583a);
        cif2.f725a = new HashMap();
        cif2.f725a.put("alive", str2);
        if (Boolean.parseBoolean((String) ay.a(m11964a, "reportNotAliveApp", "false")) && !TextUtils.isEmpty(str3)) {
            cif2.f725a.put("notAlive", str3);
        }
        ao.a(this.f129a).a((ao) cif2, hg.Notification, false, (ht) null);
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
        com.xiaomi.channel.commonutils.logger.b.m11394a("receive an intent from server, action=".concat(String.valueOf(action)));
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
                    b m11457a = b.m11457a(this.f129a);
                    if (com.xiaomi.push.service.ak.m12113a(icVar2)) {
                        str = "message arrived: receive ignore reg message, ignore!";
                    } else if (!m11457a.m11466c()) {
                        str = "message arrived: receive message without registration. need unregister or re-register!";
                    } else if (!m11457a.m11466c() || !m11457a.m11469f()) {
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
            em.a(this.f129a).a(this.f129a.getPackageName(), intent, "12");
            return null;
        }
        ic icVar3 = new ic();
        try {
            iq.a(icVar3, byteArrayExtra3);
            b m11457a2 = b.m11457a(this.f129a);
            ht m11945a = icVar3.m11945a();
            if (icVar3.a() == hg.SendMessage && m11945a != null && !m11457a2.m11468e() && !booleanExtra) {
                m11945a.a("mrt", str3);
                m11945a.a("mat", Long.toString(System.currentTimeMillis()));
                if (m11433a(icVar3)) {
                    com.xiaomi.channel.commonutils.logger.b.b("this is a mina's message, ack later");
                    m11945a.a(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS, String.valueOf(m11945a.m11893a()));
                    m11945a.a(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS, String.valueOf((int) iq.a(this.f129a, icVar3)));
                } else {
                    b(icVar3);
                }
            }
            if (icVar3.a() == hg.SendMessage && !icVar3.m11953b()) {
                if (com.xiaomi.push.service.ak.m12113a(icVar3)) {
                    com.xiaomi.channel.commonutils.logger.b.m11394a(String.format("drop an un-encrypted wake-up messages. %1$s, %2$s", icVar3.b(), m11945a != null ? m11945a.m11895a() : ""));
                    a3 = em.a(this.f129a);
                    packageName2 = this.f129a.getPackageName();
                    format = String.format("13: %1$s", icVar3.b());
                } else {
                    com.xiaomi.channel.commonutils.logger.b.m11394a(String.format("drop an un-encrypted messages. %1$s, %2$s", icVar3.b(), m11945a != null ? m11945a.m11895a() : ""));
                    a3 = em.a(this.f129a);
                    packageName2 = this.f129a.getPackageName();
                    format = String.format("14: %1$s", icVar3.b());
                }
                a3.a(packageName2, intent, format);
                s.a(this.f129a, icVar3, booleanExtra);
                return null;
            } else if (icVar3.a() == hg.SendMessage && icVar3.m11953b() && com.xiaomi.push.service.ak.m12113a(icVar3) && (!booleanExtra || m11945a == null || m11945a.m11896a() == null || !m11945a.m11896a().containsKey("notify_effect"))) {
                com.xiaomi.channel.commonutils.logger.b.m11394a(String.format("drop a wake-up messages which not has 'notify_effect' attr. %1$s, %2$s", icVar3.b(), m11945a != null ? m11945a.m11895a() : ""));
                em.a(this.f129a).a(this.f129a.getPackageName(), intent, String.format("25: %1$s", icVar3.b()));
                s.b(this.f129a, icVar3, booleanExtra);
                return null;
            } else if (!m11457a2.m11466c() && icVar3.f706a != hg.Registration) {
                if (com.xiaomi.push.service.ak.m12113a(icVar3)) {
                    return a(icVar3, booleanExtra, byteArrayExtra3, stringExtra2, intExtra, intent);
                }
                s.e(this.f129a, icVar3, booleanExtra);
                boolean m11467d = m11457a2.m11467d();
                com.xiaomi.channel.commonutils.logger.b.d("receive message without registration. need re-register!registered?".concat(String.valueOf(m11467d)));
                em.a(this.f129a).a(this.f129a.getPackageName(), intent, "15");
                if (m11467d) {
                    a();
                    return null;
                }
                return null;
            } else if (m11457a2.m11466c() && m11457a2.m11469f()) {
                if (icVar3.f706a != hg.UnRegistration) {
                    s.e(this.f129a, icVar3, booleanExtra);
                    MiPushClient.unregisterPush(this.f129a);
                    return null;
                } else if (!icVar3.m11953b()) {
                    com.xiaomi.channel.commonutils.logger.b.d("receiving an un-encrypt unregistration message");
                    return null;
                } else {
                    m11457a2.m11459a();
                    MiPushClient.clearExtras(this.f129a);
                    PushMessageHandler.a();
                    return null;
                }
            } else {
                return a(icVar3, booleanExtra, byteArrayExtra3, stringExtra2, intExtra, intent);
            }
        } catch (iw e3) {
            e = e3;
            a2 = em.a(this.f129a);
            packageName = this.f129a.getPackageName();
            str2 = "16";
            a2.a(packageName, intent, str2);
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return null;
        } catch (Exception e4) {
            e = e4;
            a2 = em.a(this.f129a);
            packageName = this.f129a.getPackageName();
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
