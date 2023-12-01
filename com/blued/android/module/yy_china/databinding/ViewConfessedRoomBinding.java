package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;
import com.google.android.material.imageview.ShapeableImageView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewConfessedRoomBinding.class */
public final class ViewConfessedRoomBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f16846a;
    public final ShapeableImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f16847c;
    public final ShapeableImageView d;
    public final ImageView e;
    public final TextView f;
    private final ConstraintLayout g;

    private ViewConfessedRoomBinding(ConstraintLayout constraintLayout, ImageView imageView, ShapeableImageView shapeableImageView, ImageView imageView2, ShapeableImageView shapeableImageView2, ImageView imageView3, TextView textView) {
        this.g = constraintLayout;
        this.f16846a = imageView;
        this.b = shapeableImageView;
        this.f16847c = imageView2;
        this.d = shapeableImageView2;
        this.e = imageView3;
        this.f = textView;
    }

    public static ViewConfessedRoomBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_confessed_room, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ViewConfessedRoomBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv);
        if (imageView != null) {
            ShapeableImageView shapeableImageView = (ShapeableImageView) view.findViewById(R.id.iv_user_1);
            if (shapeableImageView != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_user_1_tag);
                if (imageView2 != null) {
                    ShapeableImageView shapeableImageView2 = (ShapeableImageView) view.findViewById(R.id.iv_user_2);
                    if (shapeableImageView2 != null) {
                        ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_user_2_tag);
                        if (imageView3 != null) {
                            TextView textView = (TextView) view.findViewById(R.id.tv_time);
                            if (textView != null) {
                                return new ViewConfessedRoomBinding((ConstraintLayout) view, imageView, shapeableImageView, imageView2, shapeableImageView2, imageView3, textView);
                            }
                            str = "tvTime";
                        } else {
                            str = "ivUser2Tag";
                        }
                    } else {
                        str = "ivUser2";
                    }
                } else {
                    str = "ivUser1Tag";
                }
            } else {
                str = "ivUser1";
            }
        } else {
            str = "iv";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.g;
    }
}
