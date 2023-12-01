package androidx.fragment.app;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.PagerAdapter;

@Deprecated
/* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/FragmentPagerAdapter.class */
public abstract class FragmentPagerAdapter extends PagerAdapter {
    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;
    @Deprecated
    public static final int BEHAVIOR_SET_USER_VISIBLE_HINT = 0;

    /* renamed from: a  reason: collision with root package name */
    private final FragmentManager f2995a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private FragmentTransaction f2996c;
    private Fragment d;
    private boolean e;

    @Deprecated
    public FragmentPagerAdapter(FragmentManager fragmentManager) {
        this(fragmentManager, 0);
    }

    public FragmentPagerAdapter(FragmentManager fragmentManager, int i) {
        this.f2996c = null;
        this.d = null;
        this.f2995a = fragmentManager;
        this.b = i;
    }

    private static String a(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f2996c == null) {
            this.f2996c = this.f2995a.beginTransaction();
        }
        this.f2996c.detach(fragment);
        if (fragment.equals(this.d)) {
            this.d = null;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(ViewGroup viewGroup) {
        FragmentTransaction fragmentTransaction = this.f2996c;
        if (fragmentTransaction != null) {
            if (!this.e) {
                try {
                    this.e = true;
                    fragmentTransaction.commitNowAllowingStateLoss();
                } finally {
                    this.e = false;
                }
            }
            this.f2996c = null;
        }
    }

    public abstract Fragment getItem(int i);

    public long getItemId(int i) {
        return i;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        Fragment fragment;
        if (this.f2996c == null) {
            this.f2996c = this.f2995a.beginTransaction();
        }
        long itemId = getItemId(i);
        Fragment findFragmentByTag = this.f2995a.findFragmentByTag(a(viewGroup.getId(), itemId));
        if (findFragmentByTag != null) {
            this.f2996c.attach(findFragmentByTag);
            fragment = findFragmentByTag;
        } else {
            Fragment item = getItem(i);
            this.f2996c.add(viewGroup.getId(), item, a(viewGroup.getId(), itemId));
            fragment = item;
        }
        if (fragment != this.d) {
            fragment.setMenuVisibility(false);
            if (this.b == 1) {
                this.f2996c.setMaxLifecycle(fragment, Lifecycle.State.STARTED);
                return fragment;
            }
            fragment.setUserVisibleHint(false);
        }
        return fragment;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Parcelable saveState() {
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.d;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                if (this.b == 1) {
                    if (this.f2996c == null) {
                        this.f2996c = this.f2995a.beginTransaction();
                    }
                    this.f2996c.setMaxLifecycle(this.d, Lifecycle.State.STARTED);
                } else {
                    this.d.setUserVisibleHint(false);
                }
            }
            fragment.setMenuVisibility(true);
            if (this.b == 1) {
                if (this.f2996c == null) {
                    this.f2996c = this.f2995a.beginTransaction();
                }
                this.f2996c.setMaxLifecycle(fragment, Lifecycle.State.RESUMED);
            } else {
                fragment.setUserVisibleHint(true);
            }
            this.d = fragment;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void startUpdate(ViewGroup viewGroup) {
        if (viewGroup.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }
}
