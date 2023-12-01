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

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemFullServiceSquareGiftBinding.class */
public final class ItemFullServiceSquareGiftBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f16597a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f16598c;
    public final YYLivingStreamView d;
    public final ShapeTextView e;
    public final TextView f;
    public final TextView g;
    private final FrameLayout h;

    private ItemFullServiceSquareGiftBinding(FrameLayout frameLayout, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, YYLivingStreamView yYLivingStreamView, ShapeTextView shapeTextView, TextView textView, TextView textView2) {
        this.h = frameLayout;
        this.f16597a = constraintLayout;
        this.b = imageView;
        this.f16598c = imageView2;
        this.d = yYLivingStreamView;
        this.e = shapeTextView;
        this.f = textView;
        this.g = textView2;
    }

    public static ItemFullServiceSquareGiftBinding a(View view) {
        String str;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.con_gift);
        if (constraintLayout != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_gift_info);
            if (imageView != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_gift_user);
                if (imageView2 != null) {
                    YYLivingStreamView yYLivingStreamView = (YYLivingStreamView) view.findViewById(R.id.ll_living_tag);
                    if (yYLivingStreamView != null) {
                        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_bg_gift);
                        if (shapeTextView != null) {
                            TextView textView = (TextView) view.findViewById(R.id.tv_gift_info);
                            if (textView != null) {
                                TextView textView2 = (TextView) view.findViewById(R.id.tv_gift_name);
                                if (textView2 != null) {
                                    return new ItemFullServiceSquareGiftBinding((FrameLayout) view, constraintLayout, imageView, imageView2, yYLivingStreamView, shapeTextView, textView, textView2);
                                }
                                str = "tvGiftName";
                            } else {
                                str = "tvGiftInfo";
                            }
                        } else {
                            str = "tvBgGift";
                        }
                    } else {
                        str = "llLivingTag";
                    }
                } else {
                    str = "ivGiftUser";
                }
            } else {
                str = "ivGiftInfo";
            }
        } else {
            str = "conGift";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.h;
    }
}
