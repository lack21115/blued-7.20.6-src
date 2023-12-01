package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/DialogLivePocketRecordBinding.class */
public final class DialogLivePocketRecordBinding implements ViewBinding {
    public final ImageView a;
    public final ListView b;
    public final LinearLayout c;
    public final LinearLayout d;
    public final SmartRefreshLayout e;
    public final TextView f;
    public final TextView g;
    public final View h;
    private final FrameLayout i;

    private DialogLivePocketRecordBinding(FrameLayout frameLayout, ImageView imageView, ListView listView, LinearLayout linearLayout, LinearLayout linearLayout2, SmartRefreshLayout smartRefreshLayout, TextView textView, TextView textView2, View view) {
        this.i = frameLayout;
        this.a = imageView;
        this.b = listView;
        this.c = linearLayout;
        this.d = linearLayout2;
        this.e = smartRefreshLayout;
        this.f = textView;
        this.g = textView2;
        this.h = view;
    }

    public static DialogLivePocketRecordBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static DialogLivePocketRecordBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_live_pocket_record, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogLivePocketRecordBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_back);
        if (imageView != null) {
            ListView listView = (ListView) view.findViewById(R.id.listview);
            if (listView != null) {
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_default);
                if (linearLayout != null) {
                    LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_dialog_root);
                    if (linearLayout2 != null) {
                        SmartRefreshLayout findViewById = view.findViewById(R.id.refresh_layout);
                        if (findViewById != null) {
                            TextView textView = (TextView) view.findViewById(R.id.tv_name);
                            if (textView != null) {
                                TextView textView2 = (TextView) view.findViewById(R.id.tv_tip);
                                if (textView2 != null) {
                                    View findViewById2 = view.findViewById(R.id.view_bg_top);
                                    if (findViewById2 != null) {
                                        return new DialogLivePocketRecordBinding((FrameLayout) view, imageView, listView, linearLayout, linearLayout2, findViewById, textView, textView2, findViewById2);
                                    }
                                    str = "viewBgTop";
                                } else {
                                    str = "tvTip";
                                }
                            } else {
                                str = "tvName";
                            }
                        } else {
                            str = "refreshLayout";
                        }
                    } else {
                        str = "llDialogRoot";
                    }
                } else {
                    str = "llDefault";
                }
            } else {
                str = "listview";
            }
        } else {
            str = "ivBack";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.i;
    }
}
