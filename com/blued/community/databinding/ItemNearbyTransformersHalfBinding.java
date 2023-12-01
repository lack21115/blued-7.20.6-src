package com.blued.community.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.community.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/databinding/ItemNearbyTransformersHalfBinding.class */
public final class ItemNearbyTransformersHalfBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f19011a;
    public final ConstraintLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f19012c;
    public final TextView d;
    public final TextView e;
    private final ConstraintLayout f;

    private ItemNearbyTransformersHalfBinding(ConstraintLayout constraintLayout, ImageView imageView, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, TextView textView3) {
        this.f = constraintLayout;
        this.f19011a = imageView;
        this.b = constraintLayout2;
        this.f19012c = textView;
        this.d = textView2;
        this.e = textView3;
    }

    public static ItemNearbyTransformersHalfBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static ItemNearbyTransformersHalfBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_nearby_transformers_half, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ItemNearbyTransformersHalfBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_header);
        if (imageView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.root_layout);
            if (constraintLayout != null) {
                TextView textView = (TextView) view.findViewById(R.id.tv_date);
                if (textView != null) {
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_desc);
                    if (textView2 != null) {
                        TextView textView3 = (TextView) view.findViewById(R.id.tv_title);
                        if (textView3 != null) {
                            return new ItemNearbyTransformersHalfBinding((ConstraintLayout) view, imageView, constraintLayout, textView, textView2, textView3);
                        }
                        str = "tvTitle";
                    } else {
                        str = "tvDesc";
                    }
                } else {
                    str = "tvDate";
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
        return this.f;
    }
}
