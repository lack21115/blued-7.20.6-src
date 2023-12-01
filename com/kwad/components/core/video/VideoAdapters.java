package com.kwad.components.core.video;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/video/VideoAdapters.class */
public final class VideoAdapters {

    /* renamed from: com.kwad.components.core.video.VideoAdapters$1  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/video/VideoAdapters$1.class */
    static final /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Ry;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[AdaptType.values().length];
            Ry = iArr;
            try {
                iArr[AdaptType.PORTRAIT_VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                Ry[AdaptType.LANDSCAPE_HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                Ry[AdaptType.PORTRAIT_HORIZONTAL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                Ry[AdaptType.LANDSCAPE_VERTICAL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/video/VideoAdapters$AdaptType.class */
    enum AdaptType {
        PORTRAIT_VERTICAL,
        PORTRAIT_HORIZONTAL,
        LANDSCAPE_VERTICAL,
        LANDSCAPE_HORIZONTAL
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/video/VideoAdapters$a.class */
    public static abstract class a implements com.kwad.components.core.video.c {
        private static boolean b(View view, View view2, int i, int i2) {
            if (view == null || i == 0 || i2 == 0 || view2 == null) {
                return false;
            }
            return (view2.getWidth() == 0 || view2.getHeight() == 0) ? false : true;
        }

        @Override // com.kwad.components.core.video.c
        public final void a(View view, View view2, int i, int i2) {
            if (!b(view, view2, i, i2)) {
                com.kwad.sdk.core.d.b.d("AbstractVideoViewAdapter", "adaptVideo checkArguments invalid");
                return;
            }
            d dVar = new d(view2.getWidth(), view2.getHeight());
            d dVar2 = new d(i, i2);
            boolean z = true;
            boolean z2 = dVar2.getRatio() >= 1.0f;
            if (dVar.getRatio() < 1.0f) {
                z = false;
            }
            AdaptType adaptType = (z && z2) ? AdaptType.PORTRAIT_VERTICAL : z ? AdaptType.PORTRAIT_HORIZONTAL : z2 ? AdaptType.LANDSCAPE_VERTICAL : AdaptType.LANDSCAPE_HORIZONTAL;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            a(adaptType, layoutParams, dVar, dVar2);
            view.setLayoutParams(layoutParams);
        }

        protected abstract void a(AdaptType adaptType, ViewGroup.LayoutParams layoutParams, d dVar, d dVar2);
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/video/VideoAdapters$b.class */
    public static final class b extends a {
        private float Rz = 0.8f;
        private float RA = 0.9375f;
        private float RB = 1.1046f;

        @Override // com.kwad.components.core.video.VideoAdapters.a
        protected final void a(AdaptType adaptType, ViewGroup.LayoutParams layoutParams, d dVar, d dVar2) {
            float qA;
            float f;
            float qB = dVar.qB();
            float qB2 = dVar2.qB();
            float qA2 = dVar.qA();
            float qz = dVar.qz();
            com.kwad.sdk.core.d.b.d("FullHeightAdapter", "onAdaptVideo containerSize: " + qz + ", " + qA2);
            int i = AnonymousClass1.Ry[adaptType.ordinal()];
            if (i == 1 || i == 2) {
                if (qB > qB2) {
                    f = dVar.qz();
                    qA = f / qB2;
                    float f2 = qA2 / qA;
                    float f3 = this.Rz;
                    if (f2 < f3) {
                        qA = qA2 / f3;
                        f = qA * qB2;
                    }
                } else {
                    qA = dVar.qA();
                    f = qB2 * qA;
                    float f4 = qz / f;
                    float f5 = this.RA;
                    if (f4 < f5) {
                        f = qz / f5;
                        qA = f / qB2;
                    }
                }
            } else if (i == 3 || i == 4) {
                f = qA2 * this.RB;
                qA = f / qB2;
            } else {
                qA = -2.14748365E9f;
                f = -2.14748365E9f;
            }
            com.kwad.sdk.core.d.b.d("FullHeightAdapter", "onAdaptVideo result: " + f + ", " + qA);
            if (f == -2.14748365E9f || qA == -2.14748365E9f) {
                return;
            }
            int i2 = (int) qA;
            if (dVar2.getHeight() >= dVar2.getWidth()) {
                layoutParams.width = i2;
                layoutParams.height = (int) f;
                return;
            }
            layoutParams.height = i2;
            layoutParams.width = (int) f;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/video/VideoAdapters$c.class */
    public static final class c extends a {
        @Override // com.kwad.components.core.video.VideoAdapters.a
        protected final void a(AdaptType adaptType, ViewGroup.LayoutParams layoutParams, d dVar, d dVar2) {
            float qz;
            float qA;
            float qB = dVar.qB();
            float qB2 = dVar2.qB();
            int i = AnonymousClass1.Ry[adaptType.ordinal()];
            if (i == 1 || i == 2) {
                if (qB >= qB2) {
                    qA = dVar.qA();
                    qz = qA * qB2;
                } else {
                    qz = dVar.qz();
                    qA = qz / qB2;
                }
            } else if (i == 3 || i == 4) {
                qz = dVar.qA();
                qA = qz / qB2;
            } else {
                qz = 0.0f;
                qA = -2.14748365E9f;
            }
            if (qA == -2.14748365E9f || qz == -2.14748365E9f) {
                return;
            }
            int i2 = (int) qA;
            if (dVar2.getHeight() > dVar2.getWidth()) {
                layoutParams.width = i2;
                layoutParams.height = (int) qz;
                return;
            }
            layoutParams.height = i2;
            layoutParams.width = (int) qz;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/video/VideoAdapters$d.class */
    static final class d {
        float RC;
        float height;
        float width;

        public d(float f, float f2) {
            this.RC = -1.0f;
            this.width = f;
            this.height = f2;
            if (f <= 0.0f || f2 <= 0.0f) {
                return;
            }
            this.RC = f2 / f;
        }

        private boolean isValid() {
            return this.width > 0.0f && this.height > 0.0f;
        }

        public final float getHeight() {
            return this.height;
        }

        public final float getRatio() {
            return this.RC;
        }

        public final float getWidth() {
            return this.width;
        }

        public final float qA() {
            if (isValid()) {
                return Math.min(this.width, this.height);
            }
            return -1.0f;
        }

        public final float qB() {
            if (isValid()) {
                float f = this.height;
                float f2 = this.width;
                return f > f2 ? f / f2 : f2 / f;
            }
            return -1.0f;
        }

        public final float qz() {
            if (isValid()) {
                return Math.max(this.width, this.height);
            }
            return -1.0f;
        }

        public final String toString() {
            return "ViewSize{width=" + this.width + ", height=" + this.height + ", ratio=" + this.RC + '}';
        }
    }
}
