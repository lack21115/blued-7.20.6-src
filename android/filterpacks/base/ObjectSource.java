package android.filterpacks.base;

import android.filterfw.core.Filter;
import android.filterfw.core.FilterContext;
import android.filterfw.core.Frame;
import android.filterfw.core.FrameFormat;
import android.filterfw.core.GenerateFieldPort;
import android.filterfw.core.GenerateFinalPort;
import android.filterfw.format.ObjectFormat;
import androidx.constraintlayout.core.motion.utils.TypedValues;

/* loaded from: source-9557208-dex2jar.jar:android/filterpacks/base/ObjectSource.class */
public class ObjectSource extends Filter {
    private Frame mFrame;
    @GenerateFieldPort(name = "object")
    private Object mObject;
    @GenerateFinalPort(hasDefault = true, name = "format")
    private FrameFormat mOutputFormat;
    @GenerateFieldPort(hasDefault = true, name = "repeatFrame")
    boolean mRepeatFrame;

    public ObjectSource(String str) {
        super(str);
        this.mOutputFormat = FrameFormat.unspecified();
        this.mRepeatFrame = false;
    }

    @Override // android.filterfw.core.Filter
    public void fieldPortValueUpdated(String str, FilterContext filterContext) {
        if (!str.equals("object") || this.mFrame == null) {
            return;
        }
        this.mFrame.release();
        this.mFrame = null;
    }

    @Override // android.filterfw.core.Filter
    public void process(FilterContext filterContext) {
        if (this.mFrame == null) {
            if (this.mObject == null) {
                throw new NullPointerException("ObjectSource producing frame with no object set!");
            }
            this.mFrame = filterContext.getFrameManager().newFrame(ObjectFormat.fromObject(this.mObject, 1));
            this.mFrame.setObjectValue(this.mObject);
            this.mFrame.setTimestamp(-1L);
        }
        pushOutput(TypedValues.AttributesType.S_FRAME, this.mFrame);
        if (this.mRepeatFrame) {
            return;
        }
        closeOutputPort(TypedValues.AttributesType.S_FRAME);
    }

    @Override // android.filterfw.core.Filter
    public void setupPorts() {
        addOutputPort(TypedValues.AttributesType.S_FRAME, this.mOutputFormat);
    }

    @Override // android.filterfw.core.Filter
    public void tearDown(FilterContext filterContext) {
        this.mFrame.release();
    }
}
