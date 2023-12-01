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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveContentNoticeDestroy.class */
public final class LiveContentNoticeDestroy extends GeneratedMessageV3 implements LiveContentNoticeDestroyOrBuilder {
    public static final int ID_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private int id_;
    private byte memoizedIsInitialized;
    private static final LiveContentNoticeDestroy DEFAULT_INSTANCE = new LiveContentNoticeDestroy();
    private static final Parser<LiveContentNoticeDestroy> PARSER = new AbstractParser<LiveContentNoticeDestroy>() { // from class: cn.irisgw.live.LiveContentNoticeDestroy.1
        /* renamed from: parsePartialFrom */
        public LiveContentNoticeDestroy m4853parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new LiveContentNoticeDestroy(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveContentNoticeDestroy$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LiveContentNoticeDestroyOrBuilder {
        private int id_;

        private Builder() {
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_LiveContentNoticeDestroy_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = LiveContentNoticeDestroy.alwaysUseFieldBuilders;
        }

        /* renamed from: addRepeatedField */
        public Builder m4855addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public LiveContentNoticeDestroy m4857build() {
            LiveContentNoticeDestroy m4859buildPartial = m4859buildPartial();
            if (m4859buildPartial.isInitialized()) {
                return m4859buildPartial;
            }
            throw newUninitializedMessageException(m4859buildPartial);
        }

        /* renamed from: buildPartial */
        public LiveContentNoticeDestroy m4859buildPartial() {
            LiveContentNoticeDestroy liveContentNoticeDestroy = new LiveContentNoticeDestroy(this);
            liveContentNoticeDestroy.id_ = this.id_;
            onBuilt();
            return liveContentNoticeDestroy;
        }

        /* renamed from: clear */
        public Builder m4863clear() {
            super.clear();
            this.id_ = 0;
            return this;
        }

        /* renamed from: clearField */
        public Builder m4865clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearId() {
            this.id_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clearOneof */
        public Builder m4868clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        /* renamed from: clone */
        public Builder m4874clone() {
            return (Builder) super.clone();
        }

        /* renamed from: getDefaultInstanceForType */
        public LiveContentNoticeDestroy m4876getDefaultInstanceForType() {
            return LiveContentNoticeDestroy.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_LiveContentNoticeDestroy_descriptor;
        }

        @Override // cn.irisgw.live.LiveContentNoticeDestroyOrBuilder
        public int getId() {
            return this.id_;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_LiveContentNoticeDestroy_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveContentNoticeDestroy.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(LiveContentNoticeDestroy liveContentNoticeDestroy) {
            if (liveContentNoticeDestroy == LiveContentNoticeDestroy.getDefaultInstance()) {
                return this;
            }
            if (liveContentNoticeDestroy.getId() != 0) {
                setId(liveContentNoticeDestroy.getId());
            }
            m4885mergeUnknownFields(liveContentNoticeDestroy.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.LiveContentNoticeDestroy.Builder m4882mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.LiveContentNoticeDestroy.access$600()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.LiveContentNoticeDestroy r0 = (cn.irisgw.live.LiveContentNoticeDestroy) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.LiveContentNoticeDestroy$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.LiveContentNoticeDestroy r0 = (cn.irisgw.live.LiveContentNoticeDestroy) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.LiveContentNoticeDestroy$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.LiveContentNoticeDestroy.Builder.m4882mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.LiveContentNoticeDestroy$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m4881mergeFrom(Message message) {
            if (message instanceof LiveContentNoticeDestroy) {
                return mergeFrom((LiveContentNoticeDestroy) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m4885mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        /* renamed from: setField */
        public Builder m4887setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setId(int i) {
            this.id_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setRepeatedField */
        public Builder m4889setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        /* renamed from: setUnknownFields */
        public final Builder m4891setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private LiveContentNoticeDestroy() {
        this.memoizedIsInitialized = (byte) -1;
    }

    private LiveContentNoticeDestroy(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.id_ = codedInputStream.readUInt32();
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

    private LiveContentNoticeDestroy(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static LiveContentNoticeDestroy getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_LiveContentNoticeDestroy_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m4852toBuilder();
    }

    public static Builder newBuilder(LiveContentNoticeDestroy liveContentNoticeDestroy) {
        return DEFAULT_INSTANCE.m4852toBuilder().mergeFrom(liveContentNoticeDestroy);
    }

    public static LiveContentNoticeDestroy parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static LiveContentNoticeDestroy parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LiveContentNoticeDestroy parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (LiveContentNoticeDestroy) PARSER.parseFrom(byteString);
    }

    public static LiveContentNoticeDestroy parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LiveContentNoticeDestroy) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static LiveContentNoticeDestroy parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static LiveContentNoticeDestroy parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static LiveContentNoticeDestroy parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static LiveContentNoticeDestroy parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LiveContentNoticeDestroy parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (LiveContentNoticeDestroy) PARSER.parseFrom(byteBuffer);
    }

    public static LiveContentNoticeDestroy parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LiveContentNoticeDestroy) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static LiveContentNoticeDestroy parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (LiveContentNoticeDestroy) PARSER.parseFrom(bArr);
    }

    public static LiveContentNoticeDestroy parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LiveContentNoticeDestroy) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<LiveContentNoticeDestroy> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LiveContentNoticeDestroy) {
            LiveContentNoticeDestroy liveContentNoticeDestroy = (LiveContentNoticeDestroy) obj;
            return getId() == liveContentNoticeDestroy.getId() && this.unknownFields.equals(liveContentNoticeDestroy.unknownFields);
        }
        return super.equals(obj);
    }

    /* renamed from: getDefaultInstanceForType */
    public LiveContentNoticeDestroy m4847getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.LiveContentNoticeDestroyOrBuilder
    public int getId() {
        return this.id_;
    }

    public Parser<LiveContentNoticeDestroy> getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        int i3 = this.id_;
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
        int hashCode = ((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getId()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_LiveContentNoticeDestroy_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveContentNoticeDestroy.class, Builder.class);
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
    public Builder m4850newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m4849newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new LiveContentNoticeDestroy();
    }

    /* renamed from: toBuilder */
    public Builder m4852toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.id_;
        if (i != 0) {
            codedOutputStream.writeUInt32(1, i);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
