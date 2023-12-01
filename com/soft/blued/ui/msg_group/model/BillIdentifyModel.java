package com.soft.blued.ui.msg_group.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/model/BillIdentifyModel.class */
public final class BillIdentifyModel {
    public static final Companion Companion = new Companion(null);
    public static final int verify_failed = 2;
    public static final int verify_none = -1;
    public static final int verify_succeed = 1;
    private int verify = -1;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/model/BillIdentifyModel$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final int getVerify() {
        return this.verify;
    }

    public final void setVerify(int i) {
        this.verify = i;
    }
}
