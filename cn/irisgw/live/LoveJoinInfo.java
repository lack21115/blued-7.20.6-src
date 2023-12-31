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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LoveJoinInfo.class */
public final class LoveJoinInfo extends GeneratedMessageV3 implements LoveJoinInfoOrBuilder {
    public static final int CHOOSER_COUNT_FIELD_NUMBER = 1;
    public static final int CHOSEN_COUNT_FIELD_NUMBER = 2;
    private static final LoveJoinInfo DEFAULT_INSTANCE = new LoveJoinInfo();
    private static final Parser<LoveJoinInfo> PARSER = new AbstractParser<LoveJoinInfo>() { // from class: cn.irisgw.live.LoveJoinInfo.1
        /* renamed from: parsePartialFrom */
        public LoveJoinInfo m5377parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new LoveJoinInfo(codedInputStream, extensionRegistryLite);
        }
    };
    private static final long serialVersionUID = 0;
    private int chooserCount_;
    private int chosenCount_;
    private byte memoizedIsInitialized;

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LoveJoinInfo$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LoveJoinInfoOrBuilder {
        private int chooserCount_;
        private int chosenCount_;

        private Builder() {
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_LoveJoinInfo_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = LoveJoinInfo.alwaysUseFieldBuilders;
        }

        /* renamed from: addRepeatedField */
        public Builder m5379addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public LoveJoinInfo m5381build() {
            LoveJoinInfo m5383buildPartial = m5383buildPartial();
            if (m5383buildPartial.isInitialized()) {
                return m5383buildPartial;
            }
            throw newUninitializedMessageException(m5383buildPartial);
        }

        /* renamed from: buildPartial */
        public LoveJoinInfo m5383buildPartial() {
            LoveJoinInfo loveJoinInfo = new LoveJoinInfo(this);
            loveJoinInfo.chooserCount_ = this.chooserCount_;
            loveJoinInfo.chosenCount_ = this.chosenCount_;
            onBuilt();
            return loveJoinInfo;
        }

        /* renamed from: clear */
        public Builder m5387clear() {
            super.clear();
            this.chooserCount_ = 0;
            this.chosenCount_ = 0;
            return this;
        }

        public Builder clearChooserCount() {
            this.chooserCount_ = 0;
            onChanged();
            return this;
        }

        public Builder clearChosenCount() {
            this.chosenCount_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clearField */
        public Builder m5389clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        /* renamed from: clearOneof */
        public Builder m5392clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        /* renamed from: clone */
        public Builder m5398clone() {
            return (Builder) super.clone();
        }

        @Override // cn.irisgw.live.LoveJoinInfoOrBuilder
        public int getChooserCount() {
            return this.chooserCount_;
        }

        @Override // cn.irisgw.live.LoveJoinInfoOrBuilder
        public int getChosenCount() {
            return this.chosenCount_;
        }

        /* renamed from: getDefaultInstanceForType */
        public LoveJoinInfo m5400getDefaultInstanceForType() {
            return LoveJoinInfo.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_LoveJoinInfo_descriptor;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_LoveJoinInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(LoveJoinInfo.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(LoveJoinInfo loveJoinInfo) {
            if (loveJoinInfo == LoveJoinInfo.getDefaultInstance()) {
                return this;
            }
            if (loveJoinInfo.getChooserCount() != 0) {
                setChooserCount(loveJoinInfo.getChooserCount());
            }
            if (loveJoinInfo.getChosenCount() != 0) {
                setChosenCount(loveJoinInfo.getChosenCount());
            }
            m5409mergeUnknownFields(loveJoinInfo.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.LoveJoinInfo.Builder m5406mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.LoveJoinInfo.access$700()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.LoveJoinInfo r0 = (cn.irisgw.live.LoveJoinInfo) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.LoveJoinInfo$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.LoveJoinInfo r0 = (cn.irisgw.live.LoveJoinInfo) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.LoveJoinInfo$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.LoveJoinInfo.Builder.m5406mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.LoveJoinInfo$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m5405mergeFrom(Message message) {
            if (message instanceof LoveJoinInfo) {
                return mergeFrom((LoveJoinInfo) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m5409mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setChooserCount(int i) {
            this.chooserCount_ = i;
            onChanged();
            return this;
        }

        public Builder setChosenCount(int i) {
            this.chosenCount_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setField */
        public Builder m5411setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        /* renamed from: setRepeatedField */
        public Builder m5413setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        /* renamed from: setUnknownFields */
        public final Builder m5415setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private LoveJoinInfo() {
        this.memoizedIsInitialized = (byte) -1;
    }

    private LoveJoinInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.chooserCount_ = codedInputStream.readUInt32();
                            } else if (readTag == 16) {
                                this.chosenCount_ = codedInputStream.readUInt32();
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

    private LoveJoinInfo(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static LoveJoinInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_LoveJoinInfo_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m5376toBuilder();
    }

    public static Builder newBuilder(LoveJoinInfo loveJoinInfo) {
        return DEFAULT_INSTANCE.m5376toBuilder().mergeFrom(loveJoinInfo);
    }

    public static LoveJoinInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static LoveJoinInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LoveJoinInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (LoveJoinInfo) PARSER.parseFrom(byteString);
    }

    public static LoveJoinInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LoveJoinInfo) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static LoveJoinInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static LoveJoinInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static LoveJoinInfo parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static LoveJoinInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LoveJoinInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (LoveJoinInfo) PARSER.parseFrom(byteBuffer);
    }

    public static LoveJoinInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LoveJoinInfo) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static LoveJoinInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (LoveJoinInfo) PARSER.parseFrom(bArr);
    }

    public static LoveJoinInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LoveJoinInfo) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<LoveJoinInfo> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LoveJoinInfo) {
            LoveJoinInfo loveJoinInfo = (LoveJoinInfo) obj;
            return getChooserCount() == loveJoinInfo.getChooserCount() && getChosenCount() == loveJoinInfo.getChosenCount() && this.unknownFields.equals(loveJoinInfo.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.LoveJoinInfoOrBuilder
    public int getChooserCount() {
        return this.chooserCount_;
    }

    @Override // cn.irisgw.live.LoveJoinInfoOrBuilder
    public int getChosenCount() {
        return this.chosenCount_;
    }

    /* renamed from: getDefaultInstanceForType */
    public LoveJoinInfo m5371getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public Parser<LoveJoinInfo> getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        int i3 = this.chooserCount_;
        if (i3 != 0) {
            i2 = 0 + CodedOutputStream.computeUInt32Size(1, i3);
        }
        int i4 = this.chosenCount_;
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
        int hashCode = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getChooserCount()) * 37) + 2) * 53) + getChosenCount()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_LoveJoinInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(LoveJoinInfo.class, Builder.class);
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
    public Builder m5374newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m5373newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new LoveJoinInfo();
    }

    /* renamed from: toBuilder */
    public Builder m5376toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.chooserCount_;
        if (i != 0) {
            codedOutputStream.writeUInt32(1, i);
        }
        int i2 = this.chosenCount_;
        if (i2 != 0) {
            codedOutputStream.writeUInt32(2, i2);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
