package android.text.method;

import android.os.Handler;
import android.os.SystemClock;
import android.text.Editable;
import android.text.Selection;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.method.TextKeyListener;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;

/* loaded from: source-9557208-dex2jar.jar:android/text/method/MultiTapKeyListener.class */
public class MultiTapKeyListener extends BaseKeyListener implements SpanWatcher {
    private static MultiTapKeyListener[] sInstance = new MultiTapKeyListener[TextKeyListener.Capitalize.values().length * 2];
    private static final SparseArray<String> sRecs = new SparseArray<>();
    private boolean mAutoText;
    private TextKeyListener.Capitalize mCapitalize;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/text/method/MultiTapKeyListener$Timeout.class */
    public class Timeout extends Handler implements Runnable {
        private Editable mBuffer;

        public Timeout(Editable editable) {
            this.mBuffer = editable;
            this.mBuffer.setSpan(this, 0, this.mBuffer.length(), 18);
            postAtTime(this, SystemClock.uptimeMillis() + 2000);
        }

        @Override // java.lang.Runnable
        public void run() {
            Editable editable = this.mBuffer;
            if (editable != null) {
                int selectionStart = Selection.getSelectionStart(editable);
                int selectionEnd = Selection.getSelectionEnd(editable);
                int spanStart = editable.getSpanStart(TextKeyListener.ACTIVE);
                int spanEnd = editable.getSpanEnd(TextKeyListener.ACTIVE);
                if (selectionStart == spanStart && selectionEnd == spanEnd) {
                    Selection.setSelection(editable, Selection.getSelectionEnd(editable));
                }
                editable.removeSpan(this);
            }
        }
    }

    static {
        sRecs.put(8, ".,1!@#$%^&*:/?'=()");
        sRecs.put(9, "abc2ABC");
        sRecs.put(10, "def3DEF");
        sRecs.put(11, "ghi4GHI");
        sRecs.put(12, "jkl5JKL");
        sRecs.put(13, "mno6MNO");
        sRecs.put(14, "pqrs7PQRS");
        sRecs.put(15, "tuv8TUV");
        sRecs.put(16, "wxyz9WXYZ");
        sRecs.put(7, "0+");
        sRecs.put(18, " ");
    }

    public MultiTapKeyListener(TextKeyListener.Capitalize capitalize, boolean z) {
        this.mCapitalize = capitalize;
        this.mAutoText = z;
    }

    public static MultiTapKeyListener getInstance(boolean z, TextKeyListener.Capitalize capitalize) {
        int ordinal = (capitalize.ordinal() * 2) + (z ? 1 : 0);
        if (sInstance[ordinal] == null) {
            sInstance[ordinal] = new MultiTapKeyListener(capitalize, z);
        }
        return sInstance[ordinal];
    }

