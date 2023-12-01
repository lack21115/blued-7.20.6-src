package com.unikuwei.mianmi.account.shield.tencent.e;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/unikuwei/mianmi/account/shield/tencent/e/e.class */
public class e {
    public static String a(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            boolean z = true;
            for (Map.Entry<?, ?> entry : a(new JSONObject(str).toString()).entrySet()) {
                stringBuffer.append(z ? "" : str2);
                stringBuffer.append((String) entry.getKey());
                stringBuffer.append("=");
                stringBuffer.append(entry.getValue() != null ? entry.getValue() : "");
                z = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }

    private static TreeMap<?, ?> a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            TreeMap<?, ?> treeMap = new TreeMap<>();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                treeMap.put(next, jSONObject.getString(next));
            }
            return treeMap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
