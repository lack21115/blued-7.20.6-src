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
    public MsgMenuPopAdapter(List<String> data) {
        super(R.layout.item_msg_menu_pop, data);
        Intrinsics.e(data, "data");
    }

    private final void a(ShapeTextView shapeTextView) {
        ShapeTextView shapeTextView2 = shapeTextView;
        ShapeHelper.a(shapeTextView2, 0.0f, 0.0f, 0.0f, 0.0f);
        ShapeHelper.b(shapeTextView2, 2131101827);
    }

    private final void b(ShapeTextView shapeTextView) {
        ShapeTextView shapeTextView2 = shapeTextView;
        ShapeHelper.a(shapeTextView2, 0.0f, BluedViewExtKt.a(3.0f), 0.0f, BluedViewExtKt.a(3.0f));
        ShapeHelper.b(shapeTextView2, 2131101827);
    }

    private final void c(ShapeTextView shapeTextView) {
        ShapeTextView shapeTextView2 = shapeTextView;
        ShapeHelper.a(shapeTextView2, BluedViewExtKt.a(3.0f), 0.0f, BluedViewExtKt.a(3.0f), 0.0f);
        ShapeHelper.b(shapeTextView2, 2131101827);
    }

    private final void d(ShapeTextView shapeTextView) {
        ShapeTextView shapeTextView2 = shapeTextView;
        ShapeHelper.a(shapeTextView2, BluedViewExtKt.a(3.0f));
        ShapeHelper.b(shapeTextView2, 2131101827);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder helper, String item) {
        Intrinsics.e(helper, "helper");
        Intrinsics.e(item, "item");
        ShapeTextView tv = (ShapeTextView) helper.getView(2131371023);
        tv.setText(item);
        if (getData().size() == 1) {
            Intrinsics.c(tv, "tv");
            d(tv);
        } else {
            int adapterPosition = helper.getAdapterPosition();
            if (adapterPosition == 0) {
                Intrinsics.c(tv, "tv");
                c(tv);
            } else if (adapterPosition == getData().size() - 1) {
                Intrinsics.c(tv, "tv");
                b(tv);
            } else {
                a(tv);
            }
        }
        ViewGroup.LayoutParams layoutParams = tv.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (helper.getAdapterPosition() == getData().size() - 1) {
            marginLayoutParams.rightMargin = 0;
        } else {
            marginLayoutParams.rightMargin = BluedViewExtKt.a(1);
        }
        tv.setLayoutParams(marginLayoutParams);
    }
}
