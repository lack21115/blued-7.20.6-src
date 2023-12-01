package mtopsdk.mtop.unit;

import android.content.Context;
import com.alibaba.fastjson.JSON;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.a.b.c;
import mtopsdk.a.b.g;
import mtopsdk.a.b.i;
import mtopsdk.common.util.MtopUtils;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.domain.ProtocolEnum;
import mtopsdk.mtop.global.SDKConfig;
import mtopsdk.mtop.global.SwitchConfig;
import mtopsdk.mtop.unit.UserUnit;
import mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory;
import mtopsdk.xstate.a;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/unit/UnitConfigManager.class */
public final class UnitConfigManager {
    private UnitConfigManager() {
    }

    private static UserUnit a(String str, String str2) {
        String str3;
        UserUnit.UnitType unitType;
        String[] split = str.split(",");
        UserUnit.UnitType unitType2 = null;
        UserUnit userUnit = null;
        if (split != null) {
            userUnit = null;
            if (split.length > 0) {
                int length = split.length;
                String str4 = null;
                int i = 0;
                while (i < length) {
                    String str5 = split[i];
                    try {
                        if (str5.contains("type=")) {
                            if (UserUnit.UnitType.UNIT.a().equalsIgnoreCase(str5.substring(5))) {
                                unitType = UserUnit.UnitType.UNIT;
                                str3 = str4;
                            } else {
                                unitType = UserUnit.UnitType.CENTER;
                                str3 = str4;
                            }
                        } else {
                            unitType = unitType2;
                            str3 = str4;
                            if (str5.contains("prefix=")) {
                                str3 = str5.substring(7);
                                unitType = unitType2;
                            }
                        }
                    } catch (Exception e) {
                        TBSdkLog.b("mtopsdk.UnitConfigManager", str2, "[parseUserUnitInfo] parse x-m-update-unitinfo  header error,userUnitInfo=" + str, e);
                        str3 = str4;
                        unitType = unitType2;
                    }
                    i++;
                    unitType2 = unitType;
                    str4 = str3;
                }
                userUnit = new UserUnit(a.b(), unitType2, str4);
            }
        }
        return userUnit;
    }

