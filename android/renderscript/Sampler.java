package android.renderscript;

/* loaded from: source-9557208-dex2jar.jar:android/renderscript/Sampler.class */
public class Sampler extends BaseObj {
    float mAniso;
    Value mMag;
    Value mMin;
    Value mWrapR;
    Value mWrapS;
    Value mWrapT;

    /* loaded from: source-9557208-dex2jar.jar:android/renderscript/Sampler$Builder.class */
    public static class Builder {
        RenderScript mRS;
        Value mMin = Value.NEAREST;
        Value mMag = Value.NEAREST;
        Value mWrapS = Value.WRAP;
        Value mWrapT = Value.WRAP;
        Value mWrapR = Value.WRAP;
        float mAniso = 1.0f;

        public Builder(RenderScript renderScript) {
            this.mRS = renderScript;
        }

        public Sampler create() {
            this.mRS.validate();
            Sampler sampler = new Sampler(this.mRS.nSamplerCreate(this.mMag.mID, this.mMin.mID, this.mWrapS.mID, this.mWrapT.mID, this.mWrapR.mID, this.mAniso), this.mRS);
            sampler.mMin = this.mMin;
            sampler.mMag = this.mMag;
            sampler.mWrapS = this.mWrapS;
            sampler.mWrapT = this.mWrapT;
            sampler.mWrapR = this.mWrapR;
            sampler.mAniso = this.mAniso;
            return sampler;
        }

        public void setAnisotropy(float f) {
            if (f < 0.0f) {
                throw new IllegalArgumentException("Invalid value");
            }
            this.mAniso = f;
        }

        public void setMagnification(Value value) {
            if (value != Value.NEAREST && value != Value.LINEAR) {
                throw new IllegalArgumentException("Invalid value");
            }
            this.mMag = value;
        }

        public void setMinification(Value value) {
            if (value != Value.NEAREST && value != Value.LINEAR && value != Value.LINEAR_MIP_LINEAR && value != Value.LINEAR_MIP_NEAREST) {
                throw new IllegalArgumentException("Invalid value");
            }
            this.mMin = value;
        }

        public void setWrapS(Value value) {
            if (value != Value.WRAP && value != Value.CLAMP && value != Value.MIRRORED_REPEAT) {
                throw new IllegalArgumentException("Invalid value");
            }
            this.mWrapS = value;
        }

