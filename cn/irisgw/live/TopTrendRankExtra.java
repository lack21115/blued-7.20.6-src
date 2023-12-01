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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/TopTrendRankExtra.class */
public final class TopTrendRankExtra extends GeneratedMessageV3 implements TopTrendRankExtraOrBuilder {
    public static final int BATTLE_CATCH_FIELD_NUMBER = 5;
    public static final int BATTLE_RANK_FIELD_NUMBER = 4;
    public static final int HOT_FIELD_NUMBER = 1;
    public static final int JUMP_FIELD_NUMBER = 2;
    public static final int NEED_SCORE_FIELD_NUMBER = 3;
    private static final long serialVersionUID = 0;
    private long battleCatch_;
    private long battleRank_;
    private int hot_;
    private int jump_;
    private byte memoizedIsInitialized;
    private float needScore_;
    private static final TopTrendRankExtra DEFAULT_INSTANCE = new TopTrendRankExtra();
    private static final Parser<TopTrendRankExtra> PARSER = new AbstractParser<TopTrendRankExtra>() { // from class: cn.irisgw.live.TopTrendRankExtra.1
        @Override // com.google.protobuf.Parser
        public TopTrendRankExtra parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new TopTrendRankExtra(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/TopTrendRankExtra$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TopTrendRankExtraOrBuilder {
        private long battleCatch_;
        private long battleRank_;
        private int hot_;
        private int jump_;
        private float needScore_;

        private Builder() {
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_TopTrendRankExtra_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = TopTrendRankExtra.alwaysUseFieldBuilders;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public TopTrendRankExtra build() {
            TopTrendRankExtra buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public TopTrendRankExtra buildPartial() {
            TopTrendRankExtra topTrendRankExtra = new TopTrendRankExtra(this);
            topTrendRankExtra.hot_ = this.hot_;
            topTrendRankExtra.jump_ = this.jump_;
            topTrendRankExtra.needScore_ = this.needScore_;
            topTrendRankExtra.battleRank_ = this.battleRank_;
            topTrendRankExtra.battleCatch_ = this.battleCatch_;
            onBuilt();
            return topTrendRankExtra;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.hot_ = 0;
            this.jump_ = 0;
            this.needScore_ = 0.0f;
            this.battleRank_ = 0L;
            this.battleCatch_ = 0L;
            return this;
        }

        public Builder clearBattleCatch() {
            this.battleCatch_ = 0L;
            onChanged();
            return this;
        }

        public Builder clearBattleRank() {
            this.battleRank_ = 0L;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearHot() {
            this.hot_ = 0;
            onChanged();
            return this;
        }

        public Builder clearJump() {
            this.jump_ = 0;
            onChanged();
            return this;
        }

        public Builder clearNeedScore() {
            this.needScore_ = 0.0f;
            onChanged();
            return this;
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

        @Override // cn.irisgw.live.TopTrendRankExtraOrBuilder
        public long getBattleCatch() {
            return this.battleCatch_;
        }

        @Override // cn.irisgw.live.TopTrendRankExtraOrBuilder
        public long getBattleRank() {
            return this.battleRank_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TopTrendRankExtra getDefaultInstanceForType() {
            return TopTrendRankExtra.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_TopTrendRankExtra_descriptor;
        }

        @Override // cn.irisgw.live.TopTrendRankExtraOrBuilder
        public int getHot() {
            return this.hot_;
        }

        @Override // cn.irisgw.live.TopTrendRankExtraOrBuilder
        public int getJump() {
            return this.jump_;
        }

        @Override // cn.irisgw.live.TopTrendRankExtraOrBuilder
        public float getNeedScore() {
            return this.needScore_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_TopTrendRankExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(TopTrendRankExtra.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(TopTrendRankExtra topTrendRankExtra) {
            if (topTrendRankExtra == TopTrendRankExtra.getDefaultInstance()) {
                return this;
            }
            if (topTrendRankExtra.getHot() != 0) {
                setHot(topTrendRankExtra.getHot());
            }
            if (topTrendRankExtra.getJump() != 0) {
                setJump(topTrendRankExtra.getJump());
            }
            if (topTrendRankExtra.getNeedScore() != 0.0f) {
                setNeedScore(topTrendRankExtra.getNeedScore());
            }
            if (topTrendRankExtra.getBattleRank() != 0) {
                setBattleRank(topTrendRankExtra.getBattleRank());
            }
            if (topTrendRankExtra.getBattleCatch() != 0) {
                setBattleCatch(topTrendRankExtra.getBattleCatch());
            }
            mergeUnknownFields(topTrendRankExtra.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.TopTrendRankExtra.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.TopTrendRankExtra.access$1000()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.TopTrendRankExtra r0 = (cn.irisgw.live.TopTrendRankExtra) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.TopTrendRankExtra$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.TopTrendRankExtra r0 = (cn.irisgw.live.TopTrendRankExtra) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.TopTrendRankExtra$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.TopTrendRankExtra.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.TopTrendRankExtra$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof TopTrendRankExtra) {
                return mergeFrom((TopTrendRankExtra) message);
            }
            super.mergeFrom(message);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setBattleCatch(long j) {
            this.battleCatch_ = j;
            onChanged();
            return this;
        }

        public Builder setBattleRank(long j) {
            this.battleRank_ = j;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setHot(int i) {
            this.hot_ = i;
            onChanged();
            return this;
        }

        public Builder setJump(int i) {
            this.jump_ = i;
            onChanged();
            return this;
        }

        public Builder setNeedScore(float f) {
            this.needScore_ = f;
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

    private TopTrendRankExtra() {
        this.memoizedIsInitialized = (byte) -1;
    }

    private TopTrendRankExtra(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.hot_ = codedInputStream.readInt32();
                        } else if (readTag == 16) {
                            this.jump_ = codedInputStream.readInt32();
                        } else if (readTag == 29) {
                            this.needScore_ = codedInputStream.readFloat();
                        } else if (readTag == 32) {
                            this.battleRank_ = codedInputStream.readUInt64();
                        } else if (readTag == 40) {
                            this.battleCatch_ = codedInputStream.readUInt64();
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

    private TopTrendRankExtra(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static TopTrendRankExtra getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_TopTrendRankExtra_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(TopTrendRankExtra topTrendRankExtra) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(topTrendRankExtra);
    }

    public static TopTrendRankExtra parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (TopTrendRankExtra) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static TopTrendRankExtra parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TopTrendRankExtra) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static TopTrendRankExtra parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static TopTrendRankExtra parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static TopTrendRankExtra parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (TopTrendRankExtra) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static TopTrendRankExtra parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TopTrendRankExtra) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static TopTrendRankExtra parseFrom(InputStream inputStream) throws IOException {
        return (TopTrendRankExtra) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static TopTrendRankExtra parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TopTrendRankExtra) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static TopTrendRankExtra parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static TopTrendRankExtra parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static TopTrendRankExtra parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static TopTrendRankExtra parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<TopTrendRankExtra> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof TopTrendRankExtra) {
            TopTrendRankExtra topTrendRankExtra = (TopTrendRankExtra) obj;
            return getHot() == topTrendRankExtra.getHot() && getJump() == topTrendRankExtra.getJump() && Float.floatToIntBits(getNeedScore()) == Float.floatToIntBits(topTrendRankExtra.getNeedScore()) && getBattleRank() == topTrendRankExtra.getBattleRank() && getBattleCatch() == topTrendRankExtra.getBattleCatch() && this.unknownFields.equals(topTrendRankExtra.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.TopTrendRankExtraOrBuilder
    public long getBattleCatch() {
        return this.battleCatch_;
    }

    @Override // cn.irisgw.live.TopTrendRankExtraOrBuilder
    public long getBattleRank() {
        return this.battleRank_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public TopTrendRankExtra getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.TopTrendRankExtraOrBuilder
    public int getHot() {
        return this.hot_;
    }

    @Override // cn.irisgw.live.TopTrendRankExtraOrBuilder
    public int getJump() {
        return this.jump_;
    }

    @Override // cn.irisgw.live.TopTrendRankExtraOrBuilder
    public float getNeedScore() {
        return this.needScore_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<TopTrendRankExtra> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        int i3 = this.hot_;
        if (i3 != 0) {
            i2 = 0 + CodedOutputStream.computeInt32Size(1, i3);
        }
        int i4 = this.jump_;
        int i5 = i2;
        if (i4 != 0) {
            i5 = i2 + CodedOutputStream.computeInt32Size(2, i4);
        }
        float f = this.needScore_;
        int i6 = i5;
        if (f != 0.0f) {
            i6 = i5 + CodedOutputStream.computeFloatSize(3, f);
        }
        long j = this.battleRank_;
        int i7 = i6;
        if (j != 0) {
            i7 = i6 + CodedOutputStream.computeUInt64Size(4, j);
        }
        long j2 = this.battleCatch_;
        int i8 = i7;
        if (j2 != 0) {
            i8 = i7 + CodedOutputStream.computeUInt64Size(5, j2);
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
        int hashCode = ((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getHot()) * 37) + 2) * 53) + getJump()) * 37) + 3) * 53) + Float.floatToIntBits(getNeedScore())) * 37) + 4) * 53) + Internal.hashLong(getBattleRank())) * 37) + 5) * 53) + Internal.hashLong(getBattleCatch())) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_TopTrendRankExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(TopTrendRankExtra.class, Builder.class);
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
        return new TopTrendRankExtra();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.hot_;
        if (i != 0) {
            codedOutputStream.writeInt32(1, i);
        }
        int i2 = this.jump_;
        if (i2 != 0) {
            codedOutputStream.writeInt32(2, i2);
        }
        float f = this.needScore_;
        if (f != 0.0f) {
            codedOutputStream.writeFloat(3, f);
        }
        long j = this.battleRank_;
        if (j != 0) {
            codedOutputStream.writeUInt64(4, j);
        }
        long j2 = this.battleCatch_;
        if (j2 != 0) {
            codedOutputStream.writeUInt64(5, j2);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
