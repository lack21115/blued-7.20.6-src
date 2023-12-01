package com.blued.android.module.base.ui;

import com.blued.android.module.base.base.BaseProxy;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/base/ui/BottomWindowProxy.class */
public class BottomWindowProxy extends BaseProxy<IBottomWindow> implements IBottomWindow {
    private static BottomWindowProxy b;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/base/ui/BottomWindowProxy$IActionSheetListener.class */
    public interface IActionSheetListener {
        void a(int i);

        void a(boolean z);
    }

    private BottomWindowProxy() {
    }

    public static BottomWindowProxy a() {
        if (b == null) {
            synchronized (BottomWindowProxy.class) {
                try {
                    if (b == null) {
                        b = new BottomWindowProxy();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }
}
