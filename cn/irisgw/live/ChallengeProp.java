package cn.irisgw.live;

import cn.irisgw.live.UserProp;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ChallengeProp.class */
public final class ChallengeProp extends GeneratedMessageV3 implements ChallengePropOrBuilder {
    public static final int IS_SELF_FIELD_NUMBER = 2;
    public static final int USER_PROP_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private boolean isSelf_;
    private byte memoizedIsInitialized;
    private UserProp userProp_;
    private static final ChallengeProp DEFAULT_INSTANCE = new ChallengeProp();
    private static final Parser<ChallengeProp> PARSER = new AbstractParser<ChallengeProp>() { // from class: cn.irisgw.live.ChallengeProp.1
        /* renamed from: parsePartialFrom */
        public ChallengeProp m1150parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new ChallengeProp(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ChallengeProp$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ChallengePropOrBuilder {
        private boolean isSelf_;
        private SingleFieldBuilderV3<UserProp, UserProp.Builder, UserPropOrBuilder> userPropBuilder_;
        private UserProp userProp_;

        private Builder() {
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_ChallengeProp_descriptor;
        }

        private SingleFieldBuilderV3<UserProp, UserProp.Builder, UserPropOrBuilder> getUserPropFieldBuilder() {
            if (this.userPropBuilder_ == null) {
                this.userPropBuilder_ = new SingleFieldBuilderV3<>(getUserProp(), getParentForChildren(), isClean());
                this.userProp_ = null;
            }
            return this.userPropBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = ChallengeProp.alwaysUseFieldBuilders;
        }

        /* renamed from: addRepeatedField */
        public Builder m1152addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public ChallengeProp m1154build() {
            ChallengeProp m1156buildPartial = m1156buildPartial();
            if (m1156buildPartial.isInitialized()) {
                return m1156buildPartial;
            }
            throw newUninitializedMessageException(m1156buildPartial);
        }

        /* renamed from: buildPartial */
        public ChallengeProp m1156buildPartial() {
            ChallengeProp challengeProp = new ChallengeProp(this);
            SingleFieldBuilderV3<UserProp, UserProp.Builder, UserPropOrBuilder> singleFieldBuilderV3 = this.userPropBuilder_;
            if (singleFieldBuilderV3 == null) {
                challengeProp.userProp_ = this.userProp_;
            } else {
                challengeProp.userProp_ = singleFieldBuilderV3.build();
            }
            challengeProp.isSelf_ = this.isSelf_;
            onBuilt();
            return challengeProp;
        }

        /* renamed from: clear */
        public Builder m1160clear() {
            super.clear();
            if (this.userPropBuilder_ == null) {
                this.userProp_ = null;
            } else {
                this.userProp_ = null;
                this.userPropBuilder_ = null;
            }
            this.isSelf_ = false;
            return this;
        }

        /* renamed from: clearField */
        public Builder m1162clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearIsSelf() {
            this.isSelf_ = false;
            onChanged();
            return this;
        }

        /* renamed from: clearOneof */
        public Builder m1165clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearUserProp() {
            if (this.userPropBuilder_ == null) {
                this.userProp_ = null;
                onChanged();
                return this;
            }
            this.userProp_ = null;
            this.userPropBuilder_ = null;
            return this;
        }

        /* renamed from: clone */
        public Builder m1171clone() {
            return (Builder) super.clone();
        }

        /* renamed from: getDefaultInstanceForType */
        public ChallengeProp m1173getDefaultInstanceForType() {
            return ChallengeProp.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_ChallengeProp_descriptor;
        }

        @Override // cn.irisgw.live.ChallengePropOrBuilder
        public boolean getIsSelf() {
            return this.isSelf_;
        }

        @Override // cn.irisgw.live.ChallengePropOrBuilder
        public UserProp getUserProp() {
            SingleFieldBuilderV3<UserProp, UserProp.Builder, UserPropOrBuilder> singleFieldBuilderV3 = this.userPropBuilder_;
            if (singleFieldBuilderV3 == null) {
                UserProp userProp = this.userProp_;
                UserProp userProp2 = userProp;
                if (userProp == null) {
                    userProp2 = UserProp.getDefaultInstance();
                }
                return userProp2;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public UserProp.Builder getUserPropBuilder() {
            onChanged();
            return getUserPropFieldBuilder().getBuilder();
        }

        @Override // cn.irisgw.live.ChallengePropOrBuilder
        public UserPropOrBuilder getUserPropOrBuilder() {
            SingleFieldBuilderV3<UserProp, UserProp.Builder, UserPropOrBuilder> singleFieldBuilderV3 = this.userPropBuilder_;
            if (singleFieldBuilderV3 != null) {
                return (UserPropOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
            }
            UserProp userProp = this.userProp_;
            UserProp userProp2 = userProp;
            if (userProp == null) {
                userProp2 = UserProp.getDefaultInstance();
            }
            return userProp2;
        }

        @Override // cn.irisgw.live.ChallengePropOrBuilder
        public boolean hasUserProp() {
            return (this.userPropBuilder_ == null && this.userProp_ == null) ? false : true;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_ChallengeProp_fieldAccessorTable.ensureFieldAccessorsInitialized(ChallengeProp.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(ChallengeProp challengeProp) {
            if (challengeProp == ChallengeProp.getDefaultInstance()) {
                return this;
            }
            if (challengeProp.hasUserProp()) {
                mergeUserProp(challengeProp.getUserProp());
            }
            if (challengeProp.getIsSelf()) {
                setIsSelf(challengeProp.getIsSelf());
            }
            m1182mergeUnknownFields(challengeProp.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.ChallengeProp.Builder m1179mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.ChallengeProp.access$700()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.ChallengeProp r0 = (cn.irisgw.live.ChallengeProp) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.ChallengeProp$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.ChallengeProp r0 = (cn.irisgw.live.ChallengeProp) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.ChallengeProp$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.ChallengeProp.Builder.m1179mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.ChallengeProp$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m1178mergeFrom(Message message) {
            if (message instanceof ChallengeProp) {
                return mergeFrom((ChallengeProp) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m1182mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder mergeUserProp(UserProp userProp) {
            SingleFieldBuilderV3<UserProp, UserProp.Builder, UserPropOrBuilder> singleFieldBuilderV3 = this.userPropBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.mergeFrom(userProp);
                return this;
            }
            UserProp userProp2 = this.userProp_;
            if (userProp2 != null) {
                this.userProp_ = UserProp.newBuilder(userProp2).mergeFrom(userProp).m8076buildPartial();
            } else {
                this.userProp_ = userProp;
            }
            onChanged();
            return this;
        }

        /* renamed from: setField */
        public Builder m1184setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setIsSelf(boolean z) {
            this.isSelf_ = z;
            onChanged();
            return this;
        }

        /* renamed from: setRepeatedField */
        public Builder m1186setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        /* renamed from: setUnknownFields */
        public final Builder m1188setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }

        public Builder setUserProp(UserProp.Builder builder) {
            SingleFieldBuilderV3<UserProp, UserProp.Builder, UserPropOrBuilder> singleFieldBuilderV3 = this.userPropBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(builder.m8074build());
                return this;
            }
            this.userProp_ = builder.m8074build();
            onChanged();
            return this;
        }

        public Builder setUserProp(UserProp userProp) {
            SingleFieldBuilderV3<UserProp, UserProp.Builder, UserPropOrBuilder> singleFieldBuilderV3 = this.userPropBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(userProp);
                return this;
            } else if (userProp != null) {
                this.userProp_ = userProp;
                onChanged();
                return this;
            } else {
                throw null;
            }
        }
    }

    private ChallengeProp() {
        this.memoizedIsInitialized = (byte) -1;
    }

    private ChallengeProp(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                        if (readTag == 10) {
                            UserProp.Builder m8069toBuilder = this.userProp_ != null ? this.userProp_.m8069toBuilder() : null;
                            UserProp readMessage = codedInputStream.readMessage(UserProp.parser(), extensionRegistryLite);
                            this.userProp_ = readMessage;
                            if (m8069toBuilder != null) {
                                m8069toBuilder.mergeFrom(readMessage);
                                this.userProp_ = m8069toBuilder.m8076buildPartial();
                            }
                        } else if (readTag == 16) {
                            this.isSelf_ = codedInputStream.readBool();
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

    private ChallengeProp(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static ChallengeProp getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_ChallengeProp_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m1149toBuilder();
    }

    public static Builder newBuilder(ChallengeProp challengeProp) {
        return DEFAULT_INSTANCE.m1149toBuilder().mergeFrom(challengeProp);
    }

    public static ChallengeProp parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static ChallengeProp parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ChallengeProp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ChallengeProp) PARSER.parseFrom(byteString);
    }

    public static ChallengeProp parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ChallengeProp) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static ChallengeProp parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static ChallengeProp parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static ChallengeProp parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static ChallengeProp parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ChallengeProp parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ChallengeProp) PARSER.parseFrom(byteBuffer);
    }

    public static ChallengeProp parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ChallengeProp) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static ChallengeProp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ChallengeProp) PARSER.parseFrom(bArr);
    }

    public static ChallengeProp parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ChallengeProp) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<ChallengeProp> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ChallengeProp) {
            ChallengeProp challengeProp = (ChallengeProp) obj;
            if (hasUserProp() != challengeProp.hasUserProp()) {
                return false;
            }
            return (!hasUserProp() || getUserProp().equals(challengeProp.getUserProp())) && getIsSelf() == challengeProp.getIsSelf() && this.unknownFields.equals(challengeProp.unknownFields);
        }
        return super.equals(obj);
    }

    /* renamed from: getDefaultInstanceForType */
    public ChallengeProp m1144getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.ChallengePropOrBuilder
    public boolean getIsSelf() {
        return this.isSelf_;
    }

    public Parser<ChallengeProp> getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.userProp_ != null) {
            i2 = 0 + CodedOutputStream.computeMessageSize(1, getUserProp());
        }
        boolean z = this.isSelf_;
        int i3 = i2;
        if (z) {
            i3 = i2 + CodedOutputStream.computeBoolSize(2, z);
        }
        int serializedSize = i3 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // cn.irisgw.live.ChallengePropOrBuilder
    public UserProp getUserProp() {
        UserProp userProp = this.userProp_;
        UserProp userProp2 = userProp;
        if (userProp == null) {
            userProp2 = UserProp.getDefaultInstance();
        }
        return userProp2;
    }

    @Override // cn.irisgw.live.ChallengePropOrBuilder
    public UserPropOrBuilder getUserPropOrBuilder() {
        return getUserProp();
    }

    @Override // cn.irisgw.live.ChallengePropOrBuilder
    public boolean hasUserProp() {
        return this.userProp_ != null;
    }

    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = 779 + getDescriptor().hashCode();
        int i = hashCode;
        if (hasUserProp()) {
            i = (((hashCode * 37) + 1) * 53) + getUserProp().hashCode();
        }
        int hashBoolean = (((((i * 37) + 2) * 53) + Internal.hashBoolean(getIsSelf())) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashBoolean;
        return hashBoolean;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_ChallengeProp_fieldAccessorTable.ensureFieldAccessorsInitialized(ChallengeProp.class, Builder.class);
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
    public Builder m1147newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m1146newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new ChallengeProp();
    }

    /* renamed from: toBuilder */
    public Builder m1149toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (this.userProp_ != null) {
            codedOutputStream.writeMessage(1, getUserProp());
        }
        boolean z = this.isSelf_;
        if (z) {
            codedOutputStream.writeBool(2, z);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
