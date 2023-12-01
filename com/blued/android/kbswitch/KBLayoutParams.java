package com.blued.android.kbswitch;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/kbswitch/KBLayoutParams.class */
public final class KBLayoutParams extends ConstraintLayout.LayoutParams implements IKBLayoutParams {
    private int w;
    private int x;

    public KBLayoutParams(int i, int i2) {
        super(i, i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KBLayoutParams(Context c2, AttributeSet attributeSet) {
        super(c2, attributeSet);
        Intrinsics.e(c2, "c");
        TypedArray obtainStyledAttributes = c2.obtainStyledAttributes(attributeSet, R.styleable.KeyboardConstraintLayout_LP);
        Intrinsics.c(obtainStyledAttributes, "c.obtainStyledAttributes…boardConstraintLayout_LP)");
        a(obtainStyledAttributes.getInt(R.styleable.KeyboardConstraintLayout_LP_kb_layout_type, 0));
        b(obtainStyledAttributes.getResourceId(R.styleable.KeyboardConstraintLayout_LP_kb_panel_layout_id, 0));
        obtainStyledAttributes.recycle();
    }

    public KBLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public KBLayoutParams(ConstraintLayout.LayoutParams layoutParams) {
        super(layoutParams);
    }

    @Override // com.blued.android.kbswitch.IKBLayoutParams
    public int a() {
        return this.w;
    }

    public void a(int i) {
        this.w = i;
    }

    public int b() {
        return this.x;
    }

    public void b(int i) {
        this.x = i;
    }
}
