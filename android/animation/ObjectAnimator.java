package android.animation;

import android.animation.ValueAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;
import java.lang.ref.WeakReference;

/* loaded from: source-9557208-dex2jar.jar:android/animation/ObjectAnimator.class */
public final class ObjectAnimator extends ValueAnimator {
    private static final boolean DBG = false;
    private static final String LOG_TAG = "ObjectAnimator";
    private boolean mAutoCancel = false;
    private Property mProperty;
    private String mPropertyName;
    private WeakReference<Object> mTarget;

    public ObjectAnimator() {
    }

    private <T> ObjectAnimator(T t, Property<T, ?> property) {
        setTarget(t);
        setProperty(property);
    }

    private ObjectAnimator(Object obj, String str) {
        setTarget(obj);
        setPropertyName(str);
    }

    private boolean hasSameTargetAndProperties(Animator animator) {
        if (!(animator instanceof ObjectAnimator)) {
            return false;
        }
        PropertyValuesHolder[] values = ((ObjectAnimator) animator).getValues();
        if (((ObjectAnimator) animator).getTarget() != getTarget() || this.mValues.length != values.length) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mValues.length) {
                return true;
            }
            PropertyValuesHolder propertyValuesHolder = this.mValues[i2];
            PropertyValuesHolder propertyValuesHolder2 = values[i2];
            if (propertyValuesHolder.getPropertyName() == null || !propertyValuesHolder.getPropertyName().equals(propertyValuesHolder2.getPropertyName())) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public static <T> ObjectAnimator ofArgb(T t, Property<T, Integer> property, int... iArr) {
        ObjectAnimator ofInt = ofInt(t, property, iArr);
        ofInt.setEvaluator(ArgbEvaluator.getInstance());
        return ofInt;
    }

    public static ObjectAnimator ofArgb(Object obj, String str, int... iArr) {
        ObjectAnimator ofInt = ofInt(obj, str, iArr);
        ofInt.setEvaluator(ArgbEvaluator.getInstance());
        return ofInt;
    }

    public static <T> ObjectAnimator ofFloat(T t, Property<T, Float> property, Property<T, Float> property2, Path path) {
        PathKeyframes ofPath = KeyframeSet.ofPath(path);
        return ofPropertyValuesHolder(t, PropertyValuesHolder.ofKeyframes(property, ofPath.createXFloatKeyframes()), PropertyValuesHolder.ofKeyframes(property2, ofPath.createYFloatKeyframes()));
    }

    public static <T> ObjectAnimator ofFloat(T t, Property<T, Float> property, float... fArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator(t, property);
        objectAnimator.setFloatValues(fArr);
        return objectAnimator;
    }

    public static ObjectAnimator ofFloat(Object obj, String str, String str2, Path path) {
        PathKeyframes ofPath = KeyframeSet.ofPath(path);
        return ofPropertyValuesHolder(obj, PropertyValuesHolder.ofKeyframes(str, ofPath.createXFloatKeyframes()), PropertyValuesHolder.ofKeyframes(str2, ofPath.createYFloatKeyframes()));
    }

    public static ObjectAnimator ofFloat(Object obj, String str, float... fArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator(obj, str);
        objectAnimator.setFloatValues(fArr);
        return objectAnimator;
    }

    public static <T> ObjectAnimator ofInt(T t, Property<T, Integer> property, Property<T, Integer> property2, Path path) {
        PathKeyframes ofPath = KeyframeSet.ofPath(path);
        return ofPropertyValuesHolder(t, PropertyValuesHolder.ofKeyframes(property, ofPath.createXIntKeyframes()), PropertyValuesHolder.ofKeyframes(property2, ofPath.createYIntKeyframes()));
    }

    public static <T> ObjectAnimator ofInt(T t, Property<T, Integer> property, int... iArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator(t, property);
        objectAnimator.setIntValues(iArr);
        return objectAnimator;
    }

    public static ObjectAnimator ofInt(Object obj, String str, String str2, Path path) {
        PathKeyframes ofPath = KeyframeSet.ofPath(path);
        return ofPropertyValuesHolder(obj, PropertyValuesHolder.ofKeyframes(str, ofPath.createXIntKeyframes()), PropertyValuesHolder.ofKeyframes(str2, ofPath.createYIntKeyframes()));
    }

    public static ObjectAnimator ofInt(Object obj, String str, int... iArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator(obj, str);
        objectAnimator.setIntValues(iArr);
        return objectAnimator;
    }

    public static <T> ObjectAnimator ofMultiFloat(Object obj, String str, TypeConverter<T, float[]> typeConverter, TypeEvaluator<T> typeEvaluator, T... tArr) {
        return ofPropertyValuesHolder(obj, PropertyValuesHolder.ofMultiFloat(str, typeConverter, typeEvaluator, tArr));
    }

