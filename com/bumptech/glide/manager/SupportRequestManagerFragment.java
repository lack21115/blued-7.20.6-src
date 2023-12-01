package com.bumptech.glide.manager;

import android.content.Context;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.alipay.sdk.util.i;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bytedance.applog.tracker.Tracker;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/manager/SupportRequestManagerFragment.class */
public class SupportRequestManagerFragment extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private final ActivityFragmentLifecycle f21023a;
    private final RequestManagerTreeNode b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<SupportRequestManagerFragment> f21024c;
    private SupportRequestManagerFragment d;
    private RequestManager e;
    private Fragment f;

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/manager/SupportRequestManagerFragment$SupportFragmentRequestManagerTreeNode.class */
    class SupportFragmentRequestManagerTreeNode implements RequestManagerTreeNode {
        SupportFragmentRequestManagerTreeNode() {
        }

        @Override // com.bumptech.glide.manager.RequestManagerTreeNode
        public Set<RequestManager> a() {
            Set<SupportRequestManagerFragment> d = SupportRequestManagerFragment.this.d();
            HashSet hashSet = new HashSet(d.size());
            for (SupportRequestManagerFragment supportRequestManagerFragment : d) {
                if (supportRequestManagerFragment.b() != null) {
                    hashSet.add(supportRequestManagerFragment.b());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + SupportRequestManagerFragment.this + i.d;
        }
    }

    public SupportRequestManagerFragment() {
        this(new ActivityFragmentLifecycle());
    }

    public SupportRequestManagerFragment(ActivityFragmentLifecycle activityFragmentLifecycle) {
        this.b = new SupportFragmentRequestManagerTreeNode();
        this.f21024c = new HashSet();
        this.f21023a = activityFragmentLifecycle;
    }

    private void a(Context context, FragmentManager fragmentManager) {
        f();
        SupportRequestManagerFragment a2 = Glide.a(context).g().a(context, fragmentManager);
        this.d = a2;
        if (equals(a2)) {
            return;
        }
        this.d.a(this);
    }

    private void a(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.f21024c.add(supportRequestManagerFragment);
    }

    private static FragmentManager b(Fragment fragment) {
        while (fragment.getParentFragment() != null) {
            fragment = fragment.getParentFragment();
        }
        return fragment.getFragmentManager();
    }

    private void b(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.f21024c.remove(supportRequestManagerFragment);
    }

    private boolean c(Fragment fragment) {
        Fragment e = e();
        while (true) {
            Fragment parentFragment = fragment.getParentFragment();
            if (parentFragment == null) {
                return false;
            }
            if (parentFragment.equals(e)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    private Fragment e() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.f;
    }

    private void f() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.d;
        if (supportRequestManagerFragment != null) {
            supportRequestManagerFragment.b(this);
            this.d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ActivityFragmentLifecycle a() {
        return this.f21023a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Fragment fragment) {
        FragmentManager b;
        this.f = fragment;
        if (fragment == null || fragment.getContext() == null || (b = b(fragment)) == null) {
            return;
        }
        a(fragment.getContext(), b);
    }

    public void a(RequestManager requestManager) {
        this.e = requestManager;
    }

    public RequestManager b() {
        return this.e;
    }

    public RequestManagerTreeNode c() {
        return this.b;
    }

    Set<SupportRequestManagerFragment> d() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.d;
        if (supportRequestManagerFragment == null) {
            return Collections.emptySet();
        }
        if (equals(supportRequestManagerFragment)) {
            return Collections.unmodifiableSet(this.f21024c);
        }
        HashSet hashSet = new HashSet();
        for (SupportRequestManagerFragment supportRequestManagerFragment2 : this.d.d()) {
            if (c(supportRequestManagerFragment2.e())) {
                hashSet.add(supportRequestManagerFragment2);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        FragmentManager b = b((Fragment) this);
        if (b == null) {
            if (Log.isLoggable("SupportRMFragment", 5)) {
                Log.w("SupportRMFragment", "Unable to register fragment with root, ancestor detached");
                return;
            }
            return;
        }
        try {
            a(getContext(), b);
        } catch (IllegalStateException e) {
            if (Log.isLoggable("SupportRMFragment", 5)) {
                Log.w("SupportRMFragment", "Unable to register fragment with root", e);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f21023a.c();
        f();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f = null;
        f();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        Tracker.onHiddenChanged(this, z);
        super.onHiddenChanged(z);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        Tracker.onPause(this);
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Tracker.onResume(this);
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.f21023a.a();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.f21023a.b();
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Tracker.setUserVisibleHint(this, z);
        super.setUserVisibleHint(z);
    }

    @Override // androidx.fragment.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + e() + i.d;
    }
}
