package com.soft.blued.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/PopMsgItemMenuBinding.class */
public final class PopMsgItemMenuBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeFrameLayout f15853a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f15854c;
    private final LinearLayout d;

    private PopMsgItemMenuBinding(LinearLayout linearLayout, ShapeFrameLayout shapeFrameLayout, ImageView imageView, RecyclerView recyclerView) {
        this.d = linearLayout;
        this.f15853a = shapeFrameLayout;
        this.b = imageView;
        this.f15854c = recyclerView;
    }

    public static PopMsgItemMenuBinding a(View view) {
        String str;
        ShapeFrameLayout findViewById = view.findViewById(R.id.cv_root);
        if (findViewById != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_arrow);
            if (imageView != null) {
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.menu_list);
                if (recyclerView != null) {
                    return new PopMsgItemMenuBinding((LinearLayout) view, findViewById, imageView, recyclerView);
                }
                str = "menuList";
            } else {
                str = "ivArrow";
            }
        } else {
            str = "cvRoot";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.d;
    }
}
