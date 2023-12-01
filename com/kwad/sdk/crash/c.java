package com.kwad.sdk.crash;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/c.class */
public final class c {
    public final String aaS;
    public final String alj;
    public final double aqB;
    public final boolean aqF;
    public final boolean aqG;
    public final com.kwad.sdk.crash.model.b aqJ;
    public final com.kwad.sdk.crash.model.a aqK;
    public final h aqL;
    public final String[] aqM;
    public final String[] aqN;
    public final boolean aqO;
    public final f aqP;
    public final String aqQ;
    public final String aqR;
    public final String aqS;
    public final String aqT;
    public final List<com.kwad.sdk.crash.a> aqU;
    public final Context context;
    public final boolean isExternal;
    public final String platform;
    public final String version;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/c$a.class */
    public static final class a {
        private String SM;
        private int SN;
        public int SO;
        private String aaS;
        private int ajK;
        private String alj;
        private String appId;
        private String appName;
        private String appPackageName;
        private String appVersion;
        private f aqP;
        private String aqQ;
        private String aqR;
        private String aqV;
        private h aqW;
        private String[] aqX;
        public String[] aqY;
        private Context context;
        private String platform;
        private String sdkVersion;
        private String version;
        private boolean aqO = false;
        private boolean aqF = false;
        private boolean aqG = false;
        private boolean isExternal = false;
        private String aqS = "";
        private String aqT = "";
        private List<com.kwad.sdk.crash.a> aqU = new ArrayList();
        private double aqB = 1.0d;

        public final a a(f fVar) {
            this.aqP = fVar;
            return this;
        }

        public final a a(h hVar) {
            this.aqW = hVar;
            return this;
        }

        public final a bF(int i) {
            this.ajK = i;
            return this;
        }

        public final a bG(int i) {
            this.SN = i;
            return this;
        }

        public final a bH(int i) {
            this.SO = 1;
            return this;
        }

        public final a bf(boolean z) {
            this.aqF = z;
            return this;
        }

        public final a bg(boolean z) {
            this.aqG = z;
            return this;
        }

        public final a bh(boolean z) {
            this.isExternal = z;
            return this;
        }

        public final a bm(Context context) {
            this.context = context;
            return this;
        }

        public final a d(String[] strArr) {
            this.aqX = strArr;
            return this;
        }

        public final a dA(String str) {
            this.appId = str;
            return this;
        }

        public final a dB(String str) {
            this.appName = str;
            return this;
        }

        public final a dC(String str) {
            this.appVersion = str;
            return this;
        }

        public final a dq(String str) {
            this.aqS = str;
            return this;
        }

        public final a dr(String str) {
            this.aqT = str;
            return this;
        }

        public final a ds(String str) {
            this.platform = str;
            return this;
        }

        public final a dt(String str) {
            this.alj = str;
            return this;
        }

        public final a du(String str) {
            this.aaS = str;
            return this;
        }

        public final a dv(String str) {
            this.aqR = str;
            return this;
        }

        public final a dw(String str) {
            this.aqV = str;
            return this;
        }

        public final a dx(String str) {
            this.sdkVersion = str;
            return this;
        }

        public final a dy(String str) {
            this.SM = str;
            return this;
        }

        public final a dz(String str) {
            this.appPackageName = str;
            return this;
        }

        public final a e(String[] strArr) {
            this.aqY = strArr;
            return this;
        }

        public final a j(double d) {
            this.aqB = d;
            return this;
        }

        public final a u(List<String> list) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        com.kwad.sdk.crash.a aVar = new com.kwad.sdk.crash.a();
                        aVar.parseJson(jSONObject);
                        this.aqU.add(aVar);
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.b.w("ExceptionCollectorConfigs", e.toString());
                    }
                }
            }
            return this;
        }

        public final c zx() {
            return new c(this, (byte) 0);
        }
    }

    private c(a aVar) {
        this.aqJ = new com.kwad.sdk.crash.model.b();
        this.aqK = new com.kwad.sdk.crash.model.a();
        this.aqU = new ArrayList();
        this.aqO = aVar.aqO;
        this.aqF = aVar.aqF;
        this.aqG = aVar.aqG;
        this.isExternal = aVar.isExternal;
        this.aqS = aVar.aqS;
        this.aqT = aVar.aqT;
        this.context = aVar.context;
        this.aqP = aVar.aqP;
        this.platform = aVar.platform;
        this.version = aVar.version;
        this.alj = aVar.alj;
        this.aaS = aVar.aaS;
        this.aqQ = aVar.aqQ;
        this.aqR = aVar.aqR;
        this.aqK.arx = aVar.appId;
        this.aqK.mAppName = aVar.appName;
        this.aqK.arz = aVar.appVersion;
        this.aqK.ary = aVar.appPackageName;
        this.aqJ.arC = aVar.SM;
        this.aqJ.arD = aVar.SN;
        this.aqJ.mSdkVersion = aVar.sdkVersion;
        this.aqJ.arB = aVar.ajK;
        this.aqJ.arA = aVar.aqV;
        this.aqJ.arE = aVar.SO;
        this.aqL = aVar.aqW;
        this.aqM = aVar.aqX;
        this.aqN = aVar.aqY;
        this.aqU.addAll(aVar.aqU);
        this.aqB = aVar.aqB;
    }

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    public final f zv() {
        return this.aqP;
    }

    public final boolean zw() {
        return this.aqO;
    }
}
