package com.soft.blued.ui.setting.fragment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import butterknife.BindView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.core.utils.skin.listener.BluedSkinLoaderListener;
import com.blued.android.core.utils.skin.listener.BluedSkinObserver;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.common.trace.EventTrackSettings;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.das.settings.SettingsProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.customview.RippleAnimationView;
import com.soft.blued.utils.BluedPreferences;
import skin.support.observe.SkinObservable;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/BluedSkinFragment.class */
public class BluedSkinFragment extends MvpFragment<MvpPresenter> implements View.OnClickListener, BluedSkinObserver {
    @BindView
    TextView llCustom;
    @BindView
    RelativeLayout llSystem;
    @BindView
    CommonTopTitleNoTrans llTitle;
    @BindView
    ToggleButton tbSkin;
    @BindView
    CheckedTextView tvDark;
    @BindView
    CheckedTextView tvNomarl;

    public static void a(Context context) {
        TerminalActivity.d(context, BluedSkinFragment.class, (Bundle) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, boolean z) {
        RippleAnimationView.a(view).a(1000L).a();
        BluedPreferences.O(z);
        if (z) {
            BluedSkinUtils.a("night.skin", new BluedSkinLoaderListener() { // from class: com.soft.blued.ui.setting.fragment.BluedSkinFragment.3
                public void a() {
                }

                public void a(String str) {
                }

                public void b() {
                }
            });
            EventTrackSettings.b(SettingsProtos.Event.DARK_MODE_BTN_CLICK, true);
            return;
        }
        BluedSkinUtils.b();
        EventTrackSettings.b(SettingsProtos.Event.DARK_MODE_BTN_CLICK, false);
    }

    private void b(boolean z) {
        this.tvNomarl.setCheckMarkDrawable(z ? null : getResources().getDrawable(R.drawable.icon_multi_choosed));
        CheckedTextView checkedTextView = this.tvDark;
        Drawable drawable = null;
        if (z) {
            drawable = getResources().getDrawable(R.drawable.icon_multi_choosed);
        }
        checkedTextView.setCheckMarkDrawable(drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        BluedPreferences.W(z);
        d(z);
    }

    private void d(boolean z) {
        if (z) {
            this.llCustom.setVisibility(8);
            this.tvDark.setVisibility(8);
            this.tvNomarl.setVisibility(8);
            return;
        }
        this.llCustom.setVisibility(0);
        this.tvDark.setVisibility(0);
        this.tvNomarl.setVisibility(0);
    }

    public void a(Bundle bundle) {
        super.a(bundle);
        this.llTitle.setCenterText(getResources().getString(R.string.blued_dark_mode));
        this.llTitle.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.BluedSkinFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                BluedSkinFragment.this.t();
            }
        });
        b(BluedPreferences.cK());
        this.tvNomarl.setOnClickListener(this);
        this.tvDark.setOnClickListener(this);
        if (Build.VERSION.SDK_INT < 29) {
            this.llSystem.setVisibility(8);
            this.llCustom.setVisibility(8);
            return;
        }
        d(BluedPreferences.dr());
        this.tbSkin.setChecked(BluedPreferences.dr());
        this.tbSkin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.soft.blued.ui.setting.fragment.BluedSkinFragment.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                Tracker.onCheckedChanged(compoundButton, z);
                if (z) {
                    BluedSkinFragment bluedSkinFragment = BluedSkinFragment.this;
                    bluedSkinFragment.a(bluedSkinFragment.llSystem, BluedSkinUtils.a(BluedSkinFragment.this.getActivity()));
                } else {
                    BluedSkinFragment bluedSkinFragment2 = BluedSkinFragment.this;
                    bluedSkinFragment2.onClick(bluedSkinFragment2.tvNomarl);
                }
                EventTrackSettings.c(SettingsProtos.Event.DARK_MODE_BTN_CLICK, z);
                BluedSkinFragment.this.c(z);
            }
        });
    }

    public void a(SkinObservable skinObservable, Object obj) {
        getActivity().findViewById(android.R.id.content).setBackgroundColor(BluedSkinUtils.a(getContext(), 2131101780));
        StatusBarHelper.a(getActivity());
        StatusBarHelper.a(getActivity(), BluedSkinUtils.a(getContext(), AppInfo.k()));
    }

    public int g() {
        return R.layout.fragment_skin_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == 2131371241) {
            b(true);
            a((View) this.tvDark, true);
            BluedPreferences.W(false);
        } else if (id != 2131372110) {
        } else {
            b(false);
            a((View) this.tvNomarl, false);
            BluedPreferences.W(false);
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        BluedSkinUtils.b(this);
    }

    public void onResume() {
        super.onResume();
        BluedSkinUtils.a(this);
    }
}
