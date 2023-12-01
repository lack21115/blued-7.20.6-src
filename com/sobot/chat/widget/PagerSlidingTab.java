package com.sobot.chat.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.utils.ResourceUtils;
import java.util.Locale;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/PagerSlidingTab.class */
public class PagerSlidingTab extends HorizontalScrollView {
    private static final int[] ATTRS = {R.attr.textSize, R.attr.textColor};
    private boolean checkedTabWidths;
    private int curTabTextColor;
    private int currentPosition;
    private float currentPositionOffset;
    private LinearLayout.LayoutParams defaultTabLayoutParams;
    public ViewPager.OnPageChangeListener delegatePageListener;
    private int dividerColor;
    private int dividerPadding;
    private Paint dividerPaint;
    private int dividerWidth;
    private LinearLayout.LayoutParams expandedTabLayoutParams;
    private int indicatorColor;
    private int indicatorHeight;
    private int lastScrollX;
    private Locale locale;
    private int paddingBottom;
    private final PageListener pageListener;
    private ViewPager pager;
    private Paint rectPaint;
    private int scrollOffset;
    private boolean shouldExpand;
    private int tabBackgroundResId;
    private int tabCount;
    private int tabPadding;
    private int tabTextColor;
    private int tabTextSize;
    private Typeface tabTypeface;
    private int tabTypefaceStyle;
    private LinearLayout tabsContainer;
    private boolean textAllCaps;
    private int underlineColor;
    private int underlineHeight;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/PagerSlidingTab$IconTabProvider.class */
    public interface IconTabProvider {
        int getPageIconResId(int i);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/PagerSlidingTab$PageListener.class */
    class PageListener implements ViewPager.OnPageChangeListener {
        private PageListener() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (i == 0) {
                PagerSlidingTab pagerSlidingTab = PagerSlidingTab.this;
                pagerSlidingTab.scrollToChild(pagerSlidingTab.pager.getCurrentItem(), 0);
            }
            if (PagerSlidingTab.this.delegatePageListener != null) {
                PagerSlidingTab.this.delegatePageListener.onPageScrollStateChanged(i);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            PagerSlidingTab.this.currentPosition = i;
            PagerSlidingTab.this.currentPositionOffset = f;
            PagerSlidingTab pagerSlidingTab = PagerSlidingTab.this;
            pagerSlidingTab.scrollToChild(i, (int) (pagerSlidingTab.tabsContainer.getChildAt(i).getWidth() * f));
            PagerSlidingTab.this.invalidate();
            if (PagerSlidingTab.this.delegatePageListener != null) {
                PagerSlidingTab.this.delegatePageListener.onPageScrolled(i, f, i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (PagerSlidingTab.this.delegatePageListener != null) {
                PagerSlidingTab.this.delegatePageListener.onPageSelected(i);
            }
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= PagerSlidingTab.this.tabCount) {
                    return;
                }
                View childAt = PagerSlidingTab.this.tabsContainer.getChildAt(i3);
                if (childAt instanceof TextView) {
                    ((TextView) childAt).setTextColor(i3 == PagerSlidingTab.this.pager.getCurrentItem() ? PagerSlidingTab.this.curTabTextColor : PagerSlidingTab.this.tabTextColor);
                }
                i2 = i3 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/PagerSlidingTab$SavedState.class */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.sobot.chat.widget.PagerSlidingTab.SavedState.1
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
        int currentPosition;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.currentPosition = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.currentPosition);
        }
    }

    public PagerSlidingTab(Context context) {
        this(context, null);
    }

