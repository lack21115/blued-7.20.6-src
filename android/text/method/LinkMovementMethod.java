package android.text.method;

import android.text.Layout;
import android.text.NoCopySpan;
import android.text.Selection;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;

/* loaded from: source-9557208-dex2jar.jar:android/text/method/LinkMovementMethod.class */
public class LinkMovementMethod extends ScrollingMovementMethod {
    private static final int CLICK = 1;
    private static final int DOWN = 3;
    private static Object FROM_BELOW = new NoCopySpan.Concrete();
    private static final int UP = 2;
    private static LinkMovementMethod sInstance;

    private boolean action(int i, TextView textView, Spannable spannable) {
        int i2;
        int i3;
        int i4;
        int i5;
        Layout layout = textView.getLayout();
        int totalPaddingTop = textView.getTotalPaddingTop();
        int totalPaddingBottom = textView.getTotalPaddingBottom();
        int scrollY = textView.getScrollY();
        int height = textView.getHeight();
        int lineForVertical = layout.getLineForVertical(scrollY);
        int lineForVertical2 = layout.getLineForVertical((height + scrollY) - (totalPaddingTop + totalPaddingBottom));
        int lineStart = layout.getLineStart(lineForVertical);
        int lineEnd = layout.getLineEnd(lineForVertical2);
        ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(lineStart, lineEnd, ClickableSpan.class);
        int selectionStart = Selection.getSelectionStart(spannable);
        int selectionEnd = Selection.getSelectionEnd(spannable);
        int min = Math.min(selectionStart, selectionEnd);
        int max = Math.max(selectionStart, selectionEnd);
        int i6 = max;
        int i7 = min;
        if (min < 0) {
            i6 = max;
            i7 = min;
            if (spannable.getSpanStart(FROM_BELOW) >= 0) {
                i6 = spannable.length();
                i7 = i6;
            }
        }
        int i8 = i7;
        if (i7 > lineEnd) {
            i6 = Integer.MAX_VALUE;
            i8 = Integer.MAX_VALUE;
        }
        int i9 = i6;
        if (i6 < lineStart) {
            i9 = -1;
            i8 = -1;
        }
        switch (i) {
            case 1:
                if (i8 == i9) {
                    return false;
                }
                ClickableSpan[] clickableSpanArr2 = (ClickableSpan[]) spannable.getSpans(i8, i9, ClickableSpan.class);
                if (clickableSpanArr2.length != 1) {
                    return false;
                }
                clickableSpanArr2[0].onClick(textView);
                return false;
            case 2:
                int i10 = -1;
                int i11 = -1;
                int i12 = 0;
                while (i12 < clickableSpanArr.length) {
                    int spanEnd = spannable.getSpanEnd(clickableSpanArr[i12]);
                    if (spanEnd >= i9) {
                        i4 = i11;
                        i5 = i10;
                        if (i8 != i9) {
                            i12++;
                            i11 = i4;
                            i10 = i5;
                        }
                    }
                    i4 = i11;
                    i5 = i10;
                    if (spanEnd > i11) {
                        i5 = spannable.getSpanStart(clickableSpanArr[i12]);
                        i4 = spanEnd;
                    }
                    i12++;
                    i11 = i4;
                    i10 = i5;
                }
                if (i10 >= 0) {
                    Selection.setSelection(spannable, i11, i10);
                    return true;
                }
                return false;
            case 3:
                int i13 = Integer.MAX_VALUE;
                int i14 = Integer.MAX_VALUE;
                int i15 = 0;
                while (i15 < clickableSpanArr.length) {
                    int spanStart = spannable.getSpanStart(clickableSpanArr[i15]);
                    if (spanStart <= i8) {
                        i2 = i14;
                        i3 = i13;
                        if (i8 != i9) {
                            i15++;
                            i14 = i2;
                            i13 = i3;
                        }
                    }
                    i2 = i14;
                    i3 = i13;
                    if (spanStart < i13) {
                        i3 = spanStart;
                        i2 = spannable.getSpanEnd(clickableSpanArr[i15]);
                    }
                    i15++;
                    i14 = i2;
                    i13 = i3;
                }
                if (i14 < Integer.MAX_VALUE) {
                    Selection.setSelection(spannable, i13, i14);
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    public static MovementMethod getInstance() {
        if (sInstance == null) {
            sInstance = new LinkMovementMethod();
        }
        return sInstance;
    }

    @Override // android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean canSelectArbitrarily() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public boolean down(TextView textView, Spannable spannable) {
        if (action(3, textView, spannable)) {
            return true;
        }
        return super.down(textView, spannable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.text.method.BaseMovementMethod
    public boolean handleMovementKey(TextView textView, Spannable spannable, int i, int i2, KeyEvent keyEvent) {
        switch (i) {
            case 23:
            case 66:
                if (KeyEvent.metaStateHasNoModifiers(i2) && keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0 && action(1, textView, spannable)) {
                    return true;
                }
                break;
        }
        return super.handleMovementKey(textView, spannable, i, i2, keyEvent);
    }

    @Override // android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public void initialize(TextView textView, Spannable spannable) {
        Selection.removeSelection(spannable);
        spannable.removeSpan(FROM_BELOW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public boolean left(TextView textView, Spannable spannable) {
        if (action(2, textView, spannable)) {
            return true;
        }
        return super.left(textView, spannable);
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public void onTakeFocus(TextView textView, Spannable spannable, int i) {
        Selection.removeSelection(spannable);
        if ((i & 1) != 0) {
            spannable.setSpan(FROM_BELOW, 0, 0, 34);
        } else {
            spannable.removeSpan(FROM_BELOW);
        }
    }

    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 0) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int totalPaddingLeft = textView.getTotalPaddingLeft();
            int totalPaddingTop = textView.getTotalPaddingTop();
            int scrollX = textView.getScrollX();
            int scrollY = textView.getScrollY();
            Layout layout = textView.getLayout();
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical((y - totalPaddingTop) + scrollY), (x - totalPaddingLeft) + scrollX);
            Object[] objArr = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
            if (objArr.length != 0) {
                if (action == 1) {
                    objArr[0].onClick(textView);
                    return true;
                } else if (action == 0) {
                    Selection.setSelection(spannable, spannable.getSpanStart(objArr[0]), spannable.getSpanEnd(objArr[0]));
                    return true;
                } else {
                    return true;
                }
            }
            Selection.removeSelection(spannable);
        }
        return super.onTouchEvent(textView, spannable, motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public boolean right(TextView textView, Spannable spannable) {
        if (action(3, textView, spannable)) {
            return true;
        }
        return super.right(textView, spannable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod
    public boolean up(TextView textView, Spannable spannable) {
        if (action(2, textView, spannable)) {
            return true;
        }
        return super.up(textView, spannable);
    }
}
