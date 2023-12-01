package com.blued.android.module.svgaplayer.entities;

import android.graphics.Path;
import com.amap.api.col.p0003sl.iu;
import com.blued.android.module.svgaplayer.utils.SVGAPoint;
import java.util.Set;
import java.util.StringTokenizer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/entities/SVGAPathEntity.class */
public final class SVGAPathEntity {
    private final String a;
    private Path b;

    public SVGAPathEntity(String originValue) {
        Intrinsics.e(originValue, "originValue");
        this.a = StringsKt.c((CharSequence) originValue, (CharSequence) ",", false, 2, (Object) null) ? StringsKt.a(originValue, ",", " ", false, 4, (Object) null) : originValue;
    }

    private final void a(Path path, String str, StringTokenizer stringTokenizer) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        SVGAPoint sVGAPoint;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        float f10 = 0.0f;
        float f11 = 0.0f;
        int i = 0;
        while (true) {
            f = f6;
            f2 = f7;
            f3 = f8;
            f4 = f9;
            f5 = f10;
            try {
                if (!stringTokenizer.hasMoreTokens()) {
                    break;
                }
                float f12 = f6;
                String s = stringTokenizer.nextToken();
                float f13 = f6;
                Intrinsics.c(s, "s");
                float f14 = f6;
                if (!(s.length() == 0)) {
                    float f15 = f6;
                    if (i == 0) {
                        f15 = Float.parseFloat(s);
                    }
                    float f16 = f7;
                    if (i == 1) {
                        f16 = Float.parseFloat(s);
                    }
                    float f17 = f8;
                    if (i == 2) {
                        f17 = Float.parseFloat(s);
                    }
                    float f18 = f9;
                    if (i == 3) {
                        f18 = Float.parseFloat(s);
                    }
                    float f19 = f10;
                    if (i == 4) {
                        f19 = Float.parseFloat(s);
                    }
                    float f20 = f11;
                    if (i == 5) {
                        f20 = Float.parseFloat(s);
                    }
                    i++;
                    f6 = f15;
                    f7 = f16;
                    f8 = f17;
                    f9 = f18;
                    f10 = f19;
                    f11 = f20;
                }
            } catch (Exception e) {
                f = f6;
                f2 = f7;
                f3 = f8;
                f4 = f9;
                f5 = f10;
            }
        }
        SVGAPoint sVGAPoint2 = new SVGAPoint(0.0f, 0.0f, 0.0f);
        if (Intrinsics.a((Object) str, (Object) "M")) {
            path.moveTo(f, f2);
            sVGAPoint = new SVGAPoint(f, f2, 0.0f);
        } else {
            sVGAPoint = sVGAPoint2;
            if (Intrinsics.a((Object) str, (Object) "m")) {
                path.rMoveTo(f, f2);
                sVGAPoint = new SVGAPoint(sVGAPoint2.a() + f, sVGAPoint2.b() + f2, 0.0f);
            }
        }
        if (Intrinsics.a((Object) str, (Object) "L")) {
            path.lineTo(f, f2);
        } else if (Intrinsics.a((Object) str, (Object) "l")) {
            path.rLineTo(f, f2);
        }
        if (Intrinsics.a((Object) str, (Object) "C")) {
            path.cubicTo(f, f2, f3, f4, f5, f11);
        } else if (Intrinsics.a((Object) str, (Object) "c")) {
            path.rCubicTo(f, f2, f3, f4, f5, f11);
        }
        if (Intrinsics.a((Object) str, (Object) "Q")) {
            path.quadTo(f, f2, f3, f4);
        } else if (Intrinsics.a((Object) str, (Object) "q")) {
            path.rQuadTo(f, f2, f3, f4);
        }
        if (Intrinsics.a((Object) str, (Object) "H")) {
            path.lineTo(f, sVGAPoint.b());
        } else if (Intrinsics.a((Object) str, (Object) iu.g)) {
            path.rLineTo(f, 0.0f);
        }
        if (Intrinsics.a((Object) str, (Object) "V")) {
            path.lineTo(sVGAPoint.a(), f);
        } else if (Intrinsics.a((Object) str, (Object) "v")) {
            path.rLineTo(0.0f, f);
        }
        if (Intrinsics.a((Object) str, (Object) "Z")) {
            path.close();
        } else if (Intrinsics.a((Object) str, (Object) "z")) {
            path.close();
        }
    }

    public final void a(Path toPath) {
        Set set;
        Intrinsics.e(toPath, "toPath");
        Path path = this.b;
        if (path != null) {
            toPath.set(path);
            return;
        }
        Path path2 = new Path();
        StringTokenizer stringTokenizer = new StringTokenizer(this.a, "MLHVCSQRAZmlhvcsqraz", true);
        String str = "";
        while (stringTokenizer.hasMoreTokens()) {
            String segment = stringTokenizer.nextToken();
            Intrinsics.c(segment, "segment");
            if (!(segment.length() == 0)) {
                set = SVGAPathEntityKt.a;
                if (set.contains(segment)) {
                    if (Intrinsics.a((Object) segment, (Object) "Z") || Intrinsics.a((Object) segment, (Object) "z")) {
                        a(path2, segment, new StringTokenizer("", ""));
                    }
                    str = segment;
                } else {
                    a(path2, str, new StringTokenizer(segment, " "));
                }
            }
        }
        this.b = path2;
        toPath.set(path2);
    }
}
