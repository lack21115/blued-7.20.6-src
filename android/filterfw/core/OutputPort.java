package android.filterfw.core;

/* loaded from: source-9557208-dex2jar.jar:android/filterfw/core/OutputPort.class */
public class OutputPort extends FilterPort {
    protected InputPort mBasePort;
    protected InputPort mTargetPort;

    public OutputPort(Filter filter, String str) {
        super(filter, str);
    }

    @Override // android.filterfw.core.FilterPort
    public void clear() {
        if (this.mTargetPort != null) {
            this.mTargetPort.clear();
        }
    }

    @Override // android.filterfw.core.FilterPort
    public void close() {
        super.close();
        if (this.mTargetPort == null || !this.mTargetPort.isOpen()) {
            return;
        }
        this.mTargetPort.close();
    }

    public void connectTo(InputPort inputPort) {
        if (this.mTargetPort != null) {
            throw new RuntimeException(this + " already connected to " + this.mTargetPort + "!");
        }
        this.mTargetPort = inputPort;
        this.mTargetPort.setSourcePort(this);
    }

    @Override // android.filterfw.core.FilterPort
    public boolean filterMustClose() {
        return !isOpen() && isBlocking();
    }

    public InputPort getBasePort() {
        return this.mBasePort;
    }

    public Filter getTargetFilter() {
        if (this.mTargetPort == null) {
            return null;
        }
        return this.mTargetPort.getFilter();
    }

    public InputPort getTargetPort() {
        return this.mTargetPort;
    }

    @Override // android.filterfw.core.FilterPort
    public boolean hasFrame() {
        if (this.mTargetPort == null) {
            return false;
        }
        return this.mTargetPort.hasFrame();
    }

    public boolean isConnected() {
        return this.mTargetPort != null;
    }

    @Override // android.filterfw.core.FilterPort
    public boolean isReady() {
        return (isOpen() && this.mTargetPort.acceptsFrame()) || !isBlocking();
    }

    @Override // android.filterfw.core.FilterPort
    public void open() {
        super.open();
        if (this.mTargetPort == null || this.mTargetPort.isOpen()) {
            return;
        }
        this.mTargetPort.open();
    }

    @Override // android.filterfw.core.FilterPort
    public Frame pullFrame() {
        throw new RuntimeException("Cannot pull frame on " + this + "!");
    }

    @Override // android.filterfw.core.FilterPort
    public void pushFrame(Frame frame) {
        if (this.mTargetPort == null) {
            throw new RuntimeException("Attempting to push frame on unconnected port: " + this + "!");
        }
        this.mTargetPort.pushFrame(frame);
    }

    public void setBasePort(InputPort inputPort) {
        this.mBasePort = inputPort;
    }

    @Override // android.filterfw.core.FilterPort
    public void setFrame(Frame frame) {
        assertPortIsOpen();
        if (this.mTargetPort == null) {
            throw new RuntimeException("Attempting to set frame on unconnected port: " + this + "!");
        }
        this.mTargetPort.setFrame(frame);
    }

    @Override // android.filterfw.core.FilterPort
    public String toString() {
        return "output " + super.toString();
    }
}
