package com.blued.android.module.yy_china.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.HollowView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/DialogYyModifyClubNameBinding.class */
public final class DialogYyModifyClubNameBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ShapeTextView f16438a;
    public final View b;

    /* renamed from: c  reason: collision with root package name */
    public final AppCompatEditText f16439c;
    public final FrameLayout d;
    public final FrameLayout e;
    public final ImageView f;
    public final ImageView g;
    public final HollowView h;
    public final TextView i;
    private final ConstraintLayout j;

    private DialogYyModifyClubNameBinding(ConstraintLayout constraintLayout, ShapeTextView shapeTextView, View view, AppCompatEditText appCompatEditText, FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView, ImageView imageView2, HollowView hollowView, TextView textView) {
        this.j = constraintLayout;
        this.f16438a = shapeTextView;
        this.b = view;
        this.f16439c = appCompatEditText;
        this.d = frameLayout;
        this.e = frameLayout2;
        this.f = imageView;
        this.g = imageView2;
        this.h = hollowView;
        this.i = textView;
    }

    public static DialogYyModifyClubNameBinding a(View view) {
        String str;
        ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.btn_submit);
        if (shapeTextView != null) {
            View findViewById = view.findViewById(R.id.cover_view);
            if (findViewById != null) {
                AppCompatEditText appCompatEditText = (AppCompatEditText) view.findViewById(R.id.et_club_name);
                if (appCompatEditText != null) {
                    FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.ff_background_view);
                    if (frameLayout != null) {
                        FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.fl_loading_view);
                        if (frameLayout2 != null) {
                            ImageView imageView = (ImageView) view.findViewById(R.id.img_go_back);
                            if (imageView != null) {
                                ImageView imageView2 = (ImageView) view.findViewById(R.id.img_notice);
                                if (imageView2 != null) {
                                    HollowView hollowView = (HollowView) view.findViewById(R.id.ll_editor_bg);
                                    if (hollowView != null) {
                                        TextView textView = (TextView) view.findViewById(R.id.tv_title_text);
                                        if (textView != null) {
                                            return new DialogYyModifyClubNameBinding((ConstraintLayout) view, shapeTextView, findViewById, appCompatEditText, frameLayout, frameLayout2, imageView, imageView2, hollowView, textView);
                                        }
                                        str = "tvTitleText";
                                    } else {
                                        str = "llEditorBg";
                                    }
                                } else {
                                    str = "imgNotice";
                                }
                            } else {
                                str = "imgGoBack";
                            }
                        } else {
                            str = "flLoadingView";
                        }
                    } else {
                        str = "ffBackgroundView";
                    }
                } else {
                    str = "etClubName";
                }
            } else {
                str = "coverView";
            }
        } else {
            str = "btnSubmit";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.j;
    }
}
