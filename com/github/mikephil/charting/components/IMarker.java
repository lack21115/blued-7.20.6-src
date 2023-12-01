package com.github.mikephil.charting.components;

import android.graphics.Canvas;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/components/IMarker.class */
public interface IMarker {
    void a(Canvas canvas, float f, float f2);

    void a(Entry entry, Highlight highlight);
}
