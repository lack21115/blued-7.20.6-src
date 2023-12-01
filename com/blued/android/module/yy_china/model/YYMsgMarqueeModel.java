package com.blued.android.module.yy_china.model;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYMsgMarqueeModel.class */
public class YYMsgMarqueeModel {
    public static final String DOUBLE_PEOPLE_MARRIAGE = "DoublePeopleNoticeImNode";
    public static final String HOST_UP_MARRIAGE = "YYHostUpMode";
    public static final String UP_MARRIAGE = "YYUpMode";
    public static final String VIP_MARRIAGE = "YYGlobalMsgMarqueeModel";
    private Object data;
    public String type;

    public YYMsgMarqueeModel(String str, Object obj) {
        this.type = str;
        this.data = obj;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object obj) {
        this.data = obj;
    }
}
