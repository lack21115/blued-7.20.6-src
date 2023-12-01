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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ExpeditionPlanetDraw.class */
public final class ExpeditionPlanetDraw extends GeneratedMessageV3 implements ExpeditionPlanetDrawOrBuilder {
    public static final int BEANS_FIELD_NUMBER = 9;
    public static final int GOODS_INFO_FIELD_NUMBER = 11;
    public static final int IS_JOIN_FIELD_NUMBER = 6;
    public static final int IS_LUCKY_FIELD_NUMBER = 7;
    public static final int PLANET_ID_FIELD_NUMBER = 1;
    public static final int PLANET_IMAGE_FIELD_NUMBER = 3;
    public static final int PLANET_NAME_FIELD_NUMBER = 2;
    public static final int PLANET_NAME_IMAGE_FIELD_NUMBER = 4;
    public static final int RATE_FIELD_NUMBER = 5;
    public static final int REMAIN_TIME_FIELD_NUMBER = 10;
    public static final int SHIP_COUNT_FIELD_NUMBER = 8;
    private static final long serialVersionUID = 0;
    private int beans_;
    private List<Goods> goodsInfo_;
    private boolean isJoin_;
    private boolean isLucky_;
    private byte memoizedIsInitialized;
    private int planetId_;
    private volatile Object planetImage_;
    private volatile Object planetNameImage_;
    private volatile Object planetName_;
    private int rate_;
    private int remainTime_;
    private int shipCount_;
    private static final ExpeditionPlanetDraw DEFAULT_INSTANCE = new ExpeditionPlanetDraw();
    private static final Parser<ExpeditionPlanetDraw> PARSER = new AbstractParser<ExpeditionPlanetDraw>() { // from class: cn.irisgw.live.ExpeditionPlanetDraw.1
        @Override // com.google.protobuf.Parser
        public ExpeditionPlanetDraw parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new ExpeditionPlanetDraw(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ExpeditionPlanetDraw$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ExpeditionPlanetDrawOrBuilder {
        private int beans_;
        private int bitField0_;
        private RepeatedFieldBuilderV3<Goods, Goods.Builder, GoodsOrBuilder> goodsInfoBuilder_;
        private List<Goods> goodsInfo_;
        private boolean isJoin_;
        private boolean isLucky_;
        private int planetId_;
        private Object planetImage_;
        private Object planetNameImage_;
        private Object planetName_;
        private int rate_;
        private int remainTime_;
        private int shipCount_;

        private Builder() {
            this.planetName_ = "";
            this.planetImage_ = "";
            this.planetNameImage_ = "";
            this.goodsInfo_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.planetName_ = "";
            this.planetImage_ = "";
            this.planetNameImage_ = "";
            this.goodsInfo_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private void ensureGoodsInfoIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.goodsInfo_ = new ArrayList(this.goodsInfo_);
                this.bitField0_ |= 1;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_ExpeditionPlanetDraw_descriptor;
        }

        private RepeatedFieldBuilderV3<Goods, Goods.Builder, GoodsOrBuilder> getGoodsInfoFieldBuilder() {
            if (this.goodsInfoBuilder_ == null) {
                List<Goods> list = this.goodsInfo_;
                boolean z = true;
                if ((this.bitField0_ & 1) == 0) {
                    z = false;
                }
                this.goodsInfoBuilder_ = new RepeatedFieldBuilderV3<>(list, z, getParentForChildren(), isClean());
                this.goodsInfo_ = null;
            }
            return this.goodsInfoBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (ExpeditionPlanetDraw.alwaysUseFieldBuilders) {
                getGoodsInfoFieldBuilder();
            }
        }

        public Builder addAllGoodsInfo(Iterable<? extends Goods> iterable) {
            RepeatedFieldBuilderV3<Goods, Goods.Builder, GoodsOrBuilder> repeatedFieldBuilderV3 = this.goodsInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensureGoodsInfoIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.goodsInfo_);
            onChanged();
            return this;
        }

        public Builder addGoodsInfo(int i, Goods.Builder builder) {
            RepeatedFieldBuilderV3<Goods, Goods.Builder, GoodsOrBuilder> repeatedFieldBuilderV3 = this.goodsInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.build());
                return this;
            }
            ensureGoodsInfoIsMutable();
            this.goodsInfo_.add(i, builder.build());
            onChanged();
            return this;
        }

