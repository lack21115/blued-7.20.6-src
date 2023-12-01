package com.blued.android.module.svgaplayer.entities;

import android.graphics.Matrix;
import com.alipay.sdk.sys.a;
import com.blued.android.module.svgaplayer.proto.FrameEntity;
import com.blued.android.module.svgaplayer.proto.Layout;
import com.blued.android.module.svgaplayer.proto.ShapeEntity;
import com.blued.android.module.svgaplayer.proto.Transform;
import com.blued.android.module.svgaplayer.utils.SVGARect;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/entities/SVGAVideoSpriteFrameEntity.class */
public final class SVGAVideoSpriteFrameEntity {
    private double a;
    private SVGARect b;
    private Matrix c;
    private SVGAPathEntity d;
    private List<SVGAVideoShapeEntity> e;

    public SVGAVideoSpriteFrameEntity(FrameEntity obj) {
        Float f;
        float floatValue;
        float floatValue2;
        float floatValue3;
        float floatValue4;
        float floatValue5;
        float floatValue6;
        Float f2;
        Intrinsics.e(obj, "obj");
        this.b = new SVGARect(0.0d, 0.0d, 0.0d, 0.0d);
        this.c = new Matrix();
        this.e = CollectionsKt.b();
        this.a = obj.alpha != null ? f.floatValue() : 0.0f;
        Layout layout = obj.layout;
        if (layout != null) {
            Float f3 = layout.x;
            double floatValue7 = f3 != null ? f3.floatValue() : 0.0f;
            Float f4 = layout.y;
            double floatValue8 = f4 != null ? f4.floatValue() : 0.0f;
            Float f5 = layout.width;
            this.b = new SVGARect(floatValue7, floatValue8, f5 != null ? f5.floatValue() : 0.0f, layout.height != null ? f2.floatValue() : 0.0f);
        }
        Transform transform = obj.transform;
        boolean z = true;
        if (transform != null) {
            Float f6 = transform.a;
            if (f6 == null) {
                floatValue = 1.0f;
            } else {
                Intrinsics.c(f6, "it.a ?: 1.0f");
                floatValue = f6.floatValue();
            }
            Float f7 = transform.b;
            if (f7 == null) {
                floatValue2 = 0.0f;
            } else {
                Intrinsics.c(f7, "it.b ?: 0.0f");
                floatValue2 = f7.floatValue();
            }
            Float f8 = transform.c;
            if (f8 == null) {
                floatValue3 = 0.0f;
            } else {
                Intrinsics.c(f8, "it.c ?: 0.0f");
                floatValue3 = f8.floatValue();
            }
            Float f9 = transform.d;
            if (f9 == null) {
                floatValue4 = 1.0f;
            } else {
                Intrinsics.c(f9, "it.d ?: 1.0f");
                floatValue4 = f9.floatValue();
            }
            Float f10 = transform.tx;
            if (f10 == null) {
                floatValue5 = 0.0f;
            } else {
                Intrinsics.c(f10, "it.tx ?: 0.0f");
                floatValue5 = f10.floatValue();
            }
            Float f11 = transform.ty;
            if (f11 == null) {
                floatValue6 = 0.0f;
            } else {
                Intrinsics.c(f11, "it.ty ?: 0.0f");
                floatValue6 = f11.floatValue();
            }
            this.c.setValues(new float[]{floatValue, floatValue3, floatValue5, floatValue2, floatValue4, floatValue6, 0.0f, 0.0f, 1.0f});
        }
        String str = obj.clipPath;
        if (str != null) {
            str = str.length() <= 0 ? false : z ? str : null;
            if (str != null) {
                this.d = new SVGAPathEntity(str);
            }
        }
        List<ShapeEntity> list = obj.shapes;
        Intrinsics.c(list, "obj.shapes");
        List<ShapeEntity> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.a((Iterable) list2, 10));
        for (ShapeEntity it : list2) {
            Intrinsics.c(it, "it");
            arrayList.add(new SVGAVideoShapeEntity(it));
        }
        this.e = arrayList;
    }

    public SVGAVideoSpriteFrameEntity(JSONObject obj) {
        Intrinsics.e(obj, "obj");
        this.b = new SVGARect(0.0d, 0.0d, 0.0d, 0.0d);
        this.c = new Matrix();
        this.e = CollectionsKt.b();
        this.a = obj.optDouble("alpha", 0.0d);
        JSONObject optJSONObject = obj.optJSONObject("layout");
        if (optJSONObject != null) {
            this.b = new SVGARect(optJSONObject.optDouble("x", 0.0d), optJSONObject.optDouble("y", 0.0d), optJSONObject.optDouble("width", 0.0d), optJSONObject.optDouble("height", 0.0d));
        }
        JSONObject optJSONObject2 = obj.optJSONObject("transform");
        if (optJSONObject2 != null) {
            double optDouble = optJSONObject2.optDouble("a", 1.0d);
            double optDouble2 = optJSONObject2.optDouble("b", 0.0d);
            this.c.setValues(new float[]{(float) optDouble, (float) optJSONObject2.optDouble("c", 0.0d), (float) optJSONObject2.optDouble("tx", 0.0d), (float) optDouble2, (float) optJSONObject2.optDouble("d", 1.0d), (float) optJSONObject2.optDouble(a.g, 0.0d), 0.0f, 0.0f, 1.0f});
        }
        boolean z = true;
        String optString = obj.optString("clipPath");
        if (optString != null) {
            if (optString.length() <= 0 ? false : z) {
                this.d = new SVGAPathEntity(optString);
            }
        }
        JSONArray optJSONArray = obj.optJSONArray("shapes");
        if (optJSONArray == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int length = optJSONArray.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                this.e = CollectionsKt.f((Iterable) arrayList);
                return;
            }
            JSONObject optJSONObject3 = optJSONArray.optJSONObject(i2);
            if (optJSONObject3 != null) {
                Intrinsics.c(optJSONObject3, "optJSONObject(i)");
                arrayList.add(new SVGAVideoShapeEntity(optJSONObject3));
            }
            i = i2 + 1;
        }
    }

    public final double a() {
        return this.a;
    }

    public final void a(List<SVGAVideoShapeEntity> list) {
        Intrinsics.e(list, "<set-?>");
        this.e = list;
    }

    public final SVGARect b() {
        return this.b;
    }

    public final Matrix c() {
        return this.c;
    }

    public final SVGAPathEntity d() {
        return this.d;
    }

    public final List<SVGAVideoShapeEntity> e() {
        return this.e;
    }
}
