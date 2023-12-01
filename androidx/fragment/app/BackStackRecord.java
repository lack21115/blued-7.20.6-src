package androidx.fragment.app;

import android.net.wifi.WifiEnterpriseConfig;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.alipay.sdk.util.i;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/BackStackRecord.class */
public final class BackStackRecord extends FragmentTransaction implements FragmentManager.BackStackEntry, FragmentManager.OpGenerator {

    /* renamed from: a  reason: collision with root package name */
    final FragmentManager f2900a;
    boolean b;

    /* renamed from: c  reason: collision with root package name */
    int f2901c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BackStackRecord(FragmentManager fragmentManager) {
        super(fragmentManager.getFragmentFactory(), fragmentManager.h() != null ? fragmentManager.h().getContext().getClassLoader() : null);
        this.f2901c = -1;
        this.f2900a = fragmentManager;
    }

    private static boolean b(FragmentTransaction.Op op) {
        Fragment fragment = op.b;
        return (fragment == null || !fragment.mAdded || fragment.mView == null || fragment.mDetached || fragment.mHidden || !fragment.isPostponed()) ? false : true;
    }

    int a(boolean z) {
        if (this.b) {
            throw new IllegalStateException("commit already called");
        }
        if (FragmentManager.a(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
            dump("  ", printWriter);
            printWriter.close();
        }
        this.b = true;
        if (this.j) {
            this.f2901c = this.f2900a.e();
        } else {
            this.f2901c = -1;
        }
        this.f2900a.a(this, z);
        return this.f2901c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment a(ArrayList<Fragment> arrayList, Fragment fragment) {
        int i;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            Fragment fragment2 = fragment;
            if (i3 >= this.d.size()) {
                return fragment2;
            }
            FragmentTransaction.Op op = this.d.get(i3);
            int i4 = op.f3012a;
            if (i4 != 1) {
                if (i4 == 2) {
                    Fragment fragment3 = op.b;
                    int i5 = fragment3.mContainerId;
                    int size = arrayList.size() - 1;
                    boolean z = false;
                    i = i3;
                    fragment = fragment2;
                    while (size >= 0) {
                        Fragment fragment4 = arrayList.get(size);
                        Fragment fragment5 = fragment;
                        int i6 = i;
                        boolean z2 = z;
                        if (fragment4.mContainerId == i5) {
                            if (fragment4 == fragment3) {
                                z2 = true;
                                fragment5 = fragment;
                                i6 = i;
                            } else {
                                fragment5 = fragment;
                                int i7 = i;
                                if (fragment4 == fragment) {
                                    this.d.add(i, new FragmentTransaction.Op(9, fragment4));
                                    i7 = i + 1;
                                    fragment5 = null;
                                }
                                FragmentTransaction.Op op2 = new FragmentTransaction.Op(3, fragment4);
                                op2.f3013c = op.f3013c;
                                op2.e = op.e;
                                op2.d = op.d;
                                op2.f = op.f;
                                this.d.add(i7, op2);
                                arrayList.remove(fragment4);
                                i6 = i7 + 1;
                                z2 = z;
                            }
                        }
                        size--;
                        fragment = fragment5;
                        i = i6;
                        z = z2;
                    }
                    if (z) {
                        this.d.remove(i);
                        i--;
                    } else {
                        op.f3012a = 1;
                        arrayList.add(fragment3);
                    }
                } else if (i4 == 3 || i4 == 6) {
                    arrayList.remove(op.b);
                    fragment = fragment2;
                    i = i3;
                    if (op.b == fragment2) {
                        this.d.add(i3, new FragmentTransaction.Op(9, op.b));
                        i = i3 + 1;
                        fragment = null;
                    }
                } else if (i4 != 7) {
                    if (i4 != 8) {
                        fragment = fragment2;
                        i = i3;
                    } else {
                        this.d.add(i3, new FragmentTransaction.Op(9, fragment2));
                        i = i3 + 1;
                        fragment = op.b;
                    }
                }
                i2 = i + 1;
            }
            arrayList.add(op.b);
            i = i3;
            fragment = fragment2;
            i2 = i + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        int size = this.d.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                if (this.s || FragmentManager.f2967a) {
                    return;
                }
                FragmentManager fragmentManager = this.f2900a;
                fragmentManager.a(fragmentManager.f2968c, true);
                return;
            }
            FragmentTransaction.Op op = this.d.get(i2);
            Fragment fragment = op.b;
            if (fragment != null) {
                fragment.setPopDirection(false);
                fragment.setNextTransition(this.i);
                fragment.setSharedElementNames(this.q, this.r);
            }
            switch (op.f3012a) {
                case 1:
                    fragment.setAnimations(op.f3013c, op.d, op.e, op.f);
                    this.f2900a.a(fragment, false);
                    this.f2900a.i(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + op.f3012a);
                case 3:
                    fragment.setAnimations(op.f3013c, op.d, op.e, op.f);
                    this.f2900a.j(fragment);
                    break;
                case 4:
                    fragment.setAnimations(op.f3013c, op.d, op.e, op.f);
                    this.f2900a.k(fragment);
                    break;
                case 5:
                    fragment.setAnimations(op.f3013c, op.d, op.e, op.f);
                    this.f2900a.a(fragment, false);
                    this.f2900a.l(fragment);
                    break;
                case 6:
                    fragment.setAnimations(op.f3013c, op.d, op.e, op.f);
                    this.f2900a.m(fragment);
                    break;
                case 7:
                    fragment.setAnimations(op.f3013c, op.d, op.e, op.f);
                    this.f2900a.a(fragment, false);
                    this.f2900a.n(fragment);
                    break;
                case 8:
                    this.f2900a.o(fragment);
                    break;
                case 9:
                    this.f2900a.o(null);
                    break;
                case 10:
                    this.f2900a.a(fragment, op.h);
                    break;
            }
            if (!this.s && op.f3012a != 1 && fragment != null && !FragmentManager.f2967a) {
                this.f2900a.g(fragment);
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        if (!this.j) {
            return;
        }
        if (FragmentManager.a(2)) {
            Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
        }
        int size = this.d.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                return;
            }
            FragmentTransaction.Op op = this.d.get(i3);
            if (op.b != null) {
                op.b.mBackStackNesting += i;
                if (FragmentManager.a(2)) {
                    Log.v("FragmentManager", "Bump nesting of " + op.b + " to " + op.b.mBackStackNesting);
                }
            }
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.fragment.app.FragmentTransaction
    public void a(int i, Fragment fragment, String str, int i2) {
        super.a(i, fragment, str, i2);
        fragment.mFragmentManager = this.f2900a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Fragment.OnStartEnterTransitionListener onStartEnterTransitionListener) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.d.size()) {
                return;
            }
            FragmentTransaction.Op op = this.d.get(i2);
            if (b(op)) {
                op.b.setOnStartEnterTransitionListener(onStartEnterTransitionListener);
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(ArrayList<BackStackRecord> arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.d.size();
        int i3 = -1;
        int i4 = 0;
        while (i4 < size) {
            FragmentTransaction.Op op = this.d.get(i4);
            int i5 = op.b != null ? op.b.mContainerId : 0;
            int i6 = i3;
            if (i5 != 0) {
                i6 = i3;
                if (i5 != i3) {
                    int i7 = i;
                    while (true) {
                        int i8 = i7;
                        if (i8 >= i2) {
                            i6 = i5;
                            break;
                        }
                        BackStackRecord backStackRecord = arrayList.get(i8);
                        int size2 = backStackRecord.d.size();
                        int i9 = 0;
                        while (true) {
                            int i10 = i9;
                            if (i10 < size2) {
                                FragmentTransaction.Op op2 = backStackRecord.d.get(i10);
                                if ((op2.b != null ? op2.b.mContainerId : 0) == i5) {
                                    return true;
                                }
                                i9 = i10 + 1;
                            }
                        }
                        i7 = i8 + 1;
                    }
                } else {
                    continue;
                }
            }
            i4++;
            i3 = i6;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment b(ArrayList<Fragment> arrayList, Fragment fragment) {
        int size = this.d.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return fragment;
            }
            FragmentTransaction.Op op = this.d.get(i);
            int i2 = op.f3012a;
            if (i2 != 1) {
                if (i2 != 3) {
                    switch (i2) {
                        case 8:
                            fragment = null;
                            break;
                        case 9:
                            fragment = op.b;
                            break;
                        case 10:
                            op.h = op.g;
                            break;
                    }
                    size = i;
                }
                arrayList.add(op.b);
                size = i;
            }
            arrayList.remove(op.b);
            size = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(boolean z) {
        int size = this.d.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                if (this.s || !z || FragmentManager.f2967a) {
                    return;
                }
                FragmentManager fragmentManager = this.f2900a;
                fragmentManager.a(fragmentManager.f2968c, true);
                return;
            }
            FragmentTransaction.Op op = this.d.get(i);
            Fragment fragment = op.b;
            if (fragment != null) {
                fragment.setPopDirection(true);
                fragment.setNextTransition(FragmentManager.c(this.i));
                fragment.setSharedElementNames(this.r, this.q);
            }
            switch (op.f3012a) {
                case 1:
                    fragment.setAnimations(op.f3013c, op.d, op.e, op.f);
                    this.f2900a.a(fragment, true);
                    this.f2900a.j(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + op.f3012a);
                case 3:
                    fragment.setAnimations(op.f3013c, op.d, op.e, op.f);
                    this.f2900a.i(fragment);
                    break;
                case 4:
                    fragment.setAnimations(op.f3013c, op.d, op.e, op.f);
                    this.f2900a.l(fragment);
                    break;
                case 5:
                    fragment.setAnimations(op.f3013c, op.d, op.e, op.f);
                    this.f2900a.a(fragment, true);
                    this.f2900a.k(fragment);
                    break;
                case 6:
                    fragment.setAnimations(op.f3013c, op.d, op.e, op.f);
                    this.f2900a.n(fragment);
                    break;
                case 7:
                    fragment.setAnimations(op.f3013c, op.d, op.e, op.f);
                    this.f2900a.a(fragment, true);
                    this.f2900a.m(fragment);
                    break;
                case 8:
                    this.f2900a.o(null);
                    break;
                case 9:
                    this.f2900a.o(fragment);
                    break;
                case 10:
                    this.f2900a.a(fragment, op.g);
                    break;
            }
            if (!this.s && op.f3012a != 3 && fragment != null && !FragmentManager.f2967a) {
                this.f2900a.g(fragment);
            }
            size = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.d.size()) {
                return false;
            }
            if (b(this.d.get(i2))) {
                return true;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(int i) {
        int size = this.d.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                return false;
            }
            FragmentTransaction.Op op = this.d.get(i3);
            int i4 = op.b != null ? op.b.mContainerId : 0;
            if (i4 != 0 && i4 == i) {
                return true;
            }
            i2 = i3 + 1;
        }
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public int commit() {
        return a(false);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public int commitAllowingStateLoss() {
        return a(true);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public void commitNow() {
        disallowAddToBackStack();
        this.f2900a.b((FragmentManager.OpGenerator) this, false);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public void commitNowAllowingStateLoss() {
        disallowAddToBackStack();
        this.f2900a.b((FragmentManager.OpGenerator) this, true);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction detach(Fragment fragment) {
        if (fragment.mFragmentManager == null || fragment.mFragmentManager == this.f2900a) {
            return super.detach(fragment);
        }
        throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public void dump(String str, PrintWriter printWriter) {
        dump(str, printWriter, true);
    }

    public void dump(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.l);
            printWriter.print(" mIndex=");
            printWriter.print(this.f2901c);
            printWriter.print(" mCommitted=");
            printWriter.println(this.b);
            if (this.i != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.i));
            }
            if (this.e != 0 || this.f != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.e));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f));
            }
            if (this.g != 0 || this.h != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.g));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.h));
            }
            if (this.m != 0 || this.n != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.m));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.n);
            }
            if (this.o != 0 || this.p != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.o));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.p);
            }
        }
        if (this.d.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.d.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            FragmentTransaction.Op op = this.d.get(i2);
            switch (op.f3012a) {
                case 0:
                    str2 = WifiEnterpriseConfig.EMPTY_VALUE;
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + op.f3012a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i2);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(op.b);
            if (z) {
                if (op.f3013c != 0 || op.d != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(op.f3013c));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(op.d));
                }
                if (op.e != 0 || op.f != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(op.e));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(op.f));
                }
            }
            i = i2 + 1;
        }
    }

    @Override // androidx.fragment.app.FragmentManager.OpGenerator
    public boolean generateOps(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        if (FragmentManager.a(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(false);
        if (this.j) {
            this.f2900a.a(this);
            return true;
        }
        return true;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public CharSequence getBreadCrumbShortTitle() {
        return this.o != 0 ? this.f2900a.h().getContext().getText(this.o) : this.p;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public int getBreadCrumbShortTitleRes() {
        return this.o;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public CharSequence getBreadCrumbTitle() {
        return this.m != 0 ? this.f2900a.h().getContext().getText(this.m) : this.n;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public int getBreadCrumbTitleRes() {
        return this.m;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public int getId() {
        return this.f2901c;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public String getName() {
        return this.l;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction hide(Fragment fragment) {
        if (fragment.mFragmentManager == null || fragment.mFragmentManager == this.f2900a) {
            return super.hide(fragment);
        }
        throw new IllegalStateException("Cannot hide Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public boolean isEmpty() {
        return this.d.isEmpty();
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction remove(Fragment fragment) {
        if (fragment.mFragmentManager == null || fragment.mFragmentManager == this.f2900a) {
            return super.remove(fragment);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public void runOnCommitRunnables() {
        if (this.t == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.t.size()) {
                this.t = null;
                return;
            } else {
                this.t.get(i2).run();
                i = i2 + 1;
            }
        }
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction setMaxLifecycle(Fragment fragment, Lifecycle.State state) {
        if (fragment.mFragmentManager != this.f2900a) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.f2900a);
        } else if (state == Lifecycle.State.INITIALIZED && fragment.mState > -1) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + " after the Fragment has been created");
        } else if (state != Lifecycle.State.DESTROYED) {
            return super.setMaxLifecycle(fragment, state);
        } else {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
        }
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction setPrimaryNavigationFragment(Fragment fragment) {
        if (fragment == null || fragment.mFragmentManager == null || fragment.mFragmentManager == this.f2900a) {
            return super.setPrimaryNavigationFragment(fragment);
        }
        throw new IllegalStateException("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction show(Fragment fragment) {
        if (fragment.mFragmentManager == null || fragment.mFragmentManager == this.f2900a) {
            return super.show(fragment);
        }
        throw new IllegalStateException("Cannot show Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f2901c >= 0) {
            sb.append(" #");
            sb.append(this.f2901c);
        }
        if (this.l != null) {
            sb.append(" ");
            sb.append(this.l);
        }
        sb.append(i.d);
        return sb.toString();
    }
}
