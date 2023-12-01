package com.github.mikephil.charting.interfaces.datasets;

import android.graphics.DashPathEffect;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.model.GradientColor;
import com.github.mikephil.charting.utils.MPPointF;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/interfaces/datasets/IDataSet.class */
public interface IDataSet<T extends Entry> {
    MPPointF A();

    boolean B();

    YAxis.AxisDependency C();

    void G();

    int H();

    float J();

    float K();

    float L();

    float M();

    int a(int i);

    T a(float f, float f2, DataSet.Rounding rounding);

    void a(float f);

    void a(float f, float f2);

    void a(ValueFormatter valueFormatter);

    T b(float f, float f2);

    GradientColor b(int i);

    List<T> b(float f);

    void b(boolean z);

    int d(int i);

    int d(T t);

    T e(int i);

    List<Integer> j();

    int k();

    GradientColor l();

    List<GradientColor> m();

    String o();

    boolean p();

    ValueFormatter q();

    boolean r();

    Typeface s();

    float t();

    Legend.LegendForm u();

    float v();

    float w();

    DashPathEffect x();

    boolean y();

    boolean z();
}
