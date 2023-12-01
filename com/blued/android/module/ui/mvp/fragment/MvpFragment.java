package com.blued.android.module.ui.mvp.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewbinding.ViewBinding;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.R;
import com.blued.android.framework.utils.ClassUtils;
import com.blued.android.framework.utils.TypeUtils;
import com.blued.android.module.ui.mvp.base.IntMvpView;
import com.blued.android.module.ui.mvp.dispatcher.MvpDispatcher;
import com.blued.android.module.ui.mvp.presenter.MvpPresenter;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/ui/mvp/fragment/MvpFragment.class */
public abstract class MvpFragment<T extends MvpPresenter, VB extends ViewBinding> extends BaseFragment implements IntMvpView {
    public VB a;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private volatile boolean g;
    private boolean h;
    private T i;
    private Dialog j;
    private MvpDispatcher k;
    private final String b = Intrinsics.a("_MVP_", (Object) getClass().getSimpleName());
    private final HashSet<MvpFragment<T, VB>.ViewTask> l = new HashSet<>();

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/ui/mvp/fragment/MvpFragment$ViewTask.class */
    public final class ViewTask implements Runnable {
        final /* synthetic */ MvpFragment<T, VB> a;
        private final Runnable b;

        @Override // java.lang.Runnable
        public void run() {
            HashSet<MvpFragment<T, VB>.ViewTask> h = this.a.h();
            MvpFragment<T, VB> mvpFragment = this.a;
            synchronized (h) {
                mvpFragment.h().remove(this);
            }
            if (((MvpFragment) this.a).g) {
                this.b.run();
            }
        }
    }

    private final T a() {
        return (T) TypeUtils.a(c(k()));
    }

