package com.tencent.thumbplayer.core.player;

import android.view.Surface;
import java.util.Iterator;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/player/TPNativePlayerUtils.class */
public class TPNativePlayerUtils {
    static boolean isTPNativePlayerSurface(Surface surface) {
        return surface instanceof TPNativePlayerSurface;
    }

    public static String[] tpMapStringToStringArray(Map<String, String> map) {
        String[] strArr;
        int i = 0;
        if (map != null && !map.isEmpty()) {
            String[] strArr2 = new String[map.size() * 2];
            Iterator<String> it = map.keySet().iterator();
            while (true) {
                strArr = strArr2;
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                int i2 = i * 2;
                strArr2[i2] = next;
                strArr2[i2 + 1] = map.get(next);
                i++;
            }
        } else {
            strArr = new String[0];
        }
        return strArr;
    }
}
