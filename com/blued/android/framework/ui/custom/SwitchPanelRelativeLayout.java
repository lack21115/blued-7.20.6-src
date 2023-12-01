package com.blued.android.framework.ui.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/custom/SwitchPanelRelativeLayout.class */
public class SwitchPanelRelativeLayout extends RelativeLayout {
    private SwitchPanelLayoutHandler a;

    public SwitchPanelRelativeLayout(Context context) {
        super(context);
        a((AttributeSet) null);
    }

    public SwitchPanelRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public SwitchPanelRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        this.a = new SwitchPanelLayoutHandler(this);
    }

    public void a(boolean z) {
        this.a.a(z);
    }

    public boolean a() {
        return this.a.a();
    }

    public void b() {
        super.setVisibility(0);
    }

    public void c() {
        this.a.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int[] a = this.a.a(i, i2);
        super.onMeasure(a[0], a[1]);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (this.a.a(i)) {
            return;
        }
        super.setVisibility(i);
    }
}
