package com.soft.blued.ui.find.presenter;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.soft.blued.ui.find.manager.CallHelloManager;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/presenter/HelloOpenDialogPresenter.class */
public class HelloOpenDialogPresenter extends MvpPresenter {
    private int i;
    private int j;
    private boolean h = false;
    private boolean k = false;

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(FragmentActivity fragmentActivity, Bundle bundle, Bundle bundle2) {
        super.a(fragmentActivity, bundle, bundle2);
        if (bundle != null) {
            this.h = bundle.getBoolean("hello_open_is_buy");
            this.i = bundle.getInt("hello_open_count");
            this.j = bundle.getInt("hello_open_from");
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(IFetchDataListener iFetchDataListener) {
    }

    public void a(boolean z) {
        this.k = z;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void b(IFetchDataListener iFetchDataListener) {
    }

    public boolean m() {
        return this.h;
    }

    public int n() {
        int i = this.i;
        return i > 0 ? i : CallHelloManager.a().b().pay_count;
    }

    public int o() {
        return this.j;
    }

    public boolean p() {
        return this.k;
    }
}
