package android.text.method;

import android.text.Layout;
import android.text.NoCopySpan;
import android.text.Spannable;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.TextView;

/* loaded from: source-9557208-dex2jar.jar:android/text/method/Touch.class */
public class Touch {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/text/method/Touch$DragState.class */
    public static class DragState implements NoCopySpan {
        public boolean mFarEnough;
        public boolean mIsActivelySelecting;
        public boolean mIsSelectionStarted;
        public int mScrollX;
        public int mScrollY;
        public boolean mUsed;
        public float mX;
        public float mY;

        public DragState(float f, float f2, int i, int i2) {
            this.mX = f;
            this.mY = f2;
            this.mScrollX = i;
            this.mScrollY = i2;
        }
    }

    private Touch() {
    }

    public static int getInitialScrollX(TextView textView, Spannable spannable) {
        DragState[] dragStateArr = (DragState[]) spannable.getSpans(0, spannable.length(), DragState.class);
        if (dragStateArr.length > 0) {
            return dragStateArr[0].mScrollX;
        }
        return -1;
    }

    public static int getInitialScrollY(TextView textView, Spannable spannable) {
        DragState[] dragStateArr = (DragState[]) spannable.getSpans(0, spannable.length(), DragState.class);
        if (dragStateArr.length > 0) {
            return dragStateArr[0].mScrollY;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isActivelySelecting(Spannable spannable) {
        DragState[] dragStateArr = (DragState[]) spannable.getSpans(0, spannable.length(), DragState.class);
        boolean z = false;
        if (dragStateArr.length > 0) {
            z = false;
            if (dragStateArr[0].mIsActivelySelecting) {
                z = true;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isSelectionStarted(Spannable spannable) {
        DragState[] dragStateArr = (DragState[]) spannable.getSpans(0, spannable.length(), DragState.class);
        boolean z = false;
        if (dragStateArr.length > 0) {
            z = false;
            if (dragStateArr[0].mIsSelectionStarted) {
                z = true;
            }
        }
        return z;
    }

    public static boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        float x;
        float y;
        switch (motionEvent.getActionMasked()) {
            case 0:
                Object[] objArr = (DragState[]) spannable.getSpans(0, spannable.length(), DragState.class);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= objArr.length) {
                        spannable.setSpan(new DragState(motionEvent.getX(), motionEvent.getY(), textView.getScrollX(), textView.getScrollY()), 0, 0, 17);
                        return true;
                    }
                    spannable.removeSpan(objArr[i2]);
                    i = i2 + 1;
                }
            case 1:
                Object[] objArr2 = (DragState[]) spannable.getSpans(0, spannable.length(), DragState.class);
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= objArr2.length) {
                        return objArr2.length > 0 && objArr2[0].mUsed;
                    }
                    spannable.removeSpan(objArr2[i4]);
                    i3 = i4 + 1;
                }
                break;
            case 2:
                DragState[] dragStateArr = (DragState[]) spannable.getSpans(0, spannable.length(), DragState.class);
                if (dragStateArr.length > 0) {
                    dragStateArr[0].mIsSelectionStarted = false;
                    if (!dragStateArr[0].mFarEnough) {
                        int scaledTouchSlop = ViewConfiguration.get(textView.getContext()).getScaledTouchSlop();
                        if (Math.abs(motionEvent.getX() - dragStateArr[0].mX) >= scaledTouchSlop || Math.abs(motionEvent.getY() - dragStateArr[0].mY) >= scaledTouchSlop) {
                            dragStateArr[0].mFarEnough = true;
                            if (motionEvent.isButtonPressed(1)) {
                                dragStateArr[0].mIsActivelySelecting = true;
                                dragStateArr[0].mIsSelectionStarted = true;
                            }
                        }
                    }
                    if (dragStateArr[0].mFarEnough) {
                        dragStateArr[0].mUsed = true;
                        boolean z = ((motionEvent.getMetaState() & 1) == 0 && MetaKeyKeyListener.getMetaState(spannable, 1) != 1 && MetaKeyKeyListener.getMetaState(spannable, 2048) == 0) ? false : true;
                        if (!motionEvent.isButtonPressed(1)) {
                            dragStateArr[0].mIsActivelySelecting = false;
                        }
                        if (z && motionEvent.isButtonPressed(1)) {
                            x = motionEvent.getX() - dragStateArr[0].mX;
                            y = motionEvent.getY() - dragStateArr[0].mY;
                        } else {
                            x = dragStateArr[0].mX - motionEvent.getX();
                            y = dragStateArr[0].mY - motionEvent.getY();
                        }
                        dragStateArr[0].mX = motionEvent.getX();
                        dragStateArr[0].mY = motionEvent.getY();
                        int scrollX = textView.getScrollX();
                        int i5 = (int) x;
                        int totalPaddingTop = textView.getTotalPaddingTop();
                        int totalPaddingBottom = textView.getTotalPaddingBottom();
                        Layout layout = textView.getLayout();
                        int max = Math.max(Math.min(textView.getScrollY() + ((int) y), layout.getHeight() - (textView.getHeight() - (totalPaddingTop + totalPaddingBottom))), 0);
                        int scrollX2 = textView.getScrollX();
                        int scrollY = textView.getScrollY();
                        if (!motionEvent.isButtonPressed(1)) {
                            scrollTo(textView, layout, scrollX + i5, max);
                        }
                        if (scrollX2 == textView.getScrollX() && scrollY == textView.getScrollY()) {
                            return true;
                        }
                        textView.cancelLongPress();
                        return true;
                    }
                    return false;
                }
                return false;
            default:
                return false;
        }
    }

    public static void scrollTo(TextView textView, Layout layout, int i, int i2) {
        int i3;
        int i4;
        int width = textView.getWidth() - (textView.getTotalPaddingLeft() + textView.getTotalPaddingRight());
        int lineForVertical = layout.getLineForVertical(i2);
        Layout.Alignment paragraphAlignment = layout.getParagraphAlignment(lineForVertical);
        boolean z = layout.getParagraphDirection(lineForVertical) > 0;
        if (textView.getHorizontallyScrolling()) {
            int lineForVertical2 = layout.getLineForVertical((textView.getHeight() + i2) - (textView.getTotalPaddingTop() + textView.getTotalPaddingBottom()));
            int i5 = Integer.MAX_VALUE;
            int i6 = 0;
            while (true) {
                i3 = i5;
                i4 = i6;
                if (lineForVertical > lineForVertical2) {
                    break;
                }
                i5 = (int) Math.min(i5, layout.getLineLeft(lineForVertical));
                i6 = (int) Math.max(i6, layout.getLineRight(lineForVertical));
                lineForVertical++;
            }
        } else {
            i3 = 0;
            i4 = width;
        }
        int i7 = i4 - i3;
        textView.scrollTo(i7 < width ? paragraphAlignment == Layout.Alignment.ALIGN_CENTER ? i3 - ((width - i7) / 2) : (!(z && paragraphAlignment == Layout.Alignment.ALIGN_OPPOSITE) && (z || paragraphAlignment != Layout.Alignment.ALIGN_NORMAL) && paragraphAlignment != Layout.Alignment.ALIGN_RIGHT) ? i3 : i3 - (width - i7) : Math.max(Math.min(i, i4 - width), i3), i2);
    }
}
