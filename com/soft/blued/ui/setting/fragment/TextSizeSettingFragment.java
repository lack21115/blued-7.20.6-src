package com.soft.blued.ui.setting.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import butterknife.BindView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.common.trace.EventTrackSettings;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.das.settings.SettingsProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.customview.adapttextview.FontAdjustTextHelper;
import com.soft.blued.customview.adapttextview.TextSizeRaeSeekBar;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/TextSizeSettingFragment.class */
public class TextSizeSettingFragment extends MvpFragment {
    @BindView
    ImageView ivUserHeader;
    @BindView
    TextSizeRaeSeekBar sbTextSize;
    @BindView
    CommonTopTitleNoTrans title;
    @BindView
    TextView tvLeft;
    @BindView
    TextView tvRight;

    public static void a(Context context) {
        TerminalActivity.d(context, TextSizeSettingFragment.class, (Bundle) null);
    }

    public void a(Bundle bundle) {
        super.a(bundle);
        this.title.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.TextSizeSettingFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                TextSizeSettingFragment.this.t();
            }
        });
        this.title.setRightClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.TextSizeSettingFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (TextSizeSettingFragment.this.sbTextSize.getProgress() != FontAdjustTextHelper.b()) {
                    EventTrackSettings.a(SettingsProtos.Event.WORD_SIZE_CHANGE, TextSizeSettingFragment.this.sbTextSize.getProgress());
                }
                FontAdjustTextHelper.b(TextSizeSettingFragment.this.sbTextSize.getProgress());
                TextSizeSettingFragment.this.t();
            }
        });
        ImageLoader.a(getFragmentActive(), UserInfo.getInstance().getLoginUserInfo().getAvatar()).b(2131237310).a(20.0f).a(this.ivUserHeader);
        this.sbTextSize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.soft.blued.ui.setting.fragment.TextSizeSettingFragment.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                float a2 = FontAdjustTextHelper.a(i);
                TextSizeSettingFragment.this.tvRight.setTextSize(a2);
                TextSizeSettingFragment.this.tvLeft.setTextSize(a2);
                TextSizeSettingFragment.this.title.setRightBtnEnable(true);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                Tracker.onStopTrackingTouch(seekBar);
            }
        });
        if (this.sbTextSize.getMax() < FontAdjustTextHelper.b()) {
            FontAdjustTextHelper.b(1);
        }
        this.sbTextSize.setProgress(FontAdjustTextHelper.b());
        this.title.setRightBtnEnable(false);
    }

    public int g() {
        return R.layout.fragment_text_size_setting;
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
