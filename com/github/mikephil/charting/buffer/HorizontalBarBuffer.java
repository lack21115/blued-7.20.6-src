package com.github.mikephil.charting.buffer;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/buffer/HorizontalBarBuffer.class */
public class HorizontalBarBuffer extends BarBuffer {
    public HorizontalBarBuffer(int i, int i2, boolean z) {
        super(i, i2, z);
    }

    @Override // com.github.mikephil.charting.buffer.BarBuffer
    public void a(IBarDataSet iBarDataSet) {
        float f;
        float abs;
        float abs2;
        float f2;
        float f3;
        float H = iBarDataSet.H();
        float f4 = this.f8454c;
        float f5 = this.k / 2.0f;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= H * f4) {
                a();
                return;
            }
            BarEntry barEntry = (BarEntry) iBarDataSet.e(i2);
            if (barEntry != null) {
                float i3 = barEntry.i();
                float b = barEntry.b();
                float[] a2 = barEntry.a();
                if (!this.i || a2 == null) {
                    if (this.j) {
                        f = b >= 0.0f ? b : 0.0f;
                        if (b > 0.0f) {
                            b = 0.0f;
                        }
                    } else {
                        float f6 = b >= 0.0f ? b : 0.0f;
                        if (b > 0.0f) {
                            b = 0.0f;
                        }
                        float f7 = b;
                        b = f6;
                        f = f7;
                    }
                    if (b > 0.0f) {
                        b *= this.d;
                    } else {
                        f *= this.d;
                    }
                    a(f, i3 + f5, b, i3 - f5);
                } else {
                    float f8 = -barEntry.f();
                    int i4 = 0;
                    float f9 = 0.0f;
                    while (true) {
                        float f10 = f9;
                        if (i4 < a2.length) {
                            float f11 = a2[i4];
                            if (f11 >= 0.0f) {
                                abs = f11 + f10;
                                abs2 = f8;
                                f8 = f10;
                                f2 = abs;
                            } else {
                                abs = Math.abs(f11) + f8;
                                abs2 = Math.abs(f11) + f8;
                                f2 = f10;
                            }
                            if (this.j) {
                                f3 = f8 >= abs ? f8 : abs;
                                if (f8 > abs) {
                                    f8 = abs;
                                }
                            } else {
                                float f12 = f8 >= abs ? f8 : abs;
                                if (f8 > abs) {
                                    f8 = abs;
                                }
                                float f13 = f8;
                                f8 = f12;
                                f3 = f13;
                            }
                            a(f3 * this.d, i3 + f5, f8 * this.d, i3 - f5);
                            i4++;
                            f8 = abs2;
                            f9 = f2;
                        }
                    }
                }
            }
            i = i2 + 1;
        }
    }
}
