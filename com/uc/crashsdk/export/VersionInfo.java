package com.uc.crashsdk.export;

/* loaded from: source-8829756-dex2jar.jar:com/uc/crashsdk/export/VersionInfo.class */
public class VersionInfo {
    public String mBuildId;
    public String mSubVersion;
    public String mVersion;

    public VersionInfo() {
        this.mVersion = null;
        this.mSubVersion = null;
        this.mBuildId = null;
    }

    public VersionInfo(VersionInfo versionInfo) {
        this.mVersion = null;
        this.mSubVersion = null;
        this.mBuildId = null;
        this.mVersion = versionInfo.mVersion;
        this.mSubVersion = versionInfo.mSubVersion;
        this.mBuildId = versionInfo.mBuildId;
    }
}
