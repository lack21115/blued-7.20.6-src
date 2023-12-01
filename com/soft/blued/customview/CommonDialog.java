package com.soft.blued.customview;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/CommonDialog.class */
public class CommonDialog implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Dialog f28397a;
    private OnListener b;

    /* renamed from: com.soft.blued.customview.CommonDialog$1  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/CommonDialog$1.class */
    class AnonymousClass1 implements DialogInterface.OnKeyListener {
        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            return i == 4;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/CommonDialog$OnListener.class */
    public interface OnListener {
        void a();

        void b();

        void c();
    }

    public void a() {
        Dialog dialog = this.f28397a;
        if (dialog != null) {
            dialog.cancel();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        a();
        if (this.b == null) {
            return;
        }
        switch (view.getId()) {
            case R.id.dialog_action_left /* 2131363205 */:
                this.b.c();
                return;
            case R.id.dialog_action_middle /* 2131363206 */:
                this.b.b();
                return;
            case R.id.dialog_action_right /* 2131363207 */:
                this.b.a();
                return;
            default:
                return;
        }
    }
}
