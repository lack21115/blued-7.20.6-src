package cn.irisgw.live;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/UserProp.class */
public final class UserProp extends GeneratedMessageV3 implements UserPropOrBuilder {
    public static final int COUNTDOWN_FIELD_NUMBER = 3;
    public static final int EXTRA_DESC_FIELD_NUMBER = 5;
    public static final int MAX_COUNTDOWN_FIELD_NUMBER = 4;
    public static final int PROP_COUNTDOWN_FIELD_NUMBER = 8;
    public static final int PROP_DESC_FIELD_NUMBER = 9;
    public static final int PROP_FIELD_NUMBER = 2;
    public static final int PROP_ICON_FIELD_NUMBER = 6;
    public static final int PROP_NAME_FIELD_NUMBER = 7;
    public static final int UID_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private int countdown_;
    private volatile Object extraDesc_;
    private int maxCountdown_;
    private byte memoizedIsInitialized;
    private int propCountdown_;
    private LazyStringList propDesc_;
    private volatile Object propIcon_;
    private volatile Object propName_;
    private int prop_;
    private int uid_;
    private static final UserProp DEFAULT_INSTANCE = new UserProp();
    private static final Parser<UserProp> PARSER = new AbstractParser<UserProp>() { // from class: cn.irisgw.live.UserProp.1
        @Override // com.google.protobuf.Parser
        public UserProp parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new UserProp(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/UserProp$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements UserPropOrBuilder {
        private int bitField0_;
        private int countdown_;
        private Object extraDesc_;
        private int maxCountdown_;
        private int propCountdown_;
        private LazyStringList propDesc_;
        private Object propIcon_;
        private Object propName_;
        private int prop_;
        private int uid_;

        private Builder() {
            this.prop_ = 0;
            this.extraDesc_ = "";
            this.propIcon_ = "";
            this.propName_ = "";
            this.propDesc_ = LazyStringArrayList.EMPTY;
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.prop_ = 0;
            this.extraDesc_ = "";
            this.propIcon_ = "";
            this.propName_ = "";
            this.propDesc_ = LazyStringArrayList.EMPTY;
            maybeForceBuilderInitialization();
        }

        private void ensurePropDescIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.propDesc_ = new LazyStringArrayList(this.propDesc_);
                this.bitField0_ |= 1;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_UserProp_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = UserProp.alwaysUseFieldBuilders;
        }

        public Builder addAllPropDesc(Iterable<String> iterable) {
            ensurePropDescIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.propDesc_);
            onChanged();
            return this;
        }

        public Builder addPropDesc(String str) {
            if (str != null) {
                ensurePropDescIsMutable();
                this.propDesc_.add((LazyStringList) str);
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder addPropDescBytes(ByteString byteString) {
            if (byteString != null) {
                UserProp.checkByteStringIsUtf8(byteString);
                ensurePropDescIsMutable();
                this.propDesc_.add(byteString);
                onChanged();
                return this;
            }
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public UserProp build() {
            UserProp buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public UserProp buildPartial() {
            UserProp userProp = new UserProp(this);
            userProp.uid_ = this.uid_;
            userProp.prop_ = this.prop_;
            userProp.countdown_ = this.countdown_;
            userProp.maxCountdown_ = this.maxCountdown_;
            userProp.extraDesc_ = this.extraDesc_;
            userProp.propIcon_ = this.propIcon_;
            userProp.propName_ = this.propName_;
            userProp.propCountdown_ = this.propCountdown_;
            if ((this.bitField0_ & 1) != 0) {
                this.propDesc_ = this.propDesc_.getUnmodifiableView();
                this.bitField0_ &= -2;
            }
            userProp.propDesc_ = this.propDesc_;
            onBuilt();
            return userProp;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.uid_ = 0;
            this.prop_ = 0;
            this.countdown_ = 0;
            this.maxCountdown_ = 0;
            this.extraDesc_ = "";
            this.propIcon_ = "";
            this.propName_ = "";
            this.propCountdown_ = 0;
            this.propDesc_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -2;
            return this;
        }

        public Builder clearCountdown() {
            this.countdown_ = 0;
            onChanged();
            return this;
        }

        public Builder clearExtraDesc() {
            this.extraDesc_ = UserProp.getDefaultInstance().getExtraDesc();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearMaxCountdown() {
            this.maxCountdown_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearProp() {
            this.prop_ = 0;
            onChanged();
            return this;
        }

        public Builder clearPropCountdown() {
            this.propCountdown_ = 0;
            onChanged();
            return this;
        }

        public Builder clearPropDesc() {
            this.propDesc_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder clearPropIcon() {
            this.propIcon_ = UserProp.getDefaultInstance().getPropIcon();
            onChanged();
            return this;
        }

        public Builder clearPropName() {
            this.propName_ = UserProp.getDefaultInstance().getPropName();
            onChanged();
            return this;
        }

        public Builder clearUid() {
            this.uid_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo1800clone() {
            return (Builder) super.mo1800clone();
        }

        @Override // cn.irisgw.live.UserPropOrBuilder
        public int getCountdown() {
            return this.countdown_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public UserProp getDefaultInstanceForType() {
            return UserProp.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_UserProp_descriptor;
        }

        @Override // cn.irisgw.live.UserPropOrBuilder
        public String getExtraDesc() {
            Object obj = this.extraDesc_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.extraDesc_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.UserPropOrBuilder
        public ByteString getExtraDescBytes() {
            Object obj = this.extraDesc_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.extraDesc_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.UserPropOrBuilder
        public int getMaxCountdown() {
            return this.maxCountdown_;
        }

        @Override // cn.irisgw.live.UserPropOrBuilder
        public Prop getProp() {
            Prop valueOf = Prop.valueOf(this.prop_);
            Prop prop = valueOf;
            if (valueOf == null) {
                prop = Prop.UNRECOGNIZED;
            }
            return prop;
        }

        @Override // cn.irisgw.live.UserPropOrBuilder
        public int getPropCountdown() {
            return this.propCountdown_;
        }

        @Override // cn.irisgw.live.UserPropOrBuilder
        public String getPropDesc(int i) {
            return this.propDesc_.get(i);
        }

        @Override // cn.irisgw.live.UserPropOrBuilder
        public ByteString getPropDescBytes(int i) {
            return this.propDesc_.getByteString(i);
        }

        @Override // cn.irisgw.live.UserPropOrBuilder
        public int getPropDescCount() {
            return this.propDesc_.size();
        }

        @Override // cn.irisgw.live.UserPropOrBuilder
        public ProtocolStringList getPropDescList() {
            return this.propDesc_.getUnmodifiableView();
        }

        @Override // cn.irisgw.live.UserPropOrBuilder
        public String getPropIcon() {
            Object obj = this.propIcon_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.propIcon_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.UserPropOrBuilder
        public ByteString getPropIconBytes() {
            Object obj = this.propIcon_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.propIcon_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.UserPropOrBuilder
        public String getPropName() {
            Object obj = this.propName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.propName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.UserPropOrBuilder
        public ByteString getPropNameBytes() {
            Object obj = this.propName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.propName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.UserPropOrBuilder
        public int getPropValue() {
            return this.prop_;
        }

        @Override // cn.irisgw.live.UserPropOrBuilder
        public int getUid() {
            return this.uid_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_UserProp_fieldAccessorTable.ensureFieldAccessorsInitialized(UserProp.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(UserProp userProp) {
            if (userProp == UserProp.getDefaultInstance()) {
                return this;
            }
            if (userProp.getUid() != 0) {
                setUid(userProp.getUid());
            }
            if (userProp.prop_ != 0) {
                setPropValue(userProp.getPropValue());
            }
            if (userProp.getCountdown() != 0) {
                setCountdown(userProp.getCountdown());
            }
            if (userProp.getMaxCountdown() != 0) {
                setMaxCountdown(userProp.getMaxCountdown());
            }
            if (!userProp.getExtraDesc().isEmpty()) {
                this.extraDesc_ = userProp.extraDesc_;
                onChanged();
            }
            if (!userProp.getPropIcon().isEmpty()) {
                this.propIcon_ = userProp.propIcon_;
                onChanged();
            }
            if (!userProp.getPropName().isEmpty()) {
                this.propName_ = userProp.propName_;
                onChanged();
            }
            if (userProp.getPropCountdown() != 0) {
                setPropCountdown(userProp.getPropCountdown());
            }
            if (!userProp.propDesc_.isEmpty()) {
                if (this.propDesc_.isEmpty()) {
                    this.propDesc_ = userProp.propDesc_;
                    this.bitField0_ &= -2;
                } else {
                    ensurePropDescIsMutable();
                    this.propDesc_.addAll(userProp.propDesc_);
                }
                onChanged();
            }
            mergeUnknownFields(userProp.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.UserProp.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.UserProp.access$1400()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.UserProp r0 = (cn.irisgw.live.UserProp) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.UserProp$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.UserProp r0 = (cn.irisgw.live.UserProp) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.UserProp$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.UserProp.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.UserProp$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof UserProp) {
                return mergeFrom((UserProp) message);
            }
            super.mergeFrom(message);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setCountdown(int i) {
            this.countdown_ = i;
            onChanged();
            return this;
        }

        public Builder setExtraDesc(String str) {
            if (str != null) {
                this.extraDesc_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setExtraDescBytes(ByteString byteString) {
            if (byteString != null) {
                UserProp.checkByteStringIsUtf8(byteString);
                this.extraDesc_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setMaxCountdown(int i) {
            this.maxCountdown_ = i;
            onChanged();
            return this;
        }

        public Builder setProp(Prop prop) {
            if (prop != null) {
                this.prop_ = prop.getNumber();
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setPropCountdown(int i) {
            this.propCountdown_ = i;
            onChanged();
            return this;
        }

        public Builder setPropDesc(int i, String str) {
            if (str != null) {
                ensurePropDescIsMutable();
                this.propDesc_.set(i, (int) str);
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setPropIcon(String str) {
            if (str != null) {
                this.propIcon_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setPropIconBytes(ByteString byteString) {
            if (byteString != null) {
                UserProp.checkByteStringIsUtf8(byteString);
                this.propIcon_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setPropName(String str) {
            if (str != null) {
                this.propName_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setPropNameBytes(ByteString byteString) {
            if (byteString != null) {
                UserProp.checkByteStringIsUtf8(byteString);
                this.propName_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setPropValue(int i) {
            this.prop_ = i;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setUid(int i) {
            this.uid_ = i;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private UserProp() {
        this.memoizedIsInitialized = (byte) -1;
        this.prop_ = 0;
        this.extraDesc_ = "";
        this.propIcon_ = "";
        this.propName_ = "";
        this.propDesc_ = LazyStringArrayList.EMPTY;
    }

    private UserProp(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        if (extensionRegistryLite == null) {
            throw null;
        }
        UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            boolean z3 = z2;
            try {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 8) {
                            this.uid_ = codedInputStream.readUInt32();
                        } else if (readTag == 16) {
                            this.prop_ = codedInputStream.readEnum();
                        } else if (readTag == 24) {
                            this.countdown_ = codedInputStream.readUInt32();
                        } else if (readTag == 32) {
                            this.maxCountdown_ = codedInputStream.readUInt32();
                        } else if (readTag == 42) {
                            this.extraDesc_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 50) {
                            this.propIcon_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 58) {
                            this.propName_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 64) {
                            this.propCountdown_ = codedInputStream.readUInt32();
                        } else if (readTag == 74) {
                            String readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                            boolean z4 = z2;
                            if (!(z2 & true)) {
                                this.propDesc_ = new LazyStringArrayList();
                                z4 = z2 | true;
                            }
                            this.propDesc_.add((LazyStringList) readStringRequireUtf8);
                            z2 = z4;
                        } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                }
            } catch (Throwable th) {
                if (z3 & true) {
                    this.propDesc_ = this.propDesc_.getUnmodifiableView();
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                throw th;
            }
        }
        if (z2 & true) {
            this.propDesc_ = this.propDesc_.getUnmodifiableView();
        }
        this.unknownFields = newBuilder.build();
        makeExtensionsImmutable();
    }

    private UserProp(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static UserProp getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_UserProp_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(UserProp userProp) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(userProp);
    }

    public static UserProp parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (UserProp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static UserProp parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (UserProp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static UserProp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static UserProp parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static UserProp parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (UserProp) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static UserProp parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (UserProp) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static UserProp parseFrom(InputStream inputStream) throws IOException {
        return (UserProp) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static UserProp parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (UserProp) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static UserProp parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static UserProp parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static UserProp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static UserProp parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<UserProp> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof UserProp) {
            UserProp userProp = (UserProp) obj;
            return getUid() == userProp.getUid() && this.prop_ == userProp.prop_ && getCountdown() == userProp.getCountdown() && getMaxCountdown() == userProp.getMaxCountdown() && getExtraDesc().equals(userProp.getExtraDesc()) && getPropIcon().equals(userProp.getPropIcon()) && getPropName().equals(userProp.getPropName()) && getPropCountdown() == userProp.getPropCountdown() && getPropDescList().equals(userProp.getPropDescList()) && this.unknownFields.equals(userProp.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.UserPropOrBuilder
    public int getCountdown() {
        return this.countdown_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public UserProp getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.UserPropOrBuilder
    public String getExtraDesc() {
        Object obj = this.extraDesc_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.extraDesc_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.UserPropOrBuilder
    public ByteString getExtraDescBytes() {
        Object obj = this.extraDesc_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.extraDesc_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.UserPropOrBuilder
    public int getMaxCountdown() {
        return this.maxCountdown_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<UserProp> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.UserPropOrBuilder
    public Prop getProp() {
        Prop valueOf = Prop.valueOf(this.prop_);
        Prop prop = valueOf;
        if (valueOf == null) {
            prop = Prop.UNRECOGNIZED;
        }
        return prop;
    }

    @Override // cn.irisgw.live.UserPropOrBuilder
    public int getPropCountdown() {
        return this.propCountdown_;
    }

    @Override // cn.irisgw.live.UserPropOrBuilder
    public String getPropDesc(int i) {
        return this.propDesc_.get(i);
    }

    @Override // cn.irisgw.live.UserPropOrBuilder
    public ByteString getPropDescBytes(int i) {
        return this.propDesc_.getByteString(i);
    }

    @Override // cn.irisgw.live.UserPropOrBuilder
    public int getPropDescCount() {
        return this.propDesc_.size();
    }

    @Override // cn.irisgw.live.UserPropOrBuilder
    public ProtocolStringList getPropDescList() {
        return this.propDesc_;
    }

    @Override // cn.irisgw.live.UserPropOrBuilder
    public String getPropIcon() {
        Object obj = this.propIcon_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.propIcon_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.UserPropOrBuilder
    public ByteString getPropIconBytes() {
        Object obj = this.propIcon_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.propIcon_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.UserPropOrBuilder
    public String getPropName() {
        Object obj = this.propName_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.propName_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.UserPropOrBuilder
    public ByteString getPropNameBytes() {
        Object obj = this.propName_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.propName_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.UserPropOrBuilder
    public int getPropValue() {
        return this.prop_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = this.uid_;
        int computeUInt32Size = i2 != 0 ? CodedOutputStream.computeUInt32Size(1, i2) + 0 : 0;
        int i3 = computeUInt32Size;
        if (this.prop_ != Prop.NONE_PROP.getNumber()) {
            i3 = computeUInt32Size + CodedOutputStream.computeEnumSize(2, this.prop_);
        }
        int i4 = this.countdown_;
        int i5 = i3;
        if (i4 != 0) {
            i5 = i3 + CodedOutputStream.computeUInt32Size(3, i4);
        }
        int i6 = this.maxCountdown_;
        int i7 = i5;
        if (i6 != 0) {
            i7 = i5 + CodedOutputStream.computeUInt32Size(4, i6);
        }
        int i8 = i7;
        if (!getExtraDescBytes().isEmpty()) {
            i8 = i7 + GeneratedMessageV3.computeStringSize(5, this.extraDesc_);
        }
        int i9 = i8;
        if (!getPropIconBytes().isEmpty()) {
            i9 = i8 + GeneratedMessageV3.computeStringSize(6, this.propIcon_);
        }
        int i10 = i9;
        if (!getPropNameBytes().isEmpty()) {
            i10 = i9 + GeneratedMessageV3.computeStringSize(7, this.propName_);
        }
        int i11 = this.propCountdown_;
        int i12 = i10;
        if (i11 != 0) {
            i12 = i10 + CodedOutputStream.computeUInt32Size(8, i11);
        }
        int i13 = 0;
        int i14 = 0;
        while (true) {
            int i15 = i14;
            if (i15 >= this.propDesc_.size()) {
                int size = i12 + i13 + (getPropDescList().size() * 1) + this.unknownFields.getSerializedSize();
                this.memoizedSize = size;
                return size;
            }
            i13 += computeStringSizeNoTag(this.propDesc_.getRaw(i15));
            i14 = i15 + 1;
        }
    }

    @Override // cn.irisgw.live.UserPropOrBuilder
    public int getUid() {
        return this.uid_;
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
        int hashCode = ((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getUid()) * 37) + 2) * 53) + this.prop_) * 37) + 3) * 53) + getCountdown()) * 37) + 4) * 53) + getMaxCountdown()) * 37) + 5) * 53) + getExtraDesc().hashCode()) * 37) + 6) * 53) + getPropIcon().hashCode()) * 37) + 7) * 53) + getPropName().hashCode()) * 37) + 8) * 53) + getPropCountdown();
        int i = hashCode;
        if (getPropDescCount() > 0) {
            i = (((hashCode * 37) + 9) * 53) + getPropDescList().hashCode();
        }
        int hashCode2 = (i * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_UserProp_fieldAccessorTable.ensureFieldAccessorsInitialized(UserProp.class, Builder.class);
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
        return new UserProp();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.uid_;
        if (i != 0) {
            codedOutputStream.writeUInt32(1, i);
        }
        if (this.prop_ != Prop.NONE_PROP.getNumber()) {
            codedOutputStream.writeEnum(2, this.prop_);
        }
        int i2 = this.countdown_;
        if (i2 != 0) {
            codedOutputStream.writeUInt32(3, i2);
        }
        int i3 = this.maxCountdown_;
        if (i3 != 0) {
            codedOutputStream.writeUInt32(4, i3);
        }
        if (!getExtraDescBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 5, this.extraDesc_);
        }
        if (!getPropIconBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 6, this.propIcon_);
        }
        if (!getPropNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 7, this.propName_);
        }
        int i4 = this.propCountdown_;
        if (i4 != 0) {
            codedOutputStream.writeUInt32(8, i4);
        }
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= this.propDesc_.size()) {
                this.unknownFields.writeTo(codedOutputStream);
                return;
            } else {
                GeneratedMessageV3.writeString(codedOutputStream, 9, this.propDesc_.getRaw(i6));
                i5 = i6 + 1;
            }
        }
    }
}
