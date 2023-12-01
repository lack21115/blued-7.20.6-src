package androidx.transition;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.res.TypedArrayUtils;
import com.opos.process.bridge.provider.ProcessBridgeProvider;
import java.io.IOException;
import java.lang.reflect.Constructor;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8756600-dex2jar.jar:androidx/transition/TransitionInflater.class */
public class TransitionInflater {

    /* renamed from: a  reason: collision with root package name */
    private static final Class<?>[] f3425a = {Context.class, AttributeSet.class};
    private static final ArrayMap<String, Constructor<?>> b = new ArrayMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final Context f3426c;

    private TransitionInflater(Context context) {
        this.f3426c = context;
    }

    /* JADX WARN: Code restructure failed: missing block: B:89:0x0281, code lost:
        return r14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private androidx.transition.Transition a(org.xmlpull.v1.XmlPullParser r7, android.util.AttributeSet r8, androidx.transition.Transition r9) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 642
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.TransitionInflater.a(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, androidx.transition.Transition):androidx.transition.Transition");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0094, code lost:
        return r12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private androidx.transition.TransitionManager a(org.xmlpull.v1.XmlPullParser r7, android.util.AttributeSet r8, android.view.ViewGroup r9) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r6 = this;
            r0 = r7
            int r0 = r0.getDepth()
            r10 = r0
            r0 = 0
            r12 = r0
        Lb:
            r0 = r7
            int r0 = r0.next()
            r11 = r0
            r0 = r11
            r1 = 3
            if (r0 != r1) goto L24
            r0 = r7
            int r0 = r0.getDepth()
            r1 = r10
            if (r0 <= r1) goto L92
        L24:
            r0 = r11
            r1 = 1
            if (r0 == r1) goto L92
            r0 = r11
            r1 = 2
            if (r0 == r1) goto L33
            goto Lb
        L33:
            r0 = r7
            java.lang.String r0 = r0.getName()
            r13 = r0
            r0 = r13
            java.lang.String r1 = "transitionManager"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L51
            androidx.transition.TransitionManager r0 = new androidx.transition.TransitionManager
            r1 = r0
            r1.<init>()
            r12 = r0
            goto Lb
        L51:
            r0 = r13
            java.lang.String r1 = "transition"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L6c
            r0 = r12
            if (r0 == 0) goto L6c
            r0 = r6
            r1 = r8
            r2 = r7
            r3 = r9
            r4 = r12
            r0.a(r1, r2, r3, r4)
            goto Lb
        L6c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r8 = r0
            r0 = r8
            java.lang.String r1 = "Unknown scene name: "
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r8
            r1 = r7
            java.lang.String r1 = r1.getName()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r1 = r0
            r2 = r8
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        L92:
            r0 = r12
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.TransitionInflater.a(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.ViewGroup):androidx.transition.TransitionManager");
    }

    private Object a(AttributeSet attributeSet, Class<?> cls, String str) {
        Object newInstance;
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        if (attributeValue == null) {
            throw new InflateException(str + " tag must have a 'class' attribute");
        }
        try {
            synchronized (b) {
                Constructor<?> constructor = b.get(attributeValue);
                Constructor<?> constructor2 = constructor;
                if (constructor == null) {
                    Class<? extends U> asSubclass = Class.forName(attributeValue, false, this.f3426c.getClassLoader()).asSubclass(cls);
                    constructor2 = constructor;
                    if (asSubclass != 0) {
                        constructor2 = asSubclass.getConstructor(f3425a);
                        constructor2.setAccessible(true);
                        b.put(attributeValue, constructor2);
                    }
                }
                newInstance = constructor2.newInstance(this.f3426c, attributeSet);
            }
            return newInstance;
        } catch (Exception e) {
            throw new InflateException("Could not instantiate " + cls + " class " + attributeValue, e);
        }
    }

    private void a(AttributeSet attributeSet, XmlPullParser xmlPullParser, ViewGroup viewGroup, TransitionManager transitionManager) throws Resources.NotFoundException {
        Transition inflateTransition;
        TypedArray obtainStyledAttributes = this.f3426c.obtainStyledAttributes(attributeSet, Styleable.b);
        int namedResourceId = TypedArrayUtils.getNamedResourceId(obtainStyledAttributes, xmlPullParser, "transition", 2, -1);
        int namedResourceId2 = TypedArrayUtils.getNamedResourceId(obtainStyledAttributes, xmlPullParser, "fromScene", 0, -1);
        Scene sceneForLayout = namedResourceId2 < 0 ? null : Scene.getSceneForLayout(viewGroup, namedResourceId2, this.f3426c);
        int namedResourceId3 = TypedArrayUtils.getNamedResourceId(obtainStyledAttributes, xmlPullParser, "toScene", 1, -1);
        Scene sceneForLayout2 = namedResourceId3 < 0 ? null : Scene.getSceneForLayout(viewGroup, namedResourceId3, this.f3426c);
        if (namedResourceId >= 0 && (inflateTransition = inflateTransition(namedResourceId)) != null) {
            if (sceneForLayout2 == null) {
                throw new RuntimeException("No toScene for transition ID " + namedResourceId);
            } else if (sceneForLayout == null) {
                transitionManager.setTransition(sceneForLayout2, inflateTransition);
            } else {
                transitionManager.setTransition(sceneForLayout, sceneForLayout2, inflateTransition);
            }
        }
        obtainStyledAttributes.recycle();
    }

    private void b(XmlPullParser xmlPullParser, AttributeSet attributeSet, Transition transition) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                return;
            }
            if (next == 2) {
                if (!xmlPullParser.getName().equals(TypedValues.AttributesType.S_TARGET)) {
                    throw new RuntimeException("Unknown scene name: " + xmlPullParser.getName());
                }
                TypedArray obtainStyledAttributes = this.f3426c.obtainStyledAttributes(attributeSet, Styleable.f3419a);
                int namedResourceId = TypedArrayUtils.getNamedResourceId(obtainStyledAttributes, xmlPullParser, "targetId", 1, 0);
                if (namedResourceId != 0) {
                    transition.addTarget(namedResourceId);
                } else {
                    int namedResourceId2 = TypedArrayUtils.getNamedResourceId(obtainStyledAttributes, xmlPullParser, "excludeId", 2, 0);
                    if (namedResourceId2 != 0) {
                        transition.excludeTarget(namedResourceId2, true);
                    } else {
                        String namedString = TypedArrayUtils.getNamedString(obtainStyledAttributes, xmlPullParser, "targetName", 4);
                        if (namedString != null) {
                            transition.addTarget(namedString);
                        } else {
                            String namedString2 = TypedArrayUtils.getNamedString(obtainStyledAttributes, xmlPullParser, "excludeName", 5);
                            if (namedString2 != null) {
                                transition.excludeTarget(namedString2, true);
                            } else {
                                String namedString3 = TypedArrayUtils.getNamedString(obtainStyledAttributes, xmlPullParser, "excludeClass", 3);
                                if (namedString3 != null) {
                                    try {
                                        transition.excludeTarget(Class.forName(namedString3), true);
                                    } catch (ClassNotFoundException e) {
                                        obtainStyledAttributes.recycle();
                                        throw new RuntimeException("Could not create " + namedString3, e);
                                    }
                                } else {
                                    String namedString4 = TypedArrayUtils.getNamedString(obtainStyledAttributes, xmlPullParser, ProcessBridgeProvider.KEY_TARGET_CLASS, 0);
                                    if (namedString4 != null) {
                                        transition.addTarget(Class.forName(namedString4));
                                    }
                                }
                            }
                        }
                    }
                }
                obtainStyledAttributes.recycle();
            }
        }
    }

    public static TransitionInflater from(Context context) {
        return new TransitionInflater(context);
    }

    public Transition inflateTransition(int i) {
        XmlResourceParser xml = this.f3426c.getResources().getXml(i);
        try {
            try {
                Transition a2 = a(xml, Xml.asAttributeSet(xml), (Transition) null);
                xml.close();
                return a2;
            } catch (IOException e) {
                throw new InflateException(xml.getPositionDescription() + ": " + e.getMessage(), e);
            } catch (XmlPullParserException e2) {
                throw new InflateException(e2.getMessage(), e2);
            }
        } catch (Throwable th) {
            xml.close();
            throw th;
        }
    }

    public TransitionManager inflateTransitionManager(int i, ViewGroup viewGroup) {
        XmlResourceParser xml = this.f3426c.getResources().getXml(i);
        try {
            try {
                TransitionManager a2 = a(xml, Xml.asAttributeSet(xml), viewGroup);
                xml.close();
                return a2;
            } catch (IOException e) {
                InflateException inflateException = new InflateException(xml.getPositionDescription() + ": " + e.getMessage());
                inflateException.initCause(e);
                throw inflateException;
            } catch (XmlPullParserException e2) {
                InflateException inflateException2 = new InflateException(e2.getMessage());
                inflateException2.initCause(e2);
                throw inflateException2;
            }
        } catch (Throwable th) {
            xml.close();
            throw th;
        }
    }
}
