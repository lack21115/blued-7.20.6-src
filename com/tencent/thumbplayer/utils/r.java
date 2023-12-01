package com.tencent.thumbplayer.utils;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/utils/r.class */
public class r {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, Integer> f39452a;

    static {
        HashMap hashMap = new HashMap();
        f39452a = hashMap;
        hashMap.put("http://", 0);
        f39452a.put("https://", 1);
        f39452a.put("rtmp://", 2);
        f39452a.put("webrtc://", 3);
        f39452a.put("file://", 4);
        f39452a.put(BridgeUtil.SPLIT_MARK, 4);
    }

    public static int a(String str) {
        if (str == null) {
            return -1;
        }
        String lowerCase = str.toLowerCase();
        for (Map.Entry<String, Integer> entry : f39452a.entrySet()) {
            if (lowerCase.startsWith(entry.getKey())) {
                return entry.getValue().intValue();
            }
        }
        try {
            return new File(str).exists() ? 4 : -1;
        } catch (Exception e) {
            return -1;
        }
    }
}
