package androidx.constraintlayout.motion.utils;

import androidx.constraintlayout.core.motion.utils.SpringStopEngine;
import androidx.constraintlayout.core.motion.utils.StopEngine;
import androidx.constraintlayout.core.motion.utils.StopLogicEngine;
import androidx.constraintlayout.motion.widget.MotionInterpolator;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/utils/StopLogic.class */
public class StopLogic extends MotionInterpolator {

    /* renamed from: a  reason: collision with root package name */
    private StopLogicEngine f2116a;
    private SpringStopEngine b;

    /* renamed from: c  reason: collision with root package name */
    private StopEngine f2117c;

    public StopLogic() {
        StopLogicEngine stopLogicEngine = new StopLogicEngine();
        this.f2116a = stopLogicEngine;
        this.f2117c = stopLogicEngine;
    }

    public void config(float f, float f2, float f3, float f4, float f5, float f6) {
        StopLogicEngine stopLogicEngine = this.f2116a;
        this.f2117c = stopLogicEngine;
        stopLogicEngine.config(f, f2, f3, f4, f5, f6);
    }

    public String debug(String str, float f) {
        return this.f2117c.debug(str, f);
    }

    @Override // androidx.constraintlayout.motion.widget.MotionInterpolator, android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return this.f2117c.getInterpolation(f);
    }

    @Override // androidx.constraintlayout.motion.widget.MotionInterpolator
    public float getVelocity() {
        return this.f2117c.getVelocity();
    }

    public float getVelocity(float f) {
        return this.f2117c.getVelocity(f);
    }

    public boolean isStopped() {
        return this.f2117c.isStopped();
    }

    public void springConfig(float f, float f2, float f3, float f4, float f5, float f6, float f7, int i) {
        if (this.b == null) {
            this.b = new SpringStopEngine();
        }
        SpringStopEngine springStopEngine = this.b;
        this.f2117c = springStopEngine;
        springStopEngine.springConfig(f, f2, f3, f4, f5, f6, f7, i);
    }
}
