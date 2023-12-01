package com.igexin.push.core;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.igexin.assist.sdk.AssistPushManager;
import com.igexin.assist.util.AssistUtils;
import com.igexin.push.c.c.o;
import com.igexin.push.config.a;
import com.igexin.push.core.d;
import com.igexin.push.core.e.f;
import com.igexin.push.extension.mod.PushTaskBean;
import com.igexin.sdk.PushConsts;
import com.igexin.sdk.main.FeedbackImpl;
import com.umeng.analytics.pro.bh;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/m.class */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    private static final String f9969a = "PushController";
    private static m b;

    private m() {
    }

    public static m a() {
        if (b == null) {
            b = new m();
        }
        return b;
    }

    private static void a(int i) {
        com.igexin.push.config.d.e = i;
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new a.AnonymousClass3(), false, true);
        if (e.u) {
            System.currentTimeMillis();
            com.igexin.c.a.c.a.a("setHeartbeatInterval heartbeatReq", new Object[0]);
            if (System.currentTimeMillis() - e.Y > 5000) {
                e.Y = System.currentTimeMillis();
                com.igexin.push.core.a.b.d();
                com.igexin.push.core.a.b.f();
            }
        }
    }

    public static void a(int i, int i2) {
        com.igexin.push.config.d.b = i;
        com.igexin.push.config.d.f9768c = i2;
        com.igexin.push.config.a.a().b();
        com.igexin.push.e.f.c().d();
    }

    private static void a(Bundle bundle) {
        String string = bundle.getString("action");
        com.igexin.c.a.c.a.a("PushController|action pushmanager action = ".concat(String.valueOf(string)), new Object[0]);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        boolean z = true;
        switch (string.hashCode()) {
            case -1710807787:
                if (string.equals("queryPushOnLine")) {
                    z = true;
                    break;
                }
                break;
            case -1673882831:
                if (string.equals("setVivoBadgeNum")) {
                    z = true;
                    break;
                }
                break;
            case -1411528570:
                if (string.equals("setNotificationIcon")) {
                    z = true;
                    break;
                }
                break;
            case -1166665294:
                if (string.equals(PushConsts.QUERY_TAG)) {
                    z = true;
                    break;
                }
                break;
            case -1092138459:
                if (string.equals("setOppoBadgeNum")) {
                    z = true;
                    break;
                }
                break;
            case -957964269:
                if (string.equals("bindAlias")) {
                    z = true;
                    break;
                }
                break;
            case -908867308:
                if (string.equals("setHwBadgeNum")) {
                    z = true;
                    break;
                }
                break;
            case -905799720:
                if (string.equals("setTag")) {
                    z = false;
                    break;
                }
                break;
            case -889524838:
                if (string.equals("unbindAlias")) {
                    z = true;
                    break;
                }
                break;
            case -850755092:
                if (string.equals("turnOffPush")) {
                    z = true;
                    break;
                }
                break;
            case -479268212:
                if (string.equals("registerPushActivity")) {
                    z = true;
                    break;
                }
                break;
            case -344351336:
                if (string.equals("sendApplinkFeedback")) {
                    z = true;
                    break;
                }
                break;
            case -159289499:
                if (string.equals("setBadgeNum")) {
                    z = true;
                    break;
                }
                break;
            case -12797509:
                if (string.equals("setGuardOptions")) {
                    z = true;
                    break;
                }
                break;
            case 329771905:
                if (string.equals("setDeviceToken")) {
                    z = true;
                    break;
                }
                break;
            case 495464132:
                if (string.equals("setSilentTime")) {
                    z = true;
                    break;
                }
                break;
            case 539767084:
                if (string.equals("setSocketTimeout")) {
                    z = true;
                    break;
                }
                break;
            case 556182983:
                if (string.equals("registerUserService")) {
                    z = true;
                    break;
                }
                break;
            case 691453791:
                if (string.equals("sendMessage")) {
                    z = true;
                    break;
                }
                break;
            case 999002527:
                if (string.equals("setHeartbeatInterval")) {
                    z = true;
                    break;
                }
                break;
            case 1841202202:
                if (string.equals("sendFeedbackMessage")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                boolean z2 = com.igexin.push.config.d.k;
                if (com.igexin.push.config.d.k) {
                    String string2 = bundle.getString("tags");
                    String string3 = bundle.getString("sn");
                    if (TextUtils.isEmpty(e.A)) {
                        com.igexin.c.a.c.a.d.a().a("setTag : " + string2 + ", failed, has not get clientid");
                        l.a().a(string3, "20008");
                        return;
                    }
                    try {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("action", "set_tag");
                            jSONObject.put("id", String.valueOf(currentTimeMillis));
                            jSONObject.put("cid", e.A);
                            jSONObject.put("appid", e.f9887a);
                            jSONObject.put("tags", URLEncoder.encode(string2, "utf-8"));
                            jSONObject.put("sn", string3);
                        } catch (Exception e) {
                            com.igexin.c.a.c.a.a(e);
                        }
                        e.e = string2.replaceAll(",", " ");
                        String jSONObject2 = jSONObject.toString();
                        com.igexin.push.core.e.e.a().b(new com.igexin.push.core.b.l(currentTimeMillis, jSONObject2, (byte) 2, e.u ? currentTimeMillis : 0L));
                        o oVar = new o();
                        oVar.f9726c = 128;
                        oVar.e = b.K;
                        oVar.f = jSONObject2;
                        d.a.a().h.a("C-" + e.A, oVar, false);
                        com.igexin.c.a.c.a.a("settag", new Object[0]);
                        return;
                    } catch (Exception e2) {
                        com.igexin.c.a.c.a.a(e2);
                        return;
                    }
                }
                return;
            case true:
                boolean z3 = com.igexin.push.config.d.l;
                if (com.igexin.push.config.d.l) {
                    int i = bundle.getInt("beginHour", 0);
                    int i2 = bundle.getInt("duration", 0);
                    e.l.getPackageName();
                    a(i, i2);
                    AssistPushManager.getInstance().setSilentTime(e.l, i, i2);
                    return;
                }
                return;
            case true:
                boolean z4 = com.igexin.push.config.d.j;
                com.igexin.c.a.c.a.a("PushController onPushManagerMessage recevie action : sendMessage", new Object[0]);
                if (com.igexin.push.config.d.j) {
                    String string4 = bundle.getString("taskid");
                    byte[] byteArray = bundle.getByteArray("extraData");
                    com.igexin.c.a.c.a.a("PushController receive broadcast msg data , task id : " + string4 + " ######@##@@@#", new Object[0]);
                    if (e.A != null) {
                        JSONObject jSONObject3 = new JSONObject();
                        long currentTimeMillis2 = System.currentTimeMillis();
                        try {
                            jSONObject3.put("action", "sendmessage");
                            jSONObject3.put("id", String.valueOf(currentTimeMillis2));
                            jSONObject3.put("cid", e.A);
                            jSONObject3.put("appid", e.f9887a);
                            jSONObject3.put("taskid", string4);
                            jSONObject3.put("extraData", Base64.encodeToString(byteArray, 0));
                            String jSONObject4 = jSONObject3.toString();
                            com.igexin.push.core.e.e.a().b(new com.igexin.push.core.b.l(currentTimeMillis2, jSONObject4, (byte) 6, currentTimeMillis2));
                            com.igexin.push.c.c.b bVar = new com.igexin.push.c.c.b();
                            bVar.f9726c = 128;
                            bVar.b = (int) currentTimeMillis2;
                            bVar.e = e.A;
                            bVar.f = jSONObject4;
                            bVar.g = byteArray;
                            bVar.h = e.A;
                            d.a.a().h.a("C-" + e.A, bVar, false);
                            if (string4 == null || !string4.startsWith("4T5@S_")) {
                                return;
                            }
                            com.igexin.c.a.c.a.a("PushController sending lbs report message : ".concat(String.valueOf(jSONObject4)), new Object[0]);
                            return;
                        } catch (Throwable th) {
                            com.igexin.c.a.c.a.a(th);
                            return;
                        }
                    }
                    return;
                }
                return;
            case true:
                boolean z5 = com.igexin.push.config.d.m;
                if (com.igexin.push.config.d.m) {
                    int i3 = bundle.getInt(bh.aX, 0);
                    e.l.getPackageName();
                    com.igexin.push.config.d.e = i3;
                    com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new a.AnonymousClass3(), false, true);
                    if (e.u) {
                        System.currentTimeMillis();
                        com.igexin.c.a.c.a.a("setHeartbeatInterval heartbeatReq", new Object[0]);
                        if (System.currentTimeMillis() - e.Y > 5000) {
                            e.Y = System.currentTimeMillis();
                            com.igexin.push.core.a.b.d();
                            com.igexin.push.core.a.b.f();
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case true:
                boolean z6 = com.igexin.push.config.d.n;
                if (com.igexin.push.config.d.n) {
                    int i4 = bundle.getInt("submitTimeoutEvent", 0);
                    e.l.getPackageName();
                    com.igexin.push.config.d.f = i4;
                    com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new a.AnonymousClass4(), false, true);
                    return;
                }
                return;
            case true:
                boolean z7 = com.igexin.push.config.d.o;
                int i5 = e.am;
                if (!com.igexin.push.config.d.o || e.am > 200) {
                    return;
                }
                String string5 = bundle.getString("taskid");
                String string6 = bundle.getString("messageid");
                String string7 = bundle.getString("actionid");
                String str = string5 + ":" + string6 + ":" + string7;
                if (e.al.get(str) == null) {
                    long currentTimeMillis3 = System.currentTimeMillis();
                    PushTaskBean pushTaskBean = new PushTaskBean();
                    pushTaskBean.setTaskId(string5);
                    pushTaskBean.setMessageId(string6);
                    pushTaskBean.setAppid(e.f9887a);
                    FeedbackImpl.getInstance().feedbackMessageAction(pushTaskBean, string7);
                    e.am++;
                    e.al.put(str, Long.valueOf(currentTimeMillis3));
                    return;
                }
                return;
            case true:
                d a2 = d.a.a();
                if (e.l != null) {
                    com.igexin.push.core.d.d.a().a("p", Boolean.FALSE);
                    e.s = false;
                    e.v = false;
                    a2.h.b();
                }
                AssistPushManager.getInstance().turnOffPush(e.l);
                return;
            case true:
                String string8 = bundle.getString("alias");
                String string9 = bundle.getString("sn");
                com.igexin.c.a.c.a.a("PushController|onPushManagerMessage bindAlias...", new Object[0]);
                if (TextUtils.isEmpty(e.A)) {
                    com.igexin.c.a.c.a.d.a().a("bindAlias : " + string8 + ", failed, has not get clientid");
                    l.a().b(string9, "30005");
                    return;
                }
                long currentTimeMillis4 = System.currentTimeMillis();
                long j = e.aa;
                if (currentTimeMillis4 - e.aa <= 1000) {
                    com.igexin.c.a.c.a.a("PushController|bindAlias frequently called", new Object[0]);
                    return;
                }
                String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(currentTimeMillis4));
                if (e.Z != null) {
                    String str2 = e.Z;
                }
                if (!format.equals(e.Z)) {
                    com.igexin.push.core.e.f.a().d(format);
                    com.igexin.push.core.e.f.a().a(0);
                }
                int i6 = e.ab;
                com.igexin.c.a.c.a.a("-> CoreRuntimeInfo.opAliasTimes:" + e.ab, new Object[0]);
                if (e.ab < 100) {
                    com.igexin.c.a.c.a.a("start bindAlias ###", new Object[0]);
                    e.aa = currentTimeMillis4;
                    com.igexin.push.core.e.f.a().a(e.ab + 1);
                    a(string8, string9, false, true);
                    return;
                }
                com.igexin.c.a.c.a.a("PushController|bindAlias times exceed", new Object[0]);
                com.igexin.c.a.c.a.d.a().a("bindAlias : " + string8 + ", failed, , the number of calls per day cannot exceed 100");
                l.a().b(string9, "30003");
                return;
            case true:
                String string10 = bundle.getString("alias");
                String string11 = bundle.getString("sn");
                boolean z8 = bundle.getBoolean("isSeft");
                com.igexin.c.a.c.a.a("PushController|onPushManagerMessage unbindAlias...", new Object[0]);
                if (TextUtils.isEmpty(e.A)) {
                    com.igexin.c.a.c.a.d.a().a("unbindAlias : " + string10 + ", failed, has not get clientid");
                    l.a().c(string11, "30005");
                    return;
                } else if (z8 && TextUtils.isEmpty(e.A)) {
                    return;
                } else {
                    long currentTimeMillis5 = System.currentTimeMillis();
                    long j2 = e.aa;
                    if (currentTimeMillis5 - e.aa <= 1000) {
                        com.igexin.c.a.c.a.a("PushController|unbindAlias frequently called", new Object[0]);
                        return;
                    }
                    String format2 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(currentTimeMillis5));
                    String str3 = e.Z;
                    if (!format2.equals(e.Z)) {
                        com.igexin.push.core.e.f.a().d(format2);
                        com.igexin.push.core.e.f.a().a(0);
                    }
                    int i7 = e.ab;
                    if (e.ab < 100) {
                        com.igexin.c.a.c.a.a("start unbindAlias ###", new Object[0]);
                        e.aa = currentTimeMillis5;
                        com.igexin.push.core.e.f.a().a(e.ab + 1);
                        a(string10, string11, true, z8);
                        return;
                    }
                    com.igexin.c.a.c.a.a("PushController|unbindAlias times exceed", new Object[0]);
                    com.igexin.c.a.c.a.d.a().a("unbindAlias : " + string10 + ", failed, , the number of calls per day cannot exceed 100");
                    l.a().c(string11, "30003");
                    return;
                }
            case true:
                String string12 = bundle.getString("url");
                boolean z9 = com.igexin.push.config.d.E;
                if (TextUtils.isEmpty(string12)) {
                    return;
                }
                try {
                    Uri parse = Uri.parse(string12);
                    String host = parse.getHost();
                    String queryParameter = parse.getQueryParameter("p");
                    if (!TextUtils.isEmpty(host) && !TextUtils.isEmpty(queryParameter)) {
                        if (!com.igexin.push.config.d.E) {
                            com.igexin.c.a.c.a.a("PushController|isApplinkFeedback is false, not feedback", new Object[0]);
                            return;
                        } else if (!com.igexin.push.f.c.c(host)) {
                            com.igexin.c.a.c.a.a("PushController|checkIsWhiteApplinkDomain is false, not feedback", new Object[0]);
                            return;
                        } else {
                            com.igexin.c.a.c.a.a("PushController|isApplinkFeedback is true and checkIsWhiteApplinkDomain is true, to feedback", new Object[0]);
                            PushTaskBean pushTaskBean2 = new PushTaskBean();
                            pushTaskBean2.setTaskId("getuiapplinkup");
                            pushTaskBean2.setMessageId(queryParameter);
                            pushTaskBean2.setAppid(e.f9887a);
                            FeedbackImpl.getInstance().feedbackMessageAction(pushTaskBean2, PushConsts.SEND_MESSAGE_ERROR);
                            return;
                        }
                    }
                    com.igexin.c.a.c.a.a("PushController|url " + string12 + " is invalid", new Object[0]);
                    return;
                } catch (Exception e3) {
                    com.igexin.c.a.c.a.a(e3);
                    com.igexin.c.a.c.a.a("PushController|" + e3.toString(), new Object[0]);
                    return;
                }
            case true:
                com.igexin.push.f.d.a(bundle.getInt("badgeNum"), true);
                return;
            case true:
                com.igexin.push.f.d.b(bundle.getInt("badgeNum"), true);
                return;
            case true:
                com.igexin.push.f.d.c(bundle.getInt("badgeNum"), true);
                return;
            case true:
                if (com.igexin.push.f.n.d().equalsIgnoreCase(AssistUtils.BRAND_HW) || com.igexin.push.f.n.d().equalsIgnoreCase(AssistUtils.BRAND_HON)) {
                    com.igexin.push.f.d.a(bundle.getInt("badgeNum"), true);
                    return;
                } else if (com.igexin.push.f.n.d().equalsIgnoreCase(AssistUtils.BRAND_OPPO)) {
                    com.igexin.push.f.d.c(bundle.getInt("badgeNum"), true);
                    return;
                } else if (com.igexin.push.f.n.d().equalsIgnoreCase(AssistUtils.BRAND_VIVO)) {
                    com.igexin.push.f.d.b(bundle.getInt("badgeNum"), true);
                    return;
                } else {
                    return;
                }
            case true:
                com.igexin.push.config.e.a(bundle.getBoolean("guardMe", true), bundle.getBoolean("guardOthers", true));
                e.a();
                com.igexin.c.a.c.a.d.a().a("[PushController] setGuardOptions success");
                return;
            case true:
            case true:
                e.a();
                return;
            case true:
                e.aK = bundle.getString("smallIcon", "");
                e.aL = bundle.getString("largeIcon", "");
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new f.AnonymousClass19(e.aK, e.aL), false, true);
                com.igexin.c.a.c.a.d.a().a("[PushController] setNotificationIcon success");
                return;
            case true:
                String string13 = bundle.getString("sn");
                if (TextUtils.isEmpty(e.A)) {
                    return;
                }
                if (System.currentTimeMillis() - e.f9889c < com.igexin.push.config.d.f9767a * 1000 && e.d != null) {
                    String str4 = e.d;
                    com.igexin.c.a.c.a.a("PushController|query tag already cache, tag = " + e.d, new Object[0]);
                    l.a().a(string13, "0", e.d);
                    return;
                }
                try {
                    long currentTimeMillis6 = System.currentTimeMillis();
                    JSONObject jSONObject5 = new JSONObject();
                    try {
                        jSONObject5.put("action", "query_tag");
                        jSONObject5.put("id", String.valueOf(currentTimeMillis6));
                        jSONObject5.put("cid", e.A);
                        jSONObject5.put("appid", e.f9887a);
                        jSONObject5.put("sn", string13);
                    } catch (Exception e4) {
                        com.igexin.c.a.c.a.a(e4);
                    }
                    String jSONObject6 = jSONObject5.toString();
                    com.igexin.push.core.e.e.a().b(new com.igexin.push.core.b.l(currentTimeMillis6, jSONObject6, (byte) 11, currentTimeMillis6));
                    o oVar2 = new o();
                    oVar2.f9726c = 128;
                    oVar2.e = b.K;
                    oVar2.f = jSONObject6;
                    d.a.a().h.a("C-" + e.A, oVar2, false);
                    com.igexin.push.core.e.f a3 = com.igexin.push.core.e.f.a();
                    if (e.f9889c != currentTimeMillis6) {
                        e.f9889c = currentTimeMillis6;
                        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new f.AnonymousClass20(), false, true);
                    }
                    com.igexin.c.a.c.a.a("PushController｜queryTag", new Object[0]);
                    return;
                } catch (Exception e5) {
                    com.igexin.c.a.c.a.a(e5);
                    return;
                }
            case true:
                l.a().b();
                return;
            case true:
                try {
                    String string14 = bundle.getString("token", "");
                    if (!TextUtils.isEmpty(string14)) {
                        e.J = true;
                        if (!string14.equals(e.I)) {
                            com.igexin.push.core.e.f.a().b(string14);
                            if (e.u) {
                                com.igexin.c.a.c.a.b(f9969a, "online, send addphoneinfo");
                                com.igexin.push.core.a.b.d().i();
                            }
                        }
                    }
                    com.igexin.c.a.c.a.d.a().a("[PushController] setDeviceToken success ".concat(String.valueOf(string14)));
                    return;
                } catch (Throwable th2) {
                    com.igexin.c.a.c.a.a(th2);
                    return;
                }
            default:
                return;
        }
    }

    private static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Uri parse = Uri.parse(str);
            String host = parse.getHost();
            String queryParameter = parse.getQueryParameter("p");
            if (!TextUtils.isEmpty(host) && !TextUtils.isEmpty(queryParameter)) {
                if (!com.igexin.push.config.d.E) {
                    com.igexin.c.a.c.a.a("PushController|isApplinkFeedback is false, not feedback", new Object[0]);
                    return;
                } else if (!com.igexin.push.f.c.c(host)) {
                    com.igexin.c.a.c.a.a("PushController|checkIsWhiteApplinkDomain is false, not feedback", new Object[0]);
                    return;
                } else {
                    com.igexin.c.a.c.a.a("PushController|isApplinkFeedback is true and checkIsWhiteApplinkDomain is true, to feedback", new Object[0]);
                    PushTaskBean pushTaskBean = new PushTaskBean();
                    pushTaskBean.setTaskId("getuiapplinkup");
                    pushTaskBean.setMessageId(queryParameter);
                    pushTaskBean.setAppid(e.f9887a);
                    FeedbackImpl.getInstance().feedbackMessageAction(pushTaskBean, PushConsts.SEND_MESSAGE_ERROR);
                    return;
                }
            }
            com.igexin.c.a.c.a.a("PushController|url " + str + " is invalid", new Object[0]);
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            com.igexin.c.a.c.a.a("PushController|" + e.toString(), new Object[0]);
        }
    }

    private static void a(String str, String str2) {
        if (TextUtils.isEmpty(e.A)) {
            com.igexin.c.a.c.a.d a2 = com.igexin.c.a.c.a.d.a();
            a2.a("setTag : " + str + ", failed, has not get clientid");
            l.a().a(str2, "20008");
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("action", "set_tag");
                jSONObject.put("id", String.valueOf(currentTimeMillis));
                jSONObject.put("cid", e.A);
                jSONObject.put("appid", e.f9887a);
                jSONObject.put("tags", URLEncoder.encode(str, "utf-8"));
                jSONObject.put("sn", str2);
            } catch (Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
            e.e = str.replaceAll(",", " ");
            String jSONObject2 = jSONObject.toString();
            com.igexin.push.core.e.e.a().b(new com.igexin.push.core.b.l(currentTimeMillis, jSONObject2, (byte) 2, e.u ? currentTimeMillis : 0L));
            o oVar = new o();
            oVar.f9726c = 128;
            oVar.e = b.K;
            oVar.f = jSONObject2;
            com.igexin.push.d.a aVar = d.a.a().h;
            aVar.a("C-" + e.A, oVar, false);
            com.igexin.c.a.c.a.a("settag", new Object[0]);
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
        }
    }

    private static void a(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(e.A)) {
            com.igexin.c.a.c.a.d a2 = com.igexin.c.a.c.a.d.a();
            a2.a("unbindAlias : " + str + ", failed, has not get clientid");
            l.a().c(str2, "30005");
        } else if (z && TextUtils.isEmpty(e.A)) {
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            long j = e.aa;
            if (currentTimeMillis - e.aa <= 1000) {
                com.igexin.c.a.c.a.a("PushController|unbindAlias frequently called", new Object[0]);
                return;
            }
            String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(currentTimeMillis));
            String str3 = e.Z;
            if (!format.equals(e.Z)) {
                com.igexin.push.core.e.f.a().d(format);
                com.igexin.push.core.e.f.a().a(0);
            }
            int i = e.ab;
            if (e.ab < 100) {
                com.igexin.c.a.c.a.a("start unbindAlias ###", new Object[0]);
                e.aa = currentTimeMillis;
                com.igexin.push.core.e.f.a().a(e.ab + 1);
                a(str, str2, true, z);
                return;
            }
            com.igexin.c.a.c.a.a("PushController|unbindAlias times exceed", new Object[0]);
            com.igexin.c.a.c.a.d a3 = com.igexin.c.a.c.a.d.a();
            a3.a("unbindAlias : " + str + ", failed, , the number of calls per day cannot exceed 100");
            l.a().c(str2, "30003");
        }
    }

    public static void a(String str, String str2, boolean z, boolean z2) {
        if (TextUtils.isEmpty(e.A)) {
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            String str3 = z ? "unbind_alias" : "bind_alias";
            byte b2 = z ? (byte) 8 : (byte) 7;
            try {
                jSONObject.put("action", str3);
                jSONObject.put("id", String.valueOf(currentTimeMillis));
                jSONObject.put("cid", e.A);
                jSONObject.put("appid", e.f9887a);
                jSONObject.put("alias", str);
                jSONObject.put("sn", str2);
                if (z) {
                    jSONObject.put("is_self", z2);
                }
            } catch (Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
            String jSONObject2 = jSONObject.toString();
            com.igexin.push.core.e.e.a().b(new com.igexin.push.core.b.l(currentTimeMillis, jSONObject2, b2, e.u ? currentTimeMillis : 0L));
            o oVar = new o();
            oVar.f9726c = 128;
            oVar.e = b.K;
            oVar.f = jSONObject2;
            com.igexin.push.d.a aVar = d.a.a().h;
            aVar.a("C-" + e.A, oVar, false);
            com.igexin.c.a.c.a.a(str3 + " = " + jSONObject2, new Object[0]);
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
        }
    }

    private static void a(String str, byte[] bArr) {
        if (e.A != null) {
            JSONObject jSONObject = new JSONObject();
            long currentTimeMillis = System.currentTimeMillis();
            try {
                jSONObject.put("action", "sendmessage");
                jSONObject.put("id", String.valueOf(currentTimeMillis));
                jSONObject.put("cid", e.A);
                jSONObject.put("appid", e.f9887a);
                jSONObject.put("taskid", str);
                jSONObject.put("extraData", Base64.encodeToString(bArr, 0));
                String jSONObject2 = jSONObject.toString();
                com.igexin.push.core.e.e.a().b(new com.igexin.push.core.b.l(currentTimeMillis, jSONObject2, (byte) 6, currentTimeMillis));
                com.igexin.push.c.c.b bVar = new com.igexin.push.c.c.b();
                bVar.f9726c = 128;
                bVar.b = (int) currentTimeMillis;
                bVar.e = e.A;
                bVar.f = jSONObject2;
                bVar.g = bArr;
                bVar.h = e.A;
                com.igexin.push.d.a aVar = d.a.a().h;
                aVar.a("C-" + e.A, bVar, false);
                if (str == null || !str.startsWith("4T5@S_")) {
                    return;
                }
                com.igexin.c.a.c.a.a("PushController sending lbs report message : ".concat(String.valueOf(jSONObject2)), new Object[0]);
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
    }

    private static void b(int i) {
        com.igexin.push.config.d.f = i;
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new a.AnonymousClass4(), false, true);
    }

    private static void b(String str) {
        if (TextUtils.isEmpty(e.A)) {
            return;
        }
        if (System.currentTimeMillis() - e.f9889c < com.igexin.push.config.d.f9767a * 1000 && e.d != null) {
            String str2 = e.d;
            com.igexin.c.a.c.a.a("PushController|query tag already cache, tag = " + e.d, new Object[0]);
            l.a().a(str, "0", e.d);
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("action", "query_tag");
                jSONObject.put("id", String.valueOf(currentTimeMillis));
                jSONObject.put("cid", e.A);
                jSONObject.put("appid", e.f9887a);
                jSONObject.put("sn", str);
            } catch (Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
            String jSONObject2 = jSONObject.toString();
            com.igexin.push.core.e.e.a().b(new com.igexin.push.core.b.l(currentTimeMillis, jSONObject2, (byte) 11, currentTimeMillis));
            o oVar = new o();
            oVar.f9726c = 128;
            oVar.e = b.K;
            oVar.f = jSONObject2;
            com.igexin.push.d.a aVar = d.a.a().h;
            aVar.a("C-" + e.A, oVar, false);
            com.igexin.push.core.e.f a2 = com.igexin.push.core.e.f.a();
            if (e.f9889c != currentTimeMillis) {
                e.f9889c = currentTimeMillis;
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new f.AnonymousClass20(), false, true);
            }
            com.igexin.c.a.c.a.a("PushController｜queryTag", new Object[0]);
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
        }
    }

    private static void b(String str, String str2) {
        if (TextUtils.isEmpty(e.A)) {
            com.igexin.c.a.c.a.d a2 = com.igexin.c.a.c.a.d.a();
            a2.a("bindAlias : " + str + ", failed, has not get clientid");
            l.a().b(str2, "30005");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = e.aa;
        if (currentTimeMillis - e.aa <= 1000) {
            com.igexin.c.a.c.a.a("PushController|bindAlias frequently called", new Object[0]);
            return;
        }
        String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(currentTimeMillis));
        if (e.Z != null) {
            String str3 = e.Z;
        }
        if (!format.equals(e.Z)) {
            com.igexin.push.core.e.f.a().d(format);
            com.igexin.push.core.e.f.a().a(0);
        }
        int i = e.ab;
        com.igexin.c.a.c.a.a("-> CoreRuntimeInfo.opAliasTimes:" + e.ab, new Object[0]);
        if (e.ab < 100) {
            com.igexin.c.a.c.a.a("start bindAlias ###", new Object[0]);
            e.aa = currentTimeMillis;
            com.igexin.push.core.e.f.a().a(e.ab + 1);
            a(str, str2, false, true);
            return;
        }
        com.igexin.c.a.c.a.a("PushController|bindAlias times exceed", new Object[0]);
        com.igexin.c.a.c.a.d a3 = com.igexin.c.a.c.a.d.a();
        a3.a("bindAlias : " + str + ", failed, , the number of calls per day cannot exceed 100");
        l.a().b(str2, "30003");
    }
}
