package com.blued.android.chat.core.pack;

import com.blued.android.chat.utils.BytesUtils;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/SendAckPackage.class */
public class SendAckPackage extends BaseAckPackage {
    public long msgId;
    public long msgPreviousId;
    public long msgTime;
    public String promptType;

    public SendAckPackage() {
        this.type = (short) 3;
    }

    @Override // com.blued.android.chat.core.pack.BaseAckPackage
    public String _resultToString() {
        switch (this.result) {
            case 3:
                return "消息发送失败：消息内容为空";
            case 4:
                return "消息发送失败：消息内容不合法（含有敏感词或其他被定义为不合法的消息）";
            case 5:
                return "消息发送失败：私聊：接收消息的用户不存在或已被禁止; 群聊: 群被解散";
            case 6:
                return "消息发送失败：私聊：他拉黑了我";
            case 7:
                return "消息发送失败：私聊：我拉黑了他";
            case 8:
                return "消息发送失败：群聊：不在群里";
            case 9:
                return "消息发送失败：操作太频繁";
            case 10:
                return "消息发送失败: 账户未认证";
            case 11:
                return "消息发送失败: 私聊非好友";
            case 12:
                return "消息发送失败: 暫停在群組中使用小視頻的功能";
            case 13:
                return "消息发送失败: 直播聊天室被禁言";
            case 14:
                return "消息发送失败: 聊天室内的消息发送频率过快";
            case 15:
                return "消息发送失败: 群已被锁定";
            case 16:
                return "消息发送失败: 未实名认证";
            case 17:
                return "消息发送失败：群聊：暂停群聊功能";
            case 18:
                return "消息发送失败：消息防打扰错误";
            case 19:
                return "消息发送失败：群异常，包含群不存在等错误";
            case 20:
                return "消息发送失败: 用户彩虹分低，禁言";
            case 21:
                return "消息发送失败: 闪照审核未通过";
            default:
                return super._resultToString();
        }
    }

    @Override // com.blued.android.chat.core.pack.BasePackage
    protected void parseMsgData(byte[] bArr, int i, int i2) {
        this.result = BytesUtils.byteTo1Number(bArr, i);
        int i3 = i + 1;
        this.localId = BytesUtils.bytesTo4Number(bArr, i3);
        int i4 = i3 + 4;
        this.msgTime = BytesUtils.bytesTo4Number(bArr, i4);
        if (this.result == 0) {
            long byteTo8Number = BytesUtils.byteTo8Number(bArr, i4 + 4);
            this.msgId = byteTo8Number;
            this.msgPreviousId = byteTo8Number - 1;
        }
    }

    @Override // com.blued.android.chat.core.pack.BaseAckPackage, com.blued.android.chat.core.pack.BasePackage
    public String toString() {
        return super.toString() + "[result:" + ((int) this.result) + ", localId:" + this.localId + ", msgTime:" + this.msgTime + ", msgId:" + this.msgId + ", msgPreviousId:" + this.msgPreviousId + "]";
    }
}
