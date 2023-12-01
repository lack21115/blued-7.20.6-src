package com.blued.android.module.common.utils.click;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/click/SingleItemClickProxy.class */
public class SingleItemClickProxy implements BaseQuickAdapter.OnItemClickListener {
    private BaseQuickAdapter.OnItemClickListener a;
    private long b = 0;
    private long c = 1000;
    private IClickAgain d;

    public SingleItemClickProxy(BaseQuickAdapter.OnItemClickListener onItemClickListener) {
        this.a = onItemClickListener;
    }

    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        if (System.currentTimeMillis() - this.b >= this.c) {
            this.a.onItemClick(baseQuickAdapter, view, i);
            this.b = System.currentTimeMillis();
            return;
        }
        IClickAgain iClickAgain = this.d;
        if (iClickAgain != null) {
            iClickAgain.onAgain();
        }
    }
}
