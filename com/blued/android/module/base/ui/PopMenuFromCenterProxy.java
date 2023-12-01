package com.blued.android.module.base.ui;

import android.content.Context;
import com.blued.android.module.base.base.BaseProxy;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/base/ui/PopMenuFromCenterProxy.class */
public class PopMenuFromCenterProxy extends BaseProxy<IPopMenuFromCenter> implements IPopMenuFromCenter {
    private static PopMenuFromCenterProxy b;

    private PopMenuFromCenterProxy() {
    }

    public static PopMenuFromCenterProxy a() {
        if (b == null) {
            synchronized (PopMenuFromCenterProxy.class) {
                try {
                    if (b == null) {
                        b = new PopMenuFromCenterProxy();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    @Override // com.blued.android.module.base.ui.IPopMenuFromCenter
    public boolean a(Context context) {
        if (this.a != 0) {
            return ((IPopMenuFromCenter) this.a).a(context);
        }
        return false;
    }
}
