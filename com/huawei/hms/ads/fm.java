package com.huawei.hms.ads;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/fm.class */
public class fm {
    private static final byte[] I = new byte[0];
    private static fm V;
    private final Map<String, Class<? extends ac>> B;
    private final Map<String, ac> Z = new HashMap();

    private fm() {
        HashMap hashMap = new HashMap();
        this.B = hashMap;
        hashMap.put(ai.Z, fp.class);
        this.B.put(ai.i, fu.class);
    }

    public static fm Code() {
        fm fmVar;
        synchronized (I) {
            if (V == null) {
                V = new fm();
            }
            fmVar = V;
        }
        return fmVar;
    }

    public ac Code(String str) {
        StringBuilder sb;
        String str2;
        String sb2;
        if (!TextUtils.isEmpty(str)) {
            ac acVar = this.Z.get(str);
            ac acVar2 = acVar;
            if (acVar == null) {
                ge.Code("JsbInterstitialManger", "create command %s", str);
                Class<? extends ac> cls = this.B.get(str);
                if (cls == null) {
                    sb = new StringBuilder();
                    str2 = "no class found for cmd: ";
                } else {
                    try {
                        acVar = cls.newInstance();
                    } catch (InstantiationException e) {
                        ge.I("JsbInterstitialManger", "get cmd %s Instantiation Exception", str);
                    } catch (Throwable th) {
                        ge.I("JsbInterstitialManger", "get cmd %s: %s", str, th.getClass().getSimpleName());
                    }
                    if (acVar == null) {
                        sb = new StringBuilder();
                        str2 = "no instance created for cmd: ";
                    } else {
                        this.Z.put(str, acVar);
                        acVar2 = acVar;
                    }
                }
                sb.append(str2);
                sb.append(str);
                sb2 = sb.toString();
            }
            return acVar2;
        }
        sb2 = "get cmd, method is empty";
        ge.I("JsbInterstitialManger", sb2);
        return null;
    }
}
