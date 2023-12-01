package com.airbnb.lottie.parser;

import android.app.backup.FullBackup;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.JsonReader;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import com.alipay.sdk.sys.a;
import com.anythink.expressad.foundation.d.d;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.tencent.tendinsv.a.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/parser/LayerParser.class */
public class LayerParser {
    private LayerParser() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static Layer a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        boolean z;
        boolean z2;
        Layer.MatteType matteType = Layer.MatteType.NONE;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        jsonReader.beginObject();
        Float valueOf = Float.valueOf(1.0f);
        Float valueOf2 = Float.valueOf(0.0f);
        AnimatableTextFrame animatableTextFrame = null;
        AnimatableTextProperties animatableTextProperties = null;
        AnimatableFloatValue animatableFloatValue = null;
        long j = 0;
        long j2 = -1;
        float f = 0.0f;
        float f2 = 0.0f;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        float f3 = 1.0f;
        float f4 = 0.0f;
        int i4 = 0;
        int i5 = 0;
        boolean z3 = false;
        AnimatableTransform animatableTransform = null;
        String str = null;
        Layer.LayerType layerType = null;
        String str2 = "UNSET";
        String str3 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            switch (nextName.hashCode()) {
                case -995424086:
                    if (nextName.equals("parent")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case -903568142:
                    if (nextName.equals("shapes")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 104:
                    if (nextName.equals("h")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 116:
                    if (nextName.equals("t")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 119:
                    if (nextName.equals(IAdInterListener.AdReqParam.WIDTH)) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 3177:
                    if (nextName.equals("cl")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 3233:
                    if (nextName.equals(FullBackup.MANAGED_EXTERNAL_TREE_TOKEN)) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 3324:
                    if (nextName.equals("hd")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 3367:
                    if (nextName.equals(b.a.q)) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 3432:
                    if (nextName.equals("ks")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                case 3553:
                    if (nextName.equals("op")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 3664:
                    if (nextName.equals("sc")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 3669:
                    if (nextName.equals(d.t)) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 3679:
                    if (nextName.equals("sr")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 3681:
                    if (nextName.equals("st")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 3684:
                    if (nextName.equals("sw")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 3705:
                    if (nextName.equals("tm")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 3712:
                    if (nextName.equals("tt")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 3717:
                    if (nextName.equals(a.g)) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 104415:
                    if (nextName.equals("ind")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 108390670:
                    if (nextName.equals("refId")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                case 1441620890:
                    if (nextName.equals("masksProperties")) {
                        z = true;
                        break;
                    }
                    z = true;
                    break;
                default:
                    z = true;
                    break;
            }
            switch (z) {
                case false:
                    str2 = jsonReader.nextString();
                    break;
                case true:
                    j = jsonReader.nextInt();
                    break;
                case true:
                    str = jsonReader.nextString();
                    break;
                case true:
                    int nextInt = jsonReader.nextInt();
                    if (nextInt >= Layer.LayerType.UNKNOWN.ordinal()) {
                        layerType = Layer.LayerType.UNKNOWN;
                        break;
                    } else {
                        layerType = Layer.LayerType.values()[nextInt];
                        break;
                    }
                case true:
                    j2 = jsonReader.nextInt();
                    break;
                case true:
                    i = (int) (jsonReader.nextInt() * Utils.a());
                    break;
                case true:
                    i2 = (int) (jsonReader.nextInt() * Utils.a());
                    break;
                case true:
                    i3 = Color.parseColor(jsonReader.nextString());
                    break;
                case true:
                    animatableTransform = AnimatableTransformParser.a(jsonReader, lottieComposition);
                    break;
                case true:
                    matteType = Layer.MatteType.values()[jsonReader.nextInt()];
                    lottieComposition.a(1);
                    break;
                case true:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        arrayList.add(MaskParser.a(jsonReader, lottieComposition));
                    }
                    lottieComposition.a(arrayList.size());
                    jsonReader.endArray();
                    break;
                case true:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        ContentModel a2 = ContentModelParser.a(jsonReader, lottieComposition);
                        if (a2 != null) {
                            arrayList2.add(a2);
                        }
                    }
                    jsonReader.endArray();
                    break;
                case true:
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String nextName2 = jsonReader.nextName();
                        int hashCode = nextName2.hashCode();
                        if (hashCode != 97) {
                            if (hashCode == 100 && nextName2.equals("d")) {
                                z2 = false;
                            }
                            z2 = true;
                        } else {
                            if (nextName2.equals("a")) {
                                z2 = true;
                            }
                            z2 = true;
                        }
                        if (!z2) {
                            animatableTextFrame = AnimatableValueParser.f(jsonReader, lottieComposition);
                        } else if (!z2) {
                            jsonReader.skipValue();
                        } else {
                            jsonReader.beginArray();
                            if (jsonReader.hasNext()) {
                                animatableTextProperties = AnimatableTextPropertiesParser.a(jsonReader, lottieComposition);
                            }
                            while (jsonReader.hasNext()) {
                                jsonReader.skipValue();
                            }
                            jsonReader.endArray();
                        }
                    }
                    jsonReader.endObject();
                    break;
                case true:
                    jsonReader.beginArray();
                    ArrayList arrayList3 = new ArrayList();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            String nextName3 = jsonReader.nextName();
                            if ((nextName3.hashCode() == 3519 && nextName3.equals("nm")) ? false : true) {
                                jsonReader.skipValue();
                            } else {
                                arrayList3.add(jsonReader.nextString());
                            }
                        }
                        jsonReader.endObject();
                    }
                    jsonReader.endArray();
                    lottieComposition.a("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList3);
                    break;
                case true:
                    f3 = (float) jsonReader.nextDouble();
                    break;
                case true:
                    f4 = (float) jsonReader.nextDouble();
                    break;
                case true:
                    i4 = (int) (jsonReader.nextInt() * Utils.a());
                    break;
                case true:
                    i5 = (int) (jsonReader.nextInt() * Utils.a());
                    break;
                case true:
                    f = (float) jsonReader.nextDouble();
                    break;
                case true:
                    f2 = (float) jsonReader.nextDouble();
                    break;
                case true:
                    animatableFloatValue = AnimatableValueParser.a(jsonReader, lottieComposition, false);
                    break;
                case true:
                    str3 = jsonReader.nextString();
                    break;
                case true:
                    z3 = jsonReader.nextBoolean();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        float f5 = f / f3;
        float f6 = f2 / f3;
        ArrayList arrayList4 = new ArrayList();
        if (f5 > 0.0f) {
            arrayList4.add(new Keyframe(lottieComposition, valueOf2, valueOf2, null, 0.0f, Float.valueOf(f5)));
        }
        if (f6 <= 0.0f) {
            f6 = lottieComposition.g();
        }
        arrayList4.add(new Keyframe(lottieComposition, valueOf, valueOf, null, f5, Float.valueOf(f6)));
        arrayList4.add(new Keyframe(lottieComposition, valueOf2, valueOf2, null, f6, Float.valueOf(Float.MAX_VALUE)));
        if (str2.endsWith(".ai") || com.anythink.expressad.d.a.b.cZ.equals(str3)) {
            lottieComposition.a("Convert your Illustrator layers to shape layers.");
        }
        return new Layer(arrayList2, lottieComposition, str2, j, layerType, j2, str, arrayList, animatableTransform, i, i2, i3, f3, f4, i4, i5, animatableTextFrame, animatableTextProperties, arrayList4, matteType, animatableFloatValue, z3);
    }

    public static Layer a(LottieComposition lottieComposition) {
        Rect d = lottieComposition.d();
        return new Layer(Collections.emptyList(), lottieComposition, "__container", -1L, Layer.LayerType.PRE_COMP, -1L, null, Collections.emptyList(), new AnimatableTransform(), 0, 0, 0, 0.0f, 0.0f, d.width(), d.height(), null, null, Collections.emptyList(), Layer.MatteType.NONE, null, false);
    }
}