        public Builder addGoodsInfo(int i, Goods goods) {
            RepeatedFieldBuilderV3<Goods, Goods.Builder, GoodsOrBuilder> repeatedFieldBuilderV3 = this.goodsInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, goods);
                return this;
            } else if (goods != null) {
                ensureGoodsInfoIsMutable();
                this.goodsInfo_.add(i, goods);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addGoodsInfo(Goods.Builder builder) {
            RepeatedFieldBuilderV3<Goods, Goods.Builder, GoodsOrBuilder> repeatedFieldBuilderV3 = this.goodsInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(builder.build());
                return this;
            }
            ensureGoodsInfoIsMutable();
            this.goodsInfo_.add(builder.build());
            onChanged();
            return this;
        }

        public Builder addGoodsInfo(Goods goods) {
            RepeatedFieldBuilderV3<Goods, Goods.Builder, GoodsOrBuilder> repeatedFieldBuilderV3 = this.goodsInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(goods);
                return this;
            } else if (goods != null) {
                ensureGoodsInfoIsMutable();
                this.goodsInfo_.add(goods);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Goods.Builder addGoodsInfoBuilder() {
            return getGoodsInfoFieldBuilder().addBuilder(Goods.getDefaultInstance());
        }

        public Goods.Builder addGoodsInfoBuilder(int i) {
            return getGoodsInfoFieldBuilder().addBuilder(i, Goods.getDefaultInstance());
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ExpeditionPlanetDraw build() {
            ExpeditionPlanetDraw buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ExpeditionPlanetDraw buildPartial() {
            ExpeditionPlanetDraw expeditionPlanetDraw = new ExpeditionPlanetDraw(this);
            expeditionPlanetDraw.planetId_ = this.planetId_;
            expeditionPlanetDraw.planetName_ = this.planetName_;
            expeditionPlanetDraw.planetImage_ = this.planetImage_;
            expeditionPlanetDraw.planetNameImage_ = this.planetNameImage_;
            expeditionPlanetDraw.rate_ = this.rate_;
            expeditionPlanetDraw.isJoin_ = this.isJoin_;
            expeditionPlanetDraw.isLucky_ = this.isLucky_;
            expeditionPlanetDraw.shipCount_ = this.shipCount_;
            expeditionPlanetDraw.beans_ = this.beans_;
            expeditionPlanetDraw.remainTime_ = this.remainTime_;
            RepeatedFieldBuilderV3<Goods, Goods.Builder, GoodsOrBuilder> repeatedFieldBuilderV3 = this.goodsInfoBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.goodsInfo_ = Collections.unmodifiableList(this.goodsInfo_);
                    this.bitField0_ &= -2;
                }
                expeditionPlanetDraw.goodsInfo_ = this.goodsInfo_;
            } else {
                expeditionPlanetDraw.goodsInfo_ = repeatedFieldBuilderV3.build();
            }
            onBuilt();
            return expeditionPlanetDraw;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.planetId_ = 0;
            this.planetName_ = "";
            this.planetImage_ = "";
            this.planetNameImage_ = "";
            this.rate_ = 0;
            this.isJoin_ = false;
            this.isLucky_ = false;
            this.shipCount_ = 0;
            this.beans_ = 0;
            this.remainTime_ = 0;
            RepeatedFieldBuilderV3<Goods, Goods.Builder, GoodsOrBuilder> repeatedFieldBuilderV3 = this.goodsInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.goodsInfo_ = Collections.emptyList();
            this.bitField0_ &= -2;
            return this;
        }

        public Builder clearBeans() {
            this.beans_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearGoodsInfo() {
            RepeatedFieldBuilderV3<Goods, Goods.Builder, GoodsOrBuilder> repeatedFieldBuilderV3 = this.goodsInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.goodsInfo_ = Collections.emptyList();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder clearIsJoin() {
            this.isJoin_ = false;
            onChanged();
            return this;
        }

        public Builder clearIsLucky() {
            this.isLucky_ = false;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearPlanetId() {
            this.planetId_ = 0;
            onChanged();
            return this;
        }

        public Builder clearPlanetImage() {
            this.planetImage_ = ExpeditionPlanetDraw.getDefaultInstance().getPlanetImage();
            onChanged();
            return this;
        }

        public Builder clearPlanetName() {
            this.planetName_ = ExpeditionPlanetDraw.getDefaultInstance().getPlanetName();
            onChanged();
            return this;
        }

        public Builder clearPlanetNameImage() {
            this.planetNameImage_ = ExpeditionPlanetDraw.getDefaultInstance().getPlanetNameImage();
            onChanged();
            return this;
        }

        public Builder clearRate() {
            this.rate_ = 0;
            onChanged();
            return this;
        }

        public Builder clearRemainTime() {
            this.remainTime_ = 0;
            onChanged();
            return this;
        }

        public Builder clearShipCount() {
            this.shipCount_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo1800clone() {
            return (Builder) super.mo1800clone();
        }

        @Override // cn.irisgw.live.ExpeditionPlanetDrawOrBuilder
        public int getBeans() {
            return this.beans_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ExpeditionPlanetDraw getDefaultInstanceForType() {
            return ExpeditionPlanetDraw.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_ExpeditionPlanetDraw_descriptor;
        }

        @Override // cn.irisgw.live.ExpeditionPlanetDrawOrBuilder
        public Goods getGoodsInfo(int i) {
            RepeatedFieldBuilderV3<Goods, Goods.Builder, GoodsOrBuilder> repeatedFieldBuilderV3 = this.goodsInfoBuilder_;
            return repeatedFieldBuilderV3 == null ? this.goodsInfo_.get(i) : repeatedFieldBuilderV3.getMessage(i);
        }

        public Goods.Builder getGoodsInfoBuilder(int i) {
            return getGoodsInfoFieldBuilder().getBuilder(i);
        }

        public List<Goods.Builder> getGoodsInfoBuilderList() {
            return getGoodsInfoFieldBuilder().getBuilderList();
        }

        @Override // cn.irisgw.live.ExpeditionPlanetDrawOrBuilder
        public int getGoodsInfoCount() {
            RepeatedFieldBuilderV3<Goods, Goods.Builder, GoodsOrBuilder> repeatedFieldBuilderV3 = this.goodsInfoBuilder_;
            return repeatedFieldBuilderV3 == null ? this.goodsInfo_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // cn.irisgw.live.ExpeditionPlanetDrawOrBuilder
        public List<Goods> getGoodsInfoList() {
            RepeatedFieldBuilderV3<Goods, Goods.Builder, GoodsOrBuilder> repeatedFieldBuilderV3 = this.goodsInfoBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.goodsInfo_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // cn.irisgw.live.ExpeditionPlanetDrawOrBuilder
        public GoodsOrBuilder getGoodsInfoOrBuilder(int i) {
            RepeatedFieldBuilderV3<Goods, Goods.Builder, GoodsOrBuilder> repeatedFieldBuilderV3 = this.goodsInfoBuilder_;
            return repeatedFieldBuilderV3 == null ? this.goodsInfo_.get(i) : repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // cn.irisgw.live.ExpeditionPlanetDrawOrBuilder
        public List<? extends GoodsOrBuilder> getGoodsInfoOrBuilderList() {
            RepeatedFieldBuilderV3<Goods, Goods.Builder, GoodsOrBuilder> repeatedFieldBuilderV3 = this.goodsInfoBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.goodsInfo_);
        }

        @Override // cn.irisgw.live.ExpeditionPlanetDrawOrBuilder
        public boolean getIsJoin() {
            return this.isJoin_;
        }

        @Override // cn.irisgw.live.ExpeditionPlanetDrawOrBuilder
        public boolean getIsLucky() {
            return this.isLucky_;
        }

        @Override // cn.irisgw.live.ExpeditionPlanetDrawOrBuilder
        public int getPlanetId() {
            return this.planetId_;
        }

        @Override // cn.irisgw.live.ExpeditionPlanetDrawOrBuilder
        public String getPlanetImage() {
            Object obj = this.planetImage_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.planetImage_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.ExpeditionPlanetDrawOrBuilder
        public ByteString getPlanetImageBytes() {
            Object obj = this.planetImage_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.planetImage_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.ExpeditionPlanetDrawOrBuilder
        public String getPlanetName() {
            Object obj = this.planetName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.planetName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.ExpeditionPlanetDrawOrBuilder
        public ByteString getPlanetNameBytes() {
            Object obj = this.planetName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.planetName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.ExpeditionPlanetDrawOrBuilder
        public String getPlanetNameImage() {
            Object obj = this.planetNameImage_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.planetNameImage_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.ExpeditionPlanetDrawOrBuilder
        public ByteString getPlanetNameImageBytes() {
            Object obj = this.planetNameImage_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.planetNameImage_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.ExpeditionPlanetDrawOrBuilder
        public int getRate() {
            return this.rate_;
        }

        @Override // cn.irisgw.live.ExpeditionPlanetDrawOrBuilder
        public int getRemainTime() {
            return this.remainTime_;
        }

        @Override // cn.irisgw.live.ExpeditionPlanetDrawOrBuilder
        public int getShipCount() {
            return this.shipCount_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_ExpeditionPlanetDraw_fieldAccessorTable.ensureFieldAccessorsInitialized(ExpeditionPlanetDraw.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(ExpeditionPlanetDraw expeditionPlanetDraw) {
            if (expeditionPlanetDraw == ExpeditionPlanetDraw.getDefaultInstance()) {
                return this;
            }
            if (expeditionPlanetDraw.getPlanetId() != 0) {
                setPlanetId(expeditionPlanetDraw.getPlanetId());
            }
            if (!expeditionPlanetDraw.getPlanetName().isEmpty()) {
                this.planetName_ = expeditionPlanetDraw.planetName_;
                onChanged();
            }
            if (!expeditionPlanetDraw.getPlanetImage().isEmpty()) {
                this.planetImage_ = expeditionPlanetDraw.planetImage_;
                onChanged();
            }
            if (!expeditionPlanetDraw.getPlanetNameImage().isEmpty()) {
                this.planetNameImage_ = expeditionPlanetDraw.planetNameImage_;
                onChanged();
            }
            if (expeditionPlanetDraw.getRate() != 0) {
                setRate(expeditionPlanetDraw.getRate());
            }
            if (expeditionPlanetDraw.getIsJoin()) {
                setIsJoin(expeditionPlanetDraw.getIsJoin());
            }
            if (expeditionPlanetDraw.getIsLucky()) {
                setIsLucky(expeditionPlanetDraw.getIsLucky());
            }
            if (expeditionPlanetDraw.getShipCount() != 0) {
                setShipCount(expeditionPlanetDraw.getShipCount());
            }
            if (expeditionPlanetDraw.getBeans() != 0) {
                setBeans(expeditionPlanetDraw.getBeans());
            }
            if (expeditionPlanetDraw.getRemainTime() != 0) {
                setRemainTime(expeditionPlanetDraw.getRemainTime());
            }
            if (this.goodsInfoBuilder_ == null) {
                if (!expeditionPlanetDraw.goodsInfo_.isEmpty()) {
                    if (this.goodsInfo_.isEmpty()) {
                        this.goodsInfo_ = expeditionPlanetDraw.goodsInfo_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureGoodsInfoIsMutable();
                        this.goodsInfo_.addAll(expeditionPlanetDraw.goodsInfo_);
                    }
                    onChanged();
                }
            } else if (!expeditionPlanetDraw.goodsInfo_.isEmpty()) {
                if (this.goodsInfoBuilder_.isEmpty()) {
                    this.goodsInfoBuilder_.dispose();
                    RepeatedFieldBuilderV3<Goods, Goods.Builder, GoodsOrBuilder> repeatedFieldBuilderV3 = null;
                    this.goodsInfoBuilder_ = null;
                    this.goodsInfo_ = expeditionPlanetDraw.goodsInfo_;
                    this.bitField0_ &= -2;
                    if (ExpeditionPlanetDraw.alwaysUseFieldBuilders) {
                        repeatedFieldBuilderV3 = getGoodsInfoFieldBuilder();
                    }
                    this.goodsInfoBuilder_ = repeatedFieldBuilderV3;
                } else {
                    this.goodsInfoBuilder_.addAllMessages(expeditionPlanetDraw.goodsInfo_);
                }
            }
            mergeUnknownFields(expeditionPlanetDraw.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.ExpeditionPlanetDraw.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.ExpeditionPlanetDraw.access$3000()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.ExpeditionPlanetDraw r0 = (cn.irisgw.live.ExpeditionPlanetDraw) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.ExpeditionPlanetDraw$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.ExpeditionPlanetDraw r0 = (cn.irisgw.live.ExpeditionPlanetDraw) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.ExpeditionPlanetDraw$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.ExpeditionPlanetDraw.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.ExpeditionPlanetDraw$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof ExpeditionPlanetDraw) {
                return mergeFrom((ExpeditionPlanetDraw) message);
            }
            super.mergeFrom(message);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder removeGoodsInfo(int i) {
            RepeatedFieldBuilderV3<Goods, Goods.Builder, GoodsOrBuilder> repeatedFieldBuilderV3 = this.goodsInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.remove(i);
                return this;
            }
            ensureGoodsInfoIsMutable();
            this.goodsInfo_.remove(i);
            onChanged();
            return this;
        }

        public Builder setBeans(int i) {
            this.beans_ = i;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setGoodsInfo(int i, Goods.Builder builder) {
            RepeatedFieldBuilderV3<Goods, Goods.Builder, GoodsOrBuilder> repeatedFieldBuilderV3 = this.goodsInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.build());
                return this;
            }
            ensureGoodsInfoIsMutable();
            this.goodsInfo_.set(i, builder.build());
            onChanged();
            return this;
        }

        public Builder setGoodsInfo(int i, Goods goods) {
            RepeatedFieldBuilderV3<Goods, Goods.Builder, GoodsOrBuilder> repeatedFieldBuilderV3 = this.goodsInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, goods);
                return this;
            } else if (goods != null) {
                ensureGoodsInfoIsMutable();
                this.goodsInfo_.set(i, goods);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder setIsJoin(boolean z) {
            this.isJoin_ = z;
            onChanged();
            return this;
        }

        public Builder setIsLucky(boolean z) {
            this.isLucky_ = z;
            onChanged();
            return this;
        }

        public Builder setPlanetId(int i) {
            this.planetId_ = i;
            onChanged();
            return this;
        }

        public Builder setPlanetImage(String str) {
            if (str != null) {
                this.planetImage_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setPlanetImageBytes(ByteString byteString) {
            if (byteString != null) {
                ExpeditionPlanetDraw.checkByteStringIsUtf8(byteString);
                this.planetImage_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setPlanetName(String str) {
            if (str != null) {
                this.planetName_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setPlanetNameBytes(ByteString byteString) {
            if (byteString != null) {
                ExpeditionPlanetDraw.checkByteStringIsUtf8(byteString);
                this.planetName_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setPlanetNameImage(String str) {
            if (str != null) {
                this.planetNameImage_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setPlanetNameImageBytes(ByteString byteString) {
            if (byteString != null) {
                ExpeditionPlanetDraw.checkByteStringIsUtf8(byteString);
                this.planetNameImage_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setRate(int i) {
            this.rate_ = i;
            onChanged();
            return this;
        }

        public Builder setRemainTime(int i) {
            this.remainTime_ = i;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setShipCount(int i) {
            this.shipCount_ = i;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ExpeditionPlanetDraw$Goods.class */
    public static final class Goods extends GeneratedMessageV3 implements GoodsOrBuilder {
        public static final int COUNT_FIELD_NUMBER = 4;
        public static final int ID_FIELD_NUMBER = 1;
        public static final int IMAGE_FIELD_NUMBER = 3;
        public static final int NAME_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int count_;
        private int id_;
        private volatile Object image_;
        private byte memoizedIsInitialized;
        private volatile Object name_;
        private static final Goods DEFAULT_INSTANCE = new Goods();
        private static final Parser<Goods> PARSER = new AbstractParser<Goods>() { // from class: cn.irisgw.live.ExpeditionPlanetDraw.Goods.1
            @Override // com.google.protobuf.Parser
            public Goods parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Goods(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ExpeditionPlanetDraw$Goods$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GoodsOrBuilder {
            private int count_;
            private int id_;
            private Object image_;
            private Object name_;

            private Builder() {
                this.name_ = "";
                this.image_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.name_ = "";
                this.image_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LiveConstants.internal_static_cn_irisgw_live_ExpeditionPlanetDraw_Goods_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = Goods.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Goods build() {
                Goods buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Goods buildPartial() {
                Goods goods = new Goods(this);
                goods.id_ = this.id_;
                goods.name_ = this.name_;
                goods.image_ = this.image_;
                goods.count_ = this.count_;
                onBuilt();
                return goods;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.id_ = 0;
                this.name_ = "";
                this.image_ = "";
                this.count_ = 0;
                return this;
            }

            public Builder clearCount() {
                this.count_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearId() {
                this.id_ = 0;
                onChanged();
                return this;
            }

            public Builder clearImage() {
                this.image_ = Goods.getDefaultInstance().getImage();
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.name_ = Goods.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1800clone() {
                return (Builder) super.mo1800clone();
            }

            @Override // cn.irisgw.live.ExpeditionPlanetDraw.GoodsOrBuilder
            public int getCount() {
                return this.count_;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Goods getDefaultInstanceForType() {
                return Goods.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return LiveConstants.internal_static_cn_irisgw_live_ExpeditionPlanetDraw_Goods_descriptor;
            }

            @Override // cn.irisgw.live.ExpeditionPlanetDraw.GoodsOrBuilder
            public int getId() {
                return this.id_;
            }

            @Override // cn.irisgw.live.ExpeditionPlanetDraw.GoodsOrBuilder
            public String getImage() {
                Object obj = this.image_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.image_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.ExpeditionPlanetDraw.GoodsOrBuilder
            public ByteString getImageBytes() {
                Object obj = this.image_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.image_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.ExpeditionPlanetDraw.GoodsOrBuilder
            public String getName() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.ExpeditionPlanetDraw.GoodsOrBuilder
            public ByteString getNameBytes() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.name_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveConstants.internal_static_cn_irisgw_live_ExpeditionPlanetDraw_Goods_fieldAccessorTable.ensureFieldAccessorsInitialized(Goods.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(Goods goods) {
                if (goods == Goods.getDefaultInstance()) {
                    return this;
                }
                if (goods.getId() != 0) {
                    setId(goods.getId());
                }
                if (!goods.getName().isEmpty()) {
                    this.name_ = goods.name_;
                    onChanged();
                }
                if (!goods.getImage().isEmpty()) {
                    this.image_ = goods.image_;
                    onChanged();
                }
                if (goods.getCount() != 0) {
                    setCount(goods.getCount());
                }
                mergeUnknownFields(goods.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.ExpeditionPlanetDraw.Goods.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.ExpeditionPlanetDraw.Goods.access$900()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.ExpeditionPlanetDraw$Goods r0 = (cn.irisgw.live.ExpeditionPlanetDraw.Goods) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.ExpeditionPlanetDraw$Goods$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.ExpeditionPlanetDraw$Goods r0 = (cn.irisgw.live.ExpeditionPlanetDraw.Goods) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.ExpeditionPlanetDraw$Goods$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.ExpeditionPlanetDraw.Goods.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.ExpeditionPlanetDraw$Goods$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof Goods) {
                    return mergeFrom((Goods) message);
                }
                super.mergeFrom(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder setCount(int i) {
                this.count_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setId(int i) {
                this.id_ = i;
                onChanged();
                return this;
            }

            public Builder setImage(String str) {
                if (str != null) {
                    this.image_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setImageBytes(ByteString byteString) {
                if (byteString != null) {
                    Goods.checkByteStringIsUtf8(byteString);
                    this.image_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
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
                    Goods.checkByteStringIsUtf8(byteString);
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private Goods() {
            this.memoizedIsInitialized = (byte) -1;
            this.name_ = "";
            this.image_ = "";
        }

        private Goods(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.id_ = codedInputStream.readUInt32();
                            } else if (readTag == 18) {
                                this.name_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 26) {
                                this.image_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 32) {
                                this.count_ = codedInputStream.readUInt32();
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

        private Goods(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Goods getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_ExpeditionPlanetDraw_Goods_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Goods goods) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(goods);
        }

        public static Goods parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Goods) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Goods parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Goods) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Goods parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Goods parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Goods parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Goods) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Goods parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Goods) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static Goods parseFrom(InputStream inputStream) throws IOException {
            return (Goods) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Goods parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Goods) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Goods parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Goods parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Goods parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Goods parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<Goods> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Goods) {
                Goods goods = (Goods) obj;
                return getId() == goods.getId() && getName().equals(goods.getName()) && getImage().equals(goods.getImage()) && getCount() == goods.getCount() && this.unknownFields.equals(goods.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // cn.irisgw.live.ExpeditionPlanetDraw.GoodsOrBuilder
        public int getCount() {
            return this.count_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Goods getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // cn.irisgw.live.ExpeditionPlanetDraw.GoodsOrBuilder
        public int getId() {
            return this.id_;
        }

        @Override // cn.irisgw.live.ExpeditionPlanetDraw.GoodsOrBuilder
        public String getImage() {
            Object obj = this.image_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.image_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.ExpeditionPlanetDraw.GoodsOrBuilder
        public ByteString getImageBytes() {
            Object obj = this.image_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.image_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.ExpeditionPlanetDraw.GoodsOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.ExpeditionPlanetDraw.GoodsOrBuilder
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
        public Parser<Goods> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            int i3 = this.id_;
            if (i3 != 0) {
                i2 = 0 + CodedOutputStream.computeUInt32Size(1, i3);
            }
            int i4 = i2;
            if (!getNameBytes().isEmpty()) {
                i4 = i2 + GeneratedMessageV3.computeStringSize(2, this.name_);
            }
            int i5 = i4;
            if (!getImageBytes().isEmpty()) {
                i5 = i4 + GeneratedMessageV3.computeStringSize(3, this.image_);
            }
            int i6 = this.count_;
            int i7 = i5;
            if (i6 != 0) {
                i7 = i5 + CodedOutputStream.computeUInt32Size(4, i6);
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
            int hashCode = ((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getId()) * 37) + 2) * 53) + getName().hashCode()) * 37) + 3) * 53) + getImage().hashCode()) * 37) + 4) * 53) + getCount()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_ExpeditionPlanetDraw_Goods_fieldAccessorTable.ensureFieldAccessorsInitialized(Goods.class, Builder.class);
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
            return new Goods();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i = this.id_;
            if (i != 0) {
                codedOutputStream.writeUInt32(1, i);
            }
            if (!getNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.name_);
            }
            if (!getImageBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.image_);
            }
            int i2 = this.count_;
            if (i2 != 0) {
                codedOutputStream.writeUInt32(4, i2);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ExpeditionPlanetDraw$GoodsOrBuilder.class */
    public interface GoodsOrBuilder extends MessageOrBuilder {
        int getCount();

        int getId();

        String getImage();

        ByteString getImageBytes();

        String getName();

        ByteString getNameBytes();
    }

    private ExpeditionPlanetDraw() {
        this.memoizedIsInitialized = (byte) -1;
        this.planetName_ = "";
        this.planetImage_ = "";
        this.planetNameImage_ = "";
        this.goodsInfo_ = Collections.emptyList();
    }

    private ExpeditionPlanetDraw(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            this.planetId_ = codedInputStream.readUInt32();
                            continue;
                        case 18:
                            this.planetName_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 26:
                            this.planetImage_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 34:
                            this.planetNameImage_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 40:
                            this.rate_ = codedInputStream.readUInt32();
                            continue;
                        case 48:
                            this.isJoin_ = codedInputStream.readBool();
                            continue;
                        case 56:
                            this.isLucky_ = codedInputStream.readBool();
                            continue;
                        case 64:
                            this.shipCount_ = codedInputStream.readUInt32();
                            continue;
                        case 72:
                            this.beans_ = codedInputStream.readUInt32();
                            continue;
                        case 80:
                            this.remainTime_ = codedInputStream.readUInt32();
                            continue;
                        case 90:
                            boolean z4 = z2;
                            if (!(z2 & true)) {
                                this.goodsInfo_ = new ArrayList();
                                z4 = z2 | true;
                            }
                            this.goodsInfo_.add((Goods) codedInputStream.readMessage(Goods.parser(), extensionRegistryLite));
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
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                }
            } catch (Throwable th) {
                if (z3 & true) {
                    this.goodsInfo_ = Collections.unmodifiableList(this.goodsInfo_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                throw th;
            }
        }
        if (z2 & true) {
            this.goodsInfo_ = Collections.unmodifiableList(this.goodsInfo_);
        }
        this.unknownFields = newBuilder.build();
        makeExtensionsImmutable();
    }

    private ExpeditionPlanetDraw(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static ExpeditionPlanetDraw getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_ExpeditionPlanetDraw_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ExpeditionPlanetDraw expeditionPlanetDraw) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(expeditionPlanetDraw);
    }

    public static ExpeditionPlanetDraw parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ExpeditionPlanetDraw) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static ExpeditionPlanetDraw parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ExpeditionPlanetDraw) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ExpeditionPlanetDraw parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static ExpeditionPlanetDraw parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static ExpeditionPlanetDraw parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ExpeditionPlanetDraw) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static ExpeditionPlanetDraw parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ExpeditionPlanetDraw) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static ExpeditionPlanetDraw parseFrom(InputStream inputStream) throws IOException {
        return (ExpeditionPlanetDraw) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static ExpeditionPlanetDraw parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ExpeditionPlanetDraw) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ExpeditionPlanetDraw parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static ExpeditionPlanetDraw parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static ExpeditionPlanetDraw parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static ExpeditionPlanetDraw parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<ExpeditionPlanetDraw> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ExpeditionPlanetDraw) {
            ExpeditionPlanetDraw expeditionPlanetDraw = (ExpeditionPlanetDraw) obj;
            return getPlanetId() == expeditionPlanetDraw.getPlanetId() && getPlanetName().equals(expeditionPlanetDraw.getPlanetName()) && getPlanetImage().equals(expeditionPlanetDraw.getPlanetImage()) && getPlanetNameImage().equals(expeditionPlanetDraw.getPlanetNameImage()) && getRate() == expeditionPlanetDraw.getRate() && getIsJoin() == expeditionPlanetDraw.getIsJoin() && getIsLucky() == expeditionPlanetDraw.getIsLucky() && getShipCount() == expeditionPlanetDraw.getShipCount() && getBeans() == expeditionPlanetDraw.getBeans() && getRemainTime() == expeditionPlanetDraw.getRemainTime() && getGoodsInfoList().equals(expeditionPlanetDraw.getGoodsInfoList()) && this.unknownFields.equals(expeditionPlanetDraw.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.ExpeditionPlanetDrawOrBuilder
    public int getBeans() {
        return this.beans_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public ExpeditionPlanetDraw getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.ExpeditionPlanetDrawOrBuilder
    public Goods getGoodsInfo(int i) {
        return this.goodsInfo_.get(i);
    }

    @Override // cn.irisgw.live.ExpeditionPlanetDrawOrBuilder
    public int getGoodsInfoCount() {
        return this.goodsInfo_.size();
    }

    @Override // cn.irisgw.live.ExpeditionPlanetDrawOrBuilder
    public List<Goods> getGoodsInfoList() {
        return this.goodsInfo_;
    }

    @Override // cn.irisgw.live.ExpeditionPlanetDrawOrBuilder
    public GoodsOrBuilder getGoodsInfoOrBuilder(int i) {
        return this.goodsInfo_.get(i);
    }

    @Override // cn.irisgw.live.ExpeditionPlanetDrawOrBuilder
    public List<? extends GoodsOrBuilder> getGoodsInfoOrBuilderList() {
        return this.goodsInfo_;
    }

    @Override // cn.irisgw.live.ExpeditionPlanetDrawOrBuilder
    public boolean getIsJoin() {
        return this.isJoin_;
    }

    @Override // cn.irisgw.live.ExpeditionPlanetDrawOrBuilder
    public boolean getIsLucky() {
        return this.isLucky_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<ExpeditionPlanetDraw> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.ExpeditionPlanetDrawOrBuilder
    public int getPlanetId() {
        return this.planetId_;
    }

    @Override // cn.irisgw.live.ExpeditionPlanetDrawOrBuilder
    public String getPlanetImage() {
        Object obj = this.planetImage_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.planetImage_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.ExpeditionPlanetDrawOrBuilder
    public ByteString getPlanetImageBytes() {
        Object obj = this.planetImage_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.planetImage_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.ExpeditionPlanetDrawOrBuilder
    public String getPlanetName() {
        Object obj = this.planetName_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.planetName_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.ExpeditionPlanetDrawOrBuilder
    public ByteString getPlanetNameBytes() {
        Object obj = this.planetName_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.planetName_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.ExpeditionPlanetDrawOrBuilder
    public String getPlanetNameImage() {
        Object obj = this.planetNameImage_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.planetNameImage_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.ExpeditionPlanetDrawOrBuilder
    public ByteString getPlanetNameImageBytes() {
        Object obj = this.planetNameImage_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.planetNameImage_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.ExpeditionPlanetDrawOrBuilder
    public int getRate() {
        return this.rate_;
    }

    @Override // cn.irisgw.live.ExpeditionPlanetDrawOrBuilder
    public int getRemainTime() {
        return this.remainTime_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = this.planetId_;
        int computeUInt32Size = i2 != 0 ? CodedOutputStream.computeUInt32Size(1, i2) + 0 : 0;
        int i3 = computeUInt32Size;
        if (!getPlanetNameBytes().isEmpty()) {
            i3 = computeUInt32Size + GeneratedMessageV3.computeStringSize(2, this.planetName_);
        }
        int i4 = i3;
        if (!getPlanetImageBytes().isEmpty()) {
            i4 = i3 + GeneratedMessageV3.computeStringSize(3, this.planetImage_);
        }
        int i5 = i4;
        if (!getPlanetNameImageBytes().isEmpty()) {
            i5 = i4 + GeneratedMessageV3.computeStringSize(4, this.planetNameImage_);
        }
        int i6 = this.rate_;
        int i7 = i5;
        if (i6 != 0) {
            i7 = i5 + CodedOutputStream.computeUInt32Size(5, i6);
        }
        boolean z = this.isJoin_;
        int i8 = i7;
        if (z) {
            i8 = i7 + CodedOutputStream.computeBoolSize(6, z);
        }
        boolean z2 = this.isLucky_;
        int i9 = i8;
        if (z2) {
            i9 = i8 + CodedOutputStream.computeBoolSize(7, z2);
        }
        int i10 = this.shipCount_;
        int i11 = i9;
        if (i10 != 0) {
            i11 = i9 + CodedOutputStream.computeUInt32Size(8, i10);
        }
        int i12 = this.beans_;
        int i13 = i11;
        if (i12 != 0) {
            i13 = i11 + CodedOutputStream.computeUInt32Size(9, i12);
        }
        int i14 = this.remainTime_;
        int i15 = i13;
        int i16 = 0;
        if (i14 != 0) {
            i15 = i13 + CodedOutputStream.computeUInt32Size(10, i14);
            i16 = 0;
        }
        while (i16 < this.goodsInfo_.size()) {
            i15 += CodedOutputStream.computeMessageSize(11, this.goodsInfo_.get(i16));
            i16++;
        }
        int serializedSize = i15 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.ExpeditionPlanetDrawOrBuilder
    public int getShipCount() {
        return this.shipCount_;
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
        int hashCode = ((((((((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getPlanetId()) * 37) + 2) * 53) + getPlanetName().hashCode()) * 37) + 3) * 53) + getPlanetImage().hashCode()) * 37) + 4) * 53) + getPlanetNameImage().hashCode()) * 37) + 5) * 53) + getRate()) * 37) + 6) * 53) + Internal.hashBoolean(getIsJoin())) * 37) + 7) * 53) + Internal.hashBoolean(getIsLucky())) * 37) + 8) * 53) + getShipCount()) * 37) + 9) * 53) + getBeans()) * 37) + 10) * 53) + getRemainTime();
        int i = hashCode;
        if (getGoodsInfoCount() > 0) {
            i = (((hashCode * 37) + 11) * 53) + getGoodsInfoList().hashCode();
        }
        int hashCode2 = (i * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_ExpeditionPlanetDraw_fieldAccessorTable.ensureFieldAccessorsInitialized(ExpeditionPlanetDraw.class, Builder.class);
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
        return new ExpeditionPlanetDraw();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = this.planetId_;
        if (i != 0) {
            codedOutputStream.writeUInt32(1, i);
        }
        if (!getPlanetNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.planetName_);
        }
        if (!getPlanetImageBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 3, this.planetImage_);
        }
        if (!getPlanetNameImageBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 4, this.planetNameImage_);
        }
        int i2 = this.rate_;
        if (i2 != 0) {
            codedOutputStream.writeUInt32(5, i2);
        }
        boolean z = this.isJoin_;
        if (z) {
            codedOutputStream.writeBool(6, z);
        }
        boolean z2 = this.isLucky_;
        if (z2) {
            codedOutputStream.writeBool(7, z2);
        }
        int i3 = this.shipCount_;
        if (i3 != 0) {
            codedOutputStream.writeUInt32(8, i3);
        }
        int i4 = this.beans_;
        if (i4 != 0) {
            codedOutputStream.writeUInt32(9, i4);
        }
        int i5 = this.remainTime_;
        if (i5 != 0) {
            codedOutputStream.writeUInt32(10, i5);
        }
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= this.goodsInfo_.size()) {
                this.unknownFields.writeTo(codedOutputStream);
                return;
            } else {
                codedOutputStream.writeMessage(11, this.goodsInfo_.get(i7));
                i6 = i7 + 1;
            }
        }
    }
}
