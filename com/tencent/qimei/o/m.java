package com.tencent.qimei.o;

import android.os.Process;
import com.huawei.hms.push.AttributionReporter;
import com.huawei.openalliance.ad.constant.ao;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.qimei.beaconid.U;
import com.tencent.qimei.sdk.Qimei;
import com.tencent.tendinsv.a.b;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/o/m.class */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public static final m f38382a = new m();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/o/m$a.class */
    public enum a {
        KEY_ENCRYPT_KEY("key"),
        KEY_PARAMS("params"),
        KEY_TIME("time"),
        KEY_NONCE("nonce"),
        KEY_SIGN("sign"),
        KEY_EXTRA("extra"),
        KEY_PARAMS_AD(com.tencent.qimei.a.b.a(11)),
        KEY_PARAMS_PLATFORM_ID(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY),
        KEY_PARAMS_APP_KEY("appKey"),
        KEY_PARAMS_APP_VERSION(AttributionReporter.APP_VERSION),
        KEY_PARAMS_BEACON_ID_SRC("beaconIdSrc"),
        KEY_PARAMS_BRAND("brand"),
        KEY_PARAMS_CHANNEL_ID("channelId"),
        KEY_PARAMS_CD(com.tencent.qimei.a.b.a(9)),
        KEY_PARAMS_EI(com.tencent.qimei.a.b.a(6)),
        KEY_PARAMS_SI(com.tencent.qimei.a.b.a(7)),
        KEY_PARAMS_MC(com.tencent.qimei.a.b.a(8)),
        KEY_PARAMS_MODEL("model"),
        KEY_PARAMS_NETWORK_TYPE("networkType"),
        KEY_PARAMS_OD(com.tencent.qimei.a.b.a(5)),
        KEY_PARAMS_OS_VERSION(b.a.l),
        KEY_PARAMS_Q16(com.tencent.qimei.a.b.a(0)),
        KEY_PARAMS_Q36(com.tencent.qimei.a.b.a(1)),
        KEY_PARAMS_RESERVED("reserved"),
        KEY_PARAMS_SDKVERSION("sdkVersion"),
        KEY_PARAMS_TARGETSDKVERSION("targetSdkVersion"),
        KEY_PARAMS_TRUSTEDENV("audit"),
        KEY_PARAMS_USERID(ao.q),
        KEY_PARAMS_DEVICE_TYPE("deviceType"),
        KEY_PARAMS_PACKAGE_ID("packageId"),
        KEY_PARAMS_SKDNAME("sdkName"),
        KEY_RESERVED_HARMONY("harmony"),
        KEY_RESERVED_CLONE("clone"),
        KEY_RESERVED_CONTAINE("containe"),
        KEY_RESERVED_OZ("oz"),
        KEY_RESERVED_OO("oo"),
        KEY_RESERVED_KELONG("kelong"),
        KEY_RESERVED_UPTIMES("uptimes"),
        KEY_RESERVED_USERS("multiUser"),
        KEY_RESERVED_BOD("bod"),
        KEY_RESERVED_BRD("brd"),
        KEY_RESERVED_DV("dv"),
        KEY_RESERVED_FAL("firstLevel"),
        KEY_RESERVED_MT("manufact"),
        KEY_RESERVED_NAME("name"),
        KEY_RESERVED_HOST("host"),
        KEY_RESERVED_KL("kernel");
        
        public String W;

        a(String str) {
            this.W = str;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/o/m$b.class */
    public enum b {
        KEY_CODE("code"),
        KEY_DATA("data"),
        KEY_DATA_QM_16("q16"),
        KEY_DATA_QM_36("q36");
        
        public String f;

        b(String str) {
            this.f = str;
        }

        public static Qimei a(String str) {
            return new Qimei(KEY_DATA_QM_16.a(str, new b[0]), KEY_DATA_QM_36.a(str, new b[0]));
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0049, code lost:
            if (r5 != null) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x004c, code lost:
            return "";
         */
        /* JADX WARN: Code restructure failed: missing block: B:7:0x002d, code lost:
            return r5.optString(r4.f);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String a(java.lang.String r5, com.tencent.qimei.o.m.b... r6) {
            /*
                r4 = this;
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch: org.json.JSONException -> L2e
                r1 = r0
                r2 = r5
                r1.<init>(r2)     // Catch: org.json.JSONException -> L2e
                r5 = r0
                r0 = r6
                int r0 = r0.length     // Catch: org.json.JSONException -> L2e
                r8 = r0
                r0 = 0
                r7 = r0
                goto L36
            L12:
                r0 = r5
                r1 = r9
                java.lang.String r1 = r1.f     // Catch: org.json.JSONException -> L2e
                org.json.JSONObject r0 = r0.optJSONObject(r1)     // Catch: org.json.JSONException -> L2e
                r5 = r0
                r0 = r7
                r1 = 1
                int r0 = r0 + r1
                r7 = r0
                goto L36
            L23:
                r0 = r5
                r1 = r4
                java.lang.String r1 = r1.f     // Catch: org.json.JSONException -> L2e
                java.lang.String r0 = r0.optString(r1)     // Catch: org.json.JSONException -> L2e
                r5 = r0
                r0 = r5
                return r0
            L2e:
                r5 = move-exception
                r0 = r5
                r0.printStackTrace()
                java.lang.String r0 = ""
                return r0
            L36:
                r0 = r7
                r1 = r8
                if (r0 >= r1) goto L48
                r0 = r6
                r1 = r7
                r0 = r0[r1]
                r9 = r0
                r0 = r5
                if (r0 != 0) goto L12
                java.lang.String r0 = ""
                return r0
            L48:
                r0 = r5
                if (r0 != 0) goto L23
                java.lang.String r0 = ""
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.qimei.o.m.b.a(java.lang.String, com.tencent.qimei.o.m$b[]):java.lang.String");
        }
    }

    public final String a(com.tencent.qimei.c.c cVar, com.tencent.qimei.l.d dVar, com.tencent.qimei.q.a aVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(a.KEY_RESERVED_HARMONY.W, cVar.u() ? "1" : "0");
            jSONObject.put(a.KEY_RESERVED_CLONE.W, Process.myUid() / 100000 != 0 ? "1" : "0");
            jSONObject.put(a.KEY_RESERVED_CONTAINE.W, cVar.f());
            jSONObject.put(a.KEY_RESERVED_OZ.W, !com.tencent.qimei.v.d.a(dVar.b).f() ? "" : com.tencent.qimei.c.c.j().q());
            jSONObject.put(a.KEY_RESERVED_OO.W, !com.tencent.qimei.v.d.a(dVar.b).w() ? "" : com.tencent.qimei.c.c.j().o());
            jSONObject.put(a.KEY_RESERVED_KELONG.W, aVar.a() ? "1" : "0");
            String a2 = new com.tencent.qimei.j.d(com.tencent.qimei.u.d.b().J(), str).a();
            String b2 = com.tencent.qimei.a.a.b(com.tencent.qimei.u.d.b().J());
            jSONObject.put(a.KEY_RESERVED_UPTIMES.W, a2);
            jSONObject.put(a.KEY_RESERVED_USERS.W, b2);
            jSONObject.put(a.KEY_RESERVED_BOD.W, U.a(com.tencent.qimei.a.b.a(12)));
            jSONObject.put(a.KEY_RESERVED_BRD.W, U.a(com.tencent.qimei.a.b.a(13)));
            jSONObject.put(a.KEY_RESERVED_DV.W, U.a(com.tencent.qimei.a.b.a(14)));
            jSONObject.put(a.KEY_RESERVED_FAL.W, U.a(com.tencent.qimei.a.b.a(15)));
            jSONObject.put(a.KEY_RESERVED_MT.W, U.a(com.tencent.qimei.a.b.a(16)));
            jSONObject.put(a.KEY_RESERVED_NAME.W, U.a(com.tencent.qimei.a.b.a(17)));
            jSONObject.put(a.KEY_RESERVED_HOST.W, U.a(com.tencent.qimei.a.b.a(18)));
            jSONObject.put(a.KEY_RESERVED_KL.W, com.tencent.qimei.c.c.j().t());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String a(String str, String str2) {
        if (!str.isEmpty()) {
            return str + "/android";
        } else if (str2.isEmpty()) {
            return com.tencent.qimei.e.a.a() + "/android";
        } else {
            return str2 + "/android";
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(27:2|3|(2:5|6)(1:51)|7|8|(1:10)(1:50)|11|12|(1:14)(1:49)|15|16|(15:48|20|21|(1:23)(1:44)|24|25|(2:27|28)(1:43)|29|30|31|32|33|34|35|36)|19|20|21|(0)(0)|24|25|(0)(0)|29|30|31|32|33|34|35|36) */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x02a7, code lost:
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x02a8, code lost:
        r9.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x02ae, code lost:
        r9 = "";
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x021e A[Catch: JSONException -> 0x02c7, TRY_ENTER, TryCatch #0 {JSONException -> 0x02c7, blocks: (B:3:0x002e, B:9:0x00c0, B:14:0x016b, B:19:0x018c, B:27:0x01ff, B:32:0x0225, B:38:0x0260, B:44:0x02af, B:42:0x02a8, B:36:0x0253, B:30:0x021e, B:22:0x01e7, B:25:0x01f2, B:17:0x0185, B:12:0x0163, B:7:0x00b2, B:40:0x029f), top: B:51:0x002e, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0253 A[Catch: JSONException -> 0x02c7, TRY_ENTER, TryCatch #0 {JSONException -> 0x02c7, blocks: (B:3:0x002e, B:9:0x00c0, B:14:0x016b, B:19:0x018c, B:27:0x01ff, B:32:0x0225, B:38:0x0260, B:44:0x02af, B:42:0x02a8, B:36:0x0253, B:30:0x021e, B:22:0x01e7, B:25:0x01f2, B:17:0x0185, B:12:0x0163, B:7:0x00b2, B:40:0x029f), top: B:51:0x002e, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(java.lang.String r9, java.lang.String r10, com.tencent.qimei.sdk.Qimei r11, long r12, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 725
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qimei.o.m.a(java.lang.String, java.lang.String, com.tencent.qimei.sdk.Qimei, long, java.lang.String):java.lang.String");
    }

    public String a(String str, String str2, Qimei qimei, String str3) {
        return a(str, str2, qimei, System.currentTimeMillis(), str3);
    }

    public void a(JSONObject jSONObject, long j, String str) throws JSONException {
        String a2 = com.tencent.qimei.j.a.a();
        String optString = jSONObject.optString(a.KEY_ENCRYPT_KEY.W);
        String optString2 = jSONObject.optString(a.KEY_PARAMS.W);
        Object b2 = com.tencent.qimei.j.a.b(optString + optString2 + j + a2 + com.tencent.qimei.c.c.j().s() + str);
        jSONObject.put(a.KEY_TIME.W, String.valueOf(j));
        jSONObject.put(a.KEY_NONCE.W, a2);
        jSONObject.put(a.KEY_SIGN.W, b2);
        jSONObject.put(a.KEY_EXTRA.W, str);
    }
}
