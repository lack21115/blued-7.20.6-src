package com.blued.android.module.common.base.mvi;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/base/mvi/BluedLiveData.class */
public class BluedLiveData<T> extends LiveData<T> {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f10674a;
    private final AtomicInteger b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/base/mvi/BluedLiveData$ObserverWrapper.class */
    public class ObserverWrapper implements Observer<T> {
        private final Observer<? super T> b;

        /* renamed from: c  reason: collision with root package name */
        private int f10676c;

        public ObserverWrapper(Observer<? super T> observer, int i) {
            this.f10676c = -1;
            this.b = observer;
            this.f10676c = i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return Objects.equals(this.b, ((ObserverWrapper) obj).b);
        }

        public int hashCode() {
            return Objects.hash(this.b);
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(T t) {
            if (BluedLiveData.this.b.get() > this.f10676c) {
                if (t != null || BluedLiveData.this.f10674a) {
                    this.b.onChanged(t);
                }
            }
        }
    }

    public BluedLiveData() {
        this.b = new AtomicInteger(-1);
    }

    public BluedLiveData(T t) {
        super(t);
        this.b = new AtomicInteger(-1);
    }

    private BluedLiveData<T>.ObserverWrapper a(Observer<? super T> observer, int i) {
        return new ObserverWrapper(observer, i);
    }

    @Override // androidx.lifecycle.LiveData
    public void observe(LifecycleOwner lifecycleOwner, Observer<? super T> observer) {
        super.observe(lifecycleOwner, a(observer, this.b.get()));
    }

    @Override // androidx.lifecycle.LiveData
    public void observeForever(Observer<? super T> observer) {
        super.observeForever(a(observer, this.b.get()));
    }

    @Override // androidx.lifecycle.LiveData
    public void removeObserver(Observer<? super T> observer) {
        if (observer.getClass().isAssignableFrom(ObserverWrapper.class)) {
            super.removeObserver(observer);
        } else {
            super.removeObserver(a(observer, -1));
        }
    }

    @Override // androidx.lifecycle.LiveData
    public void setValue(T t) {
        this.b.getAndIncrement();
        super.setValue(t);
    }
}
