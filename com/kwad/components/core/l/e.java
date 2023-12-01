package com.kwad.components.core.l;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.j.k;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/l/e.class */
public abstract class e extends AlertDialog {
    public Activity mActivity;
    protected final Context mContext;
    protected ViewGroup yE;

    public e(Activity activity) {
        super(activity);
        setOwnerActivity(activity);
        this.mActivity = activity;
        this.mContext = k.wrapContextIfNeed(activity);
    }

    protected ViewGroup cm() {
        return null;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Activity activity = this.mActivity;
        if (activity == null) {
            return;
        }
        try {
            k.g(activity);
        } catch (Throwable th) {
        }
        try {
            super.dismiss();
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th2);
        }
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i) {
        T t = (T) this.yE.findViewById(i);
        return t != null ? t : (T) super.findViewById(i);
    }

    protected abstract void g(View view);

    protected abstract int getLayoutId();

    protected boolean mG() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.AlertDialog, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.yE = getLayoutId() != 0 ? (ViewGroup) k.inflate(this.mContext, getLayoutId(), null) : cm();
            setContentView(this.yE);
            setCanceledOnTouchOutside(mG());
            getWindow().getDecorView().setPadding(0, 0, 0, 0);
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().clearFlags(131072);
            getWindow().setLayout(-1, -1);
            g(this.yE);
        } catch (Throwable th) {
            if (!KsAdSDKImpl.get().getIsExternal()) {
                throw th;
            }
            com.kwad.components.core.c.a.b(th);
            dismiss();
        }
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        setTitle((CharSequence) null);
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        super.setContentView(i);
        this.yE = (ViewGroup) k.inflate(this.mContext, i, null);
    }
}
