package android.widget;

import android.app.LocalActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TabWidget;
import com.android.internal.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4181928-dex2jar.jar:android/widget/TabHost.class */
public class TabHost extends FrameLayout implements ViewTreeObserver.OnTouchModeChangeListener {
    private static final int TABWIDGET_LOCATION_BOTTOM = 3;
    private static final int TABWIDGET_LOCATION_LEFT = 0;
    private static final int TABWIDGET_LOCATION_RIGHT = 2;
    private static final int TABWIDGET_LOCATION_TOP = 1;
    protected int mCurrentTab;
    private View mCurrentView;
    protected LocalActivityManager mLocalActivityManager;
    private OnTabChangeListener mOnTabChangeListener;
    private FrameLayout mTabContent;
    private View.OnKeyListener mTabKeyListener;
    private int mTabLayoutId;
    private List<TabSpec> mTabSpecs;
    private TabWidget mTabWidget;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/TabHost$ContentStrategy.class */
    public interface ContentStrategy {
        View getContentView();

        void tabClosed();
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/TabHost$FactoryContentStrategy.class */
    private class FactoryContentStrategy implements ContentStrategy {
        private TabContentFactory mFactory;
        private View mTabContent;
        private final CharSequence mTag;

        public FactoryContentStrategy(CharSequence charSequence, TabContentFactory tabContentFactory) {
            this.mTag = charSequence;
            this.mFactory = tabContentFactory;
        }

        @Override // android.widget.TabHost.ContentStrategy
        public View getContentView() {
            if (this.mTabContent == null) {
                this.mTabContent = this.mFactory.createTabContent(this.mTag.toString());
            }
            this.mTabContent.setVisibility(0);
            return this.mTabContent;
        }

