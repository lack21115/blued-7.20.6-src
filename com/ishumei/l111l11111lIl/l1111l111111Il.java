package com.ishumei.l111l11111lIl;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.ishumei.l1111l111111Il.l111l1111llIl;
import com.ishumei.l1111l111111Il.l11l1111I1l;
import com.ishumei.l111l1111llIl.l111l1111lI1l;
import com.ishumei.l111l1111llIl.l111l1111lIl;
import com.ishumei.l111l1111llIl.l11l1111lIIl;
import com.ishumei.smantifraud.SmAntiFraud;
import com.umeng.analytics.pro.bh;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l11111lIl/l1111l111111Il.class */
public class l1111l111111Il {
    private static final String l1111l111111Il = "sm";
    private static final String l111l11111I1l = "conf";
    private static final String l111l11111Il = "zaq1mko0";
    private static final String l111l11111lIl = "cloudms.conf";
    private volatile l111l11111lIl l111l1111l1Il;
    private String l111l1111lI1l;
    private String l111l1111lIl;
    private Context l111l1111llIl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ishumei.l111l11111lIl.l1111l111111Il$l1111l111111Il  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l11111lIl/l1111l111111Il$l1111l111111Il.class */
    public static final class C0455l1111l111111Il {
        private static final l1111l111111Il l1111l111111Il = new l1111l111111Il((byte) 0);

        private C0455l1111l111111Il() {
        }
    }

    private l1111l111111Il() {
        Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
        if (context != null) {
            this.l111l1111llIl = context.getApplicationContext();
        }
    }

    /* synthetic */ l1111l111111Il(byte b) {
        this();
    }

    public static l1111l111111Il l1111l111111Il() {
        return C0455l1111l111111Il.l1111l111111Il;
    }

