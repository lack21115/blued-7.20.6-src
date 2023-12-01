package android.text.method;

import android.text.Layout;
import android.text.Spannable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;

/* loaded from: source-9557208-dex2jar.jar:android/text/method/BaseMovementMethod.class */
public class BaseMovementMethod implements MovementMethod {
    private int getBottomLine(TextView textView) {
        return textView.getLayout().getLineForVertical(textView.getScrollY() + getInnerHeight(textView));
    }

    private int getCharacterWidth(TextView textView) {
        return (int) Math.ceil(textView.getPaint().getFontSpacing());
    }

    private int getInnerHeight(TextView textView) {
        return (textView.getHeight() - textView.getTotalPaddingTop()) - textView.getTotalPaddingBottom();
    }

    private int getInnerWidth(TextView textView) {
        return (textView.getWidth() - textView.getTotalPaddingLeft()) - textView.getTotalPaddingRight();
    }

    private int getScrollBoundsLeft(TextView textView) {
        int i;
        Layout layout = textView.getLayout();
        int topLine = getTopLine(textView);
        int bottomLine = getBottomLine(textView);
        if (topLine <= bottomLine) {
            int i2 = Integer.MAX_VALUE;
            while (true) {
                int i3 = i2;
                i = i3;
                if (topLine > bottomLine) {
                    break;
                }
                int floor = (int) Math.floor(layout.getLineLeft(topLine));
                int i4 = i3;
                if (floor < i3) {
                    i4 = floor;
                }
                topLine++;
                i2 = i4;
            }
        } else {
            i = 0;
        }
        return i;
    }

    private int getScrollBoundsRight(TextView textView) {
        int i;
        Layout layout = textView.getLayout();
        int topLine = getTopLine(textView);
        int bottomLine = getBottomLine(textView);
        if (topLine <= bottomLine) {
            int i2 = Integer.MIN_VALUE;
            while (true) {
                int i3 = i2;
                i = i3;
                if (topLine > bottomLine) {
                    break;
                }
                int ceil = (int) Math.ceil(layout.getLineRight(topLine));
                int i4 = i3;
                if (ceil > i3) {
                    i4 = ceil;
                }
                topLine++;
                i2 = i4;
            }
        } else {
            i = 0;
        }
        return i;
    }

    private int getTopLine(TextView textView) {
        return textView.getLayout().getLineForVertical(textView.getScrollY());
    }

    protected boolean bottom(TextView textView, Spannable spannable) {
        return false;
    }

    @Override // android.text.method.MovementMethod
    public boolean canSelectArbitrarily() {
        return false;
    }

    protected boolean down(TextView textView, Spannable spannable) {
        return false;
    }

    protected boolean end(TextView textView, Spannable spannable) {
        return false;
    }