    public static void a() {
        if (SwitchConfig.a().d()) {
            if (MtopUtils.b()) {
                MtopSDKThreadPoolExecutorFactory.a(new Runnable() { // from class: mtopsdk.mtop.unit.UnitConfigManager.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        UnitConfigManager.c();
                    }
                });
            } else {
                c();
            }
        }
    }

    private static void a(String str, final String str2, final String str3) {
        if (StringUtils.b(str) || StringUtils.b(str2)) {
            TBSdkLog.c("mtopsdk.UnitConfigManager", str3, "[updateAndStoreApiUnitInfo] invalid apiUnitInfo,version=" + str + ",url=" + str2);
            return;
        }
        ApiUnit l = SDKConfig.a().l();
        if (l == null || !str.equals(l.f43775a)) {
            MtopSDKThreadPoolExecutorFactory.a(new Runnable() { // from class: mtopsdk.mtop.unit.UnitConfigManager.1
                @Override // java.lang.Runnable
                public final void run() {
                    String str4;
                    i c2;
                    try {
                        if (String.this.startsWith(ProtocolEnum.HTTP.a())) {
                            str4 = String.this;
                        } else {
                            str4 = ProtocolEnum.HTTP.a() + String.this;
                        }
                        Context b = SDKConfig.a().b();
                        try {
                            g b2 = SDKConfig.a().m().a(new c().a(str4).d(4099).a()).b();
                            if (b2 == null || b2.a() != 200 || (c2 = b2.c()) == null) {
                                return;
                            }
                            try {
                                ApiUnit apiUnit = null;
                                try {
                                    apiUnit = (ApiUnit) JSON.parseObject(new String(c2.c(), "utf-8"), ApiUnit.class);
                                } catch (Exception e) {
                                    TBSdkLog.d("mtopsdk.UnitConfigManager", str3, "[updateAndStoreApiUnitInfo]parse apiUnit json from cdn error ---" + e.toString());
                                }
                                if (apiUnit == null || !StringUtils.a(apiUnit.f43775a)) {
                                    return;
                                }
                                ApiUnit l2 = SDKConfig.a().l();
                                if (l2 == null || !apiUnit.f43775a.equals(l2.f43775a)) {
                                    SDKConfig.a().a(apiUnit);
                                    MtopUtils.a(apiUnit, b.getFilesDir(), "UNIT_SETTING_STORE.API_UNIT_ITEM");
                                    TBSdkLog.b("mtopsdk.UnitConfigManager", str3, "[updateAndStoreApiUnitInfo] update apiUnit succeed.apiUnit=" + apiUnit);
                                }
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    } catch (Exception e4) {
                        TBSdkLog.d("mtopsdk.UnitConfigManager", str3, "[updateAndStoreApiUnitInfo] generate apiUnit Config URL error.---" + e4.toString());
                    }
                }
            });
        } else if (TBSdkLog.a(TBSdkLog.LogEnable.DebugEnable)) {
            TBSdkLog.a("mtopsdk.UnitConfigManager", str3, "[updateAndStoreApiUnitInfo] current apiUnit version is up-to-date,version=" + str);
        }
    }

    public static void a(Map map, String str) {
        if (!SwitchConfig.a().d()) {
            TBSdkLog.b("mtopsdk.UnitConfigManager", str, "[parseUnitSettingHeader]unitSwitchOpen is false");
        } else if (map == null || map.isEmpty()) {
        } else {
            String a2 = com.taobao.tao.remotebusiness.listener.c.a(map, "x-m-update-unitinfo");
            if (StringUtils.a(a2)) {
                a(a(a2, str), str);
            }
            String a3 = com.taobao.tao.remotebusiness.listener.c.a(map, "x-m-update-unitapi");
            if (StringUtils.a(a3)) {
                Map b = b(a3, str);
                a((String) b.get("v="), (String) b.get("url="), str);
            }
        }
    }

    private static void a(UserUnit userUnit, String str) {
        if (userUnit == null) {
            TBSdkLog.c("mtopsdk.UnitConfigManager", str, "[updateAndStoreUserUnitInfo]  invalid userUnit,userUnit=" + userUnit);
        } else if (TBSdkLog.a(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.b("mtopsdk.UnitConfigManager", str, String.format("[updateAndStoreUserUnitInfo] update userUnitinfo succeed.userid=%s ;utdid=%s ;unitPrefix=%s", userUnit.f43777a, SDKConfig.a().g(), userUnit.f43778c));
        }
    }

    private static Map b(String str, String str2) {
        HashMap hashMap = new HashMap(2);
        String[] split = str.split(",");
        if (split != null && split.length > 0) {
            int length = split.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                String str3 = split[i2];
                try {
                    if (str3.contains("v=")) {
                        hashMap.put("v=", str3.substring(2));
                    } else if (str3.contains("url=")) {
                        hashMap.put("url=", str3.substring(4));
                    }
                } catch (Exception e) {
                    TBSdkLog.d("mtopsdk.UnitConfigManager", str2, "[parseApiUnitInfoParams] parse x-m-update-unitapi  header error---" + e.toString());
                }
                i = i2 + 1;
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c() {
        SDKConfig a2 = SDKConfig.a();
        if (a2.l() == null) {
            try {
                ApiUnit apiUnit = (ApiUnit) MtopUtils.a(a2.b().getFilesDir(), "UNIT_SETTING_STORE.API_UNIT_ITEM");
                if (apiUnit != null) {
                    a2.a(apiUnit);
                    if (TBSdkLog.a(TBSdkLog.LogEnable.InfoEnable)) {
                        TBSdkLog.b("mtopsdk.UnitConfigManager", "[loadUnitInfoFromLocalStore] load ApiUnit info from local Storage succeed.");
                    }
                }
            } catch (Exception e) {
                TBSdkLog.d("mtopsdk.UnitConfigManager", "[loadUnitInfoFromLocalStore] parse apiUnit from local Storage error ---" + e.toString());
            }
        }
    }
}
