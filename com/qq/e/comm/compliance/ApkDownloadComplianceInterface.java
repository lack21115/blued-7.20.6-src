package com.qq.e.comm.compliance;

/* loaded from: source-8303388-dex2jar.jar:com/qq/e/comm/compliance/ApkDownloadComplianceInterface.class */
public interface ApkDownloadComplianceInterface {
    public static final int INSTALL_BITS = 256;
    public static final int SCENES_AD_OR_NATIVE_LANDING_PAGE = 1;
    public static final int SCENES_WEB_LANDING_PAGE = 2;

    String getApkInfoUrl();

    void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener);
}
