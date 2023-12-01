package com.blued.login.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.FlowLayout;
import com.blued.login.R;

/* loaded from: source-7206380-dex2jar.jar:com/blued/login/databinding/FmFinishProfile3Binding.class */
public final class FmFinishProfile3Binding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f20515a;
    public final RelativeLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f20516c;
    public final FlowLayout d;
    public final CommonTopTitleNoTrans e;
    public final TextView f;
    public final ShapeTextView g;
    public final TextView h;
    private final ConstraintLayout i;

    private FmFinishProfile3Binding(ConstraintLayout constraintLayout, TextView textView, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, FlowLayout flowLayout, CommonTopTitleNoTrans commonTopTitleNoTrans, TextView textView2, ShapeTextView shapeTextView, TextView textView3) {
        this.i = constraintLayout;
        this.f20515a = textView;
        this.b = relativeLayout;
        this.f20516c = relativeLayout2;
        this.d = flowLayout;
        this.e = commonTopTitleNoTrans;
        this.f = textView2;
        this.g = shapeTextView;
        this.h = textView3;
    }

    public static FmFinishProfile3Binding a(View view) {
        String str;
        TextView textView = (TextView) view.findViewById(R.id.health_title);
        if (textView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_health);
            if (relativeLayout != null) {
                RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.rl_role);
                if (relativeLayout2 != null) {
                    FlowLayout flowLayout = (FlowLayout) view.findViewById(R.id.role_flow_layout);
                    if (flowLayout != null) {
                        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) view.findViewById(R.id.title);
                        if (commonTopTitleNoTrans != null) {
                            TextView textView2 = (TextView) view.findViewById(R.id.tv_health);
                            if (textView2 != null) {
                                ShapeTextView shapeTextView = (ShapeTextView) view.findViewById(R.id.tv_next);
                                if (shapeTextView != null) {
                                    TextView textView3 = (TextView) view.findViewById(R.id.tv_role);
                                    if (textView3 != null) {
                                        return new FmFinishProfile3Binding((ConstraintLayout) view, textView, relativeLayout, relativeLayout2, flowLayout, commonTopTitleNoTrans, textView2, shapeTextView, textView3);
                                    }
                                    str = "tvRole";
                                } else {
                                    str = "tvNext";
                                }
                            } else {
                                str = "tvHealth";
                            }
                        } else {
                            str = "title";
                        }
                    } else {
                        str = "roleFlowLayout";
                    }
                } else {
                    str = "rlRole";
                }
            } else {
                str = "rlHealth";
            }
        } else {
            str = "healthTitle";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.i;
    }
}
