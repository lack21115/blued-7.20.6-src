package com.xiaomi.push;

import android.content.Context;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ds.class */
public class ds extends dr {
    public ds(Context context, int i) {
        super(context, i);
    }

    @Override // com.xiaomi.push.dr
    public hi a() {
        return hi.Storage;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo11550a() {
        return "23";
    }

    @Override // com.xiaomi.push.dr
    public String b() {
        return "ram:" + i.m11926a() + ",rom:" + i.m11929b() + "|ramOriginal:" + i.c() + ",romOriginal:" + i.d();
    }
}
