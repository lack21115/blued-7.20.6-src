package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyRoomBannerBinding.class */
public final class ItemYyRoomBannerBinding implements ViewBinding {
    public final ImageView a;
    public final ImageView b;
    public final LinearLayout c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    private final ConstraintLayout h;

    private ItemYyRoomBannerBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.h = constraintLayout;
        this.a = imageView;
        this.b = imageView2;
        this.c = linearLayout;
        this.d = textView;
        this.e = textView2;
        this.f = textView3;
        this.g = textView4;
    }

    public static ItemYyRoomBannerBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_bg);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_bg_2);
            if (imageView2 != null) {
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll);
                if (linearLayout != null) {
                    TextView textView = (TextView) view.findViewById(R.id.tv_con_num_2_cont);
                    if (textView != null) {
                        TextView textView2 = (TextView) view.findViewById(R.id.tv_con_num_2_title);
                        if (textView2 != null) {
                            TextView textView3 = (TextView) view.findViewById(R.id.tv_con_num_cont);
                            if (textView3 != null) {
                                TextView textView4 = (TextView) view.findViewById(R.id.tv_con_num_title);
                                if (textView4 != null) {
                                    return new ItemYyRoomBannerBinding((ConstraintLayout) view, imageView, imageView2, linearLayout, textView, textView2, textView3, textView4);
                                }
                                str = "tvConNumTitle";
                            } else {
                                str = "tvConNumCont";
                            }
                        } else {
                            str = "tvConNum2Title";
                        }
                    } else {
                        str = "tvConNum2Cont";
                    }
                } else {
                    str = "ll";
                }
            } else {
                str = "ivBg2";
            }
        } else {
            str = "ivBg";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.h;
    }
}
