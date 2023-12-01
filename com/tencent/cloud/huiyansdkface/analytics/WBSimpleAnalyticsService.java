package com.tencent.cloud.huiyansdkface.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import java.util.Properties;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/analytics/WBSimpleAnalyticsService.class */
public class WBSimpleAnalyticsService {

    /* renamed from: a  reason: collision with root package name */
    private d f21802a = new d();

    public void init(String str, String str2) {
        this.f21802a.b.setAppId(str);
        this.f21802a.i = str2;
    }

    public boolean startStatService(Context context, WBSimpleStartParam wBSimpleStartParam) {
        return this.f21802a.a(context, wBSimpleStartParam);
    }

    public void trackCustomKVEvent(Context context, String str, String str2, Properties properties) {
        this.f21802a.a(context, str, str2, properties, false);
    }

    public void trackIMSWarnVEvent(Context context, String str, String str2, Properties properties) {
        this.f21802a.a(context, str, str2, properties, true);
    }

    @Deprecated
    public void trackIMSWarnVEvent(Context context, String str, Properties properties) {
        this.f21802a.a(context, "IMSWarn", str, properties, true);
    }

    public void updateEcifNo(String str) {
        d dVar = this.f21802a;
        dVar.b.setEcifNo(str);
        if (d.g != null) {
            SharedPreferences.Editor edit = d.g.getSharedPreferences(dVar.b.getAppId(), 0).edit();
            edit.putString(d.f21813c, str);
            edit.commit();
        }
    }

    public void updateEnableWBAService(boolean z) {
        this.f21802a.h = z;
    }

    public boolean updateFieldValue(String str, String str2) {
        d dVar = this.f21802a;
        if (TextUtils.isEmpty(str) || !str.startsWith("field_y_")) {
            return false;
        }
        boolean z = true;
        int hashCode = str.hashCode();
        switch (hashCode) {
            case 576982986:
                if (str.equals("field_y_10")) {
                    z = true;
                    break;
                }
                break;
            case 576982987:
                if (str.equals("field_y_11")) {
                    z = true;
                    break;
                }
                break;
            case 576982988:
                if (str.equals("field_y_12")) {
                    z = true;
                    break;
                }
                break;
            case 576982989:
                if (str.equals("field_y_13")) {
                    z = true;
                    break;
                }
                break;
            case 576982990:
                if (str.equals("field_y_14")) {
                    z = true;
                    break;
                }
                break;
            case 576982991:
                if (str.equals("field_y_15")) {
                    z = true;
                    break;
                }
                break;
            case 576982992:
                if (str.equals("field_y_16")) {
                    z = true;
                    break;
                }
                break;
            case 576982993:
                if (str.equals("field_y_17")) {
                    z = true;
                    break;
                }
                break;
            case 576982994:
                if (str.equals("field_y_18")) {
                    z = true;
                    break;
                }
                break;
            case 576982995:
                if (str.equals("field_y_19")) {
                    z = true;
                    break;
                }
                break;
            default:
                switch (hashCode) {
                    case 1265538341:
                        if (str.equals("field_y_0")) {
                            z = false;
                            break;
                        }
                        break;
                    case 1265538342:
                        if (str.equals("field_y_1")) {
                            z = true;
                            break;
                        }
                        break;
                    case 1265538343:
                        if (str.equals("field_y_2")) {
                            z = true;
                            break;
                        }
                        break;
                    case 1265538344:
                        if (str.equals("field_y_3")) {
                            z = true;
                            break;
                        }
                        break;
                    case 1265538345:
                        if (str.equals("field_y_4")) {
                            z = true;
                            break;
                        }
                        break;
                    case 1265538346:
                        if (str.equals("field_y_5")) {
                            z = true;
                            break;
                        }
                        break;
                    case 1265538347:
                        if (str.equals("field_y_6")) {
                            z = true;
                            break;
                        }
                        break;
                    case 1265538348:
                        if (str.equals("field_y_7")) {
                            z = true;
                            break;
                        }
                        break;
                    case 1265538349:
                        if (str.equals("field_y_8")) {
                            z = true;
                            break;
                        }
                        break;
                    case 1265538350:
                        if (str.equals("field_y_9")) {
                            z = true;
                            break;
                        }
                        break;
                }
        }
        switch (z) {
            case false:
                Log.d(d.f21812a, "fieldKey=".concat(String.valueOf(str)));
                Log.d(d.f21812a, "fieldValue=".concat(String.valueOf(str2)));
                dVar.b.setField_y_0(str2);
                if (d.g != null) {
                    SharedPreferences.Editor edit = d.g.getSharedPreferences(dVar.b.getAppId(), 0).edit();
                    edit.putString(d.f, str2);
                    edit.commit();
                    return true;
                }
                return true;
            case true:
                dVar.b.setField_y_1(str2);
                return true;
            case true:
                dVar.b.setField_y_2(str2);
                return true;
            case true:
                dVar.b.setField_y_3(str2);
                return true;
            case true:
                dVar.b.setField_y_4(str2);
                return true;
            case true:
                dVar.b.setField_y_5(str2);
                return true;
            case true:
                dVar.b.setField_y_6(str2);
                return true;
            case true:
                dVar.b.setField_y_7(str2);
                return true;
            case true:
                dVar.b.setField_y_8(str2);
                return true;
            case true:
                dVar.b.setField_y_9(str2);
                return true;
            case true:
                dVar.b.setField_y_10(str2);
                return true;
            case true:
                dVar.b.setField_y_11(str2);
                return true;
            case true:
                dVar.b.setField_y_12(str2);
                return true;
            case true:
                dVar.b.setField_y_13(str2);
                return true;
            case true:
                dVar.b.setField_y_14(str2);
                return true;
            case true:
                dVar.b.setField_y_15(str2);
                return true;
            case true:
                dVar.b.setField_y_16(str2);
                return true;
            case true:
                dVar.b.setField_y_17(str2);
                return true;
            case true:
                dVar.b.setField_y_18(str2);
                return true;
            case true:
                dVar.b.setField_y_19(str2);
                return true;
            default:
                return false;
        }
    }

    public void updateOpenId(String str) {
        d dVar = this.f21802a;
        dVar.b.setOpenId(str);
        if (d.g != null) {
            SharedPreferences.Editor edit = d.g.getSharedPreferences(dVar.b.getAppId(), 0).edit();
            edit.putString(d.e, str);
            edit.commit();
        }
    }

    public void updateUnionId(String str) {
        d dVar = this.f21802a;
        dVar.b.setUnionId(str);
        if (d.g != null) {
            SharedPreferences.Editor edit = d.g.getSharedPreferences(dVar.b.getAppId(), 0).edit();
            edit.putString(d.d, str);
            edit.commit();
        }
    }
}
