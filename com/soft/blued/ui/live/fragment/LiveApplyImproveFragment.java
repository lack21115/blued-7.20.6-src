package com.soft.blued.ui.live.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.url.H5Url;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.ui.live.presenter.LiveApplyImprovePresenter;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/LiveApplyImproveFragment.class */
public class LiveApplyImproveFragment extends LiveBaseImproveFragment<LiveApplyImprovePresenter> implements View.OnClickListener {
    public static void a(Context context) {
        TerminalActivity.d(context, LiveApplyImproveFragment.class, (Bundle) null);
    }

    @Override // com.soft.blued.ui.live.fragment.LiveBaseImproveFragment
    public void a(int i, String str) {
        ((LiveApplyImprovePresenter) j()).b(i, str);
    }

    @Override // com.soft.blued.ui.live.fragment.LiveBaseImproveFragment
    public void a(Context context, String str, int i) {
        ((LiveApplyImprovePresenter) j()).a(context, str, i);
    }

    @Override // com.soft.blued.ui.live.fragment.LiveBaseImproveFragment
    public void b() {
        WebViewShowInfoFragment.show(getActivity(), H5Url.a(7), 0);
    }

    @Override // com.soft.blued.ui.live.fragment.LiveBaseImproveFragment
    public void b(String str, List list) {
        Log.i("xpp", "type:" + str);
        if ((str.hashCode() == 717989595 && str.equals("LIVE_SHOW_AGREEMENT")) ? false : true) {
            return;
        }
        WebViewShowInfoFragment.show(getContext(), H5Url.a(51), 0);
    }

    @Override // com.soft.blued.ui.live.fragment.LiveBaseImproveFragment
    public void b(boolean z) {
        ((LiveApplyImprovePresenter) j()).a(z);
    }

    @Override // com.soft.blued.ui.live.fragment.LiveBaseImproveFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() != 2131372414) {
            super.onClick(view);
        } else {
            ((LiveApplyImprovePresenter) j()).a(false);
        }
    }

    public void onResume() {
        super.onResume();
        if (this.e) {
            this.e = false;
            ((LiveApplyImprovePresenter) j()).a(false);
        }
    }
}
