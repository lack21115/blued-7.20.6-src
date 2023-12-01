package com.blued.android.framework.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.internal.R;
import com.bytedance.applog.tracker.Tracker;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/dialog/ConfirmDialog.class */
public class ConfirmDialog implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener, View.OnClickListener {
    private Context b;
    private Drawable f;
    private Drawable g;
    private String h;
    private String i;
    private String j;
    private String k;
    private Dialog a = null;
    private View c = null;
    private OperationListener d = null;
    private boolean e = true;
    private boolean l = true;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/dialog/ConfirmDialog$Operation.class */
    public enum Operation {
        POSITIVE_CLICK,
        NEGATIVE_CLICK,
        CLOSE,
        CANCEL,
        DISMISS
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/dialog/ConfirmDialog$OperationListener.class */
    public interface OperationListener {
        void a(Operation operation);
    }

    public ConfirmDialog(Context context) {
        this.b = context;
    }

    private void a(Window window) {
        if (window == null || window.getDecorView() == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            window.getDecorView().setSystemUiVisibility(GL10.GL_INVALID_ENUM);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        }
        window.setBackgroundDrawableResource(R.color.transparent);
    }

    private void a(Operation operation) {
        OperationListener operationListener = this.d;
        if (operationListener != null) {
            operationListener.a(operation);
            this.l = false;
            a();
        }
    }

    private void b(View view) {
        ImageView imageView = (ImageView) view.findViewById(com.blued.android.framework.R.id.confirm_dialog_imageview_close_icon);
        if (imageView != null) {
            if (this.e) {
                imageView.setVisibility(8);
            } else {
                imageView.setImageDrawable(this.g);
                imageView.setVisibility(0);
                imageView.setOnClickListener(this);
            }
        }
        ImageView imageView2 = (ImageView) view.findViewById(com.blued.android.framework.R.id.confirm_dialog_imageview_top_picture);
        if (imageView2 != null) {
            Drawable drawable = this.f;
            if (drawable == null) {
                imageView2.setVisibility(8);
            } else {
                imageView2.setImageDrawable(drawable);
                imageView2.setVisibility(0);
            }
        }
        TextView textView = (TextView) view.findViewById(com.blued.android.framework.R.id.confirm_dialog_textview_title);
        if (textView != null) {
            if (TextUtils.isEmpty(this.h)) {
                textView.setVisibility(8);
            } else {
                textView.setText(this.h);
                textView.setVisibility(0);
            }
        }
        TextView textView2 = (TextView) view.findViewById(com.blued.android.framework.R.id.confirm_dialog_textview_message);
        if (textView2 != null) {
            if (TextUtils.isEmpty(this.i)) {
                textView2.setVisibility(8);
            } else {
                textView2.setText(this.i);
                textView2.setVisibility(0);
            }
        }
        TextView textView3 = (TextView) view.findViewById(com.blued.android.framework.R.id.confirm_dialog_textview_positive);
        if (textView3 != null) {
            if (TextUtils.isEmpty(this.j)) {
                textView3.setVisibility(8);
            } else {
                textView3.setText(this.j);
                textView3.setVisibility(0);
                textView3.setOnClickListener(this);
            }
        }
        TextView textView4 = (TextView) view.findViewById(com.blued.android.framework.R.id.confirm_dialog_textview_nagative);
        if (textView4 != null) {
            if (TextUtils.isEmpty(this.k)) {
                textView4.setVisibility(8);
                return;
            }
            textView4.setText(this.k);
            textView4.setVisibility(0);
            textView4.setOnClickListener(this);
        }
    }

    public ConfirmDialog a(View view) {
        this.c = view;
        return this;
    }

    public ConfirmDialog a(OperationListener operationListener) {
        this.d = operationListener;
        return this;
    }

    public ConfirmDialog a(boolean z) {
        this.e = z;
        return this;
    }

    public void a() {
        Dialog dialog = this.a;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.a.dismiss();
        this.a = null;
    }

    public void b() {
        if (this.c == null) {
            return;
        }
        Dialog dialog = new Dialog(this.b);
        this.a = dialog;
        dialog.requestWindowFeature(1);
        this.a.setContentView(this.c);
        this.a.setCancelable(this.e);
        this.a.setCanceledOnTouchOutside(this.e);
        if (this.e) {
            this.a.setOnCancelListener(this);
        }
        this.a.setOnDismissListener(this);
        a(this.a.getWindow());
        b(this.c);
        this.a.show();
    }

    public boolean c() {
        Dialog dialog = this.a;
        return dialog != null && dialog.isShowing();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        OperationListener operationListener = this.d;
        if (operationListener != null) {
            operationListener.a(Operation.CANCEL);
            this.l = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == com.blued.android.framework.R.id.confirm_dialog_textview_positive) {
            a(Operation.POSITIVE_CLICK);
        } else if (view.getId() == com.blued.android.framework.R.id.confirm_dialog_textview_nagative) {
            a(Operation.NEGATIVE_CLICK);
        } else if (view.getId() == com.blued.android.framework.R.id.confirm_dialog_imageview_close_icon) {
            a(Operation.CLOSE);
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        OperationListener operationListener = this.d;
        if (operationListener == null || !this.l) {
            return;
        }
        operationListener.a(Operation.DISMISS);
    }
}
