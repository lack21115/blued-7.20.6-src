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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/HourRankPop.class */
public final class HourRankPop extends GeneratedMessageV3 implements HourRankPopOrBuilder {
    public static final int NEED_SCORE_FIELD_NUMBER = 3;
    public static final int RANK_FIELD_NUMBER = 2;
    public static final int RANK_TYPE_FIELD_NUMBER = 6;
    public static final int SCORE_FIELD_NUMBER = 4;
    public static final int SECOND_FIELD_NUMBER = 5;
    public static final int TYPE_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private int needScore_;
    private int rankType_;
    private int rank_;
    private int score_;
    private int second_;
    private int type_;
    private static final HourRankPop DEFAULT_INSTANCE = new HourRankPop();
    private static final Parser<HourRankPop> PARSER = new AbstractParser<HourRankPop>() { // from class: cn.irisgw.live.HourRankPop.1
        /* renamed from: parsePartialFrom */
        public HourRankPop m3472parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new HourRankPop(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/HourRankPop$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HourRankPopOrBuilder {
        private int needScore_;
        private int rankType_;
        private int rank_;
        private int score_;
        private int second_;
        private int type_;

        private Builder() {
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_HourRankPop_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = HourRankPop.alwaysUseFieldBuilders;
        }

        /* renamed from: addRepeatedField */
        public Builder m3474addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public HourRankPop m3476build() {
            HourRankPop m3478buildPartial = m3478buildPartial();
            if (m3478buildPartial.isInitialized()) {
                return m3478buildPartial;
            }
            throw newUninitializedMessageException(m3478buildPartial);
        }

        /* renamed from: buildPartial */
        public HourRankPop m3478buildPartial() {
            HourRankPop hourRankPop = new HourRankPop(this);
            hourRankPop.type_ = this.type_;
            hourRankPop.rank_ = this.rank_;
            hourRankPop.needScore_ = this.needScore_;
            hourRankPop.score_ = this.score_;
            hourRankPop.second_ = this.second_;
            hourRankPop.rankType_ = this.rankType_;
            onBuilt();
            return hourRankPop;
        }

        /* renamed from: clear */
        public Builder m3482clear() {
            super.clear();
            this.type_ = 0;
            this.rank_ = 0;
            this.needScore_ = 0;
            this.score_ = 0;
            this.second_ = 0;
            this.rankType_ = 0;
            return this;
        }

        /* renamed from: clearField */
        public Builder m3484clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearNeedScore() {
            this.needScore_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clearOneof */
        public Builder m3487clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearRank() {
            this.rank_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRankType() {
            this.rankType_ = 0;
            onChanged();
            return this;
        }

        public Builder clearScore() {
            this.score_ = 0;
            onChanged();
            return this;
        }

        public Builder clearSecond() {
            this.second_ = 0;
            onChanged();
            return this;
        }

        public Builder clearType() {
            this.type_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m3493clone() {
            return (Builder) super.clone();
        }

        /* renamed from: getDefaultInstanceForType */
        public HourRankPop m3495getDefaultInstanceForType() {
            return HourRankPop.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_HourRankPop_descriptor;
        }

        @Override // cn.irisgw.live.HourRankPopOrBuilder
        public int getNeedScore() {
            return this.needScore_;
        }

        @Override // cn.irisgw.live.HourRankPopOrBuilder
        public int getRank() {
            return this.rank_;
        }

        @Override // cn.irisgw.live.HourRankPopOrBuilder
        public int getRankType() {
            return this.rankType_;
        }

        @Override // cn.irisgw.live.HourRankPopOrBuilder
        public int getScore() {
            return this.score_;
        }

        @Override // cn.irisgw.live.HourRankPopOrBuilder
        public int getSecond() {
            return this.second_;
        }

        @Override // cn.irisgw.live.HourRankPopOrBuilder
        public int getType() {
            return this.type_;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_HourRankPop_fieldAccessorTable.ensureFieldAccessorsInitialized(HourRankPop.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(HourRankPop hourRankPop) {
            if (hourRankPop == HourRankPop.getDefaultInstance()) {
                return this;
            }
            if (hourRankPop.getType() != 0) {
                setType(hourRankPop.getType());
            }
            if (hourRankPop.getRank() != 0) {
                setRank(hourRankPop.getRank());
            }
            if (hourRankPop.getNeedScore() != 0) {
                setNeedScore(hourRankPop.getNeedScore());
            }
            if (hourRankPop.getScore() != 0) {
                setScore(hourRankPop.getScore());
            }
            if (hourRankPop.getSecond() != 0) {
                setSecond(hourRankPop.getSecond());
            }
            if (hourRankPop.getRankType() != 0) {
                setRankType(hourRankPop.getRankType());
            }
            m3504mergeUnknownFields(hourRankPop.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.HourRankPop.Builder m3501mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.HourRankPop.access$1100()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.HourRankPop r0 = (cn.irisgw.live.HourRankPop) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.HourRankPop$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.HourRankPop r0 = (cn.irisgw.live.HourRankPop) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.HourRankPop$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.HourRankPop.Builder.m3501mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.HourRankPop$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m3500mergeFrom(Message message) {
            if (message instanceof HourRankPop) {
                return mergeFrom((HourRankPop) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m3504mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        /* renamed from: setField */
        public Builder m3506setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setNeedScore(int i) {
            this.needScore_ = i;
            onChanged();
            return this;
        }

        public Builder setRank(int i) {
            this.rank_ = i;
            onChanged();
            return this;
        }

        public Builder setRankType(int i) {
            this.rankType_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setRepeatedField */
        public Builder m3508setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setScore(int i) {
            this.score_ = i;
            onChanged();
            return this;
        }

        public Builder setSecond(int i) {
            this.second_ = i;
            onChanged();
            return this;
        }

        public Builder setType(int i) {
            this.type_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setUnknownFields */
        public final Builder m3510setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private HourRankPop() {
        this.memoizedIsInitialized = (byte) -1;
    }

    private HourRankPop(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.type_ = codedInputStream.readUInt32();
                        } else if (readTag == 16) {
                            this.rank_ = codedInputStream.readUInt32();
                        } else if (readTag == 24) {
                            this.needScore_ = codedInputStream.readUInt32();
                        } else if (readTag == 32) {
                            this.score_ = codedInputStream.readUInt32();
                        } else if (readTag == 40) {
                            this.second_ = codedInputStream.readUInt32();
                        } else if (readTag == 48) {
                            this.rankType_ = codedInputStream.readUInt32();
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

    private HourRankPop(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static HourRankPop getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_HourRankPop_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m3471toBuilder();
    }

    public static Builder newBuilder(HourRankPop hourRankPop) {
        return DEFAULT_INSTANCE.m3471toBuilder().mergeFrom(hourRankPop);
    }

    public static HourRankPop parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static HourRankPop parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static HourRankPop parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (HourRankPop) PARSER.parseFrom(byteString);
    }

    public static HourRankPop parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HourRankPop) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static HourRankPop parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static HourRankPop parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static HourRankPop parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static HourRankPop parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static HourRankPop parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (HourRankPop) PARSER.parseFrom(byteBuffer);
    }

    public static HourRankPop parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HourRankPop) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static HourRankPop parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (HourRankPop) PARSER.parseFrom(bArr);
    }

    public static HourRankPop parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HourRankPop) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<HourRankPop> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof HourRankPop) {
            HourRankPop hourRankPop = (HourRankPop) obj;
            return getType() == hourRankPop.getType() && getRank() == hourRankPop.getRank() && getNeedScore() == hourRankPop.getNeedScore() && getScore() == hourRankPop.getScore() && getSecond() == hourRankPop.getSecond() && getRankType() == hourRankPop.getRankType() && this.unknownFields.equals(hourRankPop.unknownFields);
        }
        return super.equals(obj);
    }

    /* renamed from: getDefaultInstanceForType */
    public HourRankPop m3466getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.HourRankPopOrBuilder
    public int getNeedScore() {
        return this.needScore_;
    }

    public Parser<HourRankPop> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.HourRankPopOrBuilder
    public int getRank() {
        return this.rank_;
    }

    @Override // cn.irisgw.live.HourRankPopOrBuilder
    public int getRankType() {
        return this.rankType_;
    }

    @Override // cn.irisgw.live.HourRankPopOrBuilder
    public int getScore() {
        return this.score_;
    }

    @Override // cn.irisgw.live.HourRankPopOrBuilder
    public int getSecond() {
        return this.second_;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        int i3 = this.type_;
        if (i3 != 0) {
            i2 = 0 + CodedOutputStream.computeUInt32Size(1, i3);
        }
        int i4 = this.rank_;
        int i5 = i2;
        if (i4 != 0) {
            i5 = i2 + CodedOutputStream.computeUInt32Size(2, i4);
        }
        int i6 = this.needScore_;
        int i7 = i5;
        if (i6 != 0) {
            i7 = i5 + CodedOutputStream.computeUInt32Size(3, i6);
        }
        int i8 = this.score_;
        int i9 = i7;
        if (i8 != 0) {
            i9 = i7 + CodedOutputStream.computeUInt32Size(4, i8);
        }
        int i10 = this.second_;
        int i11 = i9;
        if (i10 != 0) {
            i11 = i9 + CodedOutputStream.computeUInt32Size(5, i10);
        }
        int i12 = this.rankType_;
        int i13 = i11;
        if (i12 != 0) {
            i13 = i11 + CodedOutputStream.computeUInt32Size(6, i12);
        }
        int serializedSize = i13 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.HourRankPopOrBuilder
    public int getType() {
        return this.type_;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getType()) * 37) + 2) * 53) + getRank()) * 37) + 3) * 53) + getNeedScore()) * 37) + 4) * 53) + getScore()) * 37) + 5) * 53) + getSecond()) * 37) + 6) * 53) + getRankType()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_HourRankPop_fieldAccessorTable.ensureFieldAccessorsInitialized(HourRankPop.class, Builder.class);
    }

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

    /* renamed from: newBuilderForType */
    public Builder m3469newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m3468newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new HourRankPop();
    }

    /* renamed from: toBuilder */
    public Builder m3471toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.type_;
        if (i != 0) {
            codedOutputStream.writeUInt32(1, i);
        }
        int i2 = this.rank_;
        if (i2 != 0) {
            codedOutputStream.writeUInt32(2, i2);
        }
        int i3 = this.needScore_;
        if (i3 != 0) {
            codedOutputStream.writeUInt32(3, i3);
        }
        int i4 = this.score_;
        if (i4 != 0) {
            codedOutputStream.writeUInt32(4, i4);
        }
        int i5 = this.second_;
        if (i5 != 0) {
            codedOutputStream.writeUInt32(5, i5);
        }
        int i6 = this.rankType_;
        if (i6 != 0) {
            codedOutputStream.writeUInt32(6, i6);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
