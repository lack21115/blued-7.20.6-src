package com.blued.community.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.community.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/databinding/ItemNearbyTransformersQuarterBinding.class */
public final class ItemNearbyTransformersQuarterBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final TextView b;
    private final ConstraintLayout c;

    private ItemNearbyTransformersQuarterBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView) {
        this.c = constraintLayout;
        this.a = constraintLayout2;
        this.b = textView;
    }

    public static ItemNearbyTransformersQuarterBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static ItemNearbyTransformersQuarterBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_nearby_transformers_quarter, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ItemNearbyTransformersQuarterBinding a(View view) {
        String str;
        ConstraintLayout findViewById = view.findViewById(R.id.root_layout);
        if (findViewById != null) {
            TextView textView = (TextView) view.findViewById(R.id.tv_title);
            if (textView != null) {
                return new ItemNearbyTransformersQuarterBinding((ConstraintLayout) view, findViewById, textView);
            }
            str = "tvTitle";
        } else {
            str = "rootLayout";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.c;
    }
}
