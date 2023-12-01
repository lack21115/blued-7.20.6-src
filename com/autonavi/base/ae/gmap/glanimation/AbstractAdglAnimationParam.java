package com.autonavi.base.ae.gmap.glanimation;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/base/ae/gmap/glanimation/AbstractAdglAnimationParam.class */
public abstract class AbstractAdglAnimationParam {
    protected boolean hasCheckedParam;
    protected float mult;
    protected boolean needToCaculate;
    protected float normalizedTime;
    protected int interpolationType = 0;
    protected float factor = 1.0f;
    protected boolean hasFromValue = false;
    protected boolean hasToValue = false;

    public AbstractAdglAnimationParam() {
        this.hasCheckedParam = false;
        this.needToCaculate = false;
        this.hasCheckedParam = false;
        this.needToCaculate = false;
    }

    static float bounce(float f) {
        return f * f * 8.0f;
    }

    public abstract void checkParam();

    public float getCurMult() {
        return this.mult;
    }

    public int getInterpolatorType() {
        return this.interpolationType;
    }

    public boolean needToCaculate() {
        if (!this.hasCheckedParam) {
            checkParam();
        }
        return this.hasCheckedParam && this.needToCaculate;
    }

    public void reset() {
        this.hasCheckedParam = false;
        this.needToCaculate = false;
        this.interpolationType = 0;
        this.factor = 1.0f;
        this.hasCheckedParam = false;
        this.needToCaculate = false;
        this.hasFromValue = false;
        this.hasToValue = false;
    }

    public void setInterpolatorType(int i, float f) {
        this.interpolationType = i;
        this.factor = f;
    }

    public void setNormalizedTime(float f) {
        double pow;
        float f2;
        float bounce;
        float f3;
        this.normalizedTime = f;
        float f4 = f;
        switch (this.interpolationType) {
            case 0:
                break;
            case 1:
                pow = Math.pow(f, this.factor * 2.0f);
                f4 = (float) pow;
                break;
            case 2:
                if (this.factor != 1.0f) {
                    f4 = (float) (1.0d - Math.pow(1.0f - f, f2 * 2.0f));
                    break;
                } else {
                    float f5 = 1.0f - f;
                    f4 = 1.0f - (f5 * f5);
                    break;
                }
            case 3:
                pow = (Math.cos((f + 1.0f) * 3.141592653589793d) / 2.0d) + 0.5d;
                f4 = (float) pow;
                break;
            case 4:
                float f6 = f * 1.1226f;
                if (f6 >= 0.3535f) {
                    if (f6 < 0.7408f) {
                        bounce = bounce(f6 - 0.54719f);
                        f3 = 0.7f;
                    } else if (f6 < 0.9644f) {
                        bounce = bounce(f6 - 0.8526f);
                        f3 = 0.9f;
                    } else {
                        bounce = bounce(f6 - 1.0435f);
                        f3 = 0.95f;
                    }
                    f4 = bounce + f3;
                    break;
                } else {
                    f4 = bounce(f6);
                    break;
                }
            case 5:
                float f7 = f - 1.0f;
                f4 = (f7 * f7 * ((f7 * 3.0f) + 2.0f)) + 1.0f;
                break;
            case 6:
                if (f >= 0.0f) {
                    if (f >= 0.25f) {
                        if (f >= 0.5f) {
                            if (f >= 0.75f) {
                                if (f <= 1.0f) {
                                    f4 = 4.0f - (f * 4.0f);
                                    break;
                                }
                            } else {
                                f4 = (f * 4.0f) - 2.0f;
                                break;
                            }
                        } else {
                            f4 = 2.0f - (f * 4.0f);
                            break;
                        }
                    } else {
                        f4 = f * 4.0f;
                        break;
                    }
                }
            default:
                f4 = 0.0f;
                break;
        }
        this.mult = f4;
    }
}
