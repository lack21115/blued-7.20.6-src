package com.google.api;

import com.google.api.CustomHttpPattern;
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
import com.google.protobuf.MessageLite;
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

/* loaded from: source-8110460-dex2jar.jar:com/google/api/HttpRule.class */
public final class HttpRule extends GeneratedMessageV3 implements HttpRuleOrBuilder {
    public static final int ADDITIONAL_BINDINGS_FIELD_NUMBER = 11;
    public static final int BODY_FIELD_NUMBER = 7;
    public static final int CUSTOM_FIELD_NUMBER = 8;
    public static final int DELETE_FIELD_NUMBER = 5;
    public static final int GET_FIELD_NUMBER = 2;
    public static final int PATCH_FIELD_NUMBER = 6;
    public static final int POST_FIELD_NUMBER = 4;
    public static final int PUT_FIELD_NUMBER = 3;
    public static final int RESPONSE_BODY_FIELD_NUMBER = 12;
    public static final int SELECTOR_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private List<HttpRule> additionalBindings_;
    private int bitField0_;
    private volatile Object body_;
    private byte memoizedIsInitialized;
    private int patternCase_;
    private Object pattern_;
    private volatile Object responseBody_;
    private volatile Object selector_;
    private static final HttpRule DEFAULT_INSTANCE = new HttpRule();
    private static final Parser<HttpRule> PARSER = new AbstractParser<HttpRule>() { // from class: com.google.api.HttpRule.1
        @Override // com.google.protobuf.Parser
        public HttpRule parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new HttpRule(codedInputStream, extensionRegistryLite);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.api.HttpRule$2  reason: invalid class name */
    /* loaded from: source-8110460-dex2jar.jar:com/google/api/HttpRule$2.class */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$api$HttpRule$PatternCase;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0059 -> B:33:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005d -> B:43:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0061 -> B:39:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0065 -> B:35:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0069 -> B:31:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x006d -> B:41:0x004c). Please submit an issue!!! */
        static {
            int[] iArr = new int[PatternCase.values().length];
            $SwitchMap$com$google$api$HttpRule$PatternCase = iArr;
            try {
                iArr[PatternCase.GET.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$google$api$HttpRule$PatternCase[PatternCase.PUT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$google$api$HttpRule$PatternCase[PatternCase.POST.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$google$api$HttpRule$PatternCase[PatternCase.DELETE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$google$api$HttpRule$PatternCase[PatternCase.PATCH.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$google$api$HttpRule$PatternCase[PatternCase.CUSTOM.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$google$api$HttpRule$PatternCase[PatternCase.PATTERN_NOT_SET.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/google/api/HttpRule$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HttpRuleOrBuilder {
        private RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> additionalBindingsBuilder_;
        private List<HttpRule> additionalBindings_;
        private int bitField0_;
        private Object body_;
        private SingleFieldBuilderV3<CustomHttpPattern, CustomHttpPattern.Builder, CustomHttpPatternOrBuilder> customBuilder_;
        private int patternCase_;
        private Object pattern_;
        private Object responseBody_;
        private Object selector_;

        private Builder() {
            this.patternCase_ = 0;
            this.selector_ = "";
            this.body_ = "";
            this.responseBody_ = "";
            this.additionalBindings_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.patternCase_ = 0;
            this.selector_ = "";
            this.body_ = "";
            this.responseBody_ = "";
            this.additionalBindings_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private void ensureAdditionalBindingsIsMutable() {
            if ((this.bitField0_ & 512) == 0) {
                this.additionalBindings_ = new ArrayList(this.additionalBindings_);
                this.bitField0_ |= 512;
            }
        }

        private RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> getAdditionalBindingsFieldBuilder() {
            if (this.additionalBindingsBuilder_ == null) {
                this.additionalBindingsBuilder_ = new RepeatedFieldBuilderV3<>(this.additionalBindings_, (this.bitField0_ & 512) != 0, getParentForChildren(), isClean());
                this.additionalBindings_ = null;
            }
            return this.additionalBindingsBuilder_;
        }

        private SingleFieldBuilderV3<CustomHttpPattern, CustomHttpPattern.Builder, CustomHttpPatternOrBuilder> getCustomFieldBuilder() {
            if (this.customBuilder_ == null) {
                if (this.patternCase_ != 8) {
                    this.pattern_ = CustomHttpPattern.getDefaultInstance();
                }
                this.customBuilder_ = new SingleFieldBuilderV3<>((CustomHttpPattern) this.pattern_, getParentForChildren(), isClean());
                this.pattern_ = null;
            }
            this.patternCase_ = 8;
            onChanged();
            return this.customBuilder_;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return HttpProto.internal_static_google_api_HttpRule_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            if (HttpRule.alwaysUseFieldBuilders) {
                getAdditionalBindingsFieldBuilder();
            }
        }

        public Builder addAdditionalBindings(int i, Builder builder) {
            RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.build());
                return this;
            }
            ensureAdditionalBindingsIsMutable();
            this.additionalBindings_.add(i, builder.build());
            onChanged();
            return this;
        }

        public Builder addAdditionalBindings(int i, HttpRule httpRule) {
            RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, httpRule);
                return this;
            } else if (httpRule != null) {
                ensureAdditionalBindingsIsMutable();
                this.additionalBindings_.add(i, httpRule);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addAdditionalBindings(Builder builder) {
            RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(builder.build());
                return this;
            }
            ensureAdditionalBindingsIsMutable();
            this.additionalBindings_.add(builder.build());
            onChanged();
            return this;
        }

        public Builder addAdditionalBindings(HttpRule httpRule) {
            RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(httpRule);
                return this;
            } else if (httpRule != null) {
                ensureAdditionalBindingsIsMutable();
                this.additionalBindings_.add(httpRule);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addAdditionalBindingsBuilder() {
            return getAdditionalBindingsFieldBuilder().addBuilder(HttpRule.getDefaultInstance());
        }

        public Builder addAdditionalBindingsBuilder(int i) {
            return getAdditionalBindingsFieldBuilder().addBuilder(i, HttpRule.getDefaultInstance());
        }

        public Builder addAllAdditionalBindings(Iterable<? extends HttpRule> iterable) {
            RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensureAdditionalBindingsIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.additionalBindings_);
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public HttpRule build() {
            HttpRule buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public HttpRule buildPartial() {
            HttpRule httpRule = new HttpRule(this);
            httpRule.selector_ = this.selector_;
            if (this.patternCase_ == 2) {
                httpRule.pattern_ = this.pattern_;
            }
            if (this.patternCase_ == 3) {
                httpRule.pattern_ = this.pattern_;
            }
            if (this.patternCase_ == 4) {
                httpRule.pattern_ = this.pattern_;
            }
            if (this.patternCase_ == 5) {
                httpRule.pattern_ = this.pattern_;
            }
            if (this.patternCase_ == 6) {
                httpRule.pattern_ = this.pattern_;
            }
            if (this.patternCase_ == 8) {
                SingleFieldBuilderV3<CustomHttpPattern, CustomHttpPattern.Builder, CustomHttpPatternOrBuilder> singleFieldBuilderV3 = this.customBuilder_;
                if (singleFieldBuilderV3 == null) {
                    httpRule.pattern_ = this.pattern_;
                } else {
                    httpRule.pattern_ = singleFieldBuilderV3.build();
                }
            }
            httpRule.body_ = this.body_;
            httpRule.responseBody_ = this.responseBody_;
            RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((this.bitField0_ & 512) != 0) {
                    this.additionalBindings_ = Collections.unmodifiableList(this.additionalBindings_);
                    this.bitField0_ &= -513;
                }
                httpRule.additionalBindings_ = this.additionalBindings_;
            } else {
                httpRule.additionalBindings_ = repeatedFieldBuilderV3.build();
            }
            httpRule.bitField0_ = 0;
            httpRule.patternCase_ = this.patternCase_;
            onBuilt();
            return httpRule;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.selector_ = "";
            this.body_ = "";
            this.responseBody_ = "";
            RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.additionalBindings_ = Collections.emptyList();
                this.bitField0_ &= -513;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            this.patternCase_ = 0;
            this.pattern_ = null;
            return this;
        }

        public Builder clearAdditionalBindings() {
            RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.additionalBindings_ = Collections.emptyList();
            this.bitField0_ &= -513;
            onChanged();
            return this;
        }

        public Builder clearBody() {
            this.body_ = HttpRule.getDefaultInstance().getBody();
            onChanged();
            return this;
        }

        public Builder clearCustom() {
            if (this.customBuilder_ != null) {
                if (this.patternCase_ == 8) {
                    this.patternCase_ = 0;
                    this.pattern_ = null;
                }
                this.customBuilder_.clear();
            } else if (this.patternCase_ == 8) {
                this.patternCase_ = 0;
                this.pattern_ = null;
                onChanged();
                return this;
            }
            return this;
        }

        public Builder clearDelete() {
            if (this.patternCase_ == 5) {
                this.patternCase_ = 0;
                this.pattern_ = null;
                onChanged();
            }
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearGet() {
            if (this.patternCase_ == 2) {
                this.patternCase_ = 0;
                this.pattern_ = null;
                onChanged();
            }
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearPatch() {
            if (this.patternCase_ == 6) {
                this.patternCase_ = 0;
                this.pattern_ = null;
                onChanged();
            }
            return this;
        }

        public Builder clearPattern() {
            this.patternCase_ = 0;
            this.pattern_ = null;
            onChanged();
            return this;
        }

        public Builder clearPost() {
            if (this.patternCase_ == 4) {
                this.patternCase_ = 0;
                this.pattern_ = null;
                onChanged();
            }
            return this;
        }

        public Builder clearPut() {
            if (this.patternCase_ == 3) {
                this.patternCase_ = 0;
                this.pattern_ = null;
                onChanged();
            }
            return this;
        }

        public Builder clearResponseBody() {
            this.responseBody_ = HttpRule.getDefaultInstance().getResponseBody();
            onChanged();
            return this;
        }

        public Builder clearSelector() {
            this.selector_ = HttpRule.getDefaultInstance().getSelector();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo2030clone() {
            return (Builder) super.mo2030clone();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public HttpRule getAdditionalBindings(int i) {
            RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.additionalBindings_.get(i) : repeatedFieldBuilderV3.getMessage(i);
        }

        public Builder getAdditionalBindingsBuilder(int i) {
            return getAdditionalBindingsFieldBuilder().getBuilder(i);
        }

        public List<Builder> getAdditionalBindingsBuilderList() {
            return getAdditionalBindingsFieldBuilder().getBuilderList();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public int getAdditionalBindingsCount() {
            RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.additionalBindings_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public List<HttpRule> getAdditionalBindingsList() {
            RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.additionalBindings_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public HttpRuleOrBuilder getAdditionalBindingsOrBuilder(int i) {
            RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.additionalBindings_.get(i) : repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public List<? extends HttpRuleOrBuilder> getAdditionalBindingsOrBuilderList() {
            RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.additionalBindings_);
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public String getBody() {
            Object obj = this.body_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.body_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public ByteString getBodyBytes() {
            Object obj = this.body_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.body_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public CustomHttpPattern getCustom() {
            SingleFieldBuilderV3<CustomHttpPattern, CustomHttpPattern.Builder, CustomHttpPatternOrBuilder> singleFieldBuilderV3 = this.customBuilder_;
            return singleFieldBuilderV3 == null ? this.patternCase_ == 8 ? (CustomHttpPattern) this.pattern_ : CustomHttpPattern.getDefaultInstance() : this.patternCase_ == 8 ? singleFieldBuilderV3.getMessage() : CustomHttpPattern.getDefaultInstance();
        }

        public CustomHttpPattern.Builder getCustomBuilder() {
            return getCustomFieldBuilder().getBuilder();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public CustomHttpPatternOrBuilder getCustomOrBuilder() {
            SingleFieldBuilderV3<CustomHttpPattern, CustomHttpPattern.Builder, CustomHttpPatternOrBuilder> singleFieldBuilderV3;
            return (this.patternCase_ != 8 || (singleFieldBuilderV3 = this.customBuilder_) == null) ? this.patternCase_ == 8 ? (CustomHttpPattern) this.pattern_ : CustomHttpPattern.getDefaultInstance() : singleFieldBuilderV3.getMessageOrBuilder();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HttpRule getDefaultInstanceForType() {
            return HttpRule.getDefaultInstance();
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public String getDelete() {
            String str = this.patternCase_ == 5 ? this.pattern_ : "";
            if (str instanceof String) {
                return (String) str;
            }
            String stringUtf8 = ((ByteString) str).toStringUtf8();
            if (this.patternCase_ == 5) {
                this.pattern_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public ByteString getDeleteBytes() {
            String str = this.patternCase_ == 5 ? this.pattern_ : "";
            if (str instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) str);
                if (this.patternCase_ == 5) {
                    this.pattern_ = copyFromUtf8;
                }
                return copyFromUtf8;
            }
            return (ByteString) str;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return HttpProto.internal_static_google_api_HttpRule_descriptor;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public String getGet() {
            String str = this.patternCase_ == 2 ? this.pattern_ : "";
            if (str instanceof String) {
                return (String) str;
            }
            String stringUtf8 = ((ByteString) str).toStringUtf8();
            if (this.patternCase_ == 2) {
                this.pattern_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public ByteString getGetBytes() {
            String str = this.patternCase_ == 2 ? this.pattern_ : "";
            if (str instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) str);
                if (this.patternCase_ == 2) {
                    this.pattern_ = copyFromUtf8;
                }
                return copyFromUtf8;
            }
            return (ByteString) str;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public String getPatch() {
            String str = this.patternCase_ == 6 ? this.pattern_ : "";
            if (str instanceof String) {
                return (String) str;
            }
            String stringUtf8 = ((ByteString) str).toStringUtf8();
            if (this.patternCase_ == 6) {
                this.pattern_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public ByteString getPatchBytes() {
            String str = this.patternCase_ == 6 ? this.pattern_ : "";
            if (str instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) str);
                if (this.patternCase_ == 6) {
                    this.pattern_ = copyFromUtf8;
                }
                return copyFromUtf8;
            }
            return (ByteString) str;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public PatternCase getPatternCase() {
            return PatternCase.forNumber(this.patternCase_);
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public String getPost() {
            String str = this.patternCase_ == 4 ? this.pattern_ : "";
            if (str instanceof String) {
                return (String) str;
            }
            String stringUtf8 = ((ByteString) str).toStringUtf8();
            if (this.patternCase_ == 4) {
                this.pattern_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public ByteString getPostBytes() {
            String str = this.patternCase_ == 4 ? this.pattern_ : "";
            if (str instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) str);
                if (this.patternCase_ == 4) {
                    this.pattern_ = copyFromUtf8;
                }
                return copyFromUtf8;
            }
            return (ByteString) str;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public String getPut() {
            String str = this.patternCase_ == 3 ? this.pattern_ : "";
            if (str instanceof String) {
                return (String) str;
            }
            String stringUtf8 = ((ByteString) str).toStringUtf8();
            if (this.patternCase_ == 3) {
                this.pattern_ = stringUtf8;
            }
            return stringUtf8;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public ByteString getPutBytes() {
            String str = this.patternCase_ == 3 ? this.pattern_ : "";
            if (str instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) str);
                if (this.patternCase_ == 3) {
                    this.pattern_ = copyFromUtf8;
                }
                return copyFromUtf8;
            }
            return (ByteString) str;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public String getResponseBody() {
            Object obj = this.responseBody_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.responseBody_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public ByteString getResponseBodyBytes() {
            Object obj = this.responseBody_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.responseBody_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public String getSelector() {
            Object obj = this.selector_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.selector_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public ByteString getSelectorBytes() {
            Object obj = this.selector_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.selector_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.api.HttpRuleOrBuilder
        public boolean hasCustom() {
            return this.patternCase_ == 8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HttpProto.internal_static_google_api_HttpRule_fieldAccessorTable.ensureFieldAccessorsInitialized(HttpRule.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeCustom(CustomHttpPattern customHttpPattern) {
            SingleFieldBuilderV3<CustomHttpPattern, CustomHttpPattern.Builder, CustomHttpPatternOrBuilder> singleFieldBuilderV3 = this.customBuilder_;
            if (singleFieldBuilderV3 == null) {
                if (this.patternCase_ != 8 || this.pattern_ == CustomHttpPattern.getDefaultInstance()) {
                    this.pattern_ = customHttpPattern;
                } else {
                    this.pattern_ = CustomHttpPattern.newBuilder((CustomHttpPattern) this.pattern_).mergeFrom(customHttpPattern).buildPartial();
                }
                onChanged();
            } else {
                if (this.patternCase_ == 8) {
                    singleFieldBuilderV3.mergeFrom(customHttpPattern);
                }
                this.customBuilder_.setMessage(customHttpPattern);
            }
            this.patternCase_ = 8;
            return this;
        }

        public Builder mergeFrom(HttpRule httpRule) {
            if (httpRule == HttpRule.getDefaultInstance()) {
                return this;
            }
            if (!httpRule.getSelector().isEmpty()) {
                this.selector_ = httpRule.selector_;
                onChanged();
            }
            if (!httpRule.getBody().isEmpty()) {
                this.body_ = httpRule.body_;
                onChanged();
            }
            if (!httpRule.getResponseBody().isEmpty()) {
                this.responseBody_ = httpRule.responseBody_;
                onChanged();
            }
            if (this.additionalBindingsBuilder_ == null) {
                if (!httpRule.additionalBindings_.isEmpty()) {
                    if (this.additionalBindings_.isEmpty()) {
                        this.additionalBindings_ = httpRule.additionalBindings_;
                        this.bitField0_ &= -513;
                    } else {
                        ensureAdditionalBindingsIsMutable();
                        this.additionalBindings_.addAll(httpRule.additionalBindings_);
                    }
                    onChanged();
                }
            } else if (!httpRule.additionalBindings_.isEmpty()) {
                if (this.additionalBindingsBuilder_.isEmpty()) {
                    this.additionalBindingsBuilder_.dispose();
                    RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = null;
                    this.additionalBindingsBuilder_ = null;
                    this.additionalBindings_ = httpRule.additionalBindings_;
                    this.bitField0_ &= -513;
                    if (HttpRule.alwaysUseFieldBuilders) {
                        repeatedFieldBuilderV3 = getAdditionalBindingsFieldBuilder();
                    }
                    this.additionalBindingsBuilder_ = repeatedFieldBuilderV3;
                } else {
                    this.additionalBindingsBuilder_.addAllMessages(httpRule.additionalBindings_);
                }
            }
            switch (AnonymousClass2.$SwitchMap$com$google$api$HttpRule$PatternCase[httpRule.getPatternCase().ordinal()]) {
                case 1:
                    this.patternCase_ = 2;
                    this.pattern_ = httpRule.pattern_;
                    onChanged();
                    break;
                case 2:
                    this.patternCase_ = 3;
                    this.pattern_ = httpRule.pattern_;
                    onChanged();
                    break;
                case 3:
                    this.patternCase_ = 4;
                    this.pattern_ = httpRule.pattern_;
                    onChanged();
                    break;
                case 4:
                    this.patternCase_ = 5;
                    this.pattern_ = httpRule.pattern_;
                    onChanged();
                    break;
                case 5:
                    this.patternCase_ = 6;
                    this.pattern_ = httpRule.pattern_;
                    onChanged();
                    break;
                case 6:
                    mergeCustom(httpRule.getCustom());
                    break;
            }
            mergeUnknownFields(httpRule.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.google.api.HttpRule.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = com.google.api.HttpRule.access$1300()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                com.google.api.HttpRule r0 = (com.google.api.HttpRule) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                com.google.api.HttpRule$Builder r0 = r0.mergeFrom(r1)
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
                com.google.api.HttpRule r0 = (com.google.api.HttpRule) r0     // Catch: java.lang.Throwable -> L1c
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
                com.google.api.HttpRule$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.api.HttpRule.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.api.HttpRule$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof HttpRule) {
                return mergeFrom((HttpRule) message);
            }
            super.mergeFrom(message);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder removeAdditionalBindings(int i) {
            RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.remove(i);
                return this;
            }
            ensureAdditionalBindingsIsMutable();
            this.additionalBindings_.remove(i);
            onChanged();
            return this;
        }

        public Builder setAdditionalBindings(int i, Builder builder) {
            RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.build());
                return this;
            }
            ensureAdditionalBindingsIsMutable();
            this.additionalBindings_.set(i, builder.build());
            onChanged();
            return this;
        }

        public Builder setAdditionalBindings(int i, HttpRule httpRule) {
            RepeatedFieldBuilderV3<HttpRule, Builder, HttpRuleOrBuilder> repeatedFieldBuilderV3 = this.additionalBindingsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, httpRule);
                return this;
            } else if (httpRule != null) {
                ensureAdditionalBindingsIsMutable();
                this.additionalBindings_.set(i, httpRule);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder setBody(String str) {
            if (str != null) {
                this.body_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setBodyBytes(ByteString byteString) {
            if (byteString != null) {
                HttpRule.checkByteStringIsUtf8(byteString);
                this.body_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setCustom(CustomHttpPattern.Builder builder) {
            SingleFieldBuilderV3<CustomHttpPattern, CustomHttpPattern.Builder, CustomHttpPatternOrBuilder> singleFieldBuilderV3 = this.customBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.pattern_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            this.patternCase_ = 8;
            return this;
        }

        public Builder setCustom(CustomHttpPattern customHttpPattern) {
            SingleFieldBuilderV3<CustomHttpPattern, CustomHttpPattern.Builder, CustomHttpPatternOrBuilder> singleFieldBuilderV3 = this.customBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(customHttpPattern);
            } else if (customHttpPattern == null) {
                throw null;
            } else {
                this.pattern_ = customHttpPattern;
                onChanged();
            }
            this.patternCase_ = 8;
            return this;
        }

        public Builder setDelete(String str) {
            if (str != null) {
                this.patternCase_ = 5;
                this.pattern_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setDeleteBytes(ByteString byteString) {
            if (byteString != null) {
                HttpRule.checkByteStringIsUtf8(byteString);
                this.patternCase_ = 5;
                this.pattern_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setGet(String str) {
            if (str != null) {
                this.patternCase_ = 2;
                this.pattern_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setGetBytes(ByteString byteString) {
            if (byteString != null) {
                HttpRule.checkByteStringIsUtf8(byteString);
                this.patternCase_ = 2;
                this.pattern_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setPatch(String str) {
            if (str != null) {
                this.patternCase_ = 6;
                this.pattern_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setPatchBytes(ByteString byteString) {
            if (byteString != null) {
                HttpRule.checkByteStringIsUtf8(byteString);
                this.patternCase_ = 6;
                this.pattern_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setPost(String str) {
            if (str != null) {
                this.patternCase_ = 4;
                this.pattern_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setPostBytes(ByteString byteString) {
            if (byteString != null) {
                HttpRule.checkByteStringIsUtf8(byteString);
                this.patternCase_ = 4;
                this.pattern_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setPut(String str) {
            if (str != null) {
                this.patternCase_ = 3;
                this.pattern_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setPutBytes(ByteString byteString) {
            if (byteString != null) {
                HttpRule.checkByteStringIsUtf8(byteString);
                this.patternCase_ = 3;
                this.pattern_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setResponseBody(String str) {
            if (str != null) {
                this.responseBody_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setResponseBodyBytes(ByteString byteString) {
            if (byteString != null) {
                HttpRule.checkByteStringIsUtf8(byteString);
                this.responseBody_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setSelector(String str) {
            if (str != null) {
                this.selector_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setSelectorBytes(ByteString byteString) {
            if (byteString != null) {
                HttpRule.checkByteStringIsUtf8(byteString);
                this.selector_ = byteString;
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

    /* loaded from: source-8110460-dex2jar.jar:com/google/api/HttpRule$PatternCase.class */
    public enum PatternCase implements Internal.EnumLite {
        GET(2),
        PUT(3),
        POST(4),
        DELETE(5),
        PATCH(6),
        CUSTOM(8),
        PATTERN_NOT_SET(0);
        
        private final int value;

        PatternCase(int i) {
            this.value = i;
        }

        public static PatternCase forNumber(int i) {
            if (i != 0) {
                if (i != 8) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                if (i != 5) {
                                    if (i != 6) {
                                        return null;
                                    }
                                    return PATCH;
                                }
                                return DELETE;
                            }
                            return POST;
                        }
                        return PUT;
                    }
                    return GET;
                }
                return CUSTOM;
            }
            return PATTERN_NOT_SET;
        }

        @Deprecated
        public static PatternCase valueOf(int i) {
            return forNumber(i);
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public int getNumber() {
            return this.value;
        }
    }

    private HttpRule() {
        this.patternCase_ = 0;
        this.memoizedIsInitialized = (byte) -1;
        this.selector_ = "";
        this.body_ = "";
        this.responseBody_ = "";
        this.additionalBindings_ = Collections.emptyList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private HttpRule(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        CustomHttpPattern.Builder builder;
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
                        case 10:
                            this.selector_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 18:
                            String readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                            boolean z4 = z2;
                            this.patternCase_ = 2;
                            boolean z5 = z2;
                            this.pattern_ = readStringRequireUtf8;
                            continue;
                        case 26:
                            String readStringRequireUtf82 = codedInputStream.readStringRequireUtf8();
                            boolean z6 = z2;
                            this.patternCase_ = 3;
                            boolean z7 = z2;
                            this.pattern_ = readStringRequireUtf82;
                            continue;
                        case 34:
                            String readStringRequireUtf83 = codedInputStream.readStringRequireUtf8();
                            boolean z8 = z2;
                            this.patternCase_ = 4;
                            boolean z9 = z2;
                            this.pattern_ = readStringRequireUtf83;
                            continue;
                        case 42:
                            String readStringRequireUtf84 = codedInputStream.readStringRequireUtf8();
                            boolean z10 = z2;
                            this.patternCase_ = 5;
                            boolean z11 = z2;
                            this.pattern_ = readStringRequireUtf84;
                            continue;
                        case 50:
                            String readStringRequireUtf85 = codedInputStream.readStringRequireUtf8();
                            boolean z12 = z2;
                            this.patternCase_ = 6;
                            boolean z13 = z2;
                            this.pattern_ = readStringRequireUtf85;
                            continue;
                        case 58:
                            this.body_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 66:
                            if (this.patternCase_ == 8) {
                                boolean z14 = z2;
                                builder = ((CustomHttpPattern) this.pattern_).toBuilder();
                            } else {
                                builder = null;
                            }
                            MessageLite readMessage = codedInputStream.readMessage(CustomHttpPattern.parser(), extensionRegistryLite);
                            boolean z15 = z2;
                            this.pattern_ = readMessage;
                            if (builder != null) {
                                builder.mergeFrom((CustomHttpPattern) readMessage);
                                boolean z16 = z2;
                                this.pattern_ = builder.buildPartial();
                            }
                            boolean z17 = z2;
                            this.patternCase_ = 8;
                            continue;
                        case 90:
                            boolean z18 = z2;
                            if (!(z2 & true)) {
                                this.additionalBindings_ = new ArrayList();
                                z18 = z2 | true;
                            }
                            this.additionalBindings_.add(codedInputStream.readMessage(parser(), extensionRegistryLite));
                            z2 = z18;
                            continue;
                        case 98:
                            this.responseBody_ = codedInputStream.readStringRequireUtf8();
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
                    this.additionalBindings_ = Collections.unmodifiableList(this.additionalBindings_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                throw th;
            }
        }
        if (z2 & true) {
            this.additionalBindings_ = Collections.unmodifiableList(this.additionalBindings_);
        }
        this.unknownFields = newBuilder.build();
        makeExtensionsImmutable();
    }

    private HttpRule(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.patternCase_ = 0;
        this.memoizedIsInitialized = (byte) -1;
    }

    public static HttpRule getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return HttpProto.internal_static_google_api_HttpRule_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(HttpRule httpRule) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(httpRule);
    }

    public static HttpRule parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (HttpRule) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static HttpRule parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HttpRule) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static HttpRule parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static HttpRule parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static HttpRule parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (HttpRule) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static HttpRule parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HttpRule) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static HttpRule parseFrom(InputStream inputStream) throws IOException {
        return (HttpRule) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static HttpRule parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HttpRule) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static HttpRule parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static HttpRule parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static HttpRule parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static HttpRule parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<HttpRule> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof HttpRule) {
            HttpRule httpRule = (HttpRule) obj;
            if (getSelector().equals(httpRule.getSelector()) && getBody().equals(httpRule.getBody()) && getResponseBody().equals(httpRule.getResponseBody()) && getAdditionalBindingsList().equals(httpRule.getAdditionalBindingsList()) && getPatternCase().equals(httpRule.getPatternCase())) {
                int i = this.patternCase_;
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                if (i != 6) {
                                    if (i == 8 && !getCustom().equals(httpRule.getCustom())) {
                                        return false;
                                    }
                                } else if (!getPatch().equals(httpRule.getPatch())) {
                                    return false;
                                }
                            } else if (!getDelete().equals(httpRule.getDelete())) {
                                return false;
                            }
                        } else if (!getPost().equals(httpRule.getPost())) {
                            return false;
                        }
                    } else if (!getPut().equals(httpRule.getPut())) {
                        return false;
                    }
                } else if (!getGet().equals(httpRule.getGet())) {
                    return false;
                }
                return this.unknownFields.equals(httpRule.unknownFields);
            }
            return false;
        }
        return super.equals(obj);
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public HttpRule getAdditionalBindings(int i) {
        return this.additionalBindings_.get(i);
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public int getAdditionalBindingsCount() {
        return this.additionalBindings_.size();
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public List<HttpRule> getAdditionalBindingsList() {
        return this.additionalBindings_;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public HttpRuleOrBuilder getAdditionalBindingsOrBuilder(int i) {
        return this.additionalBindings_.get(i);
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public List<? extends HttpRuleOrBuilder> getAdditionalBindingsOrBuilderList() {
        return this.additionalBindings_;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public String getBody() {
        Object obj = this.body_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.body_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public ByteString getBodyBytes() {
        Object obj = this.body_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.body_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public CustomHttpPattern getCustom() {
        return this.patternCase_ == 8 ? (CustomHttpPattern) this.pattern_ : CustomHttpPattern.getDefaultInstance();
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public CustomHttpPatternOrBuilder getCustomOrBuilder() {
        return this.patternCase_ == 8 ? (CustomHttpPattern) this.pattern_ : CustomHttpPattern.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public HttpRule getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public String getDelete() {
        String str = this.patternCase_ == 5 ? this.pattern_ : "";
        if (str instanceof String) {
            return (String) str;
        }
        String stringUtf8 = ((ByteString) str).toStringUtf8();
        if (this.patternCase_ == 5) {
            this.pattern_ = stringUtf8;
        }
        return stringUtf8;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public ByteString getDeleteBytes() {
        String str = this.patternCase_ == 5 ? this.pattern_ : "";
        if (str instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) str);
            if (this.patternCase_ == 5) {
                this.pattern_ = copyFromUtf8;
            }
            return copyFromUtf8;
        }
        return (ByteString) str;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public String getGet() {
        String str = this.patternCase_ == 2 ? this.pattern_ : "";
        if (str instanceof String) {
            return (String) str;
        }
        String stringUtf8 = ((ByteString) str).toStringUtf8();
        if (this.patternCase_ == 2) {
            this.pattern_ = stringUtf8;
        }
        return stringUtf8;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public ByteString getGetBytes() {
        String str = this.patternCase_ == 2 ? this.pattern_ : "";
        if (str instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) str);
            if (this.patternCase_ == 2) {
                this.pattern_ = copyFromUtf8;
            }
            return copyFromUtf8;
        }
        return (ByteString) str;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<HttpRule> getParserForType() {
        return PARSER;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public String getPatch() {
        String str = this.patternCase_ == 6 ? this.pattern_ : "";
        if (str instanceof String) {
            return (String) str;
        }
        String stringUtf8 = ((ByteString) str).toStringUtf8();
        if (this.patternCase_ == 6) {
            this.pattern_ = stringUtf8;
        }
        return stringUtf8;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public ByteString getPatchBytes() {
        String str = this.patternCase_ == 6 ? this.pattern_ : "";
        if (str instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) str);
            if (this.patternCase_ == 6) {
                this.pattern_ = copyFromUtf8;
            }
            return copyFromUtf8;
        }
        return (ByteString) str;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public PatternCase getPatternCase() {
        return PatternCase.forNumber(this.patternCase_);
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public String getPost() {
        String str = this.patternCase_ == 4 ? this.pattern_ : "";
        if (str instanceof String) {
            return (String) str;
        }
        String stringUtf8 = ((ByteString) str).toStringUtf8();
        if (this.patternCase_ == 4) {
            this.pattern_ = stringUtf8;
        }
        return stringUtf8;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public ByteString getPostBytes() {
        String str = this.patternCase_ == 4 ? this.pattern_ : "";
        if (str instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) str);
            if (this.patternCase_ == 4) {
                this.pattern_ = copyFromUtf8;
            }
            return copyFromUtf8;
        }
        return (ByteString) str;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public String getPut() {
        String str = this.patternCase_ == 3 ? this.pattern_ : "";
        if (str instanceof String) {
            return (String) str;
        }
        String stringUtf8 = ((ByteString) str).toStringUtf8();
        if (this.patternCase_ == 3) {
            this.pattern_ = stringUtf8;
        }
        return stringUtf8;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public ByteString getPutBytes() {
        String str = this.patternCase_ == 3 ? this.pattern_ : "";
        if (str instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) str);
            if (this.patternCase_ == 3) {
                this.pattern_ = copyFromUtf8;
            }
            return copyFromUtf8;
        }
        return (ByteString) str;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public String getResponseBody() {
        Object obj = this.responseBody_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.responseBody_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public ByteString getResponseBodyBytes() {
        Object obj = this.responseBody_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.responseBody_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public String getSelector() {
        Object obj = this.selector_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.selector_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public ByteString getSelectorBytes() {
        Object obj = this.selector_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.selector_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int computeStringSize = !getSelectorBytes().isEmpty() ? GeneratedMessageV3.computeStringSize(1, this.selector_) + 0 : 0;
        int i2 = computeStringSize;
        if (this.patternCase_ == 2) {
            i2 = computeStringSize + GeneratedMessageV3.computeStringSize(2, this.pattern_);
        }
        int i3 = i2;
        if (this.patternCase_ == 3) {
            i3 = i2 + GeneratedMessageV3.computeStringSize(3, this.pattern_);
        }
        int i4 = i3;
        if (this.patternCase_ == 4) {
            i4 = i3 + GeneratedMessageV3.computeStringSize(4, this.pattern_);
        }
        int i5 = i4;
        if (this.patternCase_ == 5) {
            i5 = i4 + GeneratedMessageV3.computeStringSize(5, this.pattern_);
        }
        int i6 = i5;
        if (this.patternCase_ == 6) {
            i6 = i5 + GeneratedMessageV3.computeStringSize(6, this.pattern_);
        }
        int i7 = i6;
        if (!getBodyBytes().isEmpty()) {
            i7 = i6 + GeneratedMessageV3.computeStringSize(7, this.body_);
        }
        int i8 = i7;
        int i9 = 0;
        if (this.patternCase_ == 8) {
            i8 = i7 + CodedOutputStream.computeMessageSize(8, (CustomHttpPattern) this.pattern_);
            i9 = 0;
        }
        while (i9 < this.additionalBindings_.size()) {
            i8 += CodedOutputStream.computeMessageSize(11, this.additionalBindings_.get(i9));
            i9++;
        }
        int i10 = i8;
        if (!getResponseBodyBytes().isEmpty()) {
            i10 = i8 + GeneratedMessageV3.computeStringSize(12, this.responseBody_);
        }
        int serializedSize = i10 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.google.api.HttpRuleOrBuilder
    public boolean hasCustom() {
        return this.patternCase_ == 8;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int i;
        int hashCode;
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode2 = ((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getSelector().hashCode()) * 37) + 7) * 53) + getBody().hashCode()) * 37) + 12) * 53) + getResponseBody().hashCode();
        int i2 = hashCode2;
        if (getAdditionalBindingsCount() > 0) {
            i2 = (((hashCode2 * 37) + 11) * 53) + getAdditionalBindingsList().hashCode();
        }
        int i3 = this.patternCase_;
        if (i3 == 2) {
            i = ((i2 * 37) + 2) * 53;
            hashCode = getGet().hashCode();
        } else if (i3 == 3) {
            i = ((i2 * 37) + 3) * 53;
            hashCode = getPut().hashCode();
        } else if (i3 == 4) {
            i = ((i2 * 37) + 4) * 53;
            hashCode = getPost().hashCode();
        } else if (i3 == 5) {
            i = ((i2 * 37) + 5) * 53;
            hashCode = getDelete().hashCode();
        } else if (i3 != 6) {
            if (i3 == 8) {
                i = ((i2 * 37) + 8) * 53;
                hashCode = getCustom().hashCode();
            }
            int hashCode3 = (i2 * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode3;
            return hashCode3;
        } else {
            i = ((i2 * 37) + 6) * 53;
            hashCode = getPatch().hashCode();
        }
        i2 = i + hashCode;
        int hashCode32 = (i2 * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode32;
        return hashCode32;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return HttpProto.internal_static_google_api_HttpRule_fieldAccessorTable.ensureFieldAccessorsInitialized(HttpRule.class, Builder.class);
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

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!getSelectorBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.selector_);
        }
        if (this.patternCase_ == 2) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.pattern_);
        }
        if (this.patternCase_ == 3) {
            GeneratedMessageV3.writeString(codedOutputStream, 3, this.pattern_);
        }
        if (this.patternCase_ == 4) {
            GeneratedMessageV3.writeString(codedOutputStream, 4, this.pattern_);
        }
        if (this.patternCase_ == 5) {
            GeneratedMessageV3.writeString(codedOutputStream, 5, this.pattern_);
        }
        if (this.patternCase_ == 6) {
            GeneratedMessageV3.writeString(codedOutputStream, 6, this.pattern_);
        }
        if (!getBodyBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 7, this.body_);
        }
        if (this.patternCase_ == 8) {
            codedOutputStream.writeMessage(8, (CustomHttpPattern) this.pattern_);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.additionalBindings_.size()) {
                break;
            }
            codedOutputStream.writeMessage(11, this.additionalBindings_.get(i2));
            i = i2 + 1;
        }
        if (!getResponseBodyBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 12, this.responseBody_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
