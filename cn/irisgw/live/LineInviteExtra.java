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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LineInviteExtra.class */
public final class LineInviteExtra extends GeneratedMessageV3 implements LineInviteExtraOrBuilder {
    public static final int AVATAR_FIELD_NUMBER = 3;
    public static final int NAME_FIELD_NUMBER = 2;
    public static final int RESET_FIELD_NUMBER = 4;
    public static final int TYPE_FIELD_NUMBER = 5;
    public static final int UID_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private volatile Object avatar_;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private int reset_;
    private int type_;
    private int uid_;
    private static final LineInviteExtra DEFAULT_INSTANCE = new LineInviteExtra();
    private static final Parser<LineInviteExtra> PARSER = new AbstractParser<LineInviteExtra>() { // from class: cn.irisgw.live.LineInviteExtra.1
        /* renamed from: parsePartialFrom */
        public LineInviteExtra m4042parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new LineInviteExtra(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LineInviteExtra$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LineInviteExtraOrBuilder {
        private Object avatar_;
        private Object name_;
        private int reset_;
        private int type_;
        private int uid_;

        private Builder() {
            this.name_ = "";
            this.avatar_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.name_ = "";
            this.avatar_ = "";
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_LineInviteExtra_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = LineInviteExtra.alwaysUseFieldBuilders;
        }

        /* renamed from: addRepeatedField */
        public Builder m4044addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public LineInviteExtra m4046build() {
            LineInviteExtra m4048buildPartial = m4048buildPartial();
            if (m4048buildPartial.isInitialized()) {
                return m4048buildPartial;
            }
            throw newUninitializedMessageException(m4048buildPartial);
        }

        /* renamed from: buildPartial */
        public LineInviteExtra m4048buildPartial() {
            LineInviteExtra lineInviteExtra = new LineInviteExtra(this);
            lineInviteExtra.uid_ = this.uid_;
            lineInviteExtra.name_ = this.name_;
            lineInviteExtra.avatar_ = this.avatar_;
            lineInviteExtra.reset_ = this.reset_;
            lineInviteExtra.type_ = this.type_;
            onBuilt();
            return lineInviteExtra;
        }

        /* renamed from: clear */
        public Builder m4052clear() {
            super.clear();
            this.uid_ = 0;
            this.name_ = "";
            this.avatar_ = "";
            this.reset_ = 0;
            this.type_ = 0;
            return this;
        }

        public Builder clearAvatar() {
            this.avatar_ = LineInviteExtra.getDefaultInstance().getAvatar();
            onChanged();
            return this;
        }

        /* renamed from: clearField */
        public Builder m4054clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearName() {
            this.name_ = LineInviteExtra.getDefaultInstance().getName();
            onChanged();
            return this;
        }

        /* renamed from: clearOneof */
        public Builder m4057clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearReset() {
            this.reset_ = 0;
            onChanged();
            return this;
        }

        public Builder clearType() {
            this.type_ = 0;
            onChanged();
            return this;
        }

        public Builder clearUid() {
            this.uid_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m4063clone() {
            return (Builder) super.clone();
        }

        @Override // cn.irisgw.live.LineInviteExtraOrBuilder
        public String getAvatar() {
            Object obj = this.avatar_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.avatar_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LineInviteExtraOrBuilder
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
        public LineInviteExtra m4065getDefaultInstanceForType() {
            return LineInviteExtra.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_LineInviteExtra_descriptor;
        }

        @Override // cn.irisgw.live.LineInviteExtraOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LineInviteExtraOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.LineInviteExtraOrBuilder
        public int getReset() {
            return this.reset_;
        }

        @Override // cn.irisgw.live.LineInviteExtraOrBuilder
        public int getType() {
            return this.type_;
        }

        @Override // cn.irisgw.live.LineInviteExtraOrBuilder
        public int getUid() {
            return this.uid_;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_LineInviteExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(LineInviteExtra.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(LineInviteExtra lineInviteExtra) {
            if (lineInviteExtra == LineInviteExtra.getDefaultInstance()) {
                return this;
            }
            if (lineInviteExtra.getUid() != 0) {
                setUid(lineInviteExtra.getUid());
            }
            if (!lineInviteExtra.getName().isEmpty()) {
                this.name_ = lineInviteExtra.name_;
                onChanged();
            }
            if (!lineInviteExtra.getAvatar().isEmpty()) {
                this.avatar_ = lineInviteExtra.avatar_;
                onChanged();
            }
            if (lineInviteExtra.getReset() != 0) {
                setReset(lineInviteExtra.getReset());
            }
            if (lineInviteExtra.getType() != 0) {
                setType(lineInviteExtra.getType());
            }
            m4074mergeUnknownFields(lineInviteExtra.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.LineInviteExtra.Builder m4071mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.LineInviteExtra.access$1000()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.LineInviteExtra r0 = (cn.irisgw.live.LineInviteExtra) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.LineInviteExtra$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.LineInviteExtra r0 = (cn.irisgw.live.LineInviteExtra) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.LineInviteExtra$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.LineInviteExtra.Builder.m4071mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.LineInviteExtra$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m4070mergeFrom(Message message) {
            if (message instanceof LineInviteExtra) {
                return mergeFrom((LineInviteExtra) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m4074mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
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
                LineInviteExtra.checkByteStringIsUtf8(byteString);
                this.avatar_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        /* renamed from: setField */
        public Builder m4076setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setName(String str) {
            if (str != null) {
                this.name_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setNameBytes(ByteString byteString) {
            if (byteString != null) {
                LineInviteExtra.checkByteStringIsUtf8(byteString);
                this.name_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        /* renamed from: setRepeatedField */
        public Builder m4078setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setReset(int i) {
            this.reset_ = i;
            onChanged();
            return this;
        }

        public Builder setType(int i) {
            this.type_ = i;
            onChanged();
            return this;
        }

        public Builder setUid(int i) {
            this.uid_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setUnknownFields */
        public final Builder m4080setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private LineInviteExtra() {
        this.memoizedIsInitialized = (byte) -1;
        this.name_ = "";
        this.avatar_ = "";
    }

    private LineInviteExtra(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.uid_ = codedInputStream.readUInt32();
                        } else if (readTag == 18) {
                            this.name_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 26) {
                            this.avatar_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 32) {
                            this.reset_ = codedInputStream.readUInt32();
                        } else if (readTag == 40) {
                            this.type_ = codedInputStream.readUInt32();
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

    private LineInviteExtra(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static LineInviteExtra getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_LineInviteExtra_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m4041toBuilder();
    }

    public static Builder newBuilder(LineInviteExtra lineInviteExtra) {
        return DEFAULT_INSTANCE.m4041toBuilder().mergeFrom(lineInviteExtra);
    }

    public static LineInviteExtra parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static LineInviteExtra parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LineInviteExtra parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (LineInviteExtra) PARSER.parseFrom(byteString);
    }

    public static LineInviteExtra parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LineInviteExtra) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static LineInviteExtra parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static LineInviteExtra parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static LineInviteExtra parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static LineInviteExtra parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LineInviteExtra parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (LineInviteExtra) PARSER.parseFrom(byteBuffer);
    }

    public static LineInviteExtra parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LineInviteExtra) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static LineInviteExtra parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (LineInviteExtra) PARSER.parseFrom(bArr);
    }

    public static LineInviteExtra parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LineInviteExtra) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<LineInviteExtra> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LineInviteExtra) {
            LineInviteExtra lineInviteExtra = (LineInviteExtra) obj;
            return getUid() == lineInviteExtra.getUid() && getName().equals(lineInviteExtra.getName()) && getAvatar().equals(lineInviteExtra.getAvatar()) && getReset() == lineInviteExtra.getReset() && getType() == lineInviteExtra.getType() && this.unknownFields.equals(lineInviteExtra.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.LineInviteExtraOrBuilder
    public String getAvatar() {
        Object obj = this.avatar_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.avatar_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.LineInviteExtraOrBuilder
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
    public LineInviteExtra m4036getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.LineInviteExtraOrBuilder
    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.LineInviteExtraOrBuilder
    public ByteString getNameBytes() {
        Object obj = this.name_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.name_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    public Parser<LineInviteExtra> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.LineInviteExtraOrBuilder
    public int getReset() {
        return this.reset_;
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
        int i4 = i2;
        if (!getNameBytes().isEmpty()) {
            i4 = i2 + GeneratedMessageV3.computeStringSize(2, this.name_);
        }
        int i5 = i4;
        if (!getAvatarBytes().isEmpty()) {
            i5 = i4 + GeneratedMessageV3.computeStringSize(3, this.avatar_);
        }
        int i6 = this.reset_;
        int i7 = i5;
        if (i6 != 0) {
            i7 = i5 + CodedOutputStream.computeUInt32Size(4, i6);
        }
        int i8 = this.type_;
        int i9 = i7;
        if (i8 != 0) {
            i9 = i7 + CodedOutputStream.computeUInt32Size(5, i8);
        }
        int serializedSize = i9 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.LineInviteExtraOrBuilder
    public int getType() {
        return this.type_;
    }

    @Override // cn.irisgw.live.LineInviteExtraOrBuilder
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
        int hashCode = ((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getUid()) * 37) + 2) * 53) + getName().hashCode()) * 37) + 3) * 53) + getAvatar().hashCode()) * 37) + 4) * 53) + getReset()) * 37) + 5) * 53) + getType()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_LineInviteExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(LineInviteExtra.class, Builder.class);
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
    public Builder m4039newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m4038newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new LineInviteExtra();
    }

    /* renamed from: toBuilder */
    public Builder m4041toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.uid_;
        if (i != 0) {
            codedOutputStream.writeUInt32(1, i);
        }
        if (!getNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.name_);
        }
        if (!getAvatarBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 3, this.avatar_);
        }
        int i2 = this.reset_;
        if (i2 != 0) {
            codedOutputStream.writeUInt32(4, i2);
        }
        int i3 = this.type_;
        if (i3 != 0) {
            codedOutputStream.writeUInt32(5, i3);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
