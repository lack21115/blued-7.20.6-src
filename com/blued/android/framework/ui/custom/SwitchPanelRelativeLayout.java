package com.blued.android.framework.ui.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/custom/SwitchPanelRelativeLayout.class */
public class SwitchPanelRelativeLayout extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private SwitchPanelLayoutHandler f9885a;

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
        this.f9885a = new SwitchPanelLayoutHandler(this);
    }

    public void a(boolean z) {
        this.f9885a.a(z);
    }

    public boolean a() {
        return this.f9885a.a();
    }

    public void b() {
        super.setVisibility(0);
    }

    public void c() {
        this.f9885a.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int[] a2 = this.f9885a.a(i, i2);
        super.onMeasure(a2[0], a2[1]);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (this.f9885a.a(i)) {
            return;
        }
        super.setVisibility(i);
    }
}
