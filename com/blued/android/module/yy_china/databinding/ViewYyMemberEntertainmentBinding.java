package com.blued.android.module.yy_china.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.view.YYBaseUserHeadView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewYyMemberEntertainmentBinding.class */
public final class ViewYyMemberEntertainmentBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final YYBaseUserHeadView f16928a;
    public final LinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f16929c;
    public final TextView d;
    public final TextView e;
    private final ConstraintLayout f;

    private ViewYyMemberEntertainmentBinding(ConstraintLayout constraintLayout, YYBaseUserHeadView yYBaseUserHeadView, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3) {
        this.f = constraintLayout;
        this.f16928a = yYBaseUserHeadView;
        this.b = linearLayout;
        this.f16929c = textView;
        this.d = textView2;
        this.e = textView3;
    }

    public static ViewYyMemberEntertainmentBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_yy_member_entertainment, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ViewYyMemberEntertainmentBinding a(View view) {
        String str;
        YYBaseUserHeadView yYBaseUserHeadView = (YYBaseUserHeadView) view.findViewById(R.id.base_us_head);
        if (yYBaseUserHeadView != null) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_normal_number);
            if (linearLayout != null) {
                TextView textView = (TextView) view.findViewById(R.id.tv_audience_coin);
                if (textView != null) {
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_audience_index);
                    if (textView2 != null) {
                        TextView textView3 = (TextView) view.findViewById(R.id.tv_audience_name);
                        if (textView3 != null) {
                            return new ViewYyMemberEntertainmentBinding((ConstraintLayout) view, yYBaseUserHeadView, linearLayout, textView, textView2, textView3);
                        }
                        str = "tvAudienceName";
                    } else {
                        str = "tvAudienceIndex";
                    }
                } else {
                    str = "tvAudienceCoin";
                }
            } else {
                str = "llNormalNumber";
            }
        } else {
            str = "baseUsHead";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.f;
    }
}
