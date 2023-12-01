package com.blued.login.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.CommonEdittextView;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.login.R;

/* loaded from: source-7206380-dex2jar.jar:com/blued/login/databinding/FmFinishProfile1Binding.class */
public final class FmFinishProfile1Binding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final CommonEdittextView f6905a;
    public final ImageView b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f6906c;
    public final RelativeLayout d;
    public final CommonTopTitleNoTrans e;
    public final TextView f;
    public final ShapeTextView g;
    public final TextView h;
    private final ConstraintLayout i;

    private FmFinishProfile1Binding(ConstraintLayout constraintLayout, CommonEdittextView commonEdittextView, ImageView imageView, ImageView imageView2, RelativeLayout relativeLayout, CommonTopTitleNoTrans commonTopTitleNoTrans, TextView textView, ShapeTextView shapeTextView, TextView textView2) {
        this.i = constraintLayout;
        this.f6905a = commonEdittextView;
        this.b = imageView;
        this.f6906c = imageView2;
        this.d = relativeLayout;
        this.e = commonTopTitleNoTrans;
        this.f = textView;
        this.g = shapeTextView;
        this.h = textView2;
    }

    public static FmFinishProfile1Binding a(View view) {
        String str;
        CommonEdittextView findViewById = view.findViewById(R.id.et_nick);
        if (findViewById != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_camera);
            if (imageView != null) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_head);
                if (imageView2 != null) {
                    RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_head);
                    if (relativeLayout != null) {
                        CommonTopTitleNoTrans findViewById2 = view.findViewById(R.id.title);
                        if (findViewById2 != null) {
                            TextView textView = (TextView) view.findViewById(R.id.tv_hint);
                            if (textView != null) {
                                ShapeTextView findViewById3 = view.findViewById(R.id.tv_next);
                                if (findViewById3 != null) {
                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_nick_hint);
                                    if (textView2 != null) {
                                        return new FmFinishProfile1Binding((ConstraintLayout) view, findViewById, imageView, imageView2, relativeLayout, findViewById2, textView, findViewById3, textView2);
                                    }
                                    str = "tvNickHint";
                                } else {
                                    str = "tvNext";
                                }
                            } else {
                                str = "tvHint";
                            }
                        } else {
                            str = "title";
                        }
                    } else {
                        str = "rlHead";
                    }
                } else {
                    str = "ivHead";
                }
            } else {
                str = "ivCamera";
            }
        } else {
            str = "etNick";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.i;
    }
}
