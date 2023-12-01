package com.blued.android.framework.view.stickylistheaders;

import android.content.Context;
import android.widget.Checkable;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickylistheaders/CheckableWrapperView.class */
class CheckableWrapperView extends WrapperView implements Checkable {
    public CheckableWrapperView(Context context) {
        super(context);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return ((Checkable) this.f10346a).isChecked();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        ((Checkable) this.f10346a).setChecked(z);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }
}
