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
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveRedPoint.class */
public final class LiveRedPoint extends GeneratedMessageV3 implements LiveRedPointOrBuilder {
    public static final int GOODS_PACK_POINT_INFO_FIELD_NUMBER = 2;
    public static final int POINT_INFO_FIELD_NUMBER = 1;
    public static final int RED_POINT_ACTION_FIELD_NUMBER = 6;
    public static final int RED_POINT_CANCEL_FIELD_NUMBER = 5;
    public static final int RED_POINT_TYPE_FIELD_NUMBER = 3;
    public static final int RED_POINT_WORD_FIELD_NUMBER = 4;
    private static final long serialVersionUID = 0;
    private volatile Object goodsPackPointInfo_;
    private byte memoizedIsInitialized;
    private volatile Object pointInfo_;
    private int redPointAction_;
    private boolean redPointCancel_;
    private int redPointType_;
    private volatile Object redPointWord_;
    private static final LiveRedPoint DEFAULT_INSTANCE = new LiveRedPoint();
    private static final Parser<LiveRedPoint> PARSER = new AbstractParser<LiveRedPoint>() { // from class: cn.irisgw.live.LiveRedPoint.1
        @Override // com.google.protobuf.Parser
        public LiveRedPoint parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new LiveRedPoint(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveRedPoint$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LiveRedPointOrBuilder {
        private Object goodsPackPointInfo_;
        private Object pointInfo_;
        private int redPointAction_;
        private boolean redPointCancel_;
        private int redPointType_;
        private Object redPointWord_;

        private Builder() {
            this.pointInfo_ = "";
            this.goodsPackPointInfo_ = "";
            this.redPointType_ = 0;
            this.redPointWord_ = "";
            this.redPointAction_ = 0;
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.pointInfo_ = "";
            this.goodsPackPointInfo_ = "";
            this.redPointType_ = 0;
            this.redPointWord_ = "";
            this.redPointAction_ = 0;
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_LiveRedPoint_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = LiveRedPoint.alwaysUseFieldBuilders;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public LiveRedPoint build() {
            LiveRedPoint buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public LiveRedPoint buildPartial() {
            LiveRedPoint liveRedPoint = new LiveRedPoint(this);
            liveRedPoint.pointInfo_ = this.pointInfo_;
            liveRedPoint.goodsPackPointInfo_ = this.goodsPackPointInfo_;
            liveRedPoint.redPointType_ = this.redPointType_;
            liveRedPoint.redPointWord_ = this.redPointWord_;
            liveRedPoint.redPointCancel_ = this.redPointCancel_;
            liveRedPoint.redPointAction_ = this.redPointAction_;
            onBuilt();
            return liveRedPoint;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.pointInfo_ = "";
            this.goodsPackPointInfo_ = "";
            this.redPointType_ = 0;
            this.redPointWord_ = "";
            this.redPointCancel_ = false;
            this.redPointAction_ = 0;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearGoodsPackPointInfo() {
            this.goodsPackPointInfo_ = LiveRedPoint.getDefaultInstance().getGoodsPackPointInfo();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearPointInfo() {
            this.pointInfo_ = LiveRedPoint.getDefaultInstance().getPointInfo();
            onChanged();
            return this;
        }

        public Builder clearRedPointAction() {
            this.redPointAction_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRedPointCancel() {
            this.redPointCancel_ = false;
            onChanged();
            return this;
        }

        public Builder clearRedPointType() {
            this.redPointType_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRedPointWord() {
            this.redPointWord_ = LiveRedPoint.getDefaultInstance().getRedPointWord();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo1800clone() {
            return (Builder) super.mo1800clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public LiveRedPoint getDefaultInstanceForType() {
            return LiveRedPoint.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_LiveRedPoint_descriptor;
        }

        @Override // cn.irisgw.live.LiveRedPointOrBuilder
        public String getGoodsPackPointInfo() {
            Object obj = this.goodsPackPointInfo_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.goodsPackPointInfo_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LiveRedPointOrBuilder
        public ByteString getGoodsPackPointInfoBytes() {
            Object obj = this.goodsPackPointInfo_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.goodsPackPointInfo_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.LiveRedPointOrBuilder
        public String getPointInfo() {
            Object obj = this.pointInfo_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.pointInfo_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LiveRedPointOrBuilder
        public ByteString getPointInfoBytes() {
            Object obj = this.pointInfo_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.pointInfo_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.LiveRedPointOrBuilder
        public PointAction getRedPointAction() {
            PointAction valueOf = PointAction.valueOf(this.redPointAction_);
            PointAction pointAction = valueOf;
            if (valueOf == null) {
                pointAction = PointAction.UNRECOGNIZED;
            }
            return pointAction;
        }

        @Override // cn.irisgw.live.LiveRedPointOrBuilder
        public int getRedPointActionValue() {
            return this.redPointAction_;
        }

        @Override // cn.irisgw.live.LiveRedPointOrBuilder
        public boolean getRedPointCancel() {
            return this.redPointCancel_;
        }

        @Override // cn.irisgw.live.LiveRedPointOrBuilder
        public PointType getRedPointType() {
            PointType valueOf = PointType.valueOf(this.redPointType_);
            PointType pointType = valueOf;
            if (valueOf == null) {
                pointType = PointType.UNRECOGNIZED;
            }
            return pointType;
        }

        @Override // cn.irisgw.live.LiveRedPointOrBuilder
        public int getRedPointTypeValue() {
            return this.redPointType_;
        }

        @Override // cn.irisgw.live.LiveRedPointOrBuilder
        public String getRedPointWord() {
            Object obj = this.redPointWord_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.redPointWord_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LiveRedPointOrBuilder
        public ByteString getRedPointWordBytes() {
            Object obj = this.redPointWord_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.redPointWord_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_LiveRedPoint_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveRedPoint.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(LiveRedPoint liveRedPoint) {
            if (liveRedPoint == LiveRedPoint.getDefaultInstance()) {
                return this;
            }
            if (!liveRedPoint.getPointInfo().isEmpty()) {
                this.pointInfo_ = liveRedPoint.pointInfo_;
                onChanged();
            }
            if (!liveRedPoint.getGoodsPackPointInfo().isEmpty()) {
                this.goodsPackPointInfo_ = liveRedPoint.goodsPackPointInfo_;
                onChanged();
            }
            if (liveRedPoint.redPointType_ != 0) {
                setRedPointTypeValue(liveRedPoint.getRedPointTypeValue());
            }
            if (!liveRedPoint.getRedPointWord().isEmpty()) {
                this.redPointWord_ = liveRedPoint.redPointWord_;
                onChanged();
            }
            if (liveRedPoint.getRedPointCancel()) {
                setRedPointCancel(liveRedPoint.getRedPointCancel());
            }
            if (liveRedPoint.redPointAction_ != 0) {
                setRedPointActionValue(liveRedPoint.getRedPointActionValue());
            }
            mergeUnknownFields(liveRedPoint.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.LiveRedPoint.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.LiveRedPoint.access$1100()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.LiveRedPoint r0 = (cn.irisgw.live.LiveRedPoint) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.LiveRedPoint$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.LiveRedPoint r0 = (cn.irisgw.live.LiveRedPoint) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.LiveRedPoint$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.LiveRedPoint.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.LiveRedPoint$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof LiveRedPoint) {
                return mergeFrom((LiveRedPoint) message);
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

        public Builder setGoodsPackPointInfo(String str) {
            if (str != null) {
                this.goodsPackPointInfo_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setGoodsPackPointInfoBytes(ByteString byteString) {
            if (byteString != null) {
                LiveRedPoint.checkByteStringIsUtf8(byteString);
                this.goodsPackPointInfo_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setPointInfo(String str) {
            if (str != null) {
                this.pointInfo_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setPointInfoBytes(ByteString byteString) {
            if (byteString != null) {
                LiveRedPoint.checkByteStringIsUtf8(byteString);
                this.pointInfo_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setRedPointAction(PointAction pointAction) {
            if (pointAction != null) {
                this.redPointAction_ = pointAction.getNumber();
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setRedPointActionValue(int i) {
            this.redPointAction_ = i;
            onChanged();
            return this;
        }

        public Builder setRedPointCancel(boolean z) {
            this.redPointCancel_ = z;
            onChanged();
            return this;
        }

        public Builder setRedPointType(PointType pointType) {
            if (pointType != null) {
                this.redPointType_ = pointType.getNumber();
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setRedPointTypeValue(int i) {
            this.redPointType_ = i;
            onChanged();
            return this;
        }

        public Builder setRedPointWord(String str) {
            if (str != null) {
                this.redPointWord_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setRedPointWordBytes(ByteString byteString) {
            if (byteString != null) {
                LiveRedPoint.checkByteStringIsUtf8(byteString);
                this.redPointWord_ = byteString;
                onChanged();
                return this;
            }
            throw null;
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

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveRedPoint$PointAction.class */
    public enum PointAction implements ProtocolMessageEnum {
        NONE_ACTION(0),
        SHOW(1),
        HIDE(2),
        UNRECOGNIZED(-1);
        
        public static final int HIDE_VALUE = 2;
        public static final int NONE_ACTION_VALUE = 0;
        public static final int SHOW_VALUE = 1;
        private final int value;
        private static final Internal.EnumLiteMap<PointAction> internalValueMap = new Internal.EnumLiteMap<PointAction>() { // from class: cn.irisgw.live.LiveRedPoint.PointAction.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public PointAction findValueByNumber(int i) {
                return PointAction.forNumber(i);
            }
        };
        private static final PointAction[] VALUES = values();

        PointAction(int i) {
            this.value = i;
        }

        public static PointAction forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return null;
                    }
                    return HIDE;
                }
                return SHOW;
            }
            return NONE_ACTION;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return LiveRedPoint.getDescriptor().getEnumTypes().get(1);
        }

        public static Internal.EnumLiteMap<PointAction> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static PointAction valueOf(int i) {
            return forNumber(i);
        }

        public static PointAction valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LiveRedPoint$PointType.class */
    public enum PointType implements ProtocolMessageEnum {
        NONE_TYPE(0),
        GOODS(1),
        RECHARGE(2),
        OTHERICON(3),
        UNRECOGNIZED(-1);
        
        public static final int GOODS_VALUE = 1;
        public static final int NONE_TYPE_VALUE = 0;
        public static final int OTHERICON_VALUE = 3;
        public static final int RECHARGE_VALUE = 2;
        private final int value;
        private static final Internal.EnumLiteMap<PointType> internalValueMap = new Internal.EnumLiteMap<PointType>() { // from class: cn.irisgw.live.LiveRedPoint.PointType.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public PointType findValueByNumber(int i) {
                return PointType.forNumber(i);
            }
        };
        private static final PointType[] VALUES = values();

        PointType(int i) {
            this.value = i;
        }

        public static PointType forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            return null;
                        }
                        return OTHERICON;
                    }
                    return RECHARGE;
                }
                return GOODS;
            }
            return NONE_TYPE;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return LiveRedPoint.getDescriptor().getEnumTypes().get(0);
        }

        public static Internal.EnumLiteMap<PointType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static PointType valueOf(int i) {
            return forNumber(i);
        }

        public static PointType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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

    private LiveRedPoint() {
        this.memoizedIsInitialized = (byte) -1;
        this.pointInfo_ = "";
        this.goodsPackPointInfo_ = "";
        this.redPointType_ = 0;
        this.redPointWord_ = "";
        this.redPointAction_ = 0;
    }

    private LiveRedPoint(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.pointInfo_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 18) {
                            this.goodsPackPointInfo_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 24) {
                            this.redPointType_ = codedInputStream.readEnum();
                        } else if (readTag == 34) {
                            this.redPointWord_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 40) {
                            this.redPointCancel_ = codedInputStream.readBool();
                        } else if (readTag == 48) {
                            this.redPointAction_ = codedInputStream.readEnum();
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

    private LiveRedPoint(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static LiveRedPoint getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_LiveRedPoint_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(LiveRedPoint liveRedPoint) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(liveRedPoint);
    }

    public static LiveRedPoint parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (LiveRedPoint) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static LiveRedPoint parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LiveRedPoint) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LiveRedPoint parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static LiveRedPoint parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static LiveRedPoint parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (LiveRedPoint) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static LiveRedPoint parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LiveRedPoint) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static LiveRedPoint parseFrom(InputStream inputStream) throws IOException {
        return (LiveRedPoint) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static LiveRedPoint parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LiveRedPoint) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LiveRedPoint parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static LiveRedPoint parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static LiveRedPoint parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static LiveRedPoint parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<LiveRedPoint> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LiveRedPoint) {
            LiveRedPoint liveRedPoint = (LiveRedPoint) obj;
            return getPointInfo().equals(liveRedPoint.getPointInfo()) && getGoodsPackPointInfo().equals(liveRedPoint.getGoodsPackPointInfo()) && this.redPointType_ == liveRedPoint.redPointType_ && getRedPointWord().equals(liveRedPoint.getRedPointWord()) && getRedPointCancel() == liveRedPoint.getRedPointCancel() && this.redPointAction_ == liveRedPoint.redPointAction_ && this.unknownFields.equals(liveRedPoint.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public LiveRedPoint getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.LiveRedPointOrBuilder
    public String getGoodsPackPointInfo() {
        Object obj = this.goodsPackPointInfo_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.goodsPackPointInfo_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.LiveRedPointOrBuilder
    public ByteString getGoodsPackPointInfoBytes() {
        Object obj = this.goodsPackPointInfo_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.goodsPackPointInfo_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<LiveRedPoint> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.LiveRedPointOrBuilder
    public String getPointInfo() {
        Object obj = this.pointInfo_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.pointInfo_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.LiveRedPointOrBuilder
    public ByteString getPointInfoBytes() {
        Object obj = this.pointInfo_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.pointInfo_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.LiveRedPointOrBuilder
    public PointAction getRedPointAction() {
        PointAction valueOf = PointAction.valueOf(this.redPointAction_);
        PointAction pointAction = valueOf;
        if (valueOf == null) {
            pointAction = PointAction.UNRECOGNIZED;
        }
        return pointAction;
    }

    @Override // cn.irisgw.live.LiveRedPointOrBuilder
    public int getRedPointActionValue() {
        return this.redPointAction_;
    }

    @Override // cn.irisgw.live.LiveRedPointOrBuilder
    public boolean getRedPointCancel() {
        return this.redPointCancel_;
    }

    @Override // cn.irisgw.live.LiveRedPointOrBuilder
    public PointType getRedPointType() {
        PointType valueOf = PointType.valueOf(this.redPointType_);
        PointType pointType = valueOf;
        if (valueOf == null) {
            pointType = PointType.UNRECOGNIZED;
        }
        return pointType;
    }

    @Override // cn.irisgw.live.LiveRedPointOrBuilder
    public int getRedPointTypeValue() {
        return this.redPointType_;
    }

    @Override // cn.irisgw.live.LiveRedPointOrBuilder
    public String getRedPointWord() {
        Object obj = this.redPointWord_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.redPointWord_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.LiveRedPointOrBuilder
    public ByteString getRedPointWordBytes() {
        Object obj = this.redPointWord_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.redPointWord_ = copyFromUtf8;
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
        int i2 = 0;
        if (!getPointInfoBytes().isEmpty()) {
            i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.pointInfo_);
        }
        int i3 = i2;
        if (!getGoodsPackPointInfoBytes().isEmpty()) {
            i3 = i2 + GeneratedMessageV3.computeStringSize(2, this.goodsPackPointInfo_);
        }
        int i4 = i3;
        if (this.redPointType_ != PointType.NONE_TYPE.getNumber()) {
            i4 = i3 + CodedOutputStream.computeEnumSize(3, this.redPointType_);
        }
        int i5 = i4;
        if (!getRedPointWordBytes().isEmpty()) {
            i5 = i4 + GeneratedMessageV3.computeStringSize(4, this.redPointWord_);
        }
        boolean z = this.redPointCancel_;
        int i6 = i5;
        if (z) {
            i6 = i5 + CodedOutputStream.computeBoolSize(5, z);
        }
        int i7 = i6;
        if (this.redPointAction_ != PointAction.NONE_ACTION.getNumber()) {
            i7 = i6 + CodedOutputStream.computeEnumSize(6, this.redPointAction_);
        }
        int serializedSize = i7 + this.unknownFields.getSerializedSize();
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
        int hashCode = ((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getPointInfo().hashCode()) * 37) + 2) * 53) + getGoodsPackPointInfo().hashCode()) * 37) + 3) * 53) + this.redPointType_) * 37) + 4) * 53) + getRedPointWord().hashCode()) * 37) + 5) * 53) + Internal.hashBoolean(getRedPointCancel())) * 37) + 6) * 53) + this.redPointAction_) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_LiveRedPoint_fieldAccessorTable.ensureFieldAccessorsInitialized(LiveRedPoint.class, Builder.class);
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
        return new LiveRedPoint();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!getPointInfoBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.pointInfo_);
        }
        if (!getGoodsPackPointInfoBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.goodsPackPointInfo_);
        }
        if (this.redPointType_ != PointType.NONE_TYPE.getNumber()) {
            codedOutputStream.writeEnum(3, this.redPointType_);
        }
        if (!getRedPointWordBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 4, this.redPointWord_);
        }
        boolean z = this.redPointCancel_;
        if (z) {
            codedOutputStream.writeBool(5, z);
        }
        if (this.redPointAction_ != PointAction.NONE_ACTION.getNumber()) {
            codedOutputStream.writeEnum(6, this.redPointAction_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
