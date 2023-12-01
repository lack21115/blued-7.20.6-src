package com.blued.login.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.CommonEdittextView;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.login.R;

/* loaded from: source-7206380-dex2jar.jar:com/blued/login/databinding/FmIdentifyFaceBinding.class */
public final class FmIdentifyFaceBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final CommonEdittextView f6911a;
    public final CommonEdittextView b;

    /* renamed from: c  reason: collision with root package name */
    public final CommonTopTitleNoTrans f6912c;
    public final ShapeTextView d;
    private final LinearLayout e;

    private FmIdentifyFaceBinding(LinearLayout linearLayout, CommonEdittextView commonEdittextView, CommonEdittextView commonEdittextView2, CommonTopTitleNoTrans commonTopTitleNoTrans, ShapeTextView shapeTextView) {
        this.e = linearLayout;
        this.f6911a = commonEdittextView;
        this.b = commonEdittextView2;
        this.f6912c = commonTopTitleNoTrans;
        this.d = shapeTextView;
    }

    public static FmIdentifyFaceBinding a(View view) {
        String str;
        CommonEdittextView findViewById = view.findViewById(R.id.et_card);
        if (findViewById != null) {
            CommonEdittextView findViewById2 = view.findViewById(R.id.et_name);
            if (findViewById2 != null) {
                CommonTopTitleNoTrans findViewById3 = view.findViewById(R.id.title);
                if (findViewById3 != null) {
                    ShapeTextView findViewById4 = view.findViewById(R.id.tv_identify);
                    if (findViewById4 != null) {
                        return new FmIdentifyFaceBinding((LinearLayout) view, findViewById, findViewById2, findViewById3, findViewById4);
                    }
                    str = "tvIdentify";
                } else {
                    str = "title";
                }
            } else {
                str = "etName";
            }
        } else {
            str = "etCard";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.e;
    }
}
