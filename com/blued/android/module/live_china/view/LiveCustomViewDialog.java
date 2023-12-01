package com.blued.android.module.live_china.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.blued.android.module.live_china.R;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveCustomViewDialog.class */
public class LiveCustomViewDialog extends Dialog {
    private OnBackCallBack a;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveCustomViewDialog$OnBackCallBack.class */
    public interface OnBackCallBack {
        void a();
    }

    public LiveCustomViewDialog(Context context) {
        super(context, R.style.TranslucentBackground);
    }

    public void a(View view) {
        requestWindowFeature(1);
        setContentView(view);
        setCancelable(false);
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= 21 && window != null && window.getDecorView() != null) {
            window.getDecorView().setSystemUiVisibility(GL10.GL_INVALID_ENUM);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        window.setGravity(17);
        window.setAttributes(attributes);
    }

    public void a(View view, OnBackCallBack onBackCallBack) {
        a(view);
        a(onBackCallBack);
        show();
    }

    public void a(OnBackCallBack onBackCallBack) {
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
