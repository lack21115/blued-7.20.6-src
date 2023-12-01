package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeRelativeLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewYyCreateSoloGiftBinding.class */
public final class ViewYyCreateSoloGiftBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeFrameLayout f16902a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f16903c;
    public final ImageView d;
    public final ShapeRelativeLayout e;
    public final ShapeRelativeLayout f;
    public final ShapeTextView g;
    public final TextView h;
    public final TextView i;
    private final LinearLayout j;

    private ViewYyCreateSoloGiftBinding(LinearLayout linearLayout, ShapeFrameLayout shapeFrameLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ShapeRelativeLayout shapeRelativeLayout, ShapeRelativeLayout shapeRelativeLayout2, ShapeTextView shapeTextView, TextView textView, TextView textView2) {
        this.j = linearLayout;
        this.f16902a = shapeFrameLayout;
        this.b = imageView;
        this.f16903c = imageView2;
        this.d = imageView3;
        this.e = shapeRelativeLayout;
        this.f = shapeRelativeLayout2;
        this.g = shapeTextView;
        this.h = textView;
        this.i = textView2;
    }

    public static ViewYyCreateSoloGiftBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_yy_create_solo_gift, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ViewYyCreateSoloGiftBinding a(View view) {
        String str;
        ShapeFrameLayout shapeFrameLayout = (ShapeFrameLayout) view.findViewById(R.id.fl_cover_view);
        if (shapeFrameLayout != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_add_gift);
            if (imageView != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_delete_gift);
                if (imageView2 != null) {
                    ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_gift_icon);
                    if (imageView3 != null) {
                        ShapeRelativeLayout shapeRelativeLayout = (ShapeRelativeLayout) view.findViewById(R.id.rl_gift_view);
                        if (shapeRelativeLayout != null) {
                            ShapeRelativeLayout shapeRelativeLayout2 = (ShapeRelativeLayout) view.findViewById(R.id.rl_item_view);
                            if (shapeRelativeLayout2 != null) {
                                ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_create_wish);
                                if (shapeTextView != null) {
                                    TextView textView = (TextView) view.findViewById(R.id.tv_gift_name);
                                    if (textView != null) {
                                        TextView textView2 = (TextView) view.findViewById(R.id.tv_gift_notice);
                                        if (textView2 != null) {
                                            return new ViewYyCreateSoloGiftBinding((LinearLayout) view, shapeFrameLayout, imageView, imageView2, imageView3, shapeRelativeLayout, shapeRelativeLayout2, shapeTextView, textView, textView2);
                                        }
                                        str = "tvGiftNotice";
                                    } else {
                                        str = "tvGiftName";
                                    }
                                } else {
                                    str = "tvCreateWish";
                                }
                            } else {
                                str = "rlItemView";
                            }
                        } else {
                            str = "rlGiftView";
                        }
                    } else {
                        str = "ivGiftIcon";
                    }
                } else {
                    str = "ivDeleteGift";
                }
            } else {
                str = "ivAddGift";
            }
        } else {
            str = "flCoverView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.j;
    }
}
