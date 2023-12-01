package com.tencent.mapsdk.internal;

import android.text.TextUtils;
import com.tencent.map.tools.json.JsonParser;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.mapsdk.internal.g4;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/d4.class */
public class d4 implements JsonParser.Deserializer<g4.a.C0957a.AbstractC0958a> {
    @Override // com.tencent.map.tools.json.JsonParser.Deserializer
    /* renamed from: a */
    public g4.a.C0957a.AbstractC0958a deserialize(Object obj, String str, Object obj2) throws JSONException {
        if (obj2 == null) {
            return null;
        }
        g4.a.C0957a.AbstractC0958a abstractC0958a = null;
        if (obj2 instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj2;
            String string = jSONObject.getString("type");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            if ("Point".equalsIgnoreCase(string)) {
                return (g4.a.C0957a.AbstractC0958a) JsonUtils.parseToModel(jSONObject, g4.a.C0957a.d.class, new Object[0]);
            }
            if ("Points".equalsIgnoreCase(string)) {
                return (g4.a.C0957a.AbstractC0958a) JsonUtils.parseToModel(jSONObject, g4.a.C0957a.e.class, new Object[0]);
            }
            if ("Line".equalsIgnoreCase(string)) {
                return (g4.a.C0957a.AbstractC0958a) JsonUtils.parseToModel(jSONObject, g4.a.C0957a.b.class, new Object[0]);
            }
            abstractC0958a = null;
            if ("Model".equalsIgnoreCase(string)) {
                abstractC0958a = (g4.a.C0957a.AbstractC0958a) JsonUtils.parseToModel(jSONObject, g4.a.C0957a.c.class, new Object[0]);
            }
        }
        return abstractC0958a;
    }
}
