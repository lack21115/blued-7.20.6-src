package com.huawei.hms.activity.internal;

import android.content.Intent;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/activity/internal/BusResponseResult.class */
public class BusResponseResult {

    /* renamed from: a  reason: collision with root package name */
    private Intent f8797a;
    private int b;

    public int getCode() {
        return this.b;
    }

    public Intent getIntent() {
        return this.f8797a;
    }

    public void setCode(int i) {
        this.b = i;
    }

    public void setIntent(Intent intent) {
        this.f8797a = intent;
    }
}
