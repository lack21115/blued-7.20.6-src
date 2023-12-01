package io.noties.markwon.core.spans;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import io.noties.markwon.core.MarkwonTheme;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/core/spans/CodeSpan.class */
public class CodeSpan extends MetricAffectingSpan {
    private final MarkwonTheme theme;

    public CodeSpan(MarkwonTheme markwonTheme) {
        this.theme = markwonTheme;
    }

    private void apply(TextPaint textPaint) {
        this.theme.applyCodeTextStyle(textPaint);
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        apply(textPaint);
        textPaint.bgColor = this.theme.getCodeBackgroundColor(textPaint);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        apply(textPaint);
    }
}
