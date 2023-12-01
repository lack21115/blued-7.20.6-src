package com.opos.mobad.interstitial.a;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/interstitial/a/d.class */
public class d extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private Boolean f26233a;
    private Activity b;

    public d(Activity activity, int i) {
        super(activity, i);
        this.f26233a = null;
        this.b = activity;
    }

    private void a() {
        setCancelable(true);
        setCanceledOnTouchOutside(false);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Boolean bool = this.f26233a;
        if (bool == null || !bool.booleanValue()) {
            super.dismiss();
        } else {
            com.opos.cmn.an.f.a.a("", "dialog has detach do not dismiss");
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f26233a = false;
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
        this.f26233a = true;
        com.opos.cmn.an.f.a.b("", "dialog onDetachedFromWindow");
    }

    @Override // android.app.Dialog
    public void show() {
        Activity activity = this.b;
        if (activity == null || activity.isFinishing() || this.b.isDestroyed()) {
            com.opos.cmn.an.f.a.b("", "show but activity has destroy");
            return;
        }
        com.opos.cmn.i.g.a(getContext().getApplicationContext(), getWindow());
        super.show();
    }
}
