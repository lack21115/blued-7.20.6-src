package com.blued.das.superexpose;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: source-7206380-dex2jar.jar:com/blued/das/superexpose/SuperExposeProtos.class */
public final class SuperExposeProtos {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017SuperExposeProtos.proto\u0012\u0019com.blued.das.superexpose\"©\u0001\n\u0010SuperExposeProto\u0012/\n\u0005event\u0018\u0001 \u0001(\u000e2 .com.blued.das.superexpose.Event\u0012\n\n\u0002id\u0018\u0002 \u0001(\t\u0012\u0011\n\tbubble_id\u0018\u0003 \u0001(\u0003\u0012\u000e\n\u0006sku_id\u0018\u0004 \u0001(\t\u0012\u0013\n\u000bdiscount_id\u0018\u0005 \u0001(\t\u0012\u0010\n\bstrategy\u0018\u0006 \u0001(\u0005\u0012\u000e\n\u0006region\u0018\u0007 \u0001(\u0005*\u009c\u0003\n\u0005Event\u0012\u0011\n\rUNKNOWN_EVENT\u0010��\u0012'\n#AFTER_PUBLISH_PAGE_SUPER_EXPOSE_BUY\u0010\u0001\u0012%\n!PERSONAL_PAGE_HISTORY_BUBBLE_SHOW\u0010\u0002\u0012\u0018\n\u0014EXPOSE_BUY_PAGE_SHOW\u0010\u0003\u0012\u001d\n\u0019EXPOSE_BUY_PAGE_PAY_CLICK\u0010\u0004\u0012(\n$AFTER_PUBLISH_PAGE_SUPER_EXPOSE_SHOW\u0010\u0005\u0012!\n\u001dEXPOSE_FEED_PERSONAL_POP_SHOW\u0010\u0006\u0012\"\n\u001eEXPOSE_FEED_PERSONAL_POP_CLICK\u0010\u0007\u0012\u001f\n\u001bEXPOSE_FEED_DETAIL_POP_SHOW\u0010\b\u0012 \n\u001cEXPOSE_FEED_DETAIL_POP_CLICK\u0010\t\u0012\u001e\n\u001aSUPER_EXPOSE_BUY_PAGE_SHOW\u0010\n\u0012#\n\u001fSUPER_EXPOSE_BUY_PAGE_PAY_CLICK\u0010\u000bB\u000f¢\u0002\fSUPER_EXPOSEb\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_com_blued_das_superexpose_SuperExposeProto_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_superexpose_SuperExposeProto_fieldAccessorTable;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/superexpose/SuperExposeProtos$Event.class */
    public enum Event implements ProtocolMessageEnum {
        UNKNOWN_EVENT(0),
        AFTER_PUBLISH_PAGE_SUPER_EXPOSE_BUY(1),
        PERSONAL_PAGE_HISTORY_BUBBLE_SHOW(2),
        EXPOSE_BUY_PAGE_SHOW(3),
        EXPOSE_BUY_PAGE_PAY_CLICK(4),
        AFTER_PUBLISH_PAGE_SUPER_EXPOSE_SHOW(5),
        EXPOSE_FEED_PERSONAL_POP_SHOW(6),
        EXPOSE_FEED_PERSONAL_POP_CLICK(7),
        EXPOSE_FEED_DETAIL_POP_SHOW(8),
        EXPOSE_FEED_DETAIL_POP_CLICK(9),
        SUPER_EXPOSE_BUY_PAGE_SHOW(10),
        SUPER_EXPOSE_BUY_PAGE_PAY_CLICK(11),
        UNRECOGNIZED(-1);
        
        public static final int AFTER_PUBLISH_PAGE_SUPER_EXPOSE_BUY_VALUE = 1;
        public static final int AFTER_PUBLISH_PAGE_SUPER_EXPOSE_SHOW_VALUE = 5;
        public static final int EXPOSE_BUY_PAGE_PAY_CLICK_VALUE = 4;
        public static final int EXPOSE_BUY_PAGE_SHOW_VALUE = 3;
        public static final int EXPOSE_FEED_DETAIL_POP_CLICK_VALUE = 9;
        public static final int EXPOSE_FEED_DETAIL_POP_SHOW_VALUE = 8;
        public static final int EXPOSE_FEED_PERSONAL_POP_CLICK_VALUE = 7;
        public static final int EXPOSE_FEED_PERSONAL_POP_SHOW_VALUE = 6;
        public static final int PERSONAL_PAGE_HISTORY_BUBBLE_SHOW_VALUE = 2;
        public static final int SUPER_EXPOSE_BUY_PAGE_PAY_CLICK_VALUE = 11;
        public static final int SUPER_EXPOSE_BUY_PAGE_SHOW_VALUE = 10;
        public static final int UNKNOWN_EVENT_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<Event> internalValueMap = new Internal.EnumLiteMap<Event>() { // from class: com.blued.das.superexpose.SuperExposeProtos.Event.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public Event findValueByNumber(int i) {
                return Event.forNumber(i);
            }
        };
        private static final Event[] VALUES = values();

