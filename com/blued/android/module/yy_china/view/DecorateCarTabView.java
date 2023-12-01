package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.module.yy_china.databinding.ViewDecorateCarTabBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/DecorateCarTabView.class */
public final class DecorateCarTabView extends ConstraintLayout {

    /* renamed from: a  reason: collision with root package name */
    private ViewDecorateCarTabBinding f17919a;

    public DecorateCarTabView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DecorateCarTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.a(context);
        ViewDecorateCarTabBinding a2 = ViewDecorateCarTabBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics.c(a2, "inflate(LayoutInflater.from(context), this, true)");
        this.f17919a = a2;
    }

    public final void setPointVisibility(int i) {
        this.f17919a.b.setVisibility(i);
    }

    public final void setTabLineVisibility(int i) {
        this.f17919a.f16850a.setVisibility(i);
    }

    public final void setTabName(String name) {
        Intrinsics.e(name, "name");
        this.f17919a.f16851c.setText(name);
    }
}
