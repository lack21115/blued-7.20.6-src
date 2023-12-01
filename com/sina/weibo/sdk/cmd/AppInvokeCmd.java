package com.sina.weibo.sdk.cmd;

import com.sina.weibo.sdk.exception.WeiboException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/cmd/AppInvokeCmd.class */
public class AppInvokeCmd extends BaseCmd {
    private String appPackage;
    private String scheme;
    private String url;

    public AppInvokeCmd() {
    }

    public AppInvokeCmd(String str) throws WeiboException {
        super(str);
    }

    public AppInvokeCmd(JSONObject jSONObject) {
        super(jSONObject);
    }

    public String getAppPackage() {
        return this.appPackage;
    }

    public String getScheme() {
        return this.scheme;
    }

    public String getUrl() {
        return this.url;
    }

    @Override // com.sina.weibo.sdk.cmd.BaseCmd
    public void initFromJsonObj(JSONObject jSONObject) {
        super.initFromJsonObj(jSONObject);
        this.appPackage = jSONObject.optString("package");
        this.scheme = jSONObject.optString("scheme");
        this.url = jSONObject.optString("url");
    }

    public void setAppPackage(String str) {
        this.appPackage = str;
    }

    public void setScheme(String str) {
        this.scheme = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
