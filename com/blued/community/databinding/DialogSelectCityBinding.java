package com.blued.community.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.FastIndexView;
import com.blued.community.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/databinding/DialogSelectCityBinding.class */
public final class DialogSelectCityBinding implements ViewBinding {
    public final FastIndexView a;
    public final ImageView b;
    public final ShapeLinearLayout c;
    public final RecyclerView d;
    public final ConstraintLayout e;
    public final ShapeTextView f;
    private final ConstraintLayout g;

    private DialogSelectCityBinding(ConstraintLayout constraintLayout, FastIndexView fastIndexView, ImageView imageView, ShapeLinearLayout shapeLinearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout2, ShapeTextView shapeTextView) {
        this.g = constraintLayout;
        this.a = fastIndexView;
        this.b = imageView;
        this.c = shapeLinearLayout;
        this.d = recyclerView;
        this.e = constraintLayout2;
        this.f = shapeTextView;
    }

    public static DialogSelectCityBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static DialogSelectCityBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_select_city, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogSelectCityBinding a(View view) {
        String str;
        FastIndexView fastIndexView = (FastIndexView) view.findViewById(R.id.fast_index_view);
        if (fastIndexView != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.ivClose);
            if (imageView != null) {
                ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(R.id.layout_event_type);
                if (shapeLinearLayout != null) {
                    RecyclerView findViewById = view.findViewById(R.id.recycler_view);
                    if (findViewById != null) {
                        ConstraintLayout findViewById2 = view.findViewById(R.id.rootLayout);
                        if (findViewById2 != null) {
                            ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_index);
                            if (shapeTextView != null) {
                                return new DialogSelectCityBinding((ConstraintLayout) view, fastIndexView, imageView, shapeLinearLayout, findViewById, findViewById2, shapeTextView);
                            }
                            str = "tvIndex";
                        } else {
                            str = "rootLayout";
                        }
                    } else {
                        str = "recyclerView";
                    }
                } else {
                    str = "layoutEventType";
                }
            } else {
                str = "ivClose";
            }
        } else {
            str = "fastIndexView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.g;
    }
}
