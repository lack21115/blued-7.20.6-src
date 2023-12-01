package com.soft.blued.customview.gridcodeedittext.imebugfixer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/gridcodeedittext/imebugfixer/BugFixedEditText.class */
public class BugFixedEditText extends EditText {

    /* renamed from: a  reason: collision with root package name */
    private OnDelKeyEventListener f14912a;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/gridcodeedittext/imebugfixer/BugFixedEditText$OnDelKeyEventListener.class */
    public interface OnDelKeyEventListener {
        void a();
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/gridcodeedittext/imebugfixer/BugFixedEditText$ZanyInputConnection.class */
    class ZanyInputConnection extends InputConnectionWrapper {
        public ZanyInputConnection(InputConnection inputConnection, boolean z) {
            super(inputConnection, z);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean deleteSurroundingText(int i, int i2) {
            return (i == 1 && i2 == 0) ? sendKeyEvent(new KeyEvent(0, 67)) && sendKeyEvent(new KeyEvent(1, 67)) : super.deleteSurroundingText(i, i2);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean sendKeyEvent(KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 67 && BugFixedEditText.this.f14912a != null) {
                BugFixedEditText.this.f14912a.a();
                return true;
            }
            return super.sendKeyEvent(keyEvent);
        }
    }

    public BugFixedEditText(Context context) {
        super(context);
    }

    public BugFixedEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BugFixedEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return new ZanyInputConnection(super.onCreateInputConnection(editorInfo), true);
    }

    public void setDelKeyEventListener(OnDelKeyEventListener onDelKeyEventListener) {
        this.f14912a = onDelKeyEventListener;
    }
}
