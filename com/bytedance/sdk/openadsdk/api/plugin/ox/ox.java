package com.bytedance.sdk.openadsdk.api.plugin.ox;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.JProtect;
import java.security.SecureRandom;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/api/plugin/ox/ox.class */
public class ox {
    private static SecureRandom b() {
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                return SecureRandom.getInstanceStrong();
            } catch (Throwable th) {
                return new SecureRandom();
            }
        }
        return new SecureRandom();
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
        if (r0.length() != 32) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String mb() {
        /*
            r0 = 16
            java.lang.String r0 = mb(r0)
            r4 = r0
            r0 = r4
            if (r0 == 0) goto L15
            r0 = r4
            r3 = r0
            r0 = r4
            int r0 = r0.length()
            r1 = 32
            if (r0 == r1) goto L17
        L15:
            r0 = 0
            r3 = r0
        L17:
            r0 = r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.api.plugin.ox.ox.mb():java.lang.String");
    }

    public static String mb(int i) {
        try {
            byte[] bArr = new byte[i];
            b().nextBytes(bArr);
            return b.mb(bArr);
        } catch (Exception e) {
            return null;
        }
    }

    @JProtect
    public static String mb(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String mb = mb();
        String mb2 = mb(mb, 32);
        String ox = ox();
        String str2 = null;
        if (mb2 != null) {
            str2 = null;
            if (ox != null) {
                str2 = mb.mb(str, ox, mb2);
            }
        }
        return 3 + mb + ox + str2;
    }

    public static String mb(String str, int i) {
        if (str == null || str.length() != i) {
            return null;
        }
        int i2 = i / 2;
        return str.substring(i2, i) + str.substring(0, i2);
    }

    @JProtect
    public static JSONObject mb(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject2;
        }
        try {
            String mb = mb(jSONObject.toString());
            if (TextUtils.isEmpty(mb)) {
                jSONObject2.put("message", jSONObject.toString());
                jSONObject2.put("cypher", 0);
                return jSONObject2;
            }
            jSONObject2.put("message", mb);
            jSONObject2.put("cypher", 3);
            return jSONObject2;
        } catch (Throwable th) {
            try {
                jSONObject2.put("message", jSONObject.toString());
                jSONObject2.put("cypher", 0);
                return jSONObject2;
            } catch (Throwable th2) {
                return jSONObject2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
        if (r0.length() != 16) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String ox() {
        /*
            r0 = 8
            java.lang.String r0 = mb(r0)
            r4 = r0
            r0 = r4
            if (r0 == 0) goto L15
            r0 = r4
            r3 = r0
            r0 = r4
            int r0 = r0.length()
            r1 = 16
            if (r0 == r1) goto L17
        L15:
            r0 = 0
            r3 = r0
        L17:
            r0 = r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.api.plugin.ox.ox.ox():java.lang.String");
    }
}
