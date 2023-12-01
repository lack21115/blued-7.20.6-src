package com.blued.login.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.login.R;

/* loaded from: source-7206380-dex2jar.jar:com/blued/login/databinding/FmAdultIdentifyBinding.class */
public final class FmAdultIdentifyBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final CommonTopTitleNoTrans f20509a;
    public final ShapeTextView b;

    /* renamed from: c  reason: collision with root package name */
    private final LinearLayout f20510c;

    private FmAdultIdentifyBinding(LinearLayout linearLayout, CommonTopTitleNoTrans commonTopTitleNoTrans, ShapeTextView shapeTextView) {
        this.f20510c = linearLayout;
        this.f20509a = commonTopTitleNoTrans;
        this.b = shapeTextView;
    }

    public static FmAdultIdentifyBinding a(View view) {
        String str;
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) view.findViewById(R.id.title);
        if (commonTopTitleNoTrans != null) {
            ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_identify);
            if (shapeTextView != null) {
                return new FmAdultIdentifyBinding((LinearLayout) view, commonTopTitleNoTrans, shapeTextView);
            }
            str = "tvIdentify";
        } else {
            str = "title";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.f20510c;
    }
}
