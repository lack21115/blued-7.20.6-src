package cn.irisgw.live;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/SyncExpExtra.class */
public final class SyncExpExtra extends GeneratedMessageV3 implements SyncExpExtraOrBuilder {
    public static final int EXP_FIELD_NUMBER = 2;
    public static final int GAP_EXP_FIELD_NUMBER = 3;
    public static final int LEVEL_FIELD_NUMBER = 1;
    public static final int NEXT_LEVEL_FIELD_NUMBER = 5;
    public static final int PERCENT_FIELD_NUMBER = 4;
    private static final long serialVersionUID = 0;
    private float exp_;
    private float gapExp_;
    private int level_;
    private byte memoizedIsInitialized;
    private int nextLevel_;
    private float percent_;
    private static final SyncExpExtra DEFAULT_INSTANCE = new SyncExpExtra();
    private static final Parser<SyncExpExtra> PARSER = new AbstractParser<SyncExpExtra>() { // from class: cn.irisgw.live.SyncExpExtra.1
        @Override // com.google.protobuf.Parser
        public SyncExpExtra parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new SyncExpExtra(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/SyncExpExtra$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SyncExpExtraOrBuilder {
        private float exp_;
        private float gapExp_;
        private int level_;
        private int nextLevel_;
        private float percent_;

        private Builder() {
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_SyncExpExtra_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = SyncExpExtra.alwaysUseFieldBuilders;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public SyncExpExtra build() {
            SyncExpExtra buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public SyncExpExtra buildPartial() {
            SyncExpExtra syncExpExtra = new SyncExpExtra(this);
            syncExpExtra.level_ = this.level_;
            syncExpExtra.exp_ = this.exp_;
            syncExpExtra.gapExp_ = this.gapExp_;
            syncExpExtra.percent_ = this.percent_;
            syncExpExtra.nextLevel_ = this.nextLevel_;
            onBuilt();
            return syncExpExtra;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.level_ = 0;
            this.exp_ = 0.0f;
            this.gapExp_ = 0.0f;
            this.percent_ = 0.0f;
            this.nextLevel_ = 0;
            return this;
        }

        public Builder clearExp() {
            this.exp_ = 0.0f;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearGapExp() {
            this.gapExp_ = 0.0f;
            onChanged();
            return this;
        }

        public Builder clearLevel() {
            this.level_ = 0;
            onChanged();
            return this;
        }

        public Builder clearNextLevel() {
            this.nextLevel_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearPercent() {
            this.percent_ = 0.0f;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo1800clone() {
            return (Builder) super.mo1800clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SyncExpExtra getDefaultInstanceForType() {
            return SyncExpExtra.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_SyncExpExtra_descriptor;
        }

        @Override // cn.irisgw.live.SyncExpExtraOrBuilder
        public float getExp() {
            return this.exp_;
        }

        @Override // cn.irisgw.live.SyncExpExtraOrBuilder
        public float getGapExp() {
            return this.gapExp_;
        }

        @Override // cn.irisgw.live.SyncExpExtraOrBuilder
        public int getLevel() {
            return this.level_;
        }

        @Override // cn.irisgw.live.SyncExpExtraOrBuilder
        public int getNextLevel() {
            return this.nextLevel_;
        }

        @Override // cn.irisgw.live.SyncExpExtraOrBuilder
        public float getPercent() {
            return this.percent_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_SyncExpExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(SyncExpExtra.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(SyncExpExtra syncExpExtra) {
            if (syncExpExtra == SyncExpExtra.getDefaultInstance()) {
                return this;
            }
            if (syncExpExtra.getLevel() != 0) {
                setLevel(syncExpExtra.getLevel());
            }
            if (syncExpExtra.getExp() != 0.0f) {
                setExp(syncExpExtra.getExp());
            }
            if (syncExpExtra.getGapExp() != 0.0f) {
                setGapExp(syncExpExtra.getGapExp());
            }
            if (syncExpExtra.getPercent() != 0.0f) {
                setPercent(syncExpExtra.getPercent());
            }
            if (syncExpExtra.getNextLevel() != 0) {
                setNextLevel(syncExpExtra.getNextLevel());
            }
            mergeUnknownFields(syncExpExtra.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.SyncExpExtra.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.SyncExpExtra.access$1000()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.SyncExpExtra r0 = (cn.irisgw.live.SyncExpExtra) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.SyncExpExtra$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.SyncExpExtra r0 = (cn.irisgw.live.SyncExpExtra) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.SyncExpExtra$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.SyncExpExtra.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.SyncExpExtra$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof SyncExpExtra) {
                return mergeFrom((SyncExpExtra) message);
            }
            super.mergeFrom(message);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setExp(float f) {
            this.exp_ = f;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setGapExp(float f) {
            this.gapExp_ = f;
            onChanged();
            return this;
        }

        public Builder setLevel(int i) {
            this.level_ = i;
            onChanged();
            return this;
        }

        public Builder setNextLevel(int i) {
            this.nextLevel_ = i;
            onChanged();
            return this;
        }

        public Builder setPercent(float f) {
            this.percent_ = f;
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
    }

    private SyncExpExtra() {
        this.memoizedIsInitialized = (byte) -1;
    }

    private SyncExpExtra(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.level_ = codedInputStream.readUInt32();
                        } else if (readTag == 21) {
                            this.exp_ = codedInputStream.readFloat();
                        } else if (readTag == 29) {
                            this.gapExp_ = codedInputStream.readFloat();
                        } else if (readTag == 37) {
                            this.percent_ = codedInputStream.readFloat();
                        } else if (readTag == 40) {
                            this.nextLevel_ = codedInputStream.readInt32();
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

    private SyncExpExtra(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static SyncExpExtra getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_SyncExpExtra_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(SyncExpExtra syncExpExtra) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(syncExpExtra);
    }

    public static SyncExpExtra parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (SyncExpExtra) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static SyncExpExtra parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SyncExpExtra) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static SyncExpExtra parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static SyncExpExtra parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static SyncExpExtra parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (SyncExpExtra) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static SyncExpExtra parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SyncExpExtra) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static SyncExpExtra parseFrom(InputStream inputStream) throws IOException {
        return (SyncExpExtra) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static SyncExpExtra parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SyncExpExtra) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static SyncExpExtra parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static SyncExpExtra parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static SyncExpExtra parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static SyncExpExtra parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<SyncExpExtra> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SyncExpExtra) {
            SyncExpExtra syncExpExtra = (SyncExpExtra) obj;
            return getLevel() == syncExpExtra.getLevel() && Float.floatToIntBits(getExp()) == Float.floatToIntBits(syncExpExtra.getExp()) && Float.floatToIntBits(getGapExp()) == Float.floatToIntBits(syncExpExtra.getGapExp()) && Float.floatToIntBits(getPercent()) == Float.floatToIntBits(syncExpExtra.getPercent()) && getNextLevel() == syncExpExtra.getNextLevel() && this.unknownFields.equals(syncExpExtra.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public SyncExpExtra getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.SyncExpExtraOrBuilder
    public float getExp() {
        return this.exp_;
    }

    @Override // cn.irisgw.live.SyncExpExtraOrBuilder
    public float getGapExp() {
        return this.gapExp_;
    }

    @Override // cn.irisgw.live.SyncExpExtraOrBuilder
    public int getLevel() {
        return this.level_;
    }

    @Override // cn.irisgw.live.SyncExpExtraOrBuilder
    public int getNextLevel() {
        return this.nextLevel_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<SyncExpExtra> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.SyncExpExtraOrBuilder
    public float getPercent() {
        return this.percent_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        int i3 = this.level_;
        if (i3 != 0) {
            i2 = 0 + CodedOutputStream.computeUInt32Size(1, i3);
        }
        float f = this.exp_;
        int i4 = i2;
        if (f != 0.0f) {
            i4 = i2 + CodedOutputStream.computeFloatSize(2, f);
        }
        float f2 = this.gapExp_;
        int i5 = i4;
        if (f2 != 0.0f) {
            i5 = i4 + CodedOutputStream.computeFloatSize(3, f2);
        }
        float f3 = this.percent_;
        int i6 = i5;
        if (f3 != 0.0f) {
            i6 = i5 + CodedOutputStream.computeFloatSize(4, f3);
        }
        int i7 = this.nextLevel_;
        int i8 = i6;
        if (i7 != 0) {
            i8 = i6 + CodedOutputStream.computeInt32Size(5, i7);
        }
        int serializedSize = i8 + this.unknownFields.getSerializedSize();
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
        int hashCode = ((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getLevel()) * 37) + 2) * 53) + Float.floatToIntBits(getExp())) * 37) + 3) * 53) + Float.floatToIntBits(getGapExp())) * 37) + 4) * 53) + Float.floatToIntBits(getPercent())) * 37) + 5) * 53) + getNextLevel()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_SyncExpExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(SyncExpExtra.class, Builder.class);
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
        return new SyncExpExtra();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.level_;
        if (i != 0) {
            codedOutputStream.writeUInt32(1, i);
        }
        float f = this.exp_;
        if (f != 0.0f) {
            codedOutputStream.writeFloat(2, f);
        }
        float f2 = this.gapExp_;
        if (f2 != 0.0f) {
            codedOutputStream.writeFloat(3, f2);
        }
        float f3 = this.percent_;
        if (f3 != 0.0f) {
            codedOutputStream.writeFloat(4, f3);
        }
        int i2 = this.nextLevel_;
        if (i2 != 0) {
            codedOutputStream.writeInt32(5, i2);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
