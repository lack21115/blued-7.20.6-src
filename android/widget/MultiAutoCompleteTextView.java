package android.widget;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.QwertyKeyListener;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AutoCompleteTextView;

/* loaded from: source-4181928-dex2jar.jar:android/widget/MultiAutoCompleteTextView.class */
public class MultiAutoCompleteTextView extends AutoCompleteTextView {
    private Tokenizer mTokenizer;

    /* loaded from: source-4181928-dex2jar.jar:android/widget/MultiAutoCompleteTextView$CommaTokenizer.class */
    public static class CommaTokenizer implements Tokenizer {
        @Override // android.widget.MultiAutoCompleteTextView.Tokenizer
        public int findTokenEnd(CharSequence charSequence, int i) {
            int length = charSequence.length();
            while (i < length) {
                if (charSequence.charAt(i) == ',') {
                    return i;
                }
                i++;
            }
            return length;
        }

        @Override // android.widget.MultiAutoCompleteTextView.Tokenizer
        public int findTokenStart(CharSequence charSequence, int i) {
            int i2;
            int i3 = i;
            while (true) {
                int i4 = i3;
                i2 = i4;
                if (i4 <= 0) {
                    break;
                }
                i2 = i4;
                if (charSequence.charAt(i4 - 1) == ',') {
                    break;
                }
                i3 = i4 - 1;
            }
            while (i2 < i && charSequence.charAt(i2) == ' ') {
                i2++;
            }
            return i2;
        }

        @Override // android.widget.MultiAutoCompleteTextView.Tokenizer
        public CharSequence terminateToken(CharSequence charSequence) {
            int i;
            int length = charSequence.length();
            while (true) {
                i = length;
                if (i <= 0 || charSequence.charAt(i - 1) != ' ') {
                    break;
                }
                length = i - 1;
            }
            if (i <= 0 || charSequence.charAt(i - 1) != ',') {
                if (charSequence instanceof Spanned) {
                    SpannableString spannableString = new SpannableString(((Object) charSequence) + ", ");
                    TextUtils.copySpansFrom((Spanned) charSequence, 0, charSequence.length(), Object.class, spannableString, 0);
                    return spannableString;
                }
                return ((Object) charSequence) + ", ";
            }
            return charSequence;
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/MultiAutoCompleteTextView$Tokenizer.class */
    public interface Tokenizer {
        int findTokenEnd(CharSequence charSequence, int i);

        int findTokenStart(CharSequence charSequence, int i);

        CharSequence terminateToken(CharSequence charSequence);
    }

    public MultiAutoCompleteTextView(Context context) {
        this(context, null);
    }

    public MultiAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842859);
    }

    public MultiAutoCompleteTextView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public MultiAutoCompleteTextView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // android.widget.AutoCompleteTextView
    public boolean enoughToFilter() {
        Editable text = getText();
        int selectionEnd = getSelectionEnd();
        return selectionEnd >= 0 && this.mTokenizer != null && selectionEnd - this.mTokenizer.findTokenStart(text, selectionEnd) >= getThreshold();
    }

    void finishInit() {
    }

    @Override // android.widget.EditText, android.widget.TextView, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(MultiAutoCompleteTextView.class.getName());
    }

    @Override // android.widget.EditText, android.widget.TextView, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(MultiAutoCompleteTextView.class.getName());
    }

    @Override // android.widget.AutoCompleteTextView
    protected void performFiltering(CharSequence charSequence, int i) {
        if (enoughToFilter()) {
            int selectionEnd = getSelectionEnd();
            performFiltering(charSequence, this.mTokenizer.findTokenStart(charSequence, selectionEnd), selectionEnd, i);
            return;
        }
        dismissDropDown();
        Filter filter = getFilter();
        if (filter != null) {
            filter.filter(null);
        }
    }

    protected void performFiltering(CharSequence charSequence, int i, int i2, int i3) {
        getFilter().filter(charSequence.subSequence(i, i2), this);
    }

    @Override // android.widget.AutoCompleteTextView
    public void performValidation() {
        AutoCompleteTextView.Validator validator = getValidator();
        if (validator == null || this.mTokenizer == null) {
            return;
        }
        Editable text = getText();
        int length = getText().length();
        while (true) {
            int i = length;
            if (i <= 0) {
                return;
            }
            int findTokenStart = this.mTokenizer.findTokenStart(text, i);
            CharSequence subSequence = text.subSequence(findTokenStart, this.mTokenizer.findTokenEnd(text, findTokenStart));
            if (TextUtils.isEmpty(subSequence)) {
                text.replace(findTokenStart, i, "");
            } else if (!validator.isValid(subSequence)) {
                text.replace(findTokenStart, i, this.mTokenizer.terminateToken(validator.fixText(subSequence)));
            }
            length = findTokenStart;
        }
    }

    @Override // android.widget.AutoCompleteTextView
    protected void replaceText(CharSequence charSequence) {
        clearComposingText();
        int selectionEnd = getSelectionEnd();
        int findTokenStart = this.mTokenizer.findTokenStart(getText(), selectionEnd);
        Editable text = getText();
        QwertyKeyListener.markAsReplaced(text, findTokenStart, selectionEnd, TextUtils.substring(text, findTokenStart, selectionEnd));
        text.replace(findTokenStart, selectionEnd, this.mTokenizer.terminateToken(charSequence));
    }

    public void setTokenizer(Tokenizer tokenizer) {
        this.mTokenizer = tokenizer;
    }
}
