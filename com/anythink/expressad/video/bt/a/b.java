package com.anythink.expressad.video.bt.a;

import android.text.TextUtils;
import android.util.Base64;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.h.o;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/bt/a/b.class */
public final class b {

    /* renamed from: c  reason: collision with root package name */
    private static final String f8287c = "HandlerH5MessageManager";

    /* renamed from: a  reason: collision with root package name */
    int f8288a;
    int b;
    private String d;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/bt/a/b$a.class */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static b f8289a = new b((byte) 0);

        private a() {
        }
    }

    private b() {
        this.d = "handlerNativeResult";
        this.f8288a = 0;
        this.b = 1;
    }

    /* synthetic */ b(byte b) {
        this();
    }

    public static b a() {
        return a.f8289a;
    }

    private static void a(int i, String str, Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            jSONObject.put("message", str);
            j.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (JSONException e) {
            o.a(f8287c, e.getMessage());
        } catch (Throwable th) {
            o.a(f8287c, th.getMessage());
        }
    }

    public final void a(Object obj, JSONObject jSONObject) {
        try {
            if (TextUtils.isEmpty(jSONObject.toString())) {
                a(this.b, "params is null", obj);
                return;
            }
            String optString = jSONObject.optString("uniqueIdentifier");
            String optString2 = jSONObject.optString("name");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                JSONArray optJSONArray = jSONObject.optJSONArray(PushConstants.PARAMS);
                JSONObject optJSONObject = jSONObject.optJSONObject("result");
                if (optJSONObject != null && !TextUtils.isEmpty(optJSONObject.toString())) {
                    optJSONObject.optInt("type", 0);
                }
                a(this.f8288a, "receivedMessage", obj);
                if (optString.equalsIgnoreCase("reporter") || !optString.equalsIgnoreCase("MediaPlayer")) {
                    return;
                }
                com.anythink.expressad.video.bt.a.a.a().a(obj, optString2, optJSONArray);
                return;
            }
            a(this.b, "module or method is null", obj);
        } catch (Exception e) {
            o.a(f8287c, e.getMessage());
            a(this.b, e.getMessage(), obj);
        } catch (Throwable th) {
            o.a(f8287c, th.getMessage());
            a(this.b, th.getMessage(), obj);
        }
    }
}
