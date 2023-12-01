package android.filterpacks.text;

import android.filterfw.core.Filter;
import android.filterfw.core.FilterContext;
import android.filterfw.format.ObjectFormat;
import android.util.Log;

/* loaded from: source-9557208-dex2jar.jar:android/filterpacks/text/StringLogger.class */
public class StringLogger extends Filter {
    public StringLogger(String str) {
        super(str);
    }

    @Override // android.filterfw.core.Filter
    public void process(FilterContext filterContext) {
        Log.i("StringLogger", pullInput("string").getObjectValue().toString());
    }

    @Override // android.filterfw.core.Filter
    public void setupPorts() {
        addMaskedInputPort("string", ObjectFormat.fromClass(Object.class, 1));
    }
}
