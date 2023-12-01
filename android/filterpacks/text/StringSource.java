package android.filterpacks.text;

import android.filterfw.core.Filter;
import android.filterfw.core.FilterContext;
import android.filterfw.core.Frame;
import android.filterfw.core.FrameFormat;
import android.filterfw.core.GenerateFieldPort;
import android.filterfw.format.ObjectFormat;

/* loaded from: source-9557208-dex2jar.jar:android/filterpacks/text/StringSource.class */
public class StringSource extends Filter {
    private FrameFormat mOutputFormat;
    @GenerateFieldPort(name = "stringValue")
    private String mString;

    public StringSource(String str) {
        super(str);
    }

    @Override // android.filterfw.core.Filter
    public void process(FilterContext filterContext) {
        Frame newFrame = filterContext.getFrameManager().newFrame(this.mOutputFormat);
        newFrame.setObjectValue(this.mString);
        newFrame.setTimestamp(-1L);
        pushOutput("string", newFrame);
        closeOutputPort("string");
    }

    @Override // android.filterfw.core.Filter
    public void setupPorts() {
        this.mOutputFormat = ObjectFormat.fromClass(String.class, 1);
        addOutputPort("string", this.mOutputFormat);
    }
}
