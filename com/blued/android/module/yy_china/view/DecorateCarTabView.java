package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.module.yy_china.databinding.ViewDecorateCarTabBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/DecorateCarTabView.class */
public final class DecorateCarTabView extends ConstraintLayout {
    private ViewDecorateCarTabBinding a;

    public DecorateCarTabView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DecorateCarTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.a(context);
        ViewDecorateCarTabBinding a = ViewDecorateCarTabBinding.a(LayoutInflater.from(getContext()), (ViewGroup) this, true);
        Intrinsics.c(a, "inflate(LayoutInflater.from(context), this, true)");
        this.a = a;
    }

    public final void setPointVisibility(int i) {
        this.a.b.setVisibility(i);
    }

    public final void setTabLineVisibility(int i) {
        this.a.a.setVisibility(i);
    }

    public final void setTabName(String name) {
        Intrinsics.e(name, "name");
        this.a.c.setText(name);
    }
}
