package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemHomeRoomGuideBinding.class */
public final class ItemHomeRoomGuideBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final SquareImageView f16621a;
    public final SquareImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final SquareImageView f16622c;
    public final SquareImageView d;
    public final ImageView e;
    public final RelativeLayout f;
    public final ShapeFrameLayout g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    private final ConstraintLayout k;

    private ItemHomeRoomGuideBinding(ConstraintLayout constraintLayout, SquareImageView squareImageView, SquareImageView squareImageView2, SquareImageView squareImageView3, SquareImageView squareImageView4, ImageView imageView, RelativeLayout relativeLayout, ShapeFrameLayout shapeFrameLayout, TextView textView, TextView textView2, TextView textView3) {
        this.k = constraintLayout;
        this.f16621a = squareImageView;
        this.b = squareImageView2;
        this.f16622c = squareImageView3;
        this.d = squareImageView4;
        this.e = imageView;
        this.f = relativeLayout;
        this.g = shapeFrameLayout;
        this.h = textView;
        this.i = textView2;
        this.j = textView3;
    }

    public static ItemHomeRoomGuideBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_home_room_guide, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ItemHomeRoomGuideBinding a(View view) {
        String str;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.iv_1);
        if (squareImageView != null) {
            SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.iv_2);
            if (squareImageView2 != null) {
                SquareImageView squareImageView3 = (SquareImageView) view.findViewById(R.id.iv_3);
                if (squareImageView3 != null) {
                    SquareImageView squareImageView4 = (SquareImageView) view.findViewById(R.id.iv_more);
                    if (squareImageView4 != null) {
                        ImageView imageView = (ImageView) view.findViewById(R.id.iv_user);
                        if (imageView != null) {
                            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_more);
                            if (relativeLayout != null) {
                                ShapeFrameLayout shapeFrameLayout = (ShapeFrameLayout) view.findViewById(R.id.sha_user);
                                if (shapeFrameLayout != null) {
                                    TextView textView = (TextView) view.findViewById(R.id.tv_more_p);
                                    if (textView != null) {
                                        TextView textView2 = (TextView) view.findViewById(R.id.tv_name);
                                        if (textView2 != null) {
                                            TextView textView3 = (TextView) view.findViewById(R.id.tv_name_more);
                                            if (textView3 != null) {
                                                return new ItemHomeRoomGuideBinding((ConstraintLayout) view, squareImageView, squareImageView2, squareImageView3, squareImageView4, imageView, relativeLayout, shapeFrameLayout, textView, textView2, textView3);
                                            }
                                            str = "tvNameMore";
                                        } else {
                                            str = "tvName";
                                        }
                                    } else {
                                        str = "tvMoreP";
                                    }
                                } else {
                                    str = "shaUser";
                                }
                            } else {
                                str = "rlMore";
                            }
                        } else {
                            str = "ivUser";
                        }
                    } else {
                        str = "ivMore";
                    }
                } else {
                    str = "iv3";
                }
            } else {
                str = "iv2";
            }
        } else {
            str = "iv1";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.k;
    }
}
