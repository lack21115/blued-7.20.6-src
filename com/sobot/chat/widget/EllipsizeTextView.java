package com.sobot.chat.widget;

import android.content.Context;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/EllipsizeTextView.class */
public class EllipsizeTextView extends TextView {
    private static final String DEFAULT_ELLIPSIZE_TEXT = "...";
    private int mEllipsizeIndex;
    private CharSequence mEllipsizeText;
    private boolean mIsExactlyMode;
    private int mMaxLines;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/EllipsizeTextView$Range.class */
    public static final class Range<T extends Comparable<? super T>> {
        private final T mLower;
        private final T mUpper;

        public Range(T t, T t2) {
            this.mLower = t;
            this.mUpper = t2;
            if (t.compareTo(t2) > 0) {
                throw new IllegalArgumentException("lower must be less than or equal to upper");
            }
        }

        public boolean contains(T t) {
            return (t.compareTo(this.mLower) >= 0) && (t.compareTo(this.mUpper) < 0);
        }

        public T getLower() {
            return this.mLower;
        }

        public T getUpper() {
            return this.mUpper;
        }
    }

    public EllipsizeTextView(Context context) {
        this(context, null);
    }

    public EllipsizeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mEllipsizeIndex = 0;
        this.mEllipsizeText = null;
        if (0 == 0) {
            this.mEllipsizeText = DEFAULT_ELLIPSIZE_TEXT;
        }
    }

    private void adjustEllipsizeEndText(Layout layout) {
        try {
            CharSequence text = getText();
            if (TextUtils.isEmpty(text)) {
                return;
            }
            CharSequence subSequence = text.subSequence(text.length() - this.mEllipsizeIndex, text.length());
            int width = (layout.getWidth() - getPaddingLeft()) - getPaddingRight();
            int computeMaxLineCount = computeMaxLineCount(layout) - 1;
            int lineWidth = (int) layout.getLineWidth(computeMaxLineCount);
            int lineEnd = layout.getLineEnd(computeMaxLineCount);
            int desiredWidth = lineWidth + ((int) (Layout.getDesiredWidth(this.mEllipsizeText, getPaint()) + Layout.getDesiredWidth(subSequence, getPaint()))) + 1;
            if (desiredWidth > width) {
                setText(text.subSequence(0, lineEnd - computeRemovedEllipsizeEndCharacterCount(desiredWidth - width, text.subSequence(0, lineEnd))));
                append(this.mEllipsizeText);
                append(subSequence);
                return;
            }
            setText(text.subSequence(0, lineEnd));
            append(this.mEllipsizeText);
            append(subSequence);
        } catch (IndexOutOfBoundsException e) {
        }
    }

    private Range<Integer> computeCharacterStyleRange(List<Range<Integer>> list, int i) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (Range<Integer> range : list) {
            if (range.contains(Integer.valueOf(i))) {
                return range;
            }
        }
        return null;
    }

    private List<Range<Integer>> computeCharacterStyleRanges(CharSequence charSequence) {
        SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(charSequence);
        CharacterStyle[] characterStyleArr = (CharacterStyle[]) valueOf.getSpans(0, valueOf.length(), CharacterStyle.class);
        if (characterStyleArr == null || characterStyleArr.length == 0) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        for (CharacterStyle characterStyle : characterStyleArr) {
            arrayList.add(new Range(Integer.valueOf(valueOf.getSpanStart(characterStyle)), Integer.valueOf(valueOf.getSpanEnd(characterStyle))));
        }
        return arrayList;
    }

    private int computeMaxLineCount(Layout layout) {
        int measuredHeight = getMeasuredHeight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= layout.getLineCount()) {
                return layout.getLineCount();
            }
            if ((measuredHeight - paddingTop) - paddingBottom < layout.getLineBottom(i2)) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    private int computeRemovedEllipsizeEndCharacterCount(int i, CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return 0;
        }
        List<Range<Integer>> computeCharacterStyleRanges = computeCharacterStyleRanges(charSequence);
        String charSequence2 = charSequence.toString();
        charSequence.length();
        int codePointCount = charSequence2.codePointCount(0, charSequence.length());
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (codePointCount <= 0 || i <= i3) {
                break;
            }
            codePointCount--;
            int offsetByCodePoints = charSequence2.offsetByCodePoints(0, codePointCount);
            Range<Integer> computeCharacterStyleRange = computeCharacterStyleRange(computeCharacterStyleRanges, offsetByCodePoints);
            if (computeCharacterStyleRange != null) {
                offsetByCodePoints = computeCharacterStyleRange.getLower().intValue();
                codePointCount = charSequence2.codePointCount(0, offsetByCodePoints);
            }
            i2 = (int) Layout.getDesiredWidth(charSequence.subSequence(offsetByCodePoints, charSequence.length()), getPaint());
        }
        return charSequence.length() - charSequence2.offsetByCodePoints(0, codePointCount);
    }

    private boolean isExceedMaxLine(Layout layout) {
        int lineCount = layout.getLineCount();
        int i = this.mMaxLines;
        return lineCount > i && i > 0;
    }

    private boolean isOutOfBounds(Layout layout) {
        return layout.getHeight() > (getMeasuredHeight() - getPaddingBottom()) - getPaddingTop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mIsExactlyMode = View.MeasureSpec.getMode(i) == 1073741824;
        Layout layout = getLayout();
        if (layout != null) {
            if (isExceedMaxLine(layout) || isOutOfBounds(layout)) {
                adjustEllipsizeEndText(layout);
            }
        }
    }

    public void setEllipsizeText(CharSequence charSequence, int i) {
        this.mEllipsizeText = charSequence;
        this.mEllipsizeIndex = i;
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.mMaxLines = i;
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        if (this.mIsExactlyMode) {
            requestLayout();
        }
    }
}
