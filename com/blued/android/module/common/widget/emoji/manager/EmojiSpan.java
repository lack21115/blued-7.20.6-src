package com.blued.android.module.common.widget.emoji.manager;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.style.DynamicDrawableSpan;
import androidx.appcompat.content.res.AppCompatResources;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoji/manager/EmojiSpan.class */
final class EmojiSpan extends DynamicDrawableSpan {

    /* renamed from: a  reason: collision with root package name */
    private final Context f11144a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f11145c;
    private Drawable d;

    @Override // android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        if (this.d == null) {
            Drawable drawable = AppCompatResources.getDrawable(this.f11144a, this.b);
            this.d = drawable;
            int i = this.f11145c;
            drawable.setBounds(0, 0, i, i);
        }
        return this.d;
    }
}
