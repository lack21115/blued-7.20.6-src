package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogRelationListBinding.class */
public final class DialogRelationListBinding implements ViewBinding {
    public final ImageView a;
    public final RecyclerView b;
    private final LinearLayout c;

    private DialogRelationListBinding(LinearLayout linearLayout, ImageView imageView, RecyclerView recyclerView) {
        this.c = linearLayout;
        this.a = imageView;
        this.b = recyclerView;
    }

    public static DialogRelationListBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_relation_list, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogRelationListBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_back);
        if (imageView != null) {
            RecyclerView findViewById = view.findViewById(R.id.rcv_aution);
            if (findViewById != null) {
                return new DialogRelationListBinding((LinearLayout) view, imageView, findViewById);
            }
            str = "rcvAution";
        } else {
            str = "ivBack";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.c;
    }
}
