package com.soft.blued.ui.msg.adapter;

import android.view.ViewGroup;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.extensions.BluedViewExtKt;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/adapter/MsgMenuPopAdapter.class */
public final class MsgMenuPopAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgMenuPopAdapter(List<String> list) {
        super(R.layout.item_msg_menu_pop, list);
        Intrinsics.e(list, "data");
    }

    private final void a(ShapeTextView shapeTextView) {
        ShapeHelper.ShapeView shapeView = (ShapeHelper.ShapeView) shapeTextView;
        ShapeHelper.a(shapeView, 0.0f, 0.0f, 0.0f, 0.0f);
        ShapeHelper.b(shapeView, 2131101827);
    }

    private final void b(ShapeTextView shapeTextView) {
        ShapeHelper.ShapeView shapeView = (ShapeHelper.ShapeView) shapeTextView;
        ShapeHelper.a(shapeView, 0.0f, BluedViewExtKt.a(3.0f), 0.0f, BluedViewExtKt.a(3.0f));
        ShapeHelper.b(shapeView, 2131101827);
    }

    private final void c(ShapeTextView shapeTextView) {
        ShapeHelper.ShapeView shapeView = (ShapeHelper.ShapeView) shapeTextView;
        ShapeHelper.a(shapeView, BluedViewExtKt.a(3.0f), 0.0f, BluedViewExtKt.a(3.0f), 0.0f);
        ShapeHelper.b(shapeView, 2131101827);
    }

    private final void d(ShapeTextView shapeTextView) {
        ShapeHelper.ShapeView shapeView = (ShapeHelper.ShapeView) shapeTextView;
        ShapeHelper.a(shapeView, BluedViewExtKt.a(3.0f));
        ShapeHelper.b(shapeView, 2131101827);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, String str) {
        Intrinsics.e(baseViewHolder, "helper");
        Intrinsics.e(str, "item");
        ShapeTextView shapeTextView = (ShapeTextView) baseViewHolder.getView(R.id.tv_btn);
        shapeTextView.setText(str);
        if (getData().size() == 1) {
            Intrinsics.c(shapeTextView, "tv");
            d(shapeTextView);
        } else {
            int adapterPosition = baseViewHolder.getAdapterPosition();
            if (adapterPosition == 0) {
                Intrinsics.c(shapeTextView, "tv");
                c(shapeTextView);
            } else if (adapterPosition == getData().size() - 1) {
                Intrinsics.c(shapeTextView, "tv");
                b(shapeTextView);
            } else {
                a(shapeTextView);
            }
        }
        ViewGroup.LayoutParams layoutParams = shapeTextView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (baseViewHolder.getAdapterPosition() == getData().size() - 1) {
            marginLayoutParams.rightMargin = 0;
        } else {
            marginLayoutParams.rightMargin = BluedViewExtKt.a(1);
        }
        shapeTextView.setLayoutParams(marginLayoutParams);
    }
}
