package com.zx.a.I8b7;

import com.zx.sdk.api.ZXIDChangedListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/y1.class */
public class y1 extends p0 {

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentHashMap<String, LinkedList<ZXIDChangedListener>> f42231a = new ConcurrentHashMap<>();

    @Override // com.zx.a.I8b7.p0
    public void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("code");
            for (String str2 : this.f42231a.keySet()) {
                Iterator<ZXIDChangedListener> it = this.f42231a.get(str2).iterator();
                while (it.hasNext()) {
                    ZXIDChangedListener next = it.next();
                    if (i == 0) {
                        next.onChange(a(str2, jSONObject.getString("data")));
                    }
                }
                this.f42231a.remove(str2);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
