package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LiveBattleBuyDialogBinding.class */
public final class LiveBattleBuyDialogBinding implements ViewBinding {
    public final ImageView a;
    public final ImageView b;
    public final FrameLayout c;
    public final RecyclerView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final ImageView h;
    private final FrameLayout i;

    private LiveBattleBuyDialogBinding(FrameLayout frameLayout, ImageView imageView, ImageView imageView2, FrameLayout frameLayout2, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, ImageView imageView3) {
        this.i = frameLayout;
        this.a = imageView;
        this.b = imageView2;
        this.c = frameLayout2;
        this.d = recyclerView;
        this.e = textView;
        this.f = textView2;
        this.g = textView3;
        this.h = imageView3;
    }

    public static LiveBattleBuyDialogBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.live_battle_buy_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static LiveBattleBuyDialogBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_cancel);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_unlock);
            if (imageView2 != null) {
                FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.root);
                if (frameLayout != null) {
                    RecyclerView findViewById = view.findViewById(R.id.rv_list);
                    if (findViewById != null) {
                        TextView textView = (TextView) view.findViewById(R.id.tv_content);
                        if (textView != null) {
                            TextView textView2 = (TextView) view.findViewById(R.id.tv_gift_title);
                            if (textView2 != null) {
                                TextView textView3 = (TextView) view.findViewById(R.id.tv_title);
                                if (textView3 != null) {
                                    ImageView imageView3 = (ImageView) view.findViewById(R.id.view_line);
                                    if (imageView3 != null) {
                                        return new LiveBattleBuyDialogBinding((FrameLayout) view, imageView, imageView2, frameLayout, findViewById, textView, textView2, textView3, imageView3);
                                    }
                                    str = "viewLine";
                                } else {
                                    str = "tvTitle";
                                }
                            } else {
                                str = "tvGiftTitle";
                            }
                        } else {
                            str = "tvContent";
                        }
                    } else {
                        str = "rvList";
                    }
                } else {
                    str = "root";
                }
            } else {
                str = "ivUnlock";
            }
        } else {
            str = "ivCancel";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.i;
    }
}
