package com.umeng.commonsdk.statistics.common;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/common/DeviceTypeEnum.class */
public enum DeviceTypeEnum {
    IMEI("imei", "imei"),
    OAID("oaid", "oaid"),
    ANDROIDID("android_id", "android_id"),
    MAC("mac", "mac"),
    SERIALNO("serial_no", "serial_no"),
    IDFA(com.anythink.expressad.foundation.g.a.bj, com.anythink.expressad.foundation.g.a.bj),
    DEFAULT(com.igexin.push.core.b.l, com.igexin.push.core.b.l);
    
    private String description;
    private String deviceIdType;

    DeviceTypeEnum(String str, String str2) {
        this.deviceIdType = str;
        this.description = str2;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDeviceIdType() {
        return this.deviceIdType;
    }
}
