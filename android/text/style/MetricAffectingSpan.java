package android.text.style;

import android.text.TextPaint;

/* loaded from: source-9557208-dex2jar.jar:android/text/style/MetricAffectingSpan.class */
public abstract class MetricAffectingSpan extends CharacterStyle implements UpdateLayout {

    /* loaded from: source-9557208-dex2jar.jar:android/text/style/MetricAffectingSpan$Passthrough.class */
    static class Passthrough extends MetricAffectingSpan {
        private MetricAffectingSpan mStyle;

        public Passthrough(MetricAffectingSpan metricAffectingSpan) {
            this.mStyle = metricAffectingSpan;
        }

        @Override // android.text.style.MetricAffectingSpan, android.text.style.CharacterStyle
        public MetricAffectingSpan getUnderlying() {
            return this.mStyle.getUnderlying();
        }

        @Override // android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            this.mStyle.updateDrawState(textPaint);
        }

        @Override // android.text.style.MetricAffectingSpan
        public void updateMeasureState(TextPaint textPaint) {
            this.mStyle.updateMeasureState(textPaint);
        }
    }

    @Override // android.text.style.CharacterStyle
    public MetricAffectingSpan getUnderlying() {
        return this;
    }

    public abstract void updateMeasureState(TextPaint textPaint);
}
