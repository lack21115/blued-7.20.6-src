package com.blued.community.ui.circle.presenter;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.framework.utils.AppUtils;
import com.blued.community.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/presenter/CircleMemberPresenter.class */
public class CircleMemberPresenter extends MvpPresenter {
    private String h;
    private int i;
    private List<String> j;

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(FragmentActivity fragmentActivity, Bundle bundle, Bundle bundle2) {
        super.a(fragmentActivity, bundle, bundle2);
        if (bundle != null) {
            this.h = bundle.getString("circle_id");
            this.i = bundle.getInt("admin_level", 0);
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(IFetchDataListener iFetchDataListener) {
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void b(IFetchDataListener iFetchDataListener) {
    }

    public List<String> m() {
        if (this.j == null) {
            ArrayList arrayList = new ArrayList();
            this.j = arrayList;
            arrayList.add(AppUtils.a(R.string.circle_member_title));
            if (n()) {
                this.j.add(AppUtils.a(R.string.circle_banned_title));
            }
        }
        return this.j;
    }

    public boolean n() {
        int i = this.i;
        boolean z = true;
        if (i != 1) {
            if (i == 2) {
                return true;
            }
            z = false;
        }
        return z;
    }

    public String o() {
        if (TextUtils.isEmpty(this.h)) {
            this.h = "";
        }
        return this.h;
    }

    public int p() {
        return this.i;
    }
}
