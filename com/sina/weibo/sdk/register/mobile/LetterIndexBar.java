package com.sina.weibo.sdk.register.mobile;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.sina.weibo.sdk.utils.ResourceManager;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/register/mobile/LetterIndexBar.class */
public class LetterIndexBar extends View {
    public static final int INDEX_COUNT_DEFAULT = 27;
    public static final String SEARCH_ICON_LETTER = "";
    private int count;
    private int mIndex;
    private String[] mIndexLetter;
    private int mItemHeight;
    private int mItemPadding;
    private OnIndexChangeListener mListener;
    private boolean[] mNeedIndex;
    private int mOrgTextSzie;
    private Paint mPaint;
    private RectF mRect;
    private Drawable mSeatchIcon;
    private boolean mTouching;

    /* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/register/mobile/LetterIndexBar$OnIndexChangeListener.class */
    public interface OnIndexChangeListener {
        void onIndexChange(int i);
    }

    public LetterIndexBar(Context context) {
        super(context);
        this.mPaint = new Paint();
        this.count = 27;
        init();
    }

    public LetterIndexBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPaint = new Paint();
        this.count = 27;
        init();
    }

    public LetterIndexBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = new Paint();
        this.count = 27;
        init();
    }

    private void init() {
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(-10658467);
        this.mOrgTextSzie = ResourceManager.dp2px(getContext(), 13);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String valueOf;
        char c2;
        super.onDraw(canvas);
        if (this.mTouching) {
            int color = this.mPaint.getColor();
            this.mPaint.setColor(-2005436536);
            canvas.drawRoundRect(this.mRect, getMeasuredWidth() / 2, getMeasuredWidth() / 2, this.mPaint);
            this.mPaint.setColor(color);
        }
        int i = this.mOrgTextSzie;
        int i2 = this.mItemHeight;
        int i3 = i;
        if (i > i2) {
            i3 = i2;
        }
        this.mPaint.setTextSize(i3);
        if (this.mIndexLetter != null) {
            for (int i4 = 0; i4 < this.count; i4++) {
                int paddingTop = (this.mItemHeight * i4) + getPaddingTop() + i3 + this.mItemPadding;
                boolean[] zArr = this.mNeedIndex;
                if (zArr == null || zArr[i4]) {
                    String str = this.mIndexLetter[i4];
                    if (str.equals("")) {
                        int measureText = (int) this.mPaint.measureText("M");
                        int measuredWidth = (getMeasuredWidth() - measureText) / 2;
                        this.mSeatchIcon.setBounds(measuredWidth, paddingTop - measuredWidth, measureText + measuredWidth, (measureText + paddingTop) - measuredWidth);
                        this.mSeatchIcon.draw(canvas);
                    } else {
                        canvas.drawText(str, (getMeasuredWidth() - ((int) this.mPaint.measureText(str))) / 2, paddingTop, this.mPaint);
                    }
                }
            }
            return;
        }
        char c3 = 'A';
        int i5 = 0;
        while (i5 < this.count) {
            int i6 = this.mItemHeight;
            int paddingTop2 = getPaddingTop();
            int i7 = this.mItemPadding;
            boolean[] zArr2 = this.mNeedIndex;
            if (zArr2 != null) {
                c2 = c3;
                if (!zArr2[i5]) {
                    i5++;
                    c3 = c2;
                }
            }
            if (i5 == this.count - 1) {
                valueOf = "#";
            } else {
                valueOf = String.valueOf(c3);
                c3 = (char) (c3 + 1);
            }
            canvas.drawText(valueOf, (getMeasuredWidth() - ((int) this.mPaint.measureText(valueOf))) / 2, (i6 * i5) + paddingTop2 + i3 + i7, this.mPaint);
            c2 = c3;
            i5++;
            c3 = c2;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        int paddingTop = ((size - getPaddingTop()) - getPaddingBottom()) / this.count;
        this.mItemHeight = paddingTop;
        this.mItemPadding = (int) ((paddingTop - this.mPaint.getTextSize()) / 2.0f);
        setMeasuredDimension(this.mOrgTextSzie + getPaddingLeft() + getPaddingRight(), i2);
        this.mRect = new RectF(0.0f, getPaddingTop(), getMeasuredWidth(), (size - getPaddingTop()) - getPaddingBottom());
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001a, code lost:
        if (r0 != 4) goto L11;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r4) {
        /*
            r3 = this;
            r0 = r4
            int r0 = r0.getAction()
            r5 = r0
            r0 = r5
            if (r0 == 0) goto L28
            r0 = r5
            r1 = 1
            if (r0 == r1) goto L20
            r0 = r5
            r1 = 2
            if (r0 == r1) goto L28
            r0 = r5
            r1 = 3
            if (r0 == r1) goto L20
            r0 = r5
            r1 = 4
            if (r0 == r1) goto L20
            goto L75
        L20:
            r0 = r3
            r1 = 0
            r0.mTouching = r1
            goto L75
        L28:
            r0 = r3
            r1 = 1
            r0.mTouching = r1
            r0 = r4
            float r0 = r0.getY()
            int r0 = (int) r0
            r1 = r3
            int r1 = r1.getPaddingTop()
            int r0 = r0 - r1
            r1 = r3
            int r1 = r1.mItemHeight
            int r0 = r0 / r1
            r5 = r0
            r0 = r5
            r1 = r3
            int r1 = r1.mIndex
            if (r0 == r1) goto L75
            r0 = r3
            boolean[] r0 = r0.mNeedIndex
            r4 = r0
            r0 = r4
            if (r0 == 0) goto L54
            r0 = r4
            r1 = r5
            r0 = r0[r1]
            if (r0 == 0) goto L75
        L54:
            r0 = r5
            r1 = r3
            int r1 = r1.count
            if (r0 >= r1) goto L75
            r0 = r5
            if (r0 < 0) goto L75
            r0 = r3
            r1 = r5
            r0.mIndex = r1
            r0 = r3
            com.sina.weibo.sdk.register.mobile.LetterIndexBar$OnIndexChangeListener r0 = r0.mListener
            r4 = r0
            r0 = r4
            if (r0 == 0) goto L75
            r0 = r4
            r1 = r5
            r0.onIndexChange(r1)
        L75:
            r0 = r3
            r0.invalidate()
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.register.mobile.LetterIndexBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setIndexChangeListener(OnIndexChangeListener onIndexChangeListener) {
        this.mListener = onIndexChangeListener;
    }

    public void setIndexLetter(String[] strArr) {
        if (strArr == null) {
            return;
        }
        this.mIndexLetter = strArr;
        this.count = strArr.length;
        this.mIndex = -1;
        invalidate();
    }

    public void setIndexMark(boolean[] zArr) {
        if (zArr == null) {
            return;
        }
        this.mNeedIndex = zArr;
        invalidate();
    }
}
