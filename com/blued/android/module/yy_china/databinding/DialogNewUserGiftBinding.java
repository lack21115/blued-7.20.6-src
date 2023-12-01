package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogNewUserGiftBinding.class */
public final class DialogNewUserGiftBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f16368a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f16369c;
    public final RecyclerView d;
    public final ShapeTextView e;
    private final ConstraintLayout f;

    private DialogNewUserGiftBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, ImageView imageView2, RecyclerView recyclerView, ShapeTextView shapeTextView) {
        this.f = constraintLayout;
        this.f16368a = constraintLayout2;
        this.b = imageView;
        this.f16369c = imageView2;
        this.d = recyclerView;
        this.e = shapeTextView;
    }

    public static DialogNewUserGiftBinding a(View view) {
        String str;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl);
        if (constraintLayout != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_close);
            if (imageView != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_wenh);
                if (imageView2 != null) {
                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rcv);
                    if (recyclerView != null) {
                        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv);
                        if (shapeTextView != null) {
                            return new DialogNewUserGiftBinding((ConstraintLayout) view, constraintLayout, imageView, imageView2, recyclerView, shapeTextView);
                        }
                        str = "tv";
                    } else {
                        str = "rcv";
                    }
                } else {
                    str = "ivWenh";
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
