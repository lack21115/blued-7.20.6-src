package com.soft.blued.ui.user.state;

import com.blued.android.module.common.base.mvi.UiAction;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/state/SpecialCareAction.class */
public abstract class SpecialCareAction implements UiAction {

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/state/SpecialCareAction$cancelSpecialCareUser.class */
    public static final class cancelSpecialCareUser extends SpecialCareAction {

        /* renamed from: a  reason: collision with root package name */
        private final List<String> f20616a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public cancelSpecialCareUser(List<String> list) {
            super(null);
            Intrinsics.e(list, "targetUid");
            this.f20616a = list;
        }

        public final List<String> a() {
            return this.f20616a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof cancelSpecialCareUser) && Intrinsics.a(this.f20616a, ((cancelSpecialCareUser) obj).f20616a);
        }

        public int hashCode() {
            return this.f20616a.hashCode();
        }

        public String toString() {
            return "cancelSpecialCareUser(targetUid=" + this.f20616a + ')';
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/state/SpecialCareAction$getSpecialCareData.class */
    public static final class getSpecialCareData extends SpecialCareAction {

        /* renamed from: a  reason: collision with root package name */
        private final int f20617a;
        private final int b;

        public getSpecialCareData(int i, int i2) {
            super(null);
            this.f20617a = i;
            this.b = i2;
        }

        public final int a() {
            return this.f20617a;
        }

        public final int b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof getSpecialCareData) {
                getSpecialCareData getspecialcaredata = (getSpecialCareData) obj;
                return this.f20617a == getspecialcaredata.f20617a && this.b == getspecialcaredata.b;
            }
            return false;
        }

        public int hashCode() {
            return (this.f20617a * 31) + this.b;
        }

        public String toString() {
            return "getSpecialCareData(page=" + this.f20617a + ", size=" + this.b + ')';
        }
    }

    private SpecialCareAction() {
    }

    public /* synthetic */ SpecialCareAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
