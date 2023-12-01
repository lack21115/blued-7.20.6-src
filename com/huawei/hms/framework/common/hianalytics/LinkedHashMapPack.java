package com.huawei.hms.framework.common.hianalytics;

import java.util.LinkedHashMap;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/framework/common/hianalytics/LinkedHashMapPack.class */
public class LinkedHashMapPack {
    private LinkedHashMap<String, String> map = new LinkedHashMap<>();

    public LinkedHashMap<String, String> getAll() {
        return this.map;
    }

    public LinkedHashMapPack put(String str, long j) {
        if (str != null) {
            LinkedHashMap<String, String> linkedHashMap = this.map;
            linkedHashMap.put(str, "" + j);
        }
        return this;
    }

    public LinkedHashMapPack put(String str, String str2) {
        if (str != null && str2 != null) {
            this.map.put(str, str2);
        }
        return this;
    }

    public LinkedHashMapPack put(String str, boolean z) {
        if (str != null) {
            if (z) {
                this.map.put(str, "1");
                return this;
            }
            this.map.put(str, "0");
        }
        return this;
    }

    public LinkedHashMapPack putIfNotDefault(String str, long j, long j2) {
        return j == j2 ? this : put(str, j);
    }
}
