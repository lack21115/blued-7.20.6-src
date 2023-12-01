package com.kwad.sdk.core.network.idc.kwai;

import android.text.TextUtils;
import com.kwad.sdk.core.b;
import com.kwad.sdk.utils.t;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/network/idc/kwai/a.class */
public final class a implements b {
    private final Map<String, List<String>> ahr = new ConcurrentHashMap();

    public static a cj(String str) {
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(str));
            return aVar;
        } catch (JSONException e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
            return aVar;
        }
    }

    private Map<String, List<String>> wp() {
        return this.ahr;
    }

    public final void b(a aVar) {
        this.ahr.clear();
        if (aVar != null) {
            this.ahr.putAll(aVar.wp());
        }
    }

    public final List<String> ci(String str) {
        List<String> list = this.ahr.get(str);
        List<String> list2 = list;
        if (list == null) {
            list2 = Collections.emptyList();
        }
        return list2;
    }

    public final boolean isEmpty() {
        return this.ahr.isEmpty();
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next)) {
                hashMap.put(next, t.h(jSONObject.optJSONArray(next)));
            }
        }
        this.ahr.clear();
        this.ahr.putAll(hashMap);
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        Map<String, List<String>> map = this.ahr;
        JSONObject jSONObject = new JSONObject();
        for (String str : map.keySet()) {
            t.putValue(jSONObject, str, t.C(map.get(str)));
        }
        return jSONObject;
    }

    public final Set<String> wq() {
        return this.ahr.keySet();
    }
}
