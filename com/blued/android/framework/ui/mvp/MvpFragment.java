package com.blued.android.framework.ui.mvp;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.R;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.lang.reflect.ParameterizedType;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/mvp/MvpFragment.class */
public abstract class MvpFragment<T extends MvpPresenter> extends BaseFragment implements MvpView {
    protected T h;
    public View i;
    protected Dialog j;
    private Unbinder k;
    private final String a = "_MVP_" + getClass().getSimpleName();
    private boolean b = false;
    private boolean c = false;
    private boolean d = false;
    private boolean e = false;
    private volatile boolean f = false;
    private boolean g = false;
    private MvpDispatcher l = null;
    private HashSet<MvpFragment<T>.ViewTask> m = new HashSet<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/mvp/MvpFragment$ViewTask.class */
    public class ViewTask implements Runnable {
        private final Runnable b;

        public ViewTask(Runnable runnable) {
            this.b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (MvpFragment.this.m) {
                MvpFragment.this.m.remove(this);
            }
            if (MvpFragment.this.f) {
                this.b.run();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.blued.android.framework.ui.mvp.MvpPresenter a(java.lang.String r5, com.blued.android.framework.ui.mvp.MemoryDataCache r6) {
        /*
            r4 = this;
            r0 = r4
            java.lang.String r0 = r0.a
            r7 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r8 = r0
            r0 = r8
            java.lang.String r1 = "onCreatePresenter, presenterId:"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r8
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            r1 = r8
            java.lang.String r1 = r1.toString()
            int r0 = android.util.Log.v(r0, r1)
            com.blued.android.framework.ui.mvp.MvpPresenterManager r0 = com.blued.android.framework.ui.mvp.MvpPresenterManager.a()
            r1 = r5
            com.blued.android.framework.ui.mvp.MvpPresenter r0 = r0.a(r1)
            r8 = r0
            r0 = r4
            java.lang.String r0 = r0.a
            r9 = r0
            r0 = r8
            if (r0 != 0) goto L41
            java.lang.String r0 = "presenter not exist, create it"
            r7 = r0
            goto L44
        L41:
            java.lang.String r0 = "presenter exist, use it"
            r7 = r0
        L44:
            r0 = r9
            r1 = r7
            int r0 = android.util.Log.v(r0, r1)
            r0 = r8
            r9 = r0
            r0 = r8
            if (r0 != 0) goto La0
            r0 = r4
            java.lang.Class r0 = r0.b()
            r9 = r0
            r0 = r8
            r7 = r0
            r0 = r9
            if (r0 == 0) goto L88
            r0 = r9
            java.lang.Object r0 = r0.newInstance()     // Catch: java.lang.Exception -> L80
            com.blued.android.framework.ui.mvp.MvpPresenter r0 = (com.blued.android.framework.ui.mvp.MvpPresenter) r0     // Catch: java.lang.Exception -> L80
            r7 = r0
            r0 = r6
            if (r0 == 0) goto L74
            r0 = r7
            r1 = r6
            r0.a(r1)     // Catch: java.lang.Exception -> L7c
        L74:
            r0 = r7
            r1 = r5
            r0.e_(r1)     // Catch: java.lang.Exception -> L7c
            goto L88
        L7c:
            r5 = move-exception
            goto L84
        L80:
            r5 = move-exception
            r0 = r8
            r7 = r0
        L84:
            r0 = r5
            r0.printStackTrace()
        L88:
            r0 = r7
            r9 = r0
            r0 = r7
            if (r0 == 0) goto La0
            com.blued.android.framework.ui.mvp.MvpPresenterManager r0 = com.blued.android.framework.ui.mvp.MvpPresenterManager.a()
            r1 = r7
            r2 = r4
            androidx.fragment.app.FragmentActivity r2 = r2.getActivity()
            androidx.lifecycle.Lifecycle r2 = r2.getLifecycle()
            r0.a(r1, r2)
            r0 = r7
            r9 = r0
        La0:
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.framework.ui.mvp.MvpFragment.a(java.lang.String, com.blued.android.framework.ui.mvp.MemoryDataCache):com.blued.android.framework.ui.mvp.MvpPresenter");
    }

    private Class<T> b() {
        try {
            if (getClass().getGenericSuperclass() instanceof ParameterizedType) {
                return (Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private void b(Runnable runnable, long j) {
        MvpFragment<T>.ViewTask viewTask = new ViewTask(runnable);
        if (0 == j) {
            AppInfo.n().post(viewTask);
        } else {
            AppInfo.n().postDelayed(viewTask, j);
        }
        synchronized (this.m) {
            this.m.add(viewTask);
        }
    }

    private boolean c() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof MvpFragment) {
            MvpFragment mvpFragment = (MvpFragment) parentFragment;
            return !mvpFragment.r() || mvpFragment.b;
        }
        return true;
    }

    private void d() {
        List<Fragment> fragments = getChildFragmentManager().getFragments();
        if (fragments.isEmpty()) {
            return;
        }
        for (Fragment fragment : fragments) {
            if (fragment instanceof MvpFragment) {
                MvpFragment mvpFragment = (MvpFragment) fragment;
                if (mvpFragment.r() && mvpFragment.b) {
                    mvpFragment.u();
                }
            }
        }
    }

    private void e() {
        try {
            this.l = (MvpDispatcher) Class.forName(getClass().getName() + "_MVP").getConstructor(new Class[0]).newInstance(new Object[0]);
            Log.d(this.a, "Loaded _MVP class and constructor.");
        } catch (Exception e) {
            this.l = null;
        }
    }

    private void v() {
        synchronized (this.m) {
            if (this.m != null) {
                Iterator<MvpFragment<T>.ViewTask> it = this.m.iterator();
                while (it.hasNext()) {
                    MvpFragment<T>.ViewTask next = it.next();
                    if (next != null) {
                        AppInfo.n().removeCallbacks(next);
                    }
                }
                this.m.clear();
            }
        }
    }

    protected String a(String str) {
        Class<T> b = b();
        if (b != null) {
            return b.getSimpleName() + BridgeUtil.UNDERLINE_STR + str;
        }
        return getSimpleName() + BridgeUtil.UNDERLINE_STR + str;
    }

    public void a(Bundle bundle) {
        this.k = ButterKnife.a(this, this.i);
    }

    public void a(Runnable runnable) {
        if (runnable != null) {
            b(runnable, 0L);
        }
    }

    public void a(Runnable runnable, long j) {
        if (runnable != null) {
            b(runnable, j);
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpView
    public void a(String str, List list) {
        MvpDispatcher mvpDispatcher = this.l;
        if (mvpDispatcher != null) {
            mvpDispatcher.a(this, str, list);
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpView
    public void a(String str, boolean z) {
        if ("_load_type_default_".equals(str)) {
            n();
        }
    }

    protected void a(boolean z) {
        Log.v(this.a, " onLoadData()");
        if (this.h != null && k()) {
            if (!this.d) {
                this.d = true;
                List<Pair<String, List>> a = this.h.a();
                if (a != null) {
                    for (Pair<String, List> pair : a) {
                        String str = this.a;
                        Log.v(str, "showDataToUI(), type:" + ((String) pair.first));
                        if (!"_internal_data_type_has_more_data_".equals(pair.first)) {
                            a((String) pair.first, (List) pair.second);
                        } else if (((Boolean) ((List) pair.second).get(0)).booleanValue()) {
                            o();
                        } else {
                            p();
                        }
                    }
                }
            }
            if (this.e || z) {
                return;
            }
            this.e = true;
            this.h.d();
        }
    }

    public void af_() {
        this.c = false;
        this.d = false;
        this.e = false;
        v();
        this.i = null;
        this.f = false;
        Dialog dialog = this.j;
        if (dialog != null && dialog.isShowing()) {
            this.j.dismiss();
        }
        Unbinder unbinder = this.k;
        if (unbinder != null) {
            unbinder.unbind();
            this.k = null;
        }
    }

    public void f() {
    }

    protected abstract int g();

    @Override // com.blued.android.framework.ui.mvp.MvpView
    public void g_(String str) {
        if ("_load_type_default_".equals(str)) {
            m();
        }
    }

    protected String h() {
        return a(String.valueOf(SystemClock.uptimeMillis()));
    }

    public T i() {
        String h = h();
        MvpPresenter a = a(h, (MemoryDataCache) null);
        Log.v(this.a, a == null ? "presenter not exist, create it" : "presenter exist, use it");
        MvpPresenter mvpPresenter = a;
        if (a != null) {
            mvpPresenter = a;
            if (a.h() != null) {
                mvpPresenter = a;
                if (!(getActivity() == a.h())) {
                    MemoryDataCache memoryDataCache = a.f;
                    mvpPresenter = a(h + "@" + getActivity().hashCode(), memoryDataCache);
                }
            }
        }
        return (T) mvpPresenter;
    }

    public T j() {
        return this.h;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpView
    public boolean k() {
        return this.f && getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpView
    public void l() {
        this.h.e();
    }

    public void m() {
        if (getFragmentActive().isActive()) {
            if (this.j == null) {
                this.j = s();
            }
            Dialog dialog = this.j;
            if (dialog != null) {
                dialog.show();
            }
        }
    }

    public void n() {
        Dialog dialog;
        if (!getFragmentActive().isActive() || (dialog = this.j) == null) {
            return;
        }
        dialog.dismiss();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpView
    public void o() {
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Log.v(this.a, " onActivityCreated()");
        this.c = true;
        u();
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.v(this.a, " onCreate()");
        f();
        e();
        T i = i();
        this.h = i;
        if (i != null) {
            i.a(getActivity(), getArguments(), bundle);
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Log.v(this.a, " onCreateView()");
        View view = this.i;
        if (view != null) {
            if (view.getParent() != null) {
                ((ViewGroup) this.i.getParent()).removeView(this.i);
            }
            return this.i;
        }
        this.i = layoutInflater.inflate(g(), viewGroup, false);
        T t = this.h;
        if (t != null) {
            t.a(getActivity(), this);
        }
        return this.i;
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onDestroy() {
        super.onDestroy();
        Log.v(this.a, " onDestroy()");
        this.g = false;
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onDestroyView() {
        super.onDestroyView();
        Log.v(this.a, " onDestroyView()");
        if (q()) {
            return;
        }
        T t = this.h;
        if (t != null) {
            t.a(this);
        }
        af_();
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        T t = this.h;
        if (t != null) {
            t.a(bundle);
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onStart() {
        super.onStart();
        u();
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onStop() {
        super.onStop();
        this.e = false;
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Log.v(this.a, " onViewCreated()");
        if (!this.f) {
            a(bundle);
            this.f = true;
        }
        if (this.g) {
            return;
        }
        this.g = true;
        T t = this.h;
        if (t != null) {
            t.a(getActivity());
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpView
    public void p() {
    }

    protected boolean q() {
        return false;
    }

    protected boolean r() {
        return false;
    }

    protected Dialog s() {
        Dialog dialog = new Dialog(getContext(), R.style.TranslucentBackground);
        dialog.setContentView(R.layout.common_loading_dialog);
        StatusBarHelper.a(dialog.getWindow());
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        return dialog;
    }

    public final void setResult(int i) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(i);
        }
    }

    public final void setResult(int i, Intent intent) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(i, intent);
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        String str = this.a;
        Log.v(str, " setUserVisibleHint() " + z);
        this.b = z;
        u();
    }

    public final void t() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    protected void u() {
        if (this.c) {
            if (!r()) {
                a(false);
            } else if (c()) {
                a(!this.b);
                d();
            }
        }
    }
}
