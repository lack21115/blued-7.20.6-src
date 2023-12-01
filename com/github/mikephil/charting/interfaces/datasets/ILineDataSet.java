package com.github.mikephil.charting.interfaces.datasets;

import android.graphics.DashPathEffect;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IFillFormatter;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/interfaces/datasets/ILineDataSet.class */
public interface ILineDataSet extends ILineRadarDataSet<Entry> {
    int D();

    int E();

    boolean F();

    IFillFormatter N();

    LineDataSet.Mode a();

    float b();

    float c();

    float d();

    boolean e();

    int f(int i);

    DashPathEffect f();

    boolean g();
}
