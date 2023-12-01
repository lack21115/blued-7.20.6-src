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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/HourRank.class */
public final class HourRank extends GeneratedMessageV3 implements HourRankOrBuilder {
    public static final int NEED_SCORE_FIELD_NUMBER = 2;
    public static final int RANK_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private int needScore_;
    private int rank_;
    private static final HourRank DEFAULT_INSTANCE = new HourRank();
    private static final Parser<HourRank> PARSER = new AbstractParser<HourRank>() { // from class: cn.irisgw.live.HourRank.1
        /* renamed from: parsePartialFrom */
        public HourRank m3425parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new HourRank(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/HourRank$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HourRankOrBuilder {
        private int needScore_;
        private int rank_;

        private Builder() {
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_HourRank_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = HourRank.alwaysUseFieldBuilders;
        }

        /* renamed from: addRepeatedField */
        public Builder m3427addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public HourRank m3429build() {
            HourRank m3431buildPartial = m3431buildPartial();
            if (m3431buildPartial.isInitialized()) {
                return m3431buildPartial;
            }
            throw newUninitializedMessageException(m3431buildPartial);
        }

        /* renamed from: buildPartial */
        public HourRank m3431buildPartial() {
            HourRank hourRank = new HourRank(this);
            hourRank.rank_ = this.rank_;
            hourRank.needScore_ = this.needScore_;
            onBuilt();
            return hourRank;
        }

        /* renamed from: clear */
        public Builder m3435clear() {
            super.clear();
            this.rank_ = 0;
            this.needScore_ = 0;
            return this;
        }

        /* renamed from: clearField */
        public Builder m3437clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearNeedScore() {
            this.needScore_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clearOneof */
        public Builder m3440clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearRank() {
            this.rank_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m3446clone() {
            return (Builder) super.clone();
        }

        /* renamed from: getDefaultInstanceForType */
        public HourRank m3448getDefaultInstanceForType() {
            return HourRank.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_HourRank_descriptor;
        }

        @Override // cn.irisgw.live.HourRankOrBuilder
        public int getNeedScore() {
            return this.needScore_;
        }

        @Override // cn.irisgw.live.HourRankOrBuilder
        public int getRank() {
            return this.rank_;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_HourRank_fieldAccessorTable.ensureFieldAccessorsInitialized(HourRank.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(HourRank hourRank) {
            if (hourRank == HourRank.getDefaultInstance()) {
                return this;
            }
            if (hourRank.getRank() != 0) {
                setRank(hourRank.getRank());
            }
            if (hourRank.getNeedScore() != 0) {
                setNeedScore(hourRank.getNeedScore());
            }
            m3457mergeUnknownFields(hourRank.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.HourRank.Builder m3454mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.HourRank.access$700()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.HourRank r0 = (cn.irisgw.live.HourRank) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.HourRank$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.HourRank r0 = (cn.irisgw.live.HourRank) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.HourRank$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.HourRank.Builder.m3454mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.HourRank$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m3453mergeFrom(Message message) {
            if (message instanceof HourRank) {
                return mergeFrom((HourRank) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m3457mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        /* renamed from: setField */
        public Builder m3459setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
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

        /* renamed from: setRepeatedField */
        public Builder m3461setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        /* renamed from: setUnknownFields */
        public final Builder m3463setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private HourRank() {
        this.memoizedIsInitialized = (byte) -1;
    }

    private HourRank(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            if (readTag == 8) {
                                this.rank_ = codedInputStream.readUInt32();
                            } else if (readTag == 16) {
                                this.needScore_ = codedInputStream.readUInt32();
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

    private HourRank(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static HourRank getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_HourRank_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m3424toBuilder();
    }

    public static Builder newBuilder(HourRank hourRank) {
        return DEFAULT_INSTANCE.m3424toBuilder().mergeFrom(hourRank);
    }

    public static HourRank parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static HourRank parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static HourRank parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (HourRank) PARSER.parseFrom(byteString);
    }

    public static HourRank parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HourRank) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static HourRank parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static HourRank parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static HourRank parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static HourRank parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static HourRank parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (HourRank) PARSER.parseFrom(byteBuffer);
    }

    public static HourRank parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HourRank) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static HourRank parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (HourRank) PARSER.parseFrom(bArr);
    }

    public static HourRank parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HourRank) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<HourRank> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof HourRank) {
            HourRank hourRank = (HourRank) obj;
            return getRank() == hourRank.getRank() && getNeedScore() == hourRank.getNeedScore() && this.unknownFields.equals(hourRank.unknownFields);
        }
        return super.equals(obj);
    }

    /* renamed from: getDefaultInstanceForType */
    public HourRank m3419getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.HourRankOrBuilder
    public int getNeedScore() {
        return this.needScore_;
    }

    public Parser<HourRank> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.HourRankOrBuilder
    public int getRank() {
        return this.rank_;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        int i3 = this.rank_;
        if (i3 != 0) {
            i2 = 0 + CodedOutputStream.computeUInt32Size(1, i3);
        }
        int i4 = this.needScore_;
        int i5 = i2;
        if (i4 != 0) {
            i5 = i2 + CodedOutputStream.computeUInt32Size(2, i4);
        }
        int serializedSize = i5 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getRank()) * 37) + 2) * 53) + getNeedScore()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_HourRank_fieldAccessorTable.ensureFieldAccessorsInitialized(HourRank.class, Builder.class);
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
    public Builder m3422newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m3421newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new HourRank();
    }

    /* renamed from: toBuilder */
    public Builder m3424toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.rank_;
        if (i != 0) {
            codedOutputStream.writeUInt32(1, i);
        }
        int i2 = this.needScore_;
        if (i2 != 0) {
            codedOutputStream.writeUInt32(2, i2);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
