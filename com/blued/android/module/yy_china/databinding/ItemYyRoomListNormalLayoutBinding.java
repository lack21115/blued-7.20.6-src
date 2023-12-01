package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.yy_china.R;
import com.google.android.material.imageview.ShapeableImageView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyRoomListNormalLayoutBinding.class */
public final class ItemYyRoomListNormalLayoutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeableImageView f16810a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f16811c;
    public final ImageView d;
    public final ImageView e;
    public final SVGAImageView f;
    public final ShapeConstraintLayout g;
    public final LinearLayout h;
    public final ShapeLinearLayout i;
    public final RelativeLayout j;
    public final ShapeTextView k;
    public final TextView l;
    public final TextView m;
    public final ShapeTextView n;
    public final TextView o;
    private final RelativeLayout p;

    private ItemYyRoomListNormalLayoutBinding(RelativeLayout relativeLayout, ShapeableImageView shapeableImageView, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, SVGAImageView sVGAImageView, ShapeConstraintLayout shapeConstraintLayout, LinearLayout linearLayout, ShapeLinearLayout shapeLinearLayout, RelativeLayout relativeLayout2, ShapeTextView shapeTextView, TextView textView, TextView textView2, ShapeTextView shapeTextView2, TextView textView3) {
        this.p = relativeLayout;
        this.f16810a = shapeableImageView;
        this.b = imageView;
        this.f16811c = imageView2;
        this.d = imageView3;
        this.e = imageView4;
        this.f = sVGAImageView;
        this.g = shapeConstraintLayout;
        this.h = linearLayout;
        this.i = shapeLinearLayout;
        this.j = relativeLayout2;
        this.k = shapeTextView;
        this.l = textView;
        this.m = textView2;
        this.n = shapeTextView2;
        this.o = textView3;
    }

    public static ItemYyRoomListNormalLayoutBinding a(View view) {
        String str;
        ShapeableImageView shapeableImageView = (ShapeableImageView) view.findViewById(R.id.img_mask_tag);
        if (shapeableImageView != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_anchor_leve);
            if (imageView != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_hot);
                if (imageView2 != null) {
                    ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_normal_background);
                    if (imageView3 != null) {
                        ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_pk);
                        if (imageView4 != null) {
                            SVGAImageView sVGAImageView = (SVGAImageView) view.findViewById(R.id.iv_type_ani);
                            if (sVGAImageView != null) {
                                ShapeConstraintLayout shapeConstraintLayout = (ShapeConstraintLayout) view.findViewById(R.id.ll);
                                if (shapeConstraintLayout != null) {
                                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_task);
                                    if (linearLayout != null) {
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
                                                                    return new ItemYyRoomListNormalLayoutBinding((RelativeLayout) view, shapeableImageView, imageView, imageView2, imageView3, imageView4, sVGAImageView, shapeConstraintLayout, linearLayout, shapeLinearLayout, relativeLayout, shapeTextView, textView, textView2, shapeTextView2, textView3);
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
                    str = "ivHot";
                }
            } else {
                str = "ivAnchorLeve";
            }
        } else {
            str = "imgMaskTag";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public RelativeLayout getRoot() {
        return this.p;
    }
}
