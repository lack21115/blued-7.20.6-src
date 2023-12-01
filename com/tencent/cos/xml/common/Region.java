package com.tencent.cos.xml.common;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/common/Region.class */
public enum Region {
    AP_Beijing_1("ap-beijing-1"),
    AP_Beijing("ap-beijing"),
    AP_Shanghai("ap-shanghai"),
    AP_Guangzhou("ap-guangzhou"),
    AP_Guangzhou_2("ap-guangzhou-2"),
    AP_Chengdu("ap-chengdu"),
    AP_Singapore("ap-singapore"),
    AP_Hongkong("ap-hongkong"),
    NA_Toronto("na-toronto"),
    EU_Frankfurt("eu-frankfurt"),
    CN_NORTH("cn-north"),
    CN_SOUTH("cn-south"),
    CN_EAST("cn-east"),
    CN_SOUTHWEST("cn-southwest"),
    SG("sg");
    
    private String region;

    Region(String str) {
        this.region = str;
    }

    public static Region fromValue(String str) {
        Region[] values = values();
        int length = values.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return null;
            }
            Region region = values[i2];
            if (region.region.equalsIgnoreCase(str)) {
                return region;
            }
            i = i2 + 1;
        }
    }

    public String getRegion() {
        return this.region;
    }
}
