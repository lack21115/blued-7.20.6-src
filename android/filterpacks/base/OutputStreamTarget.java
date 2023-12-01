package android.filterpacks.base;

import android.app.Instrumentation;
import android.filterfw.core.Filter;
import android.filterfw.core.FilterContext;
import android.filterfw.core.Frame;
import android.filterfw.core.GenerateFieldPort;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* loaded from: source-9557208-dex2jar.jar:android/filterpacks/base/OutputStreamTarget.class */
public class OutputStreamTarget extends Filter {
    @GenerateFieldPort(name = Instrumentation.REPORT_KEY_STREAMRESULT)
    private OutputStream mOutputStream;

    public OutputStreamTarget(String str) {
        super(str);
    }

    @Override // android.filterfw.core.Filter
    public void process(FilterContext filterContext) {
        Frame pullInput = pullInput("data");
        ByteBuffer wrap = pullInput.getFormat().getObjectClass() == String.class ? ByteBuffer.wrap(((String) pullInput.getObjectValue()).getBytes()) : pullInput.getData();
        try {
            this.mOutputStream.write(wrap.array(), 0, wrap.limit());
            this.mOutputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException("OutputStreamTarget: Could not write to stream: " + e.getMessage() + "!");
        }
    }

    @Override // android.filterfw.core.Filter
    public void setupPorts() {
        addInputPort("data");
    }
}
