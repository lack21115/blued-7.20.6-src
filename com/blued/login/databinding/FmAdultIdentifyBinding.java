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
    public final CommonTopTitleNoTrans f6903a;
    public final ShapeTextView b;

    /* renamed from: c  reason: collision with root package name */
    private final LinearLayout f6904c;

    private FmAdultIdentifyBinding(LinearLayout linearLayout, CommonTopTitleNoTrans commonTopTitleNoTrans, ShapeTextView shapeTextView) {
        this.f6904c = linearLayout;
        this.f6903a = commonTopTitleNoTrans;
        this.b = shapeTextView;
    }

    public static FmAdultIdentifyBinding a(View view) {
        String str;
        CommonTopTitleNoTrans findViewById = view.findViewById(R.id.title);
        if (findViewById != null) {
            ShapeTextView findViewById2 = view.findViewById(R.id.tv_identify);
            if (findViewById2 != null) {
                return new FmAdultIdentifyBinding((LinearLayout) view, findViewById, findViewById2);
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
        return this.f6904c;
    }
}
