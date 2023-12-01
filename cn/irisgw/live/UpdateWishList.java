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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/UpdateWishList.class */
public final class UpdateWishList extends GeneratedMessageV3 implements UpdateWishListOrBuilder {
    private static final UpdateWishList DEFAULT_INSTANCE = new UpdateWishList();
    private static final Parser<UpdateWishList> PARSER = new AbstractParser<UpdateWishList>() { // from class: cn.irisgw.live.UpdateWishList.1
        /* renamed from: parsePartialFrom */
        public UpdateWishList m7785parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new UpdateWishList(codedInputStream, extensionRegistryLite);
        }
    };
    public static final int WISH_LIST_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private List<WishList> wishList_;

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/UpdateWishList$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements UpdateWishListOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilderV3<WishList, WishList.Builder, WishListOrBuilder> wishListBuilder_;
        private List<WishList> wishList_;

        private Builder() {
            this.wishList_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.wishList_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private void ensureWishListIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.wishList_ = new ArrayList(this.wishList_);
                this.bitField0_ |= 1;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_UpdateWishList_descriptor;
        }

        private RepeatedFieldBuilderV3<WishList, WishList.Builder, WishListOrBuilder> getWishListFieldBuilder() {
            if (this.wishListBuilder_ == null) {
                List<WishList> list = this.wishList_;
                boolean z = true;
                if ((this.bitField0_ & 1) == 0) {
                    z = false;
                }
                this.wishListBuilder_ = new RepeatedFieldBuilderV3<>(list, z, getParentForChildren(), isClean());
                this.wishList_ = null;
            }
            return this.wishListBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (UpdateWishList.alwaysUseFieldBuilders) {
                getWishListFieldBuilder();
            }
        }

        public Builder addAllWishList(Iterable<? extends WishList> iterable) {
            RepeatedFieldBuilderV3<WishList, WishList.Builder, WishListOrBuilder> repeatedFieldBuilderV3 = this.wishListBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensureWishListIsMutable();
            AbstractMessageLite.Builder.addAll(iterable, this.wishList_);
            onChanged();
            return this;
        }

        /* renamed from: addRepeatedField */
        public Builder m7787addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        public Builder addWishList(int i, WishList.Builder builder) {
            RepeatedFieldBuilderV3<WishList, WishList.Builder, WishListOrBuilder> repeatedFieldBuilderV3 = this.wishListBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.m7836build());
                return this;
            }
            ensureWishListIsMutable();
            this.wishList_.add(i, builder.m7836build());
            onChanged();
            return this;
        }

        public Builder addWishList(int i, WishList wishList) {
            RepeatedFieldBuilderV3<WishList, WishList.Builder, WishListOrBuilder> repeatedFieldBuilderV3 = this.wishListBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, wishList);
                return this;
            } else if (wishList != null) {
                ensureWishListIsMutable();
                this.wishList_.add(i, wishList);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addWishList(WishList.Builder builder) {
            RepeatedFieldBuilderV3<WishList, WishList.Builder, WishListOrBuilder> repeatedFieldBuilderV3 = this.wishListBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(builder.m7836build());
                return this;
            }
            ensureWishListIsMutable();
            this.wishList_.add(builder.m7836build());
            onChanged();
            return this;
        }

        public Builder addWishList(WishList wishList) {
            RepeatedFieldBuilderV3<WishList, WishList.Builder, WishListOrBuilder> repeatedFieldBuilderV3 = this.wishListBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(wishList);
                return this;
            } else if (wishList != null) {
                ensureWishListIsMutable();
                this.wishList_.add(wishList);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public WishList.Builder addWishListBuilder() {
            return getWishListFieldBuilder().addBuilder(WishList.getDefaultInstance());
        }

        public WishList.Builder addWishListBuilder(int i) {
            return getWishListFieldBuilder().addBuilder(i, WishList.getDefaultInstance());
        }

        /* renamed from: build */
        public UpdateWishList m7789build() {
            UpdateWishList m7791buildPartial = m7791buildPartial();
            if (m7791buildPartial.isInitialized()) {
                return m7791buildPartial;
            }
            throw newUninitializedMessageException(m7791buildPartial);
        }

        /* renamed from: buildPartial */
        public UpdateWishList m7791buildPartial() {
            UpdateWishList updateWishList = new UpdateWishList(this);
            int i = this.bitField0_;
            RepeatedFieldBuilderV3<WishList, WishList.Builder, WishListOrBuilder> repeatedFieldBuilderV3 = this.wishListBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((i & 1) != 0) {
                    this.wishList_ = Collections.unmodifiableList(this.wishList_);
                    this.bitField0_ &= -2;
                }
                updateWishList.wishList_ = this.wishList_;
            } else {
                updateWishList.wishList_ = repeatedFieldBuilderV3.build();
            }
            onBuilt();
            return updateWishList;
        }

        /* renamed from: clear */
        public Builder m7795clear() {
            super.clear();
            RepeatedFieldBuilderV3<WishList, WishList.Builder, WishListOrBuilder> repeatedFieldBuilderV3 = this.wishListBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.wishList_ = Collections.emptyList();
            this.bitField0_ &= -2;
            return this;
        }

        /* renamed from: clearField */
        public Builder m7797clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        /* renamed from: clearOneof */
        public Builder m7800clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearWishList() {
            RepeatedFieldBuilderV3<WishList, WishList.Builder, WishListOrBuilder> repeatedFieldBuilderV3 = this.wishListBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.wishList_ = Collections.emptyList();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m7806clone() {
            return (Builder) super.clone();
        }

        /* renamed from: getDefaultInstanceForType */
        public UpdateWishList m7808getDefaultInstanceForType() {
            return UpdateWishList.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_UpdateWishList_descriptor;
        }

        @Override // cn.irisgw.live.UpdateWishListOrBuilder
        public WishList getWishList(int i) {
            RepeatedFieldBuilderV3<WishList, WishList.Builder, WishListOrBuilder> repeatedFieldBuilderV3 = this.wishListBuilder_;
            return repeatedFieldBuilderV3 == null ? this.wishList_.get(i) : repeatedFieldBuilderV3.getMessage(i);
        }

        public WishList.Builder getWishListBuilder(int i) {
            return getWishListFieldBuilder().getBuilder(i);
        }

        public List<WishList.Builder> getWishListBuilderList() {
            return getWishListFieldBuilder().getBuilderList();
        }

        @Override // cn.irisgw.live.UpdateWishListOrBuilder
        public int getWishListCount() {
            RepeatedFieldBuilderV3<WishList, WishList.Builder, WishListOrBuilder> repeatedFieldBuilderV3 = this.wishListBuilder_;
            return repeatedFieldBuilderV3 == null ? this.wishList_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // cn.irisgw.live.UpdateWishListOrBuilder
        public List<WishList> getWishListList() {
            RepeatedFieldBuilderV3<WishList, WishList.Builder, WishListOrBuilder> repeatedFieldBuilderV3 = this.wishListBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.wishList_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // cn.irisgw.live.UpdateWishListOrBuilder
        public WishListOrBuilder getWishListOrBuilder(int i) {
            RepeatedFieldBuilderV3<WishList, WishList.Builder, WishListOrBuilder> repeatedFieldBuilderV3 = this.wishListBuilder_;
            return repeatedFieldBuilderV3 == null ? this.wishList_.get(i) : (WishListOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // cn.irisgw.live.UpdateWishListOrBuilder
        public List<? extends WishListOrBuilder> getWishListOrBuilderList() {
            RepeatedFieldBuilderV3<WishList, WishList.Builder, WishListOrBuilder> repeatedFieldBuilderV3 = this.wishListBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.wishList_);
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_UpdateWishList_fieldAccessorTable.ensureFieldAccessorsInitialized(UpdateWishList.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(UpdateWishList updateWishList) {
            if (updateWishList == UpdateWishList.getDefaultInstance()) {
                return this;
            }
            if (this.wishListBuilder_ == null) {
                if (!updateWishList.wishList_.isEmpty()) {
                    if (this.wishList_.isEmpty()) {
                        this.wishList_ = updateWishList.wishList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureWishListIsMutable();
                        this.wishList_.addAll(updateWishList.wishList_);
                    }
                    onChanged();
                }
            } else if (!updateWishList.wishList_.isEmpty()) {
                if (this.wishListBuilder_.isEmpty()) {
                    this.wishListBuilder_.dispose();
                    RepeatedFieldBuilderV3<WishList, WishList.Builder, WishListOrBuilder> repeatedFieldBuilderV3 = null;
                    this.wishListBuilder_ = null;
                    this.wishList_ = updateWishList.wishList_;
                    this.bitField0_ &= -2;
                    if (UpdateWishList.alwaysUseFieldBuilders) {
                        repeatedFieldBuilderV3 = getWishListFieldBuilder();
                    }
                    this.wishListBuilder_ = repeatedFieldBuilderV3;
                } else {
                    this.wishListBuilder_.addAllMessages(updateWishList.wishList_);
                }
            }
            m7817mergeUnknownFields(updateWishList.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.UpdateWishList.Builder m7814mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.UpdateWishList.access$2300()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.UpdateWishList r0 = (cn.irisgw.live.UpdateWishList) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.UpdateWishList$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.UpdateWishList r0 = (cn.irisgw.live.UpdateWishList) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.UpdateWishList$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.UpdateWishList.Builder.m7814mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.UpdateWishList$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m7813mergeFrom(Message message) {
            if (message instanceof UpdateWishList) {
                return mergeFrom((UpdateWishList) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m7817mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder removeWishList(int i) {
            RepeatedFieldBuilderV3<WishList, WishList.Builder, WishListOrBuilder> repeatedFieldBuilderV3 = this.wishListBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.remove(i);
                return this;
            }
            ensureWishListIsMutable();
            this.wishList_.remove(i);
            onChanged();
            return this;
        }

        /* renamed from: setField */
        public Builder m7819setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        /* renamed from: setRepeatedField */
        public Builder m7821setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        /* renamed from: setUnknownFields */
        public final Builder m7823setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }

        public Builder setWishList(int i, WishList.Builder builder) {
            RepeatedFieldBuilderV3<WishList, WishList.Builder, WishListOrBuilder> repeatedFieldBuilderV3 = this.wishListBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.m7836build());
                return this;
            }
            ensureWishListIsMutable();
            this.wishList_.set(i, builder.m7836build());
            onChanged();
            return this;
        }

        public Builder setWishList(int i, WishList wishList) {
            RepeatedFieldBuilderV3<WishList, WishList.Builder, WishListOrBuilder> repeatedFieldBuilderV3 = this.wishListBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, wishList);
                return this;
            } else if (wishList != null) {
                ensureWishListIsMutable();
                this.wishList_.set(i, wishList);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/UpdateWishList$WishList.class */
    public static final class WishList extends GeneratedMessageV3 implements WishListOrBuilder {
        public static final int COUNT_FIELD_NUMBER = 5;
        public static final int ID_FIELD_NUMBER = 1;
        public static final int NAME_FIELD_NUMBER = 4;
        public static final int PIC_FIELD_NUMBER = 3;
        public static final int PROGRESS_FIELD_NUMBER = 6;
        public static final int TYPE_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int count_;
        private int id_;
        private byte memoizedIsInitialized;
        private volatile Object name_;
        private volatile Object pic_;
        private int progress_;
        private volatile Object type_;
        private static final WishList DEFAULT_INSTANCE = new WishList();
        private static final Parser<WishList> PARSER = new AbstractParser<WishList>() { // from class: cn.irisgw.live.UpdateWishList.WishList.1
            /* renamed from: parsePartialFrom */
            public WishList m7832parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new WishList(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/UpdateWishList$WishList$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WishListOrBuilder {
            private int count_;
            private int id_;
            private Object name_;
            private Object pic_;
            private int progress_;
            private Object type_;

            private Builder() {
                this.type_ = "";
                this.pic_ = "";
                this.name_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.type_ = "";
                this.pic_ = "";
                this.name_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LiveConstants.internal_static_cn_irisgw_live_UpdateWishList_WishList_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = WishList.alwaysUseFieldBuilders;
            }

            /* renamed from: addRepeatedField */
            public Builder m7834addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: build */
            public WishList m7836build() {
                WishList m7838buildPartial = m7838buildPartial();
                if (m7838buildPartial.isInitialized()) {
                    return m7838buildPartial;
                }
                throw newUninitializedMessageException(m7838buildPartial);
            }

            /* renamed from: buildPartial */
            public WishList m7838buildPartial() {
                WishList wishList = new WishList(this);
                wishList.id_ = this.id_;
                wishList.type_ = this.type_;
                wishList.pic_ = this.pic_;
                wishList.name_ = this.name_;
                wishList.count_ = this.count_;
                wishList.progress_ = this.progress_;
                onBuilt();
                return wishList;
            }

            /* renamed from: clear */
            public Builder m7842clear() {
                super.clear();
                this.id_ = 0;
                this.type_ = "";
                this.pic_ = "";
                this.name_ = "";
                this.count_ = 0;
                this.progress_ = 0;
                return this;
            }

            public Builder clearCount() {
                this.count_ = 0;
                onChanged();
                return this;
            }

            /* renamed from: clearField */
            public Builder m7844clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearId() {
                this.id_ = 0;
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.name_ = WishList.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            /* renamed from: clearOneof */
            public Builder m7847clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearPic() {
                this.pic_ = WishList.getDefaultInstance().getPic();
                onChanged();
                return this;
            }

            public Builder clearProgress() {
                this.progress_ = 0;
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.type_ = WishList.getDefaultInstance().getType();
                onChanged();
                return this;
            }

            /* renamed from: clone */
            public Builder m7853clone() {
                return (Builder) super.clone();
            }

            @Override // cn.irisgw.live.UpdateWishList.WishListOrBuilder
            public int getCount() {
                return this.count_;
            }

            /* renamed from: getDefaultInstanceForType */
            public WishList m7855getDefaultInstanceForType() {
                return WishList.getDefaultInstance();
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return LiveConstants.internal_static_cn_irisgw_live_UpdateWishList_WishList_descriptor;
            }

            @Override // cn.irisgw.live.UpdateWishList.WishListOrBuilder
            public int getId() {
                return this.id_;
            }

            @Override // cn.irisgw.live.UpdateWishList.WishListOrBuilder
            public String getName() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.UpdateWishList.WishListOrBuilder
            public ByteString getNameBytes() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.name_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.UpdateWishList.WishListOrBuilder
            public String getPic() {
                Object obj = this.pic_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.pic_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.UpdateWishList.WishListOrBuilder
            public ByteString getPicBytes() {
                Object obj = this.pic_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.pic_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.UpdateWishList.WishListOrBuilder
            public int getProgress() {
                return this.progress_;
            }

            @Override // cn.irisgw.live.UpdateWishList.WishListOrBuilder
            public String getType() {
                Object obj = this.type_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.type_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.UpdateWishList.WishListOrBuilder
            public ByteString getTypeBytes() {
                Object obj = this.type_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.type_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveConstants.internal_static_cn_irisgw_live_UpdateWishList_WishList_fieldAccessorTable.ensureFieldAccessorsInitialized(WishList.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(WishList wishList) {
                if (wishList == WishList.getDefaultInstance()) {
                    return this;
                }
                if (wishList.getId() != 0) {
                    setId(wishList.getId());
                }
                if (!wishList.getType().isEmpty()) {
                    this.type_ = wishList.type_;
                    onChanged();
                }
                if (!wishList.getPic().isEmpty()) {
                    this.pic_ = wishList.pic_;
                    onChanged();
                }
                if (!wishList.getName().isEmpty()) {
                    this.name_ = wishList.name_;
                    onChanged();
                }
                if (wishList.getCount() != 0) {
                    setCount(wishList.getCount());
                }
                if (wishList.getProgress() != 0) {
                    setProgress(wishList.getProgress());
                }
                m7864mergeUnknownFields(wishList.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            /* renamed from: mergeFrom */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.UpdateWishList.WishList.Builder m7861mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.UpdateWishList.WishList.access$1100()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.UpdateWishList$WishList r0 = (cn.irisgw.live.UpdateWishList.WishList) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.UpdateWishList$WishList$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.UpdateWishList$WishList r0 = (cn.irisgw.live.UpdateWishList.WishList) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.UpdateWishList$WishList$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.UpdateWishList.WishList.Builder.m7861mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.UpdateWishList$WishList$Builder");
            }

            /* renamed from: mergeFrom */
            public Builder m7860mergeFrom(Message message) {
                if (message instanceof WishList) {
                    return mergeFrom((WishList) message);
                }
                super.mergeFrom(message);
                return this;
            }

            /* renamed from: mergeUnknownFields */
            public final Builder m7864mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder setCount(int i) {
                this.count_ = i;
                onChanged();
                return this;
            }

            /* renamed from: setField */
            public Builder m7866setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setId(int i) {
                this.id_ = i;
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
                    WishList.checkByteStringIsUtf8(byteString);
                    this.name_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setPic(String str) {
                if (str != null) {
                    this.pic_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setPicBytes(ByteString byteString) {
                if (byteString != null) {
                    WishList.checkByteStringIsUtf8(byteString);
                    this.pic_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setProgress(int i) {
                this.progress_ = i;
                onChanged();
                return this;
            }

            /* renamed from: setRepeatedField */
            public Builder m7868setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
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
                    WishList.checkByteStringIsUtf8(byteString);
                    this.type_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            /* renamed from: setUnknownFields */
            public final Builder m7870setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private WishList() {
            this.memoizedIsInitialized = (byte) -1;
            this.type_ = "";
            this.pic_ = "";
            this.name_ = "";
        }

        private WishList(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.type_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 26) {
                                this.pic_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 34) {
                                this.name_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 40) {
                                this.count_ = codedInputStream.readUInt32();
                            } else if (readTag == 48) {
                                this.progress_ = codedInputStream.readUInt32();
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

        private WishList(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static WishList getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_UpdateWishList_WishList_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m7831toBuilder();
        }

        public static Builder newBuilder(WishList wishList) {
            return DEFAULT_INSTANCE.m7831toBuilder().mergeFrom(wishList);
        }

        public static WishList parseDelimitedFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static WishList parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static WishList parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (WishList) PARSER.parseFrom(byteString);
        }

        public static WishList parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (WishList) PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static WishList parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static WishList parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static WishList parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static WishList parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static WishList parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (WishList) PARSER.parseFrom(byteBuffer);
        }

        public static WishList parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (WishList) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static WishList parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (WishList) PARSER.parseFrom(bArr);
        }

        public static WishList parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (WishList) PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<WishList> parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof WishList) {
                WishList wishList = (WishList) obj;
                return getId() == wishList.getId() && getType().equals(wishList.getType()) && getPic().equals(wishList.getPic()) && getName().equals(wishList.getName()) && getCount() == wishList.getCount() && getProgress() == wishList.getProgress() && this.unknownFields.equals(wishList.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // cn.irisgw.live.UpdateWishList.WishListOrBuilder
        public int getCount() {
            return this.count_;
        }

        /* renamed from: getDefaultInstanceForType */
        public WishList m7826getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // cn.irisgw.live.UpdateWishList.WishListOrBuilder
        public int getId() {
            return this.id_;
        }

        @Override // cn.irisgw.live.UpdateWishList.WishListOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.UpdateWishList.WishListOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Parser<WishList> getParserForType() {
            return PARSER;
        }

        @Override // cn.irisgw.live.UpdateWishList.WishListOrBuilder
        public String getPic() {
            Object obj = this.pic_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.pic_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.UpdateWishList.WishListOrBuilder
        public ByteString getPicBytes() {
            Object obj = this.pic_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.pic_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.UpdateWishList.WishListOrBuilder
        public int getProgress() {
            return this.progress_;
        }

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
            if (!getTypeBytes().isEmpty()) {
                i4 = i2 + GeneratedMessageV3.computeStringSize(2, this.type_);
            }
            int i5 = i4;
            if (!getPicBytes().isEmpty()) {
                i5 = i4 + GeneratedMessageV3.computeStringSize(3, this.pic_);
            }
            int i6 = i5;
            if (!getNameBytes().isEmpty()) {
                i6 = i5 + GeneratedMessageV3.computeStringSize(4, this.name_);
            }
            int i7 = this.count_;
            int i8 = i6;
            if (i7 != 0) {
                i8 = i6 + CodedOutputStream.computeUInt32Size(5, i7);
            }
            int i9 = this.progress_;
            int i10 = i8;
            if (i9 != 0) {
                i10 = i8 + CodedOutputStream.computeUInt32Size(6, i9);
            }
            int serializedSize = i10 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // cn.irisgw.live.UpdateWishList.WishListOrBuilder
        public String getType() {
            Object obj = this.type_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.type_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.UpdateWishList.WishListOrBuilder
        public ByteString getTypeBytes() {
            Object obj = this.type_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.type_ = copyFromUtf8;
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
            int hashCode = ((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getId()) * 37) + 2) * 53) + getType().hashCode()) * 37) + 3) * 53) + getPic().hashCode()) * 37) + 4) * 53) + getName().hashCode()) * 37) + 5) * 53) + getCount()) * 37) + 6) * 53) + getProgress()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_UpdateWishList_WishList_fieldAccessorTable.ensureFieldAccessorsInitialized(WishList.class, Builder.class);
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
        public Builder m7829newBuilderForType() {
            return newBuilder();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: newBuilderForType */
        public Builder m7828newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new WishList();
        }

        /* renamed from: toBuilder */
        public Builder m7831toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i = this.id_;
            if (i != 0) {
                codedOutputStream.writeUInt32(1, i);
            }
            if (!getTypeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.type_);
            }
            if (!getPicBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.pic_);
            }
            if (!getNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.name_);
            }
            int i2 = this.count_;
            if (i2 != 0) {
                codedOutputStream.writeUInt32(5, i2);
            }
            int i3 = this.progress_;
            if (i3 != 0) {
                codedOutputStream.writeUInt32(6, i3);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/UpdateWishList$WishListOrBuilder.class */
    public interface WishListOrBuilder extends MessageOrBuilder {
        int getCount();

        int getId();

        String getName();

        ByteString getNameBytes();

        String getPic();

        ByteString getPicBytes();

        int getProgress();

        String getType();

        ByteString getTypeBytes();
    }

    private UpdateWishList() {
        this.memoizedIsInitialized = (byte) -1;
        this.wishList_ = Collections.emptyList();
    }

    private UpdateWishList(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.wishList_ = new ArrayList();
                                z4 = z2 | true;
                            }
                            this.wishList_.add((WishList) codedInputStream.readMessage(WishList.parser(), extensionRegistryLite));
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
                    this.wishList_ = Collections.unmodifiableList(this.wishList_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                throw th;
            }
        }
        if (z2 & true) {
            this.wishList_ = Collections.unmodifiableList(this.wishList_);
        }
        this.unknownFields = newBuilder.build();
        makeExtensionsImmutable();
    }

    private UpdateWishList(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static UpdateWishList getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_UpdateWishList_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m7784toBuilder();
    }

    public static Builder newBuilder(UpdateWishList updateWishList) {
        return DEFAULT_INSTANCE.m7784toBuilder().mergeFrom(updateWishList);
    }

    public static UpdateWishList parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static UpdateWishList parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static UpdateWishList parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (UpdateWishList) PARSER.parseFrom(byteString);
    }

    public static UpdateWishList parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (UpdateWishList) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static UpdateWishList parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static UpdateWishList parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static UpdateWishList parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static UpdateWishList parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static UpdateWishList parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (UpdateWishList) PARSER.parseFrom(byteBuffer);
    }

    public static UpdateWishList parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (UpdateWishList) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static UpdateWishList parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (UpdateWishList) PARSER.parseFrom(bArr);
    }

    public static UpdateWishList parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (UpdateWishList) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<UpdateWishList> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof UpdateWishList) {
            UpdateWishList updateWishList = (UpdateWishList) obj;
            return getWishListList().equals(updateWishList.getWishListList()) && this.unknownFields.equals(updateWishList.unknownFields);
        }
        return super.equals(obj);
    }

    /* renamed from: getDefaultInstanceForType */
    public UpdateWishList m7779getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public Parser<UpdateWishList> getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.wishList_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(1, this.wishList_.get(i3));
        }
        int serializedSize = i2 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // cn.irisgw.live.UpdateWishListOrBuilder
    public WishList getWishList(int i) {
        return this.wishList_.get(i);
    }

    @Override // cn.irisgw.live.UpdateWishListOrBuilder
    public int getWishListCount() {
        return this.wishList_.size();
    }

    @Override // cn.irisgw.live.UpdateWishListOrBuilder
    public List<WishList> getWishListList() {
        return this.wishList_;
    }

    @Override // cn.irisgw.live.UpdateWishListOrBuilder
    public WishListOrBuilder getWishListOrBuilder(int i) {
        return this.wishList_.get(i);
    }

    @Override // cn.irisgw.live.UpdateWishListOrBuilder
    public List<? extends WishListOrBuilder> getWishListOrBuilderList() {
        return this.wishList_;
    }

    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = 779 + getDescriptor().hashCode();
        int i = hashCode;
        if (getWishListCount() > 0) {
            i = (((hashCode * 37) + 1) * 53) + getWishListList().hashCode();
        }
        int hashCode2 = (i * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_UpdateWishList_fieldAccessorTable.ensureFieldAccessorsInitialized(UpdateWishList.class, Builder.class);
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
    public Builder m7782newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m7781newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new UpdateWishList();
    }

    /* renamed from: toBuilder */
    public Builder m7784toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.wishList_.size()) {
                this.unknownFields.writeTo(codedOutputStream);
                return;
            } else {
                codedOutputStream.writeMessage(1, this.wishList_.get(i2));
                i = i2 + 1;
            }
        }
    }
}
