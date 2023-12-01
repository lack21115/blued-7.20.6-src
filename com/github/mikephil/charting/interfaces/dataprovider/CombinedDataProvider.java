package com.github.mikephil.charting.interfaces.dataprovider;

import com.github.mikephil.charting.data.CombinedData;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/interfaces/dataprovider/CombinedDataProvider.class */
public interface CombinedDataProvider extends BarDataProvider, BubbleDataProvider, CandleDataProvider, LineDataProvider, ScatterDataProvider {
    CombinedData getCombinedData();
}
