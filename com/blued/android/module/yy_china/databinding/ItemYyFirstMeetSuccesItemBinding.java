package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.SquareImageView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyFirstMeetSuccesItemBinding.class */
public final class ItemYyFirstMeetSuccesItemBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f16716a;
    public final SquareImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final SquareImageView f16717c;
    public final TextView d;
    public final TextView e;
    public final ShapeTextView f;
    public final ShapeTextView g;
    private final ConstraintLayout h;

    private ItemYyFirstMeetSuccesItemBinding(ConstraintLayout constraintLayout, TextView textView, SquareImageView squareImageView, SquareImageView squareImageView2, TextView textView2, TextView textView3, ShapeTextView shapeTextView, ShapeTextView shapeTextView2) {
        this.h = constraintLayout;
        this.f16716a = textView;
        this.b = squareImageView;
        this.f16717c = squareImageView2;
        this.d = textView2;
        this.e = textView3;
        this.f = shapeTextView;
        this.g = shapeTextView2;
    }

    public static ItemYyFirstMeetSuccesItemBinding a(View view) {
        String str;
        TextView textView = (TextView) view.findViewById(R.id.btn_click);
        if (textView != null) {
            SquareImageView squareImageView = (SquareImageView) view.findViewById(R.id.iv);
            if (squareImageView != null) {
                SquareImageView squareImageView2 = (SquareImageView) view.findViewById(R.id.iv_user);
                if (squareImageView2 != null) {
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_mess);
                    if (textView2 != null) {
                        TextView textView3 = (TextView) view.findViewById(R.id.tv_name);
                        if (textView3 != null) {
                            ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_num);
                            if (shapeTextView != null) {
                                ShapeTextView shapeTextView2 = (ShapeTextView) view.findViewById(R.id.tv_time);
                                if (shapeTextView2 != null) {
                                    return new ItemYyFirstMeetSuccesItemBinding((ConstraintLayout) view, textView, squareImageView, squareImageView2, textView2, textView3, shapeTextView, shapeTextView2);
                                }
                                str = "tvTime";
                            } else {
                                str = "tvNum";
                            }
                        } else {
                            str = "tvName";
                        }
                    } else {
                        str = "tvMess";
                    }
                } else {
                    str = "ivUser";
                }
            } else {
                str = "iv";
            }
        } else {
            str = "btnClick";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.h;
    }
}
