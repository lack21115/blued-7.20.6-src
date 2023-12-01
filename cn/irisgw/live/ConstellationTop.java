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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ConstellationTop.class */
public final class ConstellationTop extends GeneratedMessageV3 implements ConstellationTopOrBuilder {
    public static final int ANCHOR_AVATAR_FIELD_NUMBER = 2;
    public static final int AVATAR_FIELD_NUMBER = 4;
    private static final ConstellationTop DEFAULT_INSTANCE = new ConstellationTop();
    private static final Parser<ConstellationTop> PARSER = new AbstractParser<ConstellationTop>() { // from class: cn.irisgw.live.ConstellationTop.1
        /* renamed from: parsePartialFrom */
        public ConstellationTop m1863parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new ConstellationTop(codedInputStream, extensionRegistryLite);
        }
    };
    public static final int TOP_ANCHOR_FIELD_NUMBER = 1;
    public static final int TOP_UID_FIELD_NUMBER = 3;
    public static final int UID_FIELD_NUMBER = 5;
    private static final long serialVersionUID = 0;
    private volatile Object anchorAvatar_;
    private volatile Object avatar_;
    private byte memoizedIsInitialized;
    private int topAnchor_;
    private int topUid_;
    private int uid_;

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ConstellationTop$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ConstellationTopOrBuilder {
        private Object anchorAvatar_;
        private Object avatar_;
        private int topAnchor_;
        private int topUid_;
        private int uid_;

        private Builder() {
            this.anchorAvatar_ = "";
            this.avatar_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.anchorAvatar_ = "";
            this.avatar_ = "";
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_ConstellationTop_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = ConstellationTop.alwaysUseFieldBuilders;
        }

        /* renamed from: addRepeatedField */
        public Builder m1865addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public ConstellationTop m1867build() {
            ConstellationTop m1869buildPartial = m1869buildPartial();
            if (m1869buildPartial.isInitialized()) {
                return m1869buildPartial;
            }
            throw newUninitializedMessageException(m1869buildPartial);
        }

        /* renamed from: buildPartial */
        public ConstellationTop m1869buildPartial() {
            ConstellationTop constellationTop = new ConstellationTop(this);
            constellationTop.topAnchor_ = this.topAnchor_;
            constellationTop.anchorAvatar_ = this.anchorAvatar_;
            constellationTop.topUid_ = this.topUid_;
            constellationTop.avatar_ = this.avatar_;
            constellationTop.uid_ = this.uid_;
            onBuilt();
            return constellationTop;
        }

        /* renamed from: clear */
        public Builder m1873clear() {
            super.clear();
            this.topAnchor_ = 0;
            this.anchorAvatar_ = "";
            this.topUid_ = 0;
            this.avatar_ = "";
            this.uid_ = 0;
            return this;
        }

        public Builder clearAnchorAvatar() {
            this.anchorAvatar_ = ConstellationTop.getDefaultInstance().getAnchorAvatar();
            onChanged();
            return this;
        }

        public Builder clearAvatar() {
            this.avatar_ = ConstellationTop.getDefaultInstance().getAvatar();
            onChanged();
            return this;
        }

        /* renamed from: clearField */
        public Builder m1875clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        /* renamed from: clearOneof */
        public Builder m1878clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearTopAnchor() {
            this.topAnchor_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTopUid() {
            this.topUid_ = 0;
            onChanged();
            return this;
        }

        public Builder clearUid() {
            this.uid_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m1884clone() {
            return (Builder) super.clone();
        }

        @Override // cn.irisgw.live.ConstellationTopOrBuilder
        public String getAnchorAvatar() {
            Object obj = this.anchorAvatar_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.anchorAvatar_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.ConstellationTopOrBuilder
        public ByteString getAnchorAvatarBytes() {
            Object obj = this.anchorAvatar_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.anchorAvatar_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.ConstellationTopOrBuilder
        public String getAvatar() {
            Object obj = this.avatar_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.avatar_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.ConstellationTopOrBuilder
        public ByteString getAvatarBytes() {
            Object obj = this.avatar_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.avatar_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        /* renamed from: getDefaultInstanceForType */
        public ConstellationTop m1886getDefaultInstanceForType() {
            return ConstellationTop.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_ConstellationTop_descriptor;
        }

        @Override // cn.irisgw.live.ConstellationTopOrBuilder
        public int getTopAnchor() {
            return this.topAnchor_;
        }

        @Override // cn.irisgw.live.ConstellationTopOrBuilder
        public int getTopUid() {
            return this.topUid_;
        }

        @Override // cn.irisgw.live.ConstellationTopOrBuilder
        public int getUid() {
            return this.uid_;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_ConstellationTop_fieldAccessorTable.ensureFieldAccessorsInitialized(ConstellationTop.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(ConstellationTop constellationTop) {
            if (constellationTop == ConstellationTop.getDefaultInstance()) {
                return this;
            }
            if (constellationTop.getTopAnchor() != 0) {
                setTopAnchor(constellationTop.getTopAnchor());
            }
            if (!constellationTop.getAnchorAvatar().isEmpty()) {
                this.anchorAvatar_ = constellationTop.anchorAvatar_;
                onChanged();
            }
            if (constellationTop.getTopUid() != 0) {
                setTopUid(constellationTop.getTopUid());
            }
            if (!constellationTop.getAvatar().isEmpty()) {
                this.avatar_ = constellationTop.avatar_;
                onChanged();
            }
            if (constellationTop.getUid() != 0) {
                setUid(constellationTop.getUid());
            }
            m1895mergeUnknownFields(constellationTop.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.ConstellationTop.Builder m1892mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.ConstellationTop.access$1000()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.ConstellationTop r0 = (cn.irisgw.live.ConstellationTop) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.ConstellationTop$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.ConstellationTop r0 = (cn.irisgw.live.ConstellationTop) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.ConstellationTop$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.ConstellationTop.Builder.m1892mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.ConstellationTop$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m1891mergeFrom(Message message) {
            if (message instanceof ConstellationTop) {
                return mergeFrom((ConstellationTop) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m1895mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setAnchorAvatar(String str) {
            if (str != null) {
                this.anchorAvatar_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setAnchorAvatarBytes(ByteString byteString) {
            if (byteString != null) {
                ConstellationTop.checkByteStringIsUtf8(byteString);
                this.anchorAvatar_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setAvatar(String str) {
            if (str != null) {
                this.avatar_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setAvatarBytes(ByteString byteString) {
            if (byteString != null) {
                ConstellationTop.checkByteStringIsUtf8(byteString);
                this.avatar_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        /* renamed from: setField */
        public Builder m1897setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        /* renamed from: setRepeatedField */
        public Builder m1899setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setTopAnchor(int i) {
            this.topAnchor_ = i;
            onChanged();
            return this;
        }

        public Builder setTopUid(int i) {
            this.topUid_ = i;
            onChanged();
            return this;
        }

        public Builder setUid(int i) {
            this.uid_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setUnknownFields */
        public final Builder m1901setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private ConstellationTop() {
        this.memoizedIsInitialized = (byte) -1;
        this.anchorAvatar_ = "";
        this.avatar_ = "";
    }

    private ConstellationTop(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.topAnchor_ = codedInputStream.readInt32();
                        } else if (readTag == 18) {
                            this.anchorAvatar_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 24) {
                            this.topUid_ = codedInputStream.readInt32();
                        } else if (readTag == 34) {
                            this.avatar_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 40) {
                            this.uid_ = codedInputStream.readInt32();
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

    private ConstellationTop(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static ConstellationTop getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_ConstellationTop_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m1862toBuilder();
    }

    public static Builder newBuilder(ConstellationTop constellationTop) {
        return DEFAULT_INSTANCE.m1862toBuilder().mergeFrom(constellationTop);
    }

    public static ConstellationTop parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static ConstellationTop parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ConstellationTop parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ConstellationTop) PARSER.parseFrom(byteString);
    }

    public static ConstellationTop parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ConstellationTop) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static ConstellationTop parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static ConstellationTop parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static ConstellationTop parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static ConstellationTop parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ConstellationTop parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ConstellationTop) PARSER.parseFrom(byteBuffer);
    }

    public static ConstellationTop parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ConstellationTop) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static ConstellationTop parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ConstellationTop) PARSER.parseFrom(bArr);
    }

    public static ConstellationTop parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ConstellationTop) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<ConstellationTop> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ConstellationTop) {
            ConstellationTop constellationTop = (ConstellationTop) obj;
            return getTopAnchor() == constellationTop.getTopAnchor() && getAnchorAvatar().equals(constellationTop.getAnchorAvatar()) && getTopUid() == constellationTop.getTopUid() && getAvatar().equals(constellationTop.getAvatar()) && getUid() == constellationTop.getUid() && this.unknownFields.equals(constellationTop.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.ConstellationTopOrBuilder
    public String getAnchorAvatar() {
        Object obj = this.anchorAvatar_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.anchorAvatar_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.ConstellationTopOrBuilder
    public ByteString getAnchorAvatarBytes() {
        Object obj = this.anchorAvatar_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.anchorAvatar_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.ConstellationTopOrBuilder
    public String getAvatar() {
        Object obj = this.avatar_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.avatar_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.ConstellationTopOrBuilder
    public ByteString getAvatarBytes() {
        Object obj = this.avatar_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.avatar_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    /* renamed from: getDefaultInstanceForType */
    public ConstellationTop m1857getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public Parser<ConstellationTop> getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        int i3 = this.topAnchor_;
        if (i3 != 0) {
            i2 = 0 + CodedOutputStream.computeInt32Size(1, i3);
        }
        int i4 = i2;
        if (!getAnchorAvatarBytes().isEmpty()) {
            i4 = i2 + GeneratedMessageV3.computeStringSize(2, this.anchorAvatar_);
        }
        int i5 = this.topUid_;
        int i6 = i4;
        if (i5 != 0) {
            i6 = i4 + CodedOutputStream.computeInt32Size(3, i5);
        }
        int i7 = i6;
        if (!getAvatarBytes().isEmpty()) {
            i7 = i6 + GeneratedMessageV3.computeStringSize(4, this.avatar_);
        }
        int i8 = this.uid_;
        int i9 = i7;
        if (i8 != 0) {
            i9 = i7 + CodedOutputStream.computeInt32Size(5, i8);
        }
        int serializedSize = i9 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.ConstellationTopOrBuilder
    public int getTopAnchor() {
        return this.topAnchor_;
    }

    @Override // cn.irisgw.live.ConstellationTopOrBuilder
    public int getTopUid() {
        return this.topUid_;
    }

    @Override // cn.irisgw.live.ConstellationTopOrBuilder
    public int getUid() {
        return this.uid_;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getTopAnchor()) * 37) + 2) * 53) + getAnchorAvatar().hashCode()) * 37) + 3) * 53) + getTopUid()) * 37) + 4) * 53) + getAvatar().hashCode()) * 37) + 5) * 53) + getUid()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_ConstellationTop_fieldAccessorTable.ensureFieldAccessorsInitialized(ConstellationTop.class, Builder.class);
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
    public Builder m1860newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m1859newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new ConstellationTop();
    }

    /* renamed from: toBuilder */
    public Builder m1862toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.topAnchor_;
        if (i != 0) {
            codedOutputStream.writeInt32(1, i);
        }
        if (!getAnchorAvatarBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.anchorAvatar_);
        }
        int i2 = this.topUid_;
        if (i2 != 0) {
            codedOutputStream.writeInt32(3, i2);
        }
        if (!getAvatarBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 4, this.avatar_);
        }
        int i3 = this.uid_;
        if (i3 != 0) {
            codedOutputStream.writeInt32(5, i3);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
