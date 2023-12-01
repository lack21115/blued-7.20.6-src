package android.filterfw.core;

import java.util.Map;

/* loaded from: source-9557208-dex2jar.jar:android/filterfw/core/FilterFunction.class */
public class FilterFunction {
    private Filter mFilter;
    private FilterContext mFilterContext;
    private boolean mFilterIsSetup = false;
    private FrameHolderPort[] mResultHolders;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/filterfw/core/FilterFunction$FrameHolderPort.class */
    public class FrameHolderPort extends StreamPort {
        public FrameHolderPort() {
            super(null, "holder");
        }
    }

    public FilterFunction(FilterContext filterContext, Filter filter) {
        this.mFilterContext = filterContext;
        this.mFilter = filter;
    }

    private void connectFilterOutputs() {
        int i = 0;
        this.mResultHolders = new FrameHolderPort[this.mFilter.getNumberOfOutputs()];
        for (OutputPort outputPort : this.mFilter.getOutputPorts()) {
            this.mResultHolders[i] = new FrameHolderPort();
            outputPort.connectTo(this.mResultHolders[i]);
            i++;
        }
    }

    public void close() {
        this.mFilter.performClose(this.mFilterContext);
    }

    public Frame execute(KeyValueMap keyValueMap) {
        int numberOfOutputs = this.mFilter.getNumberOfOutputs();
        if (numberOfOutputs > 1) {
            throw new RuntimeException("Calling execute on filter " + this.mFilter + " with multiple outputs! Use executeMulti() instead!");
        }
        if (!this.mFilterIsSetup) {
            connectFilterOutputs();
            this.mFilterIsSetup = true;
        }
        GLEnvironment gLEnvironment = this.mFilterContext.getGLEnvironment();
        boolean z = false;
        if (gLEnvironment != null) {
            z = false;
            if (!gLEnvironment.isActive()) {
                gLEnvironment.activate();
                z = true;
            }
        }
        for (Map.Entry<String, Object> entry : keyValueMap.entrySet()) {
            if (entry.getValue() instanceof Frame) {
                this.mFilter.pushInputFrame(entry.getKey(), (Frame) entry.getValue());
            } else {
                this.mFilter.pushInputValue(entry.getKey(), entry.getValue());
            }
        }
        if (this.mFilter.getStatus() != 3) {
            this.mFilter.openOutputs();
        }
        this.mFilter.performProcess(this.mFilterContext);
        Frame frame = null;
        if (numberOfOutputs == 1) {
            frame = null;
            if (this.mResultHolders[0].hasFrame()) {
                frame = this.mResultHolders[0].pullFrame();
            }
        }
        if (z) {
            gLEnvironment.deactivate();
        }
        return frame;
    }

    public Frame executeWithArgList(Object... objArr) {
        return execute(KeyValueMap.fromKeyValues(objArr));
    }

    public FilterContext getContext() {
        return this.mFilterContext;
    }

    public Filter getFilter() {
        return this.mFilter;
    }

    public void setInputFrame(String str, Frame frame) {
        this.mFilter.setInputFrame(str, frame);
    }

    public void setInputValue(String str, Object obj) {
        this.mFilter.setInputValue(str, obj);
    }

    public void tearDown() {
        this.mFilter.performTearDown(this.mFilterContext);
        this.mFilter = null;
    }

    public String toString() {
        return this.mFilter.getName();
    }
}
