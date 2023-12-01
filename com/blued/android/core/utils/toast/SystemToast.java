package com.blued.android.core.utils.toast;

import android.app.Application;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.blued.android.core.utils.toast.config.IToast;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/utils/toast/SystemToast.class */
public class SystemToast extends Toast implements IToast {
    private TextView a;

    public SystemToast(Application application) {
        super(application);
    }

    @Override // com.blued.android.core.utils.toast.config.IToast
    public /* synthetic */ TextView a(View view) {
        return IToast.CC.$default$a(this, view);
    }

    @Override // android.widget.Toast, com.blued.android.core.utils.toast.config.IToast
    public void setText(CharSequence charSequence) {
        super.setText(charSequence);
        TextView textView = this.a;
        if (textView == null) {
            return;
        }
        textView.setText(charSequence);
    }

    @Override // android.widget.Toast, com.blued.android.core.utils.toast.config.IToast
    public void setView(View view) {
        super.setView(view);
        if (view == null) {
            this.a = null;
        } else {
            this.a = a(view);
        }
    }
}
