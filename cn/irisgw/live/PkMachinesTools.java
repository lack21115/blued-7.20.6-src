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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/PkMachinesTools.class */
public final class PkMachinesTools extends GeneratedMessageV3 implements PkMachinesToolsOrBuilder {
    public static final int DESC_FIELD_NUMBER = 1;
    public static final int STATUS_FIELD_NUMBER = 2;
    public static final int TITLE_FIELD_NUMBER = 3;
    private static final long serialVersionUID = 0;
    private volatile Object desc_;
    private byte memoizedIsInitialized;
    private int status_;
    private volatile Object title_;
    private static final PkMachinesTools DEFAULT_INSTANCE = new PkMachinesTools();
    private static final Parser<PkMachinesTools> PARSER = new AbstractParser<PkMachinesTools>() { // from class: cn.irisgw.live.PkMachinesTools.1
        /* renamed from: parsePartialFrom */
        public PkMachinesTools m6693parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new PkMachinesTools(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/PkMachinesTools$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PkMachinesToolsOrBuilder {
        private Object desc_;
        private int status_;
        private Object title_;

        private Builder() {
            this.desc_ = "";
            this.title_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.desc_ = "";
            this.title_ = "";
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_PkMachinesTools_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = PkMachinesTools.alwaysUseFieldBuilders;
        }

        /* renamed from: addRepeatedField */
        public Builder m6695addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public PkMachinesTools m6697build() {
            PkMachinesTools m6699buildPartial = m6699buildPartial();
            if (m6699buildPartial.isInitialized()) {
                return m6699buildPartial;
            }
            throw newUninitializedMessageException(m6699buildPartial);
        }

        /* renamed from: buildPartial */
        public PkMachinesTools m6699buildPartial() {
            PkMachinesTools pkMachinesTools = new PkMachinesTools(this);
            pkMachinesTools.desc_ = this.desc_;
            pkMachinesTools.status_ = this.status_;
            pkMachinesTools.title_ = this.title_;
            onBuilt();
            return pkMachinesTools;
        }

        /* renamed from: clear */
        public Builder m6703clear() {
            super.clear();
            this.desc_ = "";
            this.status_ = 0;
            this.title_ = "";
            return this;
        }

        public Builder clearDesc() {
            this.desc_ = PkMachinesTools.getDefaultInstance().getDesc();
            onChanged();
            return this;
        }

        /* renamed from: clearField */
        public Builder m6705clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        /* renamed from: clearOneof */
        public Builder m6708clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearStatus() {
            this.status_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTitle() {
            this.title_ = PkMachinesTools.getDefaultInstance().getTitle();
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m6714clone() {
            return (Builder) super.clone();
        }

        /* renamed from: getDefaultInstanceForType */
        public PkMachinesTools m6716getDefaultInstanceForType() {
            return PkMachinesTools.getDefaultInstance();
        }

        @Override // cn.irisgw.live.PkMachinesToolsOrBuilder
        public String getDesc() {
            Object obj = this.desc_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.desc_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.PkMachinesToolsOrBuilder
        public ByteString getDescBytes() {
            Object obj = this.desc_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.desc_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_PkMachinesTools_descriptor;
        }

        @Override // cn.irisgw.live.PkMachinesToolsOrBuilder
        public int getStatus() {
            return this.status_;
        }

        @Override // cn.irisgw.live.PkMachinesToolsOrBuilder
        public String getTitle() {
            Object obj = this.title_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.title_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.PkMachinesToolsOrBuilder
        public ByteString getTitleBytes() {
            Object obj = this.title_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.title_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_PkMachinesTools_fieldAccessorTable.ensureFieldAccessorsInitialized(PkMachinesTools.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(PkMachinesTools pkMachinesTools) {
            if (pkMachinesTools == PkMachinesTools.getDefaultInstance()) {
                return this;
            }
            if (!pkMachinesTools.getDesc().isEmpty()) {
                this.desc_ = pkMachinesTools.desc_;
                onChanged();
            }
            if (pkMachinesTools.getStatus() != 0) {
                setStatus(pkMachinesTools.getStatus());
            }
            if (!pkMachinesTools.getTitle().isEmpty()) {
                this.title_ = pkMachinesTools.title_;
                onChanged();
            }
            m6725mergeUnknownFields(pkMachinesTools.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.PkMachinesTools.Builder m6722mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.PkMachinesTools.access$800()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.PkMachinesTools r0 = (cn.irisgw.live.PkMachinesTools) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.PkMachinesTools$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.PkMachinesTools r0 = (cn.irisgw.live.PkMachinesTools) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.PkMachinesTools$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.PkMachinesTools.Builder.m6722mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.PkMachinesTools$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m6721mergeFrom(Message message) {
            if (message instanceof PkMachinesTools) {
                return mergeFrom((PkMachinesTools) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m6725mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setDesc(String str) {
            if (str != null) {
                this.desc_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setDescBytes(ByteString byteString) {
            if (byteString != null) {
                PkMachinesTools.checkByteStringIsUtf8(byteString);
                this.desc_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        /* renamed from: setField */
        public Builder m6727setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        /* renamed from: setRepeatedField */
        public Builder m6729setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setStatus(int i) {
            this.status_ = i;
            onChanged();
            return this;
        }

        public Builder setTitle(String str) {
            if (str != null) {
                this.title_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setTitleBytes(ByteString byteString) {
            if (byteString != null) {
                PkMachinesTools.checkByteStringIsUtf8(byteString);
                this.title_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        /* renamed from: setUnknownFields */
        public final Builder m6731setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private PkMachinesTools() {
        this.memoizedIsInitialized = (byte) -1;
        this.desc_ = "";
        this.title_ = "";
    }

    private PkMachinesTools(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.desc_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 16) {
                                this.status_ = codedInputStream.readUInt32();
                            } else if (readTag == 26) {
                                this.title_ = codedInputStream.readStringRequireUtf8();
                            } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    }
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                }
            } finally {
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
            }
        }
    }

    private PkMachinesTools(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static PkMachinesTools getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_PkMachinesTools_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m6692toBuilder();
    }

    public static Builder newBuilder(PkMachinesTools pkMachinesTools) {
        return DEFAULT_INSTANCE.m6692toBuilder().mergeFrom(pkMachinesTools);
    }

    public static PkMachinesTools parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static PkMachinesTools parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PkMachinesTools parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (PkMachinesTools) PARSER.parseFrom(byteString);
    }

    public static PkMachinesTools parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PkMachinesTools) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static PkMachinesTools parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static PkMachinesTools parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static PkMachinesTools parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static PkMachinesTools parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PkMachinesTools parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (PkMachinesTools) PARSER.parseFrom(byteBuffer);
    }

    public static PkMachinesTools parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PkMachinesTools) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static PkMachinesTools parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (PkMachinesTools) PARSER.parseFrom(bArr);
    }

    public static PkMachinesTools parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PkMachinesTools) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<PkMachinesTools> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PkMachinesTools) {
            PkMachinesTools pkMachinesTools = (PkMachinesTools) obj;
            return getDesc().equals(pkMachinesTools.getDesc()) && getStatus() == pkMachinesTools.getStatus() && getTitle().equals(pkMachinesTools.getTitle()) && this.unknownFields.equals(pkMachinesTools.unknownFields);
        }
        return super.equals(obj);
    }

    /* renamed from: getDefaultInstanceForType */
    public PkMachinesTools m6687getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.PkMachinesToolsOrBuilder
    public String getDesc() {
        Object obj = this.desc_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.desc_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.PkMachinesToolsOrBuilder
    public ByteString getDescBytes() {
        Object obj = this.desc_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.desc_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    public Parser<PkMachinesTools> getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (!getDescBytes().isEmpty()) {
            i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.desc_);
        }
        int i3 = this.status_;
        int i4 = i2;
        if (i3 != 0) {
            i4 = i2 + CodedOutputStream.computeUInt32Size(2, i3);
        }
        int i5 = i4;
        if (!getTitleBytes().isEmpty()) {
            i5 = i4 + GeneratedMessageV3.computeStringSize(3, this.title_);
        }
        int serializedSize = i5 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.PkMachinesToolsOrBuilder
    public int getStatus() {
        return this.status_;
    }

    @Override // cn.irisgw.live.PkMachinesToolsOrBuilder
    public String getTitle() {
        Object obj = this.title_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.title_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.PkMachinesToolsOrBuilder
    public ByteString getTitleBytes() {
        Object obj = this.title_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.title_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getDesc().hashCode()) * 37) + 2) * 53) + getStatus()) * 37) + 3) * 53) + getTitle().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_PkMachinesTools_fieldAccessorTable.ensureFieldAccessorsInitialized(PkMachinesTools.class, Builder.class);
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
    public Builder m6690newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m6689newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new PkMachinesTools();
    }

    /* renamed from: toBuilder */
    public Builder m6692toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!getDescBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.desc_);
        }
        int i = this.status_;
        if (i != 0) {
            codedOutputStream.writeUInt32(2, i);
        }
        if (!getTitleBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 3, this.title_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
