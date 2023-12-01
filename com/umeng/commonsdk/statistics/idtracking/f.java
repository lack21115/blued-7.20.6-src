package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/idtracking/f.class */
public class f extends a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f40922a = "imei";
    private Context b;

    public f(Context context) {
        super("imei");
        this.b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return DeviceConfig.getImeiNew(this.b);
    }
}
