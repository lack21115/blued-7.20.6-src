package com.blued.android.module.common.view;

import android.app.Dialog;
import android.content.Context;
import androidx.lifecycle.Observer;
import com.blued.android.framework.utils.Logger;
import com.jeremyliao.liveeventbus.LiveEventBus;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/LifecycleDialog.class */
public class LifecycleDialog extends Dialog {
    private Observer<String> a;

    public LifecycleDialog(Context context) {
        super(context);
        this.a = new Observer<String>() { // from class: com.blued.android.module.common.view.LifecycleDialog.1
            /* renamed from: a */
            public void onChanged(String str) {
                Logger.e("LifecycleDialog", "关闭 LifecycleDialog 。。。");
                LifecycleDialog.this.cancel();
            }
        };
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        LiveEventBus.get("dialog_cancel_event", String.class).removeObserver(this.a);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        LiveEventBus.get("dialog_cancel_event", String.class).observeForever(this.a);
    }
}
