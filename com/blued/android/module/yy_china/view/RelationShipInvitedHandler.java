package com.blued.android.module.yy_china.view;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/RelationShipInvitedHandler.class */
public final class RelationShipInvitedHandler extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<YYRelationShipInvitedDialog> f17979a;

    public RelationShipInvitedHandler(YYRelationShipInvitedDialog view) {
        Intrinsics.e(view, "view");
        this.f17979a = new WeakReference<>(view);
    }

    @Override // android.os.Handler
    public void handleMessage(Message msg) {
        Intrinsics.e(msg, "msg");
        super.handleMessage(msg);
        YYRelationShipInvitedDialog yYRelationShipInvitedDialog = this.f17979a.get();
        boolean z = false;
        if (yYRelationShipInvitedDialog != null && yYRelationShipInvitedDialog.g()) {
            z = true;
        }
        if (z) {
            sendEmptyMessageDelayed(1, 1000L);
        }
    }
}
