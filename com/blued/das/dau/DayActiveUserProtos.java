package com.blued.das.dau;

import com.blued.das.CommonProtos;
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
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: source-7206380-dex2jar.jar:com/blued/das/dau/DayActiveUserProtos.class */
public final class DayActiveUserProtos {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019DayActiveUserProtos.proto\u0012\u0011com.blued.das.dau\u001a\u0012CommonProtos.proto\"z\n\u0007Request\u0012\f\n\u0004time\u0018\u0001 \u0001(\u0003\u0012%\n\u0004name\u0018\u0002 \u0001(\u000e2\u0017.com.blued.das.dau.NAME\u0012%\n\u0006common\u0018\u0003 \u0001(\u000b2\u0015.com.blued.das.Common\u0012\u0013\n\u000bclient_time\u0018\u0004 \u0001(\u0003\"\u0018\n\bResponse\u0012\f\n\u0004code\u0018\u0001 \u0001(\u0005*`\n\u0004NAME\u0012\u000b\n\u0007UNKNOWN\u0010��\u0012\t\n\u0005LOGIN\u0010\u0001\u0012\u0013\n\u000fSWITCH_TO_FRONT\u0010\u0002\u0012\u0012\n\u000eSWITCH_TO_BACK\u0010\u0003\u0012\u000b\n\u0007REGULAR\u0010\u0004\u0012\n\n\u0006LOGOUT\u0010\u00052T\n\rReportService\u0012C\n\u0006Report\u0012\u001a.com.blued.das.dau.Request\u001a\u001b.com.blued.das.dau.Response\"��B\u0012¢\u0002\u000fDAY_ACTIVE_USERb\u0006proto3"}, new Descriptors.FileDescriptor[]{CommonProtos.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_com_blued_das_dau_Request_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_dau_Request_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_blued_das_dau_Response_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_dau_Response_fieldAccessorTable;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/dau/DayActiveUserProtos$NAME.class */
    public enum NAME implements ProtocolMessageEnum {
        UNKNOWN(0),
        LOGIN(1),
        SWITCH_TO_FRONT(2),
        SWITCH_TO_BACK(3),
        REGULAR(4),
        LOGOUT(5),
        UNRECOGNIZED(-1);
        
        public static final int LOGIN_VALUE = 1;
        public static final int LOGOUT_VALUE = 5;
        public static final int REGULAR_VALUE = 4;
        public static final int SWITCH_TO_BACK_VALUE = 3;
        public static final int SWITCH_TO_FRONT_VALUE = 2;
        public static final int UNKNOWN_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<NAME> internalValueMap = new Internal.EnumLiteMap<NAME>() { // from class: com.blued.das.dau.DayActiveUserProtos.NAME.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public NAME findValueByNumber(int i) {
                return NAME.forNumber(i);
            }
        };
        private static final NAME[] VALUES = values();

        NAME(int i) {
            this.value = i;
        }

