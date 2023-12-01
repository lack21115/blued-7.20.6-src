package com.blued.android.modules;

import com.blued.android.module.base.ui.BottomWindowProxy;
import com.blued.android.module.base.ui.IBottomWindow;
import com.blued.android.module.common.widget.menu.ActionSheet;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/modules/BottomWindowModule.class */
public class BottomWindowModule {
    protected static IBottomWindow a = new IBottomWindow() { // from class: com.blued.android.modules.BottomWindowModule.1

        /* renamed from: com.blued.android.modules.BottomWindowModule$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: source-5382004-dex2jar.jar:com/blued/android/modules/BottomWindowModule$1$1.class */
        class C01551 implements ActionSheet.ActionSheetListener {
            final /* synthetic */ BottomWindowProxy.IActionSheetListener a;

            @Override // com.blued.android.module.common.widget.menu.ActionSheet.ActionSheetListener
            public void a(ActionSheet actionSheet, int i) {
                BottomWindowProxy.IActionSheetListener iActionSheetListener = this.a;
                if (iActionSheetListener != null) {
                    iActionSheetListener.a(i);
                }
            }

            @Override // com.blued.android.module.common.widget.menu.ActionSheet.ActionSheetListener
            public void a(ActionSheet actionSheet, boolean z) {
                BottomWindowProxy.IActionSheetListener iActionSheetListener = this.a;
                if (iActionSheetListener != null) {
                    iActionSheetListener.a(z);
                }
            }
        }
    };

    public static void a() {
        BottomWindowProxy.a().a(a);
    }
}
