package cn.irisgw.live;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveRoomToolsChange.class */
public final class LiveRoomToolsChange extends GeneratedMessageV3 implements LiveRoomToolsChangeOrBuilder {
    public static final int BADGE_TEXT_FIELD_NUMBER = 1;
    public static final int COUNTDONW_TYPE_FIELD_NUMBER = 7;
    public static final int COUNTDOWN_FIELD_NUMBER = 6;
    public static final int DESC_FIELD_NUMBER = 2;
    public static final int DESC_ICON_FIELD_NUMBER = 5;
    public static final int DESC_TYPE_FIELD_NUMBER = 9;
    public static final int ICON_FIELD_NUMBER = 4;
    public static final int STATUS_FIELD_NUMBER = 10;
    public static final int TITLE_FIELD_NUMBER = 3;
    public static final int TOOLS_TYPE_FIELD_NUMBER = 8;
    private static final long serialVersionUID = 0;
    private volatile Object badgeText_;
    private int countdonwType_;
    private int countdown_;
    private volatile Object descIcon_;
    private int descType_;
    private volatile Object desc_;
    private volatile Object icon_;
    private byte memoizedIsInitialized;
    private int status_;
    private volatile Object title_;
    private int toolsType_;
    private static final LiveRoomToolsChange DEFAULT_INSTANCE = new LiveRoomToolsChange();
    private static final Parser<LiveRoomToolsChange> PARSER = new AbstractParser<LiveRoomToolsChange>() { // from class: cn.irisgw.live.LiveRoomToolsChange.1
        @Override // com.google.protobuf.Parser
        public LiveRoomToolsChange parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new LiveRoomToolsChange(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveRoomToolsChange$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LiveRoomToolsChangeOrBuilder {
        private Object badgeText_;
        private int countdonwType_;
        private int countdown_;
        private Object descIcon_;
        private int descType_;
        private Object desc_;
        private Object icon_;
        private int status_;
        private Object title_;
        private int toolsType_;

        private Builder() {
            this.badgeText_ = "";
            this.desc_ = "";
            this.title_ = "";
            this.icon_ = "";
            this.descIcon_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.badgeText_ = "";
            this.desc_ = "";
            this.title_ = "";
            this.icon_ = "";
            this.descIcon_ = "";
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_LiveRoomToolsChange_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = LiveRoomToolsChange.alwaysUseFieldBuilders;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public LiveRoomToolsChange build() {
            LiveRoomToolsChange buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public LiveRoomToolsChange buildPartial() {
            LiveRoomToolsChange liveRoomToolsChange = new LiveRoomToolsChange(this);
            liveRoomToolsChange.badgeText_ = this.badgeText_;
            liveRoomToolsChange.desc_ = this.desc_;
            liveRoomToolsChange.title_ = this.title_;
            liveRoomToolsChange.icon_ = this.icon_;
            liveRoomToolsChange.descIcon_ = this.descIcon_;
            liveRoomToolsChange.countdown_ = this.countdown_;
            liveRoomToolsChange.countdonwType_ = this.countdonwType_;
            liveRoomToolsChange.toolsType_ = this.toolsType_;
            liveRoomToolsChange.descType_ = this.descType_;
            liveRoomToolsChange.status_ = this.status_;
            onBuilt();
            return liveRoomToolsChange;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.badgeText_ = "";
            this.desc_ = "";
            this.title_ = "";
            this.icon_ = "";
            this.descIcon_ = "";
            this.countdown_ = 0;
            this.countdonwType_ = 0;
            this.toolsType_ = 0;
            this.descType_ = 0;
            this.status_ = 0;
            return this;
        }

        public Builder clearBadgeText() {
            this.badgeText_ = LiveRoomToolsChange.getDefaultInstance().getBadgeText();
            onChanged();
            return this;
        }

        public Builder clearCountdonwType() {
            this.countdonwType_ = 0;
            onChanged();
            return this;
        }

        public Builder clearCountdown() {
            this.countdown_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDesc() {
            this.desc_ = LiveRoomToolsChange.getDefaultInstance().getDesc();
            onChanged();
            return this;
        }

        public Builder clearDescIcon() {
            this.descIcon_ = LiveRoomToolsChange.getDefaultInstance().getDescIcon();
            onChanged();
            return this;
        }

        public Builder clearDescType() {
            this.descType_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearIcon() {
            this.icon_ = LiveRoomToolsChange.getDefaultInstance().getIcon();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearStatus() {
            this.status_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTitle() {
            this.title_ = LiveRoomToolsChange.getDefaultInstance().getTitle();
            onChanged();
            return this;
        }

        public Builder clearToolsType() {
            this.toolsType_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo1800clone() {
            return (Builder) super.mo1800clone();
        }

        @Override // cn.irisgw.live.LiveRoomToolsChangeOrBuilder
        public String getBadgeText() {
            Object obj = this.badgeText_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.badgeText_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LiveRoomToolsChangeOrBuilder
        public ByteString getBadgeTextBytes() {
            Object obj = this.badgeText_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.badgeText_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.LiveRoomToolsChangeOrBuilder
        public int getCountdonwType() {
            return this.countdonwType_;
        }

        @Override // cn.irisgw.live.LiveRoomToolsChangeOrBuilder
        public int getCountdown() {
            return this.countdown_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public LiveRoomToolsChange getDefaultInstanceForType() {
            return LiveRoomToolsChange.getDefaultInstance();
        }

        @Override // cn.irisgw.live.LiveRoomToolsChangeOrBuilder
        public String getDesc() {
            Object obj = this.desc_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.desc_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LiveRoomToolsChangeOrBuilder
        public ByteString getDescBytes() {
            Object obj = this.desc_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.desc_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.LiveRoomToolsChangeOrBuilder
        public String getDescIcon() {
            Object obj = this.descIcon_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.descIcon_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LiveRoomToolsChangeOrBuilder
        public ByteString getDescIconBytes() {
            Object obj = this.descIcon_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.descIcon_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.LiveRoomToolsChangeOrBuilder
        public int getDescType() {
            return this.descType_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_LiveRoomToolsChange_descriptor;
        }

        @Override // cn.irisgw.live.LiveRoomToolsChangeOrBuilder
        public String getIcon() {
            Object obj = this.icon_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.icon_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LiveRoomToolsChangeOrBuilder
        public ByteString getIconBytes() {
            Object obj = this.icon_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.icon_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.LiveRoomToolsChangeOrBuilder
        public int getStatus() {
            return this.status_;
        }

        @Override // cn.irisgw.live.LiveRoomToolsChangeOrBuilder
        public String getTitle() {
            Object obj = this.title_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.title_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LiveRoomToolsChangeOrBuilder
        public ByteString getTitleBytes() {
            Object obj = this.title_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.title_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.LiveRoomToolsChangeOrBuilder
        public int getToolsType() {
            return this.toolsType_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_LiveRoomToolsChange_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveRoomToolsChange.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(LiveRoomToolsChange liveRoomToolsChange) {
            if (liveRoomToolsChange == LiveRoomToolsChange.getDefaultInstance()) {
                return this;
            }
            if (!liveRoomToolsChange.getBadgeText().isEmpty()) {
                this.badgeText_ = liveRoomToolsChange.badgeText_;
                onChanged();
            }
            if (!liveRoomToolsChange.getDesc().isEmpty()) {
                this.desc_ = liveRoomToolsChange.desc_;
                onChanged();
            }
            if (!liveRoomToolsChange.getTitle().isEmpty()) {
                this.title_ = liveRoomToolsChange.title_;
                onChanged();
            }
            if (!liveRoomToolsChange.getIcon().isEmpty()) {
                this.icon_ = liveRoomToolsChange.icon_;
                onChanged();
            }
            if (!liveRoomToolsChange.getDescIcon().isEmpty()) {
                this.descIcon_ = liveRoomToolsChange.descIcon_;
                onChanged();
            }
            if (liveRoomToolsChange.getCountdown() != 0) {
                setCountdown(liveRoomToolsChange.getCountdown());
            }
            if (liveRoomToolsChange.getCountdonwType() != 0) {
                setCountdonwType(liveRoomToolsChange.getCountdonwType());
            }
            if (liveRoomToolsChange.getToolsType() != 0) {
                setToolsType(liveRoomToolsChange.getToolsType());
            }
            if (liveRoomToolsChange.getDescType() != 0) {
                setDescType(liveRoomToolsChange.getDescType());
            }
            if (liveRoomToolsChange.getStatus() != 0) {
                setStatus(liveRoomToolsChange.getStatus());
            }
            mergeUnknownFields(liveRoomToolsChange.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.LiveRoomToolsChange.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.LiveRoomToolsChange.access$1500()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.LiveRoomToolsChange r0 = (cn.irisgw.live.LiveRoomToolsChange) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.LiveRoomToolsChange$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.LiveRoomToolsChange r0 = (cn.irisgw.live.LiveRoomToolsChange) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.LiveRoomToolsChange$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.LiveRoomToolsChange.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.LiveRoomToolsChange$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof LiveRoomToolsChange) {
                return mergeFrom((LiveRoomToolsChange) message);
            }
            super.mergeFrom(message);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setBadgeText(String str) {
            if (str != null) {
                this.badgeText_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setBadgeTextBytes(ByteString byteString) {
            if (byteString != null) {
                LiveRoomToolsChange.checkByteStringIsUtf8(byteString);
                this.badgeText_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setCountdonwType(int i) {
            this.countdonwType_ = i;
            onChanged();
            return this;
        }

        public Builder setCountdown(int i) {
            this.countdown_ = i;
            onChanged();
            return this;
        }

        public Builder setDesc(String str) {
            if (str != null) {
                this.desc_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setDescBytes(ByteString byteString) {
            if (byteString != null) {
                LiveRoomToolsChange.checkByteStringIsUtf8(byteString);
                this.desc_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setDescIcon(String str) {
            if (str != null) {
                this.descIcon_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setDescIconBytes(ByteString byteString) {
            if (byteString != null) {
                LiveRoomToolsChange.checkByteStringIsUtf8(byteString);
                this.descIcon_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setDescType(int i) {
            this.descType_ = i;
            onChanged();
            return this;
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
                LiveRoomToolsChange.checkByteStringIsUtf8(byteString);
                this.icon_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setStatus(int i) {
            this.status_ = i;
            onChanged();
            return this;
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
                LiveRoomToolsChange.checkByteStringIsUtf8(byteString);
                this.title_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setToolsType(int i) {
            this.toolsType_ = i;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private LiveRoomToolsChange() {
        this.memoizedIsInitialized = (byte) -1;
        this.badgeText_ = "";
        this.desc_ = "";
        this.title_ = "";
        this.icon_ = "";
        this.descIcon_ = "";
    }

    private LiveRoomToolsChange(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                    switch (readTag) {
                        case 0:
                            break;
                        case 10:
                            this.badgeText_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 18:
                            this.desc_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 26:
                            this.title_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 34:
                            this.icon_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 42:
                            this.descIcon_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 48:
                            this.countdown_ = codedInputStream.readUInt32();
                            continue;
                        case 56:
                            this.countdonwType_ = codedInputStream.readUInt32();
                            continue;
                        case 64:
                            this.toolsType_ = codedInputStream.readUInt32();
                            continue;
                        case 72:
                            this.descType_ = codedInputStream.readUInt32();
                            continue;
                        case 80:
                            this.status_ = codedInputStream.readUInt32();
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
            } finally {
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
            }
        }
    }

    private LiveRoomToolsChange(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static LiveRoomToolsChange getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_LiveRoomToolsChange_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(LiveRoomToolsChange liveRoomToolsChange) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(liveRoomToolsChange);
    }

    public static LiveRoomToolsChange parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (LiveRoomToolsChange) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static LiveRoomToolsChange parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LiveRoomToolsChange) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LiveRoomToolsChange parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static LiveRoomToolsChange parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static LiveRoomToolsChange parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (LiveRoomToolsChange) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static LiveRoomToolsChange parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LiveRoomToolsChange) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static LiveRoomToolsChange parseFrom(InputStream inputStream) throws IOException {
        return (LiveRoomToolsChange) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static LiveRoomToolsChange parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LiveRoomToolsChange) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LiveRoomToolsChange parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static LiveRoomToolsChange parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static LiveRoomToolsChange parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static LiveRoomToolsChange parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<LiveRoomToolsChange> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LiveRoomToolsChange) {
            LiveRoomToolsChange liveRoomToolsChange = (LiveRoomToolsChange) obj;
            return getBadgeText().equals(liveRoomToolsChange.getBadgeText()) && getDesc().equals(liveRoomToolsChange.getDesc()) && getTitle().equals(liveRoomToolsChange.getTitle()) && getIcon().equals(liveRoomToolsChange.getIcon()) && getDescIcon().equals(liveRoomToolsChange.getDescIcon()) && getCountdown() == liveRoomToolsChange.getCountdown() && getCountdonwType() == liveRoomToolsChange.getCountdonwType() && getToolsType() == liveRoomToolsChange.getToolsType() && getDescType() == liveRoomToolsChange.getDescType() && getStatus() == liveRoomToolsChange.getStatus() && this.unknownFields.equals(liveRoomToolsChange.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.LiveRoomToolsChangeOrBuilder
    public String getBadgeText() {
        Object obj = this.badgeText_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.badgeText_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.LiveRoomToolsChangeOrBuilder
    public ByteString getBadgeTextBytes() {
        Object obj = this.badgeText_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.badgeText_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.LiveRoomToolsChangeOrBuilder
    public int getCountdonwType() {
        return this.countdonwType_;
    }

    @Override // cn.irisgw.live.LiveRoomToolsChangeOrBuilder
    public int getCountdown() {
        return this.countdown_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public LiveRoomToolsChange getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.LiveRoomToolsChangeOrBuilder
    public String getDesc() {
        Object obj = this.desc_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.desc_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.LiveRoomToolsChangeOrBuilder
    public ByteString getDescBytes() {
        Object obj = this.desc_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.desc_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.LiveRoomToolsChangeOrBuilder
    public String getDescIcon() {
        Object obj = this.descIcon_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.descIcon_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.LiveRoomToolsChangeOrBuilder
    public ByteString getDescIconBytes() {
        Object obj = this.descIcon_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.descIcon_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.LiveRoomToolsChangeOrBuilder
    public int getDescType() {
        return this.descType_;
    }

    @Override // cn.irisgw.live.LiveRoomToolsChangeOrBuilder
    public String getIcon() {
        Object obj = this.icon_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.icon_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.LiveRoomToolsChangeOrBuilder
    public ByteString getIconBytes() {
        Object obj = this.icon_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.icon_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<LiveRoomToolsChange> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (!getBadgeTextBytes().isEmpty()) {
            i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.badgeText_);
        }
        int i3 = i2;
        if (!getDescBytes().isEmpty()) {
            i3 = i2 + GeneratedMessageV3.computeStringSize(2, this.desc_);
        }
        int i4 = i3;
        if (!getTitleBytes().isEmpty()) {
            i4 = i3 + GeneratedMessageV3.computeStringSize(3, this.title_);
        }
        int i5 = i4;
        if (!getIconBytes().isEmpty()) {
            i5 = i4 + GeneratedMessageV3.computeStringSize(4, this.icon_);
        }
        int i6 = i5;
        if (!getDescIconBytes().isEmpty()) {
            i6 = i5 + GeneratedMessageV3.computeStringSize(5, this.descIcon_);
        }
        int i7 = this.countdown_;
        int i8 = i6;
        if (i7 != 0) {
            i8 = i6 + CodedOutputStream.computeUInt32Size(6, i7);
        }
        int i9 = this.countdonwType_;
        int i10 = i8;
        if (i9 != 0) {
            i10 = i8 + CodedOutputStream.computeUInt32Size(7, i9);
        }
        int i11 = this.toolsType_;
        int i12 = i10;
        if (i11 != 0) {
            i12 = i10 + CodedOutputStream.computeUInt32Size(8, i11);
        }
        int i13 = this.descType_;
        int i14 = i12;
        if (i13 != 0) {
            i14 = i12 + CodedOutputStream.computeUInt32Size(9, i13);
        }
        int i15 = this.status_;
        int i16 = i14;
        if (i15 != 0) {
            i16 = i14 + CodedOutputStream.computeUInt32Size(10, i15);
        }
        int serializedSize = i16 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.LiveRoomToolsChangeOrBuilder
    public int getStatus() {
        return this.status_;
    }

    @Override // cn.irisgw.live.LiveRoomToolsChangeOrBuilder
    public String getTitle() {
        Object obj = this.title_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.title_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.LiveRoomToolsChangeOrBuilder
    public ByteString getTitleBytes() {
        Object obj = this.title_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.title_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.LiveRoomToolsChangeOrBuilder
    public int getToolsType() {
        return this.toolsType_;
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
        int hashCode = ((((((((((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getBadgeText().hashCode()) * 37) + 2) * 53) + getDesc().hashCode()) * 37) + 3) * 53) + getTitle().hashCode()) * 37) + 4) * 53) + getIcon().hashCode()) * 37) + 5) * 53) + getDescIcon().hashCode()) * 37) + 6) * 53) + getCountdown()) * 37) + 7) * 53) + getCountdonwType()) * 37) + 8) * 53) + getToolsType()) * 37) + 9) * 53) + getDescType()) * 37) + 10) * 53) + getStatus()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_LiveRoomToolsChange_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveRoomToolsChange.class, Builder.class);
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
        return new LiveRoomToolsChange();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!getBadgeTextBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.badgeText_);
        }
        if (!getDescBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.desc_);
        }
        if (!getTitleBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 3, this.title_);
        }
        if (!getIconBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 4, this.icon_);
        }
        if (!getDescIconBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 5, this.descIcon_);
        }
        int i = this.countdown_;
        if (i != 0) {
            codedOutputStream.writeUInt32(6, i);
        }
        int i2 = this.countdonwType_;
        if (i2 != 0) {
            codedOutputStream.writeUInt32(7, i2);
        }
        int i3 = this.toolsType_;
        if (i3 != 0) {
            codedOutputStream.writeUInt32(8, i3);
        }
        int i4 = this.descType_;
        if (i4 != 0) {
            codedOutputStream.writeUInt32(9, i4);
        }
        int i5 = this.status_;
        if (i5 != 0) {
            codedOutputStream.writeUInt32(10, i5);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
