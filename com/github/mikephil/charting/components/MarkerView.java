package com.github.mikephil.charting.components;

import android.content.Context;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;
import java.lang.ref.WeakReference;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/components/MarkerView.class */
public class MarkerView extends RelativeLayout implements IMarker {

    /* renamed from: a  reason: collision with root package name */
    private MPPointF f8503a;
    private MPPointF b;

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<Chart> f8504c;

    public MarkerView(Context context, int i) {
        super(context);
        this.f8503a = new MPPointF();
        this.b = new MPPointF();
        setupLayoutResource(i);
    }

    private void setupLayoutResource(int i) {
        View inflate = LayoutInflater.from(getContext()).inflate(i, this);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        inflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        inflate.layout(0, 0, inflate.getMeasuredWidth(), inflate.getMeasuredHeight());
    }

    public MPPointF a(float f, float f2) {
        MPPointF offset = getOffset();
        this.b.f8597a = offset.f8597a;
        this.b.b = offset.b;
        Chart chartView = getChartView();
        float width = getWidth();
        float height = getHeight();
        if (this.b.f8597a + f < 0.0f) {
            this.b.f8597a = -f;
        } else if (chartView != null && f + width + this.b.f8597a > chartView.getWidth()) {
            this.b.f8597a = (chartView.getWidth() - f) - width;
        }
        if (this.b.b + f2 < 0.0f) {
            this.b.b = -f2;
        } else if (chartView != null && f2 + height + this.b.b > chartView.getHeight()) {
            this.b.b = (chartView.getHeight() - f2) - height;
        }
        return this.b;
    }

    @Override // com.github.mikephil.charting.components.IMarker
    public void a(Canvas canvas, float f, float f2) {
        MPPointF a2 = a(f, f2);
        int save = canvas.save();
        canvas.translate(f + a2.f8597a, f2 + a2.b);
        draw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // com.github.mikephil.charting.components.IMarker
    public void a(Entry entry, Highlight highlight) {
        measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }

    public Chart getChartView() {
        WeakReference<Chart> weakReference = this.f8504c;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public MPPointF getOffset() {
        return this.f8503a;
    }

    public void setChartView(Chart chart) {
        this.f8504c = new WeakReference<>(chart);
    }

    public void setOffset(MPPointF mPPointF) {
        this.f8503a = mPPointF;
        if (mPPointF == null) {
            this.f8503a = new MPPointF();
        }
    }
}
