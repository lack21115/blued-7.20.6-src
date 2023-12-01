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
    public final ShapeTextView a;
    public final ImageView b;
    public final ImageView c;
    public final ImageView d;
    public final RecyclerView e;
    public final ShapeConstraintLayout f;
    public final TextView g;
    private final ConstraintLayout h;

    private DialogGiftWallListAndInfoBinding(ConstraintLayout constraintLayout, ShapeTextView shapeTextView, ImageView imageView, ImageView imageView2, ImageView imageView3, RecyclerView recyclerView, ShapeConstraintLayout shapeConstraintLayout, TextView textView) {
        this.h = constraintLayout;
        this.a = shapeTextView;
        this.b = imageView;
        this.c = imageView2;
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
                        RecyclerView findViewById = view.findViewById(R.id.rcv);
                        if (findViewById != null) {
                            ShapeConstraintLayout shapeConstraintLayout = (ShapeConstraintLayout) view.findViewById(R.id.shap_con);
                            if (shapeConstraintLayout != null) {
                                TextView textView = (TextView) view.findViewById(R.id.tv_title_text);
                                if (textView != null) {
                                    return new DialogGiftWallListAndInfoBinding((ConstraintLayout) view, shapeTextView, imageView, imageView2, imageView3, findViewById, shapeConstraintLayout, textView);
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

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.h;
    }
}
