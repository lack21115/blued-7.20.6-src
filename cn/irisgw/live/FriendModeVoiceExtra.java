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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/FriendModeVoiceExtra.class */
public final class FriendModeVoiceExtra extends GeneratedMessageV3 implements FriendModeVoiceExtraOrBuilder {
    public static final int CONFERENCE_ID_FIELD_NUMBER = 4;
    public static final int CONFERENCE_TOKEN_FIELD_NUMBER = 5;
    public static final int COUNT_FIELD_NUMBER = 1;
    public static final int FANS_FIELD_NUMBER = 7;
    public static final int INDEX_FIELD_NUMBER = 6;
    public static final int NAME_FIELD_NUMBER = 8;
    public static final int STREAM_FIELD_NUMBER = 3;
    public static final int UID_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private volatile Object conferenceId_;
    private volatile Object conferenceToken_;
    private int count_;
    private List<Fan> fans_;
    private int index_;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private volatile Object stream_;
    private int uid_;
    private static final FriendModeVoiceExtra DEFAULT_INSTANCE = new FriendModeVoiceExtra();
    private static final Parser<FriendModeVoiceExtra> PARSER = new AbstractParser<FriendModeVoiceExtra>() { // from class: cn.irisgw.live.FriendModeVoiceExtra.1
        @Override // com.google.protobuf.Parser
        public FriendModeVoiceExtra parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new FriendModeVoiceExtra(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/FriendModeVoiceExtra$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FriendModeVoiceExtraOrBuilder {
        private int bitField0_;
        private Object conferenceId_;
        private Object conferenceToken_;
        private int count_;
        private RepeatedFieldBuilderV3<Fan, Fan.Builder, FanOrBuilder> fansBuilder_;
        private List<Fan> fans_;
        private int index_;
        private Object name_;
        private Object stream_;
        private int uid_;

        private Builder() {
            this.stream_ = "";
            this.conferenceId_ = "";
            this.conferenceToken_ = "";
            this.fans_ = Collections.emptyList();
            this.name_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.stream_ = "";
            this.conferenceId_ = "";
            this.conferenceToken_ = "";
            this.fans_ = Collections.emptyList();
            this.name_ = "";
            maybeForceBuilderInitialization();
        }

        private void ensureFansIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.fans_ = new ArrayList(this.fans_);
                this.bitField0_ |= 1;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_FriendModeVoiceExtra_descriptor;
        }

        private RepeatedFieldBuilderV3<Fan, Fan.Builder, FanOrBuilder> getFansFieldBuilder() {
            if (this.fansBuilder_ == null) {
                List<Fan> list = this.fans_;
                boolean z = true;
                if ((this.bitField0_ & 1) == 0) {
                    z = false;
                }
                this.fansBuilder_ = new RepeatedFieldBuilderV3<>(list, z, getParentForChildren(), isClean());
                this.fans_ = null;
            }
            return this.fansBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (FriendModeVoiceExtra.alwaysUseFieldBuilders) {
                getFansFieldBuilder();
            }
        }

        public Builder addAllFans(Iterable<? extends Fan> iterable) {
            RepeatedFieldBuilderV3<Fan, Fan.Builder, FanOrBuilder> repeatedFieldBuilderV3 = this.fansBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensureFansIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.fans_);
            onChanged();
            return this;
        }

        public Builder addFans(int i, Fan.Builder builder) {
            RepeatedFieldBuilderV3<Fan, Fan.Builder, FanOrBuilder> repeatedFieldBuilderV3 = this.fansBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.build());
                return this;
            }
            ensureFansIsMutable();
            this.fans_.add(i, builder.build());
            onChanged();
            return this;
        }

        public Builder addFans(int i, Fan fan) {
            RepeatedFieldBuilderV3<Fan, Fan.Builder, FanOrBuilder> repeatedFieldBuilderV3 = this.fansBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, fan);
                return this;
            } else if (fan != null) {
                ensureFansIsMutable();
                this.fans_.add(i, fan);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addFans(Fan.Builder builder) {
            RepeatedFieldBuilderV3<Fan, Fan.Builder, FanOrBuilder> repeatedFieldBuilderV3 = this.fansBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(builder.build());
                return this;
            }
            ensureFansIsMutable();
            this.fans_.add(builder.build());
            onChanged();
            return this;
        }

        public Builder addFans(Fan fan) {
            RepeatedFieldBuilderV3<Fan, Fan.Builder, FanOrBuilder> repeatedFieldBuilderV3 = this.fansBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(fan);
                return this;
            } else if (fan != null) {
                ensureFansIsMutable();
                this.fans_.add(fan);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Fan.Builder addFansBuilder() {
            return getFansFieldBuilder().addBuilder(Fan.getDefaultInstance());
        }

        public Fan.Builder addFansBuilder(int i) {
            return getFansFieldBuilder().addBuilder(i, Fan.getDefaultInstance());
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public FriendModeVoiceExtra build() {
            FriendModeVoiceExtra buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public FriendModeVoiceExtra buildPartial() {
            FriendModeVoiceExtra friendModeVoiceExtra = new FriendModeVoiceExtra(this);
            friendModeVoiceExtra.count_ = this.count_;
            friendModeVoiceExtra.uid_ = this.uid_;
            friendModeVoiceExtra.stream_ = this.stream_;
            friendModeVoiceExtra.conferenceId_ = this.conferenceId_;
            friendModeVoiceExtra.conferenceToken_ = this.conferenceToken_;
            friendModeVoiceExtra.index_ = this.index_;
            RepeatedFieldBuilderV3<Fan, Fan.Builder, FanOrBuilder> repeatedFieldBuilderV3 = this.fansBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.fans_ = Collections.unmodifiableList(this.fans_);
                    this.bitField0_ &= -2;
                }
                friendModeVoiceExtra.fans_ = this.fans_;
            } else {
                friendModeVoiceExtra.fans_ = repeatedFieldBuilderV3.build();
            }
            friendModeVoiceExtra.name_ = this.name_;
            onBuilt();
            return friendModeVoiceExtra;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.count_ = 0;
            this.uid_ = 0;
            this.stream_ = "";
            this.conferenceId_ = "";
            this.conferenceToken_ = "";
            this.index_ = 0;
            RepeatedFieldBuilderV3<Fan, Fan.Builder, FanOrBuilder> repeatedFieldBuilderV3 = this.fansBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.fans_ = Collections.emptyList();
                this.bitField0_ &= -2;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            this.name_ = "";
            return this;
        }

        public Builder clearConferenceId() {
            this.conferenceId_ = FriendModeVoiceExtra.getDefaultInstance().getConferenceId();
            onChanged();
            return this;
        }

        public Builder clearConferenceToken() {
            this.conferenceToken_ = FriendModeVoiceExtra.getDefaultInstance().getConferenceToken();
            onChanged();
            return this;
        }

        public Builder clearCount() {
            this.count_ = 0;
            onChanged();
            return this;
        }

        public Builder clearFans() {
            RepeatedFieldBuilderV3<Fan, Fan.Builder, FanOrBuilder> repeatedFieldBuilderV3 = this.fansBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.fans_ = Collections.emptyList();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearIndex() {
            this.index_ = 0;
            onChanged();
            return this;
        }

        public Builder clearName() {
            this.name_ = FriendModeVoiceExtra.getDefaultInstance().getName();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearStream() {
            this.stream_ = FriendModeVoiceExtra.getDefaultInstance().getStream();
            onChanged();
            return this;
        }

        public Builder clearUid() {
            this.uid_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo1800clone() {
            return (Builder) super.mo1800clone();
        }

        @Override // cn.irisgw.live.FriendModeVoiceExtraOrBuilder
        public String getConferenceId() {
            Object obj = this.conferenceId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.conferenceId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.FriendModeVoiceExtraOrBuilder
        public ByteString getConferenceIdBytes() {
            Object obj = this.conferenceId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.conferenceId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.FriendModeVoiceExtraOrBuilder
        public String getConferenceToken() {
            Object obj = this.conferenceToken_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.conferenceToken_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.FriendModeVoiceExtraOrBuilder
        public ByteString getConferenceTokenBytes() {
            Object obj = this.conferenceToken_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.conferenceToken_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.FriendModeVoiceExtraOrBuilder
        public int getCount() {
            return this.count_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FriendModeVoiceExtra getDefaultInstanceForType() {
            return FriendModeVoiceExtra.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_FriendModeVoiceExtra_descriptor;
        }

        @Override // cn.irisgw.live.FriendModeVoiceExtraOrBuilder
        public Fan getFans(int i) {
            RepeatedFieldBuilderV3<Fan, Fan.Builder, FanOrBuilder> repeatedFieldBuilderV3 = this.fansBuilder_;
            return repeatedFieldBuilderV3 == null ? this.fans_.get(i) : repeatedFieldBuilderV3.getMessage(i);
        }

        public Fan.Builder getFansBuilder(int i) {
            return getFansFieldBuilder().getBuilder(i);
        }

        public List<Fan.Builder> getFansBuilderList() {
            return getFansFieldBuilder().getBuilderList();
        }

        @Override // cn.irisgw.live.FriendModeVoiceExtraOrBuilder
        public int getFansCount() {
            RepeatedFieldBuilderV3<Fan, Fan.Builder, FanOrBuilder> repeatedFieldBuilderV3 = this.fansBuilder_;
            return repeatedFieldBuilderV3 == null ? this.fans_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // cn.irisgw.live.FriendModeVoiceExtraOrBuilder
        public List<Fan> getFansList() {
            RepeatedFieldBuilderV3<Fan, Fan.Builder, FanOrBuilder> repeatedFieldBuilderV3 = this.fansBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.fans_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // cn.irisgw.live.FriendModeVoiceExtraOrBuilder
        public FanOrBuilder getFansOrBuilder(int i) {
            RepeatedFieldBuilderV3<Fan, Fan.Builder, FanOrBuilder> repeatedFieldBuilderV3 = this.fansBuilder_;
            return repeatedFieldBuilderV3 == null ? this.fans_.get(i) : repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // cn.irisgw.live.FriendModeVoiceExtraOrBuilder
        public List<? extends FanOrBuilder> getFansOrBuilderList() {
            RepeatedFieldBuilderV3<Fan, Fan.Builder, FanOrBuilder> repeatedFieldBuilderV3 = this.fansBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.fans_);
        }

        @Override // cn.irisgw.live.FriendModeVoiceExtraOrBuilder
        public int getIndex() {
            return this.index_;
        }

        @Override // cn.irisgw.live.FriendModeVoiceExtraOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.FriendModeVoiceExtraOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.FriendModeVoiceExtraOrBuilder
        public String getStream() {
            Object obj = this.stream_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.stream_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.FriendModeVoiceExtraOrBuilder
        public ByteString getStreamBytes() {
            Object obj = this.stream_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.stream_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.FriendModeVoiceExtraOrBuilder
        public int getUid() {
            return this.uid_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_FriendModeVoiceExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(FriendModeVoiceExtra.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(FriendModeVoiceExtra friendModeVoiceExtra) {
            if (friendModeVoiceExtra == FriendModeVoiceExtra.getDefaultInstance()) {
                return this;
            }
            if (friendModeVoiceExtra.getCount() != 0) {
                setCount(friendModeVoiceExtra.getCount());
            }
            if (friendModeVoiceExtra.getUid() != 0) {
                setUid(friendModeVoiceExtra.getUid());
            }
            if (!friendModeVoiceExtra.getStream().isEmpty()) {
                this.stream_ = friendModeVoiceExtra.stream_;
                onChanged();
            }
            if (!friendModeVoiceExtra.getConferenceId().isEmpty()) {
                this.conferenceId_ = friendModeVoiceExtra.conferenceId_;
                onChanged();
            }
            if (!friendModeVoiceExtra.getConferenceToken().isEmpty()) {
                this.conferenceToken_ = friendModeVoiceExtra.conferenceToken_;
                onChanged();
            }
            if (friendModeVoiceExtra.getIndex() != 0) {
                setIndex(friendModeVoiceExtra.getIndex());
            }
            if (this.fansBuilder_ == null) {
                if (!friendModeVoiceExtra.fans_.isEmpty()) {
                    if (this.fans_.isEmpty()) {
                        this.fans_ = friendModeVoiceExtra.fans_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureFansIsMutable();
                        this.fans_.addAll(friendModeVoiceExtra.fans_);
                    }
                    onChanged();
                }
            } else if (!friendModeVoiceExtra.fans_.isEmpty()) {
                if (this.fansBuilder_.isEmpty()) {
                    this.fansBuilder_.dispose();
                    RepeatedFieldBuilderV3<Fan, Fan.Builder, FanOrBuilder> repeatedFieldBuilderV3 = null;
                    this.fansBuilder_ = null;
                    this.fans_ = friendModeVoiceExtra.fans_;
                    this.bitField0_ &= -2;
                    if (FriendModeVoiceExtra.alwaysUseFieldBuilders) {
                        repeatedFieldBuilderV3 = getFansFieldBuilder();
                    }
                    this.fansBuilder_ = repeatedFieldBuilderV3;
                } else {
                    this.fansBuilder_.addAllMessages(friendModeVoiceExtra.fans_);
                }
            }
            if (!friendModeVoiceExtra.getName().isEmpty()) {
                this.name_ = friendModeVoiceExtra.name_;
                onChanged();
            }
            mergeUnknownFields(friendModeVoiceExtra.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.FriendModeVoiceExtra.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.FriendModeVoiceExtra.access$2900()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.FriendModeVoiceExtra r0 = (cn.irisgw.live.FriendModeVoiceExtra) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.FriendModeVoiceExtra$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.FriendModeVoiceExtra r0 = (cn.irisgw.live.FriendModeVoiceExtra) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.FriendModeVoiceExtra$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.FriendModeVoiceExtra.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.FriendModeVoiceExtra$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof FriendModeVoiceExtra) {
                return mergeFrom((FriendModeVoiceExtra) message);
            }
            super.mergeFrom(message);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder removeFans(int i) {
            RepeatedFieldBuilderV3<Fan, Fan.Builder, FanOrBuilder> repeatedFieldBuilderV3 = this.fansBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.remove(i);
                return this;
            }
            ensureFansIsMutable();
            this.fans_.remove(i);
            onChanged();
            return this;
        }

        public Builder setConferenceId(String str) {
            if (str != null) {
                this.conferenceId_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setConferenceIdBytes(ByteString byteString) {
            if (byteString != null) {
                FriendModeVoiceExtra.checkByteStringIsUtf8(byteString);
                this.conferenceId_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setConferenceToken(String str) {
            if (str != null) {
                this.conferenceToken_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setConferenceTokenBytes(ByteString byteString) {
            if (byteString != null) {
                FriendModeVoiceExtra.checkByteStringIsUtf8(byteString);
                this.conferenceToken_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setCount(int i) {
            this.count_ = i;
            onChanged();
            return this;
        }

        public Builder setFans(int i, Fan.Builder builder) {
            RepeatedFieldBuilderV3<Fan, Fan.Builder, FanOrBuilder> repeatedFieldBuilderV3 = this.fansBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.build());
                return this;
            }
            ensureFansIsMutable();
            this.fans_.set(i, builder.build());
            onChanged();
            return this;
        }

        public Builder setFans(int i, Fan fan) {
            RepeatedFieldBuilderV3<Fan, Fan.Builder, FanOrBuilder> repeatedFieldBuilderV3 = this.fansBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, fan);
                return this;
            } else if (fan != null) {
                ensureFansIsMutable();
                this.fans_.set(i, fan);
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

        public Builder setIndex(int i) {
            this.index_ = i;
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
                FriendModeVoiceExtra.checkByteStringIsUtf8(byteString);
                this.name_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setStream(String str) {
            if (str != null) {
                this.stream_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setStreamBytes(ByteString byteString) {
            if (byteString != null) {
                FriendModeVoiceExtra.checkByteStringIsUtf8(byteString);
                this.stream_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setUid(int i) {
            this.uid_ = i;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/FriendModeVoiceExtra$Fan.class */
    public static final class Fan extends GeneratedMessageV3 implements FanOrBuilder {
        public static final int AVATAR_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int STREAM_FIELD_NUMBER = 5;
        public static final int UID_FIELD_NUMBER = 3;
        public static final int VOICE_FIELD_NUMBER = 4;
        private static final long serialVersionUID = 0;
        private volatile Object avatar_;
        private byte memoizedIsInitialized;
        private volatile Object name_;
        private volatile Object stream_;
        private int uid_;
        private int voice_;
        private static final Fan DEFAULT_INSTANCE = new Fan();
        private static final Parser<Fan> PARSER = new AbstractParser<Fan>() { // from class: cn.irisgw.live.FriendModeVoiceExtra.Fan.1
            @Override // com.google.protobuf.Parser
            public Fan parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Fan(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/FriendModeVoiceExtra$Fan$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FanOrBuilder {
            private Object avatar_;
            private Object name_;
            private Object stream_;
            private int uid_;
            private int voice_;

            private Builder() {
                this.name_ = "";
                this.avatar_ = "";
                this.stream_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.name_ = "";
                this.avatar_ = "";
                this.stream_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LiveConstants.internal_static_cn_irisgw_live_FriendModeVoiceExtra_Fan_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = Fan.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Fan build() {
                Fan buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Fan buildPartial() {
                Fan fan = new Fan(this);
                fan.name_ = this.name_;
                fan.avatar_ = this.avatar_;
                fan.uid_ = this.uid_;
                fan.voice_ = this.voice_;
                fan.stream_ = this.stream_;
                onBuilt();
                return fan;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.name_ = "";
                this.avatar_ = "";
                this.uid_ = 0;
                this.voice_ = 0;
                this.stream_ = "";
                return this;
            }

            public Builder clearAvatar() {
                this.avatar_ = Fan.getDefaultInstance().getAvatar();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearName() {
                this.name_ = Fan.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearStream() {
                this.stream_ = Fan.getDefaultInstance().getStream();
                onChanged();
                return this;
            }

            public Builder clearUid() {
                this.uid_ = 0;
                onChanged();
                return this;
            }

            public Builder clearVoice() {
                this.voice_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1800clone() {
                return (Builder) super.mo1800clone();
            }

            @Override // cn.irisgw.live.FriendModeVoiceExtra.FanOrBuilder
            public String getAvatar() {
                Object obj = this.avatar_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.avatar_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.FriendModeVoiceExtra.FanOrBuilder
            public ByteString getAvatarBytes() {
                Object obj = this.avatar_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.avatar_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Fan getDefaultInstanceForType() {
                return Fan.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return LiveConstants.internal_static_cn_irisgw_live_FriendModeVoiceExtra_Fan_descriptor;
            }

            @Override // cn.irisgw.live.FriendModeVoiceExtra.FanOrBuilder
            public String getName() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.FriendModeVoiceExtra.FanOrBuilder
            public ByteString getNameBytes() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.name_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.FriendModeVoiceExtra.FanOrBuilder
            public String getStream() {
                Object obj = this.stream_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.stream_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.FriendModeVoiceExtra.FanOrBuilder
            public ByteString getStreamBytes() {
                Object obj = this.stream_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.stream_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.FriendModeVoiceExtra.FanOrBuilder
            public int getUid() {
                return this.uid_;
            }

            @Override // cn.irisgw.live.FriendModeVoiceExtra.FanOrBuilder
            public int getVoice() {
                return this.voice_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveConstants.internal_static_cn_irisgw_live_FriendModeVoiceExtra_Fan_fieldAccessorTable.ensureFieldAccessorsInitialized(Fan.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(Fan fan) {
                if (fan == Fan.getDefaultInstance()) {
                    return this;
                }
                if (!fan.getName().isEmpty()) {
                    this.name_ = fan.name_;
                    onChanged();
                }
                if (!fan.getAvatar().isEmpty()) {
                    this.avatar_ = fan.avatar_;
                    onChanged();
                }
                if (fan.getUid() != 0) {
                    setUid(fan.getUid());
                }
                if (fan.getVoice() != 0) {
                    setVoice(fan.getVoice());
                }
                if (!fan.getStream().isEmpty()) {
                    this.stream_ = fan.stream_;
                    onChanged();
                }
                mergeUnknownFields(fan.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.FriendModeVoiceExtra.Fan.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.FriendModeVoiceExtra.Fan.access$1000()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.FriendModeVoiceExtra$Fan r0 = (cn.irisgw.live.FriendModeVoiceExtra.Fan) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.FriendModeVoiceExtra$Fan$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.FriendModeVoiceExtra$Fan r0 = (cn.irisgw.live.FriendModeVoiceExtra.Fan) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.FriendModeVoiceExtra$Fan$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.FriendModeVoiceExtra.Fan.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.FriendModeVoiceExtra$Fan$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof Fan) {
                    return mergeFrom((Fan) message);
                }
                super.mergeFrom(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder setAvatar(String str) {
                if (str != null) {
                    this.avatar_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setAvatarBytes(ByteString byteString) {
                if (byteString != null) {
                    Fan.checkByteStringIsUtf8(byteString);
                    this.avatar_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
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
                    Fan.checkByteStringIsUtf8(byteString);
                    this.name_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setStream(String str) {
                if (str != null) {
                    this.stream_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setStreamBytes(ByteString byteString) {
                if (byteString != null) {
                    Fan.checkByteStringIsUtf8(byteString);
                    this.stream_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setUid(int i) {
                this.uid_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            public Builder setVoice(int i) {
                this.voice_ = i;
                onChanged();
                return this;
            }
        }

        private Fan() {
            this.memoizedIsInitialized = (byte) -1;
            this.name_ = "";
            this.avatar_ = "";
            this.stream_ = "";
        }

        private Fan(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.name_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                this.avatar_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 24) {
                                this.uid_ = codedInputStream.readUInt32();
                            } else if (readTag == 32) {
                                this.voice_ = codedInputStream.readUInt32();
                            } else if (readTag == 42) {
                                this.stream_ = codedInputStream.readStringRequireUtf8();
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

        private Fan(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Fan getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_FriendModeVoiceExtra_Fan_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Fan fan) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(fan);
        }

        public static Fan parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Fan) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Fan parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Fan) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Fan parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Fan parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Fan parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Fan) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Fan parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Fan) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static Fan parseFrom(InputStream inputStream) throws IOException {
            return (Fan) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Fan parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Fan) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Fan parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Fan parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Fan parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Fan parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<Fan> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Fan) {
                Fan fan = (Fan) obj;
                return getName().equals(fan.getName()) && getAvatar().equals(fan.getAvatar()) && getUid() == fan.getUid() && getVoice() == fan.getVoice() && getStream().equals(fan.getStream()) && this.unknownFields.equals(fan.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // cn.irisgw.live.FriendModeVoiceExtra.FanOrBuilder
        public String getAvatar() {
            Object obj = this.avatar_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.avatar_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.FriendModeVoiceExtra.FanOrBuilder
        public ByteString getAvatarBytes() {
            Object obj = this.avatar_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.avatar_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Fan getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // cn.irisgw.live.FriendModeVoiceExtra.FanOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.FriendModeVoiceExtra.FanOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Fan> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (!getNameBytes().isEmpty()) {
                i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.name_);
            }
            int i3 = i2;
            if (!getAvatarBytes().isEmpty()) {
                i3 = i2 + GeneratedMessageV3.computeStringSize(2, this.avatar_);
            }
            int i4 = this.uid_;
            int i5 = i3;
            if (i4 != 0) {
                i5 = i3 + CodedOutputStream.computeUInt32Size(3, i4);
            }
            int i6 = this.voice_;
            int i7 = i5;
            if (i6 != 0) {
                i7 = i5 + CodedOutputStream.computeUInt32Size(4, i6);
            }
            int i8 = i7;
            if (!getStreamBytes().isEmpty()) {
                i8 = i7 + GeneratedMessageV3.computeStringSize(5, this.stream_);
            }
            int serializedSize = i8 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // cn.irisgw.live.FriendModeVoiceExtra.FanOrBuilder
        public String getStream() {
            Object obj = this.stream_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.stream_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.FriendModeVoiceExtra.FanOrBuilder
        public ByteString getStreamBytes() {
            Object obj = this.stream_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.stream_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.FriendModeVoiceExtra.FanOrBuilder
        public int getUid() {
            return this.uid_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // cn.irisgw.live.FriendModeVoiceExtra.FanOrBuilder
        public int getVoice() {
            return this.voice_;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getName().hashCode()) * 37) + 2) * 53) + getAvatar().hashCode()) * 37) + 3) * 53) + getUid()) * 37) + 4) * 53) + getVoice()) * 37) + 5) * 53) + getStream().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_FriendModeVoiceExtra_Fan_fieldAccessorTable.ensureFieldAccessorsInitialized(Fan.class, Builder.class);
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
            return new Fan();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!getNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.name_);
            }
            if (!getAvatarBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.avatar_);
            }
            int i = this.uid_;
            if (i != 0) {
                codedOutputStream.writeUInt32(3, i);
            }
            int i2 = this.voice_;
            if (i2 != 0) {
                codedOutputStream.writeUInt32(4, i2);
            }
            if (!getStreamBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.stream_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/FriendModeVoiceExtra$FanOrBuilder.class */
    public interface FanOrBuilder extends MessageOrBuilder {
        String getAvatar();

        ByteString getAvatarBytes();

        String getName();

        ByteString getNameBytes();

        String getStream();

        ByteString getStreamBytes();

        int getUid();

        int getVoice();
    }

    private FriendModeVoiceExtra() {
        this.memoizedIsInitialized = (byte) -1;
        this.stream_ = "";
        this.conferenceId_ = "";
        this.conferenceToken_ = "";
        this.fans_ = Collections.emptyList();
        this.name_ = "";
    }

    private FriendModeVoiceExtra(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.count_ = codedInputStream.readUInt32();
                            } else if (readTag == 16) {
                                this.uid_ = codedInputStream.readUInt32();
                            } else if (readTag == 26) {
                                this.stream_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 34) {
                                this.conferenceId_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 42) {
                                this.conferenceToken_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 48) {
                                this.index_ = codedInputStream.readUInt32();
                            } else if (readTag == 58) {
                                boolean z4 = z2;
                                if (!(z2 & true)) {
                                    this.fans_ = new ArrayList();
                                    z4 = z2 | true;
                                }
                                this.fans_.add((Fan) codedInputStream.readMessage(Fan.parser(), extensionRegistryLite));
                                z2 = z4;
                            } else if (readTag == 66) {
                                this.name_ = codedInputStream.readStringRequireUtf8();
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
            } catch (Throwable th) {
                if (z3 & true) {
                    this.fans_ = Collections.unmodifiableList(this.fans_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                throw th;
            }
        }
        if (z2 & true) {
            this.fans_ = Collections.unmodifiableList(this.fans_);
        }
        this.unknownFields = newBuilder.build();
        makeExtensionsImmutable();
    }

    private FriendModeVoiceExtra(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static FriendModeVoiceExtra getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_FriendModeVoiceExtra_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(FriendModeVoiceExtra friendModeVoiceExtra) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(friendModeVoiceExtra);
    }

    public static FriendModeVoiceExtra parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (FriendModeVoiceExtra) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static FriendModeVoiceExtra parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (FriendModeVoiceExtra) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static FriendModeVoiceExtra parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static FriendModeVoiceExtra parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static FriendModeVoiceExtra parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (FriendModeVoiceExtra) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static FriendModeVoiceExtra parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (FriendModeVoiceExtra) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static FriendModeVoiceExtra parseFrom(InputStream inputStream) throws IOException {
        return (FriendModeVoiceExtra) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static FriendModeVoiceExtra parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (FriendModeVoiceExtra) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static FriendModeVoiceExtra parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static FriendModeVoiceExtra parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static FriendModeVoiceExtra parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static FriendModeVoiceExtra parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<FriendModeVoiceExtra> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FriendModeVoiceExtra) {
            FriendModeVoiceExtra friendModeVoiceExtra = (FriendModeVoiceExtra) obj;
            return getCount() == friendModeVoiceExtra.getCount() && getUid() == friendModeVoiceExtra.getUid() && getStream().equals(friendModeVoiceExtra.getStream()) && getConferenceId().equals(friendModeVoiceExtra.getConferenceId()) && getConferenceToken().equals(friendModeVoiceExtra.getConferenceToken()) && getIndex() == friendModeVoiceExtra.getIndex() && getFansList().equals(friendModeVoiceExtra.getFansList()) && getName().equals(friendModeVoiceExtra.getName()) && this.unknownFields.equals(friendModeVoiceExtra.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.FriendModeVoiceExtraOrBuilder
    public String getConferenceId() {
        Object obj = this.conferenceId_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.conferenceId_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.FriendModeVoiceExtraOrBuilder
    public ByteString getConferenceIdBytes() {
        Object obj = this.conferenceId_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.conferenceId_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.FriendModeVoiceExtraOrBuilder
    public String getConferenceToken() {
        Object obj = this.conferenceToken_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.conferenceToken_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.FriendModeVoiceExtraOrBuilder
    public ByteString getConferenceTokenBytes() {
        Object obj = this.conferenceToken_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.conferenceToken_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.FriendModeVoiceExtraOrBuilder
    public int getCount() {
        return this.count_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public FriendModeVoiceExtra getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.FriendModeVoiceExtraOrBuilder
    public Fan getFans(int i) {
        return this.fans_.get(i);
    }

    @Override // cn.irisgw.live.FriendModeVoiceExtraOrBuilder
    public int getFansCount() {
        return this.fans_.size();
    }

    @Override // cn.irisgw.live.FriendModeVoiceExtraOrBuilder
    public List<Fan> getFansList() {
        return this.fans_;
    }

    @Override // cn.irisgw.live.FriendModeVoiceExtraOrBuilder
    public FanOrBuilder getFansOrBuilder(int i) {
        return this.fans_.get(i);
    }

    @Override // cn.irisgw.live.FriendModeVoiceExtraOrBuilder
    public List<? extends FanOrBuilder> getFansOrBuilderList() {
        return this.fans_;
    }

    @Override // cn.irisgw.live.FriendModeVoiceExtraOrBuilder
    public int getIndex() {
        return this.index_;
    }

    @Override // cn.irisgw.live.FriendModeVoiceExtraOrBuilder
    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.FriendModeVoiceExtraOrBuilder
    public ByteString getNameBytes() {
        Object obj = this.name_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.name_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<FriendModeVoiceExtra> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = this.count_;
        int computeUInt32Size = i2 != 0 ? CodedOutputStream.computeUInt32Size(1, i2) + 0 : 0;
        int i3 = this.uid_;
        int i4 = computeUInt32Size;
        if (i3 != 0) {
            i4 = computeUInt32Size + CodedOutputStream.computeUInt32Size(2, i3);
        }
        int i5 = i4;
        if (!getStreamBytes().isEmpty()) {
            i5 = i4 + GeneratedMessageV3.computeStringSize(3, this.stream_);
        }
        int i6 = i5;
        if (!getConferenceIdBytes().isEmpty()) {
            i6 = i5 + GeneratedMessageV3.computeStringSize(4, this.conferenceId_);
        }
        int i7 = i6;
        if (!getConferenceTokenBytes().isEmpty()) {
            i7 = i6 + GeneratedMessageV3.computeStringSize(5, this.conferenceToken_);
        }
        int i8 = this.index_;
        int i9 = i7;
        int i10 = 0;
        if (i8 != 0) {
            i9 = i7 + CodedOutputStream.computeUInt32Size(6, i8);
            i10 = 0;
        }
        while (i10 < this.fans_.size()) {
            i9 += CodedOutputStream.computeMessageSize(7, this.fans_.get(i10));
            i10++;
        }
        int i11 = i9;
        if (!getNameBytes().isEmpty()) {
            i11 = i9 + GeneratedMessageV3.computeStringSize(8, this.name_);
        }
        int serializedSize = i11 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.FriendModeVoiceExtraOrBuilder
    public String getStream() {
        Object obj = this.stream_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.stream_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.FriendModeVoiceExtraOrBuilder
    public ByteString getStreamBytes() {
        Object obj = this.stream_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.stream_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.FriendModeVoiceExtraOrBuilder
    public int getUid() {
        return this.uid_;
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
        int hashCode = ((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getCount()) * 37) + 2) * 53) + getUid()) * 37) + 3) * 53) + getStream().hashCode()) * 37) + 4) * 53) + getConferenceId().hashCode()) * 37) + 5) * 53) + getConferenceToken().hashCode()) * 37) + 6) * 53) + getIndex();
        int i = hashCode;
        if (getFansCount() > 0) {
            i = (((hashCode * 37) + 7) * 53) + getFansList().hashCode();
        }
        int hashCode2 = (((((i * 37) + 8) * 53) + getName().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_FriendModeVoiceExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(FriendModeVoiceExtra.class, Builder.class);
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
        return new FriendModeVoiceExtra();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.count_;
        if (i != 0) {
            codedOutputStream.writeUInt32(1, i);
        }
        int i2 = this.uid_;
        if (i2 != 0) {
            codedOutputStream.writeUInt32(2, i2);
        }
        if (!getStreamBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 3, this.stream_);
        }
        if (!getConferenceIdBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 4, this.conferenceId_);
        }
        if (!getConferenceTokenBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 5, this.conferenceToken_);
        }
        int i3 = this.index_;
        if (i3 != 0) {
            codedOutputStream.writeUInt32(6, i3);
        }
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= this.fans_.size()) {
                break;
            }
            codedOutputStream.writeMessage(7, this.fans_.get(i5));
            i4 = i5 + 1;
        }
        if (!getNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 8, this.name_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
