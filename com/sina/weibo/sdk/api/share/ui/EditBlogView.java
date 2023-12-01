package com.sina.weibo.sdk.api.share.ui;

import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/api/share/ui/EditBlogView.class */
public class EditBlogView extends EditText {
    private boolean canSelectionChanged;
    private int count;
    private Context ctx;
    private List<OnSelectionListener> listeners;
    private OnEnterListener mOnEnterListener;

    /* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/api/share/ui/EditBlogView$OnEnterListener.class */
    public interface OnEnterListener {
        void onEnterKey();
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/api/share/ui/EditBlogView$OnSelectionListener.class */
    public interface OnSelectionListener {
        void onSelectionChanged(int i, int i2);
    }

    public EditBlogView(Context context) {
        super(context);
        this.canSelectionChanged = true;
        init();
    }

    public EditBlogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.canSelectionChanged = true;
        init();
    }

    public EditBlogView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.canSelectionChanged = true;
        init();
    }

    private void init() {
        this.ctx = getContext();
        this.listeners = new ArrayList();
    }

    public int correctPosition(int i) {
        if (i == -1) {
            return i;
        }
        Editable text = getText();
        if (i >= text.length()) {
            return i;
        }
        Object[] spans = text.getSpans(i, i, ImageSpan.class);
        int i2 = i;
        if (spans != null) {
            i2 = i;
            if (spans.length != 0) {
                i2 = i;
                if (i != text.getSpanStart(spans[0])) {
                    i2 = text.getSpanEnd(spans[0]);
                }
            }
        }
        return i2;
    }

    public void enableSelectionChanged(boolean z) {
        this.canSelectionChanged = z;
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return new InputConnectionWrapper(super.onCreateInputConnection(editorInfo), false) { // from class: com.sina.weibo.sdk.api.share.ui.EditBlogView.1
            @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
            public boolean commitText(CharSequence charSequence, int i) {
                Editable editableText = EditBlogView.this.getEditableText();
                new String(editableText.toString());
                int selectionStart = Selection.getSelectionStart(editableText);
                int selectionEnd = Selection.getSelectionEnd(editableText);
                if (selectionStart != -1 && selectionEnd != -1) {
                    int correctPosition = EditBlogView.this.correctPosition(selectionStart);
                    int correctPosition2 = EditBlogView.this.correctPosition(selectionEnd);
                    int i2 = correctPosition;
                    int i3 = correctPosition2;
                    if (correctPosition > correctPosition2) {
                        i3 = correctPosition;
                        i2 = correctPosition2;
                    }
                    if (i2 != selectionStart || i3 != selectionEnd) {
                        Selection.setSelection(editableText, i2, i3);
                    }
                    if (i2 != i3) {
                        EditBlogView.this.getText().delete(i2, i3);
                    }
                }
                return super.commitText(charSequence, i);
            }

            @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
            public boolean setComposingText(CharSequence charSequence, int i) {
                Editable editableText = EditBlogView.this.getEditableText();
                new String(editableText.toString());
                int selectionStart = Selection.getSelectionStart(editableText);
                int selectionEnd = Selection.getSelectionEnd(editableText);
                if (selectionStart != -1 && selectionEnd != -1) {
                    int correctPosition = EditBlogView.this.correctPosition(selectionStart);
                    int correctPosition2 = EditBlogView.this.correctPosition(selectionEnd);
                    int i2 = correctPosition;
                    int i3 = correctPosition2;
                    if (correctPosition > correctPosition2) {
                        i3 = correctPosition;
                        i2 = correctPosition2;
                    }
                    if (i2 != selectionStart || i3 != selectionEnd) {
                        Selection.setSelection(editableText, i2, i3);
                    }
                    if (i2 != i3) {
                        EditBlogView.this.getText().delete(i2, i3);
                    }
                }
                return super.setComposingText(charSequence, i);
            }
        };
    }

    @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        OnEnterListener onEnterListener;
        if (i == 66 && (onEnterListener = this.mOnEnterListener) != null) {
            onEnterListener.onEnterKey();
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.widget.TextView
    protected void onSelectionChanged(int i, int i2) {
        List<OnSelectionListener> list;
        super.onSelectionChanged(i, i2);
        if (!this.canSelectionChanged || (list = this.listeners) == null || list.isEmpty()) {
            return;
        }
        for (OnSelectionListener onSelectionListener : this.listeners) {
            onSelectionListener.onSelectionChanged(i, i2);
        }
    }

    public void setOnEnterListener(OnEnterListener onEnterListener) {
        this.mOnEnterListener = onEnterListener;
    }

    public void setOnSelectionListener(OnSelectionListener onSelectionListener) {
        this.listeners.add(onSelectionListener);
    }
}
