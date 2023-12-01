package com.huawei.hms.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.RequestOptions;
import com.huawei.hms.ads.data.SearchInfo;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/ae.class */
public abstract class ae extends af {
    private static final int B = -111111;
    private static final String Z = "JsbBaseAdRequest";

    public ae(String str) {
        super(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00cb, code lost:
        if (android.text.TextUtils.isEmpty(r0) == false) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ac A[EDGE_INSN: B:34:0x00ac->B:25:0x00ac ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.huawei.hms.ads.data.SearchInfo Code(org.json.JSONObject r8) {
        /*
            Method dump skipped, instructions count: 223
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.ae.Code(org.json.JSONObject):com.huawei.hms.ads.data.SearchInfo");
    }

    private void Code(Context context, String str, RequestOptions.Builder builder, AdParam.Builder builder2) {
        JSONObject jSONObject = new JSONObject(str);
        Integer valueOf = Integer.valueOf(jSONObject.optInt(com.huawei.openalliance.ad.constant.ao.m, -111111));
        Integer valueOf2 = Integer.valueOf(jSONObject.optInt(com.huawei.openalliance.ad.constant.ao.n, -111111));
        Integer valueOf3 = Integer.valueOf(jSONObject.optInt(com.huawei.openalliance.ad.constant.ao.j, -111111));
        Integer valueOf4 = Integer.valueOf(jSONObject.optInt(com.huawei.openalliance.ad.constant.ao.k, -111111));
        Integer valueOf5 = Integer.valueOf(jSONObject.optInt(com.huawei.openalliance.ad.constant.ao.l, -111111));
        String optString = jSONObject.optString(com.huawei.openalliance.ad.constant.ao.o);
        Boolean valueOf6 = Boolean.valueOf(jSONObject.optBoolean(com.huawei.openalliance.ad.constant.ao.E, true));
        Boolean valueOf7 = Boolean.valueOf(jSONObject.optBoolean(com.huawei.openalliance.ad.constant.ao.G, true));
        Integer valueOf8 = Integer.valueOf(jSONObject.optInt(com.huawei.openalliance.ad.constant.ao.H, 0));
        Boolean valueOf9 = Boolean.valueOf(jSONObject.optBoolean(com.huawei.openalliance.ad.constant.ao.J, false));
        String optString2 = jSONObject.optString(com.huawei.openalliance.ad.constant.ao.O);
        String optString3 = jSONObject.optString(com.huawei.openalliance.ad.constant.ao.w);
        String optString4 = jSONObject.optString(com.huawei.openalliance.ad.constant.ao.M);
        String optString5 = jSONObject.optString(com.huawei.openalliance.ad.constant.ao.N);
        Integer valueOf10 = Integer.valueOf(jSONObject.optInt("brand", -111111));
        String optString6 = jSONObject.optString(com.huawei.openalliance.ad.constant.ao.s);
        String optString7 = jSONObject.optString(com.huawei.openalliance.ad.constant.ao.U);
        Map<String, Bundle> S = S(jSONObject.optString(com.huawei.openalliance.ad.constant.ao.K));
        App V = V(jSONObject.optJSONObject("app"));
        Location I = I(str);
        SearchInfo Code = Code(jSONObject.optJSONObject(com.huawei.openalliance.ad.constant.ao.av));
        if (builder != null) {
            if (valueOf != null && -111111 != valueOf.intValue()) {
                builder.setTagForChildProtection(valueOf);
            }
            if (valueOf2 != null && -111111 != valueOf2.intValue()) {
                builder.setTagForUnderAgeOfPromise(valueOf2);
            }
            if (!TextUtils.isEmpty(optString)) {
                builder.setAdContentClassification(optString);
            }
            if (valueOf3 != null && -111111 != valueOf3.intValue()) {
                builder.setNonPersonalizedAd(valueOf3);
            }
            if (valueOf4 != null && -111111 != valueOf4.intValue()) {
                builder.setHwNonPersonalizedAd(valueOf4);
            }
            if (valueOf5 != null && -111111 != valueOf5.intValue()) {
                builder.setThirdNonPersonalizedAd(valueOf5);
            }
            if (!TextUtils.isEmpty(optString2)) {
                builder.setConsent(optString2);
            }
            if (!TextUtils.isEmpty(optString3)) {
                builder.setSearchTerm(optString3);
            }
            if (valueOf6 != null) {
                builder.setRequestLocation(valueOf6);
            }
            if (V != null) {
                builder.setApp(V);
            }
            if (!TextUtils.isEmpty(optString4)) {
                builder.setAppLang(optString4);
            }
            if (!TextUtils.isEmpty(optString5)) {
                builder.setAppCountry(optString5);
            }
            if (S != null) {
                builder.setExtras(S);
            }
            if (Code != null) {
                builder.setSearchInfo(Code);
            }
        }
        if (builder2 != null) {
            if (valueOf != null && -111111 != valueOf.intValue()) {
                builder2.setTagForChildProtection(valueOf);
            }
            if (valueOf2 != null && -111111 != valueOf2.intValue()) {
                builder2.setTagForUnderAgeOfPromise(valueOf2);
            }
            if (!TextUtils.isEmpty(optString)) {
                builder2.setAdContentClassification(optString);
            }
            if (valueOf3 != null && -111111 != valueOf3.intValue()) {
                builder2.setNonPersonalizedAd(valueOf3);
            }
            if (valueOf4 != null && -111111 != valueOf4.intValue()) {
                builder2.setHwNonPersonalizedAd(valueOf4);
            }
            if (valueOf5 != null && -111111 != valueOf5.intValue()) {
                builder2.setThirdNonPersonalizedAd(valueOf5);
            }
            if (!TextUtils.isEmpty(optString2)) {
                builder2.setConsent(optString2);
            }
            if (!TextUtils.isEmpty(optString3)) {
                builder2.setSearchTerm(optString3);
            }
            if (valueOf6 != null) {
                builder2.setRequestLocation(valueOf6.booleanValue());
            }
            if (V != null) {
                builder2.setAppInfo(V);
            }
            if (!TextUtils.isEmpty(optString4)) {
                builder2.setAppLang(optString4);
            }
            if (!TextUtils.isEmpty(optString5)) {
                builder2.setAppCountry(optString5);
            }
            if (!TextUtils.isEmpty(optString7)) {
                builder2.setContentBundle(Z(optString7));
            }
            if (I != null) {
                builder2.setLocation(I);
            }
            if (Code != null) {
                builder2.setSearchInfo(Code);
            }
        }
        if (valueOf10 != null && -111111 != valueOf10.intValue()) {
            HiAd.getInstance(context).setBrand(valueOf10.intValue());
        }
        if (valueOf7 != null) {
            HiAd.getInstance(context).setAppInstalledNotify(valueOf7.booleanValue());
        }
        if (valueOf8.intValue() != 0) {
            HiAd.getInstance(context).setAppActivateStyle(valueOf8.intValue());
        }
        if (valueOf9 != null) {
            HiAd.getInstance(context).setAppAutoOpenForbidden(valueOf9.booleanValue());
        }
        if (TextUtils.isEmpty(optString6)) {
            return;
        }
        HiAd.getInstance(context).setCountryCode(optString6);
    }

    private Map<String, Bundle> S(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map map = (Map) com.huawei.openalliance.ad.utils.z.V(str, Map.class, Map.class);
        ge.Code(Z, "extras: %s", str);
        if (map == null || map.size() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (entry != null) {
                Bundle bundle = new Bundle();
                String str2 = (String) entry.getKey();
                for (Map.Entry entry2 : ((Map) entry.getValue()).entrySet()) {
                    if (entry2 != null) {
                        bundle.putString((String) entry2.getKey(), (String) entry2.getValue());
                    }
                }
                hashMap.put(str2, bundle);
            }
        }
        return hashMap;
    }

    private App V(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("name");
            String optString2 = jSONObject.optString("version");
            String optString3 = jSONObject.optString(com.huawei.openalliance.ad.constant.ao.y);
            if (TextUtils.isEmpty(optString) && TextUtils.isEmpty(optString3) && TextUtils.isEmpty(optString2)) {
                return null;
            }
            return new App(optString3, optString, optString2);
        }
        return null;
    }

    protected abstract void Code(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback);

    /* JADX INFO: Access modifiers changed from: protected */
    public Location I(String str) {
        JSONObject optJSONObject = new JSONObject(str).optJSONObject("location");
        Location location = null;
        if (optJSONObject != null) {
            String optString = optJSONObject.optString("latitude");
            String optString2 = optJSONObject.optString("longitude");
            location = null;
            if (!TextUtils.isEmpty(optString)) {
                location = null;
                if (!TextUtils.isEmpty(optString2)) {
                    location = null;
                    if (Pattern.matches(com.huawei.openalliance.ad.constant.t.bT, optString)) {
                        if (!Pattern.matches(com.huawei.openalliance.ad.constant.t.bT, optString2)) {
                            return null;
                        }
                        location = new Location("");
                        location.setLatitude(new BigDecimal(optString).doubleValue());
                        location.setLongitude(new BigDecimal(optString2).doubleValue());
                    }
                }
            }
        }
        return location;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AdParam I(Context context, String str) {
        AdParam.Builder builder = new AdParam.Builder();
        Code(context, str, (RequestOptions.Builder) null, builder);
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RequestOptions V(Context context, String str) {
        RequestOptions.Builder builder = new RequestOptions.Builder();
        Code(context, str, builder, (AdParam.Builder) null);
        return builder.build();
    }

    public String Z(String str) {
        return str;
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(final Context context, final String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        com.huawei.openalliance.ad.utils.f.Code(new Runnable() { // from class: com.huawei.hms.ads.ae.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ae.this.Code(context, str, remoteCallResultCallback);
                } catch (Throwable th) {
                    ge.Code(5, ae.Z, "executeInNetworkThread exception", th);
                    RemoteCallResultCallback remoteCallResultCallback2 = remoteCallResultCallback;
                    String str2 = ae.this.Code;
                    af.Code(remoteCallResultCallback2, str2, -1, th.getClass().getSimpleName() + ":" + th.getMessage(), true);
                }
            }
        });
    }
}
