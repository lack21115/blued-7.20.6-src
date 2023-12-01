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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/SyncTopAudienceExtra.class */
public final class SyncTopAudienceExtra extends GeneratedMessageV3 implements SyncTopAudienceExtraOrBuilder {
    private static final SyncTopAudienceExtra DEFAULT_INSTANCE = new SyncTopAudienceExtra();
    private static final Parser<SyncTopAudienceExtra> PARSER = new AbstractParser<SyncTopAudienceExtra>() { // from class: cn.irisgw.live.SyncTopAudienceExtra.1
        /* renamed from: parsePartialFrom */
        public SyncTopAudienceExtra m7406parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new SyncTopAudienceExtra(codedInputStream, extensionRegistryLite);
        }
    };
    public static final int TOPS_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private List<TopAudience> tops_;

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/SyncTopAudienceExtra$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SyncTopAudienceExtraOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilderV3<TopAudience, TopAudience.Builder, TopAudienceOrBuilder> topsBuilder_;
        private List<TopAudience> tops_;

        private Builder() {
            this.tops_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.tops_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private void ensureTopsIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.tops_ = new ArrayList(this.tops_);
                this.bitField0_ |= 1;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_SyncTopAudienceExtra_descriptor;
        }

        private RepeatedFieldBuilderV3<TopAudience, TopAudience.Builder, TopAudienceOrBuilder> getTopsFieldBuilder() {
            if (this.topsBuilder_ == null) {
                List<TopAudience> list = this.tops_;
                boolean z = true;
                if ((this.bitField0_ & 1) == 0) {
                    z = false;
                }
                this.topsBuilder_ = new RepeatedFieldBuilderV3<>(list, z, getParentForChildren(), isClean());
                this.tops_ = null;
            }
            return this.topsBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (SyncTopAudienceExtra.alwaysUseFieldBuilders) {
                getTopsFieldBuilder();
            }
        }

        public Builder addAllTops(Iterable<? extends TopAudience> iterable) {
            RepeatedFieldBuilderV3<TopAudience, TopAudience.Builder, TopAudienceOrBuilder> repeatedFieldBuilderV3 = this.topsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensureTopsIsMutable();
            AbstractMessageLite.Builder.addAll(iterable, this.tops_);
            onChanged();
            return this;
        }

        /* renamed from: addRepeatedField */
        public Builder m7408addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        public Builder addTops(int i, TopAudience.Builder builder) {
            RepeatedFieldBuilderV3<TopAudience, TopAudience.Builder, TopAudienceOrBuilder> repeatedFieldBuilderV3 = this.topsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.m7457build());
                return this;
            }
            ensureTopsIsMutable();
            this.tops_.add(i, builder.m7457build());
            onChanged();
            return this;
        }

        public Builder addTops(int i, TopAudience topAudience) {
            RepeatedFieldBuilderV3<TopAudience, TopAudience.Builder, TopAudienceOrBuilder> repeatedFieldBuilderV3 = this.topsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, topAudience);
                return this;
            } else if (topAudience != null) {
                ensureTopsIsMutable();
                this.tops_.add(i, topAudience);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addTops(TopAudience.Builder builder) {
            RepeatedFieldBuilderV3<TopAudience, TopAudience.Builder, TopAudienceOrBuilder> repeatedFieldBuilderV3 = this.topsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(builder.m7457build());
                return this;
            }
            ensureTopsIsMutable();
            this.tops_.add(builder.m7457build());
            onChanged();
            return this;
        }

        public Builder addTops(TopAudience topAudience) {
            RepeatedFieldBuilderV3<TopAudience, TopAudience.Builder, TopAudienceOrBuilder> repeatedFieldBuilderV3 = this.topsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(topAudience);
                return this;
            } else if (topAudience != null) {
                ensureTopsIsMutable();
                this.tops_.add(topAudience);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public TopAudience.Builder addTopsBuilder() {
            return getTopsFieldBuilder().addBuilder(TopAudience.getDefaultInstance());
        }

        public TopAudience.Builder addTopsBuilder(int i) {
            return getTopsFieldBuilder().addBuilder(i, TopAudience.getDefaultInstance());
        }

        /* renamed from: build */
        public SyncTopAudienceExtra m7410build() {
            SyncTopAudienceExtra m7412buildPartial = m7412buildPartial();
            if (m7412buildPartial.isInitialized()) {
                return m7412buildPartial;
            }
            throw newUninitializedMessageException(m7412buildPartial);
        }

        /* renamed from: buildPartial */
        public SyncTopAudienceExtra m7412buildPartial() {
            SyncTopAudienceExtra syncTopAudienceExtra = new SyncTopAudienceExtra(this);
            int i = this.bitField0_;
            RepeatedFieldBuilderV3<TopAudience, TopAudience.Builder, TopAudienceOrBuilder> repeatedFieldBuilderV3 = this.topsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((i & 1) != 0) {
                    this.tops_ = Collections.unmodifiableList(this.tops_);
                    this.bitField0_ &= -2;
                }
                syncTopAudienceExtra.tops_ = this.tops_;
            } else {
                syncTopAudienceExtra.tops_ = repeatedFieldBuilderV3.build();
            }
            onBuilt();
            return syncTopAudienceExtra;
        }

        /* renamed from: clear */
        public Builder m7416clear() {
            super.clear();
            RepeatedFieldBuilderV3<TopAudience, TopAudience.Builder, TopAudienceOrBuilder> repeatedFieldBuilderV3 = this.topsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.tops_ = Collections.emptyList();
            this.bitField0_ &= -2;
            return this;
        }

        /* renamed from: clearField */
        public Builder m7418clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        /* renamed from: clearOneof */
        public Builder m7421clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearTops() {
            RepeatedFieldBuilderV3<TopAudience, TopAudience.Builder, TopAudienceOrBuilder> repeatedFieldBuilderV3 = this.topsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.tops_ = Collections.emptyList();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m7427clone() {
            return (Builder) super.clone();
        }

        /* renamed from: getDefaultInstanceForType */
        public SyncTopAudienceExtra m7429getDefaultInstanceForType() {
            return SyncTopAudienceExtra.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_SyncTopAudienceExtra_descriptor;
        }

        @Override // cn.irisgw.live.SyncTopAudienceExtraOrBuilder
        public TopAudience getTops(int i) {
            RepeatedFieldBuilderV3<TopAudience, TopAudience.Builder, TopAudienceOrBuilder> repeatedFieldBuilderV3 = this.topsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.tops_.get(i) : repeatedFieldBuilderV3.getMessage(i);
        }

        public TopAudience.Builder getTopsBuilder(int i) {
            return getTopsFieldBuilder().getBuilder(i);
        }

        public List<TopAudience.Builder> getTopsBuilderList() {
            return getTopsFieldBuilder().getBuilderList();
        }

        @Override // cn.irisgw.live.SyncTopAudienceExtraOrBuilder
        public int getTopsCount() {
            RepeatedFieldBuilderV3<TopAudience, TopAudience.Builder, TopAudienceOrBuilder> repeatedFieldBuilderV3 = this.topsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.tops_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // cn.irisgw.live.SyncTopAudienceExtraOrBuilder
        public List<TopAudience> getTopsList() {
            RepeatedFieldBuilderV3<TopAudience, TopAudience.Builder, TopAudienceOrBuilder> repeatedFieldBuilderV3 = this.topsBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.tops_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // cn.irisgw.live.SyncTopAudienceExtraOrBuilder
        public TopAudienceOrBuilder getTopsOrBuilder(int i) {
            RepeatedFieldBuilderV3<TopAudience, TopAudience.Builder, TopAudienceOrBuilder> repeatedFieldBuilderV3 = this.topsBuilder_;
            return repeatedFieldBuilderV3 == null ? this.tops_.get(i) : (TopAudienceOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // cn.irisgw.live.SyncTopAudienceExtraOrBuilder
        public List<? extends TopAudienceOrBuilder> getTopsOrBuilderList() {
            RepeatedFieldBuilderV3<TopAudience, TopAudience.Builder, TopAudienceOrBuilder> repeatedFieldBuilderV3 = this.topsBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.tops_);
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_SyncTopAudienceExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(SyncTopAudienceExtra.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(SyncTopAudienceExtra syncTopAudienceExtra) {
            if (syncTopAudienceExtra == SyncTopAudienceExtra.getDefaultInstance()) {
                return this;
            }
            if (this.topsBuilder_ == null) {
                if (!syncTopAudienceExtra.tops_.isEmpty()) {
                    if (this.tops_.isEmpty()) {
                        this.tops_ = syncTopAudienceExtra.tops_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureTopsIsMutable();
                        this.tops_.addAll(syncTopAudienceExtra.tops_);
                    }
                    onChanged();
                }
            } else if (!syncTopAudienceExtra.tops_.isEmpty()) {
                if (this.topsBuilder_.isEmpty()) {
                    this.topsBuilder_.dispose();
                    RepeatedFieldBuilderV3<TopAudience, TopAudience.Builder, TopAudienceOrBuilder> repeatedFieldBuilderV3 = null;
                    this.topsBuilder_ = null;
                    this.tops_ = syncTopAudienceExtra.tops_;
                    this.bitField0_ &= -2;
                    if (SyncTopAudienceExtra.alwaysUseFieldBuilders) {
                        repeatedFieldBuilderV3 = getTopsFieldBuilder();
                    }
                    this.topsBuilder_ = repeatedFieldBuilderV3;
                } else {
                    this.topsBuilder_.addAllMessages(syncTopAudienceExtra.tops_);
                }
            }
            m7438mergeUnknownFields(syncTopAudienceExtra.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.SyncTopAudienceExtra.Builder m7435mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.SyncTopAudienceExtra.access$3500()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.SyncTopAudienceExtra r0 = (cn.irisgw.live.SyncTopAudienceExtra) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.SyncTopAudienceExtra$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.SyncTopAudienceExtra r0 = (cn.irisgw.live.SyncTopAudienceExtra) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.SyncTopAudienceExtra$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.SyncTopAudienceExtra.Builder.m7435mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.SyncTopAudienceExtra$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m7434mergeFrom(Message message) {
            if (message instanceof SyncTopAudienceExtra) {
                return mergeFrom((SyncTopAudienceExtra) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m7438mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder removeTops(int i) {
            RepeatedFieldBuilderV3<TopAudience, TopAudience.Builder, TopAudienceOrBuilder> repeatedFieldBuilderV3 = this.topsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.remove(i);
                return this;
            }
            ensureTopsIsMutable();
            this.tops_.remove(i);
            onChanged();
            return this;
        }

        /* renamed from: setField */
        public Builder m7440setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        /* renamed from: setRepeatedField */
        public Builder m7442setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setTops(int i, TopAudience.Builder builder) {
            RepeatedFieldBuilderV3<TopAudience, TopAudience.Builder, TopAudienceOrBuilder> repeatedFieldBuilderV3 = this.topsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.m7457build());
                return this;
            }
            ensureTopsIsMutable();
            this.tops_.set(i, builder.m7457build());
            onChanged();
            return this;
        }

        public Builder setTops(int i, TopAudience topAudience) {
            RepeatedFieldBuilderV3<TopAudience, TopAudience.Builder, TopAudienceOrBuilder> repeatedFieldBuilderV3 = this.topsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, topAudience);
                return this;
            } else if (topAudience != null) {
                ensureTopsIsMutable();
                this.tops_.set(i, topAudience);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        /* renamed from: setUnknownFields */
        public final Builder m7444setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/SyncTopAudienceExtra$TopAudience.class */
    public static final class TopAudience extends GeneratedMessageV3 implements TopAudienceOrBuilder {
        public static final int AVATAR_FIELD_NUMBER = 2;
        public static final int AVATAR_FRAME_FIELD_NUMBER = 7;
        public static final int AVATAR_FRAME_TYPE_FIELD_NUMBER = 8;
        public static final int LIANG_ID_FIELD_NUMBER = 5;
        public static final int LIANG_TYPE_FIELD_NUMBER = 4;
        public static final int PRIVILEGE_FIELD_NUMBER = 6;
        public static final int UID_FIELD_NUMBER = 1;
        public static final int VBADGE_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private int avatarFrameType_;
        private volatile Object avatarFrame_;
        private volatile Object avatar_;
        private volatile Object liangId_;
        private int liangType_;
        private byte memoizedIsInitialized;
        private List<UserPrivilege> privilege_;
        private int uid_;
        private int vbadge_;
        private static final TopAudience DEFAULT_INSTANCE = new TopAudience();
        private static final Parser<TopAudience> PARSER = new AbstractParser<TopAudience>() { // from class: cn.irisgw.live.SyncTopAudienceExtra.TopAudience.1
            /* renamed from: parsePartialFrom */
            public TopAudience m7453parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new TopAudience(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/SyncTopAudienceExtra$TopAudience$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TopAudienceOrBuilder {
            private int avatarFrameType_;
            private Object avatarFrame_;
            private Object avatar_;
            private int bitField0_;
            private Object liangId_;
            private int liangType_;
            private RepeatedFieldBuilderV3<UserPrivilege, UserPrivilege.Builder, UserPrivilegeOrBuilder> privilegeBuilder_;
            private List<UserPrivilege> privilege_;
            private int uid_;
            private int vbadge_;

            private Builder() {
                this.avatar_ = "";
                this.vbadge_ = 0;
                this.liangType_ = 0;
                this.liangId_ = "";
                this.privilege_ = Collections.emptyList();
                this.avatarFrame_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.avatar_ = "";
                this.vbadge_ = 0;
                this.liangType_ = 0;
                this.liangId_ = "";
                this.privilege_ = Collections.emptyList();
                this.avatarFrame_ = "";
                maybeForceBuilderInitialization();
            }

            private void ensurePrivilegeIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.privilege_ = new ArrayList(this.privilege_);
                    this.bitField0_ |= 1;
                }
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LiveConstants.internal_static_cn_irisgw_live_SyncTopAudienceExtra_TopAudience_descriptor;
            }

            private RepeatedFieldBuilderV3<UserPrivilege, UserPrivilege.Builder, UserPrivilegeOrBuilder> getPrivilegeFieldBuilder() {
                if (this.privilegeBuilder_ == null) {
                    List<UserPrivilege> list = this.privilege_;
                    boolean z = true;
                    if ((this.bitField0_ & 1) == 0) {
                        z = false;
                    }
                    this.privilegeBuilder_ = new RepeatedFieldBuilderV3<>(list, z, getParentForChildren(), isClean());
                    this.privilege_ = null;
                }
                return this.privilegeBuilder_;
            }

            private void maybeForceBuilderInitialization() {
                if (TopAudience.alwaysUseFieldBuilders) {
                    getPrivilegeFieldBuilder();
                }
            }

            public Builder addAllPrivilege(Iterable<? extends UserPrivilege> iterable) {
                RepeatedFieldBuilderV3<UserPrivilege, UserPrivilege.Builder, UserPrivilegeOrBuilder> repeatedFieldBuilderV3 = this.privilegeBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                    return this;
                }
                ensurePrivilegeIsMutable();
                AbstractMessageLite.Builder.addAll(iterable, this.privilege_);
                onChanged();
                return this;
            }

            public Builder addPrivilege(int i, UserPrivilege.Builder builder) {
                RepeatedFieldBuilderV3<UserPrivilege, UserPrivilege.Builder, UserPrivilegeOrBuilder> repeatedFieldBuilderV3 = this.privilegeBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(i, builder.m7504build());
                    return this;
                }
                ensurePrivilegeIsMutable();
                this.privilege_.add(i, builder.m7504build());
                onChanged();
                return this;
            }

            public Builder addPrivilege(int i, UserPrivilege userPrivilege) {
                RepeatedFieldBuilderV3<UserPrivilege, UserPrivilege.Builder, UserPrivilegeOrBuilder> repeatedFieldBuilderV3 = this.privilegeBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(i, userPrivilege);
                    return this;
                } else if (userPrivilege != null) {
                    ensurePrivilegeIsMutable();
                    this.privilege_.add(i, userPrivilege);
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }

            public Builder addPrivilege(UserPrivilege.Builder builder) {
                RepeatedFieldBuilderV3<UserPrivilege, UserPrivilege.Builder, UserPrivilegeOrBuilder> repeatedFieldBuilderV3 = this.privilegeBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(builder.m7504build());
                    return this;
                }
                ensurePrivilegeIsMutable();
                this.privilege_.add(builder.m7504build());
                onChanged();
                return this;
            }

            public Builder addPrivilege(UserPrivilege userPrivilege) {
                RepeatedFieldBuilderV3<UserPrivilege, UserPrivilege.Builder, UserPrivilegeOrBuilder> repeatedFieldBuilderV3 = this.privilegeBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.addMessage(userPrivilege);
                    return this;
                } else if (userPrivilege != null) {
                    ensurePrivilegeIsMutable();
                    this.privilege_.add(userPrivilege);
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }

            public UserPrivilege.Builder addPrivilegeBuilder() {
                return getPrivilegeFieldBuilder().addBuilder(UserPrivilege.getDefaultInstance());
            }

            public UserPrivilege.Builder addPrivilegeBuilder(int i) {
                return getPrivilegeFieldBuilder().addBuilder(i, UserPrivilege.getDefaultInstance());
            }

            /* renamed from: addRepeatedField */
            public Builder m7455addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: build */
            public TopAudience m7457build() {
                TopAudience m7459buildPartial = m7459buildPartial();
                if (m7459buildPartial.isInitialized()) {
                    return m7459buildPartial;
                }
                throw newUninitializedMessageException(m7459buildPartial);
            }

            /* renamed from: buildPartial */
            public TopAudience m7459buildPartial() {
                TopAudience topAudience = new TopAudience(this);
                topAudience.uid_ = this.uid_;
                topAudience.avatar_ = this.avatar_;
                topAudience.vbadge_ = this.vbadge_;
                topAudience.liangType_ = this.liangType_;
                topAudience.liangId_ = this.liangId_;
                RepeatedFieldBuilderV3<UserPrivilege, UserPrivilege.Builder, UserPrivilegeOrBuilder> repeatedFieldBuilderV3 = this.privilegeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.privilege_ = Collections.unmodifiableList(this.privilege_);
                        this.bitField0_ &= -2;
                    }
                    topAudience.privilege_ = this.privilege_;
                } else {
                    topAudience.privilege_ = repeatedFieldBuilderV3.build();
                }
                topAudience.avatarFrame_ = this.avatarFrame_;
                topAudience.avatarFrameType_ = this.avatarFrameType_;
                onBuilt();
                return topAudience;
            }

            /* renamed from: clear */
            public Builder m7463clear() {
                super.clear();
                this.uid_ = 0;
                this.avatar_ = "";
                this.vbadge_ = 0;
                this.liangType_ = 0;
                this.liangId_ = "";
                RepeatedFieldBuilderV3<UserPrivilege, UserPrivilege.Builder, UserPrivilegeOrBuilder> repeatedFieldBuilderV3 = this.privilegeBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.privilege_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                this.avatarFrame_ = "";
                this.avatarFrameType_ = 0;
                return this;
            }

            public Builder clearAvatar() {
                this.avatar_ = TopAudience.getDefaultInstance().getAvatar();
                onChanged();
                return this;
            }

            public Builder clearAvatarFrame() {
                this.avatarFrame_ = TopAudience.getDefaultInstance().getAvatarFrame();
                onChanged();
                return this;
            }

            public Builder clearAvatarFrameType() {
                this.avatarFrameType_ = 0;
                onChanged();
                return this;
            }

            /* renamed from: clearField */
            public Builder m7465clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearLiangId() {
                this.liangId_ = TopAudience.getDefaultInstance().getLiangId();
                onChanged();
                return this;
            }

            public Builder clearLiangType() {
                this.liangType_ = 0;
                onChanged();
                return this;
            }

            /* renamed from: clearOneof */
            public Builder m7468clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearPrivilege() {
                RepeatedFieldBuilderV3<UserPrivilege, UserPrivilege.Builder, UserPrivilegeOrBuilder> repeatedFieldBuilderV3 = this.privilegeBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.clear();
                    return this;
                }
                this.privilege_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            public Builder clearUid() {
                this.uid_ = 0;
                onChanged();
                return this;
            }

            public Builder clearVbadge() {
                this.vbadge_ = 0;
                onChanged();
                return this;
            }

            /* renamed from: clone */
            public Builder m7474clone() {
                return (Builder) super.clone();
            }

            @Override // cn.irisgw.live.SyncTopAudienceExtra.TopAudienceOrBuilder
            public String getAvatar() {
                Object obj = this.avatar_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.avatar_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.SyncTopAudienceExtra.TopAudienceOrBuilder
            public ByteString getAvatarBytes() {
                Object obj = this.avatar_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.avatar_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.SyncTopAudienceExtra.TopAudienceOrBuilder
            public String getAvatarFrame() {
                Object obj = this.avatarFrame_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.avatarFrame_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.SyncTopAudienceExtra.TopAudienceOrBuilder
            public ByteString getAvatarFrameBytes() {
                Object obj = this.avatarFrame_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.avatarFrame_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.SyncTopAudienceExtra.TopAudienceOrBuilder
            public int getAvatarFrameType() {
                return this.avatarFrameType_;
            }

            /* renamed from: getDefaultInstanceForType */
            public TopAudience m7476getDefaultInstanceForType() {
                return TopAudience.getDefaultInstance();
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return LiveConstants.internal_static_cn_irisgw_live_SyncTopAudienceExtra_TopAudience_descriptor;
            }

            @Override // cn.irisgw.live.SyncTopAudienceExtra.TopAudienceOrBuilder
            public String getLiangId() {
                Object obj = this.liangId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.liangId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.SyncTopAudienceExtra.TopAudienceOrBuilder
            public ByteString getLiangIdBytes() {
                Object obj = this.liangId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.liangId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.SyncTopAudienceExtra.TopAudienceOrBuilder
            public LiangType getLiangType() {
                LiangType valueOf = LiangType.valueOf(this.liangType_);
                LiangType liangType = valueOf;
                if (valueOf == null) {
                    liangType = LiangType.UNRECOGNIZED;
                }
                return liangType;
            }

            @Override // cn.irisgw.live.SyncTopAudienceExtra.TopAudienceOrBuilder
            public int getLiangTypeValue() {
                return this.liangType_;
            }

            @Override // cn.irisgw.live.SyncTopAudienceExtra.TopAudienceOrBuilder
            public UserPrivilege getPrivilege(int i) {
                RepeatedFieldBuilderV3<UserPrivilege, UserPrivilege.Builder, UserPrivilegeOrBuilder> repeatedFieldBuilderV3 = this.privilegeBuilder_;
                return repeatedFieldBuilderV3 == null ? this.privilege_.get(i) : repeatedFieldBuilderV3.getMessage(i);
            }

            public UserPrivilege.Builder getPrivilegeBuilder(int i) {
                return getPrivilegeFieldBuilder().getBuilder(i);
            }

            public List<UserPrivilege.Builder> getPrivilegeBuilderList() {
                return getPrivilegeFieldBuilder().getBuilderList();
            }

            @Override // cn.irisgw.live.SyncTopAudienceExtra.TopAudienceOrBuilder
            public int getPrivilegeCount() {
                RepeatedFieldBuilderV3<UserPrivilege, UserPrivilege.Builder, UserPrivilegeOrBuilder> repeatedFieldBuilderV3 = this.privilegeBuilder_;
                return repeatedFieldBuilderV3 == null ? this.privilege_.size() : repeatedFieldBuilderV3.getCount();
            }

            @Override // cn.irisgw.live.SyncTopAudienceExtra.TopAudienceOrBuilder
            public List<UserPrivilege> getPrivilegeList() {
                RepeatedFieldBuilderV3<UserPrivilege, UserPrivilege.Builder, UserPrivilegeOrBuilder> repeatedFieldBuilderV3 = this.privilegeBuilder_;
                return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.privilege_) : repeatedFieldBuilderV3.getMessageList();
            }

            @Override // cn.irisgw.live.SyncTopAudienceExtra.TopAudienceOrBuilder
            public UserPrivilegeOrBuilder getPrivilegeOrBuilder(int i) {
                RepeatedFieldBuilderV3<UserPrivilege, UserPrivilege.Builder, UserPrivilegeOrBuilder> repeatedFieldBuilderV3 = this.privilegeBuilder_;
                return repeatedFieldBuilderV3 == null ? this.privilege_.get(i) : (UserPrivilegeOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(i);
            }

            @Override // cn.irisgw.live.SyncTopAudienceExtra.TopAudienceOrBuilder
            public List<? extends UserPrivilegeOrBuilder> getPrivilegeOrBuilderList() {
                RepeatedFieldBuilderV3<UserPrivilege, UserPrivilege.Builder, UserPrivilegeOrBuilder> repeatedFieldBuilderV3 = this.privilegeBuilder_;
                return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.privilege_);
            }

            @Override // cn.irisgw.live.SyncTopAudienceExtra.TopAudienceOrBuilder
            public int getUid() {
                return this.uid_;
            }

            @Override // cn.irisgw.live.SyncTopAudienceExtra.TopAudienceOrBuilder
            public VBadge getVbadge() {
                VBadge valueOf = VBadge.valueOf(this.vbadge_);
                VBadge vBadge = valueOf;
                if (valueOf == null) {
                    vBadge = VBadge.UNRECOGNIZED;
                }
                return vBadge;
            }

            @Override // cn.irisgw.live.SyncTopAudienceExtra.TopAudienceOrBuilder
            public int getVbadgeValue() {
                return this.vbadge_;
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveConstants.internal_static_cn_irisgw_live_SyncTopAudienceExtra_TopAudience_fieldAccessorTable.ensureFieldAccessorsInitialized(TopAudience.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(TopAudience topAudience) {
                if (topAudience == TopAudience.getDefaultInstance()) {
                    return this;
                }
                if (topAudience.getUid() != 0) {
                    setUid(topAudience.getUid());
                }
                if (!topAudience.getAvatar().isEmpty()) {
                    this.avatar_ = topAudience.avatar_;
                    onChanged();
                }
                if (topAudience.vbadge_ != 0) {
                    setVbadgeValue(topAudience.getVbadgeValue());
                }
                if (topAudience.liangType_ != 0) {
                    setLiangTypeValue(topAudience.getLiangTypeValue());
                }
                if (!topAudience.getLiangId().isEmpty()) {
                    this.liangId_ = topAudience.liangId_;
                    onChanged();
                }
                if (this.privilegeBuilder_ == null) {
                    if (!topAudience.privilege_.isEmpty()) {
                        if (this.privilege_.isEmpty()) {
                            this.privilege_ = topAudience.privilege_;
                            this.bitField0_ &= -2;
                        } else {
                            ensurePrivilegeIsMutable();
                            this.privilege_.addAll(topAudience.privilege_);
                        }
                        onChanged();
                    }
                } else if (!topAudience.privilege_.isEmpty()) {
                    if (this.privilegeBuilder_.isEmpty()) {
                        this.privilegeBuilder_.dispose();
                        RepeatedFieldBuilderV3<UserPrivilege, UserPrivilege.Builder, UserPrivilegeOrBuilder> repeatedFieldBuilderV3 = null;
                        this.privilegeBuilder_ = null;
                        this.privilege_ = topAudience.privilege_;
                        this.bitField0_ &= -2;
                        if (TopAudience.alwaysUseFieldBuilders) {
                            repeatedFieldBuilderV3 = getPrivilegeFieldBuilder();
                        }
                        this.privilegeBuilder_ = repeatedFieldBuilderV3;
                    } else {
                        this.privilegeBuilder_.addAllMessages(topAudience.privilege_);
                    }
                }
                if (!topAudience.getAvatarFrame().isEmpty()) {
                    this.avatarFrame_ = topAudience.avatarFrame_;
                    onChanged();
                }
                if (topAudience.getAvatarFrameType() != 0) {
                    setAvatarFrameType(topAudience.getAvatarFrameType());
                }
                m7485mergeUnknownFields(topAudience.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            /* renamed from: mergeFrom */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.SyncTopAudienceExtra.TopAudience.Builder m7482mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.SyncTopAudienceExtra.TopAudience.access$2300()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.SyncTopAudienceExtra$TopAudience r0 = (cn.irisgw.live.SyncTopAudienceExtra.TopAudience) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.SyncTopAudienceExtra$TopAudience$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.SyncTopAudienceExtra$TopAudience r0 = (cn.irisgw.live.SyncTopAudienceExtra.TopAudience) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.SyncTopAudienceExtra$TopAudience$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.SyncTopAudienceExtra.TopAudience.Builder.m7482mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.SyncTopAudienceExtra$TopAudience$Builder");
            }

            /* renamed from: mergeFrom */
            public Builder m7481mergeFrom(Message message) {
                if (message instanceof TopAudience) {
                    return mergeFrom((TopAudience) message);
                }
                super.mergeFrom(message);
                return this;
            }

            /* renamed from: mergeUnknownFields */
            public final Builder m7485mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder removePrivilege(int i) {
                RepeatedFieldBuilderV3<UserPrivilege, UserPrivilege.Builder, UserPrivilegeOrBuilder> repeatedFieldBuilderV3 = this.privilegeBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.remove(i);
                    return this;
                }
                ensurePrivilegeIsMutable();
                this.privilege_.remove(i);
                onChanged();
                return this;
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
                    TopAudience.checkByteStringIsUtf8(byteString);
                    this.avatar_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setAvatarFrame(String str) {
                if (str != null) {
                    this.avatarFrame_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setAvatarFrameBytes(ByteString byteString) {
                if (byteString != null) {
                    TopAudience.checkByteStringIsUtf8(byteString);
                    this.avatarFrame_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setAvatarFrameType(int i) {
                this.avatarFrameType_ = i;
                onChanged();
                return this;
            }

            /* renamed from: setField */
            public Builder m7487setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setLiangId(String str) {
                if (str != null) {
                    this.liangId_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setLiangIdBytes(ByteString byteString) {
                if (byteString != null) {
                    TopAudience.checkByteStringIsUtf8(byteString);
                    this.liangId_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setLiangType(LiangType liangType) {
                if (liangType != null) {
                    this.liangType_ = liangType.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setLiangTypeValue(int i) {
                this.liangType_ = i;
                onChanged();
                return this;
            }

            public Builder setPrivilege(int i, UserPrivilege.Builder builder) {
                RepeatedFieldBuilderV3<UserPrivilege, UserPrivilege.Builder, UserPrivilegeOrBuilder> repeatedFieldBuilderV3 = this.privilegeBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.setMessage(i, builder.m7504build());
                    return this;
                }
                ensurePrivilegeIsMutable();
                this.privilege_.set(i, builder.m7504build());
                onChanged();
                return this;
            }

            public Builder setPrivilege(int i, UserPrivilege userPrivilege) {
                RepeatedFieldBuilderV3<UserPrivilege, UserPrivilege.Builder, UserPrivilegeOrBuilder> repeatedFieldBuilderV3 = this.privilegeBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.setMessage(i, userPrivilege);
                    return this;
                } else if (userPrivilege != null) {
                    ensurePrivilegeIsMutable();
                    this.privilege_.set(i, userPrivilege);
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }

            /* renamed from: setRepeatedField */
            public Builder m7489setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setUid(int i) {
                this.uid_ = i;
                onChanged();
                return this;
            }

            /* renamed from: setUnknownFields */
            public final Builder m7491setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            public Builder setVbadge(VBadge vBadge) {
                if (vBadge != null) {
                    this.vbadge_ = vBadge.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setVbadgeValue(int i) {
                this.vbadge_ = i;
                onChanged();
                return this;
            }
        }

        private TopAudience() {
            this.memoizedIsInitialized = (byte) -1;
            this.avatar_ = "";
            this.vbadge_ = 0;
            this.liangType_ = 0;
            this.liangId_ = "";
            this.privilege_ = Collections.emptyList();
            this.avatarFrame_ = "";
        }

        private TopAudience(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.uid_ = codedInputStream.readUInt32();
                                } else if (readTag == 18) {
                                    this.avatar_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 24) {
                                    this.vbadge_ = codedInputStream.readEnum();
                                } else if (readTag == 32) {
                                    this.liangType_ = codedInputStream.readEnum();
                                } else if (readTag == 42) {
                                    this.liangId_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 50) {
                                    boolean z4 = z2;
                                    if (!(z2 & true)) {
                                        this.privilege_ = new ArrayList();
                                        z4 = z2 | true;
                                    }
                                    this.privilege_.add((UserPrivilege) codedInputStream.readMessage(UserPrivilege.parser(), extensionRegistryLite));
                                    z2 = z4;
                                } else if (readTag == 58) {
                                    this.avatarFrame_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 64) {
                                    this.avatarFrameType_ = codedInputStream.readUInt32();
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
                        this.privilege_ = Collections.unmodifiableList(this.privilege_);
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z2 & true) {
                this.privilege_ = Collections.unmodifiableList(this.privilege_);
            }
            this.unknownFields = newBuilder.build();
            makeExtensionsImmutable();
        }

        private TopAudience(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static TopAudience getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_SyncTopAudienceExtra_TopAudience_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m7452toBuilder();
        }

        public static Builder newBuilder(TopAudience topAudience) {
            return DEFAULT_INSTANCE.m7452toBuilder().mergeFrom(topAudience);
        }

        public static TopAudience parseDelimitedFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static TopAudience parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static TopAudience parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (TopAudience) PARSER.parseFrom(byteString);
        }

        public static TopAudience parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (TopAudience) PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static TopAudience parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static TopAudience parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static TopAudience parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static TopAudience parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static TopAudience parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (TopAudience) PARSER.parseFrom(byteBuffer);
        }

        public static TopAudience parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (TopAudience) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static TopAudience parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (TopAudience) PARSER.parseFrom(bArr);
        }

        public static TopAudience parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (TopAudience) PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<TopAudience> parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof TopAudience) {
                TopAudience topAudience = (TopAudience) obj;
                return getUid() == topAudience.getUid() && getAvatar().equals(topAudience.getAvatar()) && this.vbadge_ == topAudience.vbadge_ && this.liangType_ == topAudience.liangType_ && getLiangId().equals(topAudience.getLiangId()) && getPrivilegeList().equals(topAudience.getPrivilegeList()) && getAvatarFrame().equals(topAudience.getAvatarFrame()) && getAvatarFrameType() == topAudience.getAvatarFrameType() && this.unknownFields.equals(topAudience.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // cn.irisgw.live.SyncTopAudienceExtra.TopAudienceOrBuilder
        public String getAvatar() {
            Object obj = this.avatar_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.avatar_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.SyncTopAudienceExtra.TopAudienceOrBuilder
        public ByteString getAvatarBytes() {
            Object obj = this.avatar_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.avatar_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.SyncTopAudienceExtra.TopAudienceOrBuilder
        public String getAvatarFrame() {
            Object obj = this.avatarFrame_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.avatarFrame_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.SyncTopAudienceExtra.TopAudienceOrBuilder
        public ByteString getAvatarFrameBytes() {
            Object obj = this.avatarFrame_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.avatarFrame_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.SyncTopAudienceExtra.TopAudienceOrBuilder
        public int getAvatarFrameType() {
            return this.avatarFrameType_;
        }

        /* renamed from: getDefaultInstanceForType */
        public TopAudience m7447getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // cn.irisgw.live.SyncTopAudienceExtra.TopAudienceOrBuilder
        public String getLiangId() {
            Object obj = this.liangId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.liangId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.SyncTopAudienceExtra.TopAudienceOrBuilder
        public ByteString getLiangIdBytes() {
            Object obj = this.liangId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.liangId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.SyncTopAudienceExtra.TopAudienceOrBuilder
        public LiangType getLiangType() {
            LiangType valueOf = LiangType.valueOf(this.liangType_);
            LiangType liangType = valueOf;
            if (valueOf == null) {
                liangType = LiangType.UNRECOGNIZED;
            }
            return liangType;
        }

        @Override // cn.irisgw.live.SyncTopAudienceExtra.TopAudienceOrBuilder
        public int getLiangTypeValue() {
            return this.liangType_;
        }

        public Parser<TopAudience> getParserForType() {
            return PARSER;
        }

        @Override // cn.irisgw.live.SyncTopAudienceExtra.TopAudienceOrBuilder
        public UserPrivilege getPrivilege(int i) {
            return this.privilege_.get(i);
        }

        @Override // cn.irisgw.live.SyncTopAudienceExtra.TopAudienceOrBuilder
        public int getPrivilegeCount() {
            return this.privilege_.size();
        }

        @Override // cn.irisgw.live.SyncTopAudienceExtra.TopAudienceOrBuilder
        public List<UserPrivilege> getPrivilegeList() {
            return this.privilege_;
        }

        @Override // cn.irisgw.live.SyncTopAudienceExtra.TopAudienceOrBuilder
        public UserPrivilegeOrBuilder getPrivilegeOrBuilder(int i) {
            return this.privilege_.get(i);
        }

        @Override // cn.irisgw.live.SyncTopAudienceExtra.TopAudienceOrBuilder
        public List<? extends UserPrivilegeOrBuilder> getPrivilegeOrBuilderList() {
            return this.privilege_;
        }

        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = this.uid_;
            int computeUInt32Size = i2 != 0 ? CodedOutputStream.computeUInt32Size(1, i2) + 0 : 0;
            int i3 = computeUInt32Size;
            if (!getAvatarBytes().isEmpty()) {
                i3 = computeUInt32Size + GeneratedMessageV3.computeStringSize(2, this.avatar_);
            }
            int i4 = i3;
            if (this.vbadge_ != VBadge.EMPTY_V.getNumber()) {
                i4 = i3 + CodedOutputStream.computeEnumSize(3, this.vbadge_);
            }
            int i5 = i4;
            if (this.liangType_ != LiangType.None.getNumber()) {
                i5 = i4 + CodedOutputStream.computeEnumSize(4, this.liangType_);
            }
            int i6 = i5;
            int i7 = 0;
            if (!getLiangIdBytes().isEmpty()) {
                i6 = i5 + GeneratedMessageV3.computeStringSize(5, this.liangId_);
                i7 = 0;
            }
            while (i7 < this.privilege_.size()) {
                i6 += CodedOutputStream.computeMessageSize(6, this.privilege_.get(i7));
                i7++;
            }
            int i8 = i6;
            if (!getAvatarFrameBytes().isEmpty()) {
                i8 = i6 + GeneratedMessageV3.computeStringSize(7, this.avatarFrame_);
            }
            int i9 = this.avatarFrameType_;
            int i10 = i8;
            if (i9 != 0) {
                i10 = i8 + CodedOutputStream.computeUInt32Size(8, i9);
            }
            int serializedSize = i10 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // cn.irisgw.live.SyncTopAudienceExtra.TopAudienceOrBuilder
        public int getUid() {
            return this.uid_;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // cn.irisgw.live.SyncTopAudienceExtra.TopAudienceOrBuilder
        public VBadge getVbadge() {
            VBadge valueOf = VBadge.valueOf(this.vbadge_);
            VBadge vBadge = valueOf;
            if (valueOf == null) {
                vBadge = VBadge.UNRECOGNIZED;
            }
            return vBadge;
        }

        @Override // cn.irisgw.live.SyncTopAudienceExtra.TopAudienceOrBuilder
        public int getVbadgeValue() {
            return this.vbadge_;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getUid()) * 37) + 2) * 53) + getAvatar().hashCode()) * 37) + 3) * 53) + this.vbadge_) * 37) + 4) * 53) + this.liangType_) * 37) + 5) * 53) + getLiangId().hashCode();
            int i = hashCode;
            if (getPrivilegeCount() > 0) {
                i = (((hashCode * 37) + 6) * 53) + getPrivilegeList().hashCode();
            }
            int hashCode2 = (((((((((i * 37) + 7) * 53) + getAvatarFrame().hashCode()) * 37) + 8) * 53) + getAvatarFrameType()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_SyncTopAudienceExtra_TopAudience_fieldAccessorTable.ensureFieldAccessorsInitialized(TopAudience.class, Builder.class);
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
        public Builder m7450newBuilderForType() {
            return newBuilder();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: newBuilderForType */
        public Builder m7449newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new TopAudience();
        }

        /* renamed from: toBuilder */
        public Builder m7452toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i = this.uid_;
            if (i != 0) {
                codedOutputStream.writeUInt32(1, i);
            }
            if (!getAvatarBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.avatar_);
            }
            if (this.vbadge_ != VBadge.EMPTY_V.getNumber()) {
                codedOutputStream.writeEnum(3, this.vbadge_);
            }
            if (this.liangType_ != LiangType.None.getNumber()) {
                codedOutputStream.writeEnum(4, this.liangType_);
            }
            if (!getLiangIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.liangId_);
            }
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.privilege_.size()) {
                    break;
                }
                codedOutputStream.writeMessage(6, this.privilege_.get(i3));
                i2 = i3 + 1;
            }
            if (!getAvatarFrameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 7, this.avatarFrame_);
            }
            int i4 = this.avatarFrameType_;
            if (i4 != 0) {
                codedOutputStream.writeUInt32(8, i4);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/SyncTopAudienceExtra$TopAudienceOrBuilder.class */
    public interface TopAudienceOrBuilder extends MessageOrBuilder {
        String getAvatar();

        ByteString getAvatarBytes();

        String getAvatarFrame();

        ByteString getAvatarFrameBytes();

        int getAvatarFrameType();

        String getLiangId();

        ByteString getLiangIdBytes();

        LiangType getLiangType();

        int getLiangTypeValue();

        UserPrivilege getPrivilege(int i);

        int getPrivilegeCount();

        List<UserPrivilege> getPrivilegeList();

        UserPrivilegeOrBuilder getPrivilegeOrBuilder(int i);

        List<? extends UserPrivilegeOrBuilder> getPrivilegeOrBuilderList();

        int getUid();

        VBadge getVbadge();

        int getVbadgeValue();
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/SyncTopAudienceExtra$UserPrivilege.class */
    public static final class UserPrivilege extends GeneratedMessageV3 implements UserPrivilegeOrBuilder {
        private static final UserPrivilege DEFAULT_INSTANCE = new UserPrivilege();
        private static final Parser<UserPrivilege> PARSER = new AbstractParser<UserPrivilege>() { // from class: cn.irisgw.live.SyncTopAudienceExtra.UserPrivilege.1
            /* renamed from: parsePartialFrom */
            public UserPrivilege m7500parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new UserPrivilege(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int STATUS_FIELD_NUMBER = 2;
        public static final int TYPE_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private int status_;
        private int type_;

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/SyncTopAudienceExtra$UserPrivilege$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements UserPrivilegeOrBuilder {
            private int status_;
            private int type_;

            private Builder() {
                this.type_ = 0;
                this.status_ = 0;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.type_ = 0;
                this.status_ = 0;
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LiveConstants.internal_static_cn_irisgw_live_SyncTopAudienceExtra_UserPrivilege_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = UserPrivilege.alwaysUseFieldBuilders;
            }

            /* renamed from: addRepeatedField */
            public Builder m7502addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: build */
            public UserPrivilege m7504build() {
                UserPrivilege m7506buildPartial = m7506buildPartial();
                if (m7506buildPartial.isInitialized()) {
                    return m7506buildPartial;
                }
                throw newUninitializedMessageException(m7506buildPartial);
            }

            /* renamed from: buildPartial */
            public UserPrivilege m7506buildPartial() {
                UserPrivilege userPrivilege = new UserPrivilege(this);
                userPrivilege.type_ = this.type_;
                userPrivilege.status_ = this.status_;
                onBuilt();
                return userPrivilege;
            }

            /* renamed from: clear */
            public Builder m7510clear() {
                super.clear();
                this.type_ = 0;
                this.status_ = 0;
                return this;
            }

            /* renamed from: clearField */
            public Builder m7512clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            /* renamed from: clearOneof */
            public Builder m7515clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearStatus() {
                this.status_ = 0;
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.type_ = 0;
                onChanged();
                return this;
            }

            /* renamed from: clone */
            public Builder m7521clone() {
                return (Builder) super.clone();
            }

            /* renamed from: getDefaultInstanceForType */
            public UserPrivilege m7523getDefaultInstanceForType() {
                return UserPrivilege.getDefaultInstance();
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return LiveConstants.internal_static_cn_irisgw_live_SyncTopAudienceExtra_UserPrivilege_descriptor;
            }

            @Override // cn.irisgw.live.SyncTopAudienceExtra.UserPrivilegeOrBuilder
            public PrivilegeStatus getStatus() {
                PrivilegeStatus valueOf = PrivilegeStatus.valueOf(this.status_);
                PrivilegeStatus privilegeStatus = valueOf;
                if (valueOf == null) {
                    privilegeStatus = PrivilegeStatus.UNRECOGNIZED;
                }
                return privilegeStatus;
            }

            @Override // cn.irisgw.live.SyncTopAudienceExtra.UserPrivilegeOrBuilder
            public int getStatusValue() {
                return this.status_;
            }

            @Override // cn.irisgw.live.SyncTopAudienceExtra.UserPrivilegeOrBuilder
            public PrivilegeType getType() {
                PrivilegeType valueOf = PrivilegeType.valueOf(this.type_);
                PrivilegeType privilegeType = valueOf;
                if (valueOf == null) {
                    privilegeType = PrivilegeType.UNRECOGNIZED;
                }
                return privilegeType;
            }

            @Override // cn.irisgw.live.SyncTopAudienceExtra.UserPrivilegeOrBuilder
            public int getTypeValue() {
                return this.type_;
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveConstants.internal_static_cn_irisgw_live_SyncTopAudienceExtra_UserPrivilege_fieldAccessorTable.ensureFieldAccessorsInitialized(UserPrivilege.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(UserPrivilege userPrivilege) {
                if (userPrivilege == UserPrivilege.getDefaultInstance()) {
                    return this;
                }
                if (userPrivilege.type_ != 0) {
                    setTypeValue(userPrivilege.getTypeValue());
                }
                if (userPrivilege.status_ != 0) {
                    setStatusValue(userPrivilege.getStatusValue());
                }
                m7532mergeUnknownFields(userPrivilege.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            /* renamed from: mergeFrom */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.SyncTopAudienceExtra.UserPrivilege.Builder m7529mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.SyncTopAudienceExtra.UserPrivilege.access$700()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.SyncTopAudienceExtra$UserPrivilege r0 = (cn.irisgw.live.SyncTopAudienceExtra.UserPrivilege) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.SyncTopAudienceExtra$UserPrivilege$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.SyncTopAudienceExtra$UserPrivilege r0 = (cn.irisgw.live.SyncTopAudienceExtra.UserPrivilege) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.SyncTopAudienceExtra$UserPrivilege$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.SyncTopAudienceExtra.UserPrivilege.Builder.m7529mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.SyncTopAudienceExtra$UserPrivilege$Builder");
            }

            /* renamed from: mergeFrom */
            public Builder m7528mergeFrom(Message message) {
                if (message instanceof UserPrivilege) {
                    return mergeFrom((UserPrivilege) message);
                }
                super.mergeFrom(message);
                return this;
            }

            /* renamed from: mergeUnknownFields */
            public final Builder m7532mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            /* renamed from: setField */
            public Builder m7534setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            /* renamed from: setRepeatedField */
            public Builder m7536setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setStatus(PrivilegeStatus privilegeStatus) {
                if (privilegeStatus != null) {
                    this.status_ = privilegeStatus.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setStatusValue(int i) {
                this.status_ = i;
                onChanged();
                return this;
            }

            public Builder setType(PrivilegeType privilegeType) {
                if (privilegeType != null) {
                    this.type_ = privilegeType.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setTypeValue(int i) {
                this.type_ = i;
                onChanged();
                return this;
            }

            /* renamed from: setUnknownFields */
            public final Builder m7538setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private UserPrivilege() {
            this.memoizedIsInitialized = (byte) -1;
            this.type_ = 0;
            this.status_ = 0;
        }

        private UserPrivilege(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.type_ = codedInputStream.readEnum();
                                } else if (readTag == 16) {
                                    this.status_ = codedInputStream.readEnum();
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

        private UserPrivilege(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static UserPrivilege getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_SyncTopAudienceExtra_UserPrivilege_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m7499toBuilder();
        }

        public static Builder newBuilder(UserPrivilege userPrivilege) {
            return DEFAULT_INSTANCE.m7499toBuilder().mergeFrom(userPrivilege);
        }

        public static UserPrivilege parseDelimitedFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static UserPrivilege parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static UserPrivilege parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (UserPrivilege) PARSER.parseFrom(byteString);
        }

        public static UserPrivilege parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UserPrivilege) PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static UserPrivilege parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static UserPrivilege parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static UserPrivilege parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static UserPrivilege parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static UserPrivilege parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (UserPrivilege) PARSER.parseFrom(byteBuffer);
        }

        public static UserPrivilege parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UserPrivilege) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static UserPrivilege parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (UserPrivilege) PARSER.parseFrom(bArr);
        }

        public static UserPrivilege parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UserPrivilege) PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<UserPrivilege> parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof UserPrivilege) {
                UserPrivilege userPrivilege = (UserPrivilege) obj;
                return this.type_ == userPrivilege.type_ && this.status_ == userPrivilege.status_ && this.unknownFields.equals(userPrivilege.unknownFields);
            }
            return super.equals(obj);
        }

        /* renamed from: getDefaultInstanceForType */
        public UserPrivilege m7494getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        public Parser<UserPrivilege> getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (this.type_ != PrivilegeType.EMPTY_P.getNumber()) {
                i2 = 0 + CodedOutputStream.computeEnumSize(1, this.type_);
            }
            int i3 = i2;
            if (this.status_ != PrivilegeStatus.CLOSE.getNumber()) {
                i3 = i2 + CodedOutputStream.computeEnumSize(2, this.status_);
            }
            int serializedSize = i3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // cn.irisgw.live.SyncTopAudienceExtra.UserPrivilegeOrBuilder
        public PrivilegeStatus getStatus() {
            PrivilegeStatus valueOf = PrivilegeStatus.valueOf(this.status_);
            PrivilegeStatus privilegeStatus = valueOf;
            if (valueOf == null) {
                privilegeStatus = PrivilegeStatus.UNRECOGNIZED;
            }
            return privilegeStatus;
        }

        @Override // cn.irisgw.live.SyncTopAudienceExtra.UserPrivilegeOrBuilder
        public int getStatusValue() {
            return this.status_;
        }

        @Override // cn.irisgw.live.SyncTopAudienceExtra.UserPrivilegeOrBuilder
        public PrivilegeType getType() {
            PrivilegeType valueOf = PrivilegeType.valueOf(this.type_);
            PrivilegeType privilegeType = valueOf;
            if (valueOf == null) {
                privilegeType = PrivilegeType.UNRECOGNIZED;
            }
            return privilegeType;
        }

        @Override // cn.irisgw.live.SyncTopAudienceExtra.UserPrivilegeOrBuilder
        public int getTypeValue() {
            return this.type_;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.type_) * 37) + 2) * 53) + this.status_) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_SyncTopAudienceExtra_UserPrivilege_fieldAccessorTable.ensureFieldAccessorsInitialized(UserPrivilege.class, Builder.class);
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
        public Builder m7497newBuilderForType() {
            return newBuilder();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: newBuilderForType */
        public Builder m7496newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new UserPrivilege();
        }

        /* renamed from: toBuilder */
        public Builder m7499toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.type_ != PrivilegeType.EMPTY_P.getNumber()) {
                codedOutputStream.writeEnum(1, this.type_);
            }
            if (this.status_ != PrivilegeStatus.CLOSE.getNumber()) {
                codedOutputStream.writeEnum(2, this.status_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/SyncTopAudienceExtra$UserPrivilegeOrBuilder.class */
    public interface UserPrivilegeOrBuilder extends MessageOrBuilder {
        PrivilegeStatus getStatus();

        int getStatusValue();

        PrivilegeType getType();

        int getTypeValue();
    }

    private SyncTopAudienceExtra() {
        this.memoizedIsInitialized = (byte) -1;
        this.tops_ = Collections.emptyList();
    }

    private SyncTopAudienceExtra(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.tops_ = new ArrayList();
                                z4 = z2 | true;
                            }
                            this.tops_.add((TopAudience) codedInputStream.readMessage(TopAudience.parser(), extensionRegistryLite));
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
                    this.tops_ = Collections.unmodifiableList(this.tops_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                throw th;
            }
        }
        if (z2 & true) {
            this.tops_ = Collections.unmodifiableList(this.tops_);
        }
        this.unknownFields = newBuilder.build();
        makeExtensionsImmutable();
    }

    private SyncTopAudienceExtra(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static SyncTopAudienceExtra getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_SyncTopAudienceExtra_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m7405toBuilder();
    }

    public static Builder newBuilder(SyncTopAudienceExtra syncTopAudienceExtra) {
        return DEFAULT_INSTANCE.m7405toBuilder().mergeFrom(syncTopAudienceExtra);
    }

    public static SyncTopAudienceExtra parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static SyncTopAudienceExtra parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static SyncTopAudienceExtra parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (SyncTopAudienceExtra) PARSER.parseFrom(byteString);
    }

    public static SyncTopAudienceExtra parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (SyncTopAudienceExtra) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static SyncTopAudienceExtra parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static SyncTopAudienceExtra parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static SyncTopAudienceExtra parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static SyncTopAudienceExtra parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static SyncTopAudienceExtra parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (SyncTopAudienceExtra) PARSER.parseFrom(byteBuffer);
    }

    public static SyncTopAudienceExtra parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (SyncTopAudienceExtra) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static SyncTopAudienceExtra parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (SyncTopAudienceExtra) PARSER.parseFrom(bArr);
    }

    public static SyncTopAudienceExtra parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (SyncTopAudienceExtra) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<SyncTopAudienceExtra> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SyncTopAudienceExtra) {
            SyncTopAudienceExtra syncTopAudienceExtra = (SyncTopAudienceExtra) obj;
            return getTopsList().equals(syncTopAudienceExtra.getTopsList()) && this.unknownFields.equals(syncTopAudienceExtra.unknownFields);
        }
        return super.equals(obj);
    }

    /* renamed from: getDefaultInstanceForType */
    public SyncTopAudienceExtra m7400getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public Parser<SyncTopAudienceExtra> getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.tops_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(1, this.tops_.get(i3));
        }
        int serializedSize = i2 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.SyncTopAudienceExtraOrBuilder
    public TopAudience getTops(int i) {
        return this.tops_.get(i);
    }

    @Override // cn.irisgw.live.SyncTopAudienceExtraOrBuilder
    public int getTopsCount() {
        return this.tops_.size();
    }

    @Override // cn.irisgw.live.SyncTopAudienceExtraOrBuilder
    public List<TopAudience> getTopsList() {
        return this.tops_;
    }

    @Override // cn.irisgw.live.SyncTopAudienceExtraOrBuilder
    public TopAudienceOrBuilder getTopsOrBuilder(int i) {
        return this.tops_.get(i);
    }

    @Override // cn.irisgw.live.SyncTopAudienceExtraOrBuilder
    public List<? extends TopAudienceOrBuilder> getTopsOrBuilderList() {
        return this.tops_;
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
        if (getTopsCount() > 0) {
            i = (((hashCode * 37) + 1) * 53) + getTopsList().hashCode();
        }
        int hashCode2 = (i * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_SyncTopAudienceExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(SyncTopAudienceExtra.class, Builder.class);
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
    public Builder m7403newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m7402newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new SyncTopAudienceExtra();
    }

    /* renamed from: toBuilder */
    public Builder m7405toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.tops_.size()) {
                this.unknownFields.writeTo(codedOutputStream);
                return;
            } else {
                codedOutputStream.writeMessage(1, this.tops_.get(i2));
                i = i2 + 1;
            }
        }
    }
}
