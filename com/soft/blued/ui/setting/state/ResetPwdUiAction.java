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
        private final String f33641a;
        private final String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetCode(String channel, String str) {
            super(null);
            Intrinsics.e(channel, "channel");
            this.f33641a = channel;
            this.b = str;
        }

        public final String a() {
            return this.f33641a;
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
                return Intrinsics.a((Object) this.f33641a, (Object) getCode.f33641a) && Intrinsics.a((Object) this.b, (Object) getCode.b);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.f33641a.hashCode();
            String str = this.b;
            return (hashCode * 31) + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "GetCode(channel=" + this.f33641a + ", token=" + ((Object) this.b) + ')';
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/state/ResetPwdUiAction$GetPhone.class */
    public static final class GetPhone extends ResetPwdUiAction {

        /* renamed from: a  reason: collision with root package name */
        public static final GetPhone f33642a = new GetPhone();

        private GetPhone() {
            super(null);
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/state/ResetPwdUiAction$ModifyPwd.class */
    public static final class ModifyPwd extends ResetPwdUiAction {

        /* renamed from: a  reason: collision with root package name */
        private final String f33643a;
        private final String b;

        /* renamed from: c  reason: collision with root package name */
        private final String f33644c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ModifyPwd(String str, String pwd, String code) {
            super(null);
            Intrinsics.e(pwd, "pwd");
            Intrinsics.e(code, "code");
            this.f33643a = str;
            this.b = pwd;
            this.f33644c = code;
        }

        public final String a() {
            return this.f33643a;
        }

        public final String b() {
            return this.b;
        }

        public final String c() {
            return this.f33644c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ModifyPwd) {
                ModifyPwd modifyPwd = (ModifyPwd) obj;
                return Intrinsics.a((Object) this.f33643a, (Object) modifyPwd.f33643a) && Intrinsics.a((Object) this.b, (Object) modifyPwd.b) && Intrinsics.a((Object) this.f33644c, (Object) modifyPwd.f33644c);
            }
            return false;
        }

        public int hashCode() {
            String str = this.f33643a;
            return ((((str == null ? 0 : str.hashCode()) * 31) + this.b.hashCode()) * 31) + this.f33644c.hashCode();
        }

        public String toString() {
            return "ModifyPwd(token=" + ((Object) this.f33643a) + ", pwd=" + this.b + ", code=" + this.f33644c + ')';
        }
    }

    private ResetPwdUiAction() {
    }

    public /* synthetic */ ResetPwdUiAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
