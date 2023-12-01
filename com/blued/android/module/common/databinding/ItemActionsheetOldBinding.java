package com.blued.android.module.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.R;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/databinding/ItemActionsheetOldBinding.class */
public final class ItemActionsheetOldBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeLinearLayout f10731a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f10732c;
    public final ImageView d;
    public final ShapeTextView e;
    public final ImageView f;
    public final TextView g;
    private final LinearLayout h;

    private ItemActionsheetOldBinding(LinearLayout linearLayout, ShapeLinearLayout shapeLinearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ShapeTextView shapeTextView, ImageView imageView4, TextView textView) {
        this.h = linearLayout;
        this.f10731a = shapeLinearLayout;
        this.b = imageView;
        this.f10732c = imageView2;
        this.d = imageView3;
        this.e = shapeTextView;
        this.f = imageView4;
        this.g = textView;
    }

    public static ItemActionsheetOldBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_actionsheet_old, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ItemActionsheetOldBinding a(View view) {
        String str;
        ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(R.id.action_sheet);
        if (shapeLinearLayout != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.img_checked);
            if (imageView != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.img_checked_invisible);
                if (imageView2 != null) {
                    ImageView imageView3 = (ImageView) view.findViewById(R.id.img_feed);
                    if (imageView3 != null) {
                        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.img_red_dot);
                        if (shapeTextView != null) {
                            ImageView imageView4 = (ImageView) view.findViewById(R.id.img_vip_icon);
                            if (imageView4 != null) {
                                TextView textView = (TextView) view.findViewById(R.id.tv_text);
                                if (textView != null) {
                                    return new ItemActionsheetOldBinding((LinearLayout) view, shapeLinearLayout, imageView, imageView2, imageView3, shapeTextView, imageView4, textView);
                                }
                                str = "tvText";
                            } else {
                                str = "imgVipIcon";
                            }
                        } else {
                            str = "imgRedDot";
                        }
                    } else {
                        str = "imgFeed";
                    }
                } else {
                    str = "imgCheckedInvisible";
                }
            } else {
                str = "imgChecked";
            }
        } else {
            str = "actionSheet";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.h;
    }
}