    private static void removeTimeouts(Spannable spannable) {
        Timeout[] timeoutArr = (Timeout[]) spannable.getSpans(0, spannable.length(), Timeout.class);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= timeoutArr.length) {
                return;
            }
            Timeout timeout = timeoutArr[i2];
            timeout.removeCallbacks(timeout);
            timeout.mBuffer = null;
            spannable.removeSpan(timeout);
            i = i2 + 1;
        }
    }

    @Override // android.text.method.KeyListener
    public int getInputType() {
        return makeTextContentType(this.mCapitalize, this.mAutoText);
    }

    @Override // android.text.method.BaseKeyListener, android.text.method.MetaKeyKeyListener, android.text.method.KeyListener
    public boolean onKeyDown(View view, Editable editable, int i, KeyEvent keyEvent) {
        int indexOfKey;
        String valueAt;
        int indexOf;
        int i2 = 0;
        if (view != null) {
            i2 = TextKeyListener.getInstance().getPrefs(view.getContext());
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        int min = Math.min(selectionStart, selectionEnd);
        int max = Math.max(selectionStart, selectionEnd);
        int spanStart = editable.getSpanStart(TextKeyListener.ACTIVE);
        int spanEnd = editable.getSpanEnd(TextKeyListener.ACTIVE);
        int spanFlags = (editable.getSpanFlags(TextKeyListener.ACTIVE) & (-16777216)) >>> 24;
        if (spanStart == min && spanEnd == max && max - min == 1 && spanFlags >= 0 && spanFlags < sRecs.size()) {
            if (i == 17) {
                char charAt = editable.charAt(min);
                if (Character.isLowerCase(charAt)) {
                    editable.replace(min, max, String.valueOf(charAt).toUpperCase());
                    removeTimeouts(editable);
                    new Timeout(editable);
                    return true;
                } else if (Character.isUpperCase(charAt)) {
                    editable.replace(min, max, String.valueOf(charAt).toLowerCase());
                    removeTimeouts(editable);
                    new Timeout(editable);
                    return true;
                }
            }
            if (sRecs.indexOfKey(i) == spanFlags && (indexOf = (valueAt = sRecs.valueAt(spanFlags)).indexOf(editable.charAt(min))) >= 0) {
                int length = (indexOf + 1) % valueAt.length();
                editable.replace(min, max, valueAt, length, length + 1);
                removeTimeouts(editable);
                new Timeout(editable);
                return true;
            }
            int indexOfKey2 = sRecs.indexOfKey(i);
            indexOfKey = indexOfKey2;
            if (indexOfKey2 >= 0) {
                Selection.setSelection(editable, max, max);
                min = max;
                indexOfKey = indexOfKey2;
            }
        } else {
            indexOfKey = sRecs.indexOfKey(i);
        }
        if (indexOfKey < 0) {
            return super.onKeyDown(view, editable, i, keyEvent);
        }
        String valueAt2 = sRecs.valueAt(indexOfKey);
        int i3 = 0;
        if ((i2 & 1) != 0) {
            i3 = 0;
            if (TextKeyListener.shouldCap(this.mCapitalize, editable, min)) {
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    i3 = 0;
                    if (i5 >= valueAt2.length()) {
                        break;
                    } else if (Character.isUpperCase(valueAt2.charAt(i5))) {
                        i3 = i5;
                        break;
                    } else {
                        i4 = i5 + 1;
                    }
                }
            }
        }
        if (min != max) {
            Selection.setSelection(editable, max);
        }
        editable.setSpan(OLD_SEL_START, min, min, 17);
        editable.replace(min, max, valueAt2, i3, i3 + 1);
        int spanStart2 = editable.getSpanStart(OLD_SEL_START);
        int selectionEnd2 = Selection.getSelectionEnd(editable);
        if (selectionEnd2 != spanStart2) {
            Selection.setSelection(editable, spanStart2, selectionEnd2);
            editable.setSpan(TextKeyListener.LAST_TYPED, spanStart2, selectionEnd2, 33);
            editable.setSpan(TextKeyListener.ACTIVE, spanStart2, selectionEnd2, (indexOfKey << 24) | 33);
        }
        removeTimeouts(editable);
        new Timeout(editable);
        if (editable.getSpanStart(this) >= 0) {
            return true;
        }
        Object[] objArr = (KeyListener[]) editable.getSpans(0, editable.length(), KeyListener.class);
        int length2 = objArr.length;
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= length2) {
                editable.setSpan(this, 0, editable.length(), 18);
                return true;
            }
            editable.removeSpan(objArr[i7]);
            i6 = i7 + 1;
        }
    }

    @Override // android.text.SpanWatcher
    public void onSpanAdded(Spannable spannable, Object obj, int i, int i2) {
    }

    @Override // android.text.SpanWatcher
    public void onSpanChanged(Spannable spannable, Object obj, int i, int i2, int i3, int i4) {
        if (obj == Selection.SELECTION_END) {
            spannable.removeSpan(TextKeyListener.ACTIVE);
            removeTimeouts(spannable);
        }
    }

    @Override // android.text.SpanWatcher
    public void onSpanRemoved(Spannable spannable, Object obj, int i, int i2) {
    }
}
