package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.view.YYLivingStreamView;
import com.google.android.material.imageview.ShapeableImageView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemYyMyRelationBinding.class */
public final class ItemYyMyRelationBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f16767a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f16768c;
    public final ImageView d;
    public final ShapeableImageView e;
    public final ShapeableImageView f;
    public final YYLivingStreamView g;
    public final LinearLayout h;
    public final ShapeConstraintLayout i;
    public final ShapeTextView j;
    public final TextView k;
    public final TextView l;
    public final TextView m;
    private final ConstraintLayout n;

    private ItemYyMyRelationBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ShapeableImageView shapeableImageView, ShapeableImageView shapeableImageView2, YYLivingStreamView yYLivingStreamView, LinearLayout linearLayout, ShapeConstraintLayout shapeConstraintLayout, ShapeTextView shapeTextView, TextView textView, TextView textView2, TextView textView3) {
        this.n = constraintLayout;
        this.f16767a = imageView;
        this.b = imageView2;
        this.f16768c = imageView3;
        this.d = imageView4;
        this.e = shapeableImageView;
        this.f = shapeableImageView2;
        this.g = yYLivingStreamView;
        this.h = linearLayout;
        this.i = shapeConstraintLayout;
        this.j = shapeTextView;
        this.k = textView;
        this.l = textView2;
        this.m = textView3;
    }

    public static ItemYyMyRelationBinding a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.bg_line);
        if (imageView != null) {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_lv_1);
            if (imageView2 != null) {
                ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_lv_2);
                if (imageView3 != null) {
                    ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_room);
                    if (imageView4 != null) {
                        ShapeableImageView shapeableImageView = (ShapeableImageView) view.findViewById(R.id.iv_user_1);
                        if (shapeableImageView != null) {
                            ShapeableImageView shapeableImageView2 = (ShapeableImageView) view.findViewById(R.id.iv_user_2);
                            if (shapeableImageView2 != null) {
                                YYLivingStreamView yYLivingStreamView = (YYLivingStreamView) view.findViewById(R.id.live_user_2);
                                if (yYLivingStreamView != null) {
                                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_value);
                                    if (linearLayout != null) {
                                        ShapeConstraintLayout shapeConstraintLayout = (ShapeConstraintLayout) view.findViewById(R.id.shape_cont);
                                        if (shapeConstraintLayout != null) {
                                            ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_index);
                                            if (shapeTextView != null) {
                                                TextView textView = (TextView) view.findViewById(R.id.tv_type);
                                                if (textView != null) {
                                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_value);
                                                    if (textView2 != null) {
                                                        TextView textView3 = (TextView) view.findViewById(R.id.tv_value_type);
                                                        if (textView3 != null) {
                                                            return new ItemYyMyRelationBinding((ConstraintLayout) view, imageView, imageView2, imageView3, imageView4, shapeableImageView, shapeableImageView2, yYLivingStreamView, linearLayout, shapeConstraintLayout, shapeTextView, textView, textView2, textView3);
                                                        }
                                                        str = "tvValueType";
                                                    } else {
                                                        str = "tvValue";
                                                    }
                                                } else {
                                                    str = "tvType";
                                                }
                                            } else {
                                                str = "tvIndex";
                                            }
                                        } else {
                                            str = "shapeCont";
                                        }
                                    } else {
                                        str = "llValue";
                                    }
                                } else {
                                    str = "liveUser2";
                                }
                            } else {
                                str = "ivUser2";
                            }
                        } else {
                            str = "ivUser1";
                        }
                    } else {
                        str = "ivRoom";
                    }
                } else {
                    str = "ivLv2";
                }
            } else {
                str = "ivLv1";
            }
        } else {
            str = "bgLine";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.n;
    }
}