    private final Class<T> b() {
        try {
            if (getClass().getGenericSuperclass() instanceof ParameterizedType) {
                Type genericSuperclass = getClass().getGenericSuperclass();
                if (genericSuperclass != null) {
                    return (Class) TypeUtils.a(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.blued.android.module.ui.mvp.presenter.MvpPresenter c(java.lang.String r5) {
        /*
            r4 = this;
            r0 = r4
            java.lang.String r0 = r0.b
            java.lang.String r1 = "onCreatePresenter, presenterId:"
            r2 = r5
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.a(r1, r2)
            int r0 = android.util.Log.v(r0, r1)
            com.blued.android.module.ui.mvp.manager.MvpPresenterManager$Companion r0 = com.blued.android.module.ui.mvp.manager.MvpPresenterManager.a
            com.blued.android.module.ui.mvp.manager.MvpPresenterManager r0 = r0.a()
            r1 = r5
            com.blued.android.module.ui.mvp.presenter.MvpPresenter r0 = r0.a(r1)
            r7 = r0
            r0 = r4
            java.lang.String r0 = r0.b
            r8 = r0
            r0 = r7
            if (r0 != 0) goto L29
            java.lang.String r0 = "presenter not exist, create it"
            r6 = r0
            goto L2c
        L29:
            java.lang.String r0 = "presenter exist, use it"
            r6 = r0
        L2c:
            r0 = r8
            r1 = r6
            int r0 = android.util.Log.v(r0, r1)
            r0 = r7
            r8 = r0
            r0 = r7
            if (r0 != 0) goto L7b
            r0 = r4
            java.lang.Class r0 = r0.b()
            r8 = r0
            r0 = r7
            r6 = r0
            r0 = r8
            if (r0 == 0) goto L63
            r0 = r8
            java.lang.Object r0 = r0.newInstance()     // Catch: java.lang.Exception -> L5c
            com.blued.android.module.ui.mvp.presenter.MvpPresenter r0 = (com.blued.android.module.ui.mvp.presenter.MvpPresenter) r0     // Catch: java.lang.Exception -> L5c
            r6 = r0
            r0 = r6
            r1 = r5
            r0.a(r1)     // Catch: java.lang.Exception -> L58
            goto L63
        L58:
            r5 = move-exception
            goto L5f
        L5c:
            r5 = move-exception
            r0 = r7
            r6 = r0
        L5f:
            r0 = r5
            r0.printStackTrace()
        L63:
            r0 = r6
            r8 = r0
            r0 = r6
            if (r0 == 0) goto L7b
            com.blued.android.module.ui.mvp.manager.MvpPresenterManager$Companion r0 = com.blued.android.module.ui.mvp.manager.MvpPresenterManager.a
            com.blued.android.module.ui.mvp.manager.MvpPresenterManager r0 = r0.a()
            r1 = r6
            r2 = r4
            androidx.lifecycle.Lifecycle r2 = r2.l()
            r0.a(r1, r2)
            r0 = r6
            r8 = r0
        L7b:
            r0 = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.ui.mvp.fragment.MvpFragment.c(java.lang.String):com.blued.android.module.ui.mvp.presenter.MvpPresenter");
    }

    private final boolean t() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof MvpFragment) {
            MvpFragment mvpFragment = (MvpFragment) parentFragment;
            return !mvpFragment.q() || mvpFragment.c;
        }
        return true;
    }

    private final void u() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        List<Fragment> fragments = childFragmentManager.getFragments();
        Intrinsics.c(fragments, "fragmentManager.fragments");
        if (fragments.isEmpty()) {
            return;
        }
        for (Fragment fragment : fragments) {
            if (fragment instanceof MvpFragment) {
                MvpFragment mvpFragment = (MvpFragment) fragment;
                if (mvpFragment.q() && mvpFragment.c) {
                    mvpFragment.s();
                }
            }
        }
    }

    private final void v() {
        try {
            Class<?> cls = Class.forName(Intrinsics.a(getClass().getName(), (Object) "_MVP"));
            Intrinsics.c(cls, "forName(javaClass.name + \"_MVP\")");
            this.k = (MvpDispatcher) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            Log.d(this.b, "Loaded _MVP class and constructor.");
        } catch (Exception e) {
            this.k = null;
        }
    }

    private final void w() {
        synchronized (this.l) {
            Iterator<MvpFragment<T, VB>.ViewTask> it = h().iterator();
            while (it.hasNext()) {
                AppInfo.n().removeCallbacks(it.next());
            }
            h().clear();
            Unit unit = Unit.a;
        }
    }

    private final VB x() {
        try {
            ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
            Intrinsics.a(parameterizedType);
            Method method = ClassUtils.a(parameterizedType.getActualTypeArguments()[1]).getMethod("inflate", LayoutInflater.class);
            Intrinsics.c(method, "clazz.getMethod(\"inflate…youtInflater::class.java)");
            return (VB) TypeUtils.a(method.invoke(null, getLayoutInflater()));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public VB a(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.e(inflater, "inflater");
        return null;
    }

    public void a(Bundle bundle) {
    }

    @Override // com.blued.android.module.ui.mvp.base.IntMvpView
    public void a(String type) {
        Intrinsics.e(type, "type");
        if (Intrinsics.a((Object) "_load_type_default_", (Object) type)) {
            n();
        }
    }

    @Override // com.blued.android.module.ui.mvp.base.IntMvpView
    public void a(String type, List<?> dataList) {
        Intrinsics.e(type, "type");
        Intrinsics.e(dataList, "dataList");
        MvpDispatcher mvpDispatcher = this.k;
        if (mvpDispatcher == null) {
            return;
        }
        mvpDispatcher.a(this, type, dataList);
    }

    @Override // com.blued.android.module.ui.mvp.base.IntMvpView
    public void a(String type, boolean z) {
        Intrinsics.e(type, "type");
        if (Intrinsics.a((Object) "_load_type_default_", (Object) type)) {
            o();
        }
    }

    protected final void a(boolean z) {
        Log.v(this.b, " onLoadData()");
        if (this.i == null || !c()) {
            return;
        }
        if (!this.e) {
            this.e = true;
            T t = this.i;
            List<Pair<String, List<?>>> i = t == null ? null : t.i();
            if (i != null) {
                for (Pair<String, List<?>> pair : i) {
                    String str = this.b;
                    Intrinsics.a(pair);
                    Log.v(str, Intrinsics.a("showDataToUI(), type:", pair.first));
                    Object obj = pair.first;
                    Intrinsics.a(obj);
                    String str2 = (String) obj;
                    Object obj2 = pair.second;
                    Intrinsics.a(obj2);
                    a(str2, (List) obj2);
                }
                T t2 = this.i;
                if (t2 != null) {
                    t2.r();
                }
            }
        }
        if (this.f || z) {
            return;
        }
        this.f = true;
        T t3 = this.i;
        if (t3 == null) {
            return;
        }
        t3.l();
    }

    protected String b(String customId) {
        Intrinsics.e(customId, "customId");
        Class<T> b = b();
        if (b != null) {
            return b.getSimpleName() + '_' + customId;
        }
        return getSimpleName() + '_' + customId;
    }

    @Override // com.blued.android.module.ui.mvp.base.IntMvpView
    public boolean c() {
        return this.g && getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED);
    }

    @Override // com.blued.android.module.ui.mvp.base.IntMvpView
    public void d() {
        T t = this.i;
        if (t == null) {
            return;
        }
        t.m();
    }

    @Override // com.blued.android.module.ui.mvp.base.IntMvpView
    public void e() {
    }

    @Override // com.blued.android.module.ui.mvp.base.IntMvpView
    public void f() {
    }

    @Override // com.blued.android.module.ui.mvp.base.IntMvpView
    public FragmentActivity g() {
        return getActivity();
    }

    protected final HashSet<MvpFragment<T, VB>.ViewTask> h() {
        return this.l;
    }

    protected void i() {
    }

    protected void j() {
        this.g = false;
        this.d = false;
        this.e = false;
        this.f = false;
        w();
        Dialog dialog = this.j;
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
        this.j = null;
        this.a = null;
    }

    protected String k() {
        return b(String.valueOf(SystemClock.uptimeMillis()));
    }

    protected Lifecycle l() {
        Lifecycle lifecycle = requireActivity().getLifecycle();
        Intrinsics.c(lifecycle, "requireActivity().lifecycle");
        return lifecycle;
    }

    public final T m() {
        T t = this.i;
        Intrinsics.a(t);
        return t;
    }

    public final void n() {
        if (getFragmentActive().isActive()) {
            if (this.j == null) {
                this.j = r();
            }
            Dialog dialog = this.j;
            if (dialog == null) {
                return;
            }
            dialog.show();
        }
    }

    public final void o() {
        Dialog dialog;
        if (!getFragmentActive().isActive() || (dialog = this.j) == null) {
            return;
        }
        dialog.dismiss();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Log.v(this.b, " onActivityCreated()");
        this.d = true;
        s();
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.v(this.b, " onCreate()");
        i();
        v();
        T a = a();
        this.i = a;
        if (a != null) {
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.c(requireActivity, "requireActivity()");
            a.a(requireActivity, l());
        }
        T t = this.i;
        if (t == null) {
            return;
        }
        FragmentActivity requireActivity2 = requireActivity();
        Intrinsics.c(requireActivity2, "requireActivity()");
        t.a(requireActivity2, getArguments(), bundle);
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        View root;
        ViewParent parent;
        Intrinsics.e(inflater, "inflater");
        Log.v(this.b, " onCreateView()");
        VB vb = this.a;
        if (vb == null) {
            VB a = a(inflater, viewGroup);
            VB vb2 = a;
            if (a == null) {
                vb2 = x();
            }
            this.a = vb2;
        } else if (vb != null && (root = vb.getRoot()) != null && (parent = root.getParent()) != null) {
            ((ViewGroup) parent).removeView(root);
        }
        T t = this.i;
        if (t != null) {
            FragmentActivity activity = getActivity();
            Intrinsics.a(activity);
            Intrinsics.c(activity, "this.activity!!");
            t.a(activity, l(), this);
        }
        VB vb3 = this.a;
        if (vb3 == null) {
            return null;
        }
        return vb3.getRoot();
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onDestroy() {
        super.onDestroy();
        Log.v(this.b, " onDestroy()");
        this.h = false;
        this.i = null;
        this.k = null;
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onDestroyView() {
        super.onDestroyView();
        Log.v(this.b, " onDestroyView()");
        if (p()) {
            return;
        }
        T t = this.i;
        if (t != null) {
            t.a(this);
        }
        j();
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.e(outState, "outState");
        super.onSaveInstanceState(outState);
        T t = this.i;
        if (t == null) {
            return;
        }
        t.a(outState);
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onStart() {
        super.onStart();
        s();
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onStop() {
        super.onStop();
        this.f = false;
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        Log.v(this.b, " onViewCreated()");
        if (!this.g) {
            this.g = true;
            a(bundle);
        }
        if (this.h) {
            return;
        }
        this.h = true;
        T t = this.i;
        if (t == null) {
            return;
        }
        FragmentActivity activity = getActivity();
        Intrinsics.a(activity);
        Intrinsics.c(activity, "this.activity!!");
        t.a((LifecycleOwner) activity);
    }

    protected boolean p() {
        return false;
    }

    protected boolean q() {
        return false;
    }

    protected Dialog r() {
        Dialog dialog = null;
        try {
            if (c()) {
                Dialog dialog2 = new Dialog(requireContext(), R.style.TranslucentBackground);
                dialog2.setContentView(R.layout.common_loading_dialog);
                StatusBarHelper.a(dialog2.getWindow());
                dialog2.setCancelable(true);
                dialog2.setCanceledOnTouchOutside(true);
                return dialog2;
            }
        } catch (Exception e) {
            e.printStackTrace();
            dialog = null;
        }
        return dialog;
    }

    protected final void s() {
        if (this.d) {
            if (!q()) {
                a(false);
            } else if (t()) {
                a(!this.c);
                u();
            }
        }
    }

    public final void setResult(int i) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        activity.setResult(i);
    }

    public final void setResult(int i, Intent intent) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        activity.setResult(i, intent);
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        Log.v(this.b, Intrinsics.a(" setUserVisibleHint() ", (Object) Boolean.valueOf(z)));
        this.c = z;
        s();
    }
}
