package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.view.YYSvgaView;
import com.google.android.material.imageview.ShapeableImageView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyHomeRoomsRoomBinding.class */
public final class ItemYyHomeRoomsRoomBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f16735a;
    public final ShapeableImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f16736c;
    public final ImageView d;
    public final ImageView e;
    public final SVGAImageView f;
    public final ShapeableImageView g;
    public final ShapeLinearLayout h;
    public final LinearLayout i;
    public final CardView j;
    public final YYSvgaView k;
    public final ShapeTextView l;
    public final TextView m;
    public final TextView n;
    public final ShapeTextView o;
    public final TextView p;
    public final TextView q;
    private final FrameLayout r;

    private ItemYyHomeRoomsRoomBinding(FrameLayout frameLayout, ConstraintLayout constraintLayout, ShapeableImageView shapeableImageView, ImageView imageView, ImageView imageView2, ImageView imageView3, SVGAImageView sVGAImageView, ShapeableImageView shapeableImageView2, ShapeLinearLayout shapeLinearLayout, LinearLayout linearLayout, CardView cardView, YYSvgaView yYSvgaView, ShapeTextView shapeTextView, TextView textView, TextView textView2, ShapeTextView shapeTextView2, TextView textView3, TextView textView4) {
        this.r = frameLayout;
        this.f16735a = constraintLayout;
        this.b = shapeableImageView;
        this.f16736c = imageView;
        this.d = imageView2;
        this.e = imageView3;
        this.f = sVGAImageView;
        this.g = shapeableImageView2;
        this.h = shapeLinearLayout;
        this.i = linearLayout;
        this.j = cardView;
        this.k = yYSvgaView;
        this.l = shapeTextView;
        this.m = textView;
        this.n = textView2;
        this.o = shapeTextView2;
        this.p = textView3;
        this.q = textView4;
    }

    public static ItemYyHomeRoomsRoomBinding a(View view) {
        String str;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.con);
        if (constraintLayout != null) {
            ShapeableImageView shapeableImageView = (ShapeableImageView) view.findViewById(R.id.img_mask_tag);
            if (shapeableImageView != null) {
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_anchor_leve);
                if (imageView != null) {
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_city);
                    if (imageView2 != null) {
                        ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_pk);
                        if (imageView3 != null) {
                            SVGAImageView sVGAImageView = (SVGAImageView) view.findViewById(R.id.iv_room_type_ani);
                            if (sVGAImageView != null) {
                                ShapeableImageView shapeableImageView2 = (ShapeableImageView) view.findViewById(R.id.iv_user);
                                if (shapeableImageView2 != null) {
                                    ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(R.id.ll_room_type);
                                    if (shapeLinearLayout != null) {
                                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_task);
                                        if (linearLayout != null) {
                                            CardView cardView = (CardView) view.findViewById(R.id.room_card);
                                            if (cardView != null) {
                                                YYSvgaView yYSvgaView = (YYSvgaView) view.findViewById(R.id.svga);
                                                if (yYSvgaView != null) {
                                                    ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_bg_top);
                                                    if (shapeTextView != null) {
                                                        TextView textView = (TextView) view.findViewById(R.id.tv_room_city);
                                                        if (textView != null) {
                                                            TextView textView2 = (TextView) view.findViewById(R.id.tv_room_name);
                                                            if (textView2 != null) {
                                                                ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.tv_room_type);
                                                                if (shapeTextView2 != null) {
                                                                    TextView textView3 = (TextView) view.findViewById(R.id.tv_room_user_cout);
                                                                    if (textView3 != null) {
                                                                        TextView textView4 = (TextView) view.findViewById(R.id.tv_room_user_name);
                                                                        if (textView4 != null) {
                                                                            return new ItemYyHomeRoomsRoomBinding((FrameLayout) view, constraintLayout, shapeableImageView, imageView, imageView2, imageView3, sVGAImageView, shapeableImageView2, shapeLinearLayout, linearLayout, cardView, yYSvgaView, shapeTextView, textView, textView2, shapeTextView2, textView3, textView4);
                                                                        }
                                                                        str = "tvRoomUserName";
                                                                    } else {
                                                                        str = "tvRoomUserCout";
                                                                    }
                                                                } else {
                                                                    str = "tvRoomType";
                                                                }
                                                            } else {
                                                                str = "tvRoomName";
                                                            }
                                                        } else {
                                                            str = "tvRoomCity";
                                                        }
                                                    } else {
                                                        str = "tvBgTop";
                                                    }
                                                } else {
                                                    str = "svga";
                                                }
                                            } else {
                                                str = "roomCard";
                                            }
                                        } else {
                                            str = "llTask";
                                        }
                                    } else {
                                        str = "llRoomType";
                                    }
                                } else {
                                    str = "ivUser";
                                }
                            } else {
                                str = "ivRoomTypeAni";
                            }
                        } else {
                            str = "ivPk";
                        }
                    } else {
                        str = "ivCity";
                    }
                } else {
                    str = "ivAnchorLeve";
                }
            } else {
                str = "imgMaskTag";
            }
        } else {
            str = "con";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.r;
    }
}
