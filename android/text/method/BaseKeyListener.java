package android.text.method;

import android.text.Editable;
import android.text.Layout;
import android.text.NoCopySpan;
import android.text.Selection;
import android.text.TextUtils;
import android.text.method.TextKeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

/* loaded from: source-9557208-dex2jar.jar:android/text/method/BaseKeyListener.class */
public abstract class BaseKeyListener extends MetaKeyKeyListener implements KeyListener {
    static final Object OLD_SEL_START = new NoCopySpan.Concrete();

    /* renamed from: android.text.method.BaseKeyListener$1  reason: invalid class name */
    /* loaded from: source-9557208-dex2jar.jar:android/text/method/BaseKeyListener$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$text$method$TextKeyListener$Capitalize = new int[TextKeyListener.Capitalize.values().length];

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002d -> B:17:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0031 -> B:15:0x0014). Please submit an issue!!! */
        static {
            try {
                $SwitchMap$android$text$method$TextKeyListener$Capitalize[TextKeyListener.Capitalize.CHARACTERS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$android$text$method$TextKeyListener$Capitalize[TextKeyListener.Capitalize.WORDS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$android$text$method$TextKeyListener$Capitalize[TextKeyListener.Capitalize.SENTENCES.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private boolean backspaceOrForwardDelete(View view, Editable editable, int i, KeyEvent keyEvent, boolean z) {
        if (KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState() & (-244))) {
            if (deleteSelection(view, editable)) {
                return true;
            }
            if (getMetaState(editable, 2, keyEvent) == 1 && deleteLine(view, editable)) {
                return true;
            }
            int selectionEnd = Selection.getSelectionEnd(editable);
            int offsetAfter = (z || keyEvent.isShiftPressed() || getMetaState(editable, 1) == 1) ? TextUtils.getOffsetAfter(editable, selectionEnd) : TextUtils.getOffsetBefore(editable, selectionEnd);
            if (selectionEnd != offsetAfter) {
                editable.delete(Math.min(selectionEnd, offsetAfter), Math.max(selectionEnd, offsetAfter));
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean deleteLine(View view, Editable editable) {
        Layout layout;
        int lineForOffset;
        int lineStart;
        int lineEnd;
        if (!(view instanceof TextView) || (layout = ((TextView) view).getLayout()) == null || (lineEnd = layout.getLineEnd(lineForOffset)) == (lineStart = layout.getLineStart((lineForOffset = layout.getLineForOffset(Selection.getSelectionStart(editable)))))) {
            return false;
        }
        editable.delete(lineStart, lineEnd);
        return true;
    }

    private boolean deleteSelection(View view, Editable editable) {
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        int i = selectionEnd;
        int i2 = selectionStart;
        if (selectionEnd < selectionStart) {
            i2 = selectionEnd;
            i = selectionStart;
        }
        if (i2 != i) {
            editable.delete(i2, i);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int makeTextContentType(TextKeyListener.Capitalize capitalize, boolean z) {
        int i = 1;
        switch (AnonymousClass1.$SwitchMap$android$text$method$TextKeyListener$Capitalize[capitalize.ordinal()]) {
            case 1:
                i = 1 | 4096;
                break;
            case 2:
                i = 1 | 8192;
                break;
            case 3:
                i = 1 | 16384;
                break;
        }
        int i2 = i;
        if (z) {
            i2 = i | 32768;
        }
        return i2;
    }

    public boolean backspace(View view, Editable editable, int i, KeyEvent keyEvent) {
        return backspaceOrForwardDelete(view, editable, i, keyEvent, false);
    }

    public boolean forwardDelete(View view, Editable editable, int i, KeyEvent keyEvent) {
        return backspaceOrForwardDelete(view, editable, i, keyEvent, true);
    }

    @Override // android.text.method.MetaKeyKeyListener, android.text.method.KeyListener
    public boolean onKeyDown(View view, Editable editable, int i, KeyEvent keyEvent) {
        boolean forwardDelete;
        switch (i) {
            case 67:
                forwardDelete = backspace(view, editable, i, keyEvent);
                break;
            case 112:
                forwardDelete = forwardDelete(view, editable, i, keyEvent);
                break;
            default:
                forwardDelete = false;
                break;
        }
        if (forwardDelete) {
            adjustMetaAfterKeypress(editable);
        }
        return super.onKeyDown(view, editable, i, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 2 && keyEvent.getKeyCode() == 0) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            int i = selectionEnd;
            int i2 = selectionStart;
            if (selectionEnd < selectionStart) {
                i2 = selectionEnd;
                i = selectionStart;
            }
            String characters = keyEvent.getCharacters();
            if (characters != null) {
                editable.replace(i2, i, characters);
                return true;
            }
            return false;
        }
        return false;
    }
}
