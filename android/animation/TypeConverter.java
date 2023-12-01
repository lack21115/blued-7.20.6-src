package android.animation;

/* loaded from: source-9557208-dex2jar.jar:android/animation/TypeConverter.class */
public abstract class TypeConverter<T, V> {
    private Class<T> mFromClass;
    private Class<V> mToClass;

    public TypeConverter(Class<T> cls, Class<V> cls2) {
        this.mFromClass = cls;
        this.mToClass = cls2;
    }

    public abstract V convert(T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class<T> getSourceType() {
        return this.mFromClass;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class<V> getTargetType() {
        return this.mToClass;
    }
}
