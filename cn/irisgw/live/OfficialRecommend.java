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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/OfficialRecommend.class */
public final class OfficialRecommend extends GeneratedMessageV3 implements OfficialRecommendOrBuilder {
    public static final int END_TIME_FIELD_NUMBER = 1;
    public static final int ICON_FIELD_NUMBER = 2;
    public static final int ICON_SHOW_FIELD_NUMBER = 4;
    public static final int TIMEOUT_FIELD_NUMBER = 3;
    private static final long serialVersionUID = 0;
    private long endTime_;
    private boolean iconShow_;
    private volatile Object icon_;
    private byte memoizedIsInitialized;
    private boolean timeout_;
    private static final OfficialRecommend DEFAULT_INSTANCE = new OfficialRecommend();
    private static final Parser<OfficialRecommend> PARSER = new AbstractParser<OfficialRecommend>() { // from class: cn.irisgw.live.OfficialRecommend.1
        /* renamed from: parsePartialFrom */
        public OfficialRecommend m6364parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new OfficialRecommend(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/OfficialRecommend$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements OfficialRecommendOrBuilder {
        private long endTime_;
        private boolean iconShow_;
        private Object icon_;
        private boolean timeout_;

        private Builder() {
            this.icon_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.icon_ = "";
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_OfficialRecommend_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = OfficialRecommend.alwaysUseFieldBuilders;
        }

        /* renamed from: addRepeatedField */
        public Builder m6366addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public OfficialRecommend m6368build() {
            OfficialRecommend m6370buildPartial = m6370buildPartial();
            if (m6370buildPartial.isInitialized()) {
                return m6370buildPartial;
            }
            throw newUninitializedMessageException(m6370buildPartial);
        }

        /* renamed from: buildPartial */
        public OfficialRecommend m6370buildPartial() {
            OfficialRecommend officialRecommend = new OfficialRecommend(this);
            officialRecommend.endTime_ = this.endTime_;
            officialRecommend.icon_ = this.icon_;
            officialRecommend.timeout_ = this.timeout_;
            officialRecommend.iconShow_ = this.iconShow_;
            onBuilt();
            return officialRecommend;
        }

        /* renamed from: clear */
        public Builder m6374clear() {
            super.clear();
            this.endTime_ = OfficialRecommend.serialVersionUID;
            this.icon_ = "";
            this.timeout_ = false;
            this.iconShow_ = false;
            return this;
        }

        public Builder clearEndTime() {
            this.endTime_ = OfficialRecommend.serialVersionUID;
            onChanged();
            return this;
        }

        /* renamed from: clearField */
        public Builder m6376clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearIcon() {
            this.icon_ = OfficialRecommend.getDefaultInstance().getIcon();
            onChanged();
            return this;
        }

        public Builder clearIconShow() {
            this.iconShow_ = false;
            onChanged();
            return this;
        }

        /* renamed from: clearOneof */
        public Builder m6379clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearTimeout() {
            this.timeout_ = false;
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m6385clone() {
            return (Builder) super.clone();
        }

        /* renamed from: getDefaultInstanceForType */
        public OfficialRecommend m6387getDefaultInstanceForType() {
            return OfficialRecommend.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_OfficialRecommend_descriptor;
        }

        @Override // cn.irisgw.live.OfficialRecommendOrBuilder
        public long getEndTime() {
            return this.endTime_;
        }

        @Override // cn.irisgw.live.OfficialRecommendOrBuilder
        public String getIcon() {
            Object obj = this.icon_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.icon_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.OfficialRecommendOrBuilder
        public ByteString getIconBytes() {
            Object obj = this.icon_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.icon_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.OfficialRecommendOrBuilder
        public boolean getIconShow() {
            return this.iconShow_;
        }

        @Override // cn.irisgw.live.OfficialRecommendOrBuilder
        public boolean getTimeout() {
            return this.timeout_;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_OfficialRecommend_fieldAccessorTable.ensureFieldAccessorsInitialized(OfficialRecommend.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(OfficialRecommend officialRecommend) {
            if (officialRecommend == OfficialRecommend.getDefaultInstance()) {
                return this;
            }
            if (officialRecommend.getEndTime() != OfficialRecommend.serialVersionUID) {
                setEndTime(officialRecommend.getEndTime());
            }
            if (!officialRecommend.getIcon().isEmpty()) {
                this.icon_ = officialRecommend.icon_;
                onChanged();
            }
            if (officialRecommend.getTimeout()) {
                setTimeout(officialRecommend.getTimeout());
            }
            if (officialRecommend.getIconShow()) {
                setIconShow(officialRecommend.getIconShow());
            }
            m6396mergeUnknownFields(officialRecommend.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.OfficialRecommend.Builder m6393mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.OfficialRecommend.access$900()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.OfficialRecommend r0 = (cn.irisgw.live.OfficialRecommend) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.OfficialRecommend$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.OfficialRecommend r0 = (cn.irisgw.live.OfficialRecommend) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.OfficialRecommend$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.OfficialRecommend.Builder.m6393mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.OfficialRecommend$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m6392mergeFrom(Message message) {
            if (message instanceof OfficialRecommend) {
                return mergeFrom((OfficialRecommend) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m6396mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setEndTime(long j) {
            this.endTime_ = j;
            onChanged();
            return this;
        }

        /* renamed from: setField */
        public Builder m6398setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setIcon(String str) {
            if (str != null) {
                this.icon_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setIconBytes(ByteString byteString) {
            if (byteString != null) {
                OfficialRecommend.checkByteStringIsUtf8(byteString);
                this.icon_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setIconShow(boolean z) {
            this.iconShow_ = z;
            onChanged();
            return this;
        }

        /* renamed from: setRepeatedField */
        public Builder m6400setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setTimeout(boolean z) {
            this.timeout_ = z;
            onChanged();
            return this;
        }

        /* renamed from: setUnknownFields */
        public final Builder m6402setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private OfficialRecommend() {
        this.memoizedIsInitialized = (byte) -1;
        this.icon_ = "";
    }

    private OfficialRecommend(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.endTime_ = codedInputStream.readUInt64();
                        } else if (readTag == 18) {
                            this.icon_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 24) {
                            this.timeout_ = codedInputStream.readBool();
                        } else if (readTag == 32) {
                            this.iconShow_ = codedInputStream.readBool();
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

    private OfficialRecommend(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static OfficialRecommend getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_OfficialRecommend_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m6363toBuilder();
    }

    public static Builder newBuilder(OfficialRecommend officialRecommend) {
        return DEFAULT_INSTANCE.m6363toBuilder().mergeFrom(officialRecommend);
    }

    public static OfficialRecommend parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static OfficialRecommend parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static OfficialRecommend parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (OfficialRecommend) PARSER.parseFrom(byteString);
    }

    public static OfficialRecommend parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (OfficialRecommend) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static OfficialRecommend parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static OfficialRecommend parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static OfficialRecommend parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static OfficialRecommend parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static OfficialRecommend parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (OfficialRecommend) PARSER.parseFrom(byteBuffer);
    }

    public static OfficialRecommend parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (OfficialRecommend) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static OfficialRecommend parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (OfficialRecommend) PARSER.parseFrom(bArr);
    }

    public static OfficialRecommend parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (OfficialRecommend) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<OfficialRecommend> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof OfficialRecommend) {
            OfficialRecommend officialRecommend = (OfficialRecommend) obj;
            return getEndTime() == officialRecommend.getEndTime() && getIcon().equals(officialRecommend.getIcon()) && getTimeout() == officialRecommend.getTimeout() && getIconShow() == officialRecommend.getIconShow() && this.unknownFields.equals(officialRecommend.unknownFields);
        }
        return super.equals(obj);
    }

    /* renamed from: getDefaultInstanceForType */
    public OfficialRecommend m6358getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.OfficialRecommendOrBuilder
    public long getEndTime() {
        return this.endTime_;
    }

    @Override // cn.irisgw.live.OfficialRecommendOrBuilder
    public String getIcon() {
        Object obj = this.icon_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.icon_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.OfficialRecommendOrBuilder
    public ByteString getIconBytes() {
        Object obj = this.icon_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.icon_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.OfficialRecommendOrBuilder
    public boolean getIconShow() {
        return this.iconShow_;
    }

    public Parser<OfficialRecommend> getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        long j = this.endTime_;
        if (j != serialVersionUID) {
            i2 = 0 + CodedOutputStream.computeUInt64Size(1, j);
        }
        int i3 = i2;
        if (!getIconBytes().isEmpty()) {
            i3 = i2 + GeneratedMessageV3.computeStringSize(2, this.icon_);
        }
        boolean z = this.timeout_;
        int i4 = i3;
        if (z) {
            i4 = i3 + CodedOutputStream.computeBoolSize(3, z);
        }
        boolean z2 = this.iconShow_;
        int i5 = i4;
        if (z2) {
            i5 = i4 + CodedOutputStream.computeBoolSize(4, z2);
        }
        int serializedSize = i5 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.OfficialRecommendOrBuilder
    public boolean getTimeout() {
        return this.timeout_;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(getEndTime())) * 37) + 2) * 53) + getIcon().hashCode()) * 37) + 3) * 53) + Internal.hashBoolean(getTimeout())) * 37) + 4) * 53) + Internal.hashBoolean(getIconShow())) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_OfficialRecommend_fieldAccessorTable.ensureFieldAccessorsInitialized(OfficialRecommend.class, Builder.class);
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
    public Builder m6361newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m6360newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new OfficialRecommend();
    }

    /* renamed from: toBuilder */
    public Builder m6363toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        long j = this.endTime_;
        if (j != serialVersionUID) {
            codedOutputStream.writeUInt64(1, j);
        }
        if (!getIconBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.icon_);
        }
        boolean z = this.timeout_;
        if (z) {
            codedOutputStream.writeBool(3, z);
        }
        boolean z2 = this.iconShow_;
        if (z2) {
            codedOutputStream.writeBool(4, z2);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
