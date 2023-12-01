package com.blued.android.module.base.ui;

import com.blued.android.module.base.base.BaseProxy;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/base/ui/AtChooseUserHelperProxy.class */
public class AtChooseUserHelperProxy extends BaseProxy<IAtChooseUserHelper> implements IAtChooseUserHelper {
    private static AtChooseUserHelperProxy b;

    private AtChooseUserHelperProxy() {
    }

    public static AtChooseUserHelperProxy a() {
        if (b == null) {
            synchronized (AtChooseUserHelperProxy.class) {
                try {
                    if (b == null) {
                        b = new AtChooseUserHelperProxy();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }
}
