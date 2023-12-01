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
    public final ImageView a;
    public final ShapeableImageView b;
    public final ImageView c;
    public final ShapeableImageView d;
    public final ImageView e;
    public final TextView f;
    private final ConstraintLayout g;

    private ViewConfessedRoomBinding(ConstraintLayout constraintLayout, ImageView imageView, ShapeableImageView shapeableImageView, ImageView imageView2, ShapeableImageView shapeableImageView2, ImageView imageView3, TextView textView) {
        this.g = constraintLayout;
        this.a = imageView;
        this.b = shapeableImageView;
        this.c = imageView2;
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
            ShapeableImageView findViewById = view.findViewById(R.id.iv_user_1);
            if (findViewById != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_user_1_tag);
                if (imageView2 != null) {
                    ShapeableImageView findViewById2 = view.findViewById(R.id.iv_user_2);
                    if (findViewById2 != null) {
                        ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_user_2_tag);
                        if (imageView3 != null) {
                            TextView textView = (TextView) view.findViewById(R.id.tv_time);
                            if (textView != null) {
                                return new ViewConfessedRoomBinding((ConstraintLayout) view, imageView, findViewById, imageView2, findViewById2, imageView3, textView);
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

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.g;
    }
}
