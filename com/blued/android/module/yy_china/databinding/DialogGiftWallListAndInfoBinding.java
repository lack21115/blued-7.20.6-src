package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogGiftWallListAndInfoBinding.class */
public final class DialogGiftWallListAndInfoBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeTextView f16344a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f16345c;
    public final ImageView d;
    public final RecyclerView e;
    public final ShapeConstraintLayout f;
    public final TextView g;
    private final ConstraintLayout h;

    private DialogGiftWallListAndInfoBinding(ConstraintLayout constraintLayout, ShapeTextView shapeTextView, ImageView imageView, ImageView imageView2, ImageView imageView3, RecyclerView recyclerView, ShapeConstraintLayout shapeConstraintLayout, TextView textView) {
        this.h = constraintLayout;
        this.f16344a = shapeTextView;
        this.b = imageView;
        this.f16345c = imageView2;
        this.d = imageView3;
        this.e = recyclerView;
        this.f = shapeConstraintLayout;
        this.g = textView;
    }

    public static DialogGiftWallListAndInfoBinding a(View view) {
        String str;
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.btn_gift_exhibition);
        if (shapeTextView != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_about);
            if (imageView != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_back);
                if (imageView2 != null) {
                    ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_backg);
                    if (imageView3 != null) {
                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rcv);
                        if (recyclerView != null) {
                            ShapeConstraintLayout shapeConstraintLayout = (ShapeConstraintLayout) view.findViewById(R.id.shap_con);
                            if (shapeConstraintLayout != null) {
                                TextView textView = (TextView) view.findViewById(R.id.tv_title_text);
                                if (textView != null) {
                                    return new DialogGiftWallListAndInfoBinding((ConstraintLayout) view, shapeTextView, imageView, imageView2, imageView3, recyclerView, shapeConstraintLayout, textView);
                                }
                                str = "tvTitleText";
                            } else {
                                str = "shapCon";
                            }
                        } else {
                            str = "rcv";
                        }
                    } else {
                        str = "ivBackg";
                    }
                } else {
                    str = "ivBack";
                }
            } else {
                str = "ivAbout";
            }
        } else {
            str = "btnGiftExhibition";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.h;
    }
}
