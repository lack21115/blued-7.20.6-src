package com.blued.android.module.svgaplayer.drawer;

import android.graphics.Canvas;
import android.widget.ImageView;
import com.blued.android.module.svgaplayer.SVGAVideoEntity;
import com.blued.android.module.svgaplayer.entities.SVGAVideoData;
import com.blued.android.module.svgaplayer.entities.SVGAVideoSpriteEntity;
import com.blued.android.module.svgaplayer.entities.SVGAVideoSpriteFrameEntity;
import com.blued.android.module.svgaplayer.utils.Pools;
import com.blued.android.module.svgaplayer.utils.SVGAScaleInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/drawer/SGVADrawer.class */
public class SGVADrawer {
    private final SVGAVideoEntity a;
    private final SVGAScaleInfo b;
    private final Pools.SimplePool<SVGADrawerSprite> c;

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/drawer/SGVADrawer$SVGADrawerSprite.class */
    public final class SVGADrawerSprite {
        private String b;
        private String c;
        private SVGAVideoSpriteFrameEntity d;

        public SVGADrawerSprite(String str, String str2, SVGAVideoSpriteFrameEntity sVGAVideoSpriteFrameEntity) {
            this.b = str;
            this.c = str2;
            this.d = sVGAVideoSpriteFrameEntity;
        }

        public /* synthetic */ SVGADrawerSprite(SGVADrawer sGVADrawer, String str, String str2, SVGAVideoSpriteFrameEntity sVGAVideoSpriteFrameEntity, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : sVGAVideoSpriteFrameEntity);
        }

        public final String a() {
            return this.b;
        }

        public final void a(SVGAVideoSpriteFrameEntity sVGAVideoSpriteFrameEntity) {
            this.d = sVGAVideoSpriteFrameEntity;
        }

        public final void a(String str) {
            this.b = str;
        }

        public final String b() {
            return this.c;
        }

        public final void b(String str) {
            this.c = str;
        }

        public final SVGAVideoSpriteFrameEntity c() {
            SVGAVideoSpriteFrameEntity sVGAVideoSpriteFrameEntity = this.d;
            Intrinsics.a(sVGAVideoSpriteFrameEntity);
            return sVGAVideoSpriteFrameEntity;
        }
    }

    public SGVADrawer(SVGAVideoEntity videoItem) {
        List<SVGAVideoSpriteEntity> f;
        Intrinsics.e(videoItem, "videoItem");
        this.a = videoItem;
        this.b = new SVGAScaleInfo();
        SVGAVideoData a = this.a.a();
        this.c = new Pools.SimplePool<>(Math.max(1, (a == null || (f = a.f()) == null) ? 0 : f.size()));
    }

    public final SVGAVideoEntity a() {
        return this.a;
    }

    public final List<SVGADrawerSprite> a(int i) {
        SVGADrawerSprite sVGADrawerSprite;
        String a;
        SVGAVideoData a2 = this.a.a();
        List<SVGAVideoSpriteEntity> f = a2 != null ? a2.f() : null;
        Intrinsics.a(f);
        ArrayList arrayList = new ArrayList();
        for (SVGAVideoSpriteEntity sVGAVideoSpriteEntity : f) {
            if (i < 0 || i >= sVGAVideoSpriteEntity.c().size() || (a = sVGAVideoSpriteEntity.a()) == null || (!StringsKt.b(a, ".matte", false, 2, (Object) null) && sVGAVideoSpriteEntity.c().get(i).a() <= 0.0d)) {
                sVGADrawerSprite = null;
            } else {
                SVGADrawerSprite a3 = this.c.a();
                sVGADrawerSprite = a3;
                if (a3 == null) {
                    sVGADrawerSprite = new SVGADrawerSprite(this, null, null, null, 7, null);
                }
                sVGADrawerSprite.a(sVGAVideoSpriteEntity.b());
                sVGADrawerSprite.b(sVGAVideoSpriteEntity.a());
                sVGADrawerSprite.a(sVGAVideoSpriteEntity.c().get(i));
            }
            if (sVGADrawerSprite != null) {
                arrayList.add(sVGADrawerSprite);
            }
        }
        return arrayList;
    }

    public void a(Canvas canvas, int i, ImageView.ScaleType scaleType) {
        Intrinsics.e(canvas, "canvas");
        Intrinsics.e(scaleType, "scaleType");
        SVGAVideoData a = this.a.a();
        if (a == null) {
            return;
        }
        this.b.a(canvas.getWidth(), canvas.getHeight(), (float) a.c().a(), (float) a.c().b(), scaleType);
    }

    public final void a(List<SVGADrawerSprite> sprites) {
        Intrinsics.e(sprites, "sprites");
        for (SVGADrawerSprite sVGADrawerSprite : sprites) {
            this.c.a(sVGADrawerSprite);
        }
    }

    public final SVGAScaleInfo b() {
        return this.b;
    }
}
