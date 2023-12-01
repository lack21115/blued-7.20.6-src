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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveRankExtra.class */
public final class LiveRankExtra extends GeneratedMessageV3 implements LiveRankExtraOrBuilder {
    public static final int ICON_FIELD_NUMBER = 2;
    public static final int RANK_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private volatile Object icon_;
    private byte memoizedIsInitialized;
    private int rank_;
    private static final LiveRankExtra DEFAULT_INSTANCE = new LiveRankExtra();
    private static final Parser<LiveRankExtra> PARSER = new AbstractParser<LiveRankExtra>() { // from class: cn.irisgw.live.LiveRankExtra.1
        /* renamed from: parsePartialFrom */
        public LiveRankExtra m4996parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new LiveRankExtra(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveRankExtra$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LiveRankExtraOrBuilder {
        private Object icon_;
        private int rank_;

        private Builder() {
            this.icon_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.icon_ = "";
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_LiveRankExtra_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = LiveRankExtra.alwaysUseFieldBuilders;
        }

        /* renamed from: addRepeatedField */
        public Builder m4998addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public LiveRankExtra m5000build() {
            LiveRankExtra m5002buildPartial = m5002buildPartial();
            if (m5002buildPartial.isInitialized()) {
                return m5002buildPartial;
            }
            throw newUninitializedMessageException(m5002buildPartial);
        }

        /* renamed from: buildPartial */
        public LiveRankExtra m5002buildPartial() {
            LiveRankExtra liveRankExtra = new LiveRankExtra(this);
            liveRankExtra.rank_ = this.rank_;
            liveRankExtra.icon_ = this.icon_;
            onBuilt();
            return liveRankExtra;
        }

        /* renamed from: clear */
        public Builder m5006clear() {
            super.clear();
            this.rank_ = 0;
            this.icon_ = "";
            return this;
        }

        /* renamed from: clearField */
        public Builder m5008clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearIcon() {
            this.icon_ = LiveRankExtra.getDefaultInstance().getIcon();
            onChanged();
            return this;
        }

        /* renamed from: clearOneof */
        public Builder m5011clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearRank() {
            this.rank_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m5017clone() {
            return (Builder) super.clone();
        }

        /* renamed from: getDefaultInstanceForType */
        public LiveRankExtra m5019getDefaultInstanceForType() {
            return LiveRankExtra.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_LiveRankExtra_descriptor;
        }

        @Override // cn.irisgw.live.LiveRankExtraOrBuilder
        public String getIcon() {
            Object obj = this.icon_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.icon_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LiveRankExtraOrBuilder
        public ByteString getIconBytes() {
            Object obj = this.icon_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.icon_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.LiveRankExtraOrBuilder
        public int getRank() {
            return this.rank_;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_LiveRankExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveRankExtra.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(LiveRankExtra liveRankExtra) {
            if (liveRankExtra == LiveRankExtra.getDefaultInstance()) {
                return this;
            }
            if (liveRankExtra.getRank() != 0) {
                setRank(liveRankExtra.getRank());
            }
            if (!liveRankExtra.getIcon().isEmpty()) {
                this.icon_ = liveRankExtra.icon_;
                onChanged();
            }
            m5028mergeUnknownFields(liveRankExtra.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.LiveRankExtra.Builder m5025mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.LiveRankExtra.access$700()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.LiveRankExtra r0 = (cn.irisgw.live.LiveRankExtra) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.LiveRankExtra$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.LiveRankExtra r0 = (cn.irisgw.live.LiveRankExtra) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.LiveRankExtra$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.LiveRankExtra.Builder.m5025mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.LiveRankExtra$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m5024mergeFrom(Message message) {
            if (message instanceof LiveRankExtra) {
                return mergeFrom((LiveRankExtra) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m5028mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        /* renamed from: setField */
        public Builder m5030setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setIcon(String str) {
            if (str != null) {
                this.icon_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setIconBytes(ByteString byteString) {
            if (byteString != null) {
                LiveRankExtra.checkByteStringIsUtf8(byteString);
                this.icon_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setRank(int i) {
            this.rank_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setRepeatedField */
        public Builder m5032setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        /* renamed from: setUnknownFields */
        public final Builder m5034setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private LiveRankExtra() {
        this.memoizedIsInitialized = (byte) -1;
        this.icon_ = "";
    }

    private LiveRankExtra(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            } else if (readTag == 18) {
                                this.icon_ = codedInputStream.readStringRequireUtf8();
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

    private LiveRankExtra(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static LiveRankExtra getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_LiveRankExtra_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m4995toBuilder();
    }

    public static Builder newBuilder(LiveRankExtra liveRankExtra) {
        return DEFAULT_INSTANCE.m4995toBuilder().mergeFrom(liveRankExtra);
    }

    public static LiveRankExtra parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static LiveRankExtra parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LiveRankExtra parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (LiveRankExtra) PARSER.parseFrom(byteString);
    }

    public static LiveRankExtra parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LiveRankExtra) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static LiveRankExtra parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static LiveRankExtra parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static LiveRankExtra parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static LiveRankExtra parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LiveRankExtra parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (LiveRankExtra) PARSER.parseFrom(byteBuffer);
    }

    public static LiveRankExtra parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LiveRankExtra) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static LiveRankExtra parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (LiveRankExtra) PARSER.parseFrom(bArr);
    }

    public static LiveRankExtra parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LiveRankExtra) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<LiveRankExtra> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LiveRankExtra) {
            LiveRankExtra liveRankExtra = (LiveRankExtra) obj;
            return getRank() == liveRankExtra.getRank() && getIcon().equals(liveRankExtra.getIcon()) && this.unknownFields.equals(liveRankExtra.unknownFields);
        }
        return super.equals(obj);
    }

    /* renamed from: getDefaultInstanceForType */
    public LiveRankExtra m4990getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.LiveRankExtraOrBuilder
    public String getIcon() {
        Object obj = this.icon_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.icon_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.LiveRankExtraOrBuilder
    public ByteString getIconBytes() {
        Object obj = this.icon_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.icon_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    public Parser<LiveRankExtra> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.LiveRankExtraOrBuilder
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
        int i4 = i2;
        if (!getIconBytes().isEmpty()) {
            i4 = i2 + GeneratedMessageV3.computeStringSize(2, this.icon_);
        }
        int serializedSize = i4 + this.unknownFields.getSerializedSize();
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
        int hashCode = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getRank()) * 37) + 2) * 53) + getIcon().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_LiveRankExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveRankExtra.class, Builder.class);
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
    public Builder m4993newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m4992newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new LiveRankExtra();
    }

    /* renamed from: toBuilder */
    public Builder m4995toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.rank_;
        if (i != 0) {
            codedOutputStream.writeUInt32(1, i);
        }
        if (!getIconBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.icon_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