    public static ObjectAnimator ofMultiFloat(Object obj, String str, Path path) {
        return ofPropertyValuesHolder(obj, PropertyValuesHolder.ofMultiFloat(str, path));
    }

    public static ObjectAnimator ofMultiFloat(Object obj, String str, float[][] fArr) {
        return ofPropertyValuesHolder(obj, PropertyValuesHolder.ofMultiFloat(str, fArr));
    }

    public static <T> ObjectAnimator ofMultiInt(Object obj, String str, TypeConverter<T, int[]> typeConverter, TypeEvaluator<T> typeEvaluator, T... tArr) {
        return ofPropertyValuesHolder(obj, PropertyValuesHolder.ofMultiInt(str, typeConverter, typeEvaluator, tArr));
    }

    public static ObjectAnimator ofMultiInt(Object obj, String str, Path path) {
        return ofPropertyValuesHolder(obj, PropertyValuesHolder.ofMultiInt(str, path));
    }

    public static ObjectAnimator ofMultiInt(Object obj, String str, int[][] iArr) {
        return ofPropertyValuesHolder(obj, PropertyValuesHolder.ofMultiInt(str, iArr));
    }

    public static <T, V, P> ObjectAnimator ofObject(T t, Property<T, P> property, TypeConverter<V, P> typeConverter, TypeEvaluator<V> typeEvaluator, V... vArr) {
        return ofPropertyValuesHolder(t, PropertyValuesHolder.ofObject(property, typeConverter, typeEvaluator, vArr));
    }

    public static <T, V> ObjectAnimator ofObject(T t, Property<T, V> property, TypeConverter<PointF, V> typeConverter, Path path) {
        return ofPropertyValuesHolder(t, PropertyValuesHolder.ofObject(property, typeConverter, path));
    }

    public static <T, V> ObjectAnimator ofObject(T t, Property<T, V> property, TypeEvaluator<V> typeEvaluator, V... vArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator(t, property);
        objectAnimator.setObjectValues(vArr);
        objectAnimator.setEvaluator(typeEvaluator);
        return objectAnimator;
    }

    public static ObjectAnimator ofObject(Object obj, String str, TypeConverter<PointF, ?> typeConverter, Path path) {
        return ofPropertyValuesHolder(obj, PropertyValuesHolder.ofObject(str, typeConverter, path));
    }

    public static ObjectAnimator ofObject(Object obj, String str, TypeEvaluator typeEvaluator, Object... objArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator(obj, str);
        objectAnimator.setObjectValues(objArr);
        objectAnimator.setEvaluator(typeEvaluator);
        return objectAnimator;
    }

