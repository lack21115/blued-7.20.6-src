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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveRoomTips.class */
public final class LiveRoomTips extends GeneratedMessageV3 implements LiveRoomTipsOrBuilder {
    public static final int COLORS_FIELD_NUMBER = 10;
    public static final int COUNTDOWN_FIELD_NUMBER = 9;
    public static final int DIRECTION_FIELD_NUMBER = 8;
    public static final int ICON_FIELD_NUMBER = 2;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int LINK_FIELD_NUMBER = 5;
    public static final int LINK_TYPE_FIELD_NUMBER = 6;
    public static final int LOCATION_FIELD_NUMBER = 7;
    public static final int ORDER_FIELD_NUMBER = 4;
    public static final int TEXT_FIELD_NUMBER = 3;
    private static final long serialVersionUID = 0;
    private LazyStringList colors_;
    private int countdown_;
    private int direction_;
    private volatile Object icon_;
    private int id_;
    private int linkType_;
    private volatile Object link_;
    private int location_;
    private byte memoizedIsInitialized;
    private int order_;
    private volatile Object text_;
    private static final LiveRoomTips DEFAULT_INSTANCE = new LiveRoomTips();
    private static final Parser<LiveRoomTips> PARSER = new AbstractParser<LiveRoomTips>() { // from class: cn.irisgw.live.LiveRoomTips.1
        /* renamed from: parsePartialFrom */
        public LiveRoomTips m5095parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new LiveRoomTips(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveRoomTips$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LiveRoomTipsOrBuilder {
        private int bitField0_;
        private LazyStringList colors_;
        private int countdown_;
        private int direction_;
        private Object icon_;
        private int id_;
        private int linkType_;
        private Object link_;
        private int location_;
        private int order_;
        private Object text_;

        private Builder() {
            this.icon_ = "";
            this.text_ = "";
            this.link_ = "";
            this.colors_ = LazyStringArrayList.EMPTY;
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.icon_ = "";
            this.text_ = "";
            this.link_ = "";
            this.colors_ = LazyStringArrayList.EMPTY;
            maybeForceBuilderInitialization();
        }

        private void ensureColorsIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.colors_ = new LazyStringArrayList(this.colors_);
                this.bitField0_ |= 1;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_LiveRoomTips_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = LiveRoomTips.alwaysUseFieldBuilders;
        }

        public Builder addAllColors(Iterable<String> iterable) {
            ensureColorsIsMutable();
            AbstractMessageLite.Builder.addAll(iterable, this.colors_);
            onChanged();
            return this;
        }

        public Builder addColors(String str) {
            if (str != null) {
                ensureColorsIsMutable();
                this.colors_.add(str);
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder addColorsBytes(ByteString byteString) {
            if (byteString != null) {
                LiveRoomTips.checkByteStringIsUtf8(byteString);
                ensureColorsIsMutable();
                this.colors_.add(byteString);
                onChanged();
                return this;
            }
            throw null;
        }

        /* renamed from: addRepeatedField */
        public Builder m5097addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public LiveRoomTips m5099build() {
            LiveRoomTips m5101buildPartial = m5101buildPartial();
            if (m5101buildPartial.isInitialized()) {
                return m5101buildPartial;
            }
            throw newUninitializedMessageException(m5101buildPartial);
        }

        /* renamed from: buildPartial */
        public LiveRoomTips m5101buildPartial() {
            LiveRoomTips liveRoomTips = new LiveRoomTips(this);
            liveRoomTips.id_ = this.id_;
            liveRoomTips.icon_ = this.icon_;
            liveRoomTips.text_ = this.text_;
            liveRoomTips.order_ = this.order_;
            liveRoomTips.link_ = this.link_;
            liveRoomTips.linkType_ = this.linkType_;
            liveRoomTips.location_ = this.location_;
            liveRoomTips.direction_ = this.direction_;
            liveRoomTips.countdown_ = this.countdown_;
            if ((this.bitField0_ & 1) != 0) {
                this.colors_ = this.colors_.getUnmodifiableView();
                this.bitField0_ &= -2;
            }
            liveRoomTips.colors_ = this.colors_;
            onBuilt();
            return liveRoomTips;
        }

        /* renamed from: clear */
        public Builder m5105clear() {
            super.clear();
            this.id_ = 0;
            this.icon_ = "";
            this.text_ = "";
            this.order_ = 0;
            this.link_ = "";
            this.linkType_ = 0;
            this.location_ = 0;
            this.direction_ = 0;
            this.countdown_ = 0;
            this.colors_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -2;
            return this;
        }

        public Builder clearColors() {
            this.colors_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder clearCountdown() {
            this.countdown_ = 0;
            onChanged();
            return this;
        }

        public Builder clearDirection() {
            this.direction_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clearField */
        public Builder m5107clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearIcon() {
            this.icon_ = LiveRoomTips.getDefaultInstance().getIcon();
            onChanged();
            return this;
        }

        public Builder clearId() {
            this.id_ = 0;
            onChanged();
            return this;
        }

        public Builder clearLink() {
            this.link_ = LiveRoomTips.getDefaultInstance().getLink();
            onChanged();
            return this;
        }

        public Builder clearLinkType() {
            this.linkType_ = 0;
            onChanged();
            return this;
        }

        public Builder clearLocation() {
            this.location_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clearOneof */
        public Builder m5110clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearOrder() {
            this.order_ = 0;
            onChanged();
            return this;
        }

        public Builder clearText() {
            this.text_ = LiveRoomTips.getDefaultInstance().getText();
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m5116clone() {
            return (Builder) super.clone();
        }

        @Override // cn.irisgw.live.LiveRoomTipsOrBuilder
        public String getColors(int i) {
            return (String) this.colors_.get(i);
        }

        @Override // cn.irisgw.live.LiveRoomTipsOrBuilder
        public ByteString getColorsBytes(int i) {
            return this.colors_.getByteString(i);
        }

        @Override // cn.irisgw.live.LiveRoomTipsOrBuilder
        public int getColorsCount() {
            return this.colors_.size();
        }

        @Override // cn.irisgw.live.LiveRoomTipsOrBuilder
        /* renamed from: getColorsList */
        public ProtocolStringList mo5087getColorsList() {
            return this.colors_.getUnmodifiableView();
        }

        @Override // cn.irisgw.live.LiveRoomTipsOrBuilder
        public int getCountdown() {
            return this.countdown_;
        }

        /* renamed from: getDefaultInstanceForType */
        public LiveRoomTips m5118getDefaultInstanceForType() {
            return LiveRoomTips.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_LiveRoomTips_descriptor;
        }

        @Override // cn.irisgw.live.LiveRoomTipsOrBuilder
        public int getDirection() {
            return this.direction_;
        }

        @Override // cn.irisgw.live.LiveRoomTipsOrBuilder
        public String getIcon() {
            Object obj = this.icon_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.icon_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LiveRoomTipsOrBuilder
        public ByteString getIconBytes() {
            Object obj = this.icon_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.icon_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.LiveRoomTipsOrBuilder
        public int getId() {
            return this.id_;
        }

        @Override // cn.irisgw.live.LiveRoomTipsOrBuilder
        public String getLink() {
            Object obj = this.link_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.link_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LiveRoomTipsOrBuilder
        public ByteString getLinkBytes() {
            Object obj = this.link_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.link_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.LiveRoomTipsOrBuilder
        public int getLinkType() {
            return this.linkType_;
        }

        @Override // cn.irisgw.live.LiveRoomTipsOrBuilder
        public int getLocation() {
            return this.location_;
        }

        @Override // cn.irisgw.live.LiveRoomTipsOrBuilder
        public int getOrder() {
            return this.order_;
        }

        @Override // cn.irisgw.live.LiveRoomTipsOrBuilder
        public String getText() {
            Object obj = this.text_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.text_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LiveRoomTipsOrBuilder
        public ByteString getTextBytes() {
            Object obj = this.text_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.text_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_LiveRoomTips_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveRoomTips.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(LiveRoomTips liveRoomTips) {
            if (liveRoomTips == LiveRoomTips.getDefaultInstance()) {
                return this;
            }
            if (liveRoomTips.getId() != 0) {
                setId(liveRoomTips.getId());
            }
            if (!liveRoomTips.getIcon().isEmpty()) {
                this.icon_ = liveRoomTips.icon_;
                onChanged();
            }
            if (!liveRoomTips.getText().isEmpty()) {
                this.text_ = liveRoomTips.text_;
                onChanged();
            }
            if (liveRoomTips.getOrder() != 0) {
                setOrder(liveRoomTips.getOrder());
            }
            if (!liveRoomTips.getLink().isEmpty()) {
                this.link_ = liveRoomTips.link_;
                onChanged();
            }
            if (liveRoomTips.getLinkType() != 0) {
                setLinkType(liveRoomTips.getLinkType());
            }
            if (liveRoomTips.getLocation() != 0) {
                setLocation(liveRoomTips.getLocation());
            }
            if (liveRoomTips.getDirection() != 0) {
                setDirection(liveRoomTips.getDirection());
            }
            if (liveRoomTips.getCountdown() != 0) {
                setCountdown(liveRoomTips.getCountdown());
            }
            if (!liveRoomTips.colors_.isEmpty()) {
                if (this.colors_.isEmpty()) {
                    this.colors_ = liveRoomTips.colors_;
                    this.bitField0_ &= -2;
                } else {
                    ensureColorsIsMutable();
                    this.colors_.addAll(liveRoomTips.colors_);
                }
                onChanged();
            }
            m5127mergeUnknownFields(liveRoomTips.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.LiveRoomTips.Builder m5124mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.LiveRoomTips.access$1500()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.LiveRoomTips r0 = (cn.irisgw.live.LiveRoomTips) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.LiveRoomTips$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.LiveRoomTips r0 = (cn.irisgw.live.LiveRoomTips) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.LiveRoomTips$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.LiveRoomTips.Builder.m5124mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.LiveRoomTips$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m5123mergeFrom(Message message) {
            if (message instanceof LiveRoomTips) {
                return mergeFrom((LiveRoomTips) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m5127mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setColors(int i, String str) {
            if (str != null) {
                ensureColorsIsMutable();
                this.colors_.set(i, str);
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setCountdown(int i) {
            this.countdown_ = i;
            onChanged();
            return this;
        }

        public Builder setDirection(int i) {
            this.direction_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setField */
        public Builder m5129setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
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
                LiveRoomTips.checkByteStringIsUtf8(byteString);
                this.icon_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setId(int i) {
            this.id_ = i;
            onChanged();
            return this;
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
                LiveRoomTips.checkByteStringIsUtf8(byteString);
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

        public Builder setLocation(int i) {
            this.location_ = i;
            onChanged();
            return this;
        }

        public Builder setOrder(int i) {
            this.order_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setRepeatedField */
        public Builder m5131setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
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
                LiveRoomTips.checkByteStringIsUtf8(byteString);
                this.text_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        /* renamed from: setUnknownFields */
        public final Builder m5133setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private LiveRoomTips() {
        this.memoizedIsInitialized = (byte) -1;
        this.icon_ = "";
        this.text_ = "";
        this.link_ = "";
        this.colors_ = LazyStringArrayList.EMPTY;
    }

    private LiveRoomTips(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.id_ = codedInputStream.readInt32();
                            continue;
                        case 18:
                            this.icon_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 26:
                            this.text_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 32:
                            this.order_ = codedInputStream.readInt32();
                            continue;
                        case 42:
                            this.link_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 48:
                            this.linkType_ = codedInputStream.readInt32();
                            continue;
                        case 56:
                            this.location_ = codedInputStream.readInt32();
                            continue;
                        case 64:
                            this.direction_ = codedInputStream.readInt32();
                            continue;
                        case 72:
                            this.countdown_ = codedInputStream.readInt32();
                            continue;
                        case 82:
                            String readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                            boolean z4 = z2;
                            if (!(z2 & true)) {
                                this.colors_ = new LazyStringArrayList();
                                z4 = z2 | true;
                            }
                            this.colors_.add(readStringRequireUtf8);
                            z2 = z4;
                            continue;
                        default:
                            if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                break;
                            } else {
                                continue;
                            }
                    }
                    z = true;
                } catch (IOException e) {
                    throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.setUnfinishedMessage(this);
                }
            } catch (Throwable th) {
                if (z3 & true) {
                    this.colors_ = this.colors_.getUnmodifiableView();
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                throw th;
            }
        }
        if (z2 & true) {
            this.colors_ = this.colors_.getUnmodifiableView();
        }
        this.unknownFields = newBuilder.build();
        makeExtensionsImmutable();
    }

    private LiveRoomTips(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static LiveRoomTips getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_LiveRoomTips_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m5094toBuilder();
    }

    public static Builder newBuilder(LiveRoomTips liveRoomTips) {
        return DEFAULT_INSTANCE.m5094toBuilder().mergeFrom(liveRoomTips);
    }

    public static LiveRoomTips parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static LiveRoomTips parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LiveRoomTips parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (LiveRoomTips) PARSER.parseFrom(byteString);
    }

    public static LiveRoomTips parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LiveRoomTips) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static LiveRoomTips parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static LiveRoomTips parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static LiveRoomTips parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static LiveRoomTips parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LiveRoomTips parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (LiveRoomTips) PARSER.parseFrom(byteBuffer);
    }

    public static LiveRoomTips parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LiveRoomTips) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static LiveRoomTips parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (LiveRoomTips) PARSER.parseFrom(bArr);
    }

    public static LiveRoomTips parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LiveRoomTips) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<LiveRoomTips> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LiveRoomTips) {
            LiveRoomTips liveRoomTips = (LiveRoomTips) obj;
            return getId() == liveRoomTips.getId() && getIcon().equals(liveRoomTips.getIcon()) && getText().equals(liveRoomTips.getText()) && getOrder() == liveRoomTips.getOrder() && getLink().equals(liveRoomTips.getLink()) && getLinkType() == liveRoomTips.getLinkType() && getLocation() == liveRoomTips.getLocation() && getDirection() == liveRoomTips.getDirection() && getCountdown() == liveRoomTips.getCountdown() && mo5087getColorsList().equals(liveRoomTips.mo5087getColorsList()) && this.unknownFields.equals(liveRoomTips.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.LiveRoomTipsOrBuilder
    public String getColors(int i) {
        return (String) this.colors_.get(i);
    }

    @Override // cn.irisgw.live.LiveRoomTipsOrBuilder
    public ByteString getColorsBytes(int i) {
        return this.colors_.getByteString(i);
    }

    @Override // cn.irisgw.live.LiveRoomTipsOrBuilder
    public int getColorsCount() {
        return this.colors_.size();
    }

    @Override // cn.irisgw.live.LiveRoomTipsOrBuilder
    /* renamed from: getColorsList */
    public ProtocolStringList mo5087getColorsList() {
        return this.colors_;
    }

    @Override // cn.irisgw.live.LiveRoomTipsOrBuilder
    public int getCountdown() {
        return this.countdown_;
    }

    /* renamed from: getDefaultInstanceForType */
    public LiveRoomTips m5089getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.LiveRoomTipsOrBuilder
    public int getDirection() {
        return this.direction_;
    }

    @Override // cn.irisgw.live.LiveRoomTipsOrBuilder
    public String getIcon() {
        Object obj = this.icon_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.icon_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.LiveRoomTipsOrBuilder
    public ByteString getIconBytes() {
        Object obj = this.icon_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.icon_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.LiveRoomTipsOrBuilder
    public int getId() {
        return this.id_;
    }

    @Override // cn.irisgw.live.LiveRoomTipsOrBuilder
    public String getLink() {
        Object obj = this.link_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.link_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.LiveRoomTipsOrBuilder
    public ByteString getLinkBytes() {
        Object obj = this.link_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.link_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.LiveRoomTipsOrBuilder
    public int getLinkType() {
        return this.linkType_;
    }

    @Override // cn.irisgw.live.LiveRoomTipsOrBuilder
    public int getLocation() {
        return this.location_;
    }

    @Override // cn.irisgw.live.LiveRoomTipsOrBuilder
    public int getOrder() {
        return this.order_;
    }

    public Parser<LiveRoomTips> getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = this.id_;
        int computeInt32Size = i2 != 0 ? CodedOutputStream.computeInt32Size(1, i2) + 0 : 0;
        int i3 = computeInt32Size;
        if (!getIconBytes().isEmpty()) {
            i3 = computeInt32Size + GeneratedMessageV3.computeStringSize(2, this.icon_);
        }
        int i4 = i3;
        if (!getTextBytes().isEmpty()) {
            i4 = i3 + GeneratedMessageV3.computeStringSize(3, this.text_);
        }
        int i5 = this.order_;
        int i6 = i4;
        if (i5 != 0) {
            i6 = i4 + CodedOutputStream.computeInt32Size(4, i5);
        }
        int i7 = i6;
        if (!getLinkBytes().isEmpty()) {
            i7 = i6 + GeneratedMessageV3.computeStringSize(5, this.link_);
        }
        int i8 = this.linkType_;
        int i9 = i7;
        if (i8 != 0) {
            i9 = i7 + CodedOutputStream.computeInt32Size(6, i8);
        }
        int i10 = this.location_;
        int i11 = i9;
        if (i10 != 0) {
            i11 = i9 + CodedOutputStream.computeInt32Size(7, i10);
        }
        int i12 = this.direction_;
        int i13 = i11;
        if (i12 != 0) {
            i13 = i11 + CodedOutputStream.computeInt32Size(8, i12);
        }
        int i14 = this.countdown_;
        int i15 = i13;
        if (i14 != 0) {
            i15 = i13 + CodedOutputStream.computeInt32Size(9, i14);
        }
        int i16 = 0;
        int i17 = 0;
        while (true) {
            int i18 = i17;
            if (i18 >= this.colors_.size()) {
                int size = i15 + i16 + (mo5087getColorsList().size() * 1) + this.unknownFields.getSerializedSize();
                this.memoizedSize = size;
                return size;
            }
            i16 += computeStringSizeNoTag(this.colors_.getRaw(i18));
            i17 = i18 + 1;
        }
    }

    @Override // cn.irisgw.live.LiveRoomTipsOrBuilder
    public String getText() {
        Object obj = this.text_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.text_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.LiveRoomTipsOrBuilder
    public ByteString getTextBytes() {
        Object obj = this.text_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.text_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getId()) * 37) + 2) * 53) + getIcon().hashCode()) * 37) + 3) * 53) + getText().hashCode()) * 37) + 4) * 53) + getOrder()) * 37) + 5) * 53) + getLink().hashCode()) * 37) + 6) * 53) + getLinkType()) * 37) + 7) * 53) + getLocation()) * 37) + 8) * 53) + getDirection()) * 37) + 9) * 53) + getCountdown();
        int i = hashCode;
        if (getColorsCount() > 0) {
            i = (((hashCode * 37) + 10) * 53) + mo5087getColorsList().hashCode();
        }
        int hashCode2 = (i * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_LiveRoomTips_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveRoomTips.class, Builder.class);
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
    public Builder m5092newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m5091newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new LiveRoomTips();
    }

    /* renamed from: toBuilder */
    public Builder m5094toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.id_;
        if (i != 0) {
            codedOutputStream.writeInt32(1, i);
        }
        if (!getIconBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.icon_);
        }
        if (!getTextBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 3, this.text_);
        }
        int i2 = this.order_;
        if (i2 != 0) {
            codedOutputStream.writeInt32(4, i2);
        }
        if (!getLinkBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 5, this.link_);
        }
        int i3 = this.linkType_;
        if (i3 != 0) {
            codedOutputStream.writeInt32(6, i3);
        }
        int i4 = this.location_;
        if (i4 != 0) {
            codedOutputStream.writeInt32(7, i4);
        }
        int i5 = this.direction_;
        if (i5 != 0) {
            codedOutputStream.writeInt32(8, i5);
        }
        int i6 = this.countdown_;
        if (i6 != 0) {
            codedOutputStream.writeInt32(9, i6);
        }
        int i7 = 0;
        while (true) {
            int i8 = i7;
            if (i8 >= this.colors_.size()) {
                this.unknownFields.writeTo(codedOutputStream);
                return;
            } else {
                GeneratedMessageV3.writeString(codedOutputStream, 10, this.colors_.getRaw(i8));
                i7 = i8 + 1;
            }
        }
    }
}
