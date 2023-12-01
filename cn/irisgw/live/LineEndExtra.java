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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LineEndExtra.class */
public final class LineEndExtra extends GeneratedMessageV3 implements LineEndExtraOrBuilder {
    public static final int CLOSED_BY_FIELD_NUMBER = 1;
    private static final LineEndExtra DEFAULT_INSTANCE = new LineEndExtra();
    private static final Parser<LineEndExtra> PARSER = new AbstractParser<LineEndExtra>() { // from class: cn.irisgw.live.LineEndExtra.1
        /* renamed from: parsePartialFrom */
        public LineEndExtra m3995parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new LineEndExtra(codedInputStream, extensionRegistryLite);
        }
    };
    public static final int TYPE_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private int closedBy_;
    private byte memoizedIsInitialized;
    private int type_;

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LineEndExtra$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LineEndExtraOrBuilder {
        private int closedBy_;
        private int type_;

        private Builder() {
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_LineEndExtra_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = LineEndExtra.alwaysUseFieldBuilders;
        }

        /* renamed from: addRepeatedField */
        public Builder m3997addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public LineEndExtra m3999build() {
            LineEndExtra m4001buildPartial = m4001buildPartial();
            if (m4001buildPartial.isInitialized()) {
                return m4001buildPartial;
            }
            throw newUninitializedMessageException(m4001buildPartial);
        }

        /* renamed from: buildPartial */
        public LineEndExtra m4001buildPartial() {
            LineEndExtra lineEndExtra = new LineEndExtra(this);
            lineEndExtra.closedBy_ = this.closedBy_;
            lineEndExtra.type_ = this.type_;
            onBuilt();
            return lineEndExtra;
        }

        /* renamed from: clear */
        public Builder m4005clear() {
            super.clear();
            this.closedBy_ = 0;
            this.type_ = 0;
            return this;
        }

        public Builder clearClosedBy() {
            this.closedBy_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clearField */
        public Builder m4007clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        /* renamed from: clearOneof */
        public Builder m4010clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearType() {
            this.type_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m4016clone() {
            return (Builder) super.clone();
        }

        @Override // cn.irisgw.live.LineEndExtraOrBuilder
        public int getClosedBy() {
            return this.closedBy_;
        }

        /* renamed from: getDefaultInstanceForType */
        public LineEndExtra m4018getDefaultInstanceForType() {
            return LineEndExtra.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_LineEndExtra_descriptor;
        }

        @Override // cn.irisgw.live.LineEndExtraOrBuilder
        public int getType() {
            return this.type_;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_LineEndExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(LineEndExtra.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(LineEndExtra lineEndExtra) {
            if (lineEndExtra == LineEndExtra.getDefaultInstance()) {
                return this;
            }
            if (lineEndExtra.getClosedBy() != 0) {
                setClosedBy(lineEndExtra.getClosedBy());
            }
            if (lineEndExtra.getType() != 0) {
                setType(lineEndExtra.getType());
            }
            m4027mergeUnknownFields(lineEndExtra.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.LineEndExtra.Builder m4024mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.LineEndExtra.access$700()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.LineEndExtra r0 = (cn.irisgw.live.LineEndExtra) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.LineEndExtra$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.LineEndExtra r0 = (cn.irisgw.live.LineEndExtra) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.LineEndExtra$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.LineEndExtra.Builder.m4024mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.LineEndExtra$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m4023mergeFrom(Message message) {
            if (message instanceof LineEndExtra) {
                return mergeFrom((LineEndExtra) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m4027mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setClosedBy(int i) {
            this.closedBy_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setField */
        public Builder m4029setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        /* renamed from: setRepeatedField */
        public Builder m4031setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setType(int i) {
            this.type_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setUnknownFields */
        public final Builder m4033setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private LineEndExtra() {
        this.memoizedIsInitialized = (byte) -1;
    }

    private LineEndExtra(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            if (readTag == 8) {
                                this.closedBy_ = codedInputStream.readUInt32();
                            } else if (readTag == 16) {
                                this.type_ = codedInputStream.readUInt32();
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

    private LineEndExtra(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static LineEndExtra getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_LineEndExtra_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m3994toBuilder();
    }

    public static Builder newBuilder(LineEndExtra lineEndExtra) {
        return DEFAULT_INSTANCE.m3994toBuilder().mergeFrom(lineEndExtra);
    }

    public static LineEndExtra parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static LineEndExtra parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LineEndExtra parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (LineEndExtra) PARSER.parseFrom(byteString);
    }

    public static LineEndExtra parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LineEndExtra) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static LineEndExtra parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static LineEndExtra parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static LineEndExtra parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static LineEndExtra parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LineEndExtra parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (LineEndExtra) PARSER.parseFrom(byteBuffer);
    }

    public static LineEndExtra parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LineEndExtra) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static LineEndExtra parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (LineEndExtra) PARSER.parseFrom(bArr);
    }

    public static LineEndExtra parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LineEndExtra) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<LineEndExtra> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LineEndExtra) {
            LineEndExtra lineEndExtra = (LineEndExtra) obj;
            return getClosedBy() == lineEndExtra.getClosedBy() && getType() == lineEndExtra.getType() && this.unknownFields.equals(lineEndExtra.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.LineEndExtraOrBuilder
    public int getClosedBy() {
        return this.closedBy_;
    }

    /* renamed from: getDefaultInstanceForType */
    public LineEndExtra m3989getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public Parser<LineEndExtra> getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        int i3 = this.closedBy_;
        if (i3 != 0) {
            i2 = 0 + CodedOutputStream.computeUInt32Size(1, i3);
        }
        int i4 = this.type_;
        int i5 = i2;
        if (i4 != 0) {
            i5 = i2 + CodedOutputStream.computeUInt32Size(2, i4);
        }
        int serializedSize = i5 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.LineEndExtraOrBuilder
    public int getType() {
        return this.type_;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getClosedBy()) * 37) + 2) * 53) + getType()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_LineEndExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(LineEndExtra.class, Builder.class);
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
    public Builder m3992newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m3991newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new LineEndExtra();
    }

    /* renamed from: toBuilder */
    public Builder m3994toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.closedBy_;
        if (i != 0) {
            codedOutputStream.writeUInt32(1, i);
        }
        int i2 = this.type_;
        if (i2 != 0) {
            codedOutputStream.writeUInt32(2, i2);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
