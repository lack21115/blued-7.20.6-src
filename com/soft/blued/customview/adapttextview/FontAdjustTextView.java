package com.soft.blued.customview.adapttextview;

import android.content.Context;
import android.util.AttributeSet;
import com.blued.android.config.FlexDebugSevConfig;
import com.blued.android.module.common.widget.emoji.view.EmojiTextView;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/adapttextview/FontAdjustTextView.class */
public class FontAdjustTextView extends EmojiTextView {
    public FontAdjustTextView(Context context) {
        this(context, null);
    }

    public FontAdjustTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FontAdjustTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (FlexDebugSevConfig.a().b().android_font_adjust == 1) {
            setTextSize(FontAdjustTextHelper.a());
        }
    }
}
