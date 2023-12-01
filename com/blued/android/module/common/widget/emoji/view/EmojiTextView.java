package com.blued.android.module.common.widget.emoji.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.widget.TextView;
import com.blued.android.module.common.R;
import com.blued.android.module.common.widget.emoji.manager.EmojiHandler;
import com.blued.android.module.common.widget.emoji.manager.EmojiManager;
import skin.support.widget.SkinCompatTextView;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoji/view/EmojiTextView.class */
public class EmojiTextView extends SkinCompatTextView {
    public static final float EM_SIZE_RATE = 1.2f;
    private int mEmojiconAlignment;
    private int mEmojiconSize;
    private int mEmojiconTextSize;
    private int mTextLength;
    private int mTextStart;
    private boolean mUseSystemDefault;

    public EmojiTextView(Context context) {
        this(context, null);
    }

    public EmojiTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EmojiTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTextStart = 0;
        this.mTextLength = -1;
        this.mUseSystemDefault = false;
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        if (!isInEditMode()) {
            EmojiManager.a().b();
        }
        this.mEmojiconTextSize = (int) getTextSize();
        if (attributeSet == null) {
            this.mEmojiconSize = (int) (getTextSize() * 1.2f);
        } else {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.Emojicon);
            this.mEmojiconSize = (int) obtainStyledAttributes.getDimension(R.styleable.Emojicon_emojiconSize, getTextSize() * 1.2f);
            this.mEmojiconAlignment = obtainStyledAttributes.getInt(R.styleable.Emojicon_emojiconAlignment, 1);
            this.mTextStart = obtainStyledAttributes.getInteger(R.styleable.Emojicon_emojiconTextStart, 0);
            this.mTextLength = obtainStyledAttributes.getInteger(R.styleable.Emojicon_emojiconTextLength, -1);
            this.mUseSystemDefault = obtainStyledAttributes.getBoolean(R.styleable.Emojicon_emojiconUseSystemDefault, this.mUseSystemDefault);
            obtainStyledAttributes.recycle();
        }
        setText(getText());
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        CharSequence charSequence2 = charSequence;
        if (charSequence == null) {
            charSequence2 = "";
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence2);
        EmojiHandler.a().a(getContext(), spannableStringBuilder, this.mEmojiconSize, this.mEmojiconAlignment, this.mEmojiconTextSize, this.mUseSystemDefault);
        super.setText(spannableStringBuilder, bufferType);
    }

    public void setUseSystemDefault(boolean z) {
        this.mUseSystemDefault = z;
    }

    public void setmEmojiSize(int i) {
        this.mEmojiconSize = i;
        super.setText(getText());
    }
}
