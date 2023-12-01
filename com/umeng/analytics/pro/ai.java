package com.umeng.analytics.pro;

import android.text.TextUtils;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/ai.class */
public class ai {

    /* renamed from: a  reason: collision with root package name */
    private String f40618a;
    private boolean e = false;
    private int d = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f40619c = -1;
    private int b = -1;

    public ai(String str) {
        this.f40618a = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a();
    }

    private void a() {
        try {
            if (!this.f40618a.contains("-")) {
                this.d = Integer.valueOf(this.f40618a).intValue();
                this.e = false;
                return;
            }
            String[] split = this.f40618a.split("-");
            if (split.length == 2) {
                this.b = Integer.valueOf(split[0]).intValue();
                this.f40619c = Integer.valueOf(split[1]).intValue();
                if (this.b < 1) {
                    this.b = 1;
                }
                if (this.f40619c > 24) {
                    this.f40619c = 24;
                }
            }
            this.e = true;
        } catch (Throwable th) {
        }
    }

    public boolean a(int i) {
        int i2;
        if (this.e) {
            int i3 = this.b;
            return i3 != -1 && (i2 = this.f40619c) != -1 && i >= i3 && i <= i2;
        }
        int i4 = this.d;
        return i4 != -1 && i == i4;
    }
}
