package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/renderer/DataRenderer.class */
public abstract class DataRenderer extends Renderer {
    protected ChartAnimator g;
    protected Paint h;
    protected Paint i;
    protected Paint j;
    protected Paint k;

    public DataRenderer(ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(viewPortHandler);
        this.g = chartAnimator;
        Paint paint = new Paint(1);
        this.h = paint;
        paint.setStyle(Paint.Style.FILL);
        this.j = new Paint(4);
        Paint paint2 = new Paint(1);
        this.k = paint2;
        paint2.setColor(Color.rgb(63, 63, 63));
        this.k.setTextAlign(Paint.Align.CENTER);
        this.k.setTextSize(Utils.a(9.0f));
        Paint paint3 = new Paint(1);
        this.i = paint3;
        paint3.setStyle(Paint.Style.STROKE);
        this.i.setStrokeWidth(2.0f);
        this.i.setColor(Color.rgb(255, 187, 115));
    }

    public abstract void a();

    public abstract void a(Canvas canvas);

    public abstract void a(Canvas canvas, Highlight[] highlightArr);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(ChartInterface chartInterface) {
        return ((float) chartInterface.getData().j()) < ((float) chartInterface.getMaxVisibleCount()) * this.o.q();
    }

    public abstract void b(Canvas canvas);

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(IDataSet iDataSet) {
        this.k.setTypeface(iDataSet.s());
        this.k.setTextSize(iDataSet.t());
    }

    public abstract void c(Canvas canvas);
}
