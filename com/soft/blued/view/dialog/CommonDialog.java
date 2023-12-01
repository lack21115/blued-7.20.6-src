package com.soft.blued.view.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/view/dialog/CommonDialog.class */
public class CommonDialog extends Dialog {
    private static int b = 2131951966;

    /* renamed from: a  reason: collision with root package name */
    private Activity f21171a;

    /* renamed from: c  reason: collision with root package name */
    private String f21172c;
    private String d;
    private TextView e;
    private TextView f;
    private Button g;
    private Button h;
    private ScrollView i;
    private String j;
    private String k;
    private View.OnClickListener l;
    private View.OnClickListener m;
    private int n;
    private CancelDialogListener o;
    private boolean p;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/view/dialog/CommonDialog$CancelDialogListener.class */
    public interface CancelDialogListener {
        void a();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        super.cancel();
        CancelDialogListener cancelDialogListener = this.o;
        if (cancelDialogListener != null) {
            cancelDialogListener.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.common_dialog);
        setCanceledOnTouchOutside(this.p);
        this.g = (Button) findViewById(R.id.common_dialog_left);
        this.h = (Button) findViewById(R.id.common_dialog_right);
        this.f = (TextView) findViewById(R.id.common_dialog_title);
        this.e = (TextView) findViewById(R.id.common_dialog_msg);
        this.i = (ScrollView) findViewById(R.id.common_dialog_scroll);
        if (this.n > 0) {
            this.i.setLayoutParams(new LinearLayout.LayoutParams(-1, this.n));
        }
        this.g.setText(this.j);
        this.h.setText(this.k);
        this.f.setText(this.d);
        this.e.setText(this.f21172c);
        if (this.l == null) {
            this.g.setVisibility(8);
        } else {
            this.g.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.view.dialog.CommonDialog.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    CommonDialog.this.g.setEnabled(false);
                    if (CommonDialog.this.f21171a == null) {
                        return;
                    }
                    if (!CommonDialog.this.f21171a.isFinishing() && CommonDialog.this.isShowing()) {
                        CommonDialog.this.dismiss();
                    }
                    if (CommonDialog.this.l != null) {
                        CommonDialog.this.l.onClick(view);
                    }
                }
            });
        }
        this.h.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.view.dialog.CommonDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                CommonDialog.this.h.setEnabled(false);
                if (CommonDialog.this.f21171a == null) {
                    return;
                }
                if (!CommonDialog.this.f21171a.isFinishing() && CommonDialog.this.isShowing()) {
                    CommonDialog.this.dismiss();
                }
                if (CommonDialog.this.m != null) {
                    CommonDialog.this.m.onClick(view);
                }
            }
        });
    }
}
