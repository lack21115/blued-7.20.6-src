package com.blued.android.module.common.base.mvi;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/base/mvi/BaseListState.class */
public final class BaseListState<M> implements UiState {

    /* renamed from: a  reason: collision with root package name */
    private final List<M> f10673a;

    public BaseListState() {
        this(null, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BaseListState(List<? extends M> data) {
        Intrinsics.e(data, "data");
        this.f10673a = data;
    }

    public /* synthetic */ BaseListState(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.b() : list);
    }

    public final List<M> a() {
        return this.f10673a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BaseListState) && Intrinsics.a(this.f10673a, ((BaseListState) obj).f10673a);
    }

    public int hashCode() {
        return this.f10673a.hashCode();
    }

    public String toString() {
        return "BaseListState(data=" + this.f10673a + ')';
    }
}
