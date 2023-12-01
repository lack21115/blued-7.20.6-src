package com.soft.blued.ui.setting.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.soft.blued.R;
import com.soft.blued.customview.adapttextview.TextSizeRaeSeekBar;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/TextSizeSettingFragment_ViewBinding.class */
public class TextSizeSettingFragment_ViewBinding implements Unbinder {
    private TextSizeSettingFragment b;

    public TextSizeSettingFragment_ViewBinding(TextSizeSettingFragment textSizeSettingFragment, View view) {
        this.b = textSizeSettingFragment;
        textSizeSettingFragment.title = (CommonTopTitleNoTrans) Utils.a(view, 2131370694, "field 'title'", CommonTopTitleNoTrans.class);
        textSizeSettingFragment.ivUserHeader = (ImageView) Utils.a(view, R.id.iv_user_header, "field 'ivUserHeader'", ImageView.class);
        textSizeSettingFragment.tvRight = (TextView) Utils.a(view, R.id.tv_right, "field 'tvRight'", TextView.class);
        textSizeSettingFragment.tvLeft = (TextView) Utils.a(view, R.id.tv_left, "field 'tvLeft'", TextView.class);
        textSizeSettingFragment.sbTextSize = (TextSizeRaeSeekBar) Utils.a(view, R.id.sb_text_size, "field 'sbTextSize'", TextSizeRaeSeekBar.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        TextSizeSettingFragment textSizeSettingFragment = this.b;
        if (textSizeSettingFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        textSizeSettingFragment.title = null;
        textSizeSettingFragment.ivUserHeader = null;
        textSizeSettingFragment.tvRight = null;
        textSizeSettingFragment.tvLeft = null;
        textSizeSettingFragment.sbTextSize = null;
    }
}
