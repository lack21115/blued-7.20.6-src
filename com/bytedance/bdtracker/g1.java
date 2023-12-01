package com.bytedance.bdtracker;

import com.bytedance.applog.AppLog;
import com.volcengine.onekit.service.Device;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/g1.class */
public class g1 implements Device {
    public String getDeviceID() {
        return AppLog.getDid();
    }

    public String getInstallID() {
        return AppLog.getIid();
    }

    public String getSsID() {
        return AppLog.getSsid();
    }
}
