package com.blued.im.private_chat;

import com.blued.im.CommonOuterClass;
import com.blued.im.private_chat.CodeOuterClass;
import com.blued.im.private_chat.MsgTypeOuterClass;
import com.blued.im.private_chat.PushBodyOuterClass;
import com.blued.im.private_chat.ReqTypeOuterClass;
import com.google.common.net.HttpHeaders;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import com.tencent.txcopyrightedmedia.TXCopyrightedMedia;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/Chat1V1.class */
public final class Chat1V1 {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\rChat1v1.proto\u0012\u0019com.blued.im.private_chat\u001a\rReqType.proto\u001a\nCode.proto\u001a\fCommon.proto\u001a\rMsgType.proto\u001a\u000ePushBody.proto\"å\u0001\n\u000eChat1v1Request\u0012$\n\u0006common\u0018\u0001 \u0001(\u000b2\u0014.com.blued.im.Common\u00124\n\breq_type\u0018\u0002 \u0001(\u000e2\".com.blued.im.private_chat.ReqType\u0012\u0010\n\blocal_id\u0018\u0003 \u0001(\r\u0012\u0016\n\u000ecorrelation_id\u0018\u0004 \u0001(\t\u0012\u0014\n\fdelivery_tag\u0018\u0005 \u0001(\t\u00127\n\u0004body\u0018\u0006 \u0001(\u000b2).com.blued.im.private_chat.Chat1v1ReqBody\"®\u0001\n\u000eChat1v1ReqBody\u0012\u0013\n\u000binvited_uid\u0018\u0001 \u0001(\r\u0012\u000f\n\u0007room_id\u0018\u0002 \u0001(\t\u0012\u0011\n\troom_type\u0018\u0003 \u0001(\r\u0012\u0015\n\rchat_sdk_type\u0018\u0004 \u0001(\r\u0012\u000e\n\u0006reason\u0018\u0005 \u0001(\r\u0012\u0012\n\ntotal_time\u0018\u0006 \u0001(\u0003\u0012\u0015\n\rconsume_beans\u0018\u0007 \u0001(\u0003\u0012\u0011\n\tstream_id\u0018\b \u0001(\t\"í\u0001\n\u000fChat1v1Response\u0012-\n\u0004code\u0018\u0001 \u0001(\u000e2\u001f.com.blued.im.private_chat.Code\u0012\u000f\n\u0007message\u0018\u0002 \u0001(\t\u0012\u000e\n\u0006msg_id\u0018\u0003 \u0001(\u0003\u0012\u0010\n\blocal_id\u0018\u0004 \u0001(\u0005\u00127\n\u0004body\u0018\u0005 \u0001(\u000b2).com.blued.im.private_chat.Chat1v1AckBody\u0012\u0012\n\nrequest_id\u0018\u0006 \u0001(\t\u0012\u0014\n\frequest_time\u0018\u0007 \u0001(\u0003\u0012\u0015\n\rresponse_time\u0018\b \u0001(\u0003\"û\u0001\n\u000eChat1v1AckBody\u00124\n\breq_type\u0018\u0001 \u0001(\u000e2\".com.blued.im.private_chat.ReqType\u0012\r\n\u0005error\u0018\u0002 \u0001(\r\u0012\u0016\n\u000eerror_contents\u0018\u0003 \u0001(\t\u0012\u0010\n\bown_time\u0018\u0004 \u0001(\u0004\u0012\u001c\n\u0014remaining_call_count\u0018\u0005 \u0001(\u0004\u0012\u0015\n\rchat_sdk_type\u0018\u0006 \u0001(\r\u0012\u0012\n\nswitch_sdk\u0018\u0007 \u0001(\b\u0012\u0010\n\buser_sig\u0018\b \u0001(\t\u0012\u000e\n\u0006app_id\u0018\t \u0001(\r\u0012\u000f\n\u0007room_id\u0018\n \u0001(\t\"ä\u0002\n\u000eChat1v1Receive\u0012\f\n\u0004from\u0018\u0001 \u0001(\r\u0012\n\n\u0002to\u0018\u0002 \u0001(\r\u00124\n\bmsg_type\u0018\u0003 \u0001(\u000e2\".com.blued.im.private_chat.MsgType\u0012\u000e\n\u0006msg_id\u0018\u0004 \u0001(\u0003\u0012\u0011\n\ttimestamp\u0018\u0005 \u0001(\u0003\u0012\u0010\n\bdistance\u0018\u0006 \u0001(\t\u0012\u000e\n\u0006coords\u0018\u0007 \u0003(\u0001\u0012\u0016\n\u000esession_status\u0018\b \u0001(\u0005\u0012\u0012\n\nis_deleted\u0018\t \u0001(\b\u0012\u000f\n\u0007is_read\u0018\n \u0001(\b\u00121\n\u0004body\u0018\u000b \u0001(\u000b2#.com.blued.im.private_chat.PushBody\u0012\u0014\n\fsession_type\u0018\f \u0001(\r\u0012\u0018\n\u0010phone_session_id\u0018\r \u0001(\r\u0012\u001d\n\u0015session_common_status\u0018\u000e \u0001(\t2w\n\rHermesChat1v1\u0012f\n\u000bChat1v1Send\u0012).com.blued.im.private_chat.Chat1v1Request\u001a*.com.blued.im.private_chat.Chat1v1Response\"��B\n¢\u0002\u0007Chat1v1b\u0006proto3"}, new Descriptors.FileDescriptor[]{ReqTypeOuterClass.getDescriptor(), CodeOuterClass.getDescriptor(), CommonOuterClass.getDescriptor(), MsgTypeOuterClass.getDescriptor(), PushBodyOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_com_blued_im_private_chat_Chat1v1AckBody_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_im_private_chat_Chat1v1AckBody_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_blued_im_private_chat_Chat1v1Receive_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_im_private_chat_Chat1v1Receive_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_blued_im_private_chat_Chat1v1ReqBody_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_im_private_chat_Chat1v1ReqBody_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_blued_im_private_chat_Chat1v1Request_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_im_private_chat_Chat1v1Request_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_blued_im_private_chat_Chat1v1Response_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_im_private_chat_Chat1v1Response_fieldAccessorTable;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/Chat1V1$Chat1v1AckBody.class */
    public static final class Chat1v1AckBody extends GeneratedMessageV3 implements Chat1v1AckBodyOrBuilder {
        public static final int APP_ID_FIELD_NUMBER = 9;
        public static final int CHAT_SDK_TYPE_FIELD_NUMBER = 6;
        public static final int ERROR_CONTENTS_FIELD_NUMBER = 3;
        public static final int ERROR_FIELD_NUMBER = 2;
        public static final int OWN_TIME_FIELD_NUMBER = 4;
        public static final int REMAINING_CALL_COUNT_FIELD_NUMBER = 5;
        public static final int REQ_TYPE_FIELD_NUMBER = 1;
        public static final int ROOM_ID_FIELD_NUMBER = 10;
        public static final int SWITCH_SDK_FIELD_NUMBER = 7;
        public static final int USER_SIG_FIELD_NUMBER = 8;
        private static final long serialVersionUID = 0;
        private int appId_;
        private int chatSdkType_;
        private volatile Object errorContents_;
        private int error_;
        private byte memoizedIsInitialized;
        private long ownTime_;
        private long remainingCallCount_;
        private int reqType_;
        private volatile Object roomId_;
        private boolean switchSdk_;
        private volatile Object userSig_;
        private static final Chat1v1AckBody DEFAULT_INSTANCE = new Chat1v1AckBody();
        private static final Parser<Chat1v1AckBody> PARSER = new AbstractParser<Chat1v1AckBody>() { // from class: com.blued.im.private_chat.Chat1V1.Chat1v1AckBody.1
            @Override // com.google.protobuf.Parser
            public Chat1v1AckBody parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Chat1v1AckBody(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/Chat1V1$Chat1v1AckBody$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Chat1v1AckBodyOrBuilder {
            private int appId_;
            private int chatSdkType_;
            private Object errorContents_;
            private int error_;
            private long ownTime_;
            private long remainingCallCount_;
            private int reqType_;
            private Object roomId_;
            private boolean switchSdk_;
            private Object userSig_;

            private Builder() {
                this.reqType_ = 0;
                this.errorContents_ = "";
                this.userSig_ = "";
                this.roomId_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.reqType_ = 0;
                this.errorContents_ = "";
                this.userSig_ = "";
                this.roomId_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Chat1V1.internal_static_com_blued_im_private_chat_Chat1v1AckBody_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = Chat1v1AckBody.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Chat1v1AckBody build() {
                Chat1v1AckBody buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Chat1v1AckBody buildPartial() {
                Chat1v1AckBody chat1v1AckBody = new Chat1v1AckBody(this);
                chat1v1AckBody.reqType_ = this.reqType_;
                chat1v1AckBody.error_ = this.error_;
                chat1v1AckBody.errorContents_ = this.errorContents_;
                chat1v1AckBody.ownTime_ = this.ownTime_;
                chat1v1AckBody.remainingCallCount_ = this.remainingCallCount_;
                chat1v1AckBody.chatSdkType_ = this.chatSdkType_;
                chat1v1AckBody.switchSdk_ = this.switchSdk_;
                chat1v1AckBody.userSig_ = this.userSig_;
                chat1v1AckBody.appId_ = this.appId_;
                chat1v1AckBody.roomId_ = this.roomId_;
                onBuilt();
                return chat1v1AckBody;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.reqType_ = 0;
                this.error_ = 0;
                this.errorContents_ = "";
                this.ownTime_ = 0L;
                this.remainingCallCount_ = 0L;
                this.chatSdkType_ = 0;
                this.switchSdk_ = false;
                this.userSig_ = "";
                this.appId_ = 0;
                this.roomId_ = "";
                return this;
            }

            public Builder clearAppId() {
                this.appId_ = 0;
                onChanged();
                return this;
            }

            public Builder clearChatSdkType() {
                this.chatSdkType_ = 0;
                onChanged();
                return this;
            }

            public Builder clearError() {
                this.error_ = 0;
                onChanged();
                return this;
            }

            public Builder clearErrorContents() {
                this.errorContents_ = Chat1v1AckBody.getDefaultInstance().getErrorContents();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearOwnTime() {
                this.ownTime_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearRemainingCallCount() {
                this.remainingCallCount_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearReqType() {
                this.reqType_ = 0;
                onChanged();
                return this;
            }

            public Builder clearRoomId() {
                this.roomId_ = Chat1v1AckBody.getDefaultInstance().getRoomId();
                onChanged();
                return this;
            }

            public Builder clearSwitchSdk() {
                this.switchSdk_ = false;
                onChanged();
                return this;
            }

            public Builder clearUserSig() {
                this.userSig_ = Chat1v1AckBody.getDefaultInstance().getUserSig();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo2030clone() {
                return (Builder) super.mo2030clone();
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1AckBodyOrBuilder
            public int getAppId() {
                return this.appId_;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1AckBodyOrBuilder
            public int getChatSdkType() {
                return this.chatSdkType_;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Chat1v1AckBody getDefaultInstanceForType() {
                return Chat1v1AckBody.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Chat1V1.internal_static_com_blued_im_private_chat_Chat1v1AckBody_descriptor;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1AckBodyOrBuilder
            public int getError() {
                return this.error_;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1AckBodyOrBuilder
            public String getErrorContents() {
                Object obj = this.errorContents_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.errorContents_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1AckBodyOrBuilder
            public ByteString getErrorContentsBytes() {
                Object obj = this.errorContents_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.errorContents_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1AckBodyOrBuilder
            public long getOwnTime() {
                return this.ownTime_;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1AckBodyOrBuilder
            public long getRemainingCallCount() {
                return this.remainingCallCount_;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1AckBodyOrBuilder
            public ReqTypeOuterClass.ReqType getReqType() {
                ReqTypeOuterClass.ReqType valueOf = ReqTypeOuterClass.ReqType.valueOf(this.reqType_);
                ReqTypeOuterClass.ReqType reqType = valueOf;
                if (valueOf == null) {
                    reqType = ReqTypeOuterClass.ReqType.UNRECOGNIZED;
                }
                return reqType;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1AckBodyOrBuilder
            public int getReqTypeValue() {
                return this.reqType_;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1AckBodyOrBuilder
            public String getRoomId() {
                Object obj = this.roomId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.roomId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1AckBodyOrBuilder
            public ByteString getRoomIdBytes() {
                Object obj = this.roomId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.roomId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1AckBodyOrBuilder
            public boolean getSwitchSdk() {
                return this.switchSdk_;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1AckBodyOrBuilder
            public String getUserSig() {
                Object obj = this.userSig_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.userSig_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1AckBodyOrBuilder
            public ByteString getUserSigBytes() {
                Object obj = this.userSig_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.userSig_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Chat1V1.internal_static_com_blued_im_private_chat_Chat1v1AckBody_fieldAccessorTable.ensureFieldAccessorsInitialized(Chat1v1AckBody.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(Chat1v1AckBody chat1v1AckBody) {
                if (chat1v1AckBody == Chat1v1AckBody.getDefaultInstance()) {
                    return this;
                }
                if (chat1v1AckBody.reqType_ != 0) {
                    setReqTypeValue(chat1v1AckBody.getReqTypeValue());
                }
                if (chat1v1AckBody.getError() != 0) {
                    setError(chat1v1AckBody.getError());
                }
                if (!chat1v1AckBody.getErrorContents().isEmpty()) {
                    this.errorContents_ = chat1v1AckBody.errorContents_;
                    onChanged();
                }
                if (chat1v1AckBody.getOwnTime() != 0) {
                    setOwnTime(chat1v1AckBody.getOwnTime());
                }
                if (chat1v1AckBody.getRemainingCallCount() != 0) {
                    setRemainingCallCount(chat1v1AckBody.getRemainingCallCount());
                }
                if (chat1v1AckBody.getChatSdkType() != 0) {
                    setChatSdkType(chat1v1AckBody.getChatSdkType());
                }
                if (chat1v1AckBody.getSwitchSdk()) {
                    setSwitchSdk(chat1v1AckBody.getSwitchSdk());
                }
                if (!chat1v1AckBody.getUserSig().isEmpty()) {
                    this.userSig_ = chat1v1AckBody.userSig_;
                    onChanged();
                }
                if (chat1v1AckBody.getAppId() != 0) {
                    setAppId(chat1v1AckBody.getAppId());
                }
                if (!chat1v1AckBody.getRoomId().isEmpty()) {
                    this.roomId_ = chat1v1AckBody.roomId_;
                    onChanged();
                }
                mergeUnknownFields(chat1v1AckBody.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.im.private_chat.Chat1V1.Chat1v1AckBody.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.im.private_chat.Chat1V1.Chat1v1AckBody.access$7200()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.im.private_chat.Chat1V1$Chat1v1AckBody r0 = (com.blued.im.private_chat.Chat1V1.Chat1v1AckBody) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.im.private_chat.Chat1V1$Chat1v1AckBody$Builder r0 = r0.mergeFrom(r1)
                L1a:
                    r0 = r4
                    return r0
                L1c:
                    r6 = move-exception
                    r0 = r7
                    r5 = r0
                    goto L31
                L22:
                    r6 = move-exception
                    r0 = r6
                    com.google.protobuf.MessageLite r0 = r0.getUnfinishedMessage()     // Catch: java.lang.Throwable -> L1c
                    com.blued.im.private_chat.Chat1V1$Chat1v1AckBody r0 = (com.blued.im.private_chat.Chat1V1.Chat1v1AckBody) r0     // Catch: java.lang.Throwable -> L1c
                    r5 = r0
                    r0 = r6
                    java.io.IOException r0 = r0.unwrapIOException()     // Catch: java.lang.Throwable -> L30
                    throw r0     // Catch: java.lang.Throwable -> L30
                L30:
                    r6 = move-exception
                L31:
                    r0 = r5
                    if (r0 == 0) goto L3b
                    r0 = r4
                    r1 = r5
                    com.blued.im.private_chat.Chat1V1$Chat1v1AckBody$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.im.private_chat.Chat1V1.Chat1v1AckBody.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.im.private_chat.Chat1V1$Chat1v1AckBody$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof Chat1v1AckBody) {
                    return mergeFrom((Chat1v1AckBody) message);
                }
                super.mergeFrom(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder setAppId(int i) {
                this.appId_ = i;
                onChanged();
                return this;
            }

            public Builder setChatSdkType(int i) {
                this.chatSdkType_ = i;
                onChanged();
                return this;
            }

            public Builder setError(int i) {
                this.error_ = i;
                onChanged();
                return this;
            }

            public Builder setErrorContents(String str) {
                if (str != null) {
                    this.errorContents_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setErrorContentsBytes(ByteString byteString) {
                if (byteString != null) {
                    Chat1v1AckBody.checkByteStringIsUtf8(byteString);
                    this.errorContents_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setOwnTime(long j) {
                this.ownTime_ = j;
                onChanged();
                return this;
            }

            public Builder setRemainingCallCount(long j) {
                this.remainingCallCount_ = j;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setReqType(ReqTypeOuterClass.ReqType reqType) {
                if (reqType != null) {
                    this.reqType_ = reqType.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setReqTypeValue(int i) {
                this.reqType_ = i;
                onChanged();
                return this;
            }

            public Builder setRoomId(String str) {
                if (str != null) {
                    this.roomId_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setRoomIdBytes(ByteString byteString) {
                if (byteString != null) {
                    Chat1v1AckBody.checkByteStringIsUtf8(byteString);
                    this.roomId_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setSwitchSdk(boolean z) {
                this.switchSdk_ = z;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            public Builder setUserSig(String str) {
                if (str != null) {
                    this.userSig_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setUserSigBytes(ByteString byteString) {
                if (byteString != null) {
                    Chat1v1AckBody.checkByteStringIsUtf8(byteString);
                    this.userSig_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }
        }

        private Chat1v1AckBody() {
            this.memoizedIsInitialized = (byte) -1;
            this.reqType_ = 0;
            this.errorContents_ = "";
            this.userSig_ = "";
            this.roomId_ = "";
        }

        private Chat1v1AckBody(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw null;
            }
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                this.reqType_ = codedInputStream.readEnum();
                                continue;
                            case 16:
                                this.error_ = codedInputStream.readUInt32();
                                continue;
                            case 26:
                                this.errorContents_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 32:
                                this.ownTime_ = codedInputStream.readUInt64();
                                continue;
                            case 40:
                                this.remainingCallCount_ = codedInputStream.readUInt64();
                                continue;
                            case 48:
                                this.chatSdkType_ = codedInputStream.readUInt32();
                                continue;
                            case 56:
                                this.switchSdk_ = codedInputStream.readBool();
                                continue;
                            case 66:
                                this.userSig_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 72:
                                this.appId_ = codedInputStream.readUInt32();
                                continue;
                            case 82:
                                this.roomId_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            default:
                                if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                    break;
                                } else {
                                    continue;
                                }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        private Chat1v1AckBody(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Chat1v1AckBody getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Chat1V1.internal_static_com_blued_im_private_chat_Chat1v1AckBody_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Chat1v1AckBody chat1v1AckBody) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(chat1v1AckBody);
        }

        public static Chat1v1AckBody parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Chat1v1AckBody) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Chat1v1AckBody parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Chat1v1AckBody) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Chat1v1AckBody parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Chat1v1AckBody parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Chat1v1AckBody parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Chat1v1AckBody) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Chat1v1AckBody parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Chat1v1AckBody) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static Chat1v1AckBody parseFrom(InputStream inputStream) throws IOException {
            return (Chat1v1AckBody) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Chat1v1AckBody parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Chat1v1AckBody) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Chat1v1AckBody parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Chat1v1AckBody parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Chat1v1AckBody parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Chat1v1AckBody parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<Chat1v1AckBody> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Chat1v1AckBody) {
                Chat1v1AckBody chat1v1AckBody = (Chat1v1AckBody) obj;
                return this.reqType_ == chat1v1AckBody.reqType_ && getError() == chat1v1AckBody.getError() && getErrorContents().equals(chat1v1AckBody.getErrorContents()) && getOwnTime() == chat1v1AckBody.getOwnTime() && getRemainingCallCount() == chat1v1AckBody.getRemainingCallCount() && getChatSdkType() == chat1v1AckBody.getChatSdkType() && getSwitchSdk() == chat1v1AckBody.getSwitchSdk() && getUserSig().equals(chat1v1AckBody.getUserSig()) && getAppId() == chat1v1AckBody.getAppId() && getRoomId().equals(chat1v1AckBody.getRoomId()) && this.unknownFields.equals(chat1v1AckBody.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1AckBodyOrBuilder
        public int getAppId() {
            return this.appId_;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1AckBodyOrBuilder
        public int getChatSdkType() {
            return this.chatSdkType_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Chat1v1AckBody getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1AckBodyOrBuilder
        public int getError() {
            return this.error_;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1AckBodyOrBuilder
        public String getErrorContents() {
            Object obj = this.errorContents_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.errorContents_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1AckBodyOrBuilder
        public ByteString getErrorContentsBytes() {
            Object obj = this.errorContents_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.errorContents_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1AckBodyOrBuilder
        public long getOwnTime() {
            return this.ownTime_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Chat1v1AckBody> getParserForType() {
            return PARSER;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1AckBodyOrBuilder
        public long getRemainingCallCount() {
            return this.remainingCallCount_;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1AckBodyOrBuilder
        public ReqTypeOuterClass.ReqType getReqType() {
            ReqTypeOuterClass.ReqType valueOf = ReqTypeOuterClass.ReqType.valueOf(this.reqType_);
            ReqTypeOuterClass.ReqType reqType = valueOf;
            if (valueOf == null) {
                reqType = ReqTypeOuterClass.ReqType.UNRECOGNIZED;
            }
            return reqType;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1AckBodyOrBuilder
        public int getReqTypeValue() {
            return this.reqType_;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1AckBodyOrBuilder
        public String getRoomId() {
            Object obj = this.roomId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.roomId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1AckBodyOrBuilder
        public ByteString getRoomIdBytes() {
            Object obj = this.roomId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.roomId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (this.reqType_ != ReqTypeOuterClass.ReqType.ReqNil.getNumber()) {
                i2 = 0 + CodedOutputStream.computeEnumSize(1, this.reqType_);
            }
            int i3 = this.error_;
            int i4 = i2;
            if (i3 != 0) {
                i4 = i2 + CodedOutputStream.computeUInt32Size(2, i3);
            }
            int i5 = i4;
            if (!getErrorContentsBytes().isEmpty()) {
                i5 = i4 + GeneratedMessageV3.computeStringSize(3, this.errorContents_);
            }
            long j = this.ownTime_;
            int i6 = i5;
            if (j != 0) {
                i6 = i5 + CodedOutputStream.computeUInt64Size(4, j);
            }
            long j2 = this.remainingCallCount_;
            int i7 = i6;
            if (j2 != 0) {
                i7 = i6 + CodedOutputStream.computeUInt64Size(5, j2);
            }
            int i8 = this.chatSdkType_;
            int i9 = i7;
            if (i8 != 0) {
                i9 = i7 + CodedOutputStream.computeUInt32Size(6, i8);
            }
            boolean z = this.switchSdk_;
            int i10 = i9;
            if (z) {
                i10 = i9 + CodedOutputStream.computeBoolSize(7, z);
            }
            int i11 = i10;
            if (!getUserSigBytes().isEmpty()) {
                i11 = i10 + GeneratedMessageV3.computeStringSize(8, this.userSig_);
            }
            int i12 = this.appId_;
            int i13 = i11;
            if (i12 != 0) {
                i13 = i11 + CodedOutputStream.computeUInt32Size(9, i12);
            }
            int i14 = i13;
            if (!getRoomIdBytes().isEmpty()) {
                i14 = i13 + GeneratedMessageV3.computeStringSize(10, this.roomId_);
            }
            int serializedSize = i14 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1AckBodyOrBuilder
        public boolean getSwitchSdk() {
            return this.switchSdk_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1AckBodyOrBuilder
        public String getUserSig() {
            Object obj = this.userSig_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.userSig_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1AckBodyOrBuilder
        public ByteString getUserSigBytes() {
            Object obj = this.userSig_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.userSig_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.reqType_) * 37) + 2) * 53) + getError()) * 37) + 3) * 53) + getErrorContents().hashCode()) * 37) + 4) * 53) + Internal.hashLong(getOwnTime())) * 37) + 5) * 53) + Internal.hashLong(getRemainingCallCount())) * 37) + 6) * 53) + getChatSdkType()) * 37) + 7) * 53) + Internal.hashBoolean(getSwitchSdk())) * 37) + 8) * 53) + getUserSig().hashCode()) * 37) + 9) * 53) + getAppId()) * 37) + 10) * 53) + getRoomId().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Chat1V1.internal_static_com_blued_im_private_chat_Chat1v1AckBody_fieldAccessorTable.ensureFieldAccessorsInitialized(Chat1v1AckBody.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new Chat1v1AckBody();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.reqType_ != ReqTypeOuterClass.ReqType.ReqNil.getNumber()) {
                codedOutputStream.writeEnum(1, this.reqType_);
            }
            int i = this.error_;
            if (i != 0) {
                codedOutputStream.writeUInt32(2, i);
            }
            if (!getErrorContentsBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.errorContents_);
            }
            long j = this.ownTime_;
            if (j != 0) {
                codedOutputStream.writeUInt64(4, j);
            }
            long j2 = this.remainingCallCount_;
            if (j2 != 0) {
                codedOutputStream.writeUInt64(5, j2);
            }
            int i2 = this.chatSdkType_;
            if (i2 != 0) {
                codedOutputStream.writeUInt32(6, i2);
            }
            boolean z = this.switchSdk_;
            if (z) {
                codedOutputStream.writeBool(7, z);
            }
            if (!getUserSigBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 8, this.userSig_);
            }
            int i3 = this.appId_;
            if (i3 != 0) {
                codedOutputStream.writeUInt32(9, i3);
            }
            if (!getRoomIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 10, this.roomId_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/Chat1V1$Chat1v1AckBodyOrBuilder.class */
    public interface Chat1v1AckBodyOrBuilder extends MessageOrBuilder {
        int getAppId();

        int getChatSdkType();

        int getError();

        String getErrorContents();

        ByteString getErrorContentsBytes();

        long getOwnTime();

        long getRemainingCallCount();

        ReqTypeOuterClass.ReqType getReqType();

        int getReqTypeValue();

        String getRoomId();

        ByteString getRoomIdBytes();

        boolean getSwitchSdk();

        String getUserSig();

        ByteString getUserSigBytes();
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/Chat1V1$Chat1v1Receive.class */
    public static final class Chat1v1Receive extends GeneratedMessageV3 implements Chat1v1ReceiveOrBuilder {
        public static final int BODY_FIELD_NUMBER = 11;
        public static final int COORDS_FIELD_NUMBER = 7;
        public static final int DISTANCE_FIELD_NUMBER = 6;
        public static final int FROM_FIELD_NUMBER = 1;
        public static final int IS_DELETED_FIELD_NUMBER = 9;
        public static final int IS_READ_FIELD_NUMBER = 10;
        public static final int MSG_ID_FIELD_NUMBER = 4;
        public static final int MSG_TYPE_FIELD_NUMBER = 3;
        public static final int PHONE_SESSION_ID_FIELD_NUMBER = 13;
        public static final int SESSION_COMMON_STATUS_FIELD_NUMBER = 14;
        public static final int SESSION_STATUS_FIELD_NUMBER = 8;
        public static final int SESSION_TYPE_FIELD_NUMBER = 12;
        public static final int TIMESTAMP_FIELD_NUMBER = 5;
        public static final int TO_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private PushBodyOuterClass.PushBody body_;
        private int coordsMemoizedSerializedSize;
        private Internal.DoubleList coords_;
        private volatile Object distance_;
        private int from_;
        private boolean isDeleted_;
        private boolean isRead_;
        private byte memoizedIsInitialized;
        private long msgId_;
        private int msgType_;
        private int phoneSessionId_;
        private volatile Object sessionCommonStatus_;
        private int sessionStatus_;
        private int sessionType_;
        private long timestamp_;
        private int to_;
        private static final Chat1v1Receive DEFAULT_INSTANCE = new Chat1v1Receive();
        private static final Parser<Chat1v1Receive> PARSER = new AbstractParser<Chat1v1Receive>() { // from class: com.blued.im.private_chat.Chat1V1.Chat1v1Receive.1
            @Override // com.google.protobuf.Parser
            public Chat1v1Receive parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Chat1v1Receive(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/Chat1V1$Chat1v1Receive$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Chat1v1ReceiveOrBuilder {
            private int bitField0_;
            private SingleFieldBuilderV3<PushBodyOuterClass.PushBody, PushBodyOuterClass.PushBody.Builder, PushBodyOuterClass.PushBodyOrBuilder> bodyBuilder_;
            private PushBodyOuterClass.PushBody body_;
            private Internal.DoubleList coords_;
            private Object distance_;
            private int from_;
            private boolean isDeleted_;
            private boolean isRead_;
            private long msgId_;
            private int msgType_;
            private int phoneSessionId_;
            private Object sessionCommonStatus_;
            private int sessionStatus_;
            private int sessionType_;
            private long timestamp_;
            private int to_;

            private Builder() {
                this.msgType_ = 0;
                this.distance_ = "";
                this.coords_ = Chat1v1Receive.access$10100();
                this.sessionCommonStatus_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.msgType_ = 0;
                this.distance_ = "";
                this.coords_ = Chat1v1Receive.access$10100();
                this.sessionCommonStatus_ = "";
                maybeForceBuilderInitialization();
            }

            private void ensureCoordsIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.coords_ = Chat1v1Receive.mutableCopy(this.coords_);
                    this.bitField0_ |= 1;
                }
            }

            private SingleFieldBuilderV3<PushBodyOuterClass.PushBody, PushBodyOuterClass.PushBody.Builder, PushBodyOuterClass.PushBodyOrBuilder> getBodyFieldBuilder() {
                if (this.bodyBuilder_ == null) {
                    this.bodyBuilder_ = new SingleFieldBuilderV3<>(getBody(), getParentForChildren(), isClean());
                    this.body_ = null;
                }
                return this.bodyBuilder_;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Chat1V1.internal_static_com_blued_im_private_chat_Chat1v1Receive_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = Chat1v1Receive.alwaysUseFieldBuilders;
            }

            public Builder addAllCoords(Iterable<? extends Double> iterable) {
                ensureCoordsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.coords_);
                onChanged();
                return this;
            }

            public Builder addCoords(double d) {
                ensureCoordsIsMutable();
                this.coords_.addDouble(d);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Chat1v1Receive build() {
                Chat1v1Receive buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Chat1v1Receive buildPartial() {
                Chat1v1Receive chat1v1Receive = new Chat1v1Receive(this);
                chat1v1Receive.from_ = this.from_;
                chat1v1Receive.to_ = this.to_;
                chat1v1Receive.msgType_ = this.msgType_;
                chat1v1Receive.msgId_ = this.msgId_;
                chat1v1Receive.timestamp_ = this.timestamp_;
                chat1v1Receive.distance_ = this.distance_;
                if ((this.bitField0_ & 1) != 0) {
                    this.coords_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                chat1v1Receive.coords_ = this.coords_;
                chat1v1Receive.sessionStatus_ = this.sessionStatus_;
                chat1v1Receive.isDeleted_ = this.isDeleted_;
                chat1v1Receive.isRead_ = this.isRead_;
                SingleFieldBuilderV3<PushBodyOuterClass.PushBody, PushBodyOuterClass.PushBody.Builder, PushBodyOuterClass.PushBodyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
                if (singleFieldBuilderV3 == null) {
                    chat1v1Receive.body_ = this.body_;
                } else {
                    chat1v1Receive.body_ = singleFieldBuilderV3.build();
                }
                chat1v1Receive.sessionType_ = this.sessionType_;
                chat1v1Receive.phoneSessionId_ = this.phoneSessionId_;
                chat1v1Receive.sessionCommonStatus_ = this.sessionCommonStatus_;
                onBuilt();
                return chat1v1Receive;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.from_ = 0;
                this.to_ = 0;
                this.msgType_ = 0;
                this.msgId_ = 0L;
                this.timestamp_ = 0L;
                this.distance_ = "";
                this.coords_ = Chat1v1Receive.access$8200();
                this.bitField0_ &= -2;
                this.sessionStatus_ = 0;
                this.isDeleted_ = false;
                this.isRead_ = false;
                if (this.bodyBuilder_ == null) {
                    this.body_ = null;
                } else {
                    this.body_ = null;
                    this.bodyBuilder_ = null;
                }
                this.sessionType_ = 0;
                this.phoneSessionId_ = 0;
                this.sessionCommonStatus_ = "";
                return this;
            }

            public Builder clearBody() {
                if (this.bodyBuilder_ == null) {
                    this.body_ = null;
                    onChanged();
                    return this;
                }
                this.body_ = null;
                this.bodyBuilder_ = null;
                return this;
            }

            public Builder clearCoords() {
                this.coords_ = Chat1v1Receive.access$10300();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            public Builder clearDistance() {
                this.distance_ = Chat1v1Receive.getDefaultInstance().getDistance();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearFrom() {
                this.from_ = 0;
                onChanged();
                return this;
            }

            public Builder clearIsDeleted() {
                this.isDeleted_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsRead() {
                this.isRead_ = false;
                onChanged();
                return this;
            }

            public Builder clearMsgId() {
                this.msgId_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearMsgType() {
                this.msgType_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearPhoneSessionId() {
                this.phoneSessionId_ = 0;
                onChanged();
                return this;
            }

            public Builder clearSessionCommonStatus() {
                this.sessionCommonStatus_ = Chat1v1Receive.getDefaultInstance().getSessionCommonStatus();
                onChanged();
                return this;
            }

            public Builder clearSessionStatus() {
                this.sessionStatus_ = 0;
                onChanged();
                return this;
            }

            public Builder clearSessionType() {
                this.sessionType_ = 0;
                onChanged();
                return this;
            }

            public Builder clearTimestamp() {
                this.timestamp_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearTo() {
                this.to_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo2030clone() {
                return (Builder) super.mo2030clone();
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReceiveOrBuilder
            public PushBodyOuterClass.PushBody getBody() {
                SingleFieldBuilderV3<PushBodyOuterClass.PushBody, PushBodyOuterClass.PushBody.Builder, PushBodyOuterClass.PushBodyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
                if (singleFieldBuilderV3 == null) {
                    PushBodyOuterClass.PushBody pushBody = this.body_;
                    PushBodyOuterClass.PushBody pushBody2 = pushBody;
                    if (pushBody == null) {
                        pushBody2 = PushBodyOuterClass.PushBody.getDefaultInstance();
                    }
                    return pushBody2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public PushBodyOuterClass.PushBody.Builder getBodyBuilder() {
                onChanged();
                return getBodyFieldBuilder().getBuilder();
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReceiveOrBuilder
            public PushBodyOuterClass.PushBodyOrBuilder getBodyOrBuilder() {
                SingleFieldBuilderV3<PushBodyOuterClass.PushBody, PushBodyOuterClass.PushBody.Builder, PushBodyOuterClass.PushBodyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                PushBodyOuterClass.PushBody pushBody = this.body_;
                PushBodyOuterClass.PushBody pushBody2 = pushBody;
                if (pushBody == null) {
                    pushBody2 = PushBodyOuterClass.PushBody.getDefaultInstance();
                }
                return pushBody2;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReceiveOrBuilder
            public double getCoords(int i) {
                return this.coords_.getDouble(i);
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReceiveOrBuilder
            public int getCoordsCount() {
                return this.coords_.size();
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReceiveOrBuilder
            public List<Double> getCoordsList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.coords_) : this.coords_;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Chat1v1Receive getDefaultInstanceForType() {
                return Chat1v1Receive.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Chat1V1.internal_static_com_blued_im_private_chat_Chat1v1Receive_descriptor;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReceiveOrBuilder
            public String getDistance() {
                Object obj = this.distance_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.distance_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReceiveOrBuilder
            public ByteString getDistanceBytes() {
                Object obj = this.distance_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.distance_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReceiveOrBuilder
            public int getFrom() {
                return this.from_;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReceiveOrBuilder
            public boolean getIsDeleted() {
                return this.isDeleted_;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReceiveOrBuilder
            public boolean getIsRead() {
                return this.isRead_;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReceiveOrBuilder
            public long getMsgId() {
                return this.msgId_;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReceiveOrBuilder
            public MsgTypeOuterClass.MsgType getMsgType() {
                MsgTypeOuterClass.MsgType valueOf = MsgTypeOuterClass.MsgType.valueOf(this.msgType_);
                MsgTypeOuterClass.MsgType msgType = valueOf;
                if (valueOf == null) {
                    msgType = MsgTypeOuterClass.MsgType.UNRECOGNIZED;
                }
                return msgType;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReceiveOrBuilder
            public int getMsgTypeValue() {
                return this.msgType_;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReceiveOrBuilder
            public int getPhoneSessionId() {
                return this.phoneSessionId_;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReceiveOrBuilder
            public String getSessionCommonStatus() {
                Object obj = this.sessionCommonStatus_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.sessionCommonStatus_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReceiveOrBuilder
            public ByteString getSessionCommonStatusBytes() {
                Object obj = this.sessionCommonStatus_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.sessionCommonStatus_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReceiveOrBuilder
            public int getSessionStatus() {
                return this.sessionStatus_;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReceiveOrBuilder
            public int getSessionType() {
                return this.sessionType_;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReceiveOrBuilder
            public long getTimestamp() {
                return this.timestamp_;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReceiveOrBuilder
            public int getTo() {
                return this.to_;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReceiveOrBuilder
            public boolean hasBody() {
                return (this.bodyBuilder_ == null && this.body_ == null) ? false : true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Chat1V1.internal_static_com_blued_im_private_chat_Chat1v1Receive_fieldAccessorTable.ensureFieldAccessorsInitialized(Chat1v1Receive.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeBody(PushBodyOuterClass.PushBody pushBody) {
                SingleFieldBuilderV3<PushBodyOuterClass.PushBody, PushBodyOuterClass.PushBody.Builder, PushBodyOuterClass.PushBodyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(pushBody);
                    return this;
                }
                PushBodyOuterClass.PushBody pushBody2 = this.body_;
                if (pushBody2 != null) {
                    this.body_ = PushBodyOuterClass.PushBody.newBuilder(pushBody2).mergeFrom(pushBody).buildPartial();
                } else {
                    this.body_ = pushBody;
                }
                onChanged();
                return this;
            }

            public Builder mergeFrom(Chat1v1Receive chat1v1Receive) {
                if (chat1v1Receive == Chat1v1Receive.getDefaultInstance()) {
                    return this;
                }
                if (chat1v1Receive.getFrom() != 0) {
                    setFrom(chat1v1Receive.getFrom());
                }
                if (chat1v1Receive.getTo() != 0) {
                    setTo(chat1v1Receive.getTo());
                }
                if (chat1v1Receive.msgType_ != 0) {
                    setMsgTypeValue(chat1v1Receive.getMsgTypeValue());
                }
                if (chat1v1Receive.getMsgId() != 0) {
                    setMsgId(chat1v1Receive.getMsgId());
                }
                if (chat1v1Receive.getTimestamp() != 0) {
                    setTimestamp(chat1v1Receive.getTimestamp());
                }
                if (!chat1v1Receive.getDistance().isEmpty()) {
                    this.distance_ = chat1v1Receive.distance_;
                    onChanged();
                }
                if (!chat1v1Receive.coords_.isEmpty()) {
                    if (this.coords_.isEmpty()) {
                        this.coords_ = chat1v1Receive.coords_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureCoordsIsMutable();
                        this.coords_.addAll(chat1v1Receive.coords_);
                    }
                    onChanged();
                }
                if (chat1v1Receive.getSessionStatus() != 0) {
                    setSessionStatus(chat1v1Receive.getSessionStatus());
                }
                if (chat1v1Receive.getIsDeleted()) {
                    setIsDeleted(chat1v1Receive.getIsDeleted());
                }
                if (chat1v1Receive.getIsRead()) {
                    setIsRead(chat1v1Receive.getIsRead());
                }
                if (chat1v1Receive.hasBody()) {
                    mergeBody(chat1v1Receive.getBody());
                }
                if (chat1v1Receive.getSessionType() != 0) {
                    setSessionType(chat1v1Receive.getSessionType());
                }
                if (chat1v1Receive.getPhoneSessionId() != 0) {
                    setPhoneSessionId(chat1v1Receive.getPhoneSessionId());
                }
                if (!chat1v1Receive.getSessionCommonStatus().isEmpty()) {
                    this.sessionCommonStatus_ = chat1v1Receive.sessionCommonStatus_;
                    onChanged();
                }
                mergeUnknownFields(chat1v1Receive.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.im.private_chat.Chat1V1.Chat1v1Receive.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.im.private_chat.Chat1V1.Chat1v1Receive.access$9900()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.im.private_chat.Chat1V1$Chat1v1Receive r0 = (com.blued.im.private_chat.Chat1V1.Chat1v1Receive) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.im.private_chat.Chat1V1$Chat1v1Receive$Builder r0 = r0.mergeFrom(r1)
                L1a:
                    r0 = r4
                    return r0
                L1c:
                    r6 = move-exception
                    r0 = r7
                    r5 = r0
                    goto L31
                L22:
                    r6 = move-exception
                    r0 = r6
                    com.google.protobuf.MessageLite r0 = r0.getUnfinishedMessage()     // Catch: java.lang.Throwable -> L1c
                    com.blued.im.private_chat.Chat1V1$Chat1v1Receive r0 = (com.blued.im.private_chat.Chat1V1.Chat1v1Receive) r0     // Catch: java.lang.Throwable -> L1c
                    r5 = r0
                    r0 = r6
                    java.io.IOException r0 = r0.unwrapIOException()     // Catch: java.lang.Throwable -> L30
                    throw r0     // Catch: java.lang.Throwable -> L30
                L30:
                    r6 = move-exception
                L31:
                    r0 = r5
                    if (r0 == 0) goto L3b
                    r0 = r4
                    r1 = r5
                    com.blued.im.private_chat.Chat1V1$Chat1v1Receive$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.im.private_chat.Chat1V1.Chat1v1Receive.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.im.private_chat.Chat1V1$Chat1v1Receive$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof Chat1v1Receive) {
                    return mergeFrom((Chat1v1Receive) message);
                }
                super.mergeFrom(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder setBody(PushBodyOuterClass.PushBody.Builder builder) {
                SingleFieldBuilderV3<PushBodyOuterClass.PushBody, PushBodyOuterClass.PushBody.Builder, PushBodyOuterClass.PushBodyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.body_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setBody(PushBodyOuterClass.PushBody pushBody) {
                SingleFieldBuilderV3<PushBodyOuterClass.PushBody, PushBodyOuterClass.PushBody.Builder, PushBodyOuterClass.PushBodyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(pushBody);
                    return this;
                } else if (pushBody != null) {
                    this.body_ = pushBody;
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }

            public Builder setCoords(int i, double d) {
                ensureCoordsIsMutable();
                this.coords_.setDouble(i, d);
                onChanged();
                return this;
            }

            public Builder setDistance(String str) {
                if (str != null) {
                    this.distance_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setDistanceBytes(ByteString byteString) {
                if (byteString != null) {
                    Chat1v1Receive.checkByteStringIsUtf8(byteString);
                    this.distance_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setFrom(int i) {
                this.from_ = i;
                onChanged();
                return this;
            }

            public Builder setIsDeleted(boolean z) {
                this.isDeleted_ = z;
                onChanged();
                return this;
            }

            public Builder setIsRead(boolean z) {
                this.isRead_ = z;
                onChanged();
                return this;
            }

            public Builder setMsgId(long j) {
                this.msgId_ = j;
                onChanged();
                return this;
            }

            public Builder setMsgType(MsgTypeOuterClass.MsgType msgType) {
                if (msgType != null) {
                    this.msgType_ = msgType.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setMsgTypeValue(int i) {
                this.msgType_ = i;
                onChanged();
                return this;
            }

            public Builder setPhoneSessionId(int i) {
                this.phoneSessionId_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setSessionCommonStatus(String str) {
                if (str != null) {
                    this.sessionCommonStatus_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setSessionCommonStatusBytes(ByteString byteString) {
                if (byteString != null) {
                    Chat1v1Receive.checkByteStringIsUtf8(byteString);
                    this.sessionCommonStatus_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setSessionStatus(int i) {
                this.sessionStatus_ = i;
                onChanged();
                return this;
            }

            public Builder setSessionType(int i) {
                this.sessionType_ = i;
                onChanged();
                return this;
            }

            public Builder setTimestamp(long j) {
                this.timestamp_ = j;
                onChanged();
                return this;
            }

            public Builder setTo(int i) {
                this.to_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private Chat1v1Receive() {
            this.coordsMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.msgType_ = 0;
            this.distance_ = "";
            this.coords_ = emptyDoubleList();
            this.sessionCommonStatus_ = "";
        }

        private Chat1v1Receive(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            PushBodyOuterClass.PushBody.Builder builder;
            if (extensionRegistryLite == null) {
                throw null;
            }
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                boolean z3 = z2;
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            switch (readTag) {
                                case 0:
                                    break;
                                case 8:
                                    this.from_ = codedInputStream.readUInt32();
                                    continue;
                                case 16:
                                    this.to_ = codedInputStream.readUInt32();
                                    continue;
                                case 24:
                                    this.msgType_ = codedInputStream.readEnum();
                                    continue;
                                case 32:
                                    this.msgId_ = codedInputStream.readInt64();
                                    continue;
                                case 40:
                                    this.timestamp_ = codedInputStream.readInt64();
                                    continue;
                                case 50:
                                    this.distance_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                case 57:
                                    boolean z4 = z2;
                                    if (!(z2 & true)) {
                                        this.coords_ = newDoubleList();
                                        z4 = z2 | true;
                                    }
                                    this.coords_.addDouble(codedInputStream.readDouble());
                                    z2 = z4;
                                    continue;
                                case 58:
                                    int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    boolean z5 = z2;
                                    if (!(z2 & true)) {
                                        z5 = z2;
                                        if (codedInputStream.getBytesUntilLimit() > 0) {
                                            boolean z6 = z2;
                                            this.coords_ = newDoubleList();
                                            z5 = z2 | true;
                                        }
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        boolean z7 = z5;
                                        this.coords_.addDouble(codedInputStream.readDouble());
                                    }
                                    codedInputStream.popLimit(pushLimit);
                                    z2 = z5;
                                    continue;
                                case 64:
                                    this.sessionStatus_ = codedInputStream.readInt32();
                                    continue;
                                case 72:
                                    this.isDeleted_ = codedInputStream.readBool();
                                    continue;
                                case 80:
                                    this.isRead_ = codedInputStream.readBool();
                                    continue;
                                case 90:
                                    if (this.body_ != null) {
                                        boolean z8 = z2;
                                        builder = this.body_.toBuilder();
                                    } else {
                                        builder = null;
                                    }
                                    PushBodyOuterClass.PushBody pushBody = (PushBodyOuterClass.PushBody) codedInputStream.readMessage(PushBodyOuterClass.PushBody.parser(), extensionRegistryLite);
                                    boolean z9 = z2;
                                    this.body_ = pushBody;
                                    if (builder != null) {
                                        builder.mergeFrom(pushBody);
                                        boolean z10 = z2;
                                        this.body_ = builder.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 96:
                                    this.sessionType_ = codedInputStream.readUInt32();
                                    continue;
                                case 104:
                                    this.phoneSessionId_ = codedInputStream.readUInt32();
                                    continue;
                                case 114:
                                    this.sessionCommonStatus_ = codedInputStream.readStringRequireUtf8();
                                    continue;
                                default:
                                    if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                        break;
                                    } else {
                                        continue;
                                    }
                            }
                            z = true;
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if (z3 & true) {
                        this.coords_.makeImmutable();
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 & true) {
                this.coords_.makeImmutable();
            }
            this.unknownFields = newBuilder.build();
            makeExtensionsImmutable();
        }

        private Chat1v1Receive(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.coordsMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
        }

        static /* synthetic */ Internal.DoubleList access$10100() {
            return emptyDoubleList();
        }

        static /* synthetic */ Internal.DoubleList access$10300() {
            return emptyDoubleList();
        }

        static /* synthetic */ Internal.DoubleList access$8200() {
            return emptyDoubleList();
        }

        public static Chat1v1Receive getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Chat1V1.internal_static_com_blued_im_private_chat_Chat1v1Receive_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Chat1v1Receive chat1v1Receive) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(chat1v1Receive);
        }

        public static Chat1v1Receive parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Chat1v1Receive) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Chat1v1Receive parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Chat1v1Receive) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Chat1v1Receive parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Chat1v1Receive parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Chat1v1Receive parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Chat1v1Receive) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Chat1v1Receive parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Chat1v1Receive) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static Chat1v1Receive parseFrom(InputStream inputStream) throws IOException {
            return (Chat1v1Receive) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Chat1v1Receive parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Chat1v1Receive) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Chat1v1Receive parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Chat1v1Receive parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Chat1v1Receive parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Chat1v1Receive parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<Chat1v1Receive> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Chat1v1Receive) {
                Chat1v1Receive chat1v1Receive = (Chat1v1Receive) obj;
                if (getFrom() == chat1v1Receive.getFrom() && getTo() == chat1v1Receive.getTo() && this.msgType_ == chat1v1Receive.msgType_ && getMsgId() == chat1v1Receive.getMsgId() && getTimestamp() == chat1v1Receive.getTimestamp() && getDistance().equals(chat1v1Receive.getDistance()) && getCoordsList().equals(chat1v1Receive.getCoordsList()) && getSessionStatus() == chat1v1Receive.getSessionStatus() && getIsDeleted() == chat1v1Receive.getIsDeleted() && getIsRead() == chat1v1Receive.getIsRead() && hasBody() == chat1v1Receive.hasBody()) {
                    return (!hasBody() || getBody().equals(chat1v1Receive.getBody())) && getSessionType() == chat1v1Receive.getSessionType() && getPhoneSessionId() == chat1v1Receive.getPhoneSessionId() && getSessionCommonStatus().equals(chat1v1Receive.getSessionCommonStatus()) && this.unknownFields.equals(chat1v1Receive.unknownFields);
                }
                return false;
            }
            return super.equals(obj);
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReceiveOrBuilder
        public PushBodyOuterClass.PushBody getBody() {
            PushBodyOuterClass.PushBody pushBody = this.body_;
            PushBodyOuterClass.PushBody pushBody2 = pushBody;
            if (pushBody == null) {
                pushBody2 = PushBodyOuterClass.PushBody.getDefaultInstance();
            }
            return pushBody2;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReceiveOrBuilder
        public PushBodyOuterClass.PushBodyOrBuilder getBodyOrBuilder() {
            return getBody();
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReceiveOrBuilder
        public double getCoords(int i) {
            return this.coords_.getDouble(i);
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReceiveOrBuilder
        public int getCoordsCount() {
            return this.coords_.size();
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReceiveOrBuilder
        public List<Double> getCoordsList() {
            return this.coords_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Chat1v1Receive getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReceiveOrBuilder
        public String getDistance() {
            Object obj = this.distance_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.distance_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReceiveOrBuilder
        public ByteString getDistanceBytes() {
            Object obj = this.distance_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.distance_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReceiveOrBuilder
        public int getFrom() {
            return this.from_;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReceiveOrBuilder
        public boolean getIsDeleted() {
            return this.isDeleted_;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReceiveOrBuilder
        public boolean getIsRead() {
            return this.isRead_;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReceiveOrBuilder
        public long getMsgId() {
            return this.msgId_;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReceiveOrBuilder
        public MsgTypeOuterClass.MsgType getMsgType() {
            MsgTypeOuterClass.MsgType valueOf = MsgTypeOuterClass.MsgType.valueOf(this.msgType_);
            MsgTypeOuterClass.MsgType msgType = valueOf;
            if (valueOf == null) {
                msgType = MsgTypeOuterClass.MsgType.UNRECOGNIZED;
            }
            return msgType;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReceiveOrBuilder
        public int getMsgTypeValue() {
            return this.msgType_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Chat1v1Receive> getParserForType() {
            return PARSER;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReceiveOrBuilder
        public int getPhoneSessionId() {
            return this.phoneSessionId_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            int i3 = this.from_;
            if (i3 != 0) {
                i2 = 0 + CodedOutputStream.computeUInt32Size(1, i3);
            }
            int i4 = this.to_;
            int i5 = i2;
            if (i4 != 0) {
                i5 = i2 + CodedOutputStream.computeUInt32Size(2, i4);
            }
            int i6 = i5;
            if (this.msgType_ != MsgTypeOuterClass.MsgType.UNKNOWN_MSG_TYPE.getNumber()) {
                i6 = i5 + CodedOutputStream.computeEnumSize(3, this.msgType_);
            }
            long j = this.msgId_;
            int i7 = i6;
            if (j != 0) {
                i7 = i6 + CodedOutputStream.computeInt64Size(4, j);
            }
            long j2 = this.timestamp_;
            int i8 = i7;
            if (j2 != 0) {
                i8 = i7 + CodedOutputStream.computeInt64Size(5, j2);
            }
            int i9 = i8;
            if (!getDistanceBytes().isEmpty()) {
                i9 = i8 + GeneratedMessageV3.computeStringSize(6, this.distance_);
            }
            int size = getCoordsList().size() * 8;
            int i10 = i9 + size;
            int i11 = i10;
            if (!getCoordsList().isEmpty()) {
                i11 = i10 + 1 + CodedOutputStream.computeInt32SizeNoTag(size);
            }
            this.coordsMemoizedSerializedSize = size;
            int i12 = this.sessionStatus_;
            int i13 = i11;
            if (i12 != 0) {
                i13 = i11 + CodedOutputStream.computeInt32Size(8, i12);
            }
            boolean z = this.isDeleted_;
            int i14 = i13;
            if (z) {
                i14 = i13 + CodedOutputStream.computeBoolSize(9, z);
            }
            boolean z2 = this.isRead_;
            int i15 = i14;
            if (z2) {
                i15 = i14 + CodedOutputStream.computeBoolSize(10, z2);
            }
            int i16 = i15;
            if (this.body_ != null) {
                i16 = i15 + CodedOutputStream.computeMessageSize(11, getBody());
            }
            int i17 = this.sessionType_;
            int i18 = i16;
            if (i17 != 0) {
                i18 = i16 + CodedOutputStream.computeUInt32Size(12, i17);
            }
            int i19 = this.phoneSessionId_;
            int i20 = i18;
            if (i19 != 0) {
                i20 = i18 + CodedOutputStream.computeUInt32Size(13, i19);
            }
            int i21 = i20;
            if (!getSessionCommonStatusBytes().isEmpty()) {
                i21 = i20 + GeneratedMessageV3.computeStringSize(14, this.sessionCommonStatus_);
            }
            int serializedSize = i21 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReceiveOrBuilder
        public String getSessionCommonStatus() {
            Object obj = this.sessionCommonStatus_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.sessionCommonStatus_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReceiveOrBuilder
        public ByteString getSessionCommonStatusBytes() {
            Object obj = this.sessionCommonStatus_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.sessionCommonStatus_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReceiveOrBuilder
        public int getSessionStatus() {
            return this.sessionStatus_;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReceiveOrBuilder
        public int getSessionType() {
            return this.sessionType_;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReceiveOrBuilder
        public long getTimestamp() {
            return this.timestamp_;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReceiveOrBuilder
        public int getTo() {
            return this.to_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReceiveOrBuilder
        public boolean hasBody() {
            return this.body_ != null;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getFrom()) * 37) + 2) * 53) + getTo()) * 37) + 3) * 53) + this.msgType_) * 37) + 4) * 53) + Internal.hashLong(getMsgId())) * 37) + 5) * 53) + Internal.hashLong(getTimestamp())) * 37) + 6) * 53) + getDistance().hashCode();
            int i = hashCode;
            if (getCoordsCount() > 0) {
                i = (((hashCode * 37) + 7) * 53) + getCoordsList().hashCode();
            }
            int sessionStatus = (((((((((((i * 37) + 8) * 53) + getSessionStatus()) * 37) + 9) * 53) + Internal.hashBoolean(getIsDeleted())) * 37) + 10) * 53) + Internal.hashBoolean(getIsRead());
            int i2 = sessionStatus;
            if (hasBody()) {
                i2 = (((sessionStatus * 37) + 11) * 53) + getBody().hashCode();
            }
            int sessionType = (((((((((((((i2 * 37) + 12) * 53) + getSessionType()) * 37) + 13) * 53) + getPhoneSessionId()) * 37) + 14) * 53) + getSessionCommonStatus().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = sessionType;
            return sessionType;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Chat1V1.internal_static_com_blued_im_private_chat_Chat1v1Receive_fieldAccessorTable.ensureFieldAccessorsInitialized(Chat1v1Receive.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new Chat1v1Receive();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            int i = this.from_;
            if (i != 0) {
                codedOutputStream.writeUInt32(1, i);
            }
            int i2 = this.to_;
            if (i2 != 0) {
                codedOutputStream.writeUInt32(2, i2);
            }
            if (this.msgType_ != MsgTypeOuterClass.MsgType.UNKNOWN_MSG_TYPE.getNumber()) {
                codedOutputStream.writeEnum(3, this.msgType_);
            }
            long j = this.msgId_;
            if (j != 0) {
                codedOutputStream.writeInt64(4, j);
            }
            long j2 = this.timestamp_;
            if (j2 != 0) {
                codedOutputStream.writeInt64(5, j2);
            }
            if (!getDistanceBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 6, this.distance_);
            }
            if (getCoordsList().size() > 0) {
                codedOutputStream.writeUInt32NoTag(58);
                codedOutputStream.writeUInt32NoTag(this.coordsMemoizedSerializedSize);
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= this.coords_.size()) {
                    break;
                }
                codedOutputStream.writeDoubleNoTag(this.coords_.getDouble(i4));
                i3 = i4 + 1;
            }
            int i5 = this.sessionStatus_;
            if (i5 != 0) {
                codedOutputStream.writeInt32(8, i5);
            }
            boolean z = this.isDeleted_;
            if (z) {
                codedOutputStream.writeBool(9, z);
            }
            boolean z2 = this.isRead_;
            if (z2) {
                codedOutputStream.writeBool(10, z2);
            }
            if (this.body_ != null) {
                codedOutputStream.writeMessage(11, getBody());
            }
            int i6 = this.sessionType_;
            if (i6 != 0) {
                codedOutputStream.writeUInt32(12, i6);
            }
            int i7 = this.phoneSessionId_;
            if (i7 != 0) {
                codedOutputStream.writeUInt32(13, i7);
            }
            if (!getSessionCommonStatusBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 14, this.sessionCommonStatus_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/Chat1V1$Chat1v1ReceiveOrBuilder.class */
    public interface Chat1v1ReceiveOrBuilder extends MessageOrBuilder {
        PushBodyOuterClass.PushBody getBody();

        PushBodyOuterClass.PushBodyOrBuilder getBodyOrBuilder();

        double getCoords(int i);

        int getCoordsCount();

        List<Double> getCoordsList();

        String getDistance();

        ByteString getDistanceBytes();

        int getFrom();

        boolean getIsDeleted();

        boolean getIsRead();

        long getMsgId();

        MsgTypeOuterClass.MsgType getMsgType();

        int getMsgTypeValue();

        int getPhoneSessionId();

        String getSessionCommonStatus();

        ByteString getSessionCommonStatusBytes();

        int getSessionStatus();

        int getSessionType();

        long getTimestamp();

        int getTo();

        boolean hasBody();
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/Chat1V1$Chat1v1ReqBody.class */
    public static final class Chat1v1ReqBody extends GeneratedMessageV3 implements Chat1v1ReqBodyOrBuilder {
        public static final int CHAT_SDK_TYPE_FIELD_NUMBER = 4;
        public static final int CONSUME_BEANS_FIELD_NUMBER = 7;
        public static final int INVITED_UID_FIELD_NUMBER = 1;
        public static final int REASON_FIELD_NUMBER = 5;
        public static final int ROOM_ID_FIELD_NUMBER = 2;
        public static final int ROOM_TYPE_FIELD_NUMBER = 3;
        public static final int STREAM_ID_FIELD_NUMBER = 8;
        public static final int TOTAL_TIME_FIELD_NUMBER = 6;
        private static final long serialVersionUID = 0;
        private int chatSdkType_;
        private long consumeBeans_;
        private int invitedUid_;
        private byte memoizedIsInitialized;
        private int reason_;
        private volatile Object roomId_;
        private int roomType_;
        private volatile Object streamId_;
        private long totalTime_;
        private static final Chat1v1ReqBody DEFAULT_INSTANCE = new Chat1v1ReqBody();
        private static final Parser<Chat1v1ReqBody> PARSER = new AbstractParser<Chat1v1ReqBody>() { // from class: com.blued.im.private_chat.Chat1V1.Chat1v1ReqBody.1
            @Override // com.google.protobuf.Parser
            public Chat1v1ReqBody parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Chat1v1ReqBody(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/Chat1V1$Chat1v1ReqBody$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Chat1v1ReqBodyOrBuilder {
            private int chatSdkType_;
            private long consumeBeans_;
            private int invitedUid_;
            private int reason_;
            private Object roomId_;
            private int roomType_;
            private Object streamId_;
            private long totalTime_;

            private Builder() {
                this.roomId_ = "";
                this.streamId_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.roomId_ = "";
                this.streamId_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Chat1V1.internal_static_com_blued_im_private_chat_Chat1v1ReqBody_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = Chat1v1ReqBody.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Chat1v1ReqBody build() {
                Chat1v1ReqBody buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Chat1v1ReqBody buildPartial() {
                Chat1v1ReqBody chat1v1ReqBody = new Chat1v1ReqBody(this);
                chat1v1ReqBody.invitedUid_ = this.invitedUid_;
                chat1v1ReqBody.roomId_ = this.roomId_;
                chat1v1ReqBody.roomType_ = this.roomType_;
                chat1v1ReqBody.chatSdkType_ = this.chatSdkType_;
                chat1v1ReqBody.reason_ = this.reason_;
                chat1v1ReqBody.totalTime_ = this.totalTime_;
                chat1v1ReqBody.consumeBeans_ = this.consumeBeans_;
                chat1v1ReqBody.streamId_ = this.streamId_;
                onBuilt();
                return chat1v1ReqBody;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.invitedUid_ = 0;
                this.roomId_ = "";
                this.roomType_ = 0;
                this.chatSdkType_ = 0;
                this.reason_ = 0;
                this.totalTime_ = 0L;
                this.consumeBeans_ = 0L;
                this.streamId_ = "";
                return this;
            }

            public Builder clearChatSdkType() {
                this.chatSdkType_ = 0;
                onChanged();
                return this;
            }

            public Builder clearConsumeBeans() {
                this.consumeBeans_ = 0L;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearInvitedUid() {
                this.invitedUid_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearReason() {
                this.reason_ = 0;
                onChanged();
                return this;
            }

            public Builder clearRoomId() {
                this.roomId_ = Chat1v1ReqBody.getDefaultInstance().getRoomId();
                onChanged();
                return this;
            }

            public Builder clearRoomType() {
                this.roomType_ = 0;
                onChanged();
                return this;
            }

            public Builder clearStreamId() {
                this.streamId_ = Chat1v1ReqBody.getDefaultInstance().getStreamId();
                onChanged();
                return this;
            }

            public Builder clearTotalTime() {
                this.totalTime_ = 0L;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo2030clone() {
                return (Builder) super.mo2030clone();
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReqBodyOrBuilder
            public int getChatSdkType() {
                return this.chatSdkType_;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReqBodyOrBuilder
            public long getConsumeBeans() {
                return this.consumeBeans_;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Chat1v1ReqBody getDefaultInstanceForType() {
                return Chat1v1ReqBody.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Chat1V1.internal_static_com_blued_im_private_chat_Chat1v1ReqBody_descriptor;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReqBodyOrBuilder
            public int getInvitedUid() {
                return this.invitedUid_;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReqBodyOrBuilder
            public int getReason() {
                return this.reason_;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReqBodyOrBuilder
            public String getRoomId() {
                Object obj = this.roomId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.roomId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReqBodyOrBuilder
            public ByteString getRoomIdBytes() {
                Object obj = this.roomId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.roomId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReqBodyOrBuilder
            public int getRoomType() {
                return this.roomType_;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReqBodyOrBuilder
            public String getStreamId() {
                Object obj = this.streamId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.streamId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReqBodyOrBuilder
            public ByteString getStreamIdBytes() {
                Object obj = this.streamId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.streamId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReqBodyOrBuilder
            public long getTotalTime() {
                return this.totalTime_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Chat1V1.internal_static_com_blued_im_private_chat_Chat1v1ReqBody_fieldAccessorTable.ensureFieldAccessorsInitialized(Chat1v1ReqBody.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(Chat1v1ReqBody chat1v1ReqBody) {
                if (chat1v1ReqBody == Chat1v1ReqBody.getDefaultInstance()) {
                    return this;
                }
                if (chat1v1ReqBody.getInvitedUid() != 0) {
                    setInvitedUid(chat1v1ReqBody.getInvitedUid());
                }
                if (!chat1v1ReqBody.getRoomId().isEmpty()) {
                    this.roomId_ = chat1v1ReqBody.roomId_;
                    onChanged();
                }
                if (chat1v1ReqBody.getRoomType() != 0) {
                    setRoomType(chat1v1ReqBody.getRoomType());
                }
                if (chat1v1ReqBody.getChatSdkType() != 0) {
                    setChatSdkType(chat1v1ReqBody.getChatSdkType());
                }
                if (chat1v1ReqBody.getReason() != 0) {
                    setReason(chat1v1ReqBody.getReason());
                }
                if (chat1v1ReqBody.getTotalTime() != 0) {
                    setTotalTime(chat1v1ReqBody.getTotalTime());
                }
                if (chat1v1ReqBody.getConsumeBeans() != 0) {
                    setConsumeBeans(chat1v1ReqBody.getConsumeBeans());
                }
                if (!chat1v1ReqBody.getStreamId().isEmpty()) {
                    this.streamId_ = chat1v1ReqBody.streamId_;
                    onChanged();
                }
                mergeUnknownFields(chat1v1ReqBody.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.im.private_chat.Chat1V1.Chat1v1ReqBody.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.im.private_chat.Chat1V1.Chat1v1ReqBody.access$3200()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.im.private_chat.Chat1V1$Chat1v1ReqBody r0 = (com.blued.im.private_chat.Chat1V1.Chat1v1ReqBody) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.im.private_chat.Chat1V1$Chat1v1ReqBody$Builder r0 = r0.mergeFrom(r1)
                L1a:
                    r0 = r4
                    return r0
                L1c:
                    r6 = move-exception
                    r0 = r7
                    r5 = r0
                    goto L31
                L22:
                    r6 = move-exception
                    r0 = r6
                    com.google.protobuf.MessageLite r0 = r0.getUnfinishedMessage()     // Catch: java.lang.Throwable -> L1c
                    com.blued.im.private_chat.Chat1V1$Chat1v1ReqBody r0 = (com.blued.im.private_chat.Chat1V1.Chat1v1ReqBody) r0     // Catch: java.lang.Throwable -> L1c
                    r5 = r0
                    r0 = r6
                    java.io.IOException r0 = r0.unwrapIOException()     // Catch: java.lang.Throwable -> L30
                    throw r0     // Catch: java.lang.Throwable -> L30
                L30:
                    r6 = move-exception
                L31:
                    r0 = r5
                    if (r0 == 0) goto L3b
                    r0 = r4
                    r1 = r5
                    com.blued.im.private_chat.Chat1V1$Chat1v1ReqBody$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.im.private_chat.Chat1V1.Chat1v1ReqBody.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.im.private_chat.Chat1V1$Chat1v1ReqBody$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof Chat1v1ReqBody) {
                    return mergeFrom((Chat1v1ReqBody) message);
                }
                super.mergeFrom(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder setChatSdkType(int i) {
                this.chatSdkType_ = i;
                onChanged();
                return this;
            }

            public Builder setConsumeBeans(long j) {
                this.consumeBeans_ = j;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setInvitedUid(int i) {
                this.invitedUid_ = i;
                onChanged();
                return this;
            }

            public Builder setReason(int i) {
                this.reason_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setRoomId(String str) {
                if (str != null) {
                    this.roomId_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setRoomIdBytes(ByteString byteString) {
                if (byteString != null) {
                    Chat1v1ReqBody.checkByteStringIsUtf8(byteString);
                    this.roomId_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setRoomType(int i) {
                this.roomType_ = i;
                onChanged();
                return this;
            }

            public Builder setStreamId(String str) {
                if (str != null) {
                    this.streamId_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setStreamIdBytes(ByteString byteString) {
                if (byteString != null) {
                    Chat1v1ReqBody.checkByteStringIsUtf8(byteString);
                    this.streamId_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setTotalTime(long j) {
                this.totalTime_ = j;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private Chat1v1ReqBody() {
            this.memoizedIsInitialized = (byte) -1;
            this.roomId_ = "";
            this.streamId_ = "";
        }

        private Chat1v1ReqBody(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw null;
            }
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.invitedUid_ = codedInputStream.readUInt32();
                            } else if (readTag == 18) {
                                this.roomId_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 24) {
                                this.roomType_ = codedInputStream.readUInt32();
                            } else if (readTag == 32) {
                                this.chatSdkType_ = codedInputStream.readUInt32();
                            } else if (readTag == 40) {
                                this.reason_ = codedInputStream.readUInt32();
                            } else if (readTag == 48) {
                                this.totalTime_ = codedInputStream.readInt64();
                            } else if (readTag == 56) {
                                this.consumeBeans_ = codedInputStream.readInt64();
                            } else if (readTag == 66) {
                                this.streamId_ = codedInputStream.readStringRequireUtf8();
                            } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        private Chat1v1ReqBody(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Chat1v1ReqBody getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Chat1V1.internal_static_com_blued_im_private_chat_Chat1v1ReqBody_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Chat1v1ReqBody chat1v1ReqBody) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(chat1v1ReqBody);
        }

        public static Chat1v1ReqBody parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Chat1v1ReqBody) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Chat1v1ReqBody parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Chat1v1ReqBody) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Chat1v1ReqBody parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Chat1v1ReqBody parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Chat1v1ReqBody parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Chat1v1ReqBody) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Chat1v1ReqBody parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Chat1v1ReqBody) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static Chat1v1ReqBody parseFrom(InputStream inputStream) throws IOException {
            return (Chat1v1ReqBody) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Chat1v1ReqBody parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Chat1v1ReqBody) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Chat1v1ReqBody parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Chat1v1ReqBody parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Chat1v1ReqBody parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Chat1v1ReqBody parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<Chat1v1ReqBody> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Chat1v1ReqBody) {
                Chat1v1ReqBody chat1v1ReqBody = (Chat1v1ReqBody) obj;
                return getInvitedUid() == chat1v1ReqBody.getInvitedUid() && getRoomId().equals(chat1v1ReqBody.getRoomId()) && getRoomType() == chat1v1ReqBody.getRoomType() && getChatSdkType() == chat1v1ReqBody.getChatSdkType() && getReason() == chat1v1ReqBody.getReason() && getTotalTime() == chat1v1ReqBody.getTotalTime() && getConsumeBeans() == chat1v1ReqBody.getConsumeBeans() && getStreamId().equals(chat1v1ReqBody.getStreamId()) && this.unknownFields.equals(chat1v1ReqBody.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReqBodyOrBuilder
        public int getChatSdkType() {
            return this.chatSdkType_;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReqBodyOrBuilder
        public long getConsumeBeans() {
            return this.consumeBeans_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Chat1v1ReqBody getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReqBodyOrBuilder
        public int getInvitedUid() {
            return this.invitedUid_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Chat1v1ReqBody> getParserForType() {
            return PARSER;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReqBodyOrBuilder
        public int getReason() {
            return this.reason_;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReqBodyOrBuilder
        public String getRoomId() {
            Object obj = this.roomId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.roomId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReqBodyOrBuilder
        public ByteString getRoomIdBytes() {
            Object obj = this.roomId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.roomId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReqBodyOrBuilder
        public int getRoomType() {
            return this.roomType_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            int i3 = this.invitedUid_;
            if (i3 != 0) {
                i2 = 0 + CodedOutputStream.computeUInt32Size(1, i3);
            }
            int i4 = i2;
            if (!getRoomIdBytes().isEmpty()) {
                i4 = i2 + GeneratedMessageV3.computeStringSize(2, this.roomId_);
            }
            int i5 = this.roomType_;
            int i6 = i4;
            if (i5 != 0) {
                i6 = i4 + CodedOutputStream.computeUInt32Size(3, i5);
            }
            int i7 = this.chatSdkType_;
            int i8 = i6;
            if (i7 != 0) {
                i8 = i6 + CodedOutputStream.computeUInt32Size(4, i7);
            }
            int i9 = this.reason_;
            int i10 = i8;
            if (i9 != 0) {
                i10 = i8 + CodedOutputStream.computeUInt32Size(5, i9);
            }
            long j = this.totalTime_;
            int i11 = i10;
            if (j != 0) {
                i11 = i10 + CodedOutputStream.computeInt64Size(6, j);
            }
            long j2 = this.consumeBeans_;
            int i12 = i11;
            if (j2 != 0) {
                i12 = i11 + CodedOutputStream.computeInt64Size(7, j2);
            }
            int i13 = i12;
            if (!getStreamIdBytes().isEmpty()) {
                i13 = i12 + GeneratedMessageV3.computeStringSize(8, this.streamId_);
            }
            int serializedSize = i13 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReqBodyOrBuilder
        public String getStreamId() {
            Object obj = this.streamId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.streamId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReqBodyOrBuilder
        public ByteString getStreamIdBytes() {
            Object obj = this.streamId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.streamId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ReqBodyOrBuilder
        public long getTotalTime() {
            return this.totalTime_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getInvitedUid()) * 37) + 2) * 53) + getRoomId().hashCode()) * 37) + 3) * 53) + getRoomType()) * 37) + 4) * 53) + getChatSdkType()) * 37) + 5) * 53) + getReason()) * 37) + 6) * 53) + Internal.hashLong(getTotalTime())) * 37) + 7) * 53) + Internal.hashLong(getConsumeBeans())) * 37) + 8) * 53) + getStreamId().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Chat1V1.internal_static_com_blued_im_private_chat_Chat1v1ReqBody_fieldAccessorTable.ensureFieldAccessorsInitialized(Chat1v1ReqBody.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new Chat1v1ReqBody();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i = this.invitedUid_;
            if (i != 0) {
                codedOutputStream.writeUInt32(1, i);
            }
            if (!getRoomIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.roomId_);
            }
            int i2 = this.roomType_;
            if (i2 != 0) {
                codedOutputStream.writeUInt32(3, i2);
            }
            int i3 = this.chatSdkType_;
            if (i3 != 0) {
                codedOutputStream.writeUInt32(4, i3);
            }
            int i4 = this.reason_;
            if (i4 != 0) {
                codedOutputStream.writeUInt32(5, i4);
            }
            long j = this.totalTime_;
            if (j != 0) {
                codedOutputStream.writeInt64(6, j);
            }
            long j2 = this.consumeBeans_;
            if (j2 != 0) {
                codedOutputStream.writeInt64(7, j2);
            }
            if (!getStreamIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 8, this.streamId_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/Chat1V1$Chat1v1ReqBodyOrBuilder.class */
    public interface Chat1v1ReqBodyOrBuilder extends MessageOrBuilder {
        int getChatSdkType();

        long getConsumeBeans();

        int getInvitedUid();

        int getReason();

        String getRoomId();

        ByteString getRoomIdBytes();

        int getRoomType();

        String getStreamId();

        ByteString getStreamIdBytes();

        long getTotalTime();
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/Chat1V1$Chat1v1Request.class */
    public static final class Chat1v1Request extends GeneratedMessageV3 implements Chat1v1RequestOrBuilder {
        public static final int BODY_FIELD_NUMBER = 6;
        public static final int COMMON_FIELD_NUMBER = 1;
        public static final int CORRELATION_ID_FIELD_NUMBER = 4;
        public static final int DELIVERY_TAG_FIELD_NUMBER = 5;
        public static final int LOCAL_ID_FIELD_NUMBER = 3;
        public static final int REQ_TYPE_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private Chat1v1ReqBody body_;
        private CommonOuterClass.Common common_;
        private volatile Object correlationId_;
        private volatile Object deliveryTag_;
        private int localId_;
        private byte memoizedIsInitialized;
        private int reqType_;
        private static final Chat1v1Request DEFAULT_INSTANCE = new Chat1v1Request();
        private static final Parser<Chat1v1Request> PARSER = new AbstractParser<Chat1v1Request>() { // from class: com.blued.im.private_chat.Chat1V1.Chat1v1Request.1
            @Override // com.google.protobuf.Parser
            public Chat1v1Request parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Chat1v1Request(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/Chat1V1$Chat1v1Request$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Chat1v1RequestOrBuilder {
            private SingleFieldBuilderV3<Chat1v1ReqBody, Chat1v1ReqBody.Builder, Chat1v1ReqBodyOrBuilder> bodyBuilder_;
            private Chat1v1ReqBody body_;
            private SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> commonBuilder_;
            private CommonOuterClass.Common common_;
            private Object correlationId_;
            private Object deliveryTag_;
            private int localId_;
            private int reqType_;

            private Builder() {
                this.reqType_ = 0;
                this.correlationId_ = "";
                this.deliveryTag_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.reqType_ = 0;
                this.correlationId_ = "";
                this.deliveryTag_ = "";
                maybeForceBuilderInitialization();
            }

            private SingleFieldBuilderV3<Chat1v1ReqBody, Chat1v1ReqBody.Builder, Chat1v1ReqBodyOrBuilder> getBodyFieldBuilder() {
                if (this.bodyBuilder_ == null) {
                    this.bodyBuilder_ = new SingleFieldBuilderV3<>(getBody(), getParentForChildren(), isClean());
                    this.body_ = null;
                }
                return this.bodyBuilder_;
            }

            private SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> getCommonFieldBuilder() {
                if (this.commonBuilder_ == null) {
                    this.commonBuilder_ = new SingleFieldBuilderV3<>(getCommon(), getParentForChildren(), isClean());
                    this.common_ = null;
                }
                return this.commonBuilder_;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Chat1V1.internal_static_com_blued_im_private_chat_Chat1v1Request_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = Chat1v1Request.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Chat1v1Request build() {
                Chat1v1Request buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Chat1v1Request buildPartial() {
                Chat1v1Request chat1v1Request = new Chat1v1Request(this);
                SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 == null) {
                    chat1v1Request.common_ = this.common_;
                } else {
                    chat1v1Request.common_ = singleFieldBuilderV3.build();
                }
                chat1v1Request.reqType_ = this.reqType_;
                chat1v1Request.localId_ = this.localId_;
                chat1v1Request.correlationId_ = this.correlationId_;
                chat1v1Request.deliveryTag_ = this.deliveryTag_;
                SingleFieldBuilderV3<Chat1v1ReqBody, Chat1v1ReqBody.Builder, Chat1v1ReqBodyOrBuilder> singleFieldBuilderV32 = this.bodyBuilder_;
                if (singleFieldBuilderV32 == null) {
                    chat1v1Request.body_ = this.body_;
                } else {
                    chat1v1Request.body_ = singleFieldBuilderV32.build();
                }
                onBuilt();
                return chat1v1Request;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                if (this.commonBuilder_ == null) {
                    this.common_ = null;
                } else {
                    this.common_ = null;
                    this.commonBuilder_ = null;
                }
                this.reqType_ = 0;
                this.localId_ = 0;
                this.correlationId_ = "";
                this.deliveryTag_ = "";
                if (this.bodyBuilder_ == null) {
                    this.body_ = null;
                    return this;
                }
                this.body_ = null;
                this.bodyBuilder_ = null;
                return this;
            }

            public Builder clearBody() {
                if (this.bodyBuilder_ == null) {
                    this.body_ = null;
                    onChanged();
                    return this;
                }
                this.body_ = null;
                this.bodyBuilder_ = null;
                return this;
            }

            public Builder clearCommon() {
                if (this.commonBuilder_ == null) {
                    this.common_ = null;
                    onChanged();
                    return this;
                }
                this.common_ = null;
                this.commonBuilder_ = null;
                return this;
            }

            public Builder clearCorrelationId() {
                this.correlationId_ = Chat1v1Request.getDefaultInstance().getCorrelationId();
                onChanged();
                return this;
            }

            public Builder clearDeliveryTag() {
                this.deliveryTag_ = Chat1v1Request.getDefaultInstance().getDeliveryTag();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearLocalId() {
                this.localId_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearReqType() {
                this.reqType_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo2030clone() {
                return (Builder) super.mo2030clone();
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1RequestOrBuilder
            public Chat1v1ReqBody getBody() {
                SingleFieldBuilderV3<Chat1v1ReqBody, Chat1v1ReqBody.Builder, Chat1v1ReqBodyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Chat1v1ReqBody chat1v1ReqBody = this.body_;
                    Chat1v1ReqBody chat1v1ReqBody2 = chat1v1ReqBody;
                    if (chat1v1ReqBody == null) {
                        chat1v1ReqBody2 = Chat1v1ReqBody.getDefaultInstance();
                    }
                    return chat1v1ReqBody2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Chat1v1ReqBody.Builder getBodyBuilder() {
                onChanged();
                return getBodyFieldBuilder().getBuilder();
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1RequestOrBuilder
            public Chat1v1ReqBodyOrBuilder getBodyOrBuilder() {
                SingleFieldBuilderV3<Chat1v1ReqBody, Chat1v1ReqBody.Builder, Chat1v1ReqBodyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Chat1v1ReqBody chat1v1ReqBody = this.body_;
                Chat1v1ReqBody chat1v1ReqBody2 = chat1v1ReqBody;
                if (chat1v1ReqBody == null) {
                    chat1v1ReqBody2 = Chat1v1ReqBody.getDefaultInstance();
                }
                return chat1v1ReqBody2;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1RequestOrBuilder
            public CommonOuterClass.Common getCommon() {
                SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 == null) {
                    CommonOuterClass.Common common = this.common_;
                    CommonOuterClass.Common common2 = common;
                    if (common == null) {
                        common2 = CommonOuterClass.Common.getDefaultInstance();
                    }
                    return common2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public CommonOuterClass.Common.Builder getCommonBuilder() {
                onChanged();
                return getCommonFieldBuilder().getBuilder();
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1RequestOrBuilder
            public CommonOuterClass.CommonOrBuilder getCommonOrBuilder() {
                SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                CommonOuterClass.Common common = this.common_;
                CommonOuterClass.Common common2 = common;
                if (common == null) {
                    common2 = CommonOuterClass.Common.getDefaultInstance();
                }
                return common2;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1RequestOrBuilder
            public String getCorrelationId() {
                Object obj = this.correlationId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.correlationId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1RequestOrBuilder
            public ByteString getCorrelationIdBytes() {
                Object obj = this.correlationId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.correlationId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Chat1v1Request getDefaultInstanceForType() {
                return Chat1v1Request.getDefaultInstance();
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1RequestOrBuilder
            public String getDeliveryTag() {
                Object obj = this.deliveryTag_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.deliveryTag_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1RequestOrBuilder
            public ByteString getDeliveryTagBytes() {
                Object obj = this.deliveryTag_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.deliveryTag_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Chat1V1.internal_static_com_blued_im_private_chat_Chat1v1Request_descriptor;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1RequestOrBuilder
            public int getLocalId() {
                return this.localId_;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1RequestOrBuilder
            public ReqTypeOuterClass.ReqType getReqType() {
                ReqTypeOuterClass.ReqType valueOf = ReqTypeOuterClass.ReqType.valueOf(this.reqType_);
                ReqTypeOuterClass.ReqType reqType = valueOf;
                if (valueOf == null) {
                    reqType = ReqTypeOuterClass.ReqType.UNRECOGNIZED;
                }
                return reqType;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1RequestOrBuilder
            public int getReqTypeValue() {
                return this.reqType_;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1RequestOrBuilder
            public boolean hasBody() {
                return (this.bodyBuilder_ == null && this.body_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1RequestOrBuilder
            public boolean hasCommon() {
                return (this.commonBuilder_ == null && this.common_ == null) ? false : true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Chat1V1.internal_static_com_blued_im_private_chat_Chat1v1Request_fieldAccessorTable.ensureFieldAccessorsInitialized(Chat1v1Request.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeBody(Chat1v1ReqBody chat1v1ReqBody) {
                SingleFieldBuilderV3<Chat1v1ReqBody, Chat1v1ReqBody.Builder, Chat1v1ReqBodyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(chat1v1ReqBody);
                    return this;
                }
                Chat1v1ReqBody chat1v1ReqBody2 = this.body_;
                if (chat1v1ReqBody2 != null) {
                    this.body_ = Chat1v1ReqBody.newBuilder(chat1v1ReqBody2).mergeFrom(chat1v1ReqBody).buildPartial();
                } else {
                    this.body_ = chat1v1ReqBody;
                }
                onChanged();
                return this;
            }

            public Builder mergeCommon(CommonOuterClass.Common common) {
                SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(common);
                    return this;
                }
                CommonOuterClass.Common common2 = this.common_;
                if (common2 != null) {
                    this.common_ = CommonOuterClass.Common.newBuilder(common2).mergeFrom(common).buildPartial();
                } else {
                    this.common_ = common;
                }
                onChanged();
                return this;
            }

            public Builder mergeFrom(Chat1v1Request chat1v1Request) {
                if (chat1v1Request == Chat1v1Request.getDefaultInstance()) {
                    return this;
                }
                if (chat1v1Request.hasCommon()) {
                    mergeCommon(chat1v1Request.getCommon());
                }
                if (chat1v1Request.reqType_ != 0) {
                    setReqTypeValue(chat1v1Request.getReqTypeValue());
                }
                if (chat1v1Request.getLocalId() != 0) {
                    setLocalId(chat1v1Request.getLocalId());
                }
                if (!chat1v1Request.getCorrelationId().isEmpty()) {
                    this.correlationId_ = chat1v1Request.correlationId_;
                    onChanged();
                }
                if (!chat1v1Request.getDeliveryTag().isEmpty()) {
                    this.deliveryTag_ = chat1v1Request.deliveryTag_;
                    onChanged();
                }
                if (chat1v1Request.hasBody()) {
                    mergeBody(chat1v1Request.getBody());
                }
                mergeUnknownFields(chat1v1Request.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.im.private_chat.Chat1V1.Chat1v1Request.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.im.private_chat.Chat1V1.Chat1v1Request.access$1300()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.im.private_chat.Chat1V1$Chat1v1Request r0 = (com.blued.im.private_chat.Chat1V1.Chat1v1Request) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.im.private_chat.Chat1V1$Chat1v1Request$Builder r0 = r0.mergeFrom(r1)
                L1a:
                    r0 = r4
                    return r0
                L1c:
                    r6 = move-exception
                    r0 = r7
                    r5 = r0
                    goto L31
                L22:
                    r6 = move-exception
                    r0 = r6
                    com.google.protobuf.MessageLite r0 = r0.getUnfinishedMessage()     // Catch: java.lang.Throwable -> L1c
                    com.blued.im.private_chat.Chat1V1$Chat1v1Request r0 = (com.blued.im.private_chat.Chat1V1.Chat1v1Request) r0     // Catch: java.lang.Throwable -> L1c
                    r5 = r0
                    r0 = r6
                    java.io.IOException r0 = r0.unwrapIOException()     // Catch: java.lang.Throwable -> L30
                    throw r0     // Catch: java.lang.Throwable -> L30
                L30:
                    r6 = move-exception
                L31:
                    r0 = r5
                    if (r0 == 0) goto L3b
                    r0 = r4
                    r1 = r5
                    com.blued.im.private_chat.Chat1V1$Chat1v1Request$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.im.private_chat.Chat1V1.Chat1v1Request.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.im.private_chat.Chat1V1$Chat1v1Request$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof Chat1v1Request) {
                    return mergeFrom((Chat1v1Request) message);
                }
                super.mergeFrom(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder setBody(Chat1v1ReqBody.Builder builder) {
                SingleFieldBuilderV3<Chat1v1ReqBody, Chat1v1ReqBody.Builder, Chat1v1ReqBodyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.body_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setBody(Chat1v1ReqBody chat1v1ReqBody) {
                SingleFieldBuilderV3<Chat1v1ReqBody, Chat1v1ReqBody.Builder, Chat1v1ReqBodyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(chat1v1ReqBody);
                    return this;
                } else if (chat1v1ReqBody != null) {
                    this.body_ = chat1v1ReqBody;
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }

            public Builder setCommon(CommonOuterClass.Common.Builder builder) {
                SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.common_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setCommon(CommonOuterClass.Common common) {
                SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(common);
                    return this;
                } else if (common != null) {
                    this.common_ = common;
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }

            public Builder setCorrelationId(String str) {
                if (str != null) {
                    this.correlationId_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setCorrelationIdBytes(ByteString byteString) {
                if (byteString != null) {
                    Chat1v1Request.checkByteStringIsUtf8(byteString);
                    this.correlationId_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setDeliveryTag(String str) {
                if (str != null) {
                    this.deliveryTag_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setDeliveryTagBytes(ByteString byteString) {
                if (byteString != null) {
                    Chat1v1Request.checkByteStringIsUtf8(byteString);
                    this.deliveryTag_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setLocalId(int i) {
                this.localId_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setReqType(ReqTypeOuterClass.ReqType reqType) {
                if (reqType != null) {
                    this.reqType_ = reqType.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setReqTypeValue(int i) {
                this.reqType_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private Chat1v1Request() {
            this.memoizedIsInitialized = (byte) -1;
            this.reqType_ = 0;
            this.correlationId_ = "";
            this.deliveryTag_ = "";
        }

        private Chat1v1Request(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw null;
            }
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    CommonOuterClass.Common.Builder builder = this.common_ != null ? this.common_.toBuilder() : null;
                                    CommonOuterClass.Common common = (CommonOuterClass.Common) codedInputStream.readMessage(CommonOuterClass.Common.parser(), extensionRegistryLite);
                                    this.common_ = common;
                                    if (builder != null) {
                                        builder.mergeFrom(common);
                                        this.common_ = builder.buildPartial();
                                    }
                                } else if (readTag == 16) {
                                    this.reqType_ = codedInputStream.readEnum();
                                } else if (readTag == 24) {
                                    this.localId_ = codedInputStream.readUInt32();
                                } else if (readTag == 34) {
                                    this.correlationId_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 42) {
                                    this.deliveryTag_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 50) {
                                    Chat1v1ReqBody.Builder builder2 = this.body_ != null ? this.body_.toBuilder() : null;
                                    Chat1v1ReqBody chat1v1ReqBody = (Chat1v1ReqBody) codedInputStream.readMessage(Chat1v1ReqBody.parser(), extensionRegistryLite);
                                    this.body_ = chat1v1ReqBody;
                                    if (builder2 != null) {
                                        builder2.mergeFrom(chat1v1ReqBody);
                                        this.body_ = builder2.buildPartial();
                                    }
                                } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                }
                            }
                            z = true;
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        private Chat1v1Request(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Chat1v1Request getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Chat1V1.internal_static_com_blued_im_private_chat_Chat1v1Request_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Chat1v1Request chat1v1Request) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(chat1v1Request);
        }

        public static Chat1v1Request parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Chat1v1Request) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Chat1v1Request parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Chat1v1Request) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Chat1v1Request parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Chat1v1Request parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Chat1v1Request parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Chat1v1Request) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Chat1v1Request parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Chat1v1Request) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static Chat1v1Request parseFrom(InputStream inputStream) throws IOException {
            return (Chat1v1Request) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Chat1v1Request parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Chat1v1Request) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Chat1v1Request parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Chat1v1Request parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Chat1v1Request parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Chat1v1Request parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<Chat1v1Request> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Chat1v1Request) {
                Chat1v1Request chat1v1Request = (Chat1v1Request) obj;
                if (hasCommon() != chat1v1Request.hasCommon()) {
                    return false;
                }
                if ((!hasCommon() || getCommon().equals(chat1v1Request.getCommon())) && this.reqType_ == chat1v1Request.reqType_ && getLocalId() == chat1v1Request.getLocalId() && getCorrelationId().equals(chat1v1Request.getCorrelationId()) && getDeliveryTag().equals(chat1v1Request.getDeliveryTag()) && hasBody() == chat1v1Request.hasBody()) {
                    return (!hasBody() || getBody().equals(chat1v1Request.getBody())) && this.unknownFields.equals(chat1v1Request.unknownFields);
                }
                return false;
            }
            return super.equals(obj);
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1RequestOrBuilder
        public Chat1v1ReqBody getBody() {
            Chat1v1ReqBody chat1v1ReqBody = this.body_;
            Chat1v1ReqBody chat1v1ReqBody2 = chat1v1ReqBody;
            if (chat1v1ReqBody == null) {
                chat1v1ReqBody2 = Chat1v1ReqBody.getDefaultInstance();
            }
            return chat1v1ReqBody2;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1RequestOrBuilder
        public Chat1v1ReqBodyOrBuilder getBodyOrBuilder() {
            return getBody();
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1RequestOrBuilder
        public CommonOuterClass.Common getCommon() {
            CommonOuterClass.Common common = this.common_;
            CommonOuterClass.Common common2 = common;
            if (common == null) {
                common2 = CommonOuterClass.Common.getDefaultInstance();
            }
            return common2;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1RequestOrBuilder
        public CommonOuterClass.CommonOrBuilder getCommonOrBuilder() {
            return getCommon();
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1RequestOrBuilder
        public String getCorrelationId() {
            Object obj = this.correlationId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.correlationId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1RequestOrBuilder
        public ByteString getCorrelationIdBytes() {
            Object obj = this.correlationId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.correlationId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Chat1v1Request getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1RequestOrBuilder
        public String getDeliveryTag() {
            Object obj = this.deliveryTag_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.deliveryTag_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1RequestOrBuilder
        public ByteString getDeliveryTagBytes() {
            Object obj = this.deliveryTag_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.deliveryTag_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1RequestOrBuilder
        public int getLocalId() {
            return this.localId_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Chat1v1Request> getParserForType() {
            return PARSER;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1RequestOrBuilder
        public ReqTypeOuterClass.ReqType getReqType() {
            ReqTypeOuterClass.ReqType valueOf = ReqTypeOuterClass.ReqType.valueOf(this.reqType_);
            ReqTypeOuterClass.ReqType reqType = valueOf;
            if (valueOf == null) {
                reqType = ReqTypeOuterClass.ReqType.UNRECOGNIZED;
            }
            return reqType;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1RequestOrBuilder
        public int getReqTypeValue() {
            return this.reqType_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (this.common_ != null) {
                i2 = 0 + CodedOutputStream.computeMessageSize(1, getCommon());
            }
            int i3 = i2;
            if (this.reqType_ != ReqTypeOuterClass.ReqType.ReqNil.getNumber()) {
                i3 = i2 + CodedOutputStream.computeEnumSize(2, this.reqType_);
            }
            int i4 = this.localId_;
            int i5 = i3;
            if (i4 != 0) {
                i5 = i3 + CodedOutputStream.computeUInt32Size(3, i4);
            }
            int i6 = i5;
            if (!getCorrelationIdBytes().isEmpty()) {
                i6 = i5 + GeneratedMessageV3.computeStringSize(4, this.correlationId_);
            }
            int i7 = i6;
            if (!getDeliveryTagBytes().isEmpty()) {
                i7 = i6 + GeneratedMessageV3.computeStringSize(5, this.deliveryTag_);
            }
            int i8 = i7;
            if (this.body_ != null) {
                i8 = i7 + CodedOutputStream.computeMessageSize(6, getBody());
            }
            int serializedSize = i8 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1RequestOrBuilder
        public boolean hasBody() {
            return this.body_ != null;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1RequestOrBuilder
        public boolean hasCommon() {
            return this.common_ != null;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            int i = hashCode;
            if (hasCommon()) {
                i = (((hashCode * 37) + 1) * 53) + getCommon().hashCode();
            }
            int localId = (((((((((((((((i * 37) + 2) * 53) + this.reqType_) * 37) + 3) * 53) + getLocalId()) * 37) + 4) * 53) + getCorrelationId().hashCode()) * 37) + 5) * 53) + getDeliveryTag().hashCode();
            int i2 = localId;
            if (hasBody()) {
                i2 = (((localId * 37) + 6) * 53) + getBody().hashCode();
            }
            int hashCode2 = (i2 * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Chat1V1.internal_static_com_blued_im_private_chat_Chat1v1Request_fieldAccessorTable.ensureFieldAccessorsInitialized(Chat1v1Request.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new Chat1v1Request();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.common_ != null) {
                codedOutputStream.writeMessage(1, getCommon());
            }
            if (this.reqType_ != ReqTypeOuterClass.ReqType.ReqNil.getNumber()) {
                codedOutputStream.writeEnum(2, this.reqType_);
            }
            int i = this.localId_;
            if (i != 0) {
                codedOutputStream.writeUInt32(3, i);
            }
            if (!getCorrelationIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.correlationId_);
            }
            if (!getDeliveryTagBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.deliveryTag_);
            }
            if (this.body_ != null) {
                codedOutputStream.writeMessage(6, getBody());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/Chat1V1$Chat1v1RequestOrBuilder.class */
    public interface Chat1v1RequestOrBuilder extends MessageOrBuilder {
        Chat1v1ReqBody getBody();

        Chat1v1ReqBodyOrBuilder getBodyOrBuilder();

        CommonOuterClass.Common getCommon();

        CommonOuterClass.CommonOrBuilder getCommonOrBuilder();

        String getCorrelationId();

        ByteString getCorrelationIdBytes();

        String getDeliveryTag();

        ByteString getDeliveryTagBytes();

        int getLocalId();

        ReqTypeOuterClass.ReqType getReqType();

        int getReqTypeValue();

        boolean hasBody();

        boolean hasCommon();
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/Chat1V1$Chat1v1Response.class */
    public static final class Chat1v1Response extends GeneratedMessageV3 implements Chat1v1ResponseOrBuilder {
        public static final int BODY_FIELD_NUMBER = 5;
        public static final int CODE_FIELD_NUMBER = 1;
        public static final int LOCAL_ID_FIELD_NUMBER = 4;
        public static final int MESSAGE_FIELD_NUMBER = 2;
        public static final int MSG_ID_FIELD_NUMBER = 3;
        public static final int REQUEST_ID_FIELD_NUMBER = 6;
        public static final int REQUEST_TIME_FIELD_NUMBER = 7;
        public static final int RESPONSE_TIME_FIELD_NUMBER = 8;
        private static final long serialVersionUID = 0;
        private Chat1v1AckBody body_;
        private int code_;
        private int localId_;
        private byte memoizedIsInitialized;
        private volatile Object message_;
        private long msgId_;
        private volatile Object requestId_;
        private long requestTime_;
        private long responseTime_;
        private static final Chat1v1Response DEFAULT_INSTANCE = new Chat1v1Response();
        private static final Parser<Chat1v1Response> PARSER = new AbstractParser<Chat1v1Response>() { // from class: com.blued.im.private_chat.Chat1V1.Chat1v1Response.1
            @Override // com.google.protobuf.Parser
            public Chat1v1Response parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Chat1v1Response(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/Chat1V1$Chat1v1Response$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Chat1v1ResponseOrBuilder {
            private SingleFieldBuilderV3<Chat1v1AckBody, Chat1v1AckBody.Builder, Chat1v1AckBodyOrBuilder> bodyBuilder_;
            private Chat1v1AckBody body_;
            private int code_;
            private int localId_;
            private Object message_;
            private long msgId_;
            private Object requestId_;
            private long requestTime_;
            private long responseTime_;

            private Builder() {
                this.code_ = 0;
                this.message_ = "";
                this.requestId_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.code_ = 0;
                this.message_ = "";
                this.requestId_ = "";
                maybeForceBuilderInitialization();
            }

            private SingleFieldBuilderV3<Chat1v1AckBody, Chat1v1AckBody.Builder, Chat1v1AckBodyOrBuilder> getBodyFieldBuilder() {
                if (this.bodyBuilder_ == null) {
                    this.bodyBuilder_ = new SingleFieldBuilderV3<>(getBody(), getParentForChildren(), isClean());
                    this.body_ = null;
                }
                return this.bodyBuilder_;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return Chat1V1.internal_static_com_blued_im_private_chat_Chat1v1Response_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = Chat1v1Response.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Chat1v1Response build() {
                Chat1v1Response buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Chat1v1Response buildPartial() {
                Chat1v1Response chat1v1Response = new Chat1v1Response(this);
                chat1v1Response.code_ = this.code_;
                chat1v1Response.message_ = this.message_;
                chat1v1Response.msgId_ = this.msgId_;
                chat1v1Response.localId_ = this.localId_;
                SingleFieldBuilderV3<Chat1v1AckBody, Chat1v1AckBody.Builder, Chat1v1AckBodyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
                if (singleFieldBuilderV3 == null) {
                    chat1v1Response.body_ = this.body_;
                } else {
                    chat1v1Response.body_ = singleFieldBuilderV3.build();
                }
                chat1v1Response.requestId_ = this.requestId_;
                chat1v1Response.requestTime_ = this.requestTime_;
                chat1v1Response.responseTime_ = this.responseTime_;
                onBuilt();
                return chat1v1Response;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.code_ = 0;
                this.message_ = "";
                this.msgId_ = 0L;
                this.localId_ = 0;
                if (this.bodyBuilder_ == null) {
                    this.body_ = null;
                } else {
                    this.body_ = null;
                    this.bodyBuilder_ = null;
                }
                this.requestId_ = "";
                this.requestTime_ = 0L;
                this.responseTime_ = 0L;
                return this;
            }

            public Builder clearBody() {
                if (this.bodyBuilder_ == null) {
                    this.body_ = null;
                    onChanged();
                    return this;
                }
                this.body_ = null;
                this.bodyBuilder_ = null;
                return this;
            }

            public Builder clearCode() {
                this.code_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearLocalId() {
                this.localId_ = 0;
                onChanged();
                return this;
            }

            public Builder clearMessage() {
                this.message_ = Chat1v1Response.getDefaultInstance().getMessage();
                onChanged();
                return this;
            }

            public Builder clearMsgId() {
                this.msgId_ = 0L;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearRequestId() {
                this.requestId_ = Chat1v1Response.getDefaultInstance().getRequestId();
                onChanged();
                return this;
            }

            public Builder clearRequestTime() {
                this.requestTime_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearResponseTime() {
                this.responseTime_ = 0L;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo2030clone() {
                return (Builder) super.mo2030clone();
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ResponseOrBuilder
            public Chat1v1AckBody getBody() {
                SingleFieldBuilderV3<Chat1v1AckBody, Chat1v1AckBody.Builder, Chat1v1AckBodyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Chat1v1AckBody chat1v1AckBody = this.body_;
                    Chat1v1AckBody chat1v1AckBody2 = chat1v1AckBody;
                    if (chat1v1AckBody == null) {
                        chat1v1AckBody2 = Chat1v1AckBody.getDefaultInstance();
                    }
                    return chat1v1AckBody2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Chat1v1AckBody.Builder getBodyBuilder() {
                onChanged();
                return getBodyFieldBuilder().getBuilder();
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ResponseOrBuilder
            public Chat1v1AckBodyOrBuilder getBodyOrBuilder() {
                SingleFieldBuilderV3<Chat1v1AckBody, Chat1v1AckBody.Builder, Chat1v1AckBodyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Chat1v1AckBody chat1v1AckBody = this.body_;
                Chat1v1AckBody chat1v1AckBody2 = chat1v1AckBody;
                if (chat1v1AckBody == null) {
                    chat1v1AckBody2 = Chat1v1AckBody.getDefaultInstance();
                }
                return chat1v1AckBody2;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ResponseOrBuilder
            public CodeOuterClass.Code getCode() {
                CodeOuterClass.Code valueOf = CodeOuterClass.Code.valueOf(this.code_);
                CodeOuterClass.Code code = valueOf;
                if (valueOf == null) {
                    code = CodeOuterClass.Code.UNRECOGNIZED;
                }
                return code;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ResponseOrBuilder
            public int getCodeValue() {
                return this.code_;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Chat1v1Response getDefaultInstanceForType() {
                return Chat1v1Response.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Chat1V1.internal_static_com_blued_im_private_chat_Chat1v1Response_descriptor;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ResponseOrBuilder
            public int getLocalId() {
                return this.localId_;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ResponseOrBuilder
            public String getMessage() {
                Object obj = this.message_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.message_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ResponseOrBuilder
            public ByteString getMessageBytes() {
                Object obj = this.message_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.message_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ResponseOrBuilder
            public long getMsgId() {
                return this.msgId_;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ResponseOrBuilder
            public String getRequestId() {
                Object obj = this.requestId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.requestId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ResponseOrBuilder
            public ByteString getRequestIdBytes() {
                Object obj = this.requestId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.requestId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ResponseOrBuilder
            public long getRequestTime() {
                return this.requestTime_;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ResponseOrBuilder
            public long getResponseTime() {
                return this.responseTime_;
            }

            @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ResponseOrBuilder
            public boolean hasBody() {
                return (this.bodyBuilder_ == null && this.body_ == null) ? false : true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Chat1V1.internal_static_com_blued_im_private_chat_Chat1v1Response_fieldAccessorTable.ensureFieldAccessorsInitialized(Chat1v1Response.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeBody(Chat1v1AckBody chat1v1AckBody) {
                SingleFieldBuilderV3<Chat1v1AckBody, Chat1v1AckBody.Builder, Chat1v1AckBodyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(chat1v1AckBody);
                    return this;
                }
                Chat1v1AckBody chat1v1AckBody2 = this.body_;
                if (chat1v1AckBody2 != null) {
                    this.body_ = Chat1v1AckBody.newBuilder(chat1v1AckBody2).mergeFrom(chat1v1AckBody).buildPartial();
                } else {
                    this.body_ = chat1v1AckBody;
                }
                onChanged();
                return this;
            }

            public Builder mergeFrom(Chat1v1Response chat1v1Response) {
                if (chat1v1Response == Chat1v1Response.getDefaultInstance()) {
                    return this;
                }
                if (chat1v1Response.code_ != 0) {
                    setCodeValue(chat1v1Response.getCodeValue());
                }
                if (!chat1v1Response.getMessage().isEmpty()) {
                    this.message_ = chat1v1Response.message_;
                    onChanged();
                }
                if (chat1v1Response.getMsgId() != 0) {
                    setMsgId(chat1v1Response.getMsgId());
                }
                if (chat1v1Response.getLocalId() != 0) {
                    setLocalId(chat1v1Response.getLocalId());
                }
                if (chat1v1Response.hasBody()) {
                    mergeBody(chat1v1Response.getBody());
                }
                if (!chat1v1Response.getRequestId().isEmpty()) {
                    this.requestId_ = chat1v1Response.requestId_;
                    onChanged();
                }
                if (chat1v1Response.getRequestTime() != 0) {
                    setRequestTime(chat1v1Response.getRequestTime());
                }
                if (chat1v1Response.getResponseTime() != 0) {
                    setResponseTime(chat1v1Response.getResponseTime());
                }
                mergeUnknownFields(chat1v1Response.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.im.private_chat.Chat1V1.Chat1v1Response.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.im.private_chat.Chat1V1.Chat1v1Response.access$5100()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.im.private_chat.Chat1V1$Chat1v1Response r0 = (com.blued.im.private_chat.Chat1V1.Chat1v1Response) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.im.private_chat.Chat1V1$Chat1v1Response$Builder r0 = r0.mergeFrom(r1)
                L1a:
                    r0 = r4
                    return r0
                L1c:
                    r6 = move-exception
                    r0 = r7
                    r5 = r0
                    goto L31
                L22:
                    r6 = move-exception
                    r0 = r6
                    com.google.protobuf.MessageLite r0 = r0.getUnfinishedMessage()     // Catch: java.lang.Throwable -> L1c
                    com.blued.im.private_chat.Chat1V1$Chat1v1Response r0 = (com.blued.im.private_chat.Chat1V1.Chat1v1Response) r0     // Catch: java.lang.Throwable -> L1c
                    r5 = r0
                    r0 = r6
                    java.io.IOException r0 = r0.unwrapIOException()     // Catch: java.lang.Throwable -> L30
                    throw r0     // Catch: java.lang.Throwable -> L30
                L30:
                    r6 = move-exception
                L31:
                    r0 = r5
                    if (r0 == 0) goto L3b
                    r0 = r4
                    r1 = r5
                    com.blued.im.private_chat.Chat1V1$Chat1v1Response$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.im.private_chat.Chat1V1.Chat1v1Response.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.im.private_chat.Chat1V1$Chat1v1Response$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof Chat1v1Response) {
                    return mergeFrom((Chat1v1Response) message);
                }
                super.mergeFrom(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder setBody(Chat1v1AckBody.Builder builder) {
                SingleFieldBuilderV3<Chat1v1AckBody, Chat1v1AckBody.Builder, Chat1v1AckBodyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.body_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setBody(Chat1v1AckBody chat1v1AckBody) {
                SingleFieldBuilderV3<Chat1v1AckBody, Chat1v1AckBody.Builder, Chat1v1AckBodyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(chat1v1AckBody);
                    return this;
                } else if (chat1v1AckBody != null) {
                    this.body_ = chat1v1AckBody;
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }

            public Builder setCode(CodeOuterClass.Code code) {
                if (code != null) {
                    this.code_ = code.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setCodeValue(int i) {
                this.code_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setLocalId(int i) {
                this.localId_ = i;
                onChanged();
                return this;
            }

            public Builder setMessage(String str) {
                if (str != null) {
                    this.message_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setMessageBytes(ByteString byteString) {
                if (byteString != null) {
                    Chat1v1Response.checkByteStringIsUtf8(byteString);
                    this.message_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setMsgId(long j) {
                this.msgId_ = j;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setRequestId(String str) {
                if (str != null) {
                    this.requestId_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setRequestIdBytes(ByteString byteString) {
                if (byteString != null) {
                    Chat1v1Response.checkByteStringIsUtf8(byteString);
                    this.requestId_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setRequestTime(long j) {
                this.requestTime_ = j;
                onChanged();
                return this;
            }

            public Builder setResponseTime(long j) {
                this.responseTime_ = j;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private Chat1v1Response() {
            this.memoizedIsInitialized = (byte) -1;
            this.code_ = 0;
            this.message_ = "";
            this.requestId_ = "";
        }

        private Chat1v1Response(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw null;
            }
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    this.code_ = codedInputStream.readEnum();
                                } else if (readTag == 18) {
                                    this.message_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 24) {
                                    this.msgId_ = codedInputStream.readInt64();
                                } else if (readTag == 32) {
                                    this.localId_ = codedInputStream.readInt32();
                                } else if (readTag == 42) {
                                    Chat1v1AckBody.Builder builder = this.body_ != null ? this.body_.toBuilder() : null;
                                    Chat1v1AckBody chat1v1AckBody = (Chat1v1AckBody) codedInputStream.readMessage(Chat1v1AckBody.parser(), extensionRegistryLite);
                                    this.body_ = chat1v1AckBody;
                                    if (builder != null) {
                                        builder.mergeFrom(chat1v1AckBody);
                                        this.body_ = builder.buildPartial();
                                    }
                                } else if (readTag == 50) {
                                    this.requestId_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 56) {
                                    this.requestTime_ = codedInputStream.readInt64();
                                } else if (readTag == 64) {
                                    this.responseTime_ = codedInputStream.readInt64();
                                } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                }
                            }
                            z = true;
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        private Chat1v1Response(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Chat1v1Response getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Chat1V1.internal_static_com_blued_im_private_chat_Chat1v1Response_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Chat1v1Response chat1v1Response) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(chat1v1Response);
        }

        public static Chat1v1Response parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Chat1v1Response) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Chat1v1Response parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Chat1v1Response) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Chat1v1Response parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Chat1v1Response parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Chat1v1Response parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Chat1v1Response) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Chat1v1Response parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Chat1v1Response) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static Chat1v1Response parseFrom(InputStream inputStream) throws IOException {
            return (Chat1v1Response) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Chat1v1Response parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Chat1v1Response) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Chat1v1Response parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Chat1v1Response parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Chat1v1Response parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Chat1v1Response parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<Chat1v1Response> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Chat1v1Response) {
                Chat1v1Response chat1v1Response = (Chat1v1Response) obj;
                if (this.code_ == chat1v1Response.code_ && getMessage().equals(chat1v1Response.getMessage()) && getMsgId() == chat1v1Response.getMsgId() && getLocalId() == chat1v1Response.getLocalId() && hasBody() == chat1v1Response.hasBody()) {
                    return (!hasBody() || getBody().equals(chat1v1Response.getBody())) && getRequestId().equals(chat1v1Response.getRequestId()) && getRequestTime() == chat1v1Response.getRequestTime() && getResponseTime() == chat1v1Response.getResponseTime() && this.unknownFields.equals(chat1v1Response.unknownFields);
                }
                return false;
            }
            return super.equals(obj);
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ResponseOrBuilder
        public Chat1v1AckBody getBody() {
            Chat1v1AckBody chat1v1AckBody = this.body_;
            Chat1v1AckBody chat1v1AckBody2 = chat1v1AckBody;
            if (chat1v1AckBody == null) {
                chat1v1AckBody2 = Chat1v1AckBody.getDefaultInstance();
            }
            return chat1v1AckBody2;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ResponseOrBuilder
        public Chat1v1AckBodyOrBuilder getBodyOrBuilder() {
            return getBody();
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ResponseOrBuilder
        public CodeOuterClass.Code getCode() {
            CodeOuterClass.Code valueOf = CodeOuterClass.Code.valueOf(this.code_);
            CodeOuterClass.Code code = valueOf;
            if (valueOf == null) {
                code = CodeOuterClass.Code.UNRECOGNIZED;
            }
            return code;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ResponseOrBuilder
        public int getCodeValue() {
            return this.code_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Chat1v1Response getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ResponseOrBuilder
        public int getLocalId() {
            return this.localId_;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ResponseOrBuilder
        public String getMessage() {
            Object obj = this.message_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.message_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ResponseOrBuilder
        public ByteString getMessageBytes() {
            Object obj = this.message_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.message_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ResponseOrBuilder
        public long getMsgId() {
            return this.msgId_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Chat1v1Response> getParserForType() {
            return PARSER;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ResponseOrBuilder
        public String getRequestId() {
            Object obj = this.requestId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.requestId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ResponseOrBuilder
        public ByteString getRequestIdBytes() {
            Object obj = this.requestId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.requestId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ResponseOrBuilder
        public long getRequestTime() {
            return this.requestTime_;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ResponseOrBuilder
        public long getResponseTime() {
            return this.responseTime_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (this.code_ != CodeOuterClass.Code.PRIVATE_SUCCESS.getNumber()) {
                i2 = 0 + CodedOutputStream.computeEnumSize(1, this.code_);
            }
            int i3 = i2;
            if (!getMessageBytes().isEmpty()) {
                i3 = i2 + GeneratedMessageV3.computeStringSize(2, this.message_);
            }
            long j = this.msgId_;
            int i4 = i3;
            if (j != 0) {
                i4 = i3 + CodedOutputStream.computeInt64Size(3, j);
            }
            int i5 = this.localId_;
            int i6 = i4;
            if (i5 != 0) {
                i6 = i4 + CodedOutputStream.computeInt32Size(4, i5);
            }
            int i7 = i6;
            if (this.body_ != null) {
                i7 = i6 + CodedOutputStream.computeMessageSize(5, getBody());
            }
            int i8 = i7;
            if (!getRequestIdBytes().isEmpty()) {
                i8 = i7 + GeneratedMessageV3.computeStringSize(6, this.requestId_);
            }
            long j2 = this.requestTime_;
            int i9 = i8;
            if (j2 != 0) {
                i9 = i8 + CodedOutputStream.computeInt64Size(7, j2);
            }
            long j3 = this.responseTime_;
            int i10 = i9;
            if (j3 != 0) {
                i10 = i9 + CodedOutputStream.computeInt64Size(8, j3);
            }
            int serializedSize = i10 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.blued.im.private_chat.Chat1V1.Chat1v1ResponseOrBuilder
        public boolean hasBody() {
            return this.body_ != null;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.code_) * 37) + 2) * 53) + getMessage().hashCode()) * 37) + 3) * 53) + Internal.hashLong(getMsgId())) * 37) + 4) * 53) + getLocalId();
            int i = hashCode;
            if (hasBody()) {
                i = (((hashCode * 37) + 5) * 53) + getBody().hashCode();
            }
            int hashCode2 = (((((((((((((i * 37) + 6) * 53) + getRequestId().hashCode()) * 37) + 7) * 53) + Internal.hashLong(getRequestTime())) * 37) + 8) * 53) + Internal.hashLong(getResponseTime())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Chat1V1.internal_static_com_blued_im_private_chat_Chat1v1Response_fieldAccessorTable.ensureFieldAccessorsInitialized(Chat1v1Response.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b == 1) {
                return true;
            }
            if (b == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new Chat1v1Response();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.code_ != CodeOuterClass.Code.PRIVATE_SUCCESS.getNumber()) {
                codedOutputStream.writeEnum(1, this.code_);
            }
            if (!getMessageBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.message_);
            }
            long j = this.msgId_;
            if (j != 0) {
                codedOutputStream.writeInt64(3, j);
            }
            int i = this.localId_;
            if (i != 0) {
                codedOutputStream.writeInt32(4, i);
            }
            if (this.body_ != null) {
                codedOutputStream.writeMessage(5, getBody());
            }
            if (!getRequestIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 6, this.requestId_);
            }
            long j2 = this.requestTime_;
            if (j2 != 0) {
                codedOutputStream.writeInt64(7, j2);
            }
            long j3 = this.responseTime_;
            if (j3 != 0) {
                codedOutputStream.writeInt64(8, j3);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/Chat1V1$Chat1v1ResponseOrBuilder.class */
    public interface Chat1v1ResponseOrBuilder extends MessageOrBuilder {
        Chat1v1AckBody getBody();

        Chat1v1AckBodyOrBuilder getBodyOrBuilder();

        CodeOuterClass.Code getCode();

        int getCodeValue();

        int getLocalId();

        String getMessage();

        ByteString getMessageBytes();

        long getMsgId();

        String getRequestId();

        ByteString getRequestIdBytes();

        long getRequestTime();

        long getResponseTime();

        boolean hasBody();
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_blued_im_private_chat_Chat1v1Request_descriptor = descriptor2;
        internal_static_com_blued_im_private_chat_Chat1v1Request_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Common", "ReqType", "LocalId", "CorrelationId", "DeliveryTag", "Body"});
        Descriptors.Descriptor descriptor3 = getDescriptor().getMessageTypes().get(1);
        internal_static_com_blued_im_private_chat_Chat1v1ReqBody_descriptor = descriptor3;
        internal_static_com_blued_im_private_chat_Chat1v1ReqBody_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor3, new String[]{"InvitedUid", TXCopyrightedMedia.EXT_INFO_ROOM_ID, "RoomType", "ChatSdkType", "Reason", "TotalTime", "ConsumeBeans", "StreamId"});
        Descriptors.Descriptor descriptor4 = getDescriptor().getMessageTypes().get(2);
        internal_static_com_blued_im_private_chat_Chat1v1Response_descriptor = descriptor4;
        internal_static_com_blued_im_private_chat_Chat1v1Response_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor4, new String[]{"Code", "Message", "MsgId", "LocalId", "Body", "RequestId", "RequestTime", "ResponseTime"});
        Descriptors.Descriptor descriptor5 = getDescriptor().getMessageTypes().get(3);
        internal_static_com_blued_im_private_chat_Chat1v1AckBody_descriptor = descriptor5;
        internal_static_com_blued_im_private_chat_Chat1v1AckBody_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor5, new String[]{"ReqType", "Error", "ErrorContents", "OwnTime", "RemainingCallCount", "ChatSdkType", "SwitchSdk", "UserSig", "AppId", TXCopyrightedMedia.EXT_INFO_ROOM_ID});
        Descriptors.Descriptor descriptor6 = getDescriptor().getMessageTypes().get(4);
        internal_static_com_blued_im_private_chat_Chat1v1Receive_descriptor = descriptor6;
        internal_static_com_blued_im_private_chat_Chat1v1Receive_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor6, new String[]{HttpHeaders.FROM, "To", "MsgType", "MsgId", "Timestamp", "Distance", "Coords", "SessionStatus", "IsDeleted", "IsRead", "Body", "SessionType", "PhoneSessionId", "SessionCommonStatus"});
        ReqTypeOuterClass.getDescriptor();
        CodeOuterClass.getDescriptor();
        CommonOuterClass.getDescriptor();
        MsgTypeOuterClass.getDescriptor();
        PushBodyOuterClass.getDescriptor();
    }

    private Chat1V1() {
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
