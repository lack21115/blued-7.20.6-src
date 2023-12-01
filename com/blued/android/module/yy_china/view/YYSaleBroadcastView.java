package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.blued.android.module.yy_china.databinding.DialogSaleBroadcastLayoutBinding;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYSaleBroadcastView.class */
public class YYSaleBroadcastView extends RelativeLayout {
    private DialogSaleBroadcastLayoutBinding a;

    public YYSaleBroadcastView(Context context) {
        this(context, null);
    }

    public YYSaleBroadcastView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YYSaleBroadcastView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        DialogSaleBroadcastLayoutBinding a = DialogSaleBroadcastLayoutBinding.a(LayoutInflater.from(context), this, true);
        this.a = a;
        a.a.setText("设置关系&底价礼物-->竞拍争夺关系-->竞拍成功-->关系升级");
    }
}
