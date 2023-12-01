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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/PkFinalType.class */
public final class PkFinalType extends GeneratedMessageV3 implements PkFinalTypeOrBuilder {
    public static final int COUNTDOWN_FIELD_NUMBER = 2;
    private static final PkFinalType DEFAULT_INSTANCE = new PkFinalType();
    private static final Parser<PkFinalType> PARSER = new AbstractParser<PkFinalType>() { // from class: cn.irisgw.live.PkFinalType.1
        /* renamed from: parsePartialFrom */
        public PkFinalType m6646parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new PkFinalType(codedInputStream, extensionRegistryLite);
        }
    };
    public static final int PK_TYPE_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private int countdown_;
    private byte memoizedIsInitialized;
    private int pkType_;

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/PkFinalType$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PkFinalTypeOrBuilder {
        private int countdown_;
        private int pkType_;

        private Builder() {
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_PkFinalType_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = PkFinalType.alwaysUseFieldBuilders;
        }

        /* renamed from: addRepeatedField */
        public Builder m6648addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public PkFinalType m6650build() {
            PkFinalType m6652buildPartial = m6652buildPartial();
            if (m6652buildPartial.isInitialized()) {
                return m6652buildPartial;
            }
            throw newUninitializedMessageException(m6652buildPartial);
        }

        /* renamed from: buildPartial */
        public PkFinalType m6652buildPartial() {
            PkFinalType pkFinalType = new PkFinalType(this);
            pkFinalType.pkType_ = this.pkType_;
            pkFinalType.countdown_ = this.countdown_;
            onBuilt();
            return pkFinalType;
        }

        /* renamed from: clear */
        public Builder m6656clear() {
            super.clear();
            this.pkType_ = 0;
            this.countdown_ = 0;
            return this;
        }

        public Builder clearCountdown() {
            this.countdown_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clearField */
        public Builder m6658clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        /* renamed from: clearOneof */
        public Builder m6661clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearPkType() {
            this.pkType_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m6667clone() {
            return (Builder) super.clone();
        }

        @Override // cn.irisgw.live.PkFinalTypeOrBuilder
        public int getCountdown() {
            return this.countdown_;
        }

        /* renamed from: getDefaultInstanceForType */
        public PkFinalType m6669getDefaultInstanceForType() {
            return PkFinalType.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_PkFinalType_descriptor;
        }

        @Override // cn.irisgw.live.PkFinalTypeOrBuilder
        public int getPkType() {
            return this.pkType_;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_PkFinalType_fieldAccessorTable.ensureFieldAccessorsInitialized(PkFinalType.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(PkFinalType pkFinalType) {
            if (pkFinalType == PkFinalType.getDefaultInstance()) {
                return this;
            }
            if (pkFinalType.getPkType() != 0) {
                setPkType(pkFinalType.getPkType());
            }
            if (pkFinalType.getCountdown() != 0) {
                setCountdown(pkFinalType.getCountdown());
            }
            m6678mergeUnknownFields(pkFinalType.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.PkFinalType.Builder m6675mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.PkFinalType.access$700()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.PkFinalType r0 = (cn.irisgw.live.PkFinalType) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.PkFinalType$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.PkFinalType r0 = (cn.irisgw.live.PkFinalType) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.PkFinalType$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.PkFinalType.Builder.m6675mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.PkFinalType$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m6674mergeFrom(Message message) {
            if (message instanceof PkFinalType) {
                return mergeFrom((PkFinalType) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m6678mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setCountdown(int i) {
            this.countdown_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setField */
        public Builder m6680setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setPkType(int i) {
            this.pkType_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setRepeatedField */
        public Builder m6682setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        /* renamed from: setUnknownFields */
        public final Builder m6684setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private PkFinalType() {
        this.memoizedIsInitialized = (byte) -1;
    }

    private PkFinalType(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.pkType_ = codedInputStream.readUInt32();
                            } else if (readTag == 16) {
                                this.countdown_ = codedInputStream.readUInt32();
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

    private PkFinalType(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static PkFinalType getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_PkFinalType_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m6645toBuilder();
    }

    public static Builder newBuilder(PkFinalType pkFinalType) {
        return DEFAULT_INSTANCE.m6645toBuilder().mergeFrom(pkFinalType);
    }

    public static PkFinalType parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static PkFinalType parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PkFinalType parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (PkFinalType) PARSER.parseFrom(byteString);
    }

    public static PkFinalType parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PkFinalType) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static PkFinalType parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static PkFinalType parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static PkFinalType parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static PkFinalType parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PkFinalType parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (PkFinalType) PARSER.parseFrom(byteBuffer);
    }

    public static PkFinalType parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PkFinalType) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static PkFinalType parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (PkFinalType) PARSER.parseFrom(bArr);
    }

    public static PkFinalType parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PkFinalType) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<PkFinalType> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PkFinalType) {
            PkFinalType pkFinalType = (PkFinalType) obj;
            return getPkType() == pkFinalType.getPkType() && getCountdown() == pkFinalType.getCountdown() && this.unknownFields.equals(pkFinalType.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.PkFinalTypeOrBuilder
    public int getCountdown() {
        return this.countdown_;
    }

    /* renamed from: getDefaultInstanceForType */
    public PkFinalType m6640getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public Parser<PkFinalType> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.PkFinalTypeOrBuilder
    public int getPkType() {
        return this.pkType_;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        int i3 = this.pkType_;
        if (i3 != 0) {
            i2 = 0 + CodedOutputStream.computeUInt32Size(1, i3);
        }
        int i4 = this.countdown_;
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
        int hashCode = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getPkType()) * 37) + 2) * 53) + getCountdown()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_PkFinalType_fieldAccessorTable.ensureFieldAccessorsInitialized(PkFinalType.class, Builder.class);
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
    public Builder m6643newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m6642newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new PkFinalType();
    }

    /* renamed from: toBuilder */
    public Builder m6645toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.pkType_;
        if (i != 0) {
            codedOutputStream.writeUInt32(1, i);
        }
        int i2 = this.countdown_;
        if (i2 != 0) {
            codedOutputStream.writeUInt32(2, i2);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
