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
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/HornExtra.class */
public final class HornExtra extends GeneratedMessageV3 implements HornExtraOrBuilder {
    public static final int COLOR_FIELD_NUMBER = 3;
    public static final int GIFT_APNG_FIELD_NUMBER = 6;
    public static final int GIFT_MP4_FIELD_NUMBER = 8;
    public static final int HIGHLIGHT_FIELD_NUMBER = 5;
    public static final int HIGHLIGHT_NEW_FIELD_NUMBER = 7;
    public static final int IS_HONGBAO_FIELD_NUMBER = 2;
    public static final int IS_WIN_STREAK_FIELD_NUMBER = 9;
    public static final int LID_FIELD_NUMBER = 11;
    public static final int NOTIFY_ICON_FIELD_NUMBER = 4;
    public static final int TYPE_FIELD_NUMBER = 1;
    public static final int UID_FIELD_NUMBER = 10;
    private static final long serialVersionUID = 0;
    private volatile Object color_;
    private volatile Object giftApng_;
    private volatile Object giftMp4_;
    private volatile Object highlightNew_;
    private volatile Object highlight_;
    private boolean isHongbao_;
    private boolean isWinStreak_;
    private volatile Object lid_;
    private byte memoizedIsInitialized;
    private volatile Object notifyIcon_;
    private int type_;
    private volatile Object uid_;
    private static final HornExtra DEFAULT_INSTANCE = new HornExtra();
    private static final Parser<HornExtra> PARSER = new AbstractParser<HornExtra>() { // from class: cn.irisgw.live.HornExtra.1
        @Override // com.google.protobuf.Parser
        public HornExtra parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new HornExtra(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/HornExtra$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HornExtraOrBuilder {
        private Object color_;
        private Object giftApng_;
        private Object giftMp4_;
        private Object highlightNew_;
        private Object highlight_;
        private boolean isHongbao_;
        private boolean isWinStreak_;
        private Object lid_;
        private Object notifyIcon_;
        private int type_;
        private Object uid_;

        private Builder() {
            this.color_ = "";
            this.notifyIcon_ = "";
            this.highlight_ = "";
            this.giftApng_ = "";
            this.highlightNew_ = "";
            this.giftMp4_ = "";
            this.uid_ = "";
            this.lid_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.color_ = "";
            this.notifyIcon_ = "";
            this.highlight_ = "";
            this.giftApng_ = "";
            this.highlightNew_ = "";
            this.giftMp4_ = "";
            this.uid_ = "";
            this.lid_ = "";
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_HornExtra_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = HornExtra.alwaysUseFieldBuilders;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public HornExtra build() {
            HornExtra buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public HornExtra buildPartial() {
            HornExtra hornExtra = new HornExtra(this);
            hornExtra.type_ = this.type_;
            hornExtra.isHongbao_ = this.isHongbao_;
            hornExtra.color_ = this.color_;
            hornExtra.notifyIcon_ = this.notifyIcon_;
            hornExtra.highlight_ = this.highlight_;
            hornExtra.giftApng_ = this.giftApng_;
            hornExtra.highlightNew_ = this.highlightNew_;
            hornExtra.giftMp4_ = this.giftMp4_;
            hornExtra.isWinStreak_ = this.isWinStreak_;
            hornExtra.uid_ = this.uid_;
            hornExtra.lid_ = this.lid_;
            onBuilt();
            return hornExtra;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.type_ = 0;
            this.isHongbao_ = false;
            this.color_ = "";
            this.notifyIcon_ = "";
            this.highlight_ = "";
            this.giftApng_ = "";
            this.highlightNew_ = "";
            this.giftMp4_ = "";
            this.isWinStreak_ = false;
            this.uid_ = "";
            this.lid_ = "";
            return this;
        }

        public Builder clearColor() {
            this.color_ = HornExtra.getDefaultInstance().getColor();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearGiftApng() {
            this.giftApng_ = HornExtra.getDefaultInstance().getGiftApng();
            onChanged();
            return this;
        }

        public Builder clearGiftMp4() {
            this.giftMp4_ = HornExtra.getDefaultInstance().getGiftMp4();
            onChanged();
            return this;
        }

        public Builder clearHighlight() {
            this.highlight_ = HornExtra.getDefaultInstance().getHighlight();
            onChanged();
            return this;
        }

        public Builder clearHighlightNew() {
            this.highlightNew_ = HornExtra.getDefaultInstance().getHighlightNew();
            onChanged();
            return this;
        }

        public Builder clearIsHongbao() {
            this.isHongbao_ = false;
            onChanged();
            return this;
        }

        public Builder clearIsWinStreak() {
            this.isWinStreak_ = false;
            onChanged();
            return this;
        }

        public Builder clearLid() {
            this.lid_ = HornExtra.getDefaultInstance().getLid();
            onChanged();
            return this;
        }

        public Builder clearNotifyIcon() {
            this.notifyIcon_ = HornExtra.getDefaultInstance().getNotifyIcon();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearType() {
            this.type_ = 0;
            onChanged();
            return this;
        }

        public Builder clearUid() {
            this.uid_ = HornExtra.getDefaultInstance().getUid();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo1800clone() {
            return (Builder) super.mo1800clone();
        }

        @Override // cn.irisgw.live.HornExtraOrBuilder
        public String getColor() {
            Object obj = this.color_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.color_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.HornExtraOrBuilder
        public ByteString getColorBytes() {
            Object obj = this.color_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.color_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HornExtra getDefaultInstanceForType() {
            return HornExtra.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_HornExtra_descriptor;
        }

        @Override // cn.irisgw.live.HornExtraOrBuilder
        public String getGiftApng() {
            Object obj = this.giftApng_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.giftApng_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.HornExtraOrBuilder
        public ByteString getGiftApngBytes() {
            Object obj = this.giftApng_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.giftApng_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.HornExtraOrBuilder
        public String getGiftMp4() {
            Object obj = this.giftMp4_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.giftMp4_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.HornExtraOrBuilder
        public ByteString getGiftMp4Bytes() {
            Object obj = this.giftMp4_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.giftMp4_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.HornExtraOrBuilder
        public String getHighlight() {
            Object obj = this.highlight_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.highlight_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.HornExtraOrBuilder
        public ByteString getHighlightBytes() {
            Object obj = this.highlight_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.highlight_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.HornExtraOrBuilder
        public String getHighlightNew() {
            Object obj = this.highlightNew_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.highlightNew_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.HornExtraOrBuilder
        public ByteString getHighlightNewBytes() {
            Object obj = this.highlightNew_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.highlightNew_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.HornExtraOrBuilder
        public boolean getIsHongbao() {
            return this.isHongbao_;
        }

        @Override // cn.irisgw.live.HornExtraOrBuilder
        public boolean getIsWinStreak() {
            return this.isWinStreak_;
        }

        @Override // cn.irisgw.live.HornExtraOrBuilder
        public String getLid() {
            Object obj = this.lid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.lid_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.HornExtraOrBuilder
        public ByteString getLidBytes() {
            Object obj = this.lid_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.lid_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.HornExtraOrBuilder
        public String getNotifyIcon() {
            Object obj = this.notifyIcon_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.notifyIcon_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.HornExtraOrBuilder
        public ByteString getNotifyIconBytes() {
            Object obj = this.notifyIcon_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.notifyIcon_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.HornExtraOrBuilder
        public int getType() {
            return this.type_;
        }

        @Override // cn.irisgw.live.HornExtraOrBuilder
        public String getUid() {
            Object obj = this.uid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.uid_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.HornExtraOrBuilder
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
            return LiveConstants.internal_static_cn_irisgw_live_HornExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(HornExtra.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(HornExtra hornExtra) {
            if (hornExtra == HornExtra.getDefaultInstance()) {
                return this;
            }
            if (hornExtra.getType() != 0) {
                setType(hornExtra.getType());
            }
            if (hornExtra.getIsHongbao()) {
                setIsHongbao(hornExtra.getIsHongbao());
            }
            if (!hornExtra.getColor().isEmpty()) {
                this.color_ = hornExtra.color_;
                onChanged();
            }
            if (!hornExtra.getNotifyIcon().isEmpty()) {
                this.notifyIcon_ = hornExtra.notifyIcon_;
                onChanged();
            }
            if (!hornExtra.getHighlight().isEmpty()) {
                this.highlight_ = hornExtra.highlight_;
                onChanged();
            }
            if (!hornExtra.getGiftApng().isEmpty()) {
                this.giftApng_ = hornExtra.giftApng_;
                onChanged();
            }
            if (!hornExtra.getHighlightNew().isEmpty()) {
                this.highlightNew_ = hornExtra.highlightNew_;
                onChanged();
            }
            if (!hornExtra.getGiftMp4().isEmpty()) {
                this.giftMp4_ = hornExtra.giftMp4_;
                onChanged();
            }
            if (hornExtra.getIsWinStreak()) {
                setIsWinStreak(hornExtra.getIsWinStreak());
            }
            if (!hornExtra.getUid().isEmpty()) {
                this.uid_ = hornExtra.uid_;
                onChanged();
            }
            if (!hornExtra.getLid().isEmpty()) {
                this.lid_ = hornExtra.lid_;
                onChanged();
            }
            mergeUnknownFields(hornExtra.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.HornExtra.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.HornExtra.access$1600()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.HornExtra r0 = (cn.irisgw.live.HornExtra) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.HornExtra$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.HornExtra r0 = (cn.irisgw.live.HornExtra) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.HornExtra$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.HornExtra.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.HornExtra$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof HornExtra) {
                return mergeFrom((HornExtra) message);
            }
            super.mergeFrom(message);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
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
                HornExtra.checkByteStringIsUtf8(byteString);
                this.color_ = byteString;
                onChanged();
                return this;
            }
            throw null;
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
                HornExtra.checkByteStringIsUtf8(byteString);
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
                HornExtra.checkByteStringIsUtf8(byteString);
                this.giftMp4_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setHighlight(String str) {
            if (str != null) {
                this.highlight_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setHighlightBytes(ByteString byteString) {
            if (byteString != null) {
                HornExtra.checkByteStringIsUtf8(byteString);
                this.highlight_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setHighlightNew(String str) {
            if (str != null) {
                this.highlightNew_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setHighlightNewBytes(ByteString byteString) {
            if (byteString != null) {
                HornExtra.checkByteStringIsUtf8(byteString);
                this.highlightNew_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setIsHongbao(boolean z) {
            this.isHongbao_ = z;
            onChanged();
            return this;
        }

        public Builder setIsWinStreak(boolean z) {
            this.isWinStreak_ = z;
            onChanged();
            return this;
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
                HornExtra.checkByteStringIsUtf8(byteString);
                this.lid_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setNotifyIcon(String str) {
            if (str != null) {
                this.notifyIcon_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setNotifyIconBytes(ByteString byteString) {
            if (byteString != null) {
                HornExtra.checkByteStringIsUtf8(byteString);
                this.notifyIcon_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setType(int i) {
            this.type_ = i;
            onChanged();
            return this;
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
                HornExtra.checkByteStringIsUtf8(byteString);
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

    private HornExtra() {
        this.memoizedIsInitialized = (byte) -1;
        this.color_ = "";
        this.notifyIcon_ = "";
        this.highlight_ = "";
        this.giftApng_ = "";
        this.highlightNew_ = "";
        this.giftMp4_ = "";
        this.uid_ = "";
        this.lid_ = "";
    }

    private HornExtra(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                        switch (readTag) {
                            case 0:
                                break;
                            case 8:
                                this.type_ = codedInputStream.readUInt32();
                                continue;
                            case 16:
                                this.isHongbao_ = codedInputStream.readBool();
                                continue;
                            case 26:
                                this.color_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 34:
                                this.notifyIcon_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 42:
                                this.highlight_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 50:
                                this.giftApng_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 58:
                                this.highlightNew_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 66:
                                this.giftMp4_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 72:
                                this.isWinStreak_ = codedInputStream.readBool();
                                continue;
                            case 82:
                                this.uid_ = codedInputStream.readStringRequireUtf8();
                                continue;
                            case 90:
                                this.lid_ = codedInputStream.readStringRequireUtf8();
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

    private HornExtra(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static HornExtra getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_HornExtra_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(HornExtra hornExtra) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(hornExtra);
    }

    public static HornExtra parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (HornExtra) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static HornExtra parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HornExtra) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static HornExtra parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static HornExtra parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static HornExtra parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (HornExtra) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static HornExtra parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HornExtra) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static HornExtra parseFrom(InputStream inputStream) throws IOException {
        return (HornExtra) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static HornExtra parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HornExtra) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static HornExtra parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static HornExtra parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static HornExtra parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static HornExtra parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<HornExtra> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof HornExtra) {
            HornExtra hornExtra = (HornExtra) obj;
            return getType() == hornExtra.getType() && getIsHongbao() == hornExtra.getIsHongbao() && getColor().equals(hornExtra.getColor()) && getNotifyIcon().equals(hornExtra.getNotifyIcon()) && getHighlight().equals(hornExtra.getHighlight()) && getGiftApng().equals(hornExtra.getGiftApng()) && getHighlightNew().equals(hornExtra.getHighlightNew()) && getGiftMp4().equals(hornExtra.getGiftMp4()) && getIsWinStreak() == hornExtra.getIsWinStreak() && getUid().equals(hornExtra.getUid()) && getLid().equals(hornExtra.getLid()) && this.unknownFields.equals(hornExtra.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.HornExtraOrBuilder
    public String getColor() {
        Object obj = this.color_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.color_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.HornExtraOrBuilder
    public ByteString getColorBytes() {
        Object obj = this.color_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.color_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public HornExtra getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.HornExtraOrBuilder
    public String getGiftApng() {
        Object obj = this.giftApng_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.giftApng_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.HornExtraOrBuilder
    public ByteString getGiftApngBytes() {
        Object obj = this.giftApng_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.giftApng_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.HornExtraOrBuilder
    public String getGiftMp4() {
        Object obj = this.giftMp4_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.giftMp4_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.HornExtraOrBuilder
    public ByteString getGiftMp4Bytes() {
        Object obj = this.giftMp4_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.giftMp4_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.HornExtraOrBuilder
    public String getHighlight() {
        Object obj = this.highlight_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.highlight_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.HornExtraOrBuilder
    public ByteString getHighlightBytes() {
        Object obj = this.highlight_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.highlight_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.HornExtraOrBuilder
    public String getHighlightNew() {
        Object obj = this.highlightNew_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.highlightNew_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.HornExtraOrBuilder
    public ByteString getHighlightNewBytes() {
        Object obj = this.highlightNew_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.highlightNew_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.HornExtraOrBuilder
    public boolean getIsHongbao() {
        return this.isHongbao_;
    }

    @Override // cn.irisgw.live.HornExtraOrBuilder
    public boolean getIsWinStreak() {
        return this.isWinStreak_;
    }

    @Override // cn.irisgw.live.HornExtraOrBuilder
    public String getLid() {
        Object obj = this.lid_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.lid_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.HornExtraOrBuilder
    public ByteString getLidBytes() {
        Object obj = this.lid_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.lid_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.HornExtraOrBuilder
    public String getNotifyIcon() {
        Object obj = this.notifyIcon_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.notifyIcon_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.HornExtraOrBuilder
    public ByteString getNotifyIconBytes() {
        Object obj = this.notifyIcon_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.notifyIcon_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<HornExtra> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        int i3 = this.type_;
        if (i3 != 0) {
            i2 = 0 + CodedOutputStream.computeUInt32Size(1, i3);
        }
        boolean z = this.isHongbao_;
        int i4 = i2;
        if (z) {
            i4 = i2 + CodedOutputStream.computeBoolSize(2, z);
        }
        int i5 = i4;
        if (!getColorBytes().isEmpty()) {
            i5 = i4 + GeneratedMessageV3.computeStringSize(3, this.color_);
        }
        int i6 = i5;
        if (!getNotifyIconBytes().isEmpty()) {
            i6 = i5 + GeneratedMessageV3.computeStringSize(4, this.notifyIcon_);
        }
        int i7 = i6;
        if (!getHighlightBytes().isEmpty()) {
            i7 = i6 + GeneratedMessageV3.computeStringSize(5, this.highlight_);
        }
        int i8 = i7;
        if (!getGiftApngBytes().isEmpty()) {
            i8 = i7 + GeneratedMessageV3.computeStringSize(6, this.giftApng_);
        }
        int i9 = i8;
        if (!getHighlightNewBytes().isEmpty()) {
            i9 = i8 + GeneratedMessageV3.computeStringSize(7, this.highlightNew_);
        }
        int i10 = i9;
        if (!getGiftMp4Bytes().isEmpty()) {
            i10 = i9 + GeneratedMessageV3.computeStringSize(8, this.giftMp4_);
        }
        boolean z2 = this.isWinStreak_;
        int i11 = i10;
        if (z2) {
            i11 = i10 + CodedOutputStream.computeBoolSize(9, z2);
        }
        int i12 = i11;
        if (!getUidBytes().isEmpty()) {
            i12 = i11 + GeneratedMessageV3.computeStringSize(10, this.uid_);
        }
        int i13 = i12;
        if (!getLidBytes().isEmpty()) {
            i13 = i12 + GeneratedMessageV3.computeStringSize(11, this.lid_);
        }
        int serializedSize = i13 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.HornExtraOrBuilder
    public int getType() {
        return this.type_;
    }

    @Override // cn.irisgw.live.HornExtraOrBuilder
    public String getUid() {
        Object obj = this.uid_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.uid_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.HornExtraOrBuilder
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
        int hashCode = ((((((((((((((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getType()) * 37) + 2) * 53) + Internal.hashBoolean(getIsHongbao())) * 37) + 3) * 53) + getColor().hashCode()) * 37) + 4) * 53) + getNotifyIcon().hashCode()) * 37) + 5) * 53) + getHighlight().hashCode()) * 37) + 6) * 53) + getGiftApng().hashCode()) * 37) + 7) * 53) + getHighlightNew().hashCode()) * 37) + 8) * 53) + getGiftMp4().hashCode()) * 37) + 9) * 53) + Internal.hashBoolean(getIsWinStreak())) * 37) + 10) * 53) + getUid().hashCode()) * 37) + 11) * 53) + getLid().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_HornExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(HornExtra.class, Builder.class);
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
        return new HornExtra();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.type_;
        if (i != 0) {
            codedOutputStream.writeUInt32(1, i);
        }
        boolean z = this.isHongbao_;
        if (z) {
            codedOutputStream.writeBool(2, z);
        }
        if (!getColorBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 3, this.color_);
        }
        if (!getNotifyIconBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 4, this.notifyIcon_);
        }
        if (!getHighlightBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 5, this.highlight_);
        }
        if (!getGiftApngBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 6, this.giftApng_);
        }
        if (!getHighlightNewBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 7, this.highlightNew_);
        }
        if (!getGiftMp4Bytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 8, this.giftMp4_);
        }
        boolean z2 = this.isWinStreak_;
        if (z2) {
            codedOutputStream.writeBool(9, z2);
        }
        if (!getUidBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 10, this.uid_);
        }
        if (!getLidBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 11, this.lid_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
