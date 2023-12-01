package cn.irisgw.live;

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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/NobleUpgrade.class */
public final class NobleUpgrade extends GeneratedMessageV3 implements NobleUpgradeOrBuilder {
    public static final int AVATAR_FRAME_IMG_FIELD_NUMBER = 5;
    public static final int BG_URL_FIELD_NUMBER = 4;
    public static final int CONTENT_FIELD_NUMBER = 1;
    public static final int NOBLE_FIELD_NUMBER = 8;
    public static final int NOBLE_URL_FIELD_NUMBER = 2;
    public static final int PUSH_MILLISECOND_FIELD_NUMBER = 9;
    public static final int SCREEN_TYPE_FIELD_NUMBER = 3;
    public static final int UPGRADE_COMMENT_FIELD_NUMBER = 7;
    public static final int UPGRADE_STREAMER_FIELD_NUMBER = 6;
    private static final long serialVersionUID = 0;
    private volatile Object avatarFrameImg_;
    private volatile Object bgUrl_;
    private volatile Object content_;
    private byte memoizedIsInitialized;
    private volatile Object nobleUrl_;
    private Noble noble_;
    private long pushMillisecond_;
    private int screenType_;
    private boolean upgradeComment_;
    private boolean upgradeStreamer_;
    private static final NobleUpgrade DEFAULT_INSTANCE = new NobleUpgrade();
    private static final Parser<NobleUpgrade> PARSER = new AbstractParser<NobleUpgrade>() { // from class: cn.irisgw.live.NobleUpgrade.1
        /* renamed from: parsePartialFrom */
        public NobleUpgrade m6270parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new NobleUpgrade(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/NobleUpgrade$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements NobleUpgradeOrBuilder {
        private Object avatarFrameImg_;
        private Object bgUrl_;
        private Object content_;
        private SingleFieldBuilderV3<Noble, Noble.Builder, NobleOrBuilder> nobleBuilder_;
        private Object nobleUrl_;
        private Noble noble_;
        private long pushMillisecond_;
        private int screenType_;
        private boolean upgradeComment_;
        private boolean upgradeStreamer_;

        private Builder() {
            this.content_ = "";
            this.nobleUrl_ = "";
            this.bgUrl_ = "";
            this.avatarFrameImg_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.content_ = "";
            this.nobleUrl_ = "";
            this.bgUrl_ = "";
            this.avatarFrameImg_ = "";
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_NobleUpgrade_descriptor;
        }

        private SingleFieldBuilderV3<Noble, Noble.Builder, NobleOrBuilder> getNobleFieldBuilder() {
            if (this.nobleBuilder_ == null) {
                this.nobleBuilder_ = new SingleFieldBuilderV3<>(getNoble(), getParentForChildren(), isClean());
                this.noble_ = null;
            }
            return this.nobleBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = NobleUpgrade.alwaysUseFieldBuilders;
        }

        /* renamed from: addRepeatedField */
        public Builder m6272addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public NobleUpgrade m6274build() {
            NobleUpgrade m6276buildPartial = m6276buildPartial();
            if (m6276buildPartial.isInitialized()) {
                return m6276buildPartial;
            }
            throw newUninitializedMessageException(m6276buildPartial);
        }

        /* renamed from: buildPartial */
        public NobleUpgrade m6276buildPartial() {
            NobleUpgrade nobleUpgrade = new NobleUpgrade(this);
            nobleUpgrade.content_ = this.content_;
            nobleUpgrade.nobleUrl_ = this.nobleUrl_;
            nobleUpgrade.screenType_ = this.screenType_;
            nobleUpgrade.bgUrl_ = this.bgUrl_;
            nobleUpgrade.avatarFrameImg_ = this.avatarFrameImg_;
            nobleUpgrade.upgradeStreamer_ = this.upgradeStreamer_;
            nobleUpgrade.upgradeComment_ = this.upgradeComment_;
            SingleFieldBuilderV3<Noble, Noble.Builder, NobleOrBuilder> singleFieldBuilderV3 = this.nobleBuilder_;
            if (singleFieldBuilderV3 == null) {
                nobleUpgrade.noble_ = this.noble_;
            } else {
                nobleUpgrade.noble_ = singleFieldBuilderV3.build();
            }
            nobleUpgrade.pushMillisecond_ = this.pushMillisecond_;
            onBuilt();
            return nobleUpgrade;
        }

        /* renamed from: clear */
        public Builder m6280clear() {
            super.clear();
            this.content_ = "";
            this.nobleUrl_ = "";
            this.screenType_ = 0;
            this.bgUrl_ = "";
            this.avatarFrameImg_ = "";
            this.upgradeStreamer_ = false;
            this.upgradeComment_ = false;
            if (this.nobleBuilder_ == null) {
                this.noble_ = null;
            } else {
                this.noble_ = null;
                this.nobleBuilder_ = null;
            }
            this.pushMillisecond_ = NobleUpgrade.serialVersionUID;
            return this;
        }

        public Builder clearAvatarFrameImg() {
            this.avatarFrameImg_ = NobleUpgrade.getDefaultInstance().getAvatarFrameImg();
            onChanged();
            return this;
        }

        public Builder clearBgUrl() {
            this.bgUrl_ = NobleUpgrade.getDefaultInstance().getBgUrl();
            onChanged();
            return this;
        }

        public Builder clearContent() {
            this.content_ = NobleUpgrade.getDefaultInstance().getContent();
            onChanged();
            return this;
        }

        /* renamed from: clearField */
        public Builder m6282clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearNoble() {
            if (this.nobleBuilder_ == null) {
                this.noble_ = null;
                onChanged();
                return this;
            }
            this.noble_ = null;
            this.nobleBuilder_ = null;
            return this;
        }

        public Builder clearNobleUrl() {
            this.nobleUrl_ = NobleUpgrade.getDefaultInstance().getNobleUrl();
            onChanged();
            return this;
        }

        /* renamed from: clearOneof */
        public Builder m6285clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearPushMillisecond() {
            this.pushMillisecond_ = NobleUpgrade.serialVersionUID;
            onChanged();
            return this;
        }

        public Builder clearScreenType() {
            this.screenType_ = 0;
            onChanged();
            return this;
        }

        public Builder clearUpgradeComment() {
            this.upgradeComment_ = false;
            onChanged();
            return this;
        }

        public Builder clearUpgradeStreamer() {
            this.upgradeStreamer_ = false;
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m6291clone() {
            return (Builder) super.clone();
        }

        @Override // cn.irisgw.live.NobleUpgradeOrBuilder
        public String getAvatarFrameImg() {
            Object obj = this.avatarFrameImg_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.avatarFrameImg_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.NobleUpgradeOrBuilder
        public ByteString getAvatarFrameImgBytes() {
            Object obj = this.avatarFrameImg_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.avatarFrameImg_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.NobleUpgradeOrBuilder
        public String getBgUrl() {
            Object obj = this.bgUrl_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.bgUrl_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.NobleUpgradeOrBuilder
        public ByteString getBgUrlBytes() {
            Object obj = this.bgUrl_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.bgUrl_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.NobleUpgradeOrBuilder
        public String getContent() {
            Object obj = this.content_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.content_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.NobleUpgradeOrBuilder
        public ByteString getContentBytes() {
            Object obj = this.content_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.content_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        /* renamed from: getDefaultInstanceForType */
        public NobleUpgrade m6293getDefaultInstanceForType() {
            return NobleUpgrade.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_NobleUpgrade_descriptor;
        }

        @Override // cn.irisgw.live.NobleUpgradeOrBuilder
        public Noble getNoble() {
            SingleFieldBuilderV3<Noble, Noble.Builder, NobleOrBuilder> singleFieldBuilderV3 = this.nobleBuilder_;
            if (singleFieldBuilderV3 == null) {
                Noble noble = this.noble_;
                Noble noble2 = noble;
                if (noble == null) {
                    noble2 = Noble.getDefaultInstance();
                }
                return noble2;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Noble.Builder getNobleBuilder() {
            onChanged();
            return getNobleFieldBuilder().getBuilder();
        }

        @Override // cn.irisgw.live.NobleUpgradeOrBuilder
        public NobleOrBuilder getNobleOrBuilder() {
            SingleFieldBuilderV3<Noble, Noble.Builder, NobleOrBuilder> singleFieldBuilderV3 = this.nobleBuilder_;
            if (singleFieldBuilderV3 != null) {
                return (NobleOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
            }
            Noble noble = this.noble_;
            Noble noble2 = noble;
            if (noble == null) {
                noble2 = Noble.getDefaultInstance();
            }
            return noble2;
        }

        @Override // cn.irisgw.live.NobleUpgradeOrBuilder
        public String getNobleUrl() {
            Object obj = this.nobleUrl_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.nobleUrl_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.NobleUpgradeOrBuilder
        public ByteString getNobleUrlBytes() {
            Object obj = this.nobleUrl_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.nobleUrl_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.NobleUpgradeOrBuilder
        public long getPushMillisecond() {
            return this.pushMillisecond_;
        }

        @Override // cn.irisgw.live.NobleUpgradeOrBuilder
        public int getScreenType() {
            return this.screenType_;
        }

        @Override // cn.irisgw.live.NobleUpgradeOrBuilder
        public boolean getUpgradeComment() {
            return this.upgradeComment_;
        }

        @Override // cn.irisgw.live.NobleUpgradeOrBuilder
        public boolean getUpgradeStreamer() {
            return this.upgradeStreamer_;
        }

        @Override // cn.irisgw.live.NobleUpgradeOrBuilder
        public boolean hasNoble() {
            return (this.nobleBuilder_ == null && this.noble_ == null) ? false : true;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_NobleUpgrade_fieldAccessorTable.ensureFieldAccessorsInitialized(NobleUpgrade.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(NobleUpgrade nobleUpgrade) {
            if (nobleUpgrade == NobleUpgrade.getDefaultInstance()) {
                return this;
            }
            if (!nobleUpgrade.getContent().isEmpty()) {
                this.content_ = nobleUpgrade.content_;
                onChanged();
            }
            if (!nobleUpgrade.getNobleUrl().isEmpty()) {
                this.nobleUrl_ = nobleUpgrade.nobleUrl_;
                onChanged();
            }
            if (nobleUpgrade.getScreenType() != 0) {
                setScreenType(nobleUpgrade.getScreenType());
            }
            if (!nobleUpgrade.getBgUrl().isEmpty()) {
                this.bgUrl_ = nobleUpgrade.bgUrl_;
                onChanged();
            }
            if (!nobleUpgrade.getAvatarFrameImg().isEmpty()) {
                this.avatarFrameImg_ = nobleUpgrade.avatarFrameImg_;
                onChanged();
            }
            if (nobleUpgrade.getUpgradeStreamer()) {
                setUpgradeStreamer(nobleUpgrade.getUpgradeStreamer());
            }
            if (nobleUpgrade.getUpgradeComment()) {
                setUpgradeComment(nobleUpgrade.getUpgradeComment());
            }
            if (nobleUpgrade.hasNoble()) {
                mergeNoble(nobleUpgrade.getNoble());
            }
            if (nobleUpgrade.getPushMillisecond() != NobleUpgrade.serialVersionUID) {
                setPushMillisecond(nobleUpgrade.getPushMillisecond());
            }
            m6302mergeUnknownFields(nobleUpgrade.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.NobleUpgrade.Builder m6299mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.NobleUpgrade.access$2800()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.NobleUpgrade r0 = (cn.irisgw.live.NobleUpgrade) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.NobleUpgrade$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.NobleUpgrade r0 = (cn.irisgw.live.NobleUpgrade) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.NobleUpgrade$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.NobleUpgrade.Builder.m6299mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.NobleUpgrade$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m6298mergeFrom(Message message) {
            if (message instanceof NobleUpgrade) {
                return mergeFrom((NobleUpgrade) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeNoble(Noble noble) {
            SingleFieldBuilderV3<Noble, Noble.Builder, NobleOrBuilder> singleFieldBuilderV3 = this.nobleBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.mergeFrom(noble);
                return this;
            }
            Noble noble2 = this.noble_;
            if (noble2 != null) {
                this.noble_ = Noble.newBuilder(noble2).mergeFrom(noble).m6323buildPartial();
            } else {
                this.noble_ = noble;
            }
            onChanged();
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m6302mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setAvatarFrameImg(String str) {
            if (str != null) {
                this.avatarFrameImg_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setAvatarFrameImgBytes(ByteString byteString) {
            if (byteString != null) {
                NobleUpgrade.checkByteStringIsUtf8(byteString);
                this.avatarFrameImg_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setBgUrl(String str) {
            if (str != null) {
                this.bgUrl_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setBgUrlBytes(ByteString byteString) {
            if (byteString != null) {
                NobleUpgrade.checkByteStringIsUtf8(byteString);
                this.bgUrl_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setContent(String str) {
            if (str != null) {
                this.content_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setContentBytes(ByteString byteString) {
            if (byteString != null) {
                NobleUpgrade.checkByteStringIsUtf8(byteString);
                this.content_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        /* renamed from: setField */
        public Builder m6304setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setNoble(Noble.Builder builder) {
            SingleFieldBuilderV3<Noble, Noble.Builder, NobleOrBuilder> singleFieldBuilderV3 = this.nobleBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(builder.m6321build());
                return this;
            }
            this.noble_ = builder.m6321build();
            onChanged();
            return this;
        }

        public Builder setNoble(Noble noble) {
            SingleFieldBuilderV3<Noble, Noble.Builder, NobleOrBuilder> singleFieldBuilderV3 = this.nobleBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(noble);
                return this;
            } else if (noble != null) {
                this.noble_ = noble;
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder setNobleUrl(String str) {
            if (str != null) {
                this.nobleUrl_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setNobleUrlBytes(ByteString byteString) {
            if (byteString != null) {
                NobleUpgrade.checkByteStringIsUtf8(byteString);
                this.nobleUrl_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setPushMillisecond(long j) {
            this.pushMillisecond_ = j;
            onChanged();
            return this;
        }

        /* renamed from: setRepeatedField */
        public Builder m6306setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setScreenType(int i) {
            this.screenType_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setUnknownFields */
        public final Builder m6308setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }

        public Builder setUpgradeComment(boolean z) {
            this.upgradeComment_ = z;
            onChanged();
            return this;
        }

        public Builder setUpgradeStreamer(boolean z) {
            this.upgradeStreamer_ = z;
            onChanged();
            return this;
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/NobleUpgrade$Noble.class */
    public static final class Noble extends GeneratedMessageV3 implements NobleOrBuilder {
        public static final int NAMEPLATE_IMG_FIELD_NUMBER = 3;
        public static final int NAMEPLATE_IMG_HEIGHT_FIELD_NUMBER = 5;
        public static final int NAMEPLATE_IMG_WIDTH_FIELD_NUMBER = 4;
        public static final int NOBLE_LEVEL_FIELD_NUMBER = 1;
        public static final int NOBLE_NAME_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private int nameplateImgHeight_;
        private int nameplateImgWidth_;
        private volatile Object nameplateImg_;
        private int nobleLevel_;
        private volatile Object nobleName_;
        private static final Noble DEFAULT_INSTANCE = new Noble();
        private static final Parser<Noble> PARSER = new AbstractParser<Noble>() { // from class: cn.irisgw.live.NobleUpgrade.Noble.1
            /* renamed from: parsePartialFrom */
            public Noble m6317parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Noble(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/NobleUpgrade$Noble$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements NobleOrBuilder {
            private int nameplateImgHeight_;
            private int nameplateImgWidth_;
            private Object nameplateImg_;
            private int nobleLevel_;
            private Object nobleName_;

            private Builder() {
                this.nobleName_ = "";
                this.nameplateImg_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.nobleName_ = "";
                this.nameplateImg_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LiveConstants.internal_static_cn_irisgw_live_NobleUpgrade_Noble_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = Noble.alwaysUseFieldBuilders;
            }

            /* renamed from: addRepeatedField */
            public Builder m6319addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: build */
            public Noble m6321build() {
                Noble m6323buildPartial = m6323buildPartial();
                if (m6323buildPartial.isInitialized()) {
                    return m6323buildPartial;
                }
                throw newUninitializedMessageException(m6323buildPartial);
            }

            /* renamed from: buildPartial */
            public Noble m6323buildPartial() {
                Noble noble = new Noble(this);
                noble.nobleLevel_ = this.nobleLevel_;
                noble.nobleName_ = this.nobleName_;
                noble.nameplateImg_ = this.nameplateImg_;
                noble.nameplateImgWidth_ = this.nameplateImgWidth_;
                noble.nameplateImgHeight_ = this.nameplateImgHeight_;
                onBuilt();
                return noble;
            }

            /* renamed from: clear */
            public Builder m6327clear() {
                super.clear();
                this.nobleLevel_ = 0;
                this.nobleName_ = "";
                this.nameplateImg_ = "";
                this.nameplateImgWidth_ = 0;
                this.nameplateImgHeight_ = 0;
                return this;
            }

            /* renamed from: clearField */
            public Builder m6329clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearNameplateImg() {
                this.nameplateImg_ = Noble.getDefaultInstance().getNameplateImg();
                onChanged();
                return this;
            }

            public Builder clearNameplateImgHeight() {
                this.nameplateImgHeight_ = 0;
                onChanged();
                return this;
            }

            public Builder clearNameplateImgWidth() {
                this.nameplateImgWidth_ = 0;
                onChanged();
                return this;
            }

            public Builder clearNobleLevel() {
                this.nobleLevel_ = 0;
                onChanged();
                return this;
            }

            public Builder clearNobleName() {
                this.nobleName_ = Noble.getDefaultInstance().getNobleName();
                onChanged();
                return this;
            }

            /* renamed from: clearOneof */
            public Builder m6332clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            /* renamed from: clone */
            public Builder m6338clone() {
                return (Builder) super.clone();
            }

            /* renamed from: getDefaultInstanceForType */
            public Noble m6340getDefaultInstanceForType() {
                return Noble.getDefaultInstance();
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return LiveConstants.internal_static_cn_irisgw_live_NobleUpgrade_Noble_descriptor;
            }

            @Override // cn.irisgw.live.NobleUpgrade.NobleOrBuilder
            public String getNameplateImg() {
                Object obj = this.nameplateImg_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.nameplateImg_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.NobleUpgrade.NobleOrBuilder
            public ByteString getNameplateImgBytes() {
                Object obj = this.nameplateImg_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.nameplateImg_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.NobleUpgrade.NobleOrBuilder
            public int getNameplateImgHeight() {
                return this.nameplateImgHeight_;
            }

            @Override // cn.irisgw.live.NobleUpgrade.NobleOrBuilder
            public int getNameplateImgWidth() {
                return this.nameplateImgWidth_;
            }

            @Override // cn.irisgw.live.NobleUpgrade.NobleOrBuilder
            public int getNobleLevel() {
                return this.nobleLevel_;
            }

            @Override // cn.irisgw.live.NobleUpgrade.NobleOrBuilder
            public String getNobleName() {
                Object obj = this.nobleName_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.nobleName_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.NobleUpgrade.NobleOrBuilder
            public ByteString getNobleNameBytes() {
                Object obj = this.nobleName_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.nobleName_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveConstants.internal_static_cn_irisgw_live_NobleUpgrade_Noble_fieldAccessorTable.ensureFieldAccessorsInitialized(Noble.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(Noble noble) {
                if (noble == Noble.getDefaultInstance()) {
                    return this;
                }
                if (noble.getNobleLevel() != 0) {
                    setNobleLevel(noble.getNobleLevel());
                }
                if (!noble.getNobleName().isEmpty()) {
                    this.nobleName_ = noble.nobleName_;
                    onChanged();
                }
                if (!noble.getNameplateImg().isEmpty()) {
                    this.nameplateImg_ = noble.nameplateImg_;
                    onChanged();
                }
                if (noble.getNameplateImgWidth() != 0) {
                    setNameplateImgWidth(noble.getNameplateImgWidth());
                }
                if (noble.getNameplateImgHeight() != 0) {
                    setNameplateImgHeight(noble.getNameplateImgHeight());
                }
                m6349mergeUnknownFields(noble.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            /* renamed from: mergeFrom */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.NobleUpgrade.Noble.Builder m6346mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.NobleUpgrade.Noble.access$1000()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.NobleUpgrade$Noble r0 = (cn.irisgw.live.NobleUpgrade.Noble) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.NobleUpgrade$Noble$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.NobleUpgrade$Noble r0 = (cn.irisgw.live.NobleUpgrade.Noble) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.NobleUpgrade$Noble$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.NobleUpgrade.Noble.Builder.m6346mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.NobleUpgrade$Noble$Builder");
            }

            /* renamed from: mergeFrom */
            public Builder m6345mergeFrom(Message message) {
                if (message instanceof Noble) {
                    return mergeFrom((Noble) message);
                }
                super.mergeFrom(message);
                return this;
            }

            /* renamed from: mergeUnknownFields */
            public final Builder m6349mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            /* renamed from: setField */
            public Builder m6351setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setNameplateImg(String str) {
                if (str != null) {
                    this.nameplateImg_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setNameplateImgBytes(ByteString byteString) {
                if (byteString != null) {
                    Noble.checkByteStringIsUtf8(byteString);
                    this.nameplateImg_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setNameplateImgHeight(int i) {
                this.nameplateImgHeight_ = i;
                onChanged();
                return this;
            }

            public Builder setNameplateImgWidth(int i) {
                this.nameplateImgWidth_ = i;
                onChanged();
                return this;
            }

            public Builder setNobleLevel(int i) {
                this.nobleLevel_ = i;
                onChanged();
                return this;
            }

            public Builder setNobleName(String str) {
                if (str != null) {
                    this.nobleName_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setNobleNameBytes(ByteString byteString) {
                if (byteString != null) {
                    Noble.checkByteStringIsUtf8(byteString);
                    this.nobleName_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            /* renamed from: setRepeatedField */
            public Builder m6353setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            /* renamed from: setUnknownFields */
            public final Builder m6355setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private Noble() {
            this.memoizedIsInitialized = (byte) -1;
            this.nobleName_ = "";
            this.nameplateImg_ = "";
        }

        private Noble(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.nobleLevel_ = codedInputStream.readUInt32();
                            } else if (readTag == 18) {
                                this.nobleName_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 26) {
                                this.nameplateImg_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 32) {
                                this.nameplateImgWidth_ = codedInputStream.readUInt32();
                            } else if (readTag == 40) {
                                this.nameplateImgHeight_ = codedInputStream.readUInt32();
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

        private Noble(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Noble getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_NobleUpgrade_Noble_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m6316toBuilder();
        }

        public static Builder newBuilder(Noble noble) {
            return DEFAULT_INSTANCE.m6316toBuilder().mergeFrom(noble);
        }

        public static Noble parseDelimitedFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Noble parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Noble parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Noble) PARSER.parseFrom(byteString);
        }

        public static Noble parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Noble) PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Noble parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Noble parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static Noble parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Noble parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Noble parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Noble) PARSER.parseFrom(byteBuffer);
        }

        public static Noble parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Noble) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Noble parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Noble) PARSER.parseFrom(bArr);
        }

        public static Noble parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Noble) PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<Noble> parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Noble) {
                Noble noble = (Noble) obj;
                return getNobleLevel() == noble.getNobleLevel() && getNobleName().equals(noble.getNobleName()) && getNameplateImg().equals(noble.getNameplateImg()) && getNameplateImgWidth() == noble.getNameplateImgWidth() && getNameplateImgHeight() == noble.getNameplateImgHeight() && this.unknownFields.equals(noble.unknownFields);
            }
            return super.equals(obj);
        }

        /* renamed from: getDefaultInstanceForType */
        public Noble m6311getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // cn.irisgw.live.NobleUpgrade.NobleOrBuilder
        public String getNameplateImg() {
            Object obj = this.nameplateImg_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.nameplateImg_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.NobleUpgrade.NobleOrBuilder
        public ByteString getNameplateImgBytes() {
            Object obj = this.nameplateImg_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.nameplateImg_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.NobleUpgrade.NobleOrBuilder
        public int getNameplateImgHeight() {
            return this.nameplateImgHeight_;
        }

        @Override // cn.irisgw.live.NobleUpgrade.NobleOrBuilder
        public int getNameplateImgWidth() {
            return this.nameplateImgWidth_;
        }

        @Override // cn.irisgw.live.NobleUpgrade.NobleOrBuilder
        public int getNobleLevel() {
            return this.nobleLevel_;
        }

        @Override // cn.irisgw.live.NobleUpgrade.NobleOrBuilder
        public String getNobleName() {
            Object obj = this.nobleName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.nobleName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.NobleUpgrade.NobleOrBuilder
        public ByteString getNobleNameBytes() {
            Object obj = this.nobleName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.nobleName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Parser<Noble> getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            int i3 = this.nobleLevel_;
            if (i3 != 0) {
                i2 = 0 + CodedOutputStream.computeUInt32Size(1, i3);
            }
            int i4 = i2;
            if (!getNobleNameBytes().isEmpty()) {
                i4 = i2 + GeneratedMessageV3.computeStringSize(2, this.nobleName_);
            }
            int i5 = i4;
            if (!getNameplateImgBytes().isEmpty()) {
                i5 = i4 + GeneratedMessageV3.computeStringSize(3, this.nameplateImg_);
            }
            int i6 = this.nameplateImgWidth_;
            int i7 = i5;
            if (i6 != 0) {
                i7 = i5 + CodedOutputStream.computeUInt32Size(4, i6);
            }
            int i8 = this.nameplateImgHeight_;
            int i9 = i7;
            if (i8 != 0) {
                i9 = i7 + CodedOutputStream.computeUInt32Size(5, i8);
            }
            int serializedSize = i9 + this.unknownFields.getSerializedSize();
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
            int hashCode = ((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getNobleLevel()) * 37) + 2) * 53) + getNobleName().hashCode()) * 37) + 3) * 53) + getNameplateImg().hashCode()) * 37) + 4) * 53) + getNameplateImgWidth()) * 37) + 5) * 53) + getNameplateImgHeight()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_NobleUpgrade_Noble_fieldAccessorTable.ensureFieldAccessorsInitialized(Noble.class, Builder.class);
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
        public Builder m6314newBuilderForType() {
            return newBuilder();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: newBuilderForType */
        public Builder m6313newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new Noble();
        }

        /* renamed from: toBuilder */
        public Builder m6316toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i = this.nobleLevel_;
            if (i != 0) {
                codedOutputStream.writeUInt32(1, i);
            }
            if (!getNobleNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.nobleName_);
            }
            if (!getNameplateImgBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.nameplateImg_);
            }
            int i2 = this.nameplateImgWidth_;
            if (i2 != 0) {
                codedOutputStream.writeUInt32(4, i2);
            }
            int i3 = this.nameplateImgHeight_;
            if (i3 != 0) {
                codedOutputStream.writeUInt32(5, i3);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/NobleUpgrade$NobleOrBuilder.class */
    public interface NobleOrBuilder extends MessageOrBuilder {
        String getNameplateImg();

        ByteString getNameplateImgBytes();

        int getNameplateImgHeight();

        int getNameplateImgWidth();

        int getNobleLevel();

        String getNobleName();

        ByteString getNobleNameBytes();
    }

    private NobleUpgrade() {
        this.memoizedIsInitialized = (byte) -1;
        this.content_ = "";
        this.nobleUrl_ = "";
        this.bgUrl_ = "";
        this.avatarFrameImg_ = "";
    }

    private NobleUpgrade(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.content_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                this.nobleUrl_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 24) {
                                this.screenType_ = codedInputStream.readInt32();
                            } else if (readTag == 34) {
                                this.bgUrl_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 42) {
                                this.avatarFrameImg_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 48) {
                                this.upgradeStreamer_ = codedInputStream.readBool();
                            } else if (readTag == 56) {
                                this.upgradeComment_ = codedInputStream.readBool();
                            } else if (readTag == 66) {
                                Noble.Builder m6316toBuilder = this.noble_ != null ? this.noble_.m6316toBuilder() : null;
                                Noble readMessage = codedInputStream.readMessage(Noble.parser(), extensionRegistryLite);
                                this.noble_ = readMessage;
                                if (m6316toBuilder != null) {
                                    m6316toBuilder.mergeFrom(readMessage);
                                    this.noble_ = m6316toBuilder.m6323buildPartial();
                                }
                            } else if (readTag == 72) {
                                this.pushMillisecond_ = codedInputStream.readUInt64();
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

    private NobleUpgrade(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static NobleUpgrade getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_NobleUpgrade_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m6269toBuilder();
    }

    public static Builder newBuilder(NobleUpgrade nobleUpgrade) {
        return DEFAULT_INSTANCE.m6269toBuilder().mergeFrom(nobleUpgrade);
    }

    public static NobleUpgrade parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static NobleUpgrade parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static NobleUpgrade parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (NobleUpgrade) PARSER.parseFrom(byteString);
    }

    public static NobleUpgrade parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (NobleUpgrade) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static NobleUpgrade parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static NobleUpgrade parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static NobleUpgrade parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static NobleUpgrade parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static NobleUpgrade parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (NobleUpgrade) PARSER.parseFrom(byteBuffer);
    }

    public static NobleUpgrade parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (NobleUpgrade) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static NobleUpgrade parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (NobleUpgrade) PARSER.parseFrom(bArr);
    }

    public static NobleUpgrade parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (NobleUpgrade) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<NobleUpgrade> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NobleUpgrade) {
            NobleUpgrade nobleUpgrade = (NobleUpgrade) obj;
            if (getContent().equals(nobleUpgrade.getContent()) && getNobleUrl().equals(nobleUpgrade.getNobleUrl()) && getScreenType() == nobleUpgrade.getScreenType() && getBgUrl().equals(nobleUpgrade.getBgUrl()) && getAvatarFrameImg().equals(nobleUpgrade.getAvatarFrameImg()) && getUpgradeStreamer() == nobleUpgrade.getUpgradeStreamer() && getUpgradeComment() == nobleUpgrade.getUpgradeComment() && hasNoble() == nobleUpgrade.hasNoble()) {
                return (!hasNoble() || getNoble().equals(nobleUpgrade.getNoble())) && getPushMillisecond() == nobleUpgrade.getPushMillisecond() && this.unknownFields.equals(nobleUpgrade.unknownFields);
            }
            return false;
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.NobleUpgradeOrBuilder
    public String getAvatarFrameImg() {
        Object obj = this.avatarFrameImg_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.avatarFrameImg_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.NobleUpgradeOrBuilder
    public ByteString getAvatarFrameImgBytes() {
        Object obj = this.avatarFrameImg_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.avatarFrameImg_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.NobleUpgradeOrBuilder
    public String getBgUrl() {
        Object obj = this.bgUrl_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.bgUrl_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.NobleUpgradeOrBuilder
    public ByteString getBgUrlBytes() {
        Object obj = this.bgUrl_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.bgUrl_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.NobleUpgradeOrBuilder
    public String getContent() {
        Object obj = this.content_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.content_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.NobleUpgradeOrBuilder
    public ByteString getContentBytes() {
        Object obj = this.content_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.content_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    /* renamed from: getDefaultInstanceForType */
    public NobleUpgrade m6264getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.NobleUpgradeOrBuilder
    public Noble getNoble() {
        Noble noble = this.noble_;
        Noble noble2 = noble;
        if (noble == null) {
            noble2 = Noble.getDefaultInstance();
        }
        return noble2;
    }

    @Override // cn.irisgw.live.NobleUpgradeOrBuilder
    public NobleOrBuilder getNobleOrBuilder() {
        return getNoble();
    }

    @Override // cn.irisgw.live.NobleUpgradeOrBuilder
    public String getNobleUrl() {
        Object obj = this.nobleUrl_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.nobleUrl_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.NobleUpgradeOrBuilder
    public ByteString getNobleUrlBytes() {
        Object obj = this.nobleUrl_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.nobleUrl_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    public Parser<NobleUpgrade> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.NobleUpgradeOrBuilder
    public long getPushMillisecond() {
        return this.pushMillisecond_;
    }

    @Override // cn.irisgw.live.NobleUpgradeOrBuilder
    public int getScreenType() {
        return this.screenType_;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (!getContentBytes().isEmpty()) {
            i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.content_);
        }
        int i3 = i2;
        if (!getNobleUrlBytes().isEmpty()) {
            i3 = i2 + GeneratedMessageV3.computeStringSize(2, this.nobleUrl_);
        }
        int i4 = this.screenType_;
        int i5 = i3;
        if (i4 != 0) {
            i5 = i3 + CodedOutputStream.computeInt32Size(3, i4);
        }
        int i6 = i5;
        if (!getBgUrlBytes().isEmpty()) {
            i6 = i5 + GeneratedMessageV3.computeStringSize(4, this.bgUrl_);
        }
        int i7 = i6;
        if (!getAvatarFrameImgBytes().isEmpty()) {
            i7 = i6 + GeneratedMessageV3.computeStringSize(5, this.avatarFrameImg_);
        }
        boolean z = this.upgradeStreamer_;
        int i8 = i7;
        if (z) {
            i8 = i7 + CodedOutputStream.computeBoolSize(6, z);
        }
        boolean z2 = this.upgradeComment_;
        int i9 = i8;
        if (z2) {
            i9 = i8 + CodedOutputStream.computeBoolSize(7, z2);
        }
        int i10 = i9;
        if (this.noble_ != null) {
            i10 = i9 + CodedOutputStream.computeMessageSize(8, getNoble());
        }
        long j = this.pushMillisecond_;
        int i11 = i10;
        if (j != serialVersionUID) {
            i11 = i10 + CodedOutputStream.computeUInt64Size(9, j);
        }
        int serializedSize = i11 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // cn.irisgw.live.NobleUpgradeOrBuilder
    public boolean getUpgradeComment() {
        return this.upgradeComment_;
    }

    @Override // cn.irisgw.live.NobleUpgradeOrBuilder
    public boolean getUpgradeStreamer() {
        return this.upgradeStreamer_;
    }

    @Override // cn.irisgw.live.NobleUpgradeOrBuilder
    public boolean hasNoble() {
        return this.noble_ != null;
    }

    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getContent().hashCode()) * 37) + 2) * 53) + getNobleUrl().hashCode()) * 37) + 3) * 53) + getScreenType()) * 37) + 4) * 53) + getBgUrl().hashCode()) * 37) + 5) * 53) + getAvatarFrameImg().hashCode()) * 37) + 6) * 53) + Internal.hashBoolean(getUpgradeStreamer())) * 37) + 7) * 53) + Internal.hashBoolean(getUpgradeComment());
        int i = hashCode;
        if (hasNoble()) {
            i = (((hashCode * 37) + 8) * 53) + getNoble().hashCode();
        }
        int hashLong = (((((i * 37) + 9) * 53) + Internal.hashLong(getPushMillisecond())) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashLong;
        return hashLong;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_NobleUpgrade_fieldAccessorTable.ensureFieldAccessorsInitialized(NobleUpgrade.class, Builder.class);
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
    public Builder m6267newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m6266newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new NobleUpgrade();
    }

    /* renamed from: toBuilder */
    public Builder m6269toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!getContentBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.content_);
        }
        if (!getNobleUrlBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.nobleUrl_);
        }
        int i = this.screenType_;
        if (i != 0) {
            codedOutputStream.writeInt32(3, i);
        }
        if (!getBgUrlBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 4, this.bgUrl_);
        }
        if (!getAvatarFrameImgBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 5, this.avatarFrameImg_);
        }
        boolean z = this.upgradeStreamer_;
        if (z) {
            codedOutputStream.writeBool(6, z);
        }
        boolean z2 = this.upgradeComment_;
        if (z2) {
            codedOutputStream.writeBool(7, z2);
        }
        if (this.noble_ != null) {
            codedOutputStream.writeMessage(8, getNoble());
        }
        long j = this.pushMillisecond_;
        if (j != serialVersionUID) {
            codedOutputStream.writeUInt64(9, j);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
