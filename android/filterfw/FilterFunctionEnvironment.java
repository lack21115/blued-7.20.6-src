package android.filterfw;

import android.filterfw.core.Filter;
import android.filterfw.core.FilterFactory;
import android.filterfw.core.FilterFunction;
import android.filterfw.core.FrameManager;

/* loaded from: source-9557208-dex2jar.jar:android/filterfw/FilterFunctionEnvironment.class */
public class FilterFunctionEnvironment extends MffEnvironment {
    public FilterFunctionEnvironment() {
        super(null);
    }

    public FilterFunctionEnvironment(FrameManager frameManager) {
        super(frameManager);
    }

    public FilterFunction createFunction(Class cls, Object... objArr) {
        Filter createFilterByClass = FilterFactory.sharedFactory().createFilterByClass(cls, "FilterFunction(" + cls.getSimpleName() + ")");
        createFilterByClass.initWithAssignmentList(objArr);
        return new FilterFunction(getContext(), createFilterByClass);
    }
}
