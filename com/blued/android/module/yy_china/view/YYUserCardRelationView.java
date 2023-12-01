package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.module.yy_china.databinding.ViewUserCardRelationBinding;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYUserCardRelationView.class */
public class YYUserCardRelationView extends ShapeLinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private ViewUserCardRelationBinding f18531a;

    public YYUserCardRelationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YYUserCardRelationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f18531a = ViewUserCardRelationBinding.a(LayoutInflater.from(context), this);
    }
}
