package com.tencent.cloud.huiyansdkface.facelight.ui.a;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.applog.tracker.Tracker;
import com.tencent.cloud.huiyansdkface.R;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/ui/a/b.class */
public abstract class b extends Fragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private LinearLayout f21995a;
    private LayoutInflater b;

    public <T> T a(int i) {
        return (T) this.f21995a.findViewById(i);
    }

    public View b(int i) {
        View inflate = this.b.inflate(i, (ViewGroup) null);
        inflate.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.f21995a.addView(inflate);
        return this.f21995a;
    }

    public int c(int i) {
        if (isAdded()) {
            return getResources().getColor(i);
        }
        WLogger.e("BaseFragment", "the faceRecordFragment is not attached to Activity");
        return 0;
    }

    public String d(int i) {
        if (isAdded()) {
            return getString(i);
        }
        WLogger.e("BaseFragment", "the faceRecordFragment is not attached to Activity");
        return "";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = layoutInflater;
        View inflate = layoutInflater.inflate(R.layout.wbcf_base_fragment_layout, viewGroup, false);
        this.f21995a = (LinearLayout) inflate.findViewById(R.id.wbcf_contain);
        q();
        return inflate;
    }

    @Override // android.app.Fragment
    public void onHiddenChanged(boolean z) {
        Tracker.onHiddenChanged(this, z);
        super.onHiddenChanged(z);
    }

    @Override // android.app.Fragment
    public void onPause() {
        Tracker.onPause(this);
        super.onPause();
    }

    @Override // android.app.Fragment
    public void onResume() {
        Tracker.onResume(this);
        super.onResume();
    }

    public abstract void q();

    @Override // android.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Tracker.setUserVisibleHint(this, z);
        super.setUserVisibleHint(z);
    }
}
