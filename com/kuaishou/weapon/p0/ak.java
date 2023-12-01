package com.kuaishou.weapon.p0;

import android.content.Context;
import java.io.File;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/ak.class */
public class ak {
    public static boolean a(Context context) {
        try {
            if (!g.a(context, new String[]{"android.permission.READ_EXTERNAL_STORAGE"})) {
                return false;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 2) {
                    return false;
                }
                if (new File(new String[]{"/storage/emulated/0/DCIM/Camera/virtual.mp4", "/storage/emulated/0/DCIM/Camera1/virtual.mp4"}[i2]).exists()) {
                    return true;
                }
                i = i2 + 1;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
