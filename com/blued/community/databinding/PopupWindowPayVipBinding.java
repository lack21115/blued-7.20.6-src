package com.blued.community.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.community.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/databinding/PopupWindowPayVipBinding.class */
public final class PopupWindowPayVipBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeLinearLayout f19063a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f19064c;
    public final TextView d;
    public final ShapeTextView e;
    public final TextView f;
    public final TextView g;
    private final ShapeLinearLayout h;

    private PopupWindowPayVipBinding(ShapeLinearLayout shapeLinearLayout, ShapeLinearLayout shapeLinearLayout2, ImageView imageView, ImageView imageView2, TextView textView, ShapeTextView shapeTextView, TextView textView2, TextView textView3) {
        this.h = shapeLinearLayout;
        this.f19063a = shapeLinearLayout2;
        this.b = imageView;
        this.f19064c = imageView2;
        this.d = textView;
        this.e = shapeTextView;
        this.f = textView2;
        this.g = textView3;
    }

    public static PopupWindowPayVipBinding a(View view) {
        String str;
        ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(R.id.content_view);
        if (shapeLinearLayout != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_close);
            if (imageView != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_popwindow_bg);
                if (imageView2 != null) {
                    TextView textView = (TextView) view.findViewById(R.id.tv_dialog_cancel);
                    if (textView != null) {
                        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_pay_vip_btn);
                        if (shapeTextView != null) {
                            TextView textView2 = (TextView) view.findViewById(R.id.tv_subtitle);
                            if (textView2 != null) {
                                TextView textView3 = (TextView) view.findViewById(R.id.tv_title);
                                if (textView3 != null) {
                                    return new PopupWindowPayVipBinding((ShapeLinearLayout) view, shapeLinearLayout, imageView, imageView2, textView, shapeTextView, textView2, textView3);
                                }
                                str = "tvTitle";
                            } else {
                                str = "tvSubtitle";
                            }
                        } else {
                            str = "tvPayVipBtn";
                        }
                    } else {
                        str = "tvDialogCancel";
                    }
                } else {
                    str = "ivPopwindowBg";
                }
            } else {
                str = "ivClose";
            }
        } else {
            str = "contentView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ShapeLinearLayout getRoot() {
        return this.h;
    }
}