    protected int getMovementMetaState(Spannable spannable, KeyEvent keyEvent) {
        return KeyEvent.normalizeMetaState(MetaKeyKeyListener.getMetaState(spannable, keyEvent) & (-1537)) & (-194);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean handleMovementKey(TextView textView, Spannable spannable, int i, int i2, KeyEvent keyEvent) {
        switch (i) {
            case 19:
                if (KeyEvent.metaStateHasNoModifiers(i2)) {
                    return up(textView, spannable);
                }
                if (KeyEvent.metaStateHasModifiers(i2, 2)) {
                    return top(textView, spannable);
                }
                return false;
            case 20:
                if (KeyEvent.metaStateHasNoModifiers(i2)) {
                    return down(textView, spannable);
                }
                if (KeyEvent.metaStateHasModifiers(i2, 2)) {
                    return bottom(textView, spannable);
                }
                return false;
            case 21:
                if (KeyEvent.metaStateHasNoModifiers(i2)) {
                    return left(textView, spannable);
                }
                if (KeyEvent.metaStateHasModifiers(i2, 4096)) {
                    return leftWord(textView, spannable);
                }
                if (KeyEvent.metaStateHasModifiers(i2, 2)) {
                    return lineStart(textView, spannable);
                }
                return false;
            case 22:
                if (KeyEvent.metaStateHasNoModifiers(i2)) {
                    return right(textView, spannable);
                }
                if (KeyEvent.metaStateHasModifiers(i2, 4096)) {
                    return rightWord(textView, spannable);
                }
                if (KeyEvent.metaStateHasModifiers(i2, 2)) {
                    return lineEnd(textView, spannable);
                }
                return false;
            case 92:
                if (KeyEvent.metaStateHasNoModifiers(i2)) {
                    return pageUp(textView, spannable);
                }
                if (KeyEvent.metaStateHasModifiers(i2, 2)) {
                    return top(textView, spannable);
                }
                return false;
            case 93:
                if (KeyEvent.metaStateHasNoModifiers(i2)) {
                    return pageDown(textView, spannable);
                }
                if (KeyEvent.metaStateHasModifiers(i2, 2)) {
                    return bottom(textView, spannable);
                }
                return false;
            case 122:
                if (KeyEvent.metaStateHasNoModifiers(i2)) {
                    return home(textView, spannable);
                }
                if (KeyEvent.metaStateHasModifiers(i2, 4096)) {
                    return top(textView, spannable);
                }
                return false;
            case 123:
                if (KeyEvent.metaStateHasNoModifiers(i2)) {
                    return end(textView, spannable);
                }
                if (KeyEvent.metaStateHasModifiers(i2, 4096)) {
                    return bottom(textView, spannable);
                }
                return false;
            default:
                return false;
        }
    }

    protected boolean home(TextView textView, Spannable spannable) {
        return false;
    }

    @Override // android.text.method.MovementMethod
    public void initialize(TextView textView, Spannable spannable) {
    }

    protected boolean left(TextView textView, Spannable spannable) {
        return false;
    }

    protected boolean leftWord(TextView textView, Spannable spannable) {
        return false;
    }

    protected boolean lineEnd(TextView textView, Spannable spannable) {
        return false;
    }

    protected boolean lineStart(TextView textView, Spannable spannable) {
        return false;
    }

    @Override // android.text.method.MovementMethod
    public boolean onGenericMotionEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        boolean z;
        float f;
        float axisValue;
        if ((motionEvent.getSource() & 2) != 0) {
            switch (motionEvent.getAction()) {
                case 8:
                    if ((motionEvent.getMetaState() & 1) != 0) {
                        f = 0.0f;
                        axisValue = motionEvent.getAxisValue(9);
                    } else {
                        f = -motionEvent.getAxisValue(9);
                        axisValue = motionEvent.getAxisValue(10);
                    }
                    boolean z2 = false;
                    if (axisValue < 0.0f) {
                        z2 = false | scrollLeft(textView, spannable, (int) Math.ceil(-axisValue));
                    } else if (axisValue > 0.0f) {
                        z2 = false | scrollRight(textView, spannable, (int) Math.ceil(axisValue));
                    }
                    if (f < 0.0f) {
                        return z2 | scrollUp(textView, spannable, (int) Math.ceil(-f));
                    }
                    z = z2;
                    if (f > 0.0f) {
                        return z2 | scrollDown(textView, spannable, (int) Math.ceil(f));
                    }
                    break;
            }
            return z;
        }
        z = false;
        return z;
    }

    @Override // android.text.method.MovementMethod
    public boolean onKeyDown(TextView textView, Spannable spannable, int i, KeyEvent keyEvent) {
        boolean handleMovementKey = handleMovementKey(textView, spannable, i, getMovementMetaState(spannable, keyEvent), keyEvent);
        if (handleMovementKey) {
            MetaKeyKeyListener.adjustMetaAfterKeypress(spannable);
            MetaKeyKeyListener.resetLockedMeta(spannable);
        }
        return handleMovementKey;
    }

