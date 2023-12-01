package com.baidu.mobads.sdk.api;

import java.util.HashMap;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/BaiduNativeFeedSession.class */
public class BaiduNativeFeedSession {
    private static HashMap<String, String> sessionHashMap = new HashMap<>();
    private static BaiduNativeFeedSession theInstance;

    private BaiduNativeFeedSession() {
    }

    public static BaiduNativeFeedSession getInstance() {
        BaiduNativeFeedSession baiduNativeFeedSession;
        synchronized (BaiduNativeFeedSession.class) {
            try {
                if (theInstance == null) {
                    theInstance = new BaiduNativeFeedSession();
                }
                baiduNativeFeedSession = theInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return baiduNativeFeedSession;
    }

    public int getSequenceId(int i) {
        int i2 = 1;
        if (i < 1) {
            return 1;
        }
        try {
            HashMap<String, String> hashMap = sessionHashMap;
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append("");
            if (!hashMap.containsKey(sb.toString())) {
                HashMap<String, String> hashMap2 = sessionHashMap;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i);
                sb2.append("");
                hashMap2.put(sb2.toString(), "1");
                return 1;
            }
            HashMap<String, String> hashMap3 = sessionHashMap;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(i);
            sb3.append("");
            int parseInt = Integer.parseInt(hashMap3.get(sb3.toString())) + 1;
            if (parseInt >= 1) {
                i2 = parseInt;
            }
            HashMap<String, String> hashMap4 = sessionHashMap;
            int i3 = i2;
            StringBuilder sb4 = new StringBuilder();
            int i4 = i2;
            sb4.append(i);
            int i5 = i2;
            sb4.append("");
            int i6 = i2;
            String sb5 = sb4.toString();
            int i7 = i2;
            StringBuilder sb6 = new StringBuilder();
            int i8 = i2;
            sb6.append(i2);
            int i9 = i2;
            sb6.append("");
            int i10 = i2;
            hashMap4.put(sb5, sb6.toString());
            return i2;
        } catch (Exception e) {
            return 1;
        }
    }
}
