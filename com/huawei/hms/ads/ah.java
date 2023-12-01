package com.huawei.hms.ads;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/ah.class */
public class ah {
    private static final String Code = "JsbCmdManager";
    private static final byte[] I = new byte[0];
    private static ah V;
    private final Map<String, Class<? extends ac>> C;
    private final Map<String, ac> Z = new HashMap();
    private final List<String> B = new ArrayList();

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/ah$a.class */
    public static class a<T> implements Runnable {
        private ac B;
        private final Context Code;
        private final String I;
        private final String V;
        private final RemoteCallResultCallback<String> Z;

        public a(Context context, ac acVar, String str, String str2, RemoteCallResultCallback<String> remoteCallResultCallback) {
            this.Code = context;
            this.V = str;
            this.I = str2;
            this.Z = remoteCallResultCallback;
            this.B = acVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ah.V(this.Code, this.B, this.V, this.I, this.Z);
        }
    }

    private ah() {
        HashMap hashMap = new HashMap();
        this.C = hashMap;
        hashMap.put(ai.V, com.huawei.openalliance.ad.utils.an.Code(com.huawei.openalliance.ad.constant.t.bt));
        this.C.put(ai.I, com.huawei.openalliance.ad.utils.an.Code("com.huawei.openalliance.ad.jsb.JsbRewardProxy"));
        this.C.put(ai.Z, com.huawei.openalliance.ad.utils.an.Code("com.huawei.openalliance.ad.jsb.JsbInterstitialProxy"));
        this.C.put(ai.B, com.huawei.openalliance.ad.utils.an.Code(com.huawei.openalliance.ad.constant.t.by));
        this.C.put(ai.C, ad.class);
        this.C.put(ai.b, ax.class);
        this.C.put(ai.f8829c, ay.class);
        this.C.put(ai.S, bc.class);
        this.C.put(ai.D, ba.class);
        this.C.put(ai.F, bb.class);
        this.C.put(ai.L, aw.class);
        this.C.put(ai.f8828a, aq.class);
        this.C.put(ai.d, av.class);
        this.C.put(ai.g, au.class);
        this.C.put(ai.f, as.class);
        this.C.put(ai.h, com.huawei.openalliance.ad.utils.an.Code("com.huawei.openalliance.ad.jsb.JsbRewardProxy"));
        this.C.put(ai.i, com.huawei.openalliance.ad.utils.an.Code("com.huawei.openalliance.ad.jsb.JsbInterstitialProxy"));
        this.C.put(ai.k, bm.class);
        this.C.put(ai.j, bl.class);
        this.C.put(ai.m, bg.class);
        this.C.put(ai.l, bf.class);
        this.C.put(ai.n, bk.class);
        this.C.put(ai.o, bi.class);
        this.C.put(ai.p, bj.class);
        this.C.put(ai.q, bh.class);
        this.C.put(ai.q, bh.class);
        this.C.put(ai.Code, ak.class);
        this.C.put(ai.r, aj.class);
        this.C.put(ai.v, az.class);
        this.C.put(ai.w, bd.class);
        this.C.put(ai.e, ar.class);
        if (com.huawei.openalliance.ad.utils.an.Code(com.huawei.openalliance.ad.constant.t.bz) != null) {
            this.C.put(ai.s, am.class);
            this.C.put(ai.t, ao.class);
            this.C.put(ai.u, an.class);
        }
        this.C.put(ai.x, al.class);
        this.B.add(ai.C);
        this.B.add(ai.h);
        this.B.add(ai.i);
    }

    public static ah Code() {
        ah ahVar;
        synchronized (I) {
            if (V == null) {
                V = new ah();
            }
            ahVar = V;
        }
        return ahVar;
    }

    public static String V(String str) {
        return new JSONObject(str).optString(com.huawei.openalliance.ad.constant.ao.X);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V(Context context, ac acVar, String str, String str2, RemoteCallResultCallback<String> remoteCallResultCallback) {
        if (acVar == null) {
            String str3 = "api for " + str + " is not found";
            ge.V(Code, "call " + str3);
            af.Code(remoteCallResultCallback, str, -1, str3, true);
            return;
        }
        ge.V(Code, "call method: " + str);
        if (ge.Code()) {
            ge.Code(Code, "param: %s", com.huawei.openalliance.ad.utils.bc.Code(str2));
        }
        try {
            acVar.execute(context, str2, remoteCallResultCallback);
        } catch (Throwable th) {
            ge.I(Code, "call method %s, ex: %s", str, th.getClass().getSimpleName());
            af.Code(remoteCallResultCallback, str, -1, th.getClass().getSimpleName() + ":" + th.getMessage(), true);
            ge.Code(3, th);
        }
    }

    public ac Code(String str) {
        StringBuilder sb;
        String str2;
        String sb2;
        if (!TextUtils.isEmpty(str)) {
            ac acVar = this.Z.get(str);
            ac acVar2 = acVar;
            if (acVar == null) {
                ge.Code(Code, "create command %s", str);
                Class<? extends ac> cls = this.C.get(str);
                if (cls == null) {
                    sb = new StringBuilder();
                    str2 = "no class found for cmd: ";
                } else {
                    try {
                        acVar = cls.newInstance();
                    } catch (InstantiationException e) {
                        ge.I(Code, "get cmd %s Instantiation Exception", str);
                    } catch (Throwable th) {
                        ge.I(Code, "get cmd %s: %s", str, th.getClass().getSimpleName());
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
        ge.I(Code, sb2);
        return null;
    }

    public boolean Code(String str, Context context) {
        return (context instanceof Activity) && this.B.contains(str);
    }

    public void V() {
        this.Z.clear();
    }
}
