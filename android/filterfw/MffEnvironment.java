package android.filterfw;

import android.filterfw.core.CachedFrameManager;
import android.filterfw.core.FilterContext;
import android.filterfw.core.FrameManager;
import android.filterfw.core.GLEnvironment;

/* loaded from: source-9557208-dex2jar.jar:android/filterfw/MffEnvironment.class */
public class MffEnvironment {
    private FilterContext mContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public MffEnvironment(FrameManager frameManager) {
        CachedFrameManager cachedFrameManager = frameManager == null ? new CachedFrameManager() : frameManager;
        this.mContext = new FilterContext();
        this.mContext.setFrameManager(cachedFrameManager);
    }

    public void activateGLEnvironment() {
        if (this.mContext.getGLEnvironment() == null) {
            throw new NullPointerException("No GLEnvironment in place to activate!");
        }
        this.mContext.getGLEnvironment().activate();
    }

    public void createGLEnvironment() {
        GLEnvironment gLEnvironment = new GLEnvironment();
        gLEnvironment.initWithNewContext();
        setGLEnvironment(gLEnvironment);
    }

    public void deactivateGLEnvironment() {
        if (this.mContext.getGLEnvironment() == null) {
            throw new NullPointerException("No GLEnvironment in place to deactivate!");
        }
        this.mContext.getGLEnvironment().deactivate();
    }

    public FilterContext getContext() {
        return this.mContext;
    }

    public void setGLEnvironment(GLEnvironment gLEnvironment) {
        this.mContext.initGLEnvironment(gLEnvironment);
    }
}
