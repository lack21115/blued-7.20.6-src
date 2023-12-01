package com.blued.im.private_chat;

import com.blued.im.CommonOuterClass;
import com.blued.im.private_chat.CodeOuterClass;
import com.blued.im.private_chat.MsgTypeOuterClass;
import com.blued.im.private_chat.PushBodyOuterClass;
import com.google.common.net.HttpHeaders;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.Any;
import com.google.protobuf.AnyOrBuilder;
import com.google.protobuf.AnyProto;
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
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/PrivateChatOuterClass.class */
public final class PrivateChatOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0011PrivateChat.proto\u0012\u0019com.blued.im.private_chat\u001a\u0019google/protobuf/any.proto\u001a\rMsgType.proto\u001a\nCode.proto\u001a\fCommon.proto\u001a\u000ePushBody.proto\"Ë\u0001\n\u0007Request\u0012$\n\u0006common\u0018\u0001 \u0001(\u000b2\u0014.com.blued.im.Common\u0012\n\n\u0002to\u0018\u0002 \u0001(\r\u00124\n\bmsg_type\u0018\u0003 \u0001(\u000e2\".com.blued.im.private_chat.MsgType\u0012\u0010\n\blocal_id\u0018\u0004 \u0001(\u0005\u0012\"\n\u0004body\u0018\u0005 \u0001(\u000b2\u0014.google.protobuf.Any\u0012\f\n\u0004from\u0018\u0006 \u0001(\r\u0012\u0014\n\fsession_type\u0018\u0007 \u0001(\r\"Â\u0001\n\bResponse\u0012-\n\u0004code\u0018\u0001 \u0001(\u000e2\u001f.com.blued.im.private_chat.Code\u0012\u000f\n\u0007message\u0018\u0002 \u0001(\t\u0012\u000e\n\u0006msg_id\u0018\u0003 \u0001(\u0003\u0012\u0010\n\blocal_id\u0018\u0004 \u0001(\u0005\u0012\u0012\n\nrequest_id\u0018\u0005 \u0001(\t\u0012\u0014\n\frequest_time\u0018\u0006 \u0001(\u0003\u0012\u0015\n\rresponse_time\u0018\u0007 \u0001(\u0003\u0012\u0013\n\u000bprompt_type\u0018\b \u0001(\t\"Ý\u0002\n\u0007Receive\u0012\f\n\u0004from\u0018\u0001 \u0001(\r\u0012\n\n\u0002to\u0018\u0002 \u0001(\r\u00124\n\bmsg_type\u0018\u0003 \u0001(\u000e2\".com.blued.im.private_chat.MsgType\u0012\u000e\n\u0006msg_id\u0018\u0004 \u0001(\u0003\u0012\u0011\n\ttimestamp\u0018\u0005 \u0001(\u0003\u0012\u0010\n\bdistance\u0018\u0006 \u0001(\t\u0012\u000e\n\u0006coords\u0018\u0007 \u0003(\u0001\u0012\u0016\n\u000esession_status\u0018\b \u0001(\u0005\u0012\u0012\n\nis_deleted\u0018\t \u0001(\b\u0012\u000f\n\u0007is_read\u0018\n \u0001(\b\u00121\n\u0004body\u0018\u000b \u0001(\u000b2#.com.blued.im.private_chat.PushBody\u0012\u0014\n\fsession_type\u0018\f \u0001(\r\u0012\u0018\n\u0010phone_session_id\u0018\r \u0001(\r\u0012\u001d\n\u0015session_common_status\u0018\u000e \u0001(\t\"Á\u0002\n\nReceiveNew\u0012\f\n\u0004from\u0018\u0001 \u0001(\r\u0012\n\n\u0002to\u0018\u0002 \u0001(\r\u00124\n\bmsg_type\u0018\u0003 \u0001(\u000e2\".com.blued.im.private_chat.MsgType\u0012\u000e\n\u0006msg_id\u0018\u0004 \u0001(\u0003\u0012\u0011\n\ttimestamp\u0018\u0005 \u0001(\u0003\u0012\u0010\n\bdistance\u0018\u0006 \u0001(\t\u0012\u000e\n\u0006coords\u0018\u0007 \u0003(\u0001\u0012\u0016\n\u000esession_status\u0018\b \u0001(\u0005\u0012\u0012\n\nis_deleted\u0018\t \u0001(\b\u0012\u000f\n\u0007is_read\u0018\n \u0001(\b\u00121\n\u0004body\u0018\u000b \u0001(\u000b2#.com.blued.im.private_chat.PushBody\u0012\u0014\n\fsession_type\u0018\f \u0001(\r\u0012\u0018\n\u0010phone_session_id\u0018\r \u0001(\r2`\n\u000bPrivateChat\u0012Q\n\u0004Send\u0012\".com.blued.im.private_chat.Request\u001a#.com.blued.im.private_chat.Response\"��2^\n\tGroupChat\u0012Q\n\u0004Send\u0012\".com.blued.im.private_chat.Request\u001a#.com.blued.im.private_chat.Response\"��B\u000e¢\u0002\u000bPrivateChatb\u0006proto3"}, new Descriptors.FileDescriptor[]{AnyProto.getDescriptor(), MsgTypeOuterClass.getDescriptor(), CodeOuterClass.getDescriptor(), CommonOuterClass.getDescriptor(), PushBodyOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_com_blued_im_private_chat_ReceiveNew_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_im_private_chat_ReceiveNew_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_blued_im_private_chat_Receive_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_im_private_chat_Receive_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_blued_im_private_chat_Request_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_im_private_chat_Request_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_blued_im_private_chat_Response_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_im_private_chat_Response_fieldAccessorTable;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/PrivateChatOuterClass$Receive.class */
    public static final class Receive extends GeneratedMessageV3 implements ReceiveOrBuilder {
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
        private static final Receive DEFAULT_INSTANCE = new Receive();
        private static final Parser<Receive> PARSER = new AbstractParser<Receive>() { // from class: com.blued.im.private_chat.PrivateChatOuterClass.Receive.1
            @Override // com.google.protobuf.Parser
            public Receive parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Receive(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/PrivateChatOuterClass$Receive$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ReceiveOrBuilder {
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
                this.coords_ = Receive.access$6000();
                this.sessionCommonStatus_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.msgType_ = 0;
                this.distance_ = "";
                this.coords_ = Receive.access$6000();
                this.sessionCommonStatus_ = "";
                maybeForceBuilderInitialization();
            }

            private void ensureCoordsIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.coords_ = Receive.mutableCopy(this.coords_);
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
                return PrivateChatOuterClass.internal_static_com_blued_im_private_chat_Receive_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = Receive.alwaysUseFieldBuilders;
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
            public Receive build() {
                Receive buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Receive buildPartial() {
                Receive receive = new Receive(this);
                receive.from_ = this.from_;
                receive.to_ = this.to_;
                receive.msgType_ = this.msgType_;
                receive.msgId_ = this.msgId_;
                receive.timestamp_ = this.timestamp_;
                receive.distance_ = this.distance_;
                if ((this.bitField0_ & 1) != 0) {
                    this.coords_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                receive.coords_ = this.coords_;
                receive.sessionStatus_ = this.sessionStatus_;
                receive.isDeleted_ = this.isDeleted_;
                receive.isRead_ = this.isRead_;
                SingleFieldBuilderV3<PushBodyOuterClass.PushBody, PushBodyOuterClass.PushBody.Builder, PushBodyOuterClass.PushBodyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
                if (singleFieldBuilderV3 == null) {
                    receive.body_ = this.body_;
                } else {
                    receive.body_ = singleFieldBuilderV3.build();
                }
                receive.sessionType_ = this.sessionType_;
                receive.phoneSessionId_ = this.phoneSessionId_;
                receive.sessionCommonStatus_ = this.sessionCommonStatus_;
                onBuilt();
                return receive;
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
                this.coords_ = Receive.access$4100();
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
                this.coords_ = Receive.access$6200();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            public Builder clearDistance() {
                this.distance_ = Receive.getDefaultInstance().getDistance();
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
                this.sessionCommonStatus_ = Receive.getDefaultInstance().getSessionCommonStatus();
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

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveOrBuilder
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

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveOrBuilder
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

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveOrBuilder
            public double getCoords(int i) {
                return this.coords_.getDouble(i);
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveOrBuilder
            public int getCoordsCount() {
                return this.coords_.size();
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveOrBuilder
            public List<Double> getCoordsList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.coords_) : this.coords_;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Receive getDefaultInstanceForType() {
                return Receive.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PrivateChatOuterClass.internal_static_com_blued_im_private_chat_Receive_descriptor;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveOrBuilder
            public String getDistance() {
                Object obj = this.distance_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.distance_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveOrBuilder
            public ByteString getDistanceBytes() {
                Object obj = this.distance_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.distance_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveOrBuilder
            public int getFrom() {
                return this.from_;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveOrBuilder
            public boolean getIsDeleted() {
                return this.isDeleted_;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveOrBuilder
            public boolean getIsRead() {
                return this.isRead_;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveOrBuilder
            public long getMsgId() {
                return this.msgId_;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveOrBuilder
            public MsgTypeOuterClass.MsgType getMsgType() {
                MsgTypeOuterClass.MsgType valueOf = MsgTypeOuterClass.MsgType.valueOf(this.msgType_);
                MsgTypeOuterClass.MsgType msgType = valueOf;
                if (valueOf == null) {
                    msgType = MsgTypeOuterClass.MsgType.UNRECOGNIZED;
                }
                return msgType;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveOrBuilder
            public int getMsgTypeValue() {
                return this.msgType_;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveOrBuilder
            public int getPhoneSessionId() {
                return this.phoneSessionId_;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveOrBuilder
            public String getSessionCommonStatus() {
                Object obj = this.sessionCommonStatus_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.sessionCommonStatus_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveOrBuilder
            public ByteString getSessionCommonStatusBytes() {
                Object obj = this.sessionCommonStatus_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.sessionCommonStatus_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveOrBuilder
            public int getSessionStatus() {
                return this.sessionStatus_;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveOrBuilder
            public int getSessionType() {
                return this.sessionType_;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveOrBuilder
            public long getTimestamp() {
                return this.timestamp_;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveOrBuilder
            public int getTo() {
                return this.to_;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveOrBuilder
            public boolean hasBody() {
                return (this.bodyBuilder_ == null && this.body_ == null) ? false : true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PrivateChatOuterClass.internal_static_com_blued_im_private_chat_Receive_fieldAccessorTable.ensureFieldAccessorsInitialized(Receive.class, Builder.class);
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

            public Builder mergeFrom(Receive receive) {
                if (receive == Receive.getDefaultInstance()) {
                    return this;
                }
                if (receive.getFrom() != 0) {
                    setFrom(receive.getFrom());
                }
                if (receive.getTo() != 0) {
                    setTo(receive.getTo());
                }
                if (receive.msgType_ != 0) {
                    setMsgTypeValue(receive.getMsgTypeValue());
                }
                if (receive.getMsgId() != 0) {
                    setMsgId(receive.getMsgId());
                }
                if (receive.getTimestamp() != 0) {
                    setTimestamp(receive.getTimestamp());
                }
                if (!receive.getDistance().isEmpty()) {
                    this.distance_ = receive.distance_;
                    onChanged();
                }
                if (!receive.coords_.isEmpty()) {
                    if (this.coords_.isEmpty()) {
                        this.coords_ = receive.coords_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureCoordsIsMutable();
                        this.coords_.addAll(receive.coords_);
                    }
                    onChanged();
                }
                if (receive.getSessionStatus() != 0) {
                    setSessionStatus(receive.getSessionStatus());
                }
                if (receive.getIsDeleted()) {
                    setIsDeleted(receive.getIsDeleted());
                }
                if (receive.getIsRead()) {
                    setIsRead(receive.getIsRead());
                }
                if (receive.hasBody()) {
                    mergeBody(receive.getBody());
                }
                if (receive.getSessionType() != 0) {
                    setSessionType(receive.getSessionType());
                }
                if (receive.getPhoneSessionId() != 0) {
                    setPhoneSessionId(receive.getPhoneSessionId());
                }
                if (!receive.getSessionCommonStatus().isEmpty()) {
                    this.sessionCommonStatus_ = receive.sessionCommonStatus_;
                    onChanged();
                }
                mergeUnknownFields(receive.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.im.private_chat.PrivateChatOuterClass.Receive.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.im.private_chat.PrivateChatOuterClass.Receive.access$5800()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.im.private_chat.PrivateChatOuterClass$Receive r0 = (com.blued.im.private_chat.PrivateChatOuterClass.Receive) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.im.private_chat.PrivateChatOuterClass$Receive$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.im.private_chat.PrivateChatOuterClass$Receive r0 = (com.blued.im.private_chat.PrivateChatOuterClass.Receive) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.im.private_chat.PrivateChatOuterClass$Receive$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.im.private_chat.PrivateChatOuterClass.Receive.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.im.private_chat.PrivateChatOuterClass$Receive$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof Receive) {
                    return mergeFrom((Receive) message);
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
                    Receive.checkByteStringIsUtf8(byteString);
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
                    Receive.checkByteStringIsUtf8(byteString);
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

        private Receive() {
            this.coordsMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.msgType_ = 0;
            this.distance_ = "";
            this.coords_ = emptyDoubleList();
            this.sessionCommonStatus_ = "";
        }

        private Receive(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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

        private Receive(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.coordsMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
        }

        static /* synthetic */ Internal.DoubleList access$4100() {
            return emptyDoubleList();
        }

        static /* synthetic */ Internal.DoubleList access$6000() {
            return emptyDoubleList();
        }

        static /* synthetic */ Internal.DoubleList access$6200() {
            return emptyDoubleList();
        }

        public static Receive getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PrivateChatOuterClass.internal_static_com_blued_im_private_chat_Receive_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Receive receive) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(receive);
        }

        public static Receive parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Receive) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Receive parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Receive) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Receive parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Receive parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Receive parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Receive) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Receive parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Receive) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static Receive parseFrom(InputStream inputStream) throws IOException {
            return (Receive) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Receive parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Receive) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Receive parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Receive parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Receive parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Receive parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<Receive> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Receive) {
                Receive receive = (Receive) obj;
                if (getFrom() == receive.getFrom() && getTo() == receive.getTo() && this.msgType_ == receive.msgType_ && getMsgId() == receive.getMsgId() && getTimestamp() == receive.getTimestamp() && getDistance().equals(receive.getDistance()) && getCoordsList().equals(receive.getCoordsList()) && getSessionStatus() == receive.getSessionStatus() && getIsDeleted() == receive.getIsDeleted() && getIsRead() == receive.getIsRead() && hasBody() == receive.hasBody()) {
                    return (!hasBody() || getBody().equals(receive.getBody())) && getSessionType() == receive.getSessionType() && getPhoneSessionId() == receive.getPhoneSessionId() && getSessionCommonStatus().equals(receive.getSessionCommonStatus()) && this.unknownFields.equals(receive.unknownFields);
                }
                return false;
            }
            return super.equals(obj);
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveOrBuilder
        public PushBodyOuterClass.PushBody getBody() {
            PushBodyOuterClass.PushBody pushBody = this.body_;
            PushBodyOuterClass.PushBody pushBody2 = pushBody;
            if (pushBody == null) {
                pushBody2 = PushBodyOuterClass.PushBody.getDefaultInstance();
            }
            return pushBody2;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveOrBuilder
        public PushBodyOuterClass.PushBodyOrBuilder getBodyOrBuilder() {
            return getBody();
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveOrBuilder
        public double getCoords(int i) {
            return this.coords_.getDouble(i);
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveOrBuilder
        public int getCoordsCount() {
            return this.coords_.size();
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveOrBuilder
        public List<Double> getCoordsList() {
            return this.coords_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Receive getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveOrBuilder
        public String getDistance() {
            Object obj = this.distance_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.distance_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveOrBuilder
        public ByteString getDistanceBytes() {
            Object obj = this.distance_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.distance_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveOrBuilder
        public int getFrom() {
            return this.from_;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveOrBuilder
        public boolean getIsDeleted() {
            return this.isDeleted_;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveOrBuilder
        public boolean getIsRead() {
            return this.isRead_;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveOrBuilder
        public long getMsgId() {
            return this.msgId_;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveOrBuilder
        public MsgTypeOuterClass.MsgType getMsgType() {
            MsgTypeOuterClass.MsgType valueOf = MsgTypeOuterClass.MsgType.valueOf(this.msgType_);
            MsgTypeOuterClass.MsgType msgType = valueOf;
            if (valueOf == null) {
                msgType = MsgTypeOuterClass.MsgType.UNRECOGNIZED;
            }
            return msgType;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveOrBuilder
        public int getMsgTypeValue() {
            return this.msgType_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Receive> getParserForType() {
            return PARSER;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveOrBuilder
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

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveOrBuilder
        public String getSessionCommonStatus() {
            Object obj = this.sessionCommonStatus_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.sessionCommonStatus_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveOrBuilder
        public ByteString getSessionCommonStatusBytes() {
            Object obj = this.sessionCommonStatus_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.sessionCommonStatus_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveOrBuilder
        public int getSessionStatus() {
            return this.sessionStatus_;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveOrBuilder
        public int getSessionType() {
            return this.sessionType_;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveOrBuilder
        public long getTimestamp() {
            return this.timestamp_;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveOrBuilder
        public int getTo() {
            return this.to_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveOrBuilder
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
            return PrivateChatOuterClass.internal_static_com_blued_im_private_chat_Receive_fieldAccessorTable.ensureFieldAccessorsInitialized(Receive.class, Builder.class);
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
            return new Receive();
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

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/PrivateChatOuterClass$ReceiveNew.class */
    public static final class ReceiveNew extends GeneratedMessageV3 implements ReceiveNewOrBuilder {
        public static final int BODY_FIELD_NUMBER = 11;
        public static final int COORDS_FIELD_NUMBER = 7;
        public static final int DISTANCE_FIELD_NUMBER = 6;
        public static final int FROM_FIELD_NUMBER = 1;
        public static final int IS_DELETED_FIELD_NUMBER = 9;
        public static final int IS_READ_FIELD_NUMBER = 10;
        public static final int MSG_ID_FIELD_NUMBER = 4;
        public static final int MSG_TYPE_FIELD_NUMBER = 3;
        public static final int PHONE_SESSION_ID_FIELD_NUMBER = 13;
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
        private int sessionStatus_;
        private int sessionType_;
        private long timestamp_;
        private int to_;
        private static final ReceiveNew DEFAULT_INSTANCE = new ReceiveNew();
        private static final Parser<ReceiveNew> PARSER = new AbstractParser<ReceiveNew>() { // from class: com.blued.im.private_chat.PrivateChatOuterClass.ReceiveNew.1
            @Override // com.google.protobuf.Parser
            public ReceiveNew parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ReceiveNew(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/PrivateChatOuterClass$ReceiveNew$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ReceiveNewOrBuilder {
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
            private int sessionStatus_;
            private int sessionType_;
            private long timestamp_;
            private int to_;

            private Builder() {
                this.msgType_ = 0;
                this.distance_ = "";
                this.coords_ = ReceiveNew.access$8800();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.msgType_ = 0;
                this.distance_ = "";
                this.coords_ = ReceiveNew.access$8800();
                maybeForceBuilderInitialization();
            }

            private void ensureCoordsIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.coords_ = ReceiveNew.mutableCopy(this.coords_);
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
                return PrivateChatOuterClass.internal_static_com_blued_im_private_chat_ReceiveNew_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = ReceiveNew.alwaysUseFieldBuilders;
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
            public ReceiveNew build() {
                ReceiveNew buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ReceiveNew buildPartial() {
                ReceiveNew receiveNew = new ReceiveNew(this);
                receiveNew.from_ = this.from_;
                receiveNew.to_ = this.to_;
                receiveNew.msgType_ = this.msgType_;
                receiveNew.msgId_ = this.msgId_;
                receiveNew.timestamp_ = this.timestamp_;
                receiveNew.distance_ = this.distance_;
                if ((this.bitField0_ & 1) != 0) {
                    this.coords_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                receiveNew.coords_ = this.coords_;
                receiveNew.sessionStatus_ = this.sessionStatus_;
                receiveNew.isDeleted_ = this.isDeleted_;
                receiveNew.isRead_ = this.isRead_;
                SingleFieldBuilderV3<PushBodyOuterClass.PushBody, PushBodyOuterClass.PushBody.Builder, PushBodyOuterClass.PushBodyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
                if (singleFieldBuilderV3 == null) {
                    receiveNew.body_ = this.body_;
                } else {
                    receiveNew.body_ = singleFieldBuilderV3.build();
                }
                receiveNew.sessionType_ = this.sessionType_;
                receiveNew.phoneSessionId_ = this.phoneSessionId_;
                onBuilt();
                return receiveNew;
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
                this.coords_ = ReceiveNew.access$7000();
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
                this.coords_ = ReceiveNew.access$9000();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            public Builder clearDistance() {
                this.distance_ = ReceiveNew.getDefaultInstance().getDistance();
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

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveNewOrBuilder
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

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveNewOrBuilder
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

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveNewOrBuilder
            public double getCoords(int i) {
                return this.coords_.getDouble(i);
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveNewOrBuilder
            public int getCoordsCount() {
                return this.coords_.size();
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveNewOrBuilder
            public List<Double> getCoordsList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.coords_) : this.coords_;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ReceiveNew getDefaultInstanceForType() {
                return ReceiveNew.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PrivateChatOuterClass.internal_static_com_blued_im_private_chat_ReceiveNew_descriptor;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveNewOrBuilder
            public String getDistance() {
                Object obj = this.distance_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.distance_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveNewOrBuilder
            public ByteString getDistanceBytes() {
                Object obj = this.distance_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.distance_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveNewOrBuilder
            public int getFrom() {
                return this.from_;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveNewOrBuilder
            public boolean getIsDeleted() {
                return this.isDeleted_;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveNewOrBuilder
            public boolean getIsRead() {
                return this.isRead_;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveNewOrBuilder
            public long getMsgId() {
                return this.msgId_;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveNewOrBuilder
            public MsgTypeOuterClass.MsgType getMsgType() {
                MsgTypeOuterClass.MsgType valueOf = MsgTypeOuterClass.MsgType.valueOf(this.msgType_);
                MsgTypeOuterClass.MsgType msgType = valueOf;
                if (valueOf == null) {
                    msgType = MsgTypeOuterClass.MsgType.UNRECOGNIZED;
                }
                return msgType;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveNewOrBuilder
            public int getMsgTypeValue() {
                return this.msgType_;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveNewOrBuilder
            public int getPhoneSessionId() {
                return this.phoneSessionId_;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveNewOrBuilder
            public int getSessionStatus() {
                return this.sessionStatus_;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveNewOrBuilder
            public int getSessionType() {
                return this.sessionType_;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveNewOrBuilder
            public long getTimestamp() {
                return this.timestamp_;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveNewOrBuilder
            public int getTo() {
                return this.to_;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveNewOrBuilder
            public boolean hasBody() {
                return (this.bodyBuilder_ == null && this.body_ == null) ? false : true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PrivateChatOuterClass.internal_static_com_blued_im_private_chat_ReceiveNew_fieldAccessorTable.ensureFieldAccessorsInitialized(ReceiveNew.class, Builder.class);
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

            public Builder mergeFrom(ReceiveNew receiveNew) {
                if (receiveNew == ReceiveNew.getDefaultInstance()) {
                    return this;
                }
                if (receiveNew.getFrom() != 0) {
                    setFrom(receiveNew.getFrom());
                }
                if (receiveNew.getTo() != 0) {
                    setTo(receiveNew.getTo());
                }
                if (receiveNew.msgType_ != 0) {
                    setMsgTypeValue(receiveNew.getMsgTypeValue());
                }
                if (receiveNew.getMsgId() != 0) {
                    setMsgId(receiveNew.getMsgId());
                }
                if (receiveNew.getTimestamp() != 0) {
                    setTimestamp(receiveNew.getTimestamp());
                }
                if (!receiveNew.getDistance().isEmpty()) {
                    this.distance_ = receiveNew.distance_;
                    onChanged();
                }
                if (!receiveNew.coords_.isEmpty()) {
                    if (this.coords_.isEmpty()) {
                        this.coords_ = receiveNew.coords_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureCoordsIsMutable();
                        this.coords_.addAll(receiveNew.coords_);
                    }
                    onChanged();
                }
                if (receiveNew.getSessionStatus() != 0) {
                    setSessionStatus(receiveNew.getSessionStatus());
                }
                if (receiveNew.getIsDeleted()) {
                    setIsDeleted(receiveNew.getIsDeleted());
                }
                if (receiveNew.getIsRead()) {
                    setIsRead(receiveNew.getIsRead());
                }
                if (receiveNew.hasBody()) {
                    mergeBody(receiveNew.getBody());
                }
                if (receiveNew.getSessionType() != 0) {
                    setSessionType(receiveNew.getSessionType());
                }
                if (receiveNew.getPhoneSessionId() != 0) {
                    setPhoneSessionId(receiveNew.getPhoneSessionId());
                }
                mergeUnknownFields(receiveNew.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.im.private_chat.PrivateChatOuterClass.ReceiveNew.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.im.private_chat.PrivateChatOuterClass.ReceiveNew.access$8600()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.im.private_chat.PrivateChatOuterClass$ReceiveNew r0 = (com.blued.im.private_chat.PrivateChatOuterClass.ReceiveNew) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.im.private_chat.PrivateChatOuterClass$ReceiveNew$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.im.private_chat.PrivateChatOuterClass$ReceiveNew r0 = (com.blued.im.private_chat.PrivateChatOuterClass.ReceiveNew) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.im.private_chat.PrivateChatOuterClass$ReceiveNew$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.im.private_chat.PrivateChatOuterClass.ReceiveNew.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.im.private_chat.PrivateChatOuterClass$ReceiveNew$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof ReceiveNew) {
                    return mergeFrom((ReceiveNew) message);
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
                    ReceiveNew.checkByteStringIsUtf8(byteString);
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

        private ReceiveNew() {
            this.coordsMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.msgType_ = 0;
            this.distance_ = "";
            this.coords_ = emptyDoubleList();
        }

        private ReceiveNew(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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

        private ReceiveNew(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.coordsMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
        }

        static /* synthetic */ Internal.DoubleList access$7000() {
            return emptyDoubleList();
        }

        static /* synthetic */ Internal.DoubleList access$8800() {
            return emptyDoubleList();
        }

        static /* synthetic */ Internal.DoubleList access$9000() {
            return emptyDoubleList();
        }

        public static ReceiveNew getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PrivateChatOuterClass.internal_static_com_blued_im_private_chat_ReceiveNew_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ReceiveNew receiveNew) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(receiveNew);
        }

        public static ReceiveNew parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ReceiveNew) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static ReceiveNew parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReceiveNew) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static ReceiveNew parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static ReceiveNew parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static ReceiveNew parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ReceiveNew) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static ReceiveNew parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReceiveNew) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static ReceiveNew parseFrom(InputStream inputStream) throws IOException {
            return (ReceiveNew) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static ReceiveNew parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReceiveNew) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static ReceiveNew parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static ReceiveNew parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static ReceiveNew parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static ReceiveNew parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<ReceiveNew> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof ReceiveNew) {
                ReceiveNew receiveNew = (ReceiveNew) obj;
                if (getFrom() == receiveNew.getFrom() && getTo() == receiveNew.getTo() && this.msgType_ == receiveNew.msgType_ && getMsgId() == receiveNew.getMsgId() && getTimestamp() == receiveNew.getTimestamp() && getDistance().equals(receiveNew.getDistance()) && getCoordsList().equals(receiveNew.getCoordsList()) && getSessionStatus() == receiveNew.getSessionStatus() && getIsDeleted() == receiveNew.getIsDeleted() && getIsRead() == receiveNew.getIsRead() && hasBody() == receiveNew.hasBody()) {
                    return (!hasBody() || getBody().equals(receiveNew.getBody())) && getSessionType() == receiveNew.getSessionType() && getPhoneSessionId() == receiveNew.getPhoneSessionId() && this.unknownFields.equals(receiveNew.unknownFields);
                }
                return false;
            }
            return super.equals(obj);
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveNewOrBuilder
        public PushBodyOuterClass.PushBody getBody() {
            PushBodyOuterClass.PushBody pushBody = this.body_;
            PushBodyOuterClass.PushBody pushBody2 = pushBody;
            if (pushBody == null) {
                pushBody2 = PushBodyOuterClass.PushBody.getDefaultInstance();
            }
            return pushBody2;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveNewOrBuilder
        public PushBodyOuterClass.PushBodyOrBuilder getBodyOrBuilder() {
            return getBody();
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveNewOrBuilder
        public double getCoords(int i) {
            return this.coords_.getDouble(i);
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveNewOrBuilder
        public int getCoordsCount() {
            return this.coords_.size();
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveNewOrBuilder
        public List<Double> getCoordsList() {
            return this.coords_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ReceiveNew getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveNewOrBuilder
        public String getDistance() {
            Object obj = this.distance_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.distance_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveNewOrBuilder
        public ByteString getDistanceBytes() {
            Object obj = this.distance_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.distance_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveNewOrBuilder
        public int getFrom() {
            return this.from_;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveNewOrBuilder
        public boolean getIsDeleted() {
            return this.isDeleted_;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveNewOrBuilder
        public boolean getIsRead() {
            return this.isRead_;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveNewOrBuilder
        public long getMsgId() {
            return this.msgId_;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveNewOrBuilder
        public MsgTypeOuterClass.MsgType getMsgType() {
            MsgTypeOuterClass.MsgType valueOf = MsgTypeOuterClass.MsgType.valueOf(this.msgType_);
            MsgTypeOuterClass.MsgType msgType = valueOf;
            if (valueOf == null) {
                msgType = MsgTypeOuterClass.MsgType.UNRECOGNIZED;
            }
            return msgType;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveNewOrBuilder
        public int getMsgTypeValue() {
            return this.msgType_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ReceiveNew> getParserForType() {
            return PARSER;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveNewOrBuilder
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
            int serializedSize = i20 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveNewOrBuilder
        public int getSessionStatus() {
            return this.sessionStatus_;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveNewOrBuilder
        public int getSessionType() {
            return this.sessionType_;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveNewOrBuilder
        public long getTimestamp() {
            return this.timestamp_;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveNewOrBuilder
        public int getTo() {
            return this.to_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ReceiveNewOrBuilder
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
            int sessionType = (((((((((i2 * 37) + 12) * 53) + getSessionType()) * 37) + 13) * 53) + getPhoneSessionId()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = sessionType;
            return sessionType;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PrivateChatOuterClass.internal_static_com_blued_im_private_chat_ReceiveNew_fieldAccessorTable.ensureFieldAccessorsInitialized(ReceiveNew.class, Builder.class);
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
            return new ReceiveNew();
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
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/PrivateChatOuterClass$ReceiveNewOrBuilder.class */
    public interface ReceiveNewOrBuilder extends MessageOrBuilder {
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

        int getSessionStatus();

        int getSessionType();

        long getTimestamp();

        int getTo();

        boolean hasBody();
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/PrivateChatOuterClass$ReceiveOrBuilder.class */
    public interface ReceiveOrBuilder extends MessageOrBuilder {
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

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/PrivateChatOuterClass$Request.class */
    public static final class Request extends GeneratedMessageV3 implements RequestOrBuilder {
        public static final int BODY_FIELD_NUMBER = 5;
        public static final int COMMON_FIELD_NUMBER = 1;
        public static final int FROM_FIELD_NUMBER = 6;
        public static final int LOCAL_ID_FIELD_NUMBER = 4;
        public static final int MSG_TYPE_FIELD_NUMBER = 3;
        public static final int SESSION_TYPE_FIELD_NUMBER = 7;
        public static final int TO_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private Any body_;
        private CommonOuterClass.Common common_;
        private int from_;
        private int localId_;
        private byte memoizedIsInitialized;
        private int msgType_;
        private int sessionType_;
        private int to_;
        private static final Request DEFAULT_INSTANCE = new Request();
        private static final Parser<Request> PARSER = new AbstractParser<Request>() { // from class: com.blued.im.private_chat.PrivateChatOuterClass.Request.1
            @Override // com.google.protobuf.Parser
            public Request parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Request(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/PrivateChatOuterClass$Request$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RequestOrBuilder {
            private SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> bodyBuilder_;
            private Any body_;
            private SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> commonBuilder_;
            private CommonOuterClass.Common common_;
            private int from_;
            private int localId_;
            private int msgType_;
            private int sessionType_;
            private int to_;

            private Builder() {
                this.msgType_ = 0;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.msgType_ = 0;
                maybeForceBuilderInitialization();
            }

            private SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> getBodyFieldBuilder() {
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
                return PrivateChatOuterClass.internal_static_com_blued_im_private_chat_Request_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = Request.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Request build() {
                Request buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Request buildPartial() {
                Request request = new Request(this);
                SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 == null) {
                    request.common_ = this.common_;
                } else {
                    request.common_ = singleFieldBuilderV3.build();
                }
                request.to_ = this.to_;
                request.msgType_ = this.msgType_;
                request.localId_ = this.localId_;
                SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV32 = this.bodyBuilder_;
                if (singleFieldBuilderV32 == null) {
                    request.body_ = this.body_;
                } else {
                    request.body_ = singleFieldBuilderV32.build();
                }
                request.from_ = this.from_;
                request.sessionType_ = this.sessionType_;
                onBuilt();
                return request;
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
                this.to_ = 0;
                this.msgType_ = 0;
                this.localId_ = 0;
                if (this.bodyBuilder_ == null) {
                    this.body_ = null;
                } else {
                    this.body_ = null;
                    this.bodyBuilder_ = null;
                }
                this.from_ = 0;
                this.sessionType_ = 0;
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearFrom() {
                this.from_ = 0;
                onChanged();
                return this;
            }

            public Builder clearLocalId() {
                this.localId_ = 0;
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

            public Builder clearSessionType() {
                this.sessionType_ = 0;
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

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.RequestOrBuilder
            public Any getBody() {
                SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Any any = this.body_;
                    Any any2 = any;
                    if (any == null) {
                        any2 = Any.getDefaultInstance();
                    }
                    return any2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Any.Builder getBodyBuilder() {
                onChanged();
                return getBodyFieldBuilder().getBuilder();
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.RequestOrBuilder
            public AnyOrBuilder getBodyOrBuilder() {
                SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Any any = this.body_;
                Any any2 = any;
                if (any == null) {
                    any2 = Any.getDefaultInstance();
                }
                return any2;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.RequestOrBuilder
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

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.RequestOrBuilder
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

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Request getDefaultInstanceForType() {
                return Request.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PrivateChatOuterClass.internal_static_com_blued_im_private_chat_Request_descriptor;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.RequestOrBuilder
            public int getFrom() {
                return this.from_;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.RequestOrBuilder
            public int getLocalId() {
                return this.localId_;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.RequestOrBuilder
            public MsgTypeOuterClass.MsgType getMsgType() {
                MsgTypeOuterClass.MsgType valueOf = MsgTypeOuterClass.MsgType.valueOf(this.msgType_);
                MsgTypeOuterClass.MsgType msgType = valueOf;
                if (valueOf == null) {
                    msgType = MsgTypeOuterClass.MsgType.UNRECOGNIZED;
                }
                return msgType;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.RequestOrBuilder
            public int getMsgTypeValue() {
                return this.msgType_;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.RequestOrBuilder
            public int getSessionType() {
                return this.sessionType_;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.RequestOrBuilder
            public int getTo() {
                return this.to_;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.RequestOrBuilder
            public boolean hasBody() {
                return (this.bodyBuilder_ == null && this.body_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.RequestOrBuilder
            public boolean hasCommon() {
                return (this.commonBuilder_ == null && this.common_ == null) ? false : true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PrivateChatOuterClass.internal_static_com_blued_im_private_chat_Request_fieldAccessorTable.ensureFieldAccessorsInitialized(Request.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeBody(Any any) {
                SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(any);
                    return this;
                }
                Any any2 = this.body_;
                if (any2 != null) {
                    this.body_ = Any.newBuilder(any2).mergeFrom(any).buildPartial();
                } else {
                    this.body_ = any;
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

            public Builder mergeFrom(Request request) {
                if (request == Request.getDefaultInstance()) {
                    return this;
                }
                if (request.hasCommon()) {
                    mergeCommon(request.getCommon());
                }
                if (request.getTo() != 0) {
                    setTo(request.getTo());
                }
                if (request.msgType_ != 0) {
                    setMsgTypeValue(request.getMsgTypeValue());
                }
                if (request.getLocalId() != 0) {
                    setLocalId(request.getLocalId());
                }
                if (request.hasBody()) {
                    mergeBody(request.getBody());
                }
                if (request.getFrom() != 0) {
                    setFrom(request.getFrom());
                }
                if (request.getSessionType() != 0) {
                    setSessionType(request.getSessionType());
                }
                mergeUnknownFields(request.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.im.private_chat.PrivateChatOuterClass.Request.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.im.private_chat.PrivateChatOuterClass.Request.access$1400()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.im.private_chat.PrivateChatOuterClass$Request r0 = (com.blued.im.private_chat.PrivateChatOuterClass.Request) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.im.private_chat.PrivateChatOuterClass$Request$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.im.private_chat.PrivateChatOuterClass$Request r0 = (com.blued.im.private_chat.PrivateChatOuterClass.Request) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.im.private_chat.PrivateChatOuterClass$Request$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.im.private_chat.PrivateChatOuterClass.Request.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.im.private_chat.PrivateChatOuterClass$Request$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof Request) {
                    return mergeFrom((Request) message);
                }
                super.mergeFrom(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder setBody(Any.Builder builder) {
                SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.body_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setBody(Any any) {
                SingleFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> singleFieldBuilderV3 = this.bodyBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(any);
                    return this;
                } else if (any != null) {
                    this.body_ = any;
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setFrom(int i) {
                this.from_ = i;
                onChanged();
                return this;
            }

            public Builder setLocalId(int i) {
                this.localId_ = i;
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setSessionType(int i) {
                this.sessionType_ = i;
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

        private Request() {
            this.memoizedIsInitialized = (byte) -1;
            this.msgType_ = 0;
        }

        private Request(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.to_ = codedInputStream.readUInt32();
                                } else if (readTag == 24) {
                                    this.msgType_ = codedInputStream.readEnum();
                                } else if (readTag == 32) {
                                    this.localId_ = codedInputStream.readInt32();
                                } else if (readTag == 42) {
                                    Any.Builder builder2 = this.body_ != null ? this.body_.toBuilder() : null;
                                    Any any = (Any) codedInputStream.readMessage(Any.parser(), extensionRegistryLite);
                                    this.body_ = any;
                                    if (builder2 != null) {
                                        builder2.mergeFrom(any);
                                        this.body_ = builder2.buildPartial();
                                    }
                                } else if (readTag == 48) {
                                    this.from_ = codedInputStream.readUInt32();
                                } else if (readTag == 56) {
                                    this.sessionType_ = codedInputStream.readUInt32();
                                } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e) {
                            throw e.setUnfinishedMessage(this);
                        }
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        private Request(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Request getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PrivateChatOuterClass.internal_static_com_blued_im_private_chat_Request_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Request request) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(request);
        }

        public static Request parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Request) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Request parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Request) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Request parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Request parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Request parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Request) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Request parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Request) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static Request parseFrom(InputStream inputStream) throws IOException {
            return (Request) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Request parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Request) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Request parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Request parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Request parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Request parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<Request> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Request) {
                Request request = (Request) obj;
                if (hasCommon() != request.hasCommon()) {
                    return false;
                }
                if ((!hasCommon() || getCommon().equals(request.getCommon())) && getTo() == request.getTo() && this.msgType_ == request.msgType_ && getLocalId() == request.getLocalId() && hasBody() == request.hasBody()) {
                    return (!hasBody() || getBody().equals(request.getBody())) && getFrom() == request.getFrom() && getSessionType() == request.getSessionType() && this.unknownFields.equals(request.unknownFields);
                }
                return false;
            }
            return super.equals(obj);
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.RequestOrBuilder
        public Any getBody() {
            Any any = this.body_;
            Any any2 = any;
            if (any == null) {
                any2 = Any.getDefaultInstance();
            }
            return any2;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.RequestOrBuilder
        public AnyOrBuilder getBodyOrBuilder() {
            return getBody();
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.RequestOrBuilder
        public CommonOuterClass.Common getCommon() {
            CommonOuterClass.Common common = this.common_;
            CommonOuterClass.Common common2 = common;
            if (common == null) {
                common2 = CommonOuterClass.Common.getDefaultInstance();
            }
            return common2;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.RequestOrBuilder
        public CommonOuterClass.CommonOrBuilder getCommonOrBuilder() {
            return getCommon();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Request getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.RequestOrBuilder
        public int getFrom() {
            return this.from_;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.RequestOrBuilder
        public int getLocalId() {
            return this.localId_;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.RequestOrBuilder
        public MsgTypeOuterClass.MsgType getMsgType() {
            MsgTypeOuterClass.MsgType valueOf = MsgTypeOuterClass.MsgType.valueOf(this.msgType_);
            MsgTypeOuterClass.MsgType msgType = valueOf;
            if (valueOf == null) {
                msgType = MsgTypeOuterClass.MsgType.UNRECOGNIZED;
            }
            return msgType;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.RequestOrBuilder
        public int getMsgTypeValue() {
            return this.msgType_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Request> getParserForType() {
            return PARSER;
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
            int i3 = this.to_;
            int i4 = i2;
            if (i3 != 0) {
                i4 = i2 + CodedOutputStream.computeUInt32Size(2, i3);
            }
            int i5 = i4;
            if (this.msgType_ != MsgTypeOuterClass.MsgType.UNKNOWN_MSG_TYPE.getNumber()) {
                i5 = i4 + CodedOutputStream.computeEnumSize(3, this.msgType_);
            }
            int i6 = this.localId_;
            int i7 = i5;
            if (i6 != 0) {
                i7 = i5 + CodedOutputStream.computeInt32Size(4, i6);
            }
            int i8 = i7;
            if (this.body_ != null) {
                i8 = i7 + CodedOutputStream.computeMessageSize(5, getBody());
            }
            int i9 = this.from_;
            int i10 = i8;
            if (i9 != 0) {
                i10 = i8 + CodedOutputStream.computeUInt32Size(6, i9);
            }
            int i11 = this.sessionType_;
            int i12 = i10;
            if (i11 != 0) {
                i12 = i10 + CodedOutputStream.computeUInt32Size(7, i11);
            }
            int serializedSize = i12 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.RequestOrBuilder
        public int getSessionType() {
            return this.sessionType_;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.RequestOrBuilder
        public int getTo() {
            return this.to_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.RequestOrBuilder
        public boolean hasBody() {
            return this.body_ != null;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.RequestOrBuilder
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
            int to = (((((((((((i * 37) + 2) * 53) + getTo()) * 37) + 3) * 53) + this.msgType_) * 37) + 4) * 53) + getLocalId();
            int i2 = to;
            if (hasBody()) {
                i2 = (((to * 37) + 5) * 53) + getBody().hashCode();
            }
            int from = (((((((((i2 * 37) + 6) * 53) + getFrom()) * 37) + 7) * 53) + getSessionType()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = from;
            return from;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PrivateChatOuterClass.internal_static_com_blued_im_private_chat_Request_fieldAccessorTable.ensureFieldAccessorsInitialized(Request.class, Builder.class);
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
            return new Request();
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
            int i = this.to_;
            if (i != 0) {
                codedOutputStream.writeUInt32(2, i);
            }
            if (this.msgType_ != MsgTypeOuterClass.MsgType.UNKNOWN_MSG_TYPE.getNumber()) {
                codedOutputStream.writeEnum(3, this.msgType_);
            }
            int i2 = this.localId_;
            if (i2 != 0) {
                codedOutputStream.writeInt32(4, i2);
            }
            if (this.body_ != null) {
                codedOutputStream.writeMessage(5, getBody());
            }
            int i3 = this.from_;
            if (i3 != 0) {
                codedOutputStream.writeUInt32(6, i3);
            }
            int i4 = this.sessionType_;
            if (i4 != 0) {
                codedOutputStream.writeUInt32(7, i4);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/PrivateChatOuterClass$RequestOrBuilder.class */
    public interface RequestOrBuilder extends MessageOrBuilder {
        Any getBody();

        AnyOrBuilder getBodyOrBuilder();

        CommonOuterClass.Common getCommon();

        CommonOuterClass.CommonOrBuilder getCommonOrBuilder();

        int getFrom();

        int getLocalId();

        MsgTypeOuterClass.MsgType getMsgType();

        int getMsgTypeValue();

        int getSessionType();

        int getTo();

        boolean hasBody();

        boolean hasCommon();
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/PrivateChatOuterClass$Response.class */
    public static final class Response extends GeneratedMessageV3 implements ResponseOrBuilder {
        public static final int CODE_FIELD_NUMBER = 1;
        public static final int LOCAL_ID_FIELD_NUMBER = 4;
        public static final int MESSAGE_FIELD_NUMBER = 2;
        public static final int MSG_ID_FIELD_NUMBER = 3;
        public static final int PROMPT_TYPE_FIELD_NUMBER = 8;
        public static final int REQUEST_ID_FIELD_NUMBER = 5;
        public static final int REQUEST_TIME_FIELD_NUMBER = 6;
        public static final int RESPONSE_TIME_FIELD_NUMBER = 7;
        private static final long serialVersionUID = 0;
        private int code_;
        private int localId_;
        private byte memoizedIsInitialized;
        private volatile Object message_;
        private long msgId_;
        private volatile Object promptType_;
        private volatile Object requestId_;
        private long requestTime_;
        private long responseTime_;
        private static final Response DEFAULT_INSTANCE = new Response();
        private static final Parser<Response> PARSER = new AbstractParser<Response>() { // from class: com.blued.im.private_chat.PrivateChatOuterClass.Response.1
            @Override // com.google.protobuf.Parser
            public Response parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Response(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/PrivateChatOuterClass$Response$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ResponseOrBuilder {
            private int code_;
            private int localId_;
            private Object message_;
            private long msgId_;
            private Object promptType_;
            private Object requestId_;
            private long requestTime_;
            private long responseTime_;

            private Builder() {
                this.code_ = 0;
                this.message_ = "";
                this.requestId_ = "";
                this.promptType_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.code_ = 0;
                this.message_ = "";
                this.requestId_ = "";
                this.promptType_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return PrivateChatOuterClass.internal_static_com_blued_im_private_chat_Response_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = Response.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Response build() {
                Response buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Response buildPartial() {
                Response response = new Response(this);
                response.code_ = this.code_;
                response.message_ = this.message_;
                response.msgId_ = this.msgId_;
                response.localId_ = this.localId_;
                response.requestId_ = this.requestId_;
                response.requestTime_ = this.requestTime_;
                response.responseTime_ = this.responseTime_;
                response.promptType_ = this.promptType_;
                onBuilt();
                return response;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.code_ = 0;
                this.message_ = "";
                this.msgId_ = 0L;
                this.localId_ = 0;
                this.requestId_ = "";
                this.requestTime_ = 0L;
                this.responseTime_ = 0L;
                this.promptType_ = "";
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
                this.message_ = Response.getDefaultInstance().getMessage();
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

            public Builder clearPromptType() {
                this.promptType_ = Response.getDefaultInstance().getPromptType();
                onChanged();
                return this;
            }

            public Builder clearRequestId() {
                this.requestId_ = Response.getDefaultInstance().getRequestId();
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

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ResponseOrBuilder
            public CodeOuterClass.Code getCode() {
                CodeOuterClass.Code valueOf = CodeOuterClass.Code.valueOf(this.code_);
                CodeOuterClass.Code code = valueOf;
                if (valueOf == null) {
                    code = CodeOuterClass.Code.UNRECOGNIZED;
                }
                return code;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ResponseOrBuilder
            public int getCodeValue() {
                return this.code_;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Response getDefaultInstanceForType() {
                return Response.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PrivateChatOuterClass.internal_static_com_blued_im_private_chat_Response_descriptor;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ResponseOrBuilder
            public int getLocalId() {
                return this.localId_;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ResponseOrBuilder
            public String getMessage() {
                Object obj = this.message_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.message_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ResponseOrBuilder
            public ByteString getMessageBytes() {
                Object obj = this.message_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.message_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ResponseOrBuilder
            public long getMsgId() {
                return this.msgId_;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ResponseOrBuilder
            public String getPromptType() {
                Object obj = this.promptType_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.promptType_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ResponseOrBuilder
            public ByteString getPromptTypeBytes() {
                Object obj = this.promptType_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.promptType_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ResponseOrBuilder
            public String getRequestId() {
                Object obj = this.requestId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.requestId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ResponseOrBuilder
            public ByteString getRequestIdBytes() {
                Object obj = this.requestId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.requestId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ResponseOrBuilder
            public long getRequestTime() {
                return this.requestTime_;
            }

            @Override // com.blued.im.private_chat.PrivateChatOuterClass.ResponseOrBuilder
            public long getResponseTime() {
                return this.responseTime_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PrivateChatOuterClass.internal_static_com_blued_im_private_chat_Response_fieldAccessorTable.ensureFieldAccessorsInitialized(Response.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(Response response) {
                if (response == Response.getDefaultInstance()) {
                    return this;
                }
                if (response.code_ != 0) {
                    setCodeValue(response.getCodeValue());
                }
                if (!response.getMessage().isEmpty()) {
                    this.message_ = response.message_;
                    onChanged();
                }
                if (response.getMsgId() != 0) {
                    setMsgId(response.getMsgId());
                }
                if (response.getLocalId() != 0) {
                    setLocalId(response.getLocalId());
                }
                if (!response.getRequestId().isEmpty()) {
                    this.requestId_ = response.requestId_;
                    onChanged();
                }
                if (response.getRequestTime() != 0) {
                    setRequestTime(response.getRequestTime());
                }
                if (response.getResponseTime() != 0) {
                    setResponseTime(response.getResponseTime());
                }
                if (!response.getPromptType().isEmpty()) {
                    this.promptType_ = response.promptType_;
                    onChanged();
                }
                mergeUnknownFields(response.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.im.private_chat.PrivateChatOuterClass.Response.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.im.private_chat.PrivateChatOuterClass.Response.access$3100()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.im.private_chat.PrivateChatOuterClass$Response r0 = (com.blued.im.private_chat.PrivateChatOuterClass.Response) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.im.private_chat.PrivateChatOuterClass$Response$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.im.private_chat.PrivateChatOuterClass$Response r0 = (com.blued.im.private_chat.PrivateChatOuterClass.Response) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.im.private_chat.PrivateChatOuterClass$Response$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.im.private_chat.PrivateChatOuterClass.Response.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.im.private_chat.PrivateChatOuterClass$Response$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof Response) {
                    return mergeFrom((Response) message);
                }
                super.mergeFrom(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
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
                    Response.checkByteStringIsUtf8(byteString);
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

            public Builder setPromptType(String str) {
                if (str != null) {
                    this.promptType_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setPromptTypeBytes(ByteString byteString) {
                if (byteString != null) {
                    Response.checkByteStringIsUtf8(byteString);
                    this.promptType_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
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
                    Response.checkByteStringIsUtf8(byteString);
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

        private Response() {
            this.memoizedIsInitialized = (byte) -1;
            this.code_ = 0;
            this.message_ = "";
            this.requestId_ = "";
            this.promptType_ = "";
        }

        private Response(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.code_ = codedInputStream.readEnum();
                            } else if (readTag == 18) {
                                this.message_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 24) {
                                this.msgId_ = codedInputStream.readInt64();
                            } else if (readTag == 32) {
                                this.localId_ = codedInputStream.readInt32();
                            } else if (readTag == 42) {
                                this.requestId_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 48) {
                                this.requestTime_ = codedInputStream.readInt64();
                            } else if (readTag == 56) {
                                this.responseTime_ = codedInputStream.readInt64();
                            } else if (readTag == 66) {
                                this.promptType_ = codedInputStream.readStringRequireUtf8();
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

        private Response(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Response getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PrivateChatOuterClass.internal_static_com_blued_im_private_chat_Response_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Response response) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(response);
        }

        public static Response parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Response) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Response parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Response) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Response parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Response parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Response parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Response) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Response parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Response) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static Response parseFrom(InputStream inputStream) throws IOException {
            return (Response) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Response parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Response) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Response parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Response parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Response parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Response parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<Response> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Response) {
                Response response = (Response) obj;
                return this.code_ == response.code_ && getMessage().equals(response.getMessage()) && getMsgId() == response.getMsgId() && getLocalId() == response.getLocalId() && getRequestId().equals(response.getRequestId()) && getRequestTime() == response.getRequestTime() && getResponseTime() == response.getResponseTime() && getPromptType().equals(response.getPromptType()) && this.unknownFields.equals(response.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ResponseOrBuilder
        public CodeOuterClass.Code getCode() {
            CodeOuterClass.Code valueOf = CodeOuterClass.Code.valueOf(this.code_);
            CodeOuterClass.Code code = valueOf;
            if (valueOf == null) {
                code = CodeOuterClass.Code.UNRECOGNIZED;
            }
            return code;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ResponseOrBuilder
        public int getCodeValue() {
            return this.code_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Response getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ResponseOrBuilder
        public int getLocalId() {
            return this.localId_;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ResponseOrBuilder
        public String getMessage() {
            Object obj = this.message_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.message_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ResponseOrBuilder
        public ByteString getMessageBytes() {
            Object obj = this.message_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.message_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ResponseOrBuilder
        public long getMsgId() {
            return this.msgId_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Response> getParserForType() {
            return PARSER;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ResponseOrBuilder
        public String getPromptType() {
            Object obj = this.promptType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.promptType_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ResponseOrBuilder
        public ByteString getPromptTypeBytes() {
            Object obj = this.promptType_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.promptType_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ResponseOrBuilder
        public String getRequestId() {
            Object obj = this.requestId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.requestId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ResponseOrBuilder
        public ByteString getRequestIdBytes() {
            Object obj = this.requestId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.requestId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ResponseOrBuilder
        public long getRequestTime() {
            return this.requestTime_;
        }

        @Override // com.blued.im.private_chat.PrivateChatOuterClass.ResponseOrBuilder
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
            if (!getRequestIdBytes().isEmpty()) {
                i7 = i6 + GeneratedMessageV3.computeStringSize(5, this.requestId_);
            }
            long j2 = this.requestTime_;
            int i8 = i7;
            if (j2 != 0) {
                i8 = i7 + CodedOutputStream.computeInt64Size(6, j2);
            }
            long j3 = this.responseTime_;
            int i9 = i8;
            if (j3 != 0) {
                i9 = i8 + CodedOutputStream.computeInt64Size(7, j3);
            }
            int i10 = i9;
            if (!getPromptTypeBytes().isEmpty()) {
                i10 = i9 + GeneratedMessageV3.computeStringSize(8, this.promptType_);
            }
            int serializedSize = i10 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
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
            int hashCode = ((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.code_) * 37) + 2) * 53) + getMessage().hashCode()) * 37) + 3) * 53) + Internal.hashLong(getMsgId())) * 37) + 4) * 53) + getLocalId()) * 37) + 5) * 53) + getRequestId().hashCode()) * 37) + 6) * 53) + Internal.hashLong(getRequestTime())) * 37) + 7) * 53) + Internal.hashLong(getResponseTime())) * 37) + 8) * 53) + getPromptType().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PrivateChatOuterClass.internal_static_com_blued_im_private_chat_Response_fieldAccessorTable.ensureFieldAccessorsInitialized(Response.class, Builder.class);
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
            return new Response();
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
            if (!getRequestIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.requestId_);
            }
            long j2 = this.requestTime_;
            if (j2 != 0) {
                codedOutputStream.writeInt64(6, j2);
            }
            long j3 = this.responseTime_;
            if (j3 != 0) {
                codedOutputStream.writeInt64(7, j3);
            }
            if (!getPromptTypeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 8, this.promptType_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/PrivateChatOuterClass$ResponseOrBuilder.class */
    public interface ResponseOrBuilder extends MessageOrBuilder {
        CodeOuterClass.Code getCode();

        int getCodeValue();

        int getLocalId();

        String getMessage();

        ByteString getMessageBytes();

        long getMsgId();

        String getPromptType();

        ByteString getPromptTypeBytes();

        String getRequestId();

        ByteString getRequestIdBytes();

        long getRequestTime();

        long getResponseTime();
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_blued_im_private_chat_Request_descriptor = descriptor2;
        internal_static_com_blued_im_private_chat_Request_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Common", "To", "MsgType", "LocalId", "Body", HttpHeaders.FROM, "SessionType"});
        Descriptors.Descriptor descriptor3 = getDescriptor().getMessageTypes().get(1);
        internal_static_com_blued_im_private_chat_Response_descriptor = descriptor3;
        internal_static_com_blued_im_private_chat_Response_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor3, new String[]{"Code", "Message", "MsgId", "LocalId", "RequestId", "RequestTime", "ResponseTime", "PromptType"});
        Descriptors.Descriptor descriptor4 = getDescriptor().getMessageTypes().get(2);
        internal_static_com_blued_im_private_chat_Receive_descriptor = descriptor4;
        internal_static_com_blued_im_private_chat_Receive_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor4, new String[]{HttpHeaders.FROM, "To", "MsgType", "MsgId", "Timestamp", "Distance", "Coords", "SessionStatus", "IsDeleted", "IsRead", "Body", "SessionType", "PhoneSessionId", "SessionCommonStatus"});
        Descriptors.Descriptor descriptor5 = getDescriptor().getMessageTypes().get(3);
        internal_static_com_blued_im_private_chat_ReceiveNew_descriptor = descriptor5;
        internal_static_com_blued_im_private_chat_ReceiveNew_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor5, new String[]{HttpHeaders.FROM, "To", "MsgType", "MsgId", "Timestamp", "Distance", "Coords", "SessionStatus", "IsDeleted", "IsRead", "Body", "SessionType", "PhoneSessionId"});
        AnyProto.getDescriptor();
        MsgTypeOuterClass.getDescriptor();
        CodeOuterClass.getDescriptor();
        CommonOuterClass.getDescriptor();
        PushBodyOuterClass.getDescriptor();
    }

    private PrivateChatOuterClass() {
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
