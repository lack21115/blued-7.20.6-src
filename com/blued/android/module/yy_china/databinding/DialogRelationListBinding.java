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

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f16386a;
    public final RecyclerView b;

    /* renamed from: c  reason: collision with root package name */
    private final LinearLayout f16387c;

    private DialogRelationListBinding(LinearLayout linearLayout, ImageView imageView, RecyclerView recyclerView) {
        this.f16387c = linearLayout;
        this.f16386a = imageView;
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
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rcv_aution);
            if (recyclerView != null) {
                return new DialogRelationListBinding((LinearLayout) view, imageView, recyclerView);
            }
            str = "rcvAution";
        } else {
            str = "ivBack";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.f16387c;
    }
}