    public PagerSlidingTab(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTab(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pageListener = new PageListener();
        this.currentPosition = 0;
        this.currentPositionOffset = 0.0f;
        this.checkedTabWidths = false;
        this.indicatorColor = -16142672;
        this.underlineColor = 0;
        this.dividerColor = 0;
        this.shouldExpand = false;
        this.textAllCaps = true;
        this.scrollOffset = 52;
        this.indicatorHeight = 3;
        this.underlineHeight = 2;
        this.dividerPadding = 12;
        this.tabPadding = 14;
        this.dividerWidth = 1;
        this.paddingBottom = 4;
        this.tabTextSize = 14;
        this.tabTextColor = -5458492;
        this.curTabTextColor = -11445636;
        this.tabTypeface = null;
        this.tabTypefaceStyle = 1;
        this.lastScrollX = 0;
        this.tabBackgroundResId = 0;
        setFillViewport(true);
        setWillNotDraw(false);
        LinearLayout linearLayout = new LinearLayout(context);
        this.tabsContainer = linearLayout;
        linearLayout.setOrientation(0);
        this.tabsContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.tabsContainer);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.scrollOffset = (int) TypedValue.applyDimension(1, this.scrollOffset, displayMetrics);
        this.indicatorHeight = (int) TypedValue.applyDimension(1, this.indicatorHeight, displayMetrics);
        this.underlineHeight = (int) TypedValue.applyDimension(1, this.underlineHeight, displayMetrics);
        this.dividerPadding = (int) TypedValue.applyDimension(1, this.dividerPadding, displayMetrics);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, displayMetrics);
        this.dividerWidth = (int) TypedValue.applyDimension(1, this.dividerWidth, displayMetrics);
        this.tabTextSize = (int) TypedValue.applyDimension(1, this.tabTextSize, displayMetrics);
        this.paddingBottom = (int) TypedValue.applyDimension(1, this.paddingBottom, displayMetrics);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
        this.tabTextSize = obtainStyledAttributes.getDimensionPixelSize(0, this.tabTextSize);
        this.tabTextColor = obtainStyledAttributes.getColor(1, this.tabTextColor);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, com.sobot.chat.R.styleable.sobot_PagerSlidingTab);
        this.curTabTextColor = obtainStyledAttributes2.getColor(com.sobot.chat.R.styleable.sobot_PagerSlidingTab_curTabTextColor, this.curTabTextColor);
        this.tabTextColor = obtainStyledAttributes2.getColor(com.sobot.chat.R.styleable.sobot_PagerSlidingTab_tabTextColor, this.tabTextColor);
        this.indicatorColor = obtainStyledAttributes2.getColor(com.sobot.chat.R.styleable.sobot_PagerSlidingTab_indicatorColor, this.indicatorColor);
        this.underlineColor = obtainStyledAttributes2.getColor(com.sobot.chat.R.styleable.sobot_PagerSlidingTab_underlineColor, this.underlineColor);
        this.dividerColor = obtainStyledAttributes2.getColor(com.sobot.chat.R.styleable.sobot_PagerSlidingTab_sobotdividerColor, this.dividerColor);
        this.indicatorHeight = obtainStyledAttributes2.getDimensionPixelSize(com.sobot.chat.R.styleable.sobot_PagerSlidingTab_indicatorHeight, this.indicatorHeight);
        this.underlineHeight = obtainStyledAttributes2.getDimensionPixelSize(com.sobot.chat.R.styleable.sobot_PagerSlidingTab_underlineHeight, this.underlineHeight);
        this.dividerPadding = obtainStyledAttributes2.getDimensionPixelSize(com.sobot.chat.R.styleable.sobot_PagerSlidingTab_pst_dividerPadding, this.dividerPadding);
        this.tabPadding = obtainStyledAttributes2.getDimensionPixelSize(com.sobot.chat.R.styleable.sobot_PagerSlidingTab_tabPaddingLeftRight, this.tabPadding);
        this.tabBackgroundResId = obtainStyledAttributes2.getResourceId(com.sobot.chat.R.styleable.sobot_PagerSlidingTab_tabBackground, this.tabBackgroundResId);
        this.shouldExpand = obtainStyledAttributes2.getBoolean(com.sobot.chat.R.styleable.sobot_PagerSlidingTab_shouldExpand, this.shouldExpand);
        this.scrollOffset = obtainStyledAttributes2.getDimensionPixelSize(com.sobot.chat.R.styleable.sobot_PagerSlidingTab_scrollOffset, this.scrollOffset);
        this.textAllCaps = obtainStyledAttributes2.getBoolean(com.sobot.chat.R.styleable.sobot_PagerSlidingTab_pst_textAllCaps, this.textAllCaps);
        obtainStyledAttributes2.recycle();
        this.tabBackgroundResId = ResourceUtils.getDrawableId(getContext(), "sobot_background_tab");
        Paint paint = new Paint();
        this.rectPaint = paint;
        paint.setAntiAlias(true);
        this.rectPaint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.dividerPaint = paint2;
        paint2.setAntiAlias(true);
        this.dividerPaint.setStrokeWidth(this.dividerWidth);
        this.defaultTabLayoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        this.expandedTabLayoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        if (this.locale == null) {
            this.locale = getResources().getConfiguration().locale;
        }
    }

    private void addIconTab(final int i, int i2) {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setFocusable(true);
        imageButton.setImageResource(i2);
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.widget.PagerSlidingTab.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                PagerSlidingTab.this.pager.setCurrentItem(i);
            }
        });
        this.tabsContainer.addView(imageButton);
    }

    private void addTextTab(final int i, String str) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setFocusable(true);
        textView.setGravity(17);
        textView.setSingleLine();
        textView.setTypeface(Typeface.defaultFromStyle(1));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.sobot.chat.widget.PagerSlidingTab.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                PagerSlidingTab.this.pager.setCurrentItem(i);
            }
        });
        this.tabsContainer.addView(textView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001d, code lost:
        if (r6 > 0) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void scrollToChild(int r5, int r6) {
        /*
            r4 = this;
            r0 = r4
            int r0 = r0.tabCount
            if (r0 != 0) goto L8
            return
        L8:
            r0 = r4
            android.widget.LinearLayout r0 = r0.tabsContainer
            r1 = r5
            android.view.View r0 = r0.getChildAt(r1)
            int r0 = r0.getLeft()
            r1 = r6
            int r0 = r0 + r1
            r7 = r0
            r0 = r5
            if (r0 > 0) goto L20
            r0 = r7
            r5 = r0
            r0 = r6
            if (r0 <= 0) goto L27
        L20:
            r0 = r7
            r1 = r4
            int r1 = r1.scrollOffset
            int r0 = r0 - r1
            r5 = r0
        L27:
            r0 = r5
            r1 = r4
            int r1 = r1.lastScrollX
            if (r0 == r1) goto L3a
            r0 = r4
            r1 = r5
            r0.lastScrollX = r1
            r0 = r4
            r1 = r5
            r2 = 0
            r0.scrollTo(r1, r2)
        L3a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.widget.PagerSlidingTab.scrollToChild(int, int):void");
    }

    private void updateTabStyles() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.tabCount) {
                return;
            }
            View childAt = this.tabsContainer.getChildAt(i2);
            childAt.setLayoutParams(this.defaultTabLayoutParams);
            childAt.setBackgroundResource(this.tabBackgroundResId);
            if (this.shouldExpand) {
                childAt.setPadding(0, 0, 0, 0);
            } else {
                int i3 = this.tabPadding;
                childAt.setPadding(i3, 0, i3, 0);
            }
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                textView.setTextSize(0, this.tabTextSize);
                textView.setTypeface(this.tabTypeface, this.tabTypefaceStyle);
                textView.setTextColor(i2 == 0 ? this.curTabTextColor : this.tabTextColor);
                textView.setText(textView.getText().toString());
            }
            i = i2 + 1;
        }
    }

    public int getDividerColor() {
        return this.dividerColor;
    }

    public int getDividerPadding() {
        return this.dividerPadding;
    }

    public int getIndicatorColor() {
        return this.indicatorColor;
    }

    public int getIndicatorHeight() {
        return this.indicatorHeight;
    }

    public int getScrollOffset() {
        return this.scrollOffset;
    }

    public boolean getShouldExpand() {
        return this.shouldExpand;
    }

    public int getTabBackground() {
        return this.tabBackgroundResId;
    }

    public int getTabPaddingLeftRight() {
        return this.tabPadding;
    }

    public int getTextColor() {
        return this.tabTextColor;
    }

    public int getTextSize() {
        return this.tabTextSize;
    }

    public int getUnderlineColor() {
        return this.underlineColor;
    }

    public int getUnderlineHeight() {
        return this.underlineHeight;
    }

    public boolean isTextAllCaps() {
        return this.textAllCaps;
    }

    public void notifyDataSetChanged() {
        this.tabsContainer.removeAllViews();
        this.tabCount = this.pager.getAdapter().getCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.tabCount) {
                updateTabStyles();
                this.checkedTabWidths = false;
                getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.sobot.chat.widget.PagerSlidingTab.1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        PagerSlidingTab.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                        PagerSlidingTab pagerSlidingTab = PagerSlidingTab.this;
                        pagerSlidingTab.currentPosition = pagerSlidingTab.pager.getCurrentItem();
                        PagerSlidingTab pagerSlidingTab2 = PagerSlidingTab.this;
                        pagerSlidingTab2.scrollToChild(pagerSlidingTab2.currentPosition, 0);
                    }
                });
                return;
            }
            if (this.pager.getAdapter() instanceof IconTabProvider) {
                addIconTab(i2, ((IconTabProvider) this.pager.getAdapter()).getPageIconResId(i2));
            } else {
                addTextTab(i2, this.pager.getAdapter().getPageTitle(i2).toString());
            }
            i = i2 + 1;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isInEditMode() || this.tabCount == 0) {
            return;
        }
        int height = getHeight();
        this.rectPaint.setStrokeCap(Paint.Cap.ROUND);
        this.rectPaint.setColor(this.indicatorColor);
        View childAt = this.tabsContainer.getChildAt(this.currentPosition);
        float left = childAt.getLeft();
        float right = childAt.getRight();
        float f = left;
        float f2 = right;
        if (this.currentPositionOffset > 0.0f) {
            int i = this.currentPosition;
            f = left;
            f2 = right;
            if (i < this.tabCount - 1) {
                View childAt2 = this.tabsContainer.getChildAt(i + 1);
                float left2 = childAt2.getLeft();
                float right2 = childAt2.getRight();
                float f3 = this.currentPositionOffset;
                f = (left2 * f3) + ((1.0f - f3) * left);
                f2 = (right2 * f3) + ((1.0f - f3) * right);
            }
        }
        float width = childAt.getWidth();
        if (Build.VERSION.SDK_INT > 21) {
            float f4 = (40.0f * width) / 70.0f;
            int i2 = this.indicatorHeight;
            int i3 = this.paddingBottom;
            canvas.drawRoundRect(f + f4, (height - i2) - i3, f2 - ((width * 4.0f) / 7.0f), height - i3, 20.0f, 20.0f, this.rectPaint);
        } else {
            float f5 = (width * 3.0f) / 7.0f;
            int i4 = this.indicatorHeight;
            int i5 = this.paddingBottom;
            canvas.drawRoundRect(new RectF(f + f5, (height - i4) - i5, f2 - f5, height - i5), 20.0f, 20.0f, this.rectPaint);
        }
        this.rectPaint.setColor(this.underlineColor);
        canvas.drawRect(0.0f, height - this.underlineHeight, this.tabsContainer.getWidth(), height, this.rectPaint);
        this.dividerPaint.setColor(this.dividerColor);
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= this.tabCount - 1) {
                return;
            }
            View childAt3 = this.tabsContainer.getChildAt(i7);
            canvas.drawLine(childAt3.getRight(), this.dividerPadding, childAt3.getRight(), height - this.dividerPadding, this.dividerPaint);
            i6 = i7 + 1;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!this.shouldExpand || View.MeasureSpec.getMode(i) == 0) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int i3 = 0;
        for (int i4 = 0; i4 < this.tabCount; i4++) {
            i3 += this.tabsContainer.getChildAt(i4).getMeasuredWidth();
        }
        if (this.checkedTabWidths || i3 <= 0 || measuredWidth <= 0) {
            return;
        }
        if (i3 <= measuredWidth) {
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= this.tabCount) {
                    break;
                }
                this.tabsContainer.getChildAt(i6).setLayoutParams(this.expandedTabLayoutParams);
                i5 = i6 + 1;
            }
        }
        this.checkedTabWidths = true;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.currentPosition = savedState.currentPosition;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.currentPosition = this.currentPosition;
        return savedState;
    }

    public void setAllCaps(boolean z) {
        this.textAllCaps = z;
    }

    public void setDividerColor(int i) {
        this.dividerColor = i;
        invalidate();
    }

    public void setDividerColorResource(int i) {
        this.dividerColor = getResources().getColor(i);
        invalidate();
    }

    public void setDividerPadding(int i) {
        this.dividerPadding = i;
        invalidate();
    }

    public void setIndicatorColor(int i) {
        this.indicatorColor = i;
        invalidate();
    }

    public void setIndicatorColorResource(int i) {
        this.indicatorColor = getResources().getColor(i);
        invalidate();
    }

    public void setIndicatorHeight(int i) {
        this.indicatorHeight = i;
        invalidate();
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.delegatePageListener = onPageChangeListener;
    }

    public void setScrollOffset(int i) {
        this.scrollOffset = i;
        invalidate();
    }

    public void setShouldExpand(boolean z) {
        this.shouldExpand = z;
        requestLayout();
    }

    public void setTabBackground(int i) {
        this.tabBackgroundResId = i;
    }

    public void setTabPaddingLeftRight(int i) {
        this.tabPadding = i;
        updateTabStyles();
    }

    public void setTextColor(int i) {
        this.tabTextColor = i;
        updateTabStyles();
    }

    public void setTextColorResource(int i) {
        this.tabTextColor = getResources().getColor(i);
        updateTabStyles();
    }

    public void setTextSize(int i) {
        this.tabTextSize = i;
        updateTabStyles();
    }

    public void setTypeface(Typeface typeface, int i) {
        this.tabTypeface = typeface;
        this.tabTypefaceStyle = i;
        updateTabStyles();
    }

    public void setUnderlineColor(int i) {
        this.underlineColor = i;
        invalidate();
    }

    public void setUnderlineColorResource(int i) {
        this.underlineColor = getResources().getColor(i);
        invalidate();
    }

    public void setUnderlineHeight(int i) {
        this.underlineHeight = i;
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        this.pager = viewPager;
        if (viewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        viewPager.setOnPageChangeListener(this.pageListener);
        notifyDataSetChanged();
    }
}
