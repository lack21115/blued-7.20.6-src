package com.bumptech.glide.manager;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.alipay.sdk.util.i;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bytedance.applog.tracker.Tracker;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Deprecated
/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/manager/RequestManagerFragment.class */
public class RequestManagerFragment extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private final ActivityFragmentLifecycle f21016a;
    private final RequestManagerTreeNode b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<RequestManagerFragment> f21017c;
    private RequestManager d;
    private RequestManagerFragment e;
    private Fragment f;

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/manager/RequestManagerFragment$FragmentRequestManagerTreeNode.class */
    class FragmentRequestManagerTreeNode implements RequestManagerTreeNode {
        FragmentRequestManagerTreeNode() {
        }

        @Override // com.bumptech.glide.manager.RequestManagerTreeNode
        public Set<RequestManager> a() {
            Set<RequestManagerFragment> d = RequestManagerFragment.this.d();
            HashSet hashSet = new HashSet(d.size());
            for (RequestManagerFragment requestManagerFragment : d) {
                if (requestManagerFragment.b() != null) {
                    hashSet.add(requestManagerFragment.b());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + RequestManagerFragment.this + i.d;
        }
    }

    public RequestManagerFragment() {
        this(new ActivityFragmentLifecycle());
    }

    RequestManagerFragment(ActivityFragmentLifecycle activityFragmentLifecycle) {
        this.b = new FragmentRequestManagerTreeNode();
        this.f21017c = new HashSet();
        this.f21016a = activityFragmentLifecycle;
    }

    private void a(Activity activity) {
        f();
        RequestManagerFragment b = Glide.a((Context) activity).g().b(activity);
        this.e = b;
        if (equals(b)) {
            return;
        }
        this.e.a(this);
    }

    private void a(RequestManagerFragment requestManagerFragment) {
        this.f21017c.add(requestManagerFragment);
    }

    private void b(RequestManagerFragment requestManagerFragment) {
        this.f21017c.remove(requestManagerFragment);
    }

    private boolean b(Fragment fragment) {
        Fragment parentFragment = getParentFragment();
        while (true) {
            Fragment parentFragment2 = fragment.getParentFragment();
            if (parentFragment2 == null) {
                return false;
            }
            if (parentFragment2.equals(parentFragment)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    private Fragment e() {
        Fragment parentFragment = Build.VERSION.SDK_INT >= 17 ? getParentFragment() : null;
        return parentFragment != null ? parentFragment : this.f;
    }

    private void f() {
        RequestManagerFragment requestManagerFragment = this.e;
        if (requestManagerFragment != null) {
            requestManagerFragment.b(this);
            this.e = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ActivityFragmentLifecycle a() {
        return this.f21016a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Fragment fragment) {
        this.f = fragment;
        if (fragment == null || fragment.getActivity() == null) {
            return;
        }
        a(fragment.getActivity());
    }

    public void a(RequestManager requestManager) {
        this.d = requestManager;
    }

    public RequestManager b() {
        return this.d;
    }

    public RequestManagerTreeNode c() {
        return this.b;
    }

    Set<RequestManagerFragment> d() {
        if (equals(this.e)) {
            return Collections.unmodifiableSet(this.f21017c);
        }
        if (this.e == null || Build.VERSION.SDK_INT < 17) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet();
        for (RequestManagerFragment requestManagerFragment : this.e.d()) {
            if (b(requestManagerFragment.getParentFragment())) {
                hashSet.add(requestManagerFragment);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            a(activity);
        } catch (IllegalStateException e) {
            if (Log.isLoggable("RMFragment", 5)) {
                Log.w("RMFragment", "Unable to register fragment with root", e);
            }
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f21016a.c();
        f();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        f();
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
        this.f21016a.a();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.f21016a.b();
    }

    @Override // android.app.Fragment
    public void setUserVisibleHint(boolean z) {
        Tracker.setUserVisibleHint(this, z);
        super.setUserVisibleHint(z);
    }

    @Override // android.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + e() + i.d;
    }
}
