package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.view.YYLivingStreamView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ItemFullServiceSquareBinding.class */
public final class ItemFullServiceSquareBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f16595a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f16596c;
    public final ImageView d;
    public final ImageView e;
    public final YYLivingStreamView f;
    public final YYLivingStreamView g;
    public final TextView h;
    public final ShapeTextView i;
    private final FrameLayout j;

    private ItemFullServiceSquareBinding(FrameLayout frameLayout, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, YYLivingStreamView yYLivingStreamView, YYLivingStreamView yYLivingStreamView2, TextView textView, ShapeTextView shapeTextView) {
        this.j = frameLayout;
        this.f16595a = constraintLayout;
        this.b = imageView;
        this.f16596c = imageView2;
        this.d = imageView3;
        this.e = imageView4;
        this.f = yYLivingStreamView;
        this.g = yYLivingStreamView2;
        this.h = textView;
        this.i = shapeTextView;
    }

    public static ItemFullServiceSquareBinding a(View view) {
        String str;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.con_allgift);
        if (constraintLayout != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_all_gift);
            if (imageView != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_allgift_gift);
                if (imageView2 != null) {
                    ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_allgift_user_1);
                    if (imageView3 != null) {
                        ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_allgift_user_2);
                        if (imageView4 != null) {
                            YYLivingStreamView yYLivingStreamView = (YYLivingStreamView) view.findViewById(R.id.ll_living_tag_left);
                            if (yYLivingStreamView != null) {
                                YYLivingStreamView yYLivingStreamView2 = (YYLivingStreamView) view.findViewById(R.id.ll_living_tag_right);
                                if (yYLivingStreamView2 != null) {
                                    TextView textView = (TextView) view.findViewById(R.id.tv_allgift_info);
                                    if (textView != null) {
                                        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_bg_allgift);
                                        if (shapeTextView != null) {
                                            return new ItemFullServiceSquareBinding((FrameLayout) view, constraintLayout, imageView, imageView2, imageView3, imageView4, yYLivingStreamView, yYLivingStreamView2, textView, shapeTextView);
                                        }
                                        str = "tvBgAllgift";
                                    } else {
                                        str = "tvAllgiftInfo";
                                    }
                                } else {
                                    str = "llLivingTagRight";
                                }
                            } else {
                                str = "llLivingTagLeft";
                            }
                        } else {
                            str = "ivAllgiftUser2";
                        }
                    } else {
                        str = "ivAllgiftUser1";
                    }
                } else {
                    str = "ivAllgiftGift";
                }
            } else {
                str = "ivAllGift";
            }
        } else {
            str = "conAllgift";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public FrameLayout getRoot() {
        return this.j;
    }
}
