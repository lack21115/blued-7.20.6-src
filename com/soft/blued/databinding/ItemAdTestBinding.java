package com.soft.blued.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/ItemAdTestBinding.class */
public final class ItemAdTestBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f29071a;
    public final TextView b;

    /* renamed from: c  reason: collision with root package name */
    private final LinearLayout f29072c;

    private ItemAdTestBinding(LinearLayout linearLayout, TextView textView, TextView textView2) {
        this.f29072c = linearLayout;
        this.f29071a = textView;
        this.b = textView2;
    }

    public static ItemAdTestBinding a(View view) {
        String str;
        TextView textView = (TextView) view.findViewById(R.id.btn_delete);
        if (textView != null) {
            TextView textView2 = (TextView) view.findViewById(2131371943);
            if (textView2 != null) {
                return new ItemAdTestBinding((LinearLayout) view, textView, textView2);
            }
            str = "tvMess";
        } else {
            str = "btnDelete";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.f29072c;
    }
}
