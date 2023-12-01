package com.anythink.expressad.advanced.js;

import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebView;
import com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils;
import com.anythink.expressad.atsignalcommon.windvane.j;
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

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/advanced/js/NativeAdvancedJsUtils.class */
public class NativeAdvancedJsUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7046a = "onViewDisappeared";
    public static final String b = "onViewAppeared";

    /* renamed from: c  reason: collision with root package name */
    public static final String f7047c = "onSystemDestory";
    public static final String d = "setStyleList";
    public static final String e = "params";
    public static final String f = "showCloseButton";
    public static final String g = "hideCloseButton";
    public static final String h = "setVolume";
    public static final String i = "mute";
    public static final String j = "setVideoPlayMode";
    public static final String k = "autoPlay";
    public static final String l = "onNetstatChanged";
    public static final String m = "netstat";
    public static final String n = "sq";
    public static final String o = "thirdPartyCalled";
    public static final String p = "action";
    public static final String q = "params";
    private static String r = "NativeAdvancedJsUtils";

    public static void callbackSuccess(Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", CommonJSBridgeImpUtils.b);
            j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            o.a(r, e2.getMessage());
        }
    }

    public static void fireOnJSBridgeConnected(WebView webView) {
        o.d(r, "fireOnJSBridgeConnected");
        j.a();
        j.b(webView);
    }

    /* JADX WARN: Not initialized variable reg: 13, insn: 0x04e2: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r13 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:173:0x04e2 */
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
                o.a(r, e2.getMessage());
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
                            for (int i2 = 0; i2 < length; i2++) {
                                str4 = "message";
                                str5 = "code";
                                JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
                                String optString = jSONObject3.optString(OapsKey.KEY_REF, "");
                                int i3 = jSONObject3.getInt("type");
                                JSONObject jSONObject4 = new JSONObject();
                                if (i3 != 1 || TextUtils.isEmpty(optString)) {
                                    String str6 = "";
                                    if (i3 == 2 && !TextUtils.isEmpty(optString)) {
                                        JSONObject jSONObject5 = new JSONObject();
                                        jSONObject5.put("type", 2);
                                        if (i.a().c(optString) != null) {
                                            str6 = i.a().c(optString);
                                        }
                                        jSONObject5.put(OapsWrapper.KEY_PATH, str6);
                                        jSONObject4.put(optString, jSONObject5);
                                        jSONArray2.put(jSONObject4);
                                    } else if (i3 == 3 && !TextUtils.isEmpty(optString)) {
                                        File file = new File(optString);
                                        if (file.exists() && file.isFile() && file.canRead()) {
                                            o.a(r, "getFileInfo Mraid file ".concat(String.valueOf(optString)));
                                            str6 = "file:////".concat(String.valueOf(optString));
                                        }
                                        JSONObject jSONObject6 = new JSONObject();
                                        jSONObject6.put("type", 3);
                                        jSONObject6.put(OapsWrapper.KEY_PATH, str6);
                                        jSONObject4.put(optString, jSONObject6);
                                        jSONArray2.put(jSONObject4);
                                    } else if (i3 == 4 && !TextUtils.isEmpty(optString)) {
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
                                        o.a(r, "VideoBean not null");
                                        jSONObject8.put("type", 1);
                                        jSONObject8.put("videoDataLength", b2.d());
                                        String b3 = b2.b();
                                        if (TextUtils.isEmpty(b3)) {
                                            o.a(r, "VideoPath null");
                                            jSONObject8.put(OapsWrapper.KEY_PATH, "");
                                            jSONObject8.put("path4Web", "");
                                        } else {
                                            o.a(r, "VideoPath not null");
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
                                        o.a(r, "VideoBean null");
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
                            o.a(r, e3.getMessage());
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
                        o.a(r, e.getMessage());
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

    public static void sendEventToH5(WebView webView, String str, String str2) {
        j.a();
        j.a(webView, str, str2);
    }

    public static void sendThirdToH5(WebView webView, String str, String str2, Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(n, 1);
            jSONObject.put("action", str);
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(str2, obj);
                jSONObject.put("params", jSONObject2);
            }
            if (TextUtils.isEmpty(str2) && obj != null) {
                jSONObject.put("params", obj);
            }
            j.a();
            j.a(webView, o, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
