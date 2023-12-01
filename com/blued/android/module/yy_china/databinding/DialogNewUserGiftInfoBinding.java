package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogNewUserGiftInfoBinding.class */
public final class DialogNewUserGiftInfoBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f16370a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f16371c;
    public final ShapeTextView d;
    public final TextView e;
    private final ConstraintLayout f;

    private DialogNewUserGiftInfoBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, RecyclerView recyclerView, ShapeTextView shapeTextView, TextView textView) {
        this.f = constraintLayout;
        this.f16370a = constraintLayout2;
        this.b = imageView;
        this.f16371c = recyclerView;
        this.d = shapeTextView;
        this.e = textView;
    }

    public static DialogNewUserGiftInfoBinding a(View view) {
        String str;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl);
        if (constraintLayout != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_close);
            if (imageView != null) {
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rcv);
                if (recyclerView != null) {
                    ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv);
                    if (shapeTextView != null) {
                        TextView textView = (TextView) view.findViewById(R.id.tv_type);
                        if (textView != null) {
                            return new DialogNewUserGiftInfoBinding((ConstraintLayout) view, constraintLayout, imageView, recyclerView, shapeTextView, textView);
                        }
                        str = "tvType";
                    } else {
                        str = "tv";
                    }
                } else {
                    str = "rcv";
                }
            } else {
                str = "ivClose";
            }
        } else {
            str = "cl";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f;
    }
}
