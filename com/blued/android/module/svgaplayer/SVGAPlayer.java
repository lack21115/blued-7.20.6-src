package com.blued.android.module.svgaplayer;

import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.svgaplayer.SVGAParser;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/SVGAPlayer.class */
public final class SVGAPlayer {

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/SVGAPlayer$Builder.class */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f15971a;
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private int f15972c;
        private boolean d;
        private SVGAImageView.FillMode e;
        private String f;
        private DynamicCallback g;
        private SVGAParser.PlayCallback h;
        private SVGAParser.ParseCompletion i;
        private boolean j;

        public Builder() {
            this.d = true;
            this.e = SVGAImageView.FillMode.Forward;
            this.j = true;
        }

        public Builder(String url) {
            Intrinsics.e(url, "url");
            this.d = true;
            this.e = SVGAImageView.FillMode.Forward;
            this.j = true;
            this.b = url;
        }

        public final Builder a(SVGAImageView.FillMode fillMode) {
            SVGAImageView.FillMode fillMode2 = fillMode;
            if (fillMode == null) {
                fillMode2 = SVGAImageView.FillMode.Forward;
            }
            this.e = fillMode2;
            return this;
        }

        public final Builder a(Boolean bool) {
            this.d = bool != null ? bool.booleanValue() : true;
            return this;
        }

        public final Builder a(Integer num) {
            this.f15972c = num != null ? num.intValue() : 0;
            return this;
        }

        public final Builder a(String str) {
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                return this;
            }
            this.f15971a = str;
            return this;
        }

        public final SVGAPlayer a(SVGAImageView svgaIV) {
            Intrinsics.e(svgaIV, "svgaIV");
            return new SVGAPlayer(this, svgaIV, (DefaultConstructorMarker) null);
        }

        public final SVGAPlayer a(SVGAImageView svgaIV, SVGADynamicEntity dynamic) {
            Intrinsics.e(svgaIV, "svgaIV");
            Intrinsics.e(dynamic, "dynamic");
            return new SVGAPlayer(this, svgaIV, dynamic, null);
        }

        public final String a() {
            return this.f15971a;
        }

        public final String b() {
            return this.b;
        }

        public final int c() {
            return this.f15972c;
        }

        public final SVGAImageView.FillMode d() {
            return this.e;
        }

        public final String e() {
            return this.f;
        }

        public final DynamicCallback f() {
            return this.g;
        }

        public final SVGAParser.PlayCallback g() {
            return this.h;
        }

        public final SVGAParser.ParseCompletion h() {
            return this.i;
        }

        public final boolean i() {
            return this.j;
        }
    }

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/SVGAPlayer$DynamicCallback.class */
    public interface DynamicCallback {
        SVGADynamicEntity a();
    }

    private SVGAPlayer(Builder builder, SVGAImageView sVGAImageView) {
        this(builder, sVGAImageView, (SVGADynamicEntity) null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0063, code lost:
        if (r0.length() == 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00be, code lost:
        if (r0.length() == 0) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private SVGAPlayer(final com.blued.android.module.svgaplayer.SVGAPlayer.Builder r7, com.blued.android.module.svgaplayer.SVGAImageView r8, final com.blued.android.module.svgaplayer.SVGADynamicEntity r9) {
        /*
            Method dump skipped, instructions count: 231
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.svgaplayer.SVGAPlayer.<init>(com.blued.android.module.svgaplayer.SVGAPlayer$Builder, com.blued.android.module.svgaplayer.SVGAImageView, com.blued.android.module.svgaplayer.SVGADynamicEntity):void");
    }

    public /* synthetic */ SVGAPlayer(Builder builder, SVGAImageView sVGAImageView, SVGADynamicEntity sVGADynamicEntity, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder, sVGAImageView, sVGADynamicEntity);
    }

    public /* synthetic */ SVGAPlayer(Builder builder, SVGAImageView sVGAImageView, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder, sVGAImageView);
    }
}
