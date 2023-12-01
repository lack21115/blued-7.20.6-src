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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/PKOperated.class */
public final class PKOperated extends GeneratedMessageV3 implements PKOperatedOrBuilder {
    private static final PKOperated DEFAULT_INSTANCE = new PKOperated();
    private static final Parser<PKOperated> PARSER = new AbstractParser<PKOperated>() { // from class: cn.irisgw.live.PKOperated.1
        /* renamed from: parsePartialFrom */
        public PKOperated m6458parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new PKOperated(codedInputStream, extensionRegistryLite);
        }
    };
    public static final int SOURCE_LID_FIELD_NUMBER = 1;
    public static final int SOURCE_UID_FIELD_NUMBER = 2;
    public static final int TARGET_LID_FIELD_NUMBER = 3;
    public static final int TARGET_STATUS_FIELD_NUMBER = 5;
    public static final int TARGET_UID_FIELD_NUMBER = 4;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private int sourceLid_;
    private int sourceUid_;
    private int targetLid_;
    private int targetStatus_;
    private int targetUid_;

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/PKOperated$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PKOperatedOrBuilder {
        private int sourceLid_;
        private int sourceUid_;
        private int targetLid_;
        private int targetStatus_;
        private int targetUid_;

        private Builder() {
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_PKOperated_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = PKOperated.alwaysUseFieldBuilders;
        }

        /* renamed from: addRepeatedField */
        public Builder m6460addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public PKOperated m6462build() {
            PKOperated m6464buildPartial = m6464buildPartial();
            if (m6464buildPartial.isInitialized()) {
                return m6464buildPartial;
            }
            throw newUninitializedMessageException(m6464buildPartial);
        }

        /* renamed from: buildPartial */
        public PKOperated m6464buildPartial() {
            PKOperated pKOperated = new PKOperated(this);
            pKOperated.sourceLid_ = this.sourceLid_;
            pKOperated.sourceUid_ = this.sourceUid_;
            pKOperated.targetLid_ = this.targetLid_;
            pKOperated.targetUid_ = this.targetUid_;
            pKOperated.targetStatus_ = this.targetStatus_;
            onBuilt();
            return pKOperated;
        }

        /* renamed from: clear */
        public Builder m6468clear() {
            super.clear();
            this.sourceLid_ = 0;
            this.sourceUid_ = 0;
            this.targetLid_ = 0;
            this.targetUid_ = 0;
            this.targetStatus_ = 0;
            return this;
        }

        /* renamed from: clearField */
        public Builder m6470clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        /* renamed from: clearOneof */
        public Builder m6473clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearSourceLid() {
            this.sourceLid_ = 0;
            onChanged();
            return this;
        }

        public Builder clearSourceUid() {
            this.sourceUid_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTargetLid() {
            this.targetLid_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTargetStatus() {
            this.targetStatus_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTargetUid() {
            this.targetUid_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m6479clone() {
            return (Builder) super.clone();
        }

        /* renamed from: getDefaultInstanceForType */
        public PKOperated m6481getDefaultInstanceForType() {
            return PKOperated.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_PKOperated_descriptor;
        }

        @Override // cn.irisgw.live.PKOperatedOrBuilder
        public int getSourceLid() {
            return this.sourceLid_;
        }

        @Override // cn.irisgw.live.PKOperatedOrBuilder
        public int getSourceUid() {
            return this.sourceUid_;
        }

        @Override // cn.irisgw.live.PKOperatedOrBuilder
        public int getTargetLid() {
            return this.targetLid_;
        }

        @Override // cn.irisgw.live.PKOperatedOrBuilder
        public int getTargetStatus() {
            return this.targetStatus_;
        }

        @Override // cn.irisgw.live.PKOperatedOrBuilder
        public int getTargetUid() {
            return this.targetUid_;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_PKOperated_fieldAccessorTable.ensureFieldAccessorsInitialized(PKOperated.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(PKOperated pKOperated) {
            if (pKOperated == PKOperated.getDefaultInstance()) {
                return this;
            }
            if (pKOperated.getSourceLid() != 0) {
                setSourceLid(pKOperated.getSourceLid());
            }
            if (pKOperated.getSourceUid() != 0) {
                setSourceUid(pKOperated.getSourceUid());
            }
            if (pKOperated.getTargetLid() != 0) {
                setTargetLid(pKOperated.getTargetLid());
            }
            if (pKOperated.getTargetUid() != 0) {
                setTargetUid(pKOperated.getTargetUid());
            }
            if (pKOperated.getTargetStatus() != 0) {
                setTargetStatus(pKOperated.getTargetStatus());
            }
            m6490mergeUnknownFields(pKOperated.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.PKOperated.Builder m6487mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.PKOperated.access$1000()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.PKOperated r0 = (cn.irisgw.live.PKOperated) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.PKOperated$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.PKOperated r0 = (cn.irisgw.live.PKOperated) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.PKOperated$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.PKOperated.Builder.m6487mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.PKOperated$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m6486mergeFrom(Message message) {
            if (message instanceof PKOperated) {
                return mergeFrom((PKOperated) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m6490mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        /* renamed from: setField */
        public Builder m6492setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        /* renamed from: setRepeatedField */
        public Builder m6494setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setSourceLid(int i) {
            this.sourceLid_ = i;
            onChanged();
            return this;
        }

        public Builder setSourceUid(int i) {
            this.sourceUid_ = i;
            onChanged();
            return this;
        }

        public Builder setTargetLid(int i) {
            this.targetLid_ = i;
            onChanged();
            return this;
        }

        public Builder setTargetStatus(int i) {
            this.targetStatus_ = i;
            onChanged();
            return this;
        }

        public Builder setTargetUid(int i) {
            this.targetUid_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setUnknownFields */
        public final Builder m6496setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private PKOperated() {
        this.memoizedIsInitialized = (byte) -1;
    }

    private PKOperated(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.sourceLid_ = codedInputStream.readUInt32();
                        } else if (readTag == 16) {
                            this.sourceUid_ = codedInputStream.readUInt32();
                        } else if (readTag == 24) {
                            this.targetLid_ = codedInputStream.readUInt32();
                        } else if (readTag == 32) {
                            this.targetUid_ = codedInputStream.readUInt32();
                        } else if (readTag == 40) {
                            this.targetStatus_ = codedInputStream.readUInt32();
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

    private PKOperated(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static PKOperated getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_PKOperated_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m6457toBuilder();
    }

    public static Builder newBuilder(PKOperated pKOperated) {
        return DEFAULT_INSTANCE.m6457toBuilder().mergeFrom(pKOperated);
    }

    public static PKOperated parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static PKOperated parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PKOperated parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (PKOperated) PARSER.parseFrom(byteString);
    }

    public static PKOperated parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PKOperated) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static PKOperated parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static PKOperated parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static PKOperated parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static PKOperated parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PKOperated parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (PKOperated) PARSER.parseFrom(byteBuffer);
    }

    public static PKOperated parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PKOperated) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static PKOperated parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (PKOperated) PARSER.parseFrom(bArr);
    }

    public static PKOperated parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PKOperated) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<PKOperated> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PKOperated) {
            PKOperated pKOperated = (PKOperated) obj;
            return getSourceLid() == pKOperated.getSourceLid() && getSourceUid() == pKOperated.getSourceUid() && getTargetLid() == pKOperated.getTargetLid() && getTargetUid() == pKOperated.getTargetUid() && getTargetStatus() == pKOperated.getTargetStatus() && this.unknownFields.equals(pKOperated.unknownFields);
        }
        return super.equals(obj);
    }

    /* renamed from: getDefaultInstanceForType */
    public PKOperated m6452getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public Parser<PKOperated> getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        int i3 = this.sourceLid_;
        if (i3 != 0) {
            i2 = 0 + CodedOutputStream.computeUInt32Size(1, i3);
        }
        int i4 = this.sourceUid_;
        int i5 = i2;
        if (i4 != 0) {
            i5 = i2 + CodedOutputStream.computeUInt32Size(2, i4);
        }
        int i6 = this.targetLid_;
        int i7 = i5;
        if (i6 != 0) {
            i7 = i5 + CodedOutputStream.computeUInt32Size(3, i6);
        }
        int i8 = this.targetUid_;
        int i9 = i7;
        if (i8 != 0) {
            i9 = i7 + CodedOutputStream.computeUInt32Size(4, i8);
        }
        int i10 = this.targetStatus_;
        int i11 = i9;
        if (i10 != 0) {
            i11 = i9 + CodedOutputStream.computeUInt32Size(5, i10);
        }
        int serializedSize = i11 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.PKOperatedOrBuilder
    public int getSourceLid() {
        return this.sourceLid_;
    }

    @Override // cn.irisgw.live.PKOperatedOrBuilder
    public int getSourceUid() {
        return this.sourceUid_;
    }

    @Override // cn.irisgw.live.PKOperatedOrBuilder
    public int getTargetLid() {
        return this.targetLid_;
    }

    @Override // cn.irisgw.live.PKOperatedOrBuilder
    public int getTargetStatus() {
        return this.targetStatus_;
    }

    @Override // cn.irisgw.live.PKOperatedOrBuilder
    public int getTargetUid() {
        return this.targetUid_;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getSourceLid()) * 37) + 2) * 53) + getSourceUid()) * 37) + 3) * 53) + getTargetLid()) * 37) + 4) * 53) + getTargetUid()) * 37) + 5) * 53) + getTargetStatus()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_PKOperated_fieldAccessorTable.ensureFieldAccessorsInitialized(PKOperated.class, Builder.class);
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
    public Builder m6455newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m6454newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new PKOperated();
    }

    /* renamed from: toBuilder */
    public Builder m6457toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.sourceLid_;
        if (i != 0) {
            codedOutputStream.writeUInt32(1, i);
        }
        int i2 = this.sourceUid_;
        if (i2 != 0) {
            codedOutputStream.writeUInt32(2, i2);
        }
        int i3 = this.targetLid_;
        if (i3 != 0) {
            codedOutputStream.writeUInt32(3, i3);
        }
        int i4 = this.targetUid_;
        if (i4 != 0) {
            codedOutputStream.writeUInt32(4, i4);
        }
        int i5 = this.targetStatus_;
        if (i5 != 0) {
            codedOutputStream.writeUInt32(5, i5);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
