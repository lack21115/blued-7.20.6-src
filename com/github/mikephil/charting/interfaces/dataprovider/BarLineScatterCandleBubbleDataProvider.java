package com.github.mikephil.charting.interfaces.dataprovider;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.utils.Transformer;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/interfaces/dataprovider/BarLineScatterCandleBubbleDataProvider.class */
public interface BarLineScatterCandleBubbleDataProvider extends ChartInterface {
    Transformer a(YAxis.AxisDependency axisDependency);

    boolean c(YAxis.AxisDependency axisDependency);

    @Override // 
    BarLineScatterCandleBubbleData getData();

    float getHighestVisibleX();

    float getLowestVisibleX();
}
