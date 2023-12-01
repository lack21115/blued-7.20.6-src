package com.blued.android.module.common.base.mvvm;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/base/mvvm/SingleLiveEvents.class */
public final class SingleLiveEvents<T> extends MutableLiveData<List<? extends T>> {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicBoolean f10704a = new AtomicBoolean(false);
    private final List<List<T>> b = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(SingleLiveEvents this$0, Observer observer, List list) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(observer, "$observer");
        if (this$0.f10704a.compareAndSet(true, false)) {
            this$0.b.clear();
            observer.onChanged(list);
        }
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    /* renamed from: a */
    public void setValue(List<? extends T> list) {
        this.f10704a.set(true);
        if (list != null) {
            this.b.add(list);
        }
        super.setValue(CollectionsKt.a((Iterable) this.b));
    }

    @Override // androidx.lifecycle.LiveData
    public void observe(LifecycleOwner owner, final Observer<? super List<? extends T>> observer) {
        Intrinsics.e(owner, "owner");
        Intrinsics.e(observer, "observer");
        super.observe(owner, new Observer() { // from class: com.blued.android.module.common.base.mvvm.-$$Lambda$SingleLiveEvents$eIfX_Wi6MXsDcvNkJel-mIaf9f8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SingleLiveEvents.a(SingleLiveEvents.this, observer, (List) obj);
            }
        });
    }
}
