package com.tencent.map.sdk.utilities.heatmap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/sdk/utilities/heatmap/Gradient.class */
public class Gradient extends com.tencent.map.sdk.utilities.visualization.Gradient {
    public Gradient(com.tencent.map.sdk.utilities.visualization.Gradient gradient) {
        super(gradient.mColors, gradient.mStartPoints, gradient.mColorMapSize);
    }

    public Gradient(int[] iArr, float[] fArr) {
        super(iArr, fArr);
    }

    public Gradient(int[] iArr, float[] fArr, int i) {
        super(iArr, fArr, i);
    }
}
