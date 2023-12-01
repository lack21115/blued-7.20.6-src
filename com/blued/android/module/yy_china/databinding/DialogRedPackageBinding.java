package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogRedPackageBinding.class */
public final class DialogRedPackageBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeTextView f16383a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ConstraintLayout f16384c;
    public final View d;
    public final ImageView e;
    public final ImageView f;
    public final RecyclerView g;
    public final TextView h;
    private final ConstraintLayout i;

    private DialogRedPackageBinding(ConstraintLayout constraintLayout, ShapeTextView shapeTextView, ImageView imageView, ConstraintLayout constraintLayout2, View view, ImageView imageView2, ImageView imageView3, RecyclerView recyclerView, TextView textView) {
        this.i = constraintLayout;
        this.f16383a = shapeTextView;
        this.b = imageView;
        this.f16384c = constraintLayout2;
        this.d = view;
        this.e = imageView2;
        this.f = imageView3;
        this.g = recyclerView;
        this.h = textView;
    }

    public static DialogRedPackageBinding a(View view) {
        String str;
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.btn_guide);
        if (shapeTextView != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.btn_pay);
            if (imageView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.content_view);
                if (constraintLayout != null) {
                    View findViewById = view.findViewById(R.id.cover_view);
                    if (findViewById != null) {
                        ImageView imageView2 = (ImageView) view.findViewById(R.id.img_back);
                        if (imageView2 != null) {
                            ImageView imageView3 = (ImageView) view.findViewById(R.id.img_title_bg);
                            if (imageView3 != null) {
                                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_package_list);
                                if (recyclerView != null) {
                                    TextView textView = (TextView) view.findViewById(R.id.tv_notice_text);
                                    if (textView != null) {
                                        return new DialogRedPackageBinding((ConstraintLayout) view, shapeTextView, imageView, constraintLayout, findViewById, imageView2, imageView3, recyclerView, textView);
                                    }
                                    str = "tvNoticeText";
                                } else {
                                    str = "rvPackageList";
                                }
                            } else {
                                str = "imgTitleBg";
                            }
                        } else {
                            str = "imgBack";
                        }
                    } else {
                        str = "coverView";
                    }
                } else {
                    str = "contentView";
                }
            } else {
                str = "btnPay";
            }
        } else {
            str = "btnGuide";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.i;
    }
}
