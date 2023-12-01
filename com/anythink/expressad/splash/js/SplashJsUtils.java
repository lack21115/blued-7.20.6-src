package com.anythink.expressad.splash.js;

import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebView;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.g.a.f;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.s;
import com.anythink.expressad.videocommon.b.a;
import com.anythink.expressad.videocommon.b.i;
import com.cdo.oaps.ad.OapsKey;
import com.cdo.oaps.ad.OapsWrapper;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/splash/js/SplashJsUtils.class */
public class SplashJsUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5405a = "onSystemPause";
    public static final String b = "onSystemResume";

    /* renamed from: c  reason: collision with root package name */
    public static final String f5406c = "onSystemDestory";
    private static String d = "SplashJsUtils";
    private static int e = 0;
    private static int f = 1;

    static /* synthetic */ void a(String str, c cVar) {
        if (f.o == null || TextUtils.isEmpty(cVar.aZ())) {
            return;
        }
        f.a(str, cVar, f.f);
    }

    private static void b(String str, c cVar) {
        if (f.o == null || TextUtils.isEmpty(cVar.aZ())) {
            return;
        }
        f.a(str, cVar, f.f);
    }

    public static void callbackExcep(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", f);
            jSONObject.put("message", str);
            jSONObject.put("data", new JSONObject());
            j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            o.a(d, e2.getMessage());
        }
    }

    public static void callbackSuccess(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", e);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", str);
            jSONObject.put("data", jSONObject2);
            j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            callbackExcep(obj, e2.getMessage());
            o.a(d, e2.getMessage());
        }
    }

    public static String codeToJsonString(int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            String jSONObject2 = jSONObject.toString();
            return !TextUtils.isEmpty(jSONObject2) ? Base64.encodeToString(jSONObject2.getBytes(), 2) : "";
        } catch (Throwable th) {
            o.d(d, "code to string is error");
            return "";
        }
    }

    public static void fireOnJSBridgeConnected(WebView webView) {
        o.d(d, "fireOnJSBridgeConnected");
        j.a();
        j.b(webView);
    }

    /* JADX WARN: Not initialized variable reg: 13, insn: 0x04e1: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r13 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:173:0x04e1 */
    public static void getFileInfo(Object obj, JSONObject jSONObject) {
        String str;
        String str2;
        String str3;
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            try {
                jSONObject2.put("code", 1);
                jSONObject2.put("message", "params is null");
                j.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                return;
            } catch (JSONException e2) {
                o.a(d, e2.getMessage());
                return;
            }
        }
        try {
            jSONObject2.put("code", 0);
            jSONObject2.put("message", "");
            JSONArray jSONArray = jSONObject.getJSONArray("resource");
            try {
                if (jSONArray != null) {
                    String str4 = "message";
                    String str5 = "code";
                    try {
                        if (jSONArray.length() > 0) {
                            JSONArray jSONArray2 = new JSONArray();
                            int length = jSONArray.length();
                            for (int i = 0; i < length; i++) {
                                str4 = "message";
                                str5 = "code";
                                JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                                String optString = jSONObject3.optString(OapsKey.KEY_REF, "");
                                int i2 = jSONObject3.getInt("type");
                                JSONObject jSONObject4 = new JSONObject();
                                if (i2 != 1 || TextUtils.isEmpty(optString)) {
                                    String str6 = "";
                                    if (i2 == 2 && !TextUtils.isEmpty(optString)) {
                                        JSONObject jSONObject5 = new JSONObject();
                                        jSONObject5.put("type", 2);
                                        if (i.a().c(optString) != null) {
                                            str6 = i.a().c(optString);
                                        }
                                        jSONObject5.put(OapsWrapper.KEY_PATH, str6);
                                        jSONObject4.put(optString, jSONObject5);
                                        jSONArray2.put(jSONObject4);
                                    } else if (i2 == 3 && !TextUtils.isEmpty(optString)) {
                                        File file = new File(optString);
                                        if (file.exists() && file.isFile() && file.canRead()) {
                                            o.a(d, "getFileInfo Mraid file ".concat(String.valueOf(optString)));
                                            str6 = "file:////".concat(String.valueOf(optString));
                                        }
                                        JSONObject jSONObject6 = new JSONObject();
                                        jSONObject6.put("type", 3);
                                        jSONObject6.put(OapsWrapper.KEY_PATH, str6);
                                        jSONObject4.put(optString, jSONObject6);
                                        jSONArray2.put(jSONObject4);
                                    } else if (i2 == 4 && !TextUtils.isEmpty(optString)) {
                                        JSONObject jSONObject7 = new JSONObject();
                                        jSONObject7.put("type", 4);
                                        if (s.a(optString) != null) {
                                            str6 = s.a(optString);
                                        }
                                        jSONObject7.put(OapsWrapper.KEY_PATH, str6);
                                        jSONObject4.put(optString, jSONObject7);
                                        jSONArray2.put(jSONObject4);
                                    }
                                } else {
                                    JSONObject jSONObject8 = new JSONObject();
                                    a.a();
                                    com.anythink.core.common.a.i b2 = a.b(optString);
                                    if (b2 != null) {
                                        o.a(d, "VideoBean not null");
                                        jSONObject8.put("type", 1);
                                        jSONObject8.put("videoDataLength", b2.d());
                                        String b3 = b2.b();
                                        if (TextUtils.isEmpty(b3)) {
                                            o.a(d, "VideoPath null");
                                            jSONObject8.put(OapsWrapper.KEY_PATH, "");
                                            jSONObject8.put("path4Web", "");
                                        } else {
                                            o.a(d, "VideoPath not null");
                                            jSONObject8.put(OapsWrapper.KEY_PATH, b3);
                                            jSONObject8.put("path4Web", b3);
                                        }
                                        if (b2.c() == 100) {
                                            jSONObject8.put("downloaded", 1);
                                        } else {
                                            jSONObject8.put("downloaded", 0);
                                        }
                                        jSONObject4.put(optString, jSONObject8);
                                        jSONArray2.put(jSONObject4);
                                    } else {
                                        o.a(d, "VideoBean null");
                                    }
                                }
                            }
                            jSONObject2.put("resource", jSONArray2);
                            j.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                            return;
                        }
                    } catch (Throwable th) {
                        th = th;
                        str = str4;
                        str2 = str5;
                        try {
                            jSONObject2.put(str2, 1);
                            jSONObject2.put(str, th.getLocalizedMessage());
                            j.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                        } catch (JSONException e3) {
                            o.a(d, e3.getMessage());
                            return;
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                str = str3;
            }
            try {
                try {
                    jSONObject2.put("code", 1);
                    try {
                        jSONObject2.put("message", "resource is null");
                        j.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                    } catch (JSONException e4) {
                        e = e4;
                        o.a(d, e.getMessage());
                    }
                } catch (JSONException e5) {
                    e = e5;
                }
            } catch (Throwable unused) {
                str = "message";
                th = "message";
                str2 = "code";
                jSONObject2.put(str2, 1);
                jSONObject2.put(str, th.getLocalizedMessage());
                j.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            }
        } catch (Throwable th3) {
            th = th3;
            str = "message";
            str2 = "code";
        }
    }

    public static void increaseOfferFrequence(Object obj, JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                callbackExcep(obj, "data is empty");
                return;
            }
            c b2 = c.b(optJSONObject);
            if (b2 == null) {
                callbackExcep(obj, "data camapign is empty");
                return;
            }
            updateFrequence(b2);
            callbackSuccess(obj, "");
        } catch (Throwable th) {
            callbackExcep(obj, th.getMessage());
        }
    }

    public static void sendEventToH5(WebView webView, String str, String str2) {
        j.a();
        j.a(webView, str, str2);
    }

    public static void updateFrequence(final c cVar) {
        new Thread(new Runnable() { // from class: com.anythink.expressad.splash.js.SplashJsUtils.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SplashJsUtils.a(c.this.K(), c.this);
                } catch (Throwable th) {
                    o.b(SplashJsUtils.d, th.getMessage(), th);
                }
            }
        }).start();
    }
}
