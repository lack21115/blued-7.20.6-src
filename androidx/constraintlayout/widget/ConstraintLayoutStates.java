package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/widget/ConstraintLayoutStates.class */
public class ConstraintLayoutStates {
    public static final String TAG = "ConstraintLayoutStates";

    /* renamed from: a  reason: collision with root package name */
    ConstraintSet f2259a;
    private final ConstraintLayout d;
    int b = -1;

    /* renamed from: c  reason: collision with root package name */
    int f2260c = -1;
    private SparseArray<State> e = new SparseArray<>();
    private SparseArray<ConstraintSet> f = new SparseArray<>();
    private ConstraintsChangedListener g = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/widget/ConstraintLayoutStates$State.class */
    public static class State {

        /* renamed from: a  reason: collision with root package name */
        int f2261a;
        ArrayList<Variant> b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        int f2262c;
        ConstraintSet d;

        public State(Context context, XmlPullParser xmlPullParser) {
            this.f2262c = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.State);
            int indexCount = obtainStyledAttributes.getIndexCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= indexCount) {
                    obtainStyledAttributes.recycle();
                    return;
                }
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.State_android_id) {
                    this.f2261a = obtainStyledAttributes.getResourceId(index, this.f2261a);
                } else if (index == R.styleable.State_constraints) {
                    this.f2262c = obtainStyledAttributes.getResourceId(index, this.f2262c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f2262c);
                    context.getResources().getResourceName(this.f2262c);
                    if ("layout".equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.d = constraintSet;
                        constraintSet.clone(context, this.f2262c);
                    }
                }
                i = i2 + 1;
            }
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
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/widget/ConstraintLayoutStates$Variant.class */
    public static class Variant {

        /* renamed from: a  reason: collision with root package name */
        float f2263a;
        float b;

        /* renamed from: c  reason: collision with root package name */
        float f2264c;
        float d;
        int e;
        ConstraintSet f;

        public Variant(Context context, XmlPullParser xmlPullParser) {
            this.f2263a = Float.NaN;
            this.b = Float.NaN;
            this.f2264c = Float.NaN;
            this.d = Float.NaN;
            this.e = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= indexCount) {
                    obtainStyledAttributes.recycle();
                    return;
                }
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.Variant_constraints) {
                    this.e = obtainStyledAttributes.getResourceId(index, this.e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.e);
                    context.getResources().getResourceName(this.e);
                    if ("layout".equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.f = constraintSet;
                        constraintSet.clone(context, this.e);
                    }
                } else if (index == R.styleable.Variant_region_heightLessThan) {
                    this.d = obtainStyledAttributes.getDimension(index, this.d);
                } else if (index == R.styleable.Variant_region_heightMoreThan) {
                    this.b = obtainStyledAttributes.getDimension(index, this.b);
                } else if (index == R.styleable.Variant_region_widthLessThan) {
                    this.f2264c = obtainStyledAttributes.getDimension(index, this.f2264c);
                } else if (index == R.styleable.Variant_region_widthMoreThan) {
                    this.f2263a = obtainStyledAttributes.getDimension(index, this.f2263a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
                i = i2 + 1;
            }
        }

        boolean a(float f, float f2) {
            if (Float.isNaN(this.f2263a) || f >= this.f2263a) {
                if (Float.isNaN(this.b) || f2 >= this.b) {
                    if (Float.isNaN(this.f2264c) || f <= this.f2264c) {
                        return Float.isNaN(this.d) || f2 <= this.d;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConstraintLayoutStates(Context context, ConstraintLayout constraintLayout, int i) {
        this.d = constraintLayout;
        a(context, i);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void a(Context context, int i) {
        State state;
        boolean z;
        XmlResourceParser xml = context.getResources().getXml(i);
        State state2 = null;
        try {
            int eventType = xml.getEventType();
            while (eventType != 1) {
                if (eventType == 0) {
                    xml.getName();
                    state = state2;
                } else if (eventType != 2) {
                    state = state2;
                } else {
                    String name = xml.getName();
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals("ConstraintSet")) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 80204913:
                            if (name.equals("State")) {
                                z = true;
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
                        case 1657696882:
                            if (name.equals("layoutDescription")) {
                                z = false;
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
                        state = new State(context, xml);
                        this.e.put(state.f2261a, state);
                    } else if (z) {
                        Variant variant = new Variant(context, xml);
                        state = state2;
                        if (state2 != null) {
                            state2.a(variant);
                            state = state2;
                        }
                    } else if (!z) {
                        state = state2;
                    } else {
                        a(context, xml);
                        state = state2;
                    }
                }
                eventType = xml.next();
                state2 = state;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    private void a(Context context, XmlPullParser xmlPullParser) {
        int i;
        ConstraintSet constraintSet = new ConstraintSet();
        int attributeCount = xmlPullParser.getAttributeCount();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= attributeCount) {
                return;
            }
            String attributeName = xmlPullParser.getAttributeName(i3);
            String attributeValue = xmlPullParser.getAttributeValue(i3);
            if (attributeName != null && attributeValue != null && "id".equals(attributeName)) {
                if (attributeValue.contains(BridgeUtil.SPLIT_MARK)) {
                    i = context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName());
                } else {
                    i = -1;
                }
                int i4 = i;
                if (i == -1) {
                    if (attributeValue.length() > 1) {
                        i4 = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                        i4 = i;
                    }
                }
                constraintSet.load(context, xmlPullParser);
                this.f.put(i4, constraintSet);
                return;
            }
            i2 = i3 + 1;
        }
    }

    public boolean needsToChange(int i, float f, float f2) {
        int i2 = this.b;
        if (i2 != i) {
            return true;
        }
        State valueAt = i == -1 ? this.e.valueAt(0) : this.e.get(i2);
        return (this.f2260c == -1 || !valueAt.b.get(this.f2260c).a(f, f2)) && this.f2260c != valueAt.findMatch(f, f2);
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        this.g = constraintsChangedListener;
    }

    public void updateConstraints(int i, float f, float f2) {
        int findMatch;
        int i2 = this.b;
        if (i2 == i) {
            State valueAt = i == -1 ? this.e.valueAt(0) : this.e.get(i2);
            if ((this.f2260c == -1 || !valueAt.b.get(this.f2260c).a(f, f2)) && this.f2260c != (findMatch = valueAt.findMatch(f, f2))) {
                ConstraintSet constraintSet = findMatch == -1 ? this.f2259a : valueAt.b.get(findMatch).f;
                int i3 = findMatch == -1 ? valueAt.f2262c : valueAt.b.get(findMatch).e;
                if (constraintSet == null) {
                    return;
                }
                this.f2260c = findMatch;
                ConstraintsChangedListener constraintsChangedListener = this.g;
                if (constraintsChangedListener != null) {
                    constraintsChangedListener.preLayoutChange(-1, i3);
                }
                constraintSet.applyTo(this.d);
                ConstraintsChangedListener constraintsChangedListener2 = this.g;
                if (constraintsChangedListener2 != null) {
                    constraintsChangedListener2.postLayoutChange(-1, i3);
                    return;
                }
                return;
            }
            return;
        }
        this.b = i;
        State state = this.e.get(i);
        int findMatch2 = state.findMatch(f, f2);
        ConstraintSet constraintSet2 = findMatch2 == -1 ? state.d : state.b.get(findMatch2).f;
        int i4 = findMatch2 == -1 ? state.f2262c : state.b.get(findMatch2).e;
        if (constraintSet2 == null) {
            Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + i + ", dim =" + f + ", " + f2);
            return;
        }
        this.f2260c = findMatch2;
        ConstraintsChangedListener constraintsChangedListener3 = this.g;
        if (constraintsChangedListener3 != null) {
            constraintsChangedListener3.preLayoutChange(i, i4);
        }
        constraintSet2.applyTo(this.d);
        ConstraintsChangedListener constraintsChangedListener4 = this.g;
        if (constraintsChangedListener4 != null) {
            constraintsChangedListener4.postLayoutChange(i, i4);
        }
    }
}
