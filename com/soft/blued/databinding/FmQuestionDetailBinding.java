package com.soft.blued.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/FmQuestionDetailBinding.class */
public final class FmQuestionDetailBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RelativeLayout f28759a;
    public final CommonTopTitleNoTrans b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f28760c;
    public final TextView d;
    private final ConstraintLayout e;

    private FmQuestionDetailBinding(ConstraintLayout constraintLayout, RelativeLayout relativeLayout, CommonTopTitleNoTrans commonTopTitleNoTrans, TextView textView, TextView textView2) {
        this.e = constraintLayout;
        this.f28759a = relativeLayout;
        this.b = commonTopTitleNoTrans;
        this.f28760c = textView;
        this.d = textView2;
    }

    public static FmQuestionDetailBinding a(View view) {
        String str;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.bottomView);
        if (relativeLayout != null) {
            CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) view.findViewById(2131370694);
            if (commonTopTitleNoTrans != null) {
                TextView textView = (TextView) view.findViewById(2131371186);
                if (textView != null) {
                    TextView textView2 = (TextView) view.findViewById(2131372754);
                    if (textView2 != null) {
                        return new FmQuestionDetailBinding((ConstraintLayout) view, relativeLayout, commonTopTitleNoTrans, textView, textView2);
                    }
                    str = "tvTitle";
                } else {
                    str = "tvContent";
                }
            } else {
                str = "title";
            }
        } else {
            str = "bottomView";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.e;
    }
}
