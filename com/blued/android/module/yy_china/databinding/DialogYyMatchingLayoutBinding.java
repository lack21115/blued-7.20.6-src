package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.HollowView;
import com.blued.android.module.yy_china.R;
import com.google.android.material.imageview.ShapeableImageView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogYyMatchingLayoutBinding.class */
public final class DialogYyMatchingLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f16436a;
    public final View b;

    /* renamed from: c  reason: collision with root package name */
    public final HollowView f16437c;
    public final HollowView d;
    public final ImageView e;
    public final ShapeableImageView f;
    public final ShapeableImageView g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    private final FrameLayout k;

    private DialogYyMatchingLayoutBinding(FrameLayout frameLayout, TextView textView, View view, HollowView hollowView, HollowView hollowView2, ImageView imageView, ShapeableImageView shapeableImageView, ShapeableImageView shapeableImageView2, TextView textView2, TextView textView3, TextView textView4) {
        this.k = frameLayout;
        this.f16436a = textView;
        this.b = view;
        this.f16437c = hollowView;
        this.d = hollowView2;
        this.e = imageView;
        this.f = shapeableImageView;
        this.g = shapeableImageView2;
        this.h = textView2;
        this.i = textView3;
        this.j = textView4;
    }

    public static DialogYyMatchingLayoutBinding a(View view) {
        String str;
        TextView textView = (TextView) view.findViewById(R.id.btn_cancel_pk);
        if (textView != null) {
            View findViewById = view.findViewById(R.id.conver_view);
            if (findViewById != null) {
                HollowView hollowView = (HollowView) view.findViewById(R.id.fl_left_bg);
                if (hollowView != null) {
                    HollowView hollowView2 = (HollowView) view.findViewById(R.id.fl_right_bg);
                    if (hollowView2 != null) {
                        ImageView imageView = (ImageView) view.findViewById(R.id.img_matching);
                        if (imageView != null) {
                            ShapeableImageView shapeableImageView = (ShapeableImageView) view.findViewById(R.id.pk_left);
                            if (shapeableImageView != null) {
                                ShapeableImageView shapeableImageView2 = (ShapeableImageView) view.findViewById(R.id.pk_right);
                                if (shapeableImageView2 != null) {
                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_match_title);
                                    if (textView2 != null) {
                                        TextView textView3 = (TextView) view.findViewById(R.id.tv_player_left);
                                        if (textView3 != null) {
                                            TextView textView4 = (TextView) view.findViewById(R.id.tv_player_right);
                                            if (textView4 != null) {
                                                return new DialogYyMatchingLayoutBinding((FrameLayout) view, textView, findViewById, hollowView, hollowView2, imageView, shapeableImageView, shapeableImageView2, textView2, textView3, textView4);
                                            }
                                            str = "tvPlayerRight";
                                        } else {
                                            str = "tvPlayerLeft";
                                        }
                                    } else {
                                        str = "tvMatchTitle";
                                    }
                                } else {
                                    str = "pkRight";
                                }
                            } else {
                                str = "pkLeft";
                            }
                        } else {
                            str = "imgMatching";
                        }
                    } else {
                        str = "flRightBg";
                    }
                } else {
                    str = "flLeftBg";
                }
            } else {
                str = "converView";
            }
        } else {
            str = "btnCancelPk";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.k;
    }
}
