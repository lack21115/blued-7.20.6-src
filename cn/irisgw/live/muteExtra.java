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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/muteExtra.class */
public final class muteExtra extends GeneratedMessageV3 implements muteExtraOrBuilder {
    public static final int MUTE_PROFILE_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private MuteProfile muteProfile_;
    private static final muteExtra DEFAULT_INSTANCE = new muteExtra();
    private static final Parser<muteExtra> PARSER = new AbstractParser<muteExtra>() { // from class: cn.irisgw.live.muteExtra.1
        /* renamed from: parsePartialFrom */
        public muteExtra m8358parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new muteExtra(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/muteExtra$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements muteExtraOrBuilder {
        private SingleFieldBuilderV3<MuteProfile, MuteProfile.Builder, MuteProfileOrBuilder> muteProfileBuilder_;
        private MuteProfile muteProfile_;

        private Builder() {
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_muteExtra_descriptor;
        }

        private SingleFieldBuilderV3<MuteProfile, MuteProfile.Builder, MuteProfileOrBuilder> getMuteProfileFieldBuilder() {
            if (this.muteProfileBuilder_ == null) {
                this.muteProfileBuilder_ = new SingleFieldBuilderV3<>(getMuteProfile(), getParentForChildren(), isClean());
                this.muteProfile_ = null;
            }
            return this.muteProfileBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = muteExtra.alwaysUseFieldBuilders;
        }

        /* renamed from: addRepeatedField */
        public Builder m8360addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public muteExtra m8362build() {
            muteExtra m8364buildPartial = m8364buildPartial();
            if (m8364buildPartial.isInitialized()) {
                return m8364buildPartial;
            }
            throw newUninitializedMessageException(m8364buildPartial);
        }

        /* renamed from: buildPartial */
        public muteExtra m8364buildPartial() {
            muteExtra muteextra = new muteExtra(this);
            SingleFieldBuilderV3<MuteProfile, MuteProfile.Builder, MuteProfileOrBuilder> singleFieldBuilderV3 = this.muteProfileBuilder_;
            if (singleFieldBuilderV3 == null) {
                muteextra.muteProfile_ = this.muteProfile_;
            } else {
                muteextra.muteProfile_ = singleFieldBuilderV3.build();
            }
            onBuilt();
            return muteextra;
        }

        /* renamed from: clear */
        public Builder m8368clear() {
            super.clear();
            if (this.muteProfileBuilder_ == null) {
                this.muteProfile_ = null;
                return this;
            }
            this.muteProfile_ = null;
            this.muteProfileBuilder_ = null;
            return this;
        }

        /* renamed from: clearField */
        public Builder m8370clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearMuteProfile() {
            if (this.muteProfileBuilder_ == null) {
                this.muteProfile_ = null;
                onChanged();
                return this;
            }
            this.muteProfile_ = null;
            this.muteProfileBuilder_ = null;
            return this;
        }

        /* renamed from: clearOneof */
        public Builder m8373clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        /* renamed from: clone */
        public Builder m8379clone() {
            return (Builder) super.clone();
        }

        /* renamed from: getDefaultInstanceForType */
        public muteExtra m8381getDefaultInstanceForType() {
            return muteExtra.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_muteExtra_descriptor;
        }

        @Override // cn.irisgw.live.muteExtraOrBuilder
        public MuteProfile getMuteProfile() {
            SingleFieldBuilderV3<MuteProfile, MuteProfile.Builder, MuteProfileOrBuilder> singleFieldBuilderV3 = this.muteProfileBuilder_;
            if (singleFieldBuilderV3 == null) {
                MuteProfile muteProfile = this.muteProfile_;
                MuteProfile muteProfile2 = muteProfile;
                if (muteProfile == null) {
                    muteProfile2 = MuteProfile.getDefaultInstance();
                }
                return muteProfile2;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public MuteProfile.Builder getMuteProfileBuilder() {
            onChanged();
            return getMuteProfileFieldBuilder().getBuilder();
        }

        @Override // cn.irisgw.live.muteExtraOrBuilder
        public MuteProfileOrBuilder getMuteProfileOrBuilder() {
            SingleFieldBuilderV3<MuteProfile, MuteProfile.Builder, MuteProfileOrBuilder> singleFieldBuilderV3 = this.muteProfileBuilder_;
            if (singleFieldBuilderV3 != null) {
                return (MuteProfileOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
            }
            MuteProfile muteProfile = this.muteProfile_;
            MuteProfile muteProfile2 = muteProfile;
            if (muteProfile == null) {
                muteProfile2 = MuteProfile.getDefaultInstance();
            }
            return muteProfile2;
        }

        @Override // cn.irisgw.live.muteExtraOrBuilder
        public boolean hasMuteProfile() {
            return (this.muteProfileBuilder_ == null && this.muteProfile_ == null) ? false : true;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_muteExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(muteExtra.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(muteExtra muteextra) {
            if (muteextra == muteExtra.getDefaultInstance()) {
                return this;
            }
            if (muteextra.hasMuteProfile()) {
                mergeMuteProfile(muteextra.getMuteProfile());
            }
            m8390mergeUnknownFields(muteextra.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.muteExtra.Builder m8387mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.muteExtra.access$1600()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.muteExtra r0 = (cn.irisgw.live.muteExtra) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.muteExtra$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.muteExtra r0 = (cn.irisgw.live.muteExtra) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.muteExtra$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.muteExtra.Builder.m8387mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.muteExtra$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m8386mergeFrom(Message message) {
            if (message instanceof muteExtra) {
                return mergeFrom((muteExtra) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeMuteProfile(MuteProfile muteProfile) {
            SingleFieldBuilderV3<MuteProfile, MuteProfile.Builder, MuteProfileOrBuilder> singleFieldBuilderV3 = this.muteProfileBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.mergeFrom(muteProfile);
                return this;
            }
            MuteProfile muteProfile2 = this.muteProfile_;
            if (muteProfile2 != null) {
                this.muteProfile_ = MuteProfile.newBuilder(muteProfile2).mergeFrom(muteProfile).m8411buildPartial();
            } else {
                this.muteProfile_ = muteProfile;
            }
            onChanged();
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m8390mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        /* renamed from: setField */
        public Builder m8392setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setMuteProfile(MuteProfile.Builder builder) {
            SingleFieldBuilderV3<MuteProfile, MuteProfile.Builder, MuteProfileOrBuilder> singleFieldBuilderV3 = this.muteProfileBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(builder.m8409build());
                return this;
            }
            this.muteProfile_ = builder.m8409build();
            onChanged();
            return this;
        }

        public Builder setMuteProfile(MuteProfile muteProfile) {
            SingleFieldBuilderV3<MuteProfile, MuteProfile.Builder, MuteProfileOrBuilder> singleFieldBuilderV3 = this.muteProfileBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(muteProfile);
                return this;
            } else if (muteProfile != null) {
                this.muteProfile_ = muteProfile;
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        /* renamed from: setRepeatedField */
        public Builder m8394setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        /* renamed from: setUnknownFields */
        public final Builder m8396setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/muteExtra$MuteProfile.class */
    public static final class MuteProfile extends GeneratedMessageV3 implements MuteProfileOrBuilder {
        public static final int NAME_FIELD_NUMBER = 2;
        public static final int UID_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private volatile Object name_;
        private int uid_;
        private static final MuteProfile DEFAULT_INSTANCE = new MuteProfile();
        private static final Parser<MuteProfile> PARSER = new AbstractParser<MuteProfile>() { // from class: cn.irisgw.live.muteExtra.MuteProfile.1
            /* renamed from: parsePartialFrom */
            public MuteProfile m8405parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new MuteProfile(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/muteExtra$MuteProfile$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MuteProfileOrBuilder {
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
                return LiveConstants.internal_static_cn_irisgw_live_muteExtra_MuteProfile_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = MuteProfile.alwaysUseFieldBuilders;
            }

            /* renamed from: addRepeatedField */
            public Builder m8407addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: build */
            public MuteProfile m8409build() {
                MuteProfile m8411buildPartial = m8411buildPartial();
                if (m8411buildPartial.isInitialized()) {
                    return m8411buildPartial;
                }
                throw newUninitializedMessageException(m8411buildPartial);
            }

            /* renamed from: buildPartial */
            public MuteProfile m8411buildPartial() {
                MuteProfile muteProfile = new MuteProfile(this);
                muteProfile.uid_ = this.uid_;
                muteProfile.name_ = this.name_;
                onBuilt();
                return muteProfile;
            }

            /* renamed from: clear */
            public Builder m8415clear() {
                super.clear();
                this.uid_ = 0;
                this.name_ = "";
                return this;
            }

            /* renamed from: clearField */
            public Builder m8417clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearName() {
                this.name_ = MuteProfile.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            /* renamed from: clearOneof */
            public Builder m8420clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearUid() {
                this.uid_ = 0;
                onChanged();
                return this;
            }

            /* renamed from: clone */
            public Builder m8426clone() {
                return (Builder) super.clone();
            }

            /* renamed from: getDefaultInstanceForType */
            public MuteProfile m8428getDefaultInstanceForType() {
                return MuteProfile.getDefaultInstance();
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return LiveConstants.internal_static_cn_irisgw_live_muteExtra_MuteProfile_descriptor;
            }

            @Override // cn.irisgw.live.muteExtra.MuteProfileOrBuilder
            public String getName() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.muteExtra.MuteProfileOrBuilder
            public ByteString getNameBytes() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.name_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.muteExtra.MuteProfileOrBuilder
            public int getUid() {
                return this.uid_;
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveConstants.internal_static_cn_irisgw_live_muteExtra_MuteProfile_fieldAccessorTable.ensureFieldAccessorsInitialized(MuteProfile.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(MuteProfile muteProfile) {
                if (muteProfile == MuteProfile.getDefaultInstance()) {
                    return this;
                }
                if (muteProfile.getUid() != 0) {
                    setUid(muteProfile.getUid());
                }
                if (!muteProfile.getName().isEmpty()) {
                    this.name_ = muteProfile.name_;
                    onChanged();
                }
                m8437mergeUnknownFields(muteProfile.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            /* renamed from: mergeFrom */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.muteExtra.MuteProfile.Builder m8434mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.muteExtra.MuteProfile.access$700()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.muteExtra$MuteProfile r0 = (cn.irisgw.live.muteExtra.MuteProfile) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.muteExtra$MuteProfile$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.muteExtra$MuteProfile r0 = (cn.irisgw.live.muteExtra.MuteProfile) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.muteExtra$MuteProfile$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.muteExtra.MuteProfile.Builder.m8434mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.muteExtra$MuteProfile$Builder");
            }

            /* renamed from: mergeFrom */
            public Builder m8433mergeFrom(Message message) {
                if (message instanceof MuteProfile) {
                    return mergeFrom((MuteProfile) message);
                }
                super.mergeFrom(message);
                return this;
            }

            /* renamed from: mergeUnknownFields */
            public final Builder m8437mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            /* renamed from: setField */
            public Builder m8439setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
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
                    MuteProfile.checkByteStringIsUtf8(byteString);
                    this.name_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            /* renamed from: setRepeatedField */
            public Builder m8441setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setUid(int i) {
                this.uid_ = i;
                onChanged();
                return this;
            }

            /* renamed from: setUnknownFields */
            public final Builder m8443setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private MuteProfile() {
            this.memoizedIsInitialized = (byte) -1;
            this.name_ = "";
        }

        private MuteProfile(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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

        private MuteProfile(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static MuteProfile getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_muteExtra_MuteProfile_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m8404toBuilder();
        }

        public static Builder newBuilder(MuteProfile muteProfile) {
            return DEFAULT_INSTANCE.m8404toBuilder().mergeFrom(muteProfile);
        }

        public static MuteProfile parseDelimitedFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static MuteProfile parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static MuteProfile parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (MuteProfile) PARSER.parseFrom(byteString);
        }

        public static MuteProfile parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MuteProfile) PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static MuteProfile parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static MuteProfile parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static MuteProfile parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static MuteProfile parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static MuteProfile parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (MuteProfile) PARSER.parseFrom(byteBuffer);
        }

        public static MuteProfile parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MuteProfile) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static MuteProfile parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (MuteProfile) PARSER.parseFrom(bArr);
        }

        public static MuteProfile parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MuteProfile) PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<MuteProfile> parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof MuteProfile) {
                MuteProfile muteProfile = (MuteProfile) obj;
                return getUid() == muteProfile.getUid() && getName().equals(muteProfile.getName()) && this.unknownFields.equals(muteProfile.unknownFields);
            }
            return super.equals(obj);
        }

        /* renamed from: getDefaultInstanceForType */
        public MuteProfile m8399getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // cn.irisgw.live.muteExtra.MuteProfileOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.muteExtra.MuteProfileOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Parser<MuteProfile> getParserForType() {
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

        @Override // cn.irisgw.live.muteExtra.MuteProfileOrBuilder
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
            return LiveConstants.internal_static_cn_irisgw_live_muteExtra_MuteProfile_fieldAccessorTable.ensureFieldAccessorsInitialized(MuteProfile.class, Builder.class);
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
        public Builder m8402newBuilderForType() {
            return newBuilder();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: newBuilderForType */
        public Builder m8401newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new MuteProfile();
        }

        /* renamed from: toBuilder */
        public Builder m8404toBuilder() {
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

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/muteExtra$MuteProfileOrBuilder.class */
    public interface MuteProfileOrBuilder extends MessageOrBuilder {
        String getName();

        ByteString getNameBytes();

        int getUid();
    }

    private muteExtra() {
        this.memoizedIsInitialized = (byte) -1;
    }

    private muteExtra(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                MuteProfile.Builder m8404toBuilder = this.muteProfile_ != null ? this.muteProfile_.m8404toBuilder() : null;
                                MuteProfile readMessage = codedInputStream.readMessage(MuteProfile.parser(), extensionRegistryLite);
                                this.muteProfile_ = readMessage;
                                if (m8404toBuilder != null) {
                                    m8404toBuilder.mergeFrom(readMessage);
                                    this.muteProfile_ = m8404toBuilder.m8411buildPartial();
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

    private muteExtra(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static muteExtra getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_muteExtra_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m8357toBuilder();
    }

    public static Builder newBuilder(muteExtra muteextra) {
        return DEFAULT_INSTANCE.m8357toBuilder().mergeFrom(muteextra);
    }

    public static muteExtra parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static muteExtra parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static muteExtra parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (muteExtra) PARSER.parseFrom(byteString);
    }

    public static muteExtra parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (muteExtra) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static muteExtra parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static muteExtra parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static muteExtra parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static muteExtra parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static muteExtra parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (muteExtra) PARSER.parseFrom(byteBuffer);
    }

    public static muteExtra parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (muteExtra) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static muteExtra parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (muteExtra) PARSER.parseFrom(bArr);
    }

    public static muteExtra parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (muteExtra) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<muteExtra> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof muteExtra) {
            muteExtra muteextra = (muteExtra) obj;
            if (hasMuteProfile() != muteextra.hasMuteProfile()) {
                return false;
            }
            return (!hasMuteProfile() || getMuteProfile().equals(muteextra.getMuteProfile())) && this.unknownFields.equals(muteextra.unknownFields);
        }
        return super.equals(obj);
    }

    /* renamed from: getDefaultInstanceForType */
    public muteExtra m8352getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.muteExtraOrBuilder
    public MuteProfile getMuteProfile() {
        MuteProfile muteProfile = this.muteProfile_;
        MuteProfile muteProfile2 = muteProfile;
        if (muteProfile == null) {
            muteProfile2 = MuteProfile.getDefaultInstance();
        }
        return muteProfile2;
    }

    @Override // cn.irisgw.live.muteExtraOrBuilder
    public MuteProfileOrBuilder getMuteProfileOrBuilder() {
        return getMuteProfile();
    }

    public Parser<muteExtra> getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.muteProfile_ != null) {
            i2 = 0 + CodedOutputStream.computeMessageSize(1, getMuteProfile());
        }
        int serializedSize = i2 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // cn.irisgw.live.muteExtraOrBuilder
    public boolean hasMuteProfile() {
        return this.muteProfile_ != null;
    }

    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = 779 + getDescriptor().hashCode();
        int i = hashCode;
        if (hasMuteProfile()) {
            i = (((hashCode * 37) + 1) * 53) + getMuteProfile().hashCode();
        }
        int hashCode2 = (i * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_muteExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(muteExtra.class, Builder.class);
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
    public Builder m8355newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m8354newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new muteExtra();
    }

    /* renamed from: toBuilder */
    public Builder m8357toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (this.muteProfile_ != null) {
            codedOutputStream.writeMessage(1, getMuteProfile());
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
