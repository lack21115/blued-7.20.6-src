package a.a.a.a.a.d;

import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/d/e.class */
public class e {
    public static String a() throws JSONException {
        JSONObject jSONObject = new JSONObject(f.a().c());
        for (Map.Entry<String, ?> entry : f.a().b().entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue());
        }
        jSONObject.put("data_type", "method");
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(ShareConstants.DEXMODE_RAW, jSONObject.toString());
        jSONArray.put(jSONObject2);
        return jSONArray.toString();
    }
}
