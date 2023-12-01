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

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/databinding/ViewYyMemberGameBinding.class */
public final class ViewYyMemberGameBinding implements ViewBinding {
    public final YYBaseUserHeadView a;
    public final LinearLayout b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    private final ConstraintLayout h;

    private ViewYyMemberGameBinding(ConstraintLayout constraintLayout, YYBaseUserHeadView yYBaseUserHeadView, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.h = constraintLayout;
        this.a = yYBaseUserHeadView;
        this.b = linearLayout;
        this.c = textView;
        this.d = textView2;
        this.e = textView3;
        this.f = textView4;
        this.g = textView5;
    }

    public static ViewYyMemberGameBinding a(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_yy_member_game, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    public static ViewYyMemberGameBinding a(View view) {
        String str;
        YYBaseUserHeadView yYBaseUserHeadView = (YYBaseUserHeadView) view.findViewById(R.id.base_us_head);
        if (yYBaseUserHeadView != null) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_mic_number);
            if (linearLayout != null) {
                TextView textView = (TextView) view.findViewById(R.id.tv_active_value);
                if (textView != null) {
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_audience_index);
                    if (textView2 != null) {
                        TextView textView3 = (TextView) view.findViewById(R.id.tv_audience_name);
                        if (textView3 != null) {
                            TextView textView4 = (TextView) view.findViewById(R.id.tv_leader_election);
                            if (textView4 != null) {
                                TextView textView5 = (TextView) view.findViewById(R.id.tv_team_number);
                                if (textView5 != null) {
                                    return new ViewYyMemberGameBinding((ConstraintLayout) view, yYBaseUserHeadView, linearLayout, textView, textView2, textView3, textView4, textView5);
                                }
                                str = "tvTeamNumber";
                            } else {
                                str = "tvLeaderElection";
                            }
                        } else {
                            str = "tvAudienceName";
                        }
                    } else {
                        str = "tvAudienceIndex";
                    }
                } else {
                    str = "tvActiveValue";
                }
            } else {
                str = "llMicNumber";
            }
        } else {
            str = "baseUsHead";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* renamed from: a */
    public ConstraintLayout getRoot() {
        return this.h;
    }
}
