package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/FloatViewComingEventsBinding.class */
public final class FloatViewComingEventsBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f16463a;
    public final ShapeLinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f16464c;
    public final TextView d;
    public final TextView e;
    public final ImageView f;
    public final TextView g;
    public final TextView h;
    private final CardView i;

    private FloatViewComingEventsBinding(CardView cardView, ImageView imageView, ShapeLinearLayout shapeLinearLayout, TextView textView, TextView textView2, TextView textView3, ImageView imageView2, TextView textView4, TextView textView5) {
        this.i = cardView;
        this.f16463a = imageView;
        this.b = shapeLinearLayout;
        this.f16464c = textView;
        this.d = textView2;
        this.e = textView3;
        this.f = imageView2;
        this.g = textView4;
        this.h = textView5;
    }

    public static FloatViewComingEventsBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.float_view_coming_events, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static FloatViewComingEventsBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.btn_close);
        if (imageView != null) {
            ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(R.id.fl_content_view);
            if (shapeLinearLayout != null) {
                TextView textView = (TextView) view.findViewById(R.id.fv_theme_date);
                if (textView != null) {
                    TextView textView2 = (TextView) view.findViewById(R.id.fv_theme_name);
                    if (textView2 != null) {
                        TextView textView3 = (TextView) view.findViewById(R.id.fv_theme_time);
                        if (textView3 != null) {
                            ImageView imageView2 = (ImageView) view.findViewById(R.id.img_theme_bg);
                            if (imageView2 != null) {
                                TextView textView4 = (TextView) view.findViewById(R.id.to_read_details);
                                if (textView4 != null) {
                                    TextView textView5 = (TextView) view.findViewById(R.id.tv_theme_title);
                                    if (textView5 != null) {
                                        return new FloatViewComingEventsBinding((CardView) view, imageView, shapeLinearLayout, textView, textView2, textView3, imageView2, textView4, textView5);
                                    }
                                    str = "tvThemeTitle";
                                } else {
                                    str = "toReadDetails";
                                }
                            } else {
                                str = "imgThemeBg";
                            }
                        } else {
                            str = "fvThemeTime";
                        }
                    } else {
                        str = "fvThemeName";
                    }
                } else {
                    str = "fvThemeDate";
                }
            } else {
                str = "flContentView";
            }
        } else {
            str = "btnClose";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public CardView getRoot() {
        return this.i;
    }
}
