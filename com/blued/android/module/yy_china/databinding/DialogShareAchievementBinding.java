package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;
import com.google.android.material.imageview.ShapeableImageView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogShareAchievementBinding.class */
public final class DialogShareAchievementBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final CheckBox f16413a;
    public final TextView b;

    /* renamed from: c  reason: collision with root package name */
    public final View f16414c;
    public final ImageView d;
    public final ImageView e;
    public final ImageView f;
    public final ImageView g;
    public final ImageView h;
    public final ImageView i;
    public final ShapeableImageView j;
    public final ShapeableImageView k;
    public final ShapeableImageView l;
    public final View m;
    public final ConstraintLayout n;
    public final ConstraintLayout o;
    public final ConstraintLayout p;
    public final RecyclerView q;
    public final TextView r;
    public final TextView s;
    public final TextView t;
    public final TextView u;
    public final TextView v;
    public final TextView w;
    public final TextView x;
    public final TextView y;
    private final ConstraintLayout z;

    private DialogShareAchievementBinding(ConstraintLayout constraintLayout, CheckBox checkBox, TextView textView, View view, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ShapeableImageView shapeableImageView, ShapeableImageView shapeableImageView2, ShapeableImageView shapeableImageView3, View view2, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, RecyclerView recyclerView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9) {
        this.z = constraintLayout;
        this.f16413a = checkBox;
        this.b = textView;
        this.f16414c = view;
        this.d = imageView;
        this.e = imageView2;
        this.f = imageView3;
        this.g = imageView4;
        this.h = imageView5;
        this.i = imageView6;
        this.j = shapeableImageView;
        this.k = shapeableImageView2;
        this.l = shapeableImageView3;
        this.m = view2;
        this.n = constraintLayout2;
        this.o = constraintLayout3;
        this.p = constraintLayout4;
        this.q = recyclerView;
        this.r = textView2;
        this.s = textView3;
        this.t = textView4;
        this.u = textView5;
        this.v = textView6;
        this.w = textView7;
        this.x = textView8;
        this.y = textView9;
    }

    public static DialogShareAchievementBinding a(View view) {
        String str;
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.btn_post_feed);
        if (checkBox != null) {
            TextView textView = (TextView) view.findViewById(R.id.btn_to_check);
            if (textView != null) {
                View findViewById = view.findViewById(R.id.cover_view);
                if (findViewById != null) {
                    ImageView imageView = (ImageView) view.findViewById(R.id.img_celebration);
                    if (imageView != null) {
                        ImageView imageView2 = (ImageView) view.findViewById(R.id.img_podium_1);
                        if (imageView2 != null) {
                            ImageView imageView3 = (ImageView) view.findViewById(R.id.img_podium_2);
                            if (imageView3 != null) {
                                ImageView imageView4 = (ImageView) view.findViewById(R.id.img_podium_3);
                                if (imageView4 != null) {
                                    ImageView imageView5 = (ImageView) view.findViewById(R.id.img_podium_cover);
                                    if (imageView5 != null) {
                                        ImageView imageView6 = (ImageView) view.findViewById(R.id.img_thanks_giving);
                                        if (imageView6 != null) {
                                            ShapeableImageView shapeableImageView = (ShapeableImageView) view.findViewById(R.id.img_user_1);
                                            if (shapeableImageView != null) {
                                                ShapeableImageView shapeableImageView2 = (ShapeableImageView) view.findViewById(R.id.img_user_2);
                                                if (shapeableImageView2 != null) {
                                                    ShapeableImageView shapeableImageView3 = (ShapeableImageView) view.findViewById(R.id.img_user_3);
                                                    if (shapeableImageView3 != null) {
                                                        View findViewById2 = view.findViewById(R.id.line_center);
                                                        if (findViewById2 != null) {
                                                            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.ll_content_view);
                                                            if (constraintLayout != null) {
                                                                ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.ll_dialog_view);
                                                                if (constraintLayout2 != null) {
                                                                    ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.ll_user_layout);
                                                                    if (constraintLayout3 != null) {
                                                                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_achievement_list);
                                                                        if (recyclerView != null) {
                                                                            TextView textView2 = (TextView) view.findViewById(R.id.tv_first_name);
                                                                            if (textView2 != null) {
                                                                                TextView textView3 = (TextView) view.findViewById(R.id.tv_first_unit);
                                                                                if (textView3 != null) {
                                                                                    TextView textView4 = (TextView) view.findViewById(R.id.tv_live_stream_date);
                                                                                    if (textView4 != null) {
                                                                                        TextView textView5 = (TextView) view.findViewById(R.id.tv_second_name);
                                                                                        if (textView5 != null) {
                                                                                            TextView textView6 = (TextView) view.findViewById(R.id.tv_second_unit);
                                                                                            if (textView6 != null) {
                                                                                                TextView textView7 = (TextView) view.findViewById(R.id.tv_third_name);
                                                                                                if (textView7 != null) {
                                                                                                    TextView textView8 = (TextView) view.findViewById(R.id.tv_third_unit);
                                                                                                    if (textView8 != null) {
                                                                                                        TextView textView9 = (TextView) view.findViewById(R.id.tv_title);
                                                                                                        if (textView9 != null) {
                                                                                                            return new DialogShareAchievementBinding((ConstraintLayout) view, checkBox, textView, findViewById, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, shapeableImageView, shapeableImageView2, shapeableImageView3, findViewById2, constraintLayout, constraintLayout2, constraintLayout3, recyclerView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9);
                                                                                                        }
                                                                                                        str = "tvTitle";
                                                                                                    } else {
                                                                                                        str = "tvThirdUnit";
                                                                                                    }
                                                                                                } else {
                                                                                                    str = "tvThirdName";
                                                                                                }
                                                                                            } else {
                                                                                                str = "tvSecondUnit";
                                                                                            }
                                                                                        } else {
                                                                                            str = "tvSecondName";
                                                                                        }
                                                                                    } else {
                                                                                        str = "tvLiveStreamDate";
                                                                                    }
                                                                                } else {
                                                                                    str = "tvFirstUnit";
                                                                                }
                                                                            } else {
                                                                                str = "tvFirstName";
                                                                            }
                                                                        } else {
                                                                            str = "rvAchievementList";
                                                                        }
                                                                    } else {
                                                                        str = "llUserLayout";
                                                                    }
                                                                } else {
                                                                    str = "llDialogView";
                                                                }
                                                            } else {
                                                                str = "llContentView";
                                                            }
                                                        } else {
                                                            str = "lineCenter";
                                                        }
                                                    } else {
                                                        str = "imgUser3";
                                                    }
                                                } else {
                                                    str = "imgUser2";
                                                }
                                            } else {
                                                str = "imgUser1";
                                            }
                                        } else {
                                            str = "imgThanksGiving";
                                        }
                                    } else {
                                        str = "imgPodiumCover";
                                    }
                                } else {
                                    str = "imgPodium3";
                                }
                            } else {
                                str = "imgPodium2";
                            }
                        } else {
                            str = "imgPodium1";
                        }
                    } else {
                        str = "imgCelebration";
                    }
                } else {
                    str = "coverView";
                }
            } else {
                str = "btnToCheck";
            }
        } else {
            str = "btnPostFeed";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.z;
    }
}
