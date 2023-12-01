package cn.irisgw.live;

import com.google.protobuf.AbstractMessageLite;
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
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/BoxGiftExtra.class */
public final class BoxGiftExtra extends GeneratedMessageV3 implements BoxGiftExtraOrBuilder {
    public static final int BONUS_FIELD_NUMBER = 1;
    private static final BoxGiftExtra DEFAULT_INSTANCE = new BoxGiftExtra();
    private static final Parser<BoxGiftExtra> PARSER = new AbstractParser<BoxGiftExtra>() { // from class: cn.irisgw.live.BoxGiftExtra.1
        /* renamed from: parsePartialFrom */
        public BoxGiftExtra m719parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new BoxGiftExtra(codedInputStream, extensionRegistryLite);
        }
    };
    private static final long serialVersionUID = 0;
    private List<Bonus> bonus_;
    private byte memoizedIsInitialized;

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/BoxGiftExtra$Bonus.class */
    public static final class Bonus extends GeneratedMessageV3 implements BonusOrBuilder {
        public static final int COUNT_FIELD_NUMBER = 3;
        public static final int ID_FIELD_NUMBER = 1;
        public static final int IMAGE_FIELD_NUMBER = 2;
        public static final int PROFILE_FIELD_NUMBER = 4;
        private static final long serialVersionUID = 0;
        private long count_;
        private volatile Object id_;
        private volatile Object image_;
        private byte memoizedIsInitialized;
        private WinnerProfile profile_;
        private static final Bonus DEFAULT_INSTANCE = new Bonus();
        private static final Parser<Bonus> PARSER = new AbstractParser<Bonus>() { // from class: cn.irisgw.live.BoxGiftExtra.Bonus.1
            /* renamed from: parsePartialFrom */
            public Bonus m728parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Bonus(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/BoxGiftExtra$Bonus$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BonusOrBuilder {
            private long count_;
            private Object id_;
            private Object image_;
            private SingleFieldBuilderV3<WinnerProfile, WinnerProfile.Builder, WinnerProfileOrBuilder> profileBuilder_;
            private WinnerProfile profile_;

            private Builder() {
                this.id_ = "";
                this.image_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.id_ = "";
                this.image_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LiveConstants.internal_static_cn_irisgw_live_BoxGiftExtra_Bonus_descriptor;
            }

            private SingleFieldBuilderV3<WinnerProfile, WinnerProfile.Builder, WinnerProfileOrBuilder> getProfileFieldBuilder() {
                if (this.profileBuilder_ == null) {
                    this.profileBuilder_ = new SingleFieldBuilderV3<>(getProfile(), getParentForChildren(), isClean());
                    this.profile_ = null;
                }
                return this.profileBuilder_;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = Bonus.alwaysUseFieldBuilders;
            }

            /* renamed from: addRepeatedField */
            public Builder m730addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: build */
            public Bonus m732build() {
                Bonus m734buildPartial = m734buildPartial();
                if (m734buildPartial.isInitialized()) {
                    return m734buildPartial;
                }
                throw newUninitializedMessageException(m734buildPartial);
            }

            /* renamed from: buildPartial */
            public Bonus m734buildPartial() {
                Bonus bonus = new Bonus(this);
                bonus.id_ = this.id_;
                bonus.image_ = this.image_;
                bonus.count_ = this.count_;
                SingleFieldBuilderV3<WinnerProfile, WinnerProfile.Builder, WinnerProfileOrBuilder> singleFieldBuilderV3 = this.profileBuilder_;
                if (singleFieldBuilderV3 == null) {
                    bonus.profile_ = this.profile_;
                } else {
                    bonus.profile_ = singleFieldBuilderV3.build();
                }
                onBuilt();
                return bonus;
            }

            /* renamed from: clear */
            public Builder m738clear() {
                super.clear();
                this.id_ = "";
                this.image_ = "";
                this.count_ = Bonus.serialVersionUID;
                if (this.profileBuilder_ == null) {
                    this.profile_ = null;
                    return this;
                }
                this.profile_ = null;
                this.profileBuilder_ = null;
                return this;
            }

            public Builder clearCount() {
                this.count_ = Bonus.serialVersionUID;
                onChanged();
                return this;
            }

            /* renamed from: clearField */
            public Builder m740clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearId() {
                this.id_ = Bonus.getDefaultInstance().getId();
                onChanged();
                return this;
            }

            public Builder clearImage() {
                this.image_ = Bonus.getDefaultInstance().getImage();
                onChanged();
                return this;
            }

            /* renamed from: clearOneof */
            public Builder m743clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearProfile() {
                if (this.profileBuilder_ == null) {
                    this.profile_ = null;
                    onChanged();
                    return this;
                }
                this.profile_ = null;
                this.profileBuilder_ = null;
                return this;
            }

            /* renamed from: clone */
            public Builder m749clone() {
                return (Builder) super.clone();
            }

            @Override // cn.irisgw.live.BoxGiftExtra.BonusOrBuilder
            public long getCount() {
                return this.count_;
            }

            /* renamed from: getDefaultInstanceForType */
            public Bonus m751getDefaultInstanceForType() {
                return Bonus.getDefaultInstance();
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return LiveConstants.internal_static_cn_irisgw_live_BoxGiftExtra_Bonus_descriptor;
            }

            @Override // cn.irisgw.live.BoxGiftExtra.BonusOrBuilder
            public String getId() {
                Object obj = this.id_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.id_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.BoxGiftExtra.BonusOrBuilder
            public ByteString getIdBytes() {
                Object obj = this.id_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.id_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.BoxGiftExtra.BonusOrBuilder
            public String getImage() {
                Object obj = this.image_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.image_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.BoxGiftExtra.BonusOrBuilder
            public ByteString getImageBytes() {
                Object obj = this.image_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.image_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.BoxGiftExtra.BonusOrBuilder
            public WinnerProfile getProfile() {
                SingleFieldBuilderV3<WinnerProfile, WinnerProfile.Builder, WinnerProfileOrBuilder> singleFieldBuilderV3 = this.profileBuilder_;
                if (singleFieldBuilderV3 == null) {
                    WinnerProfile winnerProfile = this.profile_;
                    WinnerProfile winnerProfile2 = winnerProfile;
                    if (winnerProfile == null) {
                        winnerProfile2 = WinnerProfile.getDefaultInstance();
                    }
                    return winnerProfile2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public WinnerProfile.Builder getProfileBuilder() {
                onChanged();
                return getProfileFieldBuilder().getBuilder();
            }

            @Override // cn.irisgw.live.BoxGiftExtra.BonusOrBuilder
            public WinnerProfileOrBuilder getProfileOrBuilder() {
                SingleFieldBuilderV3<WinnerProfile, WinnerProfile.Builder, WinnerProfileOrBuilder> singleFieldBuilderV3 = this.profileBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return (WinnerProfileOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
                }
                WinnerProfile winnerProfile = this.profile_;
                WinnerProfile winnerProfile2 = winnerProfile;
                if (winnerProfile == null) {
                    winnerProfile2 = WinnerProfile.getDefaultInstance();
                }
                return winnerProfile2;
            }

            @Override // cn.irisgw.live.BoxGiftExtra.BonusOrBuilder
            public boolean hasProfile() {
                return (this.profileBuilder_ == null && this.profile_ == null) ? false : true;
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveConstants.internal_static_cn_irisgw_live_BoxGiftExtra_Bonus_fieldAccessorTable.ensureFieldAccessorsInitialized(Bonus.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(Bonus bonus) {
                if (bonus == Bonus.getDefaultInstance()) {
                    return this;
                }
                if (!bonus.getId().isEmpty()) {
                    this.id_ = bonus.id_;
                    onChanged();
                }
                if (!bonus.getImage().isEmpty()) {
                    this.image_ = bonus.image_;
                    onChanged();
                }
                if (bonus.getCount() != Bonus.serialVersionUID) {
                    setCount(bonus.getCount());
                }
                if (bonus.hasProfile()) {
                    mergeProfile(bonus.getProfile());
                }
                m760mergeUnknownFields(bonus.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            /* renamed from: mergeFrom */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.BoxGiftExtra.Bonus.Builder m757mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.BoxGiftExtra.Bonus.access$1900()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.BoxGiftExtra$Bonus r0 = (cn.irisgw.live.BoxGiftExtra.Bonus) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.BoxGiftExtra$Bonus$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.BoxGiftExtra$Bonus r0 = (cn.irisgw.live.BoxGiftExtra.Bonus) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.BoxGiftExtra$Bonus$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.BoxGiftExtra.Bonus.Builder.m757mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.BoxGiftExtra$Bonus$Builder");
            }

            /* renamed from: mergeFrom */
            public Builder m756mergeFrom(Message message) {
                if (message instanceof Bonus) {
                    return mergeFrom((Bonus) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeProfile(WinnerProfile winnerProfile) {
                SingleFieldBuilderV3<WinnerProfile, WinnerProfile.Builder, WinnerProfileOrBuilder> singleFieldBuilderV3 = this.profileBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(winnerProfile);
                    return this;
                }
                WinnerProfile winnerProfile2 = this.profile_;
                if (winnerProfile2 != null) {
                    this.profile_ = WinnerProfile.newBuilder(winnerProfile2).mergeFrom(winnerProfile).m819buildPartial();
                } else {
                    this.profile_ = winnerProfile;
                }
                onChanged();
                return this;
            }

            /* renamed from: mergeUnknownFields */
            public final Builder m760mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder setCount(long j) {
                this.count_ = j;
                onChanged();
                return this;
            }

            /* renamed from: setField */
            public Builder m762setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setId(String str) {
                if (str != null) {
                    this.id_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setIdBytes(ByteString byteString) {
                if (byteString != null) {
                    Bonus.checkByteStringIsUtf8(byteString);
                    this.id_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setImage(String str) {
                if (str != null) {
                    this.image_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setImageBytes(ByteString byteString) {
                if (byteString != null) {
                    Bonus.checkByteStringIsUtf8(byteString);
                    this.image_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setProfile(WinnerProfile.Builder builder) {
                SingleFieldBuilderV3<WinnerProfile, WinnerProfile.Builder, WinnerProfileOrBuilder> singleFieldBuilderV3 = this.profileBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.m817build());
                    return this;
                }
                this.profile_ = builder.m817build();
                onChanged();
                return this;
            }

            public Builder setProfile(WinnerProfile winnerProfile) {
                SingleFieldBuilderV3<WinnerProfile, WinnerProfile.Builder, WinnerProfileOrBuilder> singleFieldBuilderV3 = this.profileBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(winnerProfile);
                    return this;
                } else if (winnerProfile != null) {
                    this.profile_ = winnerProfile;
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }

            /* renamed from: setRepeatedField */
            public Builder m764setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            /* renamed from: setUnknownFields */
            public final Builder m766setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private Bonus() {
            this.memoizedIsInitialized = (byte) -1;
            this.id_ = "";
            this.image_ = "";
        }

        private Bonus(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.id_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                this.image_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 24) {
                                this.count_ = codedInputStream.readUInt64();
                            } else if (readTag == 34) {
                                WinnerProfile.Builder m812toBuilder = this.profile_ != null ? this.profile_.m812toBuilder() : null;
                                WinnerProfile readMessage = codedInputStream.readMessage(WinnerProfile.parser(), extensionRegistryLite);
                                this.profile_ = readMessage;
                                if (m812toBuilder != null) {
                                    m812toBuilder.mergeFrom(readMessage);
                                    this.profile_ = m812toBuilder.m819buildPartial();
                                }
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

        private Bonus(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Bonus getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_BoxGiftExtra_Bonus_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m727toBuilder();
        }

        public static Builder newBuilder(Bonus bonus) {
            return DEFAULT_INSTANCE.m727toBuilder().mergeFrom(bonus);
        }

        public static Bonus parseDelimitedFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Bonus parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Bonus parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Bonus) PARSER.parseFrom(byteString);
        }

        public static Bonus parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Bonus) PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Bonus parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Bonus parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static Bonus parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Bonus parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Bonus parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Bonus) PARSER.parseFrom(byteBuffer);
        }

        public static Bonus parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Bonus) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Bonus parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Bonus) PARSER.parseFrom(bArr);
        }

        public static Bonus parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Bonus) PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<Bonus> parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Bonus) {
                Bonus bonus = (Bonus) obj;
                if (getId().equals(bonus.getId()) && getImage().equals(bonus.getImage()) && getCount() == bonus.getCount() && hasProfile() == bonus.hasProfile()) {
                    return (!hasProfile() || getProfile().equals(bonus.getProfile())) && this.unknownFields.equals(bonus.unknownFields);
                }
                return false;
            }
            return super.equals(obj);
        }

        @Override // cn.irisgw.live.BoxGiftExtra.BonusOrBuilder
        public long getCount() {
            return this.count_;
        }

        /* renamed from: getDefaultInstanceForType */
        public Bonus m722getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // cn.irisgw.live.BoxGiftExtra.BonusOrBuilder
        public String getId() {
            Object obj = this.id_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.id_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.BoxGiftExtra.BonusOrBuilder
        public ByteString getIdBytes() {
            Object obj = this.id_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.id_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.BoxGiftExtra.BonusOrBuilder
        public String getImage() {
            Object obj = this.image_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.image_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.BoxGiftExtra.BonusOrBuilder
        public ByteString getImageBytes() {
            Object obj = this.image_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.image_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Parser<Bonus> getParserForType() {
            return PARSER;
        }

        @Override // cn.irisgw.live.BoxGiftExtra.BonusOrBuilder
        public WinnerProfile getProfile() {
            WinnerProfile winnerProfile = this.profile_;
            WinnerProfile winnerProfile2 = winnerProfile;
            if (winnerProfile == null) {
                winnerProfile2 = WinnerProfile.getDefaultInstance();
            }
            return winnerProfile2;
        }

        @Override // cn.irisgw.live.BoxGiftExtra.BonusOrBuilder
        public WinnerProfileOrBuilder getProfileOrBuilder() {
            return getProfile();
        }

        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (!getIdBytes().isEmpty()) {
                i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.id_);
            }
            int i3 = i2;
            if (!getImageBytes().isEmpty()) {
                i3 = i2 + GeneratedMessageV3.computeStringSize(2, this.image_);
            }
            long j = this.count_;
            int i4 = i3;
            if (j != serialVersionUID) {
                i4 = i3 + CodedOutputStream.computeUInt64Size(3, j);
            }
            int i5 = i4;
            if (this.profile_ != null) {
                i5 = i4 + CodedOutputStream.computeMessageSize(4, getProfile());
            }
            int serializedSize = i5 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // cn.irisgw.live.BoxGiftExtra.BonusOrBuilder
        public boolean hasProfile() {
            return this.profile_ != null;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getId().hashCode()) * 37) + 2) * 53) + getImage().hashCode()) * 37) + 3) * 53) + Internal.hashLong(getCount());
            int i = hashCode;
            if (hasProfile()) {
                i = (((hashCode * 37) + 4) * 53) + getProfile().hashCode();
            }
            int hashCode2 = (i * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_BoxGiftExtra_Bonus_fieldAccessorTable.ensureFieldAccessorsInitialized(Bonus.class, Builder.class);
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
        public Builder m725newBuilderForType() {
            return newBuilder();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: newBuilderForType */
        public Builder m724newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new Bonus();
        }

        /* renamed from: toBuilder */
        public Builder m727toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!getIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.id_);
            }
            if (!getImageBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.image_);
            }
            long j = this.count_;
            if (j != serialVersionUID) {
                codedOutputStream.writeUInt64(3, j);
            }
            if (this.profile_ != null) {
                codedOutputStream.writeMessage(4, getProfile());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/BoxGiftExtra$BonusOrBuilder.class */
    public interface BonusOrBuilder extends MessageOrBuilder {
        long getCount();

        String getId();

        ByteString getIdBytes();

        String getImage();

        ByteString getImageBytes();

        WinnerProfile getProfile();

        WinnerProfileOrBuilder getProfileOrBuilder();

        boolean hasProfile();
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/BoxGiftExtra$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BoxGiftExtraOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilderV3<Bonus, Bonus.Builder, BonusOrBuilder> bonusBuilder_;
        private List<Bonus> bonus_;

        private Builder() {
            this.bonus_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.bonus_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private void ensureBonusIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.bonus_ = new ArrayList(this.bonus_);
                this.bitField0_ |= 1;
            }
        }

        private RepeatedFieldBuilderV3<Bonus, Bonus.Builder, BonusOrBuilder> getBonusFieldBuilder() {
            if (this.bonusBuilder_ == null) {
                List<Bonus> list = this.bonus_;
                boolean z = true;
                if ((this.bitField0_ & 1) == 0) {
                    z = false;
                }
                this.bonusBuilder_ = new RepeatedFieldBuilderV3<>(list, z, getParentForChildren(), isClean());
                this.bonus_ = null;
            }
            return this.bonusBuilder_;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_BoxGiftExtra_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            if (BoxGiftExtra.alwaysUseFieldBuilders) {
                getBonusFieldBuilder();
            }
        }

        public Builder addAllBonus(Iterable<? extends Bonus> iterable) {
            RepeatedFieldBuilderV3<Bonus, Bonus.Builder, BonusOrBuilder> repeatedFieldBuilderV3 = this.bonusBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensureBonusIsMutable();
            AbstractMessageLite.Builder.addAll(iterable, this.bonus_);
            onChanged();
            return this;
        }

        public Builder addBonus(int i, Bonus.Builder builder) {
            RepeatedFieldBuilderV3<Bonus, Bonus.Builder, BonusOrBuilder> repeatedFieldBuilderV3 = this.bonusBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.m732build());
                return this;
            }
            ensureBonusIsMutable();
            this.bonus_.add(i, builder.m732build());
            onChanged();
            return this;
        }

        public Builder addBonus(int i, Bonus bonus) {
            RepeatedFieldBuilderV3<Bonus, Bonus.Builder, BonusOrBuilder> repeatedFieldBuilderV3 = this.bonusBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, bonus);
                return this;
            } else if (bonus != null) {
                ensureBonusIsMutable();
                this.bonus_.add(i, bonus);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addBonus(Bonus.Builder builder) {
            RepeatedFieldBuilderV3<Bonus, Bonus.Builder, BonusOrBuilder> repeatedFieldBuilderV3 = this.bonusBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(builder.m732build());
                return this;
            }
            ensureBonusIsMutable();
            this.bonus_.add(builder.m732build());
            onChanged();
            return this;
        }

        public Builder addBonus(Bonus bonus) {
            RepeatedFieldBuilderV3<Bonus, Bonus.Builder, BonusOrBuilder> repeatedFieldBuilderV3 = this.bonusBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(bonus);
                return this;
            } else if (bonus != null) {
                ensureBonusIsMutable();
                this.bonus_.add(bonus);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Bonus.Builder addBonusBuilder() {
            return getBonusFieldBuilder().addBuilder(Bonus.getDefaultInstance());
        }

        public Bonus.Builder addBonusBuilder(int i) {
            return getBonusFieldBuilder().addBuilder(i, Bonus.getDefaultInstance());
        }

        /* renamed from: addRepeatedField */
        public Builder m768addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public BoxGiftExtra m770build() {
            BoxGiftExtra m772buildPartial = m772buildPartial();
            if (m772buildPartial.isInitialized()) {
                return m772buildPartial;
            }
            throw newUninitializedMessageException(m772buildPartial);
        }

        /* renamed from: buildPartial */
        public BoxGiftExtra m772buildPartial() {
            BoxGiftExtra boxGiftExtra = new BoxGiftExtra(this);
            int i = this.bitField0_;
            RepeatedFieldBuilderV3<Bonus, Bonus.Builder, BonusOrBuilder> repeatedFieldBuilderV3 = this.bonusBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((i & 1) != 0) {
                    this.bonus_ = Collections.unmodifiableList(this.bonus_);
                    this.bitField0_ &= -2;
                }
                boxGiftExtra.bonus_ = this.bonus_;
            } else {
                boxGiftExtra.bonus_ = repeatedFieldBuilderV3.build();
            }
            onBuilt();
            return boxGiftExtra;
        }

        /* renamed from: clear */
        public Builder m776clear() {
            super.clear();
            RepeatedFieldBuilderV3<Bonus, Bonus.Builder, BonusOrBuilder> repeatedFieldBuilderV3 = this.bonusBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.bonus_ = Collections.emptyList();
            this.bitField0_ &= -2;
            return this;
        }

        public Builder clearBonus() {
            RepeatedFieldBuilderV3<Bonus, Bonus.Builder, BonusOrBuilder> repeatedFieldBuilderV3 = this.bonusBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.bonus_ = Collections.emptyList();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        /* renamed from: clearField */
        public Builder m778clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        /* renamed from: clearOneof */
        public Builder m781clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        /* renamed from: clone */
        public Builder m787clone() {
            return (Builder) super.clone();
        }

        @Override // cn.irisgw.live.BoxGiftExtraOrBuilder
        public Bonus getBonus(int i) {
            RepeatedFieldBuilderV3<Bonus, Bonus.Builder, BonusOrBuilder> repeatedFieldBuilderV3 = this.bonusBuilder_;
            return repeatedFieldBuilderV3 == null ? this.bonus_.get(i) : repeatedFieldBuilderV3.getMessage(i);
        }

        public Bonus.Builder getBonusBuilder(int i) {
            return getBonusFieldBuilder().getBuilder(i);
        }

        public List<Bonus.Builder> getBonusBuilderList() {
            return getBonusFieldBuilder().getBuilderList();
        }

        @Override // cn.irisgw.live.BoxGiftExtraOrBuilder
        public int getBonusCount() {
            RepeatedFieldBuilderV3<Bonus, Bonus.Builder, BonusOrBuilder> repeatedFieldBuilderV3 = this.bonusBuilder_;
            return repeatedFieldBuilderV3 == null ? this.bonus_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // cn.irisgw.live.BoxGiftExtraOrBuilder
        public List<Bonus> getBonusList() {
            RepeatedFieldBuilderV3<Bonus, Bonus.Builder, BonusOrBuilder> repeatedFieldBuilderV3 = this.bonusBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.bonus_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // cn.irisgw.live.BoxGiftExtraOrBuilder
        public BonusOrBuilder getBonusOrBuilder(int i) {
            RepeatedFieldBuilderV3<Bonus, Bonus.Builder, BonusOrBuilder> repeatedFieldBuilderV3 = this.bonusBuilder_;
            return repeatedFieldBuilderV3 == null ? this.bonus_.get(i) : (BonusOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // cn.irisgw.live.BoxGiftExtraOrBuilder
        public List<? extends BonusOrBuilder> getBonusOrBuilderList() {
            RepeatedFieldBuilderV3<Bonus, Bonus.Builder, BonusOrBuilder> repeatedFieldBuilderV3 = this.bonusBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.bonus_);
        }

        /* renamed from: getDefaultInstanceForType */
        public BoxGiftExtra m789getDefaultInstanceForType() {
            return BoxGiftExtra.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_BoxGiftExtra_descriptor;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_BoxGiftExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(BoxGiftExtra.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(BoxGiftExtra boxGiftExtra) {
            if (boxGiftExtra == BoxGiftExtra.getDefaultInstance()) {
                return this;
            }
            if (this.bonusBuilder_ == null) {
                if (!boxGiftExtra.bonus_.isEmpty()) {
                    if (this.bonus_.isEmpty()) {
                        this.bonus_ = boxGiftExtra.bonus_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureBonusIsMutable();
                        this.bonus_.addAll(boxGiftExtra.bonus_);
                    }
                    onChanged();
                }
            } else if (!boxGiftExtra.bonus_.isEmpty()) {
                if (this.bonusBuilder_.isEmpty()) {
                    this.bonusBuilder_.dispose();
                    RepeatedFieldBuilderV3<Bonus, Bonus.Builder, BonusOrBuilder> repeatedFieldBuilderV3 = null;
                    this.bonusBuilder_ = null;
                    this.bonus_ = boxGiftExtra.bonus_;
                    this.bitField0_ &= -2;
                    if (BoxGiftExtra.alwaysUseFieldBuilders) {
                        repeatedFieldBuilderV3 = getBonusFieldBuilder();
                    }
                    this.bonusBuilder_ = repeatedFieldBuilderV3;
                } else {
                    this.bonusBuilder_.addAllMessages(boxGiftExtra.bonus_);
                }
            }
            m798mergeUnknownFields(boxGiftExtra.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.BoxGiftExtra.Builder m795mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.BoxGiftExtra.access$3000()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.BoxGiftExtra r0 = (cn.irisgw.live.BoxGiftExtra) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.BoxGiftExtra$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.BoxGiftExtra r0 = (cn.irisgw.live.BoxGiftExtra) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.BoxGiftExtra$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.BoxGiftExtra.Builder.m795mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.BoxGiftExtra$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m794mergeFrom(Message message) {
            if (message instanceof BoxGiftExtra) {
                return mergeFrom((BoxGiftExtra) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m798mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder removeBonus(int i) {
            RepeatedFieldBuilderV3<Bonus, Bonus.Builder, BonusOrBuilder> repeatedFieldBuilderV3 = this.bonusBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.remove(i);
                return this;
            }
            ensureBonusIsMutable();
            this.bonus_.remove(i);
            onChanged();
            return this;
        }

        public Builder setBonus(int i, Bonus.Builder builder) {
            RepeatedFieldBuilderV3<Bonus, Bonus.Builder, BonusOrBuilder> repeatedFieldBuilderV3 = this.bonusBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.m732build());
                return this;
            }
            ensureBonusIsMutable();
            this.bonus_.set(i, builder.m732build());
            onChanged();
            return this;
        }

        public Builder setBonus(int i, Bonus bonus) {
            RepeatedFieldBuilderV3<Bonus, Bonus.Builder, BonusOrBuilder> repeatedFieldBuilderV3 = this.bonusBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, bonus);
                return this;
            } else if (bonus != null) {
                ensureBonusIsMutable();
                this.bonus_.set(i, bonus);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        /* renamed from: setField */
        public Builder m800setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        /* renamed from: setRepeatedField */
        public Builder m802setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        /* renamed from: setUnknownFields */
        public final Builder m804setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/BoxGiftExtra$WinnerProfile.class */
    public static final class WinnerProfile extends GeneratedMessageV3 implements WinnerProfileOrBuilder {
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int UID_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private volatile Object name_;
        private int uid_;
        private static final WinnerProfile DEFAULT_INSTANCE = new WinnerProfile();
        private static final Parser<WinnerProfile> PARSER = new AbstractParser<WinnerProfile>() { // from class: cn.irisgw.live.BoxGiftExtra.WinnerProfile.1
            /* renamed from: parsePartialFrom */
            public WinnerProfile m813parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new WinnerProfile(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/BoxGiftExtra$WinnerProfile$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WinnerProfileOrBuilder {
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
                return LiveConstants.internal_static_cn_irisgw_live_BoxGiftExtra_WinnerProfile_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = WinnerProfile.alwaysUseFieldBuilders;
            }

            /* renamed from: addRepeatedField */
            public Builder m815addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: build */
            public WinnerProfile m817build() {
                WinnerProfile m819buildPartial = m819buildPartial();
                if (m819buildPartial.isInitialized()) {
                    return m819buildPartial;
                }
                throw newUninitializedMessageException(m819buildPartial);
            }

            /* renamed from: buildPartial */
            public WinnerProfile m819buildPartial() {
                WinnerProfile winnerProfile = new WinnerProfile(this);
                winnerProfile.name_ = this.name_;
                winnerProfile.uid_ = this.uid_;
                onBuilt();
                return winnerProfile;
            }

            /* renamed from: clear */
            public Builder m823clear() {
                super.clear();
                this.name_ = "";
                this.uid_ = 0;
                return this;
            }

            /* renamed from: clearField */
            public Builder m825clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearName() {
                this.name_ = WinnerProfile.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            /* renamed from: clearOneof */
            public Builder m828clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearUid() {
                this.uid_ = 0;
                onChanged();
                return this;
            }

            /* renamed from: clone */
            public Builder m834clone() {
                return (Builder) super.clone();
            }

            /* renamed from: getDefaultInstanceForType */
            public WinnerProfile m836getDefaultInstanceForType() {
                return WinnerProfile.getDefaultInstance();
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return LiveConstants.internal_static_cn_irisgw_live_BoxGiftExtra_WinnerProfile_descriptor;
            }

            @Override // cn.irisgw.live.BoxGiftExtra.WinnerProfileOrBuilder
            public String getName() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.BoxGiftExtra.WinnerProfileOrBuilder
            public ByteString getNameBytes() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.name_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.BoxGiftExtra.WinnerProfileOrBuilder
            public int getUid() {
                return this.uid_;
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveConstants.internal_static_cn_irisgw_live_BoxGiftExtra_WinnerProfile_fieldAccessorTable.ensureFieldAccessorsInitialized(WinnerProfile.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(WinnerProfile winnerProfile) {
                if (winnerProfile == WinnerProfile.getDefaultInstance()) {
                    return this;
                }
                if (!winnerProfile.getName().isEmpty()) {
                    this.name_ = winnerProfile.name_;
                    onChanged();
                }
                if (winnerProfile.getUid() != 0) {
                    setUid(winnerProfile.getUid());
                }
                m845mergeUnknownFields(winnerProfile.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            /* renamed from: mergeFrom */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.BoxGiftExtra.WinnerProfile.Builder m842mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.BoxGiftExtra.WinnerProfile.access$700()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.BoxGiftExtra$WinnerProfile r0 = (cn.irisgw.live.BoxGiftExtra.WinnerProfile) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.BoxGiftExtra$WinnerProfile$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.BoxGiftExtra$WinnerProfile r0 = (cn.irisgw.live.BoxGiftExtra.WinnerProfile) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.BoxGiftExtra$WinnerProfile$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.BoxGiftExtra.WinnerProfile.Builder.m842mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.BoxGiftExtra$WinnerProfile$Builder");
            }

            /* renamed from: mergeFrom */
            public Builder m841mergeFrom(Message message) {
                if (message instanceof WinnerProfile) {
                    return mergeFrom((WinnerProfile) message);
                }
                super.mergeFrom(message);
                return this;
            }

            /* renamed from: mergeUnknownFields */
            public final Builder m845mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            /* renamed from: setField */
            public Builder m847setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
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
                    WinnerProfile.checkByteStringIsUtf8(byteString);
                    this.name_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            /* renamed from: setRepeatedField */
            public Builder m849setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setUid(int i) {
                this.uid_ = i;
                onChanged();
                return this;
            }

            /* renamed from: setUnknownFields */
            public final Builder m851setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private WinnerProfile() {
            this.memoizedIsInitialized = (byte) -1;
            this.name_ = "";
        }

        private WinnerProfile(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.name_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 16) {
                                    this.uid_ = codedInputStream.readUInt32();
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

        private WinnerProfile(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static WinnerProfile getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_BoxGiftExtra_WinnerProfile_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m812toBuilder();
        }

        public static Builder newBuilder(WinnerProfile winnerProfile) {
            return DEFAULT_INSTANCE.m812toBuilder().mergeFrom(winnerProfile);
        }

        public static WinnerProfile parseDelimitedFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static WinnerProfile parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static WinnerProfile parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (WinnerProfile) PARSER.parseFrom(byteString);
        }

        public static WinnerProfile parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (WinnerProfile) PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static WinnerProfile parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static WinnerProfile parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static WinnerProfile parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static WinnerProfile parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static WinnerProfile parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (WinnerProfile) PARSER.parseFrom(byteBuffer);
        }

        public static WinnerProfile parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (WinnerProfile) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static WinnerProfile parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (WinnerProfile) PARSER.parseFrom(bArr);
        }

        public static WinnerProfile parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (WinnerProfile) PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<WinnerProfile> parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof WinnerProfile) {
                WinnerProfile winnerProfile = (WinnerProfile) obj;
                return getName().equals(winnerProfile.getName()) && getUid() == winnerProfile.getUid() && this.unknownFields.equals(winnerProfile.unknownFields);
            }
            return super.equals(obj);
        }

        /* renamed from: getDefaultInstanceForType */
        public WinnerProfile m807getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // cn.irisgw.live.BoxGiftExtra.WinnerProfileOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.BoxGiftExtra.WinnerProfileOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Parser<WinnerProfile> getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (!getNameBytes().isEmpty()) {
                i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.name_);
            }
            int i3 = this.uid_;
            int i4 = i2;
            if (i3 != 0) {
                i4 = i2 + CodedOutputStream.computeUInt32Size(2, i3);
            }
            int serializedSize = i4 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // cn.irisgw.live.BoxGiftExtra.WinnerProfileOrBuilder
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
            int hashCode = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getName().hashCode()) * 37) + 2) * 53) + getUid()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_BoxGiftExtra_WinnerProfile_fieldAccessorTable.ensureFieldAccessorsInitialized(WinnerProfile.class, Builder.class);
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
        public Builder m810newBuilderForType() {
            return newBuilder();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: newBuilderForType */
        public Builder m809newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new WinnerProfile();
        }

        /* renamed from: toBuilder */
        public Builder m812toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!getNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
            }
            int i = this.uid_;
            if (i != 0) {
                codedOutputStream.writeUInt32(2, i);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/BoxGiftExtra$WinnerProfileOrBuilder.class */
    public interface WinnerProfileOrBuilder extends MessageOrBuilder {
        String getName();

        ByteString getNameBytes();

        int getUid();
    }

    private BoxGiftExtra() {
        this.memoizedIsInitialized = (byte) -1;
        this.bonus_ = Collections.emptyList();
    }

    private BoxGiftExtra(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                        if (readTag == 10) {
                            boolean z4 = z2;
                            if (!(z2 & true)) {
                                this.bonus_ = new ArrayList();
                                z4 = z2 | true;
                            }
                            this.bonus_.add((Bonus) codedInputStream.readMessage(Bonus.parser(), extensionRegistryLite));
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
                    this.bonus_ = Collections.unmodifiableList(this.bonus_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                throw th;
            }
        }
        if (z2 & true) {
            this.bonus_ = Collections.unmodifiableList(this.bonus_);
        }
        this.unknownFields = newBuilder.build();
        makeExtensionsImmutable();
    }

    private BoxGiftExtra(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static BoxGiftExtra getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_BoxGiftExtra_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m718toBuilder();
    }

    public static Builder newBuilder(BoxGiftExtra boxGiftExtra) {
        return DEFAULT_INSTANCE.m718toBuilder().mergeFrom(boxGiftExtra);
    }

    public static BoxGiftExtra parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static BoxGiftExtra parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static BoxGiftExtra parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (BoxGiftExtra) PARSER.parseFrom(byteString);
    }

    public static BoxGiftExtra parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BoxGiftExtra) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static BoxGiftExtra parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static BoxGiftExtra parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static BoxGiftExtra parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static BoxGiftExtra parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static BoxGiftExtra parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (BoxGiftExtra) PARSER.parseFrom(byteBuffer);
    }

    public static BoxGiftExtra parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BoxGiftExtra) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static BoxGiftExtra parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (BoxGiftExtra) PARSER.parseFrom(bArr);
    }

    public static BoxGiftExtra parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BoxGiftExtra) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<BoxGiftExtra> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BoxGiftExtra) {
            BoxGiftExtra boxGiftExtra = (BoxGiftExtra) obj;
            return getBonusList().equals(boxGiftExtra.getBonusList()) && this.unknownFields.equals(boxGiftExtra.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.BoxGiftExtraOrBuilder
    public Bonus getBonus(int i) {
        return this.bonus_.get(i);
    }

    @Override // cn.irisgw.live.BoxGiftExtraOrBuilder
    public int getBonusCount() {
        return this.bonus_.size();
    }

    @Override // cn.irisgw.live.BoxGiftExtraOrBuilder
    public List<Bonus> getBonusList() {
        return this.bonus_;
    }

    @Override // cn.irisgw.live.BoxGiftExtraOrBuilder
    public BonusOrBuilder getBonusOrBuilder(int i) {
        return this.bonus_.get(i);
    }

    @Override // cn.irisgw.live.BoxGiftExtraOrBuilder
    public List<? extends BonusOrBuilder> getBonusOrBuilderList() {
        return this.bonus_;
    }

    /* renamed from: getDefaultInstanceForType */
    public BoxGiftExtra m713getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public Parser<BoxGiftExtra> getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.bonus_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(1, this.bonus_.get(i3));
        }
        int serializedSize = i2 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = 779 + getDescriptor().hashCode();
        int i = hashCode;
        if (getBonusCount() > 0) {
            i = (((hashCode * 37) + 1) * 53) + getBonusList().hashCode();
        }
        int hashCode2 = (i * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_BoxGiftExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(BoxGiftExtra.class, Builder.class);
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
    public Builder m716newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m715newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new BoxGiftExtra();
    }

    /* renamed from: toBuilder */
    public Builder m718toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.bonus_.size()) {
                this.unknownFields.writeTo(codedOutputStream);
                return;
            } else {
                codedOutputStream.writeMessage(1, this.bonus_.get(i2));
                i = i2 + 1;
            }
        }
    }
}
