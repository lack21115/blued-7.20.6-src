package com.qq.e.comm.managers.devtool;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: source-8303388-dex2jar.jar:com/qq/e/comm/managers/devtool/DevTools.class */
public class DevTools {

    /* renamed from: a  reason: collision with root package name */
    private String f27914a;

    public String getDemoGameUrl() {
        String str = this.f27914a;
        this.f27914a = null;
        return str;
    }

    public void testDemoGame(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context.getPackageName().equals("com.qq.e.union.demo.union")) {
            this.f27914a = str;
        }
    }
}
