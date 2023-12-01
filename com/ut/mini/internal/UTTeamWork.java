package com.ut.mini.internal;

import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.log.a;
import com.alibaba.mtl.log.b;
import com.alibaba.mtl.log.c;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.ut.device.UTDevice;
import com.ut.mini.base.UTMIVariables;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/ut/mini/internal/UTTeamWork.class */
public class UTTeamWork {

    /* renamed from: a  reason: collision with root package name */
    private static UTTeamWork f41026a;

    public static UTTeamWork getInstance() {
        UTTeamWork uTTeamWork;
        synchronized (UTTeamWork.class) {
            try {
                if (f41026a == null) {
                    f41026a = new UTTeamWork();
                }
                uTTeamWork = f41026a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return uTTeamWork;
    }

    public void closeAuto1010Track() {
        c.a().p();
    }

    public void disableNetworkStatusChecker() {
    }

    public void dispatchLocalHits() {
    }

    public String getUtsid() {
        try {
            String appkey = a.a() != null ? a.a().getAppkey() : null;
            String utdid = UTDevice.getUtdid(b.a().getContext());
            long longValue = Long.valueOf(a.B).longValue();
            if (TextUtils.isEmpty(appkey) || TextUtils.isEmpty(utdid)) {
                return null;
            }
            return utdid + BridgeUtil.UNDERLINE_STR + appkey + BridgeUtil.UNDERLINE_STR + longValue;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void initialized() {
    }

    public void saveCacheDataToLocal() {
        com.alibaba.mtl.log.c.c.a().G();
    }

    public void setToAliyunOsPlatform() {
        UTMIVariables.getInstance().setToAliyunOSPlatform();
    }

    public void turnOffRealTimeDebug() {
        AppMonitor.turnOffRealTimeDebug();
    }

    public void turnOnRealTimeDebug(Map<String, String> map) {
        AppMonitor.turnOnRealTimeDebug(map);
    }
}
