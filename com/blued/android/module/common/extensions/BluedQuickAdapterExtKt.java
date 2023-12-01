package com.blued.android.module.common.extensions;

import android.view.View;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.chad.library.adapter.base.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/extensions/BluedQuickAdapterExtKt.class */
public final class BluedQuickAdapterExtKt {
    public static final BaseViewHolder a(BaseViewHolder baseViewHolder, int i, float f) {
        Intrinsics.e(baseViewHolder, "<this>");
        View view = baseViewHolder.getView(i);
        if (view != null) {
            ShapeHelper.a((ShapeHelper.ShapeView) view, f);
            return baseViewHolder;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.blued.android.framework.view.shape.ShapeHelper.ShapeView");
    }

    public static final BaseViewHolder a(BaseViewHolder baseViewHolder, int i, float f, float f2, float f3) {
        Intrinsics.e(baseViewHolder, "<this>");
        View view = baseViewHolder.getView(i);
        if (view != null) {
            ShapeHelper.a((ShapeHelper.ShapeView) view, f, f2, f3);
            return baseViewHolder;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.blued.android.framework.view.shape.ShapeHelper.ShapeView");
    }

    public static final BaseViewHolder a(BaseViewHolder baseViewHolder, int i, float f, float f2, float f3, float f4) {
        Intrinsics.e(baseViewHolder, "<this>");
        View view = baseViewHolder.getView(i);
        if (view != null) {
            ShapeHelper.a((ShapeHelper.ShapeView) view, f, f2, f3, f4);
            return baseViewHolder;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.blued.android.framework.view.shape.ShapeHelper.ShapeView");
    }

    public static final BaseViewHolder a(BaseViewHolder baseViewHolder, int i, int i2) {
        Intrinsics.e(baseViewHolder, "<this>");
        View view = baseViewHolder.getView(i);
        if (view != null) {
            ShapeHelper.b((ShapeHelper.ShapeView) view, i2);
            return baseViewHolder;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.blued.android.framework.view.shape.ShapeHelper.ShapeView");
    }

    public static final BaseViewHolder b(BaseViewHolder baseViewHolder, int i, int i2) {
        Intrinsics.e(baseViewHolder, "<this>");
        View view = baseViewHolder.getView(i);
        if (view != null) {
            ShapeHelper.d((ShapeHelper.ShapeView) view, i2);
            return baseViewHolder;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.blued.android.framework.view.shape.ShapeHelper.ShapeView");
    }
}
