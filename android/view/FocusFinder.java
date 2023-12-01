package android.view;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* loaded from: source-9557208-dex2jar.jar:android/view/FocusFinder.class */
public class FocusFinder {
    private static final ThreadLocal<FocusFinder> tlFocusFinder = new ThreadLocal<FocusFinder>() { // from class: android.view.FocusFinder.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public FocusFinder initialValue() {
            return new FocusFinder();
        }
    };
    final Rect mBestCandidateRect;
    final Rect mFocusedRect;
    final Rect mOtherRect;
    final SequentialFocusComparator mSequentialFocusComparator;
    private final ArrayList<View> mTempList;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/view/FocusFinder$SequentialFocusComparator.class */
    public static final class SequentialFocusComparator implements Comparator<View> {
        private final Rect mFirstRect;
        private boolean mIsLayoutRtl;
        private ViewGroup mRoot;
        private final Rect mSecondRect;

        private SequentialFocusComparator() {
            this.mFirstRect = new Rect();
            this.mSecondRect = new Rect();
        }

        private void getRect(View view, Rect rect) {
            view.getDrawingRect(rect);
            this.mRoot.offsetDescendantRectToMyCoords(view, rect);
        }

        @Override // java.util.Comparator
        public int compare(View view, View view2) {
            int i;
            if (view == view2) {
                i = 0;
            } else {
                getRect(view, this.mFirstRect);
                getRect(view2, this.mSecondRect);
                i = -1;
                if (this.mFirstRect.top >= this.mSecondRect.top) {
                    if (this.mFirstRect.top > this.mSecondRect.top) {
                        return 1;
                    }
                    if (this.mFirstRect.left < this.mSecondRect.left) {
                        return this.mIsLayoutRtl ? 1 : -1;
                    } else if (this.mFirstRect.left > this.mSecondRect.left) {
                        i = -1;
                        if (!this.mIsLayoutRtl) {
                            return 1;
                        }
                    } else {
                        i = -1;
                        if (this.mFirstRect.bottom >= this.mSecondRect.bottom) {
                            if (this.mFirstRect.bottom > this.mSecondRect.bottom) {
                                return 1;
                            }
                            if (this.mFirstRect.right < this.mSecondRect.right) {
                                return this.mIsLayoutRtl ? 1 : -1;
                            } else if (this.mFirstRect.right <= this.mSecondRect.right) {
                                return 0;
                            } else {
                                i = -1;
                                if (!this.mIsLayoutRtl) {
                                    return 1;
                                }
                            }
                        }
                    }
                }
            }
            return i;
        }

        public void recycle() {
            this.mRoot = null;
        }

        public void setIsLayoutRtl(boolean z) {
            this.mIsLayoutRtl = z;
        }

        public void setRoot(ViewGroup viewGroup) {
            this.mRoot = viewGroup;
        }
    }

    private FocusFinder() {
        this.mFocusedRect = new Rect();
        this.mOtherRect = new Rect();
        this.mBestCandidateRect = new Rect();
        this.mSequentialFocusComparator = new SequentialFocusComparator();
        this.mTempList = new ArrayList<>();
    }

    private View findNextFocus(ViewGroup viewGroup, View view, Rect rect, int i) {
        View view2 = null;
        if (view != null) {
            view2 = findNextUserSpecifiedFocus(viewGroup, view, i);
        }
        if (view2 != null) {
            return view2;
        }
        ArrayList<View> arrayList = this.mTempList;
        try {
            arrayList.clear();
            viewGroup.addFocusables(arrayList, i);
            if (!arrayList.isEmpty()) {
                view2 = findNextFocus(viewGroup, view, rect, i, arrayList);
            }
            arrayList.clear();
            return view2;
        } catch (Throwable th) {
            arrayList.clear();
            throw th;
        }
    }

    private View findNextFocus(ViewGroup viewGroup, View view, Rect rect, int i, ArrayList<View> arrayList) {
        Rect rect2;
        if (view == null) {
            rect2 = rect;
            if (rect == null) {
                rect2 = this.mFocusedRect;
                switch (i) {
                    case 1:
                        if (!viewGroup.isLayoutRtl()) {
                            setFocusBottomRight(viewGroup, rect2);
                            break;
                        } else {
                            setFocusTopLeft(viewGroup, rect2);
                            break;
                        }
                    case 2:
                        if (!viewGroup.isLayoutRtl()) {
                            setFocusTopLeft(viewGroup, rect2);
                            break;
                        } else {
                            setFocusBottomRight(viewGroup, rect2);
                            break;
                        }
                    case 17:
                    case 33:
                        setFocusBottomRight(viewGroup, rect2);
                        break;
                    case 66:
                    case 130:
                        setFocusTopLeft(viewGroup, rect2);
                        break;
                }
            }
        } else {
            rect2 = rect;
            if (rect == null) {
                rect2 = this.mFocusedRect;
            }
            view.getFocusedRect(rect2);
            viewGroup.offsetDescendantRectToMyCoords(view, rect2);
        }
        switch (i) {
            case 1:
            case 2:
                return findNextFocusInRelativeDirection(arrayList, viewGroup, view, rect2, i);
            case 17:
            case 33:
            case 66:
            case 130:
                return findNextFocusInAbsoluteDirection(arrayList, viewGroup, view, rect2, i);
            default:
                throw new IllegalArgumentException("Unknown direction: " + i);
        }
    }

    private View findNextFocusInRelativeDirection(ArrayList<View> arrayList, ViewGroup viewGroup, View view, Rect rect, int i) {
        try {
            this.mSequentialFocusComparator.setRoot(viewGroup);
            this.mSequentialFocusComparator.setIsLayoutRtl(viewGroup.isLayoutRtl());
            Collections.sort(arrayList, this.mSequentialFocusComparator);
            this.mSequentialFocusComparator.recycle();
            int size = arrayList.size();
            switch (i) {
                case 1:
                    return getPreviousFocusable(view, arrayList, size);
                case 2:
                    return getNextFocusable(view, arrayList, size);
                default:
                    return arrayList.get(size - 1);
            }
        } catch (Throwable th) {
            this.mSequentialFocusComparator.recycle();
            throw th;
        }
    }

    private View findNextUserSpecifiedFocus(ViewGroup viewGroup, View view, int i) {
        View findUserSetNextFocus = view.findUserSetNextFocus(viewGroup, i);
        if (findUserSetNextFocus == null || !findUserSetNextFocus.isFocusable()) {
            return null;
        }
        if (!findUserSetNextFocus.isInTouchMode() || findUserSetNextFocus.isFocusableInTouchMode()) {
            return findUserSetNextFocus;
        }
        return null;
    }

    public static FocusFinder getInstance() {
        return tlFocusFinder.get();
    }

    private static View getNextFocusable(View view, ArrayList<View> arrayList, int i) {
        int lastIndexOf;
        if (view == null || (lastIndexOf = arrayList.lastIndexOf(view)) < 0 || lastIndexOf + 1 >= i) {
            if (arrayList.isEmpty()) {
                return null;
            }
            return arrayList.get(0);
        }
        return arrayList.get(lastIndexOf + 1);
    }

    private static View getPreviousFocusable(View view, ArrayList<View> arrayList, int i) {
        int indexOf;
        if (view == null || (indexOf = arrayList.indexOf(view)) <= 0) {
            if (arrayList.isEmpty()) {
                return null;
            }
            return arrayList.get(i - 1);
        }
        return arrayList.get(indexOf - 1);
    }

    private boolean isTouchCandidate(int i, int i2, Rect rect, int i3) {
        switch (i3) {
            case 17:
                return rect.left <= i && rect.top <= i2 && i2 <= rect.bottom;
            case 33:
                return rect.top <= i2 && rect.left <= i && i <= rect.right;
            case 66:
                return rect.left >= i && rect.top <= i2 && i2 <= rect.bottom;
            case 130:
                return rect.top >= i2 && rect.left <= i && i <= rect.right;
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int majorAxisDistance(int i, Rect rect, Rect rect2) {
        return Math.max(0, majorAxisDistanceRaw(i, rect, rect2));
    }

    static int majorAxisDistanceRaw(int i, Rect rect, Rect rect2) {
        switch (i) {
            case 17:
                return rect.left - rect2.right;
            case 33:
                return rect.top - rect2.bottom;
            case 66:
                return rect2.left - rect.right;
            case 130:
                return rect2.top - rect.bottom;
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int majorAxisDistanceToFarEdge(int i, Rect rect, Rect rect2) {
        return Math.max(1, majorAxisDistanceToFarEdgeRaw(i, rect, rect2));
    }

    static int majorAxisDistanceToFarEdgeRaw(int i, Rect rect, Rect rect2) {
        switch (i) {
            case 17:
                return rect.left - rect2.left;
            case 33:
                return rect.top - rect2.top;
            case 66:
                return rect2.right - rect.right;
            case 130:
                return rect2.bottom - rect.bottom;
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }

    static int minorAxisDistance(int i, Rect rect, Rect rect2) {
        switch (i) {
            case 17:
            case 66:
                return Math.abs((rect.top + (rect.height() / 2)) - (rect2.top + (rect2.height() / 2)));
            case 33:
            case 130:
                return Math.abs((rect.left + (rect.width() / 2)) - (rect2.left + (rect2.width() / 2)));
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }

    private void setFocusBottomRight(ViewGroup viewGroup, Rect rect) {
        int scrollY = viewGroup.getScrollY() + viewGroup.getHeight();
        int scrollX = viewGroup.getScrollX() + viewGroup.getWidth();
        rect.set(scrollX, scrollY, scrollX, scrollY);
    }

    private void setFocusTopLeft(ViewGroup viewGroup, Rect rect) {
        int scrollY = viewGroup.getScrollY();
        int scrollX = viewGroup.getScrollX();
        rect.set(scrollX, scrollY, scrollX, scrollY);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean beamBeats(int i, Rect rect, Rect rect2, Rect rect3) {
        boolean z;
        boolean beamsOverlap = beamsOverlap(i, rect, rect2);
        if (beamsOverlap(i, rect, rect3) || !beamsOverlap) {
            z = false;
        } else {
            z = true;
            if (isToDirectionOf(i, rect, rect3)) {
                z = true;
                if (i != 17) {
                    z = true;
                    if (i != 66) {
                        z = true;
                        if (majorAxisDistance(i, rect, rect2) >= majorAxisDistanceToFarEdge(i, rect, rect3)) {
                            return false;
                        }
                    }
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean beamsOverlap(int i, Rect rect, Rect rect2) {
        switch (i) {
            case 17:
            case 66:
                return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
            case 33:
            case 130:
                return rect2.right >= rect.left && rect2.left <= rect.right;
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }

    public View findNearestTouchable(ViewGroup viewGroup, int i, int i2, int i3, int[] iArr) {
        View view;
        int i4;
        ArrayList<View> touchables = viewGroup.getTouchables();
        int i5 = Integer.MAX_VALUE;
        View view2 = null;
        int size = touchables.size();
        int scaledEdgeSlop = ViewConfiguration.get(viewGroup.mContext).getScaledEdgeSlop();
        Rect rect = new Rect();
        Rect rect2 = this.mOtherRect;
        int i6 = 0;
        while (i6 < size) {
            View view3 = touchables.get(i6);
            view3.getDrawingRect(rect2);
            viewGroup.offsetRectBetweenParentAndChild(view3, rect2, true, true);
            if (isTouchCandidate(i, i2, rect2, i3)) {
                int i7 = Integer.MAX_VALUE;
                switch (i3) {
                    case 17:
                        i7 = (i - rect2.right) + 1;
                        break;
                    case 33:
                        i7 = (i2 - rect2.bottom) + 1;
                        break;
                    case 66:
                        i7 = rect2.left;
                        break;
                    case 130:
                        i7 = rect2.top;
                        break;
                }
                view = view2;
                i4 = i5;
                if (i7 < scaledEdgeSlop) {
                    if (view2 != null && !rect.contains(rect2)) {
                        view = view2;
                        i4 = i5;
                        if (!rect2.contains(rect)) {
                            view = view2;
                            i4 = i5;
                            if (i7 >= i5) {
                            }
                        }
                    }
                    i4 = i7;
                    view = view3;
                    rect.set(rect2);
                    switch (i3) {
                        case 17:
                            iArr[0] = -i7;
                            continue;
                        case 33:
                            iArr[1] = -i7;
                            continue;
                        case 66:
                            iArr[0] = i7;
                            continue;
                        case 130:
                            iArr[1] = i7;
                            continue;
                    }
                }
            } else {
                i4 = i5;
                view = view2;
            }
            i6++;
            view2 = view;
            i5 = i4;
        }
        return view2;
    }

    public final View findNextFocus(ViewGroup viewGroup, View view, int i) {
        return findNextFocus(viewGroup, view, null, i);
    }

    public View findNextFocusFromRect(ViewGroup viewGroup, Rect rect, int i) {
        this.mFocusedRect.set(rect);
        return findNextFocus(viewGroup, null, this.mFocusedRect, i);
    }

    View findNextFocusInAbsoluteDirection(ArrayList<View> arrayList, ViewGroup viewGroup, View view, Rect rect, int i) {
        this.mBestCandidateRect.set(rect);
        switch (i) {
            case 17:
                this.mBestCandidateRect.offset(rect.width() + 1, 0);
                break;
            case 33:
                this.mBestCandidateRect.offset(0, rect.height() + 1);
                break;
            case 66:
                this.mBestCandidateRect.offset(-(rect.width() + 1), 0);
                break;
            case 130:
                this.mBestCandidateRect.offset(0, -(rect.height() + 1));
                break;
        }
        View view2 = null;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            View view3 = arrayList.get(i2);
            View view4 = view2;
            if (view3 != view) {
                if (view3 == viewGroup) {
                    view4 = view2;
                } else {
                    view3.getFocusedRect(this.mOtherRect);
                    viewGroup.offsetDescendantRectToMyCoords(view3, this.mOtherRect);
                    view4 = view2;
                    if (isBetterCandidate(i, rect, this.mOtherRect, this.mBestCandidateRect)) {
                        this.mBestCandidateRect.set(this.mOtherRect);
                        view4 = view3;
                    }
                }
            }
            i2++;
            view2 = view4;
        }
        return view2;
    }

    int getWeightedDistanceFor(int i, int i2) {
        return (i * 13 * i) + (i2 * i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isBetterCandidate(int i, Rect rect, Rect rect2, Rect rect3) {
        boolean z;
        if (isCandidate(rect, rect2, i)) {
            z = true;
            if (isCandidate(rect, rect3, i)) {
                z = true;
                if (!beamBeats(i, rect, rect2, rect3)) {
                    if (beamBeats(i, rect, rect3, rect2)) {
                        return false;
                    }
                    z = true;
                    if (getWeightedDistanceFor(majorAxisDistance(i, rect, rect2), minorAxisDistance(i, rect, rect2)) >= getWeightedDistanceFor(majorAxisDistance(i, rect, rect3), minorAxisDistance(i, rect, rect3))) {
                        return false;
                    }
                }
            }
        } else {
            z = false;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isCandidate(Rect rect, Rect rect2, int i) {
        switch (i) {
            case 17:
                return (rect.right > rect2.right || rect.left >= rect2.right) && rect.left > rect2.left;
            case 33:
                return (rect.bottom > rect2.bottom || rect.top >= rect2.bottom) && rect.top > rect2.top;
            case 66:
                return (rect.left < rect2.left || rect.right <= rect2.left) && rect.right < rect2.right;
            case 130:
                return (rect.top < rect2.top || rect.bottom <= rect2.top) && rect.bottom < rect2.bottom;
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }

    boolean isToDirectionOf(int i, Rect rect, Rect rect2) {
        switch (i) {
            case 17:
                return rect.left >= rect2.right;
            case 33:
                return rect.top >= rect2.bottom;
            case 66:
                return rect.right <= rect2.left;
            case 130:
                return rect.bottom <= rect2.top;
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }
}
