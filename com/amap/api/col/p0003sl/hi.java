package com.amap.api.col.p0003sl;

import android.view.Window;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.amap.api.services.core.AMapException;
import com.android.ims.ImsReasonInfo;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3sl.hi  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/hi.class */
public final class hi {
    private static String[] a = {"com.amap.api.trace", "com.amap.api.trace.core"};

    public static int a(List<LatLng> list) {
        int i;
        int i2 = 0;
        if (list == null || list.size() == 0) {
            return 0;
        }
        int i3 = 0;
        while (true) {
            i = i3;
            if (i2 >= list.size() - 1) {
                break;
            }
            LatLng latLng = list.get(i2);
            i2++;
            LatLng latLng2 = list.get(i2);
            if (latLng == null) {
                break;
            } else if (latLng2 == null) {
                return i;
            } else {
                i3 = (int) (i + AMapUtils.calculateLineDistance(latLng, latLng2));
            }
        }
        return i;
    }

    private static void a(int i, String str) throws hf {
        if (i != 0) {
            switch (i) {
                case 10000:
                    return;
                case 10001:
                    throw new hf(AMapException.AMAP_INVALID_USER_KEY);
                case 10002:
                    throw new hf(AMapException.AMAP_SERVICE_NOT_AVAILBALE);
                case 10003:
                    throw new hf(AMapException.AMAP_DAILY_QUERY_OVER_LIMIT);
                case ImsReasonInfo.CODE_CALL_DROP_IWLAN_TO_LTE_UNAVAILABLE /* 10004 */:
                    throw new hf(AMapException.AMAP_ACCESS_TOO_FREQUENT);
                case 10005:
                    throw new hf(AMapException.AMAP_INVALID_USER_IP);
                case 10006:
                    throw new hf(AMapException.AMAP_INVALID_USER_DOMAIN);
                case 10007:
                    throw new hf("用户签名未通过");
                case 10008:
                    throw new hf(AMapException.AMAP_INVALID_USER_SCODE);
                case 10009:
                    throw new hf(AMapException.AMAP_USERKEY_PLAT_NOMATCH);
                case 10010:
                    throw new hf(AMapException.AMAP_IP_QUERY_OVER_LIMIT);
                case 10011:
                    throw new hf(AMapException.AMAP_NOT_SUPPORT_HTTPS);
                case 10012:
                    throw new hf(AMapException.AMAP_INSUFFICIENT_PRIVILEGES);
                case 10013:
                    throw new hf(AMapException.AMAP_USER_KEY_RECYCLED);
                default:
                    switch (i) {
                        case Window.PROGRESS_SECONDARY_START /* 20000 */:
                            throw new hf(AMapException.AMAP_SERVICE_INVALID_PARAMS);
                        case 20001:
                            throw new hf(AMapException.AMAP_SERVICE_MISSING_REQUIRED_PARAMS);
                        case 20002:
                            throw new hf(AMapException.AMAP_SERVICE_ILLEGAL_REQUEST);
                        case 20003:
                            throw new hf(AMapException.AMAP_SERVICE_UNKNOWN_ERROR);
                        default:
                            switch (i) {
                                case 30000:
                                    throw new hf(AMapException.AMAP_ENGINE_RESPONSE_ERROR);
                                case 30001:
                                    throw new hf(AMapException.AMAP_ENGINE_RESPONSE_DATA_ERROR);
                                case 30002:
                                    throw new hf(AMapException.AMAP_ENGINE_CONNECT_TIMEOUT);
                                case 30003:
                                    throw new hf(AMapException.AMAP_ENGINE_RETURN_TIMEOUT);
                                default:
                                    throw new hf(str);
                            }
                    }
            }
        }
    }

    public static void a(String str) throws hf {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("errcode")) {
                a(jSONObject.getInt("errcode"), jSONObject.getString("errmsg"));
            } else if (jSONObject.has("status") && jSONObject.has("infocode")) {
                String string = jSONObject.getString("status");
                int i = jSONObject.getInt("infocode");
                if ("1".equals(string)) {
                    return;
                }
                String string2 = jSONObject.getString("info");
                if ("0".equals(string)) {
                    a(i, string2);
                }
            }
        } catch (JSONException e) {
            throw new hf("协议解析错误 - ProtocolException");
        }
    }
}
