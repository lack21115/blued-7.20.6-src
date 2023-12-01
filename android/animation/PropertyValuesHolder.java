package android.animation;

import android.animation.Keyframes;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.FloatProperty;
import android.util.IntProperty;
import android.util.Log;
import android.util.Property;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/animation/PropertyValuesHolder.class */
public class PropertyValuesHolder implements Cloneable {
    private Object mAnimatedValue;
    private TypeConverter mConverter;
    private TypeEvaluator mEvaluator;
    private Method mGetter;
    Keyframes mKeyframes;
    protected Property mProperty;
    String mPropertyName;
    Method mSetter;
    final Object[] mTmpValueArray;
    Class mValueType;
    private static final TypeEvaluator sIntEvaluator = new IntEvaluator();
    private static final TypeEvaluator sFloatEvaluator = new FloatEvaluator();
    private static Class[] FLOAT_VARIANTS = {Float.TYPE, Float.class, Double.TYPE, Integer.TYPE, Double.class, Integer.class};
    private static Class[] INTEGER_VARIANTS = {Integer.TYPE, Integer.class, Float.TYPE, Double.TYPE, Float.class, Double.class};
    private static Class[] DOUBLE_VARIANTS = {Double.TYPE, Double.class, Float.TYPE, Integer.TYPE, Float.class, Integer.class};
    private static final HashMap<Class, HashMap<String, Method>> sSetterPropertyMap = new HashMap<>();
    private static final HashMap<Class, HashMap<String, Method>> sGetterPropertyMap = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/animation/PropertyValuesHolder$FloatPropertyValuesHolder.class */
    public static class FloatPropertyValuesHolder extends PropertyValuesHolder {
        private static final HashMap<Class, HashMap<String, Long>> sJNISetterPropertyMap = new HashMap<>();
        float mFloatAnimatedValue;
        Keyframes.FloatKeyframes mFloatKeyframes;
        private FloatProperty mFloatProperty;
        long mJniSetter;

        public FloatPropertyValuesHolder(Property property, Keyframes.FloatKeyframes floatKeyframes) {
            super(property);
            this.mValueType = Float.TYPE;
            this.mKeyframes = floatKeyframes;
            this.mFloatKeyframes = floatKeyframes;
            if (property instanceof FloatProperty) {
                this.mFloatProperty = (FloatProperty) this.mProperty;
            }
        }

        public FloatPropertyValuesHolder(Property property, float... fArr) {
            super(property);
            setFloatValues(fArr);
            if (property instanceof FloatProperty) {
                this.mFloatProperty = (FloatProperty) this.mProperty;
            }
        }

        public FloatPropertyValuesHolder(String str, Keyframes.FloatKeyframes floatKeyframes) {
            super(str);
            this.mValueType = Float.TYPE;
            this.mKeyframes = floatKeyframes;
            this.mFloatKeyframes = floatKeyframes;
        }

        public FloatPropertyValuesHolder(String str, float... fArr) {
            super(str);
            setFloatValues(fArr);
        }

        @Override // android.animation.PropertyValuesHolder
        void calculateValue(float f) {
            this.mFloatAnimatedValue = this.mFloatKeyframes.getFloatValue(f);
        }

        @Override // android.animation.PropertyValuesHolder
        /* renamed from: clone */
        public FloatPropertyValuesHolder mo64clone() {
            FloatPropertyValuesHolder floatPropertyValuesHolder = (FloatPropertyValuesHolder) super.mo64clone();
            floatPropertyValuesHolder.mFloatKeyframes = (Keyframes.FloatKeyframes) floatPropertyValuesHolder.mKeyframes;
            return floatPropertyValuesHolder;
        }

        @Override // android.animation.PropertyValuesHolder
        Object getAnimatedValue() {
            return Float.valueOf(this.mFloatAnimatedValue);
        }

        @Override // android.animation.PropertyValuesHolder
        void setAnimatedValue(Object obj) {
            if (this.mFloatProperty != null) {
                this.mFloatProperty.setValue(obj, this.mFloatAnimatedValue);
            } else if (this.mProperty != null) {
                this.mProperty.set(obj, Float.valueOf(this.mFloatAnimatedValue));
            } else if (this.mJniSetter != 0) {
                PropertyValuesHolder.nCallFloatMethod(obj, this.mJniSetter, this.mFloatAnimatedValue);
            } else if (this.mSetter != null) {
                try {
                    this.mTmpValueArray[0] = Float.valueOf(this.mFloatAnimatedValue);
                    this.mSetter.invoke(obj, this.mTmpValueArray);
                } catch (IllegalAccessException e) {
                    Log.e("PropertyValuesHolder", e.toString());
                } catch (InvocationTargetException e2) {
                    Log.e("PropertyValuesHolder", e2.toString());
                }
            }
        }

