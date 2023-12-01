package com.android.internal.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.android.internal.R;
import com.android.internal.view.menu.MenuBuilder;
import java.util.ArrayList;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/view/menu/IconMenuView.class */
public final class IconMenuView extends ViewGroup implements MenuBuilder.ItemInvoker, MenuView, Runnable {
    private static final int ITEM_CAPTION_CYCLE_DELAY = 1000;
    private int mAnimations;
    private boolean mHasStaleChildren;
    private Drawable mHorizontalDivider;
    private int mHorizontalDividerHeight;
    private ArrayList<Rect> mHorizontalDividerRects;
    private Drawable mItemBackground;
    private boolean mLastChildrenCaptionMode;
    private int[] mLayout;
    private int mLayoutNumRows;
    private int mMaxItems;
    private int mMaxItemsPerRow;
    private int mMaxRows;
    private MenuBuilder mMenu;
    private boolean mMenuBeingLongpressed;
    private Drawable mMoreIcon;
    private int mNumActualItemsShown;
    private int mRowHeight;
    private Drawable mVerticalDivider;
    private ArrayList<Rect> mVerticalDividerRects;
    private int mVerticalDividerWidth;

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/view/menu/IconMenuView$LayoutParams.class */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        int bottom;
        int desiredWidth;
        int left;
        int maxNumItemsOnRow;
        int right;
        int top;

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/view/menu/IconMenuView$SavedState.class */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.android.internal.view.menu.IconMenuView.SavedState.1
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
        int focusedPosition;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.focusedPosition = parcel.readInt();
        }

        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.focusedPosition = i;
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.focusedPosition);
        }
    }

    public IconMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMenuBeingLongpressed = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IconMenuView, 0, 0);
        this.mRowHeight = obtainStyledAttributes.getDimensionPixelSize(0, 64);
        this.mMaxRows = obtainStyledAttributes.getInt(1, 2);
        this.mMaxItems = obtainStyledAttributes.getInt(4, 6);
        this.mMaxItemsPerRow = obtainStyledAttributes.getInt(2, 3);
        this.mMoreIcon = obtainStyledAttributes.getDrawable(3);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.MenuView, 0, 0);
        this.mItemBackground = obtainStyledAttributes2.getDrawable(5);
        this.mHorizontalDivider = obtainStyledAttributes2.getDrawable(2);
        this.mHorizontalDividerRects = new ArrayList<>();
        this.mVerticalDivider = obtainStyledAttributes2.getDrawable(3);
        this.mVerticalDividerRects = new ArrayList<>();
        this.mAnimations = obtainStyledAttributes2.getResourceId(0, 0);
        obtainStyledAttributes2.recycle();
        if (this.mHorizontalDivider != null) {
            this.mHorizontalDividerHeight = this.mHorizontalDivider.getIntrinsicHeight();
            if (this.mHorizontalDividerHeight == -1) {
                this.mHorizontalDividerHeight = 1;
            }
        }
        if (this.mVerticalDivider != null) {
            this.mVerticalDividerWidth = this.mVerticalDivider.getIntrinsicWidth();
            if (this.mVerticalDividerWidth == -1) {
                this.mVerticalDividerWidth = 1;
            }
        }
        this.mLayout = new int[this.mMaxRows];
        setWillNotDraw(false);
        setFocusableInTouchMode(true);
        setDescendantFocusability(262144);
    }

    private void calculateItemFittingMetadata(int i) {
        int i2 = this.mMaxItemsPerRow;
        int childCount = getChildCount();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= childCount) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) getChildAt(i4).getLayoutParams();
            layoutParams.maxNumItemsOnRow = 1;
            int i5 = i2;
            while (true) {
                int i6 = i5;
                if (i6 <= 0) {
                    break;
                } else if (layoutParams.desiredWidth < i / i6) {
                    layoutParams.maxNumItemsOnRow = i6;
                    break;
                } else {
                    i5 = i6 - 1;
                }
            }
            i3 = i4 + 1;
        }
    }

    private boolean doItemsFit() {
        boolean z;
        int i = 0;
        int[] iArr = this.mLayout;
        int i2 = this.mLayoutNumRows;
        int i3 = 0;
        loop0: while (true) {
            int i4 = i3;
            z = true;
            if (i4 >= i2) {
                break;
            }
            int i5 = iArr[i4];
            if (i5 == 1) {
                i++;
            } else {
                int i6 = i5;
                while (i6 > 0) {
                    if (((LayoutParams) getChildAt(i).getLayoutParams()).maxNumItemsOnRow < i5) {
                        z = false;
                        break loop0;
                    }
                    i6--;
                    i++;
                }
                continue;
            }
            i3 = i4 + 1;
        }
        return z;
    }

    private void layoutItems(int i) {
        int childCount = getChildCount();
        if (childCount == 0) {
            this.mLayoutNumRows = 0;
            return;
        }
        int min = Math.min((int) Math.ceil(childCount / this.mMaxItemsPerRow), this.mMaxRows);
        while (true) {
            int i2 = min;
            if (i2 > this.mMaxRows) {
                return;
            }
            layoutItemsUsingGravity(i2, childCount);
            if (i2 >= childCount || doItemsFit()) {
                return;
            }
            min = i2 + 1;
        }
    }

    private void layoutItemsUsingGravity(int i, int i2) {
        int i3 = i2 / i;
        int[] iArr = this.mLayout;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= i) {
                this.mLayoutNumRows = i;
                return;
            }
            iArr[i5] = i3;
            if (i5 >= i - (i2 % i)) {
                iArr[i5] = iArr[i5] + 1;
            }
            i4 = i5 + 1;
        }
    }

    private void positionChildren(int i, int i2) {
        if (this.mHorizontalDivider != null) {
            this.mHorizontalDividerRects.clear();
        }
        if (this.mVerticalDivider != null) {
            this.mVerticalDividerRects.clear();
        }
        int i3 = this.mLayoutNumRows;
        int[] iArr = this.mLayout;
        int i4 = 0;
        LayoutParams layoutParams = null;
        float f = 0.0f;
        float f2 = (i2 - (this.mHorizontalDividerHeight * (i3 - 1))) / i3;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= i3) {
                return;
            }
            float f3 = 0.0f;
            float f4 = (i - (this.mVerticalDividerWidth * (iArr[i6] - 1))) / iArr[i6];
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 >= iArr[i6]) {
                    break;
                }
                View childAt = getChildAt(i4);
                childAt.measure(View.MeasureSpec.makeMeasureSpec((int) f4, 1073741824), View.MeasureSpec.makeMeasureSpec((int) f2, 1073741824));
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.left = (int) f3;
                layoutParams.right = (int) (f3 + f4);
                layoutParams.top = (int) f;
                layoutParams.bottom = (int) (f + f2);
                float f5 = f3 + f4;
                i4++;
                if (this.mVerticalDivider != null) {
                    this.mVerticalDividerRects.add(new Rect((int) f5, (int) f, (int) (this.mVerticalDividerWidth + f5), (int) (f + f2)));
                }
                f3 = f5 + this.mVerticalDividerWidth;
                i7 = i8 + 1;
            }
            if (layoutParams != null) {
                layoutParams.right = i;
            }
            float f6 = f + f2;
            f = f6;
            if (this.mHorizontalDivider != null) {
                f = f6;
                if (i6 < i3 - 1) {
                    this.mHorizontalDividerRects.add(new Rect(0, (int) f6, i, (int) (this.mHorizontalDividerHeight + f6)));
                    f = f6 + this.mHorizontalDividerHeight;
                }
            }
            i5 = i6 + 1;
        }
    }

    private void setChildrenCaptionMode(boolean z) {
        this.mLastChildrenCaptionMode = z;
        int childCount = getChildCount();
        while (true) {
            int i = childCount - 1;
            if (i < 0) {
                return;
            }
            ((IconMenuItemView) getChildAt(i)).setCaptionMode(z);
            childCount = i;
        }
    }

    private void setCycleShortcutCaptionMode(boolean z) {
        if (z) {
            setChildrenCaptionMode(true);
            return;
        }
        removeCallbacks(this);
        setChildrenCaptionMode(false);
        this.mMenuBeingLongpressed = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IconMenuItemView createMoreItemView() {
        Context context = getContext();
        IconMenuItemView iconMenuItemView = (IconMenuItemView) LayoutInflater.from(context).inflate(R.layout.icon_menu_item_layout, (ViewGroup) null);
        iconMenuItemView.initialize(context.getResources().getText(R.string.more_item_label), this.mMoreIcon);
        iconMenuItemView.setOnClickListener(new View.OnClickListener() { // from class: com.android.internal.view.menu.IconMenuView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IconMenuView.this.mMenu.changeMenuMode();
            }
        });
        return iconMenuItemView;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 82) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                removeCallbacks(this);
                postDelayed(this, ViewConfiguration.getLongPressTimeout());
            } else if (keyEvent.getAction() == 1) {
                if (this.mMenuBeingLongpressed) {
                    setCycleShortcutCaptionMode(false);
                    return true;
                }
                removeCallbacks(this);
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable getItemBackgroundDrawable() {
        return this.mItemBackground.getConstantState().newDrawable(getContext().getResources());
    }

    public int[] getLayout() {
        return this.mLayout;
    }

    public int getLayoutNumRows() {
        return this.mLayoutNumRows;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMaxItems() {
        return this.mMaxItems;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getNumActualItemsShown() {
        return this.mNumActualItemsShown;
    }

    @Override // com.android.internal.view.menu.MenuView
    public int getWindowAnimations() {
        return this.mAnimations;
    }

    @Override // com.android.internal.view.menu.MenuView
    public void initialize(MenuBuilder menuBuilder) {
        this.mMenu = menuBuilder;
    }

    @Override // com.android.internal.view.menu.MenuBuilder.ItemInvoker
    public boolean invokeItem(MenuItemImpl menuItemImpl) {
        return this.mMenu.performItemAction(menuItemImpl, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void markStaleChildren() {
        if (this.mHasStaleChildren) {
            return;
        }
        this.mHasStaleChildren = true;
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        setCycleShortcutCaptionMode(false);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Drawable drawable = this.mHorizontalDivider;
        if (drawable != null) {
            ArrayList<Rect> arrayList = this.mHorizontalDividerRects;
            int size = arrayList.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    break;
                }
                drawable.setBounds(arrayList.get(i));
                drawable.draw(canvas);
                size = i;
            }
        }
        Drawable drawable2 = this.mVerticalDivider;
        if (drawable2 == null) {
            return;
        }
        ArrayList<Rect> arrayList2 = this.mVerticalDividerRects;
        int size2 = arrayList2.size();
        while (true) {
            int i2 = size2 - 1;
            if (i2 < 0) {
                return;
            }
            drawable2.setBounds(arrayList2.get(i2));
            drawable2.draw(canvas);
            size2 = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        while (true) {
            int i5 = childCount - 1;
            if (i5 < 0) {
                return;
            }
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            childAt.layout(layoutParams.left, layoutParams.top, layoutParams.right, layoutParams.bottom);
            childCount = i5;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int resolveSize = resolveSize(Integer.MAX_VALUE, i);
        calculateItemFittingMetadata(resolveSize);
        layoutItems(resolveSize);
        int i3 = this.mLayoutNumRows;
        setMeasuredDimension(resolveSize, resolveSize(((this.mRowHeight + this.mHorizontalDividerHeight) * i3) - this.mHorizontalDividerHeight, i2));
        if (i3 > 0) {
            positionChildren(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        View childAt;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.focusedPosition < getChildCount() && (childAt = getChildAt(savedState.focusedPosition)) != null) {
            childAt.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        View focusedChild = getFocusedChild();
        int childCount = getChildCount();
        while (true) {
            int i = childCount - 1;
            if (i < 0) {
                return new SavedState(onSaveInstanceState, -1);
            }
            if (getChildAt(i) == focusedChild) {
                return new SavedState(onSaveInstanceState, i);
            }
            childCount = i;
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        if (!z) {
            setCycleShortcutCaptionMode(false);
        }
        super.onWindowFocusChanged(z);
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z = true;
        if (this.mMenuBeingLongpressed) {
            if (this.mLastChildrenCaptionMode) {
                z = false;
            }
            setChildrenCaptionMode(z);
        } else {
            this.mMenuBeingLongpressed = true;
            setCycleShortcutCaptionMode(true);
        }
        postDelayed(this, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setNumActualItemsShown(int i) {
        this.mNumActualItemsShown = i;
    }
}
