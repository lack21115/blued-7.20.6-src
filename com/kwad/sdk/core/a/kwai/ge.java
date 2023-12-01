package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.ranger.kwai.a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/ge.class */
public final class ge implements com.kwad.sdk.core.d<a.C0407a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(a.C0407a c0407a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0407a.ayu = jSONObject.optString("typeStr");
        if (c0407a.ayu == JSONObject.NULL) {
            c0407a.ayu = "";
        }
        c0407a.ayv = jSONObject.optString("valueStr");
        if (c0407a.ayv == JSONObject.NULL) {
            c0407a.ayv = "";
        }
        c0407a.ayw = jSONObject.optString("listValueType");
        if (c0407a.ayw == JSONObject.NULL) {
            c0407a.ayw = "";
        }
        c0407a.ayx = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("valueStrList");
        if (optJSONArray != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= optJSONArray.length()) {
                    break;
                }
                c0407a.ayx.add((String) optJSONArray.opt(i2));
                i = i2 + 1;
            }
        }
        c0407a.fieldName = jSONObject.optString("fieldName");
        if (c0407a.fieldName == JSONObject.NULL) {
            c0407a.fieldName = "";
        }
        c0407a.className = jSONObject.optString("className");
        if (c0407a.className == JSONObject.NULL) {
            c0407a.className = "";
        }
        c0407a.ayy = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("childParamList");
        if (optJSONArray2 == null) {
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= optJSONArray2.length()) {
                return;
            }
            a.C0407a c0407a2 = new a.C0407a();
            c0407a2.parseJson(optJSONArray2.optJSONObject(i4));
            c0407a.ayy.add(c0407a2);
            i3 = i4 + 1;
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.C0407a c0407a, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (c0407a.ayu != null && !c0407a.ayu.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "typeStr", c0407a.ayu);
        }
        if (c0407a.ayv != null && !c0407a.ayv.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "valueStr", c0407a.ayv);
        }
        if (c0407a.ayw != null && !c0407a.ayw.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "listValueType", c0407a.ayw);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "valueStrList", c0407a.ayx);
        if (c0407a.fieldName != null && !c0407a.fieldName.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "fieldName", c0407a.fieldName);
        }
        if (c0407a.className != null && !c0407a.className.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "className", c0407a.className);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "childParamList", c0407a.ayy);
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0407a c0407a, JSONObject jSONObject) {
        a2(c0407a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0407a c0407a, JSONObject jSONObject) {
        return b2(c0407a, jSONObject);
    }
}
