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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LeaveLiveExtra.class */
public final class LeaveLiveExtra extends GeneratedMessageV3 implements LeaveLiveExtraOrBuilder {
    public static final int COUNT_FIELD_NUMBER = 1;
    private static final LeaveLiveExtra DEFAULT_INSTANCE = new LeaveLiveExtra();
    private static final Parser<LeaveLiveExtra> PARSER = new AbstractParser<LeaveLiveExtra>() { // from class: cn.irisgw.live.LeaveLiveExtra.1
        /* renamed from: parsePartialFrom */
        public LeaveLiveExtra m3803parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new LeaveLiveExtra(codedInputStream, extensionRegistryLite);
        }
    };
    public static final int REALTIME_COUNT_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private int count_;
    private byte memoizedIsInitialized;
    private int realtimeCount_;

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LeaveLiveExtra$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LeaveLiveExtraOrBuilder {
        private int count_;
        private int realtimeCount_;

        private Builder() {
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_LeaveLiveExtra_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = LeaveLiveExtra.alwaysUseFieldBuilders;
        }

        /* renamed from: addRepeatedField */
        public Builder m3805addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public LeaveLiveExtra m3807build() {
            LeaveLiveExtra m3809buildPartial = m3809buildPartial();
            if (m3809buildPartial.isInitialized()) {
                return m3809buildPartial;
            }
            throw newUninitializedMessageException(m3809buildPartial);
        }

        /* renamed from: buildPartial */
        public LeaveLiveExtra m3809buildPartial() {
            LeaveLiveExtra leaveLiveExtra = new LeaveLiveExtra(this);
            leaveLiveExtra.count_ = this.count_;
            leaveLiveExtra.realtimeCount_ = this.realtimeCount_;
            onBuilt();
            return leaveLiveExtra;
        }

        /* renamed from: clear */
        public Builder m3813clear() {
            super.clear();
            this.count_ = 0;
            this.realtimeCount_ = 0;
            return this;
        }

        public Builder clearCount() {
            this.count_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clearField */
        public Builder m3815clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        /* renamed from: clearOneof */
        public Builder m3818clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearRealtimeCount() {
            this.realtimeCount_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m3824clone() {
            return (Builder) super.clone();
        }

        @Override // cn.irisgw.live.LeaveLiveExtraOrBuilder
        public int getCount() {
            return this.count_;
        }

        /* renamed from: getDefaultInstanceForType */
        public LeaveLiveExtra m3826getDefaultInstanceForType() {
            return LeaveLiveExtra.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_LeaveLiveExtra_descriptor;
        }

        @Override // cn.irisgw.live.LeaveLiveExtraOrBuilder
        public int getRealtimeCount() {
            return this.realtimeCount_;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_LeaveLiveExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(LeaveLiveExtra.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(LeaveLiveExtra leaveLiveExtra) {
            if (leaveLiveExtra == LeaveLiveExtra.getDefaultInstance()) {
                return this;
            }
            if (leaveLiveExtra.getCount() != 0) {
                setCount(leaveLiveExtra.getCount());
            }
            if (leaveLiveExtra.getRealtimeCount() != 0) {
                setRealtimeCount(leaveLiveExtra.getRealtimeCount());
            }
            m3835mergeUnknownFields(leaveLiveExtra.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.LeaveLiveExtra.Builder m3832mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.LeaveLiveExtra.access$700()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.LeaveLiveExtra r0 = (cn.irisgw.live.LeaveLiveExtra) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.LeaveLiveExtra$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.LeaveLiveExtra r0 = (cn.irisgw.live.LeaveLiveExtra) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.LeaveLiveExtra$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.LeaveLiveExtra.Builder.m3832mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.LeaveLiveExtra$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m3831mergeFrom(Message message) {
            if (message instanceof LeaveLiveExtra) {
                return mergeFrom((LeaveLiveExtra) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m3835mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setCount(int i) {
            this.count_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setField */
        public Builder m3837setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setRealtimeCount(int i) {
            this.realtimeCount_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setRepeatedField */
        public Builder m3839setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        /* renamed from: setUnknownFields */
        public final Builder m3841setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private LeaveLiveExtra() {
        this.memoizedIsInitialized = (byte) -1;
    }

    private LeaveLiveExtra(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.count_ = codedInputStream.readUInt32();
                            } else if (readTag == 16) {
                                this.realtimeCount_ = codedInputStream.readUInt32();
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

    private LeaveLiveExtra(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static LeaveLiveExtra getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_LeaveLiveExtra_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m3802toBuilder();
    }

    public static Builder newBuilder(LeaveLiveExtra leaveLiveExtra) {
        return DEFAULT_INSTANCE.m3802toBuilder().mergeFrom(leaveLiveExtra);
    }

    public static LeaveLiveExtra parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static LeaveLiveExtra parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LeaveLiveExtra parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (LeaveLiveExtra) PARSER.parseFrom(byteString);
    }

    public static LeaveLiveExtra parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LeaveLiveExtra) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static LeaveLiveExtra parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static LeaveLiveExtra parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static LeaveLiveExtra parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static LeaveLiveExtra parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LeaveLiveExtra parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (LeaveLiveExtra) PARSER.parseFrom(byteBuffer);
    }

    public static LeaveLiveExtra parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LeaveLiveExtra) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static LeaveLiveExtra parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (LeaveLiveExtra) PARSER.parseFrom(bArr);
    }

    public static LeaveLiveExtra parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LeaveLiveExtra) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<LeaveLiveExtra> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LeaveLiveExtra) {
            LeaveLiveExtra leaveLiveExtra = (LeaveLiveExtra) obj;
            return getCount() == leaveLiveExtra.getCount() && getRealtimeCount() == leaveLiveExtra.getRealtimeCount() && this.unknownFields.equals(leaveLiveExtra.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.LeaveLiveExtraOrBuilder
    public int getCount() {
        return this.count_;
    }

    /* renamed from: getDefaultInstanceForType */
    public LeaveLiveExtra m3797getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public Parser<LeaveLiveExtra> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.LeaveLiveExtraOrBuilder
    public int getRealtimeCount() {
        return this.realtimeCount_;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        int i3 = this.count_;
        if (i3 != 0) {
            i2 = 0 + CodedOutputStream.computeUInt32Size(1, i3);
        }
        int i4 = this.realtimeCount_;
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
        int hashCode = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getCount()) * 37) + 2) * 53) + getRealtimeCount()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_LeaveLiveExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(LeaveLiveExtra.class, Builder.class);
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
    public Builder m3800newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m3799newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new LeaveLiveExtra();
    }

    /* renamed from: toBuilder */
    public Builder m3802toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.count_;
        if (i != 0) {
            codedOutputStream.writeUInt32(1, i);
        }
        int i2 = this.realtimeCount_;
        if (i2 != 0) {
            codedOutputStream.writeUInt32(2, i2);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
