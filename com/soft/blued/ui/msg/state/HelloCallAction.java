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
        private int f32595a;
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private String f32596c;
        private String d;
        private String e;
        private ActivityFragmentActive f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetHelloCallData(int i, int i2, String rankBy, String role, String filters, ActivityFragmentActive fragmentActive) {
            super(null);
            Intrinsics.e(rankBy, "rankBy");
            Intrinsics.e(role, "role");
            Intrinsics.e(filters, "filters");
            Intrinsics.e(fragmentActive, "fragmentActive");
            this.f32595a = i;
            this.b = i2;
            this.f32596c = rankBy;
            this.d = role;
            this.e = filters;
            this.f = fragmentActive;
        }

        public final int a() {
            return this.f32595a;
        }

        public final int b() {
            return this.b;
        }

        public final String c() {
            return this.f32596c;
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
                return this.f32595a == getHelloCallData.f32595a && this.b == getHelloCallData.b && Intrinsics.a((Object) this.f32596c, (Object) getHelloCallData.f32596c) && Intrinsics.a((Object) this.d, (Object) getHelloCallData.d) && Intrinsics.a((Object) this.e, (Object) getHelloCallData.e) && Intrinsics.a(this.f, getHelloCallData.f);
            }
            return false;
        }

        public final ActivityFragmentActive f() {
            return this.f;
        }

        public int hashCode() {
            return (((((((((this.f32595a * 31) + this.b) * 31) + this.f32596c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
        }

        public String toString() {
            return "GetHelloCallData(page=" + this.f32595a + ", size=" + this.b + ", rankBy=" + this.f32596c + ", role=" + this.d + ", filters=" + this.e + ", fragmentActive=" + this.f + ')';
        }
    }

    private HelloCallAction() {
    }

    public /* synthetic */ HelloCallAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
