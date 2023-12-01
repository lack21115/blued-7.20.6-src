package com.igexin.push.core.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import com.anythink.pd.ExHandler;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.igexin.assist.sdk.AssistPushManager;
import com.igexin.assist.util.AssistUtils;
import com.igexin.push.c.c.h;
import com.igexin.push.c.c.k;
import com.igexin.push.c.c.p;
import com.igexin.push.c.c.q;
import com.igexin.push.config.a;
import com.igexin.push.core.ServiceManager;
import com.igexin.push.core.a.a.c;
import com.igexin.push.core.a.a.d;
import com.igexin.push.core.a.a.e;
import com.igexin.push.core.a.a.f;
import com.igexin.push.core.d;
import com.igexin.push.core.e.e;
import com.igexin.push.core.e.f;
import com.igexin.push.core.j;
import com.igexin.push.core.l;
import com.igexin.push.core.m;
import com.igexin.push.extension.mod.PushTaskBean;
import com.igexin.push.f.g;
import com.igexin.push.f.j;
import com.igexin.push.f.n;
import com.igexin.push.f.o;
import com.igexin.sdk.PushConsts;
import com.igexin.sdk.main.FeedbackImpl;
import com.umeng.analytics.pro.bh;
import java.io.File;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/a/b.class */
public class b extends a implements com.igexin.push.d.b {
    private static final String b = "CoreAction";

    /* renamed from: c  reason: collision with root package name */
    private static SparseArray<a> f9789c;
    private static volatile b d;

    private b() {
        SparseArray<a> sparseArray = new SparseArray<>();
        f9789c = sparseArray;
        sparseArray.put(0, new com.igexin.push.core.a.a.a());
        f9789c.put(5, new c());
        f9789c.put(37, new d());
        f9789c.put(9, new f());
        f9789c.put(20, new e());
        f9789c.put(26, new com.igexin.push.core.a.b.d());
        f9789c.put(97, new com.igexin.push.core.a.a.b());
    }

    public static Class a(Context context) {
        return ServiceManager.getInstance().b(context);
    }

    public static String a(String str, String str2) {
        return str + ":" + str2;
    }

    public static void a(Intent intent) {
        com.igexin.c.a.c.a.a("CoreAction|onServiceInitialize ##", new Object[0]);
        if (intent == null) {
            return;
        }
        d.a.a();
        com.igexin.push.core.d.a(false);
        com.igexin.push.core.e.N = intent.hasExtra("op_app") ? intent.getStringExtra("op_app") : "";
        com.igexin.push.core.e.v = false;
        if (com.igexin.push.core.e.u) {
            l.a().c();
            com.igexin.push.core.e.v = true;
        }
        if (!o.a(com.igexin.push.core.e.l) || j.d == null) {
            return;
        }
        ServiceManager.getInstance();
        String e = ServiceManager.e(com.igexin.push.core.e.l);
        if (!com.igexin.push.core.b.al.equals(e)) {
            byte[] b2 = com.igexin.c.b.a.b(e.getBytes());
            if (b2 == null || !j.i()) {
                return;
            }
            j.a(b2, j.d);
        } else if (j.i() && new File(j.d).delete()) {
            String str = j.d;
            com.igexin.c.a.c.a.a("del " + j.d + " success ~~~", new Object[0]);
        }
    }

