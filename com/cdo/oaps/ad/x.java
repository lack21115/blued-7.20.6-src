package com.cdo.oaps.ad;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

/* loaded from: source-7206380-dex2jar.jar:com/cdo/oaps/ad/x.class */
public class x {
    public static float a(Context context) {
        float f;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo("com.nearme.gamecenter", 128);
            f = -1.0f;
            if (applicationInfo.metaData != null) {
                f = -1.0f;
                if (applicationInfo.metaData.containsKey("oaps_version")) {
                    Object obj = applicationInfo.metaData.get("oaps_version");
                    f = -1.0f;
                    if (obj != null) {
                        f = obj instanceof Number ? ((Number) obj).floatValue() : Float.valueOf(obj.toString()).floatValue();
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            f = -1.0f;
        } catch (Throwable th) {
            th.printStackTrace();
            f = -1.0f;
        }
        return f > 0.0f ? f : w.b(context);
    }
}
