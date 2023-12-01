package com.bytedance.android.live.saas.middleware.alog;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/android/live/saas/middleware/alog/ALogConfig.class */
public class ALogConfig {
    private ILogProtocol aLogService;
    private boolean isDebug;
    private boolean standalone;

    public ALogConfig(ILogProtocol iLogProtocol, boolean z) {
        this(iLogProtocol, z, false);
    }

    public ALogConfig(ILogProtocol iLogProtocol, boolean z, boolean z2) {
        this.standalone = true;
        this.isDebug = false;
        this.aLogService = iLogProtocol;
        this.standalone = z;
        this.isDebug = z2;
    }

    public ILogProtocol getALogService() {
        return this.aLogService;
    }

    public boolean getStandalone() {
        return this.standalone;
    }

    public boolean isDebug() {
        return this.isDebug;
    }

    public void setALogService(ILogProtocol iLogProtocol) {
        this.aLogService = iLogProtocol;
    }

    public void setDebug(boolean z) {
        this.isDebug = z;
    }

    public void setStandalone(boolean z) {
        this.standalone = z;
    }
}
