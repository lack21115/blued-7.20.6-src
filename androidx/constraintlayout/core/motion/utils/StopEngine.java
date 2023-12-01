package androidx.constraintlayout.core.motion.utils;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/StopEngine.class */
public interface StopEngine {
    String debug(String str, float f);

    float getInterpolation(float f);

    float getVelocity();

    float getVelocity(float f);

    boolean isStopped();
}
