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
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/KickOutExtra.class */
public final class KickOutExtra extends GeneratedMessageV3 implements KickOutExtraOrBuilder {
    public static final int KICK_OUT_PROFILE_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private KickOutProfile kickOutProfile_;
    private byte memoizedIsInitialized;
    private static final KickOutExtra DEFAULT_INSTANCE = new KickOutExtra();
    private static final Parser<KickOutExtra> PARSER = new AbstractParser<KickOutExtra>() { // from class: cn.irisgw.live.KickOutExtra.1
        /* renamed from: parsePartialFrom */
        public KickOutExtra m3709parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new KickOutExtra(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/KickOutExtra$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements KickOutExtraOrBuilder {
        private SingleFieldBuilderV3<KickOutProfile, KickOutProfile.Builder, KickOutProfileOrBuilder> kickOutProfileBuilder_;
        private KickOutProfile kickOutProfile_;

        private Builder() {
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_KickOutExtra_descriptor;
        }

        private SingleFieldBuilderV3<KickOutProfile, KickOutProfile.Builder, KickOutProfileOrBuilder> getKickOutProfileFieldBuilder() {
            if (this.kickOutProfileBuilder_ == null) {
                this.kickOutProfileBuilder_ = new SingleFieldBuilderV3<>(getKickOutProfile(), getParentForChildren(), isClean());
                this.kickOutProfile_ = null;
            }
            return this.kickOutProfileBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = KickOutExtra.alwaysUseFieldBuilders;
        }

        /* renamed from: addRepeatedField */
        public Builder m3711addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public KickOutExtra m3713build() {
            KickOutExtra m3715buildPartial = m3715buildPartial();
            if (m3715buildPartial.isInitialized()) {
                return m3715buildPartial;
            }
            throw newUninitializedMessageException(m3715buildPartial);
        }

        /* renamed from: buildPartial */
        public KickOutExtra m3715buildPartial() {
            KickOutExtra kickOutExtra = new KickOutExtra(this);
            SingleFieldBuilderV3<KickOutProfile, KickOutProfile.Builder, KickOutProfileOrBuilder> singleFieldBuilderV3 = this.kickOutProfileBuilder_;
            if (singleFieldBuilderV3 == null) {
                kickOutExtra.kickOutProfile_ = this.kickOutProfile_;
            } else {
                kickOutExtra.kickOutProfile_ = singleFieldBuilderV3.build();
            }
            onBuilt();
            return kickOutExtra;
        }

        /* renamed from: clear */
        public Builder m3719clear() {
            super.clear();
            if (this.kickOutProfileBuilder_ == null) {
                this.kickOutProfile_ = null;
                return this;
            }
            this.kickOutProfile_ = null;
            this.kickOutProfileBuilder_ = null;
            return this;
        }

        /* renamed from: clearField */
        public Builder m3721clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearKickOutProfile() {
            if (this.kickOutProfileBuilder_ == null) {
                this.kickOutProfile_ = null;
                onChanged();
                return this;
            }
            this.kickOutProfile_ = null;
            this.kickOutProfileBuilder_ = null;
            return this;
        }

        /* renamed from: clearOneof */
        public Builder m3724clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        /* renamed from: clone */
        public Builder m3730clone() {
            return (Builder) super.clone();
        }

        /* renamed from: getDefaultInstanceForType */
        public KickOutExtra m3732getDefaultInstanceForType() {
            return KickOutExtra.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_KickOutExtra_descriptor;
        }

        @Override // cn.irisgw.live.KickOutExtraOrBuilder
        public KickOutProfile getKickOutProfile() {
            SingleFieldBuilderV3<KickOutProfile, KickOutProfile.Builder, KickOutProfileOrBuilder> singleFieldBuilderV3 = this.kickOutProfileBuilder_;
            if (singleFieldBuilderV3 == null) {
                KickOutProfile kickOutProfile = this.kickOutProfile_;
                KickOutProfile kickOutProfile2 = kickOutProfile;
                if (kickOutProfile == null) {
                    kickOutProfile2 = KickOutProfile.getDefaultInstance();
                }
                return kickOutProfile2;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public KickOutProfile.Builder getKickOutProfileBuilder() {
            onChanged();
            return getKickOutProfileFieldBuilder().getBuilder();
        }

        @Override // cn.irisgw.live.KickOutExtraOrBuilder
        public KickOutProfileOrBuilder getKickOutProfileOrBuilder() {
            SingleFieldBuilderV3<KickOutProfile, KickOutProfile.Builder, KickOutProfileOrBuilder> singleFieldBuilderV3 = this.kickOutProfileBuilder_;
            if (singleFieldBuilderV3 != null) {
                return (KickOutProfileOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
            }
            KickOutProfile kickOutProfile = this.kickOutProfile_;
            KickOutProfile kickOutProfile2 = kickOutProfile;
            if (kickOutProfile == null) {
                kickOutProfile2 = KickOutProfile.getDefaultInstance();
            }
            return kickOutProfile2;
        }

        @Override // cn.irisgw.live.KickOutExtraOrBuilder
        public boolean hasKickOutProfile() {
            return (this.kickOutProfileBuilder_ == null && this.kickOutProfile_ == null) ? false : true;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_KickOutExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(KickOutExtra.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(KickOutExtra kickOutExtra) {
            if (kickOutExtra == KickOutExtra.getDefaultInstance()) {
                return this;
            }
            if (kickOutExtra.hasKickOutProfile()) {
                mergeKickOutProfile(kickOutExtra.getKickOutProfile());
            }
            m3741mergeUnknownFields(kickOutExtra.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.KickOutExtra.Builder m3738mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.KickOutExtra.access$1600()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.KickOutExtra r0 = (cn.irisgw.live.KickOutExtra) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.KickOutExtra$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.KickOutExtra r0 = (cn.irisgw.live.KickOutExtra) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.KickOutExtra$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.KickOutExtra.Builder.m3738mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.KickOutExtra$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m3737mergeFrom(Message message) {
            if (message instanceof KickOutExtra) {
                return mergeFrom((KickOutExtra) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeKickOutProfile(KickOutProfile kickOutProfile) {
            SingleFieldBuilderV3<KickOutProfile, KickOutProfile.Builder, KickOutProfileOrBuilder> singleFieldBuilderV3 = this.kickOutProfileBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.mergeFrom(kickOutProfile);
                return this;
            }
            KickOutProfile kickOutProfile2 = this.kickOutProfile_;
            if (kickOutProfile2 != null) {
                this.kickOutProfile_ = KickOutProfile.newBuilder(kickOutProfile2).mergeFrom(kickOutProfile).m3762buildPartial();
            } else {
                this.kickOutProfile_ = kickOutProfile;
            }
            onChanged();
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m3741mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        /* renamed from: setField */
        public Builder m3743setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setKickOutProfile(KickOutProfile.Builder builder) {
            SingleFieldBuilderV3<KickOutProfile, KickOutProfile.Builder, KickOutProfileOrBuilder> singleFieldBuilderV3 = this.kickOutProfileBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(builder.m3760build());
                return this;
            }
            this.kickOutProfile_ = builder.m3760build();
            onChanged();
            return this;
        }

        public Builder setKickOutProfile(KickOutProfile kickOutProfile) {
            SingleFieldBuilderV3<KickOutProfile, KickOutProfile.Builder, KickOutProfileOrBuilder> singleFieldBuilderV3 = this.kickOutProfileBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(kickOutProfile);
                return this;
            } else if (kickOutProfile != null) {
                this.kickOutProfile_ = kickOutProfile;
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        /* renamed from: setRepeatedField */
        public Builder m3745setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        /* renamed from: setUnknownFields */
        public final Builder m3747setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/KickOutExtra$KickOutProfile.class */
    public static final class KickOutProfile extends GeneratedMessageV3 implements KickOutProfileOrBuilder {
        public static final int NAME_FIELD_NUMBER = 2;
        public static final int UID_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private volatile Object name_;
        private int uid_;
        private static final KickOutProfile DEFAULT_INSTANCE = new KickOutProfile();
        private static final Parser<KickOutProfile> PARSER = new AbstractParser<KickOutProfile>() { // from class: cn.irisgw.live.KickOutExtra.KickOutProfile.1
            /* renamed from: parsePartialFrom */
            public KickOutProfile m3756parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new KickOutProfile(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/KickOutExtra$KickOutProfile$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements KickOutProfileOrBuilder {
            private Object name_;
            private int uid_;

            private Builder() {
                this.name_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.name_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LiveConstants.internal_static_cn_irisgw_live_KickOutExtra_KickOutProfile_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = KickOutProfile.alwaysUseFieldBuilders;
            }

            /* renamed from: addRepeatedField */
            public Builder m3758addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: build */
            public KickOutProfile m3760build() {
                KickOutProfile m3762buildPartial = m3762buildPartial();
                if (m3762buildPartial.isInitialized()) {
                    return m3762buildPartial;
                }
                throw newUninitializedMessageException(m3762buildPartial);
            }

            /* renamed from: buildPartial */
            public KickOutProfile m3762buildPartial() {
                KickOutProfile kickOutProfile = new KickOutProfile(this);
                kickOutProfile.uid_ = this.uid_;
                kickOutProfile.name_ = this.name_;
                onBuilt();
                return kickOutProfile;
            }

            /* renamed from: clear */
            public Builder m3766clear() {
                super.clear();
                this.uid_ = 0;
                this.name_ = "";
                return this;
            }

            /* renamed from: clearField */
            public Builder m3768clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearName() {
                this.name_ = KickOutProfile.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            /* renamed from: clearOneof */
            public Builder m3771clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearUid() {
                this.uid_ = 0;
                onChanged();
                return this;
            }

            /* renamed from: clone */
            public Builder m3777clone() {
                return (Builder) super.clone();
            }

            /* renamed from: getDefaultInstanceForType */
            public KickOutProfile m3779getDefaultInstanceForType() {
                return KickOutProfile.getDefaultInstance();
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return LiveConstants.internal_static_cn_irisgw_live_KickOutExtra_KickOutProfile_descriptor;
            }

            @Override // cn.irisgw.live.KickOutExtra.KickOutProfileOrBuilder
            public String getName() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.KickOutExtra.KickOutProfileOrBuilder
            public ByteString getNameBytes() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.name_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.KickOutExtra.KickOutProfileOrBuilder
            public int getUid() {
                return this.uid_;
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveConstants.internal_static_cn_irisgw_live_KickOutExtra_KickOutProfile_fieldAccessorTable.ensureFieldAccessorsInitialized(KickOutProfile.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(KickOutProfile kickOutProfile) {
                if (kickOutProfile == KickOutProfile.getDefaultInstance()) {
                    return this;
                }
                if (kickOutProfile.getUid() != 0) {
                    setUid(kickOutProfile.getUid());
                }
                if (!kickOutProfile.getName().isEmpty()) {
                    this.name_ = kickOutProfile.name_;
                    onChanged();
                }
                m3788mergeUnknownFields(kickOutProfile.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            /* renamed from: mergeFrom */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.KickOutExtra.KickOutProfile.Builder m3785mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.KickOutExtra.KickOutProfile.access$700()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.KickOutExtra$KickOutProfile r0 = (cn.irisgw.live.KickOutExtra.KickOutProfile) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.KickOutExtra$KickOutProfile$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.KickOutExtra$KickOutProfile r0 = (cn.irisgw.live.KickOutExtra.KickOutProfile) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.KickOutExtra$KickOutProfile$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.KickOutExtra.KickOutProfile.Builder.m3785mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.KickOutExtra$KickOutProfile$Builder");
            }

            /* renamed from: mergeFrom */
            public Builder m3784mergeFrom(Message message) {
                if (message instanceof KickOutProfile) {
                    return mergeFrom((KickOutProfile) message);
                }
                super.mergeFrom(message);
                return this;
            }

            /* renamed from: mergeUnknownFields */
            public final Builder m3788mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            /* renamed from: setField */
            public Builder m3790setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
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
                    KickOutProfile.checkByteStringIsUtf8(byteString);
                    this.name_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            /* renamed from: setRepeatedField */
            public Builder m3792setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setUid(int i) {
                this.uid_ = i;
                onChanged();
                return this;
            }

            /* renamed from: setUnknownFields */
            public final Builder m3794setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private KickOutProfile() {
            this.memoizedIsInitialized = (byte) -1;
            this.name_ = "";
        }

        private KickOutProfile(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.name_ = codedInputStream.readStringRequireUtf8();
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

        private KickOutProfile(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static KickOutProfile getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_KickOutExtra_KickOutProfile_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m3755toBuilder();
        }

        public static Builder newBuilder(KickOutProfile kickOutProfile) {
            return DEFAULT_INSTANCE.m3755toBuilder().mergeFrom(kickOutProfile);
        }

        public static KickOutProfile parseDelimitedFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static KickOutProfile parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static KickOutProfile parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (KickOutProfile) PARSER.parseFrom(byteString);
        }

        public static KickOutProfile parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (KickOutProfile) PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static KickOutProfile parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static KickOutProfile parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static KickOutProfile parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static KickOutProfile parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static KickOutProfile parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (KickOutProfile) PARSER.parseFrom(byteBuffer);
        }

        public static KickOutProfile parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (KickOutProfile) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static KickOutProfile parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (KickOutProfile) PARSER.parseFrom(bArr);
        }

        public static KickOutProfile parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (KickOutProfile) PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<KickOutProfile> parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof KickOutProfile) {
                KickOutProfile kickOutProfile = (KickOutProfile) obj;
                return getUid() == kickOutProfile.getUid() && getName().equals(kickOutProfile.getName()) && this.unknownFields.equals(kickOutProfile.unknownFields);
            }
            return super.equals(obj);
        }

        /* renamed from: getDefaultInstanceForType */
        public KickOutProfile m3750getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // cn.irisgw.live.KickOutExtra.KickOutProfileOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.KickOutExtra.KickOutProfileOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Parser<KickOutProfile> getParserForType() {
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
            if (!getNameBytes().isEmpty()) {
                i4 = i2 + GeneratedMessageV3.computeStringSize(2, this.name_);
            }
            int serializedSize = i4 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // cn.irisgw.live.KickOutExtra.KickOutProfileOrBuilder
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
            int hashCode = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getUid()) * 37) + 2) * 53) + getName().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_KickOutExtra_KickOutProfile_fieldAccessorTable.ensureFieldAccessorsInitialized(KickOutProfile.class, Builder.class);
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
        public Builder m3753newBuilderForType() {
            return newBuilder();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: newBuilderForType */
        public Builder m3752newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new KickOutProfile();
        }

        /* renamed from: toBuilder */
        public Builder m3755toBuilder() {
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
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/KickOutExtra$KickOutProfileOrBuilder.class */
    public interface KickOutProfileOrBuilder extends MessageOrBuilder {
        String getName();

        ByteString getNameBytes();

        int getUid();
    }

    private KickOutExtra() {
        this.memoizedIsInitialized = (byte) -1;
    }

    private KickOutExtra(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                KickOutProfile.Builder m3755toBuilder = this.kickOutProfile_ != null ? this.kickOutProfile_.m3755toBuilder() : null;
                                KickOutProfile readMessage = codedInputStream.readMessage(KickOutProfile.parser(), extensionRegistryLite);
                                this.kickOutProfile_ = readMessage;
                                if (m3755toBuilder != null) {
                                    m3755toBuilder.mergeFrom(readMessage);
                                    this.kickOutProfile_ = m3755toBuilder.m3762buildPartial();
                                }
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

    private KickOutExtra(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static KickOutExtra getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_KickOutExtra_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m3708toBuilder();
    }

    public static Builder newBuilder(KickOutExtra kickOutExtra) {
        return DEFAULT_INSTANCE.m3708toBuilder().mergeFrom(kickOutExtra);
    }

    public static KickOutExtra parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static KickOutExtra parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static KickOutExtra parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (KickOutExtra) PARSER.parseFrom(byteString);
    }

    public static KickOutExtra parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (KickOutExtra) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static KickOutExtra parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static KickOutExtra parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static KickOutExtra parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static KickOutExtra parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static KickOutExtra parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (KickOutExtra) PARSER.parseFrom(byteBuffer);
    }

    public static KickOutExtra parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (KickOutExtra) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static KickOutExtra parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (KickOutExtra) PARSER.parseFrom(bArr);
    }

    public static KickOutExtra parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (KickOutExtra) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<KickOutExtra> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof KickOutExtra) {
            KickOutExtra kickOutExtra = (KickOutExtra) obj;
            if (hasKickOutProfile() != kickOutExtra.hasKickOutProfile()) {
                return false;
            }
            return (!hasKickOutProfile() || getKickOutProfile().equals(kickOutExtra.getKickOutProfile())) && this.unknownFields.equals(kickOutExtra.unknownFields);
        }
        return super.equals(obj);
    }

    /* renamed from: getDefaultInstanceForType */
    public KickOutExtra m3703getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.KickOutExtraOrBuilder
    public KickOutProfile getKickOutProfile() {
        KickOutProfile kickOutProfile = this.kickOutProfile_;
        KickOutProfile kickOutProfile2 = kickOutProfile;
        if (kickOutProfile == null) {
            kickOutProfile2 = KickOutProfile.getDefaultInstance();
        }
        return kickOutProfile2;
    }

    @Override // cn.irisgw.live.KickOutExtraOrBuilder
    public KickOutProfileOrBuilder getKickOutProfileOrBuilder() {
        return getKickOutProfile();
    }

    public Parser<KickOutExtra> getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.kickOutProfile_ != null) {
            i2 = 0 + CodedOutputStream.computeMessageSize(1, getKickOutProfile());
        }
        int serializedSize = i2 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // cn.irisgw.live.KickOutExtraOrBuilder
    public boolean hasKickOutProfile() {
        return this.kickOutProfile_ != null;
    }

    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = 779 + getDescriptor().hashCode();
        int i = hashCode;
        if (hasKickOutProfile()) {
            i = (((hashCode * 37) + 1) * 53) + getKickOutProfile().hashCode();
        }
        int hashCode2 = (i * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_KickOutExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(KickOutExtra.class, Builder.class);
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
    public Builder m3706newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m3705newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new KickOutExtra();
    }

    /* renamed from: toBuilder */
    public Builder m3708toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (this.kickOutProfile_ != null) {
            codedOutputStream.writeMessage(1, getKickOutProfile());
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
