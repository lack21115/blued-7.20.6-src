package android.filterpacks.base;

import android.filterfw.core.Filter;
import android.filterfw.core.FilterContext;
import android.filterfw.core.Frame;
import android.filterfw.core.FrameFormat;
import android.filterfw.core.GenerateFinalPort;

/* loaded from: source-9557208-dex2jar.jar:android/filterpacks/base/FrameBranch.class */
public class FrameBranch extends Filter {
    @GenerateFinalPort(hasDefault = true, name = "outputs")
    private int mNumberOfOutputs;

    public FrameBranch(String str) {
        super(str);
        this.mNumberOfOutputs = 2;
    }

    @Override // android.filterfw.core.Filter
    public FrameFormat getOutputFormat(String str, FrameFormat frameFormat) {
        return frameFormat;
    }

    @Override // android.filterfw.core.Filter
    public void process(FilterContext filterContext) {
        Frame pullInput = pullInput("in");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mNumberOfOutputs) {
                return;
            }
            pushOutput("out" + i2, pullInput);
            i = i2 + 1;
        }
    }

    @Override // android.filterfw.core.Filter
    public void setupPorts() {
        addInputPort("in");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mNumberOfOutputs) {
                return;
            }
            addOutputBasedOnInput("out" + i2, "in");
            i = i2 + 1;
        }
    }
}
