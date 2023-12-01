package com.huawei.hms.common.internal;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.SparseArray;
import com.bytedance.applog.tracker.Tracker;
import com.huawei.hms.api.HuaweiApiClient;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/common/internal/AutoLifecycleFragment.class */
public class AutoLifecycleFragment extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private final SparseArray<a> f9032a = new SparseArray<>();
    private boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/common/internal/AutoLifecycleFragment$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final HuaweiApiClient f9033a;

        public a(int i, HuaweiApiClient huaweiApiClient) {
            this.f9033a = huaweiApiClient;
        }

        public void a() {
            this.f9033a.disconnect();
        }
    }

    public static AutoLifecycleFragment getInstance(Activity activity) {
        Preconditions.checkMainThread("Must be called on the main thread");
        try {
            AutoLifecycleFragment autoLifecycleFragment = (AutoLifecycleFragment) activity.getFragmentManager().findFragmentByTag("HmsAutoLifecycleFrag");
            FragmentManager fragmentManager = activity.getFragmentManager();
            AutoLifecycleFragment autoLifecycleFragment2 = autoLifecycleFragment;
            if (autoLifecycleFragment == null) {
                autoLifecycleFragment2 = new AutoLifecycleFragment();
                fragmentManager.beginTransaction().add(autoLifecycleFragment2, "HmsAutoLifecycleFrag").commitAllowingStateLoss();
                fragmentManager.executePendingTransactions();
            }
            return autoLifecycleFragment2;
        } catch (ClassCastException e) {
            throw new IllegalStateException("Fragment with tag HmsAutoLifecycleFrag is not a AutoLifecycleFragment", e);
        }
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
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

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.b = true;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f9032a.size()) {
                return;
            }
            this.f9032a.valueAt(i2).f9033a.connect((Activity) null);
            i = i2 + 1;
        }
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.b = false;
        for (int i = 0; i < this.f9032a.size(); i++) {
            this.f9032a.valueAt(i).f9033a.disconnect();
        }
    }

    @Override // android.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Tracker.setUserVisibleHint(this, z);
        super.setUserVisibleHint(z);
    }

    public void startAutoMange(int i, HuaweiApiClient huaweiApiClient) {
        Preconditions.checkNotNull(huaweiApiClient, "HuaweiApiClient instance cannot be null");
        boolean z = this.f9032a.indexOfKey(i) < 0;
        Preconditions.checkState(z, "Already managing a HuaweiApiClient with this clientId: " + i);
        this.f9032a.put(i, new a(i, huaweiApiClient));
        if (this.b) {
            huaweiApiClient.connect((Activity) null);
        }
    }

    public void stopAutoManage(int i) {
        a aVar = this.f9032a.get(i);
        this.f9032a.remove(i);
        if (aVar != null) {
            aVar.a();
        }
    }
}
