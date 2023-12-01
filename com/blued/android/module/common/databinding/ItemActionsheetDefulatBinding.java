package com.blued.android.module.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.R;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/databinding/ItemActionsheetDefulatBinding.class */
public final class ItemActionsheetDefulatBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeConstraintLayout f10729a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f10730c;
    public final ShapeTextView d;
    public final ImageView e;
    public final TextView f;
    private final ShapeConstraintLayout g;

    private ItemActionsheetDefulatBinding(ShapeConstraintLayout shapeConstraintLayout, ShapeConstraintLayout shapeConstraintLayout2, ImageView imageView, ImageView imageView2, ShapeTextView shapeTextView, ImageView imageView3, TextView textView) {
        this.g = shapeConstraintLayout;
        this.f10729a = shapeConstraintLayout2;
        this.b = imageView;
        this.f10730c = imageView2;
        this.d = shapeTextView;
        this.e = imageView3;
        this.f = textView;
    }

    public static ItemActionsheetDefulatBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_actionsheet_defulat, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ItemActionsheetDefulatBinding a(View view) {
        String str;
        ShapeConstraintLayout shapeConstraintLayout = (ShapeConstraintLayout) view.findViewById(R.id.action_sheet);
        if (shapeConstraintLayout != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.img_left_icn);
            if (imageView != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.img_left_sub_icn);
                if (imageView2 != null) {
                    ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.img_red_dot);
                    if (shapeTextView != null) {
                        ImageView imageView3 = (ImageView) view.findViewById(R.id.img_right_icn);
                        if (imageView3 != null) {
                            TextView textView = (TextView) view.findViewById(R.id.tv_text);
                            if (textView != null) {
                                return new ItemActionsheetDefulatBinding((ShapeConstraintLayout) view, shapeConstraintLayout, imageView, imageView2, shapeTextView, imageView3, textView);
                            }
                            str = "tvText";
                        } else {
                            str = "imgRightIcn";
                        }
                    } else {
                        str = "imgRedDot";
                    }
                } else {
                    str = "imgLeftSubIcn";
                }
            } else {
                str = "imgLeftIcn";
            }
        } else {
            str = "actionSheet";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ShapeConstraintLayout getRoot() {
        return this.g;
    }
}
