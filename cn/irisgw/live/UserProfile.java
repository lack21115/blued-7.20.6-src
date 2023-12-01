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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/UserProfile.class */
public final class UserProfile extends GeneratedMessageV3 implements UserProfileOrBuilder {
    public static final int AVATAR_FIELD_NUMBER = 1;
    public static final int IS_MANAGER_FIELD_NUMBER = 5;
    public static final int NAME_FIELD_NUMBER = 2;
    public static final int NOBLE_FIELD_NUMBER = 7;
    public static final int PRIVILEGE_FIELD_NUMBER = 6;
    public static final int RICH_LEVEL_FIELD_NUMBER = 4;
    public static final int VBADGE_FIELD_NUMBER = 3;
    public static final int VIP_FRAME_FIELD_NUMBER = 8;
    public static final int VIP_LEVEL_FIELD_NUMBER = 9;
    private static final long serialVersionUID = 0;
    private volatile Object avatar_;
    private int isManager_;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private Noble noble_;
    private List<UserPrivilege> privilege_;
    private int richLevel_;
    private int vbadge_;
    private volatile Object vipFrame_;
    private int vipLevel_;
    private static final UserProfile DEFAULT_INSTANCE = new UserProfile();
    private static final Parser<UserProfile> PARSER = new AbstractParser<UserProfile>() { // from class: cn.irisgw.live.UserProfile.1
        /* renamed from: parsePartialFrom */
        public UserProfile m7928parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new UserProfile(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/UserProfile$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements UserProfileOrBuilder {
        private Object avatar_;
        private int bitField0_;
        private int isManager_;
        private Object name_;
        private SingleFieldBuilderV3<Noble, Noble.Builder, NobleOrBuilder> nobleBuilder_;
        private Noble noble_;
        private RepeatedFieldBuilderV3<UserPrivilege, UserPrivilege.Builder, UserPrivilegeOrBuilder> privilegeBuilder_;
        private List<UserPrivilege> privilege_;
        private int richLevel_;
        private int vbadge_;
        private Object vipFrame_;
        private int vipLevel_;

        private Builder() {
            this.avatar_ = "";
            this.name_ = "";
            this.vbadge_ = 0;
            this.privilege_ = Collections.emptyList();
            this.vipFrame_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.avatar_ = "";
            this.name_ = "";
            this.vbadge_ = 0;
            this.privilege_ = Collections.emptyList();
            this.vipFrame_ = "";
            maybeForceBuilderInitialization();
        }

        private void ensurePrivilegeIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.privilege_ = new ArrayList(this.privilege_);
                this.bitField0_ |= 1;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_UserProfile_descriptor;
        }

        private SingleFieldBuilderV3<Noble, Noble.Builder, NobleOrBuilder> getNobleFieldBuilder() {
            if (this.nobleBuilder_ == null) {
                this.nobleBuilder_ = new SingleFieldBuilderV3<>(getNoble(), getParentForChildren(), isClean());
                this.noble_ = null;
            }
            return this.nobleBuilder_;
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
            if (UserProfile.alwaysUseFieldBuilders) {
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
                repeatedFieldBuilderV3.addMessage(i, builder.m8026build());
                return this;
            }
            ensurePrivilegeIsMutable();
            this.privilege_.add(i, builder.m8026build());
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
                repeatedFieldBuilderV3.addMessage(builder.m8026build());
                return this;
            }
            ensurePrivilegeIsMutable();
            this.privilege_.add(builder.m8026build());
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
        public Builder m7930addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        /* renamed from: build */
        public UserProfile m7932build() {
            UserProfile m7934buildPartial = m7934buildPartial();
            if (m7934buildPartial.isInitialized()) {
                return m7934buildPartial;
            }
            throw newUninitializedMessageException(m7934buildPartial);
        }

        /* renamed from: buildPartial */
        public UserProfile m7934buildPartial() {
            UserProfile userProfile = new UserProfile(this);
            userProfile.avatar_ = this.avatar_;
            userProfile.name_ = this.name_;
            userProfile.vbadge_ = this.vbadge_;
            userProfile.richLevel_ = this.richLevel_;
            userProfile.isManager_ = this.isManager_;
            RepeatedFieldBuilderV3<UserPrivilege, UserPrivilege.Builder, UserPrivilegeOrBuilder> repeatedFieldBuilderV3 = this.privilegeBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.privilege_ = Collections.unmodifiableList(this.privilege_);
                    this.bitField0_ &= -2;
                }
                userProfile.privilege_ = this.privilege_;
            } else {
                userProfile.privilege_ = repeatedFieldBuilderV3.build();
            }
            SingleFieldBuilderV3<Noble, Noble.Builder, NobleOrBuilder> singleFieldBuilderV3 = this.nobleBuilder_;
            if (singleFieldBuilderV3 == null) {
                userProfile.noble_ = this.noble_;
            } else {
                userProfile.noble_ = singleFieldBuilderV3.build();
            }
            userProfile.vipFrame_ = this.vipFrame_;
            userProfile.vipLevel_ = this.vipLevel_;
            onBuilt();
            return userProfile;
        }

        /* renamed from: clear */
        public Builder m7938clear() {
            super.clear();
            this.avatar_ = "";
            this.name_ = "";
            this.vbadge_ = 0;
            this.richLevel_ = 0;
            this.isManager_ = 0;
            RepeatedFieldBuilderV3<UserPrivilege, UserPrivilege.Builder, UserPrivilegeOrBuilder> repeatedFieldBuilderV3 = this.privilegeBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.privilege_ = Collections.emptyList();
                this.bitField0_ &= -2;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            if (this.nobleBuilder_ == null) {
                this.noble_ = null;
            } else {
                this.noble_ = null;
                this.nobleBuilder_ = null;
            }
            this.vipFrame_ = "";
            this.vipLevel_ = 0;
            return this;
        }

