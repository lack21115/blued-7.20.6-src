package com.soft.blued.utils.third;

import com.blued.android.core.AppInfo;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.device_identity.library.BluedDeviceIdentity;
import com.danlan.android.cognition.Cognition;
import com.danlan.android.cognition.collector.listener.DeviceInfoDependency;
import com.danlan.android.cognition.collector.listener.ExtraInfoFroAction;
import com.danlan.android.cognition.common.DeviceInfoConstant;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/third/BluedFingerPrintUtils.class */
public class BluedFingerPrintUtils {
    public static void a() {
        Cognition.init(AppInfo.d(), new DeviceInfoDependency() { // from class: com.soft.blued.utils.third.BluedFingerPrintUtils.1
            @Override // com.danlan.android.cognition.collector.listener.DeviceInfoDependency
            public Map<String, String> setApi() {
                HashMap hashMap = new HashMap();
                hashMap.put(DeviceInfoConstant.API_UPLOAD, "/passport/device");
                return hashMap;
            }

            @Override // com.danlan.android.cognition.collector.listener.DeviceInfoDependency
            public Map<String, String> setHeaderData() {
                HashMap hashMap = new HashMap();
                hashMap.put("Authorization", "Basic " + BluedHttpTools.d());
                return hashMap;
            }

            @Override // com.danlan.android.cognition.collector.listener.DeviceInfoDependency
            public Map<String, String> setServerDomain() {
                HashMap hashMap = new HashMap();
                hashMap.put(DeviceInfoConstant.SERVER_DOMAIN, BluedHttpUrl.q());
                return hashMap;
            }

            @Override // com.danlan.android.cognition.collector.listener.DeviceInfoDependency
            public String setSpecialUserAgent() {
                return AppInfo.b;
            }

            @Override // com.danlan.android.cognition.collector.listener.DeviceInfoDependency
            public Map<String, Object> setUserData() {
                HashMap hashMap = new HashMap();
                hashMap.put(DeviceInfoConstant.APP_NAME, "blued");
                hashMap.put(DeviceInfoConstant.CHANNEL, AppInfo.f9487c);
                hashMap.put(DeviceInfoConstant.USERID, UserInfo.getInstance().getLoginUserInfo().getUid());
                hashMap.put(DeviceInfoConstant.OAID, BluedDeviceIdentity.a().h());
                hashMap.put(DeviceInfoConstant.SMID, BluedDeviceIdentity.a().g());
                hashMap.put(DeviceInfoConstant.DUID, BluedDeviceIdentity.a().d());
                return hashMap;
            }
        });
    }

    public static void a(int i, final String str) {
        Cognition.getInstance(AppInfo.d()).uploadForAction(i, new ExtraInfoFroAction() { // from class: com.soft.blued.utils.third.BluedFingerPrintUtils.2
            @Override // com.danlan.android.cognition.collector.listener.ExtraInfoFroAction
            public HashMap<String, Object> setExtraInfo() {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put(DeviceInfoConstant.USERID, String.this);
                hashMap.put(DeviceInfoConstant.SMID, BluedDeviceIdentity.a().g());
                hashMap.put(DeviceInfoConstant.DUID, BluedDeviceIdentity.a().d());
                return hashMap;
            }
        });
    }
}
