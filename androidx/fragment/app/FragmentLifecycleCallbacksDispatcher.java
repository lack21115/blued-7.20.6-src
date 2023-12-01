package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/FragmentLifecycleCallbacksDispatcher.class */
public class FragmentLifecycleCallbacksDispatcher {

    /* renamed from: a  reason: collision with root package name */
    private final CopyOnWriteArrayList<FragmentLifecycleCallbacksHolder> f2917a = new CopyOnWriteArrayList<>();
    private final FragmentManager b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/FragmentLifecycleCallbacksDispatcher$FragmentLifecycleCallbacksHolder.class */
    public static final class FragmentLifecycleCallbacksHolder {

        /* renamed from: a  reason: collision with root package name */
        final FragmentManager.FragmentLifecycleCallbacks f2918a;
        final boolean b;

        FragmentLifecycleCallbacksHolder(FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z) {
            this.f2918a = fragmentLifecycleCallbacks;
            this.b = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentLifecycleCallbacksDispatcher(FragmentManager fragmentManager) {
        this.b = fragmentManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Fragment fragment, Bundle bundle, boolean z) {
        Fragment i = this.b.i();
        if (i != null) {
            i.getParentFragmentManager().z().a(fragment, bundle, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.f2917a.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.b) {
                next.f2918a.onFragmentPreCreated(this.b, fragment, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Fragment fragment, View view, Bundle bundle, boolean z) {
        Fragment i = this.b.i();
        if (i != null) {
            i.getParentFragmentManager().z().a(fragment, view, bundle, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.f2917a.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.b) {
                next.f2918a.onFragmentViewCreated(this.b, fragment, view, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Fragment fragment, boolean z) {
        Context context = this.b.h().getContext();
        Fragment i = this.b.i();
        if (i != null) {
            i.getParentFragmentManager().z().a(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.f2917a.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.b) {
                next.f2918a.onFragmentPreAttached(this.b, fragment, context);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Fragment fragment, Bundle bundle, boolean z) {
        Fragment i = this.b.i();
        if (i != null) {
            i.getParentFragmentManager().z().b(fragment, bundle, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.f2917a.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.b) {
                next.f2918a.onFragmentCreated(this.b, fragment, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Fragment fragment, boolean z) {
        Context context = this.b.h().getContext();
        Fragment i = this.b.i();
        if (i != null) {
            i.getParentFragmentManager().z().b(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.f2917a.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.b) {
                next.f2918a.onFragmentAttached(this.b, fragment, context);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Fragment fragment, Bundle bundle, boolean z) {
        Fragment i = this.b.i();
        if (i != null) {
            i.getParentFragmentManager().z().c(fragment, bundle, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.f2917a.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.b) {
                next.f2918a.onFragmentActivityCreated(this.b, fragment, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Fragment fragment, boolean z) {
        Fragment i = this.b.i();
        if (i != null) {
            i.getParentFragmentManager().z().c(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.f2917a.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.b) {
                next.f2918a.onFragmentStarted(this.b, fragment);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Fragment fragment, Bundle bundle, boolean z) {
        Fragment i = this.b.i();
        if (i != null) {
            i.getParentFragmentManager().z().d(fragment, bundle, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.f2917a.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.b) {
                next.f2918a.onFragmentSaveInstanceState(this.b, fragment, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Fragment fragment, boolean z) {
        Fragment i = this.b.i();
        if (i != null) {
            i.getParentFragmentManager().z().d(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.f2917a.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.b) {
                next.f2918a.onFragmentResumed(this.b, fragment);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Fragment fragment, boolean z) {
        Fragment i = this.b.i();
        if (i != null) {
            i.getParentFragmentManager().z().e(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.f2917a.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.b) {
                next.f2918a.onFragmentPaused(this.b, fragment);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Fragment fragment, boolean z) {
        Fragment i = this.b.i();
        if (i != null) {
            i.getParentFragmentManager().z().f(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.f2917a.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.b) {
                next.f2918a.onFragmentStopped(this.b, fragment);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(Fragment fragment, boolean z) {
        Fragment i = this.b.i();
        if (i != null) {
            i.getParentFragmentManager().z().g(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.f2917a.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.b) {
                next.f2918a.onFragmentViewDestroyed(this.b, fragment);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(Fragment fragment, boolean z) {
        Fragment i = this.b.i();
        if (i != null) {
            i.getParentFragmentManager().z().h(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.f2917a.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.b) {
                next.f2918a.onFragmentDestroyed(this.b, fragment);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(Fragment fragment, boolean z) {
        Fragment i = this.b.i();
        if (i != null) {
            i.getParentFragmentManager().z().i(fragment, true);
        }
        Iterator<FragmentLifecycleCallbacksHolder> it = this.f2917a.iterator();
        while (it.hasNext()) {
            FragmentLifecycleCallbacksHolder next = it.next();
            if (!z || next.b) {
                next.f2918a.onFragmentDetached(this.b, fragment);
            }
        }
    }

    public void registerFragmentLifecycleCallbacks(FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z) {
        this.f2917a.add(new FragmentLifecycleCallbacksHolder(fragmentLifecycleCallbacks, z));
    }

    public void unregisterFragmentLifecycleCallbacks(FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks) {
        synchronized (this.f2917a) {
            int i = 0;
            int size = this.f2917a.size();
            while (true) {
                if (i >= size) {
                    break;
                } else if (this.f2917a.get(i).f2918a == fragmentLifecycleCallbacks) {
                    this.f2917a.remove(i);
                    break;
                } else {
                    i++;
                }
            }
        }
    }
}
