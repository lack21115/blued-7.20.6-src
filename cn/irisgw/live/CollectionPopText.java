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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/CollectionPopText.class */
public final class CollectionPopText extends GeneratedMessageV3 implements CollectionPopTextOrBuilder {
    private static final CollectionPopText DEFAULT_INSTANCE = new CollectionPopText();
    private static final Parser<CollectionPopText> PARSER = new AbstractParser<CollectionPopText>() { // from class: cn.irisgw.live.CollectionPopText.1
        @Override // com.google.protobuf.Parser
        public CollectionPopText parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new CollectionPopText(codedInputStream, extensionRegistryLite);
        }
    };
    public static final int POP_TEXT_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private List<text> popText_;

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/CollectionPopText$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CollectionPopTextOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilderV3<text, text.Builder, textOrBuilder> popTextBuilder_;
        private List<text> popText_;

        private Builder() {
            this.popText_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.popText_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private void ensurePopTextIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.popText_ = new ArrayList(this.popText_);
                this.bitField0_ |= 1;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_CollectionPopText_descriptor;
        }

        private RepeatedFieldBuilderV3<text, text.Builder, textOrBuilder> getPopTextFieldBuilder() {
            if (this.popTextBuilder_ == null) {
                List<text> list = this.popText_;
                boolean z = true;
                if ((this.bitField0_ & 1) == 0) {
                    z = false;
                }
                this.popTextBuilder_ = new RepeatedFieldBuilderV3<>(list, z, getParentForChildren(), isClean());
                this.popText_ = null;
            }
            return this.popTextBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (CollectionPopText.alwaysUseFieldBuilders) {
                getPopTextFieldBuilder();
            }
        }

        public Builder addAllPopText(Iterable<? extends text> iterable) {
            RepeatedFieldBuilderV3<text, text.Builder, textOrBuilder> repeatedFieldBuilderV3 = this.popTextBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensurePopTextIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.popText_);
            onChanged();
            return this;
        }

        public Builder addPopText(int i, text.Builder builder) {
            RepeatedFieldBuilderV3<text, text.Builder, textOrBuilder> repeatedFieldBuilderV3 = this.popTextBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.build());
                return this;
            }
            ensurePopTextIsMutable();
            this.popText_.add(i, builder.build());
            onChanged();
            return this;
        }

        public Builder addPopText(int i, text textVar) {
            RepeatedFieldBuilderV3<text, text.Builder, textOrBuilder> repeatedFieldBuilderV3 = this.popTextBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, textVar);
                return this;
            } else if (textVar != null) {
                ensurePopTextIsMutable();
                this.popText_.add(i, textVar);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addPopText(text.Builder builder) {
            RepeatedFieldBuilderV3<text, text.Builder, textOrBuilder> repeatedFieldBuilderV3 = this.popTextBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(builder.build());
                return this;
            }
            ensurePopTextIsMutable();
            this.popText_.add(builder.build());
            onChanged();
            return this;
        }

        public Builder addPopText(text textVar) {
            RepeatedFieldBuilderV3<text, text.Builder, textOrBuilder> repeatedFieldBuilderV3 = this.popTextBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(textVar);
                return this;
            } else if (textVar != null) {
                ensurePopTextIsMutable();
                this.popText_.add(textVar);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public text.Builder addPopTextBuilder() {
            return getPopTextFieldBuilder().addBuilder(text.getDefaultInstance());
        }

        public text.Builder addPopTextBuilder(int i) {
            return getPopTextFieldBuilder().addBuilder(i, text.getDefaultInstance());
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CollectionPopText build() {
            CollectionPopText buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public CollectionPopText buildPartial() {
            CollectionPopText collectionPopText = new CollectionPopText(this);
            int i = this.bitField0_;
            RepeatedFieldBuilderV3<text, text.Builder, textOrBuilder> repeatedFieldBuilderV3 = this.popTextBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((i & 1) != 0) {
                    this.popText_ = Collections.unmodifiableList(this.popText_);
                    this.bitField0_ &= -2;
                }
                collectionPopText.popText_ = this.popText_;
            } else {
                collectionPopText.popText_ = repeatedFieldBuilderV3.build();
            }
            onBuilt();
            return collectionPopText;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            RepeatedFieldBuilderV3<text, text.Builder, textOrBuilder> repeatedFieldBuilderV3 = this.popTextBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.popText_ = Collections.emptyList();
            this.bitField0_ &= -2;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearPopText() {
            RepeatedFieldBuilderV3<text, text.Builder, textOrBuilder> repeatedFieldBuilderV3 = this.popTextBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.popText_ = Collections.emptyList();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo1800clone() {
            return (Builder) super.mo1800clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CollectionPopText getDefaultInstanceForType() {
            return CollectionPopText.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_CollectionPopText_descriptor;
        }

        @Override // cn.irisgw.live.CollectionPopTextOrBuilder
        public text getPopText(int i) {
            RepeatedFieldBuilderV3<text, text.Builder, textOrBuilder> repeatedFieldBuilderV3 = this.popTextBuilder_;
            return repeatedFieldBuilderV3 == null ? this.popText_.get(i) : repeatedFieldBuilderV3.getMessage(i);
        }

        public text.Builder getPopTextBuilder(int i) {
            return getPopTextFieldBuilder().getBuilder(i);
        }

        public List<text.Builder> getPopTextBuilderList() {
            return getPopTextFieldBuilder().getBuilderList();
        }

        @Override // cn.irisgw.live.CollectionPopTextOrBuilder
        public int getPopTextCount() {
            RepeatedFieldBuilderV3<text, text.Builder, textOrBuilder> repeatedFieldBuilderV3 = this.popTextBuilder_;
            return repeatedFieldBuilderV3 == null ? this.popText_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // cn.irisgw.live.CollectionPopTextOrBuilder
        public List<text> getPopTextList() {
            RepeatedFieldBuilderV3<text, text.Builder, textOrBuilder> repeatedFieldBuilderV3 = this.popTextBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.popText_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // cn.irisgw.live.CollectionPopTextOrBuilder
        public textOrBuilder getPopTextOrBuilder(int i) {
            RepeatedFieldBuilderV3<text, text.Builder, textOrBuilder> repeatedFieldBuilderV3 = this.popTextBuilder_;
            return repeatedFieldBuilderV3 == null ? this.popText_.get(i) : repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // cn.irisgw.live.CollectionPopTextOrBuilder
        public List<? extends textOrBuilder> getPopTextOrBuilderList() {
            RepeatedFieldBuilderV3<text, text.Builder, textOrBuilder> repeatedFieldBuilderV3 = this.popTextBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.popText_);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_CollectionPopText_fieldAccessorTable.ensureFieldAccessorsInitialized(CollectionPopText.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(CollectionPopText collectionPopText) {
            if (collectionPopText == CollectionPopText.getDefaultInstance()) {
                return this;
            }
            if (this.popTextBuilder_ == null) {
                if (!collectionPopText.popText_.isEmpty()) {
                    if (this.popText_.isEmpty()) {
                        this.popText_ = collectionPopText.popText_;
                        this.bitField0_ &= -2;
                    } else {
                        ensurePopTextIsMutable();
                        this.popText_.addAll(collectionPopText.popText_);
                    }
                    onChanged();
                }
            } else if (!collectionPopText.popText_.isEmpty()) {
                if (this.popTextBuilder_.isEmpty()) {
                    this.popTextBuilder_.dispose();
                    RepeatedFieldBuilderV3<text, text.Builder, textOrBuilder> repeatedFieldBuilderV3 = null;
                    this.popTextBuilder_ = null;
                    this.popText_ = collectionPopText.popText_;
                    this.bitField0_ &= -2;
                    if (CollectionPopText.alwaysUseFieldBuilders) {
                        repeatedFieldBuilderV3 = getPopTextFieldBuilder();
                    }
                    this.popTextBuilder_ = repeatedFieldBuilderV3;
                } else {
                    this.popTextBuilder_.addAllMessages(collectionPopText.popText_);
                }
            }
            mergeUnknownFields(collectionPopText.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.CollectionPopText.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.CollectionPopText.access$2200()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.CollectionPopText r0 = (cn.irisgw.live.CollectionPopText) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.CollectionPopText$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.CollectionPopText r0 = (cn.irisgw.live.CollectionPopText) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.CollectionPopText$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.CollectionPopText.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.CollectionPopText$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof CollectionPopText) {
                return mergeFrom((CollectionPopText) message);
            }
            super.mergeFrom(message);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder removePopText(int i) {
            RepeatedFieldBuilderV3<text, text.Builder, textOrBuilder> repeatedFieldBuilderV3 = this.popTextBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.remove(i);
                return this;
            }
            ensurePopTextIsMutable();
            this.popText_.remove(i);
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setPopText(int i, text.Builder builder) {
            RepeatedFieldBuilderV3<text, text.Builder, textOrBuilder> repeatedFieldBuilderV3 = this.popTextBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.build());
                return this;
            }
            ensurePopTextIsMutable();
            this.popText_.set(i, builder.build());
            onChanged();
            return this;
        }

        public Builder setPopText(int i, text textVar) {
            RepeatedFieldBuilderV3<text, text.Builder, textOrBuilder> repeatedFieldBuilderV3 = this.popTextBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, textVar);
                return this;
            } else if (textVar != null) {
                ensurePopTextIsMutable();
                this.popText_.set(i, textVar);
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

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/CollectionPopText$text.class */
    public static final class text extends GeneratedMessageV3 implements textOrBuilder {
        public static final int LINK_FIELD_NUMBER = 6;
        public static final int LINK_TYPE_FIELD_NUMBER = 4;
        public static final int ORDER_FIELD_NUMBER = 5;
        public static final int TEXT_FIELD_NUMBER = 2;
        public static final int TIME_FIELD_NUMBER = 3;
        public static final int TYPE_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int linkType_;
        private volatile Object link_;
        private byte memoizedIsInitialized;
        private int order_;
        private volatile Object text_;
        private long time_;
        private int type_;
        private static final text DEFAULT_INSTANCE = new text();
        private static final Parser<text> PARSER = new AbstractParser<text>() { // from class: cn.irisgw.live.CollectionPopText.text.1
            @Override // com.google.protobuf.Parser
            public text parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new text(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/CollectionPopText$text$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements textOrBuilder {
            private int linkType_;
            private Object link_;
            private int order_;
            private Object text_;
            private long time_;
            private int type_;

            private Builder() {
                this.text_ = "";
                this.link_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.text_ = "";
                this.link_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LiveConstants.internal_static_cn_irisgw_live_CollectionPopText_text_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = text.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public text build() {
                text buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public text buildPartial() {
                text textVar = new text(this);
                textVar.type_ = this.type_;
                textVar.text_ = this.text_;
                textVar.time_ = this.time_;
                textVar.linkType_ = this.linkType_;
                textVar.order_ = this.order_;
                textVar.link_ = this.link_;
                onBuilt();
                return textVar;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.type_ = 0;
                this.text_ = "";
                this.time_ = 0L;
                this.linkType_ = 0;
                this.order_ = 0;
                this.link_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearLink() {
                this.link_ = text.getDefaultInstance().getLink();
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

            public Builder clearOrder() {
                this.order_ = 0;
                onChanged();
                return this;
            }

            public Builder clearText() {
                this.text_ = text.getDefaultInstance().getText();
                onChanged();
                return this;
            }

            public Builder clearTime() {
                this.time_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.type_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1800clone() {
                return (Builder) super.mo1800clone();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public text getDefaultInstanceForType() {
                return text.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return LiveConstants.internal_static_cn_irisgw_live_CollectionPopText_text_descriptor;
            }

            @Override // cn.irisgw.live.CollectionPopText.textOrBuilder
            public String getLink() {
                Object obj = this.link_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.link_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.CollectionPopText.textOrBuilder
            public ByteString getLinkBytes() {
                Object obj = this.link_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.link_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.CollectionPopText.textOrBuilder
            public int getLinkType() {
                return this.linkType_;
            }

            @Override // cn.irisgw.live.CollectionPopText.textOrBuilder
            public int getOrder() {
                return this.order_;
            }

            @Override // cn.irisgw.live.CollectionPopText.textOrBuilder
            public String getText() {
                Object obj = this.text_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.text_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.CollectionPopText.textOrBuilder
            public ByteString getTextBytes() {
                Object obj = this.text_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.text_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.CollectionPopText.textOrBuilder
            public long getTime() {
                return this.time_;
            }

            @Override // cn.irisgw.live.CollectionPopText.textOrBuilder
            public int getType() {
                return this.type_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveConstants.internal_static_cn_irisgw_live_CollectionPopText_text_fieldAccessorTable.ensureFieldAccessorsInitialized(text.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(text textVar) {
                if (textVar == text.getDefaultInstance()) {
                    return this;
                }
                if (textVar.getType() != 0) {
                    setType(textVar.getType());
                }
                if (!textVar.getText().isEmpty()) {
                    this.text_ = textVar.text_;
                    onChanged();
                }
                if (textVar.getTime() != 0) {
                    setTime(textVar.getTime());
                }
                if (textVar.getLinkType() != 0) {
                    setLinkType(textVar.getLinkType());
                }
                if (textVar.getOrder() != 0) {
                    setOrder(textVar.getOrder());
                }
                if (!textVar.getLink().isEmpty()) {
                    this.link_ = textVar.link_;
                    onChanged();
                }
                mergeUnknownFields(textVar.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.CollectionPopText.text.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.CollectionPopText.text.access$1100()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.CollectionPopText$text r0 = (cn.irisgw.live.CollectionPopText.text) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.CollectionPopText$text$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.CollectionPopText$text r0 = (cn.irisgw.live.CollectionPopText.text) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.CollectionPopText$text$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.CollectionPopText.text.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.CollectionPopText$text$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof text) {
                    return mergeFrom((text) message);
                }
                super.mergeFrom(message);
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
                    text.checkByteStringIsUtf8(byteString);
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

            public Builder setOrder(int i) {
                this.order_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setText(String str) {
                if (str != null) {
                    this.text_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setTextBytes(ByteString byteString) {
                if (byteString != null) {
                    text.checkByteStringIsUtf8(byteString);
                    this.text_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setTime(long j) {
                this.time_ = j;
                onChanged();
                return this;
            }

            public Builder setType(int i) {
                this.type_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private text() {
            this.memoizedIsInitialized = (byte) -1;
            this.text_ = "";
            this.link_ = "";
        }

        private text(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.type_ = codedInputStream.readInt32();
                            } else if (readTag == 18) {
                                this.text_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 24) {
                                this.time_ = codedInputStream.readUInt64();
                            } else if (readTag == 32) {
                                this.linkType_ = codedInputStream.readInt32();
                            } else if (readTag == 40) {
                                this.order_ = codedInputStream.readInt32();
                            } else if (readTag == 50) {
                                this.link_ = codedInputStream.readStringRequireUtf8();
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

        private text(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static text getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_CollectionPopText_text_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(text textVar) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(textVar);
        }

        public static text parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (text) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static text parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (text) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static text parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static text parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static text parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (text) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static text parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (text) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static text parseFrom(InputStream inputStream) throws IOException {
            return (text) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static text parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (text) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static text parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static text parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static text parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static text parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<text> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof text) {
                text textVar = (text) obj;
                return getType() == textVar.getType() && getText().equals(textVar.getText()) && getTime() == textVar.getTime() && getLinkType() == textVar.getLinkType() && getOrder() == textVar.getOrder() && getLink().equals(textVar.getLink()) && this.unknownFields.equals(textVar.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public text getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // cn.irisgw.live.CollectionPopText.textOrBuilder
        public String getLink() {
            Object obj = this.link_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.link_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.CollectionPopText.textOrBuilder
        public ByteString getLinkBytes() {
            Object obj = this.link_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.link_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.CollectionPopText.textOrBuilder
        public int getLinkType() {
            return this.linkType_;
        }

        @Override // cn.irisgw.live.CollectionPopText.textOrBuilder
        public int getOrder() {
            return this.order_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<text> getParserForType() {
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
                i2 = 0 + CodedOutputStream.computeInt32Size(1, i3);
            }
            int i4 = i2;
            if (!getTextBytes().isEmpty()) {
                i4 = i2 + GeneratedMessageV3.computeStringSize(2, this.text_);
            }
            long j = this.time_;
            int i5 = i4;
            if (j != 0) {
                i5 = i4 + CodedOutputStream.computeUInt64Size(3, j);
            }
            int i6 = this.linkType_;
            int i7 = i5;
            if (i6 != 0) {
                i7 = i5 + CodedOutputStream.computeInt32Size(4, i6);
            }
            int i8 = this.order_;
            int i9 = i7;
            if (i8 != 0) {
                i9 = i7 + CodedOutputStream.computeInt32Size(5, i8);
            }
            int i10 = i9;
            if (!getLinkBytes().isEmpty()) {
                i10 = i9 + GeneratedMessageV3.computeStringSize(6, this.link_);
            }
            int serializedSize = i10 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // cn.irisgw.live.CollectionPopText.textOrBuilder
        public String getText() {
            Object obj = this.text_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.text_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.CollectionPopText.textOrBuilder
        public ByteString getTextBytes() {
            Object obj = this.text_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.text_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.CollectionPopText.textOrBuilder
        public long getTime() {
            return this.time_;
        }

        @Override // cn.irisgw.live.CollectionPopText.textOrBuilder
        public int getType() {
            return this.type_;
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
            int hashCode = ((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getType()) * 37) + 2) * 53) + getText().hashCode()) * 37) + 3) * 53) + Internal.hashLong(getTime())) * 37) + 4) * 53) + getLinkType()) * 37) + 5) * 53) + getOrder()) * 37) + 6) * 53) + getLink().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_CollectionPopText_text_fieldAccessorTable.ensureFieldAccessorsInitialized(text.class, Builder.class);
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
            return new text();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i = this.type_;
            if (i != 0) {
                codedOutputStream.writeInt32(1, i);
            }
            if (!getTextBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.text_);
            }
            long j = this.time_;
            if (j != 0) {
                codedOutputStream.writeUInt64(3, j);
            }
            int i2 = this.linkType_;
            if (i2 != 0) {
                codedOutputStream.writeInt32(4, i2);
            }
            int i3 = this.order_;
            if (i3 != 0) {
                codedOutputStream.writeInt32(5, i3);
            }
            if (!getLinkBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 6, this.link_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/CollectionPopText$textOrBuilder.class */
    public interface textOrBuilder extends MessageOrBuilder {
        String getLink();

        ByteString getLinkBytes();

        int getLinkType();

        int getOrder();

        String getText();

        ByteString getTextBytes();

        long getTime();

        int getType();
    }

    private CollectionPopText() {
        this.memoizedIsInitialized = (byte) -1;
        this.popText_ = Collections.emptyList();
    }

    private CollectionPopText(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.popText_ = new ArrayList();
                                z4 = z2 | true;
                            }
                            this.popText_.add((text) codedInputStream.readMessage(text.parser(), extensionRegistryLite));
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
                    this.popText_ = Collections.unmodifiableList(this.popText_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                throw th;
            }
        }
        if (z2 & true) {
            this.popText_ = Collections.unmodifiableList(this.popText_);
        }
        this.unknownFields = newBuilder.build();
        makeExtensionsImmutable();
    }

    private CollectionPopText(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static CollectionPopText getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_CollectionPopText_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(CollectionPopText collectionPopText) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(collectionPopText);
    }

    public static CollectionPopText parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (CollectionPopText) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static CollectionPopText parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CollectionPopText) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static CollectionPopText parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static CollectionPopText parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static CollectionPopText parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (CollectionPopText) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static CollectionPopText parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CollectionPopText) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static CollectionPopText parseFrom(InputStream inputStream) throws IOException {
        return (CollectionPopText) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static CollectionPopText parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CollectionPopText) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static CollectionPopText parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static CollectionPopText parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static CollectionPopText parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static CollectionPopText parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<CollectionPopText> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CollectionPopText) {
            CollectionPopText collectionPopText = (CollectionPopText) obj;
            return getPopTextList().equals(collectionPopText.getPopTextList()) && this.unknownFields.equals(collectionPopText.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public CollectionPopText getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<CollectionPopText> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.CollectionPopTextOrBuilder
    public text getPopText(int i) {
        return this.popText_.get(i);
    }

    @Override // cn.irisgw.live.CollectionPopTextOrBuilder
    public int getPopTextCount() {
        return this.popText_.size();
    }

    @Override // cn.irisgw.live.CollectionPopTextOrBuilder
    public List<text> getPopTextList() {
        return this.popText_;
    }

    @Override // cn.irisgw.live.CollectionPopTextOrBuilder
    public textOrBuilder getPopTextOrBuilder(int i) {
        return this.popText_.get(i);
    }

    @Override // cn.irisgw.live.CollectionPopTextOrBuilder
    public List<? extends textOrBuilder> getPopTextOrBuilderList() {
        return this.popText_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.popText_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(1, this.popText_.get(i3));
        }
        int serializedSize = i2 + this.unknownFields.getSerializedSize();
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
        int hashCode = 779 + getDescriptor().hashCode();
        int i = hashCode;
        if (getPopTextCount() > 0) {
            i = (((hashCode * 37) + 1) * 53) + getPopTextList().hashCode();
        }
        int hashCode2 = (i * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_CollectionPopText_fieldAccessorTable.ensureFieldAccessorsInitialized(CollectionPopText.class, Builder.class);
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
        return new CollectionPopText();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.popText_.size()) {
                this.unknownFields.writeTo(codedOutputStream);
                return;
            } else {
                codedOutputStream.writeMessage(1, this.popText_.get(i2));
                i = i2 + 1;
            }
        }
    }
}
