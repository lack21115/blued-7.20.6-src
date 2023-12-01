package com.blued.android.module.shortvideo.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/view/StvCustomDialog.class */
public class StvCustomDialog extends Dialog {
    private OnBackCallBack a;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/view/StvCustomDialog$OnBackCallBack.class */
    public interface OnBackCallBack {
        void a();
    }

    public StvCustomDialog(Context context, int i) {
        super(context, i);
    }

    public void a(OnBackCallBack onBackCallBack) {
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= 21 && window != null && window.getDecorView() != null) {
            window.getDecorView().setSystemUiVisibility(GL10.GL_INVALID_ENUM);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        window.setGravity(17);
        window.setAttributes(attributes);
        b(onBackCallBack);
        show();
    }

    public void b(OnBackCallBack onBackCallBack) {
        this.a = onBackCallBack;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        if (isShowing()) {
            dismiss();
        }
        OnBackCallBack onBackCallBack = this.a;
        if (onBackCallBack != null) {
            onBackCallBack.a();
        }
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }
}
