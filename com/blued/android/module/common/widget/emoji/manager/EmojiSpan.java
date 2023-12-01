package com.blued.android.module.common.widget.emoji.manager;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.style.DynamicDrawableSpan;
import androidx.appcompat.content.res.AppCompatResources;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoji/manager/EmojiSpan.class */
final class EmojiSpan extends DynamicDrawableSpan {
    private final Context a;
    private final int b;
    private final int c;
    private Drawable d;

    @Override // android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        if (this.d == null) {
            Drawable drawable = AppCompatResources.getDrawable(this.a, this.b);
            this.d = drawable;
            int i = this.c;
            drawable.setBounds(0, 0, i, i);
        }
        return this.d;
    }
}
