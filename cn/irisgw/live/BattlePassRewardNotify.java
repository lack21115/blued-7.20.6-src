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
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/BattlePassRewardNotify.class */
public final class BattlePassRewardNotify extends GeneratedMessageV3 implements BattlePassRewardNotifyOrBuilder {
    public static final int BONUS_FIELD_NUMBER = 14;
    public static final int CHAT_FRAME_BORDER_COLOR_FIELD_NUMBER = 12;
    public static final int CHAT_FRAME_COLOR_TYPE_FIELD_NUMBER = 9;
    public static final int CHAT_FRAME_FIELD_NUMBER = 7;
    public static final int CHAT_FRAME_FRAME_COLOR_FIELD_NUMBER = 11;
    public static final int CHAT_FRAME_GRADIENT_TYPE_FIELD_NUMBER = 10;
    public static final int CHAT_FRAME_ICON_FIELD_NUMBER = 8;
    public static final int GOODS_COUNT_FIELD_NUMBER = 6;
    public static final int GOODS_ICON_FIELD_NUMBER = 5;
    public static final int GOODS_NAME_FIELD_NUMBER = 4;
    public static final int HIDE_FIELD_NUMBER = 13;
    public static final int LEVEL_FIELD_NUMBER = 3;
    public static final int NAME_FIELD_NUMBER = 2;
    public static final int UID_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private int bonus_;
    private LazyStringList chatFrameBorderColor_;
    private int chatFrameColorType_;
    private LazyStringList chatFrameFrameColor_;
    private int chatFrameGradientType_;
    private volatile Object chatFrameIcon_;
    private volatile Object chatFrame_;
    private int goodsCount_;
    private volatile Object goodsIcon_;
    private volatile Object goodsName_;
    private boolean hide_;
    private int level_;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private int uid_;
    private static final BattlePassRewardNotify DEFAULT_INSTANCE = new BattlePassRewardNotify();
    private static final Parser<BattlePassRewardNotify> PARSER = new AbstractParser<BattlePassRewardNotify>() { // from class: cn.irisgw.live.BattlePassRewardNotify.1
        /* renamed from: parsePartialFrom */
        public BattlePassRewardNotify m531parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new BattlePassRewardNotify(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/BattlePassRewardNotify$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BattlePassRewardNotifyOrBuilder {
        private int bitField0_;
        private int bonus_;
        private LazyStringList chatFrameBorderColor_;
        private int chatFrameColorType_;
        private LazyStringList chatFrameFrameColor_;
        private int chatFrameGradientType_;
        private Object chatFrameIcon_;
        private Object chatFrame_;
        private int goodsCount_;
        private Object goodsIcon_;
        private Object goodsName_;
        private boolean hide_;
        private int level_;
        private Object name_;
        private int uid_;

        private Builder() {
            this.name_ = "";
            this.goodsName_ = "";
            this.goodsIcon_ = "";
            this.chatFrame_ = "";
            this.chatFrameIcon_ = "";
            this.chatFrameFrameColor_ = LazyStringArrayList.EMPTY;
            this.chatFrameBorderColor_ = LazyStringArrayList.EMPTY;
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.name_ = "";
            this.goodsName_ = "";
            this.goodsIcon_ = "";
            this.chatFrame_ = "";
            this.chatFrameIcon_ = "";
            this.chatFrameFrameColor_ = LazyStringArrayList.EMPTY;
            this.chatFrameBorderColor_ = LazyStringArrayList.EMPTY;
            maybeForceBuilderInitialization();
        }

        private void ensureChatFrameBorderColorIsMutable() {
            if ((this.bitField0_ & 2) == 0) {
                this.chatFrameBorderColor_ = new LazyStringArrayList(this.chatFrameBorderColor_);
                this.bitField0_ |= 2;
            }
        }

        private void ensureChatFrameFrameColorIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.chatFrameFrameColor_ = new LazyStringArrayList(this.chatFrameFrameColor_);
                this.bitField0_ |= 1;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_BattlePassRewardNotify_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = BattlePassRewardNotify.alwaysUseFieldBuilders;
        }

        public Builder addAllChatFrameBorderColor(Iterable<String> iterable) {
            ensureChatFrameBorderColorIsMutable();
            AbstractMessageLite.Builder.addAll(iterable, this.chatFrameBorderColor_);
            onChanged();
            return this;
        }

        public Builder addAllChatFrameFrameColor(Iterable<String> iterable) {
            ensureChatFrameFrameColorIsMutable();
            AbstractMessageLite.Builder.addAll(iterable, this.chatFrameFrameColor_);
            onChanged();
            return this;
        }

        public Builder addChatFrameBorderColor(String str) {
            if (str != null) {
                ensureChatFrameBorderColorIsMutable();
                this.chatFrameBorderColor_.add(str);
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder addChatFrameBorderColorBytes(ByteString byteString) {
            if (byteString != null) {
                BattlePassRewardNotify.checkByteStringIsUtf8(byteString);
                ensureChatFrameBorderColorIsMutable();
                this.chatFrameBorderColor_.add(byteString);
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder addChatFrameFrameColor(String str) {
            if (str != null) {
                ensureChatFrameFrameColorIsMutable();
                this.chatFrameFrameColor_.add(str);
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder addChatFrameFrameColorBytes(ByteString byteString) {
            if (byteString != null) {
                BattlePassRewardNotify.checkByteStringIsUtf8(byteString);
                ensureChatFrameFrameColorIsMutable();
                this.chatFrameFrameColor_.add(byteString);
                onChanged();
                return this;
            }
            throw null;
        }

        /* renamed from: addRepeatedField */
        public Builder m533addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public BattlePassRewardNotify m535build() {
            BattlePassRewardNotify m537buildPartial = m537buildPartial();
            if (m537buildPartial.isInitialized()) {
                return m537buildPartial;
            }
            throw newUninitializedMessageException(m537buildPartial);
        }

        /* renamed from: buildPartial */
        public BattlePassRewardNotify m537buildPartial() {
            BattlePassRewardNotify battlePassRewardNotify = new BattlePassRewardNotify(this);
            battlePassRewardNotify.uid_ = this.uid_;
            battlePassRewardNotify.name_ = this.name_;
            battlePassRewardNotify.level_ = this.level_;
            battlePassRewardNotify.goodsName_ = this.goodsName_;
            battlePassRewardNotify.goodsIcon_ = this.goodsIcon_;
            battlePassRewardNotify.goodsCount_ = this.goodsCount_;
            battlePassRewardNotify.chatFrame_ = this.chatFrame_;
            battlePassRewardNotify.chatFrameIcon_ = this.chatFrameIcon_;
            battlePassRewardNotify.chatFrameColorType_ = this.chatFrameColorType_;
            battlePassRewardNotify.chatFrameGradientType_ = this.chatFrameGradientType_;
            if ((this.bitField0_ & 1) != 0) {
                this.chatFrameFrameColor_ = this.chatFrameFrameColor_.getUnmodifiableView();
                this.bitField0_ &= -2;
            }
            battlePassRewardNotify.chatFrameFrameColor_ = this.chatFrameFrameColor_;
            if ((this.bitField0_ & 2) != 0) {
                this.chatFrameBorderColor_ = this.chatFrameBorderColor_.getUnmodifiableView();
                this.bitField0_ &= -3;
            }
            battlePassRewardNotify.chatFrameBorderColor_ = this.chatFrameBorderColor_;
            battlePassRewardNotify.hide_ = this.hide_;
            battlePassRewardNotify.bonus_ = this.bonus_;
            onBuilt();
            return battlePassRewardNotify;
        }

        /* renamed from: clear */
        public Builder m541clear() {
            super.clear();
            this.uid_ = 0;
            this.name_ = "";
            this.level_ = 0;
            this.goodsName_ = "";
            this.goodsIcon_ = "";
            this.goodsCount_ = 0;
            this.chatFrame_ = "";
            this.chatFrameIcon_ = "";
            this.chatFrameColorType_ = 0;
            this.chatFrameGradientType_ = 0;
            this.chatFrameFrameColor_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -2;
            this.chatFrameBorderColor_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -3;
            this.hide_ = false;
            this.bonus_ = 0;
            return this;
        }

        public Builder clearBonus() {
            this.bonus_ = 0;
            onChanged();
            return this;
        }

        public Builder clearChatFrame() {
            this.chatFrame_ = BattlePassRewardNotify.getDefaultInstance().getChatFrame();
            onChanged();
            return this;
        }

        public Builder clearChatFrameBorderColor() {
            this.chatFrameBorderColor_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -3;
            onChanged();
            return this;
        }

        public Builder clearChatFrameColorType() {
            this.chatFrameColorType_ = 0;
            onChanged();
            return this;
        }

        public Builder clearChatFrameFrameColor() {
            this.chatFrameFrameColor_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder clearChatFrameGradientType() {
            this.chatFrameGradientType_ = 0;
            onChanged();
            return this;
        }

        public Builder clearChatFrameIcon() {
            this.chatFrameIcon_ = BattlePassRewardNotify.getDefaultInstance().getChatFrameIcon();
            onChanged();
            return this;
        }

        /* renamed from: clearField */
        public Builder m543clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearGoodsCount() {
            this.goodsCount_ = 0;
            onChanged();
            return this;
        }

        public Builder clearGoodsIcon() {
            this.goodsIcon_ = BattlePassRewardNotify.getDefaultInstance().getGoodsIcon();
            onChanged();
            return this;
        }

        public Builder clearGoodsName() {
            this.goodsName_ = BattlePassRewardNotify.getDefaultInstance().getGoodsName();
            onChanged();
            return this;
        }

        public Builder clearHide() {
            this.hide_ = false;
            onChanged();
            return this;
        }

        public Builder clearLevel() {
            this.level_ = 0;
            onChanged();
            return this;
        }

        public Builder clearName() {
            this.name_ = BattlePassRewardNotify.getDefaultInstance().getName();
            onChanged();
            return this;
        }

        /* renamed from: clearOneof */
        public Builder m546clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearUid() {
            this.uid_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m552clone() {
            return (Builder) super.clone();
        }

        @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
        public int getBonus() {
            return this.bonus_;
        }

        @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
        public String getChatFrame() {
            Object obj = this.chatFrame_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.chatFrame_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
        public String getChatFrameBorderColor(int i) {
            return (String) this.chatFrameBorderColor_.get(i);
        }

        @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
        public ByteString getChatFrameBorderColorBytes(int i) {
            return this.chatFrameBorderColor_.getByteString(i);
        }

        @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
        public int getChatFrameBorderColorCount() {
            return this.chatFrameBorderColor_.size();
        }

        @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
        /* renamed from: getChatFrameBorderColorList */
        public ProtocolStringList mo522getChatFrameBorderColorList() {
            return this.chatFrameBorderColor_.getUnmodifiableView();
        }

        @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
        public ByteString getChatFrameBytes() {
            Object obj = this.chatFrame_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.chatFrame_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
        public int getChatFrameColorType() {
            return this.chatFrameColorType_;
        }

        @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
        public String getChatFrameFrameColor(int i) {
            return (String) this.chatFrameFrameColor_.get(i);
        }

        @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
        public ByteString getChatFrameFrameColorBytes(int i) {
            return this.chatFrameFrameColor_.getByteString(i);
        }

        @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
        public int getChatFrameFrameColorCount() {
            return this.chatFrameFrameColor_.size();
        }

        @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
        /* renamed from: getChatFrameFrameColorList */
        public ProtocolStringList mo523getChatFrameFrameColorList() {
            return this.chatFrameFrameColor_.getUnmodifiableView();
        }

        @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
        public int getChatFrameGradientType() {
            return this.chatFrameGradientType_;
        }

        @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
        public String getChatFrameIcon() {
            Object obj = this.chatFrameIcon_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.chatFrameIcon_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
        public ByteString getChatFrameIconBytes() {
            Object obj = this.chatFrameIcon_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.chatFrameIcon_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        /* renamed from: getDefaultInstanceForType */
        public BattlePassRewardNotify m554getDefaultInstanceForType() {
            return BattlePassRewardNotify.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_BattlePassRewardNotify_descriptor;
        }

        @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
        public int getGoodsCount() {
            return this.goodsCount_;
        }

        @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
        public String getGoodsIcon() {
            Object obj = this.goodsIcon_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.goodsIcon_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
        public ByteString getGoodsIconBytes() {
            Object obj = this.goodsIcon_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.goodsIcon_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
        public String getGoodsName() {
            Object obj = this.goodsName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.goodsName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
        public ByteString getGoodsNameBytes() {
            Object obj = this.goodsName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.goodsName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
        public boolean getHide() {
            return this.hide_;
        }

        @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
        public int getLevel() {
            return this.level_;
        }

        @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
        public int getUid() {
            return this.uid_;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_BattlePassRewardNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(BattlePassRewardNotify.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(BattlePassRewardNotify battlePassRewardNotify) {
            if (battlePassRewardNotify == BattlePassRewardNotify.getDefaultInstance()) {
                return this;
            }
            if (battlePassRewardNotify.getUid() != 0) {
                setUid(battlePassRewardNotify.getUid());
            }
            if (!battlePassRewardNotify.getName().isEmpty()) {
                this.name_ = battlePassRewardNotify.name_;
                onChanged();
            }
            if (battlePassRewardNotify.getLevel() != 0) {
                setLevel(battlePassRewardNotify.getLevel());
            }
            if (!battlePassRewardNotify.getGoodsName().isEmpty()) {
                this.goodsName_ = battlePassRewardNotify.goodsName_;
                onChanged();
            }
            if (!battlePassRewardNotify.getGoodsIcon().isEmpty()) {
                this.goodsIcon_ = battlePassRewardNotify.goodsIcon_;
                onChanged();
            }
            if (battlePassRewardNotify.getGoodsCount() != 0) {
                setGoodsCount(battlePassRewardNotify.getGoodsCount());
            }
            if (!battlePassRewardNotify.getChatFrame().isEmpty()) {
                this.chatFrame_ = battlePassRewardNotify.chatFrame_;
                onChanged();
            }
            if (!battlePassRewardNotify.getChatFrameIcon().isEmpty()) {
                this.chatFrameIcon_ = battlePassRewardNotify.chatFrameIcon_;
                onChanged();
            }
            if (battlePassRewardNotify.getChatFrameColorType() != 0) {
                setChatFrameColorType(battlePassRewardNotify.getChatFrameColorType());
            }
            if (battlePassRewardNotify.getChatFrameGradientType() != 0) {
                setChatFrameGradientType(battlePassRewardNotify.getChatFrameGradientType());
            }
            if (!battlePassRewardNotify.chatFrameFrameColor_.isEmpty()) {
                if (this.chatFrameFrameColor_.isEmpty()) {
                    this.chatFrameFrameColor_ = battlePassRewardNotify.chatFrameFrameColor_;
                    this.bitField0_ &= -2;
                } else {
                    ensureChatFrameFrameColorIsMutable();
                    this.chatFrameFrameColor_.addAll(battlePassRewardNotify.chatFrameFrameColor_);
                }
                onChanged();
            }
            if (!battlePassRewardNotify.chatFrameBorderColor_.isEmpty()) {
                if (this.chatFrameBorderColor_.isEmpty()) {
                    this.chatFrameBorderColor_ = battlePassRewardNotify.chatFrameBorderColor_;
                    this.bitField0_ &= -3;
                } else {
                    ensureChatFrameBorderColorIsMutable();
                    this.chatFrameBorderColor_.addAll(battlePassRewardNotify.chatFrameBorderColor_);
                }
                onChanged();
            }
            if (battlePassRewardNotify.getHide()) {
                setHide(battlePassRewardNotify.getHide());
            }
            if (battlePassRewardNotify.getBonus() != 0) {
                setBonus(battlePassRewardNotify.getBonus());
            }
            m563mergeUnknownFields(battlePassRewardNotify.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.BattlePassRewardNotify.Builder m560mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.BattlePassRewardNotify.access$1900()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.BattlePassRewardNotify r0 = (cn.irisgw.live.BattlePassRewardNotify) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.BattlePassRewardNotify$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.BattlePassRewardNotify r0 = (cn.irisgw.live.BattlePassRewardNotify) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.BattlePassRewardNotify$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.BattlePassRewardNotify.Builder.m560mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.BattlePassRewardNotify$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m559mergeFrom(Message message) {
            if (message instanceof BattlePassRewardNotify) {
                return mergeFrom((BattlePassRewardNotify) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m563mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setBonus(int i) {
            this.bonus_ = i;
            onChanged();
            return this;
        }

        public Builder setChatFrame(String str) {
            if (str != null) {
                this.chatFrame_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setChatFrameBorderColor(int i, String str) {
            if (str != null) {
                ensureChatFrameBorderColorIsMutable();
                this.chatFrameBorderColor_.set(i, str);
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setChatFrameBytes(ByteString byteString) {
            if (byteString != null) {
                BattlePassRewardNotify.checkByteStringIsUtf8(byteString);
                this.chatFrame_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setChatFrameColorType(int i) {
            this.chatFrameColorType_ = i;
            onChanged();
            return this;
        }

        public Builder setChatFrameFrameColor(int i, String str) {
            if (str != null) {
                ensureChatFrameFrameColorIsMutable();
                this.chatFrameFrameColor_.set(i, str);
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setChatFrameGradientType(int i) {
            this.chatFrameGradientType_ = i;
            onChanged();
            return this;
        }

        public Builder setChatFrameIcon(String str) {
            if (str != null) {
                this.chatFrameIcon_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setChatFrameIconBytes(ByteString byteString) {
            if (byteString != null) {
                BattlePassRewardNotify.checkByteStringIsUtf8(byteString);
                this.chatFrameIcon_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        /* renamed from: setField */
        public Builder m565setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setGoodsCount(int i) {
            this.goodsCount_ = i;
            onChanged();
            return this;
        }

        public Builder setGoodsIcon(String str) {
            if (str != null) {
                this.goodsIcon_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setGoodsIconBytes(ByteString byteString) {
            if (byteString != null) {
                BattlePassRewardNotify.checkByteStringIsUtf8(byteString);
                this.goodsIcon_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setGoodsName(String str) {
            if (str != null) {
                this.goodsName_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setGoodsNameBytes(ByteString byteString) {
            if (byteString != null) {
                BattlePassRewardNotify.checkByteStringIsUtf8(byteString);
                this.goodsName_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setHide(boolean z) {
            this.hide_ = z;
            onChanged();
            return this;
        }

        public Builder setLevel(int i) {
            this.level_ = i;
            onChanged();
            return this;
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
                BattlePassRewardNotify.checkByteStringIsUtf8(byteString);
                this.name_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        /* renamed from: setRepeatedField */
        public Builder m567setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setUid(int i) {
            this.uid_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setUnknownFields */
        public final Builder m569setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private BattlePassRewardNotify() {
        this.memoizedIsInitialized = (byte) -1;
        this.name_ = "";
        this.goodsName_ = "";
        this.goodsIcon_ = "";
        this.chatFrame_ = "";
        this.chatFrameIcon_ = "";
        this.chatFrameFrameColor_ = LazyStringArrayList.EMPTY;
        this.chatFrameBorderColor_ = LazyStringArrayList.EMPTY;
    }

    private BattlePassRewardNotify(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            this.uid_ = codedInputStream.readUInt32();
                            continue;
                        case 18:
                            this.name_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 24:
                            this.level_ = codedInputStream.readUInt32();
                            continue;
                        case 34:
                            this.goodsName_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 42:
                            this.goodsIcon_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 48:
                            this.goodsCount_ = codedInputStream.readUInt32();
                            continue;
                        case 58:
                            this.chatFrame_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 66:
                            this.chatFrameIcon_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 72:
                            this.chatFrameColorType_ = codedInputStream.readInt32();
                            continue;
                        case 80:
                            this.chatFrameGradientType_ = codedInputStream.readInt32();
                            continue;
                        case 90:
                            String readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                            boolean z4 = z2;
                            if (!(z2 & true)) {
                                this.chatFrameFrameColor_ = new LazyStringArrayList();
                                z4 = z2 | true;
                            }
                            this.chatFrameFrameColor_.add(readStringRequireUtf8);
                            z2 = z4;
                            continue;
                        case 98:
                            String readStringRequireUtf82 = codedInputStream.readStringRequireUtf8();
                            boolean z5 = z2;
                            if (!(z2 & true)) {
                                this.chatFrameBorderColor_ = new LazyStringArrayList();
                                z5 = z2 | true;
                            }
                            this.chatFrameBorderColor_.add(readStringRequireUtf82);
                            z2 = z5;
                            continue;
                        case 104:
                            this.hide_ = codedInputStream.readBool();
                            continue;
                        case 112:
                            this.bonus_ = codedInputStream.readInt32();
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
            } catch (Throwable th) {
                if (z3 & true) {
                    this.chatFrameFrameColor_ = this.chatFrameFrameColor_.getUnmodifiableView();
                }
                if (z3 & true) {
                    this.chatFrameBorderColor_ = this.chatFrameBorderColor_.getUnmodifiableView();
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                throw th;
            }
        }
        if (z2 & true) {
            this.chatFrameFrameColor_ = this.chatFrameFrameColor_.getUnmodifiableView();
        }
        if (z2 & true) {
            this.chatFrameBorderColor_ = this.chatFrameBorderColor_.getUnmodifiableView();
        }
        this.unknownFields = newBuilder.build();
        makeExtensionsImmutable();
    }

    private BattlePassRewardNotify(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static BattlePassRewardNotify getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_BattlePassRewardNotify_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m530toBuilder();
    }

    public static Builder newBuilder(BattlePassRewardNotify battlePassRewardNotify) {
        return DEFAULT_INSTANCE.m530toBuilder().mergeFrom(battlePassRewardNotify);
    }

    public static BattlePassRewardNotify parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static BattlePassRewardNotify parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static BattlePassRewardNotify parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (BattlePassRewardNotify) PARSER.parseFrom(byteString);
    }

    public static BattlePassRewardNotify parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BattlePassRewardNotify) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static BattlePassRewardNotify parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static BattlePassRewardNotify parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static BattlePassRewardNotify parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static BattlePassRewardNotify parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static BattlePassRewardNotify parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (BattlePassRewardNotify) PARSER.parseFrom(byteBuffer);
    }

    public static BattlePassRewardNotify parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BattlePassRewardNotify) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static BattlePassRewardNotify parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (BattlePassRewardNotify) PARSER.parseFrom(bArr);
    }

    public static BattlePassRewardNotify parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BattlePassRewardNotify) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<BattlePassRewardNotify> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BattlePassRewardNotify) {
            BattlePassRewardNotify battlePassRewardNotify = (BattlePassRewardNotify) obj;
            return getUid() == battlePassRewardNotify.getUid() && getName().equals(battlePassRewardNotify.getName()) && getLevel() == battlePassRewardNotify.getLevel() && getGoodsName().equals(battlePassRewardNotify.getGoodsName()) && getGoodsIcon().equals(battlePassRewardNotify.getGoodsIcon()) && getGoodsCount() == battlePassRewardNotify.getGoodsCount() && getChatFrame().equals(battlePassRewardNotify.getChatFrame()) && getChatFrameIcon().equals(battlePassRewardNotify.getChatFrameIcon()) && getChatFrameColorType() == battlePassRewardNotify.getChatFrameColorType() && getChatFrameGradientType() == battlePassRewardNotify.getChatFrameGradientType() && mo523getChatFrameFrameColorList().equals(battlePassRewardNotify.mo523getChatFrameFrameColorList()) && mo522getChatFrameBorderColorList().equals(battlePassRewardNotify.mo522getChatFrameBorderColorList()) && getHide() == battlePassRewardNotify.getHide() && getBonus() == battlePassRewardNotify.getBonus() && this.unknownFields.equals(battlePassRewardNotify.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
    public int getBonus() {
        return this.bonus_;
    }

    @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
    public String getChatFrame() {
        Object obj = this.chatFrame_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.chatFrame_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
    public String getChatFrameBorderColor(int i) {
        return (String) this.chatFrameBorderColor_.get(i);
    }

    @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
    public ByteString getChatFrameBorderColorBytes(int i) {
        return this.chatFrameBorderColor_.getByteString(i);
    }

    @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
    public int getChatFrameBorderColorCount() {
        return this.chatFrameBorderColor_.size();
    }

    @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
    /* renamed from: getChatFrameBorderColorList */
    public ProtocolStringList mo522getChatFrameBorderColorList() {
        return this.chatFrameBorderColor_;
    }

    @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
    public ByteString getChatFrameBytes() {
        Object obj = this.chatFrame_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.chatFrame_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
    public int getChatFrameColorType() {
        return this.chatFrameColorType_;
    }

    @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
    public String getChatFrameFrameColor(int i) {
        return (String) this.chatFrameFrameColor_.get(i);
    }

    @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
    public ByteString getChatFrameFrameColorBytes(int i) {
        return this.chatFrameFrameColor_.getByteString(i);
    }

    @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
    public int getChatFrameFrameColorCount() {
        return this.chatFrameFrameColor_.size();
    }

    @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
    /* renamed from: getChatFrameFrameColorList */
    public ProtocolStringList mo523getChatFrameFrameColorList() {
        return this.chatFrameFrameColor_;
    }

    @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
    public int getChatFrameGradientType() {
        return this.chatFrameGradientType_;
    }

    @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
    public String getChatFrameIcon() {
        Object obj = this.chatFrameIcon_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.chatFrameIcon_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
    public ByteString getChatFrameIconBytes() {
        Object obj = this.chatFrameIcon_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.chatFrameIcon_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    /* renamed from: getDefaultInstanceForType */
    public BattlePassRewardNotify m525getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
    public int getGoodsCount() {
        return this.goodsCount_;
    }

    @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
    public String getGoodsIcon() {
        Object obj = this.goodsIcon_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.goodsIcon_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
    public ByteString getGoodsIconBytes() {
        Object obj = this.goodsIcon_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.goodsIcon_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
    public String getGoodsName() {
        Object obj = this.goodsName_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.goodsName_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
    public ByteString getGoodsNameBytes() {
        Object obj = this.goodsName_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.goodsName_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
    public boolean getHide() {
        return this.hide_;
    }

    @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
    public int getLevel() {
        return this.level_;
    }

    @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
    public ByteString getNameBytes() {
        Object obj = this.name_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.name_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    public Parser<BattlePassRewardNotify> getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = this.uid_;
        int computeUInt32Size = i2 != 0 ? CodedOutputStream.computeUInt32Size(1, i2) + 0 : 0;
        int i3 = computeUInt32Size;
        if (!getNameBytes().isEmpty()) {
            i3 = computeUInt32Size + GeneratedMessageV3.computeStringSize(2, this.name_);
        }
        int i4 = this.level_;
        int i5 = i3;
        if (i4 != 0) {
            i5 = i3 + CodedOutputStream.computeUInt32Size(3, i4);
        }
        int i6 = i5;
        if (!getGoodsNameBytes().isEmpty()) {
            i6 = i5 + GeneratedMessageV3.computeStringSize(4, this.goodsName_);
        }
        int i7 = i6;
        if (!getGoodsIconBytes().isEmpty()) {
            i7 = i6 + GeneratedMessageV3.computeStringSize(5, this.goodsIcon_);
        }
        int i8 = this.goodsCount_;
        int i9 = i7;
        if (i8 != 0) {
            i9 = i7 + CodedOutputStream.computeUInt32Size(6, i8);
        }
        int i10 = i9;
        if (!getChatFrameBytes().isEmpty()) {
            i10 = i9 + GeneratedMessageV3.computeStringSize(7, this.chatFrame_);
        }
        int i11 = i10;
        if (!getChatFrameIconBytes().isEmpty()) {
            i11 = i10 + GeneratedMessageV3.computeStringSize(8, this.chatFrameIcon_);
        }
        int i12 = this.chatFrameColorType_;
        int i13 = i11;
        if (i12 != 0) {
            i13 = i11 + CodedOutputStream.computeInt32Size(9, i12);
        }
        int i14 = this.chatFrameGradientType_;
        int i15 = i13;
        if (i14 != 0) {
            i15 = i13 + CodedOutputStream.computeInt32Size(10, i14);
        }
        int i16 = 0;
        for (int i17 = 0; i17 < this.chatFrameFrameColor_.size(); i17++) {
            i16 += computeStringSizeNoTag(this.chatFrameFrameColor_.getRaw(i17));
        }
        int size = mo523getChatFrameFrameColorList().size();
        int i18 = 0;
        int i19 = 0;
        while (true) {
            int i20 = i19;
            if (i20 >= this.chatFrameBorderColor_.size()) {
                break;
            }
            i18 += computeStringSizeNoTag(this.chatFrameBorderColor_.getRaw(i20));
            i19 = i20 + 1;
        }
        int size2 = i15 + i16 + (size * 1) + i18 + (mo522getChatFrameBorderColorList().size() * 1);
        boolean z = this.hide_;
        int i21 = size2;
        if (z) {
            i21 = size2 + CodedOutputStream.computeBoolSize(13, z);
        }
        int i22 = this.bonus_;
        int i23 = i21;
        if (i22 != 0) {
            i23 = i21 + CodedOutputStream.computeInt32Size(14, i22);
        }
        int serializedSize = i23 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.BattlePassRewardNotifyOrBuilder
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
        int hashCode = ((((((((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getUid()) * 37) + 2) * 53) + getName().hashCode()) * 37) + 3) * 53) + getLevel()) * 37) + 4) * 53) + getGoodsName().hashCode()) * 37) + 5) * 53) + getGoodsIcon().hashCode()) * 37) + 6) * 53) + getGoodsCount()) * 37) + 7) * 53) + getChatFrame().hashCode()) * 37) + 8) * 53) + getChatFrameIcon().hashCode()) * 37) + 9) * 53) + getChatFrameColorType()) * 37) + 10) * 53) + getChatFrameGradientType();
        int i = hashCode;
        if (getChatFrameFrameColorCount() > 0) {
            i = (((hashCode * 37) + 11) * 53) + mo523getChatFrameFrameColorList().hashCode();
        }
        int i2 = i;
        if (getChatFrameBorderColorCount() > 0) {
            i2 = (((i * 37) + 12) * 53) + mo522getChatFrameBorderColorList().hashCode();
        }
        int hashBoolean = (((((((((i2 * 37) + 13) * 53) + Internal.hashBoolean(getHide())) * 37) + 14) * 53) + getBonus()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashBoolean;
        return hashBoolean;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_BattlePassRewardNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(BattlePassRewardNotify.class, Builder.class);
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
    public Builder m528newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m527newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new BattlePassRewardNotify();
    }

    /* renamed from: toBuilder */
    public Builder m530toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i;
        int i2 = this.uid_;
        if (i2 != 0) {
            codedOutputStream.writeUInt32(1, i2);
        }
        if (!getNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.name_);
        }
        int i3 = this.level_;
        if (i3 != 0) {
            codedOutputStream.writeUInt32(3, i3);
        }
        if (!getGoodsNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 4, this.goodsName_);
        }
        if (!getGoodsIconBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 5, this.goodsIcon_);
        }
        int i4 = this.goodsCount_;
        if (i4 != 0) {
            codedOutputStream.writeUInt32(6, i4);
        }
        if (!getChatFrameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 7, this.chatFrame_);
        }
        if (!getChatFrameIconBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 8, this.chatFrameIcon_);
        }
        int i5 = this.chatFrameColorType_;
        if (i5 != 0) {
            codedOutputStream.writeInt32(9, i5);
        }
        int i6 = this.chatFrameGradientType_;
        if (i6 != 0) {
            codedOutputStream.writeInt32(10, i6);
        }
        int i7 = 0;
        while (true) {
            int i8 = i7;
            if (i8 >= this.chatFrameFrameColor_.size()) {
                break;
            }
            GeneratedMessageV3.writeString(codedOutputStream, 11, this.chatFrameFrameColor_.getRaw(i8));
            i7 = i8 + 1;
        }
        for (i = 0; i < this.chatFrameBorderColor_.size(); i++) {
            GeneratedMessageV3.writeString(codedOutputStream, 12, this.chatFrameBorderColor_.getRaw(i));
        }
        boolean z = this.hide_;
        if (z) {
            codedOutputStream.writeBool(13, z);
        }
        int i9 = this.bonus_;
        if (i9 != 0) {
            codedOutputStream.writeInt32(14, i9);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
