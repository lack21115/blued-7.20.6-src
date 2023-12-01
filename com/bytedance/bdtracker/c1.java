package com.bytedance.bdtracker;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.applog.network.INetworkClient;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/c1.class */
public class c1 implements INetworkClient {

    /* renamed from: a  reason: collision with root package name */
    public final q1 f21202a;

    public c1(q1 q1Var) {
        this.f21202a = q1Var;
    }

    @Override // com.bytedance.applog.network.INetworkClient
    public String get(String str, Map<String, String> map) {
        return this.f21202a.a(0, str, (HashMap) map, null);
    }

    @Override // com.bytedance.applog.network.INetworkClient
    public String post(String str, List<Pair<String, String>> list) {
        JSONObject jSONObject = new JSONObject();
        if (list != null) {
            try {
                for (Pair<String, String> pair : list) {
                    jSONObject.put(pair.first, pair.second);
                }
            } catch (JSONException e) {
                z2.a(e);
            }
        }
        return post(str, jSONObject.toString().getBytes(), "application/json; charset=utf-8");
    }

    @Override // com.bytedance.applog.network.INetworkClient
    public String post(String str, byte[] bArr, String str2) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("Content-Type", str2);
        }
        return this.f21202a.a(1, str, hashMap, bArr);
    }

    @Override // com.bytedance.applog.network.INetworkClient
    public String post(String str, byte[] bArr, Map<String, String> map) {
        return this.f21202a.a(1, str, (HashMap) map, bArr);
    }

    @Override // com.bytedance.applog.network.INetworkClient
    public byte[] postStream(String str, byte[] bArr, Map<String, String> map) {
        return this.f21202a.a(1, str, (HashMap) map, bArr, 1, -1).b;
    }
}
