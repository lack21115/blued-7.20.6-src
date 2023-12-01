package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3sl.gh  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/gh.class */
public final class gh extends ew<String, String> {
    private String k;

    public gh(Context context, String str) {
        super(context, str);
        this.k = str;
    }

    private static String b(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String a2 = fm.a(jSONObject, "code");
            String a3 = fm.a(jSONObject, "message");
            if ("1".equals(a2)) {
                return fm.a(jSONObject, "transfer_url");
            }
            if ("0".equals(a2)) {
                throw new AMapException(AMapException.AMAP_SERVICE_UNKNOWN_ERROR, 0, a3);
            }
            if ("2".equals(a2)) {
                throw new AMapException(AMapException.AMAP_SHARE_FAILURE, 0, a3);
            }
            if ("3".equals(a2)) {
                throw new AMapException(AMapException.AMAP_SERVICE_INVALID_PARAMS, 0, a3);
            }
            if ("4".equals(a2)) {
                throw new AMapException("用户签名未通过", 0, a3);
            }
            if ("5".equals(a2)) {
                throw new AMapException(AMapException.AMAP_SHARE_LICENSE_IS_EXPIRED, 0, a3);
            }
            return null;
        } catch (JSONException e) {
            fe.a(e, "ShareUrlSearchHandler", "paseJSON");
            return null;
        }
    }

    @Override // com.amap.api.col.p0003sl.ew
    protected final /* synthetic */ String a(String str) throws AMapException {
        return b(str);
    }

    @Override // com.amap.api.col.p0003sl.ew
    protected final String c() {
        return null;
    }

    @Override // com.amap.api.col.p0003sl.ew, com.amap.api.col.p0003sl.kb
    public final Map<String, String> getParams() {
        byte[] bArr;
        StringBuilder sb = new StringBuilder();
        sb.append("channel=open_api&flag=1");
        sb.append("&address=" + URLEncoder.encode(this.k));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("open_api1");
        stringBuffer.append(this.k);
        stringBuffer.append("@8UbJH6N2szojnTHONAWzB6K7N1kaj7Y0iUMarxac");
        String b = hw.b(stringBuffer.toString());
        sb.append("&sign=");
        sb.append(b.toUpperCase(Locale.US));
        sb.append("&output=json");
        try {
            bArr = gq.a(sb.toString().getBytes("utf-8"), "Yaynpa84IKOfasFx".getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            fe.a(e, "ShareUrlSearchHandler", "getParams");
            bArr = null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("ent", "2");
        hashMap.put("in", ht.b(bArr));
        hashMap.put("keyt", "openapi");
        return hashMap;
    }

    @Override // com.amap.api.col.p0003sl.kb
    public final String getURL() {
        return fd.f();
    }
}
