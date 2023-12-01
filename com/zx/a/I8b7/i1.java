package com.zx.a.I8b7;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.zx.module.annotation.Java2C;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import org.json.JSONArray;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/i1.class */
public class i1 {
    public static String a(Context context) throws Exception {
        String str;
        if (TextUtils.isEmpty(t2.f)) {
            if (context != null) {
                try {
                    str = b(context).getString("ZX_APPID");
                } catch (Exception e) {
                    z1.a(e);
                    str = null;
                }
                if (TextUtils.isEmpty(str)) {
                    if (t2.e == null) {
                        c(context);
                    }
                    if (!TextUtils.isEmpty(t2.e)) {
                        if (TextUtils.isEmpty(t2.g)) {
                            t2.g = context.getPackageName();
                        }
                        return a(t2.g);
                    }
                    throw new IllegalStateException("ZX_APPID not found");
                }
                return str;
            }
            throw new RuntimeException("context not provided, cannot be null");
        }
        return t2.f;
    }

    @Java2C.Method2C
    private static native String a(String str) throws NoSuchAlgorithmException, InvalidKeyException;

    public static JSONArray a() {
        Bundle b;
        JSONArray jSONArray = new JSONArray();
        try {
            b = b(t2.f28510a);
        } catch (PackageManager.NameNotFoundException e) {
            z1.a(e);
        }
        if (b == null) {
            return jSONArray;
        }
        for (String str : b.keySet()) {
            if (str.startsWith("ZX_APPID_")) {
                String string = b.getString(str);
                if (!TextUtils.isEmpty(string)) {
                    jSONArray.put(string);
                }
            }
        }
        return jSONArray;
    }

    public static Bundle b(Context context) throws PackageManager.NameNotFoundException {
        if (t2.G == null) {
            PackageManager c2 = d3.c(context.getApplicationContext());
            if (TextUtils.isEmpty(t2.g)) {
                t2.g = context.getPackageName();
            }
            t2.G = c2.getApplicationInfo(t2.g, 128).metaData;
        }
        return t2.G;
    }

    @Java2C.Method2C
    private static native String b();

    public static void c(Context context) {
        try {
            t2.e = b(context).getString("ZX_CHANNEL_ID");
            z1.a("initChannelId: , channelId = '" + t2.e + "'");
        } catch (Exception e) {
            z1.a(e);
        }
    }
}
