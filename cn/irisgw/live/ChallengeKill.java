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
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ChallengeKill.class */
public final class ChallengeKill extends GeneratedMessageV3 implements ChallengeKillOrBuilder {
    public static final int ACTIVE_TYPE_FIELD_NUMBER = 4;
    public static final int COUNTDOWN_FIELD_NUMBER = 2;
    public static final int GREATER_SCORE_FIELD_NUMBER = 3;
    public static final int TYPE_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private int activeType_;
    private int countdown_;
    private int greaterScore_;
    private byte memoizedIsInitialized;
    private int type_;
    private static final ChallengeKill DEFAULT_INSTANCE = new ChallengeKill();
    private static final Parser<ChallengeKill> PARSER = new AbstractParser<ChallengeKill>() { // from class: cn.irisgw.live.ChallengeKill.1
        @Override // com.google.protobuf.Parser
        public ChallengeKill parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new ChallengeKill(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ChallengeKill$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ChallengeKillOrBuilder {
        private int activeType_;
        private int countdown_;
        private int greaterScore_;
        private int type_;

        private Builder() {
            this.type_ = 0;
            this.activeType_ = 0;
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.type_ = 0;
            this.activeType_ = 0;
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_ChallengeKill_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = ChallengeKill.alwaysUseFieldBuilders;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ChallengeKill build() {
            ChallengeKill buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ChallengeKill buildPartial() {
            ChallengeKill challengeKill = new ChallengeKill(this);
            challengeKill.type_ = this.type_;
            challengeKill.countdown_ = this.countdown_;
            challengeKill.greaterScore_ = this.greaterScore_;
            challengeKill.activeType_ = this.activeType_;
            onBuilt();
            return challengeKill;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.type_ = 0;
            this.countdown_ = 0;
            this.greaterScore_ = 0;
            this.activeType_ = 0;
            return this;
        }

        public Builder clearActiveType() {
            this.activeType_ = 0;
            onChanged();
            return this;
        }

        public Builder clearCountdown() {
            this.countdown_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearGreaterScore() {
            this.greaterScore_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearType() {
            this.type_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo1800clone() {
            return (Builder) super.mo1800clone();
        }

        @Override // cn.irisgw.live.ChallengeKillOrBuilder
        public ChallengeKillActiveType getActiveType() {
            ChallengeKillActiveType valueOf = ChallengeKillActiveType.valueOf(this.activeType_);
            ChallengeKillActiveType challengeKillActiveType = valueOf;
            if (valueOf == null) {
                challengeKillActiveType = ChallengeKillActiveType.UNRECOGNIZED;
            }
            return challengeKillActiveType;
        }

        @Override // cn.irisgw.live.ChallengeKillOrBuilder
        public int getActiveTypeValue() {
            return this.activeType_;
        }

        @Override // cn.irisgw.live.ChallengeKillOrBuilder
        public int getCountdown() {
            return this.countdown_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ChallengeKill getDefaultInstanceForType() {
            return ChallengeKill.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_ChallengeKill_descriptor;
        }

        @Override // cn.irisgw.live.ChallengeKillOrBuilder
        public int getGreaterScore() {
            return this.greaterScore_;
        }

        @Override // cn.irisgw.live.ChallengeKillOrBuilder
        public ChallengeKillType getType() {
            ChallengeKillType valueOf = ChallengeKillType.valueOf(this.type_);
            ChallengeKillType challengeKillType = valueOf;
            if (valueOf == null) {
                challengeKillType = ChallengeKillType.UNRECOGNIZED;
            }
            return challengeKillType;
        }

        @Override // cn.irisgw.live.ChallengeKillOrBuilder
        public int getTypeValue() {
            return this.type_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_ChallengeKill_fieldAccessorTable.ensureFieldAccessorsInitialized(ChallengeKill.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(ChallengeKill challengeKill) {
            if (challengeKill == ChallengeKill.getDefaultInstance()) {
                return this;
            }
            if (challengeKill.type_ != 0) {
                setTypeValue(challengeKill.getTypeValue());
            }
            if (challengeKill.getCountdown() != 0) {
                setCountdown(challengeKill.getCountdown());
            }
            if (challengeKill.getGreaterScore() != 0) {
                setGreaterScore(challengeKill.getGreaterScore());
            }
            if (challengeKill.activeType_ != 0) {
                setActiveTypeValue(challengeKill.getActiveTypeValue());
            }
            mergeUnknownFields(challengeKill.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.ChallengeKill.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.ChallengeKill.access$900()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.ChallengeKill r0 = (cn.irisgw.live.ChallengeKill) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.ChallengeKill$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.ChallengeKill r0 = (cn.irisgw.live.ChallengeKill) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.ChallengeKill$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.ChallengeKill.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.ChallengeKill$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof ChallengeKill) {
                return mergeFrom((ChallengeKill) message);
            }
            super.mergeFrom(message);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setActiveType(ChallengeKillActiveType challengeKillActiveType) {
            if (challengeKillActiveType != null) {
                this.activeType_ = challengeKillActiveType.getNumber();
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setActiveTypeValue(int i) {
            this.activeType_ = i;
            onChanged();
            return this;
        }

        public Builder setCountdown(int i) {
            this.countdown_ = i;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setGreaterScore(int i) {
            this.greaterScore_ = i;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setType(ChallengeKillType challengeKillType) {
            if (challengeKillType != null) {
                this.type_ = challengeKillType.getNumber();
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setTypeValue(int i) {
            this.type_ = i;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ChallengeKill$ChallengeKillActiveType.class */
    public enum ChallengeKillActiveType implements ProtocolMessageEnum {
        None(0),
        KillTarget(1),
        KillSelf(2),
        UNRECOGNIZED(-1);
        
        public static final int KillSelf_VALUE = 2;
        public static final int KillTarget_VALUE = 1;
        public static final int None_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<ChallengeKillActiveType> internalValueMap = new Internal.EnumLiteMap<ChallengeKillActiveType>() { // from class: cn.irisgw.live.ChallengeKill.ChallengeKillActiveType.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public ChallengeKillActiveType findValueByNumber(int i) {
                return ChallengeKillActiveType.forNumber(i);
            }
        };
        private static final ChallengeKillActiveType[] VALUES = values();

        ChallengeKillActiveType(int i) {
            this.value = i;
        }

        public static ChallengeKillActiveType forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return null;
                    }
                    return KillSelf;
                }
                return KillTarget;
            }
            return None;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return ChallengeKill.getDescriptor().getEnumTypes().get(1);
        }

        public static Internal.EnumLiteMap<ChallengeKillActiveType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static ChallengeKillActiveType valueOf(int i) {
            return forNumber(i);
        }

        public static ChallengeKillActiveType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ChallengeKill$ChallengeKillType.class */
    public enum ChallengeKillType implements ProtocolMessageEnum {
        Default(0),
        Open(1),
        Close(2),
        UNRECOGNIZED(-1);
        
        public static final int Close_VALUE = 2;
        public static final int Default_VALUE = 0;
        public static final int Open_VALUE = 1;
        private final int value;
        private static final Internal.EnumLiteMap<ChallengeKillType> internalValueMap = new Internal.EnumLiteMap<ChallengeKillType>() { // from class: cn.irisgw.live.ChallengeKill.ChallengeKillType.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public ChallengeKillType findValueByNumber(int i) {
                return ChallengeKillType.forNumber(i);
            }
        };
        private static final ChallengeKillType[] VALUES = values();

        ChallengeKillType(int i) {
            this.value = i;
        }

        public static ChallengeKillType forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return null;
                    }
                    return Close;
                }
                return Open;
            }
            return Default;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return ChallengeKill.getDescriptor().getEnumTypes().get(0);
        }

        public static Internal.EnumLiteMap<ChallengeKillType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static ChallengeKillType valueOf(int i) {
            return forNumber(i);
        }

        public static ChallengeKillType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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

    private ChallengeKill() {
        this.memoizedIsInitialized = (byte) -1;
        this.type_ = 0;
        this.activeType_ = 0;
    }

    private ChallengeKill(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.type_ = codedInputStream.readEnum();
                        } else if (readTag == 16) {
                            this.countdown_ = codedInputStream.readUInt32();
                        } else if (readTag == 24) {
                            this.greaterScore_ = codedInputStream.readUInt32();
                        } else if (readTag == 32) {
                            this.activeType_ = codedInputStream.readEnum();
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

    private ChallengeKill(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static ChallengeKill getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_ChallengeKill_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ChallengeKill challengeKill) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(challengeKill);
    }

    public static ChallengeKill parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ChallengeKill) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static ChallengeKill parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ChallengeKill) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ChallengeKill parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static ChallengeKill parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static ChallengeKill parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ChallengeKill) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static ChallengeKill parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ChallengeKill) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static ChallengeKill parseFrom(InputStream inputStream) throws IOException {
        return (ChallengeKill) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static ChallengeKill parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ChallengeKill) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ChallengeKill parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static ChallengeKill parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static ChallengeKill parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static ChallengeKill parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<ChallengeKill> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ChallengeKill) {
            ChallengeKill challengeKill = (ChallengeKill) obj;
            return this.type_ == challengeKill.type_ && getCountdown() == challengeKill.getCountdown() && getGreaterScore() == challengeKill.getGreaterScore() && this.activeType_ == challengeKill.activeType_ && this.unknownFields.equals(challengeKill.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.ChallengeKillOrBuilder
    public ChallengeKillActiveType getActiveType() {
        ChallengeKillActiveType valueOf = ChallengeKillActiveType.valueOf(this.activeType_);
        ChallengeKillActiveType challengeKillActiveType = valueOf;
        if (valueOf == null) {
            challengeKillActiveType = ChallengeKillActiveType.UNRECOGNIZED;
        }
        return challengeKillActiveType;
    }

    @Override // cn.irisgw.live.ChallengeKillOrBuilder
    public int getActiveTypeValue() {
        return this.activeType_;
    }

    @Override // cn.irisgw.live.ChallengeKillOrBuilder
    public int getCountdown() {
        return this.countdown_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public ChallengeKill getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.ChallengeKillOrBuilder
    public int getGreaterScore() {
        return this.greaterScore_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<ChallengeKill> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.type_ != ChallengeKillType.Default.getNumber()) {
            i2 = 0 + CodedOutputStream.computeEnumSize(1, this.type_);
        }
        int i3 = this.countdown_;
        int i4 = i2;
        if (i3 != 0) {
            i4 = i2 + CodedOutputStream.computeUInt32Size(2, i3);
        }
        int i5 = this.greaterScore_;
        int i6 = i4;
        if (i5 != 0) {
            i6 = i4 + CodedOutputStream.computeUInt32Size(3, i5);
        }
        int i7 = i6;
        if (this.activeType_ != ChallengeKillActiveType.None.getNumber()) {
            i7 = i6 + CodedOutputStream.computeEnumSize(4, this.activeType_);
        }
        int serializedSize = i7 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.ChallengeKillOrBuilder
    public ChallengeKillType getType() {
        ChallengeKillType valueOf = ChallengeKillType.valueOf(this.type_);
        ChallengeKillType challengeKillType = valueOf;
        if (valueOf == null) {
            challengeKillType = ChallengeKillType.UNRECOGNIZED;
        }
        return challengeKillType;
    }

    @Override // cn.irisgw.live.ChallengeKillOrBuilder
    public int getTypeValue() {
        return this.type_;
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
        int hashCode = ((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.type_) * 37) + 2) * 53) + getCountdown()) * 37) + 3) * 53) + getGreaterScore()) * 37) + 4) * 53) + this.activeType_) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_ChallengeKill_fieldAccessorTable.ensureFieldAccessorsInitialized(ChallengeKill.class, Builder.class);
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
        return new ChallengeKill();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (this.type_ != ChallengeKillType.Default.getNumber()) {
            codedOutputStream.writeEnum(1, this.type_);
        }
        int i = this.countdown_;
        if (i != 0) {
            codedOutputStream.writeUInt32(2, i);
        }
        int i2 = this.greaterScore_;
        if (i2 != 0) {
            codedOutputStream.writeUInt32(3, i2);
        }
        if (this.activeType_ != ChallengeKillActiveType.None.getNumber()) {
            codedOutputStream.writeEnum(4, this.activeType_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
