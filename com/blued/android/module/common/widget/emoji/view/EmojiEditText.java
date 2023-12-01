package com.blued.android.module.common.widget.emoji.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import com.blued.android.module.common.R;
import com.blued.android.module.common.widget.emoji.manager.Emoji;
import com.blued.android.module.common.widget.emoji.manager.EmojiHandler;
import com.blued.android.module.common.widget.emoji.manager.EmojiManager;
import skin.support.widget.SkinCompatEditText;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoji/view/EmojiEditText.class */
public class EmojiEditText extends SkinCompatEditText {
    private int mEmojiconAlignment;
    private int mEmojiconSize;
    private int mEmojiconTextSize;
    private boolean mUseSystemDefault;

    public EmojiEditText(Context context) {
        this(context, null);
    }

    public EmojiEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EmojiEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mUseSystemDefault = false;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (!isInEditMode()) {
            EmojiManager.a().b();
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.Emojicon);
        this.mEmojiconSize = (int) obtainStyledAttributes.getDimension(R.styleable.Emojicon_emojiconSize, getTextSize() * 1.2f);
        this.mEmojiconAlignment = obtainStyledAttributes.getInt(R.styleable.Emojicon_emojiconAlignment, 1);
        this.mUseSystemDefault = obtainStyledAttributes.getBoolean(R.styleable.Emojicon_emojiconUseSystemDefault, false);
        obtainStyledAttributes.recycle();
        this.mEmojiconTextSize = (int) getTextSize();
        setText(getText());
    }

    private void updateText(int i, int i2, int i3) {
        if (i2 > 0) {
            return;
        }
        EmojiHandler.a().a(getContext(), getText(), i, i3, this.mEmojiconSize, this.mEmojiconAlignment, this.mEmojiconTextSize, this.mUseSystemDefault);
    }

    public void backspace() {
        dispatchKeyEvent(new KeyEvent(0L, 0L, 0, 67, 0, 0, 0, 0, 6));
    }

    public void input(Emoji emoji) {
        if (emoji != null) {
            int selectionStart = getSelectionStart();
            int selectionEnd = getSelectionEnd();
            if (selectionStart < 0) {
                append(emoji.a());
            } else {
                getText().replace(Math.min(selectionStart, selectionEnd), Math.max(selectionStart, selectionEnd), emoji.a(), 0, emoji.a().length());
            }
        }
    }

    public void onSelectionChanged(int i, int i2) {
        super.onSelectionChanged(i, i2);
    }

    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        updateText(i, i2, i3);
    }

    public void setEmojiSize(int i) {
        this.mEmojiconSize = i;
        updateText(0, 0, getText().length());
    }
}
