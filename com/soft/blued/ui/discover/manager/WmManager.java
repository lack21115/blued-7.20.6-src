package com.soft.blued.ui.discover.manager;

import com.soft.blued.http.LoginRegisterHttpUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/discover/manager/WmManager.class */
public final class WmManager {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f16153a = new Companion(null);

    @Metadata
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/discover/manager/WmManager$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(String str) {
            Intrinsics.e(str, "token");
            LoginRegisterHttpUtils.a(new WmManager$Companion$loginWm$1(), str);
        }

        @JvmStatic
        public final void b(String str) {
            Intrinsics.e(str, "token");
            LoginRegisterHttpUtils.b(new WmManager$Companion$getWid$1(), str);
        }
    }

    private WmManager() {
    }
}