        Event(int i) {
            this.value = i;
        }

        public static Event forNumber(int i) {
            switch (i) {
                case 0:
                    return UNKNOWN_EVENT;
                case 1:
                    return AFTER_PUBLISH_PAGE_SUPER_EXPOSE_BUY;
                case 2:
                    return PERSONAL_PAGE_HISTORY_BUBBLE_SHOW;
                case 3:
                    return EXPOSE_BUY_PAGE_SHOW;
                case 4:
                    return EXPOSE_BUY_PAGE_PAY_CLICK;
                case 5:
                    return AFTER_PUBLISH_PAGE_SUPER_EXPOSE_SHOW;
                case 6:
                    return EXPOSE_FEED_PERSONAL_POP_SHOW;
                case 7:
                    return EXPOSE_FEED_PERSONAL_POP_CLICK;
                case 8:
                    return EXPOSE_FEED_DETAIL_POP_SHOW;
                case 9:
                    return EXPOSE_FEED_DETAIL_POP_CLICK;
                case 10:
                    return SUPER_EXPOSE_BUY_PAGE_SHOW;
                case 11:
                    return SUPER_EXPOSE_BUY_PAGE_PAY_CLICK;
                default:
                    return null;
            }
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return SuperExposeProtos.getDescriptor().getEnumTypes().get(0);
        }

        public static Internal.EnumLiteMap<Event> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static Event valueOf(int i) {
            return forNumber(i);
        }

