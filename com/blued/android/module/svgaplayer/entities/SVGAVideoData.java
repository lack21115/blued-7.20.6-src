package com.blued.android.module.svgaplayer.entities;

import android.graphics.Bitmap;
import com.blued.android.module.svgaplayer.proto.MovieEntity;
import com.blued.android.module.svgaplayer.utils.SVGARect;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/entities/SVGAVideoData.class */
public final class SVGAVideoData {
    private MovieEntity b;
    private int e;
    private File i;
    private int j;
    private int k;
    private boolean a = true;
    private SVGARect c = new SVGARect(0.0d, 0.0d, 0.0d, 0.0d);
    private int d = 15;
    private List<SVGAVideoSpriteEntity> f = CollectionsKt.b();
    private List<SVGAAudioEntity> g = CollectionsKt.b();
    private HashMap<String, Bitmap> h = new HashMap<>();

    public final void a(int i) {
        this.d = i;
    }

    public final void a(MovieEntity movieEntity) {
        this.b = movieEntity;
    }

    public final void a(SVGARect sVGARect) {
        Intrinsics.e(sVGARect, "<set-?>");
        this.c = sVGARect;
    }

    public final void a(File file) {
        this.i = file;
    }

    public final void a(List<SVGAVideoSpriteEntity> list) {
        Intrinsics.e(list, "<set-?>");
        this.f = list;
    }

    public final void a(boolean z) {
        this.a = z;
    }

    public final boolean a() {
        return this.a;
    }

    public final MovieEntity b() {
        return this.b;
    }

    public final void b(int i) {
        this.e = i;
    }

    public final void b(List<SVGAAudioEntity> list) {
        Intrinsics.e(list, "<set-?>");
        this.g = list;
    }

    public final SVGARect c() {
        return this.c;
    }

    public final void c(int i) {
        this.j = i;
    }

    public final int d() {
        return this.d;
    }

    public final void d(int i) {
        this.k = i;
    }

    public final int e() {
        return this.e;
    }

    public final List<SVGAVideoSpriteEntity> f() {
        return this.f;
    }

    public final List<SVGAAudioEntity> g() {
        return this.g;
    }

    public final HashMap<String, Bitmap> h() {
        return this.h;
    }

    public final File i() {
        return this.i;
    }

    public final int j() {
        return this.j;
    }

    public final int k() {
        return this.k;
    }

    public final void l() {
        this.g = CollectionsKt.b();
        this.f = CollectionsKt.b();
        this.h.clear();
    }
}
