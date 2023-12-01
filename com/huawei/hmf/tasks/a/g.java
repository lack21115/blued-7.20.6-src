package com.huawei.hmf.tasks.a;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.util.Log;
import com.bytedance.applog.tracker.Tracker;
import com.huawei.hmf.tasks.ExecuteResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hmf/tasks/a/g.class */
public final class g extends Fragment {
    private static final WeakHashMap<Activity, WeakReference<g>> b = new WeakHashMap<>();

    /* renamed from: a  reason: collision with root package name */
    private final List<WeakReference<ExecuteResult<?>>> f8762a = new ArrayList();

    private static g a(Activity activity) {
        g gVar;
        g gVar2;
        WeakReference<g> weakReference = b.get(activity);
        if (weakReference == null || weakReference.get() == null) {
            FragmentManager fragmentManager = activity.getFragmentManager();
            try {
                gVar2 = (g) fragmentManager.findFragmentByTag("com.huawei.hmf.tasks.lifecycle_fragment_tag");
                if (gVar2 == null) {
                    try {
                        gVar2 = a(fragmentManager);
                    } catch (ClassCastException e) {
                        gVar = gVar2;
                        e = e;
                        Log.e("LifecycleCallbackFrg", "found LifecycleCallbackFragment but the type do not match. " + e.getMessage());
                        return gVar;
                    }
                }
            } catch (ClassCastException e2) {
                e = e2;
                gVar = null;
            }
            try {
                b.put(activity, new WeakReference<>(gVar2));
                gVar = gVar2;
            } catch (ClassCastException e3) {
                gVar = gVar2;
                e = e3;
                Log.e("LifecycleCallbackFrg", "found LifecycleCallbackFragment but the type do not match. " + e.getMessage());
                return gVar;
            }
            return gVar;
        }
        return weakReference.get();
    }

    private static g a(FragmentManager fragmentManager) {
        g gVar;
        g gVar2;
        try {
            gVar2 = new g();
        } catch (Exception e) {
            e = e;
            gVar = null;
        }
        try {
            fragmentManager.beginTransaction().add(gVar2, "com.huawei.hmf.tasks.lifecycle_fragment_tag").commitAllowingStateLoss();
            return gVar2;
        } catch (Exception e2) {
            gVar = gVar2;
            e = e2;
            Log.e("LifecycleCallbackFrg", "create fragment failed." + e.getMessage());
            return gVar;
        }
    }

    public static void a(Activity activity, ExecuteResult executeResult) {
        g a2 = a(activity);
        if (a2 != null) {
            synchronized (a2.f8762a) {
                a2.f8762a.add(new WeakReference<>(executeResult));
            }
        }
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
    public final void onStop() {
        super.onStop();
        synchronized (this.f8762a) {
            for (WeakReference<ExecuteResult<?>> weakReference : this.f8762a) {
                ExecuteResult<?> executeResult = weakReference.get();
                if (executeResult != null) {
                    executeResult.cancel();
                }
            }
            this.f8762a.clear();
        }
    }

    @Override // android.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Tracker.setUserVisibleHint(this, z);
        super.setUserVisibleHint(z);
    }
}
