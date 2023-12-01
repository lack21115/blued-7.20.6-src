package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/widget/KeyFrames.class */
public class KeyFrames {
    public static final int UNSET = -1;

    /* renamed from: a  reason: collision with root package name */
    static HashMap<String, Constructor<? extends Key>> f2125a;
    private HashMap<Integer, ArrayList<Key>> b = new HashMap<>();

    static {
        HashMap<String, Constructor<? extends Key>> hashMap = new HashMap<>();
        f2125a = hashMap;
        try {
            hashMap.put("KeyAttribute", KeyAttributes.class.getConstructor(new Class[0]));
            f2125a.put(TypedValues.PositionType.NAME, KeyPosition.class.getConstructor(new Class[0]));
            f2125a.put(TypedValues.CycleType.NAME, KeyCycle.class.getConstructor(new Class[0]));
            f2125a.put("KeyTimeCycle", KeyTimeCycle.class.getConstructor(new Class[0]));
            f2125a.put(TypedValues.TriggerType.NAME, KeyTrigger.class.getConstructor(new Class[0]));
        } catch (NoSuchMethodException e) {
            Log.e("KeyFrames", "unable to load", e);
        }
    }

    public KeyFrames() {
    }

    public KeyFrames(Context context, XmlPullParser xmlPullParser) {
        Key key;
        Exception e;
        Constructor<? extends Key> constructor;
        Key key2 = null;
        try {
            int eventType = xmlPullParser.getEventType();
            while (eventType != 1) {
                if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    if (f2125a.containsKey(name)) {
                        try {
                            constructor = f2125a.get(name);
                        } catch (Exception e2) {
                            e = e2;
                        }
                        if (constructor == null) {
                            throw new NullPointerException("Keymaker for " + name + " not found");
                            break;
                        }
                        Key newInstance = constructor.newInstance(new Object[0]);
                        try {
                            newInstance.load(context, Xml.asAttributeSet(xmlPullParser));
                            addKey(newInstance);
                            key2 = newInstance;
                        } catch (Exception e3) {
                            e = e3;
                            key2 = newInstance;
                            Log.e("KeyFrames", "unable to create ", e);
                            key = key2;
                            eventType = xmlPullParser.next();
                            key2 = key;
                        }
                        key = key2;
                    } else if (name.equalsIgnoreCase(ViewTransition.CUSTOM_ATTRIBUTE)) {
                        key = key2;
                        if (key2 != null) {
                            key = key2;
                            if (key2.e != null) {
                                ConstraintAttribute.parse(context, xmlPullParser, key2.e);
                                key = key2;
                            }
                        }
                    } else {
                        key = key2;
                        if (name.equalsIgnoreCase(ViewTransition.CUSTOM_METHOD)) {
                            key = key2;
                            if (key2 != null) {
                                key = key2;
                                if (key2.e != null) {
                                    ConstraintAttribute.parse(context, xmlPullParser, key2.e);
                                    key = key2;
                                }
                            }
                        }
                    }
                } else if (eventType != 3) {
                    key = key2;
                } else {
                    key = key2;
                    if (ViewTransition.KEY_FRAME_SET_TAG.equals(xmlPullParser.getName())) {
                        return;
                    }
                }
                eventType = xmlPullParser.next();
                key2 = key;
            }
        } catch (IOException e4) {
            e4.printStackTrace();
        } catch (XmlPullParserException e5) {
            e5.printStackTrace();
        }
    }

    public void addAllFrames(MotionController motionController) {
        ArrayList<Key> arrayList = this.b.get(-1);
        if (arrayList != null) {
            motionController.a(arrayList);
        }
    }

    public void addFrames(MotionController motionController) {
        ArrayList<Key> arrayList = this.b.get(Integer.valueOf(motionController.f2132c));
        if (arrayList != null) {
            motionController.a(arrayList);
        }
        ArrayList<Key> arrayList2 = this.b.get(-1);
        if (arrayList2 != null) {
            Iterator<Key> it = arrayList2.iterator();
            while (it.hasNext()) {
                Key next = it.next();
                if (next.a(((ConstraintLayout.LayoutParams) motionController.b.getLayoutParams()).constraintTag)) {
                    motionController.addKey(next);
                }
            }
        }
    }

    public void addKey(Key key) {
        if (!this.b.containsKey(Integer.valueOf(key.b))) {
            this.b.put(Integer.valueOf(key.b), new ArrayList<>());
        }
        ArrayList<Key> arrayList = this.b.get(Integer.valueOf(key.b));
        if (arrayList != null) {
            arrayList.add(key);
        }
    }

    public ArrayList<Key> getKeyFramesForView(int i) {
        return this.b.get(Integer.valueOf(i));
    }

    public Set<Integer> getKeys() {
        return this.b.keySet();
    }
}
