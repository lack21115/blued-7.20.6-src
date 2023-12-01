package cn.irisgw.live;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/CommonAlert.class */
public final class CommonAlert extends GeneratedMessageV3 implements CommonAlertOrBuilder {
    public static final int CLOSE_TYPE_FIELD_NUMBER = 1;
    private static final CommonAlert DEFAULT_INSTANCE = new CommonAlert();
    private static final Parser<CommonAlert> PARSER = new AbstractParser<CommonAlert>() { // from class: cn.irisgw.live.CommonAlert.1
        @Override // com.google.protobuf.Parser
        public CommonAlert parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new CommonAlert(codedInputStream, extensionRegistryLite);
        }
    };
    public static final int RESOURCE_FIELD_NUMBER = 3;
    public static final int RESOURCE_TYPE_FIELD_NUMBER = 2;
    public static final int SHOW_CLOSE_BTN_FIELD_NUMBER = 4;
    private static final long serialVersionUID = 0;
    private int closeType_;
    private byte memoizedIsInitialized;
    private int resourceType_;
    private AlertResource resource_;
    private boolean showCloseBtn_;

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/CommonAlert$AlertCloseType.class */
    public enum AlertCloseType implements ProtocolMessageEnum {
        Manual(0),
        Auto(1),
        UNRECOGNIZED(-1);
        
        public static final int Auto_VALUE = 1;
        public static final int Manual_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<AlertCloseType> internalValueMap = new Internal.EnumLiteMap<AlertCloseType>() { // from class: cn.irisgw.live.CommonAlert.AlertCloseType.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public AlertCloseType findValueByNumber(int i) {
                return AlertCloseType.forNumber(i);
            }
        };
        private static final AlertCloseType[] VALUES = values();

        AlertCloseType(int i) {
            this.value = i;
        }

        public static AlertCloseType forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    return null;
                }
                return Auto;
            }
            return Manual;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return CommonAlert.getDescriptor().getEnumTypes().get(1);
        }

        public static Internal.EnumLiteMap<AlertCloseType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static AlertCloseType valueOf(int i) {
            return forNumber(i);
        }

        public static AlertCloseType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/CommonAlert$AlertJumpType.class */
    public enum AlertJumpType implements ProtocolMessageEnum {
        None(0),
        Url(1),
        LiveRoom(2),
        Recharge(3),
        Goods(4),
        Package(5),
        Tools(6),
        Interactive(7),
        UNRECOGNIZED(-1);
        
        public static final int Goods_VALUE = 4;
        public static final int Interactive_VALUE = 7;
        public static final int LiveRoom_VALUE = 2;
        public static final int None_VALUE = 0;
        public static final int Package_VALUE = 5;
        public static final int Recharge_VALUE = 3;
        public static final int Tools_VALUE = 6;
        public static final int Url_VALUE = 1;
        private final int value;
        private static final Internal.EnumLiteMap<AlertJumpType> internalValueMap = new Internal.EnumLiteMap<AlertJumpType>() { // from class: cn.irisgw.live.CommonAlert.AlertJumpType.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public AlertJumpType findValueByNumber(int i) {
                return AlertJumpType.forNumber(i);
            }
        };
        private static final AlertJumpType[] VALUES = values();

        AlertJumpType(int i) {
            this.value = i;
        }

        public static AlertJumpType forNumber(int i) {
            switch (i) {
                case 0:
                    return None;
                case 1:
                    return Url;
                case 2:
                    return LiveRoom;
                case 3:
                    return Recharge;
                case 4:
                    return Goods;
                case 5:
                    return Package;
                case 6:
                    return Tools;
                case 7:
                    return Interactive;
                default:
                    return null;
            }
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return CommonAlert.getDescriptor().getEnumTypes().get(0);
        }

        public static Internal.EnumLiteMap<AlertJumpType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static AlertJumpType valueOf(int i) {
            return forNumber(i);
        }

        public static AlertJumpType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/CommonAlert$AlertResource.class */
    public static final class AlertResource extends GeneratedMessageV3 implements AlertResourceOrBuilder {
        public static final int JUMP_TYPE_FIELD_NUMBER = 4;
        public static final int JUMP_UID_FIELD_NUMBER = 2;
        public static final int JUMP_URL_FIELD_NUMBER = 3;
        public static final int LINK_FIELD_NUMBER = 5;
        public static final int LINK_TYPE_FIELD_NUMBER = 6;
        public static final int URL_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int jumpType_;
        private int jumpUid_;
        private volatile Object jumpUrl_;
        private int linkType_;
        private volatile Object link_;
        private byte memoizedIsInitialized;
        private volatile Object url_;
        private static final AlertResource DEFAULT_INSTANCE = new AlertResource();
        private static final Parser<AlertResource> PARSER = new AbstractParser<AlertResource>() { // from class: cn.irisgw.live.CommonAlert.AlertResource.1
            @Override // com.google.protobuf.Parser
            public AlertResource parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new AlertResource(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/CommonAlert$AlertResource$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AlertResourceOrBuilder {
            private int jumpType_;
            private int jumpUid_;
            private Object jumpUrl_;
            private int linkType_;
            private Object link_;
            private Object url_;

            private Builder() {
                this.url_ = "";
                this.jumpUrl_ = "";
                this.jumpType_ = 0;
                this.link_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.url_ = "";
                this.jumpUrl_ = "";
                this.jumpType_ = 0;
                this.link_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LiveConstants.internal_static_cn_irisgw_live_CommonAlert_AlertResource_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = AlertResource.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AlertResource build() {
                AlertResource buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AlertResource buildPartial() {
                AlertResource alertResource = new AlertResource(this);
                alertResource.url_ = this.url_;
                alertResource.jumpUid_ = this.jumpUid_;
                alertResource.jumpUrl_ = this.jumpUrl_;
                alertResource.jumpType_ = this.jumpType_;
                alertResource.link_ = this.link_;
                alertResource.linkType_ = this.linkType_;
                onBuilt();
                return alertResource;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.url_ = "";
                this.jumpUid_ = 0;
                this.jumpUrl_ = "";
                this.jumpType_ = 0;
                this.link_ = "";
                this.linkType_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearJumpType() {
                this.jumpType_ = 0;
                onChanged();
                return this;
            }

            public Builder clearJumpUid() {
                this.jumpUid_ = 0;
                onChanged();
                return this;
            }

            public Builder clearJumpUrl() {
                this.jumpUrl_ = AlertResource.getDefaultInstance().getJumpUrl();
                onChanged();
                return this;
            }

            public Builder clearLink() {
                this.link_ = AlertResource.getDefaultInstance().getLink();
                onChanged();
                return this;
            }

            public Builder clearLinkType() {
                this.linkType_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearUrl() {
                this.url_ = AlertResource.getDefaultInstance().getUrl();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1800clone() {
                return (Builder) super.mo1800clone();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AlertResource getDefaultInstanceForType() {
                return AlertResource.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return LiveConstants.internal_static_cn_irisgw_live_CommonAlert_AlertResource_descriptor;
            }

            @Override // cn.irisgw.live.CommonAlert.AlertResourceOrBuilder
            public AlertJumpType getJumpType() {
                AlertJumpType valueOf = AlertJumpType.valueOf(this.jumpType_);
                AlertJumpType alertJumpType = valueOf;
                if (valueOf == null) {
                    alertJumpType = AlertJumpType.UNRECOGNIZED;
                }
                return alertJumpType;
            }

            @Override // cn.irisgw.live.CommonAlert.AlertResourceOrBuilder
            public int getJumpTypeValue() {
                return this.jumpType_;
            }

            @Override // cn.irisgw.live.CommonAlert.AlertResourceOrBuilder
            public int getJumpUid() {
                return this.jumpUid_;
            }

            @Override // cn.irisgw.live.CommonAlert.AlertResourceOrBuilder
            public String getJumpUrl() {
                Object obj = this.jumpUrl_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.jumpUrl_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.CommonAlert.AlertResourceOrBuilder
            public ByteString getJumpUrlBytes() {
                Object obj = this.jumpUrl_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.jumpUrl_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.CommonAlert.AlertResourceOrBuilder
            public String getLink() {
                Object obj = this.link_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.link_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.CommonAlert.AlertResourceOrBuilder
            public ByteString getLinkBytes() {
                Object obj = this.link_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.link_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.CommonAlert.AlertResourceOrBuilder
            public int getLinkType() {
                return this.linkType_;
            }

            @Override // cn.irisgw.live.CommonAlert.AlertResourceOrBuilder
            public String getUrl() {
                Object obj = this.url_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.url_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.CommonAlert.AlertResourceOrBuilder
            public ByteString getUrlBytes() {
                Object obj = this.url_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.url_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveConstants.internal_static_cn_irisgw_live_CommonAlert_AlertResource_fieldAccessorTable.ensureFieldAccessorsInitialized(AlertResource.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(AlertResource alertResource) {
                if (alertResource == AlertResource.getDefaultInstance()) {
                    return this;
                }
                if (!alertResource.getUrl().isEmpty()) {
                    this.url_ = alertResource.url_;
                    onChanged();
                }
                if (alertResource.getJumpUid() != 0) {
                    setJumpUid(alertResource.getJumpUid());
                }
                if (!alertResource.getJumpUrl().isEmpty()) {
                    this.jumpUrl_ = alertResource.jumpUrl_;
                    onChanged();
                }
                if (alertResource.jumpType_ != 0) {
                    setJumpTypeValue(alertResource.getJumpTypeValue());
                }
                if (!alertResource.getLink().isEmpty()) {
                    this.link_ = alertResource.link_;
                    onChanged();
                }
                if (alertResource.getLinkType() != 0) {
                    setLinkType(alertResource.getLinkType());
                }
                mergeUnknownFields(alertResource.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.CommonAlert.AlertResource.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.CommonAlert.AlertResource.access$1100()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.CommonAlert$AlertResource r0 = (cn.irisgw.live.CommonAlert.AlertResource) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.CommonAlert$AlertResource$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.CommonAlert$AlertResource r0 = (cn.irisgw.live.CommonAlert.AlertResource) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.CommonAlert$AlertResource$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.CommonAlert.AlertResource.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.CommonAlert$AlertResource$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof AlertResource) {
                    return mergeFrom((AlertResource) message);
                }
                super.mergeFrom(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setJumpType(AlertJumpType alertJumpType) {
                if (alertJumpType != null) {
                    this.jumpType_ = alertJumpType.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setJumpTypeValue(int i) {
                this.jumpType_ = i;
                onChanged();
                return this;
            }

            public Builder setJumpUid(int i) {
                this.jumpUid_ = i;
                onChanged();
                return this;
            }

            public Builder setJumpUrl(String str) {
                if (str != null) {
                    this.jumpUrl_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setJumpUrlBytes(ByteString byteString) {
                if (byteString != null) {
                    AlertResource.checkByteStringIsUtf8(byteString);
                    this.jumpUrl_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setLink(String str) {
                if (str != null) {
                    this.link_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setLinkBytes(ByteString byteString) {
                if (byteString != null) {
                    AlertResource.checkByteStringIsUtf8(byteString);
                    this.link_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setLinkType(int i) {
                this.linkType_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            public Builder setUrl(String str) {
                if (str != null) {
                    this.url_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setUrlBytes(ByteString byteString) {
                if (byteString != null) {
                    AlertResource.checkByteStringIsUtf8(byteString);
                    this.url_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }
        }

        private AlertResource() {
            this.memoizedIsInitialized = (byte) -1;
            this.url_ = "";
            this.jumpUrl_ = "";
            this.jumpType_ = 0;
            this.link_ = "";
        }

        private AlertResource(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.url_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 16) {
                                this.jumpUid_ = codedInputStream.readUInt32();
                            } else if (readTag == 26) {
                                this.jumpUrl_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 32) {
                                this.jumpType_ = codedInputStream.readEnum();
                            } else if (readTag == 42) {
                                this.link_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 48) {
                                this.linkType_ = codedInputStream.readUInt32();
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

        private AlertResource(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static AlertResource getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_CommonAlert_AlertResource_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AlertResource alertResource) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(alertResource);
        }

        public static AlertResource parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AlertResource) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static AlertResource parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AlertResource) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AlertResource parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static AlertResource parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static AlertResource parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AlertResource) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static AlertResource parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AlertResource) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static AlertResource parseFrom(InputStream inputStream) throws IOException {
            return (AlertResource) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static AlertResource parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AlertResource) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static AlertResource parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static AlertResource parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static AlertResource parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static AlertResource parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<AlertResource> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof AlertResource) {
                AlertResource alertResource = (AlertResource) obj;
                return getUrl().equals(alertResource.getUrl()) && getJumpUid() == alertResource.getJumpUid() && getJumpUrl().equals(alertResource.getJumpUrl()) && this.jumpType_ == alertResource.jumpType_ && getLink().equals(alertResource.getLink()) && getLinkType() == alertResource.getLinkType() && this.unknownFields.equals(alertResource.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AlertResource getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // cn.irisgw.live.CommonAlert.AlertResourceOrBuilder
        public AlertJumpType getJumpType() {
            AlertJumpType valueOf = AlertJumpType.valueOf(this.jumpType_);
            AlertJumpType alertJumpType = valueOf;
            if (valueOf == null) {
                alertJumpType = AlertJumpType.UNRECOGNIZED;
            }
            return alertJumpType;
        }

        @Override // cn.irisgw.live.CommonAlert.AlertResourceOrBuilder
        public int getJumpTypeValue() {
            return this.jumpType_;
        }

        @Override // cn.irisgw.live.CommonAlert.AlertResourceOrBuilder
        public int getJumpUid() {
            return this.jumpUid_;
        }

        @Override // cn.irisgw.live.CommonAlert.AlertResourceOrBuilder
        public String getJumpUrl() {
            Object obj = this.jumpUrl_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.jumpUrl_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.CommonAlert.AlertResourceOrBuilder
        public ByteString getJumpUrlBytes() {
            Object obj = this.jumpUrl_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.jumpUrl_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.CommonAlert.AlertResourceOrBuilder
        public String getLink() {
            Object obj = this.link_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.link_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.CommonAlert.AlertResourceOrBuilder
        public ByteString getLinkBytes() {
            Object obj = this.link_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.link_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.CommonAlert.AlertResourceOrBuilder
        public int getLinkType() {
            return this.linkType_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AlertResource> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (!getUrlBytes().isEmpty()) {
                i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.url_);
            }
            int i3 = this.jumpUid_;
            int i4 = i2;
            if (i3 != 0) {
                i4 = i2 + CodedOutputStream.computeUInt32Size(2, i3);
            }
            int i5 = i4;
            if (!getJumpUrlBytes().isEmpty()) {
                i5 = i4 + GeneratedMessageV3.computeStringSize(3, this.jumpUrl_);
            }
            int i6 = i5;
            if (this.jumpType_ != AlertJumpType.None.getNumber()) {
                i6 = i5 + CodedOutputStream.computeEnumSize(4, this.jumpType_);
            }
            int i7 = i6;
            if (!getLinkBytes().isEmpty()) {
                i7 = i6 + GeneratedMessageV3.computeStringSize(5, this.link_);
            }
            int i8 = this.linkType_;
            int i9 = i7;
            if (i8 != 0) {
                i9 = i7 + CodedOutputStream.computeUInt32Size(6, i8);
            }
            int serializedSize = i9 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // cn.irisgw.live.CommonAlert.AlertResourceOrBuilder
        public String getUrl() {
            Object obj = this.url_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.url_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.CommonAlert.AlertResourceOrBuilder
        public ByteString getUrlBytes() {
            Object obj = this.url_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.url_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getUrl().hashCode()) * 37) + 2) * 53) + getJumpUid()) * 37) + 3) * 53) + getJumpUrl().hashCode()) * 37) + 4) * 53) + this.jumpType_) * 37) + 5) * 53) + getLink().hashCode()) * 37) + 6) * 53) + getLinkType()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_CommonAlert_AlertResource_fieldAccessorTable.ensureFieldAccessorsInitialized(AlertResource.class, Builder.class);
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
            return new AlertResource();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!getUrlBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.url_);
            }
            int i = this.jumpUid_;
            if (i != 0) {
                codedOutputStream.writeUInt32(2, i);
            }
            if (!getJumpUrlBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.jumpUrl_);
            }
            if (this.jumpType_ != AlertJumpType.None.getNumber()) {
                codedOutputStream.writeEnum(4, this.jumpType_);
            }
            if (!getLinkBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.link_);
            }
            int i2 = this.linkType_;
            if (i2 != 0) {
                codedOutputStream.writeUInt32(6, i2);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/CommonAlert$AlertResourceOrBuilder.class */
    public interface AlertResourceOrBuilder extends MessageOrBuilder {
        AlertJumpType getJumpType();

        int getJumpTypeValue();

        int getJumpUid();

        String getJumpUrl();

        ByteString getJumpUrlBytes();

        String getLink();

        ByteString getLinkBytes();

        int getLinkType();

        String getUrl();

        ByteString getUrlBytes();
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/CommonAlert$AlertResourceType.class */
    public enum AlertResourceType implements ProtocolMessageEnum {
        Static(0),
        Web(1),
        UNRECOGNIZED(-1);
        
        public static final int Static_VALUE = 0;
        public static final int Web_VALUE = 1;
        private final int value;
        private static final Internal.EnumLiteMap<AlertResourceType> internalValueMap = new Internal.EnumLiteMap<AlertResourceType>() { // from class: cn.irisgw.live.CommonAlert.AlertResourceType.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public AlertResourceType findValueByNumber(int i) {
                return AlertResourceType.forNumber(i);
            }
        };
        private static final AlertResourceType[] VALUES = values();

        AlertResourceType(int i) {
            this.value = i;
        }

        public static AlertResourceType forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    return null;
                }
                return Web;
            }
            return Static;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return CommonAlert.getDescriptor().getEnumTypes().get(2);
        }

        public static Internal.EnumLiteMap<AlertResourceType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static AlertResourceType valueOf(int i) {
            return forNumber(i);
        }

        public static AlertResourceType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/CommonAlert$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CommonAlertOrBuilder {
        private int closeType_;
        private SingleFieldBuilderV3<AlertResource, AlertResource.Builder, AlertResourceOrBuilder> resourceBuilder_;
        private int resourceType_;
        private AlertResource resource_;
        private boolean showCloseBtn_;

        private Builder() {
            this.closeType_ = 0;
            this.resourceType_ = 0;
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.closeType_ = 0;
            this.resourceType_ = 0;
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_CommonAlert_descriptor;
        }

        private SingleFieldBuilderV3<AlertResource, AlertResource.Builder, AlertResourceOrBuilder> getResourceFieldBuilder() {
            if (this.resourceBuilder_ == null) {
                this.resourceBuilder_ = new SingleFieldBuilderV3<>(getResource(), getParentForChildren(), isClean());
                this.resource_ = null;
            }
            return this.resourceBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = CommonAlert.alwaysUseFieldBuilders;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CommonAlert build() {
            CommonAlert buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CommonAlert buildPartial() {
            CommonAlert commonAlert = new CommonAlert(this);
            commonAlert.closeType_ = this.closeType_;
            commonAlert.resourceType_ = this.resourceType_;
            SingleFieldBuilderV3<AlertResource, AlertResource.Builder, AlertResourceOrBuilder> singleFieldBuilderV3 = this.resourceBuilder_;
            if (singleFieldBuilderV3 == null) {
                commonAlert.resource_ = this.resource_;
            } else {
                commonAlert.resource_ = singleFieldBuilderV3.build();
            }
            commonAlert.showCloseBtn_ = this.showCloseBtn_;
            onBuilt();
            return commonAlert;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.closeType_ = 0;
            this.resourceType_ = 0;
            if (this.resourceBuilder_ == null) {
                this.resource_ = null;
            } else {
                this.resource_ = null;
                this.resourceBuilder_ = null;
            }
            this.showCloseBtn_ = false;
            return this;
        }

        public Builder clearCloseType() {
            this.closeType_ = 0;
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

        public Builder clearResource() {
            if (this.resourceBuilder_ == null) {
                this.resource_ = null;
                onChanged();
                return this;
            }
            this.resource_ = null;
            this.resourceBuilder_ = null;
            return this;
        }

        public Builder clearResourceType() {
            this.resourceType_ = 0;
            onChanged();
            return this;
        }

        public Builder clearShowCloseBtn() {
            this.showCloseBtn_ = false;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo1800clone() {
            return (Builder) super.mo1800clone();
        }

        @Override // cn.irisgw.live.CommonAlertOrBuilder
        public AlertCloseType getCloseType() {
            AlertCloseType valueOf = AlertCloseType.valueOf(this.closeType_);
            AlertCloseType alertCloseType = valueOf;
            if (valueOf == null) {
                alertCloseType = AlertCloseType.UNRECOGNIZED;
            }
            return alertCloseType;
        }

        @Override // cn.irisgw.live.CommonAlertOrBuilder
        public int getCloseTypeValue() {
            return this.closeType_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CommonAlert getDefaultInstanceForType() {
            return CommonAlert.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_CommonAlert_descriptor;
        }

        @Override // cn.irisgw.live.CommonAlertOrBuilder
        public AlertResource getResource() {
            SingleFieldBuilderV3<AlertResource, AlertResource.Builder, AlertResourceOrBuilder> singleFieldBuilderV3 = this.resourceBuilder_;
            if (singleFieldBuilderV3 == null) {
                AlertResource alertResource = this.resource_;
                AlertResource alertResource2 = alertResource;
                if (alertResource == null) {
                    alertResource2 = AlertResource.getDefaultInstance();
                }
                return alertResource2;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public AlertResource.Builder getResourceBuilder() {
            onChanged();
            return getResourceFieldBuilder().getBuilder();
        }

        @Override // cn.irisgw.live.CommonAlertOrBuilder
        public AlertResourceOrBuilder getResourceOrBuilder() {
            SingleFieldBuilderV3<AlertResource, AlertResource.Builder, AlertResourceOrBuilder> singleFieldBuilderV3 = this.resourceBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            AlertResource alertResource = this.resource_;
            AlertResource alertResource2 = alertResource;
            if (alertResource == null) {
                alertResource2 = AlertResource.getDefaultInstance();
            }
            return alertResource2;
        }

        @Override // cn.irisgw.live.CommonAlertOrBuilder
        public AlertResourceType getResourceType() {
            AlertResourceType valueOf = AlertResourceType.valueOf(this.resourceType_);
            AlertResourceType alertResourceType = valueOf;
            if (valueOf == null) {
                alertResourceType = AlertResourceType.UNRECOGNIZED;
            }
            return alertResourceType;
        }

        @Override // cn.irisgw.live.CommonAlertOrBuilder
        public int getResourceTypeValue() {
            return this.resourceType_;
        }

        @Override // cn.irisgw.live.CommonAlertOrBuilder
        public boolean getShowCloseBtn() {
            return this.showCloseBtn_;
        }

        @Override // cn.irisgw.live.CommonAlertOrBuilder
        public boolean hasResource() {
            return (this.resourceBuilder_ == null && this.resource_ == null) ? false : true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_CommonAlert_fieldAccessorTable.ensureFieldAccessorsInitialized(CommonAlert.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(CommonAlert commonAlert) {
            if (commonAlert == CommonAlert.getDefaultInstance()) {
                return this;
            }
            if (commonAlert.closeType_ != 0) {
                setCloseTypeValue(commonAlert.getCloseTypeValue());
            }
            if (commonAlert.resourceType_ != 0) {
                setResourceTypeValue(commonAlert.getResourceTypeValue());
            }
            if (commonAlert.hasResource()) {
                mergeResource(commonAlert.getResource());
            }
            if (commonAlert.getShowCloseBtn()) {
                setShowCloseBtn(commonAlert.getShowCloseBtn());
            }
            mergeUnknownFields(commonAlert.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.CommonAlert.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.CommonAlert.access$2500()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.CommonAlert r0 = (cn.irisgw.live.CommonAlert) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.CommonAlert$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.CommonAlert r0 = (cn.irisgw.live.CommonAlert) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.CommonAlert$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.CommonAlert.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.CommonAlert$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof CommonAlert) {
                return mergeFrom((CommonAlert) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeResource(AlertResource alertResource) {
            SingleFieldBuilderV3<AlertResource, AlertResource.Builder, AlertResourceOrBuilder> singleFieldBuilderV3 = this.resourceBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.mergeFrom(alertResource);
                return this;
            }
            AlertResource alertResource2 = this.resource_;
            if (alertResource2 != null) {
                this.resource_ = AlertResource.newBuilder(alertResource2).mergeFrom(alertResource).buildPartial();
            } else {
                this.resource_ = alertResource;
            }
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setCloseType(AlertCloseType alertCloseType) {
            if (alertCloseType != null) {
                this.closeType_ = alertCloseType.getNumber();
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setCloseTypeValue(int i) {
            this.closeType_ = i;
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

        public Builder setResource(AlertResource.Builder builder) {
            SingleFieldBuilderV3<AlertResource, AlertResource.Builder, AlertResourceOrBuilder> singleFieldBuilderV3 = this.resourceBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(builder.build());
                return this;
            }
            this.resource_ = builder.build();
            onChanged();
            return this;
        }

        public Builder setResource(AlertResource alertResource) {
            SingleFieldBuilderV3<AlertResource, AlertResource.Builder, AlertResourceOrBuilder> singleFieldBuilderV3 = this.resourceBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(alertResource);
                return this;
            } else if (alertResource != null) {
                this.resource_ = alertResource;
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder setResourceType(AlertResourceType alertResourceType) {
            if (alertResourceType != null) {
                this.resourceType_ = alertResourceType.getNumber();
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setResourceTypeValue(int i) {
            this.resourceType_ = i;
            onChanged();
            return this;
        }

        public Builder setShowCloseBtn(boolean z) {
            this.showCloseBtn_ = z;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private CommonAlert() {
        this.memoizedIsInitialized = (byte) -1;
        this.closeType_ = 0;
        this.resourceType_ = 0;
    }

    private CommonAlert(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.closeType_ = codedInputStream.readEnum();
                        } else if (readTag == 16) {
                            this.resourceType_ = codedInputStream.readEnum();
                        } else if (readTag == 26) {
                            AlertResource.Builder builder = this.resource_ != null ? this.resource_.toBuilder() : null;
                            AlertResource alertResource = (AlertResource) codedInputStream.readMessage(AlertResource.parser(), extensionRegistryLite);
                            this.resource_ = alertResource;
                            if (builder != null) {
                                builder.mergeFrom(alertResource);
                                this.resource_ = builder.buildPartial();
                            }
                        } else if (readTag == 32) {
                            this.showCloseBtn_ = codedInputStream.readBool();
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

    private CommonAlert(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static CommonAlert getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_CommonAlert_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(CommonAlert commonAlert) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(commonAlert);
    }

    public static CommonAlert parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (CommonAlert) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static CommonAlert parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CommonAlert) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static CommonAlert parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static CommonAlert parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static CommonAlert parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (CommonAlert) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static CommonAlert parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CommonAlert) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static CommonAlert parseFrom(InputStream inputStream) throws IOException {
        return (CommonAlert) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static CommonAlert parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CommonAlert) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static CommonAlert parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static CommonAlert parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static CommonAlert parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static CommonAlert parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<CommonAlert> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CommonAlert) {
            CommonAlert commonAlert = (CommonAlert) obj;
            if (this.closeType_ == commonAlert.closeType_ && this.resourceType_ == commonAlert.resourceType_ && hasResource() == commonAlert.hasResource()) {
                return (!hasResource() || getResource().equals(commonAlert.getResource())) && getShowCloseBtn() == commonAlert.getShowCloseBtn() && this.unknownFields.equals(commonAlert.unknownFields);
            }
            return false;
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.CommonAlertOrBuilder
    public AlertCloseType getCloseType() {
        AlertCloseType valueOf = AlertCloseType.valueOf(this.closeType_);
        AlertCloseType alertCloseType = valueOf;
        if (valueOf == null) {
            alertCloseType = AlertCloseType.UNRECOGNIZED;
        }
        return alertCloseType;
    }

    @Override // cn.irisgw.live.CommonAlertOrBuilder
    public int getCloseTypeValue() {
        return this.closeType_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public CommonAlert getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<CommonAlert> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.CommonAlertOrBuilder
    public AlertResource getResource() {
        AlertResource alertResource = this.resource_;
        AlertResource alertResource2 = alertResource;
        if (alertResource == null) {
            alertResource2 = AlertResource.getDefaultInstance();
        }
        return alertResource2;
    }

    @Override // cn.irisgw.live.CommonAlertOrBuilder
    public AlertResourceOrBuilder getResourceOrBuilder() {
        return getResource();
    }

    @Override // cn.irisgw.live.CommonAlertOrBuilder
    public AlertResourceType getResourceType() {
        AlertResourceType valueOf = AlertResourceType.valueOf(this.resourceType_);
        AlertResourceType alertResourceType = valueOf;
        if (valueOf == null) {
            alertResourceType = AlertResourceType.UNRECOGNIZED;
        }
        return alertResourceType;
    }

    @Override // cn.irisgw.live.CommonAlertOrBuilder
    public int getResourceTypeValue() {
        return this.resourceType_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.closeType_ != AlertCloseType.Manual.getNumber()) {
            i2 = 0 + CodedOutputStream.computeEnumSize(1, this.closeType_);
        }
        int i3 = i2;
        if (this.resourceType_ != AlertResourceType.Static.getNumber()) {
            i3 = i2 + CodedOutputStream.computeEnumSize(2, this.resourceType_);
        }
        int i4 = i3;
        if (this.resource_ != null) {
            i4 = i3 + CodedOutputStream.computeMessageSize(3, getResource());
        }
        boolean z = this.showCloseBtn_;
        int i5 = i4;
        if (z) {
            i5 = i4 + CodedOutputStream.computeBoolSize(4, z);
        }
        int serializedSize = i5 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.CommonAlertOrBuilder
    public boolean getShowCloseBtn() {
        return this.showCloseBtn_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // cn.irisgw.live.CommonAlertOrBuilder
    public boolean hasResource() {
        return this.resource_ != null;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.closeType_) * 37) + 2) * 53) + this.resourceType_;
        int i = hashCode;
        if (hasResource()) {
            i = (((hashCode * 37) + 3) * 53) + getResource().hashCode();
        }
        int hashBoolean = (((((i * 37) + 4) * 53) + Internal.hashBoolean(getShowCloseBtn())) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashBoolean;
        return hashBoolean;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_CommonAlert_fieldAccessorTable.ensureFieldAccessorsInitialized(CommonAlert.class, Builder.class);
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
        return new CommonAlert();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (this.closeType_ != AlertCloseType.Manual.getNumber()) {
            codedOutputStream.writeEnum(1, this.closeType_);
        }
        if (this.resourceType_ != AlertResourceType.Static.getNumber()) {
            codedOutputStream.writeEnum(2, this.resourceType_);
        }
        if (this.resource_ != null) {
            codedOutputStream.writeMessage(3, getResource());
        }
        boolean z = this.showCloseBtn_;
        if (z) {
            codedOutputStream.writeBool(4, z);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
