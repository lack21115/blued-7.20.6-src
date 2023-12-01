package com.anythink.expressad.exoplayer.d;

import android.util.Log;
import com.anythink.expressad.exoplayer.k.af;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/d/a.class */
final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4398a = "ClearKeyUtil";

    private a() {
    }

    private static String a(String str) {
        return str.replace('+', '-').replace('/', '_');
    }

    public static byte[] a(byte[] bArr) {
        if (af.f4793a >= 27) {
            return bArr;
        }
        try {
            JSONObject jSONObject = new JSONObject(af.a(bArr));
            StringBuilder sb = new StringBuilder("{\"keys\":[");
            JSONArray jSONArray = jSONObject.getJSONArray("keys");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    sb.append("]}");
                    return af.c(sb.toString());
                }
                if (i2 != 0) {
                    sb.append(",");
                }
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                sb.append("{\"k\":\"");
                sb.append(b(jSONObject2.getString("k")));
                sb.append("\",\"kid\":\"");
                sb.append(b(jSONObject2.getString("kid")));
                sb.append("\",\"kty\":\"");
                sb.append(jSONObject2.getString("kty"));
                sb.append("\"}");
                i = i2 + 1;
            }
        } catch (JSONException e) {
            Log.e(f4398a, "Failed to adjust response data: " + af.a(bArr), e);
            return bArr;
        }
    }

    private static String b(String str) {
        return str.replace('-', '+').replace('_', '/');
    }

    private static byte[] b(byte[] bArr) {
        return af.f4793a >= 27 ? bArr : af.c(af.a(bArr).replace('+', '-').replace('/', '_'));
    }
}
