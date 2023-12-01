package com.blct.irisdt.client;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: source-8756600-dex2jar.jar:com/blct/irisdt/client/CommonExtraProtos.class */
public final class CommonExtraProtos {

    /* renamed from: a  reason: collision with root package name */
    private static final Descriptors.Descriptor f6637a;
    private static final GeneratedMessageV3.FieldAccessorTable b;

    /* renamed from: c  reason: collision with root package name */
    private static Descriptors.FileDescriptor f6638c = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017CommonExtraProtos.proto\u0012\u0016com.blct.irisdt.client\"6\n\u0010CommonExtraProto\u0012\u0010\n\bvip_type\u0018\u0001 \u0001(\t\u0012\u0010\n\bapp_type\u0018\u0002 \u0001(\tB\u000f¢\u0002\fCOMMON_EXTRAb\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    /* loaded from: source-8756600-dex2jar.jar:com/blct/irisdt/client/CommonExtraProtos$CommonExtraProto.class */
    public static final class CommonExtraProto extends GeneratedMessageV3 implements CommonExtraProtoOrBuilder {
        public static final int APP_TYPE_FIELD_NUMBER = 2;
        private static final CommonExtraProto DEFAULT_INSTANCE = new CommonExtraProto();
        private static final Parser<CommonExtraProto> PARSER = new AbstractParser<CommonExtraProto>() { // from class: com.blct.irisdt.client.CommonExtraProtos.CommonExtraProto.1
            @Override // com.google.protobuf.Parser
            /* renamed from: a */
            public CommonExtraProto parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new CommonExtraProto(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int VIP_TYPE_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private volatile Object appType_;
        private byte memoizedIsInitialized;
        private volatile Object vipType_;

        /* loaded from: source-8756600-dex2jar.jar:com/blct/irisdt/client/CommonExtraProtos$CommonExtraProto$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CommonExtraProtoOrBuilder {
            private Object appType_;
            private Object vipType_;

            private Builder() {
                this.vipType_ = "";
                this.appType_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.vipType_ = "";
                this.appType_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return CommonExtraProtos.f6637a;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = CommonExtraProto.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CommonExtraProto build() {
                CommonExtraProto buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CommonExtraProto buildPartial() {
                CommonExtraProto commonExtraProto = new CommonExtraProto(this);
                commonExtraProto.vipType_ = this.vipType_;
                commonExtraProto.appType_ = this.appType_;
                onBuilt();
                return commonExtraProto;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.vipType_ = "";
                this.appType_ = "";
                return this;
            }

            public Builder clearAppType() {
                this.appType_ = CommonExtraProto.getDefaultInstance().getAppType();
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

            public Builder clearVipType() {
                this.vipType_ = CommonExtraProto.getDefaultInstance().getVipType();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo2030clone() {
                return (Builder) super.mo2030clone();
            }

            @Override // com.blct.irisdt.client.CommonExtraProtos.CommonExtraProtoOrBuilder
            public String getAppType() {
                Object obj = this.appType_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.appType_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blct.irisdt.client.CommonExtraProtos.CommonExtraProtoOrBuilder
            public ByteString getAppTypeBytes() {
                Object obj = this.appType_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.appType_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CommonExtraProto getDefaultInstanceForType() {
                return CommonExtraProto.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CommonExtraProtos.f6637a;
            }

            @Override // com.blct.irisdt.client.CommonExtraProtos.CommonExtraProtoOrBuilder
            public String getVipType() {
                Object obj = this.vipType_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.vipType_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blct.irisdt.client.CommonExtraProtos.CommonExtraProtoOrBuilder
            public ByteString getVipTypeBytes() {
                Object obj = this.vipType_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.vipType_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CommonExtraProtos.b.ensureFieldAccessorsInitialized(CommonExtraProto.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(CommonExtraProto commonExtraProto) {
                if (commonExtraProto == CommonExtraProto.getDefaultInstance()) {
                    return this;
                }
                if (!commonExtraProto.getVipType().isEmpty()) {
                    this.vipType_ = commonExtraProto.vipType_;
                    onChanged();
                }
                if (!commonExtraProto.getAppType().isEmpty()) {
                    this.appType_ = commonExtraProto.appType_;
                    onChanged();
                }
                mergeUnknownFields(commonExtraProto.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blct.irisdt.client.CommonExtraProtos.CommonExtraProto.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blct.irisdt.client.CommonExtraProtos.CommonExtraProto.access$900()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blct.irisdt.client.CommonExtraProtos$CommonExtraProto r0 = (com.blct.irisdt.client.CommonExtraProtos.CommonExtraProto) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blct.irisdt.client.CommonExtraProtos$CommonExtraProto$Builder r0 = r0.mergeFrom(r1)
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
                    com.blct.irisdt.client.CommonExtraProtos$CommonExtraProto r0 = (com.blct.irisdt.client.CommonExtraProtos.CommonExtraProto) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blct.irisdt.client.CommonExtraProtos$CommonExtraProto$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blct.irisdt.client.CommonExtraProtos.CommonExtraProto.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blct.irisdt.client.CommonExtraProtos$CommonExtraProto$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof CommonExtraProto) {
                    return mergeFrom((CommonExtraProto) message);
                }
                super.mergeFrom(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder setAppType(String str) {
                if (str != null) {
                    this.appType_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setAppTypeBytes(ByteString byteString) {
                if (byteString != null) {
                    CommonExtraProto.checkByteStringIsUtf8(byteString);
                    this.appType_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
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

            public Builder setVipType(String str) {
                if (str != null) {
                    this.vipType_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setVipTypeBytes(ByteString byteString) {
                if (byteString != null) {
                    CommonExtraProto.checkByteStringIsUtf8(byteString);
                    this.vipType_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }
        }

        private CommonExtraProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.vipType_ = "";
            this.appType_ = "";
        }

        private CommonExtraProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.vipType_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 18) {
                                    this.appType_ = codedInputStream.readStringRequireUtf8();
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

        private CommonExtraProto(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static CommonExtraProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CommonExtraProtos.f6637a;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CommonExtraProto commonExtraProto) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(commonExtraProto);
        }

        public static CommonExtraProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (CommonExtraProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static CommonExtraProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CommonExtraProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static CommonExtraProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static CommonExtraProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static CommonExtraProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (CommonExtraProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static CommonExtraProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CommonExtraProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static CommonExtraProto parseFrom(InputStream inputStream) throws IOException {
            return (CommonExtraProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static CommonExtraProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CommonExtraProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static CommonExtraProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static CommonExtraProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static CommonExtraProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static CommonExtraProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<CommonExtraProto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof CommonExtraProto) {
                CommonExtraProto commonExtraProto = (CommonExtraProto) obj;
                return getVipType().equals(commonExtraProto.getVipType()) && getAppType().equals(commonExtraProto.getAppType()) && this.unknownFields.equals(commonExtraProto.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.blct.irisdt.client.CommonExtraProtos.CommonExtraProtoOrBuilder
        public String getAppType() {
            Object obj = this.appType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.appType_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blct.irisdt.client.CommonExtraProtos.CommonExtraProtoOrBuilder
        public ByteString getAppTypeBytes() {
            Object obj = this.appType_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.appType_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CommonExtraProto getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CommonExtraProto> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (!getVipTypeBytes().isEmpty()) {
                i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.vipType_);
            }
            int i3 = i2;
            if (!getAppTypeBytes().isEmpty()) {
                i3 = i2 + GeneratedMessageV3.computeStringSize(2, this.appType_);
            }
            int serializedSize = i3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.blct.irisdt.client.CommonExtraProtos.CommonExtraProtoOrBuilder
        public String getVipType() {
            Object obj = this.vipType_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.vipType_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blct.irisdt.client.CommonExtraProtos.CommonExtraProtoOrBuilder
        public ByteString getVipTypeBytes() {
            Object obj = this.vipType_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.vipType_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getVipType().hashCode()) * 37) + 2) * 53) + getAppType().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CommonExtraProtos.b.ensureFieldAccessorsInitialized(CommonExtraProto.class, Builder.class);
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
            return new CommonExtraProto();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!getVipTypeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.vipType_);
            }
            if (!getAppTypeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.appType_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/blct/irisdt/client/CommonExtraProtos$CommonExtraProtoOrBuilder.class */
    public interface CommonExtraProtoOrBuilder extends MessageOrBuilder {
        String getAppType();

        ByteString getAppTypeBytes();

        String getVipType();

        ByteString getVipTypeBytes();
    }

    static {
        Descriptors.Descriptor descriptor = a().getMessageTypes().get(0);
        f6637a = descriptor;
        b = new GeneratedMessageV3.FieldAccessorTable(descriptor, new String[]{"VipType", "AppType"});
    }

    private CommonExtraProtos() {
    }

    public static Descriptors.FileDescriptor a() {
        return f6638c;
    }
}
