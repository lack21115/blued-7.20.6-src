package com.huawei.hms.support.api.entity.core;

import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/support/api/entity/core/JosGetNoticeReq.class */
public class JosGetNoticeReq extends JosBaseReq {
    public static final int NOTICE_TYPE_CONN = 0;
    public static final int NOTICE_TYPE_SIGN = 1;
    @Packed
    private int noticeType;

    private static <T> T get(T t) {
        return t;
    }

    public int getNoticeType() {
        return ((Integer) get(Integer.valueOf(this.noticeType))).intValue();
    }

    public void setNoticeType(int i) {
        this.noticeType = i;
    }
}
