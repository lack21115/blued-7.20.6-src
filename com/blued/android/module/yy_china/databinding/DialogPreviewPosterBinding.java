package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.google.android.material.imageview.ShapeableImageView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogPreviewPosterBinding.class */
public final class DialogPreviewPosterBinding implements ViewBinding {
    public final TextView A;
    private final ConstraintLayout B;

    /* renamed from: a  reason: collision with root package name */
    public final ShapeTextView f16379a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ShapeTextView f16380c;
    public final View d;
    public final ImageView e;
    public final ImageView f;
    public final ImageView g;
    public final ImageView h;
    public final ImageView i;
    public final ImageView j;
    public final ShapeableImageView k;
    public final ShapeableImageView l;
    public final ShapeableImageView m;
    public final View n;
    public final ConstraintLayout o;
    public final ConstraintLayout p;
    public final ConstraintLayout q;
    public final RecyclerView r;
    public final TextView s;
    public final TextView t;
    public final TextView u;
    public final TextView v;
    public final TextView w;
    public final TextView x;
    public final TextView y;
    public final TextView z;

    private DialogPreviewPosterBinding(ConstraintLayout constraintLayout, ShapeTextView shapeTextView, ImageView imageView, ShapeTextView shapeTextView2, View view, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ShapeableImageView shapeableImageView, ShapeableImageView shapeableImageView2, ShapeableImageView shapeableImageView3, View view2, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9) {
        this.B = constraintLayout;
        this.f16379a = shapeTextView;
        this.b = imageView;
        this.f16380c = shapeTextView2;
        this.d = view;
        this.e = imageView2;
        this.f = imageView3;
        this.g = imageView4;
        this.h = imageView5;
        this.i = imageView6;
        this.j = imageView7;
        this.k = shapeableImageView;
        this.l = shapeableImageView2;
        this.m = shapeableImageView3;
        this.n = view2;
        this.o = constraintLayout2;
        this.p = constraintLayout3;
        this.q = constraintLayout4;
        this.r = recyclerView;
        this.s = textView;
        this.t = textView2;
        this.u = textView3;
        this.v = textView4;
        this.w = textView5;
        this.x = textView6;
        this.y = textView7;
        this.z = textView8;
        this.A = textView9;
    }

    public static DialogPreviewPosterBinding a(View view) {
        String str;
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.btn_cancel);
        if (shapeTextView != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.btn_dialog_close);
            if (imageView != null) {
                ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.btn_preview);
                if (shapeTextView2 != null) {
                    View findViewById = view.findViewById(R.id.cover_view);
                    if (findViewById != null) {
                        ImageView imageView2 = (ImageView) view.findViewById(R.id.img_celebration);
                        if (imageView2 != null) {
                            ImageView imageView3 = (ImageView) view.findViewById(R.id.img_podium_1);
                            if (imageView3 != null) {
                                ImageView imageView4 = (ImageView) view.findViewById(R.id.img_podium_2);
                                if (imageView4 != null) {
                                    ImageView imageView5 = (ImageView) view.findViewById(R.id.img_podium_3);
                                    if (imageView5 != null) {
                                        ImageView imageView6 = (ImageView) view.findViewById(R.id.img_poster);
                                        if (imageView6 != null) {
                                            ImageView imageView7 = (ImageView) view.findViewById(R.id.img_theme_type);
                                            if (imageView7 != null) {
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
                                                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.ll_poster_view);
                                                                    if (constraintLayout2 != null) {
                                                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.ll_user_layout);
                                                                        if (constraintLayout3 != null) {
                                                                            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_achievement_list);
                                                                            if (recyclerView != null) {
                                                                                TextView textView = (TextView) view.findViewById(R.id.tv_dialog_title);
                                                                                if (textView != null) {
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
                                                                                                                    return new DialogPreviewPosterBinding((ConstraintLayout) view, shapeTextView, imageView, shapeTextView2, findViewById, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, shapeableImageView, shapeableImageView2, shapeableImageView3, findViewById2, constraintLayout, constraintLayout2, constraintLayout3, recyclerView, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9);
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
                                                                                    str = "tvDialogTitle";
                                                                                }
                                                                            } else {
                                                                                str = "rvAchievementList";
                                                                            }
                                                                        } else {
                                                                            str = "llUserLayout";
                                                                        }
                                                                    } else {
                                                                        str = "llPosterView";
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
                                                str = "imgThemeType";
                                            }
                                        } else {
                                            str = "imgPoster";
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
                    str = "btnPreview";
                }
            } else {
                str = "btnDialogClose";
            }
        } else {
            str = "btnCancel";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.B;
    }
}
