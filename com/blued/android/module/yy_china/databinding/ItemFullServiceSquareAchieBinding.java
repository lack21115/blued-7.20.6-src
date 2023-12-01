package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.view.YYLivingStreamView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemFullServiceSquareAchieBinding.class */
public final class ItemFullServiceSquareAchieBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f16591a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f16592c;
    public final YYLivingStreamView d;
    public final TextView e;
    public final TextView f;
    public final ShapeTextView g;
    public final ShapeTextView h;
    private final FrameLayout i;

    private ItemFullServiceSquareAchieBinding(FrameLayout frameLayout, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, YYLivingStreamView yYLivingStreamView, TextView textView, TextView textView2, ShapeTextView shapeTextView, ShapeTextView shapeTextView2) {
        this.i = frameLayout;
        this.f16591a = constraintLayout;
        this.b = imageView;
        this.f16592c = imageView2;
        this.d = yYLivingStreamView;
        this.e = textView;
        this.f = textView2;
        this.g = shapeTextView;
        this.h = shapeTextView2;
    }

    public static ItemFullServiceSquareAchieBinding a(View view) {
        String str;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.con_achie);
        if (constraintLayout != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_achie_info);
            if (imageView != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_achie_user);
                if (imageView2 != null) {
                    YYLivingStreamView yYLivingStreamView = (YYLivingStreamView) view.findViewById(R.id.ll_living_tag);
                    if (yYLivingStreamView != null) {
                        TextView textView = (TextView) view.findViewById(R.id.tv_achie_info);
                        if (textView != null) {
                            TextView textView2 = (TextView) view.findViewById(R.id.tv_achie_name);
                            if (textView2 != null) {
                                ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_bg_achie);
                                if (shapeTextView != null) {
                                    ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.tv_click_achie);
                                    if (shapeTextView2 != null) {
                                        return new ItemFullServiceSquareAchieBinding((FrameLayout) view, constraintLayout, imageView, imageView2, yYLivingStreamView, textView, textView2, shapeTextView, shapeTextView2);
                                    }
                                    str = "tvClickAchie";
                                } else {
                                    str = "tvBgAchie";
                                }
                            } else {
                                str = "tvAchieName";
                            }
                        } else {
                            str = "tvAchieInfo";
                        }
                    } else {
                        str = "llLivingTag";
                    }
                } else {
                    str = "ivAchieUser";
                }
            } else {
                str = "ivAchieInfo";
            }
        } else {
            str = "conAchie";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.i;
    }
}
