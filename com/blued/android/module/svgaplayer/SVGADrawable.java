package com.blued.android.module.svgaplayer;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.media.SoundPool;
import android.widget.ImageView;
import com.blued.android.module.svgaplayer.drawer.SVGACanvasDrawer;
import com.blued.android.module.svgaplayer.entities.SVGAAudioEntity;
import com.blued.android.module.svgaplayer.entities.SVGAVideoData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/SVGADrawable.class */
public final class SVGADrawable extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private final SVGAVideoEntity f15944a;
    private final SVGADynamicEntity b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f15945c;
    private int d;
    private ImageView.ScaleType e;
    private final SVGACanvasDrawer f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SVGADrawable(SVGAVideoEntity videoItem) {
        this(videoItem, new SVGADynamicEntity());
        Intrinsics.e(videoItem, "videoItem");
    }

    public SVGADrawable(SVGAVideoEntity videoItem, SVGADynamicEntity dynamicItem) {
        Intrinsics.e(videoItem, "videoItem");
        Intrinsics.e(dynamicItem, "dynamicItem");
        this.f15944a = videoItem;
        this.b = dynamicItem;
        this.f15945c = true;
        this.e = ImageView.ScaleType.MATRIX;
        this.f = new SVGACanvasDrawer(this.f15944a, this.b);
    }

    public final SVGAVideoEntity a() {
        return this.f15944a;
    }

    public final void a(int i) {
        if (this.d == i) {
            return;
        }
        this.d = i;
        invalidateSelf();
    }

    public final void a(ImageView.ScaleType scaleType) {
        Intrinsics.e(scaleType, "<set-?>");
        this.e = scaleType;
    }

    public final void a(boolean z) {
        if (this.f15945c == z) {
            return;
        }
        this.f15945c = z;
        invalidateSelf();
    }

    public final SVGADynamicEntity b() {
        return this.b;
    }

    public final int c() {
        return this.d;
    }

    public final void d() {
        List<SVGAAudioEntity> g;
        SVGAVideoData a2 = this.f15944a.a();
        if (a2 == null || (g = a2.g()) == null) {
            return;
        }
        for (SVGAAudioEntity sVGAAudioEntity : g) {
            Integer e = sVGAAudioEntity.e();
            if (e != null) {
                int intValue = e.intValue();
                if (SVGASoundManager.f15975a.a()) {
                    SVGASoundManager.f15975a.c(intValue);
                } else {
                    SoundPool b = this.f15944a.b();
                    if (b != null) {
                        b.stop(intValue);
                    }
                }
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.e(canvas, "canvas");
        if (this.f15945c) {
            return;
        }
        this.f.a(canvas, this.d, this.e);
    }

    public final void e() {
        List<SVGAAudioEntity> g;
        SVGAVideoData a2 = this.f15944a.a();
        if (a2 != null && (g = a2.g()) != null) {
            for (SVGAAudioEntity sVGAAudioEntity : g) {
                Integer e = sVGAAudioEntity.e();
                if (e != null) {
                    int intValue = e.intValue();
                    if (SVGASoundManager.f15975a.a()) {
                        SVGASoundManager.f15975a.c(intValue);
                    } else {
                        SoundPool b = this.f15944a.b();
                        if (b != null) {
                            b.stop(intValue);
                        }
                    }
                }
                sVGAAudioEntity.b(null);
            }
        }
        this.f15944a.c();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
