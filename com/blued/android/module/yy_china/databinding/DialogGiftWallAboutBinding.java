package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogGiftWallAboutBinding.class */
public final class DialogGiftWallAboutBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f16342a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f16343c;
    public final ShapeConstraintLayout d;
    private final ConstraintLayout e;

    private DialogGiftWallAboutBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, RecyclerView recyclerView, ShapeConstraintLayout shapeConstraintLayout) {
        this.e = constraintLayout;
        this.f16342a = imageView;
        this.b = imageView2;
        this.f16343c = recyclerView;
        this.d = shapeConstraintLayout;
    }

    public static DialogGiftWallAboutBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_back);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_backg);
            if (imageView2 != null) {
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rcv);
                if (recyclerView != null) {
                    ShapeConstraintLayout shapeConstraintLayout = (ShapeConstraintLayout) view.findViewById(R.id.shap_con);
                    if (shapeConstraintLayout != null) {
                        return new DialogGiftWallAboutBinding((ConstraintLayout) view, imageView, imageView2, recyclerView, shapeConstraintLayout);
                    }
                    str = "shapCon";
                } else {
                    str = "rcv";
                }
            } else {
                str = "ivBackg";
            }
        } else {
            str = "ivBack";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.e;
    }
}
