package com.umeng.commonsdk.statistics.idtracking;

import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/idtracking/i.class */
public class i extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f40926a = "serial";

    public i() {
        super("serial");
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return DeviceConfig.getSerial();
    }
}
