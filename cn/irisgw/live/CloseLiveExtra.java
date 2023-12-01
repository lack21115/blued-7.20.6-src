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
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/CloseLiveExtra.class */
public final class CloseLiveExtra extends GeneratedMessageV3 implements CloseLiveExtraOrBuilder {
    public static final int KICK_INFO_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private KickInfo kickInfo_;
    private byte memoizedIsInitialized;
    private static final CloseLiveExtra DEFAULT_INSTANCE = new CloseLiveExtra();
    private static final Parser<CloseLiveExtra> PARSER = new AbstractParser<CloseLiveExtra>() { // from class: cn.irisgw.live.CloseLiveExtra.1
        @Override // com.google.protobuf.Parser
        public CloseLiveExtra parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new CloseLiveExtra(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/CloseLiveExtra$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CloseLiveExtraOrBuilder {
        private SingleFieldBuilderV3<KickInfo, KickInfo.Builder, KickInfoOrBuilder> kickInfoBuilder_;
        private KickInfo kickInfo_;

        private Builder() {
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_CloseLiveExtra_descriptor;
        }

        private SingleFieldBuilderV3<KickInfo, KickInfo.Builder, KickInfoOrBuilder> getKickInfoFieldBuilder() {
            if (this.kickInfoBuilder_ == null) {
                this.kickInfoBuilder_ = new SingleFieldBuilderV3<>(getKickInfo(), getParentForChildren(), isClean());
                this.kickInfo_ = null;
            }
            return this.kickInfoBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = CloseLiveExtra.alwaysUseFieldBuilders;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CloseLiveExtra build() {
            CloseLiveExtra buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CloseLiveExtra buildPartial() {
            CloseLiveExtra closeLiveExtra = new CloseLiveExtra(this);
            SingleFieldBuilderV3<KickInfo, KickInfo.Builder, KickInfoOrBuilder> singleFieldBuilderV3 = this.kickInfoBuilder_;
            if (singleFieldBuilderV3 == null) {
                closeLiveExtra.kickInfo_ = this.kickInfo_;
            } else {
                closeLiveExtra.kickInfo_ = singleFieldBuilderV3.build();
            }
            onBuilt();
            return closeLiveExtra;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            if (this.kickInfoBuilder_ == null) {
                this.kickInfo_ = null;
                return this;
            }
            this.kickInfo_ = null;
            this.kickInfoBuilder_ = null;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearKickInfo() {
            if (this.kickInfoBuilder_ == null) {
                this.kickInfo_ = null;
                onChanged();
                return this;
            }
            this.kickInfo_ = null;
            this.kickInfoBuilder_ = null;
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

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CloseLiveExtra getDefaultInstanceForType() {
            return CloseLiveExtra.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_CloseLiveExtra_descriptor;
        }

        @Override // cn.irisgw.live.CloseLiveExtraOrBuilder
        public KickInfo getKickInfo() {
            SingleFieldBuilderV3<KickInfo, KickInfo.Builder, KickInfoOrBuilder> singleFieldBuilderV3 = this.kickInfoBuilder_;
            if (singleFieldBuilderV3 == null) {
                KickInfo kickInfo = this.kickInfo_;
                KickInfo kickInfo2 = kickInfo;
                if (kickInfo == null) {
                    kickInfo2 = KickInfo.getDefaultInstance();
                }
                return kickInfo2;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public KickInfo.Builder getKickInfoBuilder() {
            onChanged();
            return getKickInfoFieldBuilder().getBuilder();
        }

        @Override // cn.irisgw.live.CloseLiveExtraOrBuilder
        public KickInfoOrBuilder getKickInfoOrBuilder() {
            SingleFieldBuilderV3<KickInfo, KickInfo.Builder, KickInfoOrBuilder> singleFieldBuilderV3 = this.kickInfoBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            KickInfo kickInfo = this.kickInfo_;
            KickInfo kickInfo2 = kickInfo;
            if (kickInfo == null) {
                kickInfo2 = KickInfo.getDefaultInstance();
            }
            return kickInfo2;
        }

        @Override // cn.irisgw.live.CloseLiveExtraOrBuilder
        public boolean hasKickInfo() {
            return (this.kickInfoBuilder_ == null && this.kickInfo_ == null) ? false : true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_CloseLiveExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(CloseLiveExtra.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(CloseLiveExtra closeLiveExtra) {
            if (closeLiveExtra == CloseLiveExtra.getDefaultInstance()) {
                return this;
            }
            if (closeLiveExtra.hasKickInfo()) {
                mergeKickInfo(closeLiveExtra.getKickInfo());
            }
            mergeUnknownFields(closeLiveExtra.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.CloseLiveExtra.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.CloseLiveExtra.access$2000()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.CloseLiveExtra r0 = (cn.irisgw.live.CloseLiveExtra) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.CloseLiveExtra$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.CloseLiveExtra r0 = (cn.irisgw.live.CloseLiveExtra) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.CloseLiveExtra$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.CloseLiveExtra.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.CloseLiveExtra$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof CloseLiveExtra) {
                return mergeFrom((CloseLiveExtra) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeKickInfo(KickInfo kickInfo) {
            SingleFieldBuilderV3<KickInfo, KickInfo.Builder, KickInfoOrBuilder> singleFieldBuilderV3 = this.kickInfoBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.mergeFrom(kickInfo);
                return this;
            }
            KickInfo kickInfo2 = this.kickInfo_;
            if (kickInfo2 != null) {
                this.kickInfo_ = KickInfo.newBuilder(kickInfo2).mergeFrom(kickInfo).buildPartial();
            } else {
                this.kickInfo_ = kickInfo;
            }
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setKickInfo(KickInfo.Builder builder) {
            SingleFieldBuilderV3<KickInfo, KickInfo.Builder, KickInfoOrBuilder> singleFieldBuilderV3 = this.kickInfoBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(builder.build());
                return this;
            }
            this.kickInfo_ = builder.build();
            onChanged();
            return this;
        }

        public Builder setKickInfo(KickInfo kickInfo) {
            SingleFieldBuilderV3<KickInfo, KickInfo.Builder, KickInfoOrBuilder> singleFieldBuilderV3 = this.kickInfoBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(kickInfo);
                return this;
            } else if (kickInfo != null) {
                this.kickInfo_ = kickInfo;
                onChanged();
                return this;
            } else {
                throw null;
            }
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

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/CloseLiveExtra$KickInfo.class */
    public static final class KickInfo extends GeneratedMessageV3 implements KickInfoOrBuilder {
        public static final int AUDIENCE_MESSAGE_FIELD_NUMBER = 3;
        public static final int MESSAGE_FIELD_NUMBER = 2;
        public static final int REASON_FIELD_NUMBER = 4;
        public static final int TITLE_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private volatile Object audienceMessage_;
        private byte memoizedIsInitialized;
        private volatile Object message_;
        private int reason_;
        private volatile Object title_;
        private static final KickInfo DEFAULT_INSTANCE = new KickInfo();
        private static final Parser<KickInfo> PARSER = new AbstractParser<KickInfo>() { // from class: cn.irisgw.live.CloseLiveExtra.KickInfo.1
            @Override // com.google.protobuf.Parser
            public KickInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new KickInfo(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/CloseLiveExtra$KickInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements KickInfoOrBuilder {
            private Object audienceMessage_;
            private Object message_;
            private int reason_;
            private Object title_;

            private Builder() {
                this.title_ = "";
                this.message_ = "";
                this.audienceMessage_ = "";
                this.reason_ = 0;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.title_ = "";
                this.message_ = "";
                this.audienceMessage_ = "";
                this.reason_ = 0;
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LiveConstants.internal_static_cn_irisgw_live_CloseLiveExtra_KickInfo_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = KickInfo.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public KickInfo build() {
                KickInfo buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public KickInfo buildPartial() {
                KickInfo kickInfo = new KickInfo(this);
                kickInfo.title_ = this.title_;
                kickInfo.message_ = this.message_;
                kickInfo.audienceMessage_ = this.audienceMessage_;
                kickInfo.reason_ = this.reason_;
                onBuilt();
                return kickInfo;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.title_ = "";
                this.message_ = "";
                this.audienceMessage_ = "";
                this.reason_ = 0;
                return this;
            }

            public Builder clearAudienceMessage() {
                this.audienceMessage_ = KickInfo.getDefaultInstance().getAudienceMessage();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearMessage() {
                this.message_ = KickInfo.getDefaultInstance().getMessage();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearReason() {
                this.reason_ = 0;
                onChanged();
                return this;
            }

            public Builder clearTitle() {
                this.title_ = KickInfo.getDefaultInstance().getTitle();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1800clone() {
                return (Builder) super.mo1800clone();
            }

            @Override // cn.irisgw.live.CloseLiveExtra.KickInfoOrBuilder
            public String getAudienceMessage() {
                Object obj = this.audienceMessage_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.audienceMessage_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.CloseLiveExtra.KickInfoOrBuilder
            public ByteString getAudienceMessageBytes() {
                Object obj = this.audienceMessage_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.audienceMessage_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public KickInfo getDefaultInstanceForType() {
                return KickInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return LiveConstants.internal_static_cn_irisgw_live_CloseLiveExtra_KickInfo_descriptor;
            }

            @Override // cn.irisgw.live.CloseLiveExtra.KickInfoOrBuilder
            public String getMessage() {
                Object obj = this.message_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.message_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.CloseLiveExtra.KickInfoOrBuilder
            public ByteString getMessageBytes() {
                Object obj = this.message_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.message_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.CloseLiveExtra.KickInfoOrBuilder
            public Reason getReason() {
                Reason valueOf = Reason.valueOf(this.reason_);
                Reason reason = valueOf;
                if (valueOf == null) {
                    reason = Reason.UNRECOGNIZED;
                }
                return reason;
            }

            @Override // cn.irisgw.live.CloseLiveExtra.KickInfoOrBuilder
            public int getReasonValue() {
                return this.reason_;
            }

            @Override // cn.irisgw.live.CloseLiveExtra.KickInfoOrBuilder
            public String getTitle() {
                Object obj = this.title_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.title_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.CloseLiveExtra.KickInfoOrBuilder
            public ByteString getTitleBytes() {
                Object obj = this.title_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.title_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveConstants.internal_static_cn_irisgw_live_CloseLiveExtra_KickInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(KickInfo.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(KickInfo kickInfo) {
                if (kickInfo == KickInfo.getDefaultInstance()) {
                    return this;
                }
                if (!kickInfo.getTitle().isEmpty()) {
                    this.title_ = kickInfo.title_;
                    onChanged();
                }
                if (!kickInfo.getMessage().isEmpty()) {
                    this.message_ = kickInfo.message_;
                    onChanged();
                }
                if (!kickInfo.getAudienceMessage().isEmpty()) {
                    this.audienceMessage_ = kickInfo.audienceMessage_;
                    onChanged();
                }
                if (kickInfo.reason_ != 0) {
                    setReasonValue(kickInfo.getReasonValue());
                }
                mergeUnknownFields(kickInfo.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.CloseLiveExtra.KickInfo.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.CloseLiveExtra.KickInfo.access$900()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.CloseLiveExtra$KickInfo r0 = (cn.irisgw.live.CloseLiveExtra.KickInfo) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.CloseLiveExtra$KickInfo$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.CloseLiveExtra$KickInfo r0 = (cn.irisgw.live.CloseLiveExtra.KickInfo) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.CloseLiveExtra$KickInfo$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.CloseLiveExtra.KickInfo.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.CloseLiveExtra$KickInfo$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof KickInfo) {
                    return mergeFrom((KickInfo) message);
                }
                super.mergeFrom(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder setAudienceMessage(String str) {
                if (str != null) {
                    this.audienceMessage_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setAudienceMessageBytes(ByteString byteString) {
                if (byteString != null) {
                    KickInfo.checkByteStringIsUtf8(byteString);
                    this.audienceMessage_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setMessage(String str) {
                if (str != null) {
                    this.message_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setMessageBytes(ByteString byteString) {
                if (byteString != null) {
                    KickInfo.checkByteStringIsUtf8(byteString);
                    this.message_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setReason(Reason reason) {
                if (reason != null) {
                    this.reason_ = reason.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setReasonValue(int i) {
                this.reason_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setTitle(String str) {
                if (str != null) {
                    this.title_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setTitleBytes(ByteString byteString) {
                if (byteString != null) {
                    KickInfo.checkByteStringIsUtf8(byteString);
                    this.title_ = byteString;
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

        private KickInfo() {
            this.memoizedIsInitialized = (byte) -1;
            this.title_ = "";
            this.message_ = "";
            this.audienceMessage_ = "";
            this.reason_ = 0;
        }

        private KickInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.title_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                this.message_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 26) {
                                this.audienceMessage_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 32) {
                                this.reason_ = codedInputStream.readEnum();
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

        private KickInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static KickInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_CloseLiveExtra_KickInfo_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(KickInfo kickInfo) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(kickInfo);
        }

        public static KickInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (KickInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static KickInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (KickInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static KickInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static KickInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static KickInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (KickInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static KickInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (KickInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static KickInfo parseFrom(InputStream inputStream) throws IOException {
            return (KickInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static KickInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (KickInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static KickInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static KickInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static KickInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static KickInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<KickInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof KickInfo) {
                KickInfo kickInfo = (KickInfo) obj;
                return getTitle().equals(kickInfo.getTitle()) && getMessage().equals(kickInfo.getMessage()) && getAudienceMessage().equals(kickInfo.getAudienceMessage()) && this.reason_ == kickInfo.reason_ && this.unknownFields.equals(kickInfo.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // cn.irisgw.live.CloseLiveExtra.KickInfoOrBuilder
        public String getAudienceMessage() {
            Object obj = this.audienceMessage_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.audienceMessage_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.CloseLiveExtra.KickInfoOrBuilder
        public ByteString getAudienceMessageBytes() {
            Object obj = this.audienceMessage_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.audienceMessage_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public KickInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // cn.irisgw.live.CloseLiveExtra.KickInfoOrBuilder
        public String getMessage() {
            Object obj = this.message_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.message_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.CloseLiveExtra.KickInfoOrBuilder
        public ByteString getMessageBytes() {
            Object obj = this.message_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.message_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<KickInfo> getParserForType() {
            return PARSER;
        }

        @Override // cn.irisgw.live.CloseLiveExtra.KickInfoOrBuilder
        public Reason getReason() {
            Reason valueOf = Reason.valueOf(this.reason_);
            Reason reason = valueOf;
            if (valueOf == null) {
                reason = Reason.UNRECOGNIZED;
            }
            return reason;
        }

        @Override // cn.irisgw.live.CloseLiveExtra.KickInfoOrBuilder
        public int getReasonValue() {
            return this.reason_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (!getTitleBytes().isEmpty()) {
                i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.title_);
            }
            int i3 = i2;
            if (!getMessageBytes().isEmpty()) {
                i3 = i2 + GeneratedMessageV3.computeStringSize(2, this.message_);
            }
            int i4 = i3;
            if (!getAudienceMessageBytes().isEmpty()) {
                i4 = i3 + GeneratedMessageV3.computeStringSize(3, this.audienceMessage_);
            }
            int i5 = i4;
            if (this.reason_ != Reason.Default.getNumber()) {
                i5 = i4 + CodedOutputStream.computeEnumSize(4, this.reason_);
            }
            int serializedSize = i5 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // cn.irisgw.live.CloseLiveExtra.KickInfoOrBuilder
        public String getTitle() {
            Object obj = this.title_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.title_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.CloseLiveExtra.KickInfoOrBuilder
        public ByteString getTitleBytes() {
            Object obj = this.title_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.title_ = copyFromUtf8;
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
            int hashCode = ((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getTitle().hashCode()) * 37) + 2) * 53) + getMessage().hashCode()) * 37) + 3) * 53) + getAudienceMessage().hashCode()) * 37) + 4) * 53) + this.reason_) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_CloseLiveExtra_KickInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(KickInfo.class, Builder.class);
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
            return new KickInfo();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!getTitleBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.title_);
            }
            if (!getMessageBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.message_);
            }
            if (!getAudienceMessageBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.audienceMessage_);
            }
            if (this.reason_ != Reason.Default.getNumber()) {
                codedOutputStream.writeEnum(4, this.reason_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/CloseLiveExtra$KickInfoOrBuilder.class */
    public interface KickInfoOrBuilder extends MessageOrBuilder {
        String getAudienceMessage();

        ByteString getAudienceMessageBytes();

        String getMessage();

        ByteString getMessageBytes();

        Reason getReason();

        int getReasonValue();

        String getTitle();

        ByteString getTitleBytes();
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/CloseLiveExtra$Reason.class */
    public enum Reason implements ProtocolMessageEnum {
        Default(0),
        Normal(1),
        Ban(2),
        System(3),
        UNRECOGNIZED(-1);
        
        public static final int Ban_VALUE = 2;
        public static final int Default_VALUE = 0;
        public static final int Normal_VALUE = 1;
        public static final int System_VALUE = 3;
        private final int value;
        private static final Internal.EnumLiteMap<Reason> internalValueMap = new Internal.EnumLiteMap<Reason>() { // from class: cn.irisgw.live.CloseLiveExtra.Reason.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public Reason findValueByNumber(int i) {
                return Reason.forNumber(i);
            }
        };
        private static final Reason[] VALUES = values();

        Reason(int i) {
            this.value = i;
        }

        public static Reason forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            return null;
                        }
                        return System;
                    }
                    return Ban;
                }
                return Normal;
            }
            return Default;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return CloseLiveExtra.getDescriptor().getEnumTypes().get(0);
        }

        public static Internal.EnumLiteMap<Reason> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static Reason valueOf(int i) {
            return forNumber(i);
        }

        public static Reason valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() == getDescriptor()) {
                return enumValueDescriptor.getIndex() == -1 ? UNRECOGNIZED : VALUES[enumValueDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this != UNRECOGNIZED) {
                return getDescriptor().getValues().get(ordinal());
            }
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }
    }

    private CloseLiveExtra() {
        this.memoizedIsInitialized = (byte) -1;
    }

    private CloseLiveExtra(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                KickInfo.Builder builder = this.kickInfo_ != null ? this.kickInfo_.toBuilder() : null;
                                KickInfo kickInfo = (KickInfo) codedInputStream.readMessage(KickInfo.parser(), extensionRegistryLite);
                                this.kickInfo_ = kickInfo;
                                if (builder != null) {
                                    builder.mergeFrom(kickInfo);
                                    this.kickInfo_ = builder.buildPartial();
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

    private CloseLiveExtra(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static CloseLiveExtra getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_CloseLiveExtra_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(CloseLiveExtra closeLiveExtra) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(closeLiveExtra);
    }

    public static CloseLiveExtra parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (CloseLiveExtra) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static CloseLiveExtra parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CloseLiveExtra) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static CloseLiveExtra parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static CloseLiveExtra parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static CloseLiveExtra parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (CloseLiveExtra) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static CloseLiveExtra parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CloseLiveExtra) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static CloseLiveExtra parseFrom(InputStream inputStream) throws IOException {
        return (CloseLiveExtra) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static CloseLiveExtra parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CloseLiveExtra) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static CloseLiveExtra parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static CloseLiveExtra parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static CloseLiveExtra parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static CloseLiveExtra parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<CloseLiveExtra> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CloseLiveExtra) {
            CloseLiveExtra closeLiveExtra = (CloseLiveExtra) obj;
            if (hasKickInfo() != closeLiveExtra.hasKickInfo()) {
                return false;
            }
            return (!hasKickInfo() || getKickInfo().equals(closeLiveExtra.getKickInfo())) && this.unknownFields.equals(closeLiveExtra.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public CloseLiveExtra getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.CloseLiveExtraOrBuilder
    public KickInfo getKickInfo() {
        KickInfo kickInfo = this.kickInfo_;
        KickInfo kickInfo2 = kickInfo;
        if (kickInfo == null) {
            kickInfo2 = KickInfo.getDefaultInstance();
        }
        return kickInfo2;
    }

    @Override // cn.irisgw.live.CloseLiveExtraOrBuilder
    public KickInfoOrBuilder getKickInfoOrBuilder() {
        return getKickInfo();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<CloseLiveExtra> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.kickInfo_ != null) {
            i2 = 0 + CodedOutputStream.computeMessageSize(1, getKickInfo());
        }
        int serializedSize = i2 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // cn.irisgw.live.CloseLiveExtraOrBuilder
    public boolean hasKickInfo() {
        return this.kickInfo_ != null;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = 779 + getDescriptor().hashCode();
        int i = hashCode;
        if (hasKickInfo()) {
            i = (((hashCode * 37) + 1) * 53) + getKickInfo().hashCode();
        }
        int hashCode2 = (i * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_CloseLiveExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(CloseLiveExtra.class, Builder.class);
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
        return new CloseLiveExtra();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (this.kickInfo_ != null) {
            codedOutputStream.writeMessage(1, getKickInfo());
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
