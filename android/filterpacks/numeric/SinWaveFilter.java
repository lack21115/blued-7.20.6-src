package android.filterpacks.numeric;

import android.filterfw.core.Filter;
import android.filterfw.core.FilterContext;
import android.filterfw.core.Frame;
import android.filterfw.core.FrameFormat;
import android.filterfw.core.GenerateFieldPort;
import android.filterfw.format.ObjectFormat;

/* loaded from: source-9557208-dex2jar.jar:android/filterpacks/numeric/SinWaveFilter.class */
public class SinWaveFilter extends Filter {
    private FrameFormat mOutputFormat;
    @GenerateFieldPort(hasDefault = true, name = "stepSize")
    private float mStepSize;
    private float mValue;

    public SinWaveFilter(String str) {
        super(str);
        this.mStepSize = 0.05f;
        this.mValue = 0.0f;
    }

    @Override // android.filterfw.core.Filter
    public void open(FilterContext filterContext) {
        this.mValue = 0.0f;
    }

    @Override // android.filterfw.core.Filter
    public void process(FilterContext filterContext) {
        Frame newFrame = filterContext.getFrameManager().newFrame(this.mOutputFormat);
        newFrame.setObjectValue(Float.valueOf((((float) Math.sin(this.mValue)) + 1.0f) / 2.0f));
        pushOutput("value", newFrame);
        this.mValue += this.mStepSize;
        newFrame.release();
    }

    @Override // android.filterfw.core.Filter
    public void setupPorts() {
        this.mOutputFormat = ObjectFormat.fromClass(Float.class, 1);
        addOutputPort("value", this.mOutputFormat);
    }
}
