package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogYyCloseMenuBinding.class */
public final class DialogYyCloseMenuBinding implements ViewBinding {
    public final View a;
    public final LinearLayout b;
    public final ConstraintLayout c;
    public final LinearLayout d;
    public final TextView e;
    private final ConstraintLayout f;

    private DialogYyCloseMenuBinding(ConstraintLayout constraintLayout, View view, LinearLayout linearLayout, ConstraintLayout constraintLayout2, LinearLayout linearLayout2, TextView textView) {
        this.f = constraintLayout;
        this.a = view;
        this.b = linearLayout;
        this.c = constraintLayout2;
        this.d = linearLayout2;
        this.e = textView;
    }

    public static DialogYyCloseMenuBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_yy_close_menu, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogYyCloseMenuBinding a(View view) {
        String str;
        View findViewById = view.findViewById(R.id.iv_close);
        if (findViewById != null) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_fold_room);
            if (linearLayout != null) {
                ConstraintLayout findViewById2 = view.findViewById(R.id.ll_menu);
                if (findViewById2 != null) {
                    LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_shutdown);
                    if (linearLayout2 != null) {
                        TextView textView = (TextView) view.findViewById(R.id.tv_shutdown_name);
                        if (textView != null) {
                            return new DialogYyCloseMenuBinding((ConstraintLayout) view, findViewById, linearLayout, findViewById2, linearLayout2, textView);
                        }
                        str = "tvShutdownName";
                    } else {
                        str = "llShutdown";
                    }
                } else {
                    str = "llMenu";
                }
            } else {
                str = "llFoldRoom";
            }
        } else {
            str = "ivClose";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f;
    }
}