        public static Event valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/superexpose/SuperExposeProtos$SuperExposeProto.class */
    public static final class SuperExposeProto extends GeneratedMessageV3 implements SuperExposeProtoOrBuilder {
        public static final int BUBBLE_ID_FIELD_NUMBER = 3;
        public static final int DISCOUNT_ID_FIELD_NUMBER = 5;
        public static final int EVENT_FIELD_NUMBER = 1;
        public static final int ID_FIELD_NUMBER = 2;
        public static final int REGION_FIELD_NUMBER = 7;
        public static final int SKU_ID_FIELD_NUMBER = 4;
        public static final int STRATEGY_FIELD_NUMBER = 6;
        private static final long serialVersionUID = 0;
        private long bubbleId_;
        private volatile Object discountId_;
        private int event_;
        private volatile Object id_;
        private byte memoizedIsInitialized;
        private int region_;
        private volatile Object skuId_;
        private int strategy_;
        private static final SuperExposeProto DEFAULT_INSTANCE = new SuperExposeProto();
        private static final Parser<SuperExposeProto> PARSER = new AbstractParser<SuperExposeProto>() { // from class: com.blued.das.superexpose.SuperExposeProtos.SuperExposeProto.1
            @Override // com.google.protobuf.Parser
            public SuperExposeProto parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new SuperExposeProto(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/das/superexpose/SuperExposeProtos$SuperExposeProto$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SuperExposeProtoOrBuilder {
            private long bubbleId_;
            private Object discountId_;
            private int event_;
            private Object id_;
            private int region_;
            private Object skuId_;
            private int strategy_;

            private Builder() {
                this.event_ = 0;
                this.id_ = "";
                this.skuId_ = "";
                this.discountId_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.event_ = 0;
                this.id_ = "";
                this.skuId_ = "";
                this.discountId_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return SuperExposeProtos.internal_static_com_blued_das_superexpose_SuperExposeProto_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = SuperExposeProto.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SuperExposeProto build() {
                SuperExposeProto buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SuperExposeProto buildPartial() {
                SuperExposeProto superExposeProto = new SuperExposeProto(this);
                superExposeProto.event_ = this.event_;
                superExposeProto.id_ = this.id_;
                superExposeProto.bubbleId_ = this.bubbleId_;
                superExposeProto.skuId_ = this.skuId_;
                superExposeProto.discountId_ = this.discountId_;
                superExposeProto.strategy_ = this.strategy_;
                superExposeProto.region_ = this.region_;
                onBuilt();
                return superExposeProto;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.event_ = 0;
                this.id_ = "";
                this.bubbleId_ = 0L;
                this.skuId_ = "";
                this.discountId_ = "";
                this.strategy_ = 0;
                this.region_ = 0;
                return this;
            }

            public Builder clearBubbleId() {
                this.bubbleId_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearDiscountId() {
                this.discountId_ = SuperExposeProto.getDefaultInstance().getDiscountId();
                onChanged();
                return this;
            }

            public Builder clearEvent() {
                this.event_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearId() {
                this.id_ = SuperExposeProto.getDefaultInstance().getId();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearRegion() {
                this.region_ = 0;
                onChanged();
                return this;
            }

            public Builder clearSkuId() {
                this.skuId_ = SuperExposeProto.getDefaultInstance().getSkuId();
                onChanged();
                return this;
            }

            public Builder clearStrategy() {
                this.strategy_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1800clone() {
                return (Builder) super.mo1800clone();
            }

            @Override // com.blued.das.superexpose.SuperExposeProtos.SuperExposeProtoOrBuilder
            public long getBubbleId() {
                return this.bubbleId_;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SuperExposeProto getDefaultInstanceForType() {
                return SuperExposeProto.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SuperExposeProtos.internal_static_com_blued_das_superexpose_SuperExposeProto_descriptor;
            }

            @Override // com.blued.das.superexpose.SuperExposeProtos.SuperExposeProtoOrBuilder
            public String getDiscountId() {
                Object obj = this.discountId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.discountId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.superexpose.SuperExposeProtos.SuperExposeProtoOrBuilder
            public ByteString getDiscountIdBytes() {
                Object obj = this.discountId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.discountId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.superexpose.SuperExposeProtos.SuperExposeProtoOrBuilder
            public Event getEvent() {
                Event valueOf = Event.valueOf(this.event_);
                Event event = valueOf;
                if (valueOf == null) {
                    event = Event.UNRECOGNIZED;
                }
                return event;
            }

            @Override // com.blued.das.superexpose.SuperExposeProtos.SuperExposeProtoOrBuilder
            public int getEventValue() {
                return this.event_;
            }

            @Override // com.blued.das.superexpose.SuperExposeProtos.SuperExposeProtoOrBuilder
            public String getId() {
                Object obj = this.id_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.id_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.superexpose.SuperExposeProtos.SuperExposeProtoOrBuilder
            public ByteString getIdBytes() {
                Object obj = this.id_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.id_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.superexpose.SuperExposeProtos.SuperExposeProtoOrBuilder
            public int getRegion() {
                return this.region_;
            }

            @Override // com.blued.das.superexpose.SuperExposeProtos.SuperExposeProtoOrBuilder
            public String getSkuId() {
                Object obj = this.skuId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.skuId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.superexpose.SuperExposeProtos.SuperExposeProtoOrBuilder
            public ByteString getSkuIdBytes() {
                Object obj = this.skuId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.skuId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.superexpose.SuperExposeProtos.SuperExposeProtoOrBuilder
            public int getStrategy() {
                return this.strategy_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SuperExposeProtos.internal_static_com_blued_das_superexpose_SuperExposeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(SuperExposeProto.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(SuperExposeProto superExposeProto) {
                if (superExposeProto == SuperExposeProto.getDefaultInstance()) {
                    return this;
                }
                if (superExposeProto.event_ != 0) {
                    setEventValue(superExposeProto.getEventValue());
                }
                if (!superExposeProto.getId().isEmpty()) {
                    this.id_ = superExposeProto.id_;
                    onChanged();
                }
                if (superExposeProto.getBubbleId() != 0) {
                    setBubbleId(superExposeProto.getBubbleId());
                }
                if (!superExposeProto.getSkuId().isEmpty()) {
                    this.skuId_ = superExposeProto.skuId_;
                    onChanged();
                }
                if (!superExposeProto.getDiscountId().isEmpty()) {
                    this.discountId_ = superExposeProto.discountId_;
                    onChanged();
                }
                if (superExposeProto.getStrategy() != 0) {
                    setStrategy(superExposeProto.getStrategy());
                }
                if (superExposeProto.getRegion() != 0) {
                    setRegion(superExposeProto.getRegion());
                }
                mergeUnknownFields(superExposeProto.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.das.superexpose.SuperExposeProtos.SuperExposeProto.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.das.superexpose.SuperExposeProtos.SuperExposeProto.access$1400()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.das.superexpose.SuperExposeProtos$SuperExposeProto r0 = (com.blued.das.superexpose.SuperExposeProtos.SuperExposeProto) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.das.superexpose.SuperExposeProtos$SuperExposeProto$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.das.superexpose.SuperExposeProtos$SuperExposeProto r0 = (com.blued.das.superexpose.SuperExposeProtos.SuperExposeProto) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.das.superexpose.SuperExposeProtos$SuperExposeProto$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.das.superexpose.SuperExposeProtos.SuperExposeProto.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.das.superexpose.SuperExposeProtos$SuperExposeProto$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof SuperExposeProto) {
                    return mergeFrom((SuperExposeProto) message);
                }
                super.mergeFrom(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder setBubbleId(long j) {
                this.bubbleId_ = j;
                onChanged();
                return this;
            }

            public Builder setDiscountId(String str) {
                if (str != null) {
                    this.discountId_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setDiscountIdBytes(ByteString byteString) {
                if (byteString != null) {
                    SuperExposeProto.checkByteStringIsUtf8(byteString);
                    this.discountId_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setEvent(Event event) {
                if (event != null) {
                    this.event_ = event.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setEventValue(int i) {
                this.event_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setId(String str) {
                if (str != null) {
                    this.id_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setIdBytes(ByteString byteString) {
                if (byteString != null) {
                    SuperExposeProto.checkByteStringIsUtf8(byteString);
                    this.id_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setRegion(int i) {
                this.region_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setSkuId(String str) {
                if (str != null) {
                    this.skuId_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setSkuIdBytes(ByteString byteString) {
                if (byteString != null) {
                    SuperExposeProto.checkByteStringIsUtf8(byteString);
                    this.skuId_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setStrategy(int i) {
                this.strategy_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private SuperExposeProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.event_ = 0;
            this.id_ = "";
            this.skuId_ = "";
            this.discountId_ = "";
        }

        private SuperExposeProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                if (readTag == 8) {
                                    this.event_ = codedInputStream.readEnum();
                                } else if (readTag == 18) {
                                    this.id_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 24) {
                                    this.bubbleId_ = codedInputStream.readInt64();
                                } else if (readTag == 34) {
                                    this.skuId_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 42) {
                                    this.discountId_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 48) {
                                    this.strategy_ = codedInputStream.readInt32();
                                } else if (readTag == 56) {
                                    this.region_ = codedInputStream.readInt32();
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

        private SuperExposeProto(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static SuperExposeProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SuperExposeProtos.internal_static_com_blued_das_superexpose_SuperExposeProto_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SuperExposeProto superExposeProto) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(superExposeProto);
        }

        public static SuperExposeProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SuperExposeProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static SuperExposeProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SuperExposeProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static SuperExposeProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static SuperExposeProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static SuperExposeProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SuperExposeProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static SuperExposeProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SuperExposeProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static SuperExposeProto parseFrom(InputStream inputStream) throws IOException {
            return (SuperExposeProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static SuperExposeProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SuperExposeProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static SuperExposeProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static SuperExposeProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static SuperExposeProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static SuperExposeProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<SuperExposeProto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof SuperExposeProto) {
                SuperExposeProto superExposeProto = (SuperExposeProto) obj;
                return this.event_ == superExposeProto.event_ && getId().equals(superExposeProto.getId()) && getBubbleId() == superExposeProto.getBubbleId() && getSkuId().equals(superExposeProto.getSkuId()) && getDiscountId().equals(superExposeProto.getDiscountId()) && getStrategy() == superExposeProto.getStrategy() && getRegion() == superExposeProto.getRegion() && this.unknownFields.equals(superExposeProto.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.blued.das.superexpose.SuperExposeProtos.SuperExposeProtoOrBuilder
        public long getBubbleId() {
            return this.bubbleId_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SuperExposeProto getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.das.superexpose.SuperExposeProtos.SuperExposeProtoOrBuilder
        public String getDiscountId() {
            Object obj = this.discountId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.discountId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.superexpose.SuperExposeProtos.SuperExposeProtoOrBuilder
        public ByteString getDiscountIdBytes() {
            Object obj = this.discountId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.discountId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.superexpose.SuperExposeProtos.SuperExposeProtoOrBuilder
        public Event getEvent() {
            Event valueOf = Event.valueOf(this.event_);
            Event event = valueOf;
            if (valueOf == null) {
                event = Event.UNRECOGNIZED;
            }
            return event;
        }

        @Override // com.blued.das.superexpose.SuperExposeProtos.SuperExposeProtoOrBuilder
        public int getEventValue() {
            return this.event_;
        }

        @Override // com.blued.das.superexpose.SuperExposeProtos.SuperExposeProtoOrBuilder
        public String getId() {
            Object obj = this.id_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.id_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.superexpose.SuperExposeProtos.SuperExposeProtoOrBuilder
        public ByteString getIdBytes() {
            Object obj = this.id_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.id_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SuperExposeProto> getParserForType() {
            return PARSER;
        }

        @Override // com.blued.das.superexpose.SuperExposeProtos.SuperExposeProtoOrBuilder
        public int getRegion() {
            return this.region_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (this.event_ != Event.UNKNOWN_EVENT.getNumber()) {
                i2 = 0 + CodedOutputStream.computeEnumSize(1, this.event_);
            }
            int i3 = i2;
            if (!getIdBytes().isEmpty()) {
                i3 = i2 + GeneratedMessageV3.computeStringSize(2, this.id_);
            }
            long j = this.bubbleId_;
            int i4 = i3;
            if (j != 0) {
                i4 = i3 + CodedOutputStream.computeInt64Size(3, j);
            }
            int i5 = i4;
            if (!getSkuIdBytes().isEmpty()) {
                i5 = i4 + GeneratedMessageV3.computeStringSize(4, this.skuId_);
            }
            int i6 = i5;
            if (!getDiscountIdBytes().isEmpty()) {
                i6 = i5 + GeneratedMessageV3.computeStringSize(5, this.discountId_);
            }
            int i7 = this.strategy_;
            int i8 = i6;
            if (i7 != 0) {
                i8 = i6 + CodedOutputStream.computeInt32Size(6, i7);
            }
            int i9 = this.region_;
            int i10 = i8;
            if (i9 != 0) {
                i10 = i8 + CodedOutputStream.computeInt32Size(7, i9);
            }
            int serializedSize = i10 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.blued.das.superexpose.SuperExposeProtos.SuperExposeProtoOrBuilder
        public String getSkuId() {
            Object obj = this.skuId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.skuId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.superexpose.SuperExposeProtos.SuperExposeProtoOrBuilder
        public ByteString getSkuIdBytes() {
            Object obj = this.skuId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.skuId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.superexpose.SuperExposeProtos.SuperExposeProtoOrBuilder
        public int getStrategy() {
            return this.strategy_;
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
            int hashCode = ((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.event_) * 37) + 2) * 53) + getId().hashCode()) * 37) + 3) * 53) + Internal.hashLong(getBubbleId())) * 37) + 4) * 53) + getSkuId().hashCode()) * 37) + 5) * 53) + getDiscountId().hashCode()) * 37) + 6) * 53) + getStrategy()) * 37) + 7) * 53) + getRegion()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SuperExposeProtos.internal_static_com_blued_das_superexpose_SuperExposeProto_fieldAccessorTable.ensureFieldAccessorsInitialized(SuperExposeProto.class, Builder.class);
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
            return new SuperExposeProto();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.event_ != Event.UNKNOWN_EVENT.getNumber()) {
                codedOutputStream.writeEnum(1, this.event_);
            }
            if (!getIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.id_);
            }
            long j = this.bubbleId_;
            if (j != 0) {
                codedOutputStream.writeInt64(3, j);
            }
            if (!getSkuIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.skuId_);
            }
            if (!getDiscountIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.discountId_);
            }
            int i = this.strategy_;
            if (i != 0) {
                codedOutputStream.writeInt32(6, i);
            }
            int i2 = this.region_;
            if (i2 != 0) {
                codedOutputStream.writeInt32(7, i2);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/superexpose/SuperExposeProtos$SuperExposeProtoOrBuilder.class */
    public interface SuperExposeProtoOrBuilder extends MessageOrBuilder {
        long getBubbleId();

        String getDiscountId();

        ByteString getDiscountIdBytes();

        Event getEvent();

        int getEventValue();

        String getId();

        ByteString getIdBytes();

        int getRegion();

        String getSkuId();

        ByteString getSkuIdBytes();

        int getStrategy();
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_blued_das_superexpose_SuperExposeProto_descriptor = descriptor2;
        internal_static_com_blued_das_superexpose_SuperExposeProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Event", "Id", "BubbleId", "SkuId", "DiscountId", "Strategy", "Region"});
    }

    private SuperExposeProtos() {
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
