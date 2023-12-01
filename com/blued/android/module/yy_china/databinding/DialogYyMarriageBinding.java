package com.blued.android.module.yy_china.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogYyMarriageBinding.class */
public final class DialogYyMarriageBinding implements ViewBinding {
    public final View a;
    public final SVGAImageView b;
    public final SVGAImageView c;
    public final ConstraintLayout d;
    private final ConstraintLayout e;

    private DialogYyMarriageBinding(ConstraintLayout constraintLayout, View view, SVGAImageView sVGAImageView, SVGAImageView sVGAImageView2, ConstraintLayout constraintLayout2) {
        this.e = constraintLayout;
        this.a = view;
        this.b = sVGAImageView;
        this.c = sVGAImageView2;
        this.d = constraintLayout2;
    }

    public static DialogYyMarriageBinding a(View view) {
        String str;
        View findViewById = view.findViewById(R.id.cover_view);
        if (findViewById != null) {
            SVGAImageView sVGAImageView = (SVGAImageView) view.findViewById(R.id.img_background);
            if (sVGAImageView != null) {
                SVGAImageView sVGAImageView2 = (SVGAImageView) view.findViewById(R.id.img_cheerful_view);
                if (sVGAImageView2 != null) {
                    ConstraintLayout findViewById2 = view.findViewById(R.id.root_view);
                    if (findViewById2 != null) {
                        return new DialogYyMarriageBinding((ConstraintLayout) view, findViewById, sVGAImageView, sVGAImageView2, findViewById2);
                    }
                    str = "rootView";
                } else {
                    str = "imgCheerfulView";
                }
            } else {
                str = "imgBackground";
            }
        } else {
            str = "coverView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.e;
    }
}
