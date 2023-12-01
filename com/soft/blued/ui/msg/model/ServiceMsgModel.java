package com.soft.blued.ui.msg.model;

import com.blued.android.chat.model.ChattingModel;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/ServiceMsgModel.class */
public final class ServiceMsgModel extends ChattingModel implements MultiItemEntity {
    private int status;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.a(getClass(), obj == null ? null : obj.getClass())) {
            if (obj != null) {
                ServiceMsgModel serviceMsgModel = (ServiceMsgModel) obj;
                return this.sessionId == serviceMsgModel.sessionId && this.sessionType == serviceMsgModel.sessionType && this.msgTimestamp == serviceMsgModel.msgTimestamp && this.msgLocalId == serviceMsgModel.msgLocalId && this.msgId == serviceMsgModel.msgId;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.soft.blued.ui.msg.model.ServiceMsgModel");
        }
        return false;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return this.msgType;
    }

    public final int getStatus() {
        return this.status;
    }

    public int hashCode() {
        return (((((((C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.sessionId) * 31) + this.sessionType) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.msgTimestamp)) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.msgLocalId)) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.msgId);
    }

    public final void setStatus(int i) {
        this.status = i;
    }
}
