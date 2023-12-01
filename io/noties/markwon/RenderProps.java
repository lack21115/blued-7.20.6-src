package io.noties.markwon;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/RenderProps.class */
public interface RenderProps {
    <T> void clear(Prop<T> prop);

    void clearAll();

    <T> T get(Prop<T> prop);

    <T> T get(Prop<T> prop, T t);

    <T> void set(Prop<T> prop, T t);
}
