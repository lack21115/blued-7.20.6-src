package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.view.YYLivingStreamView;
import com.google.android.material.imageview.ShapeableImageView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogConfessedTopBinding.class */
public final class DialogConfessedTopBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeTextView f16313a;
    public final TextView b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f16314c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final Group g;
    public final ImageView h;
    public final SquareImageView i;
    public final ShapeableImageView j;
    public final ImageView k;
    public final ShapeableImageView l;
    public final ImageView m;
    public final YYLivingStreamView n;
    public final YYLivingStreamView o;
    public final LinearLayout p;
    public final RecyclerView q;
    public final TextView r;
    public final TextView s;
    public final TextView t;
    public final TextView u;
    private final ConstraintLayout v;

    private DialogConfessedTopBinding(ConstraintLayout constraintLayout, ShapeTextView shapeTextView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, Group group, ImageView imageView, SquareImageView squareImageView, ShapeableImageView shapeableImageView, ImageView imageView2, ShapeableImageView shapeableImageView2, ImageView imageView3, YYLivingStreamView yYLivingStreamView, YYLivingStreamView yYLivingStreamView2, LinearLayout linearLayout, RecyclerView recyclerView, TextView textView6, TextView textView7, TextView textView8, TextView textView9) {
        this.v = constraintLayout;
        this.f16313a = shapeTextView;
        this.b = textView;
        this.f16314c = textView2;
        this.d = textView3;
        this.e = textView4;
        this.f = textView5;
        this.g = group;
        this.h = imageView;
        this.i = squareImageView;
        this.j = shapeableImageView;
        this.k = imageView2;
        this.l = shapeableImageView2;
        this.m = imageView3;
        this.n = yYLivingStreamView;
        this.o = yYLivingStreamView2;
        this.p = linearLayout;
        this.q = recyclerView;
        this.r = textView6;
        this.s = textView7;
        this.t = textView8;
        this.u = textView9;
    }

    public static DialogConfessedTopBinding a(View view) {
        String str;
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.bottom);
        if (shapeTextView != null) {
            TextView textView = (TextView) view.findViewById(R.id.btn_about);
            if (textView != null) {
                TextView textView2 = (TextView) view.findViewById(R.id.btn_rank);
                if (textView2 != null) {
                    TextView textView3 = (TextView) view.findViewById(R.id.btn_single);
                    if (textView3 != null) {
                        TextView textView4 = (TextView) view.findViewById(R.id.btn_to_con);
                        if (textView4 != null) {
                            TextView textView5 = (TextView) view.findViewById(R.id.btn_to_confeefed_null);
                            if (textView5 != null) {
                                Group group = (Group) view.findViewById(R.id.grp_bottom);
                                if (group != null) {
                                    ImageView imageView = (ImageView) view.findViewById(R.id.iv_bg_big);
                                    if (imageView != null) {
                                        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.iv_null);
                                        if (squareImageView != null) {
                                            ShapeableImageView shapeableImageView = (ShapeableImageView) view.findViewById(R.id.iv_user_1);
                                            if (shapeableImageView != null) {
                                                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_user_1_tag);
                                                if (imageView2 != null) {
                                                    ShapeableImageView shapeableImageView2 = (ShapeableImageView) view.findViewById(R.id.iv_user_2);
                                                    if (shapeableImageView2 != null) {
                                                        ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_user_2_tag);
                                                        if (imageView3 != null) {
                                                            YYLivingStreamView yYLivingStreamView = (YYLivingStreamView) view.findViewById(R.id.live_1);
                                                            if (yYLivingStreamView != null) {
                                                                YYLivingStreamView yYLivingStreamView2 = (YYLivingStreamView) view.findViewById(R.id.live_2);
                                                                if (yYLivingStreamView2 != null) {
                                                                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_null);
                                                                    if (linearLayout != null) {
                                                                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rec);
                                                                        if (recyclerView != null) {
                                                                            TextView textView6 = (TextView) view.findViewById(R.id.tv_mess);
                                                                            if (textView6 != null) {
                                                                                TextView textView7 = (TextView) view.findViewById(R.id.tv_my_con_name);
                                                                                if (textView7 != null) {
                                                                                    TextView textView8 = (TextView) view.findViewById(R.id.tv_my_con_num);
                                                                                    if (textView8 != null) {
                                                                                        TextView textView9 = (TextView) view.findViewById(R.id.tv_my_index);
                                                                                        if (textView9 != null) {
                                                                                            return new DialogConfessedTopBinding((ConstraintLayout) view, shapeTextView, textView, textView2, textView3, textView4, textView5, group, imageView, squareImageView, shapeableImageView, imageView2, shapeableImageView2, imageView3, yYLivingStreamView, yYLivingStreamView2, linearLayout, recyclerView, textView6, textView7, textView8, textView9);
                                                                                        }
                                                                                        str = "tvMyIndex";
                                                                                    } else {
                                                                                        str = "tvMyConNum";
                                                                                    }
                                                                                } else {
                                                                                    str = "tvMyConName";
                                                                                }
                                                                            } else {
                                                                                str = "tvMess";
                                                                            }
                                                                        } else {
                                                                            str = "rec";
                                                                        }
                                                                    } else {
                                                                        str = "llNull";
                                                                    }
                                                                } else {
                                                                    str = "live2";
                                                                }
                                                            } else {
                                                                str = "live1";
                                                            }
                                                        } else {
                                                            str = "ivUser2Tag";
                                                        }
                                                    } else {
                                                        str = "ivUser2";
                                                    }
                                                } else {
                                                    str = "ivUser1Tag";
                                                }
                                            } else {
                                                str = "ivUser1";
                                            }
                                        } else {
                                            str = "ivNull";
                                        }
                                    } else {
                                        str = "ivBgBig";
                                    }
                                } else {
                                    str = "grpBottom";
                                }
                            } else {
                                str = "btnToConfeefedNull";
                            }
                        } else {
                            str = "btnToCon";
                        }
                    } else {
                        str = "btnSingle";
                    }
                } else {
                    str = "btnRank";
                }
            } else {
                str = "btnAbout";
            }
        } else {
            str = "bottom";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.v;
    }
}
