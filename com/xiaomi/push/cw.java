package com.xiaomi.push;

import android.content.Context;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/cw.class */
public abstract class cw {

    /* renamed from: a  reason: collision with root package name */
    private int f27631a;

    public cw(int i) {
        this.f27631a = i;
    }

    public int a() {
        return this.f27631a;
    }

    public abstract String a(Context context, String str, List<bg> list);

    /* renamed from: a  reason: collision with other method in class */
    public boolean m8559a(Context context, String str, List<bg> list) {
        return true;
    }
}
