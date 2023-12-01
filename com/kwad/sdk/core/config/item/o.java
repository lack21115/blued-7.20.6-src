package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/config/item/o.class */
public final class o extends b<a> {
    private String aeb;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/config/item/o$a.class */
    public static final class a implements com.kwad.sdk.core.b {
        public Map<Integer, String> aec = new HashMap();
        public List<String> aed = new ArrayList();
        public List<String> aee = new ArrayList();
        public List<String> aef = new ArrayList();
        public int aeg;
        private JSONObject aeh;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.aeh = jSONObject;
            JSONObject optJSONObject = jSONObject.optJSONObject("platformInfo");
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    this.aec.put(Integer.valueOf(next), optJSONObject.optString(next));
                }
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("keyStacks");
            if (optJSONArray != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= optJSONArray.length()) {
                        break;
                    }
                    this.aed.add(optJSONArray.optString(i2));
                    i = i2 + 1;
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("extendClassNames");
            if (optJSONArray2 != null) {
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= optJSONArray2.length()) {
                        break;
                    }
                    this.aee.add(optJSONArray2.optString(i4));
                    i3 = i4 + 1;
                }
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("keyNames");
            if (optJSONArray3 != null) {
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    if (i6 >= optJSONArray3.length()) {
                        break;
                    }
                    this.aef.add(optJSONArray3.optString(i6));
                    i5 = i6 + 1;
                }
            }
            this.aeg = jSONObject.optInt("handleType");
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            return this.aeh;
        }
    }

    public o() {
        super("sdkPackInfo", null);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        String bC = bC(sharedPreferences.getString("sdkPackInfo", null));
        this.aeb = bC;
        try {
            if (TextUtils.isEmpty(bC)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(this.aeb);
            a aVar = new a();
            aVar.parseJson(jSONObject);
            setValue(aVar);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
        editor.putString("sdkPackInfo", bB(this.aeb));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void g(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("sdkPackInfo");
        if (optJSONObject == null) {
            return;
        }
        this.aeb = optJSONObject.toString();
        a aVar = new a();
        aVar.parseJson(optJSONObject);
        setValue(aVar);
    }
}
