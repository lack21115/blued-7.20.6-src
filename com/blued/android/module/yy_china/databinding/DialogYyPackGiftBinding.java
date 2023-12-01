package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.ObservableScrollView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogYyPackGiftBinding.class */
public final class DialogYyPackGiftBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeTextView f16446a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f16447c;
    public final CardView d;
    public final ImageView e;
    public final ImageView f;
    public final ImageView g;
    public final ImageView h;
    public final ImageView i;
    public final ImageView j;
    public final RecyclerView k;
    public final RecyclerView l;
    public final RecyclerView m;
    public final ObservableScrollView n;
    public final TextView o;
    public final TextView p;
    public final TextView q;
    public final TextView r;
    private final ConstraintLayout s;

    private DialogYyPackGiftBinding(ConstraintLayout constraintLayout, ShapeTextView shapeTextView, ImageView imageView, TextView textView, CardView cardView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, RecyclerView recyclerView, RecyclerView recyclerView2, RecyclerView recyclerView3, ObservableScrollView observableScrollView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.s = constraintLayout;
        this.f16446a = shapeTextView;
        this.b = imageView;
        this.f16447c = textView;
        this.d = cardView;
        this.e = imageView2;
        this.f = imageView3;
        this.g = imageView4;
        this.h = imageView5;
        this.i = imageView6;
        this.j = imageView7;
        this.k = recyclerView;
        this.l = recyclerView2;
        this.m = recyclerView3;
        this.n = observableScrollView;
        this.o = textView2;
        this.p = textView3;
        this.q = textView4;
        this.r = textView5;
    }

    public static DialogYyPackGiftBinding a(View view) {
        String str;
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.bg_bottom);
        if (shapeTextView != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.bg_card_top);
            if (imageView != null) {
                TextView textView = (TextView) view.findViewById(R.id.btn_send_gift);
                if (textView != null) {
                    CardView cardView = (CardView) view.findViewById(R.id.crad);
                    if (cardView != null) {
                        ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_about);
                        if (imageView2 != null) {
                            ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_back);
                            if (imageView3 != null) {
                                ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_bg_big);
                                if (imageView4 != null) {
                                    ImageView imageView5 = (ImageView) view.findViewById(R.id.iv_bg_title);
                                    if (imageView5 != null) {
                                        ImageView imageView6 = (ImageView) view.findViewById(R.id.iv_heart);
                                        if (imageView6 != null) {
                                            ImageView imageView7 = (ImageView) view.findViewById(R.id.iv_start);
                                            if (imageView7 != null) {
                                                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rec_card);
                                                if (recyclerView != null) {
                                                    RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.rec_gift);
                                                    if (recyclerView2 != null) {
                                                        RecyclerView recyclerView3 = (RecyclerView) view.findViewById(R.id.rec_user);
                                                        if (recyclerView3 != null) {
                                                            ObservableScrollView observableScrollView = (ObservableScrollView) view.findViewById(R.id.scr);
                                                            if (observableScrollView != null) {
                                                                TextView textView2 = (TextView) view.findViewById(R.id.tv_bo_title);
                                                                if (textView2 != null) {
                                                                    TextView textView3 = (TextView) view.findViewById(R.id.tv_bo_title2);
                                                                    if (textView3 != null) {
                                                                        TextView textView4 = (TextView) view.findViewById(R.id.tv_card_info);
                                                                        if (textView4 != null) {
                                                                            TextView textView5 = (TextView) view.findViewById(R.id.tv_card_title);
                                                                            if (textView5 != null) {
                                                                                return new DialogYyPackGiftBinding((ConstraintLayout) view, shapeTextView, imageView, textView, cardView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, recyclerView, recyclerView2, recyclerView3, observableScrollView, textView2, textView3, textView4, textView5);
                                                                            }
                                                                            str = "tvCardTitle";
                                                                        } else {
                                                                            str = "tvCardInfo";
                                                                        }
                                                                    } else {
                                                                        str = "tvBoTitle2";
                                                                    }
                                                                } else {
                                                                    str = "tvBoTitle";
                                                                }
                                                            } else {
                                                                str = "scr";
                                                            }
                                                        } else {
                                                            str = "recUser";
                                                        }
                                                    } else {
                                                        str = "recGift";
                                                    }
                                                } else {
                                                    str = "recCard";
                                                }
                                            } else {
                                                str = "ivStart";
                                            }
                                        } else {
                                            str = "ivHeart";
                                        }
                                    } else {
                                        str = "ivBgTitle";
                                    }
                                } else {
                                    str = "ivBgBig";
                                }
                            } else {
                                str = "ivBack";
                            }
                        } else {
                            str = "ivAbout";
                        }
                    } else {
                        str = "crad";
                    }
                } else {
                    str = "btnSendGift";
                }
            } else {
                str = "bgCardTop";
            }
        } else {
            str = "bgBottom";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.s;
    }
}