    public static ObjectAnimator ofPropertyValuesHolder(Object obj, PropertyValuesHolder... propertyValuesHolderArr) {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        objectAnimator.setTarget(obj);
        objectAnimator.setValues(propertyValuesHolderArr);
        return objectAnimator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.animation.ValueAnimator
    public void animateValue(float f) {
        Object target = getTarget();
        if (this.mTarget != null && target == null) {
            cancel();
            return;
        }
        super.animateValue(f);
        int length = this.mValues.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            this.mValues[i2].setAnimatedValue(target);
            i = i2 + 1;
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    /* renamed from: clone */
    public ObjectAnimator mo53clone() {
        return (ObjectAnimator) super.mo53clone();
    }

    @Override // android.animation.ValueAnimator
    String getNameForTrace() {
        return "animator:" + getPropertyName();
    }

    public String getPropertyName() {
        String str;
        if (this.mPropertyName != null) {
            str = this.mPropertyName;
        } else if (this.mProperty != null) {
            return this.mProperty.getName();
        } else {
            str = null;
            if (this.mValues != null) {
                str = null;
                if (this.mValues.length > 0) {
                    int i = 0;
                    String str2 = null;
                    while (true) {
                        str = str2;
                        if (i >= this.mValues.length) {
                            break;
                        }
                        str2 = (i == 0 ? "" : str2 + ",") + this.mValues[i].getPropertyName();
                        i++;
                    }
                }
            }
        }
        return str;
    }

    public Object getTarget() {
        if (this.mTarget == null) {
            return null;
        }
        return this.mTarget.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.animation.ValueAnimator
    public void initAnimation() {
        if (this.mInitialized) {
            return;
        }
        Object target = getTarget();
        if (target != null) {
            int length = this.mValues.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                this.mValues[i2].setupSetterAndGetter(target);
                i = i2 + 1;
            }
        }
        super.initAnimation();
    }

    public void setAutoCancel(boolean z) {
        this.mAutoCancel = z;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public ObjectAnimator setDuration(long j) {
        super.setDuration(j);
        return this;
    }

    @Override // android.animation.ValueAnimator
    public void setFloatValues(float... fArr) {
        if (this.mValues != null && this.mValues.length != 0) {
            super.setFloatValues(fArr);
        } else if (this.mProperty != null) {
            setValues(PropertyValuesHolder.ofFloat(this.mProperty, fArr));
        } else {
            setValues(PropertyValuesHolder.ofFloat(this.mPropertyName, fArr));
        }
    }

    @Override // android.animation.ValueAnimator
    public void setIntValues(int... iArr) {
        if (this.mValues != null && this.mValues.length != 0) {
            super.setIntValues(iArr);
        } else if (this.mProperty != null) {
            setValues(PropertyValuesHolder.ofInt(this.mProperty, iArr));
        } else {
            setValues(PropertyValuesHolder.ofInt(this.mPropertyName, iArr));
        }
    }

    @Override // android.animation.ValueAnimator
    public void setObjectValues(Object... objArr) {
        if (this.mValues != null && this.mValues.length != 0) {
            super.setObjectValues(objArr);
        } else if (this.mProperty != null) {
            setValues(PropertyValuesHolder.ofObject(this.mProperty, (TypeEvaluator) null, objArr));
        } else {
            setValues(PropertyValuesHolder.ofObject(this.mPropertyName, (TypeEvaluator) null, objArr));
        }
    }

    public void setProperty(Property property) {
        if (this.mValues != null) {
            PropertyValuesHolder propertyValuesHolder = this.mValues[0];
            String propertyName = propertyValuesHolder.getPropertyName();
            propertyValuesHolder.setProperty(property);
            this.mValuesMap.remove(propertyName);
            this.mValuesMap.put(this.mPropertyName, propertyValuesHolder);
        }
        if (this.mProperty != null) {
            this.mPropertyName = property.getName();
        }
        this.mProperty = property;
        this.mInitialized = false;
    }

    public void setPropertyName(String str) {
        if (this.mValues != null) {
            PropertyValuesHolder propertyValuesHolder = this.mValues[0];
            String propertyName = propertyValuesHolder.getPropertyName();
            propertyValuesHolder.setPropertyName(str);
            this.mValuesMap.remove(propertyName);
            this.mValuesMap.put(str, propertyValuesHolder);
        }
        this.mPropertyName = str;
        this.mInitialized = false;
    }

    @Override // android.animation.Animator
    public void setTarget(Object obj) {
        if (getTarget() != obj) {
            if (isStarted()) {
                cancel();
            }
            this.mTarget = obj == null ? null : new WeakReference<>(obj);
            this.mInitialized = false;
        }
    }

    @Override // android.animation.Animator
    public void setupEndValues() {
        initAnimation();
        Object target = getTarget();
        if (target == null) {
            return;
        }
        int length = this.mValues.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            this.mValues[i2].setupEndValue(target);
            i = i2 + 1;
        }
    }

    @Override // android.animation.Animator
    public void setupStartValues() {
        initAnimation();
        Object target = getTarget();
        if (target == null) {
            return;
        }
        int length = this.mValues.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            this.mValues[i2].setupStartValue(target);
            i = i2 + 1;
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void start() {
        ValueAnimator.AnimationHandler animationHandler = sAnimationHandler.get();
        if (animationHandler != null) {
            int size = animationHandler.mAnimations.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    break;
                }
                if (animationHandler.mAnimations.get(i) instanceof ObjectAnimator) {
                    ObjectAnimator objectAnimator = (ObjectAnimator) animationHandler.mAnimations.get(i);
                    if (objectAnimator.mAutoCancel && hasSameTargetAndProperties(objectAnimator)) {
                        objectAnimator.cancel();
                    }
                }
                size = i;
            }
            int size2 = animationHandler.mPendingAnimations.size();
            while (true) {
                int i2 = size2 - 1;
                if (i2 < 0) {
                    break;
                }
                if (animationHandler.mPendingAnimations.get(i2) instanceof ObjectAnimator) {
                    ObjectAnimator objectAnimator2 = (ObjectAnimator) animationHandler.mPendingAnimations.get(i2);
                    if (objectAnimator2.mAutoCancel && hasSameTargetAndProperties(objectAnimator2)) {
                        objectAnimator2.cancel();
                    }
                }
                size2 = i2;
            }
            int size3 = animationHandler.mDelayedAnims.size();
            while (true) {
                int i3 = size3 - 1;
                if (i3 < 0) {
                    break;
                }
                if (animationHandler.mDelayedAnims.get(i3) instanceof ObjectAnimator) {
                    ObjectAnimator objectAnimator3 = (ObjectAnimator) animationHandler.mDelayedAnims.get(i3);
                    if (objectAnimator3.mAutoCancel && hasSameTargetAndProperties(objectAnimator3)) {
                        objectAnimator3.cancel();
                    }
                }
                size3 = i3;
            }
        }
        super.start();
    }

    @Override // android.animation.ValueAnimator
    public String toString() {
        String str = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " + getTarget();
        String str2 = str;
        if (this.mValues != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                str2 = str;
                if (i2 >= this.mValues.length) {
                    break;
                }
                str = str + "\n    " + this.mValues[i2].toString();
                i = i2 + 1;
            }
        }
        return str2;
    }
}
