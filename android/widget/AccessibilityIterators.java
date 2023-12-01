package android.widget;

import android.graphics.Rect;
import android.text.Layout;
import android.text.Spannable;
import android.view.AccessibilityIterators;

/* loaded from: source-4181928-dex2jar.jar:android/widget/AccessibilityIterators.class */
final class AccessibilityIterators {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/AccessibilityIterators$LineTextSegmentIterator.class */
    public static class LineTextSegmentIterator extends AccessibilityIterators.AbstractTextSegmentIterator {
        protected static final int DIRECTION_END = 1;
        protected static final int DIRECTION_START = -1;
        private static LineTextSegmentIterator sLineInstance;
        protected Layout mLayout;

        LineTextSegmentIterator() {
        }

        public static LineTextSegmentIterator getInstance() {
            if (sLineInstance == null) {
                sLineInstance = new LineTextSegmentIterator();
            }
            return sLineInstance;
        }

        public int[] following(int i) {
            int i2;
            if (this.mText.length() > 0 && i < this.mText.length()) {
                if (i < 0) {
                    i2 = this.mLayout.getLineForOffset(0);
                } else {
                    int lineForOffset = this.mLayout.getLineForOffset(i);
                    i2 = getLineEdgeIndex(lineForOffset, -1) == i ? lineForOffset : lineForOffset + 1;
                }
                if (i2 < this.mLayout.getLineCount()) {
                    return getRange(getLineEdgeIndex(i2, -1), getLineEdgeIndex(i2, 1) + 1);
                }
                return null;
            }
            return null;
        }

        protected int getLineEdgeIndex(int i, int i2) {
            return i2 * this.mLayout.getParagraphDirection(i) < 0 ? this.mLayout.getLineStart(i) : this.mLayout.getLineEnd(i) - 1;
        }

        public void initialize(Spannable spannable, Layout layout) {
            this.mText = spannable.toString();
            this.mLayout = layout;
        }

        public int[] preceding(int i) {
            int i2;
            if (this.mText.length() > 0 && i > 0) {
                if (i > this.mText.length()) {
                    i2 = this.mLayout.getLineForOffset(this.mText.length());
                } else {
                    int lineForOffset = this.mLayout.getLineForOffset(i);
                    i2 = getLineEdgeIndex(lineForOffset, 1) + 1 == i ? lineForOffset : lineForOffset - 1;
                }
                if (i2 >= 0) {
                    return getRange(getLineEdgeIndex(i2, -1), getLineEdgeIndex(i2, 1) + 1);
                }
                return null;
            }
            return null;
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/AccessibilityIterators$PageTextSegmentIterator.class */
    static class PageTextSegmentIterator extends LineTextSegmentIterator {
        private static PageTextSegmentIterator sPageInstance;
        private final Rect mTempRect = new Rect();
        private TextView mView;

        PageTextSegmentIterator() {
        }

        public static PageTextSegmentIterator getInstance() {
            if (sPageInstance == null) {
                sPageInstance = new PageTextSegmentIterator();
            }
            return sPageInstance;
        }

        @Override // android.widget.AccessibilityIterators.LineTextSegmentIterator
        public int[] following(int i) {
            if (this.mText.length() > 0 && i < this.mText.length() && this.mView.getGlobalVisibleRect(this.mTempRect)) {
                int max = Math.max(0, i);
                int lineTop = this.mLayout.getLineTop(this.mLayout.getLineForOffset(max)) + ((this.mTempRect.height() - this.mView.getTotalPaddingTop()) - this.mView.getTotalPaddingBottom());
                return getRange(max, getLineEdgeIndex(lineTop < this.mLayout.getLineTop(this.mLayout.getLineCount() - 1) ? this.mLayout.getLineForVertical(lineTop) - 1 : this.mLayout.getLineCount() - 1, 1) + 1);
            }
            return null;
        }

        public void initialize(TextView textView) {
            super.initialize((Spannable) textView.getIterableTextForAccessibility(), textView.getLayout());
            this.mView = textView;
        }

        @Override // android.widget.AccessibilityIterators.LineTextSegmentIterator
        public int[] preceding(int i) {
            if (this.mText.length() > 0 && i > 0 && this.mView.getGlobalVisibleRect(this.mTempRect)) {
                int min = Math.min(this.mText.length(), i);
                int lineTop = this.mLayout.getLineTop(this.mLayout.getLineForOffset(min)) - ((this.mTempRect.height() - this.mView.getTotalPaddingTop()) - this.mView.getTotalPaddingBottom());
                return getRange(getLineEdgeIndex(lineTop > 0 ? this.mLayout.getLineForVertical(lineTop) + 1 : 0, -1), min);
            }
            return null;
        }
    }

    AccessibilityIterators() {
    }
}
