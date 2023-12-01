package com.huawei.hms.ads.template;

import android.util.LruCache;
import android.util.Pair;
import com.huawei.hms.ads.ge;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/template/DTManager.class */
public class DTManager {
    private static final byte[] I = new byte[0];
    private static DTManager V;
    private final LruCache<String, String> B = new LruCache<>(100);
    private IImageLoader Z;

    private Pair<String, Integer> Code(String str) {
        int indexOf = str.indexOf(91);
        int indexOf2 = str.indexOf(93);
        if (indexOf == -1 && indexOf2 == -1) {
            return null;
        }
        if (indexOf == 0) {
            throw V("[ is in the first character in field: " + str);
        } else if (indexOf2 < indexOf) {
            throw V("] is in front of [ bracket in field: " + str);
        } else {
            int i = indexOf + 1;
            if (indexOf2 == i) {
                throw V("It's empty in [] in field: " + str);
            }
            try {
                return new Pair<>(str.substring(0, indexOf), Integer.valueOf(Integer.parseInt(str.substring(i, indexOf2))));
            } catch (NumberFormatException e) {
                throw V("Number in [] is not valid in field: " + str);
            }
        }
    }

    private Object Code(JSONObject jSONObject, String str) {
        Pair<String, Integer> Code = Code(str);
        return Code != null ? jSONObject.getJSONArray(Code.first).get(Code.second.intValue()) : jSONObject.get(str);
    }

    private String Code(int i, String str) {
        return this.B.get(V(i, str));
    }

    private void Code(int i, String str, String str2) {
        this.B.put(V(i, str), str2);
    }

    private b V(String str) {
        ge.I("DTManager", str);
        return new b(str);
    }

    private String V(int i, String str) {
        return i + "#" + str;
    }

    public static DTManager getInstance() {
        DTManager dTManager;
        synchronized (I) {
            if (V == null) {
                V = new DTManager();
            }
            dTManager = V;
        }
        return dTManager;
    }

    public IImageLoader Code() {
        return this.Z;
    }

    public String Code(String str, JSONObject jSONObject) {
        Object Code;
        if (str == null || jSONObject == null) {
            return null;
        }
        int hashCode = jSONObject.hashCode();
        String Code2 = Code(hashCode, str);
        if (Code2 != null) {
            return Code2;
        }
        if (str.indexOf(46) > 0) {
            String[] split = str.split("\\.");
            int length = split.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return null;
                }
                Code = Code(jSONObject, split[i2]);
                if (i2 == length - 1) {
                    break;
                } else if (!(Code instanceof JSONObject)) {
                    throw V("Placement " + str + " is mismatch with json data");
                } else {
                    jSONObject = (JSONObject) Code;
                    i = i2 + 1;
                }
            }
        } else {
            Code = Code(jSONObject, str);
        }
        String valueOf = String.valueOf(Code);
        Code(hashCode, str, valueOf);
        return valueOf;
    }

    public void setImageLoader(IImageLoader iImageLoader) {
        this.Z = iImageLoader;
    }
}
