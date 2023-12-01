package com.kwad.sdk.api.loader;

import com.kwad.sdk.api.loader.a;
import com.ss.android.downloadlib.constants.EventConstants;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/loader/j.class */
public final class j {
    public static int ZG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/loader/j$a.class */
    public static final class a {
        private int ZH;
        private int ZI;
        private String ZJ;
        private String ZK;
        private long ZL;
        private int ZM;
        private String ZN;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a H(long j) {
            this.ZL = j;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a aT(int i) {
            this.ZH = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a aU(int i) {
            this.ZI = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a aV(int i) {
            this.ZM = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a bc(String str) {
            this.ZJ = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a bd(String str) {
            this.ZK = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a be(String str) {
            this.ZN = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("load_status", Integer.valueOf(this.ZH));
                jSONObject.putOpt("update_count", Integer.valueOf(this.ZI));
                jSONObject.putOpt("dynamic_version", this.ZJ);
                jSONObject.putOpt(EventConstants.ExtraJson.DOWNLOAD_URL, this.ZK);
                jSONObject.putOpt("duration_ms", Long.valueOf(this.ZL));
                jSONObject.putOpt("error_code", Integer.valueOf(this.ZM));
                jSONObject.putOpt("error_msg", this.ZN);
                return jSONObject;
            } catch (Exception e) {
                return jSONObject;
            }
        }

        public final String toString() {
            return "MonitorInfo{load_status=" + this.ZH + ", update_count=" + this.ZI + ", dynamic_version='" + this.ZJ + "', download_url='" + this.ZK + "', duration_ms=" + this.ZL + ", error_code=" + this.ZM + ", error_msg='" + this.ZN + "'}";
        }
    }

    private static void a(int i, a.C0549a c0549a, long j, int i2, String str) {
        if (c0549a == null) {
            return;
        }
        try {
            JSONObject json = new a((byte) 0).aT(i).aU(ZG).bc(c0549a.sdkVersion).bd(c0549a.Zl).H(j).aV(i2).be(str).toJson();
            StringBuilder sb = new StringBuilder("status:");
            sb.append(i);
            sb.append("--jo:");
            sb.append(json);
            com.kwad.sdk.api.c.a("reportDynamicUpdate", json);
        } catch (Throwable th) {
        }
    }

    public static void a(a.C0549a c0549a) {
        ZG++;
        a(1, c0549a, 0L, 0, "");
    }

    public static void a(a.C0549a c0549a, int i, String str) {
        a(4, c0549a, 0L, i, str);
    }

    public static void a(a.C0549a c0549a, long j) {
        a(2, c0549a, j, 0, "");
    }

    public static void a(a.C0549a c0549a, long j, String str) {
        a(3, c0549a, j, 0, str);
    }

    public static void b(a.C0549a c0549a) {
        a(5, c0549a, 0L, 0, "");
    }

    public static void b(a.C0549a c0549a, int i, String str) {
        a(7, c0549a, 0L, i, str);
    }

    public static void b(a.C0549a c0549a, long j) {
        a(6, c0549a, j, 0, "");
    }
}
