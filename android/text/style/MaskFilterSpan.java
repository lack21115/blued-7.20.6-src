package android.text.style;

import android.graphics.MaskFilter;
import android.text.TextPaint;

/* loaded from: source-9557208-dex2jar.jar:android/text/style/MaskFilterSpan.class */
public class MaskFilterSpan extends CharacterStyle implements UpdateAppearance {
    private MaskFilter mFilter;

    public MaskFilterSpan(MaskFilter maskFilter) {
        this.mFilter = maskFilter;
    }

    public MaskFilter getMaskFilter() {
        return this.mFilter;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setMaskFilter(this.mFilter);
    }
}
