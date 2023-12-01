package com.bytedance.bdtracker;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.ss.android.downloadlib.constants.EventConstants;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/u0.class */
public class u0 extends i0 {
    public final Context e;
    public final m0 f;

    public u0(Context context, m0 m0Var) {
        super(false, false);
        this.e = context;
        this.f = m0Var;
    }

    @Override // com.bytedance.bdtracker.i0
    public boolean a(JSONObject jSONObject) {
        int i;
        String packageName = this.e.getPackageName();
        if (TextUtils.isEmpty(this.f.b.getZiJieCloudPkg())) {
            jSONObject.put("package", packageName);
        } else {
            z2.a("has zijie pkg");
            jSONObject.put("package", this.f.b.getZiJieCloudPkg());
            jSONObject.put(EventConstants.ExtraJson.REAL_PACKAGE_NAME, packageName);
        }
        try {
            PackageInfo packageInfo = this.e.getPackageManager().getPackageInfo(packageName, 0);
            int i2 = packageInfo.versionCode;
            jSONObject.put("app_version", !TextUtils.isEmpty(this.f.b.getVersion()) ? this.f.b.getVersion() : packageInfo.versionName);
            jSONObject.put("app_version_minor", !TextUtils.isEmpty(this.f.b.getVersionMinor()) ? this.f.b.getVersionMinor() : "");
            if (this.f.b.getVersionCode() != 0) {
                jSONObject.put("version_code", this.f.b.getVersionCode());
            } else {
                jSONObject.put("version_code", i2);
            }
            if (this.f.b.getUpdateVersionCode() != 0) {
                jSONObject.put("update_version_code", this.f.b.getUpdateVersionCode());
            } else {
                jSONObject.put("update_version_code", i2);
            }
            if (this.f.b.getManifestVersionCode() != 0) {
                jSONObject.put("manifest_version_code", this.f.b.getManifestVersionCode());
            } else {
                jSONObject.put("manifest_version_code", i2);
            }
            if (!TextUtils.isEmpty(this.f.b.getAppName())) {
                jSONObject.put("app_name", this.f.b.getAppName());
            }
            if (!TextUtils.isEmpty(this.f.b.getTweakedChannel())) {
                jSONObject.put("tweaked_channel", this.f.b.getTweakedChannel());
            }
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo == null || (i = applicationInfo.labelRes) <= 0) {
                return true;
            }
            jSONObject.put("display_name", this.e.getString(i));
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            z2.a("U SHALL NOT PASS!", e);
            return false;
        }
    }
}
