package com.soft.blued.ui.user.state;

import com.blued.android.module.common.base.mvi.UiAction;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/state/VipInvisibleToUserAction.class */
public abstract class VipInvisibleToUserAction implements UiAction {

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/state/VipInvisibleToUserAction$cancelInvisibleUser.class */
    public static final class cancelInvisibleUser extends VipInvisibleToUserAction {

        /* renamed from: a  reason: collision with root package name */
        private final List<String> f20621a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public cancelInvisibleUser(List<String> list) {
            super(null);
            Intrinsics.e(list, "targetUid");
            this.f20621a = list;
        }

        public final List<String> a() {
            return this.f20621a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof cancelInvisibleUser) && Intrinsics.a(this.f20621a, ((cancelInvisibleUser) obj).f20621a);
        }

        public int hashCode() {
            return this.f20621a.hashCode();
        }

        public String toString() {
            return "cancelInvisibleUser(targetUid=" + this.f20621a + ')';
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/state/VipInvisibleToUserAction$getInvisibleUserData.class */
    public static final class getInvisibleUserData extends VipInvisibleToUserAction {

        /* renamed from: a  reason: collision with root package name */
        private final int f20622a;
        private final int b;

        public getInvisibleUserData(int i, int i2) {
            super(null);
            this.f20622a = i;
            this.b = i2;
        }

        public final int a() {
            return this.f20622a;
        }

        public final int b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof getInvisibleUserData) {
                getInvisibleUserData getinvisibleuserdata = (getInvisibleUserData) obj;
                return this.f20622a == getinvisibleuserdata.f20622a && this.b == getinvisibleuserdata.b;
            }
            return false;
        }

        public int hashCode() {
            return (this.f20622a * 31) + this.b;
        }

        public String toString() {
            return "getInvisibleUserData(page=" + this.f20622a + ", size=" + this.b + ')';
        }
    }

    private VipInvisibleToUserAction() {
    }

    public /* synthetic */ VipInvisibleToUserAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
