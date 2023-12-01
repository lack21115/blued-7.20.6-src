package cn.irisgw.live;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ResetWishList.class */
public final class ResetWishList extends GeneratedMessageV3 implements ResetWishListOrBuilder {
    public static final int LID_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private long lid_;
    private byte memoizedIsInitialized;
    private static final ResetWishList DEFAULT_INSTANCE = new ResetWishList();
    private static final Parser<ResetWishList> PARSER = new AbstractParser<ResetWishList>() { // from class: cn.irisgw.live.ResetWishList.1
        /* renamed from: parsePartialFrom */
        public ResetWishList m7171parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new ResetWishList(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ResetWishList$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ResetWishListOrBuilder {
        private long lid_;

        private Builder() {
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_ResetWishList_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = ResetWishList.alwaysUseFieldBuilders;
        }

        /* renamed from: addRepeatedField */
        public Builder m7173addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public ResetWishList m7175build() {
            ResetWishList m7177buildPartial = m7177buildPartial();
            if (m7177buildPartial.isInitialized()) {
                return m7177buildPartial;
            }
            throw newUninitializedMessageException(m7177buildPartial);
        }

        /* renamed from: buildPartial */
        public ResetWishList m7177buildPartial() {
            ResetWishList resetWishList = new ResetWishList(this);
            resetWishList.lid_ = this.lid_;
            onBuilt();
            return resetWishList;
        }

        /* renamed from: clear */
        public Builder m7181clear() {
            super.clear();
            this.lid_ = ResetWishList.serialVersionUID;
            return this;
        }

        /* renamed from: clearField */
        public Builder m7183clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearLid() {
            this.lid_ = ResetWishList.serialVersionUID;
            onChanged();
            return this;
        }

        /* renamed from: clearOneof */
        public Builder m7186clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        /* renamed from: clone */
        public Builder m7192clone() {
            return (Builder) super.clone();
        }

        /* renamed from: getDefaultInstanceForType */
        public ResetWishList m7194getDefaultInstanceForType() {
            return ResetWishList.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_ResetWishList_descriptor;
        }

        @Override // cn.irisgw.live.ResetWishListOrBuilder
        public long getLid() {
            return this.lid_;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_ResetWishList_fieldAccessorTable.ensureFieldAccessorsInitialized(ResetWishList.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(ResetWishList resetWishList) {
            if (resetWishList == ResetWishList.getDefaultInstance()) {
                return this;
            }
            if (resetWishList.getLid() != ResetWishList.serialVersionUID) {
                setLid(resetWishList.getLid());
            }
            m7203mergeUnknownFields(resetWishList.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.ResetWishList.Builder m7200mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.ResetWishList.access$600()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.ResetWishList r0 = (cn.irisgw.live.ResetWishList) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.ResetWishList$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.ResetWishList r0 = (cn.irisgw.live.ResetWishList) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.ResetWishList$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.ResetWishList.Builder.m7200mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.ResetWishList$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m7199mergeFrom(Message message) {
            if (message instanceof ResetWishList) {
                return mergeFrom((ResetWishList) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m7203mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        /* renamed from: setField */
        public Builder m7205setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setLid(long j) {
            this.lid_ = j;
            onChanged();
            return this;
        }

        /* renamed from: setRepeatedField */
        public Builder m7207setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        /* renamed from: setUnknownFields */
        public final Builder m7209setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private ResetWishList() {
        this.memoizedIsInitialized = (byte) -1;
    }

    private ResetWishList(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.lid_ = codedInputStream.readUInt64();
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

    private ResetWishList(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static ResetWishList getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_ResetWishList_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m7170toBuilder();
    }

    public static Builder newBuilder(ResetWishList resetWishList) {
        return DEFAULT_INSTANCE.m7170toBuilder().mergeFrom(resetWishList);
    }

    public static ResetWishList parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static ResetWishList parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ResetWishList parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ResetWishList) PARSER.parseFrom(byteString);
    }

    public static ResetWishList parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ResetWishList) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static ResetWishList parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static ResetWishList parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static ResetWishList parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static ResetWishList parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ResetWishList parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ResetWishList) PARSER.parseFrom(byteBuffer);
    }

    public static ResetWishList parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ResetWishList) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static ResetWishList parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ResetWishList) PARSER.parseFrom(bArr);
    }

    public static ResetWishList parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ResetWishList) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<ResetWishList> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ResetWishList) {
            ResetWishList resetWishList = (ResetWishList) obj;
            return getLid() == resetWishList.getLid() && this.unknownFields.equals(resetWishList.unknownFields);
        }
        return super.equals(obj);
    }

    /* renamed from: getDefaultInstanceForType */
    public ResetWishList m7165getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.ResetWishListOrBuilder
    public long getLid() {
        return this.lid_;
    }

    public Parser<ResetWishList> getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        long j = this.lid_;
        if (j != serialVersionUID) {
            i2 = 0 + CodedOutputStream.computeUInt64Size(1, j);
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
        int hashCode = ((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(getLid())) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_ResetWishList_fieldAccessorTable.ensureFieldAccessorsInitialized(ResetWishList.class, Builder.class);
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
    public Builder m7168newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m7167newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new ResetWishList();
    }

    /* renamed from: toBuilder */
    public Builder m7170toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        long j = this.lid_;
        if (j != serialVersionUID) {
            codedOutputStream.writeUInt64(1, j);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
