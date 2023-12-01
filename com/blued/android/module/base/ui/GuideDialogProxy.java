package com.blued.android.module.base.ui;

import com.blued.android.module.base.base.BaseProxy;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/base/ui/GuideDialogProxy.class */
public class GuideDialogProxy extends BaseProxy<IGuideDialog> implements IGuideDialog {
    private static GuideDialogProxy b;

    private GuideDialogProxy() {
    }

    public static GuideDialogProxy a() {
        if (b == null) {
            synchronized (GuideDialogProxy.class) {
                try {
                    if (b == null) {
                        b = new GuideDialogProxy();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }
}
