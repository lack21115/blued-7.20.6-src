package com.blued.im;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
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

/* loaded from: source-7206380-dex2jar.jar:com/blued/im/CommonOuterClass.class */
public final class CommonOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\fCommon.proto\u0012\fcom.blued.im\"¢\u0001\n\u0006Common\u0012\u0013\n\u000bapp_version\u0018\u0001 \u0001(\t\u0012\u0018\n\u0010app_version_code\u0018\u0002 \u0001(\u0005\u0012\u0010\n\bplatform\u0018\u0003 \u0001(\t\u0012\u0010\n\blanguage\u0018\u0004 \u0001(\t\u0012\u0010\n\btimezone\u0018\u0005 \u0001(\t\u0012\u0012\n\nos_version\u0018\u0006 \u0001(\t\u0012\u000e\n\u0006device\u0018\u0007 \u0001(\t\u0012\u000f\n\u0007channel\u0018\b \u0001(\tB\u000b¢\u0002\bImCommonb\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_com_blued_im_Common_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_im_Common_fieldAccessorTable;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/CommonOuterClass$Common.class */
    public static final class Common extends GeneratedMessageV3 implements CommonOrBuilder {
        public static final int APP_VERSION_CODE_FIELD_NUMBER = 2;
        public static final int APP_VERSION_FIELD_NUMBER = 1;
        public static final int CHANNEL_FIELD_NUMBER = 8;
        public static final int DEVICE_FIELD_NUMBER = 7;
        public static final int LANGUAGE_FIELD_NUMBER = 4;
        public static final int OS_VERSION_FIELD_NUMBER = 6;
        public static final int PLATFORM_FIELD_NUMBER = 3;
        public static final int TIMEZONE_FIELD_NUMBER = 5;
        private static final long serialVersionUID = 0;
        private int appVersionCode_;
        private volatile Object appVersion_;
        private volatile Object channel_;
        private volatile Object device_;
        private volatile Object language_;
        private byte memoizedIsInitialized;
        private volatile Object osVersion_;
        private volatile Object platform_;
        private volatile Object timezone_;
        private static final Common DEFAULT_INSTANCE = new Common();
        private static final Parser<Common> PARSER = new AbstractParser<Common>() { // from class: com.blued.im.CommonOuterClass.Common.1
            @Override // com.google.protobuf.Parser
            public Common parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Common(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/im/CommonOuterClass$Common$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CommonOrBuilder {
            private int appVersionCode_;
            private Object appVersion_;
            private Object channel_;
            private Object device_;
            private Object language_;
            private Object osVersion_;
            private Object platform_;
            private Object timezone_;

            private Builder() {
                this.appVersion_ = "";
                this.platform_ = "";
                this.language_ = "";
                this.timezone_ = "";
                this.osVersion_ = "";
                this.device_ = "";
                this.channel_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.appVersion_ = "";
                this.platform_ = "";
                this.language_ = "";
                this.timezone_ = "";
                this.osVersion_ = "";
                this.device_ = "";
                this.channel_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return CommonOuterClass.internal_static_com_blued_im_Common_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = Common.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Common build() {
                Common buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Common buildPartial() {
                Common common = new Common(this);
                common.appVersion_ = this.appVersion_;
                common.appVersionCode_ = this.appVersionCode_;
                common.platform_ = this.platform_;
                common.language_ = this.language_;
                common.timezone_ = this.timezone_;
                common.osVersion_ = this.osVersion_;
                common.device_ = this.device_;
                common.channel_ = this.channel_;
                onBuilt();
                return common;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.appVersion_ = "";
                this.appVersionCode_ = 0;
                this.platform_ = "";
                this.language_ = "";
                this.timezone_ = "";
                this.osVersion_ = "";
                this.device_ = "";
                this.channel_ = "";
                return this;
            }

            public Builder clearAppVersion() {
                this.appVersion_ = Common.getDefaultInstance().getAppVersion();
                onChanged();
                return this;
            }

            public Builder clearAppVersionCode() {
                this.appVersionCode_ = 0;
                onChanged();
                return this;
            }

            public Builder clearChannel() {
                this.channel_ = Common.getDefaultInstance().getChannel();
                onChanged();
                return this;
            }

            public Builder clearDevice() {
                this.device_ = Common.getDefaultInstance().getDevice();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearLanguage() {
                this.language_ = Common.getDefaultInstance().getLanguage();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearOsVersion() {
                this.osVersion_ = Common.getDefaultInstance().getOsVersion();
                onChanged();
                return this;
            }

            public Builder clearPlatform() {
                this.platform_ = Common.getDefaultInstance().getPlatform();
                onChanged();
                return this;
            }

            public Builder clearTimezone() {
                this.timezone_ = Common.getDefaultInstance().getTimezone();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo2030clone() {
                return (Builder) super.mo2030clone();
            }

            @Override // com.blued.im.CommonOuterClass.CommonOrBuilder
            public String getAppVersion() {
                Object obj = this.appVersion_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.appVersion_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.im.CommonOuterClass.CommonOrBuilder
            public ByteString getAppVersionBytes() {
                Object obj = this.appVersion_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.appVersion_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.im.CommonOuterClass.CommonOrBuilder
            public int getAppVersionCode() {
                return this.appVersionCode_;
            }

            @Override // com.blued.im.CommonOuterClass.CommonOrBuilder
            public String getChannel() {
                Object obj = this.channel_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.channel_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.im.CommonOuterClass.CommonOrBuilder
            public ByteString getChannelBytes() {
                Object obj = this.channel_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.channel_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Common getDefaultInstanceForType() {
                return Common.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CommonOuterClass.internal_static_com_blued_im_Common_descriptor;
            }

            @Override // com.blued.im.CommonOuterClass.CommonOrBuilder
            public String getDevice() {
                Object obj = this.device_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.device_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.im.CommonOuterClass.CommonOrBuilder
            public ByteString getDeviceBytes() {
                Object obj = this.device_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.device_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.im.CommonOuterClass.CommonOrBuilder
            public String getLanguage() {
                Object obj = this.language_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.language_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.im.CommonOuterClass.CommonOrBuilder
            public ByteString getLanguageBytes() {
                Object obj = this.language_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.language_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.im.CommonOuterClass.CommonOrBuilder
            public String getOsVersion() {
                Object obj = this.osVersion_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.osVersion_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.im.CommonOuterClass.CommonOrBuilder
            public ByteString getOsVersionBytes() {
                Object obj = this.osVersion_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.osVersion_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.im.CommonOuterClass.CommonOrBuilder
            public String getPlatform() {
                Object obj = this.platform_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.platform_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.im.CommonOuterClass.CommonOrBuilder
            public ByteString getPlatformBytes() {
                Object obj = this.platform_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.platform_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.im.CommonOuterClass.CommonOrBuilder
            public String getTimezone() {
                Object obj = this.timezone_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.timezone_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.im.CommonOuterClass.CommonOrBuilder
            public ByteString getTimezoneBytes() {
                Object obj = this.timezone_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.timezone_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CommonOuterClass.internal_static_com_blued_im_Common_fieldAccessorTable.ensureFieldAccessorsInitialized(Common.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(Common common) {
                if (common == Common.getDefaultInstance()) {
                    return this;
                }
                if (!common.getAppVersion().isEmpty()) {
                    this.appVersion_ = common.appVersion_;
                    onChanged();
                }
                if (common.getAppVersionCode() != 0) {
                    setAppVersionCode(common.getAppVersionCode());
                }
                if (!common.getPlatform().isEmpty()) {
                    this.platform_ = common.platform_;
                    onChanged();
                }
                if (!common.getLanguage().isEmpty()) {
                    this.language_ = common.language_;
                    onChanged();
                }
                if (!common.getTimezone().isEmpty()) {
                    this.timezone_ = common.timezone_;
                    onChanged();
                }
                if (!common.getOsVersion().isEmpty()) {
                    this.osVersion_ = common.osVersion_;
                    onChanged();
                }
                if (!common.getDevice().isEmpty()) {
                    this.device_ = common.device_;
                    onChanged();
                }
                if (!common.getChannel().isEmpty()) {
                    this.channel_ = common.channel_;
                    onChanged();
                }
                mergeUnknownFields(common.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.im.CommonOuterClass.Common.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.im.CommonOuterClass.Common.access$1500()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.im.CommonOuterClass$Common r0 = (com.blued.im.CommonOuterClass.Common) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.im.CommonOuterClass$Common$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.im.CommonOuterClass$Common r0 = (com.blued.im.CommonOuterClass.Common) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.im.CommonOuterClass$Common$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.im.CommonOuterClass.Common.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.im.CommonOuterClass$Common$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof Common) {
                    return mergeFrom((Common) message);
                }
                super.mergeFrom(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder setAppVersion(String str) {
                if (str != null) {
                    this.appVersion_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setAppVersionBytes(ByteString byteString) {
                if (byteString != null) {
                    Common.checkByteStringIsUtf8(byteString);
                    this.appVersion_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setAppVersionCode(int i) {
                this.appVersionCode_ = i;
                onChanged();
                return this;
            }

            public Builder setChannel(String str) {
                if (str != null) {
                    this.channel_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setChannelBytes(ByteString byteString) {
                if (byteString != null) {
                    Common.checkByteStringIsUtf8(byteString);
                    this.channel_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setDevice(String str) {
                if (str != null) {
                    this.device_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setDeviceBytes(ByteString byteString) {
                if (byteString != null) {
                    Common.checkByteStringIsUtf8(byteString);
                    this.device_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setLanguage(String str) {
                if (str != null) {
                    this.language_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setLanguageBytes(ByteString byteString) {
                if (byteString != null) {
                    Common.checkByteStringIsUtf8(byteString);
                    this.language_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setOsVersion(String str) {
                if (str != null) {
                    this.osVersion_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setOsVersionBytes(ByteString byteString) {
                if (byteString != null) {
                    Common.checkByteStringIsUtf8(byteString);
                    this.osVersion_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setPlatform(String str) {
                if (str != null) {
                    this.platform_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setPlatformBytes(ByteString byteString) {
                if (byteString != null) {
                    Common.checkByteStringIsUtf8(byteString);
                    this.platform_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setTimezone(String str) {
                if (str != null) {
                    this.timezone_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setTimezoneBytes(ByteString byteString) {
                if (byteString != null) {
                    Common.checkByteStringIsUtf8(byteString);
                    this.timezone_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private Common() {
            this.memoizedIsInitialized = (byte) -1;
            this.appVersion_ = "";
            this.platform_ = "";
            this.language_ = "";
            this.timezone_ = "";
            this.osVersion_ = "";
            this.device_ = "";
            this.channel_ = "";
        }

        private Common(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.appVersion_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 16) {
                                this.appVersionCode_ = codedInputStream.readInt32();
                            } else if (readTag == 26) {
                                this.platform_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 34) {
                                this.language_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 42) {
                                this.timezone_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 50) {
                                this.osVersion_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 58) {
                                this.device_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 66) {
                                this.channel_ = codedInputStream.readStringRequireUtf8();
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

        private Common(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Common getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CommonOuterClass.internal_static_com_blued_im_Common_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Common common) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(common);
        }

        public static Common parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Common) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Common parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Common) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Common parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Common parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Common parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Common) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Common parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Common) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static Common parseFrom(InputStream inputStream) throws IOException {
            return (Common) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Common parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Common) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Common parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Common parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Common parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Common parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<Common> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Common) {
                Common common = (Common) obj;
                return getAppVersion().equals(common.getAppVersion()) && getAppVersionCode() == common.getAppVersionCode() && getPlatform().equals(common.getPlatform()) && getLanguage().equals(common.getLanguage()) && getTimezone().equals(common.getTimezone()) && getOsVersion().equals(common.getOsVersion()) && getDevice().equals(common.getDevice()) && getChannel().equals(common.getChannel()) && this.unknownFields.equals(common.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.blued.im.CommonOuterClass.CommonOrBuilder
        public String getAppVersion() {
            Object obj = this.appVersion_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.appVersion_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.im.CommonOuterClass.CommonOrBuilder
        public ByteString getAppVersionBytes() {
            Object obj = this.appVersion_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.appVersion_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.im.CommonOuterClass.CommonOrBuilder
        public int getAppVersionCode() {
            return this.appVersionCode_;
        }

        @Override // com.blued.im.CommonOuterClass.CommonOrBuilder
        public String getChannel() {
            Object obj = this.channel_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.channel_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.im.CommonOuterClass.CommonOrBuilder
        public ByteString getChannelBytes() {
            Object obj = this.channel_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.channel_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Common getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.im.CommonOuterClass.CommonOrBuilder
        public String getDevice() {
            Object obj = this.device_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.device_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.im.CommonOuterClass.CommonOrBuilder
        public ByteString getDeviceBytes() {
            Object obj = this.device_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.device_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.im.CommonOuterClass.CommonOrBuilder
        public String getLanguage() {
            Object obj = this.language_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.language_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.im.CommonOuterClass.CommonOrBuilder
        public ByteString getLanguageBytes() {
            Object obj = this.language_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.language_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.im.CommonOuterClass.CommonOrBuilder
        public String getOsVersion() {
            Object obj = this.osVersion_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.osVersion_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.im.CommonOuterClass.CommonOrBuilder
        public ByteString getOsVersionBytes() {
            Object obj = this.osVersion_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.osVersion_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Common> getParserForType() {
            return PARSER;
        }

        @Override // com.blued.im.CommonOuterClass.CommonOrBuilder
        public String getPlatform() {
            Object obj = this.platform_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.platform_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.im.CommonOuterClass.CommonOrBuilder
        public ByteString getPlatformBytes() {
            Object obj = this.platform_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.platform_ = copyFromUtf8;
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
            if (!getAppVersionBytes().isEmpty()) {
                i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.appVersion_);
            }
            int i3 = this.appVersionCode_;
            int i4 = i2;
            if (i3 != 0) {
                i4 = i2 + CodedOutputStream.computeInt32Size(2, i3);
            }
            int i5 = i4;
            if (!getPlatformBytes().isEmpty()) {
                i5 = i4 + GeneratedMessageV3.computeStringSize(3, this.platform_);
            }
            int i6 = i5;
            if (!getLanguageBytes().isEmpty()) {
                i6 = i5 + GeneratedMessageV3.computeStringSize(4, this.language_);
            }
            int i7 = i6;
            if (!getTimezoneBytes().isEmpty()) {
                i7 = i6 + GeneratedMessageV3.computeStringSize(5, this.timezone_);
            }
            int i8 = i7;
            if (!getOsVersionBytes().isEmpty()) {
                i8 = i7 + GeneratedMessageV3.computeStringSize(6, this.osVersion_);
            }
            int i9 = i8;
            if (!getDeviceBytes().isEmpty()) {
                i9 = i8 + GeneratedMessageV3.computeStringSize(7, this.device_);
            }
            int i10 = i9;
            if (!getChannelBytes().isEmpty()) {
                i10 = i9 + GeneratedMessageV3.computeStringSize(8, this.channel_);
            }
            int serializedSize = i10 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.blued.im.CommonOuterClass.CommonOrBuilder
        public String getTimezone() {
            Object obj = this.timezone_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.timezone_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.im.CommonOuterClass.CommonOrBuilder
        public ByteString getTimezoneBytes() {
            Object obj = this.timezone_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.timezone_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
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
            int hashCode = ((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getAppVersion().hashCode()) * 37) + 2) * 53) + getAppVersionCode()) * 37) + 3) * 53) + getPlatform().hashCode()) * 37) + 4) * 53) + getLanguage().hashCode()) * 37) + 5) * 53) + getTimezone().hashCode()) * 37) + 6) * 53) + getOsVersion().hashCode()) * 37) + 7) * 53) + getDevice().hashCode()) * 37) + 8) * 53) + getChannel().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CommonOuterClass.internal_static_com_blued_im_Common_fieldAccessorTable.ensureFieldAccessorsInitialized(Common.class, Builder.class);
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
            return new Common();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!getAppVersionBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.appVersion_);
            }
            int i = this.appVersionCode_;
            if (i != 0) {
                codedOutputStream.writeInt32(2, i);
            }
            if (!getPlatformBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.platform_);
            }
            if (!getLanguageBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.language_);
            }
            if (!getTimezoneBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.timezone_);
            }
            if (!getOsVersionBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 6, this.osVersion_);
            }
            if (!getDeviceBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 7, this.device_);
            }
            if (!getChannelBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 8, this.channel_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/CommonOuterClass$CommonOrBuilder.class */
    public interface CommonOrBuilder extends MessageOrBuilder {
        String getAppVersion();

        ByteString getAppVersionBytes();

        int getAppVersionCode();

        String getChannel();

        ByteString getChannelBytes();

        String getDevice();

        ByteString getDeviceBytes();

        String getLanguage();

        ByteString getLanguageBytes();

        String getOsVersion();

        ByteString getOsVersionBytes();

        String getPlatform();

        ByteString getPlatformBytes();

        String getTimezone();

        ByteString getTimezoneBytes();
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_blued_im_Common_descriptor = descriptor2;
        internal_static_com_blued_im_Common_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"AppVersion", "AppVersionCode", "Platform", "Language", "Timezone", "OsVersion", "Device", "Channel"});
    }

    private CommonOuterClass() {
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
