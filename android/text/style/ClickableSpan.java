package android.text.style;

import android.text.TextPaint;
import android.view.View;

/* loaded from: source-9557208-dex2jar.jar:android/text/style/ClickableSpan.class */
public abstract class ClickableSpan extends CharacterStyle implements UpdateAppearance {
    public abstract void onClick(View view);

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(textPaint.linkColor);
        textPaint.setUnderlineText(true);
    }
}
