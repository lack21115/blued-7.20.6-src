package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyMoreMenuRoomBinding.class */
public final class ItemYyMoreMenuRoomBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final SquareImageView f16749a;
    public final TextView b;

    /* renamed from: c  reason: collision with root package name */
    public final ShapeTextView f16750c;
    public final TextView d;
    public final TextView e;
    private final ConstraintLayout f;

    private ItemYyMoreMenuRoomBinding(ConstraintLayout constraintLayout, SquareImageView squareImageView, TextView textView, ShapeTextView shapeTextView, TextView textView2, TextView textView3) {
        this.f = constraintLayout;
        this.f16749a = squareImageView;
        this.b = textView;
        this.f16750c = shapeTextView;
        this.d = textView2;
        this.e = textView3;
    }

    public static ItemYyMoreMenuRoomBinding a(View view) {
        String str;
        SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.iv_room);
        if (squareImageView != null) {
            TextView textView = (TextView) view.findViewById(R.id.tv_room_name);
            if (textView != null) {
                ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_type);
                if (shapeTextView != null) {
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_user_name);
                    if (textView2 != null) {
                        TextView textView3 = (TextView) view.findViewById(R.id.tv_user_num);
                        if (textView3 != null) {
                            return new ItemYyMoreMenuRoomBinding((ConstraintLayout) view, squareImageView, textView, shapeTextView, textView2, textView3);
                        }
                        str = "tvUserNum";
                    } else {
                        str = "tvUserName";
                    }
                } else {
                    str = "tvType";
                }
            } else {
                str = "tvRoomName";
            }
        } else {
            str = "ivRoom";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f;
    }
}
