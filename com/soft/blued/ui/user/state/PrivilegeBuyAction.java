package com.soft.blued.ui.user.state;

import com.blued.android.module.common.base.mvi.UiAction;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/state/PrivilegeBuyAction.class */
public abstract class PrivilegeBuyAction implements UiAction {

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/state/PrivilegeBuyAction$checUserPermission.class */
    public static final class checUserPermission extends PrivilegeBuyAction {

        /* renamed from: a  reason: collision with root package name */
        private final String f34305a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public checUserPermission(String uid) {
            super(null);
            Intrinsics.e(uid, "uid");
            this.f34305a = uid;
        }

        public final String a() {
            return this.f34305a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof checUserPermission) && Intrinsics.a((Object) this.f34305a, (Object) ((checUserPermission) obj).f34305a);
        }

        public int hashCode() {
            return this.f34305a.hashCode();
        }

        public String toString() {
            return "checUserPermission(uid=" + this.f34305a + ')';
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/state/PrivilegeBuyAction$getGoodsList.class */
    public static final class getGoodsList extends PrivilegeBuyAction {

        /* renamed from: a  reason: collision with root package name */
        private final String f34306a;
        private final int b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public getGoodsList(String type, int i) {
            super(null);
            Intrinsics.e(type, "type");
            this.f34306a = type;
            this.b = i;
        }

        public final int a() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof getGoodsList) {
                getGoodsList getgoodslist = (getGoodsList) obj;
                return Intrinsics.a((Object) this.f34306a, (Object) getgoodslist.f34306a) && this.b == getgoodslist.b;
            }
            return false;
        }

        public final String getType() {
            return this.f34306a;
        }

        public int hashCode() {
            return (this.f34306a.hashCode() * 31) + this.b;
        }

        public String toString() {
            return "getGoodsList(type=" + this.f34306a + ", recommend=" + this.b + ')';
        }
    }

    private PrivilegeBuyAction() {
    }

    public /* synthetic */ PrivilegeBuyAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
