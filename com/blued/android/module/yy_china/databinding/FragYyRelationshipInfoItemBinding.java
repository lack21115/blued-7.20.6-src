package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.view.RelationShipRoomProgressBtn;
import com.blued.android.module.yy_china.view.YYLivingStreamView;
import com.google.android.material.imageview.ShapeableImageView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/FragYyRelationshipInfoItemBinding.class */
public final class FragYyRelationshipInfoItemBinding implements ViewBinding {
    public final TextView A;
    public final TextView B;
    public final TextView C;
    public final TextView D;
    public final TextView E;
    public final TextView F;
    public final TextView G;
    public final TextView H;
    public final TextView I;
    public final ViewPager J;
    private final ConstraintLayout K;

    /* renamed from: a  reason: collision with root package name */
    public final ShapeTextView f16465a;
    public final TextView b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f16466c;
    public final ShapeTextView d;
    public final FrameLayout e;
    public final Group f;
    public final Group g;
    public final ImageView h;
    public final ImageView i;
    public final ImageView j;
    public final ImageView k;
    public final ImageView l;
    public final ImageView m;
    public final SquareImageView n;
    public final ImageView o;
    public final SquareImageView p;
    public final ShapeableImageView q;
    public final ShapeableImageView r;
    public final YYLivingStreamView s;
    public final YYLivingStreamView t;
    public final LinearLayout u;
    public final LinearLayout v;
    public final LinearLayout w;
    public final RelationShipRoomProgressBtn x;
    public final TextView y;
    public final ShapeTextView z;

    private FragYyRelationshipInfoItemBinding(ConstraintLayout constraintLayout, ShapeTextView shapeTextView, TextView textView, TextView textView2, ShapeTextView shapeTextView2, FrameLayout frameLayout, Group group, Group group2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, SquareImageView squareImageView, ImageView imageView7, SquareImageView squareImageView2, ShapeableImageView shapeableImageView, ShapeableImageView shapeableImageView2, YYLivingStreamView yYLivingStreamView, YYLivingStreamView yYLivingStreamView2, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, RelationShipRoomProgressBtn relationShipRoomProgressBtn, TextView textView3, ShapeTextView shapeTextView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, ViewPager viewPager) {
        this.K = constraintLayout;
        this.f16465a = shapeTextView;
        this.b = textView;
        this.f16466c = textView2;
        this.d = shapeTextView2;
        this.e = frameLayout;
        this.f = group;
        this.g = group2;
        this.h = imageView;
        this.i = imageView2;
        this.j = imageView3;
        this.k = imageView4;
        this.l = imageView5;
        this.m = imageView6;
        this.n = squareImageView;
        this.o = imageView7;
        this.p = squareImageView2;
        this.q = shapeableImageView;
        this.r = shapeableImageView2;
        this.s = yYLivingStreamView;
        this.t = yYLivingStreamView2;
        this.u = linearLayout;
        this.v = linearLayout2;
        this.w = linearLayout3;
        this.x = relationShipRoomProgressBtn;
        this.y = textView3;
        this.z = shapeTextView3;
        this.A = textView4;
        this.B = textView5;
        this.C = textView6;
        this.D = textView7;
        this.E = textView8;
        this.F = textView9;
        this.G = textView10;
        this.H = textView11;
        this.I = textView12;
        this.J = viewPager;
    }

