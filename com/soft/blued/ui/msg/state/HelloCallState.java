package com.soft.blued.ui.msg.state;

import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.common.base.mvi.UiState;
import com.soft.blued.ui.find.model.HelloDataExtra;
import com.soft.blued.ui.find.model.UserFindResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/state/HelloCallState.class */
public final class HelloCallState implements UiState {

    /* renamed from: a  reason: collision with root package name */
    private final BluedEntity<UserFindResult, HelloDataExtra> f32597a;

    public HelloCallState() {
        this(null, 1, null);
    }

    public HelloCallState(BluedEntity<UserFindResult, HelloDataExtra> bluedEntity) {
        this.f32597a = bluedEntity;
    }

    public /* synthetic */ HelloCallState(BluedEntity bluedEntity, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bluedEntity);
    }

    public final BluedEntity<UserFindResult, HelloDataExtra> a() {
        return this.f32597a;
    }

    public final HelloCallState a(BluedEntity<UserFindResult, HelloDataExtra> bluedEntity) {
        return new HelloCallState(bluedEntity);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof HelloCallState) && Intrinsics.a(this.f32597a, ((HelloCallState) obj).f32597a);
    }

    public int hashCode() {
        BluedEntity<UserFindResult, HelloDataExtra> bluedEntity = this.f32597a;
        if (bluedEntity == null) {
            return 0;
        }
        return bluedEntity.hashCode();
    }

    public String toString() {
        return "HelloCallState(helloData=" + this.f32597a + ')';
    }
}
