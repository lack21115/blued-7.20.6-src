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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/HTMLNotice.class */
public final class HTMLNotice extends GeneratedMessageV3 implements HTMLNoticeOrBuilder {
    public static final int HTML_HREF_FIELD_NUMBER = 2;
    public static final int HTML_MSG_FIELD_NUMBER = 1;
    public static final int PUSH_MILLISECOND_FIELD_NUMBER = 4;
    public static final int PUSH_TIME_FIELD_NUMBER = 3;
    private static final long serialVersionUID = 0;
    private volatile Object htmlHref_;
    private volatile Object htmlMsg_;
    private byte memoizedIsInitialized;
    private long pushMillisecond_;
    private int pushTime_;
    private static final HTMLNotice DEFAULT_INSTANCE = new HTMLNotice();
    private static final Parser<HTMLNotice> PARSER = new AbstractParser<HTMLNotice>() { // from class: cn.irisgw.live.HTMLNotice.1
        /* renamed from: parsePartialFrom */
        public HTMLNotice m3237parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new HTMLNotice(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/HTMLNotice$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HTMLNoticeOrBuilder {
        private Object htmlHref_;
        private Object htmlMsg_;
        private long pushMillisecond_;
        private int pushTime_;

        private Builder() {
            this.htmlMsg_ = "";
            this.htmlHref_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.htmlMsg_ = "";
            this.htmlHref_ = "";
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_HTMLNotice_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = HTMLNotice.alwaysUseFieldBuilders;
        }

        /* renamed from: addRepeatedField */
        public Builder m3239addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public HTMLNotice m3241build() {
            HTMLNotice m3243buildPartial = m3243buildPartial();
            if (m3243buildPartial.isInitialized()) {
                return m3243buildPartial;
            }
            throw newUninitializedMessageException(m3243buildPartial);
        }

        /* renamed from: buildPartial */
        public HTMLNotice m3243buildPartial() {
            HTMLNotice hTMLNotice = new HTMLNotice(this);
            hTMLNotice.htmlMsg_ = this.htmlMsg_;
            hTMLNotice.htmlHref_ = this.htmlHref_;
            hTMLNotice.pushTime_ = this.pushTime_;
            hTMLNotice.pushMillisecond_ = this.pushMillisecond_;
            onBuilt();
            return hTMLNotice;
        }

        /* renamed from: clear */
        public Builder m3247clear() {
            super.clear();
            this.htmlMsg_ = "";
            this.htmlHref_ = "";
            this.pushTime_ = 0;
            this.pushMillisecond_ = HTMLNotice.serialVersionUID;
            return this;
        }

        /* renamed from: clearField */
        public Builder m3249clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearHtmlHref() {
            this.htmlHref_ = HTMLNotice.getDefaultInstance().getHtmlHref();
            onChanged();
            return this;
        }

        public Builder clearHtmlMsg() {
            this.htmlMsg_ = HTMLNotice.getDefaultInstance().getHtmlMsg();
            onChanged();
            return this;
        }

        /* renamed from: clearOneof */
        public Builder m3252clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearPushMillisecond() {
            this.pushMillisecond_ = HTMLNotice.serialVersionUID;
            onChanged();
            return this;
        }

        public Builder clearPushTime() {
            this.pushTime_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m3258clone() {
            return (Builder) super.clone();
        }

        /* renamed from: getDefaultInstanceForType */
        public HTMLNotice m3260getDefaultInstanceForType() {
            return HTMLNotice.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_HTMLNotice_descriptor;
        }

        @Override // cn.irisgw.live.HTMLNoticeOrBuilder
        public String getHtmlHref() {
            Object obj = this.htmlHref_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.htmlHref_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.HTMLNoticeOrBuilder
        public ByteString getHtmlHrefBytes() {
            Object obj = this.htmlHref_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.htmlHref_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.HTMLNoticeOrBuilder
        public String getHtmlMsg() {
            Object obj = this.htmlMsg_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.htmlMsg_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.HTMLNoticeOrBuilder
        public ByteString getHtmlMsgBytes() {
            Object obj = this.htmlMsg_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.htmlMsg_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.HTMLNoticeOrBuilder
        public long getPushMillisecond() {
            return this.pushMillisecond_;
        }

        @Override // cn.irisgw.live.HTMLNoticeOrBuilder
        public int getPushTime() {
            return this.pushTime_;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_HTMLNotice_fieldAccessorTable.ensureFieldAccessorsInitialized(HTMLNotice.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(HTMLNotice hTMLNotice) {
            if (hTMLNotice == HTMLNotice.getDefaultInstance()) {
                return this;
            }
            if (!hTMLNotice.getHtmlMsg().isEmpty()) {
                this.htmlMsg_ = hTMLNotice.htmlMsg_;
                onChanged();
            }
            if (!hTMLNotice.getHtmlHref().isEmpty()) {
                this.htmlHref_ = hTMLNotice.htmlHref_;
                onChanged();
            }
            if (hTMLNotice.getPushTime() != 0) {
                setPushTime(hTMLNotice.getPushTime());
            }
            if (hTMLNotice.getPushMillisecond() != HTMLNotice.serialVersionUID) {
                setPushMillisecond(hTMLNotice.getPushMillisecond());
            }
            m3269mergeUnknownFields(hTMLNotice.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.HTMLNotice.Builder m3266mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.HTMLNotice.access$900()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.HTMLNotice r0 = (cn.irisgw.live.HTMLNotice) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.HTMLNotice$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.HTMLNotice r0 = (cn.irisgw.live.HTMLNotice) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.HTMLNotice$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.HTMLNotice.Builder.m3266mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.HTMLNotice$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m3265mergeFrom(Message message) {
            if (message instanceof HTMLNotice) {
                return mergeFrom((HTMLNotice) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m3269mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        /* renamed from: setField */
        public Builder m3271setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setHtmlHref(String str) {
            if (str != null) {
                this.htmlHref_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setHtmlHrefBytes(ByteString byteString) {
            if (byteString != null) {
                HTMLNotice.checkByteStringIsUtf8(byteString);
                this.htmlHref_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setHtmlMsg(String str) {
            if (str != null) {
                this.htmlMsg_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setHtmlMsgBytes(ByteString byteString) {
            if (byteString != null) {
                HTMLNotice.checkByteStringIsUtf8(byteString);
                this.htmlMsg_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setPushMillisecond(long j) {
            this.pushMillisecond_ = j;
            onChanged();
            return this;
        }

        public Builder setPushTime(int i) {
            this.pushTime_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setRepeatedField */
        public Builder m3273setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        /* renamed from: setUnknownFields */
        public final Builder m3275setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private HTMLNotice() {
        this.memoizedIsInitialized = (byte) -1;
        this.htmlMsg_ = "";
        this.htmlHref_ = "";
    }

    private HTMLNotice(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.htmlMsg_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 18) {
                            this.htmlHref_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 24) {
                            this.pushTime_ = codedInputStream.readUInt32();
                        } else if (readTag == 32) {
                            this.pushMillisecond_ = codedInputStream.readUInt64();
                        } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                }
            } finally {
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
            }
        }
    }

    private HTMLNotice(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static HTMLNotice getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_HTMLNotice_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m3236toBuilder();
    }

    public static Builder newBuilder(HTMLNotice hTMLNotice) {
        return DEFAULT_INSTANCE.m3236toBuilder().mergeFrom(hTMLNotice);
    }

    public static HTMLNotice parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static HTMLNotice parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static HTMLNotice parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (HTMLNotice) PARSER.parseFrom(byteString);
    }

    public static HTMLNotice parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HTMLNotice) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static HTMLNotice parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static HTMLNotice parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static HTMLNotice parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static HTMLNotice parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static HTMLNotice parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (HTMLNotice) PARSER.parseFrom(byteBuffer);
    }

    public static HTMLNotice parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HTMLNotice) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static HTMLNotice parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (HTMLNotice) PARSER.parseFrom(bArr);
    }

    public static HTMLNotice parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HTMLNotice) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<HTMLNotice> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof HTMLNotice) {
            HTMLNotice hTMLNotice = (HTMLNotice) obj;
            return getHtmlMsg().equals(hTMLNotice.getHtmlMsg()) && getHtmlHref().equals(hTMLNotice.getHtmlHref()) && getPushTime() == hTMLNotice.getPushTime() && getPushMillisecond() == hTMLNotice.getPushMillisecond() && this.unknownFields.equals(hTMLNotice.unknownFields);
        }
        return super.equals(obj);
    }

    /* renamed from: getDefaultInstanceForType */
    public HTMLNotice m3231getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.HTMLNoticeOrBuilder
    public String getHtmlHref() {
        Object obj = this.htmlHref_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.htmlHref_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.HTMLNoticeOrBuilder
    public ByteString getHtmlHrefBytes() {
        Object obj = this.htmlHref_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.htmlHref_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.HTMLNoticeOrBuilder
    public String getHtmlMsg() {
        Object obj = this.htmlMsg_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.htmlMsg_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.HTMLNoticeOrBuilder
    public ByteString getHtmlMsgBytes() {
        Object obj = this.htmlMsg_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.htmlMsg_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    public Parser<HTMLNotice> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.HTMLNoticeOrBuilder
    public long getPushMillisecond() {
        return this.pushMillisecond_;
    }

    @Override // cn.irisgw.live.HTMLNoticeOrBuilder
    public int getPushTime() {
        return this.pushTime_;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (!getHtmlMsgBytes().isEmpty()) {
            i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.htmlMsg_);
        }
        int i3 = i2;
        if (!getHtmlHrefBytes().isEmpty()) {
            i3 = i2 + GeneratedMessageV3.computeStringSize(2, this.htmlHref_);
        }
        int i4 = this.pushTime_;
        int i5 = i3;
        if (i4 != 0) {
            i5 = i3 + CodedOutputStream.computeUInt32Size(3, i4);
        }
        long j = this.pushMillisecond_;
        int i6 = i5;
        if (j != serialVersionUID) {
            i6 = i5 + CodedOutputStream.computeUInt64Size(4, j);
        }
        int serializedSize = i6 + this.unknownFields.getSerializedSize();
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
        int hashCode = ((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getHtmlMsg().hashCode()) * 37) + 2) * 53) + getHtmlHref().hashCode()) * 37) + 3) * 53) + getPushTime()) * 37) + 4) * 53) + Internal.hashLong(getPushMillisecond())) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_HTMLNotice_fieldAccessorTable.ensureFieldAccessorsInitialized(HTMLNotice.class, Builder.class);
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
    public Builder m3234newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m3233newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new HTMLNotice();
    }

    /* renamed from: toBuilder */
    public Builder m3236toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!getHtmlMsgBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.htmlMsg_);
        }
        if (!getHtmlHrefBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.htmlHref_);
        }
        int i = this.pushTime_;
        if (i != 0) {
            codedOutputStream.writeUInt32(3, i);
        }
        long j = this.pushMillisecond_;
        if (j != serialVersionUID) {
            codedOutputStream.writeUInt64(4, j);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
