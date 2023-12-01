package com.sina.weibo.sdk.statistic;

import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/statistic/EventLog.class */
class EventLog extends PageLog {
    private String mEvent_id;
    private Map<String, String> mExtend;

    public EventLog() {
    }

    public EventLog(String str, String str2, Map<String, String> map) {
        super(str);
        this.mEvent_id = str2;
        this.mExtend = map;
    }

    public String getEvent_id() {
        return this.mEvent_id;
    }

    public Map<String, String> getExtend() {
        return this.mExtend;
    }

    public String getmEvent_id() {
        return this.mEvent_id;
    }

    public void setmEvent_id(String str) {
        this.mEvent_id = str;
    }
}
