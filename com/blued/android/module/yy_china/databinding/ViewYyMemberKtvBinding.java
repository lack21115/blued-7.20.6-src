package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.view.YYBaseUserHeadView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewYyMemberKtvBinding.class */
public final class ViewYyMemberKtvBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final YYBaseUserHeadView f16932a;
    public final TextView b;

    /* renamed from: c  reason: collision with root package name */
    private final ConstraintLayout f16933c;

    private ViewYyMemberKtvBinding(ConstraintLayout constraintLayout, YYBaseUserHeadView yYBaseUserHeadView, TextView textView) {
        this.f16933c = constraintLayout;
        this.f16932a = yYBaseUserHeadView;
        this.b = textView;
    }

    public static ViewYyMemberKtvBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_yy_member_ktv, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ViewYyMemberKtvBinding a(View view) {
        String str;
        YYBaseUserHeadView yYBaseUserHeadView = (YYBaseUserHeadView) view.findViewById(R.id.base_us_head);
        if (yYBaseUserHeadView != null) {
            TextView textView = (TextView) view.findViewById(R.id.tv_audience_index);
            if (textView != null) {
                return new ViewYyMemberKtvBinding((ConstraintLayout) view, yYBaseUserHeadView, textView);
            }
            str = "tvAudienceIndex";
        } else {
            str = "baseUsHead";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f16933c;
    }
}
