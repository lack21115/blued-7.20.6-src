package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogSaleBroadcastLayoutBinding.class */
public final class DialogSaleBroadcastLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f16406a;
    private final LinearLayout b;

    private DialogSaleBroadcastLayoutBinding(LinearLayout linearLayout, TextView textView) {
        this.b = linearLayout;
        this.f16406a = textView;
    }

    public static DialogSaleBroadcastLayoutBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_sale_broadcast_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogSaleBroadcastLayoutBinding a(View view) {
        TextView textView = (TextView) view.findViewById(R.id.tv_content);
        if (textView != null) {
            return new DialogSaleBroadcastLayoutBinding((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat("tvContent"));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.b;
    }
}
