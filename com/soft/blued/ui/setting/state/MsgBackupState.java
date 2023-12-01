package com.soft.blued.ui.setting.state;

import com.blued.android.module.common.base.mvi.UiState;
import com.vivo.push.NoPorGuard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@NoPorGuard
@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/state/MsgBackupState.class */
public final class MsgBackupState implements UiState {

    /* renamed from: a  reason: collision with root package name */
    private final String f19949a;

    public MsgBackupState() {
        this(null, 1, null);
    }

    public MsgBackupState(String str) {
        this.f19949a = str;
    }

    public /* synthetic */ MsgBackupState(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    public final MsgBackupState a(String str) {
        return new MsgBackupState(str);
    }

    public final String a() {
        return this.f19949a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MsgBackupState) && Intrinsics.a(this.f19949a, ((MsgBackupState) obj).f19949a);
    }

    public int hashCode() {
        String str = this.f19949a;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "MsgBackupState(date=" + ((Object) this.f19949a) + ')';
    }
}
