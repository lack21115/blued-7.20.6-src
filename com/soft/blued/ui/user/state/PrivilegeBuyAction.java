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
        private final String f20614a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public checUserPermission(String str) {
            super(null);
            Intrinsics.e(str, "uid");
            this.f20614a = str;
        }

        public final String a() {
            return this.f20614a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof checUserPermission) && Intrinsics.a(this.f20614a, ((checUserPermission) obj).f20614a);
        }

        public int hashCode() {
            return this.f20614a.hashCode();
        }

        public String toString() {
            return "checUserPermission(uid=" + this.f20614a + ')';
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/state/PrivilegeBuyAction$getGoodsList.class */
    public static final class getGoodsList extends PrivilegeBuyAction {

        /* renamed from: a  reason: collision with root package name */
        private final String f20615a;
        private final int b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public getGoodsList(String str, int i) {
            super(null);
            Intrinsics.e(str, "type");
            this.f20615a = str;
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
                return Intrinsics.a(this.f20615a, getgoodslist.f20615a) && this.b == getgoodslist.b;
            }
            return false;
        }

        public final String getType() {
            return this.f20615a;
        }

        public int hashCode() {
            return (this.f20615a.hashCode() * 31) + this.b;
        }

        public String toString() {
            return "getGoodsList(type=" + this.f20615a + ", recommend=" + this.b + ')';
        }
    }

    private PrivilegeBuyAction() {
    }

    public /* synthetic */ PrivilegeBuyAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
