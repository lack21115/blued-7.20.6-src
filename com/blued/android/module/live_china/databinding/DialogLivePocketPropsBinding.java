package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/DialogLivePocketPropsBinding.class */
public final class DialogLivePocketPropsBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f11805a;
    public final LinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f11806c;
    public final ShapeTextView d;
    private final FrameLayout e;

    private DialogLivePocketPropsBinding(FrameLayout frameLayout, LinearLayout linearLayout, LinearLayout linearLayout2, RecyclerView recyclerView, ShapeTextView shapeTextView) {
        this.e = frameLayout;
        this.f11805a = linearLayout;
        this.b = linearLayout2;
        this.f11806c = recyclerView;
        this.d = shapeTextView;
    }

    public static DialogLivePocketPropsBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_live_pocket_props, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogLivePocketPropsBinding a(View view) {
        String str;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_default);
        if (linearLayout != null) {
            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_main);
            if (linearLayout2 != null) {
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_list);
                if (recyclerView != null) {
                    ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_use);
                    if (shapeTextView != null) {
                        return new DialogLivePocketPropsBinding((FrameLayout) view, linearLayout, linearLayout2, recyclerView, shapeTextView);
                    }
                    str = "tvUse";
                } else {
                    str = "rvList";
                }
            } else {
                str = "llMain";
            }
        } else {
            str = "llDefault";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.e;
    }
}
