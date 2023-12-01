package android.animation;

import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/animation/Keyframes.class */
interface Keyframes extends Cloneable {

    /* loaded from: source-9557208-dex2jar.jar:android/animation/Keyframes$FloatKeyframes.class */
    public interface FloatKeyframes extends Keyframes {
        float getFloatValue(float f);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/animation/Keyframes$IntKeyframes.class */
    public interface IntKeyframes extends Keyframes {
        int getIntValue(float f);
    }

    Keyframes clone();

    List<Keyframe> getKeyframes();

    Class getType();

    Object getValue(float f);

    void invalidateCache();

    void setEvaluator(TypeEvaluator typeEvaluator);
}
