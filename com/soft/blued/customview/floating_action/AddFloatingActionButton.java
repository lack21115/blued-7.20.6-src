package com.soft.blued.customview.floating_action;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/floating_action/AddFloatingActionButton.class */
public class AddFloatingActionButton extends FloatingActionButton {

    /* renamed from: a  reason: collision with root package name */
    int f28579a;

    public AddFloatingActionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AddFloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.soft.blued.customview.floating_action.FloatingActionButton
    public void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AddFloatingActionButton, 0, 0);
        this.f28579a = obtainStyledAttributes.getColor(0, a(17170443));
        obtainStyledAttributes.recycle();
        super.a(context, attributeSet);
    }

    public int getPlusColor() {
        return this.f28579a;
    }

    @Override // com.soft.blued.customview.floating_action.FloatingActionButton
    public void setIcon(int i) {
        throw new UnsupportedOperationException("Use FloatingActionButton if you want to use custom icon");
    }

    public void setPlusColor(int i) {
        if (this.f28579a != i) {
            this.f28579a = i;
        }
    }

    public void setPlusColorResId(int i) {
        setPlusColor(a(i));
    }
}
