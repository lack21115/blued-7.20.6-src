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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LikeUpdateCurrentBeans.class */
public final class LikeUpdateCurrentBeans extends GeneratedMessageV3 implements LikeUpdateCurrentBeansOrBuilder {
    public static final int BEANS_CURRENT_COUNT_FIELD_NUMBER = 1;
    private static final LikeUpdateCurrentBeans DEFAULT_INSTANCE = new LikeUpdateCurrentBeans();
    private static final Parser<LikeUpdateCurrentBeans> PARSER = new AbstractParser<LikeUpdateCurrentBeans>() { // from class: cn.irisgw.live.LikeUpdateCurrentBeans.1
        /* renamed from: parsePartialFrom */
        public LikeUpdateCurrentBeans m3948parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new LikeUpdateCurrentBeans(codedInputStream, extensionRegistryLite);
        }
    };
    private static final long serialVersionUID = 0;
    private int beansCurrentCount_;
    private byte memoizedIsInitialized;

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LikeUpdateCurrentBeans$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LikeUpdateCurrentBeansOrBuilder {
        private int beansCurrentCount_;

        private Builder() {
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_LikeUpdateCurrentBeans_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = LikeUpdateCurrentBeans.alwaysUseFieldBuilders;
        }

        /* renamed from: addRepeatedField */
        public Builder m3950addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public LikeUpdateCurrentBeans m3952build() {
            LikeUpdateCurrentBeans m3954buildPartial = m3954buildPartial();
            if (m3954buildPartial.isInitialized()) {
                return m3954buildPartial;
            }
            throw newUninitializedMessageException(m3954buildPartial);
        }

        /* renamed from: buildPartial */
        public LikeUpdateCurrentBeans m3954buildPartial() {
            LikeUpdateCurrentBeans likeUpdateCurrentBeans = new LikeUpdateCurrentBeans(this);
            likeUpdateCurrentBeans.beansCurrentCount_ = this.beansCurrentCount_;
            onBuilt();
            return likeUpdateCurrentBeans;
        }

        /* renamed from: clear */
        public Builder m3958clear() {
            super.clear();
            this.beansCurrentCount_ = 0;
            return this;
        }

        public Builder clearBeansCurrentCount() {
            this.beansCurrentCount_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clearField */
        public Builder m3960clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        /* renamed from: clearOneof */
        public Builder m3963clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        /* renamed from: clone */
        public Builder m3969clone() {
            return (Builder) super.clone();
        }

        @Override // cn.irisgw.live.LikeUpdateCurrentBeansOrBuilder
        public int getBeansCurrentCount() {
            return this.beansCurrentCount_;
        }

        /* renamed from: getDefaultInstanceForType */
        public LikeUpdateCurrentBeans m3971getDefaultInstanceForType() {
            return LikeUpdateCurrentBeans.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_LikeUpdateCurrentBeans_descriptor;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_LikeUpdateCurrentBeans_fieldAccessorTable.ensureFieldAccessorsInitialized(LikeUpdateCurrentBeans.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(LikeUpdateCurrentBeans likeUpdateCurrentBeans) {
            if (likeUpdateCurrentBeans == LikeUpdateCurrentBeans.getDefaultInstance()) {
                return this;
            }
            if (likeUpdateCurrentBeans.getBeansCurrentCount() != 0) {
                setBeansCurrentCount(likeUpdateCurrentBeans.getBeansCurrentCount());
            }
            m3980mergeUnknownFields(likeUpdateCurrentBeans.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.LikeUpdateCurrentBeans.Builder m3977mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.LikeUpdateCurrentBeans.access$600()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.LikeUpdateCurrentBeans r0 = (cn.irisgw.live.LikeUpdateCurrentBeans) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.LikeUpdateCurrentBeans$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.LikeUpdateCurrentBeans r0 = (cn.irisgw.live.LikeUpdateCurrentBeans) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.LikeUpdateCurrentBeans$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.LikeUpdateCurrentBeans.Builder.m3977mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.LikeUpdateCurrentBeans$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m3976mergeFrom(Message message) {
            if (message instanceof LikeUpdateCurrentBeans) {
                return mergeFrom((LikeUpdateCurrentBeans) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m3980mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setBeansCurrentCount(int i) {
            this.beansCurrentCount_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setField */
        public Builder m3982setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        /* renamed from: setRepeatedField */
        public Builder m3984setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        /* renamed from: setUnknownFields */
        public final Builder m3986setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private LikeUpdateCurrentBeans() {
        this.memoizedIsInitialized = (byte) -1;
    }

    private LikeUpdateCurrentBeans(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.beansCurrentCount_ = codedInputStream.readUInt32();
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

    private LikeUpdateCurrentBeans(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static LikeUpdateCurrentBeans getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_LikeUpdateCurrentBeans_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m3947toBuilder();
    }

    public static Builder newBuilder(LikeUpdateCurrentBeans likeUpdateCurrentBeans) {
        return DEFAULT_INSTANCE.m3947toBuilder().mergeFrom(likeUpdateCurrentBeans);
    }

    public static LikeUpdateCurrentBeans parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static LikeUpdateCurrentBeans parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LikeUpdateCurrentBeans parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (LikeUpdateCurrentBeans) PARSER.parseFrom(byteString);
    }

    public static LikeUpdateCurrentBeans parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LikeUpdateCurrentBeans) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static LikeUpdateCurrentBeans parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static LikeUpdateCurrentBeans parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static LikeUpdateCurrentBeans parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static LikeUpdateCurrentBeans parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LikeUpdateCurrentBeans parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (LikeUpdateCurrentBeans) PARSER.parseFrom(byteBuffer);
    }

    public static LikeUpdateCurrentBeans parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LikeUpdateCurrentBeans) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static LikeUpdateCurrentBeans parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (LikeUpdateCurrentBeans) PARSER.parseFrom(bArr);
    }

    public static LikeUpdateCurrentBeans parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LikeUpdateCurrentBeans) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<LikeUpdateCurrentBeans> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LikeUpdateCurrentBeans) {
            LikeUpdateCurrentBeans likeUpdateCurrentBeans = (LikeUpdateCurrentBeans) obj;
            return getBeansCurrentCount() == likeUpdateCurrentBeans.getBeansCurrentCount() && this.unknownFields.equals(likeUpdateCurrentBeans.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.LikeUpdateCurrentBeansOrBuilder
    public int getBeansCurrentCount() {
        return this.beansCurrentCount_;
    }

    /* renamed from: getDefaultInstanceForType */
    public LikeUpdateCurrentBeans m3942getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public Parser<LikeUpdateCurrentBeans> getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        int i3 = this.beansCurrentCount_;
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
        int hashCode = ((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getBeansCurrentCount()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_LikeUpdateCurrentBeans_fieldAccessorTable.ensureFieldAccessorsInitialized(LikeUpdateCurrentBeans.class, Builder.class);
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
    public Builder m3945newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m3944newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new LikeUpdateCurrentBeans();
    }

    /* renamed from: toBuilder */
    public Builder m3947toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.beansCurrentCount_;
        if (i != 0) {
            codedOutputStream.writeUInt32(1, i);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
