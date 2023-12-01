package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemGiftwallInfoAboutTitleBinding.class */
public final class ItemGiftwallInfoAboutTitleBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f16609a;
    public final TextView b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f16610c;
    public final TextView d;
    private final ConstraintLayout e;

    private ItemGiftwallInfoAboutTitleBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.e = constraintLayout;
        this.f16609a = textView;
        this.b = textView2;
        this.f16610c = textView3;
        this.d = textView4;
    }

    public static ItemGiftwallInfoAboutTitleBinding a(View view) {
        String str;
        TextView textView = (TextView) view.findViewById(R.id.tv_totop);
        if (textView != null) {
            TextView textView2 = (TextView) view.findViewById(R.id.tv_type_is);
            if (textView2 != null) {
                TextView textView3 = (TextView) view.findViewById(R.id.tv_type_name);
                if (textView3 != null) {
                    TextView textView4 = (TextView) view.findViewById(R.id.tv_type_num);
                    if (textView4 != null) {
                        return new ItemGiftwallInfoAboutTitleBinding((ConstraintLayout) view, textView, textView2, textView3, textView4);
                    }
                    str = "tvTypeNum";
                } else {
                    str = "tvTypeName";
                }
            } else {
                str = "tvTypeIs";
            }
        } else {
            str = "tvTotop";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.e;
    }
}
