package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.JsonParser;
import com.tencent.map.tools.json.JsonUtils;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/sf.class */
public class sf implements JsonParser {

    /* renamed from: a  reason: collision with root package name */
    private boolean f38006a;
    private List<uf> b;

    public List<uf> a() {
        return this.b;
    }

    public boolean b() {
        return this.f38006a;
    }

    @Override // com.tencent.map.tools.json.JsonParser
    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            boolean z = true;
            if (jSONObject.optInt("enable", 0) != 1) {
                z = false;
            }
            this.f38006a = z;
            JSONArray optJSONArray = jSONObject.optJSONArray("layers");
            if (optJSONArray != null) {
                this.b = JsonUtils.parseToList(optJSONArray, uf.class, new Object[0]);
            }
        }
    }
}
