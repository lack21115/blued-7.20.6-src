package com.blued.android.module.live_china.view;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveBottomDialog.class */
public abstract class LiveBottomDialog extends Dialog {
    public LiveBottomDialog(Context context) {
        super(context);
        a();
    }

    public void a() {
        Window window = getWindow();
        window.requestFeature(1);
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        attributes.windowAnimations = R.style.BottomDialogAnimation;
        attributes.gravity = 80;
        window.setAttributes(attributes);
        window.setBackgroundDrawableResource(com.android.internal.R.color.transparent);
        b();
    }

    public abstract void b();
}
