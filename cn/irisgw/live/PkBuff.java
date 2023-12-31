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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/PkBuff.class */
public final class PkBuff extends GeneratedMessageV3 implements PkBuffOrBuilder {
    public static final int BUFF_COUNTDOWN_FIELD_NUMBER = 1;
    private static final PkBuff DEFAULT_INSTANCE = new PkBuff();
    private static final Parser<PkBuff> PARSER = new AbstractParser<PkBuff>() { // from class: cn.irisgw.live.PkBuff.1
        /* renamed from: parsePartialFrom */
        public PkBuff m6599parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new PkBuff(codedInputStream, extensionRegistryLite);
        }
    };
    private static final long serialVersionUID = 0;
    private int buffCountdown_;
    private byte memoizedIsInitialized;

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/PkBuff$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PkBuffOrBuilder {
        private int buffCountdown_;

        private Builder() {
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_PkBuff_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = PkBuff.alwaysUseFieldBuilders;
        }

        /* renamed from: addRepeatedField */
        public Builder m6601addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public PkBuff m6603build() {
            PkBuff m6605buildPartial = m6605buildPartial();
            if (m6605buildPartial.isInitialized()) {
                return m6605buildPartial;
            }
            throw newUninitializedMessageException(m6605buildPartial);
        }

        /* renamed from: buildPartial */
        public PkBuff m6605buildPartial() {
            PkBuff pkBuff = new PkBuff(this);
            pkBuff.buffCountdown_ = this.buffCountdown_;
            onBuilt();
            return pkBuff;
        }

        /* renamed from: clear */
        public Builder m6609clear() {
            super.clear();
            this.buffCountdown_ = 0;
            return this;
        }

        public Builder clearBuffCountdown() {
            this.buffCountdown_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clearField */
        public Builder m6611clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        /* renamed from: clearOneof */
        public Builder m6614clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        /* renamed from: clone */
        public Builder m6620clone() {
            return (Builder) super.clone();
        }

        @Override // cn.irisgw.live.PkBuffOrBuilder
        public int getBuffCountdown() {
            return this.buffCountdown_;
        }

        /* renamed from: getDefaultInstanceForType */
        public PkBuff m6622getDefaultInstanceForType() {
            return PkBuff.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_PkBuff_descriptor;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_PkBuff_fieldAccessorTable.ensureFieldAccessorsInitialized(PkBuff.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(PkBuff pkBuff) {
            if (pkBuff == PkBuff.getDefaultInstance()) {
                return this;
            }
            if (pkBuff.getBuffCountdown() != 0) {
                setBuffCountdown(pkBuff.getBuffCountdown());
            }
            m6631mergeUnknownFields(pkBuff.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.PkBuff.Builder m6628mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.PkBuff.access$600()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.PkBuff r0 = (cn.irisgw.live.PkBuff) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.PkBuff$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.PkBuff r0 = (cn.irisgw.live.PkBuff) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.PkBuff$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.PkBuff.Builder.m6628mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.PkBuff$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m6627mergeFrom(Message message) {
            if (message instanceof PkBuff) {
                return mergeFrom((PkBuff) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m6631mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setBuffCountdown(int i) {
            this.buffCountdown_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setField */
        public Builder m6633setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        /* renamed from: setRepeatedField */
        public Builder m6635setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        /* renamed from: setUnknownFields */
        public final Builder m6637setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private PkBuff() {
        this.memoizedIsInitialized = (byte) -1;
    }

    private PkBuff(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.buffCountdown_ = codedInputStream.readUInt32();
                        } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (IOException e) {
                    throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.setUnfinishedMessage(this);
                }
            } finally {
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
            }
        }
    }

    private PkBuff(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static PkBuff getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_PkBuff_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m6598toBuilder();
    }

    public static Builder newBuilder(PkBuff pkBuff) {
        return DEFAULT_INSTANCE.m6598toBuilder().mergeFrom(pkBuff);
    }

    public static PkBuff parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static PkBuff parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PkBuff parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (PkBuff) PARSER.parseFrom(byteString);
    }

    public static PkBuff parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PkBuff) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static PkBuff parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static PkBuff parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static PkBuff parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static PkBuff parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PkBuff parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (PkBuff) PARSER.parseFrom(byteBuffer);
    }

    public static PkBuff parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PkBuff) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static PkBuff parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (PkBuff) PARSER.parseFrom(bArr);
    }

    public static PkBuff parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PkBuff) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<PkBuff> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PkBuff) {
            PkBuff pkBuff = (PkBuff) obj;
            return getBuffCountdown() == pkBuff.getBuffCountdown() && this.unknownFields.equals(pkBuff.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.PkBuffOrBuilder
    public int getBuffCountdown() {
        return this.buffCountdown_;
    }

    /* renamed from: getDefaultInstanceForType */
    public PkBuff m6593getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public Parser<PkBuff> getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        int i3 = this.buffCountdown_;
        if (i3 != 0) {
            i2 = 0 + CodedOutputStream.computeUInt32Size(1, i3);
        }
        int serializedSize = i2 + this.unknownFields.getSerializedSize();
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
        int hashCode = ((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getBuffCountdown()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_PkBuff_fieldAccessorTable.ensureFieldAccessorsInitialized(PkBuff.class, Builder.class);
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
    public Builder m6596newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m6595newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new PkBuff();
    }

    /* renamed from: toBuilder */
    public Builder m6598toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.buffCountdown_;
        if (i != 0) {
            codedOutputStream.writeUInt32(1, i);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
