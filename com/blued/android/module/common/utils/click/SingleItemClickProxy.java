package com.blued.android.module.common.utils.click;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/click/SingleItemClickProxy.class */
public class SingleItemClickProxy implements BaseQuickAdapter.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    private BaseQuickAdapter.OnItemClickListener f10927a;
    private long b = 0;

    /* renamed from: c  reason: collision with root package name */
    private long f10928c = 1000;
    private IClickAgain d;

    public SingleItemClickProxy(BaseQuickAdapter.OnItemClickListener onItemClickListener) {
        this.f10927a = onItemClickListener;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        if (System.currentTimeMillis() - this.b >= this.f10928c) {
            this.f10927a.onItemClick(baseQuickAdapter, view, i);
            this.b = System.currentTimeMillis();
            return;
        }
        IClickAgain iClickAgain = this.d;
        if (iClickAgain != null) {
            iClickAgain.onAgain();
        }
    }
}
