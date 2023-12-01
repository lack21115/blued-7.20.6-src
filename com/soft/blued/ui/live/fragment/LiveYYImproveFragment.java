package com.soft.blued.ui.live.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.url.H5Url;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.ui.live.presenter.LiveYYImprovePresenter;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/LiveYYImproveFragment.class */
public class LiveYYImproveFragment extends LiveBaseImproveFragment<LiveYYImprovePresenter> implements View.OnClickListener {
    public static void a(Context context) {
        TerminalActivity.d(context, LiveYYImproveFragment.class, null);
    }

    @Override // com.soft.blued.ui.live.fragment.LiveBaseImproveFragment
    public void a(int i, String str) {
        ((LiveYYImprovePresenter) j()).b(i, str);
    }

    @Override // com.soft.blued.ui.live.fragment.LiveBaseImproveFragment
    public void a(Context context, String str, int i) {
        ((LiveYYImprovePresenter) j()).a(context, str, i);
    }

    @Override // com.soft.blued.ui.live.fragment.LiveBaseImproveFragment
    public void b() {
        WebViewShowInfoFragment.show(getActivity(), H5Url.a(8), 0);
    }

    @Override // com.soft.blued.ui.live.fragment.LiveBaseImproveFragment
    public void b(String str, List list) {
        Log.i("xpp", "type:" + str);
        if ((str.hashCode() == 717989595 && str.equals("LIVE_SHOW_AGREEMENT")) ? false : true) {
            return;
        }
        WebViewShowInfoFragment.show(getContext(), H5Url.a(59), 0);
    }

    @Override // com.soft.blued.ui.live.fragment.LiveBaseImproveFragment
    public void b(boolean z) {
        ((LiveYYImprovePresenter) j()).a(z);
    }

    @Override // com.soft.blued.ui.live.fragment.LiveBaseImproveFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() != 2131372414) {
            super.onClick(view);
        } else {
            ((LiveYYImprovePresenter) j()).a(false);
        }
    }

    @Override // com.soft.blued.ui.live.fragment.LiveBaseImproveFragment, com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f31143c = getContext();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.e) {
            this.e = false;
            ((LiveYYImprovePresenter) j()).a(false);
        }
    }
}
