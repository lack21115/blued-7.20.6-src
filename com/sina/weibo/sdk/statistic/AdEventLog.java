package com.sina.weibo.sdk.statistic;

import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/statistic/AdEventLog.class */
class AdEventLog extends EventLog {
    private String mAid = "";
    private String mAppkey = "";
    private Map<String, String> mExtend;
    private String mImei;

    public String getmAid() {
        return this.mAid;
    }

    public String getmAppkey() {
        return this.mAppkey;
    }

    public Map<String, String> getmExtend() {
        return this.mExtend;
    }

    public String getmImei() {
        return this.mImei;
    }

    public void setmAid(String str) {
        this.mAid = str;
    }

    public void setmAppkey(String str) {
        this.mAppkey = str;
    }

    public void setmExtend(Map<String, String> map) {
        this.mExtend = map;
    }

    public void setmImei(String str) {
        this.mImei = str;
    }
}
