package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/ai.class */
public class ai {

    /* renamed from: a  reason: collision with root package name */
    private String f26927a;
    private boolean e = false;
    private int d = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f26928c = -1;
    private int b = -1;

    public ai(String str) {
        this.f26927a = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a();
    }

    private void a() {
        try {
            if (!this.f26927a.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                this.d = Integer.valueOf(this.f26927a).intValue();
                this.e = false;
                return;
            }
            String[] split = this.f26927a.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            if (split.length == 2) {
                this.b = Integer.valueOf(split[0]).intValue();
                this.f26928c = Integer.valueOf(split[1]).intValue();
                if (this.b < 1) {
                    this.b = 1;
                }
                if (this.f26928c > 24) {
                    this.f26928c = 24;
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
            return i3 != -1 && (i2 = this.f26928c) != -1 && i >= i3 && i <= i2;
        }
        int i4 = this.d;
        return i4 != -1 && i == i4;
    }
}
