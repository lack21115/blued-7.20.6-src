package android.filterfw.core;

import android.util.Log;

/* loaded from: source-9557208-dex2jar.jar:android/filterfw/core/FilterPort.class */
public abstract class FilterPort {
    private static final String TAG = "FilterPort";
    protected Filter mFilter;
    protected String mName;
    protected FrameFormat mPortFormat;
    protected boolean mIsBlocking = true;
    protected boolean mIsOpen = false;
    protected boolean mChecksType = false;
    private boolean mLogVerbose = Log.isLoggable(TAG, 2);

    public FilterPort(Filter filter, String str) {
        this.mName = str;
        this.mFilter = filter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void assertPortIsOpen() {
        if (!isOpen()) {
            throw new RuntimeException("Illegal operation on closed " + this + "!");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkFrameManager(Frame frame, FilterContext filterContext) {
        if (frame.getFrameManager() != null && frame.getFrameManager() != filterContext.getFrameManager()) {
            throw new RuntimeException("Frame " + frame + " is managed by foreign FrameManager! ");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkFrameType(Frame frame, boolean z) {
        if ((this.mChecksType || z) && this.mPortFormat != null && !frame.getFormat().isCompatibleWith(this.mPortFormat)) {
            throw new RuntimeException("Frame passed to " + this + " is of incorrect type! Expected " + this.mPortFormat + " but got " + frame.getFormat());
        }
    }

    public abstract void clear();

    public void close() {
        if (this.mIsOpen && this.mLogVerbose) {
            Log.v(TAG, "Closing " + this);
        }
        this.mIsOpen = false;
    }

    public abstract boolean filterMustClose();

    public Filter getFilter() {
        return this.mFilter;
    }

    public String getName() {
        return this.mName;
    }

    public FrameFormat getPortFormat() {
        return this.mPortFormat;
    }

    public abstract boolean hasFrame();

    public boolean isAttached() {
        return this.mFilter != null;
    }

    public boolean isBlocking() {
        return this.mIsBlocking;
    }

    public boolean isOpen() {
        return this.mIsOpen;
    }

    public abstract boolean isReady();

    public void open() {
        if (!this.mIsOpen && this.mLogVerbose) {
            Log.v(TAG, "Opening " + this);
        }
        this.mIsOpen = true;
    }

    public abstract Frame pullFrame();

    public abstract void pushFrame(Frame frame);

    public void setBlocking(boolean z) {
        this.mIsBlocking = z;
    }

    public void setChecksType(boolean z) {
        this.mChecksType = z;
    }

    public abstract void setFrame(Frame frame);

    public void setPortFormat(FrameFormat frameFormat) {
        this.mPortFormat = frameFormat;
    }

    public String toString() {
        return "port '" + this.mName + "' of " + this.mFilter;
    }
}
