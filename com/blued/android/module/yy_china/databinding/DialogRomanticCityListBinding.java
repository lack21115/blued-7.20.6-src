package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogRomanticCityListBinding.class */
public final class DialogRomanticCityListBinding implements ViewBinding {
    public final ImageView a;
    public final RecyclerView b;
    public final TextView c;
    public final TextView d;
    private final ConstraintLayout e;

    private DialogRomanticCityListBinding(ConstraintLayout constraintLayout, ImageView imageView, RecyclerView recyclerView, TextView textView, TextView textView2) {
        this.e = constraintLayout;
        this.a = imageView;
        this.b = recyclerView;
        this.c = textView;
        this.d = textView2;
    }

    public static DialogRomanticCityListBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.img_empty_view);
        if (imageView != null) {
            RecyclerView findViewById = view.findViewById(R.id.rv_city_list);
            if (findViewById != null) {
                TextView textView = (TextView) view.findViewById(R.id.tv_empty_text);
                if (textView != null) {
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_notice);
                    if (textView2 != null) {
                        return new DialogRomanticCityListBinding((ConstraintLayout) view, imageView, findViewById, textView, textView2);
                    }
                    str = "tvNotice";
                } else {
                    str = "tvEmptyText";
                }
            } else {
                str = "rvCityList";
            }
        } else {
            str = "imgEmptyView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.e;
    }
}
