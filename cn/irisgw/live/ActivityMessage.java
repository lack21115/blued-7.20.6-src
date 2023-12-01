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
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ActivityMessage.class */
public final class ActivityMessage extends GeneratedMessageV3 implements ActivityMessageOrBuilder {
    public static final int DISPLAY_URLS_FIELD_NUMBER = 6;
    public static final int ICON_FIELD_NUMBER = 3;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int PAGE_FIELD_NUMBER = 5;
    public static final int SORT_FIELD_NUMBER = 2;
    public static final int STATUS_FIELD_NUMBER = 7;
    public static final int URL_FIELD_NUMBER = 4;
    private static final long serialVersionUID = 0;
    private List<DisplayUrl> displayUrls_;
    private volatile Object icon_;
    private long id_;
    private byte memoizedIsInitialized;
    private int page_;
    private long sort_;
    private int status_;
    private volatile Object url_;
    private static final ActivityMessage DEFAULT_INSTANCE = new ActivityMessage();
    private static final Parser<ActivityMessage> PARSER = new AbstractParser<ActivityMessage>() { // from class: cn.irisgw.live.ActivityMessage.1
        @Override // com.google.protobuf.Parser
        public ActivityMessage parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new ActivityMessage(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ActivityMessage$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ActivityMessageOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilderV3<DisplayUrl, DisplayUrl.Builder, DisplayUrlOrBuilder> displayUrlsBuilder_;
        private List<DisplayUrl> displayUrls_;
        private Object icon_;
        private long id_;
        private int page_;
        private long sort_;
        private int status_;
        private Object url_;

        private Builder() {
            this.icon_ = "";
            this.url_ = "";
            this.page_ = 0;
            this.displayUrls_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.icon_ = "";
            this.url_ = "";
            this.page_ = 0;
            this.displayUrls_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private void ensureDisplayUrlsIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.displayUrls_ = new ArrayList(this.displayUrls_);
                this.bitField0_ |= 1;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_ActivityMessage_descriptor;
        }

        private RepeatedFieldBuilderV3<DisplayUrl, DisplayUrl.Builder, DisplayUrlOrBuilder> getDisplayUrlsFieldBuilder() {
            if (this.displayUrlsBuilder_ == null) {
                List<DisplayUrl> list = this.displayUrls_;
                boolean z = true;
                if ((this.bitField0_ & 1) == 0) {
                    z = false;
                }
                this.displayUrlsBuilder_ = new RepeatedFieldBuilderV3<>(list, z, getParentForChildren(), isClean());
                this.displayUrls_ = null;
            }
            return this.displayUrlsBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (ActivityMessage.alwaysUseFieldBuilders) {
                getDisplayUrlsFieldBuilder();
            }
        }

        public Builder addAllDisplayUrls(Iterable<? extends DisplayUrl> iterable) {
            RepeatedFieldBuilderV3<DisplayUrl, DisplayUrl.Builder, DisplayUrlOrBuilder> repeatedFieldBuilderV3 = this.displayUrlsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensureDisplayUrlsIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.displayUrls_);
            onChanged();
            return this;
        }

        public Builder addDisplayUrls(int i, DisplayUrl.Builder builder) {
            RepeatedFieldBuilderV3<DisplayUrl, DisplayUrl.Builder, DisplayUrlOrBuilder> repeatedFieldBuilderV3 = this.displayUrlsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.build());
                return this;
            }
            ensureDisplayUrlsIsMutable();
            this.displayUrls_.add(i, builder.build());
            onChanged();
            return this;
        }

        public Builder addDisplayUrls(int i, DisplayUrl displayUrl) {
            RepeatedFieldBuilderV3<DisplayUrl, DisplayUrl.Builder, DisplayUrlOrBuilder> repeatedFieldBuilderV3 = this.displayUrlsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, displayUrl);
                return this;
            } else if (displayUrl != null) {
                ensureDisplayUrlsIsMutable();
                this.displayUrls_.add(i, displayUrl);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addDisplayUrls(DisplayUrl.Builder builder) {
            RepeatedFieldBuilderV3<DisplayUrl, DisplayUrl.Builder, DisplayUrlOrBuilder> repeatedFieldBuilderV3 = this.displayUrlsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(builder.build());
                return this;
            }
            ensureDisplayUrlsIsMutable();
            this.displayUrls_.add(builder.build());
            onChanged();
            return this;
        }

        public Builder addDisplayUrls(DisplayUrl displayUrl) {
            RepeatedFieldBuilderV3<DisplayUrl, DisplayUrl.Builder, DisplayUrlOrBuilder> repeatedFieldBuilderV3 = this.displayUrlsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(displayUrl);
                return this;
            } else if (displayUrl != null) {
                ensureDisplayUrlsIsMutable();
                this.displayUrls_.add(displayUrl);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public DisplayUrl.Builder addDisplayUrlsBuilder() {
            return getDisplayUrlsFieldBuilder().addBuilder(DisplayUrl.getDefaultInstance());
        }

        public DisplayUrl.Builder addDisplayUrlsBuilder(int i) {
            return getDisplayUrlsFieldBuilder().addBuilder(i, DisplayUrl.getDefaultInstance());
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ActivityMessage build() {
            ActivityMessage buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ActivityMessage buildPartial() {
            ActivityMessage activityMessage = new ActivityMessage(this);
            activityMessage.id_ = this.id_;
            activityMessage.sort_ = this.sort_;
            activityMessage.icon_ = this.icon_;
            activityMessage.url_ = this.url_;
            activityMessage.page_ = this.page_;
            RepeatedFieldBuilderV3<DisplayUrl, DisplayUrl.Builder, DisplayUrlOrBuilder> repeatedFieldBuilderV3 = this.displayUrlsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.displayUrls_ = Collections.unmodifiableList(this.displayUrls_);
                    this.bitField0_ &= -2;
                }
                activityMessage.displayUrls_ = this.displayUrls_;
            } else {
                activityMessage.displayUrls_ = repeatedFieldBuilderV3.build();
            }
            activityMessage.status_ = this.status_;
            onBuilt();
            return activityMessage;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.id_ = 0L;
            this.sort_ = 0L;
            this.icon_ = "";
            this.url_ = "";
            this.page_ = 0;
            RepeatedFieldBuilderV3<DisplayUrl, DisplayUrl.Builder, DisplayUrlOrBuilder> repeatedFieldBuilderV3 = this.displayUrlsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.displayUrls_ = Collections.emptyList();
                this.bitField0_ &= -2;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            this.status_ = 0;
            return this;
        }

        public Builder clearDisplayUrls() {
            RepeatedFieldBuilderV3<DisplayUrl, DisplayUrl.Builder, DisplayUrlOrBuilder> repeatedFieldBuilderV3 = this.displayUrlsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.displayUrls_ = Collections.emptyList();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearIcon() {
            this.icon_ = ActivityMessage.getDefaultInstance().getIcon();
            onChanged();
            return this;
        }

        public Builder clearId() {
            this.id_ = 0L;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearPage() {
            this.page_ = 0;
            onChanged();
            return this;
        }

        public Builder clearSort() {
            this.sort_ = 0L;
            onChanged();
            return this;
        }

        public Builder clearStatus() {
            this.status_ = 0;
            onChanged();
            return this;
        }

        public Builder clearUrl() {
            this.url_ = ActivityMessage.getDefaultInstance().getUrl();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo1800clone() {
            return (Builder) super.mo1800clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ActivityMessage getDefaultInstanceForType() {
            return ActivityMessage.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_ActivityMessage_descriptor;
        }

        @Override // cn.irisgw.live.ActivityMessageOrBuilder
        public DisplayUrl getDisplayUrls(int i) {
            RepeatedFieldBuilderV3<DisplayUrl, DisplayUrl.Builder, DisplayUrlOrBuilder> repeatedFieldBuilderV3 = this.displayUrlsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.displayUrls_.get(i) : repeatedFieldBuilderV3.getMessage(i);
        }

        public DisplayUrl.Builder getDisplayUrlsBuilder(int i) {
            return getDisplayUrlsFieldBuilder().getBuilder(i);
        }

        public List<DisplayUrl.Builder> getDisplayUrlsBuilderList() {
            return getDisplayUrlsFieldBuilder().getBuilderList();
        }

        @Override // cn.irisgw.live.ActivityMessageOrBuilder
        public int getDisplayUrlsCount() {
            RepeatedFieldBuilderV3<DisplayUrl, DisplayUrl.Builder, DisplayUrlOrBuilder> repeatedFieldBuilderV3 = this.displayUrlsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.displayUrls_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // cn.irisgw.live.ActivityMessageOrBuilder
        public List<DisplayUrl> getDisplayUrlsList() {
            RepeatedFieldBuilderV3<DisplayUrl, DisplayUrl.Builder, DisplayUrlOrBuilder> repeatedFieldBuilderV3 = this.displayUrlsBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.displayUrls_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // cn.irisgw.live.ActivityMessageOrBuilder
        public DisplayUrlOrBuilder getDisplayUrlsOrBuilder(int i) {
            RepeatedFieldBuilderV3<DisplayUrl, DisplayUrl.Builder, DisplayUrlOrBuilder> repeatedFieldBuilderV3 = this.displayUrlsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.displayUrls_.get(i) : repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // cn.irisgw.live.ActivityMessageOrBuilder
        public List<? extends DisplayUrlOrBuilder> getDisplayUrlsOrBuilderList() {
            RepeatedFieldBuilderV3<DisplayUrl, DisplayUrl.Builder, DisplayUrlOrBuilder> repeatedFieldBuilderV3 = this.displayUrlsBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.displayUrls_);
        }

        @Override // cn.irisgw.live.ActivityMessageOrBuilder
        public String getIcon() {
            Object obj = this.icon_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.icon_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.ActivityMessageOrBuilder
        public ByteString getIconBytes() {
            Object obj = this.icon_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.icon_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.ActivityMessageOrBuilder
        public long getId() {
            return this.id_;
        }

        @Override // cn.irisgw.live.ActivityMessageOrBuilder
        public Page getPage() {
            Page valueOf = Page.valueOf(this.page_);
            Page page = valueOf;
            if (valueOf == null) {
                page = Page.UNRECOGNIZED;
            }
            return page;
        }

        @Override // cn.irisgw.live.ActivityMessageOrBuilder
        public int getPageValue() {
            return this.page_;
        }

        @Override // cn.irisgw.live.ActivityMessageOrBuilder
        public long getSort() {
            return this.sort_;
        }

        @Override // cn.irisgw.live.ActivityMessageOrBuilder
        public int getStatus() {
            return this.status_;
        }

        @Override // cn.irisgw.live.ActivityMessageOrBuilder
        public String getUrl() {
            Object obj = this.url_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.url_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.ActivityMessageOrBuilder
        public ByteString getUrlBytes() {
            Object obj = this.url_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.url_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_ActivityMessage_fieldAccessorTable.ensureFieldAccessorsInitialized(ActivityMessage.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(ActivityMessage activityMessage) {
            if (activityMessage == ActivityMessage.getDefaultInstance()) {
                return this;
            }
            if (activityMessage.getId() != 0) {
                setId(activityMessage.getId());
            }
            if (activityMessage.getSort() != 0) {
                setSort(activityMessage.getSort());
            }
            if (!activityMessage.getIcon().isEmpty()) {
                this.icon_ = activityMessage.icon_;
                onChanged();
            }
            if (!activityMessage.getUrl().isEmpty()) {
                this.url_ = activityMessage.url_;
                onChanged();
            }
            if (activityMessage.page_ != 0) {
                setPageValue(activityMessage.getPageValue());
            }
            if (this.displayUrlsBuilder_ == null) {
                if (!activityMessage.displayUrls_.isEmpty()) {
                    if (this.displayUrls_.isEmpty()) {
                        this.displayUrls_ = activityMessage.displayUrls_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureDisplayUrlsIsMutable();
                        this.displayUrls_.addAll(activityMessage.displayUrls_);
                    }
                    onChanged();
                }
            } else if (!activityMessage.displayUrls_.isEmpty()) {
                if (this.displayUrlsBuilder_.isEmpty()) {
                    this.displayUrlsBuilder_.dispose();
                    RepeatedFieldBuilderV3<DisplayUrl, DisplayUrl.Builder, DisplayUrlOrBuilder> repeatedFieldBuilderV3 = null;
                    this.displayUrlsBuilder_ = null;
                    this.displayUrls_ = activityMessage.displayUrls_;
                    this.bitField0_ &= -2;
                    if (ActivityMessage.alwaysUseFieldBuilders) {
                        repeatedFieldBuilderV3 = getDisplayUrlsFieldBuilder();
                    }
                    this.displayUrlsBuilder_ = repeatedFieldBuilderV3;
                } else {
                    this.displayUrlsBuilder_.addAllMessages(activityMessage.displayUrls_);
                }
            }
            if (activityMessage.getStatus() != 0) {
                setStatus(activityMessage.getStatus());
            }
            mergeUnknownFields(activityMessage.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.ActivityMessage.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.ActivityMessage.access$2400()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.ActivityMessage r0 = (cn.irisgw.live.ActivityMessage) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.ActivityMessage$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.ActivityMessage r0 = (cn.irisgw.live.ActivityMessage) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.ActivityMessage$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.ActivityMessage.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.ActivityMessage$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof ActivityMessage) {
                return mergeFrom((ActivityMessage) message);
            }
            super.mergeFrom(message);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder removeDisplayUrls(int i) {
            RepeatedFieldBuilderV3<DisplayUrl, DisplayUrl.Builder, DisplayUrlOrBuilder> repeatedFieldBuilderV3 = this.displayUrlsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.remove(i);
                return this;
            }
            ensureDisplayUrlsIsMutable();
            this.displayUrls_.remove(i);
            onChanged();
            return this;
        }

        public Builder setDisplayUrls(int i, DisplayUrl.Builder builder) {
            RepeatedFieldBuilderV3<DisplayUrl, DisplayUrl.Builder, DisplayUrlOrBuilder> repeatedFieldBuilderV3 = this.displayUrlsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.build());
                return this;
            }
            ensureDisplayUrlsIsMutable();
            this.displayUrls_.set(i, builder.build());
            onChanged();
            return this;
        }

        public Builder setDisplayUrls(int i, DisplayUrl displayUrl) {
            RepeatedFieldBuilderV3<DisplayUrl, DisplayUrl.Builder, DisplayUrlOrBuilder> repeatedFieldBuilderV3 = this.displayUrlsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, displayUrl);
                return this;
            } else if (displayUrl != null) {
                ensureDisplayUrlsIsMutable();
                this.displayUrls_.set(i, displayUrl);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setIcon(String str) {
            if (str != null) {
                this.icon_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setIconBytes(ByteString byteString) {
            if (byteString != null) {
                ActivityMessage.checkByteStringIsUtf8(byteString);
                this.icon_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setId(long j) {
            this.id_ = j;
            onChanged();
            return this;
        }

        public Builder setPage(Page page) {
            if (page != null) {
                this.page_ = page.getNumber();
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setPageValue(int i) {
            this.page_ = i;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setSort(long j) {
            this.sort_ = j;
            onChanged();
            return this;
        }

        public Builder setStatus(int i) {
            this.status_ = i;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }

        public Builder setUrl(String str) {
            if (str != null) {
                this.url_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setUrlBytes(ByteString byteString) {
            if (byteString != null) {
                ActivityMessage.checkByteStringIsUtf8(byteString);
                this.url_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ActivityMessage$DisplayUrl.class */
    public static final class DisplayUrl extends GeneratedMessageV3 implements DisplayUrlOrBuilder {
        public static final int DATA_FIELD_NUMBER = 2;
        private static final DisplayUrl DEFAULT_INSTANCE = new DisplayUrl();
        private static final Parser<DisplayUrl> PARSER = new AbstractParser<DisplayUrl>() { // from class: cn.irisgw.live.ActivityMessage.DisplayUrl.1
            @Override // com.google.protobuf.Parser
            public DisplayUrl parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new DisplayUrl(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int URL_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private volatile Object data_;
        private byte memoizedIsInitialized;
        private volatile Object url_;

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ActivityMessage$DisplayUrl$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DisplayUrlOrBuilder {
            private Object data_;
            private Object url_;

            private Builder() {
                this.url_ = "";
                this.data_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.url_ = "";
                this.data_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LiveConstants.internal_static_cn_irisgw_live_ActivityMessage_DisplayUrl_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = DisplayUrl.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DisplayUrl build() {
                DisplayUrl buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DisplayUrl buildPartial() {
                DisplayUrl displayUrl = new DisplayUrl(this);
                displayUrl.url_ = this.url_;
                displayUrl.data_ = this.data_;
                onBuilt();
                return displayUrl;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.url_ = "";
                this.data_ = "";
                return this;
            }

            public Builder clearData() {
                this.data_ = DisplayUrl.getDefaultInstance().getData();
                onChanged();
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

            public Builder clearUrl() {
                this.url_ = DisplayUrl.getDefaultInstance().getUrl();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1800clone() {
                return (Builder) super.mo1800clone();
            }

            @Override // cn.irisgw.live.ActivityMessage.DisplayUrlOrBuilder
            public String getData() {
                Object obj = this.data_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.data_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.ActivityMessage.DisplayUrlOrBuilder
            public ByteString getDataBytes() {
                Object obj = this.data_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.data_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public DisplayUrl getDefaultInstanceForType() {
                return DisplayUrl.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return LiveConstants.internal_static_cn_irisgw_live_ActivityMessage_DisplayUrl_descriptor;
            }

            @Override // cn.irisgw.live.ActivityMessage.DisplayUrlOrBuilder
            public String getUrl() {
                Object obj = this.url_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.url_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.ActivityMessage.DisplayUrlOrBuilder
            public ByteString getUrlBytes() {
                Object obj = this.url_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.url_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveConstants.internal_static_cn_irisgw_live_ActivityMessage_DisplayUrl_fieldAccessorTable.ensureFieldAccessorsInitialized(DisplayUrl.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(DisplayUrl displayUrl) {
                if (displayUrl == DisplayUrl.getDefaultInstance()) {
                    return this;
                }
                if (!displayUrl.getUrl().isEmpty()) {
                    this.url_ = displayUrl.url_;
                    onChanged();
                }
                if (!displayUrl.getData().isEmpty()) {
                    this.data_ = displayUrl.data_;
                    onChanged();
                }
                mergeUnknownFields(displayUrl.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.ActivityMessage.DisplayUrl.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.ActivityMessage.DisplayUrl.access$700()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.ActivityMessage$DisplayUrl r0 = (cn.irisgw.live.ActivityMessage.DisplayUrl) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.ActivityMessage$DisplayUrl$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.ActivityMessage$DisplayUrl r0 = (cn.irisgw.live.ActivityMessage.DisplayUrl) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.ActivityMessage$DisplayUrl$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.ActivityMessage.DisplayUrl.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.ActivityMessage$DisplayUrl$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof DisplayUrl) {
                    return mergeFrom((DisplayUrl) message);
                }
                super.mergeFrom(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder setData(String str) {
                if (str != null) {
                    this.data_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setDataBytes(ByteString byteString) {
                if (byteString != null) {
                    DisplayUrl.checkByteStringIsUtf8(byteString);
                    this.data_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            public Builder setUrl(String str) {
                if (str != null) {
                    this.url_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setUrlBytes(ByteString byteString) {
                if (byteString != null) {
                    DisplayUrl.checkByteStringIsUtf8(byteString);
                    this.url_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }
        }

        private DisplayUrl() {
            this.memoizedIsInitialized = (byte) -1;
            this.url_ = "";
            this.data_ = "";
        }

        private DisplayUrl(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.url_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 18) {
                                    this.data_ = codedInputStream.readStringRequireUtf8();
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

        private DisplayUrl(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static DisplayUrl getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_ActivityMessage_DisplayUrl_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DisplayUrl displayUrl) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(displayUrl);
        }

        public static DisplayUrl parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (DisplayUrl) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static DisplayUrl parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DisplayUrl) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static DisplayUrl parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static DisplayUrl parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static DisplayUrl parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (DisplayUrl) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static DisplayUrl parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DisplayUrl) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static DisplayUrl parseFrom(InputStream inputStream) throws IOException {
            return (DisplayUrl) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static DisplayUrl parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (DisplayUrl) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static DisplayUrl parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static DisplayUrl parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static DisplayUrl parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static DisplayUrl parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<DisplayUrl> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof DisplayUrl) {
                DisplayUrl displayUrl = (DisplayUrl) obj;
                return getUrl().equals(displayUrl.getUrl()) && getData().equals(displayUrl.getData()) && this.unknownFields.equals(displayUrl.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // cn.irisgw.live.ActivityMessage.DisplayUrlOrBuilder
        public String getData() {
            Object obj = this.data_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.data_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.ActivityMessage.DisplayUrlOrBuilder
        public ByteString getDataBytes() {
            Object obj = this.data_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.data_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public DisplayUrl getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<DisplayUrl> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (!getUrlBytes().isEmpty()) {
                i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.url_);
            }
            int i3 = i2;
            if (!getDataBytes().isEmpty()) {
                i3 = i2 + GeneratedMessageV3.computeStringSize(2, this.data_);
            }
            int serializedSize = i3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // cn.irisgw.live.ActivityMessage.DisplayUrlOrBuilder
        public String getUrl() {
            Object obj = this.url_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.url_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.ActivityMessage.DisplayUrlOrBuilder
        public ByteString getUrlBytes() {
            Object obj = this.url_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.url_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getUrl().hashCode()) * 37) + 2) * 53) + getData().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_ActivityMessage_DisplayUrl_fieldAccessorTable.ensureFieldAccessorsInitialized(DisplayUrl.class, Builder.class);
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
            return new DisplayUrl();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!getUrlBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.url_);
            }
            if (!getDataBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.data_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ActivityMessage$DisplayUrlOrBuilder.class */
    public interface DisplayUrlOrBuilder extends MessageOrBuilder {
        String getData();

        ByteString getDataBytes();

        String getUrl();

        ByteString getUrlBytes();
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ActivityMessage$Page.class */
    public enum Page implements ProtocolMessageEnum {
        Full(0),
        Half(1),
        UNRECOGNIZED(-1);
        
        public static final int Full_VALUE = 0;
        public static final int Half_VALUE = 1;
        private final int value;
        private static final Internal.EnumLiteMap<Page> internalValueMap = new Internal.EnumLiteMap<Page>() { // from class: cn.irisgw.live.ActivityMessage.Page.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public Page findValueByNumber(int i) {
                return Page.forNumber(i);
            }
        };
        private static final Page[] VALUES = values();

        Page(int i) {
            this.value = i;
        }

        public static Page forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    return null;
                }
                return Half;
            }
            return Full;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return ActivityMessage.getDescriptor().getEnumTypes().get(0);
        }

        public static Internal.EnumLiteMap<Page> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static Page valueOf(int i) {
            return forNumber(i);
        }

        public static Page valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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

    private ActivityMessage() {
        this.memoizedIsInitialized = (byte) -1;
        this.icon_ = "";
        this.url_ = "";
        this.page_ = 0;
        this.displayUrls_ = Collections.emptyList();
    }

    private ActivityMessage(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.id_ = codedInputStream.readInt64();
                        } else if (readTag == 16) {
                            this.sort_ = codedInputStream.readInt64();
                        } else if (readTag == 26) {
                            this.icon_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 34) {
                            this.url_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 40) {
                            this.page_ = codedInputStream.readEnum();
                        } else if (readTag == 50) {
                            boolean z4 = z2;
                            if (!(z2 & true)) {
                                this.displayUrls_ = new ArrayList();
                                z4 = z2 | true;
                            }
                            this.displayUrls_.add((DisplayUrl) codedInputStream.readMessage(DisplayUrl.parser(), extensionRegistryLite));
                            z2 = z4;
                        } else if (readTag == 56) {
                            this.status_ = codedInputStream.readInt32();
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
                    this.displayUrls_ = Collections.unmodifiableList(this.displayUrls_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                throw th;
            }
        }
        if (z2 & true) {
            this.displayUrls_ = Collections.unmodifiableList(this.displayUrls_);
        }
        this.unknownFields = newBuilder.build();
        makeExtensionsImmutable();
    }

    private ActivityMessage(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static ActivityMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_ActivityMessage_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ActivityMessage activityMessage) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(activityMessage);
    }

    public static ActivityMessage parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ActivityMessage) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static ActivityMessage parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ActivityMessage) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ActivityMessage parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static ActivityMessage parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static ActivityMessage parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ActivityMessage) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static ActivityMessage parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ActivityMessage) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static ActivityMessage parseFrom(InputStream inputStream) throws IOException {
        return (ActivityMessage) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static ActivityMessage parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ActivityMessage) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ActivityMessage parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static ActivityMessage parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static ActivityMessage parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static ActivityMessage parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<ActivityMessage> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ActivityMessage) {
            ActivityMessage activityMessage = (ActivityMessage) obj;
            return getId() == activityMessage.getId() && getSort() == activityMessage.getSort() && getIcon().equals(activityMessage.getIcon()) && getUrl().equals(activityMessage.getUrl()) && this.page_ == activityMessage.page_ && getDisplayUrlsList().equals(activityMessage.getDisplayUrlsList()) && getStatus() == activityMessage.getStatus() && this.unknownFields.equals(activityMessage.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public ActivityMessage getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.ActivityMessageOrBuilder
    public DisplayUrl getDisplayUrls(int i) {
        return this.displayUrls_.get(i);
    }

    @Override // cn.irisgw.live.ActivityMessageOrBuilder
    public int getDisplayUrlsCount() {
        return this.displayUrls_.size();
    }

    @Override // cn.irisgw.live.ActivityMessageOrBuilder
    public List<DisplayUrl> getDisplayUrlsList() {
        return this.displayUrls_;
    }

    @Override // cn.irisgw.live.ActivityMessageOrBuilder
    public DisplayUrlOrBuilder getDisplayUrlsOrBuilder(int i) {
        return this.displayUrls_.get(i);
    }

    @Override // cn.irisgw.live.ActivityMessageOrBuilder
    public List<? extends DisplayUrlOrBuilder> getDisplayUrlsOrBuilderList() {
        return this.displayUrls_;
    }

    @Override // cn.irisgw.live.ActivityMessageOrBuilder
    public String getIcon() {
        Object obj = this.icon_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.icon_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.ActivityMessageOrBuilder
    public ByteString getIconBytes() {
        Object obj = this.icon_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.icon_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.ActivityMessageOrBuilder
    public long getId() {
        return this.id_;
    }

    @Override // cn.irisgw.live.ActivityMessageOrBuilder
    public Page getPage() {
        Page valueOf = Page.valueOf(this.page_);
        Page page = valueOf;
        if (valueOf == null) {
            page = Page.UNRECOGNIZED;
        }
        return page;
    }

    @Override // cn.irisgw.live.ActivityMessageOrBuilder
    public int getPageValue() {
        return this.page_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<ActivityMessage> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        long j = this.id_;
        int computeInt64Size = j != 0 ? CodedOutputStream.computeInt64Size(1, j) + 0 : 0;
        long j2 = this.sort_;
        int i2 = computeInt64Size;
        if (j2 != 0) {
            i2 = computeInt64Size + CodedOutputStream.computeInt64Size(2, j2);
        }
        int i3 = i2;
        if (!getIconBytes().isEmpty()) {
            i3 = i2 + GeneratedMessageV3.computeStringSize(3, this.icon_);
        }
        int i4 = i3;
        if (!getUrlBytes().isEmpty()) {
            i4 = i3 + GeneratedMessageV3.computeStringSize(4, this.url_);
        }
        int i5 = i4;
        int i6 = 0;
        if (this.page_ != Page.Full.getNumber()) {
            i5 = i4 + CodedOutputStream.computeEnumSize(5, this.page_);
            i6 = 0;
        }
        while (i6 < this.displayUrls_.size()) {
            i5 += CodedOutputStream.computeMessageSize(6, this.displayUrls_.get(i6));
            i6++;
        }
        int i7 = this.status_;
        int i8 = i5;
        if (i7 != 0) {
            i8 = i5 + CodedOutputStream.computeInt32Size(7, i7);
        }
        int serializedSize = i8 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.ActivityMessageOrBuilder
    public long getSort() {
        return this.sort_;
    }

    @Override // cn.irisgw.live.ActivityMessageOrBuilder
    public int getStatus() {
        return this.status_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // cn.irisgw.live.ActivityMessageOrBuilder
    public String getUrl() {
        Object obj = this.url_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.url_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.ActivityMessageOrBuilder
    public ByteString getUrlBytes() {
        Object obj = this.url_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.url_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(getId())) * 37) + 2) * 53) + Internal.hashLong(getSort())) * 37) + 3) * 53) + getIcon().hashCode()) * 37) + 4) * 53) + getUrl().hashCode()) * 37) + 5) * 53) + this.page_;
        int i = hashCode;
        if (getDisplayUrlsCount() > 0) {
            i = (((hashCode * 37) + 6) * 53) + getDisplayUrlsList().hashCode();
        }
        int status = (((((i * 37) + 7) * 53) + getStatus()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = status;
        return status;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_ActivityMessage_fieldAccessorTable.ensureFieldAccessorsInitialized(ActivityMessage.class, Builder.class);
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
        return new ActivityMessage();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        long j = this.id_;
        if (j != 0) {
            codedOutputStream.writeInt64(1, j);
        }
        long j2 = this.sort_;
        if (j2 != 0) {
            codedOutputStream.writeInt64(2, j2);
        }
        if (!getIconBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 3, this.icon_);
        }
        if (!getUrlBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 4, this.url_);
        }
        if (this.page_ != Page.Full.getNumber()) {
            codedOutputStream.writeEnum(5, this.page_);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.displayUrls_.size()) {
                break;
            }
            codedOutputStream.writeMessage(6, this.displayUrls_.get(i2));
            i = i2 + 1;
        }
        int i3 = this.status_;
        if (i3 != 0) {
            codedOutputStream.writeInt32(7, i3);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
