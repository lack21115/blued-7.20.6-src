package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/FragmentManagerViewModel.class */
public final class FragmentManagerViewModel extends ViewModel {

    /* renamed from: a  reason: collision with root package name */
    private static final ViewModelProvider.Factory f2945a = new ViewModelProvider.Factory() { // from class: androidx.fragment.app.FragmentManagerViewModel.1
        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> cls) {
            return new FragmentManagerViewModel(true);
        }
    };
    private final boolean e;
    private final HashMap<String, Fragment> b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<String, FragmentManagerViewModel> f2946c = new HashMap<>();
    private final HashMap<String, ViewModelStore> d = new HashMap<>();
    private boolean f = false;
    private boolean g = false;
    private boolean h = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentManagerViewModel(boolean z) {
        this.e = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FragmentManagerViewModel a(ViewModelStore viewModelStore) {
        return (FragmentManagerViewModel) new ViewModelProvider(viewModelStore, f2945a).get(FragmentManagerViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment a(String str) {
        return this.b.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Fragment fragment) {
        if (this.h) {
            if (FragmentManager.a(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else if (this.b.containsKey(fragment.mWho)) {
        } else {
            this.b.put(fragment.mWho, fragment);
            if (FragmentManager.a(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public void a(FragmentManagerNonConfig fragmentManagerNonConfig) {
        this.b.clear();
        this.f2946c.clear();
        this.d.clear();
        if (fragmentManagerNonConfig != null) {
            Collection<Fragment> a2 = fragmentManagerNonConfig.a();
            if (a2 != null) {
                for (Fragment fragment : a2) {
                    if (fragment != null) {
                        this.b.put(fragment.mWho, fragment);
                    }
                }
            }
            Map<String, FragmentManagerNonConfig> b = fragmentManagerNonConfig.b();
            if (b != null) {
                for (Map.Entry<String, FragmentManagerNonConfig> entry : b.entrySet()) {
                    FragmentManagerViewModel fragmentManagerViewModel = new FragmentManagerViewModel(this.e);
                    fragmentManagerViewModel.a(entry.getValue());
                    this.f2946c.put(entry.getKey(), fragmentManagerViewModel);
                }
            }
            Map<String, ViewModelStore> c2 = fragmentManagerNonConfig.c();
            if (c2 != null) {
                this.d.putAll(c2);
            }
        }
        this.g = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        this.h = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Collection<Fragment> b() {
        return new ArrayList(this.b.values());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(Fragment fragment) {
        if (this.b.containsKey(fragment.mWho)) {
            return this.e ? this.f : !this.g;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public FragmentManagerNonConfig c() {
        if (this.b.isEmpty() && this.f2946c.isEmpty() && this.d.isEmpty()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, FragmentManagerViewModel> entry : this.f2946c.entrySet()) {
            FragmentManagerNonConfig c2 = entry.getValue().c();
            if (c2 != null) {
                hashMap.put(entry.getKey(), c2);
            }
        }
        this.g = true;
        if (this.b.isEmpty() && hashMap.isEmpty() && this.d.isEmpty()) {
            return null;
        }
        return new FragmentManagerNonConfig(new ArrayList(this.b.values()), hashMap, new HashMap(this.d));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Fragment fragment) {
        if (this.h) {
            if (FragmentManager.a(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
                return;
            }
            return;
        }
        if ((this.b.remove(fragment.mWho) != null) && FragmentManager.a(2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentManagerViewModel d(Fragment fragment) {
        FragmentManagerViewModel fragmentManagerViewModel = this.f2946c.get(fragment.mWho);
        FragmentManagerViewModel fragmentManagerViewModel2 = fragmentManagerViewModel;
        if (fragmentManagerViewModel == null) {
            fragmentManagerViewModel2 = new FragmentManagerViewModel(this.e);
            this.f2946c.put(fragment.mWho, fragmentManagerViewModel2);
        }
        return fragmentManagerViewModel2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewModelStore e(Fragment fragment) {
        ViewModelStore viewModelStore = this.d.get(fragment.mWho);
        ViewModelStore viewModelStore2 = viewModelStore;
        if (viewModelStore == null) {
            viewModelStore2 = new ViewModelStore();
            this.d.put(fragment.mWho, viewModelStore2);
        }
        return viewModelStore2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FragmentManagerViewModel fragmentManagerViewModel = (FragmentManagerViewModel) obj;
        return this.b.equals(fragmentManagerViewModel.b) && this.f2946c.equals(fragmentManagerViewModel.f2946c) && this.d.equals(fragmentManagerViewModel.d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Fragment fragment) {
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        FragmentManagerViewModel fragmentManagerViewModel = this.f2946c.get(fragment.mWho);
        if (fragmentManagerViewModel != null) {
            fragmentManagerViewModel.onCleared();
            this.f2946c.remove(fragment.mWho);
        }
        ViewModelStore viewModelStore = this.d.get(fragment.mWho);
        if (viewModelStore != null) {
            viewModelStore.clear();
            this.d.remove(fragment.mWho);
        }
    }

    public int hashCode() {
        return (((this.b.hashCode() * 31) + this.f2946c.hashCode()) * 31) + this.d.hashCode();
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        if (FragmentManager.a(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f = true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<Fragment> it = this.b.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.f2946c.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.d.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
