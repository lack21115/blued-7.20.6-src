package com.bytedance.android.live.saas.middleware.applog;

import com.bytedance.android.live.base.api.IHostPermission;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/android/live/saas/middleware/applog/AppLogConfig.class */
public class AppLogConfig {
    private String appLogId;
    private IHostPermission hostPermission;
    private IAppLog impl;
    private boolean isToBVersion;
    private boolean standalone;

    public AppLogConfig() {
        this.impl = null;
        this.standalone = false;
        this.isToBVersion = false;
        this.appLogId = null;
        this.hostPermission = null;
    }

    public AppLogConfig(IAppLog iAppLog, boolean z) {
        this(iAppLog, z, false);
    }

    public AppLogConfig(IAppLog iAppLog, boolean z, boolean z2) {
        this(iAppLog, z, z2, null);
    }

    public AppLogConfig(IAppLog iAppLog, boolean z, boolean z2, String str) {
        this(iAppLog, z, z2, str, null);
    }

    public AppLogConfig(IAppLog iAppLog, boolean z, boolean z2, String str, IHostPermission iHostPermission) {
        this.impl = null;
        this.standalone = false;
        this.isToBVersion = false;
        this.appLogId = null;
        this.hostPermission = null;
        this.impl = iAppLog;
        this.standalone = z;
        this.isToBVersion = z2;
        this.appLogId = str;
        this.hostPermission = iHostPermission;
    }

    public String getAppLogId() {
        return this.appLogId;
    }

    public IHostPermission getHostPermission() {
        return this.hostPermission;
    }

    public IAppLog getImpl() {
        return this.impl;
    }

    public boolean getStandalone() {
        return this.standalone;
    }

    public boolean isToBVersion() {
        return this.isToBVersion;
    }

    public void setAppLogId(String str) {
        this.appLogId = str;
    }

    public void setHostPermission(IHostPermission iHostPermission) {
        this.hostPermission = iHostPermission;
    }

    public void setImpl(IAppLog iAppLog) {
        this.impl = iAppLog;
    }

    public void setStandalone(boolean z) {
        this.standalone = z;
    }

    public void setToBVersion(boolean z) {
        this.isToBVersion = z;
    }
}
