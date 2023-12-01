package com.soft.blued.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/ItemMineNewHealthEntryBinding.class */
public final class ItemMineNewHealthEntryBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f15543a;
    public final LinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f15544c;
    public final TextView d;
    private final ConstraintLayout e;

    private ItemMineNewHealthEntryBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2) {
        this.e = constraintLayout;
        this.f15543a = linearLayout;
        this.b = linearLayout2;
        this.f15544c = textView;
        this.d = textView2;
    }

    public static ItemMineNewHealthEntryBinding a(View view) {
        String str;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_health_title);
        if (linearLayout != null) {
            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_item_health);
            if (linearLayout2 != null) {
                TextView textView = (TextView) view.findViewById(R.id.tv_divider);
                if (textView != null) {
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_health_title);
                    if (textView2 != null) {
                        return new ItemMineNewHealthEntryBinding((ConstraintLayout) view, linearLayout, linearLayout2, textView, textView2);
                    }
                    str = "tvHealthTitle";
                } else {
                    str = "tvDivider";
                }
            } else {
                str = "llItemHealth";
            }
        } else {
            str = "llHealthTitle";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.e;
    }
}
