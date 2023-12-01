package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogYyFirstMeetBinding.class */
public final class DialogYyFirstMeetBinding implements ViewBinding {
    public final ShapeLinearLayout a;
    public final Group b;
    public final SquareImageView c;
    public final SquareImageView d;
    public final ImageView e;
    public final RecyclerView f;
    public final SVGAImageView g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    private final LinearLayout k;

    private DialogYyFirstMeetBinding(LinearLayout linearLayout, ShapeLinearLayout shapeLinearLayout, Group group, SquareImageView squareImageView, SquareImageView squareImageView2, ImageView imageView, RecyclerView recyclerView, SVGAImageView sVGAImageView, TextView textView, TextView textView2, TextView textView3) {
        this.k = linearLayout;
        this.a = shapeLinearLayout;
        this.b = group;
        this.c = squareImageView;
        this.d = squareImageView2;
        this.e = imageView;
        this.f = recyclerView;
        this.g = sVGAImageView;
        this.h = textView;
        this.i = textView2;
        this.j = textView3;
    }

    public static DialogYyFirstMeetBinding a(View view) {
        String str;
        ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(R.id.btn_send_gift);
        if (shapeLinearLayout != null) {
            Group findViewById = view.findViewById(R.id.group);
            if (findViewById != null) {
                SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.iv_gift);
                if (squareImageView != null) {
                    SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.iv_smeel);
                    if (squareImageView2 != null) {
                        ImageView imageView = (ImageView) view.findViewById(R.id.iv_title);
                        if (imageView != null) {
                            RecyclerView findViewById2 = view.findViewById(R.id.rec);
                            if (findViewById2 != null) {
                                SVGAImageView sVGAImageView = (SVGAImageView) view.findViewById(R.id.svga);
                                if (sVGAImageView != null) {
                                    TextView textView = (TextView) view.findViewById(R.id.tv_gift_num);
                                    if (textView != null) {
                                        TextView textView2 = (TextView) view.findViewById(R.id.tv_mess);
                                        if (textView2 != null) {
                                            TextView textView3 = (TextView) view.findViewById(R.id.tv_title);
                                            if (textView3 != null) {
                                                return new DialogYyFirstMeetBinding((LinearLayout) view, shapeLinearLayout, findViewById, squareImageView, squareImageView2, imageView, findViewById2, sVGAImageView, textView, textView2, textView3);
                                            }
                                            str = "tvTitle";
                                        } else {
                                            str = "tvMess";
                                        }
                                    } else {
                                        str = "tvGiftNum";
                                    }
                                } else {
                                    str = "svga";
                                }
                            } else {
                                str = "rec";
                            }
                        } else {
                            str = "ivTitle";
                        }
                    } else {
                        str = "ivSmeel";
                    }
                } else {
                    str = "ivGift";
                }
            } else {
                str = "group";
            }
        } else {
            str = "btnSendGift";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.k;
    }
}
