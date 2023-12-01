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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/FriendPKInviteExtra.class */
public final class FriendPKInviteExtra extends GeneratedMessageV3 implements FriendPKInviteExtraOrBuilder {
    public static final int AVATAR_FIELD_NUMBER = 3;
    public static final int LID_FIELD_NUMBER = 5;
    public static final int NAME_FIELD_NUMBER = 4;
    public static final int RESET_FIELD_NUMBER = 1;
    public static final int UID_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private volatile Object avatar_;
    private volatile Object lid_;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private int reset_;
    private int uid_;
    private static final FriendPKInviteExtra DEFAULT_INSTANCE = new FriendPKInviteExtra();
    private static final Parser<FriendPKInviteExtra> PARSER = new AbstractParser<FriendPKInviteExtra>() { // from class: cn.irisgw.live.FriendPKInviteExtra.1
        /* renamed from: parsePartialFrom */
        public FriendPKInviteExtra m2620parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new FriendPKInviteExtra(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/FriendPKInviteExtra$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FriendPKInviteExtraOrBuilder {
        private Object avatar_;
        private Object lid_;
        private Object name_;
        private int reset_;
        private int uid_;

        private Builder() {
            this.avatar_ = "";
            this.name_ = "";
            this.lid_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.avatar_ = "";
            this.name_ = "";
            this.lid_ = "";
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_FriendPKInviteExtra_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = FriendPKInviteExtra.alwaysUseFieldBuilders;
        }

        /* renamed from: addRepeatedField */
        public Builder m2622addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public FriendPKInviteExtra m2624build() {
            FriendPKInviteExtra m2626buildPartial = m2626buildPartial();
            if (m2626buildPartial.isInitialized()) {
                return m2626buildPartial;
            }
            throw newUninitializedMessageException(m2626buildPartial);
        }

        /* renamed from: buildPartial */
        public FriendPKInviteExtra m2626buildPartial() {
            FriendPKInviteExtra friendPKInviteExtra = new FriendPKInviteExtra(this);
            friendPKInviteExtra.reset_ = this.reset_;
            friendPKInviteExtra.uid_ = this.uid_;
            friendPKInviteExtra.avatar_ = this.avatar_;
            friendPKInviteExtra.name_ = this.name_;
            friendPKInviteExtra.lid_ = this.lid_;
            onBuilt();
            return friendPKInviteExtra;
        }

        /* renamed from: clear */
        public Builder m2630clear() {
            super.clear();
            this.reset_ = 0;
            this.uid_ = 0;
            this.avatar_ = "";
            this.name_ = "";
            this.lid_ = "";
            return this;
        }

        public Builder clearAvatar() {
            this.avatar_ = FriendPKInviteExtra.getDefaultInstance().getAvatar();
            onChanged();
            return this;
        }

        /* renamed from: clearField */
        public Builder m2632clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearLid() {
            this.lid_ = FriendPKInviteExtra.getDefaultInstance().getLid();
            onChanged();
            return this;
        }

        public Builder clearName() {
            this.name_ = FriendPKInviteExtra.getDefaultInstance().getName();
            onChanged();
            return this;
        }

        /* renamed from: clearOneof */
        public Builder m2635clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearReset() {
            this.reset_ = 0;
            onChanged();
            return this;
        }

        public Builder clearUid() {
            this.uid_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m2641clone() {
            return (Builder) super.clone();
        }

        @Override // cn.irisgw.live.FriendPKInviteExtraOrBuilder
        public String getAvatar() {
            Object obj = this.avatar_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.avatar_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.FriendPKInviteExtraOrBuilder
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
        public FriendPKInviteExtra m2643getDefaultInstanceForType() {
            return FriendPKInviteExtra.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_FriendPKInviteExtra_descriptor;
        }

        @Override // cn.irisgw.live.FriendPKInviteExtraOrBuilder
        public String getLid() {
            Object obj = this.lid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.lid_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.FriendPKInviteExtraOrBuilder
        public ByteString getLidBytes() {
            Object obj = this.lid_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.lid_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.FriendPKInviteExtraOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.FriendPKInviteExtraOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.FriendPKInviteExtraOrBuilder
        public int getReset() {
            return this.reset_;
        }

        @Override // cn.irisgw.live.FriendPKInviteExtraOrBuilder
        public int getUid() {
            return this.uid_;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_FriendPKInviteExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(FriendPKInviteExtra.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(FriendPKInviteExtra friendPKInviteExtra) {
            if (friendPKInviteExtra == FriendPKInviteExtra.getDefaultInstance()) {
                return this;
            }
            if (friendPKInviteExtra.getReset() != 0) {
                setReset(friendPKInviteExtra.getReset());
            }
            if (friendPKInviteExtra.getUid() != 0) {
                setUid(friendPKInviteExtra.getUid());
            }
            if (!friendPKInviteExtra.getAvatar().isEmpty()) {
                this.avatar_ = friendPKInviteExtra.avatar_;
                onChanged();
            }
            if (!friendPKInviteExtra.getName().isEmpty()) {
                this.name_ = friendPKInviteExtra.name_;
                onChanged();
            }
            if (!friendPKInviteExtra.getLid().isEmpty()) {
                this.lid_ = friendPKInviteExtra.lid_;
                onChanged();
            }
            m2652mergeUnknownFields(friendPKInviteExtra.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.FriendPKInviteExtra.Builder m2649mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.FriendPKInviteExtra.access$1000()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.FriendPKInviteExtra r0 = (cn.irisgw.live.FriendPKInviteExtra) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.FriendPKInviteExtra$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.FriendPKInviteExtra r0 = (cn.irisgw.live.FriendPKInviteExtra) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.FriendPKInviteExtra$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.FriendPKInviteExtra.Builder.m2649mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.FriendPKInviteExtra$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m2648mergeFrom(Message message) {
            if (message instanceof FriendPKInviteExtra) {
                return mergeFrom((FriendPKInviteExtra) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m2652mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
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
                FriendPKInviteExtra.checkByteStringIsUtf8(byteString);
                this.avatar_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        /* renamed from: setField */
        public Builder m2654setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setLid(String str) {
            if (str != null) {
                this.lid_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setLidBytes(ByteString byteString) {
            if (byteString != null) {
                FriendPKInviteExtra.checkByteStringIsUtf8(byteString);
                this.lid_ = byteString;
                onChanged();
                return this;
            }
            throw null;
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
                FriendPKInviteExtra.checkByteStringIsUtf8(byteString);
                this.name_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        /* renamed from: setRepeatedField */
        public Builder m2656setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setReset(int i) {
            this.reset_ = i;
            onChanged();
            return this;
        }

        public Builder setUid(int i) {
            this.uid_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setUnknownFields */
        public final Builder m2658setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private FriendPKInviteExtra() {
        this.memoizedIsInitialized = (byte) -1;
        this.avatar_ = "";
        this.name_ = "";
        this.lid_ = "";
    }

    private FriendPKInviteExtra(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.reset_ = codedInputStream.readUInt32();
                        } else if (readTag == 16) {
                            this.uid_ = codedInputStream.readUInt32();
                        } else if (readTag == 26) {
                            this.avatar_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 34) {
                            this.name_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 42) {
                            this.lid_ = codedInputStream.readStringRequireUtf8();
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

    private FriendPKInviteExtra(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static FriendPKInviteExtra getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_FriendPKInviteExtra_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m2619toBuilder();
    }

    public static Builder newBuilder(FriendPKInviteExtra friendPKInviteExtra) {
        return DEFAULT_INSTANCE.m2619toBuilder().mergeFrom(friendPKInviteExtra);
    }

    public static FriendPKInviteExtra parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static FriendPKInviteExtra parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static FriendPKInviteExtra parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (FriendPKInviteExtra) PARSER.parseFrom(byteString);
    }

    public static FriendPKInviteExtra parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (FriendPKInviteExtra) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static FriendPKInviteExtra parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static FriendPKInviteExtra parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static FriendPKInviteExtra parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static FriendPKInviteExtra parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static FriendPKInviteExtra parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (FriendPKInviteExtra) PARSER.parseFrom(byteBuffer);
    }

    public static FriendPKInviteExtra parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (FriendPKInviteExtra) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static FriendPKInviteExtra parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (FriendPKInviteExtra) PARSER.parseFrom(bArr);
    }

    public static FriendPKInviteExtra parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (FriendPKInviteExtra) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<FriendPKInviteExtra> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FriendPKInviteExtra) {
            FriendPKInviteExtra friendPKInviteExtra = (FriendPKInviteExtra) obj;
            return getReset() == friendPKInviteExtra.getReset() && getUid() == friendPKInviteExtra.getUid() && getAvatar().equals(friendPKInviteExtra.getAvatar()) && getName().equals(friendPKInviteExtra.getName()) && getLid().equals(friendPKInviteExtra.getLid()) && this.unknownFields.equals(friendPKInviteExtra.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.FriendPKInviteExtraOrBuilder
    public String getAvatar() {
        Object obj = this.avatar_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.avatar_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.FriendPKInviteExtraOrBuilder
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
    public FriendPKInviteExtra m2614getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.FriendPKInviteExtraOrBuilder
    public String getLid() {
        Object obj = this.lid_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.lid_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.FriendPKInviteExtraOrBuilder
    public ByteString getLidBytes() {
        Object obj = this.lid_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.lid_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.FriendPKInviteExtraOrBuilder
    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.FriendPKInviteExtraOrBuilder
    public ByteString getNameBytes() {
        Object obj = this.name_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.name_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    public Parser<FriendPKInviteExtra> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.FriendPKInviteExtraOrBuilder
    public int getReset() {
        return this.reset_;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        int i3 = this.reset_;
        if (i3 != 0) {
            i2 = 0 + CodedOutputStream.computeUInt32Size(1, i3);
        }
        int i4 = this.uid_;
        int i5 = i2;
        if (i4 != 0) {
            i5 = i2 + CodedOutputStream.computeUInt32Size(2, i4);
        }
        int i6 = i5;
        if (!getAvatarBytes().isEmpty()) {
            i6 = i5 + GeneratedMessageV3.computeStringSize(3, this.avatar_);
        }
        int i7 = i6;
        if (!getNameBytes().isEmpty()) {
            i7 = i6 + GeneratedMessageV3.computeStringSize(4, this.name_);
        }
        int i8 = i7;
        if (!getLidBytes().isEmpty()) {
            i8 = i7 + GeneratedMessageV3.computeStringSize(5, this.lid_);
        }
        int serializedSize = i8 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.FriendPKInviteExtraOrBuilder
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
        int hashCode = ((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getReset()) * 37) + 2) * 53) + getUid()) * 37) + 3) * 53) + getAvatar().hashCode()) * 37) + 4) * 53) + getName().hashCode()) * 37) + 5) * 53) + getLid().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_FriendPKInviteExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(FriendPKInviteExtra.class, Builder.class);
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
    public Builder m2617newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m2616newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new FriendPKInviteExtra();
    }

    /* renamed from: toBuilder */
    public Builder m2619toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.reset_;
        if (i != 0) {
            codedOutputStream.writeUInt32(1, i);
        }
        int i2 = this.uid_;
        if (i2 != 0) {
            codedOutputStream.writeUInt32(2, i2);
        }
        if (!getAvatarBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 3, this.avatar_);
        }
        if (!getNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 4, this.name_);
        }
        if (!getLidBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 5, this.lid_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
