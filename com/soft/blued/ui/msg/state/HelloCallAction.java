package com.soft.blued.ui.msg.state;

import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.module.common.base.mvi.UiAction;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/state/HelloCallAction.class */
public abstract class HelloCallAction implements UiAction {

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/state/HelloCallAction$GetHelloCallData.class */
    public static final class GetHelloCallData extends HelloCallAction {

        /* renamed from: a  reason: collision with root package name */
        private int f18904a;
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private String f18905c;
        private String d;
        private String e;
        private ActivityFragmentActive f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetHelloCallData(int i, int i2, String str, String str2, String str3, ActivityFragmentActive activityFragmentActive) {
            super(null);
            Intrinsics.e(str, "rankBy");
            Intrinsics.e(str2, "role");
            Intrinsics.e(str3, "filters");
            Intrinsics.e(activityFragmentActive, "fragmentActive");
            this.f18904a = i;
            this.b = i2;
            this.f18905c = str;
            this.d = str2;
            this.e = str3;
            this.f = activityFragmentActive;
        }

        public final int a() {
            return this.f18904a;
        }

        public final int b() {
            return this.b;
        }

        public final String c() {
            return this.f18905c;
        }

        public final String d() {
            return this.d;
        }

        public final String e() {
            return this.e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof GetHelloCallData) {
                GetHelloCallData getHelloCallData = (GetHelloCallData) obj;
                return this.f18904a == getHelloCallData.f18904a && this.b == getHelloCallData.b && Intrinsics.a(this.f18905c, getHelloCallData.f18905c) && Intrinsics.a(this.d, getHelloCallData.d) && Intrinsics.a(this.e, getHelloCallData.e) && Intrinsics.a(this.f, getHelloCallData.f);
            }
            return false;
        }

        public final ActivityFragmentActive f() {
            return this.f;
        }

        public int hashCode() {
            return (((((((((this.f18904a * 31) + this.b) * 31) + this.f18905c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
        }

        public String toString() {
            return "GetHelloCallData(page=" + this.f18904a + ", size=" + this.b + ", rankBy=" + this.f18905c + ", role=" + this.d + ", filters=" + this.e + ", fragmentActive=" + this.f + ')';
        }
    }

    private HelloCallAction() {
    }

    public /* synthetic */ HelloCallAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
