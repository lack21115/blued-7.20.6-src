package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.ObservableScrollView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogConfessedGiftBinding.class */
public final class DialogConfessedGiftBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f16309a;
    public final TextView b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f16310c;
    public final TextView d;
    public final EditText e;
    public final ImageView f;
    public final ImageView g;
    public final ImageView h;
    public final RecyclerView i;
    public final RecyclerView j;
    public final ObservableScrollView k;
    public final ShapeTextView l;
    public final TextView m;
    public final TextView n;
    public final TextView o;
    private final ConstraintLayout p;

    private DialogConfessedGiftBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, EditText editText, ImageView imageView, ImageView imageView2, ImageView imageView3, RecyclerView recyclerView, RecyclerView recyclerView2, ObservableScrollView observableScrollView, ShapeTextView shapeTextView, TextView textView5, TextView textView6, TextView textView7) {
        this.p = constraintLayout;
        this.f16309a = textView;
        this.b = textView2;
        this.f16310c = textView3;
        this.d = textView4;
        this.e = editText;
        this.f = imageView;
        this.g = imageView2;
        this.h = imageView3;
        this.i = recyclerView;
        this.j = recyclerView2;
        this.k = observableScrollView;
        this.l = shapeTextView;
        this.m = textView5;
        this.n = textView6;
        this.o = textView7;
    }

    public static DialogConfessedGiftBinding a(View view) {
        String str;
        TextView textView = (TextView) view.findViewById(R.id.btn_about);
        if (textView != null) {
            TextView textView2 = (TextView) view.findViewById(R.id.btn_click_more);
            if (textView2 != null) {
                TextView textView3 = (TextView) view.findViewById(R.id.btn_rank);
                if (textView3 != null) {
                    TextView textView4 = (TextView) view.findViewById(R.id.btn_to);
                    if (textView4 != null) {
                        EditText editText = (EditText) view.findViewById(R.id.ed);
                        if (editText != null) {
                            ImageView imageView = (ImageView) view.findViewById(R.id.iv_bg_big);
                            if (imageView != null) {
                                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_ed);
                                if (imageView2 != null) {
                                    ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_star);
                                    if (imageView3 != null) {
                                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rec_gift);
                                        if (recyclerView != null) {
                                            RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.rec_user);
                                            if (recyclerView2 != null) {
                                                ObservableScrollView observableScrollView = (ObservableScrollView) view.findViewById(R.id.scroll);
                                                if (observableScrollView != null) {
                                                    ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.sh_bg);
                                                    if (shapeTextView != null) {
                                                        TextView textView5 = (TextView) view.findViewById(R.id.tv_title);
                                                        if (textView5 != null) {
                                                            TextView textView6 = (TextView) view.findViewById(R.id.tv_title_2);
                                                            if (textView6 != null) {
                                                                TextView textView7 = (TextView) view.findViewById(R.id.tv_title_3);
                                                                if (textView7 != null) {
                                                                    return new DialogConfessedGiftBinding((ConstraintLayout) view, textView, textView2, textView3, textView4, editText, imageView, imageView2, imageView3, recyclerView, recyclerView2, observableScrollView, shapeTextView, textView5, textView6, textView7);
                                                                }
                                                                str = "tvTitle3";
                                                            } else {
                                                                str = "tvTitle2";
                                                            }
                                                        } else {
                                                            str = "tvTitle";
                                                        }
                                                    } else {
                                                        str = "shBg";
                                                    }
                                                } else {
                                                    str = "scroll";
                                                }
                                            } else {
                                                str = "recUser";
                                            }
                                        } else {
                                            str = "recGift";
                                        }
                                    } else {
                                        str = "ivStar";
                                    }
                                } else {
                                    str = "ivEd";
                                }
                            } else {
                                str = "ivBgBig";
                            }
                        } else {
                            str = "ed";
                        }
                    } else {
                        str = "btnTo";
                    }
                } else {
                    str = "btnRank";
                }
            } else {
                str = "btnClickMore";
            }
        } else {
            str = "btnAbout";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.p;
    }
}
