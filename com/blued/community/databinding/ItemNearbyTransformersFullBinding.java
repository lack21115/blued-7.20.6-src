package com.blued.community.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.community.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/databinding/ItemNearbyTransformersFullBinding.class */
public final class ItemNearbyTransformersFullBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f19009a;
    public final ConstraintLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final ShapeTextView f19010c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    private final ConstraintLayout g;

    private ItemNearbyTransformersFullBinding(ConstraintLayout constraintLayout, ImageView imageView, ConstraintLayout constraintLayout2, ShapeTextView shapeTextView, TextView textView, TextView textView2, TextView textView3) {
        this.g = constraintLayout;
        this.f19009a = imageView;
        this.b = constraintLayout2;
        this.f19010c = shapeTextView;
        this.d = textView;
        this.e = textView2;
        this.f = textView3;
    }

    public static ItemNearbyTransformersFullBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static ItemNearbyTransformersFullBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_nearby_transformers_full, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ItemNearbyTransformersFullBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_header);
        if (imageView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.root_layout);
            if (constraintLayout != null) {
                ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_btn);
                if (shapeTextView != null) {
                    TextView textView = (TextView) view.findViewById(R.id.tv_date);
                    if (textView != null) {
                        TextView textView2 = (TextView) view.findViewById(R.id.tv_desc);
                        if (textView2 != null) {
                            TextView textView3 = (TextView) view.findViewById(R.id.tv_title);
                            if (textView3 != null) {
                                return new ItemNearbyTransformersFullBinding((ConstraintLayout) view, imageView, constraintLayout, shapeTextView, textView, textView2, textView3);
                            }
                            str = "tvTitle";
                        } else {
                            str = "tvDesc";
                        }
                    } else {
                        str = "tvDate";
                    }
                } else {
                    str = "tvBtn";
                }
            } else {
                str = "rootLayout";
            }
        } else {
            str = "ivHeader";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.g;
    }
}
