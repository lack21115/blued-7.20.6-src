package com.blued.android.module.svgaplayer.entities;

import com.blued.android.module.svgaplayer.proto.FrameEntity;
import com.blued.android.module.svgaplayer.proto.SpriteEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/entities/SVGAVideoSpriteEntity.class */
public final class SVGAVideoSpriteEntity {
    private final String a;
    private final String b;
    private final List<SVGAVideoSpriteFrameEntity> c;

    public SVGAVideoSpriteEntity(SpriteEntity obj) {
        ArrayList b;
        Intrinsics.e(obj, "obj");
        this.a = obj.imageKey;
        this.b = obj.matteKey;
        List<FrameEntity> list = obj.frames;
        if (list != null) {
            List<FrameEntity> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.a((Iterable) list2, 10));
            Iterator<FrameEntity> it = list2.iterator();
            SVGAVideoSpriteFrameEntity sVGAVideoSpriteFrameEntity = null;
            while (true) {
                SVGAVideoSpriteFrameEntity sVGAVideoSpriteFrameEntity2 = sVGAVideoSpriteFrameEntity;
                if (!it.hasNext()) {
                    break;
                }
                FrameEntity it2 = it.next();
                Intrinsics.c(it2, "it");
                SVGAVideoSpriteFrameEntity sVGAVideoSpriteFrameEntity3 = new SVGAVideoSpriteFrameEntity(it2);
                if ((!sVGAVideoSpriteFrameEntity3.e().isEmpty()) && ((SVGAVideoShapeEntity) CollectionsKt.h((List<? extends Object>) sVGAVideoSpriteFrameEntity3.e())).d() && sVGAVideoSpriteFrameEntity2 != null) {
                    sVGAVideoSpriteFrameEntity3.a(sVGAVideoSpriteFrameEntity2.e());
                }
                arrayList.add(sVGAVideoSpriteFrameEntity3);
                sVGAVideoSpriteFrameEntity = sVGAVideoSpriteFrameEntity3;
            }
            b = arrayList;
        } else {
            b = CollectionsKt.b();
        }
        this.c = b;
    }

    public SVGAVideoSpriteEntity(JSONObject obj) {
        Intrinsics.e(obj, "obj");
        this.a = obj.optString("imageKey");
        this.b = obj.optString("matteKey");
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = obj.optJSONArray("frames");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    Intrinsics.c(optJSONObject, "optJSONObject(i)");
                    SVGAVideoSpriteFrameEntity sVGAVideoSpriteFrameEntity = new SVGAVideoSpriteFrameEntity(optJSONObject);
                    if ((!sVGAVideoSpriteFrameEntity.e().isEmpty()) && ((SVGAVideoShapeEntity) CollectionsKt.h((List<? extends Object>) sVGAVideoSpriteFrameEntity.e())).d() && arrayList.size() > 0) {
                        sVGAVideoSpriteFrameEntity.a(((SVGAVideoSpriteFrameEntity) CollectionsKt.j((List<? extends Object>) arrayList)).e());
                    }
                    arrayList.add(sVGAVideoSpriteFrameEntity);
                }
            }
        }
        this.c = CollectionsKt.f((Iterable) arrayList);
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final List<SVGAVideoSpriteFrameEntity> c() {
        return this.c;
    }
}
