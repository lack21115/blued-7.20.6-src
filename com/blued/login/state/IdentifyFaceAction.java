package com.blued.login.state;

import com.blued.android.module.common.base.mvi.UiAction;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/login/state/IdentifyFaceAction.class */
public abstract class IdentifyFaceAction implements UiAction {

    @Metadata
    /* loaded from: source-7206380-dex2jar.jar:com/blued/login/state/IdentifyFaceAction$VerifyCard.class */
    public static final class VerifyCard extends IdentifyFaceAction {

        /* renamed from: a  reason: collision with root package name */
        private final String f6959a;
        private final String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VerifyCard(String str, String str2) {
            super(null);
            Intrinsics.e(str, "name");
            Intrinsics.e(str2, "cardId");
            this.f6959a = str;
            this.b = str2;
        }

        public final String a() {
            return this.f6959a;
        }

        public final String b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof VerifyCard) {
                VerifyCard verifyCard = (VerifyCard) obj;
                return Intrinsics.a(this.f6959a, verifyCard.f6959a) && Intrinsics.a(this.b, verifyCard.b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f6959a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            return "VerifyCard(name=" + this.f6959a + ", cardId=" + this.b + ')';
        }
    }

    private IdentifyFaceAction() {
    }

    public /* synthetic */ IdentifyFaceAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
