package com.soft.blued.ui.login_register;

import android.content.DialogInterface;
import android.os.Bundle;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/BindingShowActivity.class */
public class BindingShowActivity extends BaseFragmentActivity {

    /* renamed from: c  reason: collision with root package name */
    private String f17671c = BindingShowActivity.class.getSimpleName();

    /* JADX WARN: Multi-variable type inference failed */
    private void f() {
        CommonAlertDialog.a(this, "", getResources().getString(2131890504), getResources().getString(2131890499), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.login_register.BindingShowActivity.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                TerminalActivity.d(BindingShowActivity.this, LinkMobileFragment.class, (Bundle) null);
                BindingShowActivity.this.finish();
            }
        }, getResources().getString(2131890500), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.login_register.BindingShowActivity.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                BindingShowActivity.this.finish();
            }
        }, new DialogInterface.OnDismissListener() { // from class: com.soft.blued.ui.login_register.BindingShowActivity.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                BindingShowActivity.this.finish();
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        f();
    }
}
