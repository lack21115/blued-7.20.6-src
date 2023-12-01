package android.text.method;

import android.graphics.Rect;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;

/* loaded from: source-9557208-dex2jar.jar:android/text/method/ArrowKeyMovementMethod.class */
public class ArrowKeyMovementMethod extends BaseMovementMethod implements MovementMethod {
    private static final Object LAST_TAP_DOWN = new Object();
    private static ArrowKeyMovementMethod sInstance;

    private static int getCurrentLineTop(Spannable spannable, Layout layout) {
        return layout.getLineTop(layout.getLineForOffset(Selection.getSelectionEnd(spannable)));
    }

    public static MovementMethod getInstance() {
        if (sInstance == null) {
            sInstance = new ArrowKeyMovementMethod();
        }
        return sInstance;
    }

    private static int getPageHeight(TextView textView) {
        Rect rect = new Rect();
        if (textView.getGlobalVisibleRect(rect)) {
            return rect.height();
        }
        return 0;
    }

    private static boolean isSelecting(Spannable spannable) {
        return MetaKeyKeyListener.getMetaState(spannable, 1) == 1 || MetaKeyKeyListener.getMetaState(spannable, 2048) != 0;
    }

    private static boolean isTouchSelecting(boolean z, Spannable spannable) {
        return z ? Touch.isActivelySelecting(spannable) : isSelecting(spannable);
    }

    @Override // android.text.method.BaseMovementMethod
    protected boolean bottom(TextView textView, Spannable spannable) {
        if (isSelecting(spannable)) {
            Selection.extendSelection(spannable, spannable.length());
            return true;
        }
        Selection.setSelection(spannable, spannable.length());
        return true;
    }

