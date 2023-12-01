package com.blued.android.module.common.base.mvvm;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/base/mvvm/LifecycleExtKt.class */
public final class LifecycleExtKt {
    public static final <T> void a(LifecycleOwner lifecycleOwner, LiveData<T> liveData, final Function1<? super T, Unit> observer) {
        Intrinsics.e(lifecycleOwner, "<this>");
        Intrinsics.e(liveData, "liveData");
        Intrinsics.e(observer, "observer");
        liveData.observe(lifecycleOwner, new Observer() { // from class: com.blued.android.module.common.base.mvvm.-$$Lambda$LifecycleExtKt$qByS_gRqnWMBsw1y4X2zuhrjC0U
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LifecycleExtKt.a(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Function1 observer, Object obj) {
        Intrinsics.e(observer, "$observer");
        if (obj == null) {
            return;
        }
        observer.invoke(obj);
    }

    public static final <T> void b(LifecycleOwner lifecycleOwner, LiveData<T> liveData, final Function1<? super T, Unit> observer) {
        Intrinsics.e(lifecycleOwner, "<this>");
        Intrinsics.e(liveData, "liveData");
        Intrinsics.e(observer, "observer");
        liveData.observe(lifecycleOwner, new Observer() { // from class: com.blued.android.module.common.base.mvvm.-$$Lambda$LifecycleExtKt$huhP1kCsX8JiCceBOErMGydEWYI
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LifecycleExtKt.b(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function1 observer, Object obj) {
        Intrinsics.e(observer, "$observer");
        observer.invoke(obj);
    }
}
