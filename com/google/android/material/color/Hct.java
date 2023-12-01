package com.google.android.material.color;

/* loaded from: source-8110460-dex2jar.jar:com/google/android/material/color/Hct.class */
final class Hct {
    private static final float CHROMA_SEARCH_ENDPOINT = 0.4f;
    private static final float DE_MAX = 1.0f;
    private static final float DE_MAX_ERROR = 1.0E-9f;
    private static final float DL_MAX = 0.2f;
    private static final float LIGHTNESS_SEARCH_ENDPOINT = 0.01f;
    private float chroma;
    private float hue;
    private float tone;

    private Hct(float f, float f2, float f3) {
        setInternalState(gamutMap(f, f2, f3));
    }

    private static Cam16 findCamByJ(float f, float f2, float f3) {
        float f4 = 1000.0f;
        Cam16 cam16 = null;
        float f5 = 1000.0f;
        float f6 = 100.0f;
        float f7 = 0.0f;
        while (Math.abs(f7 - f6) > 0.01f) {
            float f8 = ((f6 - f7) / 2.0f) + f7;
            int i = Cam16.fromJch(f8, f2, f).getInt();
            float lstarFromInt = ColorUtils.lstarFromInt(i);
            float abs = Math.abs(f3 - lstarFromInt);
            float f9 = f4;
            float f10 = f5;
            Cam16 cam162 = cam16;
            if (abs < 0.2f) {
                Cam16 fromInt = Cam16.fromInt(i);
                float distance = fromInt.distance(Cam16.fromJch(fromInt.getJ(), fromInt.getChroma(), f));
                f9 = f4;
                f10 = f5;
                cam162 = cam16;
                if (distance <= 1.0f) {
                    f9 = f4;
                    f10 = f5;
                    cam162 = cam16;
                    if (distance <= f4) {
                        cam162 = fromInt;
                        f10 = abs;
                        f9 = distance;
                    }
                }
            }
            if (f10 == 0.0f && f9 < DE_MAX_ERROR) {
                return cam162;
            }
            if (lstarFromInt < f3) {
                f7 = f8;
                f4 = f9;
                f5 = f10;
                cam16 = cam162;
            } else {
                f6 = f8;
                f4 = f9;
                f5 = f10;
                cam16 = cam162;
            }
        }
        return cam16;
    }

    public static Hct from(float f, float f2, float f3) {
        return new Hct(f, f2, f3);
    }

    public static Hct fromInt(int i) {
        Cam16 fromInt = Cam16.fromInt(i);
        return new Hct(fromInt.getHue(), fromInt.getChroma(), ColorUtils.lstarFromInt(i));
    }

    private static int gamutMap(float f, float f2, float f3) {
        return gamutMapInViewingConditions(f, f2, f3, ViewingConditions.DEFAULT);
    }

    static int gamutMapInViewingConditions(float f, float f2, float f3, ViewingConditions viewingConditions) {
        if (f2 < 1.0d || Math.round(f3) <= 0.0d || Math.round(f3) >= 100.0d) {
            return ColorUtils.intFromLstar(f3);
        }
        float sanitizeDegrees = MathUtils.sanitizeDegrees(f);
        float f4 = f2;
        Cam16 cam16 = null;
        float f5 = 0.0f;
        boolean z = true;
        while (Math.abs(f5 - f2) >= 0.4f) {
            Cam16 findCamByJ = findCamByJ(sanitizeDegrees, f4, f3);
            if (z) {
                if (findCamByJ != null) {
                    return findCamByJ.viewed(viewingConditions);
                }
                z = false;
            } else if (findCamByJ == null) {
                f2 = f4;
            } else {
                cam16 = findCamByJ;
                f5 = f4;
            }
            f4 = ((f2 - f5) / 2.0f) + f5;
        }
        return cam16 == null ? ColorUtils.intFromLstar(f3) : cam16.viewed(viewingConditions);
    }

    private void setInternalState(int i) {
        Cam16 fromInt = Cam16.fromInt(i);
        float lstarFromInt = ColorUtils.lstarFromInt(i);
        this.hue = fromInt.getHue();
        this.chroma = fromInt.getChroma();
        this.tone = lstarFromInt;
    }

    public float getChroma() {
        return this.chroma;
    }

    public float getHue() {
        return this.hue;
    }

    public float getTone() {
        return this.tone;
    }

    public void setChroma(float f) {
        setInternalState(gamutMap(this.hue, f, this.tone));
    }

    public void setHue(float f) {
        setInternalState(gamutMap(MathUtils.sanitizeDegrees(f), this.chroma, this.tone));
    }

    public void setTone(float f) {
        setInternalState(gamutMap(this.hue, this.chroma, f));
    }

    public int toInt() {
        return gamutMap(this.hue, this.chroma, this.tone);
    }
}
