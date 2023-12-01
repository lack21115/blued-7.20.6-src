package com.blued.android.framework.activity.keyboardpage;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/activity/keyboardpage/SwitchPanelRelativeLayout.class */
public class SwitchPanelRelativeLayout extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private SwitchPanelLayoutHandler f9788a;

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
        this.f9788a = new SwitchPanelLayoutHandler(this);
    }

    public void a(boolean z) {
        this.f9788a.a(z);
    }

    public boolean a() {
        return this.f9788a.a();
    }

    public void b() {
        super.setVisibility(0);
    }

    public void c() {
        this.f9788a.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int[] a2 = this.f9788a.a(i, i2);
        super.onMeasure(a2[0], a2[1]);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (this.f9788a.a(i)) {
            return;
        }
        super.setVisibility(i);
    }
}