        @Override // android.animation.PropertyValuesHolder
        public void setFloatValues(float... fArr) {
            super.setFloatValues(fArr);
            this.mFloatKeyframes = (Keyframes.FloatKeyframes) this.mKeyframes;
        }

        @Override // android.animation.PropertyValuesHolder
        void setupSetter(Class cls) {
            if (this.mProperty != null) {
                return;
            }
            synchronized (sJNISetterPropertyMap) {
                HashMap<String, Long> hashMap = sJNISetterPropertyMap.get(cls);
                boolean z = false;
                if (hashMap != null) {
                    boolean containsKey = hashMap.containsKey(this.mPropertyName);
                    z = containsKey;
                    if (containsKey) {
                        Long l = hashMap.get(this.mPropertyName);
                        z = containsKey;
                        if (l != null) {
                            this.mJniSetter = l.longValue();
                            z = containsKey;
                        }
                    }
                }
                if (!z) {
                    try {
                        this.mJniSetter = PropertyValuesHolder.nGetFloatMethod(cls, getMethodName("set", this.mPropertyName));
                    } catch (NoSuchMethodError e) {
                    }
                    HashMap<String, Long> hashMap2 = hashMap;
                    if (hashMap == null) {
                        hashMap2 = new HashMap<>();
                        sJNISetterPropertyMap.put(cls, hashMap2);
                    }
                    hashMap2.put(this.mPropertyName, Long.valueOf(this.mJniSetter));
                }
            }
            if (this.mJniSetter == 0) {
                super.setupSetter(cls);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/animation/PropertyValuesHolder$IntPropertyValuesHolder.class */
    public static class IntPropertyValuesHolder extends PropertyValuesHolder {
        private static final HashMap<Class, HashMap<String, Long>> sJNISetterPropertyMap = new HashMap<>();
        int mIntAnimatedValue;
        Keyframes.IntKeyframes mIntKeyframes;
        private IntProperty mIntProperty;
        long mJniSetter;

        public IntPropertyValuesHolder(Property property, Keyframes.IntKeyframes intKeyframes) {
            super(property);
            this.mValueType = Integer.TYPE;
            this.mKeyframes = intKeyframes;
            this.mIntKeyframes = intKeyframes;
            if (property instanceof IntProperty) {
                this.mIntProperty = (IntProperty) this.mProperty;
            }
        }

        public IntPropertyValuesHolder(Property property, int... iArr) {
            super(property);
            setIntValues(iArr);
            if (property instanceof IntProperty) {
                this.mIntProperty = (IntProperty) this.mProperty;
            }
        }

        public IntPropertyValuesHolder(String str, Keyframes.IntKeyframes intKeyframes) {
            super(str);
            this.mValueType = Integer.TYPE;
            this.mKeyframes = intKeyframes;
            this.mIntKeyframes = intKeyframes;
        }

        public IntPropertyValuesHolder(String str, int... iArr) {
            super(str);
            setIntValues(iArr);
        }

        @Override // android.animation.PropertyValuesHolder
        void calculateValue(float f) {
            this.mIntAnimatedValue = this.mIntKeyframes.getIntValue(f);
        }

        @Override // android.animation.PropertyValuesHolder
        /* renamed from: clone */
        public IntPropertyValuesHolder mo64clone() {
            IntPropertyValuesHolder intPropertyValuesHolder = (IntPropertyValuesHolder) super.mo64clone();
            intPropertyValuesHolder.mIntKeyframes = (Keyframes.IntKeyframes) intPropertyValuesHolder.mKeyframes;
            return intPropertyValuesHolder;
        }

        @Override // android.animation.PropertyValuesHolder
        Object getAnimatedValue() {
            return Integer.valueOf(this.mIntAnimatedValue);
        }

        @Override // android.animation.PropertyValuesHolder
        void setAnimatedValue(Object obj) {
            if (this.mIntProperty != null) {
                this.mIntProperty.setValue(obj, this.mIntAnimatedValue);
            } else if (this.mProperty != null) {
                this.mProperty.set(obj, Integer.valueOf(this.mIntAnimatedValue));
            } else if (this.mJniSetter != 0) {
                PropertyValuesHolder.nCallIntMethod(obj, this.mJniSetter, this.mIntAnimatedValue);
            } else if (this.mSetter != null) {
                try {
                    this.mTmpValueArray[0] = Integer.valueOf(this.mIntAnimatedValue);
                    this.mSetter.invoke(obj, this.mTmpValueArray);
                } catch (IllegalAccessException e) {
                    Log.e("PropertyValuesHolder", e.toString());
                } catch (InvocationTargetException e2) {
                    Log.e("PropertyValuesHolder", e2.toString());
                }
            }
        }

        @Override // android.animation.PropertyValuesHolder
        public void setIntValues(int... iArr) {
            super.setIntValues(iArr);
            this.mIntKeyframes = (Keyframes.IntKeyframes) this.mKeyframes;
        }

        @Override // android.animation.PropertyValuesHolder
        void setupSetter(Class cls) {
            if (this.mProperty != null) {
                return;
            }
            synchronized (sJNISetterPropertyMap) {
                HashMap<String, Long> hashMap = sJNISetterPropertyMap.get(cls);
                boolean z = false;
                if (hashMap != null) {
                    boolean containsKey = hashMap.containsKey(this.mPropertyName);
                    z = containsKey;
                    if (containsKey) {
                        Long l = hashMap.get(this.mPropertyName);
                        z = containsKey;
                        if (l != null) {
                            this.mJniSetter = l.longValue();
                            z = containsKey;
                        }
                    }
                }
                if (!z) {
                    try {
                        this.mJniSetter = PropertyValuesHolder.nGetIntMethod(cls, getMethodName("set", this.mPropertyName));
                    } catch (NoSuchMethodError e) {
                    }
                    HashMap<String, Long> hashMap2 = hashMap;
                    if (hashMap == null) {
                        hashMap2 = new HashMap<>();
                        sJNISetterPropertyMap.put(cls, hashMap2);
                    }
                    hashMap2.put(this.mPropertyName, Long.valueOf(this.mJniSetter));
                }
            }
            if (this.mJniSetter == 0) {
                super.setupSetter(cls);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/animation/PropertyValuesHolder$MultiFloatValuesHolder.class */
    public static class MultiFloatValuesHolder extends PropertyValuesHolder {
        private static final HashMap<Class, HashMap<String, Long>> sJNISetterPropertyMap = new HashMap<>();
        private long mJniSetter;

        public MultiFloatValuesHolder(String str, TypeConverter typeConverter, TypeEvaluator typeEvaluator, Keyframes keyframes) {
            super(str);
            setConverter(typeConverter);
            this.mKeyframes = keyframes;
            setEvaluator(typeEvaluator);
        }

        public MultiFloatValuesHolder(String str, TypeConverter typeConverter, TypeEvaluator typeEvaluator, Object... objArr) {
            super(str);
            setConverter(typeConverter);
            setObjectValues(objArr);
            setEvaluator(typeEvaluator);
        }

        @Override // android.animation.PropertyValuesHolder
        /* renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo64clone() throws CloneNotSupportedException {
            return super.mo64clone();
        }

        @Override // android.animation.PropertyValuesHolder
        void setAnimatedValue(Object obj) {
            float[] fArr = (float[]) getAnimatedValue();
            int length = fArr.length;
            if (this.mJniSetter != 0) {
                switch (length) {
                    case 1:
                        PropertyValuesHolder.nCallFloatMethod(obj, this.mJniSetter, fArr[0]);
                        return;
                    case 2:
                        PropertyValuesHolder.nCallTwoFloatMethod(obj, this.mJniSetter, fArr[0], fArr[1]);
                        return;
                    case 3:
                    default:
                        PropertyValuesHolder.nCallMultipleFloatMethod(obj, this.mJniSetter, fArr);
                        return;
                    case 4:
                        PropertyValuesHolder.nCallFourFloatMethod(obj, this.mJniSetter, fArr[0], fArr[1], fArr[2], fArr[3]);
                        return;
                }
            }
        }

        @Override // android.animation.PropertyValuesHolder
        void setupSetter(Class cls) {
            if (this.mJniSetter != 0) {
                return;
            }
            synchronized (sJNISetterPropertyMap) {
                HashMap<String, Long> hashMap = sJNISetterPropertyMap.get(cls);
                boolean z = false;
                if (hashMap != null) {
                    boolean containsKey = hashMap.containsKey(this.mPropertyName);
                    z = containsKey;
                    if (containsKey) {
                        Long l = hashMap.get(this.mPropertyName);
                        z = containsKey;
                        if (l != null) {
                            this.mJniSetter = l.longValue();
                            z = containsKey;
                        }
                    }
                }
                if (!z) {
                    String methodName = getMethodName("set", this.mPropertyName);
                    calculateValue(0.0f);
                    int length = ((float[]) getAnimatedValue()).length;
                    try {
                        this.mJniSetter = PropertyValuesHolder.nGetMultipleFloatMethod(cls, methodName, length);
                    } catch (NoSuchMethodError e) {
                        try {
                            this.mJniSetter = PropertyValuesHolder.nGetMultipleFloatMethod(cls, this.mPropertyName, length);
                        } catch (NoSuchMethodError e2) {
                        }
                    }
                    HashMap<String, Long> hashMap2 = hashMap;
                    if (hashMap == null) {
                        hashMap2 = new HashMap<>();
                        sJNISetterPropertyMap.put(cls, hashMap2);
                    }
                    hashMap2.put(this.mPropertyName, Long.valueOf(this.mJniSetter));
                }
            }
        }

        @Override // android.animation.PropertyValuesHolder
        void setupSetterAndGetter(Object obj) {
            setupSetter(obj.getClass());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/animation/PropertyValuesHolder$MultiIntValuesHolder.class */
    public static class MultiIntValuesHolder extends PropertyValuesHolder {
        private static final HashMap<Class, HashMap<String, Long>> sJNISetterPropertyMap = new HashMap<>();
        private long mJniSetter;

        public MultiIntValuesHolder(String str, TypeConverter typeConverter, TypeEvaluator typeEvaluator, Keyframes keyframes) {
            super(str);
            setConverter(typeConverter);
            this.mKeyframes = keyframes;
            setEvaluator(typeEvaluator);
        }

        public MultiIntValuesHolder(String str, TypeConverter typeConverter, TypeEvaluator typeEvaluator, Object... objArr) {
            super(str);
            setConverter(typeConverter);
            setObjectValues(objArr);
            setEvaluator(typeEvaluator);
        }

        @Override // android.animation.PropertyValuesHolder
        /* renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo64clone() throws CloneNotSupportedException {
            return super.mo64clone();
        }

        @Override // android.animation.PropertyValuesHolder
        void setAnimatedValue(Object obj) {
            int[] iArr = (int[]) getAnimatedValue();
            int length = iArr.length;
            if (this.mJniSetter != 0) {
                switch (length) {
                    case 1:
                        PropertyValuesHolder.nCallIntMethod(obj, this.mJniSetter, iArr[0]);
                        return;
                    case 2:
                        PropertyValuesHolder.nCallTwoIntMethod(obj, this.mJniSetter, iArr[0], iArr[1]);
                        return;
                    case 3:
                    default:
                        PropertyValuesHolder.nCallMultipleIntMethod(obj, this.mJniSetter, iArr);
                        return;
                    case 4:
                        PropertyValuesHolder.nCallFourIntMethod(obj, this.mJniSetter, iArr[0], iArr[1], iArr[2], iArr[3]);
                        return;
                }
            }
        }

        @Override // android.animation.PropertyValuesHolder
        void setupSetter(Class cls) {
            if (this.mJniSetter != 0) {
                return;
            }
            synchronized (sJNISetterPropertyMap) {
                HashMap<String, Long> hashMap = sJNISetterPropertyMap.get(cls);
                boolean z = false;
                if (hashMap != null) {
                    boolean containsKey = hashMap.containsKey(this.mPropertyName);
                    z = containsKey;
                    if (containsKey) {
                        Long l = hashMap.get(this.mPropertyName);
                        z = containsKey;
                        if (l != null) {
                            this.mJniSetter = l.longValue();
                            z = containsKey;
                        }
                    }
                }
                if (!z) {
                    String methodName = getMethodName("set", this.mPropertyName);
                    calculateValue(0.0f);
                    int length = ((int[]) getAnimatedValue()).length;
                    try {
                        this.mJniSetter = PropertyValuesHolder.nGetMultipleIntMethod(cls, methodName, length);
                    } catch (NoSuchMethodError e) {
                        try {
                            this.mJniSetter = PropertyValuesHolder.nGetMultipleIntMethod(cls, this.mPropertyName, length);
                        } catch (NoSuchMethodError e2) {
                        }
                    }
                    HashMap<String, Long> hashMap2 = hashMap;
                    if (hashMap == null) {
                        hashMap2 = new HashMap<>();
                        sJNISetterPropertyMap.put(cls, hashMap2);
                    }
                    hashMap2.put(this.mPropertyName, Long.valueOf(this.mJniSetter));
                }
            }
        }

        @Override // android.animation.PropertyValuesHolder
        void setupSetterAndGetter(Object obj) {
            setupSetter(obj.getClass());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/animation/PropertyValuesHolder$PointFToFloatArray.class */
    public static class PointFToFloatArray extends TypeConverter<PointF, float[]> {
        private float[] mCoordinates;

        public PointFToFloatArray() {
            super(PointF.class, float[].class);
            this.mCoordinates = new float[2];
        }

        @Override // android.animation.TypeConverter
        public float[] convert(PointF pointF) {
            this.mCoordinates[0] = pointF.x;
            this.mCoordinates[1] = pointF.y;
            return this.mCoordinates;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/animation/PropertyValuesHolder$PointFToIntArray.class */
    public static class PointFToIntArray extends TypeConverter<PointF, int[]> {
        private int[] mCoordinates;

        public PointFToIntArray() {
            super(PointF.class, int[].class);
            this.mCoordinates = new int[2];
        }

        @Override // android.animation.TypeConverter
        public int[] convert(PointF pointF) {
            this.mCoordinates[0] = Math.round(pointF.x);
            this.mCoordinates[1] = Math.round(pointF.y);
            return this.mCoordinates;
        }
    }

    private PropertyValuesHolder(Property property) {
        this.mSetter = null;
        this.mGetter = null;
        this.mKeyframes = null;
        this.mTmpValueArray = new Object[1];
        this.mProperty = property;
        if (property != null) {
            this.mPropertyName = property.getName();
        }
    }

    private PropertyValuesHolder(String str) {
        this.mSetter = null;
        this.mGetter = null;
        this.mKeyframes = null;
        this.mTmpValueArray = new Object[1];
        this.mPropertyName = str;
    }

    private Object convertBack(Object obj) {
        Object obj2 = obj;
        if (this.mConverter != null) {
            if (!(this.mConverter instanceof BidirectionalTypeConverter)) {
                throw new IllegalArgumentException("Converter " + this.mConverter.getClass().getName() + " must be a BidirectionalTypeConverter");
            }
            obj2 = ((BidirectionalTypeConverter) this.mConverter).convertBack(obj);
        }
        return obj2;
    }

    static String getMethodName(String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            return str;
        }
        char upperCase = Character.toUpperCase(str2.charAt(0));
        return str + upperCase + str2.substring(1);
    }

    private Method getPropertyFunction(Class cls, String str, Class cls2) {
        Method method;
        Method method2 = null;
        Method method3 = null;
        String methodName = getMethodName(str, this.mPropertyName);
        if (cls2 != null) {
            Class<?>[] clsArr = new Class[1];
            Class[] clsArr2 = cls2.equals(Float.class) ? FLOAT_VARIANTS : cls2.equals(Integer.class) ? INTEGER_VARIANTS : cls2.equals(Double.class) ? DOUBLE_VARIANTS : new Class[]{cls2};
            int length = clsArr2.length;
            int i = 0;
            while (true) {
                int i2 = i;
                method3 = method2;
                if (i2 >= length) {
                    break;
                }
                Class<?> cls3 = clsArr2[i2];
                clsArr[0] = cls3;
                try {
                    method = cls.getMethod(methodName, clsArr);
                    if (this.mConverter != null) {
                        break;
                    }
                    method2 = method;
                    this.mValueType = cls3;
                    break;
                } catch (NoSuchMethodException e) {
                    i = i2 + 1;
                }
            }
            return method;
        }
        try {
            method3 = cls.getMethod(methodName, null);
        } catch (NoSuchMethodException e2) {
        }
        if (method3 == null) {
            Log.w("PropertyValuesHolder", "Method " + getMethodName(str, this.mPropertyName) + "() with type " + cls2 + " not found on target class " + cls);
        }
        return method3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nCallFloatMethod(Object obj, long j, float f);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nCallFourFloatMethod(Object obj, long j, float f, float f2, float f3, float f4);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nCallFourIntMethod(Object obj, long j, int i, int i2, int i3, int i4);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nCallIntMethod(Object obj, long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nCallMultipleFloatMethod(Object obj, long j, float[] fArr);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nCallMultipleIntMethod(Object obj, long j, int[] iArr);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nCallTwoFloatMethod(Object obj, long j, float f, float f2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nCallTwoIntMethod(Object obj, long j, int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native long nGetFloatMethod(Class cls, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static native long nGetIntMethod(Class cls, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static native long nGetMultipleFloatMethod(Class cls, String str, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public static native long nGetMultipleIntMethod(Class cls, String str, int i);

    public static PropertyValuesHolder ofFloat(Property<?, Float> property, float... fArr) {
        return new FloatPropertyValuesHolder(property, fArr);
    }

    public static PropertyValuesHolder ofFloat(String str, float... fArr) {
        return new FloatPropertyValuesHolder(str, fArr);
    }

    public static PropertyValuesHolder ofInt(Property<?, Integer> property, int... iArr) {
        return new IntPropertyValuesHolder(property, iArr);
    }

    public static PropertyValuesHolder ofInt(String str, int... iArr) {
        return new IntPropertyValuesHolder(str, iArr);
    }

    public static PropertyValuesHolder ofKeyframe(Property property, Keyframe... keyframeArr) {
        return ofKeyframes(property, KeyframeSet.ofKeyframe(keyframeArr));
    }

    public static PropertyValuesHolder ofKeyframe(String str, Keyframe... keyframeArr) {
        return ofKeyframes(str, KeyframeSet.ofKeyframe(keyframeArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PropertyValuesHolder ofKeyframes(Property property, Keyframes keyframes) {
        if (keyframes instanceof Keyframes.IntKeyframes) {
            return new IntPropertyValuesHolder(property, (Keyframes.IntKeyframes) keyframes);
        }
        if (keyframes instanceof Keyframes.FloatKeyframes) {
            return new FloatPropertyValuesHolder(property, (Keyframes.FloatKeyframes) keyframes);
        }
        PropertyValuesHolder propertyValuesHolder = new PropertyValuesHolder(property);
        propertyValuesHolder.mKeyframes = keyframes;
        propertyValuesHolder.mValueType = keyframes.getType();
        return propertyValuesHolder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PropertyValuesHolder ofKeyframes(String str, Keyframes keyframes) {
        if (keyframes instanceof Keyframes.IntKeyframes) {
            return new IntPropertyValuesHolder(str, (Keyframes.IntKeyframes) keyframes);
        }
        if (keyframes instanceof Keyframes.FloatKeyframes) {
            return new FloatPropertyValuesHolder(str, (Keyframes.FloatKeyframes) keyframes);
        }
        PropertyValuesHolder propertyValuesHolder = new PropertyValuesHolder(str);
        propertyValuesHolder.mKeyframes = keyframes;
        propertyValuesHolder.mValueType = keyframes.getType();
        return propertyValuesHolder;
    }

    public static <T> PropertyValuesHolder ofMultiFloat(String str, TypeConverter<T, float[]> typeConverter, TypeEvaluator<T> typeEvaluator, Keyframe... keyframeArr) {
        return new MultiFloatValuesHolder(str, typeConverter, typeEvaluator, KeyframeSet.ofKeyframe(keyframeArr));
    }

    public static <V> PropertyValuesHolder ofMultiFloat(String str, TypeConverter<V, float[]> typeConverter, TypeEvaluator<V> typeEvaluator, V... vArr) {
        return new MultiFloatValuesHolder(str, typeConverter, typeEvaluator, vArr);
    }

    public static PropertyValuesHolder ofMultiFloat(String str, Path path) {
        return new MultiFloatValuesHolder(str, new PointFToFloatArray(), (TypeEvaluator) null, KeyframeSet.ofPath(path));
    }

    public static PropertyValuesHolder ofMultiFloat(String str, float[][] fArr) {
        int i;
        if (fArr.length < 2) {
            throw new IllegalArgumentException("At least 2 values must be supplied");
        }
        int i2 = 0;
        int i3 = 0;
        while (i3 < fArr.length) {
            if (fArr[i3] == null) {
                throw new IllegalArgumentException("values must not be null");
            }
            int length = fArr[i3].length;
            if (i3 == 0) {
                i = length;
            } else {
                i = i2;
                if (length != i2) {
                    throw new IllegalArgumentException("Values must all have the same length");
                }
            }
            i3++;
            i2 = i;
        }
        return new MultiFloatValuesHolder(str, (TypeConverter) null, new FloatArrayEvaluator(new float[i2]), fArr);
    }

    public static <T> PropertyValuesHolder ofMultiInt(String str, TypeConverter<T, int[]> typeConverter, TypeEvaluator<T> typeEvaluator, Keyframe... keyframeArr) {
        return new MultiIntValuesHolder(str, typeConverter, typeEvaluator, KeyframeSet.ofKeyframe(keyframeArr));
    }

    public static <V> PropertyValuesHolder ofMultiInt(String str, TypeConverter<V, int[]> typeConverter, TypeEvaluator<V> typeEvaluator, V... vArr) {
        return new MultiIntValuesHolder(str, typeConverter, typeEvaluator, vArr);
    }

    public static PropertyValuesHolder ofMultiInt(String str, Path path) {
        return new MultiIntValuesHolder(str, new PointFToIntArray(), (TypeEvaluator) null, KeyframeSet.ofPath(path));
    }

    public static PropertyValuesHolder ofMultiInt(String str, int[][] iArr) {
        int i;
        if (iArr.length < 2) {
            throw new IllegalArgumentException("At least 2 values must be supplied");
        }
        int i2 = 0;
        int i3 = 0;
        while (i3 < iArr.length) {
            if (iArr[i3] == null) {
                throw new IllegalArgumentException("values must not be null");
            }
            int length = iArr[i3].length;
            if (i3 == 0) {
                i = length;
            } else {
                i = i2;
                if (length != i2) {
                    throw new IllegalArgumentException("Values must all have the same length");
                }
            }
            i3++;
            i2 = i;
        }
        return new MultiIntValuesHolder(str, (TypeConverter) null, new IntArrayEvaluator(new int[i2]), iArr);
    }

    public static <T, V> PropertyValuesHolder ofObject(Property<?, V> property, TypeConverter<T, V> typeConverter, TypeEvaluator<T> typeEvaluator, T... tArr) {
        PropertyValuesHolder propertyValuesHolder = new PropertyValuesHolder(property);
        propertyValuesHolder.setConverter(typeConverter);
        propertyValuesHolder.setObjectValues(tArr);
        propertyValuesHolder.setEvaluator(typeEvaluator);
        return propertyValuesHolder;
    }

    public static <V> PropertyValuesHolder ofObject(Property<?, V> property, TypeConverter<PointF, V> typeConverter, Path path) {
        PropertyValuesHolder propertyValuesHolder = new PropertyValuesHolder(property);
        propertyValuesHolder.mKeyframes = KeyframeSet.ofPath(path);
        propertyValuesHolder.mValueType = PointF.class;
        propertyValuesHolder.setConverter(typeConverter);
        return propertyValuesHolder;
    }

    public static <V> PropertyValuesHolder ofObject(Property property, TypeEvaluator<V> typeEvaluator, V... vArr) {
        PropertyValuesHolder propertyValuesHolder = new PropertyValuesHolder(property);
        propertyValuesHolder.setObjectValues(vArr);
        propertyValuesHolder.setEvaluator(typeEvaluator);
        return propertyValuesHolder;
    }

    public static PropertyValuesHolder ofObject(String str, TypeConverter<PointF, ?> typeConverter, Path path) {
        PropertyValuesHolder propertyValuesHolder = new PropertyValuesHolder(str);
        propertyValuesHolder.mKeyframes = KeyframeSet.ofPath(path);
        propertyValuesHolder.mValueType = PointF.class;
        propertyValuesHolder.setConverter(typeConverter);
        return propertyValuesHolder;
    }

    public static PropertyValuesHolder ofObject(String str, TypeEvaluator typeEvaluator, Object... objArr) {
        PropertyValuesHolder propertyValuesHolder = new PropertyValuesHolder(str);
        propertyValuesHolder.setObjectValues(objArr);
        propertyValuesHolder.setEvaluator(typeEvaluator);
        return propertyValuesHolder;
    }

    private void setupGetter(Class cls) {
        this.mGetter = setupSetterOrGetter(cls, sGetterPropertyMap, MonitorConstants.CONNECT_TYPE_GET, null);
    }

    private Method setupSetterOrGetter(Class cls, HashMap<Class, HashMap<String, Method>> hashMap, String str, Class cls2) {
        Method method;
        synchronized (hashMap) {
            HashMap<String, Method> hashMap2 = hashMap.get(cls);
            boolean z = false;
            method = null;
            if (hashMap2 != null) {
                boolean containsKey = hashMap2.containsKey(this.mPropertyName);
                method = null;
                z = containsKey;
                if (containsKey) {
                    method = hashMap2.get(this.mPropertyName);
                    z = containsKey;
                }
            }
            if (!z) {
                method = getPropertyFunction(cls, str, cls2);
                HashMap<String, Method> hashMap3 = hashMap2;
                if (hashMap2 == null) {
                    hashMap3 = new HashMap<>();
                    hashMap.put(cls, hashMap3);
                }
                hashMap3.put(this.mPropertyName, method);
            }
        }
        return method;
    }

    private void setupValue(Object obj, Keyframe keyframe) {
        if (this.mProperty != null) {
            keyframe.setValue(convertBack(this.mProperty.get(obj)));
        }
        try {
            if (this.mGetter == null) {
                setupGetter(obj.getClass());
                if (this.mGetter == null) {
                    return;
                }
            }
            keyframe.setValue(convertBack(this.mGetter.invoke(obj, new Object[0])));
        } catch (IllegalAccessException e) {
            Log.e("PropertyValuesHolder", e.toString());
        } catch (InvocationTargetException e2) {
            Log.e("PropertyValuesHolder", e2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void calculateValue(float f) {
        Object value = this.mKeyframes.getValue(f);
        if (this.mConverter != null) {
            value = this.mConverter.convert(value);
        }
        this.mAnimatedValue = value;
    }

    @Override // 
    /* renamed from: clone */
    public PropertyValuesHolder mo64clone() {
        try {
            PropertyValuesHolder propertyValuesHolder = (PropertyValuesHolder) super.clone();
            propertyValuesHolder.mPropertyName = this.mPropertyName;
            propertyValuesHolder.mProperty = this.mProperty;
            propertyValuesHolder.mKeyframes = this.mKeyframes.clone();
            propertyValuesHolder.mEvaluator = this.mEvaluator;
            return propertyValuesHolder;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object getAnimatedValue() {
        return this.mAnimatedValue;
    }

    public String getPropertyName() {
        return this.mPropertyName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init() {
        if (this.mEvaluator == null) {
            this.mEvaluator = this.mValueType == Integer.class ? sIntEvaluator : this.mValueType == Float.class ? sFloatEvaluator : null;
        }
        if (this.mEvaluator != null) {
            this.mKeyframes.setEvaluator(this.mEvaluator);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAnimatedValue(Object obj) {
        if (this.mProperty != null) {
            this.mProperty.set(obj, getAnimatedValue());
        }
        if (this.mSetter != null) {
            try {
                this.mTmpValueArray[0] = getAnimatedValue();
                this.mSetter.invoke(obj, this.mTmpValueArray);
            } catch (IllegalAccessException e) {
                Log.e("PropertyValuesHolder", e.toString());
            } catch (InvocationTargetException e2) {
                Log.e("PropertyValuesHolder", e2.toString());
            }
        }
    }

    public void setConverter(TypeConverter typeConverter) {
        this.mConverter = typeConverter;
    }

    public void setEvaluator(TypeEvaluator typeEvaluator) {
        this.mEvaluator = typeEvaluator;
        this.mKeyframes.setEvaluator(typeEvaluator);
    }

    public void setFloatValues(float... fArr) {
        this.mValueType = Float.TYPE;
        this.mKeyframes = KeyframeSet.ofFloat(fArr);
    }

    public void setIntValues(int... iArr) {
        this.mValueType = Integer.TYPE;
        this.mKeyframes = KeyframeSet.ofInt(iArr);
    }

    public void setKeyframes(Keyframe... keyframeArr) {
        int length = keyframeArr.length;
        Keyframe[] keyframeArr2 = new Keyframe[Math.max(length, 2)];
        this.mValueType = keyframeArr[0].getType();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                this.mKeyframes = new KeyframeSet(keyframeArr2);
                return;
            } else {
                keyframeArr2[i2] = keyframeArr[i2];
                i = i2 + 1;
            }
        }
    }

    public void setObjectValues(Object... objArr) {
        this.mValueType = objArr[0].getClass();
        this.mKeyframes = KeyframeSet.ofObject(objArr);
        if (this.mEvaluator != null) {
            this.mKeyframes.setEvaluator(this.mEvaluator);
        }
    }

    public void setProperty(Property property) {
        this.mProperty = property;
    }

    public void setPropertyName(String str) {
        this.mPropertyName = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setupEndValue(Object obj) {
        List<Keyframe> keyframes = this.mKeyframes.getKeyframes();
        if (keyframes.isEmpty()) {
            return;
        }
        setupValue(obj, keyframes.get(keyframes.size() - 1));
    }

    void setupSetter(Class cls) {
        this.mSetter = setupSetterOrGetter(cls, sSetterPropertyMap, "set", this.mConverter == null ? this.mValueType : this.mConverter.getTargetType());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setupSetterAndGetter(Object obj) {
        Object obj2;
        this.mKeyframes.invalidateCache();
        if (this.mProperty != null) {
            try {
                List<Keyframe> keyframes = this.mKeyframes.getKeyframes();
                int size = keyframes == null ? 0 : keyframes.size();
                int i = 0;
                Object obj3 = null;
                while (true) {
                    Object obj4 = obj3;
                    if (i >= size) {
                        return;
                    }
                    Keyframe keyframe = keyframes.get(i);
                    if (keyframe.hasValue()) {
                        obj2 = obj4;
                        if (!keyframe.valueWasSetOnStart()) {
                            i++;
                            obj3 = obj2;
                        }
                    }
                    obj2 = obj4;
                    if (obj4 == null) {
                        obj2 = convertBack(this.mProperty.get(obj));
                    }
                    keyframe.setValue(obj2);
                    keyframe.setValueWasSetOnStart(true);
                    i++;
                    obj3 = obj2;
                }
            } catch (ClassCastException e) {
                Log.w("PropertyValuesHolder", "No such property (" + this.mProperty.getName() + ") on target object " + obj + ". Trying reflection instead");
                this.mProperty = null;
            }
        }
        if (this.mProperty != null) {
            return;
        }
        Class<?> cls = obj.getClass();
        if (this.mSetter == null) {
            setupSetter(cls);
        }
        List<Keyframe> keyframes2 = this.mKeyframes.getKeyframes();
        int size2 = keyframes2 == null ? 0 : keyframes2.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size2) {
                return;
            }
            Keyframe keyframe2 = keyframes2.get(i3);
            if (!keyframe2.hasValue() || keyframe2.valueWasSetOnStart()) {
                if (this.mGetter == null) {
                    setupGetter(cls);
                    if (this.mGetter == null) {
                        return;
                    }
                }
                try {
                    keyframe2.setValue(convertBack(this.mGetter.invoke(obj, new Object[0])));
                    keyframe2.setValueWasSetOnStart(true);
                } catch (IllegalAccessException e2) {
                    Log.e("PropertyValuesHolder", e2.toString());
                } catch (InvocationTargetException e3) {
                    Log.e("PropertyValuesHolder", e3.toString());
                }
            }
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setupStartValue(Object obj) {
        List<Keyframe> keyframes = this.mKeyframes.getKeyframes();
        if (keyframes.isEmpty()) {
            return;
        }
        setupValue(obj, keyframes.get(0));
    }

    public String toString() {
        return this.mPropertyName + ": " + this.mKeyframes.toString();
    }
}
