package com.tencent.ugc.datereport;

import com.tencent.liteav.base.datareport.Event4XReporter;
import com.tencent.liteav.base.system.LiteavSystemInfo;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/datereport/UGCDataReport.class */
public class UGCDataReport {
    private static UGCDataReport sInstance;
    private String mNetType = Integer.toString(LiteavSystemInfo.getNetworkType());
    private String mDevId = LiteavSystemInfo.getDeviceUuid();
    private String mDevUUID = LiteavSystemInfo.getDeviceUuid();
    private String mPkgName = LiteavSystemInfo.getAppPackageName();
    private String mAppName = LiteavSystemInfo.getAppName() + ":" + this.mPkgName;
    private String mSystemVersion = String.valueOf(LiteavSystemInfo.getSystemOSVersionInt());
    private final Event4XReporter mDAUReporter = new Event4XReporter(UGCDataReportDef.COMMAND_ID_DAU, 1004, "", true, 1);

    private UGCDataReport() {
    }

    private static UGCDataReport getInstance() {
        if (sInstance == null) {
            synchronized (UGCDataReport.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new UGCDataReport();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return sInstance;
    }

    public static void reportDAU(int i) {
        getInstance().reportDAUImpl(i);
    }

    public static void reportDAU(int i, int i2, String str) {
        getInstance().reportDAUImpl(i, i2, str);
    }

    private void reportDAUImpl(int i) {
        reportDAU(i, 0, "");
    }

    private void reportDAUImpl(int i, int i2, String str) {
        setCommonInfo();
        this.mDAUReporter.ReportDau(i, i2, str);
    }

    private void setCommonInfo() {
        String str = this.mNetType;
        if (str != null) {
            this.mDAUReporter.SetCommonStringValue("net_type", str);
        }
        String str2 = this.mDevId;
        if (str2 != null) {
            this.mDAUReporter.SetCommonStringValue(UGCDataReportDef.DR_KEY_DEV_ID, str2);
        }
        String str3 = this.mDevUUID;
        if (str3 != null) {
            this.mDAUReporter.SetCommonStringValue(UGCDataReportDef.DR_KEY_DEV_UUID, str3);
        }
        String str4 = this.mAppName;
        if (str4 != null) {
            this.mDAUReporter.SetCommonStringValue("app_name", str4);
        }
        String str5 = this.mSystemVersion;
        if (str5 != null) {
            this.mDAUReporter.SetCommonStringValue(UGCDataReportDef.DR_KEY_SYS_VER, str5);
        }
    }
}
