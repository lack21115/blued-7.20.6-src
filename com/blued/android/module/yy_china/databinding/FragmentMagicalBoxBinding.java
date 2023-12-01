package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/FragmentMagicalBoxBinding.class */
public final class FragmentMagicalBoxBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f16475a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final View f16476c;
    public final ImageView d;
    public final ImageView e;
    public final ImageView f;
    public final ConstraintLayout g;
    public final ProgressBar h;
    public final ImageView i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final TextView m;
    public final TextView n;
    private final ConstraintLayout o;

    private FragmentMagicalBoxBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, View view, ImageView imageView3, ImageView imageView4, ImageView imageView5, ConstraintLayout constraintLayout2, ProgressBar progressBar, ImageView imageView6, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.o = constraintLayout;
        this.f16475a = imageView;
        this.b = imageView2;
        this.f16476c = view;
        this.d = imageView3;
        this.e = imageView4;
        this.f = imageView5;
        this.g = constraintLayout2;
        this.h = progressBar;
        this.i = imageView6;
        this.j = textView;
        this.k = textView2;
        this.l = textView3;
        this.m = textView4;
        this.n = textView5;
    }

    public static FragmentMagicalBoxBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.btn_box_qa);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.btn_take_prize);
            if (imageView2 != null) {
                View findViewById = view.findViewById(R.id.cover_view);
                if (findViewById != null) {
                    ImageView imageView3 = (ImageView) view.findViewById(R.id.img_coin);
                    if (imageView3 != null) {
                        ImageView imageView4 = (ImageView) view.findViewById(R.id.img_prize_box);
                        if (imageView4 != null) {
                            ImageView imageView5 = (ImageView) view.findViewById(R.id.img_prize_package);
                            if (imageView5 != null) {
                                ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.ll_flash_message);
                                if (constraintLayout != null) {
                                    ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
                                    if (progressBar != null) {
                                        ImageView imageView6 = (ImageView) view.findViewById(R.id.root_view);
                                        if (imageView6 != null) {
                                            TextView textView = (TextView) view.findViewById(R.id.tv_coin_count);
                                            if (textView != null) {
                                                TextView textView2 = (TextView) view.findViewById(R.id.tv_fall_down_count);
                                                if (textView2 != null) {
                                                    TextView textView3 = (TextView) view.findViewById(R.id.tv_prize_msg);
                                                    if (textView3 != null) {
                                                        TextView textView4 = (TextView) view.findViewById(R.id.tv_progress_bar);
                                                        if (textView4 != null) {
                                                            TextView textView5 = (TextView) view.findViewById(R.id.tv_take_prize);
                                                            if (textView5 != null) {
                                                                return new FragmentMagicalBoxBinding((ConstraintLayout) view, imageView, imageView2, findViewById, imageView3, imageView4, imageView5, constraintLayout, progressBar, imageView6, textView, textView2, textView3, textView4, textView5);
                                                            }
                                                            str = "tvTakePrize";
                                                        } else {
                                                            str = "tvProgressBar";
                                                        }
                                                    } else {
                                                        str = "tvPrizeMsg";
                                                    }
                                                } else {
                                                    str = "tvFallDownCount";
                                                }
                                            } else {
                                                str = "tvCoinCount";
                                            }
                                        } else {
                                            str = "rootView";
                                        }
                                    } else {
                                        str = "progressBar";
                                    }
                                } else {
                                    str = "llFlashMessage";
                                }
                            } else {
                                str = "imgPrizePackage";
                            }
                        } else {
                            str = "imgPrizeBox";
                        }
                    } else {
                        str = "imgCoin";
                    }
                } else {
                    str = "coverView";
                }
            } else {
                str = "btnTakePrize";
            }
        } else {
            str = "btnBoxQa";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.o;
    }
}
