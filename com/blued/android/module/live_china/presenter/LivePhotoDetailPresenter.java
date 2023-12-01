package com.blued.android.module.live_china.presenter;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.live_china.R;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/presenter/LivePhotoDetailPresenter.class */
public class LivePhotoDetailPresenter extends MvpPresenter {
    public List<String> h;
    private LoadOptions i;

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(FragmentActivity fragmentActivity, Bundle bundle, Bundle bundle2) {
        super.a(fragmentActivity, bundle, bundle2);
        this.h = bundle.getStringArrayList("picture_url_list");
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(IFetchDataListener iFetchDataListener) {
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void b(IFetchDataListener iFetchDataListener) {
    }

    public LoadOptions m() {
        if (this.i == null) {
            int i = h().getResources().getDisplayMetrics().widthPixels;
            LoadOptions loadOptions = new LoadOptions();
            this.i = loadOptions;
            loadOptions.d = R.drawable.defaultpicture;
            this.i.b = R.drawable.defaultpicture;
            int i2 = i >> 1;
            this.i.a(i2, i2);
        }
        return this.i;
    }
}
