package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.view.CircleImageView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyEntranceEffectBinding.class */
public final class ItemYyEntranceEffectBinding implements ViewBinding {
    public final RelativeLayout a;
    public final ImageView b;
    public final CircleImageView c;
    public final ImageView d;
    public final LinearLayout e;
    public final ShapeFrameLayout f;
    public final TextView g;
    public final TextView h;
    private final LinearLayout i;

    private ItemYyEntranceEffectBinding(LinearLayout linearLayout, RelativeLayout relativeLayout, ImageView imageView, CircleImageView circleImageView, ImageView imageView2, LinearLayout linearLayout2, ShapeFrameLayout shapeFrameLayout, TextView textView, TextView textView2) {
        this.i = linearLayout;
        this.a = relativeLayout;
        this.b = imageView;
        this.c = circleImageView;
        this.d = imageView2;
        this.e = linearLayout2;
        this.f = shapeFrameLayout;
        this.g = textView;
        this.h = textView2;
    }

    public static ItemYyEntranceEffectBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_yy_entrance_effect, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ItemYyEntranceEffectBinding a(View view) {
        String str;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.fl_main);
        if (relativeLayout != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_m);
            if (imageView != null) {
                CircleImageView circleImageView = (CircleImageView) view.findViewById(R.id.iv_us_head);
                if (circleImageView != null) {
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_user_ani);
                    if (imageView2 != null) {
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_mess);
                        if (linearLayout != null) {
                            ShapeFrameLayout shapeFrameLayout = (ShapeFrameLayout) view.findViewById(R.id.shafl_main);
                            if (shapeFrameLayout != null) {
                                TextView textView = (TextView) view.findViewById(R.id.tv_add_us_type);
                                if (textView != null) {
                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_us_name);
                                    if (textView2 != null) {
                                        return new ItemYyEntranceEffectBinding((LinearLayout) view, relativeLayout, imageView, circleImageView, imageView2, linearLayout, shapeFrameLayout, textView, textView2);
                                    }
                                    str = "tvUsName";
                                } else {
                                    str = "tvAddUsType";
                                }
                            } else {
                                str = "shaflMain";
                            }
                        } else {
                            str = "llMess";
                        }
                    } else {
                        str = "ivUserAni";
                    }
                } else {
                    str = "ivUsHead";
                }
            } else {
                str = "ivM";
            }
        } else {
            str = "flMain";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.i;
    }
}
