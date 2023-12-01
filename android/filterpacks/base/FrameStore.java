package android.filterpacks.base;

import android.filterfw.core.Filter;
import android.filterfw.core.FilterContext;
import android.filterfw.core.GenerateFieldPort;
import androidx.constraintlayout.core.motion.utils.TypedValues;

/* loaded from: source-9557208-dex2jar.jar:android/filterpacks/base/FrameStore.class */
public class FrameStore extends Filter {
    @GenerateFieldPort(name = "key")
    private String mKey;

    public FrameStore(String str) {
        super(str);
    }

    @Override // android.filterfw.core.Filter
    public void process(FilterContext filterContext) {
        filterContext.storeFrame(this.mKey, pullInput(TypedValues.AttributesType.S_FRAME));
    }

    @Override // android.filterfw.core.Filter
    public void setupPorts() {
        addInputPort(TypedValues.AttributesType.S_FRAME);
    }
}