    private l111l11111lIl l1111l111111Il(Context context) {
        String l111l11111lIl2 = l111l11111lIl(context);
        if (l111l1111lI1l.l111l11111I1l(l111l11111lIl2)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(l111l11111lIl2);
        int i = jSONObject.getInt("length");
        int i2 = 0;
        int i3 = jSONObject.has("enc") ? jSONObject.getInt("enc") : 0;
        if (jSONObject.has("ver")) {
            i2 = jSONObject.getInt("ver");
        }
        l111l11111lIl l1111l111111Il2 = l1111l111111Il(jSONObject.getString("data"), i, i3, i2);
        l1111l111111Il2.l1111l111111Il("local");
        return l1111l111111Il2;
    }

    private l111l11111lIl l1111l111111Il(String str) {
        JSONObject jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            if (1100 == jSONObject2.getInt("code") && (jSONObject = jSONObject2.getJSONObject("detail")) != null && jSONObject.getInt("code") == 0) {
                int i = jSONObject.getInt("length");
                int i2 = jSONObject.has("enc") ? jSONObject.getInt("enc") : 0;
                int i3 = jSONObject.has("ver") ? jSONObject.getInt("ver") : 0;
                String string = jSONObject.getString("data");
                l111l11111lIl l1111l111111Il2 = l1111l111111Il(string, i, i2, i3);
                l1111l111111Il2.l1111l111111Il("cloud");
                HashMap hashMap = new HashMap();
                hashMap.put("data", string);
                hashMap.put("length", Integer.valueOf(i));
                hashMap.put("enc", Integer.valueOf(i2));
                hashMap.put("ver", Integer.valueOf(i3));
                Context context = this.l111l1111llIl;
                String jSONObject3 = l111l1111lIl.l1111l111111Il((Map<?, ?>) hashMap).toString();
                SharedPreferences.Editor edit = context.getSharedPreferences(l111l11111lIl, 0).edit();
                edit.putString("conf", jSONObject3);
                if (edit.commit()) {
                    return l1111l111111Il2;
                }
                throw new IOException("editor commit failed");
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    private static l111l11111lIl l1111l111111Il(String str, int i, int i2, int i3) {
        String l1111l111111Il2;
        if (str == null) {
            return null;
        }
        try {
            byte[] l111l1111llIl = l111l1111lIl.l111l1111llIl(str);
            if (i2 == 1) {
                byte[] l1111l111111Il3 = l11l1111lIIl.l1111l111111Il(com.ishumei.l111l1111llIl.l1111l111111Il.l111l11111lIl(l111l11111Il, l111l1111llIl, i));
                l1111l111111Il2 = new String(l1111l111111Il3, 0, l1111l111111Il3.length, "utf-8");
            } else {
                l1111l111111Il2 = com.ishumei.l111l1111llIl.l1111l111111Il.l1111l111111Il(l111l11111Il, l111l1111llIl, i);
            }
            return i3 == 1 ? l111l11111lIl.l111l11111lIl(l1111l111111Il2) : l111l11111lIl.l111l11111I1l(l1111l111111Il2);
        } catch (Exception e) {
            return null;
        }
    }

    private static void l1111l111111Il(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences(l111l11111lIl, 0).edit();
        edit.putString("conf", str);
        if (!edit.commit()) {
            throw new IOException("editor commit failed");
        }
    }

    static /* synthetic */ void l1111l111111Il(l1111l111111Il l1111l111111il) {
        try {
            if (TextUtils.isEmpty(l1111l111111il.l111l1111lIl)) {
                return;
            }
            com.ishumei.l111l1111l1Il.l1111l111111Il l1111l111111Il2 = com.ishumei.l111l1111l1Il.l1111l111111Il.l1111l111111Il(l1111l111111il.l111l1111lIl);
            l111l11111lIl l111l11111lIl2 = l1111l111111il.l111l11111lIl();
            String l11l1111Il1l = l111l11111lIl2 == null ? "" : l111l11111lIl2.l11l1111Il1l();
            String str = l111l1111llIl.l1111l111111Il.l111l1111l1Il;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("organization", l1111l111111il.l111l1111lI1l);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(bh.x, "android");
            jSONObject2.put("sdkver", "3.0.6");
            jSONObject2.put("md5", l11l1111Il1l);
            jSONObject2.put("enc", 1);
            jSONObject2.put("bb", l11l1111I1l.l1111l111111Il().l111l11111lIl());
            jSONObject2.put("sid", str);
            jSONObject.put("data", jSONObject2);
            l1111l111111il.l111l1111l1Il = l1111l111111il.l1111l111111Il(new com.ishumei.l111l1111l1Il.l111l11111I1l().l1111l111111Il(l1111l111111Il2).l1111l111111Il(jSONObject.toString().getBytes("utf-8"), null));
        } catch (Exception e) {
        }
    }

    private l111l11111lIl l111l11111Il() {
        try {
            l111l11111lIl l111l11111lil = null;
            String string = this.l111l1111llIl.getSharedPreferences(l111l11111lIl, 0).getString("conf", null);
            if (!l111l1111lI1l.l111l11111I1l(string)) {
                JSONObject jSONObject = new JSONObject(string);
                l111l11111lil = l1111l111111Il(jSONObject.getString("data"), jSONObject.getInt("length"), jSONObject.has("enc") ? jSONObject.getInt("enc") : 0, jSONObject.has("ver") ? jSONObject.getInt("ver") : 0);
                l111l11111lil.l1111l111111Il("local");
            }
            if (l111l11111lil != null) {
                return l111l11111lil;
            }
        } catch (Exception e) {
            Log.getStackTraceString(e);
        }
        try {
            JSONObject jSONObject2 = new JSONObject("{\"code\":0,\"data\":\"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\",\"enc\":1,\"length\":5866,\"ver\":1}");
            int i = jSONObject2.getInt("length");
            int i2 = jSONObject2.has("enc") ? jSONObject2.getInt("enc") : 0;
            int i3 = 0;
            if (jSONObject2.has("ver")) {
                i3 = jSONObject2.getInt("ver");
            }
            l111l11111lIl l1111l111111Il2 = l1111l111111Il(jSONObject2.getString("data"), i, i2, i3);
            l1111l111111Il2.l1111l111111Il("code");
            return l1111l111111Il2;
        } catch (Exception e2) {
            return new l111l11111lIl();
        }
    }

    private static String l111l11111lIl(Context context) {
        return context.getSharedPreferences(l111l11111lIl, 0).getString("conf", null);
    }

    private l111l11111lIl l111l1111l1Il() {
        JSONObject jSONObject = new JSONObject("{\"code\":0,\"data\":\"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\",\"enc\":1,\"length\":5866,\"ver\":1}");
        int i = jSONObject.getInt("length");
        int i2 = 0;
        int i3 = jSONObject.has("enc") ? jSONObject.getInt("enc") : 0;
        if (jSONObject.has("ver")) {
            i2 = jSONObject.getInt("ver");
        }
        l111l11111lIl l1111l111111Il2 = l1111l111111Il(jSONObject.getString("data"), i, i3, i2);
        l1111l111111Il2.l1111l111111Il("code");
        return l1111l111111Il2;
    }

    private void l111l1111llIl() {
        try {
            if (TextUtils.isEmpty(this.l111l1111lIl)) {
                return;
            }
            com.ishumei.l111l1111l1Il.l1111l111111Il l1111l111111Il2 = com.ishumei.l111l1111l1Il.l1111l111111Il.l1111l111111Il(this.l111l1111lIl);
            l111l11111lIl l111l11111lIl2 = l111l11111lIl();
            String l11l1111Il1l = l111l11111lIl2 == null ? "" : l111l11111lIl2.l11l1111Il1l();
            String str = l111l1111llIl.l1111l111111Il.l111l1111l1Il;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("organization", this.l111l1111lI1l);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(bh.x, "android");
            jSONObject2.put("sdkver", "3.0.6");
            jSONObject2.put("md5", l11l1111Il1l);
            jSONObject2.put("enc", 1);
            jSONObject2.put("bb", l11l1111I1l.l1111l111111Il().l111l11111lIl());
            jSONObject2.put("sid", str);
            jSONObject.put("data", jSONObject2);
            this.l111l1111l1Il = l1111l111111Il(new com.ishumei.l111l1111l1Il.l111l11111I1l().l1111l111111Il(l1111l111111Il2).l1111l111111Il(jSONObject.toString().getBytes("utf-8"), null));
        } catch (Exception e) {
        }
    }

    public final void l1111l111111Il(SmAntiFraud.SmOption smOption) {
        this.l111l1111lI1l = smOption.l11l1111I1ll();
        this.l111l1111lIl = smOption.l111l1111lIl();
    }

    public final void l111l11111I1l() {
        com.ishumei.l111l11111I1l.l1111l111111Il.l111l11111lIl().l1111l111111Il(new Runnable() { // from class: com.ishumei.l111l11111lIl.l1111l111111Il.1
            @Override // java.lang.Runnable
            public final void run() {
                l1111l111111Il.l1111l111111Il(l1111l111111Il.this);
            }
        }, 7);
    }

    public final l111l11111lIl l111l11111lIl() {
        if (this.l111l1111l1Il == null) {
            synchronized (l1111l111111Il.class) {
                try {
                    if (this.l111l1111l1Il == null) {
                        this.l111l1111l1Il = l111l11111Il();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.l111l1111l1Il;
    }
}
