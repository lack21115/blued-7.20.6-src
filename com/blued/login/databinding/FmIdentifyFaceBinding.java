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
    public final CommonEdittextView f20517a;
    public final CommonEdittextView b;

    /* renamed from: c  reason: collision with root package name */
    public final CommonTopTitleNoTrans f20518c;
    public final ShapeTextView d;
    private final LinearLayout e;

    private FmIdentifyFaceBinding(LinearLayout linearLayout, CommonEdittextView commonEdittextView, CommonEdittextView commonEdittextView2, CommonTopTitleNoTrans commonTopTitleNoTrans, ShapeTextView shapeTextView) {
        this.e = linearLayout;
        this.f20517a = commonEdittextView;
        this.b = commonEdittextView2;
        this.f20518c = commonTopTitleNoTrans;
        this.d = shapeTextView;
    }

    public static FmIdentifyFaceBinding a(View view) {
        String str;
        CommonEdittextView commonEdittextView = (CommonEdittextView) view.findViewById(R.id.et_card);
        if (commonEdittextView != null) {
            CommonEdittextView commonEdittextView2 = (CommonEdittextView) view.findViewById(R.id.et_name);
            if (commonEdittextView2 != null) {
                CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) view.findViewById(R.id.title);
                if (commonTopTitleNoTrans != null) {
                    ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_identify);
                    if (shapeTextView != null) {
                        return new FmIdentifyFaceBinding((LinearLayout) view, commonEdittextView, commonEdittextView2, commonTopTitleNoTrans, shapeTextView);
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
