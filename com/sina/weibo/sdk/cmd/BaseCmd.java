package com.sina.weibo.sdk.cmd;

import com.sina.weibo.sdk.exception.WeiboException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/cmd/BaseCmd.class */
class BaseCmd {
    private long mNotificationDelay;
    private String mNotificationText;
    private String mNotificationTitle;

    public BaseCmd() {
    }

    public BaseCmd(String str) throws WeiboException {
        initFromJsonStr(str);
    }

    public BaseCmd(JSONObject jSONObject) {
        initFromJsonObj(jSONObject);
    }

    public long getNotificationDelay() {
        return this.mNotificationDelay;
    }

    public String getNotificationText() {
        return this.mNotificationText;
    }

    public String getNotificationTitle() {
        return this.mNotificationTitle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initFromJsonObj(JSONObject jSONObject) {
        this.mNotificationText = jSONObject.optString("notification_text");
        this.mNotificationTitle = jSONObject.optString("notification_title");
        this.mNotificationDelay = jSONObject.optLong("notification_delay");
    }

    protected void initFromJsonStr(String str) throws WeiboException {
        if (str == null) {
            return;
        }
        try {
            initFromJsonObj(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
            throw new WeiboException("pase cmd has error !!!");
        }
    }

    public void setNotificationDelay(long j) {
        this.mNotificationDelay = j;
    }

    public void setNotificationText(String str) {
        this.mNotificationText = str;
    }

    public void setNotificationTitle(String str) {
        this.mNotificationTitle = str;
    }
}
