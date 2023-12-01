package android.filterpacks.performance;

import android.filterfw.core.Filter;
import android.filterfw.core.FilterContext;
import android.filterfw.core.Frame;
import android.filterfw.core.FrameFormat;
import android.filterfw.core.GenerateFieldPort;
import android.filterfw.format.ObjectFormat;
import android.os.SystemClock;
import androidx.constraintlayout.core.motion.utils.TypedValues;

/* loaded from: source-9557208-dex2jar.jar:android/filterpacks/performance/ThroughputFilter.class */
public class ThroughputFilter extends Filter {
    private long mLastTime;
    private FrameFormat mOutputFormat;
    @GenerateFieldPort(hasDefault = true, name = "period")
    private int mPeriod;
    private int mPeriodFrameCount;
    private int mTotalFrameCount;

    public ThroughputFilter(String str) {
        super(str);
        this.mPeriod = 5;
        this.mLastTime = 0L;
        this.mTotalFrameCount = 0;
        this.mPeriodFrameCount = 0;
    }

    @Override // android.filterfw.core.Filter
    public FrameFormat getOutputFormat(String str, FrameFormat frameFormat) {
        return frameFormat;
    }

    @Override // android.filterfw.core.Filter
    public void open(FilterContext filterContext) {
        this.mTotalFrameCount = 0;
        this.mPeriodFrameCount = 0;
        this.mLastTime = 0L;
    }

    @Override // android.filterfw.core.Filter
    public void process(FilterContext filterContext) {
        Frame pullInput = pullInput(TypedValues.AttributesType.S_FRAME);
        pushOutput(TypedValues.AttributesType.S_FRAME, pullInput);
        this.mTotalFrameCount++;
        this.mPeriodFrameCount++;
        if (this.mLastTime == 0) {
            this.mLastTime = SystemClock.elapsedRealtime();
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - this.mLastTime >= this.mPeriod * 1000) {
            FrameFormat format = pullInput.getFormat();
            Throughput throughput = new Throughput(this.mTotalFrameCount, this.mPeriodFrameCount, this.mPeriod, format.getWidth() * format.getHeight());
            Frame newFrame = filterContext.getFrameManager().newFrame(this.mOutputFormat);
            newFrame.setObjectValue(throughput);
            pushOutput("throughput", newFrame);
            this.mLastTime = elapsedRealtime;
            this.mPeriodFrameCount = 0;
        }
    }

    @Override // android.filterfw.core.Filter
    public void setupPorts() {
        addInputPort(TypedValues.AttributesType.S_FRAME);
        this.mOutputFormat = ObjectFormat.fromClass(Throughput.class, 1);
        addOutputBasedOnInput(TypedValues.AttributesType.S_FRAME, TypedValues.AttributesType.S_FRAME);
        addOutputPort("throughput", this.mOutputFormat);
    }
}
