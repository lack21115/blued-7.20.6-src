package android.util;

/* loaded from: source-9557208-dex2jar.jar:android/util/FloatProperty.class */
public abstract class FloatProperty<T> extends Property<T, Float> {
    public FloatProperty(String str) {
        super(Float.class, str);
    }

    /* renamed from: set  reason: avoid collision after fix types in other method */
    public final void set2(T t, Float f) {
        setValue(t, f.floatValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(Object obj, Float f) {
        set2((FloatProperty<T>) obj, f);
    }

    public abstract void setValue(T t, float f);
}
