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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/UpdateGoodsWishList.class */
public final class UpdateGoodsWishList extends GeneratedMessageV3 implements UpdateGoodsWishListOrBuilder {
    public static final int COUNT_FIELD_NUMBER = 2;
    public static final int GOODS_ID_FIELD_NUMBER = 3;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int PROGRESS_FIELD_NUMBER = 4;
    private static final long serialVersionUID = 0;
    private int count_;
    private int goodsId_;
    private int id_;
    private byte memoizedIsInitialized;
    private int progress_;
    private static final UpdateGoodsWishList DEFAULT_INSTANCE = new UpdateGoodsWishList();
    private static final Parser<UpdateGoodsWishList> PARSER = new AbstractParser<UpdateGoodsWishList>() { // from class: cn.irisgw.live.UpdateGoodsWishList.1
        @Override // com.google.protobuf.Parser
        public UpdateGoodsWishList parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new UpdateGoodsWishList(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/UpdateGoodsWishList$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements UpdateGoodsWishListOrBuilder {
        private int count_;
        private int goodsId_;
        private int id_;
        private int progress_;

        private Builder() {
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_UpdateGoodsWishList_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = UpdateGoodsWishList.alwaysUseFieldBuilders;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public UpdateGoodsWishList build() {
            UpdateGoodsWishList buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public UpdateGoodsWishList buildPartial() {
            UpdateGoodsWishList updateGoodsWishList = new UpdateGoodsWishList(this);
            updateGoodsWishList.id_ = this.id_;
            updateGoodsWishList.count_ = this.count_;
            updateGoodsWishList.goodsId_ = this.goodsId_;
            updateGoodsWishList.progress_ = this.progress_;
            onBuilt();
            return updateGoodsWishList;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.id_ = 0;
            this.count_ = 0;
            this.goodsId_ = 0;
            this.progress_ = 0;
            return this;
        }

        public Builder clearCount() {
            this.count_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearGoodsId() {
            this.goodsId_ = 0;
            onChanged();
            return this;
        }

        public Builder clearId() {
            this.id_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearProgress() {
            this.progress_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo1800clone() {
            return (Builder) super.mo1800clone();
        }

        @Override // cn.irisgw.live.UpdateGoodsWishListOrBuilder
        public int getCount() {
            return this.count_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public UpdateGoodsWishList getDefaultInstanceForType() {
            return UpdateGoodsWishList.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_UpdateGoodsWishList_descriptor;
        }

        @Override // cn.irisgw.live.UpdateGoodsWishListOrBuilder
        public int getGoodsId() {
            return this.goodsId_;
        }

        @Override // cn.irisgw.live.UpdateGoodsWishListOrBuilder
        public int getId() {
            return this.id_;
        }

        @Override // cn.irisgw.live.UpdateGoodsWishListOrBuilder
        public int getProgress() {
            return this.progress_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_UpdateGoodsWishList_fieldAccessorTable.ensureFieldAccessorsInitialized(UpdateGoodsWishList.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(UpdateGoodsWishList updateGoodsWishList) {
            if (updateGoodsWishList == UpdateGoodsWishList.getDefaultInstance()) {
                return this;
            }
            if (updateGoodsWishList.getId() != 0) {
                setId(updateGoodsWishList.getId());
            }
            if (updateGoodsWishList.getCount() != 0) {
                setCount(updateGoodsWishList.getCount());
            }
            if (updateGoodsWishList.getGoodsId() != 0) {
                setGoodsId(updateGoodsWishList.getGoodsId());
            }
            if (updateGoodsWishList.getProgress() != 0) {
                setProgress(updateGoodsWishList.getProgress());
            }
            mergeUnknownFields(updateGoodsWishList.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.UpdateGoodsWishList.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.UpdateGoodsWishList.access$900()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.UpdateGoodsWishList r0 = (cn.irisgw.live.UpdateGoodsWishList) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.UpdateGoodsWishList$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.UpdateGoodsWishList r0 = (cn.irisgw.live.UpdateGoodsWishList) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.UpdateGoodsWishList$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.UpdateGoodsWishList.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.UpdateGoodsWishList$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof UpdateGoodsWishList) {
                return mergeFrom((UpdateGoodsWishList) message);
            }
            super.mergeFrom(message);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setCount(int i) {
            this.count_ = i;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setGoodsId(int i) {
            this.goodsId_ = i;
            onChanged();
            return this;
        }

        public Builder setId(int i) {
            this.id_ = i;
            onChanged();
            return this;
        }

        public Builder setProgress(int i) {
            this.progress_ = i;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private UpdateGoodsWishList() {
        this.memoizedIsInitialized = (byte) -1;
    }

    private UpdateGoodsWishList(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.id_ = codedInputStream.readUInt32();
                        } else if (readTag == 16) {
                            this.count_ = codedInputStream.readUInt32();
                        } else if (readTag == 24) {
                            this.goodsId_ = codedInputStream.readUInt32();
                        } else if (readTag == 32) {
                            this.progress_ = codedInputStream.readUInt32();
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

    private UpdateGoodsWishList(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static UpdateGoodsWishList getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_UpdateGoodsWishList_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(UpdateGoodsWishList updateGoodsWishList) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(updateGoodsWishList);
    }

    public static UpdateGoodsWishList parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (UpdateGoodsWishList) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static UpdateGoodsWishList parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (UpdateGoodsWishList) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static UpdateGoodsWishList parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static UpdateGoodsWishList parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static UpdateGoodsWishList parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (UpdateGoodsWishList) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static UpdateGoodsWishList parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (UpdateGoodsWishList) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static UpdateGoodsWishList parseFrom(InputStream inputStream) throws IOException {
        return (UpdateGoodsWishList) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static UpdateGoodsWishList parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (UpdateGoodsWishList) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static UpdateGoodsWishList parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static UpdateGoodsWishList parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static UpdateGoodsWishList parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static UpdateGoodsWishList parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<UpdateGoodsWishList> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof UpdateGoodsWishList) {
            UpdateGoodsWishList updateGoodsWishList = (UpdateGoodsWishList) obj;
            return getId() == updateGoodsWishList.getId() && getCount() == updateGoodsWishList.getCount() && getGoodsId() == updateGoodsWishList.getGoodsId() && getProgress() == updateGoodsWishList.getProgress() && this.unknownFields.equals(updateGoodsWishList.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.UpdateGoodsWishListOrBuilder
    public int getCount() {
        return this.count_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public UpdateGoodsWishList getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.UpdateGoodsWishListOrBuilder
    public int getGoodsId() {
        return this.goodsId_;
    }

    @Override // cn.irisgw.live.UpdateGoodsWishListOrBuilder
    public int getId() {
        return this.id_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<UpdateGoodsWishList> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.UpdateGoodsWishListOrBuilder
    public int getProgress() {
        return this.progress_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        int i3 = this.id_;
        if (i3 != 0) {
            i2 = 0 + CodedOutputStream.computeUInt32Size(1, i3);
        }
        int i4 = this.count_;
        int i5 = i2;
        if (i4 != 0) {
            i5 = i2 + CodedOutputStream.computeUInt32Size(2, i4);
        }
        int i6 = this.goodsId_;
        int i7 = i5;
        if (i6 != 0) {
            i7 = i5 + CodedOutputStream.computeUInt32Size(3, i6);
        }
        int i8 = this.progress_;
        int i9 = i7;
        if (i8 != 0) {
            i9 = i7 + CodedOutputStream.computeUInt32Size(4, i8);
        }
        int serializedSize = i9 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getId()) * 37) + 2) * 53) + getCount()) * 37) + 3) * 53) + getGoodsId()) * 37) + 4) * 53) + getProgress()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_UpdateGoodsWishList_fieldAccessorTable.ensureFieldAccessorsInitialized(UpdateGoodsWishList.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
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

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new UpdateGoodsWishList();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.id_;
        if (i != 0) {
            codedOutputStream.writeUInt32(1, i);
        }
        int i2 = this.count_;
        if (i2 != 0) {
            codedOutputStream.writeUInt32(2, i2);
        }
        int i3 = this.goodsId_;
        if (i3 != 0) {
            codedOutputStream.writeUInt32(3, i3);
        }
        int i4 = this.progress_;
        if (i4 != 0) {
            codedOutputStream.writeUInt32(4, i4);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
