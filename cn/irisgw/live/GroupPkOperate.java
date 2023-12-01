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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/GroupPkOperate.class */
public final class GroupPkOperate extends GeneratedMessageV3 implements GroupPkOperateOrBuilder {
    public static final int FROM_UID_FIELD_NUMBER = 3;
    public static final int TEXT_FIELD_NUMBER = 2;
    public static final int TYPE_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private int fromUid_;
    private byte memoizedIsInitialized;
    private volatile Object text_;
    private int type_;
    private static final GroupPkOperate DEFAULT_INSTANCE = new GroupPkOperate();
    private static final Parser<GroupPkOperate> PARSER = new AbstractParser<GroupPkOperate>() { // from class: cn.irisgw.live.GroupPkOperate.1
        /* renamed from: parsePartialFrom */
        public GroupPkOperate m3096parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new GroupPkOperate(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/GroupPkOperate$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GroupPkOperateOrBuilder {
        private int fromUid_;
        private Object text_;
        private int type_;

        private Builder() {
            this.text_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.text_ = "";
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_GroupPkOperate_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = GroupPkOperate.alwaysUseFieldBuilders;
        }

        /* renamed from: addRepeatedField */
        public Builder m3098addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public GroupPkOperate m3100build() {
            GroupPkOperate m3102buildPartial = m3102buildPartial();
            if (m3102buildPartial.isInitialized()) {
                return m3102buildPartial;
            }
            throw newUninitializedMessageException(m3102buildPartial);
        }

        /* renamed from: buildPartial */
        public GroupPkOperate m3102buildPartial() {
            GroupPkOperate groupPkOperate = new GroupPkOperate(this);
            groupPkOperate.type_ = this.type_;
            groupPkOperate.text_ = this.text_;
            groupPkOperate.fromUid_ = this.fromUid_;
            onBuilt();
            return groupPkOperate;
        }

        /* renamed from: clear */
        public Builder m3106clear() {
            super.clear();
            this.type_ = 0;
            this.text_ = "";
            this.fromUid_ = 0;
            return this;
        }

        /* renamed from: clearField */
        public Builder m3108clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearFromUid() {
            this.fromUid_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clearOneof */
        public Builder m3111clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearText() {
            this.text_ = GroupPkOperate.getDefaultInstance().getText();
            onChanged();
            return this;
        }

        public Builder clearType() {
            this.type_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m3117clone() {
            return (Builder) super.clone();
        }

        /* renamed from: getDefaultInstanceForType */
        public GroupPkOperate m3119getDefaultInstanceForType() {
            return GroupPkOperate.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_GroupPkOperate_descriptor;
        }

        @Override // cn.irisgw.live.GroupPkOperateOrBuilder
        public int getFromUid() {
            return this.fromUid_;
        }

        @Override // cn.irisgw.live.GroupPkOperateOrBuilder
        public String getText() {
            Object obj = this.text_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.text_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.GroupPkOperateOrBuilder
        public ByteString getTextBytes() {
            Object obj = this.text_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.text_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.GroupPkOperateOrBuilder
        public int getType() {
            return this.type_;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_GroupPkOperate_fieldAccessorTable.ensureFieldAccessorsInitialized(GroupPkOperate.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(GroupPkOperate groupPkOperate) {
            if (groupPkOperate == GroupPkOperate.getDefaultInstance()) {
                return this;
            }
            if (groupPkOperate.getType() != 0) {
                setType(groupPkOperate.getType());
            }
            if (!groupPkOperate.getText().isEmpty()) {
                this.text_ = groupPkOperate.text_;
                onChanged();
            }
            if (groupPkOperate.getFromUid() != 0) {
                setFromUid(groupPkOperate.getFromUid());
            }
            m3128mergeUnknownFields(groupPkOperate.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.GroupPkOperate.Builder m3125mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.GroupPkOperate.access$800()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.GroupPkOperate r0 = (cn.irisgw.live.GroupPkOperate) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.GroupPkOperate$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.GroupPkOperate r0 = (cn.irisgw.live.GroupPkOperate) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.GroupPkOperate$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.GroupPkOperate.Builder.m3125mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.GroupPkOperate$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m3124mergeFrom(Message message) {
            if (message instanceof GroupPkOperate) {
                return mergeFrom((GroupPkOperate) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m3128mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        /* renamed from: setField */
        public Builder m3130setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setFromUid(int i) {
            this.fromUid_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setRepeatedField */
        public Builder m3132setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setText(String str) {
            if (str != null) {
                this.text_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setTextBytes(ByteString byteString) {
            if (byteString != null) {
                GroupPkOperate.checkByteStringIsUtf8(byteString);
                this.text_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setType(int i) {
            this.type_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setUnknownFields */
        public final Builder m3134setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private GroupPkOperate() {
        this.memoizedIsInitialized = (byte) -1;
        this.text_ = "";
    }

    private GroupPkOperate(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.type_ = codedInputStream.readInt32();
                            } else if (readTag == 18) {
                                this.text_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 24) {
                                this.fromUid_ = codedInputStream.readUInt32();
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

    private GroupPkOperate(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static GroupPkOperate getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_GroupPkOperate_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m3095toBuilder();
    }

    public static Builder newBuilder(GroupPkOperate groupPkOperate) {
        return DEFAULT_INSTANCE.m3095toBuilder().mergeFrom(groupPkOperate);
    }

    public static GroupPkOperate parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static GroupPkOperate parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static GroupPkOperate parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (GroupPkOperate) PARSER.parseFrom(byteString);
    }

    public static GroupPkOperate parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (GroupPkOperate) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static GroupPkOperate parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static GroupPkOperate parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static GroupPkOperate parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static GroupPkOperate parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static GroupPkOperate parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (GroupPkOperate) PARSER.parseFrom(byteBuffer);
    }

    public static GroupPkOperate parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (GroupPkOperate) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static GroupPkOperate parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (GroupPkOperate) PARSER.parseFrom(bArr);
    }

    public static GroupPkOperate parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (GroupPkOperate) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<GroupPkOperate> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GroupPkOperate) {
            GroupPkOperate groupPkOperate = (GroupPkOperate) obj;
            return getType() == groupPkOperate.getType() && getText().equals(groupPkOperate.getText()) && getFromUid() == groupPkOperate.getFromUid() && this.unknownFields.equals(groupPkOperate.unknownFields);
        }
        return super.equals(obj);
    }

    /* renamed from: getDefaultInstanceForType */
    public GroupPkOperate m3090getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.GroupPkOperateOrBuilder
    public int getFromUid() {
        return this.fromUid_;
    }

    public Parser<GroupPkOperate> getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        int i3 = this.type_;
        if (i3 != 0) {
            i2 = 0 + CodedOutputStream.computeInt32Size(1, i3);
        }
        int i4 = i2;
        if (!getTextBytes().isEmpty()) {
            i4 = i2 + GeneratedMessageV3.computeStringSize(2, this.text_);
        }
        int i5 = this.fromUid_;
        int i6 = i4;
        if (i5 != 0) {
            i6 = i4 + CodedOutputStream.computeUInt32Size(3, i5);
        }
        int serializedSize = i6 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.GroupPkOperateOrBuilder
    public String getText() {
        Object obj = this.text_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.text_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.GroupPkOperateOrBuilder
    public ByteString getTextBytes() {
        Object obj = this.text_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.text_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.GroupPkOperateOrBuilder
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
        int hashCode = ((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getType()) * 37) + 2) * 53) + getText().hashCode()) * 37) + 3) * 53) + getFromUid()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_GroupPkOperate_fieldAccessorTable.ensureFieldAccessorsInitialized(GroupPkOperate.class, Builder.class);
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
    public Builder m3093newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m3092newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new GroupPkOperate();
    }

    /* renamed from: toBuilder */
    public Builder m3095toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.type_;
        if (i != 0) {
            codedOutputStream.writeInt32(1, i);
        }
        if (!getTextBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.text_);
        }
        int i2 = this.fromUid_;
        if (i2 != 0) {
            codedOutputStream.writeUInt32(3, i2);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
