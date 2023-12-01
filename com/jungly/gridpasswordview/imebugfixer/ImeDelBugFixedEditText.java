package com.jungly.gridpasswordview.imebugfixer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;

/* loaded from: source-7994992-dex2jar.jar:com/jungly/gridpasswordview/imebugfixer/ImeDelBugFixedEditText.class */
public class ImeDelBugFixedEditText extends EditText {

    /* renamed from: a  reason: collision with root package name */
    private OnDelKeyEventListener f23688a;

    /* loaded from: source-7994992-dex2jar.jar:com/jungly/gridpasswordview/imebugfixer/ImeDelBugFixedEditText$OnDelKeyEventListener.class */
    public interface OnDelKeyEventListener {
        void a();
    }

    /* loaded from: source-7994992-dex2jar.jar:com/jungly/gridpasswordview/imebugfixer/ImeDelBugFixedEditText$ZanyInputConnection.class */
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
            if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 67 && ImeDelBugFixedEditText.this.f23688a != null) {
                ImeDelBugFixedEditText.this.f23688a.a();
                return true;
            }
            return super.sendKeyEvent(keyEvent);
        }
    }

    public ImeDelBugFixedEditText(Context context) {
        super(context);
    }

    public ImeDelBugFixedEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ImeDelBugFixedEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return new ZanyInputConnection(super.onCreateInputConnection(editorInfo), true);
    }

    public void setDelKeyEventListener(OnDelKeyEventListener onDelKeyEventListener) {
        this.f23688a = onDelKeyEventListener;
    }
}
