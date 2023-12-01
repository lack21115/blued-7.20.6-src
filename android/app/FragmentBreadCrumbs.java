package android.app;

import android.animation.LayoutTransition;
import android.app.FragmentManager;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.internal.R;

@Deprecated
/* loaded from: source-9557208-dex2jar.jar:android/app/FragmentBreadCrumbs.class */
public class FragmentBreadCrumbs extends ViewGroup implements FragmentManager.OnBackStackChangedListener {
    private static final int DEFAULT_GRAVITY = 8388627;
    Activity mActivity;
    LinearLayout mContainer;
    private int mGravity;
    LayoutInflater mInflater;
    private int mLayoutResId;
    int mMaxVisible;
    private OnBreadCrumbClickListener mOnBreadCrumbClickListener;
    private View.OnClickListener mOnClickListener;
    private View.OnClickListener mParentClickListener;
    BackStackRecord mParentEntry;
    private int mTextColor;
    BackStackRecord mTopEntry;

    /* loaded from: source-9557208-dex2jar.jar:android/app/FragmentBreadCrumbs$OnBreadCrumbClickListener.class */
    public interface OnBreadCrumbClickListener {
        boolean onBreadCrumbClick(FragmentManager.BackStackEntry backStackEntry, int i);
    }

    public FragmentBreadCrumbs(Context context) {
        this(context, null);
    }

