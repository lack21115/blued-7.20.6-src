package com.huawei.hms.push.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/push/utils/JsonUtil.class */
public class JsonUtil {
    private JsonUtil() {
    }

    private static void a(JSONObject jSONObject, String str, Object obj, Bundle bundle) {
        if (obj == null) {
            HMSLog.w("JsonUtil", "transfer jsonObject to bundle failed, defaultValue is null.");
        } else if (obj instanceof String) {
            String str2 = (String) obj;
            if (TextUtils.isEmpty(str2)) {
                str2 = null;
            }
            bundle.putString(str, getString(jSONObject, str, str2));
        } else if (obj instanceof Integer) {
            bundle.putInt(str, getInt(jSONObject, str, ((Integer) obj).intValue()));
        } else if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            if (iArr.length == 0) {
                iArr = null;
            }
            bundle.putIntArray(str, getIntArray(jSONObject, str, iArr));
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            if (jArr.length == 0) {
                jArr = null;
            }
            bundle.putLongArray(str, getLongArray(jSONObject, str, jArr));
        } else if (!(obj instanceof String[])) {
            HMSLog.w("JsonUtil", "transfer jsonObject to bundle failed, invalid data type.");
        } else {
            String[] strArr = (String[]) obj;
            if (strArr.length == 0) {
                strArr = null;
            }
            bundle.putStringArray(str, getStringArray(jSONObject, str, strArr));
        }
    }

    public static int getInt(JSONObject jSONObject, String str, int i) {
        if (jSONObject != null) {
            try {
                if (jSONObject.has(str)) {
                    return jSONObject.getInt(str);
                }
            } catch (JSONException e) {
                HMSLog.w("JsonUtil", "JSONException: get " + str + " error.");
            }
        }
        return i;
    }

    public static int[] getIntArray(JSONObject jSONObject, String str, int[] iArr) {
        int[] iArr2 = null;
        if (jSONObject != null) {
            iArr2 = null;
            int[] iArr3 = null;
            try {
                if (jSONObject.has(str)) {
                    JSONArray jSONArray = jSONObject.getJSONArray(str);
                    int[] iArr4 = new int[jSONArray.length()];
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        iArr2 = iArr4;
                        iArr3 = iArr4;
                        if (i2 >= jSONArray.length()) {
                            break;
                        }
                        iArr4[i2] = ((Integer) jSONArray.get(i2)).intValue();
                        i = i2 + 1;
                    }
                }
            } catch (JSONException e) {
                HMSLog.w("JsonUtil", "JSONException: get " + str + " error.");
                iArr2 = iArr3;
            }
        }
        return iArr2 == null ? iArr : iArr2;
    }

    public static JSONArray getIntJsonArray(int[] iArr) {
        JSONArray jSONArray = new JSONArray();
        if (iArr != null) {
            if (iArr.length != 0) {
                int length = iArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    jSONArray.put(iArr[i2]);
                    i = i2 + 1;
                }
            } else {
                return jSONArray;
            }
        }
        return jSONArray;
    }

    public static long[] getLongArray(JSONObject jSONObject, String str, long[] jArr) {
        long[] jArr2 = null;
        if (jSONObject != null) {
            jArr2 = null;
            long[] jArr3 = null;
            try {
                if (jSONObject.has(str)) {
                    JSONArray jSONArray = jSONObject.getJSONArray(str);
                    long[] jArr4 = new long[jSONArray.length()];
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        jArr2 = jArr4;
                        jArr3 = jArr4;
                        if (i2 >= jSONArray.length()) {
                            break;
                        }
                        jArr4[i2] = jSONArray.getLong(i2);
                        i = i2 + 1;
                    }
                }
            } catch (JSONException e) {
                HMSLog.w("JsonUtil", "JSONException: get " + str + " error.");
                jArr2 = jArr3;
            }
        }
        return jArr2 == null ? jArr : jArr2;
    }

    public static JSONArray getLongJsonArray(long[] jArr) {
        JSONArray jSONArray = new JSONArray();
        if (jArr != null) {
            if (jArr.length != 0) {
                int length = jArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    jSONArray.put(jArr[i2]);
                    i = i2 + 1;
                }
            } else {
                return jSONArray;
            }
        }
        return jSONArray;
    }

    public static String getString(JSONObject jSONObject, String str, String str2) {
        if (jSONObject != null) {
            try {
                if (jSONObject.has(str) && jSONObject.get(str) != null) {
                    return String.valueOf(jSONObject.get(str));
                }
            } catch (JSONException e) {
                HMSLog.w("JsonUtil", "JSONException: get " + str + " error.");
            }
        }
        return str2;
    }

    public static String[] getStringArray(JSONObject jSONObject, String str, String[] strArr) {
        String[] strArr2 = null;
        if (jSONObject != null) {
            strArr2 = null;
            String[] strArr3 = null;
            try {
                if (jSONObject.has(str)) {
                    JSONArray jSONArray = jSONObject.getJSONArray(str);
                    String[] strArr4 = new String[jSONArray.length()];
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        strArr2 = strArr4;
                        strArr3 = strArr4;
                        if (i2 >= jSONArray.length()) {
                            break;
                        }
                        strArr4[i2] = (String) jSONArray.get(i2);
                        i = i2 + 1;
                    }
                }
            } catch (JSONException e) {
                HMSLog.w("JsonUtil", "JSONException: get " + str + " error.");
                strArr2 = strArr3;
            }
        }
        return strArr2;
    }

    public static JSONArray getStringJsonArray(String[] strArr) {
        JSONArray jSONArray = new JSONArray();
        if (strArr != null) {
            if (strArr.length != 0) {
                int length = strArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    jSONArray.put(strArr[i2]);
                    i = i2 + 1;
                }
            } else {
                return jSONArray;
            }
        }
        return jSONArray;
    }

    public static void transferJsonObjectToBundle(JSONObject jSONObject, Bundle bundle, HashMap<String, Object> hashMap) {
        for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
            a(jSONObject, entry.getKey(), entry.getValue(), bundle);
        }
    }
}
