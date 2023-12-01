package com.soft.blued.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeRelativeLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/PopGroupHelpCreateBinding.class */
public final class PopGroupHelpCreateBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f15837a;
    public final TextView b;

    /* renamed from: c  reason: collision with root package name */
    public final ShapeTextView f15838c;
    public final ShapeTextView d;
    public final RecyclerView e;
    private final ShapeRelativeLayout f;

    private PopGroupHelpCreateBinding(ShapeRelativeLayout shapeRelativeLayout, ImageView imageView, TextView textView, ShapeTextView shapeTextView, ShapeTextView shapeTextView2, RecyclerView recyclerView) {
        this.f = shapeRelativeLayout;
        this.f15837a = imageView;
        this.b = textView;
        this.f15838c = shapeTextView;
        this.d = shapeTextView2;
        this.e = recyclerView;
    }

    public static PopGroupHelpCreateBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(2131365207);
        if (imageView != null) {
            TextView textView = (TextView) view.findViewById(R.id.tv_help_progress);
            if (textView != null) {
                ShapeTextView findViewById = view.findViewById(R.id.tv_invite);
                if (findViewById != null) {
                    ShapeTextView findViewById2 = view.findViewById(R.id.tv_vip);
                    if (findViewById2 != null) {
                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.user_list);
                        if (recyclerView != null) {
                            return new PopGroupHelpCreateBinding((ShapeRelativeLayout) view, imageView, textView, findViewById, findViewById2, recyclerView);
                        }
                        str = "userList";
                    } else {
                        str = "tvVip";
                    }
                } else {
                    str = "tvInvite";
                }
            } else {
                str = "tvHelpProgress";
            }
        } else {
            str = "ivClose";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ShapeRelativeLayout getRoot() {
        return this.f;
    }
}
