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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LeftBottomCommonMsg.class */
public final class LeftBottomCommonMsg extends GeneratedMessageV3 implements LeftBottomCommonMsgOrBuilder {
    public static final int CHAT_FRAME_BORDER_COLOR_FIELD_NUMBER = 6;
    public static final int CHAT_FRAME_COLOR_TYPE_FIELD_NUMBER = 3;
    public static final int CHAT_FRAME_FIELD_NUMBER = 7;
    public static final int CHAT_FRAME_FRAME_COLOR_FIELD_NUMBER = 5;
    public static final int CHAT_FRAME_GRADIENT_TYPE_FIELD_NUMBER = 4;
    public static final int CHAT_FRAME_ICON_FIELD_NUMBER = 8;
    public static final int COLOR_FIELD_NUMBER = 9;
    public static final int LINK_FIELD_NUMBER = 2;
    public static final int LINK_TYPE_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private LazyStringList chatFrameBorderColor_;
    private int chatFrameColorType_;
    private LazyStringList chatFrameFrameColor_;
    private int chatFrameGradientType_;
    private volatile Object chatFrameIcon_;
    private volatile Object chatFrame_;
    private volatile Object color_;
    private int linkType_;
    private volatile Object link_;
    private byte memoizedIsInitialized;
    private static final LeftBottomCommonMsg DEFAULT_INSTANCE = new LeftBottomCommonMsg();
    private static final Parser<LeftBottomCommonMsg> PARSER = new AbstractParser<LeftBottomCommonMsg>() { // from class: cn.irisgw.live.LeftBottomCommonMsg.1
        @Override // com.google.protobuf.Parser
        public LeftBottomCommonMsg parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new LeftBottomCommonMsg(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LeftBottomCommonMsg$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LeftBottomCommonMsgOrBuilder {
        private int bitField0_;
        private LazyStringList chatFrameBorderColor_;
        private int chatFrameColorType_;
        private LazyStringList chatFrameFrameColor_;
        private int chatFrameGradientType_;
        private Object chatFrameIcon_;
        private Object chatFrame_;
        private Object color_;
        private int linkType_;
        private Object link_;

        private Builder() {
            this.link_ = "";
            this.chatFrameFrameColor_ = LazyStringArrayList.EMPTY;
            this.chatFrameBorderColor_ = LazyStringArrayList.EMPTY;
            this.chatFrame_ = "";
            this.chatFrameIcon_ = "";
            this.color_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.link_ = "";
            this.chatFrameFrameColor_ = LazyStringArrayList.EMPTY;
            this.chatFrameBorderColor_ = LazyStringArrayList.EMPTY;
            this.chatFrame_ = "";
            this.chatFrameIcon_ = "";
            this.color_ = "";
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
            return LiveConstants.internal_static_cn_irisgw_live_LeftBottomCommonMsg_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = LeftBottomCommonMsg.alwaysUseFieldBuilders;
        }

        public Builder addAllChatFrameBorderColor(Iterable<String> iterable) {
            ensureChatFrameBorderColorIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.chatFrameBorderColor_);
            onChanged();
            return this;
        }

        public Builder addAllChatFrameFrameColor(Iterable<String> iterable) {
            ensureChatFrameFrameColorIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.chatFrameFrameColor_);
            onChanged();
            return this;
        }

        public Builder addChatFrameBorderColor(String str) {
            if (str != null) {
                ensureChatFrameBorderColorIsMutable();
                this.chatFrameBorderColor_.add((LazyStringList) str);
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder addChatFrameBorderColorBytes(ByteString byteString) {
            if (byteString != null) {
                LeftBottomCommonMsg.checkByteStringIsUtf8(byteString);
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
                this.chatFrameFrameColor_.add((LazyStringList) str);
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder addChatFrameFrameColorBytes(ByteString byteString) {
            if (byteString != null) {
                LeftBottomCommonMsg.checkByteStringIsUtf8(byteString);
                ensureChatFrameFrameColorIsMutable();
                this.chatFrameFrameColor_.add(byteString);
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
        public LeftBottomCommonMsg build() {
            LeftBottomCommonMsg buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public LeftBottomCommonMsg buildPartial() {
            LeftBottomCommonMsg leftBottomCommonMsg = new LeftBottomCommonMsg(this);
            leftBottomCommonMsg.linkType_ = this.linkType_;
            leftBottomCommonMsg.link_ = this.link_;
            leftBottomCommonMsg.chatFrameColorType_ = this.chatFrameColorType_;
            leftBottomCommonMsg.chatFrameGradientType_ = this.chatFrameGradientType_;
            if ((this.bitField0_ & 1) != 0) {
                this.chatFrameFrameColor_ = this.chatFrameFrameColor_.getUnmodifiableView();
                this.bitField0_ &= -2;
            }
            leftBottomCommonMsg.chatFrameFrameColor_ = this.chatFrameFrameColor_;
            if ((this.bitField0_ & 2) != 0) {
                this.chatFrameBorderColor_ = this.chatFrameBorderColor_.getUnmodifiableView();
                this.bitField0_ &= -3;
            }
            leftBottomCommonMsg.chatFrameBorderColor_ = this.chatFrameBorderColor_;
            leftBottomCommonMsg.chatFrame_ = this.chatFrame_;
            leftBottomCommonMsg.chatFrameIcon_ = this.chatFrameIcon_;
            leftBottomCommonMsg.color_ = this.color_;
            onBuilt();
            return leftBottomCommonMsg;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.linkType_ = 0;
            this.link_ = "";
            this.chatFrameColorType_ = 0;
            this.chatFrameGradientType_ = 0;
            this.chatFrameFrameColor_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -2;
            this.chatFrameBorderColor_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -3;
            this.chatFrame_ = "";
            this.chatFrameIcon_ = "";
            this.color_ = "";
            return this;
        }

        public Builder clearChatFrame() {
            this.chatFrame_ = LeftBottomCommonMsg.getDefaultInstance().getChatFrame();
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
            this.chatFrameIcon_ = LeftBottomCommonMsg.getDefaultInstance().getChatFrameIcon();
            onChanged();
            return this;
        }

        public Builder clearColor() {
            this.color_ = LeftBottomCommonMsg.getDefaultInstance().getColor();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearLink() {
            this.link_ = LeftBottomCommonMsg.getDefaultInstance().getLink();
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

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo1800clone() {
            return (Builder) super.mo1800clone();
        }

        @Override // cn.irisgw.live.LeftBottomCommonMsgOrBuilder
        public String getChatFrame() {
            Object obj = this.chatFrame_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.chatFrame_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LeftBottomCommonMsgOrBuilder
        public String getChatFrameBorderColor(int i) {
            return this.chatFrameBorderColor_.get(i);
        }

        @Override // cn.irisgw.live.LeftBottomCommonMsgOrBuilder
        public ByteString getChatFrameBorderColorBytes(int i) {
            return this.chatFrameBorderColor_.getByteString(i);
        }

        @Override // cn.irisgw.live.LeftBottomCommonMsgOrBuilder
        public int getChatFrameBorderColorCount() {
            return this.chatFrameBorderColor_.size();
        }

        @Override // cn.irisgw.live.LeftBottomCommonMsgOrBuilder
        public ProtocolStringList getChatFrameBorderColorList() {
            return this.chatFrameBorderColor_.getUnmodifiableView();
        }

        @Override // cn.irisgw.live.LeftBottomCommonMsgOrBuilder
        public ByteString getChatFrameBytes() {
            Object obj = this.chatFrame_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.chatFrame_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.LeftBottomCommonMsgOrBuilder
        public int getChatFrameColorType() {
            return this.chatFrameColorType_;
        }

        @Override // cn.irisgw.live.LeftBottomCommonMsgOrBuilder
        public String getChatFrameFrameColor(int i) {
            return this.chatFrameFrameColor_.get(i);
        }

        @Override // cn.irisgw.live.LeftBottomCommonMsgOrBuilder
        public ByteString getChatFrameFrameColorBytes(int i) {
            return this.chatFrameFrameColor_.getByteString(i);
        }

        @Override // cn.irisgw.live.LeftBottomCommonMsgOrBuilder
        public int getChatFrameFrameColorCount() {
            return this.chatFrameFrameColor_.size();
        }

        @Override // cn.irisgw.live.LeftBottomCommonMsgOrBuilder
        public ProtocolStringList getChatFrameFrameColorList() {
            return this.chatFrameFrameColor_.getUnmodifiableView();
        }

        @Override // cn.irisgw.live.LeftBottomCommonMsgOrBuilder
        public int getChatFrameGradientType() {
            return this.chatFrameGradientType_;
        }

        @Override // cn.irisgw.live.LeftBottomCommonMsgOrBuilder
        public String getChatFrameIcon() {
            Object obj = this.chatFrameIcon_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.chatFrameIcon_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LeftBottomCommonMsgOrBuilder
        public ByteString getChatFrameIconBytes() {
            Object obj = this.chatFrameIcon_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.chatFrameIcon_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.LeftBottomCommonMsgOrBuilder
        public String getColor() {
            Object obj = this.color_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.color_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LeftBottomCommonMsgOrBuilder
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
        public LeftBottomCommonMsg getDefaultInstanceForType() {
            return LeftBottomCommonMsg.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_LeftBottomCommonMsg_descriptor;
        }

        @Override // cn.irisgw.live.LeftBottomCommonMsgOrBuilder
        public String getLink() {
            Object obj = this.link_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.link_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LeftBottomCommonMsgOrBuilder
        public ByteString getLinkBytes() {
            Object obj = this.link_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.link_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.LeftBottomCommonMsgOrBuilder
        public int getLinkType() {
            return this.linkType_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_LeftBottomCommonMsg_fieldAccessorTable.ensureFieldAccessorsInitialized(LeftBottomCommonMsg.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(LeftBottomCommonMsg leftBottomCommonMsg) {
            if (leftBottomCommonMsg == LeftBottomCommonMsg.getDefaultInstance()) {
                return this;
            }
            if (leftBottomCommonMsg.getLinkType() != 0) {
                setLinkType(leftBottomCommonMsg.getLinkType());
            }
            if (!leftBottomCommonMsg.getLink().isEmpty()) {
                this.link_ = leftBottomCommonMsg.link_;
                onChanged();
            }
            if (leftBottomCommonMsg.getChatFrameColorType() != 0) {
                setChatFrameColorType(leftBottomCommonMsg.getChatFrameColorType());
            }
            if (leftBottomCommonMsg.getChatFrameGradientType() != 0) {
                setChatFrameGradientType(leftBottomCommonMsg.getChatFrameGradientType());
            }
            if (!leftBottomCommonMsg.chatFrameFrameColor_.isEmpty()) {
                if (this.chatFrameFrameColor_.isEmpty()) {
                    this.chatFrameFrameColor_ = leftBottomCommonMsg.chatFrameFrameColor_;
                    this.bitField0_ &= -2;
                } else {
                    ensureChatFrameFrameColorIsMutable();
                    this.chatFrameFrameColor_.addAll(leftBottomCommonMsg.chatFrameFrameColor_);
                }
                onChanged();
            }
            if (!leftBottomCommonMsg.chatFrameBorderColor_.isEmpty()) {
                if (this.chatFrameBorderColor_.isEmpty()) {
                    this.chatFrameBorderColor_ = leftBottomCommonMsg.chatFrameBorderColor_;
                    this.bitField0_ &= -3;
                } else {
                    ensureChatFrameBorderColorIsMutable();
                    this.chatFrameBorderColor_.addAll(leftBottomCommonMsg.chatFrameBorderColor_);
                }
                onChanged();
            }
            if (!leftBottomCommonMsg.getChatFrame().isEmpty()) {
                this.chatFrame_ = leftBottomCommonMsg.chatFrame_;
                onChanged();
            }
            if (!leftBottomCommonMsg.getChatFrameIcon().isEmpty()) {
                this.chatFrameIcon_ = leftBottomCommonMsg.chatFrameIcon_;
                onChanged();
            }
            if (!leftBottomCommonMsg.getColor().isEmpty()) {
                this.color_ = leftBottomCommonMsg.color_;
                onChanged();
            }
            mergeUnknownFields(leftBottomCommonMsg.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.LeftBottomCommonMsg.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.LeftBottomCommonMsg.access$1400()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.LeftBottomCommonMsg r0 = (cn.irisgw.live.LeftBottomCommonMsg) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.LeftBottomCommonMsg$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.LeftBottomCommonMsg r0 = (cn.irisgw.live.LeftBottomCommonMsg) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.LeftBottomCommonMsg$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.LeftBottomCommonMsg.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.LeftBottomCommonMsg$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof LeftBottomCommonMsg) {
                return mergeFrom((LeftBottomCommonMsg) message);
            }
            super.mergeFrom(message);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
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
                this.chatFrameBorderColor_.set(i, (int) str);
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setChatFrameBytes(ByteString byteString) {
            if (byteString != null) {
                LeftBottomCommonMsg.checkByteStringIsUtf8(byteString);
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
                this.chatFrameFrameColor_.set(i, (int) str);
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
                LeftBottomCommonMsg.checkByteStringIsUtf8(byteString);
                this.chatFrameIcon_ = byteString;
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
                LeftBottomCommonMsg.checkByteStringIsUtf8(byteString);
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
                LeftBottomCommonMsg.checkByteStringIsUtf8(byteString);
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

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private LeftBottomCommonMsg() {
        this.memoizedIsInitialized = (byte) -1;
        this.link_ = "";
        this.chatFrameFrameColor_ = LazyStringArrayList.EMPTY;
        this.chatFrameBorderColor_ = LazyStringArrayList.EMPTY;
        this.chatFrame_ = "";
        this.chatFrameIcon_ = "";
        this.color_ = "";
    }

    private LeftBottomCommonMsg(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.linkType_ = codedInputStream.readUInt32();
                        } else if (readTag == 18) {
                            this.link_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 24) {
                            this.chatFrameColorType_ = codedInputStream.readInt32();
                        } else if (readTag == 32) {
                            this.chatFrameGradientType_ = codedInputStream.readInt32();
                        } else if (readTag == 42) {
                            String readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                            boolean z4 = z2;
                            if (!(z2 & true)) {
                                this.chatFrameFrameColor_ = new LazyStringArrayList();
                                z4 = z2 | true;
                            }
                            this.chatFrameFrameColor_.add((LazyStringList) readStringRequireUtf8);
                            z2 = z4;
                        } else if (readTag == 50) {
                            String readStringRequireUtf82 = codedInputStream.readStringRequireUtf8();
                            boolean z5 = z2;
                            if (!(z2 & true)) {
                                this.chatFrameBorderColor_ = new LazyStringArrayList();
                                z5 = z2 | true;
                            }
                            this.chatFrameBorderColor_.add((LazyStringList) readStringRequireUtf82);
                            z2 = z5;
                        } else if (readTag == 58) {
                            this.chatFrame_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 66) {
                            this.chatFrameIcon_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 74) {
                            this.color_ = codedInputStream.readStringRequireUtf8();
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

    private LeftBottomCommonMsg(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static LeftBottomCommonMsg getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_LeftBottomCommonMsg_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(LeftBottomCommonMsg leftBottomCommonMsg) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(leftBottomCommonMsg);
    }

    public static LeftBottomCommonMsg parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (LeftBottomCommonMsg) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static LeftBottomCommonMsg parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LeftBottomCommonMsg) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LeftBottomCommonMsg parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static LeftBottomCommonMsg parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static LeftBottomCommonMsg parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (LeftBottomCommonMsg) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static LeftBottomCommonMsg parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LeftBottomCommonMsg) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static LeftBottomCommonMsg parseFrom(InputStream inputStream) throws IOException {
        return (LeftBottomCommonMsg) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static LeftBottomCommonMsg parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LeftBottomCommonMsg) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LeftBottomCommonMsg parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static LeftBottomCommonMsg parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static LeftBottomCommonMsg parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static LeftBottomCommonMsg parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<LeftBottomCommonMsg> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LeftBottomCommonMsg) {
            LeftBottomCommonMsg leftBottomCommonMsg = (LeftBottomCommonMsg) obj;
            return getLinkType() == leftBottomCommonMsg.getLinkType() && getLink().equals(leftBottomCommonMsg.getLink()) && getChatFrameColorType() == leftBottomCommonMsg.getChatFrameColorType() && getChatFrameGradientType() == leftBottomCommonMsg.getChatFrameGradientType() && getChatFrameFrameColorList().equals(leftBottomCommonMsg.getChatFrameFrameColorList()) && getChatFrameBorderColorList().equals(leftBottomCommonMsg.getChatFrameBorderColorList()) && getChatFrame().equals(leftBottomCommonMsg.getChatFrame()) && getChatFrameIcon().equals(leftBottomCommonMsg.getChatFrameIcon()) && getColor().equals(leftBottomCommonMsg.getColor()) && this.unknownFields.equals(leftBottomCommonMsg.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.LeftBottomCommonMsgOrBuilder
    public String getChatFrame() {
        Object obj = this.chatFrame_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.chatFrame_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.LeftBottomCommonMsgOrBuilder
    public String getChatFrameBorderColor(int i) {
        return this.chatFrameBorderColor_.get(i);
    }

    @Override // cn.irisgw.live.LeftBottomCommonMsgOrBuilder
    public ByteString getChatFrameBorderColorBytes(int i) {
        return this.chatFrameBorderColor_.getByteString(i);
    }

    @Override // cn.irisgw.live.LeftBottomCommonMsgOrBuilder
    public int getChatFrameBorderColorCount() {
        return this.chatFrameBorderColor_.size();
    }

    @Override // cn.irisgw.live.LeftBottomCommonMsgOrBuilder
    public ProtocolStringList getChatFrameBorderColorList() {
        return this.chatFrameBorderColor_;
    }

    @Override // cn.irisgw.live.LeftBottomCommonMsgOrBuilder
    public ByteString getChatFrameBytes() {
        Object obj = this.chatFrame_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.chatFrame_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.LeftBottomCommonMsgOrBuilder
    public int getChatFrameColorType() {
        return this.chatFrameColorType_;
    }

    @Override // cn.irisgw.live.LeftBottomCommonMsgOrBuilder
    public String getChatFrameFrameColor(int i) {
        return this.chatFrameFrameColor_.get(i);
    }

    @Override // cn.irisgw.live.LeftBottomCommonMsgOrBuilder
    public ByteString getChatFrameFrameColorBytes(int i) {
        return this.chatFrameFrameColor_.getByteString(i);
    }

    @Override // cn.irisgw.live.LeftBottomCommonMsgOrBuilder
    public int getChatFrameFrameColorCount() {
        return this.chatFrameFrameColor_.size();
    }

    @Override // cn.irisgw.live.LeftBottomCommonMsgOrBuilder
    public ProtocolStringList getChatFrameFrameColorList() {
        return this.chatFrameFrameColor_;
    }

    @Override // cn.irisgw.live.LeftBottomCommonMsgOrBuilder
    public int getChatFrameGradientType() {
        return this.chatFrameGradientType_;
    }

    @Override // cn.irisgw.live.LeftBottomCommonMsgOrBuilder
    public String getChatFrameIcon() {
        Object obj = this.chatFrameIcon_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.chatFrameIcon_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.LeftBottomCommonMsgOrBuilder
    public ByteString getChatFrameIconBytes() {
        Object obj = this.chatFrameIcon_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.chatFrameIcon_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.LeftBottomCommonMsgOrBuilder
    public String getColor() {
        Object obj = this.color_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.color_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.LeftBottomCommonMsgOrBuilder
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
    public LeftBottomCommonMsg getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.LeftBottomCommonMsgOrBuilder
    public String getLink() {
        Object obj = this.link_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.link_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.LeftBottomCommonMsgOrBuilder
    public ByteString getLinkBytes() {
        Object obj = this.link_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.link_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.LeftBottomCommonMsgOrBuilder
    public int getLinkType() {
        return this.linkType_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<LeftBottomCommonMsg> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = this.linkType_;
        int computeUInt32Size = i2 != 0 ? CodedOutputStream.computeUInt32Size(1, i2) + 0 : 0;
        int i3 = computeUInt32Size;
        if (!getLinkBytes().isEmpty()) {
            i3 = computeUInt32Size + GeneratedMessageV3.computeStringSize(2, this.link_);
        }
        int i4 = this.chatFrameColorType_;
        int i5 = i3;
        if (i4 != 0) {
            i5 = i3 + CodedOutputStream.computeInt32Size(3, i4);
        }
        int i6 = this.chatFrameGradientType_;
        int i7 = i5;
        if (i6 != 0) {
            i7 = i5 + CodedOutputStream.computeInt32Size(4, i6);
        }
        int i8 = 0;
        for (int i9 = 0; i9 < this.chatFrameFrameColor_.size(); i9++) {
            i8 += computeStringSizeNoTag(this.chatFrameFrameColor_.getRaw(i9));
        }
        int size = getChatFrameFrameColorList().size();
        int i10 = 0;
        int i11 = 0;
        while (true) {
            int i12 = i11;
            if (i12 >= this.chatFrameBorderColor_.size()) {
                break;
            }
            i10 += computeStringSizeNoTag(this.chatFrameBorderColor_.getRaw(i12));
            i11 = i12 + 1;
        }
        int size2 = i7 + i8 + (size * 1) + i10 + (getChatFrameBorderColorList().size() * 1);
        int i13 = size2;
        if (!getChatFrameBytes().isEmpty()) {
            i13 = size2 + GeneratedMessageV3.computeStringSize(7, this.chatFrame_);
        }
        int i14 = i13;
        if (!getChatFrameIconBytes().isEmpty()) {
            i14 = i13 + GeneratedMessageV3.computeStringSize(8, this.chatFrameIcon_);
        }
        int i15 = i14;
        if (!getColorBytes().isEmpty()) {
            i15 = i14 + GeneratedMessageV3.computeStringSize(9, this.color_);
        }
        int serializedSize = i15 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
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
        int hashCode = ((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getLinkType()) * 37) + 2) * 53) + getLink().hashCode()) * 37) + 3) * 53) + getChatFrameColorType()) * 37) + 4) * 53) + getChatFrameGradientType();
        int i = hashCode;
        if (getChatFrameFrameColorCount() > 0) {
            i = (((hashCode * 37) + 5) * 53) + getChatFrameFrameColorList().hashCode();
        }
        int i2 = i;
        if (getChatFrameBorderColorCount() > 0) {
            i2 = (((i * 37) + 6) * 53) + getChatFrameBorderColorList().hashCode();
        }
        int hashCode2 = (((((((((((((i2 * 37) + 7) * 53) + getChatFrame().hashCode()) * 37) + 8) * 53) + getChatFrameIcon().hashCode()) * 37) + 9) * 53) + getColor().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_LeftBottomCommonMsg_fieldAccessorTable.ensureFieldAccessorsInitialized(LeftBottomCommonMsg.class, Builder.class);
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
        return new LeftBottomCommonMsg();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i;
        int i2 = this.linkType_;
        if (i2 != 0) {
            codedOutputStream.writeUInt32(1, i2);
        }
        if (!getLinkBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.link_);
        }
        int i3 = this.chatFrameColorType_;
        if (i3 != 0) {
            codedOutputStream.writeInt32(3, i3);
        }
        int i4 = this.chatFrameGradientType_;
        if (i4 != 0) {
            codedOutputStream.writeInt32(4, i4);
        }
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= this.chatFrameFrameColor_.size()) {
                break;
            }
            GeneratedMessageV3.writeString(codedOutputStream, 5, this.chatFrameFrameColor_.getRaw(i6));
            i5 = i6 + 1;
        }
        for (i = 0; i < this.chatFrameBorderColor_.size(); i++) {
            GeneratedMessageV3.writeString(codedOutputStream, 6, this.chatFrameBorderColor_.getRaw(i));
        }
        if (!getChatFrameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 7, this.chatFrame_);
        }
        if (!getChatFrameIconBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 8, this.chatFrameIcon_);
        }
        if (!getColorBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 9, this.color_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
