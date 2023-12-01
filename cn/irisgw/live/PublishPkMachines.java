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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/PublishPkMachines.class */
public final class PublishPkMachines extends GeneratedMessageV3 implements PublishPkMachinesOrBuilder {
    public static final int ANCHOR_FIELD_NUMBER = 6;
    public static final int BEANS_FIELD_NUMBER = 5;
    public static final int DESC_FIELD_NUMBER = 4;
    public static final int INDEX_FIELD_NUMBER = 2;
    public static final int MACHINES_FIELD_NUMBER = 1;
    public static final int MVP_FIELD_NUMBER = 7;
    public static final int STATUS_FIELD_NUMBER = 3;
    private static final long serialVersionUID = 0;
    private int anchor_;
    private int beans_;
    private volatile Object desc_;
    private int index_;
    private volatile Object machines_;
    private byte memoizedIsInitialized;
    private int mvp_;
    private int status_;
    private static final PublishPkMachines DEFAULT_INSTANCE = new PublishPkMachines();
    private static final Parser<PublishPkMachines> PARSER = new AbstractParser<PublishPkMachines>() { // from class: cn.irisgw.live.PublishPkMachines.1
        /* renamed from: parsePartialFrom */
        public PublishPkMachines m7124parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new PublishPkMachines(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/PublishPkMachines$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PublishPkMachinesOrBuilder {
        private int anchor_;
        private int beans_;
        private Object desc_;
        private int index_;
        private Object machines_;
        private int mvp_;
        private int status_;

        private Builder() {
            this.machines_ = "";
            this.desc_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.machines_ = "";
            this.desc_ = "";
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_PublishPkMachines_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = PublishPkMachines.alwaysUseFieldBuilders;
        }

        /* renamed from: addRepeatedField */
        public Builder m7126addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public PublishPkMachines m7128build() {
            PublishPkMachines m7130buildPartial = m7130buildPartial();
            if (m7130buildPartial.isInitialized()) {
                return m7130buildPartial;
            }
            throw newUninitializedMessageException(m7130buildPartial);
        }

        /* renamed from: buildPartial */
        public PublishPkMachines m7130buildPartial() {
            PublishPkMachines publishPkMachines = new PublishPkMachines(this);
            publishPkMachines.machines_ = this.machines_;
            publishPkMachines.index_ = this.index_;
            publishPkMachines.status_ = this.status_;
            publishPkMachines.desc_ = this.desc_;
            publishPkMachines.beans_ = this.beans_;
            publishPkMachines.anchor_ = this.anchor_;
            publishPkMachines.mvp_ = this.mvp_;
            onBuilt();
            return publishPkMachines;
        }

        /* renamed from: clear */
        public Builder m7134clear() {
            super.clear();
            this.machines_ = "";
            this.index_ = 0;
            this.status_ = 0;
            this.desc_ = "";
            this.beans_ = 0;
            this.anchor_ = 0;
            this.mvp_ = 0;
            return this;
        }

        public Builder clearAnchor() {
            this.anchor_ = 0;
            onChanged();
            return this;
        }

        public Builder clearBeans() {
            this.beans_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDesc() {
            this.desc_ = PublishPkMachines.getDefaultInstance().getDesc();
            onChanged();
            return this;
        }

        /* renamed from: clearField */
        public Builder m7136clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearIndex() {
            this.index_ = 0;
            onChanged();
            return this;
        }

        public Builder clearMachines() {
            this.machines_ = PublishPkMachines.getDefaultInstance().getMachines();
            onChanged();
            return this;
        }

        public Builder clearMvp() {
            this.mvp_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clearOneof */
        public Builder m7139clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearStatus() {
            this.status_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m7145clone() {
            return (Builder) super.clone();
        }

        @Override // cn.irisgw.live.PublishPkMachinesOrBuilder
        public int getAnchor() {
            return this.anchor_;
        }

        @Override // cn.irisgw.live.PublishPkMachinesOrBuilder
        public int getBeans() {
            return this.beans_;
        }

        /* renamed from: getDefaultInstanceForType */
        public PublishPkMachines m7147getDefaultInstanceForType() {
            return PublishPkMachines.getDefaultInstance();
        }

        @Override // cn.irisgw.live.PublishPkMachinesOrBuilder
        public String getDesc() {
            Object obj = this.desc_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.desc_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.PublishPkMachinesOrBuilder
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
            return LiveConstants.internal_static_cn_irisgw_live_PublishPkMachines_descriptor;
        }

        @Override // cn.irisgw.live.PublishPkMachinesOrBuilder
        public int getIndex() {
            return this.index_;
        }

        @Override // cn.irisgw.live.PublishPkMachinesOrBuilder
        public String getMachines() {
            Object obj = this.machines_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.machines_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.PublishPkMachinesOrBuilder
        public ByteString getMachinesBytes() {
            Object obj = this.machines_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.machines_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.PublishPkMachinesOrBuilder
        public int getMvp() {
            return this.mvp_;
        }

        @Override // cn.irisgw.live.PublishPkMachinesOrBuilder
        public int getStatus() {
            return this.status_;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_PublishPkMachines_fieldAccessorTable.ensureFieldAccessorsInitialized(PublishPkMachines.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(PublishPkMachines publishPkMachines) {
            if (publishPkMachines == PublishPkMachines.getDefaultInstance()) {
                return this;
            }
            if (!publishPkMachines.getMachines().isEmpty()) {
                this.machines_ = publishPkMachines.machines_;
                onChanged();
            }
            if (publishPkMachines.getIndex() != 0) {
                setIndex(publishPkMachines.getIndex());
            }
            if (publishPkMachines.getStatus() != 0) {
                setStatus(publishPkMachines.getStatus());
            }
            if (!publishPkMachines.getDesc().isEmpty()) {
                this.desc_ = publishPkMachines.desc_;
                onChanged();
            }
            if (publishPkMachines.getBeans() != 0) {
                setBeans(publishPkMachines.getBeans());
            }
            if (publishPkMachines.getAnchor() != 0) {
                setAnchor(publishPkMachines.getAnchor());
            }
            if (publishPkMachines.getMvp() != 0) {
                setMvp(publishPkMachines.getMvp());
            }
            m7156mergeUnknownFields(publishPkMachines.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.PublishPkMachines.Builder m7153mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.PublishPkMachines.access$1200()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.PublishPkMachines r0 = (cn.irisgw.live.PublishPkMachines) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.PublishPkMachines$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.PublishPkMachines r0 = (cn.irisgw.live.PublishPkMachines) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.PublishPkMachines$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.PublishPkMachines.Builder.m7153mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.PublishPkMachines$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m7152mergeFrom(Message message) {
            if (message instanceof PublishPkMachines) {
                return mergeFrom((PublishPkMachines) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m7156mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setAnchor(int i) {
            this.anchor_ = i;
            onChanged();
            return this;
        }

        public Builder setBeans(int i) {
            this.beans_ = i;
            onChanged();
            return this;
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
                PublishPkMachines.checkByteStringIsUtf8(byteString);
                this.desc_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        /* renamed from: setField */
        public Builder m7158setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setIndex(int i) {
            this.index_ = i;
            onChanged();
            return this;
        }

        public Builder setMachines(String str) {
            if (str != null) {
                this.machines_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setMachinesBytes(ByteString byteString) {
            if (byteString != null) {
                PublishPkMachines.checkByteStringIsUtf8(byteString);
                this.machines_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setMvp(int i) {
            this.mvp_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setRepeatedField */
        public Builder m7160setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setStatus(int i) {
            this.status_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setUnknownFields */
        public final Builder m7162setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private PublishPkMachines() {
        this.memoizedIsInitialized = (byte) -1;
        this.machines_ = "";
        this.desc_ = "";
    }

    private PublishPkMachines(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.machines_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 16) {
                                this.index_ = codedInputStream.readUInt32();
                            } else if (readTag == 24) {
                                this.status_ = codedInputStream.readUInt32();
                            } else if (readTag == 34) {
                                this.desc_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 40) {
                                this.beans_ = codedInputStream.readUInt32();
                            } else if (readTag == 48) {
                                this.anchor_ = codedInputStream.readUInt32();
                            } else if (readTag == 56) {
                                this.mvp_ = codedInputStream.readUInt32();
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

    private PublishPkMachines(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static PublishPkMachines getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_PublishPkMachines_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m7123toBuilder();
    }

    public static Builder newBuilder(PublishPkMachines publishPkMachines) {
        return DEFAULT_INSTANCE.m7123toBuilder().mergeFrom(publishPkMachines);
    }

    public static PublishPkMachines parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static PublishPkMachines parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PublishPkMachines parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (PublishPkMachines) PARSER.parseFrom(byteString);
    }

    public static PublishPkMachines parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PublishPkMachines) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static PublishPkMachines parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static PublishPkMachines parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static PublishPkMachines parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static PublishPkMachines parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PublishPkMachines parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (PublishPkMachines) PARSER.parseFrom(byteBuffer);
    }

    public static PublishPkMachines parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PublishPkMachines) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static PublishPkMachines parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (PublishPkMachines) PARSER.parseFrom(bArr);
    }

    public static PublishPkMachines parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PublishPkMachines) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<PublishPkMachines> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PublishPkMachines) {
            PublishPkMachines publishPkMachines = (PublishPkMachines) obj;
            return getMachines().equals(publishPkMachines.getMachines()) && getIndex() == publishPkMachines.getIndex() && getStatus() == publishPkMachines.getStatus() && getDesc().equals(publishPkMachines.getDesc()) && getBeans() == publishPkMachines.getBeans() && getAnchor() == publishPkMachines.getAnchor() && getMvp() == publishPkMachines.getMvp() && this.unknownFields.equals(publishPkMachines.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.PublishPkMachinesOrBuilder
    public int getAnchor() {
        return this.anchor_;
    }

    @Override // cn.irisgw.live.PublishPkMachinesOrBuilder
    public int getBeans() {
        return this.beans_;
    }

    /* renamed from: getDefaultInstanceForType */
    public PublishPkMachines m7118getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.PublishPkMachinesOrBuilder
    public String getDesc() {
        Object obj = this.desc_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.desc_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.PublishPkMachinesOrBuilder
    public ByteString getDescBytes() {
        Object obj = this.desc_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.desc_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.PublishPkMachinesOrBuilder
    public int getIndex() {
        return this.index_;
    }

    @Override // cn.irisgw.live.PublishPkMachinesOrBuilder
    public String getMachines() {
        Object obj = this.machines_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.machines_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.PublishPkMachinesOrBuilder
    public ByteString getMachinesBytes() {
        Object obj = this.machines_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.machines_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.PublishPkMachinesOrBuilder
    public int getMvp() {
        return this.mvp_;
    }

    public Parser<PublishPkMachines> getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (!getMachinesBytes().isEmpty()) {
            i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.machines_);
        }
        int i3 = this.index_;
        int i4 = i2;
        if (i3 != 0) {
            i4 = i2 + CodedOutputStream.computeUInt32Size(2, i3);
        }
        int i5 = this.status_;
        int i6 = i4;
        if (i5 != 0) {
            i6 = i4 + CodedOutputStream.computeUInt32Size(3, i5);
        }
        int i7 = i6;
        if (!getDescBytes().isEmpty()) {
            i7 = i6 + GeneratedMessageV3.computeStringSize(4, this.desc_);
        }
        int i8 = this.beans_;
        int i9 = i7;
        if (i8 != 0) {
            i9 = i7 + CodedOutputStream.computeUInt32Size(5, i8);
        }
        int i10 = this.anchor_;
        int i11 = i9;
        if (i10 != 0) {
            i11 = i9 + CodedOutputStream.computeUInt32Size(6, i10);
        }
        int i12 = this.mvp_;
        int i13 = i11;
        if (i12 != 0) {
            i13 = i11 + CodedOutputStream.computeUInt32Size(7, i12);
        }
        int serializedSize = i13 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.PublishPkMachinesOrBuilder
    public int getStatus() {
        return this.status_;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getMachines().hashCode()) * 37) + 2) * 53) + getIndex()) * 37) + 3) * 53) + getStatus()) * 37) + 4) * 53) + getDesc().hashCode()) * 37) + 5) * 53) + getBeans()) * 37) + 6) * 53) + getAnchor()) * 37) + 7) * 53) + getMvp()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_PublishPkMachines_fieldAccessorTable.ensureFieldAccessorsInitialized(PublishPkMachines.class, Builder.class);
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
    public Builder m7121newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m7120newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new PublishPkMachines();
    }

    /* renamed from: toBuilder */
    public Builder m7123toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!getMachinesBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.machines_);
        }
        int i = this.index_;
        if (i != 0) {
            codedOutputStream.writeUInt32(2, i);
        }
        int i2 = this.status_;
        if (i2 != 0) {
            codedOutputStream.writeUInt32(3, i2);
        }
        if (!getDescBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 4, this.desc_);
        }
        int i3 = this.beans_;
        if (i3 != 0) {
            codedOutputStream.writeUInt32(5, i3);
        }
        int i4 = this.anchor_;
        if (i4 != 0) {
            codedOutputStream.writeUInt32(6, i4);
        }
        int i5 = this.mvp_;
        if (i5 != 0) {
            codedOutputStream.writeUInt32(7, i5);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
