package android.inputmethodservice;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/* loaded from: source-9557208-dex2jar.jar:android/inputmethodservice/ExtractEditText.class */
public class ExtractEditText extends EditText {
    private InputMethodService mIME;
    private int mSettingExtractedText;

    public ExtractEditText(Context context) {
        super(context, null);
    }

    public ExtractEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.editTextStyle);
    }

    public ExtractEditText(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ExtractEditText(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    protected void deleteText_internal(int i, int i2) {
        this.mIME.onExtractedDeleteText(i, i2);
    }

    public void finishInternalChanges() {
        this.mSettingExtractedText--;
    }

    @Override // android.view.View
    public boolean hasFocus() {
        return isEnabled();
    }

    public boolean hasVerticalScrollBar() {
        return computeVerticalScrollRange() > computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return isEnabled();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return isEnabled();
    }

    @Override // android.widget.TextView
    public boolean isInputMethodTarget() {
        return true;
    }

    @Override // android.widget.TextView
    protected void onSelectionChanged(int i, int i2) {
        if (this.mSettingExtractedText != 0 || this.mIME == null || i < 0 || i2 < 0) {
            return;
        }
        this.mIME.onExtractedSelectionChanged(i, i2);
    }

    @Override // android.widget.TextView
    public boolean onTextContextMenuItem(int i) {
        if (this.mIME == null || !this.mIME.onExtractTextContextMenuItem(i)) {
            return super.onTextContextMenuItem(i);
        }
        if (i == 16908321) {
            stopSelectionActionMode();
            return true;
        }
        return true;
    }

    @Override // android.view.View
    public boolean performClick() {
        if (super.performClick() || this.mIME == null) {
            return false;
        }
        this.mIME.onExtractedTextClicked();
        return true;
    }

    protected void replaceText_internal(int i, int i2, CharSequence charSequence) {
        this.mIME.onExtractedReplaceText(i, i2, charSequence);
    }

    protected void setCursorPosition_internal(int i, int i2) {
        this.mIME.onExtractedSelectionChanged(i, i2);
    }

    @Override // android.widget.TextView
    public void setExtractedText(ExtractedText extractedText) {
        try {
            this.mSettingExtractedText++;
            super.setExtractedText(extractedText);
        } finally {
            this.mSettingExtractedText--;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setIME(InputMethodService inputMethodService) {
        this.mIME = inputMethodService;
    }

    protected void setSpan_internal(Object obj, int i, int i2, int i3) {
        this.mIME.onExtractedSetSpan(obj, i, i2, i3);
    }

    public void startInternalChanges() {
        this.mSettingExtractedText++;
    }

    protected void viewClicked(InputMethodManager inputMethodManager) {
        if (this.mIME != null) {
            this.mIME.onViewClicked(false);
        }
    }
}
