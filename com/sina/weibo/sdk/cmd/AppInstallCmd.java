package com.sina.weibo.sdk.cmd;

import android.provider.Settings;
import android.text.TextUtils;
import com.sina.weibo.sdk.exception.WeiboException;
import com.ss.android.downloadlib.constants.EventConstants;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/cmd/AppInstallCmd.class */
public class AppInstallCmd extends BaseCmd {
    private List<String> appPackages;
    private String appSign;
    private long appVersion;
    private String downloadUrl;

    public AppInstallCmd() {
    }

    public AppInstallCmd(String str) throws WeiboException {
        super(str);
    }

    public AppInstallCmd(JSONObject jSONObject) {
        super(jSONObject);
    }

    public List<String> getAppPackage() {
        return this.appPackages;
    }

    public String getAppSign() {
        return this.appSign;
    }

    public long getAppVersion() {
        return this.appVersion;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    @Override // com.sina.weibo.sdk.cmd.BaseCmd
    public void initFromJsonObj(JSONObject jSONObject) {
        super.initFromJsonObj(jSONObject);
        this.downloadUrl = jSONObject.optString(EventConstants.ExtraJson.DOWNLOAD_URL);
        String optString = jSONObject.optString(Settings.EXTRA_APP_PACKAGE);
        if (!TextUtils.isEmpty(optString)) {
            this.appPackages = Arrays.asList(optString.split("\\|"));
        }
        this.appSign = jSONObject.optString("app_sign");
        this.appVersion = jSONObject.optLong("app_version");
    }

    public void setAppPackage(List<String> list) {
        this.appPackages = list;
    }

    public void setAppSign(String str) {
        this.appSign = str;
    }

    public void setAppVersion(long j) {
        this.appVersion = j;
    }

    public void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }
}
