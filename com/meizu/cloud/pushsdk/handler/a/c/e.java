package com.meizu.cloud.pushsdk.handler.a.c;

import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.handler.MzPushMessage;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/meizu/cloud/pushsdk/handler/a/c/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private int f10532a;
    private String b = String.valueOf(-1);

    /* renamed from: c  reason: collision with root package name */
    private String f10533c = "";
    private String d = "";
    private int e = -1;
    private String f = "";

    /* loaded from: source-8303388-dex2jar.jar:com/meizu/cloud/pushsdk/handler/a/c/e$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f10534a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        String f10535c;

        public a(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull("code")) {
                    a(jSONObject.getString("code"));
                }
                if (!jSONObject.isNull("message")) {
                    b(jSONObject.getString("message"));
                }
                if (jSONObject.isNull("value")) {
                    return;
                }
                c(jSONObject.getString("value"));
            } catch (JSONException e) {
                DebugLogger.e("SecurityMessage", "covert json error " + e.getMessage());
            }
        }

        public String a() {
            return this.f10535c;
        }

        public void a(String str) {
            this.f10534a = str;
        }

        public void b(String str) {
            this.b = str;
        }

        public void c(String str) {
            this.f10535c = str;
        }

        public String toString() {
            return "PublicKeyStatus{code='" + this.f10534a + "', message='" + this.b + "', publicKey='" + this.f10535c + "'}";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r0v21, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v44, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.String] */
    public static String a(MessageV3 messageV3) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        String notificationMessage = messageV3.getNotificationMessage();
        JSONObject jSONObject3 = null;
        try {
            try {
                if (!TextUtils.isEmpty(notificationMessage)) {
                    try {
                        JSONObject jSONObject4 = new JSONObject(notificationMessage).getJSONObject("data");
                        jSONObject2 = null;
                        if (!jSONObject4.isNull("extra")) {
                            jSONObject3 = jSONObject4.getJSONObject("extra");
                            jSONObject2 = null;
                            if (!jSONObject3.isNull("se")) {
                                jSONObject2 = jSONObject3.getString("se");
                            }
                        }
                        jSONObject3 = jSONObject2;
                    } catch (JSONException e) {
                        DebugLogger.e("SecurityMessage", "parse notification message error " + e.getMessage());
                        jSONObject3 = null;
                        if (TextUtils.isEmpty(null)) {
                            jSONObject = new JSONObject(notificationMessage);
                            jSONObject2 = null;
                        }
                    }
                    if (TextUtils.isEmpty(jSONObject2)) {
                        jSONObject = new JSONObject(notificationMessage);
                        jSONObject3 = jSONObject2;
                        jSONObject3 = jSONObject.getString("se");
                    }
                }
            } catch (Throwable th) {
                if (TextUtils.isEmpty(null)) {
                    try {
                        new JSONObject(notificationMessage).getString("se");
                    } catch (Exception e2) {
                    }
                }
                throw th;
            }
        } catch (Exception e3) {
        }
        DebugLogger.i("SecurityMessage", "encrypt message " + jSONObject3);
        return jSONObject3;
    }

    public static boolean a(String str, MessageV3 messageV3) {
        String str2;
        e e = e(str);
        DebugLogger.e("SecurityMessage", "securityMessage " + e);
        if (System.currentTimeMillis() / 1000 > e.a()) {
            str2 = "message expire";
        } else if (!messageV3.getTitle().contains(e.c())) {
            str2 = "invalid title";
        } else if (!messageV3.getContent().contains(e.d())) {
            str2 = "invalid content";
        } else if (!String.valueOf(-1).equals(e.b()) && !e.b().equals(messageV3.getTaskId())) {
            str2 = "invalid taskId";
        } else if (e.e() != -1) {
            int e2 = e.e();
            if (e2 != 1) {
                if (e2 != 2) {
                    if (e2 != 3 || MzPushMessage.fromMessageV3(messageV3).getSelfDefineContentString().contains(e.f())) {
                        return true;
                    }
                    str2 = "invalid self define";
                } else if (messageV3.getWebUrl().contains(e.f())) {
                    return true;
                } else {
                    str2 = "invalid web url";
                }
            } else if (messageV3.getActivity().contains(e.f())) {
                return true;
            } else {
                str2 = "invalid click activity";
            }
        } else {
            str2 = "invalid click type";
        }
        DebugLogger.e("SecurityMessage", str2);
        return false;
    }

    private static e e(String str) {
        e eVar = new e();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull("tt")) {
                eVar.a(jSONObject.getInt("tt"));
            }
            if (!jSONObject.isNull("ti")) {
                eVar.a(jSONObject.getString("ti"));
            }
            if (!jSONObject.isNull("tl")) {
                eVar.b(jSONObject.getString("tl"));
            }
            if (!jSONObject.isNull("cont")) {
                eVar.c(jSONObject.getString("cont"));
            }
            if (!jSONObject.isNull(com.anythink.expressad.d.a.b.dx)) {
                eVar.b(jSONObject.getInt(com.anythink.expressad.d.a.b.dx));
            }
            if (!jSONObject.isNull("pm")) {
                eVar.d(jSONObject.getString("pm"));
                return eVar;
            }
        } catch (Exception e) {
            DebugLogger.e("SecurityMessage", "parse decryptSign error " + e.getMessage());
        }
        return eVar;
    }

    public int a() {
        return this.f10532a;
    }

    public void a(int i) {
        this.f10532a = i;
    }

    public void a(String str) {
        this.b = str;
    }

    public String b() {
        return this.b;
    }

    public void b(int i) {
        this.e = i;
    }

    public void b(String str) {
        this.f10533c = str;
    }

    public String c() {
        return this.f10533c;
    }

    public void c(String str) {
        this.d = str;
    }

    public String d() {
        return this.d;
    }

    public void d(String str) {
        this.f = str;
    }

    public int e() {
        return this.e;
    }

    public String f() {
        return this.f;
    }

    public String toString() {
        return "SecurityMessage{timestamp=" + this.f10532a + ", taskId='" + this.b + "', title='" + this.f10533c + "', content='" + this.d + "', clickType=" + this.e + ", params='" + this.f + "'}";
    }
}
