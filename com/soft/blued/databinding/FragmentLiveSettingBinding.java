package com.soft.blued.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.soft.blued.R;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/databinding/FragmentLiveSettingBinding.class */
public final class FragmentLiveSettingBinding implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RelativeLayout f28875a;
    public final ToggleButton b;

    /* renamed from: c  reason: collision with root package name */
    public final ToggleButton f28876c;
    public final ToggleButton d;
    public final ToggleButton e;
    public final ToggleButton f;
    public final ToggleButton g;
    public final CommonTopTitleNoTrans h;
    public final TextView i;
    private final LinearLayout j;

    private FragmentLiveSettingBinding(LinearLayout linearLayout, RelativeLayout relativeLayout, ToggleButton toggleButton, ToggleButton toggleButton2, ToggleButton toggleButton3, ToggleButton toggleButton4, ToggleButton toggleButton5, ToggleButton toggleButton6, CommonTopTitleNoTrans commonTopTitleNoTrans, TextView textView) {
        this.j = linearLayout;
        this.f28875a = relativeLayout;
        this.b = toggleButton;
        this.f28876c = toggleButton2;
        this.d = toggleButton3;
        this.e = toggleButton4;
        this.f = toggleButton5;
        this.g = toggleButton6;
        this.h = commonTopTitleNoTrans;
        this.i = textView;
    }

    public static FragmentLiveSettingBinding a(View view) {
        String str;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_live_privilege);
        if (relativeLayout != null) {
            ToggleButton toggleButton = (ToggleButton) view.findViewById(R.id.tglbtn_live_background_play);
            if (toggleButton != null) {
                ToggleButton toggleButton2 = (ToggleButton) view.findViewById(R.id.tglbtn_live_float_play);
                if (toggleButton2 != null) {
                    ToggleButton toggleButton3 = (ToggleButton) view.findViewById(R.id.tglbtn_live_gift_sound);
                    if (toggleButton3 != null) {
                        ToggleButton toggleButton4 = (ToggleButton) view.findViewById(R.id.tglbtn_live_gift_vibrate);
                        if (toggleButton4 != null) {
                            ToggleButton toggleButton5 = (ToggleButton) view.findViewById(R.id.tglbtn_live_join_cloaking);
                            if (toggleButton5 != null) {
                                ToggleButton toggleButton6 = (ToggleButton) view.findViewById(R.id.tglbtn_live_rank_cloaking);
                                if (toggleButton6 != null) {
                                    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) view.findViewById(2131370749);
                                    if (commonTopTitleNoTrans != null) {
                                        TextView textView = (TextView) view.findViewById(R.id.tv_live_privilege);
                                        if (textView != null) {
                                            return new FragmentLiveSettingBinding((LinearLayout) view, relativeLayout, toggleButton, toggleButton2, toggleButton3, toggleButton4, toggleButton5, toggleButton6, commonTopTitleNoTrans, textView);
                                        }
                                        str = "tvLivePrivilege";
                                    } else {
                                        str = "topTitle";
                                    }
                                } else {
                                    str = "tglbtnLiveRankCloaking";
                                }
                            } else {
                                str = "tglbtnLiveJoinCloaking";
                            }
                        } else {
                            str = "tglbtnLiveGiftVibrate";
                        }
                    } else {
                        str = "tglbtnLiveGiftSound";
                    }
                } else {
                    str = "tglbtnLiveFloatPlay";
                }
            } else {
                str = "tglbtnLiveBackgroundPlay";
            }
        } else {
            str = "rlLivePrivilege";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: a */
    public LinearLayout getRoot() {
        return this.j;
    }
}
