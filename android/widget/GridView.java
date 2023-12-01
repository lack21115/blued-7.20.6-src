package android.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Trace;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.RemotableViewMethod;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.GridLayoutAnimationController;
import android.widget.AbsListView;
import android.widget.RemoteViews;
import com.android.internal.R;

@RemoteViews.RemoteView
/* loaded from: source-4181928-dex2jar.jar:android/widget/GridView.class */
public class GridView extends AbsListView {
    public static final int AUTO_FIT = -1;
    public static final int NO_STRETCH = 0;
    public static final int STRETCH_COLUMN_WIDTH = 2;
    public static final int STRETCH_SPACING = 1;
    public static final int STRETCH_SPACING_UNIFORM = 3;
    private int mColumnWidth;
    private int mGravity;
    private int mHorizontalSpacing;
    private int mNumColumns;
    private View mReferenceView;
    private View mReferenceViewInSelectedRow;
    private int mRequestedColumnWidth;
    private int mRequestedHorizontalSpacing;
    private int mRequestedNumColumns;
    private int mStretchMode;
    private final Rect mTempRect;
    private int mVerticalSpacing;

    public GridView(Context context) {
        this(context, null);
    }

    public GridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842865);
    }

    public GridView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public GridView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mNumColumns = -1;
        this.mHorizontalSpacing = 0;
        this.mVerticalSpacing = 0;
        this.mStretchMode = 2;
        this.mReferenceView = null;
        this.mReferenceViewInSelectedRow = null;
        this.mGravity = 8388611;
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.GridView, i, i2);
        setHorizontalSpacing(obtainStyledAttributes.getDimensionPixelOffset(1, 0));
        setVerticalSpacing(obtainStyledAttributes.getDimensionPixelOffset(2, 0));
        int i3 = obtainStyledAttributes.getInt(3, 2);
        if (i3 >= 0) {
            setStretchMode(i3);
        }
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(4, -1);
        if (dimensionPixelOffset > 0) {
            setColumnWidth(dimensionPixelOffset);
        }
        setNumColumns(obtainStyledAttributes.getInt(5, 1));
        int i4 = obtainStyledAttributes.getInt(0, -1);
        if (i4 >= 0) {
            setGravity(i4);
        }
        obtainStyledAttributes.recycle();
        setGridView(true);
    }

    private void adjustForBottomFadingEdge(View view, int i, int i2) {
        if (view.getBottom() > i2) {
            offsetChildrenTopAndBottom(-Math.min(view.getTop() - i, view.getBottom() - i2));
        }
    }

    private void adjustForTopFadingEdge(View view, int i, int i2) {
        if (view.getTop() < i) {
            offsetChildrenTopAndBottom(Math.min(i - view.getTop(), i2 - view.getBottom()));
        }
    }

    private void adjustViewsUpOrDown() {
        int i;
        int childCount = getChildCount();
        if (childCount > 0) {
            if (this.mStackFromBottom) {
                int bottom = getChildAt(childCount - 1).getBottom() - (getHeight() - this.mListPadding.bottom);
                int i2 = bottom;
                if (this.mFirstPosition + childCount < this.mItemCount) {
                    i2 = bottom + this.mVerticalSpacing;
                }
                i = i2;
                if (i2 > 0) {
                    i = 0;
                }
            } else {
                int top = getChildAt(0).getTop() - this.mListPadding.top;
                int i3 = top;
                if (this.mFirstPosition != 0) {
                    i3 = top - this.mVerticalSpacing;
                }
                i = i3;
                if (i3 < 0) {
                    i = 0;
                }
            }
            if (i != 0) {
                offsetChildrenTopAndBottom(-i);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:84:0x01c9, code lost:
        if (r5.mPopup.isShowing() == false) goto L74;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean commonKey(int r6, int r7, android.view.KeyEvent r8) {
        /*
            Method dump skipped, instructions count: 832
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.widget.GridView.commonKey(int, int, android.view.KeyEvent):boolean");
    }

    private void correctTooHigh(int i, int i2, int i3) {
        if ((this.mFirstPosition + i3) - 1 != this.mItemCount - 1 || i3 <= 0) {
            return;
        }
        int bottom = ((this.mBottom - this.mTop) - this.mListPadding.bottom) - getChildAt(i3 - 1).getBottom();
        View childAt = getChildAt(0);
        int top = childAt.getTop();
        if (bottom > 0) {
            if (this.mFirstPosition > 0 || top < this.mListPadding.top) {
                int i4 = bottom;
                if (this.mFirstPosition == 0) {
                    i4 = Math.min(bottom, this.mListPadding.top - top);
                }
                offsetChildrenTopAndBottom(i4);
                if (this.mFirstPosition > 0) {
                    int i5 = this.mFirstPosition;
                    if (this.mStackFromBottom) {
                        i = 1;
                    }
                    fillUp(i5 - i, childAt.getTop() - i2);
                    adjustViewsUpOrDown();
                }
            }
        }
    }

    private void correctTooLow(int i, int i2, int i3) {
        if (this.mFirstPosition != 0 || i3 <= 0) {
            return;
        }
        int top = getChildAt(0).getTop();
        int i4 = this.mListPadding.top;
        int i5 = (this.mBottom - this.mTop) - this.mListPadding.bottom;
        int i6 = top - i4;
        View childAt = getChildAt(i3 - 1);
        int bottom = childAt.getBottom();
        int i7 = (this.mFirstPosition + i3) - 1;
        if (i6 > 0) {
            if (i7 < this.mItemCount - 1 || bottom > i5) {
                int i8 = i6;
                if (i7 == this.mItemCount - 1) {
                    i8 = Math.min(i6, bottom - i5);
                }
                offsetChildrenTopAndBottom(-i8);
                if (i7 < this.mItemCount - 1) {
                    if (!this.mStackFromBottom) {
                        i = 1;
                    }
                    fillDown(i7 + i, childAt.getBottom() + i2);
                    adjustViewsUpOrDown();
                }
            }
        }
    }

    private boolean determineColumns(int i) {
        int i2 = this.mRequestedHorizontalSpacing;
        int i3 = this.mStretchMode;
        int i4 = this.mRequestedColumnWidth;
        boolean z = false;
        if (this.mRequestedNumColumns != -1) {
            this.mNumColumns = this.mRequestedNumColumns;
        } else if (i4 > 0) {
            this.mNumColumns = (i + i2) / (i4 + i2);
        } else {
            this.mNumColumns = 2;
        }
        if (this.mNumColumns <= 0) {
            this.mNumColumns = 1;
        }
        switch (i3) {
            case 0:
                this.mColumnWidth = i4;
                this.mHorizontalSpacing = i2;
                return false;
            default:
                int i5 = (i - (this.mNumColumns * i4)) - ((this.mNumColumns - 1) * i2);
                if (i5 < 0) {
                    z = true;
                }
                switch (i3) {
                    case 1:
                        this.mColumnWidth = i4;
                        if (this.mNumColumns > 1) {
                            this.mHorizontalSpacing = (i5 / (this.mNumColumns - 1)) + i2;
                            return z;
                        }
                        this.mHorizontalSpacing = i2 + i5;
                        return z;
                    case 2:
                        this.mColumnWidth = (i5 / this.mNumColumns) + i4;
                        this.mHorizontalSpacing = i2;
                        return z;
                    case 3:
                        this.mColumnWidth = i4;
                        if (this.mNumColumns > 1) {
                            this.mHorizontalSpacing = (i5 / (this.mNumColumns + 1)) + i2;
                            return z;
                        }
                        this.mHorizontalSpacing = i2 + i5;
                        return z;
                    default:
                        return z;
                }
        }
    }

    private View fillDown(int i, int i2) {
        int i3 = this.mBottom - this.mTop;
        int i4 = i3;
        View view = null;
        int i5 = i;
        int i6 = i2;
        if ((this.mGroupFlags & 34) == 34) {
            i4 = i3 - this.mListPadding.bottom;
            i6 = i2;
            i5 = i;
            view = null;
        }
        while (i6 < i4 && i5 < this.mItemCount) {
            View makeRow = makeRow(i5, i6, true);
            if (makeRow != null) {
                view = makeRow;
            }
            i6 = this.mReferenceView.getBottom() + this.mVerticalSpacing;
            i5 += this.mNumColumns;
        }
        setVisibleRangeHint(this.mFirstPosition, (this.mFirstPosition + getChildCount()) - 1);
        return view;
    }

    private View fillFromBottom(int i, int i2) {
        int min = (this.mItemCount - 1) - Math.min(Math.max(i, this.mSelectedPosition), this.mItemCount - 1);
        return fillUp((this.mItemCount - 1) - (min - (min % this.mNumColumns)), i2);
    }

    private View fillFromSelection(int i, int i2, int i3) {
        int max;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int i4 = this.mSelectedPosition;
        int i5 = this.mNumColumns;
        int i6 = this.mVerticalSpacing;
        int i7 = -1;
        if (this.mStackFromBottom) {
            int i8 = (this.mItemCount - 1) - i4;
            i7 = (this.mItemCount - 1) - (i8 - (i8 % i5));
            max = Math.max(0, (i7 - i5) + 1);
        } else {
            max = i4 - (i4 % i5);
        }
        int topSelectionPixel = getTopSelectionPixel(i2, verticalFadingEdgeLength, max);
        int bottomSelectionPixel = getBottomSelectionPixel(i3, verticalFadingEdgeLength, i5, max);
        View makeRow = makeRow(this.mStackFromBottom ? i7 : max, i, true);
        this.mFirstPosition = max;
        View view = this.mReferenceView;
        adjustForTopFadingEdge(view, topSelectionPixel, bottomSelectionPixel);
        adjustForBottomFadingEdge(view, topSelectionPixel, bottomSelectionPixel);
        if (this.mStackFromBottom) {
            fillDown(i7 + i5, view.getBottom() + i6);
            adjustViewsUpOrDown();
            fillUp(max - 1, view.getTop() - i6);
            return makeRow;
        }
        fillUp(max - i5, view.getTop() - i6);
        adjustViewsUpOrDown();
        fillDown(max + i5, view.getBottom() + i6);
        return makeRow;
    }

    private View fillFromTop(int i) {
        this.mFirstPosition = Math.min(this.mFirstPosition, this.mSelectedPosition);
        this.mFirstPosition = Math.min(this.mFirstPosition, this.mItemCount - 1);
        if (this.mFirstPosition < 0) {
            this.mFirstPosition = 0;
        }
        this.mFirstPosition -= this.mFirstPosition % this.mNumColumns;
        return fillDown(this.mFirstPosition, i);
    }

    private View fillSelection(int i, int i2) {
        int max;
        int reconcileSelectedPosition = reconcileSelectedPosition();
        int i3 = this.mNumColumns;
        int i4 = this.mVerticalSpacing;
        int i5 = -1;
        if (this.mStackFromBottom) {
            int i6 = (this.mItemCount - 1) - reconcileSelectedPosition;
            i5 = (this.mItemCount - 1) - (i6 - (i6 % i3));
            max = Math.max(0, (i5 - i3) + 1);
        } else {
            max = reconcileSelectedPosition - (reconcileSelectedPosition % i3);
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        View makeRow = makeRow(this.mStackFromBottom ? i5 : max, getTopSelectionPixel(i, verticalFadingEdgeLength, max), true);
        this.mFirstPosition = max;
        View view = this.mReferenceView;
        if (!this.mStackFromBottom) {
            fillDown(max + i3, view.getBottom() + i4);
            pinToBottom(i2);
            fillUp(max - i3, view.getTop() - i4);
            adjustViewsUpOrDown();
            return makeRow;
        }
        offsetChildrenTopAndBottom(getBottomSelectionPixel(i2, verticalFadingEdgeLength, i3, max) - view.getBottom());
        fillUp(max - 1, view.getTop() - i4);
        pinToTop(i);
        fillDown(i5 + i3, view.getBottom() + i4);
        adjustViewsUpOrDown();
        return makeRow;
    }

    private View fillSpecific(int i, int i2) {
        int i3;
        int max;
        View view;
        View view2;
        View view3;
        int i4 = this.mNumColumns;
        if (this.mStackFromBottom) {
            int i5 = (this.mItemCount - 1) - i;
            i3 = (this.mItemCount - 1) - (i5 - (i5 % i4));
            max = Math.max(0, (i3 - i4) + 1);
        } else {
            max = i - (i % i4);
            i3 = -1;
        }
        View makeRow = makeRow(this.mStackFromBottom ? i3 : max, i2, true);
        this.mFirstPosition = max;
        View view4 = this.mReferenceView;
        if (view4 == null) {
            view3 = null;
        } else {
            int i6 = this.mVerticalSpacing;
            if (this.mStackFromBottom) {
                View fillDown = fillDown(i3 + i4, view4.getBottom() + i6);
                adjustViewsUpOrDown();
                View fillUp = fillUp(max - 1, view4.getTop() - i6);
                int childCount = getChildCount();
                view = fillUp;
                view2 = fillDown;
                if (childCount > 0) {
                    correctTooLow(i4, i6, childCount);
                    view = fillUp;
                    view2 = fillDown;
                }
            } else {
                View fillUp2 = fillUp(max - i4, view4.getTop() - i6);
                adjustViewsUpOrDown();
                View fillDown2 = fillDown(max + i4, view4.getBottom() + i6);
                int childCount2 = getChildCount();
                view = fillUp2;
                view2 = fillDown2;
                if (childCount2 > 0) {
                    correctTooHigh(i4, i6, childCount2);
                    view2 = fillDown2;
                    view = fillUp2;
                }
            }
            view3 = makeRow;
            if (makeRow == null) {
                return view != null ? view : view2;
            }
        }
        return view3;
    }

    private View fillUp(int i, int i2) {
        int i3 = 0;
        View view = null;
        int i4 = i;
        int i5 = i2;
        if ((this.mGroupFlags & 34) == 34) {
            i3 = this.mListPadding.top;
            i5 = i2;
            i4 = i;
            view = null;
        }
        while (i5 > i3 && i4 >= 0) {
            View makeRow = makeRow(i4, i5, false);
            if (makeRow != null) {
                view = makeRow;
            }
            i5 = this.mReferenceView.getTop() - this.mVerticalSpacing;
            this.mFirstPosition = i4;
            i4 -= this.mNumColumns;
        }
        if (this.mStackFromBottom) {
            this.mFirstPosition = Math.max(0, i4 + 1);
        }
        setVisibleRangeHint(this.mFirstPosition, (this.mFirstPosition + getChildCount()) - 1);
        return view;
    }

    private int getBottomSelectionPixel(int i, int i2, int i3, int i4) {
        int i5 = i;
        if ((i4 + i3) - 1 < this.mItemCount - 1) {
            i5 = i - i2;
        }
        return i5;
    }

    private int getTopSelectionPixel(int i, int i2, int i3) {
        int i4 = i;
        if (i3 > 0) {
            i4 = i + i2;
        }
        return i4;
    }

    private boolean isCandidateSelection(int i, int i2) {
        int i3;
        int max;
        int childCount = getChildCount();
        int i4 = (childCount - 1) - i;
        if (this.mStackFromBottom) {
            i3 = (childCount - 1) - (i4 - (i4 % this.mNumColumns));
            max = Math.max(0, (i3 - this.mNumColumns) + 1);
        } else {
            max = i - (i % this.mNumColumns);
            i3 = Math.max((this.mNumColumns + max) - 1, childCount);
        }
        switch (i2) {
            case 1:
                return i == i3 && i3 == childCount - 1;
            case 2:
                return i == max && max == 0;
            case 17:
                return i == i3;
            case 33:
                return i3 == childCount - 1;
            case 66:
                return i == max;
            case 130:
                return max == 0;
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT, FOCUS_FORWARD, FOCUS_BACKWARD}.");
        }
    }

    private View makeAndAddView(int i, int i2, boolean z, int i3, boolean z2, int i4) {
        View activeView;
        if (!this.mDataChanged && (activeView = this.mRecycler.getActiveView(i)) != null) {
            setupChild(activeView, i, i2, z, i3, z2, true, i4);
            return activeView;
        }
        View obtainView = obtainView(i, this.mIsScrap);
        setupChild(obtainView, i, i2, z, i3, z2, this.mIsScrap[0], i4);
        return obtainView;
    }

    private View makeRow(int i, int i2, boolean z) {
        int i3;
        int i4;
        int i5;
        int i6 = this.mColumnWidth;
        int i7 = this.mHorizontalSpacing;
        boolean isLayoutRtl = isLayoutRtl();
        if (isLayoutRtl) {
            i3 = ((getWidth() - this.mListPadding.right) - i6) - (this.mStretchMode == 3 ? i7 : 0);
        } else {
            i3 = this.mListPadding.left + (this.mStretchMode == 3 ? i7 : 0);
        }
        if (this.mStackFromBottom) {
            int i8 = i + 1;
            int max = Math.max(0, (i - this.mNumColumns) + 1);
            i4 = i3;
            i5 = i8;
            i = max;
            if (i8 - max < this.mNumColumns) {
                i4 = i3 + ((isLayoutRtl ? -1 : 1) * (this.mNumColumns - (i8 - max)) * (i6 + i7));
                i5 = i8;
                i = max;
            }
        } else {
            i5 = Math.min(this.mNumColumns + i, this.mItemCount);
            i4 = i3;
        }
        View view = null;
        boolean shouldShowSelector = shouldShowSelector();
        boolean z2 = touchModeDrawsInPressedState();
        int i9 = this.mSelectedPosition;
        View view2 = null;
        int i10 = isLayoutRtl ? -1 : 1;
        int i11 = i4;
        int i12 = i;
        while (i12 < i5) {
            boolean z3 = i12 == i9;
            view2 = makeAndAddView(i12, i2, z, i11, z3, z ? -1 : i12 - i);
            int i13 = i11 + (i10 * i6);
            i11 = i13;
            if (i12 < i5 - 1) {
                i11 = i13 + (i10 * i7);
            }
            View view3 = view;
            if (z3) {
                if (!shouldShowSelector) {
                    view3 = view;
                    if (!z2) {
                    }
                }
                view3 = view2;
            }
            i12++;
            view = view3;
        }
        this.mReferenceView = view2;
        if (view != null) {
            this.mReferenceViewInSelectedRow = this.mReferenceView;
        }
        return view;
    }

    private View moveSelection(int i, int i2, int i3) {
        int max;
        int max2;
        int i4;
        View makeRow;
        View view;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int i5 = this.mSelectedPosition;
        int i6 = this.mNumColumns;
        int i7 = this.mVerticalSpacing;
        if (this.mStackFromBottom) {
            int i8 = (this.mItemCount - 1) - i5;
            int i9 = (this.mItemCount - 1) - (i8 - (i8 % i6));
            max = Math.max(0, (i9 - i6) + 1);
            int i10 = (this.mItemCount - 1) - (i5 - i);
            max2 = Math.max(0, (((this.mItemCount - 1) - (i10 - (i10 % i6))) - i6) + 1);
            i4 = i9;
        } else {
            int i11 = (i5 - i) - ((i5 - i) % i6);
            max = i5 - (i5 % i6);
            i4 = -1;
            max2 = i11;
        }
        int i12 = max - max2;
        int topSelectionPixel = getTopSelectionPixel(i2, verticalFadingEdgeLength, max);
        int bottomSelectionPixel = getBottomSelectionPixel(i3, verticalFadingEdgeLength, i6, max);
        this.mFirstPosition = max;
        if (i12 > 0) {
            makeRow = makeRow(this.mStackFromBottom ? i4 : max, (this.mReferenceViewInSelectedRow == null ? 0 : this.mReferenceViewInSelectedRow.getBottom()) + i7, true);
            view = this.mReferenceView;
            adjustForBottomFadingEdge(view, topSelectionPixel, bottomSelectionPixel);
        } else if (i12 < 0) {
            makeRow = makeRow(this.mStackFromBottom ? i4 : max, (this.mReferenceViewInSelectedRow == null ? 0 : this.mReferenceViewInSelectedRow.getTop()) - i7, false);
            view = this.mReferenceView;
            adjustForTopFadingEdge(view, topSelectionPixel, bottomSelectionPixel);
        } else {
            makeRow = makeRow(this.mStackFromBottom ? i4 : max, this.mReferenceViewInSelectedRow == null ? 0 : this.mReferenceViewInSelectedRow.getTop(), true);
            view = this.mReferenceView;
        }
        if (this.mStackFromBottom) {
            fillDown(i4 + i6, view.getBottom() + i7);
            adjustViewsUpOrDown();
            fillUp(max - 1, view.getTop() - i7);
            return makeRow;
        }
        fillUp(max - i6, view.getTop() - i7);
        adjustViewsUpOrDown();
        fillDown(max + i6, view.getBottom() + i7);
        return makeRow;
    }

    private void pinToBottom(int i) {
        int bottom;
        int childCount = getChildCount();
        if (this.mFirstPosition + childCount != this.mItemCount || (bottom = i - getChildAt(childCount - 1).getBottom()) <= 0) {
            return;
        }
        offsetChildrenTopAndBottom(bottom);
    }

    private void pinToTop(int i) {
        int top;
        if (this.mFirstPosition != 0 || (top = i - getChildAt(0).getTop()) >= 0) {
            return;
        }
        offsetChildrenTopAndBottom(top);
    }

    private void setupChild(View view, int i, int i2, boolean z, int i3, boolean z2, boolean z3, int i4) {
        int i5;
        Trace.traceBegin(8L, "setupGridItem");
        boolean z4 = z2 && shouldShowSelector();
        boolean z5 = z4 != view.isSelected();
        int i6 = this.mTouchMode;
        boolean z6 = i6 > 0 && i6 < 3 && this.mMotionPosition == i;
        boolean z7 = z6 != view.isPressed();
        boolean z8 = !z3 || z5 || view.isLayoutRequested();
        AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) view.getLayoutParams();
        AbsListView.LayoutParams layoutParams2 = layoutParams;
        if (layoutParams == null) {
            layoutParams2 = (AbsListView.LayoutParams) generateDefaultLayoutParams();
        }
        layoutParams2.viewType = this.mAdapter.getItemViewType(i);
        if (!z3 || layoutParams2.forceAdd) {
            layoutParams2.forceAdd = false;
            addViewInLayout(view, i4, layoutParams2, true);
        } else {
            attachViewToParent(view, i4, layoutParams2);
        }
        if (z5) {
            view.setSelected(z4);
            if (z4) {
                requestFocus();
            }
        }
        if (z7) {
            view.setPressed(z6);
        }
        if (this.mChoiceMode != 0 && this.mCheckStates != null) {
            if (view instanceof Checkable) {
                ((Checkable) view).setChecked(this.mCheckStates.get(i));
            } else if (getContext().getApplicationInfo().targetSdkVersion >= 11) {
                view.setActivated(this.mCheckStates.get(i));
            }
        }
        if (z8) {
            view.measure(ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(this.mColumnWidth, 1073741824), 0, layoutParams2.width), ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(0, 0), 0, layoutParams2.height));
        } else {
            cleanupLayoutState(view);
        }
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i7 = z ? i2 : i2 - measuredHeight;
        switch (Gravity.getAbsoluteGravity(this.mGravity, getLayoutDirection()) & 7) {
            case 1:
                i5 = i3 + ((this.mColumnWidth - measuredWidth) / 2);
                break;
            case 2:
            case 4:
            default:
                i5 = i3;
                break;
            case 3:
                i5 = i3;
                break;
            case 5:
                i5 = (this.mColumnWidth + i3) - measuredWidth;
                break;
        }
        if (z8) {
            view.layout(i5, i7, i5 + measuredWidth, i7 + measuredHeight);
        } else {
            view.offsetLeftAndRight(i5 - view.getLeft());
            view.offsetTopAndBottom(i7 - view.getTop());
        }
        if (this.mCachingStarted) {
            view.setDrawingCacheEnabled(true);
        }
        if (z3 && ((AbsListView.LayoutParams) view.getLayoutParams()).scrappedFromPosition != i) {
            view.jumpDrawablesToCurrentState();
        }
        Trace.traceEnd(8L);
    }

    boolean arrowScroll(int i) {
        int i2;
        int max;
        boolean z;
        int i3 = this.mSelectedPosition;
        int i4 = this.mNumColumns;
        boolean isLayoutRtl = isLayoutRtl();
        if (this.mStackFromBottom) {
            i2 = (this.mItemCount - 1) - ((((this.mItemCount - 1) - i3) / i4) * i4);
            max = Math.max(0, (i2 - i4) + 1);
        } else {
            max = (i3 / i4) * i4;
            i2 = Math.min((max + i4) - 1, this.mItemCount - 1);
        }
        switch (i) {
            case 17:
                if (!isLayoutRtl && i3 > max) {
                    this.mLayoutMode = 6;
                    setSelectionInt(Math.max(0, i3 - 1));
                    z = true;
                    break;
                } else {
                    z = false;
                    if (isLayoutRtl) {
                        z = false;
                        if (i3 < i2) {
                            this.mLayoutMode = 6;
                            setSelectionInt(Math.min(i3 + 1, this.mItemCount - 1));
                            z = true;
                            break;
                        }
                    }
                }
                break;
            case 33:
                z = false;
                if (max > 0) {
                    this.mLayoutMode = 6;
                    setSelectionInt(Math.max(0, i3 - i4));
                    z = true;
                    break;
                }
                break;
            case 66:
                if (!isLayoutRtl && i3 < i2) {
                    this.mLayoutMode = 6;
                    setSelectionInt(Math.min(i3 + 1, this.mItemCount - 1));
                    z = true;
                    break;
                } else {
                    z = false;
                    if (isLayoutRtl) {
                        z = false;
                        if (i3 > max) {
                            this.mLayoutMode = 6;
                            setSelectionInt(Math.max(0, i3 - 1));
                            z = true;
                            break;
                        }
                    }
                }
                break;
            case 130:
                z = false;
                if (i2 < this.mItemCount - 1) {
                    this.mLayoutMode = 6;
                    setSelectionInt(Math.min(i3 + i4, this.mItemCount - 1));
                    z = true;
                    break;
                }
                break;
            default:
                z = false;
                break;
        }
        if (z) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
            invokeOnItemScrollListener();
        }
        if (z) {
            awakenScrollBars();
        }
        return z;
    }

    @Override // android.view.ViewGroup
    protected void attachLayoutAnimationParameters(View view, ViewGroup.LayoutParams layoutParams, int i, int i2) {
        GridLayoutAnimationController.AnimationParameters animationParameters = (GridLayoutAnimationController.AnimationParameters) layoutParams.layoutAnimationParameters;
        GridLayoutAnimationController.AnimationParameters animationParameters2 = animationParameters;
        if (animationParameters == null) {
            animationParameters2 = new GridLayoutAnimationController.AnimationParameters();
            layoutParams.layoutAnimationParameters = animationParameters2;
        }
        animationParameters2.count = i2;
        animationParameters2.index = i;
        animationParameters2.columnsCount = this.mNumColumns;
        animationParameters2.rowsCount = i2 / this.mNumColumns;
        if (!this.mStackFromBottom) {
            animationParameters2.column = i % this.mNumColumns;
            animationParameters2.row = i / this.mNumColumns;
            return;
        }
        int i3 = (i2 - 1) - i;
        animationParameters2.column = (this.mNumColumns - 1) - (i3 % this.mNumColumns);
        animationParameters2.row = (animationParameters2.rowsCount - 1) - (i3 / this.mNumColumns);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AbsListView, android.view.View
    public int computeVerticalScrollExtent() {
        int childCount = getChildCount();
        if (childCount > 0) {
            int i = this.mNumColumns;
            int i2 = (((childCount + i) - 1) / i) * 100;
            View childAt = getChildAt(0);
            int top = childAt.getTop();
            int height = childAt.getHeight();
            int i3 = i2;
            if (height > 0) {
                i3 = i2 + ((top * 100) / height);
            }
            View childAt2 = getChildAt(childCount - 1);
            int bottom = childAt2.getBottom();
            int height2 = childAt2.getHeight();
            int i4 = i3;
            if (height2 > 0) {
                i4 = i3 - (((bottom - getHeight()) * 100) / height2);
            }
            return i4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AbsListView, android.view.View
    public int computeVerticalScrollOffset() {
        int i = 0;
        if (this.mFirstPosition >= 0) {
            i = 0;
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                int top = childAt.getTop();
                int height = childAt.getHeight();
                i = 0;
                if (height > 0) {
                    int i2 = this.mNumColumns;
                    int i3 = ((this.mItemCount + i2) - 1) / i2;
                    i = Math.max(((((this.mFirstPosition + (isStackFromBottom() ? (i3 * i2) - this.mItemCount : 0)) / i2) * 100) - ((top * 100) / height)) + ((int) ((this.mScrollY / getHeight()) * i3 * 100.0f)), 0);
                }
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AbsListView, android.view.View
    public int computeVerticalScrollRange() {
        int i = this.mNumColumns;
        int i2 = ((this.mItemCount + i) - 1) / i;
        int max = Math.max(i2 * 100, 0);
        int i3 = max;
        if (this.mScrollY != 0) {
            i3 = max + Math.abs((int) ((this.mScrollY / getHeight()) * i2 * 100.0f));
        }
        return i3;
    }

    @Override // android.widget.AbsListView
    void fillGap(boolean z) {
        int i = this.mNumColumns;
        int i2 = this.mVerticalSpacing;
        int childCount = getChildCount();
        if (!z) {
            int i3 = 0;
            if ((this.mGroupFlags & 34) == 34) {
                i3 = getListPaddingBottom();
            }
            int top = childCount > 0 ? getChildAt(0).getTop() - i2 : getHeight() - i3;
            int i4 = this.mFirstPosition;
            fillUp(!this.mStackFromBottom ? i4 - i : i4 - 1, top);
            correctTooLow(i, i2, getChildCount());
            return;
        }
        int i5 = 0;
        if ((this.mGroupFlags & 34) == 34) {
            i5 = getListPaddingTop();
        }
        if (childCount > 0) {
            i5 = getChildAt(childCount - 1).getBottom() + i2;
        }
        int i6 = this.mFirstPosition + childCount;
        int i7 = i6;
        if (this.mStackFromBottom) {
            i7 = i6 + (i - 1);
        }
        fillDown(i7, i5);
        correctTooHigh(i, i2, getChildCount());
    }

    @Override // android.widget.AbsListView
    int findMotionRow(int i) {
        int childCount = getChildCount();
        if (childCount <= 0) {
            return -1;
        }
        int i2 = this.mNumColumns;
        if (this.mStackFromBottom) {
            int i3 = childCount;
            int i4 = 1;
            while (true) {
                int i5 = i3 - i4;
                if (i5 < 0) {
                    return -1;
                }
                if (i >= getChildAt(i5).getTop()) {
                    return this.mFirstPosition + i5;
                }
                i3 = i5;
                i4 = i2;
            }
        } else {
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= childCount) {
                    return -1;
                }
                if (i <= getChildAt(i7).getBottom()) {
                    return this.mFirstPosition + i7;
                }
                i6 = i7 + i2;
            }
        }
    }

    boolean fullScroll(int i) {
        boolean z = false;
        if (i == 33) {
            this.mLayoutMode = 2;
            setSelectionInt(0);
            invokeOnItemScrollListener();
            z = true;
        } else if (i == 130) {
            this.mLayoutMode = 2;
            setSelectionInt(this.mItemCount - 1);
            invokeOnItemScrollListener();
            z = true;
        }
        if (z) {
            awakenScrollBars();
        }
        return z;
    }

    @Override // android.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.mAdapter;
    }

    public int getColumnWidth() {
        return this.mColumnWidth;
    }

    public int getGravity() {
        return this.mGravity;
    }

    public int getHorizontalSpacing() {
        return this.mHorizontalSpacing;
    }

    @ViewDebug.ExportedProperty
    public int getNumColumns() {
        return this.mNumColumns;
    }

    public int getRequestedColumnWidth() {
        return this.mRequestedColumnWidth;
    }

    public int getRequestedHorizontalSpacing() {
        return this.mRequestedHorizontalSpacing;
    }

    public int getStretchMode() {
        return this.mStretchMode;
    }

    public int getVerticalSpacing() {
        return this.mVerticalSpacing;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01dc, code lost:
        if (r6.mAdapterHasStableIds != false) goto L50;
     */
    @Override // android.widget.AbsListView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void layoutChildren() {
        /*
            Method dump skipped, instructions count: 1281
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.widget.GridView.layoutChildren():void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.widget.AdapterView
    public int lookForSelectablePosition(int i, boolean z) {
        int i2;
        if (this.mAdapter == null || isInTouchMode()) {
            i2 = -1;
        } else if (i < 0) {
            return -1;
        } else {
            i2 = i;
            if (i >= this.mItemCount) {
                return -1;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AbsListView, android.view.View
    public void onFocusChanged(boolean z, int i, Rect rect) {
        int i2;
        super.onFocusChanged(z, i, rect);
        int i3 = -1;
        int i4 = -1;
        if (z) {
            i4 = -1;
            if (rect != null) {
                rect.offset(this.mScrollX, this.mScrollY);
                Rect rect2 = this.mTempRect;
                int i5 = Integer.MAX_VALUE;
                int childCount = getChildCount();
                int i6 = 0;
                while (true) {
                    i4 = i3;
                    if (i6 >= childCount) {
                        break;
                    }
                    if (isCandidateSelection(i6, i)) {
                        View childAt = getChildAt(i6);
                        childAt.getDrawingRect(rect2);
                        offsetDescendantRectToMyCoords(childAt, rect2);
                        int distance = getDistance(rect, rect2, i);
                        i2 = i5;
                        if (distance < i5) {
                            i2 = distance;
                            i3 = i6;
                        }
                    } else {
                        i2 = i5;
                    }
                    i6++;
                    i5 = i2;
                }
            }
        }
        if (i4 >= 0) {
            setSelection(this.mFirstPosition + i4);
        } else {
            requestLayout();
        }
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(GridView.class.getName());
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(GridView.class.getName());
        int numColumns = getNumColumns();
        accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(getCount() / numColumns, numColumns, false, getSelectionModeForAccessibility()));
    }

    @Override // android.widget.AbsListView
    public void onInitializeAccessibilityNodeInfoForItem(View view, int i, AccessibilityNodeInfo accessibilityNodeInfo) {
        int i2;
        int i3;
        super.onInitializeAccessibilityNodeInfoForItem(view, i, accessibilityNodeInfo);
        int count = getCount();
        int numColumns = getNumColumns();
        int i4 = count / numColumns;
        if (this.mStackFromBottom) {
            int i5 = (count - 1) - i;
            i2 = (numColumns - 1) - (i5 % numColumns);
            i3 = (i4 - 1) - (i5 / numColumns);
        } else {
            i2 = i % numColumns;
            i3 = i / numColumns;
        }
        AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) view.getLayoutParams();
        accessibilityNodeInfo.setCollectionItemInfo(AccessibilityNodeInfo.CollectionItemInfo.obtain(i3, 1, i2, 1, (layoutParams == null || layoutParams.viewType == -2) ? false : true, isItemChecked(i)));
    }

    @Override // android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return commonKey(i, 1, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return commonKey(i, i2, keyEvent);
    }

    @Override // android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return commonKey(i, 1, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x01d0, code lost:
        if (r0 != false) goto L45;
     */
    @Override // android.widget.AbsListView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r6, int r7) {
        /*
            Method dump skipped, instructions count: 528
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.widget.GridView.onMeasure(int, int):void");
    }

    boolean pageScroll(int i) {
        boolean z = false;
        int i2 = -1;
        if (i == 33) {
            i2 = Math.max(0, this.mSelectedPosition - getChildCount());
        } else if (i == 130) {
            i2 = Math.min(this.mItemCount - 1, this.mSelectedPosition + getChildCount());
        }
        if (i2 >= 0) {
            setSelectionInt(i2);
            invokeOnItemScrollListener();
            awakenScrollBars();
            z = true;
        }
        return z;
    }

    boolean sequenceScroll(int i) {
        int i2;
        int max;
        int i3 = this.mSelectedPosition;
        int i4 = this.mNumColumns;
        int i5 = this.mItemCount;
        if (this.mStackFromBottom) {
            i2 = (i5 - 1) - ((((i5 - 1) - i3) / i4) * i4);
            max = Math.max(0, (i2 - i4) + 1);
        } else {
            max = (i3 / i4) * i4;
            i2 = Math.min((max + i4) - 1, i5 - 1);
        }
        boolean z = false;
        boolean z2 = false;
        switch (i) {
            case 1:
                if (i3 > 0) {
                    this.mLayoutMode = 6;
                    setSelectionInt(i3 - 1);
                    z = true;
                    if (i3 != max) {
                        z2 = false;
                        break;
                    } else {
                        z2 = true;
                        break;
                    }
                }
                break;
            case 2:
                if (i3 < i5 - 1) {
                    this.mLayoutMode = 6;
                    setSelectionInt(i3 + 1);
                    z = true;
                    if (i3 != i2) {
                        z2 = false;
                        break;
                    } else {
                        z2 = true;
                        break;
                    }
                }
                break;
        }
        if (z) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
            invokeOnItemScrollListener();
        }
        if (z2) {
            awakenScrollBars();
        }
        return z;
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        if (this.mAdapter != null && this.mDataSetObserver != null) {
            this.mAdapter.unregisterDataSetObserver(this.mDataSetObserver);
        }
        resetList();
        this.mRecycler.clear();
        this.mAdapter = listAdapter;
        this.mOldSelectedPosition = -1;
        this.mOldSelectedRowId = Long.MIN_VALUE;
        super.setAdapter(listAdapter);
        if (this.mAdapter != null) {
            this.mOldItemCount = this.mItemCount;
            this.mItemCount = this.mAdapter.getCount();
            this.mDataChanged = true;
            checkFocus();
            this.mDataSetObserver = new AbsListView.AdapterDataSetObserver();
            this.mAdapter.registerDataSetObserver(this.mDataSetObserver);
            this.mRecycler.setViewTypeCount(this.mAdapter.getViewTypeCount());
            int lookForSelectablePosition = this.mStackFromBottom ? lookForSelectablePosition(this.mItemCount - 1, false) : lookForSelectablePosition(0, true);
            setSelectedPositionInt(lookForSelectablePosition);
            setNextSelectedPositionInt(lookForSelectablePosition);
            checkSelectionChanged();
        } else {
            checkFocus();
            checkSelectionChanged();
        }
        requestLayout();
    }

    public void setColumnWidth(int i) {
        if (i != this.mRequestedColumnWidth) {
            this.mRequestedColumnWidth = i;
            requestLayoutIfNecessary();
        }
    }

    public void setGravity(int i) {
        if (this.mGravity != i) {
            this.mGravity = i;
            requestLayoutIfNecessary();
        }
    }

    public void setHorizontalSpacing(int i) {
        if (i != this.mRequestedHorizontalSpacing) {
            this.mRequestedHorizontalSpacing = i;
            requestLayoutIfNecessary();
        }
    }

    public void setNumColumns(int i) {
        if (i != this.mRequestedNumColumns) {
            this.mRequestedNumColumns = i;
            requestLayoutIfNecessary();
        }
    }

    @Override // android.widget.AbsListView
    @RemotableViewMethod
    public void setRemoteViewsAdapter(Intent intent) {
        super.setRemoteViewsAdapter(intent);
    }

    @Override // android.widget.AdapterView
    public void setSelection(int i) {
        if (isInTouchMode()) {
            this.mResurrectToPosition = i;
        } else {
            setNextSelectedPositionInt(i);
        }
        this.mLayoutMode = 2;
        if (this.mPositionScroller != null) {
            this.mPositionScroller.stop();
        }
        requestLayout();
    }

    @Override // android.widget.AbsListView
    void setSelectionInt(int i) {
        int i2 = this.mNextSelectedPosition;
        if (this.mPositionScroller != null) {
            this.mPositionScroller.stop();
        }
        setNextSelectedPositionInt(i);
        layoutChildren();
        int i3 = this.mStackFromBottom ? (this.mItemCount - 1) - this.mNextSelectedPosition : this.mNextSelectedPosition;
        if (this.mStackFromBottom) {
            i2 = (this.mItemCount - 1) - i2;
        }
        if (i3 / this.mNumColumns != i2 / this.mNumColumns) {
            awakenScrollBars();
        }
    }

    public void setStretchMode(int i) {
        if (i != this.mStretchMode) {
            this.mStretchMode = i;
            requestLayoutIfNecessary();
        }
    }

    public void setVerticalSpacing(int i) {
        if (i != this.mVerticalSpacing) {
            this.mVerticalSpacing = i;
            requestLayoutIfNecessary();
        }
    }

    @Override // android.widget.AbsListView
    @RemotableViewMethod
    public void smoothScrollByOffset(int i) {
        super.smoothScrollByOffset(i);
    }

    @Override // android.widget.AbsListView
    @RemotableViewMethod
    public void smoothScrollToPosition(int i) {
        super.smoothScrollToPosition(i);
    }
}
