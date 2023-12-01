package com.soft.blued.ui.setting.state;

import com.blued.android.module.common.base.mvi.UiAction;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/state/ResetPwdUiAction.class */
public abstract class ResetPwdUiAction implements UiAction {

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/state/ResetPwdUiAction$GetCode.class */
    public static final class GetCode extends ResetPwdUiAction {

        /* renamed from: a  reason: collision with root package name */
        private final String f19950a;
        private final String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetCode(String str, String str2) {
            super(null);
            Intrinsics.e(str, "channel");
            this.f19950a = str;
            this.b = str2;
        }

        public final String a() {
            return this.f19950a;
        }

        public final String b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof GetCode) {
                GetCode getCode = (GetCode) obj;
                return Intrinsics.a(this.f19950a, getCode.f19950a) && Intrinsics.a(this.b, getCode.b);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.f19950a.hashCode();
            String str = this.b;
            return (hashCode * 31) + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "GetCode(channel=" + this.f19950a + ", token=" + ((Object) this.b) + ')';
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/state/ResetPwdUiAction$GetPhone.class */
    public static final class GetPhone extends ResetPwdUiAction {

        /* renamed from: a  reason: collision with root package name */
        public static final GetPhone f19951a = new GetPhone();

        private GetPhone() {
            super(null);
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/state/ResetPwdUiAction$ModifyPwd.class */
    public static final class ModifyPwd extends ResetPwdUiAction {

        /* renamed from: a  reason: collision with root package name */
        private final String f19952a;
        private final String b;

        /* renamed from: c  reason: collision with root package name */
        private final String f19953c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ModifyPwd(String str, String str2, String str3) {
            super(null);
            Intrinsics.e(str2, "pwd");
            Intrinsics.e(str3, "code");
            this.f19952a = str;
            this.b = str2;
            this.f19953c = str3;
        }

        public final String a() {
            return this.f19952a;
        }

        public final String b() {
            return this.b;
        }

        public final String c() {
            return this.f19953c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ModifyPwd) {
                ModifyPwd modifyPwd = (ModifyPwd) obj;
                return Intrinsics.a(this.f19952a, modifyPwd.f19952a) && Intrinsics.a(this.b, modifyPwd.b) && Intrinsics.a(this.f19953c, modifyPwd.f19953c);
            }
            return false;
        }

        public int hashCode() {
            String str = this.f19952a;
            return ((((str == null ? 0 : str.hashCode()) * 31) + this.b.hashCode()) * 31) + this.f19953c.hashCode();
        }

        public String toString() {
            return "ModifyPwd(token=" + ((Object) this.f19952a) + ", pwd=" + this.b + ", code=" + this.f19953c + ')';
        }
    }

    private ResetPwdUiAction() {
    }

    public /* synthetic */ ResetPwdUiAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
