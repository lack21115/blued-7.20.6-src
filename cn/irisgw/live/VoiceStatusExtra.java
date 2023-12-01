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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/VoiceStatusExtra.class */
public final class VoiceStatusExtra extends GeneratedMessageV3 implements VoiceStatusExtraOrBuilder {
    private static final VoiceStatusExtra DEFAULT_INSTANCE = new VoiceStatusExtra();
    private static final Parser<VoiceStatusExtra> PARSER = new AbstractParser<VoiceStatusExtra>() { // from class: cn.irisgw.live.VoiceStatusExtra.1
        /* renamed from: parsePartialFrom */
        public VoiceStatusExtra m8119parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new VoiceStatusExtra(codedInputStream, extensionRegistryLite);
        }
    };
    public static final int UID_FIELD_NUMBER = 1;
    public static final int VOICE_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private int uid_;
    private int voice_;

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/VoiceStatusExtra$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements VoiceStatusExtraOrBuilder {
        private int uid_;
        private int voice_;

        private Builder() {
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_VoiceStatusExtra_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = VoiceStatusExtra.alwaysUseFieldBuilders;
        }

        /* renamed from: addRepeatedField */
        public Builder m8121addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public VoiceStatusExtra m8123build() {
            VoiceStatusExtra m8125buildPartial = m8125buildPartial();
            if (m8125buildPartial.isInitialized()) {
                return m8125buildPartial;
            }
            throw newUninitializedMessageException(m8125buildPartial);
        }

        /* renamed from: buildPartial */
        public VoiceStatusExtra m8125buildPartial() {
            VoiceStatusExtra voiceStatusExtra = new VoiceStatusExtra(this);
            voiceStatusExtra.uid_ = this.uid_;
            voiceStatusExtra.voice_ = this.voice_;
            onBuilt();
            return voiceStatusExtra;
        }

        /* renamed from: clear */
        public Builder m8129clear() {
            super.clear();
            this.uid_ = 0;
            this.voice_ = 0;
            return this;
        }

        /* renamed from: clearField */
        public Builder m8131clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        /* renamed from: clearOneof */
        public Builder m8134clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearUid() {
            this.uid_ = 0;
            onChanged();
            return this;
        }

        public Builder clearVoice() {
            this.voice_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m8140clone() {
            return (Builder) super.clone();
        }

        /* renamed from: getDefaultInstanceForType */
        public VoiceStatusExtra m8142getDefaultInstanceForType() {
            return VoiceStatusExtra.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_VoiceStatusExtra_descriptor;
        }

        @Override // cn.irisgw.live.VoiceStatusExtraOrBuilder
        public int getUid() {
            return this.uid_;
        }

        @Override // cn.irisgw.live.VoiceStatusExtraOrBuilder
        public int getVoice() {
            return this.voice_;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_VoiceStatusExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(VoiceStatusExtra.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(VoiceStatusExtra voiceStatusExtra) {
            if (voiceStatusExtra == VoiceStatusExtra.getDefaultInstance()) {
                return this;
            }
            if (voiceStatusExtra.getUid() != 0) {
                setUid(voiceStatusExtra.getUid());
            }
            if (voiceStatusExtra.getVoice() != 0) {
                setVoice(voiceStatusExtra.getVoice());
            }
            m8151mergeUnknownFields(voiceStatusExtra.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.VoiceStatusExtra.Builder m8148mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.VoiceStatusExtra.access$700()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.VoiceStatusExtra r0 = (cn.irisgw.live.VoiceStatusExtra) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.VoiceStatusExtra$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.VoiceStatusExtra r0 = (cn.irisgw.live.VoiceStatusExtra) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.VoiceStatusExtra$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.VoiceStatusExtra.Builder.m8148mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.VoiceStatusExtra$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m8147mergeFrom(Message message) {
            if (message instanceof VoiceStatusExtra) {
                return mergeFrom((VoiceStatusExtra) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m8151mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        /* renamed from: setField */
        public Builder m8153setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        /* renamed from: setRepeatedField */
        public Builder m8155setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setUid(int i) {
            this.uid_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setUnknownFields */
        public final Builder m8157setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }

        public Builder setVoice(int i) {
            this.voice_ = i;
            onChanged();
            return this;
        }
    }

    private VoiceStatusExtra() {
        this.memoizedIsInitialized = (byte) -1;
    }

    private VoiceStatusExtra(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.uid_ = codedInputStream.readUInt32();
                            } else if (readTag == 16) {
                                this.voice_ = codedInputStream.readUInt32();
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

    private VoiceStatusExtra(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static VoiceStatusExtra getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_VoiceStatusExtra_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m8118toBuilder();
    }

    public static Builder newBuilder(VoiceStatusExtra voiceStatusExtra) {
        return DEFAULT_INSTANCE.m8118toBuilder().mergeFrom(voiceStatusExtra);
    }

    public static VoiceStatusExtra parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static VoiceStatusExtra parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static VoiceStatusExtra parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (VoiceStatusExtra) PARSER.parseFrom(byteString);
    }

    public static VoiceStatusExtra parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (VoiceStatusExtra) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static VoiceStatusExtra parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static VoiceStatusExtra parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static VoiceStatusExtra parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static VoiceStatusExtra parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static VoiceStatusExtra parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (VoiceStatusExtra) PARSER.parseFrom(byteBuffer);
    }

    public static VoiceStatusExtra parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (VoiceStatusExtra) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static VoiceStatusExtra parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (VoiceStatusExtra) PARSER.parseFrom(bArr);
    }

    public static VoiceStatusExtra parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (VoiceStatusExtra) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<VoiceStatusExtra> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof VoiceStatusExtra) {
            VoiceStatusExtra voiceStatusExtra = (VoiceStatusExtra) obj;
            return getUid() == voiceStatusExtra.getUid() && getVoice() == voiceStatusExtra.getVoice() && this.unknownFields.equals(voiceStatusExtra.unknownFields);
        }
        return super.equals(obj);
    }

    /* renamed from: getDefaultInstanceForType */
    public VoiceStatusExtra m8113getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public Parser<VoiceStatusExtra> getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        int i3 = this.uid_;
        if (i3 != 0) {
            i2 = 0 + CodedOutputStream.computeUInt32Size(1, i3);
        }
        int i4 = this.voice_;
        int i5 = i2;
        if (i4 != 0) {
            i5 = i2 + CodedOutputStream.computeUInt32Size(2, i4);
        }
        int serializedSize = i5 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.VoiceStatusExtraOrBuilder
    public int getUid() {
        return this.uid_;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // cn.irisgw.live.VoiceStatusExtraOrBuilder
    public int getVoice() {
        return this.voice_;
    }

    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getUid()) * 37) + 2) * 53) + getVoice()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_VoiceStatusExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(VoiceStatusExtra.class, Builder.class);
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
    public Builder m8116newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m8115newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new VoiceStatusExtra();
    }

    /* renamed from: toBuilder */
    public Builder m8118toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.uid_;
        if (i != 0) {
            codedOutputStream.writeUInt32(1, i);
        }
        int i2 = this.voice_;
        if (i2 != 0) {
            codedOutputStream.writeUInt32(2, i2);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
