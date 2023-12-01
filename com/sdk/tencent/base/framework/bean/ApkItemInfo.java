package com.sdk.tencent.base.framework.bean;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import com.sdk.tencent.k.a;
import java.io.File;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/base/framework/bean/ApkItemInfo.class */
public class ApkItemInfo {
    private String apkfile;
    private Drawable icon;
    private int isSystemApp = -1;
    private CharSequence lable;
    private PackageInfo packageInfo;
    private String pkName;
    private int versionCode;
    private String versionName;

    public ApkItemInfo(Context context, File file) {
        if (file != null) {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(file.getPath(), 0);
            ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
            applicationInfo.sourceDir = file.getPath();
            applicationInfo.publicSourceDir = file.getPath();
            getApkItemInfo(packageManager, packageArchiveInfo, applicationInfo);
        }
    }

    public ApkItemInfo(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        getApkItemInfo(packageManager, packageManager.getPackageInfo(str, 0), packageManager.getApplicationInfo(str, 128));
    }

    public void getApkItemInfo(PackageManager packageManager, PackageInfo packageInfo, ApplicationInfo applicationInfo) {
        try {
            this.icon = packageManager.getApplicationIcon(packageInfo.applicationInfo);
        } catch (Exception e) {
            this.icon = packageManager.getDefaultActivityIcon();
        }
        try {
            this.lable = packageManager.getApplicationLabel(packageInfo.applicationInfo);
        } catch (Exception e2) {
        }
        try {
            if ((packageInfo.applicationInfo.flags & 1) == 0) {
                this.isSystemApp = 0;
            } else {
                this.isSystemApp = 1;
            }
        } catch (Exception e3) {
        }
        this.pkName = applicationInfo.packageName;
        this.versionName = packageInfo.versionName;
        this.versionCode = packageInfo.versionCode;
        this.apkfile = applicationInfo.sourceDir;
        this.packageInfo = packageInfo;
    }

    public String getApkfile() {
        return this.apkfile;
    }

    public Drawable getIcon() {
        return this.icon;
    }

    public int getIsSystemApp() {
        return this.isSystemApp;
    }

    public CharSequence getLable() {
        return this.lable;
    }

    public PackageInfo getPackageInfo() {
        return this.packageInfo;
    }

    public String getPkName() {
        return this.pkName;
    }

    public int getVersionCode() {
        return this.versionCode;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public void setApkfile(String str) {
        this.apkfile = str;
    }

    public void setIcon(Drawable drawable) {
        this.icon = drawable;
    }

    public void setIsSystemApp(int i) {
        this.isSystemApp = i;
    }

    public void setLable(CharSequence charSequence) {
        this.lable = charSequence;
    }

    public void setPackageInfo(PackageInfo packageInfo) {
        this.packageInfo = packageInfo;
    }

    public void setPkName(String str) {
        this.pkName = str;
    }

    public void setVersionCode(int i) {
        this.versionCode = i;
    }

    public void setVersionName(String str) {
        this.versionName = str;
    }

    public String toJsonString() {
        return a.a(this);
    }

    public String toString() {
        return "ApkItemInfo [icon=" + this.icon + ", pkName=" + this.pkName + ", lable=" + ((Object) this.lable) + ", versionName=" + this.versionName + ", versionCode=" + this.versionCode + ", apkfile=" + this.apkfile + ", packageInfo=" + this.packageInfo + "]";
    }
}
