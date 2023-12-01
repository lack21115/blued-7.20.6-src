package com.blued.im.private_chat;

import com.blued.im.CommonOuterClass;
import com.blued.im.private_chat.CodeOuterClass;
import com.google.common.net.HttpHeaders;
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
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/ReceiptOuterClass.class */
public final class ReceiptOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\rReceipt.proto\u0012\u0019com.blued.im.private_chat\u001a\nCode.proto\u001a\fCommon.proto\"£\u0001\n\u000eReceiptRequest\u0012$\n\u0006common\u0018\u0001 \u0001(\u000b2\u0014.com.blued.im.Common\u0012\u0014\n\fsession_type\u0018\u0003 \u0001(\r\u0012\f\n\u0004from\u0018\u0004 \u0001(\r\u0012\n\n\u0002to\u0018\u0005 \u0001(\r\u0012\u000e\n\u0006seqnum\u0018\u0006 \u0001(\u0003\u0012\u0015\n\ris_delete_msg\u0018\u0007 \u0001(\b\u0012\u0014\n\fis_match_msg\u0018\b \u0001(\r\"¢\u0001\n\u000fReceiptResponse\u0012-\n\u0004code\u0018\u0001 \u0001(\u000e2\u001f.com.blued.im.private_chat.Code\u0012\u000f\n\u0007message\u0018\u0002 \u0001(\t\u0012\u000e\n\u0006seqnum\u0018\u0003 \u0001(\u0003\u0012\u0012\n\nrequest_id\u0018\u0004 \u0001(\t\u0012\u0014\n\frequest_time\u0018\u0005 \u0001(\u0003\u0012\u0015\n\rresponse_time\u0018\u0006 \u0001(\u00032Û\u0004\n\u0007Receipt\u0012^\n\u0003Got\u0012).com.blued.im.private_chat.ReceiptRequest\u001a*.com.blued.im.private_chat.ReceiptResponse\"��\u0012_\n\u0004Read\u0012).com.blued.im.private_chat.ReceiptRequest\u001a*.com.blued.im.private_chat.ReceiptResponse\"��\u0012b\n\u0007Retract\u0012).com.blued.im.private_chat.ReceiptRequest\u001a*.com.blued.im.private_chat.ReceiptResponse\"��\u0012a\n\u0006DelAll\u0012).com.blued.im.private_chat.ReceiptRequest\u001a*.com.blued.im.private_chat.ReceiptResponse\"��\u0012e\n\nDelSession\u0012).com.blued.im.private_chat.ReceiptRequest\u001a*.com.blued.im.private_chat.ReceiptResponse\"��\u0012a\n\u0006DelMsg\u0012).com.blued.im.private_chat.ReceiptRequest\u001a*.com.blued.im.private_chat.ReceiptResponse\"��B\u000e¢\u0002\u000bPrivateChatb\u0006proto3"}, new Descriptors.FileDescriptor[]{CodeOuterClass.getDescriptor(), CommonOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_com_blued_im_private_chat_ReceiptRequest_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_im_private_chat_ReceiptRequest_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_blued_im_private_chat_ReceiptResponse_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_im_private_chat_ReceiptResponse_fieldAccessorTable;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/ReceiptOuterClass$ReceiptRequest.class */
    public static final class ReceiptRequest extends GeneratedMessageV3 implements ReceiptRequestOrBuilder {
        public static final int COMMON_FIELD_NUMBER = 1;
        public static final int FROM_FIELD_NUMBER = 4;
        public static final int IS_DELETE_MSG_FIELD_NUMBER = 7;
        public static final int IS_MATCH_MSG_FIELD_NUMBER = 8;
        public static final int SEQNUM_FIELD_NUMBER = 6;
        public static final int SESSION_TYPE_FIELD_NUMBER = 3;
        public static final int TO_FIELD_NUMBER = 5;
        private static final long serialVersionUID = 0;
        private CommonOuterClass.Common common_;
        private int from_;
        private boolean isDeleteMsg_;
        private int isMatchMsg_;
        private byte memoizedIsInitialized;
        private long seqnum_;
        private int sessionType_;
        private int to_;
        private static final ReceiptRequest DEFAULT_INSTANCE = new ReceiptRequest();
        private static final Parser<ReceiptRequest> PARSER = new AbstractParser<ReceiptRequest>() { // from class: com.blued.im.private_chat.ReceiptOuterClass.ReceiptRequest.1
            @Override // com.google.protobuf.Parser
            public ReceiptRequest parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ReceiptRequest(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/ReceiptOuterClass$ReceiptRequest$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ReceiptRequestOrBuilder {
            private SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> commonBuilder_;
            private CommonOuterClass.Common common_;
            private int from_;
            private boolean isDeleteMsg_;
            private int isMatchMsg_;
            private long seqnum_;
            private int sessionType_;
            private int to_;

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            private SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> getCommonFieldBuilder() {
                if (this.commonBuilder_ == null) {
                    this.commonBuilder_ = new SingleFieldBuilderV3<>(getCommon(), getParentForChildren(), isClean());
                    this.common_ = null;
                }
                return this.commonBuilder_;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return ReceiptOuterClass.internal_static_com_blued_im_private_chat_ReceiptRequest_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = ReceiptRequest.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ReceiptRequest build() {
                ReceiptRequest buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ReceiptRequest buildPartial() {
                ReceiptRequest receiptRequest = new ReceiptRequest(this);
                SingleFieldBuilderV3<CommonOuterClass.Common, CommonOuterClass.Common.Builder, CommonOuterClass.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 == null) {
                    receiptRequest.common_ = this.common_;
                } else {
                    receiptRequest.common_ = singleFieldBuilderV3.build();
                }
                receiptRequest.sessionType_ = this.sessionType_;
                receiptRequest.from_ = this.from_;
                receiptRequest.to_ = this.to_;
                receiptRequest.seqnum_ = this.seqnum_;
                receiptRequest.isDeleteMsg_ = this.isDeleteMsg_;
                receiptRequest.isMatchMsg_ = this.isMatchMsg_;
                onBuilt();
                return receiptRequest;
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
                this.sessionType_ = 0;
                this.from_ = 0;
                this.to_ = 0;
                this.seqnum_ = 0L;
                this.isDeleteMsg_ = false;
                this.isMatchMsg_ = 0;
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

            public Builder clearIsDeleteMsg() {
                this.isDeleteMsg_ = false;
                onChanged();
                return this;
            }

            public Builder clearIsMatchMsg() {
                this.isMatchMsg_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearSeqnum() {
                this.seqnum_ = 0L;
                onChanged();
                return this;
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

            @Override // com.blued.im.private_chat.ReceiptOuterClass.ReceiptRequestOrBuilder
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

            @Override // com.blued.im.private_chat.ReceiptOuterClass.ReceiptRequestOrBuilder
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
            public ReceiptRequest getDefaultInstanceForType() {
                return ReceiptRequest.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ReceiptOuterClass.internal_static_com_blued_im_private_chat_ReceiptRequest_descriptor;
            }

            @Override // com.blued.im.private_chat.ReceiptOuterClass.ReceiptRequestOrBuilder
            public int getFrom() {
                return this.from_;
            }

            @Override // com.blued.im.private_chat.ReceiptOuterClass.ReceiptRequestOrBuilder
            public boolean getIsDeleteMsg() {
                return this.isDeleteMsg_;
            }

            @Override // com.blued.im.private_chat.ReceiptOuterClass.ReceiptRequestOrBuilder
            public int getIsMatchMsg() {
                return this.isMatchMsg_;
            }

            @Override // com.blued.im.private_chat.ReceiptOuterClass.ReceiptRequestOrBuilder
            public long getSeqnum() {
                return this.seqnum_;
            }

            @Override // com.blued.im.private_chat.ReceiptOuterClass.ReceiptRequestOrBuilder
            public int getSessionType() {
                return this.sessionType_;
            }

            @Override // com.blued.im.private_chat.ReceiptOuterClass.ReceiptRequestOrBuilder
            public int getTo() {
                return this.to_;
            }

            @Override // com.blued.im.private_chat.ReceiptOuterClass.ReceiptRequestOrBuilder
            public boolean hasCommon() {
                return (this.commonBuilder_ == null && this.common_ == null) ? false : true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ReceiptOuterClass.internal_static_com_blued_im_private_chat_ReceiptRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ReceiptRequest.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
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

            public Builder mergeFrom(ReceiptRequest receiptRequest) {
                if (receiptRequest == ReceiptRequest.getDefaultInstance()) {
                    return this;
                }
                if (receiptRequest.hasCommon()) {
                    mergeCommon(receiptRequest.getCommon());
                }
                if (receiptRequest.getSessionType() != 0) {
                    setSessionType(receiptRequest.getSessionType());
                }
                if (receiptRequest.getFrom() != 0) {
                    setFrom(receiptRequest.getFrom());
                }
                if (receiptRequest.getTo() != 0) {
                    setTo(receiptRequest.getTo());
                }
                if (receiptRequest.getSeqnum() != 0) {
                    setSeqnum(receiptRequest.getSeqnum());
                }
                if (receiptRequest.getIsDeleteMsg()) {
                    setIsDeleteMsg(receiptRequest.getIsDeleteMsg());
                }
                if (receiptRequest.getIsMatchMsg() != 0) {
                    setIsMatchMsg(receiptRequest.getIsMatchMsg());
                }
                mergeUnknownFields(receiptRequest.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.im.private_chat.ReceiptOuterClass.ReceiptRequest.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.im.private_chat.ReceiptOuterClass.ReceiptRequest.access$1400()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.im.private_chat.ReceiptOuterClass$ReceiptRequest r0 = (com.blued.im.private_chat.ReceiptOuterClass.ReceiptRequest) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.im.private_chat.ReceiptOuterClass$ReceiptRequest$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.im.private_chat.ReceiptOuterClass$ReceiptRequest r0 = (com.blued.im.private_chat.ReceiptOuterClass.ReceiptRequest) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.im.private_chat.ReceiptOuterClass$ReceiptRequest$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.im.private_chat.ReceiptOuterClass.ReceiptRequest.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.im.private_chat.ReceiptOuterClass$ReceiptRequest$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof ReceiptRequest) {
                    return mergeFrom((ReceiptRequest) message);
                }
                super.mergeFrom(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
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

            public Builder setIsDeleteMsg(boolean z) {
                this.isDeleteMsg_ = z;
                onChanged();
                return this;
            }

            public Builder setIsMatchMsg(int i) {
                this.isMatchMsg_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setSeqnum(long j) {
                this.seqnum_ = j;
                onChanged();
                return this;
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

        private ReceiptRequest() {
            this.memoizedIsInitialized = (byte) -1;
        }

        private ReceiptRequest(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            if (readTag == 10) {
                                CommonOuterClass.Common.Builder builder = this.common_ != null ? this.common_.toBuilder() : null;
                                CommonOuterClass.Common common = (CommonOuterClass.Common) codedInputStream.readMessage(CommonOuterClass.Common.parser(), extensionRegistryLite);
                                this.common_ = common;
                                if (builder != null) {
                                    builder.mergeFrom(common);
                                    this.common_ = builder.buildPartial();
                                }
                            } else if (readTag == 24) {
                                this.sessionType_ = codedInputStream.readUInt32();
                            } else if (readTag == 32) {
                                this.from_ = codedInputStream.readUInt32();
                            } else if (readTag == 40) {
                                this.to_ = codedInputStream.readUInt32();
                            } else if (readTag == 48) {
                                this.seqnum_ = codedInputStream.readInt64();
                            } else if (readTag == 56) {
                                this.isDeleteMsg_ = codedInputStream.readBool();
                            } else if (readTag == 64) {
                                this.isMatchMsg_ = codedInputStream.readUInt32();
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

        private ReceiptRequest(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static ReceiptRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ReceiptOuterClass.internal_static_com_blued_im_private_chat_ReceiptRequest_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ReceiptRequest receiptRequest) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(receiptRequest);
        }

        public static ReceiptRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ReceiptRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static ReceiptRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReceiptRequest) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static ReceiptRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static ReceiptRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static ReceiptRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ReceiptRequest) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static ReceiptRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReceiptRequest) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static ReceiptRequest parseFrom(InputStream inputStream) throws IOException {
            return (ReceiptRequest) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static ReceiptRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReceiptRequest) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static ReceiptRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static ReceiptRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static ReceiptRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static ReceiptRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<ReceiptRequest> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof ReceiptRequest) {
                ReceiptRequest receiptRequest = (ReceiptRequest) obj;
                if (hasCommon() != receiptRequest.hasCommon()) {
                    return false;
                }
                return (!hasCommon() || getCommon().equals(receiptRequest.getCommon())) && getSessionType() == receiptRequest.getSessionType() && getFrom() == receiptRequest.getFrom() && getTo() == receiptRequest.getTo() && getSeqnum() == receiptRequest.getSeqnum() && getIsDeleteMsg() == receiptRequest.getIsDeleteMsg() && getIsMatchMsg() == receiptRequest.getIsMatchMsg() && this.unknownFields.equals(receiptRequest.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.blued.im.private_chat.ReceiptOuterClass.ReceiptRequestOrBuilder
        public CommonOuterClass.Common getCommon() {
            CommonOuterClass.Common common = this.common_;
            CommonOuterClass.Common common2 = common;
            if (common == null) {
                common2 = CommonOuterClass.Common.getDefaultInstance();
            }
            return common2;
        }

        @Override // com.blued.im.private_chat.ReceiptOuterClass.ReceiptRequestOrBuilder
        public CommonOuterClass.CommonOrBuilder getCommonOrBuilder() {
            return getCommon();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ReceiptRequest getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.im.private_chat.ReceiptOuterClass.ReceiptRequestOrBuilder
        public int getFrom() {
            return this.from_;
        }

        @Override // com.blued.im.private_chat.ReceiptOuterClass.ReceiptRequestOrBuilder
        public boolean getIsDeleteMsg() {
            return this.isDeleteMsg_;
        }

        @Override // com.blued.im.private_chat.ReceiptOuterClass.ReceiptRequestOrBuilder
        public int getIsMatchMsg() {
            return this.isMatchMsg_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ReceiptRequest> getParserForType() {
            return PARSER;
        }

        @Override // com.blued.im.private_chat.ReceiptOuterClass.ReceiptRequestOrBuilder
        public long getSeqnum() {
            return this.seqnum_;
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
            int i3 = this.sessionType_;
            int i4 = i2;
            if (i3 != 0) {
                i4 = i2 + CodedOutputStream.computeUInt32Size(3, i3);
            }
            int i5 = this.from_;
            int i6 = i4;
            if (i5 != 0) {
                i6 = i4 + CodedOutputStream.computeUInt32Size(4, i5);
            }
            int i7 = this.to_;
            int i8 = i6;
            if (i7 != 0) {
                i8 = i6 + CodedOutputStream.computeUInt32Size(5, i7);
            }
            long j = this.seqnum_;
            int i9 = i8;
            if (j != 0) {
                i9 = i8 + CodedOutputStream.computeInt64Size(6, j);
            }
            boolean z = this.isDeleteMsg_;
            int i10 = i9;
            if (z) {
                i10 = i9 + CodedOutputStream.computeBoolSize(7, z);
            }
            int i11 = this.isMatchMsg_;
            int i12 = i10;
            if (i11 != 0) {
                i12 = i10 + CodedOutputStream.computeUInt32Size(8, i11);
            }
            int serializedSize = i12 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.blued.im.private_chat.ReceiptOuterClass.ReceiptRequestOrBuilder
        public int getSessionType() {
            return this.sessionType_;
        }

        @Override // com.blued.im.private_chat.ReceiptOuterClass.ReceiptRequestOrBuilder
        public int getTo() {
            return this.to_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.blued.im.private_chat.ReceiptOuterClass.ReceiptRequestOrBuilder
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
            int sessionType = (((((((((((((((((((((((((i * 37) + 3) * 53) + getSessionType()) * 37) + 4) * 53) + getFrom()) * 37) + 5) * 53) + getTo()) * 37) + 6) * 53) + Internal.hashLong(getSeqnum())) * 37) + 7) * 53) + Internal.hashBoolean(getIsDeleteMsg())) * 37) + 8) * 53) + getIsMatchMsg()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = sessionType;
            return sessionType;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ReceiptOuterClass.internal_static_com_blued_im_private_chat_ReceiptRequest_fieldAccessorTable.ensureFieldAccessorsInitialized(ReceiptRequest.class, Builder.class);
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
            return new ReceiptRequest();
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
            int i = this.sessionType_;
            if (i != 0) {
                codedOutputStream.writeUInt32(3, i);
            }
            int i2 = this.from_;
            if (i2 != 0) {
                codedOutputStream.writeUInt32(4, i2);
            }
            int i3 = this.to_;
            if (i3 != 0) {
                codedOutputStream.writeUInt32(5, i3);
            }
            long j = this.seqnum_;
            if (j != 0) {
                codedOutputStream.writeInt64(6, j);
            }
            boolean z = this.isDeleteMsg_;
            if (z) {
                codedOutputStream.writeBool(7, z);
            }
            int i4 = this.isMatchMsg_;
            if (i4 != 0) {
                codedOutputStream.writeUInt32(8, i4);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/ReceiptOuterClass$ReceiptRequestOrBuilder.class */
    public interface ReceiptRequestOrBuilder extends MessageOrBuilder {
        CommonOuterClass.Common getCommon();

        CommonOuterClass.CommonOrBuilder getCommonOrBuilder();

        int getFrom();

        boolean getIsDeleteMsg();

        int getIsMatchMsg();

        long getSeqnum();

        int getSessionType();

        int getTo();

        boolean hasCommon();
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/ReceiptOuterClass$ReceiptResponse.class */
    public static final class ReceiptResponse extends GeneratedMessageV3 implements ReceiptResponseOrBuilder {
        public static final int CODE_FIELD_NUMBER = 1;
        public static final int MESSAGE_FIELD_NUMBER = 2;
        public static final int REQUEST_ID_FIELD_NUMBER = 4;
        public static final int REQUEST_TIME_FIELD_NUMBER = 5;
        public static final int RESPONSE_TIME_FIELD_NUMBER = 6;
        public static final int SEQNUM_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private int code_;
        private byte memoizedIsInitialized;
        private volatile Object message_;
        private volatile Object requestId_;
        private long requestTime_;
        private long responseTime_;
        private long seqnum_;
        private static final ReceiptResponse DEFAULT_INSTANCE = new ReceiptResponse();
        private static final Parser<ReceiptResponse> PARSER = new AbstractParser<ReceiptResponse>() { // from class: com.blued.im.private_chat.ReceiptOuterClass.ReceiptResponse.1
            @Override // com.google.protobuf.Parser
            public ReceiptResponse parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ReceiptResponse(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/ReceiptOuterClass$ReceiptResponse$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ReceiptResponseOrBuilder {
            private int code_;
            private Object message_;
            private Object requestId_;
            private long requestTime_;
            private long responseTime_;
            private long seqnum_;

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

            public static final Descriptors.Descriptor getDescriptor() {
                return ReceiptOuterClass.internal_static_com_blued_im_private_chat_ReceiptResponse_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = ReceiptResponse.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ReceiptResponse build() {
                ReceiptResponse buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ReceiptResponse buildPartial() {
                ReceiptResponse receiptResponse = new ReceiptResponse(this);
                receiptResponse.code_ = this.code_;
                receiptResponse.message_ = this.message_;
                receiptResponse.seqnum_ = this.seqnum_;
                receiptResponse.requestId_ = this.requestId_;
                receiptResponse.requestTime_ = this.requestTime_;
                receiptResponse.responseTime_ = this.responseTime_;
                onBuilt();
                return receiptResponse;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.code_ = 0;
                this.message_ = "";
                this.seqnum_ = 0L;
                this.requestId_ = "";
                this.requestTime_ = 0L;
                this.responseTime_ = 0L;
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

            public Builder clearMessage() {
                this.message_ = ReceiptResponse.getDefaultInstance().getMessage();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearRequestId() {
                this.requestId_ = ReceiptResponse.getDefaultInstance().getRequestId();
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

            public Builder clearSeqnum() {
                this.seqnum_ = 0L;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo2030clone() {
                return (Builder) super.mo2030clone();
            }

            @Override // com.blued.im.private_chat.ReceiptOuterClass.ReceiptResponseOrBuilder
            public CodeOuterClass.Code getCode() {
                CodeOuterClass.Code valueOf = CodeOuterClass.Code.valueOf(this.code_);
                CodeOuterClass.Code code = valueOf;
                if (valueOf == null) {
                    code = CodeOuterClass.Code.UNRECOGNIZED;
                }
                return code;
            }

            @Override // com.blued.im.private_chat.ReceiptOuterClass.ReceiptResponseOrBuilder
            public int getCodeValue() {
                return this.code_;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ReceiptResponse getDefaultInstanceForType() {
                return ReceiptResponse.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ReceiptOuterClass.internal_static_com_blued_im_private_chat_ReceiptResponse_descriptor;
            }

            @Override // com.blued.im.private_chat.ReceiptOuterClass.ReceiptResponseOrBuilder
            public String getMessage() {
                Object obj = this.message_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.message_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.im.private_chat.ReceiptOuterClass.ReceiptResponseOrBuilder
            public ByteString getMessageBytes() {
                Object obj = this.message_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.message_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.im.private_chat.ReceiptOuterClass.ReceiptResponseOrBuilder
            public String getRequestId() {
                Object obj = this.requestId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.requestId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.im.private_chat.ReceiptOuterClass.ReceiptResponseOrBuilder
            public ByteString getRequestIdBytes() {
                Object obj = this.requestId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.requestId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.im.private_chat.ReceiptOuterClass.ReceiptResponseOrBuilder
            public long getRequestTime() {
                return this.requestTime_;
            }

            @Override // com.blued.im.private_chat.ReceiptOuterClass.ReceiptResponseOrBuilder
            public long getResponseTime() {
                return this.responseTime_;
            }

            @Override // com.blued.im.private_chat.ReceiptOuterClass.ReceiptResponseOrBuilder
            public long getSeqnum() {
                return this.seqnum_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ReceiptOuterClass.internal_static_com_blued_im_private_chat_ReceiptResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ReceiptResponse.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(ReceiptResponse receiptResponse) {
                if (receiptResponse == ReceiptResponse.getDefaultInstance()) {
                    return this;
                }
                if (receiptResponse.code_ != 0) {
                    setCodeValue(receiptResponse.getCodeValue());
                }
                if (!receiptResponse.getMessage().isEmpty()) {
                    this.message_ = receiptResponse.message_;
                    onChanged();
                }
                if (receiptResponse.getSeqnum() != 0) {
                    setSeqnum(receiptResponse.getSeqnum());
                }
                if (!receiptResponse.getRequestId().isEmpty()) {
                    this.requestId_ = receiptResponse.requestId_;
                    onChanged();
                }
                if (receiptResponse.getRequestTime() != 0) {
                    setRequestTime(receiptResponse.getRequestTime());
                }
                if (receiptResponse.getResponseTime() != 0) {
                    setResponseTime(receiptResponse.getResponseTime());
                }
                mergeUnknownFields(receiptResponse.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.im.private_chat.ReceiptOuterClass.ReceiptResponse.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.im.private_chat.ReceiptOuterClass.ReceiptResponse.access$2900()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.im.private_chat.ReceiptOuterClass$ReceiptResponse r0 = (com.blued.im.private_chat.ReceiptOuterClass.ReceiptResponse) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.im.private_chat.ReceiptOuterClass$ReceiptResponse$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.im.private_chat.ReceiptOuterClass$ReceiptResponse r0 = (com.blued.im.private_chat.ReceiptOuterClass.ReceiptResponse) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.im.private_chat.ReceiptOuterClass$ReceiptResponse$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.im.private_chat.ReceiptOuterClass.ReceiptResponse.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.im.private_chat.ReceiptOuterClass$ReceiptResponse$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof ReceiptResponse) {
                    return mergeFrom((ReceiptResponse) message);
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
                    ReceiptResponse.checkByteStringIsUtf8(byteString);
                    this.message_ = byteString;
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
                    ReceiptResponse.checkByteStringIsUtf8(byteString);
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

            public Builder setSeqnum(long j) {
                this.seqnum_ = j;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private ReceiptResponse() {
            this.memoizedIsInitialized = (byte) -1;
            this.code_ = 0;
            this.message_ = "";
            this.requestId_ = "";
        }

        private ReceiptResponse(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.seqnum_ = codedInputStream.readInt64();
                            } else if (readTag == 34) {
                                this.requestId_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 40) {
                                this.requestTime_ = codedInputStream.readInt64();
                            } else if (readTag == 48) {
                                this.responseTime_ = codedInputStream.readInt64();
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

        private ReceiptResponse(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static ReceiptResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ReceiptOuterClass.internal_static_com_blued_im_private_chat_ReceiptResponse_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ReceiptResponse receiptResponse) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(receiptResponse);
        }

        public static ReceiptResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ReceiptResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static ReceiptResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReceiptResponse) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static ReceiptResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static ReceiptResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static ReceiptResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ReceiptResponse) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static ReceiptResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReceiptResponse) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static ReceiptResponse parseFrom(InputStream inputStream) throws IOException {
            return (ReceiptResponse) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static ReceiptResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ReceiptResponse) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static ReceiptResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static ReceiptResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static ReceiptResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static ReceiptResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<ReceiptResponse> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof ReceiptResponse) {
                ReceiptResponse receiptResponse = (ReceiptResponse) obj;
                return this.code_ == receiptResponse.code_ && getMessage().equals(receiptResponse.getMessage()) && getSeqnum() == receiptResponse.getSeqnum() && getRequestId().equals(receiptResponse.getRequestId()) && getRequestTime() == receiptResponse.getRequestTime() && getResponseTime() == receiptResponse.getResponseTime() && this.unknownFields.equals(receiptResponse.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.blued.im.private_chat.ReceiptOuterClass.ReceiptResponseOrBuilder
        public CodeOuterClass.Code getCode() {
            CodeOuterClass.Code valueOf = CodeOuterClass.Code.valueOf(this.code_);
            CodeOuterClass.Code code = valueOf;
            if (valueOf == null) {
                code = CodeOuterClass.Code.UNRECOGNIZED;
            }
            return code;
        }

        @Override // com.blued.im.private_chat.ReceiptOuterClass.ReceiptResponseOrBuilder
        public int getCodeValue() {
            return this.code_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ReceiptResponse getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.im.private_chat.ReceiptOuterClass.ReceiptResponseOrBuilder
        public String getMessage() {
            Object obj = this.message_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.message_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.im.private_chat.ReceiptOuterClass.ReceiptResponseOrBuilder
        public ByteString getMessageBytes() {
            Object obj = this.message_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.message_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ReceiptResponse> getParserForType() {
            return PARSER;
        }

        @Override // com.blued.im.private_chat.ReceiptOuterClass.ReceiptResponseOrBuilder
        public String getRequestId() {
            Object obj = this.requestId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.requestId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.im.private_chat.ReceiptOuterClass.ReceiptResponseOrBuilder
        public ByteString getRequestIdBytes() {
            Object obj = this.requestId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.requestId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.im.private_chat.ReceiptOuterClass.ReceiptResponseOrBuilder
        public long getRequestTime() {
            return this.requestTime_;
        }

        @Override // com.blued.im.private_chat.ReceiptOuterClass.ReceiptResponseOrBuilder
        public long getResponseTime() {
            return this.responseTime_;
        }

        @Override // com.blued.im.private_chat.ReceiptOuterClass.ReceiptResponseOrBuilder
        public long getSeqnum() {
            return this.seqnum_;
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
            long j = this.seqnum_;
            int i4 = i3;
            if (j != 0) {
                i4 = i3 + CodedOutputStream.computeInt64Size(3, j);
            }
            int i5 = i4;
            if (!getRequestIdBytes().isEmpty()) {
                i5 = i4 + GeneratedMessageV3.computeStringSize(4, this.requestId_);
            }
            long j2 = this.requestTime_;
            int i6 = i5;
            if (j2 != 0) {
                i6 = i5 + CodedOutputStream.computeInt64Size(5, j2);
            }
            long j3 = this.responseTime_;
            int i7 = i6;
            if (j3 != 0) {
                i7 = i6 + CodedOutputStream.computeInt64Size(6, j3);
            }
            int serializedSize = i7 + this.unknownFields.getSerializedSize();
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
            int hashCode = ((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.code_) * 37) + 2) * 53) + getMessage().hashCode()) * 37) + 3) * 53) + Internal.hashLong(getSeqnum())) * 37) + 4) * 53) + getRequestId().hashCode()) * 37) + 5) * 53) + Internal.hashLong(getRequestTime())) * 37) + 6) * 53) + Internal.hashLong(getResponseTime())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ReceiptOuterClass.internal_static_com_blued_im_private_chat_ReceiptResponse_fieldAccessorTable.ensureFieldAccessorsInitialized(ReceiptResponse.class, Builder.class);
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
            return new ReceiptResponse();
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
            long j = this.seqnum_;
            if (j != 0) {
                codedOutputStream.writeInt64(3, j);
            }
            if (!getRequestIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.requestId_);
            }
            long j2 = this.requestTime_;
            if (j2 != 0) {
                codedOutputStream.writeInt64(5, j2);
            }
            long j3 = this.responseTime_;
            if (j3 != 0) {
                codedOutputStream.writeInt64(6, j3);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/ReceiptOuterClass$ReceiptResponseOrBuilder.class */
    public interface ReceiptResponseOrBuilder extends MessageOrBuilder {
        CodeOuterClass.Code getCode();

        int getCodeValue();

        String getMessage();

        ByteString getMessageBytes();

        String getRequestId();

        ByteString getRequestIdBytes();

        long getRequestTime();

        long getResponseTime();

        long getSeqnum();
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_blued_im_private_chat_ReceiptRequest_descriptor = descriptor2;
        internal_static_com_blued_im_private_chat_ReceiptRequest_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Common", "SessionType", HttpHeaders.FROM, "To", "Seqnum", "IsDeleteMsg", "IsMatchMsg"});
        Descriptors.Descriptor descriptor3 = getDescriptor().getMessageTypes().get(1);
        internal_static_com_blued_im_private_chat_ReceiptResponse_descriptor = descriptor3;
        internal_static_com_blued_im_private_chat_ReceiptResponse_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor3, new String[]{"Code", "Message", "Seqnum", "RequestId", "RequestTime", "ResponseTime"});
        CodeOuterClass.getDescriptor();
        CommonOuterClass.getDescriptor();
    }

    private ReceiptOuterClass() {
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
