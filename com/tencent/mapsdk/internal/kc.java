package com.tencent.mapsdk.internal;

import android.content.Context;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/kc.class */
public class kc extends ic {

    /* renamed from: c  reason: collision with root package name */
    private static final String f37593c = "Tencent_MapSDK_SUB_CONFIG";
    private static Map<String, ic> d = new HashMap();

    private kc(Context context, String str) {
        this.f37553a = context.getSharedPreferences("Tencent_MapSDK_SUB_CONFIG_" + str, 0);
    }

    public static ic a(Context context, String str) {
        if (f7.b(str)) {
            return lc.a(context);
        }
        if (d.get(str) == null) {
            synchronized (kc.class) {
                try {
                    if (d.get(str) == null) {
                        kc kcVar = new kc(context, str);
                        d.put(str, kcVar);
                        return kcVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return d.get(str);
    }

    public static void a(Context context) {
        try {
            File[] listFiles = new File(context.getFilesDir().getParent() + File.separator + "shared_prefs").listFiles();
            if (listFiles == null) {
                return;
            }
            int length = listFiles.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                File file = listFiles[i2];
                if (file.getName().startsWith(f37593c)) {
                    file.delete();
                }
                i = i2 + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void c() {
        Map<String, ic> map = d;
        if (map != null) {
            map.clear();
        }
    }

    public boolean b(Context context, String str) {
        if (f7.b(str)) {
            return false;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(context.getFilesDir().getParent());
            String str2 = File.separator;
            sb.append(str2);
            sb.append("shared_prefs");
            sb.append(str2);
            sb.append(f37593c);
            sb.append(BridgeUtil.UNDERLINE_STR);
            sb.append(str);
            File file = new File(sb.toString());
            if (file.exists()) {
                return file.delete();
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
