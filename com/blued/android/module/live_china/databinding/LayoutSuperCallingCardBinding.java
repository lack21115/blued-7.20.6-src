package com.blued.android.module.live_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/databinding/LayoutSuperCallingCardBinding.class */
public final class LayoutSuperCallingCardBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final EditText f12113a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f12114c;
    public final ImageView d;
    public final ShapeConstraintLayout e;
    public final ShapeFrameLayout f;
    public final ShapeTextView g;
    private final LinearLayout h;

    private LayoutSuperCallingCardBinding(LinearLayout linearLayout, EditText editText, ImageView imageView, ImageView imageView2, ImageView imageView3, ShapeConstraintLayout shapeConstraintLayout, ShapeFrameLayout shapeFrameLayout, ShapeTextView shapeTextView) {
        this.h = linearLayout;
        this.f12113a = editText;
        this.b = imageView;
        this.f12114c = imageView2;
        this.d = imageView3;
        this.e = shapeConstraintLayout;
        this.f = shapeFrameLayout;
        this.g = shapeTextView;
    }

    public static LayoutSuperCallingCardBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static LayoutSuperCallingCardBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_super_calling_card, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static LayoutSuperCallingCardBinding a(View view) {
        String str;
        EditText editText = (EditText) view.findViewById(R.id.edt_input_calling_msg);
        if (editText != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_super_calling_card_icon);
            if (imageView != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_super_calling_card_tips);
                if (imageView2 != null) {
                    ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_super_calling_card_title);
                    if (imageView3 != null) {
                        ShapeConstraintLayout shapeConstraintLayout = (ShapeConstraintLayout) view.findViewById(R.id.scl_super_calling_card_top_msg);
                        if (shapeConstraintLayout != null) {
                            ShapeFrameLayout shapeFrameLayout = (ShapeFrameLayout) view.findViewById(R.id.sfl_input_calling_msg);
                            if (shapeFrameLayout != null) {
                                ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.stv_to_calling);
                                if (shapeTextView != null) {
                                    return new LayoutSuperCallingCardBinding((LinearLayout) view, editText, imageView, imageView2, imageView3, shapeConstraintLayout, shapeFrameLayout, shapeTextView);
                                }
                                str = "stvToCalling";
                            } else {
                                str = "sflInputCallingMsg";
                            }
                        } else {
                            str = "sclSuperCallingCardTopMsg";
                        }
                    } else {
                        str = "ivSuperCallingCardTitle";
                    }
                } else {
                    str = "ivSuperCallingCardTips";
                }
            } else {
                str = "ivSuperCallingCardIcon";
            }
        } else {
            str = "edtInputCallingMsg";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.h;
    }
}
