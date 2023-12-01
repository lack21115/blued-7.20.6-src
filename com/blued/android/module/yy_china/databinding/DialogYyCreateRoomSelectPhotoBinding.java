package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeRelativeLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogYyCreateRoomSelectPhotoBinding.class */
public final class DialogYyCreateRoomSelectPhotoBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final ImageView b;
    public final ImageView c;
    public final ShapeLinearLayout d;
    public final ShapeLinearLayout e;
    public final ShapeRelativeLayout f;
    public final ShapeTextView g;
    private final ConstraintLayout h;

    private DialogYyCreateRoomSelectPhotoBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, ImageView imageView2, ShapeLinearLayout shapeLinearLayout, ShapeLinearLayout shapeLinearLayout2, ShapeRelativeLayout shapeRelativeLayout, ShapeTextView shapeTextView) {
        this.h = constraintLayout;
        this.a = constraintLayout2;
        this.b = imageView;
        this.c = imageView2;
        this.d = shapeLinearLayout;
        this.e = shapeLinearLayout2;
        this.f = shapeRelativeLayout;
        this.g = shapeTextView;
    }

    public static DialogYyCreateRoomSelectPhotoBinding a(LayoutInflater layoutInflater) {
        return a(layoutInflater, null, false);
    }

    public static DialogYyCreateRoomSelectPhotoBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_yy_create_room_select_photo, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static DialogYyCreateRoomSelectPhotoBinding a(View view) {
        String str;
        ConstraintLayout findViewById = view.findViewById(R.id.cons);
        if (findViewById != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_cover);
            if (imageView != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_up_cover_close);
                if (imageView2 != null) {
                    ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) view.findViewById(R.id.ll_select_cover);
                    if (shapeLinearLayout != null) {
                        ShapeLinearLayout shapeLinearLayout2 = (ShapeLinearLayout) view.findViewById(R.id.sll_add_cover);
                        if (shapeLinearLayout2 != null) {
                            ShapeRelativeLayout shapeRelativeLayout = (ShapeRelativeLayout) view.findViewById(R.id.sll_cover);
                            if (shapeRelativeLayout != null) {
                                ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_up_cover_qd);
                                if (shapeTextView != null) {
                                    return new DialogYyCreateRoomSelectPhotoBinding((ConstraintLayout) view, findViewById, imageView, imageView2, shapeLinearLayout, shapeLinearLayout2, shapeRelativeLayout, shapeTextView);
                                }
                                str = "tvUpCoverQd";
                            } else {
                                str = "sllCover";
                            }
                        } else {
                            str = "sllAddCover";
                        }
                    } else {
                        str = "llSelectCover";
                    }
                } else {
                    str = "ivUpCoverClose";
                }
            } else {
                str = "ivCover";
            }
        } else {
            str = "cons";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.h;
    }
}
