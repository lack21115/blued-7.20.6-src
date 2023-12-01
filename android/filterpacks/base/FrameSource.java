package android.filterpacks.base;

import android.filterfw.core.Filter;
import android.filterfw.core.FilterContext;
import android.filterfw.core.Frame;
import android.filterfw.core.FrameFormat;
import android.filterfw.core.GenerateFieldPort;
import android.filterfw.core.GenerateFinalPort;
import androidx.constraintlayout.core.motion.utils.TypedValues;

/* loaded from: source-9557208-dex2jar.jar:android/filterpacks/base/FrameSource.class */
public class FrameSource extends Filter {
    @GenerateFinalPort(name = "format")
    private FrameFormat mFormat;
    @GenerateFieldPort(hasDefault = true, name = TypedValues.AttributesType.S_FRAME)
    private Frame mFrame;
    @GenerateFieldPort(hasDefault = true, name = "repeatFrame")
    private boolean mRepeatFrame;

    public FrameSource(String str) {
        super(str);
        this.mFrame = null;
        this.mRepeatFrame = false;
    }

    @Override // android.filterfw.core.Filter
    public void process(FilterContext filterContext) {
        if (this.mFrame != null) {
            pushOutput(TypedValues.AttributesType.S_FRAME, this.mFrame);
        }
        if (this.mRepeatFrame) {
            return;
        }
        closeOutputPort(TypedValues.AttributesType.S_FRAME);
    }

    @Override // android.filterfw.core.Filter
    public void setupPorts() {
        addOutputPort(TypedValues.AttributesType.S_FRAME, this.mFormat);
    }
}
