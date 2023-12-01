package com.anythink.expressad.video.bt.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.anythink.core.common.a.i;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.u;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.g.a.f;
import com.anythink.expressad.foundation.h.h;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.s;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.video.bt.module.ATTempContainer;
import com.anythink.expressad.video.bt.module.AnythinkBTContainer;
import com.anythink.expressad.video.bt.module.AnythinkBTLayout;
import com.anythink.expressad.video.bt.module.AnythinkBTNativeEC;
import com.anythink.expressad.video.bt.module.AnythinkBTVideoView;
import com.anythink.expressad.video.bt.module.AnythinkBTWebView;
import com.anythink.expressad.video.bt.module.BTBaseView;
import com.anythink.expressad.videocommon.e.d;
import com.cdo.oaps.ad.OapsKey;
import com.cdo.oaps.ad.OapsWrapper;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.huawei.openalliance.ad.constant.ao;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/bt/a/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final int f5450a = -999;
    private static final String b = "OperateViews";

    /* renamed from: c  reason: collision with root package name */
    private static ConcurrentHashMap<String, LinkedHashMap<String, View>> f5451c = new ConcurrentHashMap<>();
    private static LinkedHashMap<String, String> d = new LinkedHashMap<>();
    private static LinkedHashMap<String, com.anythink.expressad.foundation.d.c> e = new LinkedHashMap<>();
    private static LinkedHashMap<String, d> f = new LinkedHashMap<>();
    private static LinkedHashMap<String, String> g = new LinkedHashMap<>();
    private static LinkedHashMap<String, Integer> h = new LinkedHashMap<>();
    private static LinkedHashMap<String, Activity> i = new LinkedHashMap<>();
    private static volatile int j = 10000;
    private static int k = 0;
    private static int l = 1;
    private static String m = "";
    private static int n;
    private static int o;
    private static int p;
    private static int q;
    private static int r;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/bt/a/c$a.class */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static c f5456a = new c((byte) 0);

        private a() {
        }
    }

    private c() {
    }

    /* synthetic */ c(byte b2) {
        this();
    }

    public static void E(Object obj, JSONObject jSONObject) {
        try {
            jSONObject.optString("unitId");
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
        }
    }

    public static void I(Object obj, JSONObject jSONObject) {
        try {
            jSONObject.optString("unitId");
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
        }
    }

    public static void J(Object obj, JSONObject jSONObject) {
        try {
            jSONObject.optString("unitId");
            jSONObject.optString("id");
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
            } else {
                c(obj, "android mediaPlayer not support setScaleType");
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
        }
    }

    public static void P(Object obj, JSONObject jSONObject) {
        String str;
        String str2;
        String str3 = "message";
        JSONObject jSONObject2 = new JSONObject();
        String str4 = str3;
        String str5 = "code";
        try {
            jSONObject2.put("code", 0);
            jSONObject2.put("message", "");
            JSONArray jSONArray = jSONObject.getJSONArray("resource");
            if (jSONArray != null && jSONArray.length() > 0) {
                JSONArray jSONArray2 = new JSONArray();
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    str4 = str3;
                    str5 = "code";
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
                    String optString = jSONObject3.optString(OapsKey.KEY_REF, "");
                    int i3 = jSONObject3.getInt("type");
                    JSONObject jSONObject4 = new JSONObject();
                    if (i3 == 1 && !TextUtils.isEmpty(optString)) {
                        JSONObject jSONObject5 = new JSONObject();
                        com.anythink.expressad.videocommon.b.a.a();
                        i b2 = com.anythink.expressad.videocommon.b.a.b(optString);
                        if (b2 != null) {
                            o.a(b, "VideoBean not null");
                            jSONObject5.put("type", 1);
                            try {
                                jSONObject5.put("videoDataLength", b2.d());
                                String b3 = b2.b();
                                if (TextUtils.isEmpty(b3)) {
                                    o.a(b, "VideoPath null");
                                    jSONObject5.put(OapsWrapper.KEY_PATH, "");
                                    jSONObject5.put("path4Web", "");
                                } else {
                                    o.a(b, "VideoPath not null");
                                    jSONObject5.put(OapsWrapper.KEY_PATH, b3);
                                    jSONObject5.put("path4Web", b3);
                                }
                                if (b2.c() == 100) {
                                    jSONObject5.put("downloaded", 1);
                                } else {
                                    jSONObject5.put("downloaded", 0);
                                }
                                jSONObject4.put(optString, jSONObject5);
                                jSONArray2.put(jSONObject4);
                            } catch (Throwable th) {
                                str = "code";
                                th = th;
                            }
                        } else {
                            o.a(b, "VideoBean null");
                        }
                    } else if (i3 == 2 && !TextUtils.isEmpty(optString)) {
                        JSONObject jSONObject6 = new JSONObject();
                        jSONObject6.put("type", 2);
                        jSONObject6.put(OapsWrapper.KEY_PATH, com.anythink.expressad.videocommon.b.i.a().c(optString) == null ? "" : com.anythink.expressad.videocommon.b.i.a().c(optString));
                        jSONObject4.put(optString, jSONObject6);
                        jSONArray2.put(jSONObject4);
                    } else if (i3 == 3 && !TextUtils.isEmpty(optString)) {
                        File file = new File(optString);
                        if (file.exists() && file.isFile() && file.canRead()) {
                            o.a(b, "getFileInfo Mraid file ".concat(String.valueOf(optString)));
                            str2 = "file:////".concat(String.valueOf(optString));
                        } else {
                            str2 = "";
                        }
                        JSONObject jSONObject7 = new JSONObject();
                        jSONObject7.put("type", 3);
                        jSONObject7.put(OapsWrapper.KEY_PATH, str2);
                        jSONObject4.put(optString, jSONObject7);
                        jSONArray2.put(jSONObject4);
                    } else if (i3 == 4 && !TextUtils.isEmpty(optString)) {
                        JSONObject jSONObject8 = new JSONObject();
                        jSONObject8.put("type", 4);
                        jSONObject8.put(OapsWrapper.KEY_PATH, s.a(optString) == null ? "" : s.a(optString));
                        jSONObject4.put(optString, jSONObject8);
                        jSONArray2.put(jSONObject4);
                    }
                }
                jSONObject2.put("resource", jSONArray2);
                j.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                return;
            }
            str = "code";
            try {
                jSONObject2.put(str, 1);
            } catch (JSONException e2) {
                e = e2;
            } catch (Throwable th2) {
                th = th2;
                str3 = "message";
            }
            try {
                try {
                    jSONObject2.put("message", "resource is null");
                    j.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                    return;
                } catch (Throwable unused) {
                    str3 = "message";
                    th = b;
                }
            } catch (JSONException e3) {
                e = e3;
                o.a(b, e.getMessage());
                return;
            }
        } catch (Throwable th3) {
            th = th3;
            str3 = str4;
            str = str5;
        }
        try {
            jSONObject2.put(str, 1);
            jSONObject2.put(str3, th.getLocalizedMessage());
            j.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (JSONException e4) {
            o.a(b, e4.getMessage());
        }
    }

    private static ViewGroup.LayoutParams a(ViewGroup.LayoutParams layoutParams, Rect rect, int i2, int i3) {
        Rect rect2 = rect;
        if (rect == null) {
            rect2 = new Rect(f5450a, f5450a, f5450a, f5450a);
        }
        Context g2 = n.a().g();
        if (g2 == null) {
            return layoutParams;
        }
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            if (rect2.left != -999) {
                layoutParams2.leftMargin = t.b(g2, rect2.left);
            }
            if (rect2.top != -999) {
                layoutParams2.topMargin = t.b(g2, rect2.top);
            }
            if (rect2.right != -999) {
                layoutParams2.rightMargin = t.b(g2, rect2.right);
            }
            if (rect2.bottom != -999) {
                layoutParams2.bottomMargin = t.b(g2, rect2.bottom);
            }
            if (i2 > 0) {
                layoutParams2.width = t.b(g2, i2);
            }
            if (i3 > 0) {
                layoutParams2.height = t.b(g2, i3);
            }
            return layoutParams2;
        } else if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
            if (rect2.left != -999) {
                layoutParams3.leftMargin = t.b(g2, rect2.left);
            }
            if (rect2.top != -999) {
                layoutParams3.topMargin = t.b(g2, rect2.top);
            }
            if (rect2.right != -999) {
                layoutParams3.rightMargin = t.b(g2, rect2.right);
            }
            if (rect2.bottom != -999) {
                layoutParams3.bottomMargin = t.b(g2, rect2.bottom);
            }
            if (i2 > 0) {
                layoutParams3.width = t.b(g2, i2);
            }
            if (i3 > 0) {
                layoutParams3.height = t.b(g2, i3);
            }
            return layoutParams3;
        } else {
            LinearLayout.LayoutParams layoutParams4 = layoutParams;
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -1);
                if (rect2.left != -999) {
                    layoutParams5.leftMargin = t.b(g2, rect2.left);
                }
                if (rect2.top != -999) {
                    layoutParams5.topMargin = t.b(g2, rect2.top);
                }
                if (rect2.right != -999) {
                    layoutParams5.rightMargin = t.b(g2, rect2.right);
                }
                if (rect2.bottom != -999) {
                    layoutParams5.bottomMargin = t.b(g2, rect2.bottom);
                }
                if (i2 > 0) {
                    layoutParams5.width = t.b(g2, i2);
                }
                layoutParams4 = layoutParams5;
                if (i3 > 0) {
                    layoutParams5.height = t.b(g2, i3);
                    layoutParams4 = layoutParams5;
                }
            }
            return layoutParams4;
        }
    }

    public static com.anythink.expressad.foundation.d.c a(String str) {
        if (e.containsKey(str)) {
            return e.get(str);
        }
        return null;
    }

    public static c a() {
        return a.f5456a;
    }

    public static void a(int i2, int i3, int i4, int i5, int i6) {
        o.a(b, "OperateViews setNotchString = " + String.format("%1$s-%2$s-%3$s-%4$s-%5$s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)));
        m = h.a(i2, i3, i4, i5, i6);
        n = i2;
        o = i3;
        p = i4;
        q = i5;
        r = i6;
    }

    public static void a(WebView webView, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", l);
            jSONObject.put("message", str);
            jSONObject.put("data", new JSONObject());
            j.a().a(webView, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            o.a(b, e2.getMessage());
        }
    }

    public static void a(WebView webView, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", k);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", str2);
            jSONObject.put("data", jSONObject2);
            j.a();
            j.a(webView, str, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            a(webView, e2.getMessage());
            o.a(b, e2.getMessage());
        }
    }

    public static void a(Object obj) {
        try {
            a(obj, "");
        } catch (Throwable th) {
            c(obj, th.getMessage());
        }
    }

    public static void a(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", k);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", str);
            jSONObject.put("data", jSONObject2);
            j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            c(obj, e2.getMessage());
            o.a(b, e2.getMessage());
        }
    }

    private static void a(Object obj, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", k);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", str2);
            jSONObject.put("data", jSONObject2);
            j.a().a(obj, str, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            c(obj, e2.getMessage());
            o.a(b, e2.getMessage());
        }
    }

    public static void a(String str, int i2) {
        h.put(str, Integer.valueOf(i2));
    }

    public static void a(String str, Activity activity) {
        i.put(str, activity);
    }

    private static void a(String str, com.anythink.expressad.foundation.d.c cVar) {
        if (f.k == null || TextUtils.isEmpty(cVar.aZ())) {
            return;
        }
        f.a(str, cVar, "reward");
    }

    public static void a(String str, String str2) {
        d.put(str, str2);
    }

    private static void a(String str, String str2, String str3) {
        try {
            LinkedHashMap<String, View> b2 = a.f5456a.b(str, str2);
            if (b2 == null || b2.size() <= 0) {
                return;
            }
            for (View view : b2.values()) {
                if (view instanceof ATTempContainer) {
                    ((ATTempContainer) view).notifyEvent(str3);
                } else if (view instanceof AnythinkBTWebView) {
                    ((AnythinkBTWebView) view).notifyEvent(str3);
                } else if (view instanceof AnythinkBTLayout) {
                    ((AnythinkBTLayout) view).notifyEvent(str3);
                }
            }
        } catch (Throwable th) {
            o.a(b, th.getMessage());
        }
    }

    public static d b(String str) {
        if (f.containsKey(str)) {
            return f.get(str);
        }
        return null;
    }

    public static String b() {
        int i2 = j + 1;
        j = i2;
        return String.valueOf(i2);
    }

    public static void b(Object obj, String str) {
        o.a(b, "reportUrls:".concat(String.valueOf(str)));
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= jSONArray.length()) {
                    a(obj, "");
                    return;
                }
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                int optInt = jSONObject.optInt("type");
                String optString = jSONObject.optString("url");
                int optInt2 = jSONObject.optInt("report");
                boolean z = true;
                if (optInt2 == 0) {
                    Context g2 = n.a().g();
                    if (optInt == 0) {
                        z = false;
                    }
                    com.anythink.expressad.a.a.a(g2, (com.anythink.expressad.foundation.d.c) null, "", optString, z);
                } else {
                    com.anythink.expressad.a.a.a(n.a().g(), null, "", optString, false, optInt != 0, optInt2);
                }
                i2 = i3 + 1;
            }
        } catch (Throwable th) {
            o.b(b, "reportUrls", th);
        }
    }

    public static String c(String str) {
        return g.containsKey(str) ? g.get(str) : "";
    }

    private static void c(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", l);
            jSONObject.put("message", str);
            jSONObject.put("data", new JSONObject());
            j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            o.a(b, e2.getMessage());
        }
    }

    public static void d(String str) {
        i.remove(str);
    }

    public static int e(String str) {
        if (h.containsKey(str)) {
            return h.get(str).intValue();
        }
        return 2;
    }

    public static void f(Object obj, JSONObject jSONObject) {
        try {
            jSONObject.optString("unitId");
            String optString = jSONObject.optString("id");
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
            } else {
                a(obj, optString);
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
        }
    }

    public static void f(String str) {
        if (g.containsKey(str)) {
            g.remove(str);
        }
        if (f.containsKey(str)) {
            f.remove(str);
        }
        if (e.containsKey(str)) {
            e.remove(str);
        }
        if (d.containsKey(str)) {
            d.remove(str);
        }
    }

    public static void g(String str) {
        if (h.containsKey(str)) {
            h.remove(str);
        }
    }

    private static String h(String str) {
        return d.containsKey(str) ? d.get(str) : "";
    }

    private static Activity i(String str) {
        if (i.containsKey(str)) {
            return i.get(str);
        }
        return null;
    }

    public final void A(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String h2 = h(optString2);
            String str = h2;
            if (TextUtils.isEmpty(h2)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                str = h2;
                if (aVar.f4263a != null) {
                    str = aVar.f4263a.getRid();
                }
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, str);
            if (!b2.containsKey(optString2)) {
                c(obj, "instanceId not exit");
                o.a(b, "playerPlay failed instanceId not exit instanceId = ".concat(String.valueOf(optString2)));
                return;
            }
            View view = b2.get(optString2);
            if (!(view instanceof AnythinkBTVideoView)) {
                c(obj, "instanceId is not player");
                o.a(b, "playerPlay failed instanceId is not player instanceId = ".concat(String.valueOf(optString2)));
                return;
            }
            ((AnythinkBTVideoView) view).play();
            a(obj, optString2);
            o.a(b, "playerPlay success");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "playerPlay failed: " + th.getMessage());
        }
    }

    public final void B(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String h2 = h(optString2);
            String str = h2;
            if (TextUtils.isEmpty(h2)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                str = h2;
                if (aVar.f4263a != null) {
                    str = aVar.f4263a.getRid();
                }
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, str);
            if (!b2.containsKey(optString2)) {
                c(obj, "instanceId not exit");
                o.a(b, "playerPause failed instanceId not exit instanceId = ".concat(String.valueOf(optString2)));
                return;
            }
            View view = b2.get(optString2);
            if (!(view instanceof AnythinkBTVideoView)) {
                c(obj, "instanceId is not player");
                o.a(b, "playerPause failed instanceId is not player instanceId = ".concat(String.valueOf(optString2)));
                return;
            }
            ((AnythinkBTVideoView) view).pause();
            a(obj, optString2);
            o.a(b, "playerPause success");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "playerPause failed: " + th.getMessage());
        }
    }

    public final void C(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String h2 = h(optString2);
            String str = h2;
            if (TextUtils.isEmpty(h2)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                str = h2;
                if (aVar.f4263a != null) {
                    str = aVar.f4263a.getRid();
                }
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, str);
            if (!b2.containsKey(optString2)) {
                c(obj, "instanceId not exit");
                o.a(b, "playerResume failed instanceId not exit instanceId = ".concat(String.valueOf(optString2)));
                return;
            }
            View view = b2.get(optString2);
            if (!(view instanceof AnythinkBTVideoView)) {
                c(obj, "instanceId is not player");
                o.a(b, "playerResume failed instanceId is not player instanceId = ".concat(String.valueOf(optString2)));
                return;
            }
            ((AnythinkBTVideoView) view).resume();
            a(obj, optString2);
            o.a(b, "playerResume success");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "playerResume failed: " + th.getMessage());
        }
    }

    public final void D(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String h2 = h(optString2);
            String str = h2;
            if (TextUtils.isEmpty(h2)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                str = h2;
                if (aVar.f4263a != null) {
                    str = aVar.f4263a.getRid();
                }
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, str);
            if (!b2.containsKey(optString2)) {
                c(obj, "instanceId not exit");
                o.a(b, "playerStop failed instanceId not exit instanceId = ".concat(String.valueOf(optString2)));
                return;
            }
            View view = b2.get(optString2);
            if (!(view instanceof AnythinkBTVideoView)) {
                c(obj, "instanceId is not player");
                o.a(b, "playerStop failed instanceId is not player instanceId = ".concat(String.valueOf(optString2)));
                return;
            }
            ((AnythinkBTVideoView) view).stop();
            a(obj, optString2);
            o.a(b, "playerStop success");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "playerStop failed: " + th.getMessage());
        }
    }

    public final void F(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String h2 = h(optString2);
            String str = h2;
            if (TextUtils.isEmpty(h2)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                str = h2;
                if (aVar.f4263a != null) {
                    str = aVar.f4263a.getRid();
                }
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, str);
            if (!b2.containsKey(optString2)) {
                c(obj, "instanceId not exist");
                o.a(b, "playerMute failed: instanceId is not exist");
                return;
            }
            View view = b2.get(optString2);
            if (!(view instanceof AnythinkBTVideoView)) {
                c(obj, "instanceId is not player");
                o.a(b, "playerMute failed: instanceId is not player");
            } else if (((AnythinkBTVideoView) view).playMute()) {
                a(obj, optString2);
                o.a(b, "playerMute success");
            } else {
                c(obj, "set mute failed");
                o.a(b, "playerMute failed set mute failed");
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "playerMute failed: " + th.getMessage());
        }
    }

    public final void G(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String h2 = h(optString2);
            String str = h2;
            if (TextUtils.isEmpty(h2)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                str = h2;
                if (aVar.f4263a != null) {
                    str = aVar.f4263a.getRid();
                }
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, str);
            if (!b2.containsKey(optString2)) {
                c(obj, "instanceId not exit");
                o.a(b, "playerUnmute failed: instanceId not exit");
                return;
            }
            View view = b2.get(optString2);
            if (!(view instanceof AnythinkBTVideoView)) {
                c(obj, "instanceId is not player");
                o.a(b, "playerUnmute failed: instanceId is not player");
            } else if (!((AnythinkBTVideoView) view).playUnMute()) {
                a(obj, "set unmute failed");
                o.a(b, "playerUnmute failed: set unmute failed");
            } else {
                a(obj, optString2);
                a(obj, "onUnmute", optString2);
                o.a(b, "playerUnmute successed");
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "playerUnmute failed: " + th.getMessage());
        }
    }

    public final void H(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String h2 = h(optString2);
            String str = h2;
            if (TextUtils.isEmpty(h2)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                str = h2;
                if (aVar.f4263a != null) {
                    str = aVar.f4263a.getRid();
                }
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, str);
            if (!b2.containsKey(optString2)) {
                c(obj, "instanceId not exist");
                o.a(b, "playerGetMuteState failed instanceId not exist");
                return;
            }
            View view = b2.get(optString2);
            if (!(view instanceof AnythinkBTVideoView)) {
                c(obj, "instanceId is not player");
                o.a(b, "playerGetMuteState failed instanceId is not player");
                return;
            }
            int mute = ((AnythinkBTVideoView) view).getMute();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", k);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("id", optString2);
            jSONObject3.put("mute", mute);
            jSONObject2.put("data", jSONObject3);
            j.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            o.a(b, "playerGetMuteState successed mute = ".concat(String.valueOf(mute)));
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "playerGetMuteState failed: " + th.getMessage());
        }
    }

    public final void K(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String h2 = h(optString2);
            String str = h2;
            if (TextUtils.isEmpty(h2)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                str = h2;
                if (aVar.f4263a != null) {
                    str = aVar.f4263a.getRid();
                }
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, str);
            if (!b2.containsKey(optString2)) {
                c(obj, "instanceId not exist");
                return;
            }
            View view = b2.get(optString2);
            if (!(view instanceof ATTempContainer)) {
                c(obj, "view not exist");
                return;
            }
            ((ATTempContainer) view).preload();
            a(obj, optString2);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "preloadSubPlayTemplateView failed: " + th.getMessage());
        }
    }

    public final void L(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String h2 = h(optString2);
            String str = h2;
            if (TextUtils.isEmpty(h2)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                str = h2;
                if (aVar.f4263a != null) {
                    str = aVar.f4263a.getRid();
                }
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, str);
            AnythinkBTContainer anythinkBTContainer = null;
            if (b2.size() <= 0) {
                c(obj, "unitId or instanceId not exist");
                o.a(b, "closeAd failed: unitId or instanceId not exist unitId = ".concat(String.valueOf(optString)));
                return;
            }
            for (View view : b2.values()) {
                if (view instanceof AnythinkBTContainer) {
                    anythinkBTContainer = (AnythinkBTContainer) view;
                } else if (view instanceof AnythinkBTWebView) {
                    ((AnythinkBTWebView) view).onDestory();
                } else if (view instanceof AnythinkBTVideoView) {
                    String instanceId = ((AnythinkBTVideoView) view).getInstanceId();
                    com.anythink.expressad.video.bt.a.a.a();
                    com.anythink.expressad.video.bt.a.a.a(instanceId);
                    ((AnythinkBTVideoView) view).onDestory();
                } else if (view instanceof ATTempContainer) {
                    ((ATTempContainer) view).onDestroy();
                }
            }
            if (anythinkBTContainer == null) {
                c(obj, "not found AnythinkBTContainer");
                o.a(b, "closeAd successed");
                return;
            }
            anythinkBTContainer.onAdClose();
            f5451c.remove(b2);
            b2.clear();
            f5451c.remove(optString + "_" + str);
            a(obj, optString2);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "closeAd failed: " + th.getMessage());
        }
    }

    public final void M(Object obj, JSONObject jSONObject) {
        try {
            com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
            String rid = aVar.f4263a != null ? aVar.f4263a.getRid() : "";
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("eventName");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            LinkedHashMap<String, View> b2 = b(optString, rid);
            if (b2 == null || b2.size() <= 0) {
                c(obj, "unitId not exist");
                return;
            }
            for (View view : b2.values()) {
                if (view instanceof AnythinkBTWebView) {
                    ((AnythinkBTWebView) view).broadcast(optString2, optJSONObject);
                }
                if (view instanceof AnythinkBTLayout) {
                    ((AnythinkBTLayout) view).broadcast(optString2, optJSONObject);
                }
            }
            a(obj, "");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "broadcast failed: " + th.getMessage());
        }
    }

    public final void N(Object obj, JSONObject jSONObject) {
        try {
            com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
            String rid = aVar.f4263a != null ? aVar.f4263a.getRid() : "";
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            String optString3 = optJSONObject.optString(ao.q);
            boolean optBoolean = optJSONObject.optBoolean("expired");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("reward");
            String optString4 = optJSONObject.optString("extra");
            String str = "";
            com.anythink.expressad.videocommon.c.c cVar = null;
            if (optJSONObject2 != null) {
                cVar = new com.anythink.expressad.videocommon.c.c(optJSONObject2.optString("name"), optJSONObject2.optInt("amount"));
                str = optJSONObject2.optString("id");
            }
            LinkedHashMap<String, View> b2 = b(optString, rid);
            if (b2.size() <= 0 || !g.containsKey(optString2)) {
                c(obj, "unitId not exist");
                o.a(b, "setSubPlayTemplateInfo failed: unitId not exist instanceId = ".concat(String.valueOf(optString2)));
                return;
            }
            View view = b2.get(optString2);
            if (!(view instanceof ATTempContainer)) {
                c(obj, "instanceId not exist");
                o.a(b, "setSubPlayTemplateInfo failed: instanceId not exist instanceId = ".concat(String.valueOf(optString2)));
                return;
            }
            ATTempContainer aTTempContainer = (ATTempContainer) view;
            aTTempContainer.setReward(cVar);
            aTTempContainer.setUserId(optString3);
            aTTempContainer.setRewardId(str);
            aTTempContainer.setCampaignExpired(optBoolean);
            if (!TextUtils.isEmpty(optString4)) {
                aTTempContainer.setDeveloperExtraData(optString4);
            }
            a(obj, optString2);
            o.a(b, "setSubPlayTemplateInfo success instanceId = ".concat(String.valueOf(optString2)));
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "setSubPlayTemplateInfo failed: " + th.getMessage());
        }
    }

    public final void O(Object obj, JSONObject jSONObject) {
        try {
            com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
            String rid = aVar.f4263a != null ? aVar.f4263a.getRid() : "";
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            String optString3 = optJSONObject.optString("eventName");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("eventData");
            JSONObject jSONObject2 = optJSONObject2;
            if (optJSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            LinkedHashMap<String, View> b2 = b(optString, rid);
            if (b2.size() <= 0) {
                c(obj, "unitId not exist");
                o.a(b, "webviewFireEvent failed: unitId not exist");
                return;
            }
            View view = b2.get(optString2);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= childCount) {
                        break;
                    }
                    View childAt = viewGroup.getChildAt(i3);
                    if (childAt instanceof WindVaneWebView) {
                        j.a();
                        j.a((WebView) ((WindVaneWebView) childAt), optString3, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                        a(obj, optString2);
                        o.a(b, "webviewFireEvent instanceId = ".concat(String.valueOf(optString2)));
                        return;
                    }
                    i2 = i3 + 1;
                }
            }
            c(obj, "instanceId not exist");
            o.a(b, "webviewFireEvent failed: instanceId not exist instanceId = ".concat(String.valueOf(optString2)));
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "webviewFireEvent failed: " + th.getMessage());
        }
    }

    public final void Q(Object obj, JSONObject jSONObject) {
        o.a(b, "createNativeEC:".concat(String.valueOf(jSONObject)));
        try {
            String optString = jSONObject.optString("unitId");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null && !TextUtils.isEmpty(optString)) {
                com.anythink.expressad.foundation.d.c b2 = com.anythink.expressad.foundation.d.c.b(optJSONObject.optJSONObject("campaign"));
                String str = "";
                if (b2 != null) {
                    str = "";
                    if (!TextUtils.isEmpty(optString)) {
                        b2.l(optString);
                        str = b2.Z();
                    }
                }
                d a2 = d.a(optJSONObject.optJSONObject("unitSetting"));
                if (a2 != null) {
                    a2.a(optString);
                }
                AnythinkBTNativeEC anythinkBTNativeEC = new AnythinkBTNativeEC(n.a().g());
                anythinkBTNativeEC.setCampaign(b2);
                com.anythink.expressad.video.signal.a.j jVar = new com.anythink.expressad.video.signal.a.j(null, b2);
                jVar.a(optString);
                anythinkBTNativeEC.setJSCommon(jVar);
                anythinkBTNativeEC.setUnitId(optString);
                anythinkBTNativeEC.setRewardUnitSetting(a2);
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                if (aVar.f4263a != null) {
                    WindVaneWebView windVaneWebView = aVar.f4263a;
                    str = windVaneWebView.getRid();
                    anythinkBTNativeEC.setCreateWebView(windVaneWebView);
                }
                LinkedHashMap<String, View> b3 = b(optString, str);
                String b4 = b();
                d.put(b4, str);
                anythinkBTNativeEC.setInstanceId(b4);
                b3.put(b4, anythinkBTNativeEC);
                anythinkBTNativeEC.preLoadData();
                if (b2 == null) {
                    c(obj, "campaign is null");
                    o.a(b, "createNativeEC failed");
                    return;
                }
                a(obj, b4);
                o.a(b, "createNativeEC instanceId = ".concat(String.valueOf(b4)));
                return;
            }
            c(obj, "unitId or data is empty");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "createNativeEC failed：" + th.getMessage());
        }
    }

    public final void a(final Object obj, JSONObject jSONObject) {
        int i2;
        int i3;
        try {
            final String optString = jSONObject.optString("unitId");
            if (TextUtils.isEmpty(optString)) {
                c(obj, "unitId is empty");
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            int optInt = optJSONObject.optInt("delay", 0);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
            Rect rect = new Rect(f5450a, f5450a, f5450a, f5450a);
            if (optJSONObject2 != null) {
                rect = new Rect(optJSONObject2.optInt("left", f5450a), optJSONObject2.optInt(Constant.MAP_KEY_TOP, f5450a), optJSONObject2.optInt("right", f5450a), optJSONObject2.optInt("bottom", f5450a));
                i2 = optJSONObject2.optInt("width");
                i3 = optJSONObject2.optInt("height");
            } else {
                i2 = 0;
                i3 = 0;
            }
            final Rect rect2 = rect;
            final int i4 = i2;
            final int i5 = i3;
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.anythink.expressad.video.bt.a.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    String str;
                    WindVaneWebView windVaneWebView;
                    com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                    if (aVar.f4263a != null) {
                        windVaneWebView = aVar.f4263a;
                        str = windVaneWebView.getRid();
                    } else {
                        str = "";
                        windVaneWebView = null;
                    }
                    LinkedHashMap<String, View> b2 = c.this.b(optString, str);
                    String b3 = c.b();
                    c.d.put(b3, str);
                    AnythinkBTLayout anythinkBTLayout = new AnythinkBTLayout(n.a().g());
                    b2.put(b3, anythinkBTLayout);
                    anythinkBTLayout.setInstanceId(b3);
                    anythinkBTLayout.setUnitId(optString);
                    anythinkBTLayout.setWebView(windVaneWebView);
                    anythinkBTLayout.setRect(rect2);
                    if (i4 > 0 || i5 > 0) {
                        anythinkBTLayout.setLayout(i4, i5);
                    }
                    c.a(obj, b3);
                    o.a(c.b, "create view instanceId = ".concat(String.valueOf(b3)));
                }
            }, optInt);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "create view failed：" + th.getMessage());
        }
    }

    public final LinkedHashMap<String, View> b(String str, String str2) {
        synchronized (this) {
            ConcurrentHashMap<String, LinkedHashMap<String, View>> concurrentHashMap = f5451c;
            if (concurrentHashMap.containsKey(str + "_" + str2)) {
                ConcurrentHashMap<String, LinkedHashMap<String, View>> concurrentHashMap2 = f5451c;
                return concurrentHashMap2.get(str + "_" + str2);
            }
            LinkedHashMap<String, View> linkedHashMap = new LinkedHashMap<>();
            ConcurrentHashMap<String, LinkedHashMap<String, View>> concurrentHashMap3 = f5451c;
            concurrentHashMap3.put(str + "_" + str2, linkedHashMap);
            return linkedHashMap;
        }
    }

    public final void b(final Object obj, JSONObject jSONObject) {
        int i2;
        int i3;
        try {
            final String optString = jSONObject.optString("unitId");
            if (TextUtils.isEmpty(optString)) {
                c(obj, "unitId is empty");
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            int optInt = optJSONObject.optInt("delay", 0);
            final String optString2 = optJSONObject.optString("fileURL");
            final String optString3 = optJSONObject.optString("filePath");
            final String optString4 = optJSONObject.optString(com.baidu.mobads.sdk.internal.a.f);
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
            Rect rect = new Rect(f5450a, f5450a, f5450a, f5450a);
            if (optJSONObject2 != null) {
                rect = new Rect(optJSONObject2.optInt("left", f5450a), optJSONObject2.optInt(Constant.MAP_KEY_TOP, f5450a), optJSONObject2.optInt("right", f5450a), optJSONObject2.optInt("bottom", f5450a));
                i2 = optJSONObject2.optInt("width");
                i3 = optJSONObject2.optInt("height");
            } else {
                i2 = 0;
                i3 = 0;
            }
            final Rect rect2 = rect;
            final int i4 = i2;
            final int i5 = i3;
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.anythink.expressad.video.bt.a.c.2
                @Override // java.lang.Runnable
                public final void run() {
                    String str;
                    WindVaneWebView windVaneWebView;
                    com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                    if (aVar.f4263a != null) {
                        windVaneWebView = aVar.f4263a;
                        str = windVaneWebView.getRid();
                    } else {
                        str = "";
                        windVaneWebView = null;
                    }
                    LinkedHashMap<String, View> b2 = c.this.b(optString, str);
                    String b3 = c.b();
                    c.d.put(b3, str);
                    AnythinkBTWebView anythinkBTWebView = new AnythinkBTWebView(n.a().g());
                    b2.put(b3, anythinkBTWebView);
                    anythinkBTWebView.setInstanceId(b3);
                    anythinkBTWebView.setUnitId(optString);
                    anythinkBTWebView.setFileURL(optString2);
                    anythinkBTWebView.setFilePath(optString3);
                    anythinkBTWebView.setHtml(optString4);
                    anythinkBTWebView.setRect(rect2);
                    anythinkBTWebView.setWebViewRid(str);
                    anythinkBTWebView.setCreateWebView(windVaneWebView);
                    if (i4 > 0 || i5 > 0) {
                        anythinkBTWebView.setLayout(i4, i5);
                    }
                    anythinkBTWebView.preload();
                    c.a(obj, b3);
                    o.a(c.b, "createWebview instanceId = ".concat(String.valueOf(b3)));
                }
            }, optInt);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "createWebview failed：" + th.getMessage());
        }
    }

    public final void c(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("unitId");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null && !TextUtils.isEmpty(optString)) {
                com.anythink.expressad.foundation.d.c b2 = com.anythink.expressad.foundation.d.c.b(optJSONObject.optJSONObject("campaign"));
                String str = "";
                if (b2 != null) {
                    str = "";
                    if (!TextUtils.isEmpty(optString)) {
                        b2.l(optString);
                        str = b2.Z();
                    }
                }
                int optInt = optJSONObject.optInt("show_time", 0);
                int optInt2 = optJSONObject.optInt("show_mute", 0);
                int optInt3 = optJSONObject.optInt("show_close", 0);
                int optInt4 = optJSONObject.optInt("orientation", 1);
                int optInt5 = optJSONObject.optInt("show_pgb", 0);
                AnythinkBTVideoView anythinkBTVideoView = new AnythinkBTVideoView(n.a().g());
                anythinkBTVideoView.setCampaign(b2);
                anythinkBTVideoView.setUnitId(optString);
                anythinkBTVideoView.setShowMute(optInt2);
                anythinkBTVideoView.setShowTime(optInt);
                anythinkBTVideoView.setShowClose(optInt3);
                anythinkBTVideoView.setOrientation(optInt4);
                anythinkBTVideoView.setProgressBarState(optInt5);
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                if (aVar.f4263a != null) {
                    WindVaneWebView windVaneWebView = aVar.f4263a;
                    str = windVaneWebView.getRid();
                    anythinkBTVideoView.setCreateWebView(windVaneWebView);
                }
                LinkedHashMap<String, View> b3 = b(optString, str);
                String b4 = b();
                d.put(b4, str);
                anythinkBTVideoView.setInstanceId(b4);
                b3.put(b4, anythinkBTVideoView);
                anythinkBTVideoView.preLoadData();
                if (b2 == null) {
                    c(obj, "campaign is null");
                    o.a(b, "createPlayerView failed");
                } else {
                    a(obj, b4);
                    o.a(b, "createPlayerView instanceId = ".concat(String.valueOf(b4)));
                }
                com.anythink.expressad.video.bt.a.a.a();
                com.anythink.expressad.video.bt.a.a.a(b4, anythinkBTVideoView);
                return;
            }
            c(obj, "unitId or data is empty");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "createPlayerView failed：" + th.getMessage());
        }
    }

    public final void d(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("unitId");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null && !TextUtils.isEmpty(optString)) {
                int optInt = optJSONObject.optInt("mute");
                com.anythink.expressad.foundation.d.c b2 = com.anythink.expressad.foundation.d.c.b(optJSONObject.optJSONObject("campaign"));
                String str = "";
                if (b2 != null) {
                    str = "";
                    if (!TextUtils.isEmpty(optString)) {
                        b2.l(optString);
                        str = b2.Z();
                    }
                }
                d a2 = d.a(optJSONObject.optJSONObject("unitSetting"));
                if (a2 != null) {
                    a2.a(optString);
                }
                String optString2 = optJSONObject.optString(ao.q);
                String str2 = str;
                if (TextUtils.isEmpty(str)) {
                    com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                    str2 = str;
                    if (aVar.f4263a != null) {
                        str2 = aVar.f4263a.getRid();
                    }
                }
                LinkedHashMap<String, View> b3 = b(optString, str2);
                String b4 = b();
                d.put(b4, str2);
                ATTempContainer aTTempContainer = new ATTempContainer(n.a().g());
                aTTempContainer.setInstanceId(b4);
                aTTempContainer.setUnitId(optString);
                aTTempContainer.setCampaign(b2);
                aTTempContainer.setRewardUnitSetting(a2);
                aTTempContainer.setBigOffer(true);
                if (!TextUtils.isEmpty(optString2)) {
                    aTTempContainer.setUserId(optString2);
                }
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("reward");
                if (optJSONObject2 != null) {
                    String optString3 = optJSONObject2.optString("id");
                    com.anythink.expressad.videocommon.c.c cVar = new com.anythink.expressad.videocommon.c.c(optJSONObject2.optString("name"), optJSONObject2.optInt("amount"));
                    if (!TextUtils.isEmpty(optString3)) {
                        aTTempContainer.setRewardId(optString3);
                    }
                    if (!TextUtils.isEmpty(cVar.a())) {
                        aTTempContainer.setReward(cVar);
                    }
                }
                String optString4 = optJSONObject.optString("extra");
                if (!TextUtils.isEmpty(optString4)) {
                    aTTempContainer.setDeveloperExtraData(optString4);
                }
                aTTempContainer.setMute(optInt);
                b3.put(b4, aTTempContainer);
                g.put(b4, optString);
                e.put(b4, b2);
                f.put(b4, a2);
                a(obj, b4);
                o.a(b, "createSubPlayTemplateView instanceId = ".concat(String.valueOf(b4)));
                return;
            }
            c(obj, "unitId or data is empty");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "createSubPlayTemplateView failed：" + th.getMessage());
        }
    }

    public final void e(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            if (jSONObject.optJSONObject("data") != null && !TextUtils.isEmpty(optString)) {
                String h2 = h(optString2);
                String str = h2;
                if (TextUtils.isEmpty(h2)) {
                    com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                    str = h2;
                    if (aVar.f4263a != null) {
                        str = aVar.f4263a.getRid();
                    }
                }
                LinkedHashMap<String, View> b2 = b(optString, str);
                if (b2 == null || !b2.containsKey(optString2)) {
                    c(obj, "unitId or instanceId not exist");
                    o.a(b, "destroyComponent failed");
                    return;
                }
                View view = b2.get(optString2);
                b2.remove(optString2);
                if (view != null && view.getParent() != null) {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(view);
                    }
                    if (view instanceof ViewGroup) {
                        ViewGroup viewGroup2 = (ViewGroup) view;
                        if (viewGroup2.getChildCount() > 0) {
                            int childCount = viewGroup2.getChildCount();
                            int i2 = 0;
                            while (true) {
                                int i3 = i2;
                                if (i3 >= childCount) {
                                    break;
                                }
                                View childAt = viewGroup2.getChildAt(i3);
                                if (childAt instanceof AnythinkBTWebView) {
                                    b2.remove(((AnythinkBTWebView) childAt).getInstanceId());
                                    ((AnythinkBTWebView) childAt).onDestory();
                                } else if (childAt instanceof AnythinkBTVideoView) {
                                    b2.remove(((AnythinkBTVideoView) childAt).getInstanceId());
                                    ((AnythinkBTVideoView) childAt).onDestory();
                                } else if (childAt instanceof ATTempContainer) {
                                    b2.remove(((ATTempContainer) childAt).getInstanceId());
                                    ((ATTempContainer) childAt).onDestroy();
                                }
                                i2 = i3 + 1;
                            }
                        }
                    }
                }
                if (view instanceof ATTempContainer) {
                    ((ATTempContainer) view).onDestroy();
                }
                if (view instanceof AnythinkBTWebView) {
                    ((AnythinkBTWebView) view).onDestory();
                }
                if (view instanceof AnythinkBTVideoView) {
                    ((AnythinkBTVideoView) view).onDestory();
                }
                a(obj, optString2);
                a(obj, "onComponentDestroy", optString2);
                o.a(b, "destroyComponent instanceId = ".concat(String.valueOf(optString2)));
                return;
            }
            c(obj, "unidId or data is empty");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "destroyComponent failed");
        }
    }

    public final void g(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String h2 = h(optString2);
            String str = h2;
            if (TextUtils.isEmpty(h2)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                str = h2;
                if (aVar.f4263a != null) {
                    str = aVar.f4263a.getRid();
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
            if (optJSONObject2 == null) {
                c(obj, "rect not exist");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, str);
            Rect rect = new Rect(optJSONObject2.optInt("left", f5450a), optJSONObject2.optInt(Constant.MAP_KEY_TOP, f5450a), optJSONObject2.optInt("right", f5450a), optJSONObject2.optInt("bottom", f5450a));
            int optInt = optJSONObject2.optInt("width");
            int optInt2 = optJSONObject2.optInt("height");
            if (!b2.containsKey(optString2)) {
                c(obj, "instanceId not exist");
                o.a(b, "setViewRect failed: instanceId not exist");
                return;
            }
            View view = b2.get(optString2);
            if (view == null) {
                c(obj, "view is null");
                o.a(b, "setViewRect failed: view is null");
                return;
            }
            if (view.getParent() != null) {
                view.setLayoutParams(a(view.getLayoutParams(), rect, optInt, optInt2));
                view.requestLayout();
            } else {
                if (view instanceof AnythinkBTWebView) {
                    ((AnythinkBTWebView) view).setRect(rect);
                    ((AnythinkBTWebView) view).setLayout(optInt, optInt2);
                }
                if (view instanceof AnythinkBTVideoView) {
                    ((AnythinkBTVideoView) view).setRect(rect);
                    ((AnythinkBTVideoView) view).setLayout(optInt, optInt2);
                }
            }
            a(obj, optString2);
            a(obj, "onViewRectChanged", optString2);
            o.a(b, "setViewRect instanceId = ".concat(String.valueOf(optString2)));
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "setViewRect failed: " + th.getMessage());
        }
    }

    public final void h(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String h2 = h(optString2);
            String str = h2;
            if (TextUtils.isEmpty(h2)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                str = h2;
                if (aVar.f4263a != null) {
                    str = aVar.f4263a.getRid();
                }
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, str);
            if (!b2.containsKey(optString2)) {
                c(obj, "params not enough");
                o.a(b, "removeFromSuperView failed: params not enough instanceId = ".concat(String.valueOf(optString2)));
                return;
            }
            View view = b2.get(optString2);
            if (view == null || view.getParent() == null) {
                c(obj, "view is null");
                o.a(b, "removeFromSuperView failed: view is null instanceId = ".concat(String.valueOf(optString2)));
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup == null) {
                c(obj, "parent is null");
                o.a(b, "removeFromSuperView failed: parent is null instanceId = ".concat(String.valueOf(optString2)));
                return;
            }
            viewGroup.removeView(view);
            a(obj, optString2);
            a(obj, "onRemoveFromView", optString2);
            o.a(b, "removeFromSuperView instanceId = ".concat(String.valueOf(optString2)));
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "removeFromSuperView failed: " + th.getMessage());
        }
    }

    public final void i(Object obj, JSONObject jSONObject) {
        int optInt;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String h2 = h(optString2);
            String str = h2;
            if (TextUtils.isEmpty(h2)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                str = h2;
                if (aVar.f4263a != null) {
                    str = aVar.f4263a.getRid();
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            String optString3 = optJSONObject.optString("id");
            LinkedHashMap<String, View> b2 = b(optString, str);
            if (!b2.containsKey(optString3) || !b2.containsKey(optString2)) {
                c(obj, "instanceId is not exist");
                o.a(b, "appendSubView failed: instanceId is not exist");
                return;
            }
            ViewGroup viewGroup = (ViewGroup) b2.get(optString2);
            View view = b2.get(optString3);
            u.a(view);
            if (viewGroup == null || view == null) {
                c(obj, "view is not exist");
                return;
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
            int i2 = 0;
            if (view instanceof ATTempContainer) {
                o.d(b, "OperateViews setNotchString = " + String.format("%1$s-%2$s-%3$s-%4$s-%5$s", Integer.valueOf(n), Integer.valueOf(o), Integer.valueOf(p), Integer.valueOf(q), Integer.valueOf(r)));
                ((ATTempContainer) view).setNotchPadding(n, o, p, q, r);
                Iterator<View> it = b2.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    View next = it.next();
                    if (next instanceof AnythinkBTContainer) {
                        u.a(view);
                        ((AnythinkBTContainer) next).appendSubView((AnythinkBTContainer) next, (ATTempContainer) view, optJSONObject2);
                        break;
                    }
                }
            } else {
                Rect rect = null;
                if (optJSONObject2 != null) {
                    rect = new Rect(optJSONObject2.optInt("left", f5450a), optJSONObject2.optInt(Constant.MAP_KEY_TOP, f5450a), optJSONObject2.optInt("right", f5450a), optJSONObject2.optInt("bottom", f5450a));
                    i2 = optJSONObject2.optInt("width");
                    optInt = optJSONObject2.optInt("height");
                } else if (view instanceof BTBaseView) {
                    rect = ((BTBaseView) view).getRect();
                    i2 = ((BTBaseView) view).getViewWidth();
                    optInt = ((BTBaseView) view).getViewHeight();
                } else {
                    optInt = 0;
                }
                FrameLayout.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                if (viewGroup instanceof FrameLayout) {
                    layoutParams = new FrameLayout.LayoutParams(-1, -1);
                } else if (viewGroup instanceof RelativeLayout) {
                    layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                } else if (viewGroup instanceof LinearLayout) {
                    layoutParams = new LinearLayout.LayoutParams(-1, -1);
                }
                ViewGroup.LayoutParams a2 = a(layoutParams, rect, i2, optInt);
                u.a(view);
                viewGroup.addView(view, a2);
            }
            a(obj, optString2);
            a(obj, "onAppendView", optString2);
            o.a(b, "appendSubView parentId = " + optString2 + " childId = " + optString3);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "appendSubView failed: " + th.getMessage());
        }
    }

    public final void j(Object obj, JSONObject jSONObject) {
        int optInt;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String h2 = h(optString2);
            String str = h2;
            if (TextUtils.isEmpty(h2)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                str = h2;
                if (aVar.f4263a != null) {
                    str = aVar.f4263a.getRid();
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null && !TextUtils.isEmpty(optString)) {
                String optString3 = optJSONObject.optString("id");
                LinkedHashMap<String, View> b2 = b(optString, str);
                if (!b2.containsKey(optString2) || !b2.containsKey(optString3)) {
                    c(obj, "instanceId is not exist");
                    o.a(b, "appendViewTo failed: instanceId is not exist");
                    return;
                }
                ViewGroup viewGroup = (ViewGroup) b2.get(optString3);
                View view = b2.get(optString2);
                u.a(view);
                if (viewGroup == null || view == null) {
                    c(obj, "view is not exist");
                    return;
                }
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
                if (view instanceof ATTempContainer) {
                    Iterator<View> it = b2.values().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        View next = it.next();
                        if (next instanceof AnythinkBTContainer) {
                            u.a(view);
                            ((AnythinkBTContainer) next).appendSubView((AnythinkBTContainer) next, (ATTempContainer) view, optJSONObject2);
                            break;
                        }
                    }
                } else {
                    Rect rect = null;
                    int i2 = 0;
                    if (optJSONObject2 != null) {
                        rect = new Rect(optJSONObject2.optInt("left", f5450a), optJSONObject2.optInt(Constant.MAP_KEY_TOP, f5450a), optJSONObject2.optInt("right", f5450a), optJSONObject2.optInt("bottom", f5450a));
                        i2 = optJSONObject2.optInt("width");
                        optInt = optJSONObject2.optInt("height");
                    } else if (view instanceof BTBaseView) {
                        rect = ((BTBaseView) view).getRect();
                        i2 = ((BTBaseView) view).getViewWidth();
                        optInt = ((BTBaseView) view).getViewHeight();
                    } else {
                        optInt = 0;
                    }
                    FrameLayout.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                    if (viewGroup instanceof FrameLayout) {
                        layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    } else if (viewGroup instanceof RelativeLayout) {
                        layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    } else if (viewGroup instanceof LinearLayout) {
                        layoutParams = new LinearLayout.LayoutParams(-1, -1);
                    }
                    ViewGroup.LayoutParams a2 = a(layoutParams, rect, i2, optInt);
                    u.a(view);
                    viewGroup.addView(view, a2);
                }
                a(obj, optString2);
                a(obj, "onAppendViewTo", optString2);
                o.a(b, "appendViewTo parentId = " + optString3 + " childId = " + optString2);
                return;
            }
            c(obj, "unitId or data is empty");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "appendViewTo failed: " + th.getMessage());
        }
    }

    public final void k(Object obj, JSONObject jSONObject) {
        int optInt;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String h2 = h(optString2);
            String str = h2;
            if (TextUtils.isEmpty(h2)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                str = h2;
                if (aVar.f4263a != null) {
                    str = aVar.f4263a.getRid();
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            String optString3 = optJSONObject.optString("id");
            LinkedHashMap<String, View> b2 = b(optString, str);
            if (!b2.containsKey(optString3) || !b2.containsKey(optString2)) {
                c(obj, "instanceId is not exist");
                o.a(b, "appendSubView failed: instanceId is not exist");
                return;
            }
            ViewGroup viewGroup = (ViewGroup) b2.get(optString2);
            View view = b2.get(optString3);
            if (viewGroup == null || view == null) {
                c(obj, "view is not exist");
                return;
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
            int i2 = 0;
            if (view instanceof ATTempContainer) {
                o.d(b, "OperateViews setNotchString = " + String.format("%1$s-%2$s-%3$s-%4$s-%5$s", Integer.valueOf(n), Integer.valueOf(o), Integer.valueOf(p), Integer.valueOf(q), Integer.valueOf(r)));
                ((ATTempContainer) view).setNotchPadding(n, o, p, q, r);
                Iterator<View> it = b2.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    View next = it.next();
                    if (next instanceof AnythinkBTContainer) {
                        u.a(view);
                        ((AnythinkBTContainer) next).appendSubView((AnythinkBTContainer) next, (ATTempContainer) view, optJSONObject2);
                        break;
                    }
                }
            } else {
                Rect rect = null;
                if (optJSONObject2 != null) {
                    rect = new Rect(optJSONObject2.optInt("left", f5450a), optJSONObject2.optInt(Constant.MAP_KEY_TOP, f5450a), optJSONObject2.optInt("right", f5450a), optJSONObject2.optInt("bottom", f5450a));
                    i2 = optJSONObject2.optInt("width");
                    optInt = optJSONObject2.optInt("height");
                } else if (view instanceof BTBaseView) {
                    rect = ((BTBaseView) view).getRect();
                    i2 = ((BTBaseView) view).getViewWidth();
                    optInt = ((BTBaseView) view).getViewHeight();
                } else {
                    optInt = 0;
                }
                FrameLayout.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                if (viewGroup instanceof FrameLayout) {
                    layoutParams = new FrameLayout.LayoutParams(-1, -1);
                } else if (viewGroup instanceof RelativeLayout) {
                    layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                } else if (viewGroup instanceof LinearLayout) {
                    layoutParams = new LinearLayout.LayoutParams(-1, -1);
                }
                viewGroup.addView(view, a(layoutParams, rect, i2, optInt));
            }
            a(obj, optString2);
            a(obj, "onAppendView", optString2);
            o.a(b, "appendSubView parentId = " + optString2 + " childId = " + optString3);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "appendSubView failed: " + th.getMessage());
        }
    }

    public final void l(Object obj, JSONObject jSONObject) {
        int optInt;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String h2 = h(optString2);
            String str = h2;
            if (TextUtils.isEmpty(h2)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                str = h2;
                if (aVar.f4263a != null) {
                    str = aVar.f4263a.getRid();
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null && !TextUtils.isEmpty(optString)) {
                String optString3 = optJSONObject.optString("id");
                LinkedHashMap<String, View> b2 = b(optString, str);
                if (!b2.containsKey(optString2) || !b2.containsKey(optString3)) {
                    c(obj, "instanceId is not exist");
                    o.a(b, "appendViewTo failed: instanceId is not exist");
                    return;
                }
                ViewGroup viewGroup = (ViewGroup) b2.get(optString3);
                View view = b2.get(optString2);
                if (viewGroup == null || view == null) {
                    c(obj, "view is not exist");
                    return;
                }
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
                if (view instanceof ATTempContainer) {
                    Iterator<View> it = b2.values().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        View next = it.next();
                        if (next instanceof AnythinkBTContainer) {
                            u.a(view);
                            ((AnythinkBTContainer) next).appendSubView((AnythinkBTContainer) next, (ATTempContainer) view, optJSONObject2);
                            break;
                        }
                    }
                } else {
                    Rect rect = null;
                    int i2 = 0;
                    if (optJSONObject2 != null) {
                        rect = new Rect(optJSONObject2.optInt("left", f5450a), optJSONObject2.optInt(Constant.MAP_KEY_TOP, f5450a), optJSONObject2.optInt("right", f5450a), optJSONObject2.optInt("bottom", f5450a));
                        i2 = optJSONObject2.optInt("width");
                        optInt = optJSONObject2.optInt("height");
                    } else if (view instanceof BTBaseView) {
                        rect = ((BTBaseView) view).getRect();
                        i2 = ((BTBaseView) view).getViewWidth();
                        optInt = ((BTBaseView) view).getViewHeight();
                    } else {
                        optInt = 0;
                    }
                    FrameLayout.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                    if (viewGroup instanceof FrameLayout) {
                        layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    } else if (viewGroup instanceof RelativeLayout) {
                        layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    } else if (viewGroup instanceof LinearLayout) {
                        layoutParams = new LinearLayout.LayoutParams(-1, -1);
                    }
                    viewGroup.addView(view, a(layoutParams, rect, i2, optInt));
                }
                a(obj, optString2);
                a(obj, "onAppendViewTo", optString2);
                o.a(b, "appendViewTo parentId = " + optString3 + " childId = " + optString2);
                return;
            }
            c(obj, "unitId or data is empty");
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "appendViewTo failed: " + th.getMessage());
        }
    }

    public final void m(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String h2 = h(optString2);
            String str = h2;
            if (TextUtils.isEmpty(h2)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                str = h2;
                if (aVar.f4263a != null) {
                    str = aVar.f4263a.getRid();
                }
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, str);
            if (!b2.containsKey(optString2)) {
                c(obj, "instanceId is not exist");
                o.a(b, "bringViewToFront failed: instanceId is not exist");
                return;
            }
            View view = b2.get(optString2);
            if (view == null || view.getParent() == null) {
                c(obj, "view is null");
                o.a(b, "bringViewToFront failed: view is null");
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup == null) {
                c(obj, "parent is null");
                o.a(b, "bringViewToFront failed: parent is null");
                return;
            }
            viewGroup.bringChildToFront(view);
            a(obj, optString2);
            a(obj, "onBringViewToFront", optString2);
            o.a(b, "bringViewToFront instanceId = ".concat(String.valueOf(optString2)));
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "bringViewToFront failed: " + th.getMessage());
        }
    }

    public final void n(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String h2 = h(optString2);
            String str = h2;
            if (TextUtils.isEmpty(h2)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                str = h2;
                if (aVar.f4263a != null) {
                    str = aVar.f4263a.getRid();
                }
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, str);
            if (!b2.containsKey(optString2)) {
                c(obj, "instanceId not exist");
                o.a(b, "hideView failed: instanceId not exist");
                return;
            }
            View view = b2.get(optString2);
            if (view == null) {
                c(obj, "view not exist");
                o.a(b, "hideView failed: view not exist");
                return;
            }
            view.setVisibility(8);
            a(obj, optString2);
            a(obj, "onHideView", optString2);
            o.a(b, "hideView instanceId = ".concat(String.valueOf(optString2)));
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "hideView failed: + " + th.getMessage());
        }
    }

    public final void o(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String h2 = h(optString2);
            String str = h2;
            if (TextUtils.isEmpty(h2)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                str = h2;
                if (aVar.f4263a != null) {
                    str = aVar.f4263a.getRid();
                }
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, str);
            if (!b2.containsKey(optString2)) {
                c(obj, "instanceId not exist");
                o.a(b, "showView failed: instanceId not exist instanceId = ".concat(String.valueOf(optString2)));
                return;
            }
            View view = b2.get(optString2);
            if (view == null) {
                c(obj, "view not exist");
                o.a(b, "showView failed: view not exist instanceId = ".concat(String.valueOf(optString2)));
                return;
            }
            view.setVisibility(0);
            a(obj, optString2);
            a(obj, "onShowView", optString2);
            o.a(b, "showView instanceId = ".concat(String.valueOf(optString2)));
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "showView failed: " + th.getMessage());
        }
    }

    public final void p(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String h2 = h(optString2);
            String str = h2;
            if (TextUtils.isEmpty(h2)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                str = h2;
                if (aVar.f4263a != null) {
                    str = aVar.f4263a.getRid();
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            String optString3 = optJSONObject.optString("color");
            if (TextUtils.isEmpty(optString3)) {
                c(obj, "color is not exist");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, str);
            if (!b2.containsKey(optString2)) {
                c(obj, "instanceId not exist");
                o.a(b, "setViewBgColor failed: instanceId not exist instanceId = ".concat(String.valueOf(optString2)));
                return;
            }
            View view = b2.get(optString2);
            if (view == null) {
                c(obj, "view not exist");
                o.a(b, "setViewBgColor failed: view not exist instanceId = ".concat(String.valueOf(optString2)));
                return;
            }
            a(obj, optString2);
            view.setBackgroundColor(Color.parseColor(optString3));
            a(obj, "onViewBgColorChanged", optString2);
            o.a(b, "setViewBgColor instanceId = ".concat(String.valueOf(optString2)));
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "setViewBgColor failed: " + th.getMessage());
        }
    }

    public final void q(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String h2 = h(optString2);
            String str = h2;
            if (TextUtils.isEmpty(h2)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                str = h2;
                if (aVar.f4263a != null) {
                    str = aVar.f4263a.getRid();
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            double optDouble = optJSONObject.optDouble("alpha", 1.0d);
            LinkedHashMap<String, View> b2 = b(optString, str);
            if (!b2.containsKey(optString2)) {
                c(obj, "instanceId not exist");
                o.a(b, "setViewAlpha failed: instanceId not exist instanceId = ".concat(String.valueOf(optString2)));
                return;
            }
            View view = b2.get(optString2);
            if (view == null) {
                c(obj, "view not exist");
                o.a(b, "setViewAlpha failed: view not exist instanceId = ".concat(String.valueOf(optString2)));
                return;
            }
            view.setAlpha((float) optDouble);
            a(obj, optString2);
            a(obj, "onViewAlphaChanged", optString2);
            o.a(b, "setViewAlpha instanceId = ".concat(String.valueOf(optString2)));
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "setViewAlpha failed: " + th.getMessage());
        }
    }

    public final void r(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String h2 = h(optString2);
            String str = h2;
            if (TextUtils.isEmpty(h2)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                str = h2;
                if (aVar.f4263a != null) {
                    str = aVar.f4263a.getRid();
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            double optDouble = optJSONObject.optDouble("vertical", 1.0d);
            double optDouble2 = optJSONObject.optDouble("horizon", 1.0d);
            LinkedHashMap<String, View> b2 = b(optString, str);
            if (!b2.containsKey(optString2)) {
                c(obj, "instanceId not exist");
                o.a(b, "setViewScale failed: instanceId not exist instanceId = ".concat(String.valueOf(optString2)));
                return;
            }
            View view = b2.get(optString2);
            if (view == null) {
                c(obj, "view not exist");
                o.a(b, "setViewScale failed: view not exist instanceId = ".concat(String.valueOf(optString2)));
                return;
            }
            view.setScaleX((float) optDouble2);
            view.setScaleY((float) optDouble);
            a(obj, optString2);
            a(obj, "onViewScaleChanged", optString2);
            o.a(b, "setViewScale instanceId = ".concat(String.valueOf(optString2)));
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "setViewScale failed: " + th.getMessage());
        }
    }

    public final void s(Object obj, JSONObject jSONObject) {
        int optInt;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String h2 = h(optString2);
            String str = h2;
            if (TextUtils.isEmpty(h2)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                str = h2;
                if (aVar.f4263a != null) {
                    str = aVar.f4263a.getRid();
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            String optString3 = optJSONObject.optString("targetComponentId");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
            LinkedHashMap<String, View> b2 = b(optString, str);
            if (!b2.containsKey(optString2) || !b2.containsKey(optString3)) {
                c(obj, "instanceId not exist");
                o.a(b, "insertViewAbove failed: instanceId not exist instanceId = ".concat(String.valueOf(optString2)));
                return;
            }
            View view = b2.get(optString2);
            View view2 = b2.get(optString3);
            if (view2 == null || view2.getParent() == null) {
                c(obj, "view not exist");
                o.a(b, "insertViewAbove failed: view not exist instanceId = ".concat(String.valueOf(optString2)));
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            int indexOfChild = viewGroup.indexOfChild(view2);
            Rect rect = null;
            int i2 = 0;
            if (optJSONObject2 != null) {
                rect = new Rect(optJSONObject2.optInt("left", f5450a), optJSONObject2.optInt(Constant.MAP_KEY_TOP, f5450a), optJSONObject2.optInt("right", f5450a), optJSONObject2.optInt("bottom", f5450a));
                i2 = optJSONObject2.optInt("width");
                optInt = optJSONObject2.optInt("height");
            } else if (view instanceof BTBaseView) {
                rect = ((BTBaseView) view).getRect();
                i2 = ((BTBaseView) view).getViewWidth();
                optInt = ((BTBaseView) view).getViewHeight();
            } else {
                optInt = 0;
            }
            FrameLayout.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (viewGroup instanceof FrameLayout) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof RelativeLayout) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof LinearLayout) {
                layoutParams = new LinearLayout.LayoutParams(-1, -1);
            }
            ViewGroup.LayoutParams a2 = a(layoutParams, rect, i2, optInt);
            u.a(view);
            viewGroup.addView(view, indexOfChild + 1, a2);
            a(obj, optString2);
            a(obj, "onInsertViewAbove", optString2);
            o.a(b, "insertViewAbove instanceId = " + optString2 + " brotherId = " + optString3);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "insertViewAbove failed: " + th.getMessage());
        }
    }

    public final void t(Object obj, JSONObject jSONObject) {
        int optInt;
        int optInt2;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String h2 = h(optString2);
            String str = h2;
            if (TextUtils.isEmpty(h2)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                str = h2;
                if (aVar.f4263a != null) {
                    str = aVar.f4263a.getRid();
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            String optString3 = optJSONObject.optString("targetComponentId");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
            LinkedHashMap<String, View> b2 = b(optString, str);
            if (!b2.containsKey(optString2) || !b2.containsKey(optString3)) {
                c(obj, "instanceId not exist");
                o.a(b, "insertViewBelow failed: instanceId not exist instanceId = ".concat(String.valueOf(optString2)));
                return;
            }
            View view = b2.get(optString2);
            View view2 = b2.get(optString3);
            if (view2 == null || view2.getParent() == null) {
                c(obj, "view not exist");
                o.a(b, "insertViewBelow failed: view not exist instanceId = ".concat(String.valueOf(optString2)));
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            int indexOfChild = viewGroup.indexOfChild(view2);
            Rect rect = null;
            if (optJSONObject2 != null) {
                rect = new Rect(optJSONObject2.optInt("left", f5450a), optJSONObject2.optInt(Constant.MAP_KEY_TOP, f5450a), optJSONObject2.optInt("right", f5450a), optJSONObject2.optInt("bottom", f5450a));
                optInt = optJSONObject2.optInt("width");
                optInt2 = optJSONObject2.optInt("height");
            } else if (view instanceof BTBaseView) {
                rect = ((BTBaseView) view).getRect();
                optInt = ((BTBaseView) view).getViewWidth();
                optInt2 = ((BTBaseView) view).getViewHeight();
            } else {
                optInt = 0;
                optInt2 = 0;
            }
            FrameLayout.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (viewGroup instanceof FrameLayout) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof RelativeLayout) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof LinearLayout) {
                layoutParams = new LinearLayout.LayoutParams(-1, -1);
            }
            ViewGroup.LayoutParams a2 = a(layoutParams, rect, optInt, optInt2);
            u.a(view);
            int i2 = indexOfChild - 1;
            int i3 = 0;
            if (i2 >= 0) {
                i3 = i2;
            }
            viewGroup.addView(view, i3, a2);
            a(obj, optString2);
            a(obj, "onInsertViewBelow", optString2);
            o.a(b, "insertViewBelow instanceId = ".concat(String.valueOf(optString2)));
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "insertViewBelow failed: " + th.getMessage());
        }
    }

    public final void u(Object obj, JSONObject jSONObject) {
        int optInt;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String h2 = h(optString2);
            String str = h2;
            if (TextUtils.isEmpty(h2)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                str = h2;
                if (aVar.f4263a != null) {
                    str = aVar.f4263a.getRid();
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            String optString3 = optJSONObject.optString("targetComponentId");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
            LinkedHashMap<String, View> b2 = b(optString, str);
            if (!b2.containsKey(optString2) || !b2.containsKey(optString3)) {
                c(obj, "instanceId not exist");
                o.a(b, "insertViewAbove failed: instanceId not exist instanceId = ".concat(String.valueOf(optString2)));
                return;
            }
            View view = b2.get(optString2);
            View view2 = b2.get(optString3);
            if (view2 == null || view2.getParent() == null) {
                c(obj, "view not exist");
                o.a(b, "insertViewAbove failed: view not exist instanceId = ".concat(String.valueOf(optString2)));
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            int indexOfChild = viewGroup.indexOfChild(view2);
            Rect rect = null;
            int i2 = 0;
            if (optJSONObject2 != null) {
                rect = new Rect(optJSONObject2.optInt("left", f5450a), optJSONObject2.optInt(Constant.MAP_KEY_TOP, f5450a), optJSONObject2.optInt("right", f5450a), optJSONObject2.optInt("bottom", f5450a));
                i2 = optJSONObject2.optInt("width");
                optInt = optJSONObject2.optInt("height");
            } else if (view instanceof BTBaseView) {
                rect = ((BTBaseView) view).getRect();
                i2 = ((BTBaseView) view).getViewWidth();
                optInt = ((BTBaseView) view).getViewHeight();
            } else {
                optInt = 0;
            }
            FrameLayout.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (viewGroup instanceof FrameLayout) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof RelativeLayout) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof LinearLayout) {
                layoutParams = new LinearLayout.LayoutParams(-1, -1);
            }
            viewGroup.addView(view, indexOfChild + 1, a(layoutParams, rect, i2, optInt));
            a(obj, optString2);
            a(obj, "onInsertViewAbove", optString2);
            o.a(b, "insertViewAbove instanceId = " + optString2 + " brotherId = " + optString3);
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "insertViewAbove failed: " + th.getMessage());
        }
    }

    public final void v(Object obj, JSONObject jSONObject) {
        int optInt;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String h2 = h(optString2);
            String str = h2;
            if (TextUtils.isEmpty(h2)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                str = h2;
                if (aVar.f4263a != null) {
                    str = aVar.f4263a.getRid();
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            String optString3 = optJSONObject.optString("targetComponentId");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("rect");
            LinkedHashMap<String, View> b2 = b(optString, str);
            if (!b2.containsKey(optString2) || !b2.containsKey(optString3)) {
                c(obj, "instanceId not exist");
                o.a(b, "insertViewBelow failed: instanceId not exist instanceId = ".concat(String.valueOf(optString2)));
                return;
            }
            View view = b2.get(optString2);
            View view2 = b2.get(optString3);
            if (view2 == null || view2.getParent() == null) {
                c(obj, "view not exist");
                o.a(b, "insertViewBelow failed: view not exist instanceId = ".concat(String.valueOf(optString2)));
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view2.getParent();
            int indexOfChild = viewGroup.indexOfChild(view2);
            Rect rect = null;
            int i2 = 0;
            if (optJSONObject2 != null) {
                rect = new Rect(optJSONObject2.optInt("left", f5450a), optJSONObject2.optInt(Constant.MAP_KEY_TOP, f5450a), optJSONObject2.optInt("right", f5450a), optJSONObject2.optInt("bottom", f5450a));
                i2 = optJSONObject2.optInt("width");
                optInt = optJSONObject2.optInt("height");
            } else if (view instanceof BTBaseView) {
                rect = ((BTBaseView) view).getRect();
                i2 = ((BTBaseView) view).getViewWidth();
                optInt = ((BTBaseView) view).getViewHeight();
            } else {
                optInt = 0;
            }
            FrameLayout.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (viewGroup instanceof FrameLayout) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof RelativeLayout) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            } else if (viewGroup instanceof LinearLayout) {
                layoutParams = new LinearLayout.LayoutParams(-1, -1);
            }
            viewGroup.addView(view, indexOfChild, a(layoutParams, rect, i2, optInt));
            a(obj, optString2);
            a(obj, "onInsertViewBelow", optString2);
            o.a(b, "insertViewBelow instanceId = ".concat(String.valueOf(optString2)));
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "insertViewBelow failed: " + th.getMessage());
        }
    }

    public final void w(Object obj, JSONObject jSONObject) {
        String str;
        int i2;
        int i3;
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String h2 = h(optString2);
            String str2 = h2;
            if (TextUtils.isEmpty(h2)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                str2 = h2;
                if (aVar.f4263a != null) {
                    str2 = aVar.f4263a.getRid();
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                c(obj, "data is empty");
                return;
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("content");
            if (optJSONObject2 == null) {
                c(obj, "content is empty");
                return;
            }
            String optString3 = optJSONObject2.optString("fileURL");
            String optString4 = optJSONObject2.optString("filePath");
            String optString5 = optJSONObject2.optString(com.baidu.mobads.sdk.internal.a.f);
            if (TextUtils.isEmpty(optString3) && TextUtils.isEmpty(optString4) && TextUtils.isEmpty(optString5)) {
                c(obj, "url is empty");
                return;
            }
            JSONArray optJSONArray = optJSONObject2.optJSONArray("campaigns");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= length) {
                        break;
                    }
                    com.anythink.expressad.foundation.d.c b2 = com.anythink.expressad.foundation.d.c.b(optJSONArray.getJSONObject(i5));
                    if (b2 != null) {
                        b2.l(optString);
                        arrayList.add(b2);
                    }
                    i4 = i5 + 1;
                }
            }
            String optString6 = optJSONObject2.optString("unitId");
            d a2 = d.a(optJSONObject2.optJSONObject("unitSetting"));
            if (a2 != null) {
                a2.a(optString6);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("rect");
            Rect rect = new Rect(f5450a, f5450a, f5450a, f5450a);
            if (optJSONObject3 != null) {
                try {
                    rect = new Rect(optJSONObject3.optInt("left", f5450a), optJSONObject3.optInt(Constant.MAP_KEY_TOP, f5450a), optJSONObject3.optInt("right", f5450a), optJSONObject3.optInt("bottom", f5450a));
                    i3 = optJSONObject3.optInt("width");
                    i2 = optJSONObject3.optInt("height");
                } catch (Throwable th) {
                    th = th;
                    str = b;
                    c(obj, th.getMessage());
                    o.a(str, "webviewLoad failed: " + th.getMessage());
                }
            } else {
                i2 = 0;
                i3 = 0;
            }
            int optInt = optJSONObject2.optInt("refreshCache", 0);
            try {
                LinkedHashMap<String, View> b3 = b(optString, str2);
                boolean containsKey = b3.containsKey(optString2);
                try {
                    if (!containsKey) {
                        c(obj, "instanceId not exist");
                        o.a(b, "webviewLoad failed: instanceId not exist instanceId = ".concat(String.valueOf(optString2)));
                        return;
                    }
                    View view = b3.get(optString2);
                    if (!(view instanceof AnythinkBTWebView)) {
                        c(obj, "view not exist");
                        o.a(b, "webviewLoad failed: view not exist instanceId = ".concat(String.valueOf(optString2)));
                        return;
                    }
                    AnythinkBTWebView anythinkBTWebView = (AnythinkBTWebView) view;
                    anythinkBTWebView.setHtml(optString5);
                    anythinkBTWebView.setFilePath(optString4);
                    anythinkBTWebView.setFileURL(optString3);
                    anythinkBTWebView.setRect(rect);
                    anythinkBTWebView.setLayout(i3, i2);
                    anythinkBTWebView.setCampaigns(arrayList);
                    anythinkBTWebView.setRewardUnitSetting(a2);
                    anythinkBTWebView.webviewLoad(optInt);
                    a(obj, optString2);
                    o.a(b, "webviewLoad instanceId = ".concat(String.valueOf(optString2)));
                } catch (Throwable unused) {
                    str = b;
                    th = containsKey ? 1 : 0;
                    c(obj, th.getMessage());
                    o.a(str, "webviewLoad failed: " + th.getMessage());
                }
            } catch (Throwable th2) {
                th = th2;
                str = b;
                c(obj, th.getMessage());
                o.a(str, "webviewLoad failed: " + th.getMessage());
            }
        } catch (Throwable th3) {
            th = th3;
            str = b;
        }
    }

    public final void x(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String h2 = h(optString2);
            String str = h2;
            if (TextUtils.isEmpty(h2)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                str = h2;
                if (aVar.f4263a != null) {
                    str = aVar.f4263a.getRid();
                }
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, str);
            if (!b2.containsKey(optString2)) {
                c(obj, "instanceId not exist");
                o.a(b, "webviewReload failed instanceId not exist instanceId = ".concat(String.valueOf(optString2)));
                return;
            }
            View view = b2.get(optString2);
            if (!(view instanceof AnythinkBTWebView)) {
                c(obj, "view not exist");
                o.a(b, "webviewReload failed view not exist instanceId = ".concat(String.valueOf(optString2)));
            } else if (((AnythinkBTWebView) view).webviewReload()) {
                a(obj, optString2);
                o.a(b, "webviewReload instanceId = ".concat(String.valueOf(optString2)));
            } else {
                c(obj, "reload failed");
                o.a(b, "webviewReload failed reload failed instanceId = ".concat(String.valueOf(optString2)));
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "webviewReload failed: " + th.getMessage());
        }
    }

    public final void y(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String h2 = h(optString2);
            String str = h2;
            if (TextUtils.isEmpty(h2)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                str = h2;
                if (aVar.f4263a != null) {
                    str = aVar.f4263a.getRid();
                }
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, str);
            if (!b2.containsKey(optString2)) {
                c(obj, "instanceId not exist");
                o.a(b, "webviewGoBack failed instanceId not exist instanceId = ".concat(String.valueOf(optString2)));
                return;
            }
            View view = b2.get(optString2);
            if (!(view instanceof AnythinkBTWebView)) {
                c(obj, "view not exist");
                o.a(b, "webviewGoBack failed view not exist instanceId = ".concat(String.valueOf(optString2)));
            } else if (((AnythinkBTWebView) view).webviewGoBack()) {
                a(obj, optString2);
                o.a(b, "webviewGoBack instanceId = ".concat(String.valueOf(optString2)));
            } else {
                c(obj, "webviewGoBack failed");
                o.a(b, "webviewGoBack failed instanceId = ".concat(String.valueOf(optString2)));
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "webviewGoBack failed: " + th.getMessage());
        }
    }

    public final void z(Object obj, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("unitId");
            String optString2 = jSONObject.optString("id");
            String h2 = h(optString2);
            String str = h2;
            if (TextUtils.isEmpty(h2)) {
                com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
                str = h2;
                if (aVar.f4263a != null) {
                    str = aVar.f4263a.getRid();
                }
            }
            if (jSONObject.optJSONObject("data") == null) {
                c(obj, "data is empty");
                return;
            }
            LinkedHashMap<String, View> b2 = b(optString, str);
            if (!b2.containsKey(optString2)) {
                c(obj, "instanceId not exist");
                o.a(b, "webviewGoForward failed instanceId not exist instanceId = ".concat(String.valueOf(optString2)));
                return;
            }
            View view = b2.get(optString2);
            if (!(view instanceof AnythinkBTWebView)) {
                c(obj, "view not exist");
                o.a(b, "webviewGoForward failed view not exist instanceId = ".concat(String.valueOf(optString2)));
            } else if (((AnythinkBTWebView) view).webviewGoForward()) {
                a(obj, optString2);
                o.a(b, "webviewGoForward instanceId = ".concat(String.valueOf(optString2)));
            } else {
                c(obj, "webviewGoForward failed");
                o.a(b, "webviewGoForward failed instanceId = ".concat(String.valueOf(optString2)));
            }
        } catch (Throwable th) {
            c(obj, th.getMessage());
            o.a(b, "webviewGoForward failed: " + th.getMessage());
        }
    }
}
