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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ConstellationBasicCount.class */
public final class ConstellationBasicCount extends GeneratedMessageV3 implements ConstellationBasicCountOrBuilder {
    public static final int COUNT_FIELD_NUMBER = 1;
    private static final ConstellationBasicCount DEFAULT_INSTANCE = new ConstellationBasicCount();
    private static final Parser<ConstellationBasicCount> PARSER = new AbstractParser<ConstellationBasicCount>() { // from class: cn.irisgw.live.ConstellationBasicCount.1
        /* renamed from: parsePartialFrom */
        public ConstellationBasicCount m1769parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new ConstellationBasicCount(codedInputStream, extensionRegistryLite);
        }
    };
    public static final int UID_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private int count_;
    private byte memoizedIsInitialized;
    private int uid_;

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ConstellationBasicCount$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ConstellationBasicCountOrBuilder {
        private int count_;
        private int uid_;

        private Builder() {
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_ConstellationBasicCount_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = ConstellationBasicCount.alwaysUseFieldBuilders;
        }

        /* renamed from: addRepeatedField */
        public Builder m1771addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public ConstellationBasicCount m1773build() {
            ConstellationBasicCount m1775buildPartial = m1775buildPartial();
            if (m1775buildPartial.isInitialized()) {
                return m1775buildPartial;
            }
            throw newUninitializedMessageException(m1775buildPartial);
        }

        /* renamed from: buildPartial */
        public ConstellationBasicCount m1775buildPartial() {
            ConstellationBasicCount constellationBasicCount = new ConstellationBasicCount(this);
            constellationBasicCount.count_ = this.count_;
            constellationBasicCount.uid_ = this.uid_;
            onBuilt();
            return constellationBasicCount;
        }

        /* renamed from: clear */
        public Builder m1779clear() {
            super.clear();
            this.count_ = 0;
            this.uid_ = 0;
            return this;
        }

        public Builder clearCount() {
            this.count_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clearField */
        public Builder m1781clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        /* renamed from: clearOneof */
        public Builder m1784clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearUid() {
            this.uid_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m1790clone() {
            return (Builder) super.clone();
        }

        @Override // cn.irisgw.live.ConstellationBasicCountOrBuilder
        public int getCount() {
            return this.count_;
        }

        /* renamed from: getDefaultInstanceForType */
        public ConstellationBasicCount m1792getDefaultInstanceForType() {
            return ConstellationBasicCount.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_ConstellationBasicCount_descriptor;
        }

        @Override // cn.irisgw.live.ConstellationBasicCountOrBuilder
        public int getUid() {
            return this.uid_;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_ConstellationBasicCount_fieldAccessorTable.ensureFieldAccessorsInitialized(ConstellationBasicCount.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(ConstellationBasicCount constellationBasicCount) {
            if (constellationBasicCount == ConstellationBasicCount.getDefaultInstance()) {
                return this;
            }
            if (constellationBasicCount.getCount() != 0) {
                setCount(constellationBasicCount.getCount());
            }
            if (constellationBasicCount.getUid() != 0) {
                setUid(constellationBasicCount.getUid());
            }
            m1801mergeUnknownFields(constellationBasicCount.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.ConstellationBasicCount.Builder m1798mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.ConstellationBasicCount.access$700()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.ConstellationBasicCount r0 = (cn.irisgw.live.ConstellationBasicCount) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.ConstellationBasicCount$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.ConstellationBasicCount r0 = (cn.irisgw.live.ConstellationBasicCount) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.ConstellationBasicCount$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.ConstellationBasicCount.Builder.m1798mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.ConstellationBasicCount$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m1797mergeFrom(Message message) {
            if (message instanceof ConstellationBasicCount) {
                return mergeFrom((ConstellationBasicCount) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m1801mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setCount(int i) {
            this.count_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setField */
        public Builder m1803setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        /* renamed from: setRepeatedField */
        public Builder m1805setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setUid(int i) {
            this.uid_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setUnknownFields */
        public final Builder m1807setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private ConstellationBasicCount() {
        this.memoizedIsInitialized = (byte) -1;
    }

    private ConstellationBasicCount(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.count_ = codedInputStream.readInt32();
                            } else if (readTag == 16) {
                                this.uid_ = codedInputStream.readInt32();
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

    private ConstellationBasicCount(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static ConstellationBasicCount getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_ConstellationBasicCount_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m1768toBuilder();
    }

    public static Builder newBuilder(ConstellationBasicCount constellationBasicCount) {
        return DEFAULT_INSTANCE.m1768toBuilder().mergeFrom(constellationBasicCount);
    }

    public static ConstellationBasicCount parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static ConstellationBasicCount parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ConstellationBasicCount parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ConstellationBasicCount) PARSER.parseFrom(byteString);
    }

    public static ConstellationBasicCount parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ConstellationBasicCount) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static ConstellationBasicCount parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static ConstellationBasicCount parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static ConstellationBasicCount parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static ConstellationBasicCount parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ConstellationBasicCount parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ConstellationBasicCount) PARSER.parseFrom(byteBuffer);
    }

    public static ConstellationBasicCount parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ConstellationBasicCount) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static ConstellationBasicCount parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ConstellationBasicCount) PARSER.parseFrom(bArr);
    }

    public static ConstellationBasicCount parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ConstellationBasicCount) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<ConstellationBasicCount> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ConstellationBasicCount) {
            ConstellationBasicCount constellationBasicCount = (ConstellationBasicCount) obj;
            return getCount() == constellationBasicCount.getCount() && getUid() == constellationBasicCount.getUid() && this.unknownFields.equals(constellationBasicCount.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.ConstellationBasicCountOrBuilder
    public int getCount() {
        return this.count_;
    }

    /* renamed from: getDefaultInstanceForType */
    public ConstellationBasicCount m1763getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public Parser<ConstellationBasicCount> getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        int i3 = this.count_;
        if (i3 != 0) {
            i2 = 0 + CodedOutputStream.computeInt32Size(1, i3);
        }
        int i4 = this.uid_;
        int i5 = i2;
        if (i4 != 0) {
            i5 = i2 + CodedOutputStream.computeInt32Size(2, i4);
        }
        int serializedSize = i5 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.ConstellationBasicCountOrBuilder
    public int getUid() {
        return this.uid_;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getCount()) * 37) + 2) * 53) + getUid()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_ConstellationBasicCount_fieldAccessorTable.ensureFieldAccessorsInitialized(ConstellationBasicCount.class, Builder.class);
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
    public Builder m1766newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m1765newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new ConstellationBasicCount();
    }

    /* renamed from: toBuilder */
    public Builder m1768toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.count_;
        if (i != 0) {
            codedOutputStream.writeInt32(1, i);
        }
        int i2 = this.uid_;
        if (i2 != 0) {
            codedOutputStream.writeInt32(2, i2);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
