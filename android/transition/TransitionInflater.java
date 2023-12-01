package android.transition;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.ArrayMap;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.android.internal.R;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-9557208-dex2jar.jar:android/transition/TransitionInflater.class */
public class TransitionInflater {
    private static final Class<?>[] sConstructorSignature = {Context.class, AttributeSet.class};
    private static final ArrayMap<String, Constructor> sConstructors = new ArrayMap<>();
    private Context mContext;

    private TransitionInflater(Context context) {
        this.mContext = context;
    }

    private Object createCustom(AttributeSet attributeSet, Class cls, String str) {
        Object newInstance;
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        if (attributeValue == null) {
            throw new InflateException(str + " tag must have a 'class' attribute");
        }
        try {
            synchronized (sConstructors) {
                Constructor constructor = sConstructors.get(attributeValue);
                Constructor constructor2 = constructor;
                if (constructor == null) {
                    Class<? extends U> asSubclass = this.mContext.getClassLoader().loadClass(attributeValue).asSubclass(cls);
                    constructor2 = constructor;
                    if (asSubclass != 0) {
                        constructor2 = asSubclass.getConstructor(sConstructorSignature);
                        sConstructors.put(attributeValue, constructor2);
                    }
                }
                newInstance = constructor2.newInstance(this.mContext, attributeSet);
            }
            return newInstance;
        } catch (ClassNotFoundException e) {
            throw new InflateException("Could not instantiate " + cls + " class " + attributeValue, e);
        } catch (IllegalAccessException e2) {
            throw new InflateException("Could not instantiate " + cls + " class " + attributeValue, e2);
        } catch (InstantiationException e3) {
            throw new InflateException("Could not instantiate " + cls + " class " + attributeValue, e3);
        } catch (NoSuchMethodException e4) {
            throw new InflateException("Could not instantiate " + cls + " class " + attributeValue, e4);
        } catch (InvocationTargetException e5) {
            throw new InflateException("Could not instantiate " + cls + " class " + attributeValue, e5);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:77:0x0269, code lost:
        return r13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.transition.Transition createTransitionFromXml(org.xmlpull.v1.XmlPullParser r7, android.util.AttributeSet r8, android.transition.Transition r9) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 618
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.transition.TransitionInflater.createTransitionFromXml(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.transition.Transition):android.transition.Transition");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x008a, code lost:
        return r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.transition.TransitionManager createTransitionManagerFromXml(org.xmlpull.v1.XmlPullParser r6, android.util.AttributeSet r7, android.view.ViewGroup r8) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r5 = this;
            r0 = r6
            int r0 = r0.getDepth()
            r9 = r0
            r0 = 0
            r11 = r0
        Lb:
            r0 = r6
            int r0 = r0.next()
            r10 = r0
            r0 = r10
            r1 = 3
            if (r0 != r1) goto L24
            r0 = r6
            int r0 = r0.getDepth()
            r1 = r9
            if (r0 <= r1) goto L88
        L24:
            r0 = r10
            r1 = 1
            if (r0 == r1) goto L88
            r0 = r10
            r1 = 2
            if (r0 != r1) goto Lb
            r0 = r6
            java.lang.String r0 = r0.getName()
            r12 = r0
            r0 = r12
            java.lang.String r1 = "transitionManager"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L4e
            android.transition.TransitionManager r0 = new android.transition.TransitionManager
            r1 = r0
            r1.<init>()
            r11 = r0
            goto Lb
        L4e:
            r0 = r12
            java.lang.String r1 = "transition"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L68
            r0 = r11
            if (r0 == 0) goto L68
            r0 = r5
            r1 = r7
            r2 = r8
            r3 = r11
            r0.loadTransition(r1, r2, r3)
            goto Lb
        L68:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r2
            r3.<init>()
            java.lang.String r3 = "Unknown scene name: "
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r6
            java.lang.String r3 = r3.getName()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        L88:
            r0 = r11
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.transition.TransitionInflater.createTransitionManagerFromXml(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.ViewGroup):android.transition.TransitionManager");
    }

    public static TransitionInflater from(Context context) {
        return new TransitionInflater(context);
    }

    private void getTargetIds(XmlPullParser xmlPullParser, AttributeSet attributeSet, Transition transition) throws XmlPullParserException, IOException {
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
                TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, R.styleable.TransitionTarget);
                int resourceId = obtainStyledAttributes.getResourceId(1, 0);
                if (resourceId != 0) {
                    transition.addTarget(resourceId);
                } else {
                    int resourceId2 = obtainStyledAttributes.getResourceId(2, 0);
                    if (resourceId2 != 0) {
                        transition.excludeTarget(resourceId2, true);
                    } else {
                        String string = obtainStyledAttributes.getString(4);
                        if (string != null) {
                            transition.addTarget(string);
                        } else {
                            String string2 = obtainStyledAttributes.getString(5);
                            if (string2 != null) {
                                transition.excludeTarget(string2, true);
                            } else {
                                String string3 = obtainStyledAttributes.getString(3);
                                if (string3 != null) {
                                    try {
                                        transition.excludeTarget((Class) Class.forName(string3), true);
                                    } catch (ClassNotFoundException e) {
                                        throw new RuntimeException("Could not create " + string3, e);
                                    }
                                } else {
                                    String string4 = obtainStyledAttributes.getString(0);
                                    if (string4 != null) {
                                        transition.addTarget(Class.forName(string4));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void loadTransition(AttributeSet attributeSet, ViewGroup viewGroup, TransitionManager transitionManager) throws Resources.NotFoundException {
        Transition inflateTransition;
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, R.styleable.TransitionManager);
        int resourceId = obtainStyledAttributes.getResourceId(2, -1);
        int resourceId2 = obtainStyledAttributes.getResourceId(0, -1);
        Scene sceneForLayout = resourceId2 < 0 ? null : Scene.getSceneForLayout(viewGroup, resourceId2, this.mContext);
        int resourceId3 = obtainStyledAttributes.getResourceId(1, -1);
        Scene sceneForLayout2 = resourceId3 < 0 ? null : Scene.getSceneForLayout(viewGroup, resourceId3, this.mContext);
        if (resourceId >= 0 && (inflateTransition = inflateTransition(resourceId)) != null) {
            if (sceneForLayout2 == null) {
                throw new RuntimeException("No toScene for transition ID " + resourceId);
            }
            if (sceneForLayout == null) {
                transitionManager.setTransition(sceneForLayout2, inflateTransition);
            } else {
                transitionManager.setTransition(sceneForLayout, sceneForLayout2, inflateTransition);
            }
        }
        obtainStyledAttributes.recycle();
    }

    public Transition inflateTransition(int i) {
        XmlResourceParser xml = this.mContext.getResources().getXml(i);
        try {
            try {
                try {
                    return createTransitionFromXml(xml, Xml.asAttributeSet(xml), null);
                } catch (IOException e) {
                    InflateException inflateException = new InflateException(xml.getPositionDescription() + ": " + e.getMessage());
                    inflateException.initCause(e);
                    throw inflateException;
                }
            } catch (XmlPullParserException e2) {
                InflateException inflateException2 = new InflateException(e2.getMessage());
                inflateException2.initCause(e2);
                throw inflateException2;
            }
        } finally {
            xml.close();
        }
    }

    public TransitionManager inflateTransitionManager(int i, ViewGroup viewGroup) {
        XmlResourceParser xml = this.mContext.getResources().getXml(i);
        try {
            try {
                try {
                    return createTransitionManagerFromXml(xml, Xml.asAttributeSet(xml), viewGroup);
                } catch (IOException e) {
                    InflateException inflateException = new InflateException(xml.getPositionDescription() + ": " + e.getMessage());
                    inflateException.initCause(e);
                    throw inflateException;
                }
            } catch (XmlPullParserException e2) {
                InflateException inflateException2 = new InflateException(e2.getMessage());
                inflateException2.initCause(e2);
                throw inflateException2;
            }
        } finally {
            xml.close();
        }
    }
}
