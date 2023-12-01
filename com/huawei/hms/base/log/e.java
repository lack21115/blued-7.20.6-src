package com.huawei.hms.base.log;

import android.content.Context;
import android.util.Log;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/base/log/e.class */
public class e implements b {

    /* renamed from: a  reason: collision with root package name */
    public b f22616a;

    @Override // com.huawei.hms.base.log.b
    public void a(Context context, String str) {
        b bVar = this.f22616a;
        if (bVar != null) {
            bVar.a(context, str);
        }
    }

    @Override // com.huawei.hms.base.log.b
    public void a(b bVar) {
        this.f22616a = bVar;
    }

    @Override // com.huawei.hms.base.log.b
    public void a(String str, int i, String str2, String str3) {
        Log.println(i, "HMSSDK_" + str2, str3);
        b bVar = this.f22616a;
        if (bVar != null) {
            bVar.a(str, i, str2, str3);
        }
    }
}
