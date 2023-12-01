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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveNotice.class */
public final class LiveNotice extends GeneratedMessageV3 implements LiveNoticeOrBuilder {
    public static final int NOTICE_CONTENT_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private volatile Object noticeContent_;
    private static final LiveNotice DEFAULT_INSTANCE = new LiveNotice();
    private static final Parser<LiveNotice> PARSER = new AbstractParser<LiveNotice>() { // from class: cn.irisgw.live.LiveNotice.1
        /* renamed from: parsePartialFrom */
        public LiveNotice m4949parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new LiveNotice(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveNotice$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LiveNoticeOrBuilder {
        private Object noticeContent_;

        private Builder() {
            this.noticeContent_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.noticeContent_ = "";
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_LiveNotice_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = LiveNotice.alwaysUseFieldBuilders;
        }

        /* renamed from: addRepeatedField */
        public Builder m4951addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public LiveNotice m4953build() {
            LiveNotice m4955buildPartial = m4955buildPartial();
            if (m4955buildPartial.isInitialized()) {
                return m4955buildPartial;
            }
            throw newUninitializedMessageException(m4955buildPartial);
        }

        /* renamed from: buildPartial */
        public LiveNotice m4955buildPartial() {
            LiveNotice liveNotice = new LiveNotice(this);
            liveNotice.noticeContent_ = this.noticeContent_;
            onBuilt();
            return liveNotice;
        }

        /* renamed from: clear */
        public Builder m4959clear() {
            super.clear();
            this.noticeContent_ = "";
            return this;
        }

        /* renamed from: clearField */
        public Builder m4961clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearNoticeContent() {
            this.noticeContent_ = LiveNotice.getDefaultInstance().getNoticeContent();
            onChanged();
            return this;
        }

        /* renamed from: clearOneof */
        public Builder m4964clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        /* renamed from: clone */
        public Builder m4970clone() {
            return (Builder) super.clone();
        }

        /* renamed from: getDefaultInstanceForType */
        public LiveNotice m4972getDefaultInstanceForType() {
            return LiveNotice.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_LiveNotice_descriptor;
        }

        @Override // cn.irisgw.live.LiveNoticeOrBuilder
        public String getNoticeContent() {
            Object obj = this.noticeContent_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.noticeContent_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LiveNoticeOrBuilder
        public ByteString getNoticeContentBytes() {
            Object obj = this.noticeContent_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.noticeContent_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_LiveNotice_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveNotice.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(LiveNotice liveNotice) {
            if (liveNotice == LiveNotice.getDefaultInstance()) {
                return this;
            }
            if (!liveNotice.getNoticeContent().isEmpty()) {
                this.noticeContent_ = liveNotice.noticeContent_;
                onChanged();
            }
            m4981mergeUnknownFields(liveNotice.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.LiveNotice.Builder m4978mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.LiveNotice.access$600()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.LiveNotice r0 = (cn.irisgw.live.LiveNotice) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.LiveNotice$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.LiveNotice r0 = (cn.irisgw.live.LiveNotice) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.LiveNotice$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.LiveNotice.Builder.m4978mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.LiveNotice$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m4977mergeFrom(Message message) {
            if (message instanceof LiveNotice) {
                return mergeFrom((LiveNotice) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m4981mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        /* renamed from: setField */
        public Builder m4983setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setNoticeContent(String str) {
            if (str != null) {
                this.noticeContent_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setNoticeContentBytes(ByteString byteString) {
            if (byteString != null) {
                LiveNotice.checkByteStringIsUtf8(byteString);
                this.noticeContent_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        /* renamed from: setRepeatedField */
        public Builder m4985setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        /* renamed from: setUnknownFields */
        public final Builder m4987setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private LiveNotice() {
        this.memoizedIsInitialized = (byte) -1;
        this.noticeContent_ = "";
    }

    private LiveNotice(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                        if (readTag == 10) {
                            this.noticeContent_ = codedInputStream.readStringRequireUtf8();
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

    private LiveNotice(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static LiveNotice getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_LiveNotice_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m4948toBuilder();
    }

    public static Builder newBuilder(LiveNotice liveNotice) {
        return DEFAULT_INSTANCE.m4948toBuilder().mergeFrom(liveNotice);
    }

    public static LiveNotice parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static LiveNotice parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LiveNotice parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (LiveNotice) PARSER.parseFrom(byteString);
    }

    public static LiveNotice parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LiveNotice) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static LiveNotice parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static LiveNotice parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static LiveNotice parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static LiveNotice parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LiveNotice parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (LiveNotice) PARSER.parseFrom(byteBuffer);
    }

    public static LiveNotice parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LiveNotice) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static LiveNotice parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (LiveNotice) PARSER.parseFrom(bArr);
    }

    public static LiveNotice parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LiveNotice) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<LiveNotice> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LiveNotice) {
            LiveNotice liveNotice = (LiveNotice) obj;
            return getNoticeContent().equals(liveNotice.getNoticeContent()) && this.unknownFields.equals(liveNotice.unknownFields);
        }
        return super.equals(obj);
    }

    /* renamed from: getDefaultInstanceForType */
    public LiveNotice m4943getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.LiveNoticeOrBuilder
    public String getNoticeContent() {
        Object obj = this.noticeContent_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.noticeContent_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.LiveNoticeOrBuilder
    public ByteString getNoticeContentBytes() {
        Object obj = this.noticeContent_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.noticeContent_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    public Parser<LiveNotice> getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (!getNoticeContentBytes().isEmpty()) {
            i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.noticeContent_);
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
        int hashCode = ((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getNoticeContent().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_LiveNotice_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveNotice.class, Builder.class);
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
    public Builder m4946newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m4945newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new LiveNotice();
    }

    /* renamed from: toBuilder */
    public Builder m4948toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!getNoticeContentBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.noticeContent_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
