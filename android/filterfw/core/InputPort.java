package android.filterfw.core;

/* loaded from: source-9557208-dex2jar.jar:android/filterfw/core/InputPort.class */
public abstract class InputPort extends FilterPort {
    protected OutputPort mSourcePort;

    public InputPort(Filter filter, String str) {
        super(filter, str);
    }

    public boolean acceptsFrame() {
        return !hasFrame();
    }

    @Override // android.filterfw.core.FilterPort
    public void close() {
        if (this.mSourcePort != null && this.mSourcePort.isOpen()) {
            this.mSourcePort.close();
        }
        super.close();
    }

    @Override // android.filterfw.core.FilterPort
    public boolean filterMustClose() {
        return (isOpen() || !isBlocking() || hasFrame()) ? false : true;
    }

    public Filter getSourceFilter() {
        if (this.mSourcePort == null) {
            return null;
        }
        return this.mSourcePort.getFilter();
    }

    public FrameFormat getSourceFormat() {
        return this.mSourcePort != null ? this.mSourcePort.getPortFormat() : getPortFormat();
    }

    public OutputPort getSourcePort() {
        return this.mSourcePort;
    }

    public Object getTarget() {
        return null;
    }

    public boolean isConnected() {
        return this.mSourcePort != null;
    }

    @Override // android.filterfw.core.FilterPort
    public boolean isReady() {
        return hasFrame() || !isBlocking();
    }

    @Override // android.filterfw.core.FilterPort
    public void open() {
        super.open();
        if (this.mSourcePort == null || this.mSourcePort.isOpen()) {
            return;
        }
        this.mSourcePort.open();
    }

    public void setSourcePort(OutputPort outputPort) {
        if (this.mSourcePort != null) {
            throw new RuntimeException(this + " already connected to " + this.mSourcePort + "!");
        }
        this.mSourcePort = outputPort;
    }

    public abstract void transfer(FilterContext filterContext);
}
