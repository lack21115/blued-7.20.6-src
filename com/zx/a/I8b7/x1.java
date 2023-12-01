package com.zx.a.I8b7;

import com.zx.sdk.api.ZXIDListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/x1.class */
public class x1 extends p0 {

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentHashMap<String, LinkedList<ZXIDListener>> f28536a = new ConcurrentHashMap<>();

    @Override // com.zx.a.I8b7.p0
    public void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("code");
            String optString = jSONObject.optString("message");
            for (String str2 : this.f28536a.keySet()) {
                Iterator<ZXIDListener> it = this.f28536a.get(str2).iterator();
                while (it.hasNext()) {
                    ZXIDListener next = it.next();
                    if (i == 0) {
                        next.onSuccess(a(str2, jSONObject.getString("data")));
                    } else {
                        next.onFailed(i, optString);
                    }
                }
                this.f28536a.remove(str2);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
