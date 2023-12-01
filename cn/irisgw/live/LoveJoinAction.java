package cn.irisgw.live;

import cn.irisgw.live.LoveFan;
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
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LoveJoinAction.class */
public final class LoveJoinAction extends GeneratedMessageV3 implements LoveJoinActionOrBuilder {
    public static final int CONFERENCE_ID_FIELD_NUMBER = 1;
    public static final int FANS_FIELD_NUMBER = 8;
    public static final int INDEX_FIELD_NUMBER = 4;
    public static final int IS_HIDE_DISTANCE_FIELD_NUMBER = 3;
    public static final int NAME_FIELD_NUMBER = 7;
    public static final int STREAM_FIELD_NUMBER = 2;
    public static final int TYPE_FIELD_NUMBER = 5;
    public static final int UID_FIELD_NUMBER = 6;
    private static final long serialVersionUID = 0;
    private volatile Object conferenceId_;
    private List<LoveFan> fans_;
    private int index_;
    private boolean isHideDistance_;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private volatile Object stream_;
    private volatile Object type_;
    private int uid_;
    private static final LoveJoinAction DEFAULT_INSTANCE = new LoveJoinAction();
    private static final Parser<LoveJoinAction> PARSER = new AbstractParser<LoveJoinAction>() { // from class: cn.irisgw.live.LoveJoinAction.1
        @Override // com.google.protobuf.Parser
        public LoveJoinAction parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new LoveJoinAction(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LoveJoinAction$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LoveJoinActionOrBuilder {
        private int bitField0_;
        private Object conferenceId_;
        private RepeatedFieldBuilderV3<LoveFan, LoveFan.Builder, LoveFanOrBuilder> fansBuilder_;
        private List<LoveFan> fans_;
        private int index_;
        private boolean isHideDistance_;
        private Object name_;
        private Object stream_;
        private Object type_;
        private int uid_;

        private Builder() {
            this.conferenceId_ = "";
            this.stream_ = "";
            this.type_ = "";
            this.name_ = "";
            this.fans_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.conferenceId_ = "";
            this.stream_ = "";
            this.type_ = "";
            this.name_ = "";
            this.fans_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private void ensureFansIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.fans_ = new ArrayList(this.fans_);
                this.bitField0_ |= 1;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_LoveJoinAction_descriptor;
        }

        private RepeatedFieldBuilderV3<LoveFan, LoveFan.Builder, LoveFanOrBuilder> getFansFieldBuilder() {
            if (this.fansBuilder_ == null) {
                List<LoveFan> list = this.fans_;
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
            if (LoveJoinAction.alwaysUseFieldBuilders) {
                getFansFieldBuilder();
            }
        }

        public Builder addAllFans(Iterable<? extends LoveFan> iterable) {
            RepeatedFieldBuilderV3<LoveFan, LoveFan.Builder, LoveFanOrBuilder> repeatedFieldBuilderV3 = this.fansBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensureFansIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.fans_);
            onChanged();
            return this;
        }

        public Builder addFans(int i, LoveFan.Builder builder) {
            RepeatedFieldBuilderV3<LoveFan, LoveFan.Builder, LoveFanOrBuilder> repeatedFieldBuilderV3 = this.fansBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.build());
                return this;
            }
            ensureFansIsMutable();
            this.fans_.add(i, builder.build());
            onChanged();
            return this;
        }

        public Builder addFans(int i, LoveFan loveFan) {
            RepeatedFieldBuilderV3<LoveFan, LoveFan.Builder, LoveFanOrBuilder> repeatedFieldBuilderV3 = this.fansBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, loveFan);
                return this;
            } else if (loveFan != null) {
                ensureFansIsMutable();
                this.fans_.add(i, loveFan);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addFans(LoveFan.Builder builder) {
            RepeatedFieldBuilderV3<LoveFan, LoveFan.Builder, LoveFanOrBuilder> repeatedFieldBuilderV3 = this.fansBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(builder.build());
                return this;
            }
            ensureFansIsMutable();
            this.fans_.add(builder.build());
            onChanged();
            return this;
        }

