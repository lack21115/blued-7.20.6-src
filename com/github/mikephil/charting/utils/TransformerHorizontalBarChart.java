package com.github.mikephil.charting.utils;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/utils/TransformerHorizontalBarChart.class */
public class TransformerHorizontalBarChart extends Transformer {
    public TransformerHorizontalBarChart(ViewPortHandler viewPortHandler) {
        super(viewPortHandler);
    }

    @Override // com.github.mikephil.charting.utils.Transformer
    public void a(boolean z) {
        this.b.reset();
        if (!z) {
            this.b.postTranslate(this.f8601c.a(), this.f8601c.m() - this.f8601c.d());
            return;
        }
        this.b.setTranslate(-(this.f8601c.n() - this.f8601c.b()), this.f8601c.m() - this.f8601c.d());
        this.b.postScale(-1.0f, 1.0f);
    }
}
