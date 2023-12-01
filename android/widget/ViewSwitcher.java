package android.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;

/* loaded from: source-4181928-dex2jar.jar:android/widget/ViewSwitcher.class */
public class ViewSwitcher extends ViewAnimator {
    ViewFactory mFactory;

    /* loaded from: source-4181928-dex2jar.jar:android/widget/ViewSwitcher$ViewFactory.class */
    public interface ViewFactory {
        View makeView();
    }

    public ViewSwitcher(Context context) {
        super(context);
    }

    public ViewSwitcher(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private View obtainView() {
        View makeView = this.mFactory.makeView();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) makeView.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams;
        if (layoutParams == null) {
            layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        }
        addView(makeView, layoutParams2);
        return makeView;
    }

    @Override // android.widget.ViewAnimator, android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() >= 2) {
            throw new IllegalStateException("Can't add more than 2 views to a ViewSwitcher");
        }
        super.addView(view, i, layoutParams);
    }

    public View getNextView() {
        return getChildAt(this.mWhichChild == 0 ? 1 : 0);
    }

    @Override // android.widget.ViewAnimator, android.widget.FrameLayout, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ViewSwitcher.class.getName());
    }

    @Override // android.widget.ViewAnimator, android.widget.FrameLayout, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ViewSwitcher.class.getName());
    }

    public void reset() {
        this.mFirstTime = true;
        View childAt = getChildAt(0);
        if (childAt != null) {
            childAt.setVisibility(8);
        }
        View childAt2 = getChildAt(1);
        if (childAt2 != null) {
            childAt2.setVisibility(8);
        }
    }

    public void setFactory(ViewFactory viewFactory) {
        this.mFactory = viewFactory;
        obtainView();
        obtainView();
    }
}
