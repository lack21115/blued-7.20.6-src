package android.filterfw.core;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* loaded from: source-9557208-dex2jar.jar:android/filterfw/core/FilterContext.class */
public class FilterContext {
    private FrameManager mFrameManager;
    private GLEnvironment mGLEnvironment;
    private HashMap<String, Frame> mStoredFrames = new HashMap<>();
    private Set<FilterGraph> mGraphs = new HashSet();

    /* loaded from: source-9557208-dex2jar.jar:android/filterfw/core/FilterContext$OnFrameReceivedListener.class */
    public interface OnFrameReceivedListener {
        void onFrameReceived(Filter filter, Frame frame, Object obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void addGraph(FilterGraph filterGraph) {
        this.mGraphs.add(filterGraph);
    }

    public Frame fetchFrame(String str) {
        Frame frame;
        synchronized (this) {
            frame = this.mStoredFrames.get(str);
            if (frame != null) {
                frame.onFrameFetch();
            }
        }
        return frame;
    }

    public FrameManager getFrameManager() {
        return this.mFrameManager;
    }

    public GLEnvironment getGLEnvironment() {
        return this.mGLEnvironment;
    }

    public void initGLEnvironment(GLEnvironment gLEnvironment) {
        if (this.mGLEnvironment != null) {
            throw new RuntimeException("Attempting to re-initialize GL Environment for FilterContext!");
        }
        this.mGLEnvironment = gLEnvironment;
    }

    public void removeFrame(String str) {
        synchronized (this) {
            Frame frame = this.mStoredFrames.get(str);
            if (frame != null) {
                this.mStoredFrames.remove(str);
                frame.release();
            }
        }
    }

    public void setFrameManager(FrameManager frameManager) {
        if (frameManager == null) {
            throw new NullPointerException("Attempting to set null FrameManager!");
        }
        if (frameManager.getContext() != null) {
            throw new IllegalArgumentException("Attempting to set FrameManager which is already bound to another FilterContext!");
        }
        this.mFrameManager = frameManager;
        this.mFrameManager.setContext(this);
    }

    public void storeFrame(String str, Frame frame) {
        synchronized (this) {
            Frame fetchFrame = fetchFrame(str);
            if (fetchFrame != null) {
                fetchFrame.release();
            }
            frame.onFrameStore();
            this.mStoredFrames.put(str, frame.retain());
        }
    }

    public void tearDown() {
        synchronized (this) {
            for (Frame frame : this.mStoredFrames.values()) {
                frame.release();
            }
            this.mStoredFrames.clear();
            for (FilterGraph filterGraph : this.mGraphs) {
                filterGraph.tearDown(this);
            }
            this.mGraphs.clear();
            if (this.mFrameManager != null) {
                this.mFrameManager.tearDown();
                this.mFrameManager = null;
            }
            if (this.mGLEnvironment != null) {
                this.mGLEnvironment.tearDown();
                this.mGLEnvironment = null;
            }
        }
    }
}
