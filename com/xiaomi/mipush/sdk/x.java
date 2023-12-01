package com.xiaomi.mipush.sdk;

import android.text.TextUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/x.class */
public class x {

    /* renamed from: a  reason: collision with root package name */
    int f41238a = 0;

    /* renamed from: a  reason: collision with other field name */
    String f165a = "";

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return !TextUtils.isEmpty(xVar.f165a) && xVar.f165a.equals(this.f165a);
    }
}
