package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.view.YYFansLevelView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyFollowedsLayoutBinding.class */
public final class ItemYyFollowedsLayoutBinding implements ViewBinding {
    public final TextView a;
    public final LinearLayout b;
    public final ImageView c;
    public final SVGAImageView d;
    public final LinearLayout e;
    public final ShapeLinearLayout f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public final ShapeTextView j;
    public final TextView k;
    public final YYFansLevelView l;
    private final LinearLayout m;

    private ItemYyFollowedsLayoutBinding(LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, ImageView imageView, SVGAImageView sVGAImageView, LinearLayout linearLayout3, ShapeLinearLayout shapeLinearLayout, TextView textView2, TextView textView3, TextView textView4, ShapeTextView shapeTextView, TextView textView5, YYFansLevelView yYFansLevelView) {
        this.m = linearLayout;
        this.a = textView;
        this.b = linearLayout2;
        this.c = imageView;
        this.d = sVGAImageView;
        this.e = linearLayout3;
        this.f = shapeLinearLayout;
        this.g = textView2;
        this.h = textView3;
        this.i = textView4;
        this.j = shapeTextView;
        this.k = textView5;
        this.l = yYFansLevelView;
    }

    public static ItemYyFollowedsLayoutBinding a(View view) {
        String str;
        TextView textView = (TextView) view.findViewById(R.id.fl_cover_view);
        if (textView != null) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.item_follow_layout);
            if (linearLayout != null) {
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_header_img);
                if (imageView != null) {
                    SVGAImageView sVGAImageView = (SVGAImageView) view.findViewById(R.id.iv_type_ani);
                    if (sVGAImageView != null) {
                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_count);
                        if (linearLayout2 != null) {
                            ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(R.id.ll_type);
                            if (shapeLinearLayout != null) {
                                TextView textView2 = (TextView) view.findViewById(R.id.tv_count);
                                if (textView2 != null) {
                                    TextView textView3 = (TextView) view.findViewById(R.id.tv_last_live);
                                    if (textView3 != null) {
                                        TextView textView4 = (TextView) view.findViewById(R.id.tv_nickname);
                                        if (textView4 != null) {
                                            ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_normal_room_type);
                                            if (shapeTextView != null) {
                                                TextView textView5 = (TextView) view.findViewById(R.id.tv_room_name);
                                                if (textView5 != null) {
                                                    YYFansLevelView yYFansLevelView = (YYFansLevelView) view.findViewById(R.id.yy_fans_leve);
                                                    if (yYFansLevelView != null) {
                                                        return new ItemYyFollowedsLayoutBinding((LinearLayout) view, textView, linearLayout, imageView, sVGAImageView, linearLayout2, shapeLinearLayout, textView2, textView3, textView4, shapeTextView, textView5, yYFansLevelView);
                                                    }
                                                    str = "yyFansLeve";
                                                } else {
                                                    str = "tvRoomName";
                                                }
                                            } else {
                                                str = "tvNormalRoomType";
                                            }
                                        } else {
                                            str = "tvNickname";
                                        }
                                    } else {
                                        str = "tvLastLive";
                                    }
                                } else {
                                    str = "tvCount";
                                }
                            } else {
                                str = "llType";
                            }
                        } else {
                            str = "llCount";
                        }
                    } else {
                        str = "ivTypeAni";
                    }
                } else {
                    str = "ivHeaderImg";
                }
            } else {
                str = "itemFollowLayout";
            }
        } else {
            str = "flCoverView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.m;
    }
}
