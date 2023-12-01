package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyCreateRoomTypeBinding.class */
public final class ItemYyCreateRoomTypeBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final SquareImageView f16703a;
    public final ShapeTextView b;

    /* renamed from: c  reason: collision with root package name */
    public final ShapeTextView f16704c;
    public final ImageView d;
    private final FrameLayout e;

    private ItemYyCreateRoomTypeBinding(FrameLayout frameLayout, SquareImageView squareImageView, ShapeTextView shapeTextView, ShapeTextView shapeTextView2, ImageView imageView) {
        this.e = frameLayout;
        this.f16703a = squareImageView;
        this.b = shapeTextView;
        this.f16704c = shapeTextView2;
        this.d = imageView;
    }

    public static ItemYyCreateRoomTypeBinding a(View view) {
        String str;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.iv_sqm);
        if (squareImageView != null) {
            ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_type);
            if (shapeTextView != null) {
                ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.tv_type_tab);
                if (shapeTextView2 != null) {
                    ImageView imageView = (ImageView) view.findViewById(R.id.view_border);
                    if (imageView != null) {
                        return new ItemYyCreateRoomTypeBinding((FrameLayout) view, squareImageView, shapeTextView, shapeTextView2, imageView);
                    }
                    str = "viewBorder";
                } else {
                    str = "tvTypeTab";
                }
            } else {
                str = "tvType";
            }
        } else {
            str = "ivSqm";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.e;
    }
}
