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
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/PKProgressUpdateExtra.class */
public final class PKProgressUpdateExtra extends GeneratedMessageV3 implements PKProgressUpdateExtraOrBuilder {
    private static final PKProgressUpdateExtra DEFAULT_INSTANCE = new PKProgressUpdateExtra();
    private static final Parser<PKProgressUpdateExtra> PARSER = new AbstractParser<PKProgressUpdateExtra>() { // from class: cn.irisgw.live.PKProgressUpdateExtra.1
        /* renamed from: parsePartialFrom */
        public PKProgressUpdateExtra m6505parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new PKProgressUpdateExtra(codedInputStream, extensionRegistryLite);
        }
    };
    public static final int SCORE_FIELD_NUMBER = 2;
    public static final int TARGET_TOP_FIELD_NUMBER = 5;
    public static final int TOP_FIELD_NUMBER = 4;
    public static final int TOTAL_FIELD_NUMBER = 3;
    public static final int UID_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private int score_;
    private List<BattleTopUser> targetTop_;
    private List<BattleTopUser> top_;
    private int total_;
    private int uid_;

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/PKProgressUpdateExtra$BattleTopUser.class */
    public static final class BattleTopUser extends GeneratedMessageV3 implements BattleTopUserOrBuilder {
        public static final int AVATAR_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 3;
        public static final int UID_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private volatile Object avatar_;
        private byte memoizedIsInitialized;
        private volatile Object name_;
        private int uid_;
        private static final BattleTopUser DEFAULT_INSTANCE = new BattleTopUser();
        private static final Parser<BattleTopUser> PARSER = new AbstractParser<BattleTopUser>() { // from class: cn.irisgw.live.PKProgressUpdateExtra.BattleTopUser.1
            /* renamed from: parsePartialFrom */
            public BattleTopUser m6514parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new BattleTopUser(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/PKProgressUpdateExtra$BattleTopUser$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BattleTopUserOrBuilder {
            private Object avatar_;
            private Object name_;
            private int uid_;

            private Builder() {
                this.avatar_ = "";
                this.name_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.avatar_ = "";
                this.name_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LiveConstants.internal_static_cn_irisgw_live_PKProgressUpdateExtra_BattleTopUser_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = BattleTopUser.alwaysUseFieldBuilders;
            }

            /* renamed from: addRepeatedField */
            public Builder m6516addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: build */
            public BattleTopUser m6518build() {
                BattleTopUser m6520buildPartial = m6520buildPartial();
                if (m6520buildPartial.isInitialized()) {
                    return m6520buildPartial;
                }
                throw newUninitializedMessageException(m6520buildPartial);
            }

            /* renamed from: buildPartial */
            public BattleTopUser m6520buildPartial() {
                BattleTopUser battleTopUser = new BattleTopUser(this);
                battleTopUser.uid_ = this.uid_;
                battleTopUser.avatar_ = this.avatar_;
                battleTopUser.name_ = this.name_;
                onBuilt();
                return battleTopUser;
            }

            /* renamed from: clear */
            public Builder m6524clear() {
                super.clear();
                this.uid_ = 0;
                this.avatar_ = "";
                this.name_ = "";
                return this;
            }

            public Builder clearAvatar() {
                this.avatar_ = BattleTopUser.getDefaultInstance().getAvatar();
                onChanged();
                return this;
            }

            /* renamed from: clearField */
            public Builder m6526clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearName() {
                this.name_ = BattleTopUser.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            /* renamed from: clearOneof */
            public Builder m6529clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearUid() {
                this.uid_ = 0;
                onChanged();
                return this;
            }

            /* renamed from: clone */
            public Builder m6535clone() {
                return (Builder) super.clone();
            }

            @Override // cn.irisgw.live.PKProgressUpdateExtra.BattleTopUserOrBuilder
            public String getAvatar() {
                Object obj = this.avatar_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.avatar_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.PKProgressUpdateExtra.BattleTopUserOrBuilder
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
            public BattleTopUser m6537getDefaultInstanceForType() {
                return BattleTopUser.getDefaultInstance();
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return LiveConstants.internal_static_cn_irisgw_live_PKProgressUpdateExtra_BattleTopUser_descriptor;
            }

            @Override // cn.irisgw.live.PKProgressUpdateExtra.BattleTopUserOrBuilder
            public String getName() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.PKProgressUpdateExtra.BattleTopUserOrBuilder
            public ByteString getNameBytes() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.name_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.PKProgressUpdateExtra.BattleTopUserOrBuilder
            public int getUid() {
                return this.uid_;
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveConstants.internal_static_cn_irisgw_live_PKProgressUpdateExtra_BattleTopUser_fieldAccessorTable.ensureFieldAccessorsInitialized(BattleTopUser.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(BattleTopUser battleTopUser) {
                if (battleTopUser == BattleTopUser.getDefaultInstance()) {
                    return this;
                }
                if (battleTopUser.getUid() != 0) {
                    setUid(battleTopUser.getUid());
                }
                if (!battleTopUser.getAvatar().isEmpty()) {
                    this.avatar_ = battleTopUser.avatar_;
                    onChanged();
                }
                if (!battleTopUser.getName().isEmpty()) {
                    this.name_ = battleTopUser.name_;
                    onChanged();
                }
                m6546mergeUnknownFields(battleTopUser.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            /* renamed from: mergeFrom */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.PKProgressUpdateExtra.BattleTopUser.Builder m6543mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.PKProgressUpdateExtra.BattleTopUser.access$800()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.PKProgressUpdateExtra$BattleTopUser r0 = (cn.irisgw.live.PKProgressUpdateExtra.BattleTopUser) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.PKProgressUpdateExtra$BattleTopUser$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.PKProgressUpdateExtra$BattleTopUser r0 = (cn.irisgw.live.PKProgressUpdateExtra.BattleTopUser) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.PKProgressUpdateExtra$BattleTopUser$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.PKProgressUpdateExtra.BattleTopUser.Builder.m6543mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.PKProgressUpdateExtra$BattleTopUser$Builder");
            }

            /* renamed from: mergeFrom */
            public Builder m6542mergeFrom(Message message) {
                if (message instanceof BattleTopUser) {
                    return mergeFrom((BattleTopUser) message);
                }
                super.mergeFrom(message);
                return this;
            }

            /* renamed from: mergeUnknownFields */
            public final Builder m6546mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
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
                    BattleTopUser.checkByteStringIsUtf8(byteString);
                    this.avatar_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            /* renamed from: setField */
            public Builder m6548setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
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
                    BattleTopUser.checkByteStringIsUtf8(byteString);
                    this.name_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            /* renamed from: setRepeatedField */
            public Builder m6550setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setUid(int i) {
                this.uid_ = i;
                onChanged();
                return this;
            }

            /* renamed from: setUnknownFields */
            public final Builder m6552setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private BattleTopUser() {
            this.memoizedIsInitialized = (byte) -1;
            this.avatar_ = "";
            this.name_ = "";
        }

        private BattleTopUser(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.uid_ = codedInputStream.readUInt32();
                                } else if (readTag == 18) {
                                    this.avatar_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 26) {
                                    this.name_ = codedInputStream.readStringRequireUtf8();
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

        private BattleTopUser(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static BattleTopUser getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_PKProgressUpdateExtra_BattleTopUser_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m6513toBuilder();
        }

        public static Builder newBuilder(BattleTopUser battleTopUser) {
            return DEFAULT_INSTANCE.m6513toBuilder().mergeFrom(battleTopUser);
        }

        public static BattleTopUser parseDelimitedFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static BattleTopUser parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static BattleTopUser parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (BattleTopUser) PARSER.parseFrom(byteString);
        }

        public static BattleTopUser parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (BattleTopUser) PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static BattleTopUser parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static BattleTopUser parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static BattleTopUser parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static BattleTopUser parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static BattleTopUser parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (BattleTopUser) PARSER.parseFrom(byteBuffer);
        }

        public static BattleTopUser parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (BattleTopUser) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static BattleTopUser parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (BattleTopUser) PARSER.parseFrom(bArr);
        }

        public static BattleTopUser parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (BattleTopUser) PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<BattleTopUser> parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof BattleTopUser) {
                BattleTopUser battleTopUser = (BattleTopUser) obj;
                return getUid() == battleTopUser.getUid() && getAvatar().equals(battleTopUser.getAvatar()) && getName().equals(battleTopUser.getName()) && this.unknownFields.equals(battleTopUser.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // cn.irisgw.live.PKProgressUpdateExtra.BattleTopUserOrBuilder
        public String getAvatar() {
            Object obj = this.avatar_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.avatar_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.PKProgressUpdateExtra.BattleTopUserOrBuilder
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
        public BattleTopUser m6508getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // cn.irisgw.live.PKProgressUpdateExtra.BattleTopUserOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.PKProgressUpdateExtra.BattleTopUserOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Parser<BattleTopUser> getParserForType() {
            return PARSER;
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
            if (!getAvatarBytes().isEmpty()) {
                i4 = i2 + GeneratedMessageV3.computeStringSize(2, this.avatar_);
            }
            int i5 = i4;
            if (!getNameBytes().isEmpty()) {
                i5 = i4 + GeneratedMessageV3.computeStringSize(3, this.name_);
            }
            int serializedSize = i5 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // cn.irisgw.live.PKProgressUpdateExtra.BattleTopUserOrBuilder
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
            int hashCode = ((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getUid()) * 37) + 2) * 53) + getAvatar().hashCode()) * 37) + 3) * 53) + getName().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_PKProgressUpdateExtra_BattleTopUser_fieldAccessorTable.ensureFieldAccessorsInitialized(BattleTopUser.class, Builder.class);
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
        public Builder m6511newBuilderForType() {
            return newBuilder();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: newBuilderForType */
        public Builder m6510newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new BattleTopUser();
        }

        /* renamed from: toBuilder */
        public Builder m6513toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i = this.uid_;
            if (i != 0) {
                codedOutputStream.writeUInt32(1, i);
            }
            if (!getAvatarBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.avatar_);
            }
            if (!getNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.name_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/PKProgressUpdateExtra$BattleTopUserOrBuilder.class */
    public interface BattleTopUserOrBuilder extends MessageOrBuilder {
        String getAvatar();

        ByteString getAvatarBytes();

        String getName();

        ByteString getNameBytes();

        int getUid();
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/PKProgressUpdateExtra$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PKProgressUpdateExtraOrBuilder {
        private int bitField0_;
        private int score_;
        private RepeatedFieldBuilderV3<BattleTopUser, BattleTopUser.Builder, BattleTopUserOrBuilder> targetTopBuilder_;
        private List<BattleTopUser> targetTop_;
        private RepeatedFieldBuilderV3<BattleTopUser, BattleTopUser.Builder, BattleTopUserOrBuilder> topBuilder_;
        private List<BattleTopUser> top_;
        private int total_;
        private int uid_;

        private Builder() {
            this.top_ = Collections.emptyList();
            this.targetTop_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.top_ = Collections.emptyList();
            this.targetTop_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private void ensureTargetTopIsMutable() {
            if ((this.bitField0_ & 2) == 0) {
                this.targetTop_ = new ArrayList(this.targetTop_);
                this.bitField0_ |= 2;
            }
        }

        private void ensureTopIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.top_ = new ArrayList(this.top_);
                this.bitField0_ |= 1;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_PKProgressUpdateExtra_descriptor;
        }

        private RepeatedFieldBuilderV3<BattleTopUser, BattleTopUser.Builder, BattleTopUserOrBuilder> getTargetTopFieldBuilder() {
            if (this.targetTopBuilder_ == null) {
                this.targetTopBuilder_ = new RepeatedFieldBuilderV3<>(this.targetTop_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                this.targetTop_ = null;
            }
            return this.targetTopBuilder_;
        }

        private RepeatedFieldBuilderV3<BattleTopUser, BattleTopUser.Builder, BattleTopUserOrBuilder> getTopFieldBuilder() {
            if (this.topBuilder_ == null) {
                List<BattleTopUser> list = this.top_;
                boolean z = true;
                if ((this.bitField0_ & 1) == 0) {
                    z = false;
                }
                this.topBuilder_ = new RepeatedFieldBuilderV3<>(list, z, getParentForChildren(), isClean());
                this.top_ = null;
            }
            return this.topBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (PKProgressUpdateExtra.alwaysUseFieldBuilders) {
                getTopFieldBuilder();
                getTargetTopFieldBuilder();
            }
        }

        public Builder addAllTargetTop(Iterable<? extends BattleTopUser> iterable) {
            RepeatedFieldBuilderV3<BattleTopUser, BattleTopUser.Builder, BattleTopUserOrBuilder> repeatedFieldBuilderV3 = this.targetTopBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensureTargetTopIsMutable();
            AbstractMessageLite.Builder.addAll(iterable, this.targetTop_);
            onChanged();
            return this;
        }

        public Builder addAllTop(Iterable<? extends BattleTopUser> iterable) {
            RepeatedFieldBuilderV3<BattleTopUser, BattleTopUser.Builder, BattleTopUserOrBuilder> repeatedFieldBuilderV3 = this.topBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensureTopIsMutable();
            AbstractMessageLite.Builder.addAll(iterable, this.top_);
            onChanged();
            return this;
        }

        /* renamed from: addRepeatedField */
        public Builder m6554addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        public Builder addTargetTop(int i, BattleTopUser.Builder builder) {
            RepeatedFieldBuilderV3<BattleTopUser, BattleTopUser.Builder, BattleTopUserOrBuilder> repeatedFieldBuilderV3 = this.targetTopBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.m6518build());
                return this;
            }
            ensureTargetTopIsMutable();
            this.targetTop_.add(i, builder.m6518build());
            onChanged();
            return this;
        }

        public Builder addTargetTop(int i, BattleTopUser battleTopUser) {
            RepeatedFieldBuilderV3<BattleTopUser, BattleTopUser.Builder, BattleTopUserOrBuilder> repeatedFieldBuilderV3 = this.targetTopBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, battleTopUser);
                return this;
            } else if (battleTopUser != null) {
                ensureTargetTopIsMutable();
                this.targetTop_.add(i, battleTopUser);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addTargetTop(BattleTopUser.Builder builder) {
            RepeatedFieldBuilderV3<BattleTopUser, BattleTopUser.Builder, BattleTopUserOrBuilder> repeatedFieldBuilderV3 = this.targetTopBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(builder.m6518build());
                return this;
            }
            ensureTargetTopIsMutable();
            this.targetTop_.add(builder.m6518build());
            onChanged();
            return this;
        }

        public Builder addTargetTop(BattleTopUser battleTopUser) {
            RepeatedFieldBuilderV3<BattleTopUser, BattleTopUser.Builder, BattleTopUserOrBuilder> repeatedFieldBuilderV3 = this.targetTopBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(battleTopUser);
                return this;
            } else if (battleTopUser != null) {
                ensureTargetTopIsMutable();
                this.targetTop_.add(battleTopUser);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public BattleTopUser.Builder addTargetTopBuilder() {
            return getTargetTopFieldBuilder().addBuilder(BattleTopUser.getDefaultInstance());
        }

        public BattleTopUser.Builder addTargetTopBuilder(int i) {
            return getTargetTopFieldBuilder().addBuilder(i, BattleTopUser.getDefaultInstance());
        }

        public Builder addTop(int i, BattleTopUser.Builder builder) {
            RepeatedFieldBuilderV3<BattleTopUser, BattleTopUser.Builder, BattleTopUserOrBuilder> repeatedFieldBuilderV3 = this.topBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.m6518build());
                return this;
            }
            ensureTopIsMutable();
            this.top_.add(i, builder.m6518build());
            onChanged();
            return this;
        }

        public Builder addTop(int i, BattleTopUser battleTopUser) {
            RepeatedFieldBuilderV3<BattleTopUser, BattleTopUser.Builder, BattleTopUserOrBuilder> repeatedFieldBuilderV3 = this.topBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, battleTopUser);
                return this;
            } else if (battleTopUser != null) {
                ensureTopIsMutable();
                this.top_.add(i, battleTopUser);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addTop(BattleTopUser.Builder builder) {
            RepeatedFieldBuilderV3<BattleTopUser, BattleTopUser.Builder, BattleTopUserOrBuilder> repeatedFieldBuilderV3 = this.topBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(builder.m6518build());
                return this;
            }
            ensureTopIsMutable();
            this.top_.add(builder.m6518build());
            onChanged();
            return this;
        }

        public Builder addTop(BattleTopUser battleTopUser) {
            RepeatedFieldBuilderV3<BattleTopUser, BattleTopUser.Builder, BattleTopUserOrBuilder> repeatedFieldBuilderV3 = this.topBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(battleTopUser);
                return this;
            } else if (battleTopUser != null) {
                ensureTopIsMutable();
                this.top_.add(battleTopUser);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public BattleTopUser.Builder addTopBuilder() {
            return getTopFieldBuilder().addBuilder(BattleTopUser.getDefaultInstance());
        }

        public BattleTopUser.Builder addTopBuilder(int i) {
            return getTopFieldBuilder().addBuilder(i, BattleTopUser.getDefaultInstance());
        }

        /* renamed from: build */
        public PKProgressUpdateExtra m6556build() {
            PKProgressUpdateExtra m6558buildPartial = m6558buildPartial();
            if (m6558buildPartial.isInitialized()) {
                return m6558buildPartial;
            }
            throw newUninitializedMessageException(m6558buildPartial);
        }

        /* renamed from: buildPartial */
        public PKProgressUpdateExtra m6558buildPartial() {
            PKProgressUpdateExtra pKProgressUpdateExtra = new PKProgressUpdateExtra(this);
            pKProgressUpdateExtra.uid_ = this.uid_;
            pKProgressUpdateExtra.score_ = this.score_;
            pKProgressUpdateExtra.total_ = this.total_;
            RepeatedFieldBuilderV3<BattleTopUser, BattleTopUser.Builder, BattleTopUserOrBuilder> repeatedFieldBuilderV3 = this.topBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.top_ = Collections.unmodifiableList(this.top_);
                    this.bitField0_ &= -2;
                }
                pKProgressUpdateExtra.top_ = this.top_;
            } else {
                pKProgressUpdateExtra.top_ = repeatedFieldBuilderV3.build();
            }
            RepeatedFieldBuilderV3<BattleTopUser, BattleTopUser.Builder, BattleTopUserOrBuilder> repeatedFieldBuilderV32 = this.targetTopBuilder_;
            if (repeatedFieldBuilderV32 == null) {
                if ((this.bitField0_ & 2) != 0) {
                    this.targetTop_ = Collections.unmodifiableList(this.targetTop_);
                    this.bitField0_ &= -3;
                }
                pKProgressUpdateExtra.targetTop_ = this.targetTop_;
            } else {
                pKProgressUpdateExtra.targetTop_ = repeatedFieldBuilderV32.build();
            }
            onBuilt();
            return pKProgressUpdateExtra;
        }

        /* renamed from: clear */
        public Builder m6562clear() {
            super.clear();
            this.uid_ = 0;
            this.score_ = 0;
            this.total_ = 0;
            RepeatedFieldBuilderV3<BattleTopUser, BattleTopUser.Builder, BattleTopUserOrBuilder> repeatedFieldBuilderV3 = this.topBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.top_ = Collections.emptyList();
                this.bitField0_ &= -2;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            RepeatedFieldBuilderV3<BattleTopUser, BattleTopUser.Builder, BattleTopUserOrBuilder> repeatedFieldBuilderV32 = this.targetTopBuilder_;
            if (repeatedFieldBuilderV32 != null) {
                repeatedFieldBuilderV32.clear();
                return this;
            }
            this.targetTop_ = Collections.emptyList();
            this.bitField0_ &= -3;
            return this;
        }

        /* renamed from: clearField */
        public Builder m6564clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        /* renamed from: clearOneof */
        public Builder m6567clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearScore() {
            this.score_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTargetTop() {
            RepeatedFieldBuilderV3<BattleTopUser, BattleTopUser.Builder, BattleTopUserOrBuilder> repeatedFieldBuilderV3 = this.targetTopBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.targetTop_ = Collections.emptyList();
            this.bitField0_ &= -3;
            onChanged();
            return this;
        }

        public Builder clearTop() {
            RepeatedFieldBuilderV3<BattleTopUser, BattleTopUser.Builder, BattleTopUserOrBuilder> repeatedFieldBuilderV3 = this.topBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.top_ = Collections.emptyList();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder clearTotal() {
            this.total_ = 0;
            onChanged();
            return this;
        }

        public Builder clearUid() {
            this.uid_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m6573clone() {
            return (Builder) super.clone();
        }

        /* renamed from: getDefaultInstanceForType */
        public PKProgressUpdateExtra m6575getDefaultInstanceForType() {
            return PKProgressUpdateExtra.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_PKProgressUpdateExtra_descriptor;
        }

        @Override // cn.irisgw.live.PKProgressUpdateExtraOrBuilder
        public int getScore() {
            return this.score_;
        }

        @Override // cn.irisgw.live.PKProgressUpdateExtraOrBuilder
        public BattleTopUser getTargetTop(int i) {
            RepeatedFieldBuilderV3<BattleTopUser, BattleTopUser.Builder, BattleTopUserOrBuilder> repeatedFieldBuilderV3 = this.targetTopBuilder_;
            return repeatedFieldBuilderV3 == null ? this.targetTop_.get(i) : repeatedFieldBuilderV3.getMessage(i);
        }

        public BattleTopUser.Builder getTargetTopBuilder(int i) {
            return getTargetTopFieldBuilder().getBuilder(i);
        }

        public List<BattleTopUser.Builder> getTargetTopBuilderList() {
            return getTargetTopFieldBuilder().getBuilderList();
        }

        @Override // cn.irisgw.live.PKProgressUpdateExtraOrBuilder
        public int getTargetTopCount() {
            RepeatedFieldBuilderV3<BattleTopUser, BattleTopUser.Builder, BattleTopUserOrBuilder> repeatedFieldBuilderV3 = this.targetTopBuilder_;
            return repeatedFieldBuilderV3 == null ? this.targetTop_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // cn.irisgw.live.PKProgressUpdateExtraOrBuilder
        public List<BattleTopUser> getTargetTopList() {
            RepeatedFieldBuilderV3<BattleTopUser, BattleTopUser.Builder, BattleTopUserOrBuilder> repeatedFieldBuilderV3 = this.targetTopBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.targetTop_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // cn.irisgw.live.PKProgressUpdateExtraOrBuilder
        public BattleTopUserOrBuilder getTargetTopOrBuilder(int i) {
            RepeatedFieldBuilderV3<BattleTopUser, BattleTopUser.Builder, BattleTopUserOrBuilder> repeatedFieldBuilderV3 = this.targetTopBuilder_;
            return repeatedFieldBuilderV3 == null ? this.targetTop_.get(i) : (BattleTopUserOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // cn.irisgw.live.PKProgressUpdateExtraOrBuilder
        public List<? extends BattleTopUserOrBuilder> getTargetTopOrBuilderList() {
            RepeatedFieldBuilderV3<BattleTopUser, BattleTopUser.Builder, BattleTopUserOrBuilder> repeatedFieldBuilderV3 = this.targetTopBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.targetTop_);
        }

        @Override // cn.irisgw.live.PKProgressUpdateExtraOrBuilder
        public BattleTopUser getTop(int i) {
            RepeatedFieldBuilderV3<BattleTopUser, BattleTopUser.Builder, BattleTopUserOrBuilder> repeatedFieldBuilderV3 = this.topBuilder_;
            return repeatedFieldBuilderV3 == null ? this.top_.get(i) : repeatedFieldBuilderV3.getMessage(i);
        }

        public BattleTopUser.Builder getTopBuilder(int i) {
            return getTopFieldBuilder().getBuilder(i);
        }

        public List<BattleTopUser.Builder> getTopBuilderList() {
            return getTopFieldBuilder().getBuilderList();
        }

        @Override // cn.irisgw.live.PKProgressUpdateExtraOrBuilder
        public int getTopCount() {
            RepeatedFieldBuilderV3<BattleTopUser, BattleTopUser.Builder, BattleTopUserOrBuilder> repeatedFieldBuilderV3 = this.topBuilder_;
            return repeatedFieldBuilderV3 == null ? this.top_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // cn.irisgw.live.PKProgressUpdateExtraOrBuilder
        public List<BattleTopUser> getTopList() {
            RepeatedFieldBuilderV3<BattleTopUser, BattleTopUser.Builder, BattleTopUserOrBuilder> repeatedFieldBuilderV3 = this.topBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.top_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // cn.irisgw.live.PKProgressUpdateExtraOrBuilder
        public BattleTopUserOrBuilder getTopOrBuilder(int i) {
            RepeatedFieldBuilderV3<BattleTopUser, BattleTopUser.Builder, BattleTopUserOrBuilder> repeatedFieldBuilderV3 = this.topBuilder_;
            return repeatedFieldBuilderV3 == null ? this.top_.get(i) : (BattleTopUserOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // cn.irisgw.live.PKProgressUpdateExtraOrBuilder
        public List<? extends BattleTopUserOrBuilder> getTopOrBuilderList() {
            RepeatedFieldBuilderV3<BattleTopUser, BattleTopUser.Builder, BattleTopUserOrBuilder> repeatedFieldBuilderV3 = this.topBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.top_);
        }

        @Override // cn.irisgw.live.PKProgressUpdateExtraOrBuilder
        public int getTotal() {
            return this.total_;
        }

        @Override // cn.irisgw.live.PKProgressUpdateExtraOrBuilder
        public int getUid() {
            return this.uid_;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_PKProgressUpdateExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(PKProgressUpdateExtra.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(PKProgressUpdateExtra pKProgressUpdateExtra) {
            if (pKProgressUpdateExtra == PKProgressUpdateExtra.getDefaultInstance()) {
                return this;
            }
            if (pKProgressUpdateExtra.getUid() != 0) {
                setUid(pKProgressUpdateExtra.getUid());
            }
            if (pKProgressUpdateExtra.getScore() != 0) {
                setScore(pKProgressUpdateExtra.getScore());
            }
            if (pKProgressUpdateExtra.getTotal() != 0) {
                setTotal(pKProgressUpdateExtra.getTotal());
            }
            if (this.topBuilder_ == null) {
                if (!pKProgressUpdateExtra.top_.isEmpty()) {
                    if (this.top_.isEmpty()) {
                        this.top_ = pKProgressUpdateExtra.top_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureTopIsMutable();
                        this.top_.addAll(pKProgressUpdateExtra.top_);
                    }
                    onChanged();
                }
            } else if (!pKProgressUpdateExtra.top_.isEmpty()) {
                if (this.topBuilder_.isEmpty()) {
                    this.topBuilder_.dispose();
                    this.topBuilder_ = null;
                    this.top_ = pKProgressUpdateExtra.top_;
                    this.bitField0_ &= -2;
                    this.topBuilder_ = PKProgressUpdateExtra.alwaysUseFieldBuilders ? getTopFieldBuilder() : null;
                } else {
                    this.topBuilder_.addAllMessages(pKProgressUpdateExtra.top_);
                }
            }
            if (this.targetTopBuilder_ == null) {
                if (!pKProgressUpdateExtra.targetTop_.isEmpty()) {
                    if (this.targetTop_.isEmpty()) {
                        this.targetTop_ = pKProgressUpdateExtra.targetTop_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureTargetTopIsMutable();
                        this.targetTop_.addAll(pKProgressUpdateExtra.targetTop_);
                    }
                    onChanged();
                }
            } else if (!pKProgressUpdateExtra.targetTop_.isEmpty()) {
                if (this.targetTopBuilder_.isEmpty()) {
                    this.targetTopBuilder_.dispose();
                    this.targetTopBuilder_ = null;
                    this.targetTop_ = pKProgressUpdateExtra.targetTop_;
                    this.bitField0_ &= -3;
                    RepeatedFieldBuilderV3<BattleTopUser, BattleTopUser.Builder, BattleTopUserOrBuilder> repeatedFieldBuilderV3 = null;
                    if (PKProgressUpdateExtra.alwaysUseFieldBuilders) {
                        repeatedFieldBuilderV3 = getTargetTopFieldBuilder();
                    }
                    this.targetTopBuilder_ = repeatedFieldBuilderV3;
                } else {
                    this.targetTopBuilder_.addAllMessages(pKProgressUpdateExtra.targetTop_);
                }
            }
            m6584mergeUnknownFields(pKProgressUpdateExtra.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.PKProgressUpdateExtra.Builder m6581mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.PKProgressUpdateExtra.access$2400()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.PKProgressUpdateExtra r0 = (cn.irisgw.live.PKProgressUpdateExtra) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.PKProgressUpdateExtra$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.PKProgressUpdateExtra r0 = (cn.irisgw.live.PKProgressUpdateExtra) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.PKProgressUpdateExtra$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.PKProgressUpdateExtra.Builder.m6581mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.PKProgressUpdateExtra$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m6580mergeFrom(Message message) {
            if (message instanceof PKProgressUpdateExtra) {
                return mergeFrom((PKProgressUpdateExtra) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m6584mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder removeTargetTop(int i) {
            RepeatedFieldBuilderV3<BattleTopUser, BattleTopUser.Builder, BattleTopUserOrBuilder> repeatedFieldBuilderV3 = this.targetTopBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.remove(i);
                return this;
            }
            ensureTargetTopIsMutable();
            this.targetTop_.remove(i);
            onChanged();
            return this;
        }

        public Builder removeTop(int i) {
            RepeatedFieldBuilderV3<BattleTopUser, BattleTopUser.Builder, BattleTopUserOrBuilder> repeatedFieldBuilderV3 = this.topBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.remove(i);
                return this;
            }
            ensureTopIsMutable();
            this.top_.remove(i);
            onChanged();
            return this;
        }

        /* renamed from: setField */
        public Builder m6586setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        /* renamed from: setRepeatedField */
        public Builder m6588setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setScore(int i) {
            this.score_ = i;
            onChanged();
            return this;
        }

        public Builder setTargetTop(int i, BattleTopUser.Builder builder) {
            RepeatedFieldBuilderV3<BattleTopUser, BattleTopUser.Builder, BattleTopUserOrBuilder> repeatedFieldBuilderV3 = this.targetTopBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.m6518build());
                return this;
            }
            ensureTargetTopIsMutable();
            this.targetTop_.set(i, builder.m6518build());
            onChanged();
            return this;
        }

        public Builder setTargetTop(int i, BattleTopUser battleTopUser) {
            RepeatedFieldBuilderV3<BattleTopUser, BattleTopUser.Builder, BattleTopUserOrBuilder> repeatedFieldBuilderV3 = this.targetTopBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, battleTopUser);
                return this;
            } else if (battleTopUser != null) {
                ensureTargetTopIsMutable();
                this.targetTop_.set(i, battleTopUser);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder setTop(int i, BattleTopUser.Builder builder) {
            RepeatedFieldBuilderV3<BattleTopUser, BattleTopUser.Builder, BattleTopUserOrBuilder> repeatedFieldBuilderV3 = this.topBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.m6518build());
                return this;
            }
            ensureTopIsMutable();
            this.top_.set(i, builder.m6518build());
            onChanged();
            return this;
        }

        public Builder setTop(int i, BattleTopUser battleTopUser) {
            RepeatedFieldBuilderV3<BattleTopUser, BattleTopUser.Builder, BattleTopUserOrBuilder> repeatedFieldBuilderV3 = this.topBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, battleTopUser);
                return this;
            } else if (battleTopUser != null) {
                ensureTopIsMutable();
                this.top_.set(i, battleTopUser);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder setTotal(int i) {
            this.total_ = i;
            onChanged();
            return this;
        }

        public Builder setUid(int i) {
            this.uid_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setUnknownFields */
        public final Builder m6590setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private PKProgressUpdateExtra() {
        this.memoizedIsInitialized = (byte) -1;
        this.top_ = Collections.emptyList();
        this.targetTop_ = Collections.emptyList();
    }

    private PKProgressUpdateExtra(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.score_ = codedInputStream.readUInt32();
                        } else if (readTag == 24) {
                            this.total_ = codedInputStream.readUInt32();
                        } else if (readTag == 34) {
                            boolean z4 = z2;
                            if (!(z2 & true)) {
                                this.top_ = new ArrayList();
                                z4 = z2 | true;
                            }
                            this.top_.add((BattleTopUser) codedInputStream.readMessage(BattleTopUser.parser(), extensionRegistryLite));
                            z2 = z4;
                        } else if (readTag == 42) {
                            boolean z5 = z2;
                            if (!(z2 & true)) {
                                this.targetTop_ = new ArrayList();
                                z5 = z2 | true;
                            }
                            this.targetTop_.add((BattleTopUser) codedInputStream.readMessage(BattleTopUser.parser(), extensionRegistryLite));
                            z2 = z5;
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
                    this.top_ = Collections.unmodifiableList(this.top_);
                }
                if (z3 & true) {
                    this.targetTop_ = Collections.unmodifiableList(this.targetTop_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                throw th;
            }
        }
        if (z2 & true) {
            this.top_ = Collections.unmodifiableList(this.top_);
        }
        if (z2 & true) {
            this.targetTop_ = Collections.unmodifiableList(this.targetTop_);
        }
        this.unknownFields = newBuilder.build();
        makeExtensionsImmutable();
    }

    private PKProgressUpdateExtra(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static PKProgressUpdateExtra getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_PKProgressUpdateExtra_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m6504toBuilder();
    }

    public static Builder newBuilder(PKProgressUpdateExtra pKProgressUpdateExtra) {
        return DEFAULT_INSTANCE.m6504toBuilder().mergeFrom(pKProgressUpdateExtra);
    }

    public static PKProgressUpdateExtra parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static PKProgressUpdateExtra parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PKProgressUpdateExtra parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (PKProgressUpdateExtra) PARSER.parseFrom(byteString);
    }

    public static PKProgressUpdateExtra parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PKProgressUpdateExtra) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static PKProgressUpdateExtra parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static PKProgressUpdateExtra parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static PKProgressUpdateExtra parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static PKProgressUpdateExtra parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PKProgressUpdateExtra parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (PKProgressUpdateExtra) PARSER.parseFrom(byteBuffer);
    }

    public static PKProgressUpdateExtra parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PKProgressUpdateExtra) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static PKProgressUpdateExtra parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (PKProgressUpdateExtra) PARSER.parseFrom(bArr);
    }

    public static PKProgressUpdateExtra parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PKProgressUpdateExtra) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<PKProgressUpdateExtra> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PKProgressUpdateExtra) {
            PKProgressUpdateExtra pKProgressUpdateExtra = (PKProgressUpdateExtra) obj;
            return getUid() == pKProgressUpdateExtra.getUid() && getScore() == pKProgressUpdateExtra.getScore() && getTotal() == pKProgressUpdateExtra.getTotal() && getTopList().equals(pKProgressUpdateExtra.getTopList()) && getTargetTopList().equals(pKProgressUpdateExtra.getTargetTopList()) && this.unknownFields.equals(pKProgressUpdateExtra.unknownFields);
        }
        return super.equals(obj);
    }

    /* renamed from: getDefaultInstanceForType */
    public PKProgressUpdateExtra m6499getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public Parser<PKProgressUpdateExtra> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.PKProgressUpdateExtraOrBuilder
    public int getScore() {
        return this.score_;
    }

    public int getSerializedSize() {
        int i;
        int i2;
        int i3 = this.memoizedSize;
        if (i3 != -1) {
            return i3;
        }
        int i4 = this.uid_;
        int computeUInt32Size = i4 != 0 ? CodedOutputStream.computeUInt32Size(1, i4) + 0 : 0;
        int i5 = this.score_;
        int i6 = computeUInt32Size;
        if (i5 != 0) {
            i6 = computeUInt32Size + CodedOutputStream.computeUInt32Size(2, i5);
        }
        int i7 = this.total_;
        int i8 = i6;
        if (i7 != 0) {
            i8 = i6 + CodedOutputStream.computeUInt32Size(3, i7);
        }
        int i9 = 0;
        while (true) {
            int i10 = i9;
            i = i8;
            if (i10 >= this.top_.size()) {
                break;
            }
            i8 += CodedOutputStream.computeMessageSize(4, this.top_.get(i10));
            i9 = i10 + 1;
        }
        for (i2 = 0; i2 < this.targetTop_.size(); i2++) {
            i += CodedOutputStream.computeMessageSize(5, this.targetTop_.get(i2));
        }
        int serializedSize = i + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.PKProgressUpdateExtraOrBuilder
    public BattleTopUser getTargetTop(int i) {
        return this.targetTop_.get(i);
    }

    @Override // cn.irisgw.live.PKProgressUpdateExtraOrBuilder
    public int getTargetTopCount() {
        return this.targetTop_.size();
    }

    @Override // cn.irisgw.live.PKProgressUpdateExtraOrBuilder
    public List<BattleTopUser> getTargetTopList() {
        return this.targetTop_;
    }

    @Override // cn.irisgw.live.PKProgressUpdateExtraOrBuilder
    public BattleTopUserOrBuilder getTargetTopOrBuilder(int i) {
        return this.targetTop_.get(i);
    }

    @Override // cn.irisgw.live.PKProgressUpdateExtraOrBuilder
    public List<? extends BattleTopUserOrBuilder> getTargetTopOrBuilderList() {
        return this.targetTop_;
    }

    @Override // cn.irisgw.live.PKProgressUpdateExtraOrBuilder
    public BattleTopUser getTop(int i) {
        return this.top_.get(i);
    }

    @Override // cn.irisgw.live.PKProgressUpdateExtraOrBuilder
    public int getTopCount() {
        return this.top_.size();
    }

    @Override // cn.irisgw.live.PKProgressUpdateExtraOrBuilder
    public List<BattleTopUser> getTopList() {
        return this.top_;
    }

    @Override // cn.irisgw.live.PKProgressUpdateExtraOrBuilder
    public BattleTopUserOrBuilder getTopOrBuilder(int i) {
        return this.top_.get(i);
    }

    @Override // cn.irisgw.live.PKProgressUpdateExtraOrBuilder
    public List<? extends BattleTopUserOrBuilder> getTopOrBuilderList() {
        return this.top_;
    }

    @Override // cn.irisgw.live.PKProgressUpdateExtraOrBuilder
    public int getTotal() {
        return this.total_;
    }

    @Override // cn.irisgw.live.PKProgressUpdateExtraOrBuilder
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
        int hashCode = ((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getUid()) * 37) + 2) * 53) + getScore()) * 37) + 3) * 53) + getTotal();
        int i = hashCode;
        if (getTopCount() > 0) {
            i = (((hashCode * 37) + 4) * 53) + getTopList().hashCode();
        }
        int i2 = i;
        if (getTargetTopCount() > 0) {
            i2 = (((i * 37) + 5) * 53) + getTargetTopList().hashCode();
        }
        int hashCode2 = (i2 * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_PKProgressUpdateExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(PKProgressUpdateExtra.class, Builder.class);
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
    public Builder m6502newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m6501newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new PKProgressUpdateExtra();
    }

    /* renamed from: toBuilder */
    public Builder m6504toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i;
        int i2 = this.uid_;
        if (i2 != 0) {
            codedOutputStream.writeUInt32(1, i2);
        }
        int i3 = this.score_;
        if (i3 != 0) {
            codedOutputStream.writeUInt32(2, i3);
        }
        int i4 = this.total_;
        if (i4 != 0) {
            codedOutputStream.writeUInt32(3, i4);
        }
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= this.top_.size()) {
                break;
            }
            codedOutputStream.writeMessage(4, this.top_.get(i6));
            i5 = i6 + 1;
        }
        for (i = 0; i < this.targetTop_.size(); i++) {
            codedOutputStream.writeMessage(5, this.targetTop_.get(i));
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
