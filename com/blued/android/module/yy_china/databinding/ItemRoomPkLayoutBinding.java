package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.HollowView;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.view.YYBaseUserHeadView;
import com.google.android.material.imageview.ShapeableImageView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemRoomPkLayoutBinding.class */
public final class ItemRoomPkLayoutBinding implements ViewBinding {
    public final TextView A;
    public final TextView B;
    public final TextView C;
    public final TextView D;
    public final TextView E;
    public final ConstraintLayout F;
    private final ConstraintLayout G;

    /* renamed from: a  reason: collision with root package name */
    public final ShapeTextView f16653a;
    public final LinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f16654c;
    public final ImageView d;
    public final ImageView e;
    public final SVGAImageView f;
    public final ImageView g;
    public final ShapeableImageView h;
    public final ImageView i;
    public final ImageView j;
    public final ShapeableImageView k;
    public final ImageView l;
    public final ShapeLinearLayout m;
    public final YYBaseUserHeadView n;
    public final LinearLayout o;
    public final HollowView p;
    public final LinearLayout q;
    public final HollowView r;
    public final YYBaseUserHeadView s;
    public final RecyclerView t;
    public final RecyclerView u;
    public final RecyclerView v;
    public final TextView w;
    public final TextView x;
    public final TextView y;
    public final TextView z;

    private ItemRoomPkLayoutBinding(ConstraintLayout constraintLayout, ShapeTextView shapeTextView, LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, SVGAImageView sVGAImageView, ImageView imageView4, ShapeableImageView shapeableImageView, ImageView imageView5, ImageView imageView6, ShapeableImageView shapeableImageView2, ImageView imageView7, ShapeLinearLayout shapeLinearLayout, YYBaseUserHeadView yYBaseUserHeadView, LinearLayout linearLayout2, HollowView hollowView, LinearLayout linearLayout3, HollowView hollowView2, YYBaseUserHeadView yYBaseUserHeadView2, RecyclerView recyclerView, RecyclerView recyclerView2, RecyclerView recyclerView3, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, ConstraintLayout constraintLayout2) {
        this.G = constraintLayout;
        this.f16653a = shapeTextView;
        this.b = linearLayout;
        this.f16654c = imageView;
        this.d = imageView2;
        this.e = imageView3;
        this.f = sVGAImageView;
        this.g = imageView4;
        this.h = shapeableImageView;
        this.i = imageView5;
        this.j = imageView6;
        this.k = shapeableImageView2;
        this.l = imageView7;
        this.m = shapeLinearLayout;
        this.n = yYBaseUserHeadView;
        this.o = linearLayout2;
        this.p = hollowView;
        this.q = linearLayout3;
        this.r = hollowView2;
        this.s = yYBaseUserHeadView2;
        this.t = recyclerView;
        this.u = recyclerView2;
        this.v = recyclerView3;
        this.w = textView;
        this.x = textView2;
        this.y = textView3;
        this.z = textView4;
        this.A = textView5;
        this.B = textView6;
        this.C = textView7;
        this.D = textView8;
        this.E = textView9;
        this.F = constraintLayout2;
    }

    public static ItemRoomPkLayoutBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_room_pk_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ItemRoomPkLayoutBinding a(View view) {
        String str;
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.btn_instruction);
        if (shapeTextView != null) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.fl_pk_progress);
            if (linearLayout != null) {
                ImageView imageView = (ImageView) view.findViewById(R.id.img_all_member);
                if (imageView != null) {
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.img_anchor_bg);
                    if (imageView2 != null) {
                        ImageView imageView3 = (ImageView) view.findViewById(R.id.img_first_gift_time);
                        if (imageView3 != null) {
                            SVGAImageView sVGAImageView = (SVGAImageView) view.findViewById(R.id.img_first_time);
                            if (sVGAImageView != null) {
                                ImageView imageView4 = (ImageView) view.findViewById(R.id.img_left_pk_result);
                                if (imageView4 != null) {
                                    ShapeableImageView shapeableImageView = (ShapeableImageView) view.findViewById(R.id.img_left_user_level);
                                    if (shapeableImageView != null) {
                                        ImageView imageView5 = (ImageView) view.findViewById(R.id.img_other_member);
                                        if (imageView5 != null) {
                                            ImageView imageView6 = (ImageView) view.findViewById(R.id.img_right_pk_result);
                                            if (imageView6 != null) {
                                                ShapeableImageView shapeableImageView2 = (ShapeableImageView) view.findViewById(R.id.img_right_user_level);
                                                if (shapeableImageView2 != null) {
                                                    ImageView imageView7 = (ImageView) view.findViewById(R.id.img_vs_icon);
                                                    if (imageView7 != null) {
                                                        ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(R.id.iv_pk_pro);
                                                        if (shapeLinearLayout != null) {
                                                            YYBaseUserHeadView yYBaseUserHeadView = (YYBaseUserHeadView) view.findViewById(R.id.left_anchor_view);
                                                            if (yYBaseUserHeadView != null) {
                                                                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_all_member);
                                                                if (linearLayout2 != null) {
                                                                    HollowView hollowView = (HollowView) view.findViewById(R.id.ll_left_user_ring);
                                                                    if (hollowView != null) {
                                                                        LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.ll_other_member);
                                                                        if (linearLayout3 != null) {
                                                                            HollowView hollowView2 = (HollowView) view.findViewById(R.id.ll_right_user_ring);
                                                                            if (hollowView2 != null) {
                                                                                YYBaseUserHeadView yYBaseUserHeadView2 = (YYBaseUserHeadView) view.findViewById(R.id.right_anchor_view);
                                                                                if (yYBaseUserHeadView2 != null) {
                                                                                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_blue_rank);
                                                                                    if (recyclerView != null) {
                                                                                        RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.rv_member_list);
                                                                                        if (recyclerView2 != null) {
                                                                                            RecyclerView recyclerView3 = (RecyclerView) view.findViewById(R.id.rv_red_rank);
                                                                                            if (recyclerView3 != null) {
                                                                                                TextView textView = (TextView) view.findViewById(R.id.tv_all_member);
                                                                                                if (textView != null) {
                                                                                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_blue_score);
                                                                                                    if (textView2 != null) {
                                                                                                        TextView textView3 = (TextView) view.findViewById(R.id.tv_left_user_level);
                                                                                                        if (textView3 != null) {
                                                                                                            TextView textView4 = (TextView) view.findViewById(R.id.tv_left_user_name);
                                                                                                            if (textView4 != null) {
                                                                                                                TextView textView5 = (TextView) view.findViewById(R.id.tv_other_member);
                                                                                                                if (textView5 != null) {
                                                                                                                    TextView textView6 = (TextView) view.findViewById(R.id.tv_pk_timer_view);
                                                                                                                    if (textView6 != null) {
                                                                                                                        TextView textView7 = (TextView) view.findViewById(R.id.tv_red_score);
                                                                                                                        if (textView7 != null) {
                                                                                                                            TextView textView8 = (TextView) view.findViewById(R.id.tv_right_user_level);
                                                                                                                            if (textView8 != null) {
                                                                                                                                TextView textView9 = (TextView) view.findViewById(R.id.tv_right_user_name);
                                                                                                                                if (textView9 != null) {
                                                                                                                                    ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.yy_connectting_root);
                                                                                                                                    if (constraintLayout != null) {
                                                                                                                                        return new ItemRoomPkLayoutBinding((ConstraintLayout) view, shapeTextView, linearLayout, imageView, imageView2, imageView3, sVGAImageView, imageView4, shapeableImageView, imageView5, imageView6, shapeableImageView2, imageView7, shapeLinearLayout, yYBaseUserHeadView, linearLayout2, hollowView, linearLayout3, hollowView2, yYBaseUserHeadView2, recyclerView, recyclerView2, recyclerView3, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, constraintLayout);
                                                                                                                                    }
                                                                                                                                    str = "yyConnecttingRoot";
                                                                                                                                } else {
                                                                                                                                    str = "tvRightUserName";
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                str = "tvRightUserLevel";
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            str = "tvRedScore";
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        str = "tvPkTimerView";
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    str = "tvOtherMember";
                                                                                                                }
                                                                                                            } else {
                                                                                                                str = "tvLeftUserName";
                                                                                                            }
                                                                                                        } else {
                                                                                                            str = "tvLeftUserLevel";
                                                                                                        }
                                                                                                    } else {
                                                                                                        str = "tvBlueScore";
                                                                                                    }
                                                                                                } else {
                                                                                                    str = "tvAllMember";
                                                                                                }
                                                                                            } else {
                                                                                                str = "rvRedRank";
                                                                                            }
                                                                                        } else {
                                                                                            str = "rvMemberList";
                                                                                        }
                                                                                    } else {
                                                                                        str = "rvBlueRank";
                                                                                    }
                                                                                } else {
                                                                                    str = "rightAnchorView";
                                                                                }
                                                                            } else {
                                                                                str = "llRightUserRing";
                                                                            }
                                                                        } else {
                                                                            str = "llOtherMember";
                                                                        }
                                                                    } else {
                                                                        str = "llLeftUserRing";
                                                                    }
                                                                } else {
                                                                    str = "llAllMember";
                                                                }
                                                            } else {
                                                                str = "leftAnchorView";
                                                            }
                                                        } else {
                                                            str = "ivPkPro";
                                                        }
                                                    } else {
                                                        str = "imgVsIcon";
                                                    }
                                                } else {
                                                    str = "imgRightUserLevel";
                                                }
                                            } else {
                                                str = "imgRightPkResult";
                                            }
                                        } else {
                                            str = "imgOtherMember";
                                        }
                                    } else {
                                        str = "imgLeftUserLevel";
                                    }
                                } else {
                                    str = "imgLeftPkResult";
                                }
                            } else {
                                str = "imgFirstTime";
                            }
                        } else {
                            str = "imgFirstGiftTime";
                        }
                    } else {
                        str = "imgAnchorBg";
                    }
                } else {
                    str = "imgAllMember";
                }
            } else {
                str = "flPkProgress";
            }
        } else {
            str = "btnInstruction";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.G;
    }
}
