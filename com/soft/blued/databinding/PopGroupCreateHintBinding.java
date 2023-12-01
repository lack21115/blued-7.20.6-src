package com.soft.blued.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/PopGroupCreateHintBinding.class */
public final class PopGroupCreateHintBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final View f15835a;
    public final View b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f15836c;
    public final LinearLayout d;
    public final LinearLayout e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    private final ConstraintLayout j;

    private PopGroupCreateHintBinding(ConstraintLayout constraintLayout, View view, View view2, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.j = constraintLayout;
        this.f15835a = view;
        this.b = view2;
        this.f15836c = linearLayout;
        this.d = linearLayout2;
        this.e = linearLayout3;
        this.f = textView;
        this.g = textView2;
        this.h = textView3;
        this.i = textView4;
    }

    public static PopGroupCreateHintBinding a(View view) {
        String str;
        View findViewById = view.findViewById(2131366864);
        if (findViewById != null) {
            View findViewById2 = view.findViewById(2131366876);
            if (findViewById2 != null) {
                LinearLayout linearLayout = (LinearLayout) view.findViewById(2131367679);
                if (linearLayout != null) {
                    LinearLayout linearLayout2 = (LinearLayout) view.findViewById(2131367715);
                    if (linearLayout2 != null) {
                        LinearLayout linearLayout3 = (LinearLayout) view.findViewById(2131367744);
                        if (linearLayout3 != null) {
                            TextView textView = (TextView) view.findViewById(2131371186);
                            if (textView != null) {
                                TextView textView2 = (TextView) view.findViewById(2131372072);
                                if (textView2 != null) {
                                    TextView textView3 = (TextView) view.findViewById(2131372273);
                                    if (textView3 != null) {
                                        TextView textView4 = (TextView) view.findViewById(2131372754);
                                        if (textView4 != null) {
                                            return new PopGroupCreateHintBinding((ConstraintLayout) view, findViewById, findViewById2, linearLayout, linearLayout2, linearLayout3, textView, textView2, textView3, textView4);
                                        }
                                        str = "tvTitle";
                                    } else {
                                        str = "tvPositiveOrdinary";
                                    }
                                } else {
                                    str = "tvNegativeOrdinary";
                                }
                            } else {
                                str = "tvContent";
                            }
                        } else {
                            str = "llDialog";
                        }
                    } else {
                        str = "llContent";
                    }
                } else {
                    str = "llButtonOrdinary";
                }
            } else {
                str = "lineTopView";
            }
        } else {
            str = "lineCenterView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.j;
    }
}
