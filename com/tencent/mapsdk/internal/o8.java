package com.tencent.mapsdk.internal;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/o8.class */
public class o8 implements y8<Number> {
    @Override // com.tencent.mapsdk.internal.y8
    public Number a(float f, Number number, Number number2) {
        double doubleValue = number.doubleValue();
        return Double.valueOf(doubleValue + (f * (number2.doubleValue() - doubleValue)));
    }
}
