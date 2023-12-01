package de.robv.android.xposed.callbacks;

/* loaded from: source-259656-dex2jar.jar:de/robv/android/xposed/callbacks/IXUnhook.class */
public interface IXUnhook<T> {
    T getCallback();

    void unhook();
}
