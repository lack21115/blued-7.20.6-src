package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/YyExplorationViewBinding.class */
public final class YyExplorationViewBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final CardView f16979a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f16980c;
    public final ShapeTextView d;
    private final ConstraintLayout e;

    private YyExplorationViewBinding(ConstraintLayout constraintLayout, CardView cardView, ImageView imageView, TextView textView, ShapeTextView shapeTextView) {
        this.e = constraintLayout;
        this.f16979a = cardView;
        this.b = imageView;
        this.f16980c = textView;
        this.d = shapeTextView;
    }

    public static YyExplorationViewBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.yy_exploration_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static YyExplorationViewBinding a(View view) {
        String str;
        CardView cardView = (CardView) view.findViewById(R.id.fl_img_bg);
        if (cardView != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.img_exploration);
            if (imageView != null) {
                TextView textView = (TextView) view.findViewById(R.id.tv_countdown);
                if (textView != null) {
                    ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_extra_times);
                    if (shapeTextView != null) {
                        return new YyExplorationViewBinding((ConstraintLayout) view, cardView, imageView, textView, shapeTextView);
                    }
                    str = "tvExtraTimes";
                } else {
                    str = "tvCountdown";
                }
            } else {
                str = "imgExploration";
            }
        } else {
            str = "flImgBg";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.e;
    }
}
