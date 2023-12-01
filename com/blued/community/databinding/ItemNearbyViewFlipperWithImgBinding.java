package com.blued.community.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.community.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/databinding/ItemNearbyViewFlipperWithImgBinding.class */
public final class ItemNearbyViewFlipperWithImgBinding implements ViewBinding {
    public final LinearLayout a;
    public final LinearLayout b;
    public final ImageView c;
    public final ShapeTextView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public final ViewFlipper j;
    private final CardView k;

    private ItemNearbyViewFlipperWithImgBinding(CardView cardView, LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView, ShapeTextView shapeTextView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, ViewFlipper viewFlipper) {
        this.k = cardView;
        this.a = linearLayout;
        this.b = linearLayout2;
        this.c = imageView;
        this.d = shapeTextView;
        this.e = textView;
        this.f = textView2;
        this.g = textView3;
        this.h = textView4;
        this.i = textView5;
        this.j = viewFlipper;
    }

    public static ItemNearbyViewFlipperWithImgBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static ItemNearbyViewFlipperWithImgBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_nearby_view_flipper_with_img, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ItemNearbyViewFlipperWithImgBinding a(View view) {
        String str;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.content_layout);
        if (linearLayout != null) {
            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.content_layout_1);
            if (linearLayout2 != null) {
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_bg);
                if (imageView != null) {
                    ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_btn);
                    if (shapeTextView != null) {
                        TextView textView = (TextView) view.findViewById(R.id.tv_date);
                        if (textView != null) {
                            TextView textView2 = (TextView) view.findViewById(R.id.tv_date_1);
                            if (textView2 != null) {
                                TextView textView3 = (TextView) view.findViewById(R.id.tv_desc);
                                if (textView3 != null) {
                                    TextView textView4 = (TextView) view.findViewById(R.id.tv_desc_1);
                                    if (textView4 != null) {
                                        TextView textView5 = (TextView) view.findViewById(R.id.tv_title);
                                        if (textView5 != null) {
                                            ViewFlipper viewFlipper = (ViewFlipper) view.findViewById(R.id.view_flipper);
                                            if (viewFlipper != null) {
                                                return new ItemNearbyViewFlipperWithImgBinding((CardView) view, linearLayout, linearLayout2, imageView, shapeTextView, textView, textView2, textView3, textView4, textView5, viewFlipper);
                                            }
                                            str = "viewFlipper";
                                        } else {
                                            str = "tvTitle";
                                        }
                                    } else {
                                        str = "tvDesc1";
                                    }
                                } else {
                                    str = "tvDesc";
                                }
                            } else {
                                str = "tvDate1";
                            }
                        } else {
                            str = "tvDate";
                        }
                    } else {
                        str = "tvBtn";
                    }
                } else {
                    str = "ivBg";
                }
            } else {
                str = "contentLayout1";
            }
        } else {
            str = "contentLayout";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public CardView getRoot() {
        return this.k;
    }
}
