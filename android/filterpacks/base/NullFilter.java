package android.filterpacks.base;

import android.filterfw.core.Filter;
import android.filterfw.core.FilterContext;
import androidx.constraintlayout.core.motion.utils.TypedValues;

/* loaded from: source-9557208-dex2jar.jar:android/filterpacks/base/NullFilter.class */
public class NullFilter extends Filter {
    public NullFilter(String str) {
        super(str);
    }

    @Override // android.filterfw.core.Filter
    public void process(FilterContext filterContext) {
        pullInput(TypedValues.AttributesType.S_FRAME);
    }

    @Override // android.filterfw.core.Filter
    public void setupPorts() {
        addInputPort(TypedValues.AttributesType.S_FRAME);
    }
}
