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
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveActivity.class */
public final class LiveActivity extends GeneratedMessageV3 implements LiveActivityOrBuilder {
    public static final int ACTIVITY_FIELD_NUMBER = 1;
    private static final LiveActivity DEFAULT_INSTANCE = new LiveActivity();
    private static final Parser<LiveActivity> PARSER = new AbstractParser<LiveActivity>() { // from class: cn.irisgw.live.LiveActivity.1
        /* renamed from: parsePartialFrom */
        public LiveActivity m4328parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new LiveActivity(codedInputStream, extensionRegistryLite);
        }
    };
    private static final long serialVersionUID = 0;
    private List<Activity> activity_;
    private byte memoizedIsInitialized;

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveActivity$Activity.class */
    public static final class Activity extends GeneratedMessageV3 implements ActivityOrBuilder {
        public static final int DISPLAY_URLS_FIELD_NUMBER = 8;
        public static final int ICON_FIELD_NUMBER = 3;
        public static final int ID_FIELD_NUMBER = 1;
        public static final int LIST_FIELD_NUMBER = 7;
        public static final int PAGE_FIELD_NUMBER = 5;
        public static final int RANK_FIELD_NUMBER = 2;
        public static final int TITLE_FIELD_NUMBER = 6;
        public static final int URL_FIELD_NUMBER = 4;
        private static final long serialVersionUID = 0;
        private List<DisplayUrl> displayUrls_;
        private volatile Object icon_;
        private long id_;
        private LazyStringList list_;
        private byte memoizedIsInitialized;
        private int page_;
        private long rank_;
        private volatile Object title_;
        private volatile Object url_;
        private static final Activity DEFAULT_INSTANCE = new Activity();
        private static final Parser<Activity> PARSER = new AbstractParser<Activity>() { // from class: cn.irisgw.live.LiveActivity.Activity.1
            /* renamed from: parsePartialFrom */
            public Activity m4338parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Activity(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveActivity$Activity$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ActivityOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<DisplayUrl, DisplayUrl.Builder, DisplayUrlOrBuilder> displayUrlsBuilder_;
            private List<DisplayUrl> displayUrls_;
            private Object icon_;
            private long id_;
            private LazyStringList list_;
            private int page_;
            private long rank_;
            private Object title_;
            private Object url_;

            private Builder() {
                this.icon_ = "";
                this.url_ = "";
                this.page_ = 0;
                this.title_ = "";
                this.list_ = LazyStringArrayList.EMPTY;
                this.displayUrls_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.icon_ = "";
                this.url_ = "";
                this.page_ = 0;
                this.title_ = "";
                this.list_ = LazyStringArrayList.EMPTY;
                this.displayUrls_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void ensureDisplayUrlsIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.displayUrls_ = new ArrayList(this.displayUrls_);
                    this.bitField0_ |= 2;
                }
            }

            private void ensureListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.list_ = new LazyStringArrayList(this.list_);
                    this.bitField0_ |= 1;
                }
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LiveConstants.internal_static_cn_irisgw_live_LiveActivity_Activity_descriptor;
            }

            private RepeatedFieldBuilderV3<DisplayUrl, DisplayUrl.Builder, DisplayUrlOrBuilder> getDisplayUrlsFieldBuilder() {
                if (this.displayUrlsBuilder_ == null) {
                    this.displayUrlsBuilder_ = new RepeatedFieldBuilderV3<>(this.displayUrls_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.displayUrls_ = null;
                }
                return this.displayUrlsBuilder_;
            }

            private void maybeForceBuilderInitialization() {
                if (Activity.alwaysUseFieldBuilders) {
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
                AbstractMessageLite.Builder.addAll(iterable, this.displayUrls_);
                onChanged();
                return this;
            }

            public Builder addAllList(Iterable<String> iterable) {
                ensureListIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.list_);
                onChanged();
                return this;
            }

            public Builder addDisplayUrls(int i, DisplayUrl.Builder builder) {
                RepeatedFieldBuilderV3<DisplayUrl, DisplayUrl.Builder, DisplayUrlOrBuilder> repeatedFieldBuilderV3 = this.displayUrlsBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(i, builder.m4427build());
                    return this;
                }
                ensureDisplayUrlsIsMutable();
                this.displayUrls_.add(i, builder.m4427build());
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
                    repeatedFieldBuilderV3.addMessage(builder.m4427build());
                    return this;
                }
                ensureDisplayUrlsIsMutable();
                this.displayUrls_.add(builder.m4427build());
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

            public Builder addList(String str) {
                if (str != null) {
                    ensureListIsMutable();
                    this.list_.add(str);
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder addListBytes(ByteString byteString) {
                if (byteString != null) {
                    Activity.checkByteStringIsUtf8(byteString);
                    ensureListIsMutable();
                    this.list_.add(byteString);
                    onChanged();
                    return this;
                }
                throw null;
            }

            /* renamed from: addRepeatedField */
            public Builder m4340addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: build */
            public Activity m4342build() {
                Activity m4344buildPartial = m4344buildPartial();
                if (m4344buildPartial.isInitialized()) {
                    return m4344buildPartial;
                }
                throw newUninitializedMessageException(m4344buildPartial);
            }

            /* renamed from: buildPartial */
            public Activity m4344buildPartial() {
                Activity activity = new Activity(this);
                activity.id_ = this.id_;
                activity.rank_ = this.rank_;
                activity.icon_ = this.icon_;
                activity.url_ = this.url_;
                activity.page_ = this.page_;
                activity.title_ = this.title_;
                if ((this.bitField0_ & 1) != 0) {
                    this.list_ = this.list_.getUnmodifiableView();
                    this.bitField0_ &= -2;
                }
                activity.list_ = this.list_;
                RepeatedFieldBuilderV3<DisplayUrl, DisplayUrl.Builder, DisplayUrlOrBuilder> repeatedFieldBuilderV3 = this.displayUrlsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.displayUrls_ = Collections.unmodifiableList(this.displayUrls_);
                        this.bitField0_ &= -3;
                    }
                    activity.displayUrls_ = this.displayUrls_;
                } else {
                    activity.displayUrls_ = repeatedFieldBuilderV3.build();
                }
                onBuilt();
                return activity;
            }

            /* renamed from: clear */
            public Builder m4348clear() {
                super.clear();
                this.id_ = Activity.serialVersionUID;
                this.rank_ = Activity.serialVersionUID;
                this.icon_ = "";
                this.url_ = "";
                this.page_ = 0;
                this.title_ = "";
                this.list_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -2;
                RepeatedFieldBuilderV3<DisplayUrl, DisplayUrl.Builder, DisplayUrlOrBuilder> repeatedFieldBuilderV3 = this.displayUrlsBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.clear();
                    return this;
                }
                this.displayUrls_ = Collections.emptyList();
                this.bitField0_ &= -3;
                return this;
            }

            public Builder clearDisplayUrls() {
                RepeatedFieldBuilderV3<DisplayUrl, DisplayUrl.Builder, DisplayUrlOrBuilder> repeatedFieldBuilderV3 = this.displayUrlsBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.clear();
                    return this;
                }
                this.displayUrls_ = Collections.emptyList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            /* renamed from: clearField */
            public Builder m4350clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearIcon() {
                this.icon_ = Activity.getDefaultInstance().getIcon();
                onChanged();
                return this;
            }

            public Builder clearId() {
                this.id_ = Activity.serialVersionUID;
                onChanged();
                return this;
            }

            public Builder clearList() {
                this.list_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            /* renamed from: clearOneof */
            public Builder m4353clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearPage() {
                this.page_ = 0;
                onChanged();
                return this;
            }

            public Builder clearRank() {
                this.rank_ = Activity.serialVersionUID;
                onChanged();
                return this;
            }

            public Builder clearTitle() {
                this.title_ = Activity.getDefaultInstance().getTitle();
                onChanged();
                return this;
            }

            public Builder clearUrl() {
                this.url_ = Activity.getDefaultInstance().getUrl();
                onChanged();
                return this;
            }

            /* renamed from: clone */
            public Builder m4359clone() {
                return (Builder) super.clone();
            }

            /* renamed from: getDefaultInstanceForType */
            public Activity m4361getDefaultInstanceForType() {
                return Activity.getDefaultInstance();
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return LiveConstants.internal_static_cn_irisgw_live_LiveActivity_Activity_descriptor;
            }

            @Override // cn.irisgw.live.LiveActivity.ActivityOrBuilder
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

            @Override // cn.irisgw.live.LiveActivity.ActivityOrBuilder
            public int getDisplayUrlsCount() {
                RepeatedFieldBuilderV3<DisplayUrl, DisplayUrl.Builder, DisplayUrlOrBuilder> repeatedFieldBuilderV3 = this.displayUrlsBuilder_;
                return repeatedFieldBuilderV3 == null ? this.displayUrls_.size() : repeatedFieldBuilderV3.getCount();
            }

            @Override // cn.irisgw.live.LiveActivity.ActivityOrBuilder
            public List<DisplayUrl> getDisplayUrlsList() {
                RepeatedFieldBuilderV3<DisplayUrl, DisplayUrl.Builder, DisplayUrlOrBuilder> repeatedFieldBuilderV3 = this.displayUrlsBuilder_;
                return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.displayUrls_) : repeatedFieldBuilderV3.getMessageList();
            }

            @Override // cn.irisgw.live.LiveActivity.ActivityOrBuilder
            public DisplayUrlOrBuilder getDisplayUrlsOrBuilder(int i) {
                RepeatedFieldBuilderV3<DisplayUrl, DisplayUrl.Builder, DisplayUrlOrBuilder> repeatedFieldBuilderV3 = this.displayUrlsBuilder_;
                return repeatedFieldBuilderV3 == null ? this.displayUrls_.get(i) : (DisplayUrlOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // cn.irisgw.live.LiveActivity.ActivityOrBuilder
            public List<? extends DisplayUrlOrBuilder> getDisplayUrlsOrBuilderList() {
                RepeatedFieldBuilderV3<DisplayUrl, DisplayUrl.Builder, DisplayUrlOrBuilder> repeatedFieldBuilderV3 = this.displayUrlsBuilder_;
                return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.displayUrls_);
            }

            @Override // cn.irisgw.live.LiveActivity.ActivityOrBuilder
            public String getIcon() {
                Object obj = this.icon_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.icon_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.LiveActivity.ActivityOrBuilder
            public ByteString getIconBytes() {
                Object obj = this.icon_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.icon_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.LiveActivity.ActivityOrBuilder
            public long getId() {
                return this.id_;
            }

            @Override // cn.irisgw.live.LiveActivity.ActivityOrBuilder
            public String getList(int i) {
                return (String) this.list_.get(i);
            }

            @Override // cn.irisgw.live.LiveActivity.ActivityOrBuilder
            public ByteString getListBytes(int i) {
                return this.list_.getByteString(i);
            }

            @Override // cn.irisgw.live.LiveActivity.ActivityOrBuilder
            public int getListCount() {
                return this.list_.size();
            }

            @Override // cn.irisgw.live.LiveActivity.ActivityOrBuilder
            /* renamed from: getListList */
            public ProtocolStringList mo4332getListList() {
                return this.list_.getUnmodifiableView();
            }

            @Override // cn.irisgw.live.LiveActivity.ActivityOrBuilder
            public Page getPage() {
                Page valueOf = Page.valueOf(this.page_);
                Page page = valueOf;
                if (valueOf == null) {
                    page = Page.UNRECOGNIZED;
                }
                return page;
            }

            @Override // cn.irisgw.live.LiveActivity.ActivityOrBuilder
            public int getPageValue() {
                return this.page_;
            }

            @Override // cn.irisgw.live.LiveActivity.ActivityOrBuilder
            public long getRank() {
                return this.rank_;
            }

            @Override // cn.irisgw.live.LiveActivity.ActivityOrBuilder
            public String getTitle() {
                Object obj = this.title_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.title_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.LiveActivity.ActivityOrBuilder
            public ByteString getTitleBytes() {
                Object obj = this.title_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.title_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.LiveActivity.ActivityOrBuilder
            public String getUrl() {
                Object obj = this.url_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.url_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.LiveActivity.ActivityOrBuilder
            public ByteString getUrlBytes() {
                Object obj = this.url_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.url_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveConstants.internal_static_cn_irisgw_live_LiveActivity_Activity_fieldAccessorTable.ensureFieldAccessorsInitialized(Activity.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(Activity activity) {
                if (activity == Activity.getDefaultInstance()) {
                    return this;
                }
                if (activity.getId() != Activity.serialVersionUID) {
                    setId(activity.getId());
                }
                if (activity.getRank() != Activity.serialVersionUID) {
                    setRank(activity.getRank());
                }
                if (!activity.getIcon().isEmpty()) {
                    this.icon_ = activity.icon_;
                    onChanged();
                }
                if (!activity.getUrl().isEmpty()) {
                    this.url_ = activity.url_;
                    onChanged();
                }
                if (activity.page_ != 0) {
                    setPageValue(activity.getPageValue());
                }
                if (!activity.getTitle().isEmpty()) {
                    this.title_ = activity.title_;
                    onChanged();
                }
                if (!activity.list_.isEmpty()) {
                    if (this.list_.isEmpty()) {
                        this.list_ = activity.list_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureListIsMutable();
                        this.list_.addAll(activity.list_);
                    }
                    onChanged();
                }
                if (this.displayUrlsBuilder_ == null) {
                    if (!activity.displayUrls_.isEmpty()) {
                        if (this.displayUrls_.isEmpty()) {
                            this.displayUrls_ = activity.displayUrls_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureDisplayUrlsIsMutable();
                            this.displayUrls_.addAll(activity.displayUrls_);
                        }
                        onChanged();
                    }
                } else if (!activity.displayUrls_.isEmpty()) {
                    if (this.displayUrlsBuilder_.isEmpty()) {
                        this.displayUrlsBuilder_.dispose();
                        RepeatedFieldBuilderV3<DisplayUrl, DisplayUrl.Builder, DisplayUrlOrBuilder> repeatedFieldBuilderV3 = null;
                        this.displayUrlsBuilder_ = null;
                        this.displayUrls_ = activity.displayUrls_;
                        this.bitField0_ &= -3;
                        if (Activity.alwaysUseFieldBuilders) {
                            repeatedFieldBuilderV3 = getDisplayUrlsFieldBuilder();
                        }
                        this.displayUrlsBuilder_ = repeatedFieldBuilderV3;
                    } else {
                        this.displayUrlsBuilder_.addAllMessages(activity.displayUrls_);
                    }
                }
                m4370mergeUnknownFields(activity.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            /* renamed from: mergeFrom */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.LiveActivity.Activity.Builder m4367mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.LiveActivity.Activity.access$2500()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.LiveActivity$Activity r0 = (cn.irisgw.live.LiveActivity.Activity) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.LiveActivity$Activity$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.LiveActivity$Activity r0 = (cn.irisgw.live.LiveActivity.Activity) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.LiveActivity$Activity$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.LiveActivity.Activity.Builder.m4367mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.LiveActivity$Activity$Builder");
            }

            /* renamed from: mergeFrom */
            public Builder m4366mergeFrom(Message message) {
                if (message instanceof Activity) {
                    return mergeFrom((Activity) message);
                }
                super.mergeFrom(message);
                return this;
            }

            /* renamed from: mergeUnknownFields */
            public final Builder m4370mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
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
                    repeatedFieldBuilderV3.setMessage(i, builder.m4427build());
                    return this;
                }
                ensureDisplayUrlsIsMutable();
                this.displayUrls_.set(i, builder.m4427build());
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

            /* renamed from: setField */
            public Builder m4372setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
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
                    Activity.checkByteStringIsUtf8(byteString);
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

            public Builder setList(int i, String str) {
                if (str != null) {
                    ensureListIsMutable();
                    this.list_.set(i, str);
                    onChanged();
                    return this;
                }
                throw null;
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

            public Builder setRank(long j) {
                this.rank_ = j;
                onChanged();
                return this;
            }

            /* renamed from: setRepeatedField */
            public Builder m4374setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
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
                    Activity.checkByteStringIsUtf8(byteString);
                    this.title_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            /* renamed from: setUnknownFields */
            public final Builder m4376setUnknownFields(UnknownFieldSet unknownFieldSet) {
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
                    Activity.checkByteStringIsUtf8(byteString);
                    this.url_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }
        }

        private Activity() {
            this.memoizedIsInitialized = (byte) -1;
            this.icon_ = "";
            this.url_ = "";
            this.page_ = 0;
            this.title_ = "";
            this.list_ = LazyStringArrayList.EMPTY;
            this.displayUrls_ = Collections.emptyList();
        }

        private Activity(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.rank_ = codedInputStream.readInt64();
                            } else if (readTag == 26) {
                                this.icon_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 34) {
                                this.url_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 40) {
                                this.page_ = codedInputStream.readEnum();
                            } else if (readTag == 50) {
                                this.title_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 58) {
                                String readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                boolean z4 = z2;
                                if (!(z2 & true)) {
                                    this.list_ = new LazyStringArrayList();
                                    z4 = z2 | true;
                                }
                                this.list_.add(readStringRequireUtf8);
                                z2 = z4;
                            } else if (readTag == 66) {
                                boolean z5 = z2;
                                if (!(z2 & true)) {
                                    this.displayUrls_ = new ArrayList();
                                    z5 = z2 | true;
                                }
                                this.displayUrls_.add((DisplayUrl) codedInputStream.readMessage(DisplayUrl.parser(), extensionRegistryLite));
                                z2 = z5;
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
                        this.list_ = this.list_.getUnmodifiableView();
                    }
                    if (z3 & true) {
                        this.displayUrls_ = Collections.unmodifiableList(this.displayUrls_);
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 & true) {
                this.list_ = this.list_.getUnmodifiableView();
            }
            if (z2 & true) {
                this.displayUrls_ = Collections.unmodifiableList(this.displayUrls_);
            }
            this.unknownFields = newBuilder.build();
            makeExtensionsImmutable();
        }

        private Activity(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Activity getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_LiveActivity_Activity_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m4337toBuilder();
        }

        public static Builder newBuilder(Activity activity) {
            return DEFAULT_INSTANCE.m4337toBuilder().mergeFrom(activity);
        }

        public static Activity parseDelimitedFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Activity parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Activity parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Activity) PARSER.parseFrom(byteString);
        }

        public static Activity parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Activity) PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Activity parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Activity parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static Activity parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Activity parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Activity parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Activity) PARSER.parseFrom(byteBuffer);
        }

        public static Activity parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Activity) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Activity parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Activity) PARSER.parseFrom(bArr);
        }

        public static Activity parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Activity) PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<Activity> parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Activity) {
                Activity activity = (Activity) obj;
                return getId() == activity.getId() && getRank() == activity.getRank() && getIcon().equals(activity.getIcon()) && getUrl().equals(activity.getUrl()) && this.page_ == activity.page_ && getTitle().equals(activity.getTitle()) && mo4332getListList().equals(activity.mo4332getListList()) && getDisplayUrlsList().equals(activity.getDisplayUrlsList()) && this.unknownFields.equals(activity.unknownFields);
            }
            return super.equals(obj);
        }

        /* renamed from: getDefaultInstanceForType */
        public Activity m4331getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // cn.irisgw.live.LiveActivity.ActivityOrBuilder
        public DisplayUrl getDisplayUrls(int i) {
            return this.displayUrls_.get(i);
        }

        @Override // cn.irisgw.live.LiveActivity.ActivityOrBuilder
        public int getDisplayUrlsCount() {
            return this.displayUrls_.size();
        }

        @Override // cn.irisgw.live.LiveActivity.ActivityOrBuilder
        public List<DisplayUrl> getDisplayUrlsList() {
            return this.displayUrls_;
        }

        @Override // cn.irisgw.live.LiveActivity.ActivityOrBuilder
        public DisplayUrlOrBuilder getDisplayUrlsOrBuilder(int i) {
            return this.displayUrls_.get(i);
        }

        @Override // cn.irisgw.live.LiveActivity.ActivityOrBuilder
        public List<? extends DisplayUrlOrBuilder> getDisplayUrlsOrBuilderList() {
            return this.displayUrls_;
        }

        @Override // cn.irisgw.live.LiveActivity.ActivityOrBuilder
        public String getIcon() {
            Object obj = this.icon_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.icon_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LiveActivity.ActivityOrBuilder
        public ByteString getIconBytes() {
            Object obj = this.icon_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.icon_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.LiveActivity.ActivityOrBuilder
        public long getId() {
            return this.id_;
        }

        @Override // cn.irisgw.live.LiveActivity.ActivityOrBuilder
        public String getList(int i) {
            return (String) this.list_.get(i);
        }

        @Override // cn.irisgw.live.LiveActivity.ActivityOrBuilder
        public ByteString getListBytes(int i) {
            return this.list_.getByteString(i);
        }

        @Override // cn.irisgw.live.LiveActivity.ActivityOrBuilder
        public int getListCount() {
            return this.list_.size();
        }

        @Override // cn.irisgw.live.LiveActivity.ActivityOrBuilder
        /* renamed from: getListList */
        public ProtocolStringList mo4332getListList() {
            return this.list_;
        }

        @Override // cn.irisgw.live.LiveActivity.ActivityOrBuilder
        public Page getPage() {
            Page valueOf = Page.valueOf(this.page_);
            Page page = valueOf;
            if (valueOf == null) {
                page = Page.UNRECOGNIZED;
            }
            return page;
        }

        @Override // cn.irisgw.live.LiveActivity.ActivityOrBuilder
        public int getPageValue() {
            return this.page_;
        }

        public Parser<Activity> getParserForType() {
            return PARSER;
        }

        @Override // cn.irisgw.live.LiveActivity.ActivityOrBuilder
        public long getRank() {
            return this.rank_;
        }

        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            long j = this.id_;
            int computeInt64Size = j != serialVersionUID ? CodedOutputStream.computeInt64Size(1, j) + 0 : 0;
            long j2 = this.rank_;
            int i2 = computeInt64Size;
            if (j2 != serialVersionUID) {
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
            if (this.page_ != Page.Full.getNumber()) {
                i5 = i4 + CodedOutputStream.computeEnumSize(5, this.page_);
            }
            int i6 = i5;
            if (!getTitleBytes().isEmpty()) {
                i6 = i5 + GeneratedMessageV3.computeStringSize(6, this.title_);
            }
            int i7 = 0;
            for (int i8 = 0; i8 < this.list_.size(); i8++) {
                i7 += computeStringSizeNoTag(this.list_.getRaw(i8));
            }
            int size = i6 + i7 + (mo4332getListList().size() * 1);
            int i9 = 0;
            while (true) {
                int i10 = i9;
                if (i10 >= this.displayUrls_.size()) {
                    int serializedSize = size + this.unknownFields.getSerializedSize();
                    this.memoizedSize = serializedSize;
                    return serializedSize;
                }
                size += CodedOutputStream.computeMessageSize(8, this.displayUrls_.get(i10));
                i9 = i10 + 1;
            }
        }

        @Override // cn.irisgw.live.LiveActivity.ActivityOrBuilder
        public String getTitle() {
            Object obj = this.title_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.title_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LiveActivity.ActivityOrBuilder
        public ByteString getTitleBytes() {
            Object obj = this.title_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.title_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // cn.irisgw.live.LiveActivity.ActivityOrBuilder
        public String getUrl() {
            Object obj = this.url_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.url_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LiveActivity.ActivityOrBuilder
        public ByteString getUrlBytes() {
            Object obj = this.url_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.url_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(getId())) * 37) + 2) * 53) + Internal.hashLong(getRank())) * 37) + 3) * 53) + getIcon().hashCode()) * 37) + 4) * 53) + getUrl().hashCode()) * 37) + 5) * 53) + this.page_) * 37) + 6) * 53) + getTitle().hashCode();
            int i = hashCode;
            if (getListCount() > 0) {
                i = (((hashCode * 37) + 7) * 53) + mo4332getListList().hashCode();
            }
            int i2 = i;
            if (getDisplayUrlsCount() > 0) {
                i2 = (((i * 37) + 8) * 53) + getDisplayUrlsList().hashCode();
            }
            int hashCode2 = (i2 * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_LiveActivity_Activity_fieldAccessorTable.ensureFieldAccessorsInitialized(Activity.class, Builder.class);
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
        public Builder m4335newBuilderForType() {
            return newBuilder();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: newBuilderForType */
        public Builder m4334newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new Activity();
        }

        /* renamed from: toBuilder */
        public Builder m4337toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i;
            long j = this.id_;
            if (j != serialVersionUID) {
                codedOutputStream.writeInt64(1, j);
            }
            long j2 = this.rank_;
            if (j2 != serialVersionUID) {
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
            if (!getTitleBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 6, this.title_);
            }
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.list_.size()) {
                    break;
                }
                GeneratedMessageV3.writeString(codedOutputStream, 7, this.list_.getRaw(i3));
                i2 = i3 + 1;
            }
            for (i = 0; i < this.displayUrls_.size(); i++) {
                codedOutputStream.writeMessage(8, this.displayUrls_.get(i));
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveActivity$ActivityOrBuilder.class */
    public interface ActivityOrBuilder extends MessageOrBuilder {
        DisplayUrl getDisplayUrls(int i);

        int getDisplayUrlsCount();

        List<DisplayUrl> getDisplayUrlsList();

        DisplayUrlOrBuilder getDisplayUrlsOrBuilder(int i);

        List<? extends DisplayUrlOrBuilder> getDisplayUrlsOrBuilderList();

        String getIcon();

        ByteString getIconBytes();

        long getId();

        String getList(int i);

        ByteString getListBytes(int i);

        int getListCount();

        /* renamed from: getListList */
        List<String> mo4332getListList();

        Page getPage();

        int getPageValue();

        long getRank();

        String getTitle();

        ByteString getTitleBytes();

        String getUrl();

        ByteString getUrlBytes();
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveActivity$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LiveActivityOrBuilder {
        private RepeatedFieldBuilderV3<Activity, Activity.Builder, ActivityOrBuilder> activityBuilder_;
        private List<Activity> activity_;
        private int bitField0_;

        private Builder() {
            this.activity_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.activity_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private void ensureActivityIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.activity_ = new ArrayList(this.activity_);
                this.bitField0_ |= 1;
            }
        }

        private RepeatedFieldBuilderV3<Activity, Activity.Builder, ActivityOrBuilder> getActivityFieldBuilder() {
            if (this.activityBuilder_ == null) {
                List<Activity> list = this.activity_;
                boolean z = true;
                if ((this.bitField0_ & 1) == 0) {
                    z = false;
                }
                this.activityBuilder_ = new RepeatedFieldBuilderV3<>(list, z, getParentForChildren(), isClean());
                this.activity_ = null;
            }
            return this.activityBuilder_;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_LiveActivity_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            if (LiveActivity.alwaysUseFieldBuilders) {
                getActivityFieldBuilder();
            }
        }

        public Builder addActivity(int i, Activity.Builder builder) {
            RepeatedFieldBuilderV3<Activity, Activity.Builder, ActivityOrBuilder> repeatedFieldBuilderV3 = this.activityBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.m4342build());
                return this;
            }
            ensureActivityIsMutable();
            this.activity_.add(i, builder.m4342build());
            onChanged();
            return this;
        }

        public Builder addActivity(int i, Activity activity) {
            RepeatedFieldBuilderV3<Activity, Activity.Builder, ActivityOrBuilder> repeatedFieldBuilderV3 = this.activityBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, activity);
                return this;
            } else if (activity != null) {
                ensureActivityIsMutable();
                this.activity_.add(i, activity);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addActivity(Activity.Builder builder) {
            RepeatedFieldBuilderV3<Activity, Activity.Builder, ActivityOrBuilder> repeatedFieldBuilderV3 = this.activityBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(builder.m4342build());
                return this;
            }
            ensureActivityIsMutable();
            this.activity_.add(builder.m4342build());
            onChanged();
            return this;
        }

        public Builder addActivity(Activity activity) {
            RepeatedFieldBuilderV3<Activity, Activity.Builder, ActivityOrBuilder> repeatedFieldBuilderV3 = this.activityBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(activity);
                return this;
            } else if (activity != null) {
                ensureActivityIsMutable();
                this.activity_.add(activity);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Activity.Builder addActivityBuilder() {
            return getActivityFieldBuilder().addBuilder(Activity.getDefaultInstance());
        }

        public Activity.Builder addActivityBuilder(int i) {
            return getActivityFieldBuilder().addBuilder(i, Activity.getDefaultInstance());
        }

        public Builder addAllActivity(Iterable<? extends Activity> iterable) {
            RepeatedFieldBuilderV3<Activity, Activity.Builder, ActivityOrBuilder> repeatedFieldBuilderV3 = this.activityBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensureActivityIsMutable();
            AbstractMessageLite.Builder.addAll(iterable, this.activity_);
            onChanged();
            return this;
        }

        /* renamed from: addRepeatedField */
        public Builder m4378addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public LiveActivity m4380build() {
            LiveActivity m4382buildPartial = m4382buildPartial();
            if (m4382buildPartial.isInitialized()) {
                return m4382buildPartial;
            }
            throw newUninitializedMessageException(m4382buildPartial);
        }

        /* renamed from: buildPartial */
        public LiveActivity m4382buildPartial() {
            LiveActivity liveActivity = new LiveActivity(this);
            int i = this.bitField0_;
            RepeatedFieldBuilderV3<Activity, Activity.Builder, ActivityOrBuilder> repeatedFieldBuilderV3 = this.activityBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((i & 1) != 0) {
                    this.activity_ = Collections.unmodifiableList(this.activity_);
                    this.bitField0_ &= -2;
                }
                liveActivity.activity_ = this.activity_;
            } else {
                liveActivity.activity_ = repeatedFieldBuilderV3.build();
            }
            onBuilt();
            return liveActivity;
        }

        /* renamed from: clear */
        public Builder m4386clear() {
            super.clear();
            RepeatedFieldBuilderV3<Activity, Activity.Builder, ActivityOrBuilder> repeatedFieldBuilderV3 = this.activityBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.activity_ = Collections.emptyList();
            this.bitField0_ &= -2;
            return this;
        }

        public Builder clearActivity() {
            RepeatedFieldBuilderV3<Activity, Activity.Builder, ActivityOrBuilder> repeatedFieldBuilderV3 = this.activityBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.activity_ = Collections.emptyList();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        /* renamed from: clearField */
        public Builder m4388clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        /* renamed from: clearOneof */
        public Builder m4391clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        /* renamed from: clone */
        public Builder m4397clone() {
            return (Builder) super.clone();
        }

        @Override // cn.irisgw.live.LiveActivityOrBuilder
        public Activity getActivity(int i) {
            RepeatedFieldBuilderV3<Activity, Activity.Builder, ActivityOrBuilder> repeatedFieldBuilderV3 = this.activityBuilder_;
            return repeatedFieldBuilderV3 == null ? this.activity_.get(i) : repeatedFieldBuilderV3.getMessage(i);
        }

        public Activity.Builder getActivityBuilder(int i) {
            return getActivityFieldBuilder().getBuilder(i);
        }

        public List<Activity.Builder> getActivityBuilderList() {
            return getActivityFieldBuilder().getBuilderList();
        }

        @Override // cn.irisgw.live.LiveActivityOrBuilder
        public int getActivityCount() {
            RepeatedFieldBuilderV3<Activity, Activity.Builder, ActivityOrBuilder> repeatedFieldBuilderV3 = this.activityBuilder_;
            return repeatedFieldBuilderV3 == null ? this.activity_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // cn.irisgw.live.LiveActivityOrBuilder
        public List<Activity> getActivityList() {
            RepeatedFieldBuilderV3<Activity, Activity.Builder, ActivityOrBuilder> repeatedFieldBuilderV3 = this.activityBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.activity_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // cn.irisgw.live.LiveActivityOrBuilder
        public ActivityOrBuilder getActivityOrBuilder(int i) {
            RepeatedFieldBuilderV3<Activity, Activity.Builder, ActivityOrBuilder> repeatedFieldBuilderV3 = this.activityBuilder_;
            return repeatedFieldBuilderV3 == null ? this.activity_.get(i) : (ActivityOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // cn.irisgw.live.LiveActivityOrBuilder
        public List<? extends ActivityOrBuilder> getActivityOrBuilderList() {
            RepeatedFieldBuilderV3<Activity, Activity.Builder, ActivityOrBuilder> repeatedFieldBuilderV3 = this.activityBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.activity_);
        }

        /* renamed from: getDefaultInstanceForType */
        public LiveActivity m4399getDefaultInstanceForType() {
            return LiveActivity.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_LiveActivity_descriptor;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_LiveActivity_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveActivity.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(LiveActivity liveActivity) {
            if (liveActivity == LiveActivity.getDefaultInstance()) {
                return this;
            }
            if (this.activityBuilder_ == null) {
                if (!liveActivity.activity_.isEmpty()) {
                    if (this.activity_.isEmpty()) {
                        this.activity_ = liveActivity.activity_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureActivityIsMutable();
                        this.activity_.addAll(liveActivity.activity_);
                    }
                    onChanged();
                }
            } else if (!liveActivity.activity_.isEmpty()) {
                if (this.activityBuilder_.isEmpty()) {
                    this.activityBuilder_.dispose();
                    RepeatedFieldBuilderV3<Activity, Activity.Builder, ActivityOrBuilder> repeatedFieldBuilderV3 = null;
                    this.activityBuilder_ = null;
                    this.activity_ = liveActivity.activity_;
                    this.bitField0_ &= -2;
                    if (LiveActivity.alwaysUseFieldBuilders) {
                        repeatedFieldBuilderV3 = getActivityFieldBuilder();
                    }
                    this.activityBuilder_ = repeatedFieldBuilderV3;
                } else {
                    this.activityBuilder_.addAllMessages(liveActivity.activity_);
                }
            }
            m4408mergeUnknownFields(liveActivity.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.LiveActivity.Builder m4405mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.LiveActivity.access$3800()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.LiveActivity r0 = (cn.irisgw.live.LiveActivity) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.LiveActivity$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.LiveActivity r0 = (cn.irisgw.live.LiveActivity) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.LiveActivity$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.LiveActivity.Builder.m4405mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.LiveActivity$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m4404mergeFrom(Message message) {
            if (message instanceof LiveActivity) {
                return mergeFrom((LiveActivity) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m4408mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder removeActivity(int i) {
            RepeatedFieldBuilderV3<Activity, Activity.Builder, ActivityOrBuilder> repeatedFieldBuilderV3 = this.activityBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.remove(i);
                return this;
            }
            ensureActivityIsMutable();
            this.activity_.remove(i);
            onChanged();
            return this;
        }

        public Builder setActivity(int i, Activity.Builder builder) {
            RepeatedFieldBuilderV3<Activity, Activity.Builder, ActivityOrBuilder> repeatedFieldBuilderV3 = this.activityBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.m4342build());
                return this;
            }
            ensureActivityIsMutable();
            this.activity_.set(i, builder.m4342build());
            onChanged();
            return this;
        }

        public Builder setActivity(int i, Activity activity) {
            RepeatedFieldBuilderV3<Activity, Activity.Builder, ActivityOrBuilder> repeatedFieldBuilderV3 = this.activityBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, activity);
                return this;
            } else if (activity != null) {
                ensureActivityIsMutable();
                this.activity_.set(i, activity);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        /* renamed from: setField */
        public Builder m4410setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        /* renamed from: setRepeatedField */
        public Builder m4412setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        /* renamed from: setUnknownFields */
        public final Builder m4414setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveActivity$DisplayUrl.class */
    public static final class DisplayUrl extends GeneratedMessageV3 implements DisplayUrlOrBuilder {
        public static final int DATA_FIELD_NUMBER = 2;
        private static final DisplayUrl DEFAULT_INSTANCE = new DisplayUrl();
        private static final Parser<DisplayUrl> PARSER = new AbstractParser<DisplayUrl>() { // from class: cn.irisgw.live.LiveActivity.DisplayUrl.1
            /* renamed from: parsePartialFrom */
            public DisplayUrl m4423parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new DisplayUrl(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int URL_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private volatile Object data_;
        private byte memoizedIsInitialized;
        private volatile Object url_;

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveActivity$DisplayUrl$Builder.class */
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
                return LiveConstants.internal_static_cn_irisgw_live_LiveActivity_DisplayUrl_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = DisplayUrl.alwaysUseFieldBuilders;
            }

            /* renamed from: addRepeatedField */
            public Builder m4425addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: build */
            public DisplayUrl m4427build() {
                DisplayUrl m4429buildPartial = m4429buildPartial();
                if (m4429buildPartial.isInitialized()) {
                    return m4429buildPartial;
                }
                throw newUninitializedMessageException(m4429buildPartial);
            }

            /* renamed from: buildPartial */
            public DisplayUrl m4429buildPartial() {
                DisplayUrl displayUrl = new DisplayUrl(this);
                displayUrl.url_ = this.url_;
                displayUrl.data_ = this.data_;
                onBuilt();
                return displayUrl;
            }

            /* renamed from: clear */
            public Builder m4433clear() {
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

            /* renamed from: clearField */
            public Builder m4435clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            /* renamed from: clearOneof */
            public Builder m4438clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearUrl() {
                this.url_ = DisplayUrl.getDefaultInstance().getUrl();
                onChanged();
                return this;
            }

            /* renamed from: clone */
            public Builder m4444clone() {
                return (Builder) super.clone();
            }

            @Override // cn.irisgw.live.LiveActivity.DisplayUrlOrBuilder
            public String getData() {
                Object obj = this.data_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.data_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.LiveActivity.DisplayUrlOrBuilder
            public ByteString getDataBytes() {
                Object obj = this.data_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.data_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            /* renamed from: getDefaultInstanceForType */
            public DisplayUrl m4446getDefaultInstanceForType() {
                return DisplayUrl.getDefaultInstance();
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return LiveConstants.internal_static_cn_irisgw_live_LiveActivity_DisplayUrl_descriptor;
            }

            @Override // cn.irisgw.live.LiveActivity.DisplayUrlOrBuilder
            public String getUrl() {
                Object obj = this.url_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.url_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.LiveActivity.DisplayUrlOrBuilder
            public ByteString getUrlBytes() {
                Object obj = this.url_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.url_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveConstants.internal_static_cn_irisgw_live_LiveActivity_DisplayUrl_fieldAccessorTable.ensureFieldAccessorsInitialized(DisplayUrl.class, Builder.class);
            }

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
                m4455mergeUnknownFields(displayUrl.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            /* renamed from: mergeFrom */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.LiveActivity.DisplayUrl.Builder m4452mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.LiveActivity.DisplayUrl.access$700()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.LiveActivity$DisplayUrl r0 = (cn.irisgw.live.LiveActivity.DisplayUrl) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.LiveActivity$DisplayUrl$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.LiveActivity$DisplayUrl r0 = (cn.irisgw.live.LiveActivity.DisplayUrl) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.LiveActivity$DisplayUrl$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.LiveActivity.DisplayUrl.Builder.m4452mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.LiveActivity$DisplayUrl$Builder");
            }

            /* renamed from: mergeFrom */
            public Builder m4451mergeFrom(Message message) {
                if (message instanceof DisplayUrl) {
                    return mergeFrom((DisplayUrl) message);
                }
                super.mergeFrom(message);
                return this;
            }

            /* renamed from: mergeUnknownFields */
            public final Builder m4455mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
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

            /* renamed from: setField */
            public Builder m4457setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            /* renamed from: setRepeatedField */
            public Builder m4459setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            /* renamed from: setUnknownFields */
            public final Builder m4461setUnknownFields(UnknownFieldSet unknownFieldSet) {
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
            return LiveConstants.internal_static_cn_irisgw_live_LiveActivity_DisplayUrl_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m4422toBuilder();
        }

        public static Builder newBuilder(DisplayUrl displayUrl) {
            return DEFAULT_INSTANCE.m4422toBuilder().mergeFrom(displayUrl);
        }

        public static DisplayUrl parseDelimitedFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static DisplayUrl parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static DisplayUrl parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (DisplayUrl) PARSER.parseFrom(byteString);
        }

        public static DisplayUrl parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DisplayUrl) PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static DisplayUrl parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static DisplayUrl parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static DisplayUrl parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static DisplayUrl parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static DisplayUrl parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (DisplayUrl) PARSER.parseFrom(byteBuffer);
        }

        public static DisplayUrl parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DisplayUrl) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static DisplayUrl parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (DisplayUrl) PARSER.parseFrom(bArr);
        }

        public static DisplayUrl parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (DisplayUrl) PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<DisplayUrl> parser() {
            return PARSER;
        }

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

        @Override // cn.irisgw.live.LiveActivity.DisplayUrlOrBuilder
        public String getData() {
            Object obj = this.data_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.data_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LiveActivity.DisplayUrlOrBuilder
        public ByteString getDataBytes() {
            Object obj = this.data_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.data_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        /* renamed from: getDefaultInstanceForType */
        public DisplayUrl m4417getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        public Parser<DisplayUrl> getParserForType() {
            return PARSER;
        }

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

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // cn.irisgw.live.LiveActivity.DisplayUrlOrBuilder
        public String getUrl() {
            Object obj = this.url_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.url_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LiveActivity.DisplayUrlOrBuilder
        public ByteString getUrlBytes() {
            Object obj = this.url_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.url_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getUrl().hashCode()) * 37) + 2) * 53) + getData().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_LiveActivity_DisplayUrl_fieldAccessorTable.ensureFieldAccessorsInitialized(DisplayUrl.class, Builder.class);
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
        public Builder m4420newBuilderForType() {
            return newBuilder();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: newBuilderForType */
        public Builder m4419newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new DisplayUrl();
        }

        /* renamed from: toBuilder */
        public Builder m4422toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

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

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveActivity$DisplayUrlOrBuilder.class */
    public interface DisplayUrlOrBuilder extends MessageOrBuilder {
        String getData();

        ByteString getDataBytes();

        String getUrl();

        ByteString getUrlBytes();
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveActivity$Page.class */
    public enum Page implements ProtocolMessageEnum {
        Full(0),
        Half(1),
        UNRECOGNIZED(-1);
        
        public static final int Full_VALUE = 0;
        public static final int Half_VALUE = 1;
        private final int value;
        private static final Internal.EnumLiteMap<Page> internalValueMap = new Internal.EnumLiteMap<Page>() { // from class: cn.irisgw.live.LiveActivity.Page.1
            /* renamed from: findValueByNumber */
            public Page m4463findValueByNumber(int i) {
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
            return (Descriptors.EnumDescriptor) LiveActivity.getDescriptor().getEnumTypes().get(0);
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

        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this != UNRECOGNIZED) {
                return (Descriptors.EnumValueDescriptor) getDescriptor().getValues().get(ordinal());
            }
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }
    }

    private LiveActivity() {
        this.memoizedIsInitialized = (byte) -1;
        this.activity_ = Collections.emptyList();
    }

    private LiveActivity(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.activity_ = new ArrayList();
                                z4 = z2 | true;
                            }
                            this.activity_.add((Activity) codedInputStream.readMessage(Activity.parser(), extensionRegistryLite));
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
                    this.activity_ = Collections.unmodifiableList(this.activity_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                throw th;
            }
        }
        if (z2 & true) {
            this.activity_ = Collections.unmodifiableList(this.activity_);
        }
        this.unknownFields = newBuilder.build();
        makeExtensionsImmutable();
    }

    private LiveActivity(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static LiveActivity getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_LiveActivity_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m4327toBuilder();
    }

    public static Builder newBuilder(LiveActivity liveActivity) {
        return DEFAULT_INSTANCE.m4327toBuilder().mergeFrom(liveActivity);
    }

    public static LiveActivity parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static LiveActivity parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LiveActivity parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (LiveActivity) PARSER.parseFrom(byteString);
    }

    public static LiveActivity parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LiveActivity) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static LiveActivity parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static LiveActivity parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static LiveActivity parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static LiveActivity parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LiveActivity parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (LiveActivity) PARSER.parseFrom(byteBuffer);
    }

    public static LiveActivity parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LiveActivity) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static LiveActivity parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (LiveActivity) PARSER.parseFrom(bArr);
    }

    public static LiveActivity parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LiveActivity) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<LiveActivity> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LiveActivity) {
            LiveActivity liveActivity = (LiveActivity) obj;
            return getActivityList().equals(liveActivity.getActivityList()) && this.unknownFields.equals(liveActivity.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.LiveActivityOrBuilder
    public Activity getActivity(int i) {
        return this.activity_.get(i);
    }

    @Override // cn.irisgw.live.LiveActivityOrBuilder
    public int getActivityCount() {
        return this.activity_.size();
    }

    @Override // cn.irisgw.live.LiveActivityOrBuilder
    public List<Activity> getActivityList() {
        return this.activity_;
    }

    @Override // cn.irisgw.live.LiveActivityOrBuilder
    public ActivityOrBuilder getActivityOrBuilder(int i) {
        return this.activity_.get(i);
    }

    @Override // cn.irisgw.live.LiveActivityOrBuilder
    public List<? extends ActivityOrBuilder> getActivityOrBuilderList() {
        return this.activity_;
    }

    /* renamed from: getDefaultInstanceForType */
    public LiveActivity m4322getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public Parser<LiveActivity> getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.activity_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(1, this.activity_.get(i3));
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
        if (getActivityCount() > 0) {
            i = (((hashCode * 37) + 1) * 53) + getActivityList().hashCode();
        }
        int hashCode2 = (i * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_LiveActivity_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveActivity.class, Builder.class);
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
    public Builder m4325newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m4324newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new LiveActivity();
    }

    /* renamed from: toBuilder */
    public Builder m4327toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.activity_.size()) {
                this.unknownFields.writeTo(codedOutputStream);
                return;
            } else {
                codedOutputStream.writeMessage(1, this.activity_.get(i2));
                i = i2 + 1;
            }
        }
    }
}
