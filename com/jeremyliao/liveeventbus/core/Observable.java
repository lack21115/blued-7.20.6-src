package com.jeremyliao.liveeventbus.core;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

/* loaded from: source-7994992-dex2jar.jar:com/jeremyliao/liveeventbus/core/Observable.class */
public interface Observable<T> {
    @Deprecated
    void broadcast(T t);

    void broadcast(T t, boolean z, boolean z2);

    void observe(LifecycleOwner lifecycleOwner, Observer<T> observer);

    void observeForever(Observer<T> observer);

    void observeSticky(LifecycleOwner lifecycleOwner, Observer<T> observer);

    void observeStickyForever(Observer<T> observer);

    void post(T t);

    void postAcrossApp(T t);

    void postAcrossProcess(T t);

    void postDelay(LifecycleOwner lifecycleOwner, T t, long j);

    void postDelay(T t, long j);

    void postOrderly(T t);

    void removeObserver(Observer<T> observer);
}
