package android.filterpacks.base;

import android.filterfw.core.Filter;
import android.filterfw.core.FilterContext;
import android.filterfw.core.Frame;
import android.filterfw.core.FrameFormat;
import android.filterfw.core.GenerateFieldPort;
import android.filterfw.core.GenerateFinalPort;
import androidx.constraintlayout.core.motion.utils.TypedValues;

/* loaded from: source-9557208-dex2jar.jar:android/filterpacks/base/FrameFetch.class */
public class FrameFetch extends Filter {
    @GenerateFinalPort(hasDefault = true, name = "format")
    private FrameFormat mFormat;
    @GenerateFieldPort(name = "key")
    private String mKey;
    @GenerateFieldPort(hasDefault = true, name = "repeatFrame")
    private boolean mRepeatFrame;

    public FrameFetch(String str) {
        super(str);
        this.mRepeatFrame = false;
    }

    @Override // android.filterfw.core.Filter
    public void process(FilterContext filterContext) {
        Frame fetchFrame = filterContext.fetchFrame(this.mKey);
        if (fetchFrame == null) {
            delayNextProcess(250);
            return;
        }
        pushOutput(TypedValues.AttributesType.S_FRAME, fetchFrame);
        if (this.mRepeatFrame) {
            return;
        }
        closeOutputPort(TypedValues.AttributesType.S_FRAME);
    }

    @Override // android.filterfw.core.Filter
    public void setupPorts() {
        addOutputPort(TypedValues.AttributesType.S_FRAME, this.mFormat == null ? FrameFormat.unspecified() : this.mFormat);
    }
}
