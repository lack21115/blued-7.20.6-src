package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogGiftwallAboutInfoBinding.class */
public final class DialogGiftwallAboutInfoBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f16346a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ConstraintLayout f16347c;
    public final ShapeConstraintLayout d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    private final ConstraintLayout i;

    private DialogGiftwallAboutInfoBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout2, ShapeConstraintLayout shapeConstraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.i = constraintLayout;
        this.f16346a = imageView;
        this.b = imageView2;
        this.f16347c = constraintLayout2;
        this.d = shapeConstraintLayout;
        this.e = textView;
        this.f = textView2;
        this.g = textView3;
        this.h = textView4;
    }

    public static DialogGiftwallAboutInfoBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_close);
            if (imageView2 != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.sha_);
                if (constraintLayout != null) {
                    ShapeConstraintLayout shapeConstraintLayout = (ShapeConstraintLayout) view.findViewById(R.id.shap_con);
                    if (shapeConstraintLayout != null) {
                        TextView textView = (TextView) view.findViewById(R.id.tv_botto);
                        if (textView != null) {
                            TextView textView2 = (TextView) view.findViewById(R.id.tv_name);
                            if (textView2 != null) {
                                TextView textView3 = (TextView) view.findViewById(R.id.tv_type_info);
                                if (textView3 != null) {
                                    TextView textView4 = (TextView) view.findViewById(R.id.tv_type_time);
                                    if (textView4 != null) {
                                        return new DialogGiftwallAboutInfoBinding((ConstraintLayout) view, imageView, imageView2, constraintLayout, shapeConstraintLayout, textView, textView2, textView3, textView4);
                                    }
                                    str = "tvTypeTime";
                                } else {
                                    str = "tvTypeInfo";
                                }
                            } else {
                                str = "tvName";
                            }
                        } else {
                            str = "tvBotto";
                        }
                    } else {
                        str = "shapCon";
                    }
                } else {
                    str = "sha";
                }
            } else {
                str = "ivClose";
            }
        } else {
            str = "iv";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.i;
    }
}
