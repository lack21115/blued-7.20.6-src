package android.filterfw.core;

/* loaded from: source-9557208-dex2jar.jar:android/filterfw/core/SimpleFrameManager.class */
public class SimpleFrameManager extends FrameManager {
    private Frame createNewFrame(FrameFormat frameFormat) {
        switch (frameFormat.getTarget()) {
            case 1:
                return new SimpleFrame(frameFormat, this);
            case 2:
                return new NativeFrame(frameFormat, this);
            case 3:
                GLFrame gLFrame = new GLFrame(frameFormat, this);
                gLFrame.init(getGLEnvironment());
                return gLFrame;
            case 4:
                return new VertexFrame(frameFormat, this);
            default:
                throw new RuntimeException("Unsupported frame target type: " + FrameFormat.targetToString(frameFormat.getTarget()) + "!");
        }
    }

    @Override // android.filterfw.core.FrameManager
    public Frame newBoundFrame(FrameFormat frameFormat, int i, long j) {
        switch (frameFormat.getTarget()) {
            case 3:
                GLFrame gLFrame = new GLFrame(frameFormat, this, i, j);
                gLFrame.init(getGLEnvironment());
                return gLFrame;
            default:
                throw new RuntimeException("Attached frames are not supported for target type: " + FrameFormat.targetToString(frameFormat.getTarget()) + "!");
        }
    }

    @Override // android.filterfw.core.FrameManager
    public Frame newFrame(FrameFormat frameFormat) {
        return createNewFrame(frameFormat);
    }

    @Override // android.filterfw.core.FrameManager
    public Frame releaseFrame(Frame frame) {
        int decRefCount = frame.decRefCount();
        if (decRefCount == 0 && frame.hasNativeAllocation()) {
            frame.releaseNativeAllocation();
            frame = null;
        } else if (decRefCount < 0) {
            throw new RuntimeException("Frame reference count dropped below 0!");
        }
        return frame;
    }

    @Override // android.filterfw.core.FrameManager
    public Frame retainFrame(Frame frame) {
        frame.incRefCount();
        return frame;
    }
}