        public void setWrapT(Value value) {
            if (value != Value.WRAP && value != Value.CLAMP && value != Value.MIRRORED_REPEAT) {
                throw new IllegalArgumentException("Invalid value");
            }
            this.mWrapT = value;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/renderscript/Sampler$Value.class */
    public enum Value {
        NEAREST(0),
        LINEAR(1),
        LINEAR_MIP_LINEAR(2),
        LINEAR_MIP_NEAREST(5),
        WRAP(3),
        CLAMP(4),
        MIRRORED_REPEAT(6);
        
        int mID;

        Value(int i) {
            this.mID = i;
        }
    }

    Sampler(long j, RenderScript renderScript) {
        super(j, renderScript);
    }

    public static Sampler CLAMP_LINEAR(RenderScript renderScript) {
        if (renderScript.mSampler_CLAMP_LINEAR == null) {
            Builder builder = new Builder(renderScript);
            builder.setMinification(Value.LINEAR);
            builder.setMagnification(Value.LINEAR);
            builder.setWrapS(Value.CLAMP);
            builder.setWrapT(Value.CLAMP);
            renderScript.mSampler_CLAMP_LINEAR = builder.create();
        }
        return renderScript.mSampler_CLAMP_LINEAR;
    }

    public static Sampler CLAMP_LINEAR_MIP_LINEAR(RenderScript renderScript) {
        if (renderScript.mSampler_CLAMP_LINEAR_MIP_LINEAR == null) {
            Builder builder = new Builder(renderScript);
            builder.setMinification(Value.LINEAR_MIP_LINEAR);
            builder.setMagnification(Value.LINEAR);
            builder.setWrapS(Value.CLAMP);
            builder.setWrapT(Value.CLAMP);
            renderScript.mSampler_CLAMP_LINEAR_MIP_LINEAR = builder.create();
        }
        return renderScript.mSampler_CLAMP_LINEAR_MIP_LINEAR;
    }

    public static Sampler CLAMP_NEAREST(RenderScript renderScript) {
        if (renderScript.mSampler_CLAMP_NEAREST == null) {
            Builder builder = new Builder(renderScript);
            builder.setMinification(Value.NEAREST);
            builder.setMagnification(Value.NEAREST);
            builder.setWrapS(Value.CLAMP);
            builder.setWrapT(Value.CLAMP);
            renderScript.mSampler_CLAMP_NEAREST = builder.create();
        }
        return renderScript.mSampler_CLAMP_NEAREST;
    }

    public static Sampler MIRRORED_REPEAT_LINEAR(RenderScript renderScript) {
        if (renderScript.mSampler_MIRRORED_REPEAT_LINEAR == null) {
            Builder builder = new Builder(renderScript);
            builder.setMinification(Value.LINEAR);
            builder.setMagnification(Value.LINEAR);
            builder.setWrapS(Value.MIRRORED_REPEAT);
            builder.setWrapT(Value.MIRRORED_REPEAT);
            renderScript.mSampler_MIRRORED_REPEAT_LINEAR = builder.create();
        }
        return renderScript.mSampler_MIRRORED_REPEAT_LINEAR;
    }

    public static Sampler MIRRORED_REPEAT_LINEAR_MIP_LINEAR(RenderScript renderScript) {
        if (renderScript.mSampler_MIRRORED_REPEAT_LINEAR_MIP_LINEAR == null) {
            Builder builder = new Builder(renderScript);
            builder.setMinification(Value.LINEAR_MIP_LINEAR);
            builder.setMagnification(Value.LINEAR);
            builder.setWrapS(Value.MIRRORED_REPEAT);
            builder.setWrapT(Value.MIRRORED_REPEAT);
            renderScript.mSampler_MIRRORED_REPEAT_LINEAR_MIP_LINEAR = builder.create();
        }
        return renderScript.mSampler_MIRRORED_REPEAT_LINEAR_MIP_LINEAR;
    }

    public static Sampler MIRRORED_REPEAT_NEAREST(RenderScript renderScript) {
        if (renderScript.mSampler_MIRRORED_REPEAT_NEAREST == null) {
            Builder builder = new Builder(renderScript);
            builder.setMinification(Value.NEAREST);
            builder.setMagnification(Value.NEAREST);
            builder.setWrapS(Value.MIRRORED_REPEAT);
            builder.setWrapT(Value.MIRRORED_REPEAT);
            renderScript.mSampler_MIRRORED_REPEAT_NEAREST = builder.create();
        }
        return renderScript.mSampler_MIRRORED_REPEAT_NEAREST;
    }

    public static Sampler WRAP_LINEAR(RenderScript renderScript) {
        if (renderScript.mSampler_WRAP_LINEAR == null) {
            Builder builder = new Builder(renderScript);
            builder.setMinification(Value.LINEAR);
            builder.setMagnification(Value.LINEAR);
            builder.setWrapS(Value.WRAP);
            builder.setWrapT(Value.WRAP);
            renderScript.mSampler_WRAP_LINEAR = builder.create();
        }
        return renderScript.mSampler_WRAP_LINEAR;
    }

    public static Sampler WRAP_LINEAR_MIP_LINEAR(RenderScript renderScript) {
        if (renderScript.mSampler_WRAP_LINEAR_MIP_LINEAR == null) {
            Builder builder = new Builder(renderScript);
            builder.setMinification(Value.LINEAR_MIP_LINEAR);
            builder.setMagnification(Value.LINEAR);
            builder.setWrapS(Value.WRAP);
            builder.setWrapT(Value.WRAP);
            renderScript.mSampler_WRAP_LINEAR_MIP_LINEAR = builder.create();
        }
        return renderScript.mSampler_WRAP_LINEAR_MIP_LINEAR;
    }

    public static Sampler WRAP_NEAREST(RenderScript renderScript) {
        if (renderScript.mSampler_WRAP_NEAREST == null) {
            Builder builder = new Builder(renderScript);
            builder.setMinification(Value.NEAREST);
            builder.setMagnification(Value.NEAREST);
            builder.setWrapS(Value.WRAP);
            builder.setWrapT(Value.WRAP);
            renderScript.mSampler_WRAP_NEAREST = builder.create();
        }
        return renderScript.mSampler_WRAP_NEAREST;
    }

    public float getAnisotropy() {
        return this.mAniso;
    }

    public Value getMagnification() {
        return this.mMag;
    }

    public Value getMinification() {
        return this.mMin;
    }

    public Value getWrapS() {
        return this.mWrapS;
    }

    public Value getWrapT() {
        return this.mWrapT;
    }
}
