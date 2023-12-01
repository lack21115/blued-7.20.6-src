package androidx.fragment.app;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import java.util.ArrayList;

@Deprecated
/* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/FragmentTabHost.class */
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<TabInfo> f2957a;
    private FrameLayout b;

    /* renamed from: c  reason: collision with root package name */
    private Context f2958c;
    private FragmentManager d;
    private int e;
    private TabHost.OnTabChangeListener f;
    private TabInfo g;
    private boolean h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/FragmentTabHost$DummyTabFactory.class */
    public static class DummyTabFactory implements TabHost.TabContentFactory {

        /* renamed from: a  reason: collision with root package name */
        private final Context f2959a;

        public DummyTabFactory(Context context) {
            this.f2959a = context;
        }

        @Override // android.widget.TabHost.TabContentFactory
        public View createTabContent(String str) {
            View view = new View(this.f2959a);
            view.setMinimumWidth(0);
            view.setMinimumHeight(0);
            return view;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/FragmentTabHost$SavedState.class */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.fragment.app.FragmentTabHost.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        String f2960a;

        SavedState(Parcel parcel) {
            super(parcel);
            this.f2960a = parcel.readString();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.f2960a + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f2960a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/fragment/app/FragmentTabHost$TabInfo.class */
    public static final class TabInfo {

        /* renamed from: a  reason: collision with root package name */
        final String f2961a;
        final Class<?> b;

        /* renamed from: c  reason: collision with root package name */
        final Bundle f2962c;
        Fragment d;

        TabInfo(String str, Class<?> cls, Bundle bundle) {
            this.f2961a = str;
            this.b = cls;
            this.f2962c = bundle;
        }
    }

    @Deprecated
    public FragmentTabHost(Context context) {
        super(context, null);
        this.f2957a = new ArrayList<>();
        a(context, (AttributeSet) null);
    }

    @Deprecated
    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2957a = new ArrayList<>();
        a(context, attributeSet);
    }

    private TabInfo a(String str) {
        int size = this.f2957a.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return null;
            }
            TabInfo tabInfo = this.f2957a.get(i2);
            if (tabInfo.f2961a.equals(str)) {
                return tabInfo;
            }
            i = i2 + 1;
        }
    }

    private FragmentTransaction a(String str, FragmentTransaction fragmentTransaction) {
        TabInfo a2 = a(str);
        FragmentTransaction fragmentTransaction2 = fragmentTransaction;
        if (this.g != a2) {
            fragmentTransaction2 = fragmentTransaction;
            if (fragmentTransaction == null) {
                fragmentTransaction2 = this.d.beginTransaction();
            }
            TabInfo tabInfo = this.g;
            if (tabInfo != null && tabInfo.d != null) {
                fragmentTransaction2.detach(this.g.d);
            }
            if (a2 != null) {
                if (a2.d == null) {
                    a2.d = this.d.getFragmentFactory().instantiate(this.f2958c.getClassLoader(), a2.b.getName());
                    a2.d.setArguments(a2.f2962c);
                    fragmentTransaction2.add(this.e, a2.d, a2.f2961a);
                } else {
                    fragmentTransaction2.attach(a2.d);
                }
            }
            this.g = a2;
        }
        return fragmentTransaction2;
    }

    private void a() {
        if (this.b == null) {
            FrameLayout frameLayout = (FrameLayout) findViewById(this.e);
            this.b = frameLayout;
            if (frameLayout != null) {
                return;
            }
            throw new IllegalStateException("No tab content FrameLayout found for id " + this.e);
        }
    }

    private void a(Context context) {
        if (findViewById(R.id.tabs) == null) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
            TabWidget tabWidget = new TabWidget(context);
            tabWidget.setId(R.id.tabs);
            tabWidget.setOrientation(0);
            linearLayout.addView(tabWidget, new LinearLayout.LayoutParams(-1, -2, 0.0f));
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setId(R.id.tabcontent);
            linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(0, 0, 0.0f));
            FrameLayout frameLayout2 = new FrameLayout(context);
            this.b = frameLayout2;
            frameLayout2.setId(this.e);
            linearLayout.addView(frameLayout2, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.inflatedId}, 0, 0);
        this.e = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    @Deprecated
    public void addTab(TabHost.TabSpec tabSpec, Class<?> cls, Bundle bundle) {
        tabSpec.setContent(new DummyTabFactory(this.f2958c));
        String tag = tabSpec.getTag();
        TabInfo tabInfo = new TabInfo(tag, cls, bundle);
        if (this.h) {
            tabInfo.d = this.d.findFragmentByTag(tag);
            if (tabInfo.d != null && !tabInfo.d.isDetached()) {
                FragmentTransaction beginTransaction = this.d.beginTransaction();
                beginTransaction.detach(tabInfo.d);
                beginTransaction.commit();
            }
        }
        this.f2957a.add(tabInfo);
        addTab(tabSpec);
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        int size = this.f2957a.size();
        FragmentTransaction fragmentTransaction = null;
        int i = 0;
        while (i < size) {
            TabInfo tabInfo = this.f2957a.get(i);
            tabInfo.d = this.d.findFragmentByTag(tabInfo.f2961a);
            FragmentTransaction fragmentTransaction2 = fragmentTransaction;
            if (tabInfo.d != null) {
                fragmentTransaction2 = fragmentTransaction;
                if (!tabInfo.d.isDetached()) {
                    if (tabInfo.f2961a.equals(currentTabTag)) {
                        this.g = tabInfo;
                        fragmentTransaction2 = fragmentTransaction;
                    } else {
                        fragmentTransaction2 = fragmentTransaction;
                        if (fragmentTransaction == null) {
                            fragmentTransaction2 = this.d.beginTransaction();
                        }
                        fragmentTransaction2.detach(tabInfo.d);
                    }
                }
            }
            i++;
            fragmentTransaction = fragmentTransaction2;
        }
        this.h = true;
        FragmentTransaction a2 = a(currentTabTag, fragmentTransaction);
        if (a2 != null) {
            a2.commit();
            this.d.executePendingTransactions();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.h = false;
    }

    @Override // android.view.View
    @Deprecated
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.f2960a);
    }

    @Override // android.view.View
    @Deprecated
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f2960a = getCurrentTabTag();
        return savedState;
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    @Deprecated
    public void onTabChanged(String str) {
        FragmentTransaction a2;
        if (this.h && (a2 = a(str, (FragmentTransaction) null)) != null) {
            a2.commit();
        }
        TabHost.OnTabChangeListener onTabChangeListener = this.f;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setOnTabChangedListener(TabHost.OnTabChangeListener onTabChangeListener) {
        this.f = onTabChangeListener;
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    @Deprecated
    public void setup(Context context, FragmentManager fragmentManager) {
        a(context);
        super.setup();
        this.f2958c = context;
        this.d = fragmentManager;
        a();
    }

    @Deprecated
    public void setup(Context context, FragmentManager fragmentManager, int i) {
        a(context);
        super.setup();
        this.f2958c = context;
        this.d = fragmentManager;
        this.e = i;
        a();
        this.b.setId(i);
        if (getId() == -1) {
            setId(R.id.tabhost);
        }
    }
}
