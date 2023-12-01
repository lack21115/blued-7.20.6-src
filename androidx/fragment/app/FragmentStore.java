package androidx.fragment.app;

import android.util.Log;
import android.view.ViewGroup;
import com.igexin.push.core.b;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/FragmentStore.class */
public class FragmentStore {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<Fragment> f3003a = new ArrayList<>();
    private final HashMap<String, FragmentStateManager> b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private FragmentManagerViewModel f3004c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment a(String str) {
        if (str != null) {
            int size = this.f3003a.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    break;
                }
                Fragment fragment = this.f3003a.get(i);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
                size = i;
            }
        }
        if (str != null) {
            for (FragmentStateManager fragmentStateManager : this.b.values()) {
                if (fragmentStateManager != null) {
                    Fragment a2 = fragmentStateManager.a();
                    if (str.equals(a2.mTag)) {
                        return a2;
                    }
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentManagerViewModel a() {
        return this.f3004c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        for (FragmentStateManager fragmentStateManager : this.b.values()) {
            if (fragmentStateManager != null) {
                fragmentStateManager.a(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Fragment fragment) {
        if (this.f3003a.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.f3003a) {
            this.f3003a.add(fragment);
        }
        fragment.mAdded = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(FragmentManagerViewModel fragmentManagerViewModel) {
        this.f3004c = fragmentManagerViewModel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(FragmentStateManager fragmentStateManager) {
        Fragment a2 = fragmentStateManager.a();
        if (b(a2.mWho)) {
            return;
        }
        this.b.put(a2.mWho, fragmentStateManager);
        if (a2.mRetainInstanceChangedWhileDetached) {
            if (a2.mRetainInstance) {
                this.f3004c.a(a2);
            } else {
                this.f3004c.c(a2);
            }
            a2.mRetainInstanceChangedWhileDetached = false;
        }
        if (FragmentManager.a(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "    ";
        if (!this.b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (FragmentStateManager fragmentStateManager : this.b.values()) {
                printWriter.print(str);
                if (fragmentStateManager != null) {
                    Fragment a2 = fragmentStateManager.a();
                    printWriter.println(a2);
                    a2.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println(b.l);
                }
            }
        }
        int size = this.f3003a.size();
        if (size <= 0) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Added Fragments:");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            printWriter.print(str);
            printWriter.print("  #");
            printWriter.print(i2);
            printWriter.print(": ");
            printWriter.println(this.f3003a.get(i2).toString());
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(List<String> list) {
        this.f3003a.clear();
        if (list != null) {
            for (String str : list) {
                Fragment e = e(str);
                if (e == null) {
                    throw new IllegalStateException("No instantiated fragment for (" + str + ")");
                }
                if (FragmentManager.a(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + e);
                }
                a(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment b(int i) {
        int size = this.f3003a.size();
        while (true) {
            int i2 = size - 1;
            if (i2 < 0) {
                for (FragmentStateManager fragmentStateManager : this.b.values()) {
                    if (fragmentStateManager != null) {
                        Fragment a2 = fragmentStateManager.a();
                        if (a2.mFragmentId == i) {
                            return a2;
                        }
                    }
                }
                return null;
            }
            Fragment fragment = this.f3003a.get(i2);
            if (fragment != null && fragment.mFragmentId == i) {
                return fragment;
            }
            size = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.b.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Fragment fragment) {
        synchronized (this.f3003a) {
            this.f3003a.remove(fragment);
        }
        fragment.mAdded = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(FragmentStateManager fragmentStateManager) {
        Fragment a2 = fragmentStateManager.a();
        if (a2.mRetainInstance) {
            this.f3004c.c(a2);
        }
        if (this.b.put(a2.mWho, null) != null && FragmentManager.a(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(String str) {
        return this.b.get(str) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup == null) {
            return -1;
        }
        int indexOf = this.f3003a.indexOf(fragment);
        int i = indexOf;
        while (true) {
            int i2 = i - 1;
            int i3 = indexOf;
            if (i2 >= 0) {
                Fragment fragment2 = this.f3003a.get(i2);
                if (fragment2.mContainer == viewGroup && fragment2.mView != null) {
                    return viewGroup.indexOfChild(fragment2.mView) + 1;
                }
                i = i2;
            } else {
                while (true) {
                    i3++;
                    if (i3 >= this.f3003a.size()) {
                        return -1;
                    }
                    Fragment fragment3 = this.f3003a.get(i3);
                    if (fragment3.mContainer == viewGroup && fragment3.mView != null) {
                        return viewGroup.indexOfChild(fragment3.mView);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentStateManager c(String str) {
        return this.b.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        Iterator<Fragment> it = this.f3003a.iterator();
        while (it.hasNext()) {
            FragmentStateManager fragmentStateManager = this.b.get(it.next().mWho);
            if (fragmentStateManager != null) {
                fragmentStateManager.c();
            }
        }
        for (FragmentStateManager fragmentStateManager2 : this.b.values()) {
            if (fragmentStateManager2 != null) {
                fragmentStateManager2.c();
                Fragment a2 = fragmentStateManager2.a();
                if (a2.mRemoving && !a2.isInBackStack()) {
                    b(fragmentStateManager2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment d(String str) {
        Fragment findFragmentByWho;
        for (FragmentStateManager fragmentStateManager : this.b.values()) {
            if (fragmentStateManager != null && (findFragmentByWho = fragmentStateManager.a().findFragmentByWho(str)) != null) {
                return findFragmentByWho;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        this.b.values().removeAll(Collections.singleton(null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment e(String str) {
        FragmentStateManager fragmentStateManager = this.b.get(str);
        if (fragmentStateManager != null) {
            return fragmentStateManager.a();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<FragmentState> e() {
        ArrayList<FragmentState> arrayList = new ArrayList<>(this.b.size());
        for (FragmentStateManager fragmentStateManager : this.b.values()) {
            if (fragmentStateManager != null) {
                Fragment a2 = fragmentStateManager.a();
                FragmentState m = fragmentStateManager.m();
                arrayList.add(m);
                if (FragmentManager.a(2)) {
                    Log.v("FragmentManager", "Saved state of " + a2 + ": " + m.m);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<String> f() {
        synchronized (this.f3003a) {
            if (this.f3003a.isEmpty()) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>(this.f3003a.size());
            Iterator<Fragment> it = this.f3003a.iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                arrayList.add(next.mWho);
                if (FragmentManager.a(2)) {
                    Log.v("FragmentManager", "saveAllState: adding fragment (" + next.mWho + "): " + next);
                }
            }
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<FragmentStateManager> g() {
        ArrayList arrayList = new ArrayList();
        for (FragmentStateManager fragmentStateManager : this.b.values()) {
            if (fragmentStateManager != null) {
                arrayList.add(fragmentStateManager);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Fragment> h() {
        ArrayList arrayList;
        if (this.f3003a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f3003a) {
            arrayList = new ArrayList(this.f3003a);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Fragment> i() {
        ArrayList arrayList = new ArrayList();
        for (FragmentStateManager fragmentStateManager : this.b.values()) {
            if (fragmentStateManager != null) {
                arrayList.add(fragmentStateManager.a());
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        return this.b.size();
    }
}
