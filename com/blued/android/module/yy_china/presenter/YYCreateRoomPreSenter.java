package com.blued.android.module.yy_china.presenter;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.soft.blued.ui.mine.model.MineEntryInfo;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/presenter/YYCreateRoomPreSenter.class */
public final class YYCreateRoomPreSenter extends MvpPresenter {
    private String h;
    private Boolean i;
    private int j;

    public final void a(int i) {
        this.j = i;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(FragmentActivity fragmentActivity, Bundle bundle, Bundle bundle2) {
        super.a(fragmentActivity, bundle, bundle2);
        if (bundle == null) {
            return;
        }
        d(bundle.getString("data"));
        a(Boolean.valueOf(bundle.getBoolean("isShowRight")));
        a(bundle.getInt(MineEntryInfo.ColumnsExtra.TYPE_ANCHOR_LEVEL));
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(IFetchDataListener iFetchDataListener) {
    }

    public final void a(Boolean bool) {
        this.i = bool;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void b(IFetchDataListener iFetchDataListener) {
    }

    public final void d(String str) {
        this.h = str;
    }

    public final String m() {
        return this.h;
    }

    public final Boolean n() {
        return this.i;
    }

    public final int o() {
        return this.j;
    }
}
