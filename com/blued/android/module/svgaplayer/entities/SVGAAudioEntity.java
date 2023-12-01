package com.blued.android.module.svgaplayer.entities;

import com.blued.android.module.svgaplayer.proto.AudioEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/entities/SVGAAudioEntity.class */
public final class SVGAAudioEntity {

    /* renamed from: a  reason: collision with root package name */
    private final String f16000a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f16001c;
    private final int d;
    private final int e;
    private Integer f;
    private Integer g;

    public SVGAAudioEntity(AudioEntity audioItem) {
        Intrinsics.e(audioItem, "audioItem");
        this.f16000a = audioItem.audioKey;
        Integer num = audioItem.startFrame;
        this.b = num == null ? 0 : num.intValue();
        Integer num2 = audioItem.endFrame;
        this.f16001c = num2 == null ? 0 : num2.intValue();
        Integer num3 = audioItem.startTime;
        this.d = num3 == null ? 0 : num3.intValue();
        Integer num4 = audioItem.totalTime;
        this.e = num4 == null ? 0 : num4.intValue();
    }

    public final String a() {
        return this.f16000a;
    }

    public final void a(Integer num) {
        this.f = num;
    }

    public final int b() {
        return this.b;
    }

    public final void b(Integer num) {
        this.g = num;
    }

    public final int c() {
        return this.f16001c;
    }

    public final Integer d() {
        return this.f;
    }

    public final Integer e() {
        return this.g;
    }
}
