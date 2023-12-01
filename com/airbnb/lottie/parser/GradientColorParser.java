package com.airbnb.lottie.parser;

import android.graphics.Color;
import android.util.JsonReader;
import android.util.JsonToken;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.utils.MiscUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/parser/GradientColorParser.class */
public class GradientColorParser implements ValueParser<GradientColor> {
    private int a;

    public GradientColorParser(int i) {
        this.a = i;
    }

    private int a(double d, double[] dArr, double[] dArr2) {
        double d2;
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= dArr.length) {
                d2 = dArr2[dArr2.length - 1];
                break;
            }
            int i3 = i2 - 1;
            double d3 = dArr[i3];
            double d4 = dArr[i2];
            if (dArr[i2] >= d) {
                d2 = MiscUtils.a(dArr2[i3], dArr2[i2], (d - d3) / (d4 - d3));
                break;
            }
            i = i2 + 1;
        }
        return (int) (d2 * 255.0d);
    }

    private void a(GradientColor gradientColor, List<Float> list) {
        int i;
        int i2 = this.a * 4;
        if (list.size() <= i2) {
            return;
        }
        int size = (list.size() - i2) / 2;
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        int i3 = 0;
        while (true) {
            if (i2 >= list.size()) {
                break;
            }
            if (i2 % 2 == 0) {
                dArr[i3] = list.get(i2).floatValue();
            } else {
                dArr2[i3] = list.get(i2).floatValue();
                i3++;
            }
            i2++;
        }
        for (i = 0; i < gradientColor.c(); i++) {
            int i4 = gradientColor.b()[i];
            gradientColor.b()[i] = Color.argb(a(gradientColor.a()[i], dArr, dArr2), Color.red(i4), Color.green(i4), Color.blue(i4));
        }
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    /* renamed from: a */
    public GradientColor b(JsonReader jsonReader, float f) throws IOException {
        ArrayList arrayList = new ArrayList();
        boolean z = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
        if (z) {
            jsonReader.beginArray();
        }
        while (jsonReader.hasNext()) {
            arrayList.add(Float.valueOf((float) jsonReader.nextDouble()));
        }
        if (z) {
            jsonReader.endArray();
        }
        if (this.a == -1) {
            this.a = arrayList.size() / 4;
        }
        int i = this.a;
        float[] fArr = new float[i];
        int[] iArr = new int[i];
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.a * 4; i4++) {
            int i5 = i4 / 4;
            double floatValue = arrayList.get(i4).floatValue();
            int i6 = i4 % 4;
            if (i6 == 0) {
                fArr[i5] = (float) floatValue;
            } else if (i6 == 1) {
                i3 = (int) (floatValue * 255.0d);
            } else if (i6 == 2) {
                i2 = (int) (floatValue * 255.0d);
            } else if (i6 == 3) {
                iArr[i5] = Color.argb(255, i3, i2, (int) (floatValue * 255.0d));
            }
        }
        GradientColor gradientColor = new GradientColor(fArr, iArr);
        a(gradientColor, arrayList);
        return gradientColor;
    }
}
