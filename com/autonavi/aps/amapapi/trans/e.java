package com.autonavi.aps.amapapi.trans;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.amap.api.col.3sl.ho;
import com.amap.api.col.3sl.kc;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.aps.amapapi.utils.g;
import java.util.List;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/aps/amapapi/trans/e.class */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private StringBuilder f6432a = new StringBuilder();
    private AMapLocationClientOption b = new AMapLocationClientOption();

    private void a(com.autonavi.aps.amapapi.model.a aVar, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            sb.append(" ");
        }
        if (!TextUtils.isEmpty(str2)) {
            a(str, str2, sb);
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append(str3);
            sb.append(" ");
        }
        if (!TextUtils.isEmpty(str4)) {
            sb.append(str4);
            sb.append(" ");
        }
        if (!TextUtils.isEmpty(str5)) {
            sb.append(str5);
            sb.append(" ");
        }
        if (!TextUtils.isEmpty(str6)) {
            a(str7, str6, sb, aVar);
        }
        Bundle bundle = new Bundle();
        bundle.putString("citycode", aVar.getCityCode());
        bundle.putString("desc", sb.toString());
        bundle.putString("adcode", aVar.getAdCode());
        aVar.setExtras(bundle);
        aVar.g(sb.toString());
        String adCode = aVar.getAdCode();
        if (adCode == null || adCode.trim().length() <= 0 || this.b.getGeoLanguage() == AMapLocationClientOption.GeoLanguage.EN) {
            aVar.setAddress(sb.toString());
        } else {
            aVar.setAddress(sb.toString().replace(" ", ""));
        }
    }

    private static void a(com.autonavi.aps.amapapi.model.a aVar, short s) {
        short s2;
        if ("-1".equals(aVar.d())) {
            short s3 = s;
            if (s == 101) {
                s3 = 100;
            }
            aVar.setConScenario(s3);
            return;
        }
        if (s == -1) {
            s2 = 0;
        } else {
            s2 = s;
            if (s == 0) {
                s2 = -1;
            }
        }
        aVar.setConScenario(s2);
    }

    private void a(String str, String str2, StringBuilder sb) {
        if (this.b.getGeoLanguage() == AMapLocationClientOption.GeoLanguage.EN) {
            if (str2.equals(str)) {
                return;
            }
            sb.append(str2);
            sb.append(" ");
        } else if (str.contains("市") && str.equals(str2)) {
        } else {
            sb.append(str2);
            sb.append(" ");
        }
    }

    private void a(String str, String str2, StringBuilder sb, com.autonavi.aps.amapapi.model.a aVar) {
        if (TextUtils.isEmpty(str) || this.b.getGeoLanguage() == AMapLocationClientOption.GeoLanguage.EN) {
            sb.append("Near ".concat(String.valueOf(str2)));
            aVar.setDescription("Near ".concat(String.valueOf(str2)));
            return;
        }
        sb.append("靠近");
        sb.append(str2);
        sb.append(" ");
        aVar.setDescription("在" + str2 + "附近");
    }

    private static String b(String str) {
        String str2 = str;
        if ("[]".equals(str)) {
            str2 = "";
        }
        return str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:131:0x0423  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0435  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.autonavi.aps.amapapi.model.a a(com.autonavi.aps.amapapi.model.a r11, byte[] r12, com.autonavi.aps.amapapi.a r13) {
        /*
            Method dump skipped, instructions count: 1206
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.trans.e.a(com.autonavi.aps.amapapi.model.a, byte[], com.autonavi.aps.amapapi.a):com.autonavi.aps.amapapi.model.a");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00bf A[Catch: all -> 0x018a, TRY_LEAVE, TryCatch #0 {all -> 0x018a, blocks: (B:2:0x0000, B:4:0x006c, B:6:0x0076, B:8:0x0080, B:11:0x008d, B:20:0x00b8, B:22:0x00bf, B:24:0x00c8, B:26:0x0137, B:27:0x014f, B:29:0x0161, B:31:0x0176, B:15:0x00a6, B:17:0x00ad), top: B:37:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0137 A[Catch: all -> 0x018a, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x018a, blocks: (B:2:0x0000, B:4:0x006c, B:6:0x0076, B:8:0x0080, B:11:0x008d, B:20:0x00b8, B:22:0x00bf, B:24:0x00c8, B:26:0x0137, B:27:0x014f, B:29:0x0161, B:31:0x0176, B:15:0x00a6, B:17:0x00ad), top: B:37:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0161 A[Catch: all -> 0x018a, TryCatch #0 {all -> 0x018a, blocks: (B:2:0x0000, B:4:0x006c, B:6:0x0076, B:8:0x0080, B:11:0x008d, B:20:0x00b8, B:22:0x00bf, B:24:0x00c8, B:26:0x0137, B:27:0x014f, B:29:0x0161, B:31:0x0176, B:15:0x00a6, B:17:0x00ad), top: B:37:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x018d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.autonavi.aps.amapapi.model.a a(java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 402
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.trans.e.a(java.lang.String):com.autonavi.aps.amapapi.model.a");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0189 -> B:30:0x007a). Please submit an issue!!! */
    public final com.autonavi.aps.amapapi.model.a a(String str, Context context, kc kcVar, com.autonavi.aps.amapapi.a aVar) {
        com.autonavi.aps.amapapi.model.a aVar2 = new com.autonavi.aps.amapapi.model.a("");
        aVar2.setErrorCode(7);
        StringBuffer stringBuffer = new StringBuffer();
        try {
            stringBuffer.append("#SHA1AndPackage#");
            stringBuffer.append(ho.e(context));
            String str2 = (String) ((List) kcVar.b.get("gsid")).get(0);
            if (!TextUtils.isEmpty(str2)) {
                stringBuffer.append("#gsid#");
                stringBuffer.append(str2);
            }
            String str3 = kcVar.c;
            if (!TextUtils.isEmpty(str3)) {
                stringBuffer.append("#csid#".concat(String.valueOf(str3)));
            }
        } catch (Throwable th) {
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("status") || !jSONObject.has("info")) {
                aVar.f("#0702");
                StringBuilder sb = this.f6432a;
                sb.append("json is error:");
                sb.append(str);
                sb.append(stringBuffer);
                sb.append("#0702");
            }
            String string = jSONObject.getString("status");
            String string2 = jSONObject.getString("info");
            String string3 = jSONObject.getString("infocode");
            if ("0".equals(string)) {
                aVar.f("#0701");
                StringBuilder sb2 = this.f6432a;
                sb2.append("auth fail:");
                sb2.append(string2);
                sb2.append(stringBuffer);
                sb2.append("#0701");
                g.a(kcVar.d, string3, string2);
            }
        } catch (Throwable th2) {
            aVar.f("#0703");
            StringBuilder sb3 = this.f6432a;
            sb3.append("json exception error:");
            sb3.append(th2.getMessage());
            sb3.append(stringBuffer);
            sb3.append("#0703");
            com.autonavi.aps.amapapi.utils.b.a(th2, "parser", "paseAuthFailurJson");
        }
        aVar2.setLocationDetail(this.f6432a.toString());
        if (this.f6432a.length() > 0) {
            StringBuilder sb4 = this.f6432a;
            sb4.delete(0, sb4.length());
        }
        return aVar2;
    }

    public final void a(AMapLocationClientOption aMapLocationClientOption) {
        if (aMapLocationClientOption == null) {
            this.b = new AMapLocationClientOption();
        } else {
            this.b = aMapLocationClientOption;
        }
    }
}
