package com.soft.blued.ui.setting.fragment;

import android.view.View;
import android.widget.CheckedTextView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.soft.blued.R;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/BluedSkinFragment_ViewBinding.class */
public class BluedSkinFragment_ViewBinding implements Unbinder {
    private BluedSkinFragment b;

    public BluedSkinFragment_ViewBinding(BluedSkinFragment bluedSkinFragment, View view) {
        this.b = bluedSkinFragment;
        bluedSkinFragment.llTitle = (CommonTopTitleNoTrans) Utils.a(view, 2131368288, "field 'llTitle'", CommonTopTitleNoTrans.class);
        bluedSkinFragment.tbSkin = (ToggleButton) Utils.a(view, R.id.tb_skin, "field 'tbSkin'", ToggleButton.class);
        bluedSkinFragment.llSystem = (RelativeLayout) Utils.a(view, R.id.ll_system, "field 'llSystem'", RelativeLayout.class);
        bluedSkinFragment.llCustom = (TextView) Utils.a(view, 2131367724, "field 'llCustom'", TextView.class);
        bluedSkinFragment.tvNomarl = (CheckedTextView) Utils.a(view, R.id.tv_nomarl, "field 'tvNomarl'", CheckedTextView.class);
        bluedSkinFragment.tvDark = (CheckedTextView) Utils.a(view, R.id.tv_dark, "field 'tvDark'", CheckedTextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        BluedSkinFragment bluedSkinFragment = this.b;
        if (bluedSkinFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        bluedSkinFragment.llTitle = null;
        bluedSkinFragment.tbSkin = null;
        bluedSkinFragment.llSystem = null;
        bluedSkinFragment.llCustom = null;
        bluedSkinFragment.tvNomarl = null;
        bluedSkinFragment.tvDark = null;
    }
}
