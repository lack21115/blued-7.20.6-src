package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.ranger.kwai.a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/ge.class */
public final class ge implements com.kwad.sdk.core.d<a.C0577a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(a.C0577a c0577a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0577a.ayu = jSONObject.optString("typeStr");
        if (c0577a.ayu == JSONObject.NULL) {
            c0577a.ayu = "";
        }
        c0577a.ayv = jSONObject.optString("valueStr");
        if (c0577a.ayv == JSONObject.NULL) {
            c0577a.ayv = "";
        }
        c0577a.ayw = jSONObject.optString("listValueType");
        if (c0577a.ayw == JSONObject.NULL) {
            c0577a.ayw = "";
        }
        c0577a.ayx = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("valueStrList");
        if (optJSONArray != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= optJSONArray.length()) {
                    break;
                }
                c0577a.ayx.add((String) optJSONArray.opt(i2));
                i = i2 + 1;
            }
        }
        c0577a.fieldName = jSONObject.optString("fieldName");
        if (c0577a.fieldName == JSONObject.NULL) {
            c0577a.fieldName = "";
        }
        c0577a.className = jSONObject.optString("className");
        if (c0577a.className == JSONObject.NULL) {
            c0577a.className = "";
        }
        c0577a.ayy = new ArrayList();
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
            a.C0577a c0577a2 = new a.C0577a();
            c0577a2.parseJson(optJSONArray2.optJSONObject(i4));
            c0577a.ayy.add(c0577a2);
            i3 = i4 + 1;
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.C0577a c0577a, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (c0577a.ayu != null && !c0577a.ayu.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "typeStr", c0577a.ayu);
        }
        if (c0577a.ayv != null && !c0577a.ayv.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "valueStr", c0577a.ayv);
        }
        if (c0577a.ayw != null && !c0577a.ayw.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "listValueType", c0577a.ayw);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "valueStrList", c0577a.ayx);
        if (c0577a.fieldName != null && !c0577a.fieldName.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "fieldName", c0577a.fieldName);
        }
        if (c0577a.className != null && !c0577a.className.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "className", c0577a.className);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "childParamList", c0577a.ayy);
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0577a c0577a, JSONObject jSONObject) {
        a2(c0577a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0577a c0577a, JSONObject jSONObject) {
        return b2(c0577a, jSONObject);
    }
}
