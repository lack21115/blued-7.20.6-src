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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/NewHorn.class */
public final class NewHorn extends GeneratedMessageV3 implements NewHornOrBuilder {
    public static final int BACK_IMAGE_FIELD_NUMBER = 4;
    public static final int COLOR_FIELD_NUMBER = 8;
    public static final int CONTENTS_FIELD_NUMBER = 7;
    public static final int EFFECT_FIELD_NUMBER = 16;
    public static final int GIFT_APNG_FIELD_NUMBER = 10;
    public static final int GIFT_MP4_FIELD_NUMBER = 11;
    public static final int HEAD_IMAGE_FIELD_NUMBER = 3;
    public static final int HIGHLIGHT_COLOR_FIELD_NUMBER = 9;
    public static final int ICON_IMAGE_FIELD_NUMBER = 2;
    public static final int LID_FIELD_NUMBER = 13;
    public static final int LINK_FIELD_NUMBER = 18;
    public static final int LINK_TYPE_FIELD_NUMBER = 17;
    public static final int POSITION_FIELD_NUMBER = 14;
    public static final int REDIRECT_URL_FIELD_NUMBER = 6;
    public static final int REPORT_ID_FIELD_NUMBER = 15;
    public static final int SCENE_FIELD_NUMBER = 1;
    public static final int TAIL_IMAGE_FIELD_NUMBER = 5;
    public static final int UID_FIELD_NUMBER = 12;
    private static final long serialVersionUID = 0;
    private volatile Object backImage_;
    private volatile Object color_;
    private volatile Object contents_;
    private int effect_;
    private volatile Object giftApng_;
    private volatile Object giftMp4_;
    private volatile Object headImage_;
    private volatile Object highlightColor_;
    private volatile Object iconImage_;
    private volatile Object lid_;
    private int linkType_;
    private volatile Object link_;
    private byte memoizedIsInitialized;
    private int position_;
    private volatile Object redirectUrl_;
    private volatile Object reportId_;
    private int scene_;
    private volatile Object tailImage_;
    private volatile Object uid_;
    private static final NewHorn DEFAULT_INSTANCE = new NewHorn();
    private static final Parser<NewHorn> PARSER = new AbstractParser<NewHorn>() { // from class: cn.irisgw.live.NewHorn.1
        @Override // com.google.protobuf.Parser
        public NewHorn parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new NewHorn(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/NewHorn$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements NewHornOrBuilder {
        private Object backImage_;
        private Object color_;
        private Object contents_;
        private int effect_;
        private Object giftApng_;
        private Object giftMp4_;
        private Object headImage_;
        private Object highlightColor_;
        private Object iconImage_;
        private Object lid_;
        private int linkType_;
        private Object link_;
        private int position_;
        private Object redirectUrl_;
        private Object reportId_;
        private int scene_;
        private Object tailImage_;
        private Object uid_;

        private Builder() {
            this.iconImage_ = "";
            this.headImage_ = "";
            this.backImage_ = "";
            this.tailImage_ = "";
            this.redirectUrl_ = "";
            this.contents_ = "";
            this.color_ = "";
            this.highlightColor_ = "";
            this.giftApng_ = "";
            this.giftMp4_ = "";
            this.uid_ = "";
            this.lid_ = "";
            this.reportId_ = "";
            this.link_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.iconImage_ = "";
            this.headImage_ = "";
            this.backImage_ = "";
            this.tailImage_ = "";
            this.redirectUrl_ = "";
            this.contents_ = "";
            this.color_ = "";
            this.highlightColor_ = "";
            this.giftApng_ = "";
            this.giftMp4_ = "";
            this.uid_ = "";
            this.lid_ = "";
            this.reportId_ = "";
            this.link_ = "";
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_NewHorn_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = NewHorn.alwaysUseFieldBuilders;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public NewHorn build() {
            NewHorn buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public NewHorn buildPartial() {
            NewHorn newHorn = new NewHorn(this);
            newHorn.scene_ = this.scene_;
            newHorn.iconImage_ = this.iconImage_;
            newHorn.headImage_ = this.headImage_;
            newHorn.backImage_ = this.backImage_;
            newHorn.tailImage_ = this.tailImage_;
            newHorn.redirectUrl_ = this.redirectUrl_;
            newHorn.contents_ = this.contents_;
            newHorn.color_ = this.color_;
            newHorn.highlightColor_ = this.highlightColor_;
            newHorn.giftApng_ = this.giftApng_;
            newHorn.giftMp4_ = this.giftMp4_;
            newHorn.uid_ = this.uid_;
            newHorn.lid_ = this.lid_;
            newHorn.position_ = this.position_;
            newHorn.reportId_ = this.reportId_;
            newHorn.effect_ = this.effect_;
            newHorn.linkType_ = this.linkType_;
            newHorn.link_ = this.link_;
            onBuilt();
            return newHorn;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.scene_ = 0;
            this.iconImage_ = "";
            this.headImage_ = "";
            this.backImage_ = "";
            this.tailImage_ = "";
            this.redirectUrl_ = "";
            this.contents_ = "";
            this.color_ = "";
            this.highlightColor_ = "";
            this.giftApng_ = "";
            this.giftMp4_ = "";
            this.uid_ = "";
            this.lid_ = "";
            this.position_ = 0;
            this.reportId_ = "";
            this.effect_ = 0;
            this.linkType_ = 0;
            this.link_ = "";
            return this;
        }

        public Builder clearBackImage() {
            this.backImage_ = NewHorn.getDefaultInstance().getBackImage();
            onChanged();
            return this;
        }

        public Builder clearColor() {
            this.color_ = NewHorn.getDefaultInstance().getColor();
            onChanged();
            return this;
        }

        public Builder clearContents() {
            this.contents_ = NewHorn.getDefaultInstance().getContents();
            onChanged();
            return this;
        }

        public Builder clearEffect() {
            this.effect_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearGiftApng() {
            this.giftApng_ = NewHorn.getDefaultInstance().getGiftApng();
            onChanged();
            return this;
        }

        public Builder clearGiftMp4() {
            this.giftMp4_ = NewHorn.getDefaultInstance().getGiftMp4();
            onChanged();
            return this;
        }

        public Builder clearHeadImage() {
            this.headImage_ = NewHorn.getDefaultInstance().getHeadImage();
            onChanged();
            return this;
        }

        public Builder clearHighlightColor() {
            this.highlightColor_ = NewHorn.getDefaultInstance().getHighlightColor();
            onChanged();
            return this;
        }

        public Builder clearIconImage() {
            this.iconImage_ = NewHorn.getDefaultInstance().getIconImage();
            onChanged();
            return this;
        }

        public Builder clearLid() {
            this.lid_ = NewHorn.getDefaultInstance().getLid();
            onChanged();
            return this;
        }

        public Builder clearLink() {
            this.link_ = NewHorn.getDefaultInstance().getLink();
            onChanged();
            return this;
        }

        public Builder clearLinkType() {
            this.linkType_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearPosition() {
            this.position_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRedirectUrl() {
            this.redirectUrl_ = NewHorn.getDefaultInstance().getRedirectUrl();
            onChanged();
            return this;
        }

        public Builder clearReportId() {
            this.reportId_ = NewHorn.getDefaultInstance().getReportId();
            onChanged();
            return this;
        }

        public Builder clearScene() {
            this.scene_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTailImage() {
            this.tailImage_ = NewHorn.getDefaultInstance().getTailImage();
            onChanged();
            return this;
        }

        public Builder clearUid() {
            this.uid_ = NewHorn.getDefaultInstance().getUid();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo1800clone() {
            return (Builder) super.mo1800clone();
        }

        @Override // cn.irisgw.live.NewHornOrBuilder
        public String getBackImage() {
            Object obj = this.backImage_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.backImage_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.NewHornOrBuilder
        public ByteString getBackImageBytes() {
            Object obj = this.backImage_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.backImage_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.NewHornOrBuilder
        public String getColor() {
            Object obj = this.color_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.color_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.NewHornOrBuilder
        public ByteString getColorBytes() {
            Object obj = this.color_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.color_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.NewHornOrBuilder
        public String getContents() {
            Object obj = this.contents_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.contents_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.NewHornOrBuilder
        public ByteString getContentsBytes() {
            Object obj = this.contents_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.contents_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public NewHorn getDefaultInstanceForType() {
            return NewHorn.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_NewHorn_descriptor;
        }

        @Override // cn.irisgw.live.NewHornOrBuilder
        public int getEffect() {
            return this.effect_;
        }

        @Override // cn.irisgw.live.NewHornOrBuilder
        public String getGiftApng() {
            Object obj = this.giftApng_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.giftApng_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.NewHornOrBuilder
        public ByteString getGiftApngBytes() {
            Object obj = this.giftApng_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.giftApng_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.NewHornOrBuilder
        public String getGiftMp4() {
            Object obj = this.giftMp4_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.giftMp4_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.NewHornOrBuilder
        public ByteString getGiftMp4Bytes() {
            Object obj = this.giftMp4_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.giftMp4_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.NewHornOrBuilder
        public String getHeadImage() {
            Object obj = this.headImage_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.headImage_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.NewHornOrBuilder
        public ByteString getHeadImageBytes() {
            Object obj = this.headImage_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.headImage_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.NewHornOrBuilder
        public String getHighlightColor() {
            Object obj = this.highlightColor_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.highlightColor_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.NewHornOrBuilder
        public ByteString getHighlightColorBytes() {
            Object obj = this.highlightColor_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.highlightColor_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.NewHornOrBuilder
        public String getIconImage() {
            Object obj = this.iconImage_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.iconImage_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.NewHornOrBuilder
        public ByteString getIconImageBytes() {
            Object obj = this.iconImage_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.iconImage_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.NewHornOrBuilder
        public String getLid() {
            Object obj = this.lid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.lid_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.NewHornOrBuilder
        public ByteString getLidBytes() {
            Object obj = this.lid_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.lid_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.NewHornOrBuilder
        public String getLink() {
            Object obj = this.link_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.link_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.NewHornOrBuilder
        public ByteString getLinkBytes() {
            Object obj = this.link_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.link_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.NewHornOrBuilder
        public int getLinkType() {
            return this.linkType_;
        }

        @Override // cn.irisgw.live.NewHornOrBuilder
        public int getPosition() {
            return this.position_;
        }

        @Override // cn.irisgw.live.NewHornOrBuilder
        public String getRedirectUrl() {
            Object obj = this.redirectUrl_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.redirectUrl_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.NewHornOrBuilder
        public ByteString getRedirectUrlBytes() {
            Object obj = this.redirectUrl_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.redirectUrl_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.NewHornOrBuilder
        public String getReportId() {
            Object obj = this.reportId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.reportId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.NewHornOrBuilder
        public ByteString getReportIdBytes() {
            Object obj = this.reportId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.reportId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.NewHornOrBuilder
        public int getScene() {
            return this.scene_;
        }

        @Override // cn.irisgw.live.NewHornOrBuilder
        public String getTailImage() {
            Object obj = this.tailImage_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.tailImage_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.NewHornOrBuilder
        public ByteString getTailImageBytes() {
            Object obj = this.tailImage_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.tailImage_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.NewHornOrBuilder
        public String getUid() {
            Object obj = this.uid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.uid_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.NewHornOrBuilder
        public ByteString getUidBytes() {
            Object obj = this.uid_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.uid_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_NewHorn_fieldAccessorTable.ensureFieldAccessorsInitialized(NewHorn.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(NewHorn newHorn) {
            if (newHorn == NewHorn.getDefaultInstance()) {
                return this;
            }
            if (newHorn.getScene() != 0) {
                setScene(newHorn.getScene());
            }
            if (!newHorn.getIconImage().isEmpty()) {
                this.iconImage_ = newHorn.iconImage_;
                onChanged();
            }
            if (!newHorn.getHeadImage().isEmpty()) {
                this.headImage_ = newHorn.headImage_;
                onChanged();
            }
            if (!newHorn.getBackImage().isEmpty()) {
                this.backImage_ = newHorn.backImage_;
                onChanged();
            }
            if (!newHorn.getTailImage().isEmpty()) {
                this.tailImage_ = newHorn.tailImage_;
                onChanged();
            }
            if (!newHorn.getRedirectUrl().isEmpty()) {
                this.redirectUrl_ = newHorn.redirectUrl_;
                onChanged();
            }
            if (!newHorn.getContents().isEmpty()) {
                this.contents_ = newHorn.contents_;
                onChanged();
            }
            if (!newHorn.getColor().isEmpty()) {
                this.color_ = newHorn.color_;
                onChanged();
            }
            if (!newHorn.getHighlightColor().isEmpty()) {
                this.highlightColor_ = newHorn.highlightColor_;
                onChanged();
            }
            if (!newHorn.getGiftApng().isEmpty()) {
                this.giftApng_ = newHorn.giftApng_;
                onChanged();
            }
            if (!newHorn.getGiftMp4().isEmpty()) {
                this.giftMp4_ = newHorn.giftMp4_;
                onChanged();
            }
            if (!newHorn.getUid().isEmpty()) {
                this.uid_ = newHorn.uid_;
                onChanged();
            }
            if (!newHorn.getLid().isEmpty()) {
                this.lid_ = newHorn.lid_;
                onChanged();
            }
            if (newHorn.getPosition() != 0) {
                setPosition(newHorn.getPosition());
            }
            if (!newHorn.getReportId().isEmpty()) {
                this.reportId_ = newHorn.reportId_;
                onChanged();
            }
            if (newHorn.getEffect() != 0) {
                setEffect(newHorn.getEffect());
            }
            if (newHorn.getLinkType() != 0) {
                setLinkType(newHorn.getLinkType());
            }
            if (!newHorn.getLink().isEmpty()) {
                this.link_ = newHorn.link_;
                onChanged();
            }
            mergeUnknownFields(newHorn.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.NewHorn.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.NewHorn.access$2300()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.NewHorn r0 = (cn.irisgw.live.NewHorn) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.NewHorn$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.NewHorn r0 = (cn.irisgw.live.NewHorn) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.NewHorn$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.NewHorn.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.NewHorn$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof NewHorn) {
                return mergeFrom((NewHorn) message);
            }
            super.mergeFrom(message);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setBackImage(String str) {
            if (str != null) {
                this.backImage_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setBackImageBytes(ByteString byteString) {
            if (byteString != null) {
                NewHorn.checkByteStringIsUtf8(byteString);
                this.backImage_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setColor(String str) {
            if (str != null) {
                this.color_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setColorBytes(ByteString byteString) {
            if (byteString != null) {
                NewHorn.checkByteStringIsUtf8(byteString);
                this.color_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setContents(String str) {
            if (str != null) {
                this.contents_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setContentsBytes(ByteString byteString) {
            if (byteString != null) {
                NewHorn.checkByteStringIsUtf8(byteString);
                this.contents_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setEffect(int i) {
            this.effect_ = i;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setGiftApng(String str) {
            if (str != null) {
                this.giftApng_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setGiftApngBytes(ByteString byteString) {
            if (byteString != null) {
                NewHorn.checkByteStringIsUtf8(byteString);
                this.giftApng_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setGiftMp4(String str) {
            if (str != null) {
                this.giftMp4_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setGiftMp4Bytes(ByteString byteString) {
            if (byteString != null) {
                NewHorn.checkByteStringIsUtf8(byteString);
                this.giftMp4_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setHeadImage(String str) {
            if (str != null) {
                this.headImage_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setHeadImageBytes(ByteString byteString) {
            if (byteString != null) {
                NewHorn.checkByteStringIsUtf8(byteString);
                this.headImage_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setHighlightColor(String str) {
            if (str != null) {
                this.highlightColor_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setHighlightColorBytes(ByteString byteString) {
            if (byteString != null) {
                NewHorn.checkByteStringIsUtf8(byteString);
                this.highlightColor_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setIconImage(String str) {
            if (str != null) {
                this.iconImage_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setIconImageBytes(ByteString byteString) {
            if (byteString != null) {
                NewHorn.checkByteStringIsUtf8(byteString);
                this.iconImage_ = byteString;
                onChanged();
                return this;
            }
            throw null;
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
                NewHorn.checkByteStringIsUtf8(byteString);
                this.lid_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setLink(String str) {
            if (str != null) {
                this.link_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setLinkBytes(ByteString byteString) {
            if (byteString != null) {
                NewHorn.checkByteStringIsUtf8(byteString);
                this.link_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setLinkType(int i) {
            this.linkType_ = i;
            onChanged();
            return this;
        }

        public Builder setPosition(int i) {
            this.position_ = i;
            onChanged();
            return this;
        }

        public Builder setRedirectUrl(String str) {
            if (str != null) {
                this.redirectUrl_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setRedirectUrlBytes(ByteString byteString) {
            if (byteString != null) {
                NewHorn.checkByteStringIsUtf8(byteString);
                this.redirectUrl_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setReportId(String str) {
            if (str != null) {
                this.reportId_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setReportIdBytes(ByteString byteString) {
            if (byteString != null) {
                NewHorn.checkByteStringIsUtf8(byteString);
                this.reportId_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setScene(int i) {
            this.scene_ = i;
            onChanged();
            return this;
        }

        public Builder setTailImage(String str) {
            if (str != null) {
                this.tailImage_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setTailImageBytes(ByteString byteString) {
            if (byteString != null) {
                NewHorn.checkByteStringIsUtf8(byteString);
                this.tailImage_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setUid(String str) {
            if (str != null) {
                this.uid_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setUidBytes(ByteString byteString) {
            if (byteString != null) {
                NewHorn.checkByteStringIsUtf8(byteString);
                this.uid_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private NewHorn() {
        this.memoizedIsInitialized = (byte) -1;
        this.iconImage_ = "";
        this.headImage_ = "";
        this.backImage_ = "";
        this.tailImage_ = "";
        this.redirectUrl_ = "";
        this.contents_ = "";
        this.color_ = "";
        this.highlightColor_ = "";
        this.giftApng_ = "";
        this.giftMp4_ = "";
        this.uid_ = "";
        this.lid_ = "";
        this.reportId_ = "";
        this.link_ = "";
    }

    private NewHorn(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            this.scene_ = codedInputStream.readUInt32();
                            continue;
                        case 18:
                            this.iconImage_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 26:
                            this.headImage_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 34:
                            this.backImage_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 42:
                            this.tailImage_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 50:
                            this.redirectUrl_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 58:
                            this.contents_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 66:
                            this.color_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 74:
                            this.highlightColor_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 82:
                            this.giftApng_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 90:
                            this.giftMp4_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 98:
                            this.uid_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 106:
                            this.lid_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 112:
                            this.position_ = codedInputStream.readUInt32();
                            continue;
                        case 122:
                            this.reportId_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 128:
                            this.effect_ = codedInputStream.readUInt32();
                            continue;
                        case 136:
                            this.linkType_ = codedInputStream.readUInt32();
                            continue;
                        case 146:
                            this.link_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        default:
                            if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                break;
                            } else {
                                continue;
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

    private NewHorn(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static NewHorn getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_NewHorn_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(NewHorn newHorn) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(newHorn);
    }

    public static NewHorn parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (NewHorn) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static NewHorn parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (NewHorn) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static NewHorn parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static NewHorn parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static NewHorn parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (NewHorn) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static NewHorn parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (NewHorn) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static NewHorn parseFrom(InputStream inputStream) throws IOException {
        return (NewHorn) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static NewHorn parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (NewHorn) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static NewHorn parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static NewHorn parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static NewHorn parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static NewHorn parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<NewHorn> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NewHorn) {
            NewHorn newHorn = (NewHorn) obj;
            return getScene() == newHorn.getScene() && getIconImage().equals(newHorn.getIconImage()) && getHeadImage().equals(newHorn.getHeadImage()) && getBackImage().equals(newHorn.getBackImage()) && getTailImage().equals(newHorn.getTailImage()) && getRedirectUrl().equals(newHorn.getRedirectUrl()) && getContents().equals(newHorn.getContents()) && getColor().equals(newHorn.getColor()) && getHighlightColor().equals(newHorn.getHighlightColor()) && getGiftApng().equals(newHorn.getGiftApng()) && getGiftMp4().equals(newHorn.getGiftMp4()) && getUid().equals(newHorn.getUid()) && getLid().equals(newHorn.getLid()) && getPosition() == newHorn.getPosition() && getReportId().equals(newHorn.getReportId()) && getEffect() == newHorn.getEffect() && getLinkType() == newHorn.getLinkType() && getLink().equals(newHorn.getLink()) && this.unknownFields.equals(newHorn.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.NewHornOrBuilder
    public String getBackImage() {
        Object obj = this.backImage_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.backImage_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.NewHornOrBuilder
    public ByteString getBackImageBytes() {
        Object obj = this.backImage_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.backImage_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.NewHornOrBuilder
    public String getColor() {
        Object obj = this.color_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.color_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.NewHornOrBuilder
    public ByteString getColorBytes() {
        Object obj = this.color_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.color_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.NewHornOrBuilder
    public String getContents() {
        Object obj = this.contents_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.contents_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.NewHornOrBuilder
    public ByteString getContentsBytes() {
        Object obj = this.contents_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.contents_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public NewHorn getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.NewHornOrBuilder
    public int getEffect() {
        return this.effect_;
    }

    @Override // cn.irisgw.live.NewHornOrBuilder
    public String getGiftApng() {
        Object obj = this.giftApng_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.giftApng_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.NewHornOrBuilder
    public ByteString getGiftApngBytes() {
        Object obj = this.giftApng_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.giftApng_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.NewHornOrBuilder
    public String getGiftMp4() {
        Object obj = this.giftMp4_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.giftMp4_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.NewHornOrBuilder
    public ByteString getGiftMp4Bytes() {
        Object obj = this.giftMp4_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.giftMp4_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.NewHornOrBuilder
    public String getHeadImage() {
        Object obj = this.headImage_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.headImage_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.NewHornOrBuilder
    public ByteString getHeadImageBytes() {
        Object obj = this.headImage_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.headImage_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.NewHornOrBuilder
    public String getHighlightColor() {
        Object obj = this.highlightColor_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.highlightColor_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.NewHornOrBuilder
    public ByteString getHighlightColorBytes() {
        Object obj = this.highlightColor_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.highlightColor_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.NewHornOrBuilder
    public String getIconImage() {
        Object obj = this.iconImage_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.iconImage_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.NewHornOrBuilder
    public ByteString getIconImageBytes() {
        Object obj = this.iconImage_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.iconImage_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.NewHornOrBuilder
    public String getLid() {
        Object obj = this.lid_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.lid_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.NewHornOrBuilder
    public ByteString getLidBytes() {
        Object obj = this.lid_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.lid_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.NewHornOrBuilder
    public String getLink() {
        Object obj = this.link_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.link_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.NewHornOrBuilder
    public ByteString getLinkBytes() {
        Object obj = this.link_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.link_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.NewHornOrBuilder
    public int getLinkType() {
        return this.linkType_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<NewHorn> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.NewHornOrBuilder
    public int getPosition() {
        return this.position_;
    }

    @Override // cn.irisgw.live.NewHornOrBuilder
    public String getRedirectUrl() {
        Object obj = this.redirectUrl_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.redirectUrl_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.NewHornOrBuilder
    public ByteString getRedirectUrlBytes() {
        Object obj = this.redirectUrl_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.redirectUrl_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.NewHornOrBuilder
    public String getReportId() {
        Object obj = this.reportId_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.reportId_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.NewHornOrBuilder
    public ByteString getReportIdBytes() {
        Object obj = this.reportId_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.reportId_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.NewHornOrBuilder
    public int getScene() {
        return this.scene_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        int i3 = this.scene_;
        if (i3 != 0) {
            i2 = 0 + CodedOutputStream.computeUInt32Size(1, i3);
        }
        int i4 = i2;
        if (!getIconImageBytes().isEmpty()) {
            i4 = i2 + GeneratedMessageV3.computeStringSize(2, this.iconImage_);
        }
        int i5 = i4;
        if (!getHeadImageBytes().isEmpty()) {
            i5 = i4 + GeneratedMessageV3.computeStringSize(3, this.headImage_);
        }
        int i6 = i5;
        if (!getBackImageBytes().isEmpty()) {
            i6 = i5 + GeneratedMessageV3.computeStringSize(4, this.backImage_);
        }
        int i7 = i6;
        if (!getTailImageBytes().isEmpty()) {
            i7 = i6 + GeneratedMessageV3.computeStringSize(5, this.tailImage_);
        }
        int i8 = i7;
        if (!getRedirectUrlBytes().isEmpty()) {
            i8 = i7 + GeneratedMessageV3.computeStringSize(6, this.redirectUrl_);
        }
        int i9 = i8;
        if (!getContentsBytes().isEmpty()) {
            i9 = i8 + GeneratedMessageV3.computeStringSize(7, this.contents_);
        }
        int i10 = i9;
        if (!getColorBytes().isEmpty()) {
            i10 = i9 + GeneratedMessageV3.computeStringSize(8, this.color_);
        }
        int i11 = i10;
        if (!getHighlightColorBytes().isEmpty()) {
            i11 = i10 + GeneratedMessageV3.computeStringSize(9, this.highlightColor_);
        }
        int i12 = i11;
        if (!getGiftApngBytes().isEmpty()) {
            i12 = i11 + GeneratedMessageV3.computeStringSize(10, this.giftApng_);
        }
        int i13 = i12;
        if (!getGiftMp4Bytes().isEmpty()) {
            i13 = i12 + GeneratedMessageV3.computeStringSize(11, this.giftMp4_);
        }
        int i14 = i13;
        if (!getUidBytes().isEmpty()) {
            i14 = i13 + GeneratedMessageV3.computeStringSize(12, this.uid_);
        }
        int i15 = i14;
        if (!getLidBytes().isEmpty()) {
            i15 = i14 + GeneratedMessageV3.computeStringSize(13, this.lid_);
        }
        int i16 = this.position_;
        int i17 = i15;
        if (i16 != 0) {
            i17 = i15 + CodedOutputStream.computeUInt32Size(14, i16);
        }
        int i18 = i17;
        if (!getReportIdBytes().isEmpty()) {
            i18 = i17 + GeneratedMessageV3.computeStringSize(15, this.reportId_);
        }
        int i19 = this.effect_;
        int i20 = i18;
        if (i19 != 0) {
            i20 = i18 + CodedOutputStream.computeUInt32Size(16, i19);
        }
        int i21 = this.linkType_;
        int i22 = i20;
        if (i21 != 0) {
            i22 = i20 + CodedOutputStream.computeUInt32Size(17, i21);
        }
        int i23 = i22;
        if (!getLinkBytes().isEmpty()) {
            i23 = i22 + GeneratedMessageV3.computeStringSize(18, this.link_);
        }
        int serializedSize = i23 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.NewHornOrBuilder
    public String getTailImage() {
        Object obj = this.tailImage_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.tailImage_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.NewHornOrBuilder
    public ByteString getTailImageBytes() {
        Object obj = this.tailImage_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.tailImage_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.NewHornOrBuilder
    public String getUid() {
        Object obj = this.uid_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.uid_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.NewHornOrBuilder
    public ByteString getUidBytes() {
        Object obj = this.uid_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.uid_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
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
        int hashCode = ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getScene()) * 37) + 2) * 53) + getIconImage().hashCode()) * 37) + 3) * 53) + getHeadImage().hashCode()) * 37) + 4) * 53) + getBackImage().hashCode()) * 37) + 5) * 53) + getTailImage().hashCode()) * 37) + 6) * 53) + getRedirectUrl().hashCode()) * 37) + 7) * 53) + getContents().hashCode()) * 37) + 8) * 53) + getColor().hashCode()) * 37) + 9) * 53) + getHighlightColor().hashCode()) * 37) + 10) * 53) + getGiftApng().hashCode()) * 37) + 11) * 53) + getGiftMp4().hashCode()) * 37) + 12) * 53) + getUid().hashCode()) * 37) + 13) * 53) + getLid().hashCode()) * 37) + 14) * 53) + getPosition()) * 37) + 15) * 53) + getReportId().hashCode()) * 37) + 16) * 53) + getEffect()) * 37) + 17) * 53) + getLinkType()) * 37) + 18) * 53) + getLink().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_NewHorn_fieldAccessorTable.ensureFieldAccessorsInitialized(NewHorn.class, Builder.class);
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
        return new NewHorn();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.scene_;
        if (i != 0) {
            codedOutputStream.writeUInt32(1, i);
        }
        if (!getIconImageBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.iconImage_);
        }
        if (!getHeadImageBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 3, this.headImage_);
        }
        if (!getBackImageBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 4, this.backImage_);
        }
        if (!getTailImageBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 5, this.tailImage_);
        }
        if (!getRedirectUrlBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 6, this.redirectUrl_);
        }
        if (!getContentsBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 7, this.contents_);
        }
        if (!getColorBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 8, this.color_);
        }
        if (!getHighlightColorBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 9, this.highlightColor_);
        }
        if (!getGiftApngBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 10, this.giftApng_);
        }
        if (!getGiftMp4Bytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 11, this.giftMp4_);
        }
        if (!getUidBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 12, this.uid_);
        }
        if (!getLidBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 13, this.lid_);
        }
        int i2 = this.position_;
        if (i2 != 0) {
            codedOutputStream.writeUInt32(14, i2);
        }
        if (!getReportIdBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 15, this.reportId_);
        }
        int i3 = this.effect_;
        if (i3 != 0) {
            codedOutputStream.writeUInt32(16, i3);
        }
        int i4 = this.linkType_;
        if (i4 != 0) {
            codedOutputStream.writeUInt32(17, i4);
        }
        if (!getLinkBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 18, this.link_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
