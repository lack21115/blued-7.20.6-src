package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.blued.android.module.yy_china.databinding.ItemKtvPrizeViewBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/ItemKtvPrizeView.class */
public final class ItemKtvPrizeView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private ItemKtvPrizeViewBinding f17950a;

    public ItemKtvPrizeView(Context context) {
        this(context, null);
    }

    public ItemKtvPrizeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ItemKtvPrizeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ItemKtvPrizeViewBinding a2 = ItemKtvPrizeViewBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics.c(a2, "inflate(LayoutInflater.from(context), this, true)");
        this.f17950a = a2;
    }

    public final ItemKtvPrizeViewBinding getBinding() {
        return this.f17950a;
    }

    public final void setBinding(ItemKtvPrizeViewBinding itemKtvPrizeViewBinding) {
        Intrinsics.e(itemKtvPrizeViewBinding, "<set-?>");
        this.f17950a = itemKtvPrizeViewBinding;
    }

    public final void setGiftCount(String count) {
        Intrinsics.e(count, "count");
        this.f17950a.f16624a.setText(count);
    }

    public final void setGiftIcon(int i) {
        this.f17950a.b.setImageResource(i);
    }

    public final void setGiftName(String name) {
        Intrinsics.e(name, "name");
        this.f17950a.f16625c.setText(name);
    }
}
