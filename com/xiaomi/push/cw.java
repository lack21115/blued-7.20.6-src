package com.xiaomi.push;

import android.content.Context;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/cw.class */
public abstract class cw {

    /* renamed from: a  reason: collision with root package name */
    private int f41322a;

    public cw(int i) {
        this.f41322a = i;
    }

    public int a() {
        return this.f41322a;
    }

    public abstract String a(Context context, String str, List<bg> list);

    /* renamed from: a  reason: collision with other method in class */
    public boolean m11609a(Context context, String str, List<bg> list) {
        return true;
    }
}