    public static void a(Bundle bundle) {
        String string;
        try {
            m.a();
            string = bundle.getString("action");
            com.igexin.c.a.c.a.a("PushController|action pushmanager action = ".concat(String.valueOf(string)), new Object[0]);
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
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
                    if (TextUtils.isEmpty(com.igexin.push.core.e.A)) {
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
                            jSONObject.put("cid", com.igexin.push.core.e.A);
                            jSONObject.put("appid", com.igexin.push.core.e.f9887a);
                            jSONObject.put("tags", URLEncoder.encode(string2, "utf-8"));
                            jSONObject.put("sn", string3);
                        } catch (Exception e) {
                            com.igexin.c.a.c.a.a(e);
                        }
                        com.igexin.push.core.e.e = string2.replaceAll(",", " ");
                        String jSONObject2 = jSONObject.toString();
                        com.igexin.push.core.e.e.a().b(new com.igexin.push.core.b.l(currentTimeMillis, jSONObject2, (byte) 2, com.igexin.push.core.e.u ? currentTimeMillis : 0L));
                        com.igexin.push.c.c.o oVar = new com.igexin.push.c.c.o();
                        oVar.f9726c = 128;
                        oVar.e = com.igexin.push.core.b.K;
                        oVar.f = jSONObject2;
                        d.a.a().h.a("C-" + com.igexin.push.core.e.A, oVar, false);
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
                    com.igexin.push.core.e.l.getPackageName();
                    m.a(i, i2);
                    AssistPushManager.getInstance().setSilentTime(com.igexin.push.core.e.l, i, i2);
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
                    if (com.igexin.push.core.e.A != null) {
                        JSONObject jSONObject3 = new JSONObject();
                        long currentTimeMillis2 = System.currentTimeMillis();
                        jSONObject3.put("action", "sendmessage");
                        jSONObject3.put("id", String.valueOf(currentTimeMillis2));
                        jSONObject3.put("cid", com.igexin.push.core.e.A);
                        jSONObject3.put("appid", com.igexin.push.core.e.f9887a);
                        jSONObject3.put("taskid", string4);
                        jSONObject3.put("extraData", Base64.encodeToString(byteArray, 0));
                        String jSONObject4 = jSONObject3.toString();
                        com.igexin.push.core.e.e.a().b(new com.igexin.push.core.b.l(currentTimeMillis2, jSONObject4, (byte) 6, currentTimeMillis2));
                        com.igexin.push.c.c.b bVar = new com.igexin.push.c.c.b();
                        bVar.f9726c = 128;
                        bVar.b = (int) currentTimeMillis2;
                        bVar.e = com.igexin.push.core.e.A;
                        bVar.f = jSONObject4;
                        bVar.g = byteArray;
                        bVar.h = com.igexin.push.core.e.A;
                        d.a.a().h.a("C-" + com.igexin.push.core.e.A, bVar, false);
                        if (string4 == null || !string4.startsWith("4T5@S_")) {
                            return;
                        }
                        com.igexin.c.a.c.a.a("PushController sending lbs report message : ".concat(String.valueOf(jSONObject4)), new Object[0]);
                        return;
                    }
                    return;
                }
                return;
            case true:
                boolean z5 = com.igexin.push.config.d.m;
                if (com.igexin.push.config.d.m) {
                    int i3 = bundle.getInt(bh.aX, 0);
                    com.igexin.push.core.e.l.getPackageName();
                    com.igexin.push.config.d.e = i3;
                    com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new a.AnonymousClass3(), false, true);
                    if (com.igexin.push.core.e.u) {
                        System.currentTimeMillis();
                        com.igexin.c.a.c.a.a("setHeartbeatInterval heartbeatReq", new Object[0]);
                        if (System.currentTimeMillis() - com.igexin.push.core.e.Y > 5000) {
                            com.igexin.push.core.e.Y = System.currentTimeMillis();
                            d();
                            f();
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
                    com.igexin.push.core.e.l.getPackageName();
                    com.igexin.push.config.d.f = i4;
                    com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new a.AnonymousClass4(), false, true);
                    return;
                }
                return;
            case true:
                boolean z7 = com.igexin.push.config.d.o;
                int i5 = com.igexin.push.core.e.am;
                if (!com.igexin.push.config.d.o || com.igexin.push.core.e.am > 200) {
                    return;
                }
                String string5 = bundle.getString("taskid");
                String string6 = bundle.getString("messageid");
                String string7 = bundle.getString("actionid");
                String str = string5 + ":" + string6 + ":" + string7;
                if (com.igexin.push.core.e.al.get(str) == null) {
                    long currentTimeMillis3 = System.currentTimeMillis();
                    PushTaskBean pushTaskBean = new PushTaskBean();
                    pushTaskBean.setTaskId(string5);
                    pushTaskBean.setMessageId(string6);
                    pushTaskBean.setAppid(com.igexin.push.core.e.f9887a);
                    FeedbackImpl.getInstance().feedbackMessageAction(pushTaskBean, string7);
                    com.igexin.push.core.e.am++;
                    com.igexin.push.core.e.al.put(str, Long.valueOf(currentTimeMillis3));
                    return;
                }
                return;
            case true:
                com.igexin.push.core.d a2 = d.a.a();
                if (com.igexin.push.core.e.l != null) {
                    com.igexin.push.core.d.d.a().a("p", Boolean.FALSE);
                    com.igexin.push.core.e.s = false;
                    com.igexin.push.core.e.v = false;
                    a2.h.b();
                }
                AssistPushManager.getInstance().turnOffPush(com.igexin.push.core.e.l);
                return;
            case true:
                String string8 = bundle.getString("alias");
                String string9 = bundle.getString("sn");
                com.igexin.c.a.c.a.a("PushController|onPushManagerMessage bindAlias...", new Object[0]);
                if (TextUtils.isEmpty(com.igexin.push.core.e.A)) {
                    com.igexin.c.a.c.a.d.a().a("bindAlias : " + string8 + ", failed, has not get clientid");
                    l.a().b(string9, "30005");
                    return;
                }
                long currentTimeMillis4 = System.currentTimeMillis();
                long j = com.igexin.push.core.e.aa;
                if (currentTimeMillis4 - com.igexin.push.core.e.aa <= 1000) {
                    com.igexin.c.a.c.a.a("PushController|bindAlias frequently called", new Object[0]);
                    return;
                }
                String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(currentTimeMillis4));
                if (com.igexin.push.core.e.Z != null) {
                    String str2 = com.igexin.push.core.e.Z;
                }
                if (!format.equals(com.igexin.push.core.e.Z)) {
                    com.igexin.push.core.e.f.a().d(format);
                    com.igexin.push.core.e.f.a().a(0);
                }
                int i6 = com.igexin.push.core.e.ab;
                com.igexin.c.a.c.a.a("-> CoreRuntimeInfo.opAliasTimes:" + com.igexin.push.core.e.ab, new Object[0]);
                if (com.igexin.push.core.e.ab < 100) {
                    com.igexin.c.a.c.a.a("start bindAlias ###", new Object[0]);
                    com.igexin.push.core.e.aa = currentTimeMillis4;
                    com.igexin.push.core.e.f.a().a(com.igexin.push.core.e.ab + 1);
                    m.a(string8, string9, false, true);
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
                if (TextUtils.isEmpty(com.igexin.push.core.e.A)) {
                    com.igexin.c.a.c.a.d.a().a("unbindAlias : " + string10 + ", failed, has not get clientid");
                    l.a().c(string11, "30005");
                    return;
                } else if (z8 && TextUtils.isEmpty(com.igexin.push.core.e.A)) {
                    return;
                } else {
                    long currentTimeMillis5 = System.currentTimeMillis();
                    long j2 = com.igexin.push.core.e.aa;
                    if (currentTimeMillis5 - com.igexin.push.core.e.aa <= 1000) {
                        com.igexin.c.a.c.a.a("PushController|unbindAlias frequently called", new Object[0]);
                        return;
                    }
                    String format2 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(currentTimeMillis5));
                    String str3 = com.igexin.push.core.e.Z;
                    if (!format2.equals(com.igexin.push.core.e.Z)) {
                        com.igexin.push.core.e.f.a().d(format2);
                        com.igexin.push.core.e.f.a().a(0);
                    }
                    int i7 = com.igexin.push.core.e.ab;
                    if (com.igexin.push.core.e.ab < 100) {
                        com.igexin.c.a.c.a.a("start unbindAlias ###", new Object[0]);
                        com.igexin.push.core.e.aa = currentTimeMillis5;
                        com.igexin.push.core.e.f.a().a(com.igexin.push.core.e.ab + 1);
                        m.a(string10, string11, true, z8);
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
                            pushTaskBean2.setAppid(com.igexin.push.core.e.f9887a);
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
                if (!n.d().equalsIgnoreCase(AssistUtils.BRAND_HW) && !n.d().equalsIgnoreCase(AssistUtils.BRAND_HON)) {
                    if (n.d().equalsIgnoreCase(AssistUtils.BRAND_OPPO)) {
                        com.igexin.push.f.d.c(bundle.getInt("badgeNum"), true);
                        return;
                    } else if (n.d().equalsIgnoreCase(AssistUtils.BRAND_VIVO)) {
                        com.igexin.push.f.d.b(bundle.getInt("badgeNum"), true);
                        return;
                    } else {
                        return;
                    }
                }
                com.igexin.push.f.d.a(bundle.getInt("badgeNum"), true);
                return;
            case true:
                com.igexin.push.config.e.a(bundle.getBoolean("guardMe", true), bundle.getBoolean("guardOthers", true));
                com.igexin.push.core.e.a();
                com.igexin.c.a.c.a.d.a().a("[PushController] setGuardOptions success");
                return;
            case true:
            case true:
                com.igexin.push.core.e.a();
                return;
            case true:
                com.igexin.push.core.e.aK = bundle.getString("smallIcon", "");
                com.igexin.push.core.e.aL = bundle.getString("largeIcon", "");
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new f.AnonymousClass19(com.igexin.push.core.e.aK, com.igexin.push.core.e.aL), false, true);
                com.igexin.c.a.c.a.d.a().a("[PushController] setNotificationIcon success");
                return;
            case true:
                String string13 = bundle.getString("sn");
                if (TextUtils.isEmpty(com.igexin.push.core.e.A)) {
                    return;
                }
                if (System.currentTimeMillis() - com.igexin.push.core.e.f9889c < com.igexin.push.config.d.f9767a * 1000 && com.igexin.push.core.e.d != null) {
                    String str4 = com.igexin.push.core.e.d;
                    com.igexin.c.a.c.a.a("PushController|query tag already cache, tag = " + com.igexin.push.core.e.d, new Object[0]);
                    l.a().a(string13, "0", com.igexin.push.core.e.d);
                    return;
                }
                try {
                    long currentTimeMillis6 = System.currentTimeMillis();
                    JSONObject jSONObject5 = new JSONObject();
                    try {
                        jSONObject5.put("action", "query_tag");
                        jSONObject5.put("id", String.valueOf(currentTimeMillis6));
                        jSONObject5.put("cid", com.igexin.push.core.e.A);
                        jSONObject5.put("appid", com.igexin.push.core.e.f9887a);
                        jSONObject5.put("sn", string13);
                    } catch (Exception e4) {
                        com.igexin.c.a.c.a.a(e4);
                    }
                    String jSONObject6 = jSONObject5.toString();
                    com.igexin.push.core.e.e.a().b(new com.igexin.push.core.b.l(currentTimeMillis6, jSONObject6, (byte) 11, currentTimeMillis6));
                    com.igexin.push.c.c.o oVar2 = new com.igexin.push.c.c.o();
                    oVar2.f9726c = 128;
                    oVar2.e = com.igexin.push.core.b.K;
                    oVar2.f = jSONObject6;
                    d.a.a().h.a("C-" + com.igexin.push.core.e.A, oVar2, false);
                    com.igexin.push.core.e.f a3 = com.igexin.push.core.e.f.a();
                    if (com.igexin.push.core.e.f9889c != currentTimeMillis6) {
                        com.igexin.push.core.e.f9889c = currentTimeMillis6;
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
                String string14 = bundle.getString("token", "");
                if (!TextUtils.isEmpty(string14)) {
                    com.igexin.push.core.e.J = true;
                    if (!string14.equals(com.igexin.push.core.e.I)) {
                        com.igexin.push.core.e.f.a().b(string14);
                        if (com.igexin.push.core.e.u) {
                            com.igexin.c.a.c.a.b("PushController", "online, send addphoneinfo");
                            d().i();
                        }
                    }
                }
                com.igexin.c.a.c.a.d.a().a("[PushController] setDeviceToken success ".concat(String.valueOf(string14)));
                return;
            default:
                return;
        }
        com.igexin.c.a.c.a.a(th);
    }

    public static void a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("action", com.igexin.push.core.b.B);
            jSONObject.put("id", str);
        } catch (JSONException e) {
            com.igexin.c.a.c.a.a(e);
        }
        String jSONObject2 = jSONObject.toString();
        com.igexin.push.c.c.o oVar = new com.igexin.push.c.c.o();
        oVar.f9726c = 128;
        ((com.igexin.push.c.c.b) oVar).b = (int) System.currentTimeMillis();
        oVar.e = com.igexin.push.core.b.K;
        oVar.f = jSONObject2;
        oVar.h = com.igexin.push.core.e.A;
        com.igexin.push.d.a aVar = d.a.a().h;
        aVar.a("C-" + com.igexin.push.core.e.A, oVar, false);
    }

    private static void a(String str, String str2, String str3, String str4) {
        l.a().a(str, str2, str3, str4);
    }

    public static boolean a(String str, String str2, String str3) {
        return com.igexin.push.core.n.a().a(str, str2, str3);
    }

    private static boolean a(JSONObject jSONObject, PushTaskBean pushTaskBean) {
        return com.igexin.push.core.n.a().a(jSONObject, pushTaskBean);
    }

    public static void b(Intent intent) {
        if (intent == null || !intent.hasExtra("isSlave")) {
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("isSlave", false);
        com.igexin.c.a.c.a.a("CoreAction|onServiceInitializeForSlave isSlave =".concat(String.valueOf(booleanExtra)), new Object[0]);
        if (booleanExtra) {
            d.a.a();
            com.igexin.push.core.d.a(true);
            com.igexin.push.core.e.N = intent.hasExtra("op_app") ? intent.getStringExtra("op_app") : "";
            if (com.igexin.push.core.e.u) {
                l.a().c();
            }
        }
    }

    public static void b(String str) {
        com.igexin.c.a.c.a.a("CoreAction|resetDelayTime from = ".concat(String.valueOf(str)), new Object[0]);
        if (com.igexin.push.core.e.O <= 10000 && com.igexin.push.core.e.O != 0) {
            long j = com.igexin.push.core.e.O;
            com.igexin.c.a.c.a.a("CoreAction|resetDelayTime ignore, delay = " + com.igexin.push.core.e.O, new Object[0]);
            return;
        }
        int random = (int) ((Math.random() * 100.0d) + 1000.0d);
        long j2 = com.igexin.push.core.e.O;
        com.igexin.c.a.c.a.a("CoreAction|reConnectDelayTime = " + com.igexin.push.core.e.O + ", reset = " + random, new Object[0]);
        com.igexin.push.e.b.e.g().a((long) random);
    }

    private static void c(Intent intent) {
        if (intent == null || intent.getAction() == null) {
            return;
        }
        try {
            String action = intent.getAction();
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                e();
            } else if (com.igexin.push.core.b.H.equals(action)) {
                com.igexin.push.core.n.a().a(intent);
            } else if ("android.intent.action.TIME_SET".equals(action)) {
                if (com.igexin.push.config.d.f9768c != 0) {
                    com.igexin.push.e.f.c().d();
                }
            } else if (!Intent.ACTION_SCREEN_ON.equals(action)) {
                if (Intent.ACTION_SCREEN_OFF.equals(action)) {
                    com.igexin.push.core.e.y = 0;
                }
            } else {
                com.igexin.push.core.e.y = 1;
                com.igexin.push.core.n.a();
                if (com.igexin.push.core.n.b()) {
                    com.igexin.push.core.n.a().d();
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    b("screen on");
                }
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public static b d() {
        if (d == null) {
            synchronized (b.class) {
                try {
                    if (d == null) {
                        d = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return d;
    }

    public static void e() {
        d.a.a();
        com.igexin.push.d.a.e();
        com.igexin.push.core.n.a();
        if (com.igexin.push.core.n.b()) {
            com.igexin.c.a.c.a.a("CoreAction|network changed check condition status", new Object[0]);
            com.igexin.push.core.n.a().d();
        }
    }

    public static int f() {
        com.igexin.c.a.c.a.a("CoreAction|send heart beat data ........", new Object[0]);
        com.igexin.push.d.a aVar = d.a.a().h;
        return aVar.a("H-" + com.igexin.push.core.e.A, new com.igexin.push.c.c.f(), true);
    }

    public static void g() {
        try {
            for (com.igexin.push.core.b.l lVar : com.igexin.push.core.e.e.a().f9898a) {
                if (lVar.e >= com.igexin.push.config.d.N - 1) {
                    com.igexin.c.a.c.a.a("CoreAction|data.getSendTimes=" + lVar.e + " id=" + lVar.f9840a, new Object[0]);
                } else if (lVar.d + 20000 <= System.currentTimeMillis()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject(lVar.b);
                    com.igexin.push.c.c.b bVar = new com.igexin.push.c.c.b();
                    bVar.f9726c = 128;
                    bVar.b = (int) currentTimeMillis;
                    bVar.e = com.igexin.push.core.b.K;
                    if (jSONObject.has("extraData")) {
                        bVar.g = Base64.decode(jSONObject.optString("extraData").getBytes(), 0);
                        jSONObject.remove("extraData");
                    }
                    bVar.f = lVar.b;
                    bVar.h = com.igexin.push.core.e.A;
                    com.igexin.c.a.c.a.a("freshral|" + lVar.b, new Object[0]);
                    com.igexin.push.core.e.e a2 = com.igexin.push.core.e.e.a();
                    long j = lVar.f9840a;
                    long currentTimeMillis2 = System.currentTimeMillis();
                    com.igexin.push.core.b.l a3 = a2.a(j);
                    if (a3 != null) {
                        a3.d = currentTimeMillis2;
                        a3.e++;
                        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new e.AnonymousClass3(com.igexin.push.core.e.e.a(a3), j), true, true);
                    }
                    d.a.a().h.a("C-" + com.igexin.push.core.e.A, bVar, false);
                    return;
                }
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public static void h() {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("action", "request_deviceid");
            jSONObject.put("id", String.valueOf(currentTimeMillis));
        } catch (JSONException e) {
            com.igexin.c.a.c.a.a(e);
        }
        String jSONObject2 = jSONObject.toString();
        com.igexin.push.c.c.b bVar = new com.igexin.push.c.c.b();
        bVar.f9726c = 128;
        bVar.b = (int) currentTimeMillis;
        bVar.e = com.igexin.push.core.b.K;
        bVar.f = jSONObject2;
        bVar.h = com.igexin.push.core.e.A;
        com.igexin.push.d.a aVar = d.a.a().h;
        aVar.a("C-" + com.igexin.push.core.e.A, bVar, false);
        com.igexin.c.a.c.a.a("CoreAction|deviceidReq", new Object[0]);
    }

    public static void j() {
        if (!com.igexin.push.core.e.W || com.igexin.push.core.e.X >= System.currentTimeMillis()) {
            return;
        }
        com.igexin.push.core.e.f.a().a(false);
    }

    public static void k() {
        if (!com.igexin.push.core.e.ae) {
            com.igexin.push.core.e.ae = com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.e.b.b.g(), false, true);
        }
        if (!com.igexin.push.core.e.af) {
            com.igexin.push.core.e.af = com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.e.b.e.g(), true, true);
        }
        if (com.igexin.push.core.e.ag) {
            return;
        }
        d.a.a().c();
    }

    private static boolean l() {
        return false;
    }

    private static void m() {
        com.igexin.push.f.c.d();
    }

    @Override // com.igexin.push.core.a.a
    public final void a() {
    }

    @Override // com.igexin.push.d.b
    public final boolean a(com.igexin.push.c.c.c cVar) {
        if (cVar != null) {
            a aVar = f9789c.get(cVar.m);
            cVar.getClass().getName();
            com.igexin.c.a.c.a.a("CoreAction|receive : " + cVar.getClass().getName() + " resp ~~~~", new Object[0]);
            if ((cVar instanceof h) || (cVar instanceof k) || (cVar instanceof com.igexin.push.c.c.m) || (cVar instanceof p) || (cVar instanceof com.igexin.push.c.c.f) || (cVar instanceof q)) {
                com.igexin.c.a.b.a.a.d.a().a(cVar.getClass().getName());
            }
            if ((cVar instanceof k) || (cVar instanceof com.igexin.push.c.c.m) || (cVar instanceof p)) {
                com.igexin.push.core.e.O = 0L;
                com.igexin.push.b.c.a().d().b();
            }
            if (aVar != null) {
                aVar.a(cVar);
            }
            com.igexin.push.e.b.b.g().h();
            return true;
        }
        return false;
    }

    @Override // com.igexin.push.core.a.a
    public final boolean a(Object obj) {
        com.igexin.push.d.a aVar = d.a.a().h;
        if ((obj instanceof com.igexin.push.c.c.c) && aVar != null) {
            com.igexin.push.d.a.a((com.igexin.push.c.c.c) obj);
            return false;
        } else if (obj instanceof com.igexin.push.c.b.b) {
            com.igexin.c.a.c.a.a("CoreAction|TcpExceptionNotify###", new Object[0]);
            com.igexin.push.b.c.a().d().c();
            com.igexin.push.b.a d2 = com.igexin.push.b.c.a().d();
            com.igexin.push.core.j.a().a(j.a.f9959c);
            d2.f();
            if (com.igexin.push.d.a.d()) {
                com.igexin.c.a.c.a.a(com.igexin.push.d.a.f9983a, "sdkOn = false or pushOn = false, disconect|user");
                com.igexin.c.a.c.a.a(com.igexin.push.d.a.f9983a + "|sdkOn = false or pushOn = false, disconect|user", new Object[0]);
            } else {
                com.igexin.c.a.c.a.a(com.igexin.push.d.a.f9983a + "|disconnect by network", new Object[0]);
            }
            com.igexin.c.a.d.e<com.igexin.c.a.d.f> eVar = com.igexin.c.a.b.e.a().s;
            if (eVar != null) {
                eVar.a(com.igexin.c.a.b.a.a.f.class);
            }
            com.igexin.push.d.a.a(false);
            return false;
        } else if (obj instanceof com.igexin.push.c.b.a) {
            com.igexin.c.a.c.a.a("CoreAction|TcpDisconnectSuccessNotify ###", new Object[0]);
            if (com.igexin.push.core.e.u) {
                com.igexin.push.core.e.u = false;
                com.igexin.c.a.c.a.a("CoreAction|broadcast online state = offline", new Object[0]);
                l.a().b();
            }
            com.igexin.push.c.a.c.b = -1;
            if (com.igexin.push.core.e.q) {
                com.igexin.c.a.c.a.a(com.igexin.push.d.a.f9983a, "isAppidWrong = true");
                com.igexin.c.a.c.a.a(com.igexin.push.d.a.f9983a + "|isAppidWrong = true", new Object[0]);
                com.igexin.c.a.c.a.d.a().a("isAppidWrong = true");
                return false;
            } else if (!g.a()) {
                com.igexin.c.a.c.a.a(com.igexin.push.d.a.f9983a, "so error ++++++++");
                com.igexin.c.a.c.a.a(com.igexin.push.d.a.f9983a + "|so error ++++++++", new Object[0]);
                return false;
            } else if (com.igexin.push.core.e.az) {
                com.igexin.push.d.a.c();
                return false;
            } else {
                com.igexin.c.a.c.a.a(com.igexin.push.d.a.f9983a, "initSuccess = false");
                com.igexin.c.a.c.a.a(com.igexin.push.d.a.f9983a + "|initSuccess = false", new Object[0]);
                return false;
            }
        } else {
            return false;
        }
    }

    @Override // com.igexin.push.core.a.a
    public final void b() {
    }

    public final void i() {
        try {
            if ((System.currentTimeMillis() - com.igexin.push.core.e.Q) - 86400000 > 0) {
                com.igexin.push.core.e.f.a().b(0);
                com.igexin.push.core.e.f.a().c(System.currentTimeMillis());
            }
            com.igexin.c.a.c.a.b(b, "sendAddphoneinfo.deviceToken" + com.igexin.push.core.e.I);
            if (com.igexin.push.core.e.aA <= 5) {
                com.igexin.push.core.e.f.a().b(com.igexin.push.core.e.aA + 1);
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.e.d() { // from class: com.igexin.push.core.a.b.1

                    /* renamed from: c  reason: collision with root package name */
                    private boolean f9791c = true;

                    @Override // com.igexin.push.e.d
                    public final void b() {
                        n.n();
                        try {
                            com.igexin.push.core.b.a aVar = new com.igexin.push.core.b.a();
                            long j = aVar.n;
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("model", aVar.f9821a == null ? "" : aVar.f9821a);
                            jSONObject.put("sim", aVar.b == null ? "" : aVar.b);
                            jSONObject.put(ExHandler.JSON_REQUEST_IMEI, aVar.f9822c == null ? "" : aVar.f9822c);
                            jSONObject.put("mac", aVar.d == null ? "" : n.c());
                            jSONObject.put("version", aVar.e == null ? "" : aVar.e);
                            jSONObject.put("channelid", aVar.f == null ? "" : aVar.f);
                            jSONObject.put("type", "ANDROID");
                            jSONObject.put("app", aVar.k == null ? "" : aVar.k);
                            StringBuilder sb = new StringBuilder("ANDROID-");
                            sb.append(aVar.g == null ? "" : aVar.g);
                            jSONObject.put("deviceid", sb.toString());
                            jSONObject.put(RemoteMessageConst.DEVICE_TOKEN, aVar.l == null ? "" : aVar.l);
                            jSONObject.put("brand", aVar.m == null ? "" : aVar.m);
                            jSONObject.put("system_version", aVar.j == null ? "" : aVar.j);
                            jSONObject.put("cell", aVar.i == null ? "" : aVar.i);
                            jSONObject.put("aid", n.i());
                            jSONObject.put(OapsKey.KEY_ADID, n.j());
                            jSONObject.put("gtcid", TextUtils.isEmpty(aVar.o) ? "" : aVar.o);
                            jSONObject.put("oaid", com.igexin.push.core.e.h == null ? "" : com.igexin.push.core.e.h);
                            ServiceManager.getInstance();
                            String e = ServiceManager.e(com.igexin.push.core.e.l);
                            if (!com.igexin.push.core.b.al.equals(e)) {
                                jSONObject.put(o.f10055a, e);
                            }
                            ServiceManager.getInstance();
                            jSONObject.put("ua", ServiceManager.d(com.igexin.push.core.e.l));
                            jSONObject.put("notification_enabled", com.igexin.push.f.c.b(com.igexin.push.core.e.l) ? 1 : 0);
                            jSONObject.put("installChannel", com.igexin.c.b.a.b(com.igexin.push.core.e.b, "").replaceAll("\\|", ""));
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("action", "addphoneinfo");
                            jSONObject2.put("id", String.valueOf(aVar.n));
                            jSONObject2.put("info", jSONObject);
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("guardMe", String.valueOf(com.igexin.push.config.e.b()));
                            jSONObject3.put("guardOthers", String.valueOf(com.igexin.push.config.e.c()));
                            jSONObject2.put("extra", jSONObject3);
                            String jSONObject4 = jSONObject2.toString();
                            com.igexin.c.a.c.a.a("addphoneinfo |  ".concat(String.valueOf(jSONObject4)), new Object[0]);
                            com.igexin.push.core.e.e a2 = com.igexin.push.core.e.e.a();
                            if (a2 != null) {
                                a2.b(new com.igexin.push.core.b.l(j, jSONObject4, (byte) 5, j));
                            }
                            com.igexin.push.c.c.b bVar = new com.igexin.push.c.c.b();
                            bVar.f9726c = 128;
                            bVar.b = (int) j;
                            bVar.e = com.igexin.push.core.b.K;
                            bVar.f = jSONObject4;
                            bVar.h = com.igexin.push.core.e.A;
                            com.igexin.push.d.a aVar2 = d.a.a().h;
                            aVar2.a("C-" + com.igexin.push.core.e.A, bVar, false);
                            if (com.igexin.c.b.a.a(com.igexin.push.core.e.K, com.igexin.push.core.e.I)) {
                                return;
                            }
                            com.igexin.push.core.e.f.a().c(com.igexin.push.core.e.I);
                        } catch (Throwable th) {
                            com.igexin.c.a.c.a.a(th);
                        }
                    }
                }, false, true);
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }
}