        public Builder clearAvatar() {
            this.avatar_ = UserProfile.getDefaultInstance().getAvatar();
            onChanged();
            return this;
        }

        /* renamed from: clearField */
        public Builder m7940clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearIsManager() {
            this.isManager_ = 0;
            onChanged();
            return this;
        }

        public Builder clearName() {
            this.name_ = UserProfile.getDefaultInstance().getName();
            onChanged();
            return this;
        }

        public Builder clearNoble() {
            if (this.nobleBuilder_ == null) {
                this.noble_ = null;
                onChanged();
                return this;
            }
            this.noble_ = null;
            this.nobleBuilder_ = null;
            return this;
        }

        /* renamed from: clearOneof */
        public Builder m7943clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
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

        public Builder clearRichLevel() {
            this.richLevel_ = 0;
            onChanged();
            return this;
        }

        public Builder clearVbadge() {
            this.vbadge_ = 0;
            onChanged();
            return this;
        }

        public Builder clearVipFrame() {
            this.vipFrame_ = UserProfile.getDefaultInstance().getVipFrame();
            onChanged();
            return this;
        }

        public Builder clearVipLevel() {
            this.vipLevel_ = 0;
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m7949clone() {
            return (Builder) super.clone();
        }

        @Override // cn.irisgw.live.UserProfileOrBuilder
        public String getAvatar() {
            Object obj = this.avatar_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.avatar_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.UserProfileOrBuilder
        public ByteString getAvatarBytes() {
            Object obj = this.avatar_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.avatar_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        /* renamed from: getDefaultInstanceForType */
        public UserProfile m7951getDefaultInstanceForType() {
            return UserProfile.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_UserProfile_descriptor;
        }

        @Override // cn.irisgw.live.UserProfileOrBuilder
        public int getIsManager() {
            return this.isManager_;
        }

        @Override // cn.irisgw.live.UserProfileOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.UserProfileOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.UserProfileOrBuilder
        public Noble getNoble() {
            SingleFieldBuilderV3<Noble, Noble.Builder, NobleOrBuilder> singleFieldBuilderV3 = this.nobleBuilder_;
            if (singleFieldBuilderV3 == null) {
                Noble noble = this.noble_;
                Noble noble2 = noble;
                if (noble == null) {
                    noble2 = Noble.getDefaultInstance();
                }
                return noble2;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Noble.Builder getNobleBuilder() {
            onChanged();
            return getNobleFieldBuilder().getBuilder();
        }

        @Override // cn.irisgw.live.UserProfileOrBuilder
        public NobleOrBuilder getNobleOrBuilder() {
            SingleFieldBuilderV3<Noble, Noble.Builder, NobleOrBuilder> singleFieldBuilderV3 = this.nobleBuilder_;
            if (singleFieldBuilderV3 != null) {
                return (NobleOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
            }
            Noble noble = this.noble_;
            Noble noble2 = noble;
            if (noble == null) {
                noble2 = Noble.getDefaultInstance();
            }
            return noble2;
        }

        @Override // cn.irisgw.live.UserProfileOrBuilder
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

        @Override // cn.irisgw.live.UserProfileOrBuilder
        public int getPrivilegeCount() {
            RepeatedFieldBuilderV3<UserPrivilege, UserPrivilege.Builder, UserPrivilegeOrBuilder> repeatedFieldBuilderV3 = this.privilegeBuilder_;
            return repeatedFieldBuilderV3 == null ? this.privilege_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // cn.irisgw.live.UserProfileOrBuilder
        public List<UserPrivilege> getPrivilegeList() {
            RepeatedFieldBuilderV3<UserPrivilege, UserPrivilege.Builder, UserPrivilegeOrBuilder> repeatedFieldBuilderV3 = this.privilegeBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.privilege_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // cn.irisgw.live.UserProfileOrBuilder
        public UserPrivilegeOrBuilder getPrivilegeOrBuilder(int i) {
            RepeatedFieldBuilderV3<UserPrivilege, UserPrivilege.Builder, UserPrivilegeOrBuilder> repeatedFieldBuilderV3 = this.privilegeBuilder_;
            return repeatedFieldBuilderV3 == null ? this.privilege_.get(i) : (UserPrivilegeOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // cn.irisgw.live.UserProfileOrBuilder
        public List<? extends UserPrivilegeOrBuilder> getPrivilegeOrBuilderList() {
            RepeatedFieldBuilderV3<UserPrivilege, UserPrivilege.Builder, UserPrivilegeOrBuilder> repeatedFieldBuilderV3 = this.privilegeBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.privilege_);
        }

        @Override // cn.irisgw.live.UserProfileOrBuilder
        public int getRichLevel() {
            return this.richLevel_;
        }

        @Override // cn.irisgw.live.UserProfileOrBuilder
        public VBadge getVbadge() {
            VBadge valueOf = VBadge.valueOf(this.vbadge_);
            VBadge vBadge = valueOf;
            if (valueOf == null) {
                vBadge = VBadge.UNRECOGNIZED;
            }
            return vBadge;
        }

        @Override // cn.irisgw.live.UserProfileOrBuilder
        public int getVbadgeValue() {
            return this.vbadge_;
        }

        @Override // cn.irisgw.live.UserProfileOrBuilder
        public String getVipFrame() {
            Object obj = this.vipFrame_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.vipFrame_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.UserProfileOrBuilder
        public ByteString getVipFrameBytes() {
            Object obj = this.vipFrame_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.vipFrame_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.UserProfileOrBuilder
        public int getVipLevel() {
            return this.vipLevel_;
        }

        @Override // cn.irisgw.live.UserProfileOrBuilder
        public boolean hasNoble() {
            return (this.nobleBuilder_ == null && this.noble_ == null) ? false : true;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_UserProfile_fieldAccessorTable.ensureFieldAccessorsInitialized(UserProfile.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(UserProfile userProfile) {
            if (userProfile == UserProfile.getDefaultInstance()) {
                return this;
            }
            if (!userProfile.getAvatar().isEmpty()) {
                this.avatar_ = userProfile.avatar_;
                onChanged();
            }
            if (!userProfile.getName().isEmpty()) {
                this.name_ = userProfile.name_;
                onChanged();
            }
            if (userProfile.vbadge_ != 0) {
                setVbadgeValue(userProfile.getVbadgeValue());
            }
            if (userProfile.getRichLevel() != 0) {
                setRichLevel(userProfile.getRichLevel());
            }
            if (userProfile.getIsManager() != 0) {
                setIsManager(userProfile.getIsManager());
            }
            if (this.privilegeBuilder_ == null) {
                if (!userProfile.privilege_.isEmpty()) {
                    if (this.privilege_.isEmpty()) {
                        this.privilege_ = userProfile.privilege_;
                        this.bitField0_ &= -2;
                    } else {
                        ensurePrivilegeIsMutable();
                        this.privilege_.addAll(userProfile.privilege_);
                    }
                    onChanged();
                }
            } else if (!userProfile.privilege_.isEmpty()) {
                if (this.privilegeBuilder_.isEmpty()) {
                    this.privilegeBuilder_.dispose();
                    RepeatedFieldBuilderV3<UserPrivilege, UserPrivilege.Builder, UserPrivilegeOrBuilder> repeatedFieldBuilderV3 = null;
                    this.privilegeBuilder_ = null;
                    this.privilege_ = userProfile.privilege_;
                    this.bitField0_ &= -2;
                    if (UserProfile.alwaysUseFieldBuilders) {
                        repeatedFieldBuilderV3 = getPrivilegeFieldBuilder();
                    }
                    this.privilegeBuilder_ = repeatedFieldBuilderV3;
                } else {
                    this.privilegeBuilder_.addAllMessages(userProfile.privilege_);
                }
            }
            if (userProfile.hasNoble()) {
                mergeNoble(userProfile.getNoble());
            }
            if (!userProfile.getVipFrame().isEmpty()) {
                this.vipFrame_ = userProfile.vipFrame_;
                onChanged();
            }
            if (userProfile.getVipLevel() != 0) {
                setVipLevel(userProfile.getVipLevel());
            }
            m7960mergeUnknownFields(userProfile.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.UserProfile.Builder m7957mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.UserProfile.access$3800()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.UserProfile r0 = (cn.irisgw.live.UserProfile) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.UserProfile$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.UserProfile r0 = (cn.irisgw.live.UserProfile) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.UserProfile$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.UserProfile.Builder.m7957mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.UserProfile$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m7956mergeFrom(Message message) {
            if (message instanceof UserProfile) {
                return mergeFrom((UserProfile) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeNoble(Noble noble) {
            SingleFieldBuilderV3<Noble, Noble.Builder, NobleOrBuilder> singleFieldBuilderV3 = this.nobleBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.mergeFrom(noble);
                return this;
            }
            Noble noble2 = this.noble_;
            if (noble2 != null) {
                this.noble_ = Noble.newBuilder(noble2).mergeFrom(noble).m7981buildPartial();
            } else {
                this.noble_ = noble;
            }
            onChanged();
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m7960mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
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
                UserProfile.checkByteStringIsUtf8(byteString);
                this.avatar_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        /* renamed from: setField */
        public Builder m7962setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setIsManager(int i) {
            this.isManager_ = i;
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
                UserProfile.checkByteStringIsUtf8(byteString);
                this.name_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setNoble(Noble.Builder builder) {
            SingleFieldBuilderV3<Noble, Noble.Builder, NobleOrBuilder> singleFieldBuilderV3 = this.nobleBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(builder.m7979build());
                return this;
            }
            this.noble_ = builder.m7979build();
            onChanged();
            return this;
        }

        public Builder setNoble(Noble noble) {
            SingleFieldBuilderV3<Noble, Noble.Builder, NobleOrBuilder> singleFieldBuilderV3 = this.nobleBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(noble);
                return this;
            } else if (noble != null) {
                this.noble_ = noble;
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder setPrivilege(int i, UserPrivilege.Builder builder) {
            RepeatedFieldBuilderV3<UserPrivilege, UserPrivilege.Builder, UserPrivilegeOrBuilder> repeatedFieldBuilderV3 = this.privilegeBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.m8026build());
                return this;
            }
            ensurePrivilegeIsMutable();
            this.privilege_.set(i, builder.m8026build());
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
        public Builder m7964setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setRichLevel(int i) {
            this.richLevel_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setUnknownFields */
        public final Builder m7966setUnknownFields(UnknownFieldSet unknownFieldSet) {
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

        public Builder setVipFrame(String str) {
            if (str != null) {
                this.vipFrame_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setVipFrameBytes(ByteString byteString) {
            if (byteString != null) {
                UserProfile.checkByteStringIsUtf8(byteString);
                this.vipFrame_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setVipLevel(int i) {
            this.vipLevel_ = i;
            onChanged();
            return this;
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/UserProfile$Noble.class */
    public static final class Noble extends GeneratedMessageV3 implements NobleOrBuilder {
        public static final int NAMEPLATE_IMG_FIELD_NUMBER = 3;
        public static final int NAMEPLATE_IMG_HEIGHT_FIELD_NUMBER = 5;
        public static final int NAMEPLATE_IMG_WIDTH_FIELD_NUMBER = 4;
        public static final int NOBLE_LEVEL_FIELD_NUMBER = 1;
        public static final int NOBLE_NAME_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private int nameplateImgHeight_;
        private int nameplateImgWidth_;
        private volatile Object nameplateImg_;
        private int nobleLevel_;
        private volatile Object nobleName_;
        private static final Noble DEFAULT_INSTANCE = new Noble();
        private static final Parser<Noble> PARSER = new AbstractParser<Noble>() { // from class: cn.irisgw.live.UserProfile.Noble.1
            /* renamed from: parsePartialFrom */
            public Noble m7975parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Noble(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/UserProfile$Noble$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements NobleOrBuilder {
            private int nameplateImgHeight_;
            private int nameplateImgWidth_;
            private Object nameplateImg_;
            private int nobleLevel_;
            private Object nobleName_;

            private Builder() {
                this.nobleName_ = "";
                this.nameplateImg_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.nobleName_ = "";
                this.nameplateImg_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LiveConstants.internal_static_cn_irisgw_live_UserProfile_Noble_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = Noble.alwaysUseFieldBuilders;
            }

            /* renamed from: addRepeatedField */
            public Builder m7977addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: build */
            public Noble m7979build() {
                Noble m7981buildPartial = m7981buildPartial();
                if (m7981buildPartial.isInitialized()) {
                    return m7981buildPartial;
                }
                throw newUninitializedMessageException(m7981buildPartial);
            }

            /* renamed from: buildPartial */
            public Noble m7981buildPartial() {
                Noble noble = new Noble(this);
                noble.nobleLevel_ = this.nobleLevel_;
                noble.nobleName_ = this.nobleName_;
                noble.nameplateImg_ = this.nameplateImg_;
                noble.nameplateImgWidth_ = this.nameplateImgWidth_;
                noble.nameplateImgHeight_ = this.nameplateImgHeight_;
                onBuilt();
                return noble;
            }

            /* renamed from: clear */
            public Builder m7985clear() {
                super.clear();
                this.nobleLevel_ = 0;
                this.nobleName_ = "";
                this.nameplateImg_ = "";
                this.nameplateImgWidth_ = 0;
                this.nameplateImgHeight_ = 0;
                return this;
            }

            /* renamed from: clearField */
            public Builder m7987clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearNameplateImg() {
                this.nameplateImg_ = Noble.getDefaultInstance().getNameplateImg();
                onChanged();
                return this;
            }

            public Builder clearNameplateImgHeight() {
                this.nameplateImgHeight_ = 0;
                onChanged();
                return this;
            }

            public Builder clearNameplateImgWidth() {
                this.nameplateImgWidth_ = 0;
                onChanged();
                return this;
            }

            public Builder clearNobleLevel() {
                this.nobleLevel_ = 0;
                onChanged();
                return this;
            }

            public Builder clearNobleName() {
                this.nobleName_ = Noble.getDefaultInstance().getNobleName();
                onChanged();
                return this;
            }

            /* renamed from: clearOneof */
            public Builder m7990clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            /* renamed from: clone */
            public Builder m7996clone() {
                return (Builder) super.clone();
            }

            /* renamed from: getDefaultInstanceForType */
            public Noble m7998getDefaultInstanceForType() {
                return Noble.getDefaultInstance();
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return LiveConstants.internal_static_cn_irisgw_live_UserProfile_Noble_descriptor;
            }

            @Override // cn.irisgw.live.UserProfile.NobleOrBuilder
            public String getNameplateImg() {
                Object obj = this.nameplateImg_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.nameplateImg_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.UserProfile.NobleOrBuilder
            public ByteString getNameplateImgBytes() {
                Object obj = this.nameplateImg_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.nameplateImg_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.UserProfile.NobleOrBuilder
            public int getNameplateImgHeight() {
                return this.nameplateImgHeight_;
            }

            @Override // cn.irisgw.live.UserProfile.NobleOrBuilder
            public int getNameplateImgWidth() {
                return this.nameplateImgWidth_;
            }

            @Override // cn.irisgw.live.UserProfile.NobleOrBuilder
            public int getNobleLevel() {
                return this.nobleLevel_;
            }

            @Override // cn.irisgw.live.UserProfile.NobleOrBuilder
            public String getNobleName() {
                Object obj = this.nobleName_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.nobleName_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.UserProfile.NobleOrBuilder
            public ByteString getNobleNameBytes() {
                Object obj = this.nobleName_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.nobleName_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveConstants.internal_static_cn_irisgw_live_UserProfile_Noble_fieldAccessorTable.ensureFieldAccessorsInitialized(Noble.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(Noble noble) {
                if (noble == Noble.getDefaultInstance()) {
                    return this;
                }
                if (noble.getNobleLevel() != 0) {
                    setNobleLevel(noble.getNobleLevel());
                }
                if (!noble.getNobleName().isEmpty()) {
                    this.nobleName_ = noble.nobleName_;
                    onChanged();
                }
                if (!noble.getNameplateImg().isEmpty()) {
                    this.nameplateImg_ = noble.nameplateImg_;
                    onChanged();
                }
                if (noble.getNameplateImgWidth() != 0) {
                    setNameplateImgWidth(noble.getNameplateImgWidth());
                }
                if (noble.getNameplateImgHeight() != 0) {
                    setNameplateImgHeight(noble.getNameplateImgHeight());
                }
                m8007mergeUnknownFields(noble.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            /* renamed from: mergeFrom */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.UserProfile.Noble.Builder m8004mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.UserProfile.Noble.access$1900()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.UserProfile$Noble r0 = (cn.irisgw.live.UserProfile.Noble) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.UserProfile$Noble$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.UserProfile$Noble r0 = (cn.irisgw.live.UserProfile.Noble) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.UserProfile$Noble$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.UserProfile.Noble.Builder.m8004mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.UserProfile$Noble$Builder");
            }

            /* renamed from: mergeFrom */
            public Builder m8003mergeFrom(Message message) {
                if (message instanceof Noble) {
                    return mergeFrom((Noble) message);
                }
                super.mergeFrom(message);
                return this;
            }

            /* renamed from: mergeUnknownFields */
            public final Builder m8007mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            /* renamed from: setField */
            public Builder m8009setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setNameplateImg(String str) {
                if (str != null) {
                    this.nameplateImg_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setNameplateImgBytes(ByteString byteString) {
                if (byteString != null) {
                    Noble.checkByteStringIsUtf8(byteString);
                    this.nameplateImg_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setNameplateImgHeight(int i) {
                this.nameplateImgHeight_ = i;
                onChanged();
                return this;
            }

            public Builder setNameplateImgWidth(int i) {
                this.nameplateImgWidth_ = i;
                onChanged();
                return this;
            }

            public Builder setNobleLevel(int i) {
                this.nobleLevel_ = i;
                onChanged();
                return this;
            }

            public Builder setNobleName(String str) {
                if (str != null) {
                    this.nobleName_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setNobleNameBytes(ByteString byteString) {
                if (byteString != null) {
                    Noble.checkByteStringIsUtf8(byteString);
                    this.nobleName_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            /* renamed from: setRepeatedField */
            public Builder m8011setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            /* renamed from: setUnknownFields */
            public final Builder m8013setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private Noble() {
            this.memoizedIsInitialized = (byte) -1;
            this.nobleName_ = "";
            this.nameplateImg_ = "";
        }

        private Noble(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.nobleLevel_ = codedInputStream.readUInt32();
                            } else if (readTag == 18) {
                                this.nobleName_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 26) {
                                this.nameplateImg_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 32) {
                                this.nameplateImgWidth_ = codedInputStream.readUInt32();
                            } else if (readTag == 40) {
                                this.nameplateImgHeight_ = codedInputStream.readUInt32();
                            } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                            }
                        }
                        z = true;
                    } catch (IOException e) {
                        throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        private Noble(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Noble getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_UserProfile_Noble_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m7974toBuilder();
        }

        public static Builder newBuilder(Noble noble) {
            return DEFAULT_INSTANCE.m7974toBuilder().mergeFrom(noble);
        }

        public static Noble parseDelimitedFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Noble parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Noble parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Noble) PARSER.parseFrom(byteString);
        }

        public static Noble parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Noble) PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Noble parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Noble parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static Noble parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Noble parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Noble parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Noble) PARSER.parseFrom(byteBuffer);
        }

        public static Noble parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Noble) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Noble parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Noble) PARSER.parseFrom(bArr);
        }

        public static Noble parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Noble) PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<Noble> parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Noble) {
                Noble noble = (Noble) obj;
                return getNobleLevel() == noble.getNobleLevel() && getNobleName().equals(noble.getNobleName()) && getNameplateImg().equals(noble.getNameplateImg()) && getNameplateImgWidth() == noble.getNameplateImgWidth() && getNameplateImgHeight() == noble.getNameplateImgHeight() && this.unknownFields.equals(noble.unknownFields);
            }
            return super.equals(obj);
        }

        /* renamed from: getDefaultInstanceForType */
        public Noble m7969getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // cn.irisgw.live.UserProfile.NobleOrBuilder
        public String getNameplateImg() {
            Object obj = this.nameplateImg_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.nameplateImg_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.UserProfile.NobleOrBuilder
        public ByteString getNameplateImgBytes() {
            Object obj = this.nameplateImg_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.nameplateImg_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.UserProfile.NobleOrBuilder
        public int getNameplateImgHeight() {
            return this.nameplateImgHeight_;
        }

        @Override // cn.irisgw.live.UserProfile.NobleOrBuilder
        public int getNameplateImgWidth() {
            return this.nameplateImgWidth_;
        }

        @Override // cn.irisgw.live.UserProfile.NobleOrBuilder
        public int getNobleLevel() {
            return this.nobleLevel_;
        }

        @Override // cn.irisgw.live.UserProfile.NobleOrBuilder
        public String getNobleName() {
            Object obj = this.nobleName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.nobleName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.UserProfile.NobleOrBuilder
        public ByteString getNobleNameBytes() {
            Object obj = this.nobleName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.nobleName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Parser<Noble> getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            int i3 = this.nobleLevel_;
            if (i3 != 0) {
                i2 = 0 + CodedOutputStream.computeUInt32Size(1, i3);
            }
            int i4 = i2;
            if (!getNobleNameBytes().isEmpty()) {
                i4 = i2 + GeneratedMessageV3.computeStringSize(2, this.nobleName_);
            }
            int i5 = i4;
            if (!getNameplateImgBytes().isEmpty()) {
                i5 = i4 + GeneratedMessageV3.computeStringSize(3, this.nameplateImg_);
            }
            int i6 = this.nameplateImgWidth_;
            int i7 = i5;
            if (i6 != 0) {
                i7 = i5 + CodedOutputStream.computeUInt32Size(4, i6);
            }
            int i8 = this.nameplateImgHeight_;
            int i9 = i7;
            if (i8 != 0) {
                i9 = i7 + CodedOutputStream.computeUInt32Size(5, i8);
            }
            int serializedSize = i9 + this.unknownFields.getSerializedSize();
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
            int hashCode = ((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getNobleLevel()) * 37) + 2) * 53) + getNobleName().hashCode()) * 37) + 3) * 53) + getNameplateImg().hashCode()) * 37) + 4) * 53) + getNameplateImgWidth()) * 37) + 5) * 53) + getNameplateImgHeight()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_UserProfile_Noble_fieldAccessorTable.ensureFieldAccessorsInitialized(Noble.class, Builder.class);
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
        public Builder m7972newBuilderForType() {
            return newBuilder();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: newBuilderForType */
        public Builder m7971newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new Noble();
        }

        /* renamed from: toBuilder */
        public Builder m7974toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i = this.nobleLevel_;
            if (i != 0) {
                codedOutputStream.writeUInt32(1, i);
            }
            if (!getNobleNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.nobleName_);
            }
            if (!getNameplateImgBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.nameplateImg_);
            }
            int i2 = this.nameplateImgWidth_;
            if (i2 != 0) {
                codedOutputStream.writeUInt32(4, i2);
            }
            int i3 = this.nameplateImgHeight_;
            if (i3 != 0) {
                codedOutputStream.writeUInt32(5, i3);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/UserProfile$NobleOrBuilder.class */
    public interface NobleOrBuilder extends MessageOrBuilder {
        String getNameplateImg();

        ByteString getNameplateImgBytes();

        int getNameplateImgHeight();

        int getNameplateImgWidth();

        int getNobleLevel();

        String getNobleName();

        ByteString getNobleNameBytes();
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/UserProfile$UserPrivilege.class */
    public static final class UserPrivilege extends GeneratedMessageV3 implements UserPrivilegeOrBuilder {
        private static final UserPrivilege DEFAULT_INSTANCE = new UserPrivilege();
        private static final Parser<UserPrivilege> PARSER = new AbstractParser<UserPrivilege>() { // from class: cn.irisgw.live.UserProfile.UserPrivilege.1
            /* renamed from: parsePartialFrom */
            public UserPrivilege m8022parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new UserPrivilege(codedInputStream, extensionRegistryLite);
            }
        };
        public static final int STATUS_FIELD_NUMBER = 2;
        public static final int TYPE_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private int status_;
        private int type_;

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/UserProfile$UserPrivilege$Builder.class */
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
                return LiveConstants.internal_static_cn_irisgw_live_UserProfile_UserPrivilege_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = UserPrivilege.alwaysUseFieldBuilders;
            }

            /* renamed from: addRepeatedField */
            public Builder m8024addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: build */
            public UserPrivilege m8026build() {
                UserPrivilege m8028buildPartial = m8028buildPartial();
                if (m8028buildPartial.isInitialized()) {
                    return m8028buildPartial;
                }
                throw newUninitializedMessageException(m8028buildPartial);
            }

            /* renamed from: buildPartial */
            public UserPrivilege m8028buildPartial() {
                UserPrivilege userPrivilege = new UserPrivilege(this);
                userPrivilege.type_ = this.type_;
                userPrivilege.status_ = this.status_;
                onBuilt();
                return userPrivilege;
            }

            /* renamed from: clear */
            public Builder m8032clear() {
                super.clear();
                this.type_ = 0;
                this.status_ = 0;
                return this;
            }

            /* renamed from: clearField */
            public Builder m8034clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            /* renamed from: clearOneof */
            public Builder m8037clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
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
            public Builder m8043clone() {
                return (Builder) super.clone();
            }

            /* renamed from: getDefaultInstanceForType */
            public UserPrivilege m8045getDefaultInstanceForType() {
                return UserPrivilege.getDefaultInstance();
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return LiveConstants.internal_static_cn_irisgw_live_UserProfile_UserPrivilege_descriptor;
            }

            @Override // cn.irisgw.live.UserProfile.UserPrivilegeOrBuilder
            public PrivilegeStatus getStatus() {
                PrivilegeStatus valueOf = PrivilegeStatus.valueOf(this.status_);
                PrivilegeStatus privilegeStatus = valueOf;
                if (valueOf == null) {
                    privilegeStatus = PrivilegeStatus.UNRECOGNIZED;
                }
                return privilegeStatus;
            }

            @Override // cn.irisgw.live.UserProfile.UserPrivilegeOrBuilder
            public int getStatusValue() {
                return this.status_;
            }

            @Override // cn.irisgw.live.UserProfile.UserPrivilegeOrBuilder
            public PrivilegeType getType() {
                PrivilegeType valueOf = PrivilegeType.valueOf(this.type_);
                PrivilegeType privilegeType = valueOf;
                if (valueOf == null) {
                    privilegeType = PrivilegeType.UNRECOGNIZED;
                }
                return privilegeType;
            }

            @Override // cn.irisgw.live.UserProfile.UserPrivilegeOrBuilder
            public int getTypeValue() {
                return this.type_;
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveConstants.internal_static_cn_irisgw_live_UserProfile_UserPrivilege_fieldAccessorTable.ensureFieldAccessorsInitialized(UserPrivilege.class, Builder.class);
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
                m8054mergeUnknownFields(userPrivilege.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            /* renamed from: mergeFrom */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.UserProfile.UserPrivilege.Builder m8051mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.UserProfile.UserPrivilege.access$700()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.UserProfile$UserPrivilege r0 = (cn.irisgw.live.UserProfile.UserPrivilege) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.UserProfile$UserPrivilege$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.UserProfile$UserPrivilege r0 = (cn.irisgw.live.UserProfile.UserPrivilege) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.UserProfile$UserPrivilege$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.UserProfile.UserPrivilege.Builder.m8051mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.UserProfile$UserPrivilege$Builder");
            }

            /* renamed from: mergeFrom */
            public Builder m8050mergeFrom(Message message) {
                if (message instanceof UserPrivilege) {
                    return mergeFrom((UserPrivilege) message);
                }
                super.mergeFrom(message);
                return this;
            }

            /* renamed from: mergeUnknownFields */
            public final Builder m8054mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            /* renamed from: setField */
            public Builder m8056setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            /* renamed from: setRepeatedField */
            public Builder m8058setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
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
            public final Builder m8060setUnknownFields(UnknownFieldSet unknownFieldSet) {
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
            return LiveConstants.internal_static_cn_irisgw_live_UserProfile_UserPrivilege_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m8021toBuilder();
        }

        public static Builder newBuilder(UserPrivilege userPrivilege) {
            return DEFAULT_INSTANCE.m8021toBuilder().mergeFrom(userPrivilege);
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
        public UserPrivilege m8016getDefaultInstanceForType() {
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

        @Override // cn.irisgw.live.UserProfile.UserPrivilegeOrBuilder
        public PrivilegeStatus getStatus() {
            PrivilegeStatus valueOf = PrivilegeStatus.valueOf(this.status_);
            PrivilegeStatus privilegeStatus = valueOf;
            if (valueOf == null) {
                privilegeStatus = PrivilegeStatus.UNRECOGNIZED;
            }
            return privilegeStatus;
        }

        @Override // cn.irisgw.live.UserProfile.UserPrivilegeOrBuilder
        public int getStatusValue() {
            return this.status_;
        }

        @Override // cn.irisgw.live.UserProfile.UserPrivilegeOrBuilder
        public PrivilegeType getType() {
            PrivilegeType valueOf = PrivilegeType.valueOf(this.type_);
            PrivilegeType privilegeType = valueOf;
            if (valueOf == null) {
                privilegeType = PrivilegeType.UNRECOGNIZED;
            }
            return privilegeType;
        }

        @Override // cn.irisgw.live.UserProfile.UserPrivilegeOrBuilder
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
            return LiveConstants.internal_static_cn_irisgw_live_UserProfile_UserPrivilege_fieldAccessorTable.ensureFieldAccessorsInitialized(UserPrivilege.class, Builder.class);
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
        public Builder m8019newBuilderForType() {
            return newBuilder();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: newBuilderForType */
        public Builder m8018newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new UserPrivilege();
        }

        /* renamed from: toBuilder */
        public Builder m8021toBuilder() {
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

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/UserProfile$UserPrivilegeOrBuilder.class */
    public interface UserPrivilegeOrBuilder extends MessageOrBuilder {
        PrivilegeStatus getStatus();

        int getStatusValue();

        PrivilegeType getType();

        int getTypeValue();
    }

    private UserProfile() {
        this.memoizedIsInitialized = (byte) -1;
        this.avatar_ = "";
        this.name_ = "";
        this.vbadge_ = 0;
        this.privilege_ = Collections.emptyList();
        this.vipFrame_ = "";
    }

    private UserProfile(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        Noble.Builder builder;
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
                            this.avatar_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 18) {
                            this.name_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 24) {
                            this.vbadge_ = codedInputStream.readEnum();
                        } else if (readTag == 32) {
                            this.richLevel_ = codedInputStream.readUInt32();
                        } else if (readTag == 40) {
                            this.isManager_ = codedInputStream.readUInt32();
                        } else if (readTag == 50) {
                            boolean z4 = z2;
                            if (!(z2 & true)) {
                                this.privilege_ = new ArrayList();
                                z4 = z2 | true;
                            }
                            this.privilege_.add((UserPrivilege) codedInputStream.readMessage(UserPrivilege.parser(), extensionRegistryLite));
                            z2 = z4;
                        } else if (readTag == 58) {
                            if (this.noble_ != null) {
                                boolean z5 = z2;
                                builder = this.noble_.m7974toBuilder();
                            } else {
                                builder = null;
                            }
                            Noble readMessage = codedInputStream.readMessage(Noble.parser(), extensionRegistryLite);
                            boolean z6 = z2;
                            this.noble_ = readMessage;
                            if (builder != null) {
                                builder.mergeFrom(readMessage);
                                boolean z7 = z2;
                                this.noble_ = builder.m7981buildPartial();
                            }
                        } else if (readTag == 66) {
                            this.vipFrame_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 72) {
                            this.vipLevel_ = codedInputStream.readUInt32();
                        } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
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

    private UserProfile(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static UserProfile getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_UserProfile_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m7927toBuilder();
    }

    public static Builder newBuilder(UserProfile userProfile) {
        return DEFAULT_INSTANCE.m7927toBuilder().mergeFrom(userProfile);
    }

    public static UserProfile parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static UserProfile parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static UserProfile parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (UserProfile) PARSER.parseFrom(byteString);
    }

    public static UserProfile parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (UserProfile) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static UserProfile parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static UserProfile parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static UserProfile parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static UserProfile parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static UserProfile parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (UserProfile) PARSER.parseFrom(byteBuffer);
    }

    public static UserProfile parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (UserProfile) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static UserProfile parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (UserProfile) PARSER.parseFrom(bArr);
    }

    public static UserProfile parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (UserProfile) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<UserProfile> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof UserProfile) {
            UserProfile userProfile = (UserProfile) obj;
            if (getAvatar().equals(userProfile.getAvatar()) && getName().equals(userProfile.getName()) && this.vbadge_ == userProfile.vbadge_ && getRichLevel() == userProfile.getRichLevel() && getIsManager() == userProfile.getIsManager() && getPrivilegeList().equals(userProfile.getPrivilegeList()) && hasNoble() == userProfile.hasNoble()) {
                return (!hasNoble() || getNoble().equals(userProfile.getNoble())) && getVipFrame().equals(userProfile.getVipFrame()) && getVipLevel() == userProfile.getVipLevel() && this.unknownFields.equals(userProfile.unknownFields);
            }
            return false;
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.UserProfileOrBuilder
    public String getAvatar() {
        Object obj = this.avatar_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.avatar_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.UserProfileOrBuilder
    public ByteString getAvatarBytes() {
        Object obj = this.avatar_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.avatar_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    /* renamed from: getDefaultInstanceForType */
    public UserProfile m7922getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.UserProfileOrBuilder
    public int getIsManager() {
        return this.isManager_;
    }

    @Override // cn.irisgw.live.UserProfileOrBuilder
    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.UserProfileOrBuilder
    public ByteString getNameBytes() {
        Object obj = this.name_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.name_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.UserProfileOrBuilder
    public Noble getNoble() {
        Noble noble = this.noble_;
        Noble noble2 = noble;
        if (noble == null) {
            noble2 = Noble.getDefaultInstance();
        }
        return noble2;
    }

    @Override // cn.irisgw.live.UserProfileOrBuilder
    public NobleOrBuilder getNobleOrBuilder() {
        return getNoble();
    }

    public Parser<UserProfile> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.UserProfileOrBuilder
    public UserPrivilege getPrivilege(int i) {
        return this.privilege_.get(i);
    }

    @Override // cn.irisgw.live.UserProfileOrBuilder
    public int getPrivilegeCount() {
        return this.privilege_.size();
    }

    @Override // cn.irisgw.live.UserProfileOrBuilder
    public List<UserPrivilege> getPrivilegeList() {
        return this.privilege_;
    }

    @Override // cn.irisgw.live.UserProfileOrBuilder
    public UserPrivilegeOrBuilder getPrivilegeOrBuilder(int i) {
        return this.privilege_.get(i);
    }

    @Override // cn.irisgw.live.UserProfileOrBuilder
    public List<? extends UserPrivilegeOrBuilder> getPrivilegeOrBuilderList() {
        return this.privilege_;
    }

    @Override // cn.irisgw.live.UserProfileOrBuilder
    public int getRichLevel() {
        return this.richLevel_;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int computeStringSize = !getAvatarBytes().isEmpty() ? GeneratedMessageV3.computeStringSize(1, this.avatar_) + 0 : 0;
        int i2 = computeStringSize;
        if (!getNameBytes().isEmpty()) {
            i2 = computeStringSize + GeneratedMessageV3.computeStringSize(2, this.name_);
        }
        int i3 = i2;
        if (this.vbadge_ != VBadge.EMPTY_V.getNumber()) {
            i3 = i2 + CodedOutputStream.computeEnumSize(3, this.vbadge_);
        }
        int i4 = this.richLevel_;
        int i5 = i3;
        if (i4 != 0) {
            i5 = i3 + CodedOutputStream.computeUInt32Size(4, i4);
        }
        int i6 = this.isManager_;
        int i7 = i5;
        int i8 = 0;
        if (i6 != 0) {
            i7 = i5 + CodedOutputStream.computeUInt32Size(5, i6);
            i8 = 0;
        }
        while (i8 < this.privilege_.size()) {
            i7 += CodedOutputStream.computeMessageSize(6, this.privilege_.get(i8));
            i8++;
        }
        int i9 = i7;
        if (this.noble_ != null) {
            i9 = i7 + CodedOutputStream.computeMessageSize(7, getNoble());
        }
        int i10 = i9;
        if (!getVipFrameBytes().isEmpty()) {
            i10 = i9 + GeneratedMessageV3.computeStringSize(8, this.vipFrame_);
        }
        int i11 = this.vipLevel_;
        int i12 = i10;
        if (i11 != 0) {
            i12 = i10 + CodedOutputStream.computeUInt32Size(9, i11);
        }
        int serializedSize = i12 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // cn.irisgw.live.UserProfileOrBuilder
    public VBadge getVbadge() {
        VBadge valueOf = VBadge.valueOf(this.vbadge_);
        VBadge vBadge = valueOf;
        if (valueOf == null) {
            vBadge = VBadge.UNRECOGNIZED;
        }
        return vBadge;
    }

    @Override // cn.irisgw.live.UserProfileOrBuilder
    public int getVbadgeValue() {
        return this.vbadge_;
    }

    @Override // cn.irisgw.live.UserProfileOrBuilder
    public String getVipFrame() {
        Object obj = this.vipFrame_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.vipFrame_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.UserProfileOrBuilder
    public ByteString getVipFrameBytes() {
        Object obj = this.vipFrame_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.vipFrame_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.UserProfileOrBuilder
    public int getVipLevel() {
        return this.vipLevel_;
    }

    @Override // cn.irisgw.live.UserProfileOrBuilder
    public boolean hasNoble() {
        return this.noble_ != null;
    }

    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getAvatar().hashCode()) * 37) + 2) * 53) + getName().hashCode()) * 37) + 3) * 53) + this.vbadge_) * 37) + 4) * 53) + getRichLevel()) * 37) + 5) * 53) + getIsManager();
        int i = hashCode;
        if (getPrivilegeCount() > 0) {
            i = (((hashCode * 37) + 6) * 53) + getPrivilegeList().hashCode();
        }
        int i2 = i;
        if (hasNoble()) {
            i2 = (((i * 37) + 7) * 53) + getNoble().hashCode();
        }
        int hashCode2 = (((((((((i2 * 37) + 8) * 53) + getVipFrame().hashCode()) * 37) + 9) * 53) + getVipLevel()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_UserProfile_fieldAccessorTable.ensureFieldAccessorsInitialized(UserProfile.class, Builder.class);
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
    public Builder m7925newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m7924newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new UserProfile();
    }

    /* renamed from: toBuilder */
    public Builder m7927toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!getAvatarBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.avatar_);
        }
        if (!getNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.name_);
        }
        if (this.vbadge_ != VBadge.EMPTY_V.getNumber()) {
            codedOutputStream.writeEnum(3, this.vbadge_);
        }
        int i = this.richLevel_;
        if (i != 0) {
            codedOutputStream.writeUInt32(4, i);
        }
        int i2 = this.isManager_;
        if (i2 != 0) {
            codedOutputStream.writeUInt32(5, i2);
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.privilege_.size()) {
                break;
            }
            codedOutputStream.writeMessage(6, this.privilege_.get(i4));
            i3 = i4 + 1;
        }
        if (this.noble_ != null) {
            codedOutputStream.writeMessage(7, getNoble());
        }
        if (!getVipFrameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 8, this.vipFrame_);
        }
        int i5 = this.vipLevel_;
        if (i5 != 0) {
            codedOutputStream.writeUInt32(9, i5);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