    public static FragYyRelationshipInfoItemBinding a(View view) {
        String str;
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.btn_all);
        if (shapeTextView != null) {
            TextView textView = (TextView) view.findViewById(R.id.btn_close_relation);
            if (textView != null) {
                TextView textView2 = (TextView) view.findViewById(R.id.btn_hit_relation);
                if (textView2 != null) {
                    ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.btn_more);
                    if (shapeTextView2 != null) {
                        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.con_pro);
                        if (frameLayout != null) {
                            Group group = (Group) view.findViewById(R.id.gro_masked_about);
                            if (group != null) {
                                Group group2 = (Group) view.findViewById(R.id.grp_lv_info);
                                if (group2 != null) {
                                    ImageView imageView = (ImageView) view.findViewById(R.id.iv_bg);
                                    if (imageView != null) {
                                        ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_bg_2);
                                        if (imageView2 != null) {
                                            ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_bg_masked_about);
                                            if (imageView3 != null) {
                                                ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_lv_1);
                                                if (imageView4 != null) {
                                                    ImageView imageView5 = (ImageView) view.findViewById(R.id.iv_lv_2);
                                                    if (imageView5 != null) {
                                                        ImageView imageView6 = (ImageView) view.findViewById(R.id.iv_masked_top_about);
                                                        if (imageView6 != null) {
                                                            SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.iv_pro_triage);
                                                            if (squareImageView != null) {
                                                                ImageView imageView7 = (ImageView) view.findViewById(R.id.iv_relation_icon);
                                                                if (imageView7 != null) {
                                                                    SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.iv_relationship_about);
                                                                    if (squareImageView2 != null) {
                                                                        ShapeableImageView shapeableImageView = (ShapeableImageView) view.findViewById(R.id.iv_user_1);
                                                                        if (shapeableImageView != null) {
                                                                            ShapeableImageView shapeableImageView2 = (ShapeableImageView) view.findViewById(R.id.iv_user_2);
                                                                            if (shapeableImageView2 != null) {
                                                                                YYLivingStreamView yYLivingStreamView = (YYLivingStreamView) view.findViewById(R.id.iv_user_live_1);
                                                                                if (yYLivingStreamView != null) {
                                                                                    YYLivingStreamView yYLivingStreamView2 = (YYLivingStreamView) view.findViewById(R.id.iv_user_live_2);
                                                                                    if (yYLivingStreamView2 != null) {
                                                                                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_lv_num);
                                                                                        if (linearLayout != null) {
                                                                                            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_more);
                                                                                            if (linearLayout2 != null) {
                                                                                                LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.ll_num);
                                                                                                if (linearLayout3 != null) {
                                                                                                    RelationShipRoomProgressBtn relationShipRoomProgressBtn = (RelationShipRoomProgressBtn) view.findViewById(R.id.pro_relationship);
                                                                                                    if (relationShipRoomProgressBtn != null) {
                                                                                                        TextView textView3 = (TextView) view.findViewById(R.id.tv_current_value);
                                                                                                        if (textView3 != null) {
                                                                                                            ShapeTextView shapeTextView3 = (ShapeTextView) view.findViewById(R.id.tv_masked_top_about);
                                                                                                            if (shapeTextView3 != null) {
                                                                                                                TextView textView4 = (TextView) view.findViewById(R.id.tv_name_user_1);
                                                                                                                if (textView4 != null) {
                                                                                                                    TextView textView5 = (TextView) view.findViewById(R.id.tv_name_user_2);
                                                                                                                    if (textView5 != null) {
                                                                                                                        TextView textView6 = (TextView) view.findViewById(R.id.tv_next_value);
                                                                                                                        if (textView6 != null) {
                                                                                                                            TextView textView7 = (TextView) view.findViewById(R.id.tv_null_info);
                                                                                                                            if (textView7 != null) {
                                                                                                                                TextView textView8 = (TextView) view.findViewById(R.id.tv_relation_info);
                                                                                                                                if (textView8 != null) {
                                                                                                                                    TextView textView9 = (TextView) view.findViewById(R.id.tv_relation_info_null);
                                                                                                                                    if (textView9 != null) {
                                                                                                                                        TextView textView10 = (TextView) view.findViewById(R.id.tv_relation_num);
                                                                                                                                        if (textView10 != null) {
                                                                                                                                            TextView textView11 = (TextView) view.findViewById(R.id.tv_relation_type_day);
                                                                                                                                            if (textView11 != null) {
                                                                                                                                                TextView textView12 = (TextView) view.findViewById(R.id.tv_relation_type_name);
                                                                                                                                                if (textView12 != null) {
                                                                                                                                                    ViewPager viewPager = (ViewPager) view.findViewById(R.id.vp_room);
                                                                                                                                                    if (viewPager != null) {
                                                                                                                                                        return new FragYyRelationshipInfoItemBinding((ConstraintLayout) view, shapeTextView, textView, textView2, shapeTextView2, frameLayout, group, group2, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, squareImageView, imageView7, squareImageView2, shapeableImageView, shapeableImageView2, yYLivingStreamView, yYLivingStreamView2, linearLayout, linearLayout2, linearLayout3, relationShipRoomProgressBtn, textView3, shapeTextView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, viewPager);
                                                                                                                                                    }
                                                                                                                                                    str = "vpRoom";
                                                                                                                                                } else {
                                                                                                                                                    str = "tvRelationTypeName";
                                                                                                                                                }
                                                                                                                                            } else {
                                                                                                                                                str = "tvRelationTypeDay";
                                                                                                                                            }
                                                                                                                                        } else {
                                                                                                                                            str = "tvRelationNum";
                                                                                                                                        }
                                                                                                                                    } else {
                                                                                                                                        str = "tvRelationInfoNull";
                                                                                                                                    }
                                                                                                                                } else {
                                                                                                                                    str = "tvRelationInfo";
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                str = "tvNullInfo";
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            str = "tvNextValue";
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        str = "tvNameUser2";
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    str = "tvNameUser1";
                                                                                                                }
                                                                                                            } else {
                                                                                                                str = "tvMaskedTopAbout";
                                                                                                            }
                                                                                                        } else {
                                                                                                            str = "tvCurrentValue";
                                                                                                        }
                                                                                                    } else {
                                                                                                        str = "proRelationship";
                                                                                                    }
                                                                                                } else {
                                                                                                    str = "llNum";
                                                                                                }
                                                                                            } else {
                                                                                                str = "llMore";
                                                                                            }
                                                                                        } else {
                                                                                            str = "llLvNum";
                                                                                        }
                                                                                    } else {
                                                                                        str = "ivUserLive2";
                                                                                    }
                                                                                } else {
                                                                                    str = "ivUserLive1";
                                                                                }
                                                                            } else {
                                                                                str = "ivUser2";
                                                                            }
                                                                        } else {
                                                                            str = "ivUser1";
                                                                        }
                                                                    } else {
                                                                        str = "ivRelationshipAbout";
                                                                    }
                                                                } else {
                                                                    str = "ivRelationIcon";
                                                                }
                                                            } else {
                                                                str = "ivProTriage";
                                                            }
                                                        } else {
                                                            str = "ivMaskedTopAbout";
                                                        }
                                                    } else {
                                                        str = "ivLv2";
                                                    }
                                                } else {
                                                    str = "ivLv1";
                                                }
                                            } else {
                                                str = "ivBgMaskedAbout";
                                            }
                                        } else {
                                            str = "ivBg2";
                                        }
                                    } else {
                                        str = "ivBg";
                                    }
                                } else {
                                    str = "grpLvInfo";
                                }
                            } else {
                                str = "groMaskedAbout";
                            }
                        } else {
                            str = "conPro";
                        }
                    } else {
                        str = "btnMore";
                    }
                } else {
                    str = "btnHitRelation";
                }
            } else {
                str = "btnCloseRelation";
            }
        } else {
            str = "btnAll";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.K;
    }
}
