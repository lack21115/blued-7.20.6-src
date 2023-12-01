package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewYyMoreMenuLayoutBinding.class */
public final class ViewYyMoreMenuLayoutBinding implements ViewBinding {
    public final ImageView a;
    public final LinearLayout b;
    public final LinearLayout c;
    public final RecyclerView d;
    public final TextView e;
    public final TextView f;
    private final LinearLayout g;

    private ViewYyMoreMenuLayoutBinding(LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, LinearLayout linearLayout3, RecyclerView recyclerView, TextView textView, TextView textView2) {
        this.g = linearLayout;
        this.a = imageView;
        this.b = linearLayout2;
        this.c = linearLayout3;
        this.d = recyclerView;
        this.e = textView;
        this.f = textView2;
    }

    public static ViewYyMoreMenuLayoutBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_yy_more_menu_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ViewYyMoreMenuLayoutBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_clos);
        if (imageView != null) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_fold_room);
            if (linearLayout != null) {
                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_shutdown);
                if (linearLayout2 != null) {
                    RecyclerView findViewById = view.findViewById(R.id.rcv);
                    if (findViewById != null) {
                        TextView textView = (TextView) view.findViewById(R.id.tv_shutdown_name);
                        if (textView != null) {
                            TextView textView2 = (TextView) view.findViewById(R.id.tv_title);
                            if (textView2 != null) {
                                return new ViewYyMoreMenuLayoutBinding((LinearLayout) view, imageView, linearLayout, linearLayout2, findViewById, textView, textView2);
                            }
                            str = "tvTitle";
                        } else {
                            str = "tvShutdownName";
                        }
                    } else {
                        str = "rcv";
                    }
                } else {
                    str = "llShutdown";
                }
            } else {
                str = "llFoldRoom";
            }
        } else {
            str = "ivClos";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.g;
    }
}
