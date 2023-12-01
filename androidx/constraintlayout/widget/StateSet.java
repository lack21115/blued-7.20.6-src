package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/widget/StateSet.class */
public class StateSet {
    public static final String TAG = "ConstraintLayoutStates";

    /* renamed from: a  reason: collision with root package name */
    int f2237a = -1;
    int b = -1;

    /* renamed from: c  reason: collision with root package name */
    int f2238c = -1;
    private SparseArray<State> d = new SparseArray<>();
    private SparseArray<ConstraintSet> e = new SparseArray<>();
    private ConstraintsChangedListener f = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/widget/StateSet$State.class */
    public static class State {

        /* renamed from: a  reason: collision with root package name */
        int f2239a;
        ArrayList<Variant> b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        int f2240c;
        boolean d;

        public State(Context context, XmlPullParser xmlPullParser) {
            this.f2240c = -1;
            this.d = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.State);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.State_android_id) {
                    this.f2239a = obtainStyledAttributes.getResourceId(index, this.f2239a);
                } else if (index == R.styleable.State_constraints) {
                    this.f2240c = obtainStyledAttributes.getResourceId(index, this.f2240c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f2240c);
                    context.getResources().getResourceName(this.f2240c);
                    if ("layout".equals(resourceTypeName)) {
                        this.d = true;
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        void a(Variant variant) {
            this.b.add(variant);
        }

        public int findMatch(float f, float f2) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.b.size()) {
                    return -1;
                }
                if (this.b.get(i2).a(f, f2)) {
                    return i2;
                }
                i = i2 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/widget/StateSet$Variant.class */
    public static class Variant {

        /* renamed from: a  reason: collision with root package name */
        float f2241a;
        float b;

        /* renamed from: c  reason: collision with root package name */
        float f2242c;
        float d;
        int e;
        boolean f;

        public Variant(Context context, XmlPullParser xmlPullParser) {
            this.f2241a = Float.NaN;
            this.b = Float.NaN;
            this.f2242c = Float.NaN;
            this.d = Float.NaN;
            this.e = -1;
            this.f = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.Variant_constraints) {
                    this.e = obtainStyledAttributes.getResourceId(index, this.e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.e);
                    context.getResources().getResourceName(this.e);
                    if ("layout".equals(resourceTypeName)) {
                        this.f = true;
                    }
                } else if (index == R.styleable.Variant_region_heightLessThan) {
                    this.d = obtainStyledAttributes.getDimension(index, this.d);
                } else if (index == R.styleable.Variant_region_heightMoreThan) {
                    this.b = obtainStyledAttributes.getDimension(index, this.b);
                } else if (index == R.styleable.Variant_region_widthLessThan) {
                    this.f2242c = obtainStyledAttributes.getDimension(index, this.f2242c);
                } else if (index == R.styleable.Variant_region_widthMoreThan) {
                    this.f2241a = obtainStyledAttributes.getDimension(index, this.f2241a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }

        boolean a(float f, float f2) {
            if (Float.isNaN(this.f2241a) || f >= this.f2241a) {
                if (Float.isNaN(this.b) || f2 >= this.b) {
                    if (Float.isNaN(this.f2242c) || f <= this.f2242c) {
                        return Float.isNaN(this.d) || f2 <= this.d;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
    }

    public StateSet(Context context, XmlPullParser xmlPullParser) {
        a(context, xmlPullParser);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void a(Context context, XmlPullParser xmlPullParser) {
        State state;
        boolean z;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.StateSet);
        int indexCount = obtainStyledAttributes.getIndexCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= indexCount) {
                break;
            }
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.StateSet_defaultState) {
                this.f2237a = obtainStyledAttributes.getResourceId(index, this.f2237a);
            }
            i = i2 + 1;
        }
        obtainStyledAttributes.recycle();
        State state2 = null;
        try {
            int eventType = xmlPullParser.getEventType();
            while (eventType != 1) {
                if (eventType == 0) {
                    xmlPullParser.getName();
                    state = state2;
                } else if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    switch (name.hashCode()) {
                        case 80204913:
                            if (name.equals("State")) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 1301459538:
                            if (name.equals("LayoutDescription")) {
                                z = false;
                                break;
                            }
                            z = true;
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        default:
                            z = true;
                            break;
                    }
                    if (z) {
                        state = new State(context, xmlPullParser);
                        this.d.put(state.f2239a, state);
                    } else if (!z) {
                        state = state2;
                    } else {
                        Variant variant = new Variant(context, xmlPullParser);
                        state = state2;
                        if (state2 != null) {
                            state2.a(variant);
                            state = state2;
                        }
                    }
                } else if (eventType != 3) {
                    state = state2;
                } else {
                    state = state2;
                    if ("StateSet".equals(xmlPullParser.getName())) {
                        return;
                    }
                }
                eventType = xmlPullParser.next();
                state2 = state;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    public int convertToConstraintSet(int i, int i2, float f, float f2) {
        State state = this.d.get(i2);
        if (state == null) {
            return i2;
        }
        if (f == -1.0f || f2 == -1.0f) {
            if (state.f2240c == i) {
                return i;
            }
            Iterator<Variant> it = state.b.iterator();
            while (it.hasNext()) {
                if (i == it.next().e) {
                    return i;
                }
            }
            return state.f2240c;
        }
        Variant variant = null;
        Iterator<Variant> it2 = state.b.iterator();
        while (it2.hasNext()) {
            Variant next = it2.next();
            if (next.a(f, f2)) {
                if (i == next.e) {
                    return i;
                }
                variant = next;
            }
        }
        return variant != null ? variant.e : state.f2240c;
    }

    public boolean needsToChange(int i, float f, float f2) {
        int i2 = this.b;
        if (i2 != i) {
            return true;
        }
        State valueAt = i == -1 ? this.d.valueAt(0) : this.d.get(i2);
        return (this.f2238c == -1 || !valueAt.b.get(this.f2238c).a(f, f2)) && this.f2238c != valueAt.findMatch(f, f2);
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        this.f = constraintsChangedListener;
    }

    public int stateGetConstraintID(int i, int i2, int i3) {
        return updateConstraints(-1, i, i2, i3);
    }

    public int updateConstraints(int i, int i2, float f, float f2) {
        int findMatch;
        if (i != i2) {
            State state = this.d.get(i2);
            if (state == null) {
                return -1;
            }
            int findMatch2 = state.findMatch(f, f2);
            return findMatch2 == -1 ? state.f2240c : state.b.get(findMatch2).e;
        }
        State valueAt = i2 == -1 ? this.d.valueAt(0) : this.d.get(this.b);
        if (valueAt == null) {
            return -1;
        }
        if ((this.f2238c == -1 || !valueAt.b.get(i).a(f, f2)) && i != (findMatch = valueAt.findMatch(f, f2))) {
            return findMatch == -1 ? valueAt.f2240c : valueAt.b.get(findMatch).e;
        }
        return i;
    }
}
