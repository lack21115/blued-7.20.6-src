package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.fragment.YYRankFragment;
import com.blued.android.module.yy_china.manager.YYObserverManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.observer.GiftBeansObserver;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYIncomeView.class */
public class YYIncomeView extends LinearLayout implements View.OnClickListener, GiftBeansObserver {
    private BaseYYStudioFragment a;
    private TextView b;
    private LinearLayout c;

    public YYIncomeView(Context context) {
        this(context, null);
    }

    public YYIncomeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YYIncomeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_yy_income_layout, (ViewGroup) this, true);
        this.c = (LinearLayout) findViewById(R.id.ll_income);
        this.b = (TextView) findViewById(R.id.tv_gold_count);
        this.c.setOnClickListener(this);
    }

    public void a(BaseYYStudioFragment baseYYStudioFragment) {
        this.a = baseYYStudioFragment;
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            b(b.getGiftBeans());
        }
    }

    @Override // com.blued.android.module.yy_china.observer.GiftBeansObserver
    public void b(String str) {
        Logger.e("observer", "giftObserver count: " + str);
        double a = (double) StringUtils.a(str, 0);
        this.b.setText(a > 0.0d ? CommonStringUtils.c(a) : "0");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        YYObserverManager.a().a(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.ll_income) {
            new YYRankFragment().show(this.a.getFragmentManager(), "RankListDialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        YYObserverManager.a().b(this);
    }
}
