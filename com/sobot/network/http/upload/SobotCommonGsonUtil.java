package com.sobot.network.http.upload;

import android.os.BatteryManager;
import android.text.TextUtils;
import com.alipay.sdk.util.i;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.igexin.push.core.b;
import com.sobot.network.http.model.UploadFileResult;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/upload/SobotCommonGsonUtil.class */
public class SobotCommonGsonUtil {
    public static Method convertGetter(Class cls, String str, Class<?>... clsArr) {
        String substring = str.substring(0, 1);
        String substring2 = str.substring(1);
        try {
            return cls.getMethod(MonitorConstants.CONNECT_TYPE_GET + substring.toUpperCase() + substring2, clsArr);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    private static String filterNull(String str) {
        if (TextUtils.isEmpty(str) || str.equals(b.l)) {
            return null;
        }
        String replace = str.replace("\n", "<br/>");
        String str2 = replace;
        if (replace.startsWith("<br/>")) {
            str2 = replace.substring(5, replace.length());
        }
        String str3 = str2;
        if (str2.endsWith("<br/>")) {
            str3 = str2.substring(0, str2.length() - 5);
        }
        return str3;
    }

    private static String filterNullStr(String str) {
        if (str.equalsIgnoreCase(b.l)) {
            return null;
        }
        return str;
    }

    public static boolean isEmpty(Object obj) {
        return obj == null || "".equals(obj) || b.l.equals(obj);
    }

    public static SobotUploadModel jsonToCommonModel(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SobotUploadModel sobotUploadModel = new SobotUploadModel();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("code")) {
                sobotUploadModel.setCode(filterNull(jSONObject.optString("code")));
            }
            if ("1".equals(filterNull(jSONObject.optString("code")))) {
                SobotUploadModelBase sobotUploadModelBase = new SobotUploadModelBase();
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                if (jSONObject2.has("status")) {
                    sobotUploadModelBase.setStatus(filterNull(jSONObject2.optString("status")));
                }
                if (jSONObject2.has("switchFlag")) {
                    sobotUploadModelBase.setSwitchFlag(filterNull(jSONObject2.optString("switchFlag")));
                }
                if (jSONObject2.has("msg")) {
                    sobotUploadModelBase.setMsg(filterNull(jSONObject2.optString("msg")));
                }
                sobotUploadModel.setData(sobotUploadModelBase);
            }
            if (jSONObject.has("msg")) {
                sobotUploadModel.setMsg(filterNull(jSONObject.optString("msg")));
            }
            return sobotUploadModel;
        } catch (JSONException e) {
            return sobotUploadModel;
        }
    }

    public static String map2Json(Map<String, String> map) {
        return (map == null || map.size() <= 0) ? "" : new JSONObject(map).toString();
    }

    public static String map2Str(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (!"items".equals(entry.getKey()) && !BatteryManager.EXTRA_LEVEL.equals(entry.getKey())) {
                    sb.append("\"" + entry.getKey() + "\":\"" + entry.getValue() + "\",");
                }
                sb.append("\"" + entry.getKey() + "\":" + entry.getValue() + ",");
            }
            String sb2 = sb.toString();
            return sb2.substring(0, sb2.lastIndexOf(",")) + i.d;
        } catch (Exception e) {
            return "";
        }
    }

    public static UploadFileResult obtainUploadFileResult(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            UploadFileResult uploadFileResult = new UploadFileResult();
            uploadFileResult.setMsgId(jSONObject.optString(RemoteMessageConst.MSGID));
            uploadFileResult.setUrl(jSONObject.optString("msg"));
            return uploadFileResult;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> JSONArray praseList2Json(List<T> list) {
        JSONArray jSONArray = new JSONArray();
        try {
            for (T t : list) {
                JSONObject jSONObject = new JSONObject();
                Field[] declaredFields = t.getClass().getDeclaredFields();
                int length = declaredFields.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < length) {
                        Field field = declaredFields[i2];
                        field.setAccessible(true);
                        Method convertGetter = convertGetter(t.getClass(), field.getName(), new Class[0]);
                        if (convertGetter != null) {
                            jSONObject.put(field.getName(), (String) convertGetter.invoke(t, new Object[0]));
                        }
                        i = i2 + 1;
                    }
                }
                jSONArray.put(jSONObject);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return jSONArray;
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
            return jSONArray;
        } catch (JSONException e3) {
            e3.printStackTrace();
        } catch (Exception e4) {
            e4.printStackTrace();
            return jSONArray;
        }
        return jSONArray;
    }
}
