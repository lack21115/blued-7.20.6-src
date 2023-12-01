package com.opos.cmn.e.a.b.f;

import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import com.opos.cmn.i.g;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/e/a/b/f/a.class */
public class a extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private boolean f11088a;
    private com.opos.cmn.e.a.b.d.a b;

    /* renamed from: c  reason: collision with root package name */
    private Activity f11089c;

    public a(Activity activity, int i, com.opos.cmn.e.a.b.d.a aVar) {
        super(activity, i);
        this.f11088a = true;
        this.f11089c = activity;
        this.b = aVar;
    }

    public a(Activity activity, com.opos.cmn.e.a.b.d.a aVar) {
        super(activity);
        this.f11088a = true;
        this.f11089c = activity;
        this.b = aVar;
    }

    private void a() {
        com.opos.cmn.e.a.b.d.a aVar = this.b;
        if (aVar != null) {
            setCancelable(aVar.b);
            setCanceledOnTouchOutside(this.b.f11083c);
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                getWindow().setAttributes(attributes);
            }
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.f11088a) {
            com.opos.cmn.an.f.a.a("", "dialog has detach do not dismiss");
        } else {
            super.dismiss();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f11088a = false;
        com.opos.cmn.an.f.a.b("", "dialog onAttachedToWindow");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f11088a = true;
        com.opos.cmn.an.f.a.b("", "dialog onDetachedFromWindow");
    }

    @Override // android.app.Dialog
    public void show() {
        Activity activity = this.f11089c;
        if (activity == null || activity.isFinishing() || this.f11089c.isDestroyed()) {
            com.opos.cmn.an.f.a.b("", "show but activity has destroy");
            return;
        }
        g.a(getContext().getApplicationContext(), getWindow());
        super.show();
    }
}