        @Override // android.widget.TabHost.ContentStrategy
        public void tabClosed() {
            this.mTabContent.setVisibility(8);
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/TabHost$IndicatorStrategy.class */
    private interface IndicatorStrategy {
        View createIndicatorView();
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/TabHost$IntentContentStrategy.class */
    private class IntentContentStrategy implements ContentStrategy {
        private final Intent mIntent;
        private View mLaunchedView;
        private final String mTag;

        private IntentContentStrategy(String str, Intent intent) {
            this.mTag = str;
            this.mIntent = intent;
        }

        @Override // android.widget.TabHost.ContentStrategy
        public View getContentView() {
            if (TabHost.this.mLocalActivityManager == null) {
                throw new IllegalStateException("Did you forget to call 'public void setup(LocalActivityManager activityGroup)'?");
            }
            Window startActivity = TabHost.this.mLocalActivityManager.startActivity(this.mTag, this.mIntent);
            View decorView = startActivity != null ? startActivity.getDecorView() : null;
            if (this.mLaunchedView != decorView && this.mLaunchedView != null && this.mLaunchedView.getParent() != null) {
                TabHost.this.mTabContent.removeView(this.mLaunchedView);
            }
            this.mLaunchedView = decorView;
            if (this.mLaunchedView != null) {
                this.mLaunchedView.setVisibility(0);
                this.mLaunchedView.setFocusableInTouchMode(true);
                ((ViewGroup) this.mLaunchedView).setDescendantFocusability(262144);
            }
            return this.mLaunchedView;
        }

        @Override // android.widget.TabHost.ContentStrategy
        public void tabClosed() {
            if (this.mLaunchedView != null) {
                this.mLaunchedView.setVisibility(8);
            }
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/TabHost$LabelAndIconIndicatorStrategy.class */
    private class LabelAndIconIndicatorStrategy implements IndicatorStrategy {
        private final Drawable mIcon;
        private final CharSequence mLabel;

        private LabelAndIconIndicatorStrategy(CharSequence charSequence, Drawable drawable) {
            this.mLabel = charSequence;
            this.mIcon = drawable;
        }

        @Override // android.widget.TabHost.IndicatorStrategy
        public View createIndicatorView() {
            Context context = TabHost.this.getContext();
            View inflate = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(TabHost.this.mTabLayoutId, (ViewGroup) TabHost.this.mTabWidget, false);
            TextView textView = (TextView) inflate.findViewById(16908310);
            ImageView imageView = (ImageView) inflate.findViewById(16908294);
            boolean z = true;
            if (imageView.getVisibility() == 8) {
                z = TextUtils.isEmpty(this.mLabel);
            }
            textView.setText(this.mLabel);
            if (z && this.mIcon != null) {
                imageView.setImageDrawable(this.mIcon);
                imageView.setVisibility(0);
            }
            if (context.getApplicationInfo().targetSdkVersion <= 4) {
                inflate.setBackgroundResource(R.drawable.tab_indicator_v4);
                textView.setTextColor(context.getResources().getColorStateList(R.color.tab_indicator_text_v4));
            }
            return inflate;
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/TabHost$LabelIndicatorStrategy.class */
    private class LabelIndicatorStrategy implements IndicatorStrategy {
        private final CharSequence mLabel;

        private LabelIndicatorStrategy(CharSequence charSequence) {
            this.mLabel = charSequence;
        }

        @Override // android.widget.TabHost.IndicatorStrategy
        public View createIndicatorView() {
            Context context = TabHost.this.getContext();
            View inflate = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(TabHost.this.mTabLayoutId, (ViewGroup) TabHost.this.mTabWidget, false);
            TextView textView = (TextView) inflate.findViewById(16908310);
            textView.setText(this.mLabel);
            if (context.getApplicationInfo().targetSdkVersion <= 4) {
                inflate.setBackgroundResource(R.drawable.tab_indicator_v4);
                textView.setTextColor(context.getResources().getColorStateList(R.color.tab_indicator_text_v4));
            }
            return inflate;
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/TabHost$OnTabChangeListener.class */
    public interface OnTabChangeListener {
        void onTabChanged(String str);
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/TabHost$TabContentFactory.class */
    public interface TabContentFactory {
        View createTabContent(String str);
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/TabHost$TabSpec.class */
    public class TabSpec {
        private ContentStrategy mContentStrategy;
        private IndicatorStrategy mIndicatorStrategy;
        private String mTag;

        private TabSpec(String str) {
            this.mTag = str;
        }

        public String getTag() {
            return this.mTag;
        }

        public TabSpec setContent(int i) {
            this.mContentStrategy = new ViewIdContentStrategy(i);
            return this;
        }

        public TabSpec setContent(Intent intent) {
            this.mContentStrategy = new IntentContentStrategy(this.mTag, intent);
            return this;
        }

        public TabSpec setContent(TabContentFactory tabContentFactory) {
            this.mContentStrategy = new FactoryContentStrategy(this.mTag, tabContentFactory);
            return this;
        }

        public TabSpec setIndicator(View view) {
            this.mIndicatorStrategy = new ViewIndicatorStrategy(view);
            return this;
        }

        public TabSpec setIndicator(CharSequence charSequence) {
            this.mIndicatorStrategy = new LabelIndicatorStrategy(charSequence);
            return this;
        }

        public TabSpec setIndicator(CharSequence charSequence, Drawable drawable) {
            this.mIndicatorStrategy = new LabelAndIconIndicatorStrategy(charSequence, drawable);
            return this;
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/TabHost$ViewIdContentStrategy.class */
    private class ViewIdContentStrategy implements ContentStrategy {
        private final View mView;

        private ViewIdContentStrategy(int i) {
            this.mView = TabHost.this.mTabContent.findViewById(i);
            if (this.mView == null) {
                throw new RuntimeException("Could not create tab content because could not find view with id " + i);
            }
            this.mView.setVisibility(8);
        }

        @Override // android.widget.TabHost.ContentStrategy
        public View getContentView() {
            this.mView.setVisibility(0);
            return this.mView;
        }

        @Override // android.widget.TabHost.ContentStrategy
        public void tabClosed() {
            this.mView.setVisibility(8);
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/TabHost$ViewIndicatorStrategy.class */
    private class ViewIndicatorStrategy implements IndicatorStrategy {
        private final View mView;

        private ViewIndicatorStrategy(View view) {
            this.mView = view;
        }

        @Override // android.widget.TabHost.IndicatorStrategy
        public View createIndicatorView() {
            return this.mView;
        }
    }

    public TabHost(Context context) {
        super(context);
        this.mTabSpecs = new ArrayList(2);
        this.mCurrentTab = -1;
        this.mCurrentView = null;
        this.mLocalActivityManager = null;
        initTabHost();
    }

    public TabHost(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842883);
    }

    public TabHost(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public TabHost(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet);
        this.mTabSpecs = new ArrayList(2);
        this.mCurrentTab = -1;
        this.mCurrentView = null;
        this.mLocalActivityManager = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TabWidget, i, i2);
        this.mTabLayoutId = obtainStyledAttributes.getResourceId(4, 0);
        obtainStyledAttributes.recycle();
        if (this.mTabLayoutId == 0) {
            this.mTabLayoutId = R.layout.tab_indicator_holo;
        }
        initTabHost();
    }

    private int getTabWidgetLocation() {
        switch (this.mTabWidget.getOrientation()) {
            case 1:
                return this.mTabContent.getLeft() < this.mTabWidget.getLeft() ? 2 : 0;
            default:
                return this.mTabContent.getTop() < this.mTabWidget.getTop() ? 3 : 1;
        }
    }

    private void initTabHost() {
        setFocusableInTouchMode(true);
        setDescendantFocusability(262144);
        this.mCurrentTab = -1;
        this.mCurrentView = null;
    }

    private void invokeOnTabChangeListener() {
        if (this.mOnTabChangeListener != null) {
            this.mOnTabChangeListener.onTabChanged(getCurrentTabTag());
        }
    }

    public void addTab(TabSpec tabSpec) {
        if (tabSpec.mIndicatorStrategy == null) {
            throw new IllegalArgumentException("you must specify a way to create the tab indicator.");
        }
        if (tabSpec.mContentStrategy == null) {
            throw new IllegalArgumentException("you must specify a way to create the tab content");
        }
        View createIndicatorView = tabSpec.mIndicatorStrategy.createIndicatorView();
        createIndicatorView.setOnKeyListener(this.mTabKeyListener);
        if (tabSpec.mIndicatorStrategy instanceof ViewIndicatorStrategy) {
            this.mTabWidget.setStripEnabled(false);
        }
        this.mTabWidget.addView(createIndicatorView);
        this.mTabSpecs.add(tabSpec);
        if (this.mCurrentTab == -1) {
            setCurrentTab(0);
        }
    }

    public void clearAllTabs() {
        this.mTabWidget.removeAllViews();
        initTabHost();
        this.mTabContent.removeAllViews();
        this.mTabSpecs.clear();
        requestLayout();
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int i;
        int i2;
        int i3;
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        boolean z = dispatchKeyEvent;
        if (!dispatchKeyEvent) {
            z = dispatchKeyEvent;
            if (keyEvent.getAction() == 0) {
                z = dispatchKeyEvent;
                if (this.mCurrentView != null) {
                    z = dispatchKeyEvent;
                    if (this.mCurrentView.isRootNamespace()) {
                        z = dispatchKeyEvent;
                        if (this.mCurrentView.hasFocus()) {
                            switch (getTabWidgetLocation()) {
                                case 0:
                                    i = 21;
                                    i2 = 17;
                                    i3 = 1;
                                    break;
                                case 1:
                                default:
                                    i = 19;
                                    i2 = 33;
                                    i3 = 2;
                                    break;
                                case 2:
                                    i = 22;
                                    i2 = 66;
                                    i3 = 3;
                                    break;
                                case 3:
                                    i = 20;
                                    i2 = 130;
                                    i3 = 4;
                                    break;
                            }
                            z = dispatchKeyEvent;
                            if (keyEvent.getKeyCode() == i) {
                                z = dispatchKeyEvent;
                                if (this.mCurrentView.findFocus().focusSearch(i2) == null) {
                                    this.mTabWidget.getChildTabViewAt(this.mCurrentTab).requestFocus();
                                    playSoundEffect(i3);
                                    z = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchWindowFocusChanged(boolean z) {
        if (this.mCurrentView != null) {
            this.mCurrentView.dispatchWindowFocusChanged(z);
        }
    }

    public int getCurrentTab() {
        return this.mCurrentTab;
    }

    public String getCurrentTabTag() {
        if (this.mCurrentTab < 0 || this.mCurrentTab >= this.mTabSpecs.size()) {
            return null;
        }
        return this.mTabSpecs.get(this.mCurrentTab).getTag();
    }

    public View getCurrentTabView() {
        if (this.mCurrentTab < 0 || this.mCurrentTab >= this.mTabSpecs.size()) {
            return null;
        }
        return this.mTabWidget.getChildTabViewAt(this.mCurrentTab);
    }

    public View getCurrentView() {
        return this.mCurrentView;
    }

    public FrameLayout getTabContentView() {
        return this.mTabContent;
    }

    public TabWidget getTabWidget() {
        return this.mTabWidget;
    }

    public TabSpec newTabSpec(String str) {
        return new TabSpec(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnTouchModeChangeListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnTouchModeChangeListener(this);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(TabHost.class.getName());
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(TabHost.class.getName());
    }

    @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
    public void onTouchModeChanged(boolean z) {
        if (z || this.mCurrentView == null) {
            return;
        }
        if (!this.mCurrentView.hasFocus() || this.mCurrentView.isFocused()) {
            this.mTabWidget.getChildTabViewAt(this.mCurrentTab).requestFocus();
        }
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEvent(int i) {
    }

    public void setCurrentTab(int i) {
        if (i < 0 || i >= this.mTabSpecs.size() || i == this.mCurrentTab) {
            return;
        }
        if (this.mCurrentTab != -1) {
            this.mTabSpecs.get(this.mCurrentTab).mContentStrategy.tabClosed();
        }
        this.mCurrentTab = i;
        TabSpec tabSpec = this.mTabSpecs.get(i);
        this.mTabWidget.focusCurrentTab(this.mCurrentTab);
        this.mCurrentView = tabSpec.mContentStrategy.getContentView();
        if (this.mCurrentView.getParent() == null) {
            this.mTabContent.addView(this.mCurrentView, new ViewGroup.LayoutParams(-1, -1));
        }
        if (!this.mTabWidget.hasFocus()) {
            this.mCurrentView.requestFocus();
        }
        invokeOnTabChangeListener();
    }

    public void setCurrentTabByTag(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mTabSpecs.size()) {
                return;
            }
            if (this.mTabSpecs.get(i2).getTag().equals(str)) {
                setCurrentTab(i2);
                return;
            }
            i = i2 + 1;
        }
    }

    public void setOnTabChangedListener(OnTabChangeListener onTabChangeListener) {
        this.mOnTabChangeListener = onTabChangeListener;
    }

    public void setup() {
        this.mTabWidget = (TabWidget) findViewById(16908307);
        if (this.mTabWidget == null) {
            throw new RuntimeException("Your TabHost must have a TabWidget whose id attribute is 'android.R.id.tabs'");
        }
        this.mTabKeyListener = new View.OnKeyListener() { // from class: android.widget.TabHost.1
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                switch (i) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 66:
                        return false;
                    default:
                        TabHost.this.mTabContent.requestFocus(2);
                        return TabHost.this.mTabContent.dispatchKeyEvent(keyEvent);
                }
            }
        };
        this.mTabWidget.setTabSelectionListener(new TabWidget.OnTabSelectionChanged() { // from class: android.widget.TabHost.2
            @Override // android.widget.TabWidget.OnTabSelectionChanged
            public void onTabSelectionChanged(int i, boolean z) {
                TabHost.this.setCurrentTab(i);
                if (z) {
                    TabHost.this.mTabContent.requestFocus(2);
                }
            }
        });
        this.mTabContent = (FrameLayout) findViewById(16908305);
        if (this.mTabContent == null) {
            throw new RuntimeException("Your TabHost must have a FrameLayout whose id attribute is 'android.R.id.tabcontent'");
        }
    }

    public void setup(LocalActivityManager localActivityManager) {
        setup();
        this.mLocalActivityManager = localActivityManager;
    }
}
