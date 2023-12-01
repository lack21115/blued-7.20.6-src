package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;
import com.google.android.material.imageview.ShapeableImageView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogMedalListsBinding.class */
public final class DialogMedalListsBinding implements ViewBinding {
    public final FrameLayout a;
    public final ImageView b;
    public final ShapeableImageView c;
    public final RecyclerView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    private final FrameLayout i;

    private DialogMedalListsBinding(FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView, ShapeableImageView shapeableImageView, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.i = frameLayout;
        this.a = frameLayout2;
        this.b = imageView;
        this.c = shapeableImageView;
        this.d = recyclerView;
        this.e = textView;
        this.f = textView2;
        this.g = textView3;
        this.h = textView4;
    }

    public static DialogMedalListsBinding a(View view) {
        String str;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.con);
        if (frameLayout != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_back);
            if (imageView != null) {
                ShapeableImageView findViewById = view.findViewById(R.id.iv_user);
                if (findViewById != null) {
                    RecyclerView findViewById2 = view.findViewById(R.id.rcv);
                    if (findViewById2 != null) {
                        TextView textView = (TextView) view.findViewById(R.id.tv_medal_num);
                        if (textView != null) {
                            TextView textView2 = (TextView) view.findViewById(R.id.tv_mess);
                            if (textView2 != null) {
                                TextView textView3 = (TextView) view.findViewById(R.id.tv_name);
                                if (textView3 != null) {
                                    TextView textView4 = (TextView) view.findViewById(R.id.tv_title);
                                    if (textView4 != null) {
                                        return new DialogMedalListsBinding((FrameLayout) view, frameLayout, imageView, findViewById, findViewById2, textView, textView2, textView3, textView4);
                                    }
                                    str = "tvTitle";
                                } else {
                                    str = "tvName";
                                }
                            } else {
                                str = "tvMess";
                            }
                        } else {
                            str = "tvMedalNum";
                        }
                    } else {
                        str = "rcv";
                    }
                } else {
                    str = "ivUser";
                }
            } else {
                str = "ivBack";
            }
        } else {
            str = "con";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.i;
    }
}
