package android.filterfw.core;

/* loaded from: source-9557208-dex2jar.jar:android/filterfw/core/StreamPort.class */
public class StreamPort extends InputPort {
    private Frame mFrame;
    private boolean mPersistent;

    public StreamPort(Filter filter, String str) {
        super(filter, str);
    }

    protected void assignFrame(Frame frame, boolean z) {
        synchronized (this) {
            assertPortIsOpen();
            checkFrameType(frame, z);
            if (z) {
                if (this.mFrame != null) {
                    this.mFrame.release();
                }
            } else if (this.mFrame != null) {
                throw new RuntimeException("Attempting to push more than one frame on port: " + this + "!");
            }
            this.mFrame = frame.retain();
            this.mFrame.markReadOnly();
            this.mPersistent = z;
        }
    }

    @Override // android.filterfw.core.FilterPort
    public void clear() {
        if (this.mFrame != null) {
            this.mFrame.release();
            this.mFrame = null;
        }
    }

    @Override // android.filterfw.core.FilterPort
    public boolean hasFrame() {
        boolean z;
        synchronized (this) {
            z = this.mFrame != null;
        }
        return z;
    }

    @Override // android.filterfw.core.FilterPort
    public Frame pullFrame() {
        Frame frame;
        synchronized (this) {
            if (this.mFrame == null) {
                throw new RuntimeException("No frame available to pull on port: " + this + "!");
            }
            frame = this.mFrame;
            if (this.mPersistent) {
                this.mFrame.retain();
            } else {
                this.mFrame = null;
            }
        }
        return frame;
    }

    @Override // android.filterfw.core.FilterPort
    public void pushFrame(Frame frame) {
        assignFrame(frame, false);
    }

    @Override // android.filterfw.core.FilterPort
    public void setFrame(Frame frame) {
        assignFrame(frame, true);
    }

    @Override // android.filterfw.core.FilterPort
    public String toString() {
        return "input " + super.toString();
    }

    @Override // android.filterfw.core.InputPort
    public void transfer(FilterContext filterContext) {
        synchronized (this) {
            if (this.mFrame != null) {
                checkFrameManager(this.mFrame, filterContext);
            }
        }
    }
}
