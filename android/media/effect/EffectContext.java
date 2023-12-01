package android.media.effect;

import android.filterfw.core.CachedFrameManager;
import android.filterfw.core.FilterContext;
import android.filterfw.core.GLEnvironment;
import android.opengl.GLES20;

/* loaded from: source-9557208-dex2jar.jar:android/media/effect/EffectContext.class */
public class EffectContext {
    private EffectFactory mFactory;
    private final int GL_STATE_FBO = 0;
    private final int GL_STATE_PROGRAM = 1;
    private final int GL_STATE_ARRAYBUFFER = 2;
    private final int GL_STATE_COUNT = 3;
    private int[] mOldState = new int[3];
    FilterContext mFilterContext = new FilterContext();

    private EffectContext() {
        this.mFilterContext.setFrameManager(new CachedFrameManager());
        this.mFactory = new EffectFactory(this);
    }

    public static EffectContext createWithCurrentGlContext() {
        EffectContext effectContext = new EffectContext();
        effectContext.initInCurrentGlContext();
        return effectContext;
    }

    private void initInCurrentGlContext() {
        if (!GLEnvironment.isAnyContextActive()) {
            throw new RuntimeException("Attempting to initialize EffectContext with no active GL context!");
        }
        GLEnvironment gLEnvironment = new GLEnvironment();
        gLEnvironment.initWithCurrentContext();
        this.mFilterContext.initGLEnvironment(gLEnvironment);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void assertValidGLState() {
        GLEnvironment gLEnvironment = this.mFilterContext.getGLEnvironment();
        if (gLEnvironment == null || !gLEnvironment.isContextActive()) {
            if (!GLEnvironment.isAnyContextActive()) {
                throw new RuntimeException("Attempting to apply effect without valid GL context!");
            }
            throw new RuntimeException("Applying effect in wrong GL context!");
        }
    }

    public EffectFactory getFactory() {
        return this.mFactory;
    }

    public void release() {
        this.mFilterContext.tearDown();
        this.mFilterContext = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void restoreGLState() {
        GLES20.glBindFramebuffer(36160, this.mOldState[0]);
        GLES20.glUseProgram(this.mOldState[1]);
        GLES20.glBindBuffer(34962, this.mOldState[2]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void saveGLState() {
        GLES20.glGetIntegerv(36006, this.mOldState, 0);
        GLES20.glGetIntegerv(GLES20.GL_CURRENT_PROGRAM, this.mOldState, 1);
        GLES20.glGetIntegerv(34964, this.mOldState, 2);
    }
}