    @Override // android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean canSelectArbitrarily() {
        return true;
    }

    @Override // android.text.method.BaseMovementMethod
    protected boolean down(TextView textView, Spannable spannable) {
        Layout layout = textView.getLayout();
        return isSelecting(spannable) ? Selection.extendDown(spannable, layout) : Selection.moveDown(spannable, layout);
    }

    @Override // android.text.method.BaseMovementMethod
    protected boolean end(TextView textView, Spannable spannable) {
        return lineEnd(textView, spannable);
    }

    @Override // android.text.method.BaseMovementMethod
    protected boolean handleMovementKey(TextView textView, Spannable spannable, int i, int i2, KeyEvent keyEvent) {
        switch (i) {
            case 23:
                if (KeyEvent.metaStateHasNoModifiers(i2) && keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0 && MetaKeyKeyListener.getMetaState(spannable, 2048, keyEvent) != 0) {
                    return textView.showContextMenu();
                }
                break;
        }
        return super.handleMovementKey(textView, spannable, i, i2, keyEvent);
    }

    @Override // android.text.method.BaseMovementMethod
    protected boolean home(TextView textView, Spannable spannable) {
        return lineStart(textView, spannable);
    }

    @Override // android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public void initialize(TextView textView, Spannable spannable) {
        Selection.setSelection(spannable, 0);
    }

    @Override // android.text.method.BaseMovementMethod
    protected boolean left(TextView textView, Spannable spannable) {
        Layout layout = textView.getLayout();
        return isSelecting(spannable) ? Selection.extendLeft(spannable, layout) : Selection.moveLeft(spannable, layout);
    }

    @Override // android.text.method.BaseMovementMethod
    protected boolean leftWord(TextView textView, Spannable spannable) {
        int selectionEnd = textView.getSelectionEnd();
        WordIterator wordIterator = textView.getWordIterator();
        wordIterator.setCharSequence(spannable, selectionEnd, selectionEnd);
        return Selection.moveToPreceding(spannable, wordIterator, isSelecting(spannable));
    }

    @Override // android.text.method.BaseMovementMethod
    protected boolean lineEnd(TextView textView, Spannable spannable) {
        Layout layout = textView.getLayout();
        return isSelecting(spannable) ? Selection.extendToRightEdge(spannable, layout) : Selection.moveToRightEdge(spannable, layout);
    }

    @Override // android.text.method.BaseMovementMethod
    protected boolean lineStart(TextView textView, Spannable spannable) {
        Layout layout = textView.getLayout();
        return isSelecting(spannable) ? Selection.extendToLeftEdge(spannable, layout) : Selection.moveToLeftEdge(spannable, layout);
    }

    @Override // android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public void onTakeFocus(TextView textView, Spannable spannable, int i) {
        if ((i & 130) == 0) {
            Selection.setSelection(spannable, spannable.length());
        } else if (textView.getLayout() == null) {
            Selection.setSelection(spannable, spannable.length());
        }
    }

    @Override // android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int i = -1;
        int i2 = -1;
        int action = motionEvent.getAction();
        boolean isFromSource = motionEvent.isFromSource(8194);
        if (action == 1) {
            i = Touch.getInitialScrollX(textView, spannable);
            i2 = Touch.getInitialScrollY(textView, spannable);
        }
        boolean onTouchEvent = Touch.onTouchEvent(textView, spannable, motionEvent);
        if (textView.isFocused() && !textView.didTouchFocusSelect()) {
            if (action == 0) {
                if (isFromSource || isTouchSelecting(isFromSource, spannable)) {
                    int offsetForPosition = textView.getOffsetForPosition(motionEvent.getX(), motionEvent.getY());
                    spannable.setSpan(LAST_TAP_DOWN, offsetForPosition, offsetForPosition, 34);
                    textView.getParent().requestDisallowInterceptTouchEvent(true);
                }
            } else if (action == 2) {
                if (isFromSource && Touch.isSelectionStarted(spannable)) {
                    Selection.setSelection(spannable, spannable.getSpanStart(LAST_TAP_DOWN));
                }
                if (isTouchSelecting(isFromSource, spannable) && onTouchEvent) {
                    textView.cancelLongPress();
                    Selection.extendSelection(spannable, textView.getOffsetForPosition(motionEvent.getX(), motionEvent.getY()));
                    return true;
                }
            } else if (action == 1) {
                if ((i2 >= 0 && i2 != textView.getScrollY()) || (i >= 0 && i != textView.getScrollX())) {
                    textView.moveCursorToVisibleOffset();
                    return true;
                }
                int offsetForPosition2 = textView.getOffsetForPosition(motionEvent.getX(), motionEvent.getY());
                if (isTouchSelecting(isFromSource, spannable)) {
                    spannable.removeSpan(LAST_TAP_DOWN);
                    Selection.extendSelection(spannable, offsetForPosition2);
                }
                MetaKeyKeyListener.adjustMetaAfterKeypress(spannable);
                MetaKeyKeyListener.resetLockedMeta(spannable);
                return true;
            }
        }
        return onTouchEvent;
    }

    @Override // android.text.method.BaseMovementMethod
    protected boolean pageDown(TextView textView, Spannable spannable) {
        Layout layout = textView.getLayout();
        boolean isSelecting = isSelecting(spannable);
        int currentLineTop = getCurrentLineTop(spannable, layout);
        int pageHeight = getPageHeight(textView);
        boolean z = false;
        do {
            int selectionEnd = Selection.getSelectionEnd(spannable);
            if (isSelecting) {
                Selection.extendDown(spannable, layout);
            } else {
                Selection.moveDown(spannable, layout);
            }
            if (Selection.getSelectionEnd(spannable) == selectionEnd) {
                return z;
            }
            z = true;
        } while (getCurrentLineTop(spannable, layout) < currentLineTop + pageHeight);
        return true;
    }

    @Override // android.text.method.BaseMovementMethod
    protected boolean pageUp(TextView textView, Spannable spannable) {
        Layout layout = textView.getLayout();
        boolean isSelecting = isSelecting(spannable);
        int currentLineTop = getCurrentLineTop(spannable, layout);
        int pageHeight = getPageHeight(textView);
        boolean z = false;
        do {
            int selectionEnd = Selection.getSelectionEnd(spannable);
            if (isSelecting) {
                Selection.extendUp(spannable, layout);
            } else {
                Selection.moveUp(spannable, layout);
            }
            if (Selection.getSelectionEnd(spannable) == selectionEnd) {
                return z;
            }
            z = true;
        } while (getCurrentLineTop(spannable, layout) > currentLineTop - pageHeight);
        return true;
    }

    @Override // android.text.method.BaseMovementMethod
    protected boolean right(TextView textView, Spannable spannable) {
        Layout layout = textView.getLayout();
        return isSelecting(spannable) ? Selection.extendRight(spannable, layout) : Selection.moveRight(spannable, layout);
    }

    @Override // android.text.method.BaseMovementMethod
    protected boolean rightWord(TextView textView, Spannable spannable) {
        int selectionEnd = textView.getSelectionEnd();
        WordIterator wordIterator = textView.getWordIterator();
        wordIterator.setCharSequence(spannable, selectionEnd, selectionEnd);
        return Selection.moveToFollowing(spannable, wordIterator, isSelecting(spannable));
    }

    @Override // android.text.method.BaseMovementMethod
    protected boolean top(TextView textView, Spannable spannable) {
        if (isSelecting(spannable)) {
            Selection.extendSelection(spannable, 0);
            return true;
        }
        Selection.setSelection(spannable, 0);
        return true;
    }

    @Override // android.text.method.BaseMovementMethod
    protected boolean up(TextView textView, Spannable spannable) {
        Layout layout = textView.getLayout();
        return isSelecting(spannable) ? Selection.extendUp(spannable, layout) : Selection.moveUp(spannable, layout);
    }
}
