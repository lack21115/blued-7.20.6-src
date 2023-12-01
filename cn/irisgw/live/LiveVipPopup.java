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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveVipPopup.class */
public final class LiveVipPopup extends GeneratedMessageV3 implements LiveVipPopupOrBuilder {
    private static final LiveVipPopup DEFAULT_INSTANCE = new LiveVipPopup();
    private static final Parser<LiveVipPopup> PARSER = new AbstractParser<LiveVipPopup>() { // from class: cn.irisgw.live.LiveVipPopup.1
        /* renamed from: parsePartialFrom */
        public LiveVipPopup m5189parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new LiveVipPopup(codedInputStream, extensionRegistryLite);
        }
    };
    public static final int URL_FIELD_NUMBER = 2;
    public static final int WECHAT_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private volatile Object url_;
    private volatile Object wechat_;

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveVipPopup$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LiveVipPopupOrBuilder {
        private Object url_;
        private Object wechat_;

        private Builder() {
            this.wechat_ = "";
            this.url_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.wechat_ = "";
            this.url_ = "";
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_LiveVipPopup_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = LiveVipPopup.alwaysUseFieldBuilders;
        }

        /* renamed from: addRepeatedField */
        public Builder m5191addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public LiveVipPopup m5193build() {
            LiveVipPopup m5195buildPartial = m5195buildPartial();
            if (m5195buildPartial.isInitialized()) {
                return m5195buildPartial;
            }
            throw newUninitializedMessageException(m5195buildPartial);
        }

        /* renamed from: buildPartial */
        public LiveVipPopup m5195buildPartial() {
            LiveVipPopup liveVipPopup = new LiveVipPopup(this);
            liveVipPopup.wechat_ = this.wechat_;
            liveVipPopup.url_ = this.url_;
            onBuilt();
            return liveVipPopup;
        }

        /* renamed from: clear */
        public Builder m5199clear() {
            super.clear();
            this.wechat_ = "";
            this.url_ = "";
            return this;
        }

        /* renamed from: clearField */
        public Builder m5201clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        /* renamed from: clearOneof */
        public Builder m5204clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearUrl() {
            this.url_ = LiveVipPopup.getDefaultInstance().getUrl();
            onChanged();
            return this;
        }

        public Builder clearWechat() {
            this.wechat_ = LiveVipPopup.getDefaultInstance().getWechat();
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m5210clone() {
            return (Builder) super.clone();
        }

        /* renamed from: getDefaultInstanceForType */
        public LiveVipPopup m5212getDefaultInstanceForType() {
            return LiveVipPopup.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_LiveVipPopup_descriptor;
        }

        @Override // cn.irisgw.live.LiveVipPopupOrBuilder
        public String getUrl() {
            Object obj = this.url_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.url_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LiveVipPopupOrBuilder
        public ByteString getUrlBytes() {
            Object obj = this.url_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.url_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.LiveVipPopupOrBuilder
        public String getWechat() {
            Object obj = this.wechat_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.wechat_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LiveVipPopupOrBuilder
        public ByteString getWechatBytes() {
            Object obj = this.wechat_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.wechat_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_LiveVipPopup_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveVipPopup.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(LiveVipPopup liveVipPopup) {
            if (liveVipPopup == LiveVipPopup.getDefaultInstance()) {
                return this;
            }
            if (!liveVipPopup.getWechat().isEmpty()) {
                this.wechat_ = liveVipPopup.wechat_;
                onChanged();
            }
            if (!liveVipPopup.getUrl().isEmpty()) {
                this.url_ = liveVipPopup.url_;
                onChanged();
            }
            m5221mergeUnknownFields(liveVipPopup.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.LiveVipPopup.Builder m5218mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.LiveVipPopup.access$700()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.LiveVipPopup r0 = (cn.irisgw.live.LiveVipPopup) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.LiveVipPopup$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.LiveVipPopup r0 = (cn.irisgw.live.LiveVipPopup) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.LiveVipPopup$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.LiveVipPopup.Builder.m5218mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.LiveVipPopup$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m5217mergeFrom(Message message) {
            if (message instanceof LiveVipPopup) {
                return mergeFrom((LiveVipPopup) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m5221mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        /* renamed from: setField */
        public Builder m5223setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        /* renamed from: setRepeatedField */
        public Builder m5225setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        /* renamed from: setUnknownFields */
        public final Builder m5227setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }

        public Builder setUrl(String str) {
            if (str != null) {
                this.url_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setUrlBytes(ByteString byteString) {
            if (byteString != null) {
                LiveVipPopup.checkByteStringIsUtf8(byteString);
                this.url_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setWechat(String str) {
            if (str != null) {
                this.wechat_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setWechatBytes(ByteString byteString) {
            if (byteString != null) {
                LiveVipPopup.checkByteStringIsUtf8(byteString);
                this.wechat_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }
    }

    private LiveVipPopup() {
        this.memoizedIsInitialized = (byte) -1;
        this.wechat_ = "";
        this.url_ = "";
    }

    private LiveVipPopup(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            if (readTag == 10) {
                                this.wechat_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                this.url_ = codedInputStream.readStringRequireUtf8();
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

    private LiveVipPopup(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static LiveVipPopup getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_LiveVipPopup_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m5188toBuilder();
    }

    public static Builder newBuilder(LiveVipPopup liveVipPopup) {
        return DEFAULT_INSTANCE.m5188toBuilder().mergeFrom(liveVipPopup);
    }

    public static LiveVipPopup parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static LiveVipPopup parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LiveVipPopup parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (LiveVipPopup) PARSER.parseFrom(byteString);
    }

    public static LiveVipPopup parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LiveVipPopup) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static LiveVipPopup parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static LiveVipPopup parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static LiveVipPopup parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static LiveVipPopup parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LiveVipPopup parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (LiveVipPopup) PARSER.parseFrom(byteBuffer);
    }

    public static LiveVipPopup parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LiveVipPopup) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static LiveVipPopup parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (LiveVipPopup) PARSER.parseFrom(bArr);
    }

    public static LiveVipPopup parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LiveVipPopup) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<LiveVipPopup> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LiveVipPopup) {
            LiveVipPopup liveVipPopup = (LiveVipPopup) obj;
            return getWechat().equals(liveVipPopup.getWechat()) && getUrl().equals(liveVipPopup.getUrl()) && this.unknownFields.equals(liveVipPopup.unknownFields);
        }
        return super.equals(obj);
    }

    /* renamed from: getDefaultInstanceForType */
    public LiveVipPopup m5183getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public Parser<LiveVipPopup> getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (!getWechatBytes().isEmpty()) {
            i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.wechat_);
        }
        int i3 = i2;
        if (!getUrlBytes().isEmpty()) {
            i3 = i2 + GeneratedMessageV3.computeStringSize(2, this.url_);
        }
        int serializedSize = i3 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // cn.irisgw.live.LiveVipPopupOrBuilder
    public String getUrl() {
        Object obj = this.url_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.url_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.LiveVipPopupOrBuilder
    public ByteString getUrlBytes() {
        Object obj = this.url_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.url_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.LiveVipPopupOrBuilder
    public String getWechat() {
        Object obj = this.wechat_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.wechat_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.LiveVipPopupOrBuilder
    public ByteString getWechatBytes() {
        Object obj = this.wechat_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.wechat_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getWechat().hashCode()) * 37) + 2) * 53) + getUrl().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_LiveVipPopup_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveVipPopup.class, Builder.class);
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
    public Builder m5186newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m5185newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new LiveVipPopup();
    }

    /* renamed from: toBuilder */
    public Builder m5188toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!getWechatBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.wechat_);
        }
        if (!getUrlBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.url_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