        public Builder addFans(LoveFan loveFan) {
            RepeatedFieldBuilderV3<LoveFan, LoveFan.Builder, LoveFanOrBuilder> repeatedFieldBuilderV3 = this.fansBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(loveFan);
                return this;
            } else if (loveFan != null) {
                ensureFansIsMutable();
                this.fans_.add(loveFan);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public LoveFan.Builder addFansBuilder() {
            return getFansFieldBuilder().addBuilder(LoveFan.getDefaultInstance());
        }

        public LoveFan.Builder addFansBuilder(int i) {
            return getFansFieldBuilder().addBuilder(i, LoveFan.getDefaultInstance());
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public LoveJoinAction build() {
            LoveJoinAction buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public LoveJoinAction buildPartial() {
            LoveJoinAction loveJoinAction = new LoveJoinAction(this);
            loveJoinAction.conferenceId_ = this.conferenceId_;
            loveJoinAction.stream_ = this.stream_;
            loveJoinAction.isHideDistance_ = this.isHideDistance_;
            loveJoinAction.index_ = this.index_;
            loveJoinAction.type_ = this.type_;
            loveJoinAction.uid_ = this.uid_;
            loveJoinAction.name_ = this.name_;
            RepeatedFieldBuilderV3<LoveFan, LoveFan.Builder, LoveFanOrBuilder> repeatedFieldBuilderV3 = this.fansBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.fans_ = Collections.unmodifiableList(this.fans_);
                    this.bitField0_ &= -2;
                }
                loveJoinAction.fans_ = this.fans_;
            } else {
                loveJoinAction.fans_ = repeatedFieldBuilderV3.build();
            }
            onBuilt();
            return loveJoinAction;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.conferenceId_ = "";
            this.stream_ = "";
            this.isHideDistance_ = false;
            this.index_ = 0;
            this.type_ = "";
            this.uid_ = 0;
            this.name_ = "";
            RepeatedFieldBuilderV3<LoveFan, LoveFan.Builder, LoveFanOrBuilder> repeatedFieldBuilderV3 = this.fansBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.fans_ = Collections.emptyList();
            this.bitField0_ &= -2;
            return this;
        }

        public Builder clearConferenceId() {
            this.conferenceId_ = LoveJoinAction.getDefaultInstance().getConferenceId();
            onChanged();
            return this;
        }

        public Builder clearFans() {
            RepeatedFieldBuilderV3<LoveFan, LoveFan.Builder, LoveFanOrBuilder> repeatedFieldBuilderV3 = this.fansBuilder_;
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

        public Builder clearIsHideDistance() {
            this.isHideDistance_ = false;
            onChanged();
            return this;
        }

        public Builder clearName() {
            this.name_ = LoveJoinAction.getDefaultInstance().getName();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearStream() {
            this.stream_ = LoveJoinAction.getDefaultInstance().getStream();
            onChanged();
            return this;
        }

        public Builder clearType() {
            this.type_ = LoveJoinAction.getDefaultInstance().getType();
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

        @Override // cn.irisgw.live.LoveJoinActionOrBuilder
        public String getConferenceId() {
            Object obj = this.conferenceId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.conferenceId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LoveJoinActionOrBuilder
        public ByteString getConferenceIdBytes() {
            Object obj = this.conferenceId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.conferenceId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public LoveJoinAction getDefaultInstanceForType() {
            return LoveJoinAction.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_LoveJoinAction_descriptor;
        }

        @Override // cn.irisgw.live.LoveJoinActionOrBuilder
        public LoveFan getFans(int i) {
            RepeatedFieldBuilderV3<LoveFan, LoveFan.Builder, LoveFanOrBuilder> repeatedFieldBuilderV3 = this.fansBuilder_;
            return repeatedFieldBuilderV3 == null ? this.fans_.get(i) : repeatedFieldBuilderV3.getMessage(i);
        }

        public LoveFan.Builder getFansBuilder(int i) {
            return getFansFieldBuilder().getBuilder(i);
        }

        public List<LoveFan.Builder> getFansBuilderList() {
            return getFansFieldBuilder().getBuilderList();
        }

        @Override // cn.irisgw.live.LoveJoinActionOrBuilder
        public int getFansCount() {
            RepeatedFieldBuilderV3<LoveFan, LoveFan.Builder, LoveFanOrBuilder> repeatedFieldBuilderV3 = this.fansBuilder_;
            return repeatedFieldBuilderV3 == null ? this.fans_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // cn.irisgw.live.LoveJoinActionOrBuilder
        public List<LoveFan> getFansList() {
            RepeatedFieldBuilderV3<LoveFan, LoveFan.Builder, LoveFanOrBuilder> repeatedFieldBuilderV3 = this.fansBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.fans_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // cn.irisgw.live.LoveJoinActionOrBuilder
        public LoveFanOrBuilder getFansOrBuilder(int i) {
            RepeatedFieldBuilderV3<LoveFan, LoveFan.Builder, LoveFanOrBuilder> repeatedFieldBuilderV3 = this.fansBuilder_;
            return repeatedFieldBuilderV3 == null ? this.fans_.get(i) : repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // cn.irisgw.live.LoveJoinActionOrBuilder
        public List<? extends LoveFanOrBuilder> getFansOrBuilderList() {
            RepeatedFieldBuilderV3<LoveFan, LoveFan.Builder, LoveFanOrBuilder> repeatedFieldBuilderV3 = this.fansBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.fans_);
        }

        @Override // cn.irisgw.live.LoveJoinActionOrBuilder
        public int getIndex() {
            return this.index_;
        }

        @Override // cn.irisgw.live.LoveJoinActionOrBuilder
        public boolean getIsHideDistance() {
            return this.isHideDistance_;
        }

        @Override // cn.irisgw.live.LoveJoinActionOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LoveJoinActionOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.LoveJoinActionOrBuilder
        public String getStream() {
            Object obj = this.stream_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.stream_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LoveJoinActionOrBuilder
        public ByteString getStreamBytes() {
            Object obj = this.stream_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.stream_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.LoveJoinActionOrBuilder
        public String getType() {
            Object obj = this.type_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.type_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LoveJoinActionOrBuilder
        public ByteString getTypeBytes() {
            Object obj = this.type_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.type_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.LoveJoinActionOrBuilder
        public int getUid() {
            return this.uid_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_LoveJoinAction_fieldAccessorTable.ensureFieldAccessorsInitialized(LoveJoinAction.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(LoveJoinAction loveJoinAction) {
            if (loveJoinAction == LoveJoinAction.getDefaultInstance()) {
                return this;
            }
            if (!loveJoinAction.getConferenceId().isEmpty()) {
                this.conferenceId_ = loveJoinAction.conferenceId_;
                onChanged();
            }
            if (!loveJoinAction.getStream().isEmpty()) {
                this.stream_ = loveJoinAction.stream_;
                onChanged();
            }
            if (loveJoinAction.getIsHideDistance()) {
                setIsHideDistance(loveJoinAction.getIsHideDistance());
            }
            if (loveJoinAction.getIndex() != 0) {
                setIndex(loveJoinAction.getIndex());
            }
            if (!loveJoinAction.getType().isEmpty()) {
                this.type_ = loveJoinAction.type_;
                onChanged();
            }
            if (loveJoinAction.getUid() != 0) {
                setUid(loveJoinAction.getUid());
            }
            if (!loveJoinAction.getName().isEmpty()) {
                this.name_ = loveJoinAction.name_;
                onChanged();
            }
            if (this.fansBuilder_ == null) {
                if (!loveJoinAction.fans_.isEmpty()) {
                    if (this.fans_.isEmpty()) {
                        this.fans_ = loveJoinAction.fans_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureFansIsMutable();
                        this.fans_.addAll(loveJoinAction.fans_);
                    }
                    onChanged();
                }
            } else if (!loveJoinAction.fans_.isEmpty()) {
                if (this.fansBuilder_.isEmpty()) {
                    this.fansBuilder_.dispose();
                    RepeatedFieldBuilderV3<LoveFan, LoveFan.Builder, LoveFanOrBuilder> repeatedFieldBuilderV3 = null;
                    this.fansBuilder_ = null;
                    this.fans_ = loveJoinAction.fans_;
                    this.bitField0_ &= -2;
                    if (LoveJoinAction.alwaysUseFieldBuilders) {
                        repeatedFieldBuilderV3 = getFansFieldBuilder();
                    }
                    this.fansBuilder_ = repeatedFieldBuilderV3;
                } else {
                    this.fansBuilder_.addAllMessages(loveJoinAction.fans_);
                }
            }
            mergeUnknownFields(loveJoinAction.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.LoveJoinAction.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.LoveJoinAction.access$1400()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.LoveJoinAction r0 = (cn.irisgw.live.LoveJoinAction) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.LoveJoinAction$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.LoveJoinAction r0 = (cn.irisgw.live.LoveJoinAction) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.LoveJoinAction$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.LoveJoinAction.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.LoveJoinAction$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof LoveJoinAction) {
                return mergeFrom((LoveJoinAction) message);
            }
            super.mergeFrom(message);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder removeFans(int i) {
            RepeatedFieldBuilderV3<LoveFan, LoveFan.Builder, LoveFanOrBuilder> repeatedFieldBuilderV3 = this.fansBuilder_;
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
                LoveJoinAction.checkByteStringIsUtf8(byteString);
                this.conferenceId_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setFans(int i, LoveFan.Builder builder) {
            RepeatedFieldBuilderV3<LoveFan, LoveFan.Builder, LoveFanOrBuilder> repeatedFieldBuilderV3 = this.fansBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.build());
                return this;
            }
            ensureFansIsMutable();
            this.fans_.set(i, builder.build());
            onChanged();
            return this;
        }

        public Builder setFans(int i, LoveFan loveFan) {
            RepeatedFieldBuilderV3<LoveFan, LoveFan.Builder, LoveFanOrBuilder> repeatedFieldBuilderV3 = this.fansBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, loveFan);
                return this;
            } else if (loveFan != null) {
                ensureFansIsMutable();
                this.fans_.set(i, loveFan);
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

        public Builder setIsHideDistance(boolean z) {
            this.isHideDistance_ = z;
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
                LoveJoinAction.checkByteStringIsUtf8(byteString);
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
                LoveJoinAction.checkByteStringIsUtf8(byteString);
                this.stream_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setType(String str) {
            if (str != null) {
                this.type_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setTypeBytes(ByteString byteString) {
            if (byteString != null) {
                LoveJoinAction.checkByteStringIsUtf8(byteString);
                this.type_ = byteString;
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

    private LoveJoinAction() {
        this.memoizedIsInitialized = (byte) -1;
        this.conferenceId_ = "";
        this.stream_ = "";
        this.type_ = "";
        this.name_ = "";
        this.fans_ = Collections.emptyList();
    }

    private LoveJoinAction(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            if (readTag == 10) {
                                this.conferenceId_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                this.stream_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 24) {
                                this.isHideDistance_ = codedInputStream.readBool();
                            } else if (readTag == 32) {
                                this.index_ = codedInputStream.readUInt32();
                            } else if (readTag == 42) {
                                this.type_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 48) {
                                this.uid_ = codedInputStream.readUInt32();
                            } else if (readTag == 58) {
                                this.name_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 66) {
                                boolean z4 = z2;
                                if (!(z2 & true)) {
                                    this.fans_ = new ArrayList();
                                    z4 = z2 | true;
                                }
                                this.fans_.add((LoveFan) codedInputStream.readMessage(LoveFan.parser(), extensionRegistryLite));
                                z2 = z4;
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

    private LoveJoinAction(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static LoveJoinAction getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_LoveJoinAction_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(LoveJoinAction loveJoinAction) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(loveJoinAction);
    }

    public static LoveJoinAction parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (LoveJoinAction) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static LoveJoinAction parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LoveJoinAction) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LoveJoinAction parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static LoveJoinAction parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static LoveJoinAction parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (LoveJoinAction) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static LoveJoinAction parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LoveJoinAction) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static LoveJoinAction parseFrom(InputStream inputStream) throws IOException {
        return (LoveJoinAction) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static LoveJoinAction parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LoveJoinAction) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LoveJoinAction parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static LoveJoinAction parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static LoveJoinAction parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static LoveJoinAction parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<LoveJoinAction> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LoveJoinAction) {
            LoveJoinAction loveJoinAction = (LoveJoinAction) obj;
            return getConferenceId().equals(loveJoinAction.getConferenceId()) && getStream().equals(loveJoinAction.getStream()) && getIsHideDistance() == loveJoinAction.getIsHideDistance() && getIndex() == loveJoinAction.getIndex() && getType().equals(loveJoinAction.getType()) && getUid() == loveJoinAction.getUid() && getName().equals(loveJoinAction.getName()) && getFansList().equals(loveJoinAction.getFansList()) && this.unknownFields.equals(loveJoinAction.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.LoveJoinActionOrBuilder
    public String getConferenceId() {
        Object obj = this.conferenceId_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.conferenceId_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.LoveJoinActionOrBuilder
    public ByteString getConferenceIdBytes() {
        Object obj = this.conferenceId_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.conferenceId_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public LoveJoinAction getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.LoveJoinActionOrBuilder
    public LoveFan getFans(int i) {
        return this.fans_.get(i);
    }

    @Override // cn.irisgw.live.LoveJoinActionOrBuilder
    public int getFansCount() {
        return this.fans_.size();
    }

    @Override // cn.irisgw.live.LoveJoinActionOrBuilder
    public List<LoveFan> getFansList() {
        return this.fans_;
    }

    @Override // cn.irisgw.live.LoveJoinActionOrBuilder
    public LoveFanOrBuilder getFansOrBuilder(int i) {
        return this.fans_.get(i);
    }

    @Override // cn.irisgw.live.LoveJoinActionOrBuilder
    public List<? extends LoveFanOrBuilder> getFansOrBuilderList() {
        return this.fans_;
    }

    @Override // cn.irisgw.live.LoveJoinActionOrBuilder
    public int getIndex() {
        return this.index_;
    }

    @Override // cn.irisgw.live.LoveJoinActionOrBuilder
    public boolean getIsHideDistance() {
        return this.isHideDistance_;
    }

    @Override // cn.irisgw.live.LoveJoinActionOrBuilder
    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.LoveJoinActionOrBuilder
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
    public Parser<LoveJoinAction> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int computeStringSize = !getConferenceIdBytes().isEmpty() ? GeneratedMessageV3.computeStringSize(1, this.conferenceId_) + 0 : 0;
        int i2 = computeStringSize;
        if (!getStreamBytes().isEmpty()) {
            i2 = computeStringSize + GeneratedMessageV3.computeStringSize(2, this.stream_);
        }
        boolean z = this.isHideDistance_;
        int i3 = i2;
        if (z) {
            i3 = i2 + CodedOutputStream.computeBoolSize(3, z);
        }
        int i4 = this.index_;
        int i5 = i3;
        if (i4 != 0) {
            i5 = i3 + CodedOutputStream.computeUInt32Size(4, i4);
        }
        int i6 = i5;
        if (!getTypeBytes().isEmpty()) {
            i6 = i5 + GeneratedMessageV3.computeStringSize(5, this.type_);
        }
        int i7 = this.uid_;
        int i8 = i6;
        if (i7 != 0) {
            i8 = i6 + CodedOutputStream.computeUInt32Size(6, i7);
        }
        int i9 = i8;
        int i10 = 0;
        if (!getNameBytes().isEmpty()) {
            i9 = i8 + GeneratedMessageV3.computeStringSize(7, this.name_);
            i10 = 0;
        }
        while (i10 < this.fans_.size()) {
            i9 += CodedOutputStream.computeMessageSize(8, this.fans_.get(i10));
            i10++;
        }
        int serializedSize = i9 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.LoveJoinActionOrBuilder
    public String getStream() {
        Object obj = this.stream_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.stream_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.LoveJoinActionOrBuilder
    public ByteString getStreamBytes() {
        Object obj = this.stream_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.stream_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.LoveJoinActionOrBuilder
    public String getType() {
        Object obj = this.type_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.type_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.LoveJoinActionOrBuilder
    public ByteString getTypeBytes() {
        Object obj = this.type_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.type_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.LoveJoinActionOrBuilder
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
        int hashCode = ((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getConferenceId().hashCode()) * 37) + 2) * 53) + getStream().hashCode()) * 37) + 3) * 53) + Internal.hashBoolean(getIsHideDistance())) * 37) + 4) * 53) + getIndex()) * 37) + 5) * 53) + getType().hashCode()) * 37) + 6) * 53) + getUid()) * 37) + 7) * 53) + getName().hashCode();
        int i = hashCode;
        if (getFansCount() > 0) {
            i = (((hashCode * 37) + 8) * 53) + getFansList().hashCode();
        }
        int hashCode2 = (i * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_LoveJoinAction_fieldAccessorTable.ensureFieldAccessorsInitialized(LoveJoinAction.class, Builder.class);
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
        return new LoveJoinAction();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!getConferenceIdBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.conferenceId_);
        }
        if (!getStreamBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.stream_);
        }
        boolean z = this.isHideDistance_;
        if (z) {
            codedOutputStream.writeBool(3, z);
        }
        int i = this.index_;
        if (i != 0) {
            codedOutputStream.writeUInt32(4, i);
        }
        if (!getTypeBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 5, this.type_);
        }
        int i2 = this.uid_;
        if (i2 != 0) {
            codedOutputStream.writeUInt32(6, i2);
        }
        if (!getNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 7, this.name_);
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.fans_.size()) {
                this.unknownFields.writeTo(codedOutputStream);
                return;
            } else {
                codedOutputStream.writeMessage(8, this.fans_.get(i4));
                i3 = i4 + 1;
            }
        }
    }
}