        public static NAME forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                if (i != 5) {
                                    return null;
                                }
                                return LOGOUT;
                            }
                            return REGULAR;
                        }
                        return SWITCH_TO_BACK;
                    }
                    return SWITCH_TO_FRONT;
                }
                return LOGIN;
            }
            return UNKNOWN;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return DayActiveUserProtos.getDescriptor().getEnumTypes().get(0);
        }

        public static Internal.EnumLiteMap<NAME> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static NAME valueOf(int i) {
            return forNumber(i);
        }

        public static NAME valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() == getDescriptor()) {
                return enumValueDescriptor.getIndex() == -1 ? UNRECOGNIZED : VALUES[enumValueDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this != UNRECOGNIZED) {
                return getDescriptor().getValues().get(ordinal());
            }
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/dau/DayActiveUserProtos$Request.class */
    public static final class Request extends GeneratedMessageV3 implements RequestOrBuilder {
        public static final int CLIENT_TIME_FIELD_NUMBER = 4;
        public static final int COMMON_FIELD_NUMBER = 3;
        public static final int NAME_FIELD_NUMBER = 2;
        public static final int TIME_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private long clientTime_;
        private CommonProtos.Common common_;
        private byte memoizedIsInitialized;
        private int name_;
        private long time_;
        private static final Request DEFAULT_INSTANCE = new Request();
        private static final Parser<Request> PARSER = new AbstractParser<Request>() { // from class: com.blued.das.dau.DayActiveUserProtos.Request.1
            @Override // com.google.protobuf.Parser
            public Request parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Request(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/das/dau/DayActiveUserProtos$Request$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RequestOrBuilder {
            private long clientTime_;
            private SingleFieldBuilderV3<CommonProtos.Common, CommonProtos.Common.Builder, CommonProtos.CommonOrBuilder> commonBuilder_;
            private CommonProtos.Common common_;
            private int name_;
            private long time_;

            private Builder() {
                this.name_ = 0;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.name_ = 0;
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
                return DayActiveUserProtos.internal_static_com_blued_das_dau_Request_descriptor;
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
                this.name_ = 0;
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

            public Builder clearName() {
                this.name_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
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

            @Override // com.blued.das.dau.DayActiveUserProtos.RequestOrBuilder
            public long getClientTime() {
                return this.clientTime_;
            }

            @Override // com.blued.das.dau.DayActiveUserProtos.RequestOrBuilder
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

            @Override // com.blued.das.dau.DayActiveUserProtos.RequestOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DayActiveUserProtos.internal_static_com_blued_das_dau_Request_descriptor;
            }

            @Override // com.blued.das.dau.DayActiveUserProtos.RequestOrBuilder
            public NAME getName() {
                NAME valueOf = NAME.valueOf(this.name_);
                NAME name = valueOf;
                if (valueOf == null) {
                    name = NAME.UNRECOGNIZED;
                }
                return name;
            }

            @Override // com.blued.das.dau.DayActiveUserProtos.RequestOrBuilder
            public int getNameValue() {
                return this.name_;
            }

            @Override // com.blued.das.dau.DayActiveUserProtos.RequestOrBuilder
            public long getTime() {
                return this.time_;
            }

            @Override // com.blued.das.dau.DayActiveUserProtos.RequestOrBuilder
            public boolean hasCommon() {
                return (this.commonBuilder_ == null && this.common_ == null) ? false : true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DayActiveUserProtos.internal_static_com_blued_das_dau_Request_fieldAccessorTable.ensureFieldAccessorsInitialized(Request.class, Builder.class);
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
                if (request.name_ != 0) {
                    setNameValue(request.getNameValue());
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
            public com.blued.das.dau.DayActiveUserProtos.Request.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.das.dau.DayActiveUserProtos.Request.access$1100()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.das.dau.DayActiveUserProtos$Request r0 = (com.blued.das.dau.DayActiveUserProtos.Request) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.das.dau.DayActiveUserProtos$Request$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.das.dau.DayActiveUserProtos$Request r0 = (com.blued.das.dau.DayActiveUserProtos.Request) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.das.dau.DayActiveUserProtos$Request$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.das.dau.DayActiveUserProtos.Request.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.das.dau.DayActiveUserProtos$Request$Builder");
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

            public Builder setName(NAME name) {
                if (name != null) {
                    this.name_ = name.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setNameValue(int i) {
                this.name_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
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
            this.name_ = 0;
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
                                this.name_ = codedInputStream.readEnum();
                            } else if (readTag == 26) {
                                CommonProtos.Common.Builder builder = this.common_ != null ? this.common_.toBuilder() : null;
                                CommonProtos.Common common = (CommonProtos.Common) codedInputStream.readMessage(CommonProtos.Common.parser(), extensionRegistryLite);
                                this.common_ = common;
                                if (builder != null) {
                                    builder.mergeFrom(common);
                                    this.common_ = builder.buildPartial();
                                }
                            } else if (readTag == 32) {
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
            return DayActiveUserProtos.internal_static_com_blued_das_dau_Request_descriptor;
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
                if (getTime() == request.getTime() && this.name_ == request.name_ && hasCommon() == request.hasCommon()) {
                    return (!hasCommon() || getCommon().equals(request.getCommon())) && getClientTime() == request.getClientTime() && this.unknownFields.equals(request.unknownFields);
                }
                return false;
            }
            return super.equals(obj);
        }

        @Override // com.blued.das.dau.DayActiveUserProtos.RequestOrBuilder
        public long getClientTime() {
            return this.clientTime_;
        }

        @Override // com.blued.das.dau.DayActiveUserProtos.RequestOrBuilder
        public CommonProtos.Common getCommon() {
            CommonProtos.Common common = this.common_;
            CommonProtos.Common common2 = common;
            if (common == null) {
                common2 = CommonProtos.Common.getDefaultInstance();
            }
            return common2;
        }

        @Override // com.blued.das.dau.DayActiveUserProtos.RequestOrBuilder
        public CommonProtos.CommonOrBuilder getCommonOrBuilder() {
            return getCommon();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Request getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.das.dau.DayActiveUserProtos.RequestOrBuilder
        public NAME getName() {
            NAME valueOf = NAME.valueOf(this.name_);
            NAME name = valueOf;
            if (valueOf == null) {
                name = NAME.UNRECOGNIZED;
            }
            return name;
        }

        @Override // com.blued.das.dau.DayActiveUserProtos.RequestOrBuilder
        public int getNameValue() {
            return this.name_;
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
            int i3 = i2;
            if (this.name_ != NAME.UNKNOWN.getNumber()) {
                i3 = i2 + CodedOutputStream.computeEnumSize(2, this.name_);
            }
            int i4 = i3;
            if (this.common_ != null) {
                i4 = i3 + CodedOutputStream.computeMessageSize(3, getCommon());
            }
            long j2 = this.clientTime_;
            int i5 = i4;
            if (j2 != 0) {
                i5 = i4 + CodedOutputStream.computeInt64Size(4, j2);
            }
            int serializedSize = i5 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.blued.das.dau.DayActiveUserProtos.RequestOrBuilder
        public long getTime() {
            return this.time_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.blued.das.dau.DayActiveUserProtos.RequestOrBuilder
        public boolean hasCommon() {
            return this.common_ != null;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(getTime())) * 37) + 2) * 53) + this.name_;
            int i = hashCode;
            if (hasCommon()) {
                i = (((hashCode * 37) + 3) * 53) + getCommon().hashCode();
            }
            int hashLong = (((((i * 37) + 4) * 53) + Internal.hashLong(getClientTime())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashLong;
            return hashLong;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return DayActiveUserProtos.internal_static_com_blued_das_dau_Request_fieldAccessorTable.ensureFieldAccessorsInitialized(Request.class, Builder.class);
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
            if (this.name_ != NAME.UNKNOWN.getNumber()) {
                codedOutputStream.writeEnum(2, this.name_);
            }
            if (this.common_ != null) {
                codedOutputStream.writeMessage(3, getCommon());
            }
            long j2 = this.clientTime_;
            if (j2 != 0) {
                codedOutputStream.writeInt64(4, j2);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/dau/DayActiveUserProtos$RequestOrBuilder.class */
    public interface RequestOrBuilder extends MessageOrBuilder {
        long getClientTime();

        CommonProtos.Common getCommon();

        CommonProtos.CommonOrBuilder getCommonOrBuilder();

        NAME getName();

        int getNameValue();

        long getTime();

        boolean hasCommon();
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/dau/DayActiveUserProtos$Response.class */
    public static final class Response extends GeneratedMessageV3 implements ResponseOrBuilder {
        public static final int CODE_FIELD_NUMBER = 1;
        private static final Response DEFAULT_INSTANCE = new Response();
        private static final Parser<Response> PARSER = new AbstractParser<Response>() { // from class: com.blued.das.dau.DayActiveUserProtos.Response.1
            @Override // com.google.protobuf.Parser
            public Response parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Response(codedInputStream, extensionRegistryLite);
            }
        };
        private static final long serialVersionUID = 0;
        private int code_;
        private byte memoizedIsInitialized;

        /* loaded from: source-7206380-dex2jar.jar:com/blued/das/dau/DayActiveUserProtos$Response$Builder.class */
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
                return DayActiveUserProtos.internal_static_com_blued_das_dau_Response_descriptor;
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

            @Override // com.blued.das.dau.DayActiveUserProtos.ResponseOrBuilder
            public int getCode() {
                return this.code_;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Response getDefaultInstanceForType() {
                return Response.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DayActiveUserProtos.internal_static_com_blued_das_dau_Response_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DayActiveUserProtos.internal_static_com_blued_das_dau_Response_fieldAccessorTable.ensureFieldAccessorsInitialized(Response.class, Builder.class);
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
            public com.blued.das.dau.DayActiveUserProtos.Response.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.das.dau.DayActiveUserProtos.Response.access$2100()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.das.dau.DayActiveUserProtos$Response r0 = (com.blued.das.dau.DayActiveUserProtos.Response) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.das.dau.DayActiveUserProtos$Response$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.das.dau.DayActiveUserProtos$Response r0 = (com.blued.das.dau.DayActiveUserProtos.Response) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.das.dau.DayActiveUserProtos$Response$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.das.dau.DayActiveUserProtos.Response.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.das.dau.DayActiveUserProtos$Response$Builder");
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
            return DayActiveUserProtos.internal_static_com_blued_das_dau_Response_descriptor;
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

        @Override // com.blued.das.dau.DayActiveUserProtos.ResponseOrBuilder
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
            return DayActiveUserProtos.internal_static_com_blued_das_dau_Response_fieldAccessorTable.ensureFieldAccessorsInitialized(Response.class, Builder.class);
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

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/dau/DayActiveUserProtos$ResponseOrBuilder.class */
    public interface ResponseOrBuilder extends MessageOrBuilder {
        int getCode();
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_blued_das_dau_Request_descriptor = descriptor2;
        internal_static_com_blued_das_dau_Request_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Time", "Name", "Common", "ClientTime"});
        Descriptors.Descriptor descriptor3 = getDescriptor().getMessageTypes().get(1);
        internal_static_com_blued_das_dau_Response_descriptor = descriptor3;
        internal_static_com_blued_das_dau_Response_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor3, new String[]{"Code"});
        CommonProtos.getDescriptor();
    }

    private DayActiveUserProtos() {
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