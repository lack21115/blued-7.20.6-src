package android.widget;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.RemotableViewMethod;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.RemoteViews;
import android.widget.RemoteViewsAdapter;
import com.android.internal.R;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: source-4181928-dex2jar.jar:android/widget/AdapterViewAnimator.class */
public abstract class AdapterViewAnimator extends AdapterView<Adapter> implements RemoteViewsAdapter.RemoteAdapterConnectionCallback, Advanceable {
    private static final int DEFAULT_ANIMATION_DURATION = 200;
    private static final String TAG = "RemoteViewAnimator";
    static final int TOUCH_MODE_DOWN_IN_CURRENT_VIEW = 1;
    static final int TOUCH_MODE_HANDLED = 2;
    static final int TOUCH_MODE_NONE = 0;
    int mActiveOffset;
    Adapter mAdapter;
    boolean mAnimateFirstTime;
    int mCurrentWindowEnd;
    int mCurrentWindowStart;
    int mCurrentWindowStartUnbounded;
    AdapterView<Adapter>.AdapterDataSetObserver mDataSetObserver;
    boolean mDeferNotifyDataSetChanged;
    boolean mFirstTime;
    ObjectAnimator mInAnimation;
    boolean mLoopViews;
    int mMaxNumActiveViews;
    ObjectAnimator mOutAnimation;
    private Runnable mPendingCheckForTap;
    ArrayList<Integer> mPreviousViews;
    int mReferenceChildHeight;
    int mReferenceChildWidth;
    RemoteViewsAdapter mRemoteViewsAdapter;
    private int mRestoreWhichChild;
    private int mTouchMode;
    HashMap<Integer, ViewAndMetaData> mViewsMap;
    int mWhichChild;

    /* loaded from: source-4181928-dex2jar.jar:android/widget/AdapterViewAnimator$CheckForTap.class */
    final class CheckForTap implements Runnable {
        CheckForTap() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AdapterViewAnimator.this.mTouchMode == 1) {
                AdapterViewAnimator.this.showTapFeedback(AdapterViewAnimator.this.getCurrentView());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/AdapterViewAnimator$SavedState.class */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.widget.AdapterViewAnimator.SavedState.1
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
        int whichChild;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.whichChild = parcel.readInt();
        }

        SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.whichChild = i;
        }

        public String toString() {
            return "AdapterViewAnimator.SavedState{ whichChild = " + this.whichChild + " }";
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.whichChild);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/AdapterViewAnimator$ViewAndMetaData.class */
    public class ViewAndMetaData {
        int adapterPosition;
        long itemId;
        int relativeIndex;
        View view;

        ViewAndMetaData(View view, int i, int i2, long j) {
            this.view = view;
            this.relativeIndex = i;
            this.adapterPosition = i2;
            this.itemId = j;
        }
    }

    public AdapterViewAnimator(Context context) {
        this(context, null);
    }

    public AdapterViewAnimator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdapterViewAnimator(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public AdapterViewAnimator(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mWhichChild = 0;
        this.mRestoreWhichChild = -1;
        this.mAnimateFirstTime = true;
        this.mActiveOffset = 0;
        this.mMaxNumActiveViews = 1;
        this.mViewsMap = new HashMap<>();
        this.mCurrentWindowStart = 0;
        this.mCurrentWindowEnd = -1;
        this.mCurrentWindowStartUnbounded = 0;
        this.mDeferNotifyDataSetChanged = false;
        this.mFirstTime = true;
        this.mLoopViews = true;
        this.mReferenceChildWidth = -1;
        this.mReferenceChildHeight = -1;
        this.mTouchMode = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AdapterViewAnimator, i, i2);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId > 0) {
            setInAnimation(context, resourceId);
        } else {
            setInAnimation(getDefaultInAnimation());
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
        if (resourceId2 > 0) {
            setOutAnimation(context, resourceId2);
        } else {
            setOutAnimation(getDefaultOutAnimation());
        }
        setAnimateFirstView(obtainStyledAttributes.getBoolean(2, true));
        this.mLoopViews = obtainStyledAttributes.getBoolean(3, false);
        obtainStyledAttributes.recycle();
        initViewAnimator();
    }

    private void addChild(View view) {
        addViewInLayout(view, -1, createOrReuseLayoutParams(view));
        if (this.mReferenceChildWidth == -1 || this.mReferenceChildHeight == -1) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            view.measure(makeMeasureSpec, makeMeasureSpec);
            this.mReferenceChildWidth = view.getMeasuredWidth();
            this.mReferenceChildHeight = view.getMeasuredHeight();
        }
    }

    private ViewAndMetaData getMetaDataForChild(View view) {
        for (ViewAndMetaData viewAndMetaData : this.mViewsMap.values()) {
            if (viewAndMetaData.view == view) {
                return viewAndMetaData;
            }
        }
        return null;
    }

    private void initViewAnimator() {
        this.mPreviousViews = new ArrayList<>();
    }

    private void measureChildren() {
        int childCount = getChildCount();
        int measuredWidth = getMeasuredWidth();
        int i = this.mPaddingLeft;
        int i2 = this.mPaddingRight;
        int measuredHeight = getMeasuredHeight();
        int i3 = this.mPaddingTop;
        int i4 = this.mPaddingBottom;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= childCount) {
                return;
            }
            getChildAt(i6).measure(View.MeasureSpec.makeMeasureSpec((measuredWidth - i) - i2, 1073741824), View.MeasureSpec.makeMeasureSpec((measuredHeight - i3) - i4, 1073741824));
            i5 = i6 + 1;
        }
    }

    private void setDisplayedChild(int i, boolean z) {
        if (this.mAdapter != null) {
            this.mWhichChild = i;
            if (i >= getWindowSize()) {
                this.mWhichChild = this.mLoopViews ? 0 : getWindowSize() - 1;
            } else if (i < 0) {
                this.mWhichChild = this.mLoopViews ? getWindowSize() - 1 : 0;
            }
            boolean z2 = getFocusedChild() != null;
            showOnly(this.mWhichChild, z);
            if (z2) {
                requestFocus(2);
            }
        }
    }

    @Override // android.widget.Advanceable
    public void advance() {
        showNext();
    }

    void applyTransformForChildAtIndex(View view, int i) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cancelHandleClick() {
        View currentView = getCurrentView();
        if (currentView != null) {
            hideTapFeedback(currentView);
        }
        this.mTouchMode = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void checkForAndHandleDataChanged() {
        if (this.mDataChanged) {
            post(new Runnable() { // from class: android.widget.AdapterViewAnimator.2
                @Override // java.lang.Runnable
                public void run() {
                    AdapterViewAnimator.this.handleDataChanged();
                    if (AdapterViewAnimator.this.mWhichChild >= AdapterViewAnimator.this.getWindowSize()) {
                        AdapterViewAnimator.this.mWhichChild = 0;
                        AdapterViewAnimator.this.showOnly(AdapterViewAnimator.this.mWhichChild, false);
                    } else if (AdapterViewAnimator.this.mOldItemCount != AdapterViewAnimator.this.getCount()) {
                        AdapterViewAnimator.this.showOnly(AdapterViewAnimator.this.mWhichChild, false);
                    }
                    AdapterViewAnimator.this.refreshChildren();
                    AdapterViewAnimator.this.requestLayout();
                }
            });
        }
        this.mDataChanged = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void configureViewAnimator(int i, int i2) {
        if (i2 > i - 1) {
        }
        this.mMaxNumActiveViews = i;
        this.mActiveOffset = i2;
        this.mPreviousViews.clear();
        this.mViewsMap.clear();
        removeAllViewsInLayout();
        this.mCurrentWindowStart = 0;
        this.mCurrentWindowEnd = -1;
    }

    ViewGroup.LayoutParams createOrReuseLayoutParams(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return layoutParams instanceof ViewGroup.LayoutParams ? layoutParams : new ViewGroup.LayoutParams(0, 0);
    }

    @Override // android.widget.RemoteViewsAdapter.RemoteAdapterConnectionCallback
    public void deferNotifyDataSetChanged() {
        this.mDeferNotifyDataSetChanged = true;
    }

    @Override // android.widget.Advanceable
    public void fyiWillBeAdvancedByHostKThx() {
    }

    @Override // android.widget.AdapterView
    public Adapter getAdapter() {
        return this.mAdapter;
    }

    @Override // android.view.View
    public int getBaseline() {
        return getCurrentView() != null ? getCurrentView().getBaseline() : super.getBaseline();
    }

    public View getCurrentView() {
        return getViewAtRelativeIndex(this.mActiveOffset);
    }

    ObjectAnimator getDefaultInAnimation() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((Object) null, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(200L);
        return ofFloat;
    }

    ObjectAnimator getDefaultOutAnimation() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((Object) null, "alpha", 1.0f, 0.0f);
        ofFloat.setDuration(200L);
        return ofFloat;
    }

    public int getDisplayedChild() {
        return this.mWhichChild;
    }

    FrameLayout getFrameForChild() {
        return new FrameLayout(this.mContext);
    }

    public ObjectAnimator getInAnimation() {
        return this.mInAnimation;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getNumActiveViews() {
        return this.mAdapter != null ? Math.min(getCount() + 1, this.mMaxNumActiveViews) : this.mMaxNumActiveViews;
    }

    public ObjectAnimator getOutAnimation() {
        return this.mOutAnimation;
    }

    @Override // android.widget.AdapterView
    public View getSelectedView() {
        return getViewAtRelativeIndex(this.mActiveOffset);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getViewAtRelativeIndex(int i) {
        if (i < 0 || i > getNumActiveViews() - 1 || this.mAdapter == null) {
            return null;
        }
        int modulo = modulo(this.mCurrentWindowStartUnbounded + i, getWindowSize());
        if (this.mViewsMap.get(Integer.valueOf(modulo)) != null) {
            return this.mViewsMap.get(Integer.valueOf(modulo)).view;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getWindowSize() {
        if (this.mAdapter != null) {
            int count = getCount();
            int i = count;
            if (count <= getNumActiveViews()) {
                i = count;
                if (this.mLoopViews) {
                    i = count * this.mMaxNumActiveViews;
                }
            }
            return i;
        }
        return 0;
    }

    void hideTapFeedback(View view) {
        view.setPressed(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int modulo(int i, int i2) {
        if (i2 > 0) {
            return ((i % i2) + i2) % i2;
        }
        return 0;
    }

    @Override // android.widget.AdapterView, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(AdapterViewAnimator.class.getName());
    }

    @Override // android.widget.AdapterView, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(AdapterViewAnimator.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        checkForAndHandleDataChanged();
        int childCount = getChildCount();
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= childCount) {
                return;
            }
            View childAt = getChildAt(i6);
            childAt.layout(this.mPaddingLeft, this.mPaddingTop, this.mPaddingLeft + childAt.getMeasuredWidth(), this.mPaddingTop + childAt.getMeasuredHeight());
            i5 = i6 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        boolean z = (this.mReferenceChildWidth == -1 || this.mReferenceChildHeight == -1) ? false : true;
        if (mode2 == 0) {
            i3 = z ? this.mReferenceChildHeight + this.mPaddingTop + this.mPaddingBottom : 0;
        } else {
            i3 = size2;
            if (mode2 == Integer.MIN_VALUE) {
                i3 = size2;
                if (z) {
                    i3 = this.mReferenceChildHeight + this.mPaddingTop + this.mPaddingBottom;
                    if (i3 > size2) {
                        i3 = size2 | 16777216;
                    }
                }
            }
        }
        if (mode == 0) {
            i4 = z ? this.mReferenceChildWidth + this.mPaddingLeft + this.mPaddingRight : 0;
        } else {
            i4 = size;
            if (mode2 == Integer.MIN_VALUE) {
                i4 = size;
                if (z) {
                    i4 = this.mReferenceChildWidth + this.mPaddingLeft + this.mPaddingRight;
                    if (i4 > size) {
                        i4 = size | 16777216;
                    }
                }
            }
        }
        setMeasuredDimension(i4, i3);
        measureChildren();
    }

    @Override // android.widget.RemoteViewsAdapter.RemoteAdapterConnectionCallback
    public boolean onRemoteAdapterConnected() {
        if (this.mRemoteViewsAdapter == this.mAdapter) {
            if (this.mRemoteViewsAdapter != null) {
                this.mRemoteViewsAdapter.superNotifyDataSetChanged();
                return true;
            }
            return false;
        }
        setAdapter(this.mRemoteViewsAdapter);
        if (this.mDeferNotifyDataSetChanged) {
            this.mRemoteViewsAdapter.notifyDataSetChanged();
            this.mDeferNotifyDataSetChanged = false;
        }
        if (this.mRestoreWhichChild > -1) {
            setDisplayedChild(this.mRestoreWhichChild, false);
            this.mRestoreWhichChild = -1;
            return false;
        }
        return false;
    }

    @Override // android.widget.RemoteViewsAdapter.RemoteAdapterConnectionCallback
    public void onRemoteAdapterDisconnected() {
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mWhichChild = savedState.whichChild;
        if (this.mRemoteViewsAdapter == null || this.mAdapter != null) {
            setDisplayedChild(this.mWhichChild, false);
        } else {
            this.mRestoreWhichChild = this.mWhichChild;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (this.mRemoteViewsAdapter != null) {
            this.mRemoteViewsAdapter.saveRemoteViewsCache();
        }
        return new SavedState(onSaveInstanceState, this.mWhichChild);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                View currentView = getCurrentView();
                if (currentView == null || !isTransformedTouchPointInView(motionEvent.getX(), motionEvent.getY(), currentView, null)) {
                    return false;
                }
                if (this.mPendingCheckForTap == null) {
                    this.mPendingCheckForTap = new CheckForTap();
                }
                this.mTouchMode = 1;
                postDelayed(this.mPendingCheckForTap, ViewConfiguration.getTapTimeout());
                return false;
            case 1:
                boolean z = false;
                if (this.mTouchMode == 1) {
                    final View currentView2 = getCurrentView();
                    final ViewAndMetaData metaDataForChild = getMetaDataForChild(currentView2);
                    z = false;
                    if (currentView2 != null) {
                        z = false;
                        if (isTransformedTouchPointInView(motionEvent.getX(), motionEvent.getY(), currentView2, null)) {
                            Handler handler = getHandler();
                            if (handler != null) {
                                handler.removeCallbacks(this.mPendingCheckForTap);
                            }
                            showTapFeedback(currentView2);
                            postDelayed(new Runnable() { // from class: android.widget.AdapterViewAnimator.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AdapterViewAnimator.this.hideTapFeedback(currentView2);
                                    AdapterViewAnimator.this.post(new Runnable() { // from class: android.widget.AdapterViewAnimator.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            if (metaDataForChild != null) {
                                                AdapterViewAnimator.this.performItemClick(currentView2, metaDataForChild.adapterPosition, metaDataForChild.itemId);
                                            } else {
                                                AdapterViewAnimator.this.performItemClick(currentView2, 0, 0L);
                                            }
                                        }
                                    });
                                }
                            }, ViewConfiguration.getPressedStateDuration());
                            z = true;
                        }
                    }
                }
                this.mTouchMode = 0;
                return z;
            case 2:
            case 4:
            case 5:
            case 6:
            default:
                return false;
            case 3:
                View currentView3 = getCurrentView();
                if (currentView3 != null) {
                    hideTapFeedback(currentView3);
                }
                this.mTouchMode = 0;
                return false;
        }
    }

    void refreshChildren() {
        if (this.mAdapter == null) {
            return;
        }
        int i = this.mCurrentWindowStart;
        while (true) {
            int i2 = i;
            if (i2 > this.mCurrentWindowEnd) {
                return;
            }
            int modulo = modulo(i2, getWindowSize());
            View view = this.mAdapter.getView(modulo(i2, getCount()), null, this);
            if (view.getImportantForAccessibility() == 0) {
                view.setImportantForAccessibility(1);
            }
            if (this.mViewsMap.containsKey(Integer.valueOf(modulo))) {
                FrameLayout frameLayout = (FrameLayout) this.mViewsMap.get(Integer.valueOf(modulo)).view;
                if (view != null) {
                    frameLayout.removeAllViewsInLayout();
                    frameLayout.addView(view);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // android.widget.AdapterView
    public void setAdapter(Adapter adapter) {
        if (this.mAdapter != null && this.mDataSetObserver != null) {
            this.mAdapter.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.mAdapter = adapter;
        checkFocus();
        if (this.mAdapter != null) {
            this.mDataSetObserver = new AdapterView.AdapterDataSetObserver();
            this.mAdapter.registerDataSetObserver(this.mDataSetObserver);
            this.mItemCount = this.mAdapter.getCount();
        }
        setFocusable(true);
        this.mWhichChild = 0;
        showOnly(this.mWhichChild, false);
    }

    public void setAnimateFirstView(boolean z) {
        this.mAnimateFirstTime = z;
    }

    @RemotableViewMethod
    public void setDisplayedChild(int i) {
        setDisplayedChild(i, true);
    }

    public void setInAnimation(ObjectAnimator objectAnimator) {
        this.mInAnimation = objectAnimator;
    }

    public void setInAnimation(Context context, int i) {
        setInAnimation((ObjectAnimator) AnimatorInflater.loadAnimator(context, i));
    }

    public void setOutAnimation(ObjectAnimator objectAnimator) {
        this.mOutAnimation = objectAnimator;
    }

    public void setOutAnimation(Context context, int i) {
        setOutAnimation((ObjectAnimator) AnimatorInflater.loadAnimator(context, i));
    }

    @RemotableViewMethod
    public void setRemoteViewsAdapter(Intent intent) {
        if (this.mRemoteViewsAdapter == null || !new Intent.FilterComparison(intent).equals(new Intent.FilterComparison(this.mRemoteViewsAdapter.getRemoteViewsServiceIntent()))) {
            this.mDeferNotifyDataSetChanged = false;
            this.mRemoteViewsAdapter = new RemoteViewsAdapter(getContext(), intent, this);
            if (this.mRemoteViewsAdapter.isDataReady()) {
                setAdapter(this.mRemoteViewsAdapter);
            }
        }
    }

    public void setRemoteViewsOnClickHandler(RemoteViews.OnClickHandler onClickHandler) {
        if (this.mRemoteViewsAdapter != null) {
            this.mRemoteViewsAdapter.setRemoteViewsOnClickHandler(onClickHandler);
        }
    }

    @Override // android.widget.AdapterView
    public void setSelection(int i) {
        setDisplayedChild(i);
    }

    public void showNext() {
        setDisplayedChild(this.mWhichChild + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void showOnly(int i, boolean z) {
        int count;
        boolean z2;
        if (this.mAdapter == null || (count = getCount()) == 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.mPreviousViews.size()) {
                break;
            }
            View view = this.mViewsMap.get(this.mPreviousViews.get(i3)).view;
            this.mViewsMap.remove(this.mPreviousViews.get(i3));
            view.clearAnimation();
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).removeAllViewsInLayout();
            }
            applyTransformForChildAtIndex(view, -1);
            removeViewInLayout(view);
            i2 = i3 + 1;
        }
        this.mPreviousViews.clear();
        int i4 = i - this.mActiveOffset;
        int numActiveViews = (getNumActiveViews() + i4) - 1;
        int max = Math.max(0, i4);
        int min = Math.min(count - 1, numActiveViews);
        if (this.mLoopViews) {
            max = i4;
            min = numActiveViews;
        }
        int modulo = modulo(max, getWindowSize());
        int modulo2 = modulo(min, getWindowSize());
        boolean z3 = modulo > modulo2;
        for (Integer num : this.mViewsMap.keySet()) {
            if (z3 || (num.intValue() >= modulo && num.intValue() <= modulo2)) {
                z2 = false;
                if (z3) {
                    z2 = false;
                    if (num.intValue() > modulo2) {
                        z2 = false;
                        if (num.intValue() < modulo) {
                            z2 = true;
                        }
                    }
                }
            } else {
                z2 = true;
            }
            if (z2) {
                View view2 = this.mViewsMap.get(num).view;
                int i5 = this.mViewsMap.get(num).relativeIndex;
                this.mPreviousViews.add(num);
                transformViewForTransition(i5, -1, view2, z);
            }
        }
        if (max != this.mCurrentWindowStart || min != this.mCurrentWindowEnd || i4 != this.mCurrentWindowStartUnbounded) {
            int i6 = max;
            while (true) {
                int i7 = i6;
                if (i7 > min) {
                    break;
                }
                int modulo3 = modulo(i7, getWindowSize());
                int i8 = this.mViewsMap.containsKey(Integer.valueOf(modulo3)) ? this.mViewsMap.get(Integer.valueOf(modulo3)).relativeIndex : -1;
                int i9 = i7 - i4;
                if (this.mViewsMap.containsKey(Integer.valueOf(modulo3)) && !this.mPreviousViews.contains(Integer.valueOf(modulo3))) {
                    View view3 = this.mViewsMap.get(Integer.valueOf(modulo3)).view;
                    this.mViewsMap.get(Integer.valueOf(modulo3)).relativeIndex = i9;
                    applyTransformForChildAtIndex(view3, i9);
                    transformViewForTransition(i8, i9, view3, z);
                } else {
                    int modulo4 = modulo(i7, count);
                    View view4 = this.mAdapter.getView(modulo4, null, this);
                    long itemId = this.mAdapter.getItemId(modulo4);
                    FrameLayout frameForChild = getFrameForChild();
                    if (view4 != null) {
                        frameForChild.addView(view4);
                    }
                    this.mViewsMap.put(Integer.valueOf(modulo3), new ViewAndMetaData(frameForChild, i9, modulo4, itemId));
                    addChild(frameForChild);
                    applyTransformForChildAtIndex(frameForChild, i9);
                    transformViewForTransition(-1, i9, frameForChild, z);
                }
                this.mViewsMap.get(Integer.valueOf(modulo3)).view.bringToFront();
                i6 = i7 + 1;
            }
            this.mCurrentWindowStart = max;
            this.mCurrentWindowEnd = min;
            this.mCurrentWindowStartUnbounded = i4;
            if (this.mRemoteViewsAdapter != null) {
                this.mRemoteViewsAdapter.setVisibleRangeHint(modulo(this.mCurrentWindowStart, count), modulo(this.mCurrentWindowEnd, count));
            }
        }
        requestLayout();
        invalidate();
    }

    public void showPrevious() {
        setDisplayedChild(this.mWhichChild - 1);
    }

    void showTapFeedback(View view) {
        view.setPressed(true);
    }

    void transformViewForTransition(int i, int i2, View view, boolean z) {
        if (i == -1) {
            this.mInAnimation.setTarget(view);
            this.mInAnimation.start();
        } else if (i2 == -1) {
            this.mOutAnimation.setTarget(view);
            this.mOutAnimation.start();
        }
    }
}
