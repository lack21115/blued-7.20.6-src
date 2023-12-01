package io.noties.markwon;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/Prop.class */
public class Prop<T> {
    private final String name;

    Prop(String str) {
        this.name = str;
    }

    public static <T> Prop<T> of(Class<T> cls, String str) {
        return new Prop<>(str);
    }

    public static <T> Prop<T> of(String str) {
        return new Prop<>(str);
    }

    public void clear(RenderProps renderProps) {
        renderProps.clear(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.name.equals(((Prop) obj).name);
    }

    public T get(RenderProps renderProps) {
        return (T) renderProps.get(this);
    }

    public T get(RenderProps renderProps, T t) {
        return (T) renderProps.get(this, t);
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public String name() {
        return this.name;
    }

    public T require(RenderProps renderProps) {
        T t = get(renderProps);
        if (t != null) {
            return t;
        }
        throw new NullPointerException(this.name);
    }

    public void set(RenderProps renderProps, T t) {
        renderProps.set(this, t);
    }

    public String toString() {
        return "Prop{name='" + this.name + "'}";
    }
}