    public FragmentBreadCrumbs(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 18219030);
    }

    public FragmentBreadCrumbs(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public FragmentBreadCrumbs(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mMaxVisible = -1;
        this.mOnClickListener = new View.OnClickListener() { // from class: android.app.FragmentBreadCrumbs.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getTag() instanceof FragmentManager.BackStackEntry) {
                    FragmentManager.BackStackEntry backStackEntry = (FragmentManager.BackStackEntry) view.getTag();
                    if (backStackEntry == FragmentBreadCrumbs.this.mParentEntry) {
                        if (FragmentBreadCrumbs.this.mParentClickListener != null) {
                            FragmentBreadCrumbs.this.mParentClickListener.onClick(view);
                            return;
                        }
                        return;
                    }
                    if (FragmentBreadCrumbs.this.mOnBreadCrumbClickListener != null) {
                        if (FragmentBreadCrumbs.this.mOnBreadCrumbClickListener.onBreadCrumbClick(backStackEntry == FragmentBreadCrumbs.this.mTopEntry ? null : backStackEntry, 0)) {
                            return;
                        }
                    }
                    if (backStackEntry == FragmentBreadCrumbs.this.mTopEntry) {
                        FragmentBreadCrumbs.this.mActivity.getFragmentManager().popBackStack();
                    } else {
                        FragmentBreadCrumbs.this.mActivity.getFragmentManager().popBackStack(backStackEntry.getId(), 0);
                    }
                }
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FragmentBreadCrumbs, i, i2);
        this.mGravity = obtainStyledAttributes.getInt(0, DEFAULT_GRAVITY);
        this.mLayoutResId = obtainStyledAttributes.getResourceId(1, 17367121);
        this.mTextColor = obtainStyledAttributes.getColor(2, 0);
        obtainStyledAttributes.recycle();
    }

    private BackStackRecord createBackStackEntry(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null) {
            return null;
        }
        BackStackRecord backStackRecord = new BackStackRecord((FragmentManagerImpl) this.mActivity.getFragmentManager());
        backStackRecord.setBreadCrumbTitle(charSequence);
        backStackRecord.setBreadCrumbShortTitle(charSequence2);
        return backStackRecord;
    }

    private FragmentManager.BackStackEntry getPreEntry(int i) {
        if (this.mParentEntry != null && i == 0) {
            return this.mParentEntry;
        }
        return this.mTopEntry;
    }

    private int getPreEntryCount() {
        int i = 1;
        int i2 = this.mTopEntry != null ? 1 : 0;
        if (this.mParentEntry == null) {
            i = 0;
        }
        return i2 + i;
    }

    @Override // android.app.FragmentManager.OnBackStackChangedListener
    public void onBackStackChanged() {
        updateCrumbs();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int measuredWidth2;
        if (getChildCount() == 0) {
            return;
        }
        View childAt = getChildAt(0);
        int i5 = this.mPaddingTop;
        int i6 = this.mPaddingTop;
        int measuredHeight = childAt.getMeasuredHeight();
        int i7 = this.mPaddingBottom;
        switch (Gravity.getAbsoluteGravity(this.mGravity & 8388615, getLayoutDirection())) {
            case 1:
                measuredWidth = this.mPaddingLeft + (((this.mRight - this.mLeft) - childAt.getMeasuredWidth()) / 2);
                measuredWidth2 = measuredWidth + childAt.getMeasuredWidth();
                break;
            case 5:
                measuredWidth2 = (this.mRight - this.mLeft) - this.mPaddingRight;
                measuredWidth = measuredWidth2 - childAt.getMeasuredWidth();
                break;
            default:
                measuredWidth = this.mPaddingLeft;
                measuredWidth2 = measuredWidth + childAt.getMeasuredWidth();
                break;
        }
        int i8 = measuredWidth;
        if (measuredWidth < this.mPaddingLeft) {
            i8 = this.mPaddingLeft;
        }
        int i9 = measuredWidth2;
        if (measuredWidth2 > (this.mRight - this.mLeft) - this.mPaddingRight) {
            i9 = (this.mRight - this.mLeft) - this.mPaddingRight;
        }
        childAt.layout(i8, i5, i9, (i6 + measuredHeight) - i7);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i6 < childCount) {
            View childAt = getChildAt(i6);
            int i7 = i3;
            int i8 = i4;
            int i9 = i5;
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i, i2);
                i8 = Math.max(i4, childAt.getMeasuredWidth());
                i7 = Math.max(i3, childAt.getMeasuredHeight());
                i9 = combineMeasuredStates(i5, childAt.getMeasuredState());
            }
            i6++;
            i3 = i7;
            i4 = i8;
            i5 = i9;
        }
        setMeasuredDimension(resolveSizeAndState(Math.max(i4 + this.mPaddingLeft + this.mPaddingRight, getSuggestedMinimumWidth()), i, i5), resolveSizeAndState(Math.max(i3 + this.mPaddingTop + this.mPaddingBottom, getSuggestedMinimumHeight()), i2, i5 << 16));
    }

    public void setActivity(Activity activity) {
        this.mActivity = activity;
        this.mInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mContainer = (LinearLayout) this.mInflater.inflate(17367123, (ViewGroup) this, false);
        addView(this.mContainer);
        activity.getFragmentManager().addOnBackStackChangedListener(this);
        updateCrumbs();
        setLayoutTransition(new LayoutTransition());
    }

    public void setMaxVisible(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("visibleCrumbs must be greater than zero");
        }
        this.mMaxVisible = i;
    }

    public void setOnBreadCrumbClickListener(OnBreadCrumbClickListener onBreadCrumbClickListener) {
        this.mOnBreadCrumbClickListener = onBreadCrumbClickListener;
    }

    public void setParentTitle(CharSequence charSequence, CharSequence charSequence2, View.OnClickListener onClickListener) {
        this.mParentEntry = createBackStackEntry(charSequence, charSequence2);
        this.mParentClickListener = onClickListener;
        updateCrumbs();
    }

    public void setTitle(CharSequence charSequence, CharSequence charSequence2) {
        this.mTopEntry = createBackStackEntry(charSequence, charSequence2);
        updateCrumbs();
    }

    void updateCrumbs() {
        int i;
        FragmentManager fragmentManager = this.mActivity.getFragmentManager();
        int backStackEntryCount = fragmentManager.getBackStackEntryCount();
        int preEntryCount = getPreEntryCount();
        int childCount = this.mContainer.getChildCount();
        int i2 = 0;
        while (i2 < backStackEntryCount + preEntryCount) {
            FragmentManager.BackStackEntry preEntry = i2 < preEntryCount ? getPreEntry(i2) : fragmentManager.getBackStackEntryAt(i2 - preEntryCount);
            int i3 = childCount;
            if (i2 < childCount) {
                i3 = childCount;
                if (this.mContainer.getChildAt(i2).getTag() != preEntry) {
                    int i4 = i2;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= childCount) {
                            break;
                        }
                        this.mContainer.removeViewAt(i2);
                        i4 = i5 + 1;
                    }
                    i3 = i2;
                }
            }
            if (i2 >= i3) {
                View inflate = this.mInflater.inflate(this.mLayoutResId, (ViewGroup) this, false);
                TextView textView = (TextView) inflate.findViewById(android.R.id.title);
                textView.setText(preEntry.getBreadCrumbTitle());
                textView.setTag(preEntry);
                textView.setTextColor(this.mTextColor);
                if (i2 == 0) {
                    inflate.findViewById(16908338).setVisibility(8);
                }
                this.mContainer.addView(inflate);
                textView.setOnClickListener(this.mOnClickListener);
            }
            i2++;
            childCount = i3;
        }
        int childCount2 = this.mContainer.getChildCount();
        while (true) {
            i = childCount2;
            if (i <= backStackEntryCount + preEntryCount) {
                break;
            }
            this.mContainer.removeViewAt(i - 1);
            childCount2 = i - 1;
        }
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= i) {
                return;
            }
            View childAt = this.mContainer.getChildAt(i7);
            childAt.findViewById(android.R.id.title).setEnabled(i7 < i - 1);
            if (this.mMaxVisible > 0) {
                childAt.setVisibility(i7 < i - this.mMaxVisible ? 8 : 0);
                childAt.findViewById(16908338).setVisibility((i7 <= i - this.mMaxVisible || i7 == 0) ? 8 : 0);
            }
            i6 = i7 + 1;
        }
    }
}
