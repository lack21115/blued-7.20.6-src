package androidx.transition;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:androidx/transition/TransitionValues.class */
public class TransitionValues {
    public View view;
    public final Map<String, Object> values = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    final ArrayList<Transition> f3439a = new ArrayList<>();

    @Deprecated
    public TransitionValues() {
    }

    public TransitionValues(View view) {
        this.view = view;
    }

    public boolean equals(Object obj) {
        if (obj instanceof TransitionValues) {
            TransitionValues transitionValues = (TransitionValues) obj;
            return this.view == transitionValues.view && this.values.equals(transitionValues.values);
        }
        return false;
    }

    public int hashCode() {
        return (this.view.hashCode() * 31) + this.values.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.view + "\n") + "    values:";
        for (String str2 : this.values.keySet()) {
            str = str + "    " + str2 + ": " + this.values.get(str2) + "\n";
        }
        return str;
    }
}
