package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.ia;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3sl.na  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/na.class */
public final class na {

    /* renamed from: a  reason: collision with root package name */
    private ia f5402a;

    public na(String str) {
        this.f5402a = null;
        try {
            this.f5402a = new ia.a(str, "1.0", "1.0.0").a(new String[]{"info"}).a();
        } catch (hn e) {
        }
    }

    private static ia a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            String optString = jSONObject.optString("a");
            String optString2 = jSONObject.optString("b");
            String optString3 = jSONObject.optString("c");
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("d");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= optJSONArray.length()) {
                    return new ia.a(optString, optString2, optString).a(optString3).a((String[]) arrayList.toArray(new String[0])).a();
                }
                arrayList.add(optJSONArray.getString(i2));
                i = i2 + 1;
            }
        } catch (Throwable th) {
            return null;
        }
    }

    private static List<ia> a(JSONArray jSONArray) {
        if (jSONArray.length() == 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= jSONArray.length()) {
                return arrayList;
            }
            ia iaVar = null;
            try {
                iaVar = a(jSONArray.getJSONObject(i2));
            } catch (JSONException e) {
            }
            if (iaVar != null) {
                arrayList.add(iaVar);
            }
            i = i2 + 1;
        }
    }

    private static JSONArray a(List<ia> list) {
        if (list.size() == 0) {
            return new JSONArray();
        }
        JSONArray jSONArray = new JSONArray();
        for (ia iaVar : list) {
            jSONArray.put(a(iaVar));
        }
        return jSONArray;
    }

    private static JSONObject a(ia iaVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("a", iaVar.a());
            jSONObject.put("b", iaVar.b());
            jSONObject.put("c", iaVar.c());
            JSONArray jSONArray = new JSONArray();
            int i = 0;
            while (true) {
                int i2 = i;
                if (iaVar.f() == null || i2 >= iaVar.f().length) {
                    break;
                }
                jSONArray.put(iaVar.f()[i2]);
                i = i2 + 1;
            }
            jSONObject.put("d", jSONArray);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    public final List<ia> a(Context context) {
        try {
            return a(new JSONArray(ji.a(context, this.f5402a, "rbck")));
        } catch (JSONException e) {
            return new ArrayList();
        }
    }

    public final void a(Context context, ia iaVar) {
        if (iaVar == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(iaVar);
        String jSONArray = a(arrayList).toString();
        if (TextUtils.isEmpty(jSONArray)) {
            return;
        }
        ji.a(context, this.f5402a, "rbck", jSONArray);
    }
}
