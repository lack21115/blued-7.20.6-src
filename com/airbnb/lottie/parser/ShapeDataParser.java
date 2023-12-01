package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.utils.MiscUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/parser/ShapeDataParser.class */
public class ShapeDataParser implements ValueParser<ShapeData> {

    /* renamed from: a  reason: collision with root package name */
    public static final ShapeDataParser f4408a = new ShapeDataParser();

    private ShapeDataParser() {
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    /* renamed from: a */
    public ShapeData b(JsonReader jsonReader, float f) throws IOException {
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
        }
        jsonReader.beginObject();
        List<PointF> list = null;
        List<PointF> list2 = null;
        List<PointF> list3 = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            boolean z2 = true;
            int hashCode = nextName.hashCode();
            if (hashCode != 99) {
                if (hashCode != 105) {
                    if (hashCode != 111) {
                        if (hashCode == 118 && nextName.equals("v")) {
                            z2 = true;
                        }
                    } else if (nextName.equals("o")) {
                        z2 = true;
                    }
                } else if (nextName.equals("i")) {
                    z2 = true;
                }
            } else if (nextName.equals("c")) {
                z2 = false;
            }
            if (!z2) {
                z = jsonReader.nextBoolean();
            } else if (z2) {
                list = JsonUtils.a(jsonReader, f);
            } else if (z2) {
                list2 = JsonUtils.a(jsonReader, f);
            } else if (z2) {
                list3 = JsonUtils.a(jsonReader, f);
            }
        }
        jsonReader.endObject();
        if (jsonReader.peek() == JsonToken.END_ARRAY) {
            jsonReader.endArray();
        }
        if (list == null || list2 == null || list3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        }
        if (list.isEmpty()) {
            return new ShapeData(new PointF(), false, Collections.emptyList());
        }
        int size = list.size();
        PointF pointF = list.get(0);
        ArrayList arrayList = new ArrayList(size);
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                break;
            }
            PointF pointF2 = list.get(i2);
            int i3 = i2 - 1;
            arrayList.add(new CubicCurveData(MiscUtils.a(list.get(i3), list3.get(i3)), MiscUtils.a(pointF2, list2.get(i2)), pointF2));
            i = i2 + 1;
        }
        if (z) {
            PointF pointF3 = list.get(0);
            int i4 = size - 1;
            arrayList.add(new CubicCurveData(MiscUtils.a(list.get(i4), list3.get(i4)), MiscUtils.a(pointF3, list2.get(0)), pointF3));
        }
        return new ShapeData(pointF, z, arrayList);
    }
}
