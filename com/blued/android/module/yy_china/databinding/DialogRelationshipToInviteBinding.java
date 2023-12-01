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
import com.google.android.material.imageview.ShapeableImageView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogRelationshipToInviteBinding.class */
public final class DialogRelationshipToInviteBinding implements ViewBinding {
    public final ShapeTextView a;
    public final ShapeConstraintLayout b;
    public final ImageView c;
    public final ImageView d;
    public final ImageView e;
    public final ShapeableImageView f;
    public final ShapeableImageView g;
    public final RecyclerView h;
    public final RecyclerView i;
    public final TextView j;
    public final TextView k;
    private final ConstraintLayout l;

    private DialogRelationshipToInviteBinding(ConstraintLayout constraintLayout, ShapeTextView shapeTextView, ShapeConstraintLayout shapeConstraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ShapeableImageView shapeableImageView, ShapeableImageView shapeableImageView2, RecyclerView recyclerView, RecyclerView recyclerView2, TextView textView, TextView textView2) {
        this.l = constraintLayout;
        this.a = shapeTextView;
        this.b = shapeConstraintLayout;
        this.c = imageView;
        this.d = imageView2;
        this.e = imageView3;
        this.f = shapeableImageView;
        this.g = shapeableImageView2;
        this.h = recyclerView;
        this.i = recyclerView2;
        this.j = textView;
        this.k = textView2;
    }

    public static DialogRelationshipToInviteBinding a(View view) {
        String str;
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.btn_invite);
        if (shapeTextView != null) {
            ShapeConstraintLayout shapeConstraintLayout = (ShapeConstraintLayout) view.findViewById(R.id.con);
            if (shapeConstraintLayout != null) {
                ImageView imageView = (ImageView) view.findViewById(R.id.iv);
                if (imageView != null) {
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_back);
                    if (imageView2 != null) {
                        ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_close);
                        if (imageView3 != null) {
                            ShapeableImageView findViewById = view.findViewById(R.id.iv_user_1);
                            if (findViewById != null) {
                                ShapeableImageView findViewById2 = view.findViewById(R.id.iv_user_2);
                                if (findViewById2 != null) {
                                    RecyclerView findViewById3 = view.findViewById(R.id.rec_day);
                                    if (findViewById3 != null) {
                                        RecyclerView findViewById4 = view.findViewById(R.id.rec_gift);
                                        if (findViewById4 != null) {
                                            TextView textView = (TextView) view.findViewById(R.id.tv_type);
                                            if (textView != null) {
                                                TextView textView2 = (TextView) view.findViewById(R.id.tv_type_info);
                                                if (textView2 != null) {
                                                    return new DialogRelationshipToInviteBinding((ConstraintLayout) view, shapeTextView, shapeConstraintLayout, imageView, imageView2, imageView3, findViewById, findViewById2, findViewById3, findViewById4, textView, textView2);
                                                }
                                                str = "tvTypeInfo";
                                            } else {
                                                str = "tvType";
                                            }
                                        } else {
                                            str = "recGift";
                                        }
                                    } else {
                                        str = "recDay";
                                    }
                                } else {
                                    str = "ivUser2";
                                }
                            } else {
                                str = "ivUser1";
                            }
                        } else {
                            str = "ivClose";
                        }
                    } else {
                        str = "ivBack";
                    }
                } else {
                    str = "iv";
                }
            } else {
                str = "con";
            }
        } else {
            str = "btnInvite";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.l;
    }
}
