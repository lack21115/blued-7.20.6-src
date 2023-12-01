package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.jsb.inner.data.H5Ad;
import com.huawei.hms.ads.jsb.inner.data.JsbCallBackData;
import com.huawei.openalliance.ad.beans.metadata.ImpEX;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/fq.class */
public class fq extends ae {

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/fq$a.class */
    static class a implements com.huawei.openalliance.ad.inter.listeners.l {
        private String Code;
        private String I;
        private Context V;
        private RemoteCallResultCallback<String> Z;

        a(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback, String str2) {
            this.Code = str;
            this.V = context;
            this.Z = remoteCallResultCallback;
            this.I = str2;
        }

        private List<H5Ad> Code(List<com.huawei.openalliance.ad.inter.data.g> list) {
            ArrayList arrayList = new ArrayList(4);
            if (list != null && list.size() > 0) {
                for (com.huawei.openalliance.ad.inter.data.g gVar : list) {
                    if (gVar != null && gVar.l() != null) {
                        arrayList.add(new H5Ad(gVar.l()));
                    }
                }
            }
            return arrayList;
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.l
        public void Code(int i) {
            af.Code(this.Z, this.I, bo.Code(i), null, true);
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.l
        public void Code(Map<String, List<com.huawei.openalliance.ad.inter.data.g>> map) {
            if (map != null && map.size() > 0) {
                List<H5Ad> Code = Code(map.get(this.Code));
                if (Code.size() > 0) {
                    af.Code(this.Z, this.I, 1000, com.huawei.openalliance.ad.utils.z.V(Code), true);
                    return;
                }
            }
            ge.Code("JsbReqNativeAd", " ads map is empty.");
            af.Code(this.Z, this.I, 1005, null, true);
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/fq$b.class */
    static class b implements com.huawei.openalliance.ad.inter.listeners.d {
        private String Code;
        private RemoteCallResultCallback<String> V;

        b(RemoteCallResultCallback<String> remoteCallResultCallback, String str) {
            this.V = remoteCallResultCallback;
            this.Code = str;
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.d
        public void Code(List<String> list) {
            af.Code(this.V, this.Code, 200, new JsbCallBackData(com.huawei.openalliance.ad.utils.z.V(list), false, ag.Code));
        }
    }

    public fq() {
        super(ai.V);
    }

    private List<Integer> Code(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    break;
                }
                int optInt = jSONArray.optInt(i2, -111111);
                if (optInt != -111111) {
                    arrayList.add(Integer.valueOf(optInt));
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    private String S(String str) {
        HashMap hashMap = new HashMap();
        Map map = (Map) com.huawei.openalliance.ad.utils.z.V(str, Map.class, new Class[0]);
        if (map != null && map.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : map.entrySet()) {
                if (entry != null) {
                    arrayList.add(new ImpEX((String) entry.getKey(), com.huawei.openalliance.ad.utils.au.S((String) entry.getValue())));
                }
            }
            if (arrayList.size() > 0) {
                hashMap.put("contentBundle", arrayList);
            }
        }
        if (hashMap.size() > 0) {
            return com.huawei.openalliance.ad.utils.z.V(hashMap);
        }
        return null;
    }

    private List<String> V(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    break;
                }
                String optString = jSONArray.optString(i2);
                if (!TextUtils.isEmpty(optString)) {
                    arrayList.add(optString);
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    @Override // com.huawei.hms.ads.ae
    protected void Code(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString(com.huawei.openalliance.ad.constant.ao.L);
        String optString2 = jSONObject.optString(com.huawei.openalliance.ad.constant.ao.U);
        JSONArray optJSONArray = jSONObject.optJSONArray(com.huawei.openalliance.ad.constant.ao.W);
        int optInt = jSONObject.optInt("adType", 3);
        int optInt2 = jSONObject.optInt(com.huawei.openalliance.ad.constant.ao.b, -111111);
        int optInt3 = jSONObject.optInt(com.huawei.openalliance.ad.constant.ao.f22942c, -111111);
        int optInt4 = jSONObject.optInt(com.huawei.openalliance.ad.constant.ao.d, -111111);
        int optInt5 = jSONObject.optInt("deviceType", 4);
        int optInt6 = jSONObject.optInt(com.huawei.openalliance.ad.constant.ao.g, -111111);
        List<String> V = V(jSONObject.optJSONArray(com.huawei.openalliance.ad.constant.ao.f));
        boolean optBoolean = jSONObject.optBoolean(com.huawei.openalliance.ad.constant.ao.aB, true);
        boolean optBoolean2 = jSONObject.optBoolean(com.huawei.openalliance.ad.constant.ao.aA, false);
        RequestOptions Code = dr.Code(V(context, str));
        com.huawei.openalliance.ad.inter.m mVar = new com.huawei.openalliance.ad.inter.m(context, new String[]{optString}, optInt, V);
        if (optInt6 != -111111) {
            mVar.Z(Integer.valueOf(optInt6));
        }
        if (optInt2 != -111111) {
            mVar.Code(Integer.valueOf(optInt2));
        }
        if (optInt3 != -111111) {
            mVar.V(Integer.valueOf(optInt3));
        }
        if (optInt4 != -111111) {
            mVar.I(Integer.valueOf(optInt4));
        }
        mVar.Code(Code);
        mVar.Code(S(optString2));
        mVar.Z(Z(optString2));
        mVar.Code(Code(optJSONArray));
        mVar.Code(optBoolean);
        mVar.V(optBoolean2);
        mVar.Code(new b(remoteCallResultCallback, this.Code));
        mVar.Code(new a(context, optString, remoteCallResultCallback, this.Code));
        mVar.B((Integer) 3);
        mVar.Code(I(str));
        mVar.Code(optInt5, false);
    }
}
