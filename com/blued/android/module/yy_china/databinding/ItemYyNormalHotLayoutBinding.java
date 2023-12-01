package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeRelativeLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.yy_china.R;
import com.google.android.material.imageview.ShapeableImageView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyNormalHotLayoutBinding.class */
public final class ItemYyNormalHotLayoutBinding implements ViewBinding {
    public final ShapeableImageView a;
    public final ImageView b;
    public final SquareImageView c;
    public final ImageView d;
    public final SVGAImageView e;
    public final ShapeRelativeLayout f;
    public final LinearLayout g;
    public final LinearLayout h;
    public final ShapeLinearLayout i;
    public final RelativeLayout j;
    public final ShapeTextView k;
    public final TextView l;
    public final TextView m;
    public final ShapeTextView n;
    public final TextView o;
    private final RelativeLayout p;

    private ItemYyNormalHotLayoutBinding(RelativeLayout relativeLayout, ShapeableImageView shapeableImageView, ImageView imageView, SquareImageView squareImageView, ImageView imageView2, SVGAImageView sVGAImageView, ShapeRelativeLayout shapeRelativeLayout, LinearLayout linearLayout, LinearLayout linearLayout2, ShapeLinearLayout shapeLinearLayout, RelativeLayout relativeLayout2, ShapeTextView shapeTextView, TextView textView, TextView textView2, ShapeTextView shapeTextView2, TextView textView3) {
        this.p = relativeLayout;
        this.a = shapeableImageView;
        this.b = imageView;
        this.c = squareImageView;
        this.d = imageView2;
        this.e = sVGAImageView;
        this.f = shapeRelativeLayout;
        this.g = linearLayout;
        this.h = linearLayout2;
        this.i = shapeLinearLayout;
        this.j = relativeLayout2;
        this.k = shapeTextView;
        this.l = textView;
        this.m = textView2;
        this.n = shapeTextView2;
        this.o = textView3;
    }

    public static ItemYyNormalHotLayoutBinding a(View view) {
        String str;
        ShapeableImageView findViewById = view.findViewById(R.id.img_mask_tag);
        if (findViewById != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_anchor_leve);
            if (imageView != null) {
                SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.iv_normal_background);
                if (squareImageView != null) {
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_pk);
                    if (imageView2 != null) {
                        SVGAImageView sVGAImageView = (SVGAImageView) view.findViewById(R.id.iv_type_ani);
                        if (sVGAImageView != null) {
                            ShapeRelativeLayout shapeRelativeLayout = (ShapeRelativeLayout) view.findViewById(R.id.ll);
                            if (shapeRelativeLayout != null) {
                                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_info);
                                if (linearLayout != null) {
                                    LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_task);
                                    if (linearLayout2 != null) {
                                        ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(R.id.ll_type);
                                        if (shapeLinearLayout != null) {
                                            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_room_card);
                                            if (relativeLayout != null) {
                                                ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_anchor_city);
                                                if (shapeTextView != null) {
                                                    TextView textView = (TextView) view.findViewById(R.id.tv_normal_online_count);
                                                    if (textView != null) {
                                                        TextView textView2 = (TextView) view.findViewById(R.id.tv_normal_room_name);
                                                        if (textView2 != null) {
                                                            ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.tv_normal_room_type);
                                                            if (shapeTextView2 != null) {
                                                                TextView textView3 = (TextView) view.findViewById(R.id.tv_room_name);
                                                                if (textView3 != null) {
                                                                    return new ItemYyNormalHotLayoutBinding((RelativeLayout) view, findViewById, imageView, squareImageView, imageView2, sVGAImageView, shapeRelativeLayout, linearLayout, linearLayout2, shapeLinearLayout, relativeLayout, shapeTextView, textView, textView2, shapeTextView2, textView3);
                                                                }
                                                                str = "tvRoomName";
                                                            } else {
                                                                str = "tvNormalRoomType";
                                                            }
                                                        } else {
                                                            str = "tvNormalRoomName";
                                                        }
                                                    } else {
                                                        str = "tvNormalOnlineCount";
                                                    }
                                                } else {
                                                    str = "tvAnchorCity";
                                                }
                                            } else {
                                                str = "rlRoomCard";
                                            }
                                        } else {
                                            str = "llType";
                                        }
                                    } else {
                                        str = "llTask";
                                    }
                                } else {
                                    str = "llInfo";
                                }
                            } else {
                                str = "ll";
                            }
                        } else {
                            str = "ivTypeAni";
                        }
                    } else {
                        str = "ivPk";
                    }
                } else {
                    str = "ivNormalBackground";
                }
            } else {
                str = "ivAnchorLeve";
            }
        } else {
            str = "imgMaskTag";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public RelativeLayout getRoot() {
        return this.p;
    }
}