    @Override // android.text.method.MovementMethod
    public boolean onKeyOther(TextView textView, Spannable spannable, KeyEvent keyEvent) {
        int movementMetaState = getMovementMetaState(spannable, keyEvent);
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 0 || keyEvent.getAction() != 2) {
            return false;
        }
        int repeatCount = keyEvent.getRepeatCount();
        boolean z = false;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= repeatCount || !handleMovementKey(textView, spannable, keyCode, movementMetaState, keyEvent)) {
                break;
            }
            z = true;
            i = i2 + 1;
        }
        if (z) {
            MetaKeyKeyListener.adjustMetaAfterKeypress(spannable);
            MetaKeyKeyListener.resetLockedMeta(spannable);
        }
        return z;
    }

    @Override // android.text.method.MovementMethod
    public boolean onKeyUp(TextView textView, Spannable spannable, int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // android.text.method.MovementMethod
    public void onTakeFocus(TextView textView, Spannable spannable, int i) {
    }

    @Override // android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        return false;
    }

    @Override // android.text.method.MovementMethod
    public boolean onTrackballEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        return false;
    }

    protected boolean pageDown(TextView textView, Spannable spannable) {
        return false;
    }

    protected boolean pageUp(TextView textView, Spannable spannable) {
        return false;
    }

    protected boolean right(TextView textView, Spannable spannable) {
        return false;
    }

    protected boolean rightWord(TextView textView, Spannable spannable) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean scrollBottom(TextView textView, Spannable spannable) {
        Layout layout = textView.getLayout();
        int lineCount = layout.getLineCount();
        if (getBottomLine(textView) <= lineCount - 1) {
            Touch.scrollTo(textView, layout, textView.getScrollX(), layout.getLineTop(lineCount) - getInnerHeight(textView));
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean scrollDown(TextView textView, Spannable spannable, int i) {
        Layout layout = textView.getLayout();
        int innerHeight = getInnerHeight(textView);
        int scrollY = textView.getScrollY() + innerHeight;
        int lineForVertical = layout.getLineForVertical(scrollY);
        int i2 = lineForVertical;
        if (layout.getLineTop(lineForVertical + 1) < scrollY + 1) {
            i2 = lineForVertical + 1;
        }
        int lineCount = layout.getLineCount() - 1;
        if (i2 <= lineCount) {
            Touch.scrollTo(textView, layout, textView.getScrollX(), layout.getLineTop(Math.min((i2 + i) - 1, lineCount) + 1) - innerHeight);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean scrollLeft(TextView textView, Spannable spannable, int i) {
        int scrollBoundsLeft = getScrollBoundsLeft(textView);
        int scrollX = textView.getScrollX();
        if (scrollX > scrollBoundsLeft) {
            textView.scrollTo(Math.max(scrollX - (getCharacterWidth(textView) * i), scrollBoundsLeft), textView.getScrollY());
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean scrollLineEnd(TextView textView, Spannable spannable) {
        int scrollBoundsRight = getScrollBoundsRight(textView) - getInnerWidth(textView);
        if (textView.getScrollX() < scrollBoundsRight) {
            textView.scrollTo(scrollBoundsRight, textView.getScrollY());
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean scrollLineStart(TextView textView, Spannable spannable) {
        int scrollBoundsLeft = getScrollBoundsLeft(textView);
        if (textView.getScrollX() > scrollBoundsLeft) {
            textView.scrollTo(scrollBoundsLeft, textView.getScrollY());
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean scrollPageDown(TextView textView, Spannable spannable) {
        Layout layout = textView.getLayout();
        int innerHeight = getInnerHeight(textView);
        int lineForVertical = layout.getLineForVertical(textView.getScrollY() + innerHeight + innerHeight);
        if (lineForVertical <= layout.getLineCount() - 1) {
            Touch.scrollTo(textView, layout, textView.getScrollX(), layout.getLineTop(lineForVertical + 1) - innerHeight);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean scrollPageUp(TextView textView, Spannable spannable) {
        Layout layout = textView.getLayout();
        int lineForVertical = layout.getLineForVertical(textView.getScrollY() - getInnerHeight(textView));
        if (lineForVertical >= 0) {
            Touch.scrollTo(textView, layout, textView.getScrollX(), layout.getLineTop(lineForVertical));
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean scrollRight(TextView textView, Spannable spannable, int i) {
        int scrollBoundsRight = getScrollBoundsRight(textView) - getInnerWidth(textView);
        int scrollX = textView.getScrollX();
        if (scrollX < scrollBoundsRight) {
            textView.scrollTo(Math.min((getCharacterWidth(textView) * i) + scrollX, scrollBoundsRight), textView.getScrollY());
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean scrollTop(TextView textView, Spannable spannable) {
        boolean z = false;
        Layout layout = textView.getLayout();
        if (getTopLine(textView) >= 0) {
            Touch.scrollTo(textView, layout, textView.getScrollX(), layout.getLineTop(0));
            z = true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean scrollUp(TextView textView, Spannable spannable, int i) {
        boolean z = false;
        Layout layout = textView.getLayout();
        int scrollY = textView.getScrollY();
        int lineForVertical = layout.getLineForVertical(scrollY);
        int i2 = lineForVertical;
        if (layout.getLineTop(lineForVertical) == scrollY) {
            i2 = lineForVertical - 1;
        }
        if (i2 >= 0) {
            Touch.scrollTo(textView, layout, textView.getScrollX(), layout.getLineTop(Math.max((i2 - i) + 1, 0)));
            z = true;
        }
        return z;
    }

    protected boolean top(TextView textView, Spannable spannable) {
        return false;
    }

    protected boolean up(TextView textView, Spannable spannable) {
        return false;
    }
}
