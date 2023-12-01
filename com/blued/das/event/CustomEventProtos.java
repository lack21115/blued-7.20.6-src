package com.blued.das.event;

import com.blued.das.CommonProtos;
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
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/blued/das/event/CustomEventProtos.class */
public final class CustomEventProtos {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017CustomEventProtos.proto\u0012\u0013com.blued.das.event\u001a\u0012CommonProtos.proto\"\u0093\u0001\n\u0007Request\u0012\f\n\u0004time\u0018\u0001 \u0001(\u0003\u0012\r\n\u0005takes\u0018\u0002 \u0001(\u0005\u0012\f\n\u0004code\u0018\u0003 \u0001(\u0005\u0012\u0013\n\u000bdescription\u0018\u0004 \u0001(\t\u0012\f\n\u0004name\u0018\u0005 \u0001(\t\u0012%\n\u0006common\u0018\u0006 \u0001(\u000b2\u0015.com.blued.das.Common\u0012\u0013\n\u000bclient_time\u0018\u0007 \u0001(\u0003\"`\n\bRequests\u0012%\n\u0006common\u0018\u0001 \u0001(\u000b2\u0015.com.blued.das.Common\u0012-\n\u0007request\u0018\u0002 \u0003(\u000b2\u001c.com.blued.das.event.Request\"\u0018\n\bResponse\u0012\f\n\u0004code\u0018\u0001 \u0001(\u00052^\n\rReportService\u0012M\n\u000bBatchReport\u0012\u001d.com.blued.das.event.Requests\u001a\u001d.com.blued.das.event.Response\"��B\b¢\u0002\u0005EVENTb\u0006proto3"}, new Descriptors.FileDescriptor[]{CommonProtos.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_com_blued_das_event_Request_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_event_Request_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_blued_das_event_Requests_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_event_Requests_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_blued_das_event_Response_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_event_Response_fieldAccessorTable;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/event/CustomEventProtos$Request.class */
    public static final class Request extends GeneratedMessageV3 implements RequestOrBuilder {
        public static final int CLIENT_TIME_FIELD_NUMBER = 7;
        public static final int CODE_FIELD_NUMBER = 3;
        public static final int COMMON_FIELD_NUMBER = 6;
        public static final int DESCRIPTION_FIELD_NUMBER = 4;
        public static final int NAME_FIELD_NUMBER = 5;
        public static final int TAKES_FIELD_NUMBER = 2;
        public static final int TIME_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private long clientTime_;
        private int code_;
        private CommonProtos.Common common_;
        private volatile Object description_;
        private byte memoizedIsInitialized;
        private volatile Object name_;
        private int takes_;
        private long time_;
        private static final Request DEFAULT_INSTANCE = new Request();
        private static final Parser<Request> PARSER = new AbstractParser<Request>() { // from class: com.blued.das.event.CustomEventProtos.Request.1
            @Override // com.google.protobuf.Parser
            public Request parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Request(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/das/event/CustomEventProtos$Request$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RequestOrBuilder {
            private long clientTime_;
            private int code_;
            private SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> commonBuilder_;
            private CommonProtos.Common common_;
            private Object description_;
            private Object name_;
            private int takes_;
            private long time_;

            private Builder() {
                this.description_ = "";
                this.name_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.description_ = "";
                this.name_ = "";
                maybeForceBuilderInitialization();
            }

            private SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> getCommonFieldBuilder() {
                if (this.commonBuilder_ == null) {
                    this.commonBuilder_ = new SingleFieldBuilderV3<>(getCommon(), getParentForChildren(), isClean());
                    this.common_ = null;
                }
                return this.commonBuilder_;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return CustomEventProtos.internal_static_com_blued_das_event_Request_descriptor;
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
                request.time_ = this.time_;
                request.takes_ = this.takes_;
                request.code_ = this.code_;
                request.description_ = this.description_;
                request.name_ = this.name_;
                SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 == null) {
                    request.common_ = this.common_;
                } else {
                    request.common_ = singleFieldBuilderV3.build();
                }
                request.clientTime_ = this.clientTime_;
                onBuilt();
                return request;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.time_ = 0L;
                this.takes_ = 0;
                this.code_ = 0;
                this.description_ = "";
                this.name_ = "";
                if (this.commonBuilder_ == null) {
                    this.common_ = null;
                } else {
                    this.common_ = null;
                    this.commonBuilder_ = null;
                }
                this.clientTime_ = 0L;
                return this;
            }

            public Builder clearClientTime() {
                this.clientTime_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearCode() {
                this.code_ = 0;
                onChanged();
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

            public Builder clearDescription() {
                this.description_ = Request.getDefaultInstance().getDescription();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearName() {
                this.name_ = Request.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearTakes() {
                this.takes_ = 0;
                onChanged();
                return this;
            }

            public Builder clearTime() {
                this.time_ = 0L;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1800clone() {
                return (Builder) super.mo1800clone();
            }

            @Override // com.blued.das.event.CustomEventProtos.RequestOrBuilder
            public long getClientTime() {
                return this.clientTime_;
            }

            @Override // com.blued.das.event.CustomEventProtos.RequestOrBuilder
            public int getCode() {
                return this.code_;
            }

            @Override // com.blued.das.event.CustomEventProtos.RequestOrBuilder
            public CommonProtos.Common getCommon() {
                SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 == null) {
                    CommonProtos.Common common = this.common_;
                    CommonProtos.Common common2 = common;
                    if (common == null) {
                        common2 = CommonProtos.Common.getDefaultInstance();
                    }
                    return common2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public CommonProtos.Common.Builder getCommonBuilder() {
                onChanged();
                return getCommonFieldBuilder().getBuilder();
            }

            @Override // com.blued.das.event.CustomEventProtos.RequestOrBuilder
            public CommonProtos.CommonOrBuilder getCommonOrBuilder() {
                SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                CommonProtos.Common common = this.common_;
                CommonProtos.Common common2 = common;
                if (common == null) {
                    common2 = CommonProtos.Common.getDefaultInstance();
                }
                return common2;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Request getDefaultInstanceForType() {
                return Request.getDefaultInstance();
            }

            @Override // com.blued.das.event.CustomEventProtos.RequestOrBuilder
            public String getDescription() {
                Object obj = this.description_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.description_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.event.CustomEventProtos.RequestOrBuilder
            public ByteString getDescriptionBytes() {
                Object obj = this.description_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.description_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CustomEventProtos.internal_static_com_blued_das_event_Request_descriptor;
            }

            @Override // com.blued.das.event.CustomEventProtos.RequestOrBuilder
            public String getName() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.event.CustomEventProtos.RequestOrBuilder
            public ByteString getNameBytes() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.name_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.event.CustomEventProtos.RequestOrBuilder
            public int getTakes() {
                return this.takes_;
            }

            @Override // com.blued.das.event.CustomEventProtos.RequestOrBuilder
            public long getTime() {
                return this.time_;
            }

            @Override // com.blued.das.event.CustomEventProtos.RequestOrBuilder
            public boolean hasCommon() {
                return (this.commonBuilder_ == null && this.common_ == null) ? false : true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CustomEventProtos.internal_static_com_blued_das_event_Request_fieldAccessorTable.ensureFieldAccessorsInitialized(Request.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeCommon(CommonProtos.Common common) {
                SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(common);
                    return this;
                }
                CommonProtos.Common common2 = this.common_;
                if (common2 != null) {
                    this.common_ = CommonProtos.Common.newBuilder(common2).mergeFrom(common).buildPartial();
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
                if (request.getTime() != 0) {
                    setTime(request.getTime());
                }
                if (request.getTakes() != 0) {
                    setTakes(request.getTakes());
                }
                if (request.getCode() != 0) {
                    setCode(request.getCode());
                }
                if (!request.getDescription().isEmpty()) {
                    this.description_ = request.description_;
                    onChanged();
                }
                if (!request.getName().isEmpty()) {
                    this.name_ = request.name_;
                    onChanged();
                }
                if (request.hasCommon()) {
                    mergeCommon(request.getCommon());
                }
                if (request.getClientTime() != 0) {
                    setClientTime(request.getClientTime());
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
            public com.blued.das.event.CustomEventProtos.Request.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.das.event.CustomEventProtos.Request.access$1400()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.das.event.CustomEventProtos$Request r0 = (com.blued.das.event.CustomEventProtos.Request) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.das.event.CustomEventProtos$Request$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.das.event.CustomEventProtos$Request r0 = (com.blued.das.event.CustomEventProtos.Request) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.das.event.CustomEventProtos$Request$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.das.event.CustomEventProtos.Request.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.das.event.CustomEventProtos$Request$Builder");
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

            public Builder setClientTime(long j) {
                this.clientTime_ = j;
                onChanged();
                return this;
            }

            public Builder setCode(int i) {
                this.code_ = i;
                onChanged();
                return this;
            }

            public Builder setCommon(CommonProtos.Common.Builder builder) {
                SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.common_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setCommon(CommonProtos.Common common) {
                SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
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

            public Builder setDescription(String str) {
                if (str != null) {
                    this.description_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setDescriptionBytes(ByteString byteString) {
                if (byteString != null) {
                    Request.checkByteStringIsUtf8(byteString);
                    this.description_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setName(String str) {
                if (str != null) {
                    this.name_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setNameBytes(ByteString byteString) {
                if (byteString != null) {
                    Request.checkByteStringIsUtf8(byteString);
                    this.name_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setTakes(int i) {
                this.takes_ = i;
                onChanged();
                return this;
            }

            public Builder setTime(long j) {
                this.time_ = j;
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
            this.description_ = "";
            this.name_ = "";
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
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.time_ = codedInputStream.readInt64();
                            } else if (readTag == 16) {
                                this.takes_ = codedInputStream.readInt32();
                            } else if (readTag == 24) {
                                this.code_ = codedInputStream.readInt32();
                            } else if (readTag == 34) {
                                this.description_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 42) {
                                this.name_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 50) {
                                CommonProtos.Common.Builder builder = this.common_ != null ? this.common_.toBuilder() : null;
                                CommonProtos.Common common = (CommonProtos.Common) codedInputStream.readMessage(CommonProtos.Common.parser(), extensionRegistryLite);
                                this.common_ = common;
                                if (builder != null) {
                                    builder.mergeFrom(common);
                                    this.common_ = builder.buildPartial();
                                }
                            } else if (readTag == 56) {
                                this.clientTime_ = codedInputStream.readInt64();
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

        private Request(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Request getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CustomEventProtos.internal_static_com_blued_das_event_Request_descriptor;
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
                if (getTime() == request.getTime() && getTakes() == request.getTakes() && getCode() == request.getCode() && getDescription().equals(request.getDescription()) && getName().equals(request.getName()) && hasCommon() == request.hasCommon()) {
                    return (!hasCommon() || getCommon().equals(request.getCommon())) && getClientTime() == request.getClientTime() && this.unknownFields.equals(request.unknownFields);
                }
                return false;
            }
            return super.equals(obj);
        }

        @Override // com.blued.das.event.CustomEventProtos.RequestOrBuilder
        public long getClientTime() {
            return this.clientTime_;
        }

        @Override // com.blued.das.event.CustomEventProtos.RequestOrBuilder
        public int getCode() {
            return this.code_;
        }

        @Override // com.blued.das.event.CustomEventProtos.RequestOrBuilder
        public CommonProtos.Common getCommon() {
            CommonProtos.Common common = this.common_;
            CommonProtos.Common common2 = common;
            if (common == null) {
                common2 = CommonProtos.Common.getDefaultInstance();
            }
            return common2;
        }

        @Override // com.blued.das.event.CustomEventProtos.RequestOrBuilder
        public CommonProtos.CommonOrBuilder getCommonOrBuilder() {
            return getCommon();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Request getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.das.event.CustomEventProtos.RequestOrBuilder
        public String getDescription() {
            Object obj = this.description_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.description_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.event.CustomEventProtos.RequestOrBuilder
        public ByteString getDescriptionBytes() {
            Object obj = this.description_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.description_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.event.CustomEventProtos.RequestOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.event.CustomEventProtos.RequestOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
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
            long j = this.time_;
            if (j != 0) {
                i2 = 0 + CodedOutputStream.computeInt64Size(1, j);
            }
            int i3 = this.takes_;
            int i4 = i2;
            if (i3 != 0) {
                i4 = i2 + CodedOutputStream.computeInt32Size(2, i3);
            }
            int i5 = this.code_;
            int i6 = i4;
            if (i5 != 0) {
                i6 = i4 + CodedOutputStream.computeInt32Size(3, i5);
            }
            int i7 = i6;
            if (!getDescriptionBytes().isEmpty()) {
                i7 = i6 + GeneratedMessageV3.computeStringSize(4, this.description_);
            }
            int i8 = i7;
            if (!getNameBytes().isEmpty()) {
                i8 = i7 + GeneratedMessageV3.computeStringSize(5, this.name_);
            }
            int i9 = i8;
            if (this.common_ != null) {
                i9 = i8 + CodedOutputStream.computeMessageSize(6, getCommon());
            }
            long j2 = this.clientTime_;
            int i10 = i9;
            if (j2 != 0) {
                i10 = i9 + CodedOutputStream.computeInt64Size(7, j2);
            }
            int serializedSize = i10 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.blued.das.event.CustomEventProtos.RequestOrBuilder
        public int getTakes() {
            return this.takes_;
        }

        @Override // com.blued.das.event.CustomEventProtos.RequestOrBuilder
        public long getTime() {
            return this.time_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.blued.das.event.CustomEventProtos.RequestOrBuilder
        public boolean hasCommon() {
            return this.common_ != null;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(getTime())) * 37) + 2) * 53) + getTakes()) * 37) + 3) * 53) + getCode()) * 37) + 4) * 53) + getDescription().hashCode()) * 37) + 5) * 53) + getName().hashCode();
            int i = hashCode;
            if (hasCommon()) {
                i = (((hashCode * 37) + 6) * 53) + getCommon().hashCode();
            }
            int hashLong = (((((i * 37) + 7) * 53) + Internal.hashLong(getClientTime())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashLong;
            return hashLong;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CustomEventProtos.internal_static_com_blued_das_event_Request_fieldAccessorTable.ensureFieldAccessorsInitialized(Request.class, Builder.class);
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
            long j = this.time_;
            if (j != 0) {
                codedOutputStream.writeInt64(1, j);
            }
            int i = this.takes_;
            if (i != 0) {
                codedOutputStream.writeInt32(2, i);
            }
            int i2 = this.code_;
            if (i2 != 0) {
                codedOutputStream.writeInt32(3, i2);
            }
            if (!getDescriptionBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.description_);
            }
            if (!getNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.name_);
            }
            if (this.common_ != null) {
                codedOutputStream.writeMessage(6, getCommon());
            }
            long j2 = this.clientTime_;
            if (j2 != 0) {
                codedOutputStream.writeInt64(7, j2);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/event/CustomEventProtos$RequestOrBuilder.class */
    public interface RequestOrBuilder extends MessageOrBuilder {
        long getClientTime();

        int getCode();

        CommonProtos.Common getCommon();

        CommonProtos.CommonOrBuilder getCommonOrBuilder();

        String getDescription();

        ByteString getDescriptionBytes();

        String getName();

        ByteString getNameBytes();

        int getTakes();

        long getTime();

        boolean hasCommon();
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/event/CustomEventProtos$Requests.class */
    public static final class Requests extends GeneratedMessageV3 implements RequestsOrBuilder {
        public static final int COMMON_FIELD_NUMBER = 1;
        private static final Requests DEFAULT_INSTANCE = new Requests();
        private static final Parser<Requests> PARSER = new AbstractParser<Requests>() { // from class: com.blued.das.event.CustomEventProtos.Requests.1
            @Override // com.google.protobuf.Parser
            public Requests parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Requests(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int REQUEST_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private CommonProtos.Common common_;
        private byte memoizedIsInitialized;
        private List<Request> request_;

        /* loaded from: source-7206380-dex2jar.jar:com/blued/das/event/CustomEventProtos$Requests$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RequestsOrBuilder {
            private int bitField0_;
            private SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> commonBuilder_;
            private CommonProtos.Common common_;
            private RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> requestBuilder_;
            private List<Request> request_;

            private Builder() {
                this.request_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.request_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void ensureRequestIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.request_ = new ArrayList(this.request_);
                    this.bitField0_ |= 1;
                }
            }

            private SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> getCommonFieldBuilder() {
                if (this.commonBuilder_ == null) {
                    this.commonBuilder_ = new SingleFieldBuilderV3<>(getCommon(), getParentForChildren(), isClean());
                    this.common_ = null;
                }
                return this.commonBuilder_;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return CustomEventProtos.internal_static_com_blued_das_event_Requests_descriptor;
            }

            private RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> getRequestFieldBuilder() {
                if (this.requestBuilder_ == null) {
                    List<Request> list = this.request_;
                    boolean z = true;
                    if ((this.bitField0_ & 1) == 0) {
                        z = false;
                    }
                    this.requestBuilder_ = new RepeatedFieldBuilderV3<>(list, z, getParentForChildren(), isClean());
                    this.request_ = null;
                }
                return this.requestBuilder_;
            }

            private void maybeForceBuilderInitialization() {
                if (Requests.alwaysUseFieldBuilders) {
                    getRequestFieldBuilder();
                }
            }

            public Builder addAllRequest(Iterable<? extends Request> iterable) {
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                    return this;
                }
                ensureRequestIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.request_);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            public Builder addRequest(int i, Request.Builder builder) {
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(i, builder.build());
                    return this;
                }
                ensureRequestIsMutable();
                this.request_.add(i, builder.build());
                onChanged();
                return this;
            }

            public Builder addRequest(int i, Request request) {
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(i, request);
                    return this;
                } else if (request != null) {
                    ensureRequestIsMutable();
                    this.request_.add(i, request);
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }

            public Builder addRequest(Request.Builder builder) {
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                    return this;
                }
                ensureRequestIsMutable();
                this.request_.add(builder.build());
                onChanged();
                return this;
            }

            public Builder addRequest(Request request) {
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(request);
                    return this;
                } else if (request != null) {
                    ensureRequestIsMutable();
                    this.request_.add(request);
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }

            public Request.Builder addRequestBuilder() {
                return getRequestFieldBuilder().addBuilder(Request.getDefaultInstance());
            }

            public Request.Builder addRequestBuilder(int i) {
                return getRequestFieldBuilder().addBuilder(i, Request.getDefaultInstance());
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Requests build() {
                Requests buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Requests buildPartial() {
                Requests requests = new Requests(this);
                SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 == null) {
                    requests.common_ = this.common_;
                } else {
                    requests.common_ = singleFieldBuilderV3.build();
                }
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.request_ = Collections.unmodifiableList(this.request_);
                        this.bitField0_ &= -2;
                    }
                    requests.request_ = this.request_;
                } else {
                    requests.request_ = repeatedFieldBuilderV3.build();
                }
                onBuilt();
                return requests;
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
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.clear();
                    return this;
                }
                this.request_ = Collections.emptyList();
                this.bitField0_ &= -2;
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearRequest() {
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.clear();
                    return this;
                }
                this.request_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1800clone() {
                return (Builder) super.mo1800clone();
            }

            @Override // com.blued.das.event.CustomEventProtos.RequestsOrBuilder
            public CommonProtos.Common getCommon() {
                SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 == null) {
                    CommonProtos.Common common = this.common_;
                    CommonProtos.Common common2 = common;
                    if (common == null) {
                        common2 = CommonProtos.Common.getDefaultInstance();
                    }
                    return common2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public CommonProtos.Common.Builder getCommonBuilder() {
                onChanged();
                return getCommonFieldBuilder().getBuilder();
            }

            @Override // com.blued.das.event.CustomEventProtos.RequestsOrBuilder
            public CommonProtos.CommonOrBuilder getCommonOrBuilder() {
                SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                CommonProtos.Common common = this.common_;
                CommonProtos.Common common2 = common;
                if (common == null) {
                    common2 = CommonProtos.Common.getDefaultInstance();
                }
                return common2;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Requests getDefaultInstanceForType() {
                return Requests.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CustomEventProtos.internal_static_com_blued_das_event_Requests_descriptor;
            }

            @Override // com.blued.das.event.CustomEventProtos.RequestsOrBuilder
            public Request getRequest(int i) {
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                return repeatedFieldBuilderV3 == null ? this.request_.get(i) : repeatedFieldBuilderV3.getMessage(i);
            }

            public Request.Builder getRequestBuilder(int i) {
                return getRequestFieldBuilder().getBuilder(i);
            }

            public List<Request.Builder> getRequestBuilderList() {
                return getRequestFieldBuilder().getBuilderList();
            }

            @Override // com.blued.das.event.CustomEventProtos.RequestsOrBuilder
            public int getRequestCount() {
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                return repeatedFieldBuilderV3 == null ? this.request_.size() : repeatedFieldBuilderV3.getCount();
            }

            @Override // com.blued.das.event.CustomEventProtos.RequestsOrBuilder
            public List<Request> getRequestList() {
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.request_) : repeatedFieldBuilderV3.getMessageList();
            }

            @Override // com.blued.das.event.CustomEventProtos.RequestsOrBuilder
            public RequestOrBuilder getRequestOrBuilder(int i) {
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                return repeatedFieldBuilderV3 == null ? this.request_.get(i) : repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // com.blued.das.event.CustomEventProtos.RequestsOrBuilder
            public List<? extends RequestOrBuilder> getRequestOrBuilderList() {
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.request_);
            }

            @Override // com.blued.das.event.CustomEventProtos.RequestsOrBuilder
            public boolean hasCommon() {
                return (this.commonBuilder_ == null && this.common_ == null) ? false : true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CustomEventProtos.internal_static_com_blued_das_event_Requests_fieldAccessorTable.ensureFieldAccessorsInitialized(Requests.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeCommon(CommonProtos.Common common) {
                SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(common);
                    return this;
                }
                CommonProtos.Common common2 = this.common_;
                if (common2 != null) {
                    this.common_ = CommonProtos.Common.newBuilder(common2).mergeFrom(common).buildPartial();
                } else {
                    this.common_ = common;
                }
                onChanged();
                return this;
            }

            public Builder mergeFrom(Requests requests) {
                if (requests == Requests.getDefaultInstance()) {
                    return this;
                }
                if (requests.hasCommon()) {
                    mergeCommon(requests.getCommon());
                }
                if (this.requestBuilder_ == null) {
                    if (!requests.request_.isEmpty()) {
                        if (this.request_.isEmpty()) {
                            this.request_ = requests.request_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureRequestIsMutable();
                            this.request_.addAll(requests.request_);
                        }
                        onChanged();
                    }
                } else if (!requests.request_.isEmpty()) {
                    if (this.requestBuilder_.isEmpty()) {
                        this.requestBuilder_.dispose();
                        RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = null;
                        this.requestBuilder_ = null;
                        this.request_ = requests.request_;
                        this.bitField0_ &= -2;
                        if (Requests.alwaysUseFieldBuilders) {
                            repeatedFieldBuilderV3 = getRequestFieldBuilder();
                        }
                        this.requestBuilder_ = repeatedFieldBuilderV3;
                    } else {
                        this.requestBuilder_.addAllMessages(requests.request_);
                    }
                }
                mergeUnknownFields(requests.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.das.event.CustomEventProtos.Requests.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.das.event.CustomEventProtos.Requests.access$2800()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.das.event.CustomEventProtos$Requests r0 = (com.blued.das.event.CustomEventProtos.Requests) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.das.event.CustomEventProtos$Requests$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.das.event.CustomEventProtos$Requests r0 = (com.blued.das.event.CustomEventProtos.Requests) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.das.event.CustomEventProtos$Requests$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.das.event.CustomEventProtos.Requests.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.das.event.CustomEventProtos$Requests$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof Requests) {
                    return mergeFrom((Requests) message);
                }
                super.mergeFrom(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder removeRequest(int i) {
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.remove(i);
                    return this;
                }
                ensureRequestIsMutable();
                this.request_.remove(i);
                onChanged();
                return this;
            }

            public Builder setCommon(CommonProtos.Common.Builder builder) {
                SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.common_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setCommon(CommonProtos.Common common) {
                SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> singleFieldBuilderV3 = this.commonBuilder_;
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setRequest(int i, Request.Builder builder) {
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.setMessage(i, builder.build());
                    return this;
                }
                ensureRequestIsMutable();
                this.request_.set(i, builder.build());
                onChanged();
                return this;
            }

            public Builder setRequest(int i, Request request) {
                RepeatedFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> repeatedFieldBuilderV3 = this.requestBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.setMessage(i, request);
                    return this;
                } else if (request != null) {
                    ensureRequestIsMutable();
                    this.request_.set(i, request);
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private Requests() {
            this.memoizedIsInitialized = (byte) -1;
            this.request_ = Collections.emptyList();
        }

        private Requests(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            CommonProtos.Common.Builder builder;
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
                        if (readTag != 0) {
                            if (readTag == 10) {
                                if (this.common_ != null) {
                                    boolean z4 = z2;
                                    builder = this.common_.toBuilder();
                                } else {
                                    builder = null;
                                }
                                CommonProtos.Common common = (CommonProtos.Common) codedInputStream.readMessage(CommonProtos.Common.parser(), extensionRegistryLite);
                                boolean z5 = z2;
                                this.common_ = common;
                                if (builder != null) {
                                    builder.mergeFrom(common);
                                    boolean z6 = z2;
                                    this.common_ = builder.buildPartial();
                                }
                            } else if (readTag == 18) {
                                boolean z7 = z2;
                                if (!(z2 & true)) {
                                    this.request_ = new ArrayList();
                                    z7 = z2 | true;
                                }
                                this.request_.add((Request) codedInputStream.readMessage(Request.parser(), extensionRegistryLite));
                                z2 = z7;
                            } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
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
                        this.request_ = Collections.unmodifiableList(this.request_);
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 & true) {
                this.request_ = Collections.unmodifiableList(this.request_);
            }
            this.unknownFields = newBuilder.build();
            makeExtensionsImmutable();
        }

        private Requests(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Requests getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CustomEventProtos.internal_static_com_blued_das_event_Requests_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Requests requests) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(requests);
        }

        public static Requests parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Requests) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Requests parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Requests) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Requests parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Requests parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Requests parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Requests) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Requests parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Requests) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static Requests parseFrom(InputStream inputStream) throws IOException {
            return (Requests) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Requests parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Requests) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Requests parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Requests parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Requests parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Requests parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<Requests> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Requests) {
                Requests requests = (Requests) obj;
                if (hasCommon() != requests.hasCommon()) {
                    return false;
                }
                return (!hasCommon() || getCommon().equals(requests.getCommon())) && getRequestList().equals(requests.getRequestList()) && this.unknownFields.equals(requests.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.blued.das.event.CustomEventProtos.RequestsOrBuilder
        public CommonProtos.Common getCommon() {
            CommonProtos.Common common = this.common_;
            CommonProtos.Common common2 = common;
            if (common == null) {
                common2 = CommonProtos.Common.getDefaultInstance();
            }
            return common2;
        }

        @Override // com.blued.das.event.CustomEventProtos.RequestsOrBuilder
        public CommonProtos.CommonOrBuilder getCommonOrBuilder() {
            return getCommon();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Requests getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Requests> getParserForType() {
            return PARSER;
        }

        @Override // com.blued.das.event.CustomEventProtos.RequestsOrBuilder
        public Request getRequest(int i) {
            return this.request_.get(i);
        }

        @Override // com.blued.das.event.CustomEventProtos.RequestsOrBuilder
        public int getRequestCount() {
            return this.request_.size();
        }

        @Override // com.blued.das.event.CustomEventProtos.RequestsOrBuilder
        public List<Request> getRequestList() {
            return this.request_;
        }

        @Override // com.blued.das.event.CustomEventProtos.RequestsOrBuilder
        public RequestOrBuilder getRequestOrBuilder(int i) {
            return this.request_.get(i);
        }

        @Override // com.blued.das.event.CustomEventProtos.RequestsOrBuilder
        public List<? extends RequestOrBuilder> getRequestOrBuilderList() {
            return this.request_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int computeMessageSize = this.common_ != null ? CodedOutputStream.computeMessageSize(1, getCommon()) + 0 : 0;
            for (int i2 = 0; i2 < this.request_.size(); i2++) {
                computeMessageSize += CodedOutputStream.computeMessageSize(2, this.request_.get(i2));
            }
            int serializedSize = computeMessageSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.blued.das.event.CustomEventProtos.RequestsOrBuilder
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
            int i2 = i;
            if (getRequestCount() > 0) {
                i2 = (((i * 37) + 2) * 53) + getRequestList().hashCode();
            }
            int hashCode2 = (i2 * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CustomEventProtos.internal_static_com_blued_das_event_Requests_fieldAccessorTable.ensureFieldAccessorsInitialized(Requests.class, Builder.class);
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
            return new Requests();
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
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.request_.size()) {
                    this.unknownFields.writeTo(codedOutputStream);
                    return;
                } else {
                    codedOutputStream.writeMessage(2, this.request_.get(i2));
                    i = i2 + 1;
                }
            }
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/event/CustomEventProtos$RequestsOrBuilder.class */
    public interface RequestsOrBuilder extends MessageOrBuilder {
        CommonProtos.Common getCommon();

        CommonProtos.CommonOrBuilder getCommonOrBuilder();

        Request getRequest(int i);

        int getRequestCount();

        List<Request> getRequestList();

        RequestOrBuilder getRequestOrBuilder(int i);

        List<? extends RequestOrBuilder> getRequestOrBuilderList();

        boolean hasCommon();
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/event/CustomEventProtos$Response.class */
    public static final class Response extends GeneratedMessageV3 implements ResponseOrBuilder {
        public static final int CODE_FIELD_NUMBER = 1;
        private static final Response DEFAULT_INSTANCE = new Response();
        private static final Parser<Response> PARSER = new AbstractParser<Response>() { // from class: com.blued.das.event.CustomEventProtos.Response.1
            @Override // com.google.protobuf.Parser
            public Response parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Response(codedInputStream, extensionRegistryLite);
            }
        };
        private static final long serialVersionUID = 0;
        private int code_;
        private byte memoizedIsInitialized;

        /* loaded from: source-7206380-dex2jar.jar:com/blued/das/event/CustomEventProtos$Response$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ResponseOrBuilder {
            private int code_;

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return CustomEventProtos.internal_static_com_blued_das_event_Response_descriptor;
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
                onBuilt();
                return response;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.code_ = 0;
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1800clone() {
                return (Builder) super.mo1800clone();
            }

            @Override // com.blued.das.event.CustomEventProtos.ResponseOrBuilder
            public int getCode() {
                return this.code_;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Response getDefaultInstanceForType() {
                return Response.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CustomEventProtos.internal_static_com_blued_das_event_Response_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CustomEventProtos.internal_static_com_blued_das_event_Response_fieldAccessorTable.ensureFieldAccessorsInitialized(Response.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(Response response) {
                if (response == Response.getDefaultInstance()) {
                    return this;
                }
                if (response.getCode() != 0) {
                    setCode(response.getCode());
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
            public com.blued.das.event.CustomEventProtos.Response.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.das.event.CustomEventProtos.Response.access$3800()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.das.event.CustomEventProtos$Response r0 = (com.blued.das.event.CustomEventProtos.Response) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.das.event.CustomEventProtos$Response$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.das.event.CustomEventProtos$Response r0 = (com.blued.das.event.CustomEventProtos.Response) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.das.event.CustomEventProtos$Response$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.das.event.CustomEventProtos.Response.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.das.event.CustomEventProtos$Response$Builder");
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

            public Builder setCode(int i) {
                this.code_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private Response() {
            this.memoizedIsInitialized = (byte) -1;
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
                                this.code_ = codedInputStream.readInt32();
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
            return CustomEventProtos.internal_static_com_blued_das_event_Response_descriptor;
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
                return getCode() == response.getCode() && this.unknownFields.equals(response.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.blued.das.event.CustomEventProtos.ResponseOrBuilder
        public int getCode() {
            return this.code_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Response getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Response> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            int i3 = this.code_;
            if (i3 != 0) {
                i2 = 0 + CodedOutputStream.computeInt32Size(1, i3);
            }
            int serializedSize = i2 + this.unknownFields.getSerializedSize();
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
            int hashCode = ((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CustomEventProtos.internal_static_com_blued_das_event_Response_fieldAccessorTable.ensureFieldAccessorsInitialized(Response.class, Builder.class);
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
            int i = this.code_;
            if (i != 0) {
                codedOutputStream.writeInt32(1, i);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/event/CustomEventProtos$ResponseOrBuilder.class */
    public interface ResponseOrBuilder extends MessageOrBuilder {
        int getCode();
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_blued_das_event_Request_descriptor = descriptor2;
        internal_static_com_blued_das_event_Request_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Time", "Takes", "Code", "Description", "Name", "Common", "ClientTime"});
        Descriptors.Descriptor descriptor3 = getDescriptor().getMessageTypes().get(1);
        internal_static_com_blued_das_event_Requests_descriptor = descriptor3;
        internal_static_com_blued_das_event_Requests_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor3, new String[]{"Common", "Request"});
        Descriptors.Descriptor descriptor4 = getDescriptor().getMessageTypes().get(2);
        internal_static_com_blued_das_event_Response_descriptor = descriptor4;
        internal_static_com_blued_das_event_Response_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor4, new String[]{"Code"});
        CommonProtos.getDescriptor();
    }

    private CustomEventProtos() {
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
