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
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LinkMultiUpdate.class */
public final class LinkMultiUpdate extends GeneratedMessageV3 implements LinkMultiUpdateOrBuilder {
    public static final int ACTION_FIELD_NUMBER = 3;
    public static final int ACTION_TYPE_FIELD_NUMBER = 4;
    public static final int ACTION_USERS_FIELD_NUMBER = 2;
    private static final LinkMultiUpdate DEFAULT_INSTANCE = new LinkMultiUpdate();
    private static final Parser<LinkMultiUpdate> PARSER = new AbstractParser<LinkMultiUpdate>() { // from class: cn.irisgw.live.LinkMultiUpdate.1
        /* renamed from: parsePartialFrom */
        public LinkMultiUpdate m4230parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new LinkMultiUpdate(codedInputStream, extensionRegistryLite);
        }
    };
    public static final int USERS_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private int actionType_;
    private LinkMultiUser actionUsers_;
    private int action_;
    private byte memoizedIsInitialized;
    private List<LinkMultiUser> users_;

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LinkMultiUpdate$Action.class */
    public enum Action implements ProtocolMessageEnum {
        None(0),
        Up(1),
        Down(2),
        UNRECOGNIZED(-1);
        
        public static final int Down_VALUE = 2;
        public static final int None_VALUE = 0;
        public static final int Up_VALUE = 1;
        private final int value;
        private static final Internal.EnumLiteMap<Action> internalValueMap = new Internal.EnumLiteMap<Action>() { // from class: cn.irisgw.live.LinkMultiUpdate.Action.1
            /* renamed from: findValueByNumber */
            public Action m4232findValueByNumber(int i) {
                return Action.forNumber(i);
            }
        };
        private static final Action[] VALUES = values();

        Action(int i) {
            this.value = i;
        }

        public static Action forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return null;
                    }
                    return Down;
                }
                return Up;
            }
            return None;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return (Descriptors.EnumDescriptor) LinkMultiUpdate.getDescriptor().getEnumTypes().get(0);
        }

        public static Internal.EnumLiteMap<Action> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static Action valueOf(int i) {
            return forNumber(i);
        }

        public static Action valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() == getDescriptor()) {
                return enumValueDescriptor.getIndex() == -1 ? UNRECOGNIZED : VALUES[enumValueDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }

        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this != UNRECOGNIZED) {
                return (Descriptors.EnumValueDescriptor) getDescriptor().getValues().get(ordinal());
            }
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LinkMultiUpdate$ActionType.class */
    public enum ActionType implements ProtocolMessageEnum {
        Default(0),
        Start(1),
        End(2),
        UNRECOGNIZED(-1);
        
        public static final int Default_VALUE = 0;
        public static final int End_VALUE = 2;
        public static final int Start_VALUE = 1;
        private final int value;
        private static final Internal.EnumLiteMap<ActionType> internalValueMap = new Internal.EnumLiteMap<ActionType>() { // from class: cn.irisgw.live.LinkMultiUpdate.ActionType.1
            /* renamed from: findValueByNumber */
            public ActionType m4234findValueByNumber(int i) {
                return ActionType.forNumber(i);
            }
        };
        private static final ActionType[] VALUES = values();

        ActionType(int i) {
            this.value = i;
        }

        public static ActionType forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return null;
                    }
                    return End;
                }
                return Start;
            }
            return Default;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return (Descriptors.EnumDescriptor) LinkMultiUpdate.getDescriptor().getEnumTypes().get(1);
        }

        public static Internal.EnumLiteMap<ActionType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static ActionType valueOf(int i) {
            return forNumber(i);
        }

        public static ActionType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() == getDescriptor()) {
                return enumValueDescriptor.getIndex() == -1 ? UNRECOGNIZED : VALUES[enumValueDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }

        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this != UNRECOGNIZED) {
                return (Descriptors.EnumValueDescriptor) getDescriptor().getValues().get(ordinal());
            }
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LinkMultiUpdate$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LinkMultiUpdateOrBuilder {
        private int actionType_;
        private SingleFieldBuilderV3<LinkMultiUser, LinkMultiUser.Builder, LinkMultiUserOrBuilder> actionUsersBuilder_;
        private LinkMultiUser actionUsers_;
        private int action_;
        private int bitField0_;
        private RepeatedFieldBuilderV3<LinkMultiUser, LinkMultiUser.Builder, LinkMultiUserOrBuilder> usersBuilder_;
        private List<LinkMultiUser> users_;

        private Builder() {
            this.users_ = Collections.emptyList();
            this.action_ = 0;
            this.actionType_ = 0;
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.users_ = Collections.emptyList();
            this.action_ = 0;
            this.actionType_ = 0;
            maybeForceBuilderInitialization();
        }

        private void ensureUsersIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.users_ = new ArrayList(this.users_);
                this.bitField0_ |= 1;
            }
        }

        private SingleFieldBuilderV3<LinkMultiUser, LinkMultiUser.Builder, LinkMultiUserOrBuilder> getActionUsersFieldBuilder() {
            if (this.actionUsersBuilder_ == null) {
                this.actionUsersBuilder_ = new SingleFieldBuilderV3<>(getActionUsers(), getParentForChildren(), isClean());
                this.actionUsers_ = null;
            }
            return this.actionUsersBuilder_;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_LinkMultiUpdate_descriptor;
        }

        private RepeatedFieldBuilderV3<LinkMultiUser, LinkMultiUser.Builder, LinkMultiUserOrBuilder> getUsersFieldBuilder() {
            if (this.usersBuilder_ == null) {
                List<LinkMultiUser> list = this.users_;
                boolean z = true;
                if ((this.bitField0_ & 1) == 0) {
                    z = false;
                }
                this.usersBuilder_ = new RepeatedFieldBuilderV3<>(list, z, getParentForChildren(), isClean());
                this.users_ = null;
            }
            return this.usersBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (LinkMultiUpdate.alwaysUseFieldBuilders) {
                getUsersFieldBuilder();
            }
        }

        public Builder addAllUsers(Iterable<? extends LinkMultiUser> iterable) {
            RepeatedFieldBuilderV3<LinkMultiUser, LinkMultiUser.Builder, LinkMultiUserOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensureUsersIsMutable();
            AbstractMessageLite.Builder.addAll(iterable, this.users_);
            onChanged();
            return this;
        }

        /* renamed from: addRepeatedField */
        public Builder m4236addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        public Builder addUsers(int i, LinkMultiUser.Builder builder) {
            RepeatedFieldBuilderV3<LinkMultiUser, LinkMultiUser.Builder, LinkMultiUserOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.m4285build());
                return this;
            }
            ensureUsersIsMutable();
            this.users_.add(i, builder.m4285build());
            onChanged();
            return this;
        }

        public Builder addUsers(int i, LinkMultiUser linkMultiUser) {
            RepeatedFieldBuilderV3<LinkMultiUser, LinkMultiUser.Builder, LinkMultiUserOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, linkMultiUser);
                return this;
            } else if (linkMultiUser != null) {
                ensureUsersIsMutable();
                this.users_.add(i, linkMultiUser);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addUsers(LinkMultiUser.Builder builder) {
            RepeatedFieldBuilderV3<LinkMultiUser, LinkMultiUser.Builder, LinkMultiUserOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(builder.m4285build());
                return this;
            }
            ensureUsersIsMutable();
            this.users_.add(builder.m4285build());
            onChanged();
            return this;
        }

        public Builder addUsers(LinkMultiUser linkMultiUser) {
            RepeatedFieldBuilderV3<LinkMultiUser, LinkMultiUser.Builder, LinkMultiUserOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(linkMultiUser);
                return this;
            } else if (linkMultiUser != null) {
                ensureUsersIsMutable();
                this.users_.add(linkMultiUser);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public LinkMultiUser.Builder addUsersBuilder() {
            return getUsersFieldBuilder().addBuilder(LinkMultiUser.getDefaultInstance());
        }

        public LinkMultiUser.Builder addUsersBuilder(int i) {
            return getUsersFieldBuilder().addBuilder(i, LinkMultiUser.getDefaultInstance());
        }

        /* renamed from: build */
        public LinkMultiUpdate m4238build() {
            LinkMultiUpdate m4240buildPartial = m4240buildPartial();
            if (m4240buildPartial.isInitialized()) {
                return m4240buildPartial;
            }
            throw newUninitializedMessageException(m4240buildPartial);
        }

        /* renamed from: buildPartial */
        public LinkMultiUpdate m4240buildPartial() {
            LinkMultiUpdate linkMultiUpdate = new LinkMultiUpdate(this);
            int i = this.bitField0_;
            RepeatedFieldBuilderV3<LinkMultiUser, LinkMultiUser.Builder, LinkMultiUserOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((i & 1) != 0) {
                    this.users_ = Collections.unmodifiableList(this.users_);
                    this.bitField0_ &= -2;
                }
                linkMultiUpdate.users_ = this.users_;
            } else {
                linkMultiUpdate.users_ = repeatedFieldBuilderV3.build();
            }
            SingleFieldBuilderV3<LinkMultiUser, LinkMultiUser.Builder, LinkMultiUserOrBuilder> singleFieldBuilderV3 = this.actionUsersBuilder_;
            if (singleFieldBuilderV3 == null) {
                linkMultiUpdate.actionUsers_ = this.actionUsers_;
            } else {
                linkMultiUpdate.actionUsers_ = singleFieldBuilderV3.build();
            }
            linkMultiUpdate.action_ = this.action_;
            linkMultiUpdate.actionType_ = this.actionType_;
            onBuilt();
            return linkMultiUpdate;
        }

        /* renamed from: clear */
        public Builder m4244clear() {
            super.clear();
            RepeatedFieldBuilderV3<LinkMultiUser, LinkMultiUser.Builder, LinkMultiUserOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.users_ = Collections.emptyList();
                this.bitField0_ &= -2;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            if (this.actionUsersBuilder_ == null) {
                this.actionUsers_ = null;
            } else {
                this.actionUsers_ = null;
                this.actionUsersBuilder_ = null;
            }
            this.action_ = 0;
            this.actionType_ = 0;
            return this;
        }

        public Builder clearAction() {
            this.action_ = 0;
            onChanged();
            return this;
        }

        public Builder clearActionType() {
            this.actionType_ = 0;
            onChanged();
            return this;
        }

        public Builder clearActionUsers() {
            if (this.actionUsersBuilder_ == null) {
                this.actionUsers_ = null;
                onChanged();
                return this;
            }
            this.actionUsers_ = null;
            this.actionUsersBuilder_ = null;
            return this;
        }

        /* renamed from: clearField */
        public Builder m4246clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        /* renamed from: clearOneof */
        public Builder m4249clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearUsers() {
            RepeatedFieldBuilderV3<LinkMultiUser, LinkMultiUser.Builder, LinkMultiUserOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.users_ = Collections.emptyList();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m4255clone() {
            return (Builder) super.clone();
        }

        @Override // cn.irisgw.live.LinkMultiUpdateOrBuilder
        public Action getAction() {
            Action valueOf = Action.valueOf(this.action_);
            Action action = valueOf;
            if (valueOf == null) {
                action = Action.UNRECOGNIZED;
            }
            return action;
        }

        @Override // cn.irisgw.live.LinkMultiUpdateOrBuilder
        public ActionType getActionType() {
            ActionType valueOf = ActionType.valueOf(this.actionType_);
            ActionType actionType = valueOf;
            if (valueOf == null) {
                actionType = ActionType.UNRECOGNIZED;
            }
            return actionType;
        }

        @Override // cn.irisgw.live.LinkMultiUpdateOrBuilder
        public int getActionTypeValue() {
            return this.actionType_;
        }

        @Override // cn.irisgw.live.LinkMultiUpdateOrBuilder
        public LinkMultiUser getActionUsers() {
            SingleFieldBuilderV3<LinkMultiUser, LinkMultiUser.Builder, LinkMultiUserOrBuilder> singleFieldBuilderV3 = this.actionUsersBuilder_;
            if (singleFieldBuilderV3 == null) {
                LinkMultiUser linkMultiUser = this.actionUsers_;
                LinkMultiUser linkMultiUser2 = linkMultiUser;
                if (linkMultiUser == null) {
                    linkMultiUser2 = LinkMultiUser.getDefaultInstance();
                }
                return linkMultiUser2;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public LinkMultiUser.Builder getActionUsersBuilder() {
            onChanged();
            return getActionUsersFieldBuilder().getBuilder();
        }

        @Override // cn.irisgw.live.LinkMultiUpdateOrBuilder
        public LinkMultiUserOrBuilder getActionUsersOrBuilder() {
            SingleFieldBuilderV3<LinkMultiUser, LinkMultiUser.Builder, LinkMultiUserOrBuilder> singleFieldBuilderV3 = this.actionUsersBuilder_;
            if (singleFieldBuilderV3 != null) {
                return (LinkMultiUserOrBuilder) singleFieldBuilderV3.getMessageOrBuilder();
            }
            LinkMultiUser linkMultiUser = this.actionUsers_;
            LinkMultiUser linkMultiUser2 = linkMultiUser;
            if (linkMultiUser == null) {
                linkMultiUser2 = LinkMultiUser.getDefaultInstance();
            }
            return linkMultiUser2;
        }

        @Override // cn.irisgw.live.LinkMultiUpdateOrBuilder
        public int getActionValue() {
            return this.action_;
        }

        /* renamed from: getDefaultInstanceForType */
        public LinkMultiUpdate m4257getDefaultInstanceForType() {
            return LinkMultiUpdate.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_LinkMultiUpdate_descriptor;
        }

        @Override // cn.irisgw.live.LinkMultiUpdateOrBuilder
        public LinkMultiUser getUsers(int i) {
            RepeatedFieldBuilderV3<LinkMultiUser, LinkMultiUser.Builder, LinkMultiUserOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            return repeatedFieldBuilderV3 == null ? this.users_.get(i) : repeatedFieldBuilderV3.getMessage(i);
        }

        public LinkMultiUser.Builder getUsersBuilder(int i) {
            return getUsersFieldBuilder().getBuilder(i);
        }

        public List<LinkMultiUser.Builder> getUsersBuilderList() {
            return getUsersFieldBuilder().getBuilderList();
        }

        @Override // cn.irisgw.live.LinkMultiUpdateOrBuilder
        public int getUsersCount() {
            RepeatedFieldBuilderV3<LinkMultiUser, LinkMultiUser.Builder, LinkMultiUserOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            return repeatedFieldBuilderV3 == null ? this.users_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // cn.irisgw.live.LinkMultiUpdateOrBuilder
        public List<LinkMultiUser> getUsersList() {
            RepeatedFieldBuilderV3<LinkMultiUser, LinkMultiUser.Builder, LinkMultiUserOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.users_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // cn.irisgw.live.LinkMultiUpdateOrBuilder
        public LinkMultiUserOrBuilder getUsersOrBuilder(int i) {
            RepeatedFieldBuilderV3<LinkMultiUser, LinkMultiUser.Builder, LinkMultiUserOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            return repeatedFieldBuilderV3 == null ? this.users_.get(i) : (LinkMultiUserOrBuilder) repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // cn.irisgw.live.LinkMultiUpdateOrBuilder
        public List<? extends LinkMultiUserOrBuilder> getUsersOrBuilderList() {
            RepeatedFieldBuilderV3<LinkMultiUser, LinkMultiUser.Builder, LinkMultiUserOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.users_);
        }

        @Override // cn.irisgw.live.LinkMultiUpdateOrBuilder
        public boolean hasActionUsers() {
            return (this.actionUsersBuilder_ == null && this.actionUsers_ == null) ? false : true;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_LinkMultiUpdate_fieldAccessorTable.ensureFieldAccessorsInitialized(LinkMultiUpdate.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeActionUsers(LinkMultiUser linkMultiUser) {
            SingleFieldBuilderV3<LinkMultiUser, LinkMultiUser.Builder, LinkMultiUserOrBuilder> singleFieldBuilderV3 = this.actionUsersBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.mergeFrom(linkMultiUser);
                return this;
            }
            LinkMultiUser linkMultiUser2 = this.actionUsers_;
            if (linkMultiUser2 != null) {
                this.actionUsers_ = LinkMultiUser.newBuilder(linkMultiUser2).mergeFrom(linkMultiUser).m4287buildPartial();
            } else {
                this.actionUsers_ = linkMultiUser;
            }
            onChanged();
            return this;
        }

        public Builder mergeFrom(LinkMultiUpdate linkMultiUpdate) {
            if (linkMultiUpdate == LinkMultiUpdate.getDefaultInstance()) {
                return this;
            }
            if (this.usersBuilder_ == null) {
                if (!linkMultiUpdate.users_.isEmpty()) {
                    if (this.users_.isEmpty()) {
                        this.users_ = linkMultiUpdate.users_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureUsersIsMutable();
                        this.users_.addAll(linkMultiUpdate.users_);
                    }
                    onChanged();
                }
            } else if (!linkMultiUpdate.users_.isEmpty()) {
                if (this.usersBuilder_.isEmpty()) {
                    this.usersBuilder_.dispose();
                    RepeatedFieldBuilderV3<LinkMultiUser, LinkMultiUser.Builder, LinkMultiUserOrBuilder> repeatedFieldBuilderV3 = null;
                    this.usersBuilder_ = null;
                    this.users_ = linkMultiUpdate.users_;
                    this.bitField0_ &= -2;
                    if (LinkMultiUpdate.alwaysUseFieldBuilders) {
                        repeatedFieldBuilderV3 = getUsersFieldBuilder();
                    }
                    this.usersBuilder_ = repeatedFieldBuilderV3;
                } else {
                    this.usersBuilder_.addAllMessages(linkMultiUpdate.users_);
                }
            }
            if (linkMultiUpdate.hasActionUsers()) {
                mergeActionUsers(linkMultiUpdate.getActionUsers());
            }
            if (linkMultiUpdate.action_ != 0) {
                setActionValue(linkMultiUpdate.getActionValue());
            }
            if (linkMultiUpdate.actionType_ != 0) {
                setActionTypeValue(linkMultiUpdate.getActionTypeValue());
            }
            m4266mergeUnknownFields(linkMultiUpdate.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.LinkMultiUpdate.Builder m4263mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.LinkMultiUpdate.access$2600()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.LinkMultiUpdate r0 = (cn.irisgw.live.LinkMultiUpdate) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.LinkMultiUpdate$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.LinkMultiUpdate r0 = (cn.irisgw.live.LinkMultiUpdate) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.LinkMultiUpdate$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.LinkMultiUpdate.Builder.m4263mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.LinkMultiUpdate$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m4262mergeFrom(Message message) {
            if (message instanceof LinkMultiUpdate) {
                return mergeFrom((LinkMultiUpdate) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m4266mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder removeUsers(int i) {
            RepeatedFieldBuilderV3<LinkMultiUser, LinkMultiUser.Builder, LinkMultiUserOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.remove(i);
                return this;
            }
            ensureUsersIsMutable();
            this.users_.remove(i);
            onChanged();
            return this;
        }

        public Builder setAction(Action action) {
            if (action != null) {
                this.action_ = action.getNumber();
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setActionType(ActionType actionType) {
            if (actionType != null) {
                this.actionType_ = actionType.getNumber();
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setActionTypeValue(int i) {
            this.actionType_ = i;
            onChanged();
            return this;
        }

        public Builder setActionUsers(LinkMultiUser.Builder builder) {
            SingleFieldBuilderV3<LinkMultiUser, LinkMultiUser.Builder, LinkMultiUserOrBuilder> singleFieldBuilderV3 = this.actionUsersBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(builder.m4285build());
                return this;
            }
            this.actionUsers_ = builder.m4285build();
            onChanged();
            return this;
        }

        public Builder setActionUsers(LinkMultiUser linkMultiUser) {
            SingleFieldBuilderV3<LinkMultiUser, LinkMultiUser.Builder, LinkMultiUserOrBuilder> singleFieldBuilderV3 = this.actionUsersBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(linkMultiUser);
                return this;
            } else if (linkMultiUser != null) {
                this.actionUsers_ = linkMultiUser;
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder setActionValue(int i) {
            this.action_ = i;
            onChanged();
            return this;
        }

        /* renamed from: setField */
        public Builder m4268setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        /* renamed from: setRepeatedField */
        public Builder m4270setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        /* renamed from: setUnknownFields */
        public final Builder m4272setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }

        public Builder setUsers(int i, LinkMultiUser.Builder builder) {
            RepeatedFieldBuilderV3<LinkMultiUser, LinkMultiUser.Builder, LinkMultiUserOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.m4285build());
                return this;
            }
            ensureUsersIsMutable();
            this.users_.set(i, builder.m4285build());
            onChanged();
            return this;
        }

        public Builder setUsers(int i, LinkMultiUser linkMultiUser) {
            RepeatedFieldBuilderV3<LinkMultiUser, LinkMultiUser.Builder, LinkMultiUserOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, linkMultiUser);
                return this;
            } else if (linkMultiUser != null) {
                ensureUsersIsMutable();
                this.users_.set(i, linkMultiUser);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LinkMultiUpdate$LinkMultiUser.class */
    public static final class LinkMultiUser extends GeneratedMessageV3 implements LinkMultiUserOrBuilder {
        public static final int AVATAR_FIELD_NUMBER = 4;
        public static final int LID_FIELD_NUMBER = 5;
        public static final int NAME_FIELD_NUMBER = 2;
        public static final int STREAM_ID_FIELD_NUMBER = 3;
        public static final int UID_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private volatile Object avatar_;
        private volatile Object lid_;
        private byte memoizedIsInitialized;
        private volatile Object name_;
        private volatile Object streamId_;
        private long uid_;
        private static final LinkMultiUser DEFAULT_INSTANCE = new LinkMultiUser();
        private static final Parser<LinkMultiUser> PARSER = new AbstractParser<LinkMultiUser>() { // from class: cn.irisgw.live.LinkMultiUpdate.LinkMultiUser.1
            /* renamed from: parsePartialFrom */
            public LinkMultiUser m4281parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new LinkMultiUser(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LinkMultiUpdate$LinkMultiUser$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LinkMultiUserOrBuilder {
            private Object avatar_;
            private Object lid_;
            private Object name_;
            private Object streamId_;
            private long uid_;

            private Builder() {
                this.name_ = "";
                this.streamId_ = "";
                this.avatar_ = "";
                this.lid_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.name_ = "";
                this.streamId_ = "";
                this.avatar_ = "";
                this.lid_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LiveConstants.internal_static_cn_irisgw_live_LinkMultiUpdate_LinkMultiUser_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = LinkMultiUser.alwaysUseFieldBuilders;
            }

            /* renamed from: addRepeatedField */
            public Builder m4283addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            /* renamed from: build */
            public LinkMultiUser m4285build() {
                LinkMultiUser m4287buildPartial = m4287buildPartial();
                if (m4287buildPartial.isInitialized()) {
                    return m4287buildPartial;
                }
                throw newUninitializedMessageException(m4287buildPartial);
            }

            /* renamed from: buildPartial */
            public LinkMultiUser m4287buildPartial() {
                LinkMultiUser linkMultiUser = new LinkMultiUser(this);
                linkMultiUser.uid_ = this.uid_;
                linkMultiUser.name_ = this.name_;
                linkMultiUser.streamId_ = this.streamId_;
                linkMultiUser.avatar_ = this.avatar_;
                linkMultiUser.lid_ = this.lid_;
                onBuilt();
                return linkMultiUser;
            }

            /* renamed from: clear */
            public Builder m4291clear() {
                super.clear();
                this.uid_ = LinkMultiUser.serialVersionUID;
                this.name_ = "";
                this.streamId_ = "";
                this.avatar_ = "";
                this.lid_ = "";
                return this;
            }

            public Builder clearAvatar() {
                this.avatar_ = LinkMultiUser.getDefaultInstance().getAvatar();
                onChanged();
                return this;
            }

            /* renamed from: clearField */
            public Builder m4293clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearLid() {
                this.lid_ = LinkMultiUser.getDefaultInstance().getLid();
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.name_ = LinkMultiUser.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            /* renamed from: clearOneof */
            public Builder m4296clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearStreamId() {
                this.streamId_ = LinkMultiUser.getDefaultInstance().getStreamId();
                onChanged();
                return this;
            }

            public Builder clearUid() {
                this.uid_ = LinkMultiUser.serialVersionUID;
                onChanged();
                return this;
            }

            /* renamed from: clone */
            public Builder m4302clone() {
                return (Builder) super.clone();
            }

            @Override // cn.irisgw.live.LinkMultiUpdate.LinkMultiUserOrBuilder
            public String getAvatar() {
                Object obj = this.avatar_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.avatar_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.LinkMultiUpdate.LinkMultiUserOrBuilder
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
            public LinkMultiUser m4304getDefaultInstanceForType() {
                return LinkMultiUser.getDefaultInstance();
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return LiveConstants.internal_static_cn_irisgw_live_LinkMultiUpdate_LinkMultiUser_descriptor;
            }

            @Override // cn.irisgw.live.LinkMultiUpdate.LinkMultiUserOrBuilder
            public String getLid() {
                Object obj = this.lid_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.lid_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.LinkMultiUpdate.LinkMultiUserOrBuilder
            public ByteString getLidBytes() {
                Object obj = this.lid_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.lid_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.LinkMultiUpdate.LinkMultiUserOrBuilder
            public String getName() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.LinkMultiUpdate.LinkMultiUserOrBuilder
            public ByteString getNameBytes() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.name_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.LinkMultiUpdate.LinkMultiUserOrBuilder
            public String getStreamId() {
                Object obj = this.streamId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.streamId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.LinkMultiUpdate.LinkMultiUserOrBuilder
            public ByteString getStreamIdBytes() {
                Object obj = this.streamId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.streamId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.LinkMultiUpdate.LinkMultiUserOrBuilder
            public long getUid() {
                return this.uid_;
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveConstants.internal_static_cn_irisgw_live_LinkMultiUpdate_LinkMultiUser_fieldAccessorTable.ensureFieldAccessorsInitialized(LinkMultiUser.class, Builder.class);
            }

            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(LinkMultiUser linkMultiUser) {
                if (linkMultiUser == LinkMultiUser.getDefaultInstance()) {
                    return this;
                }
                if (linkMultiUser.getUid() != LinkMultiUser.serialVersionUID) {
                    setUid(linkMultiUser.getUid());
                }
                if (!linkMultiUser.getName().isEmpty()) {
                    this.name_ = linkMultiUser.name_;
                    onChanged();
                }
                if (!linkMultiUser.getStreamId().isEmpty()) {
                    this.streamId_ = linkMultiUser.streamId_;
                    onChanged();
                }
                if (!linkMultiUser.getAvatar().isEmpty()) {
                    this.avatar_ = linkMultiUser.avatar_;
                    onChanged();
                }
                if (!linkMultiUser.getLid().isEmpty()) {
                    this.lid_ = linkMultiUser.lid_;
                    onChanged();
                }
                m4313mergeUnknownFields(linkMultiUser.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            /* renamed from: mergeFrom */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.LinkMultiUpdate.LinkMultiUser.Builder m4310mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.LinkMultiUpdate.LinkMultiUser.access$1000()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.LinkMultiUpdate$LinkMultiUser r0 = (cn.irisgw.live.LinkMultiUpdate.LinkMultiUser) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.LinkMultiUpdate$LinkMultiUser$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.LinkMultiUpdate$LinkMultiUser r0 = (cn.irisgw.live.LinkMultiUpdate.LinkMultiUser) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.LinkMultiUpdate$LinkMultiUser$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.LinkMultiUpdate.LinkMultiUser.Builder.m4310mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.LinkMultiUpdate$LinkMultiUser$Builder");
            }

            /* renamed from: mergeFrom */
            public Builder m4309mergeFrom(Message message) {
                if (message instanceof LinkMultiUser) {
                    return mergeFrom((LinkMultiUser) message);
                }
                super.mergeFrom(message);
                return this;
            }

            /* renamed from: mergeUnknownFields */
            public final Builder m4313mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
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
                    LinkMultiUser.checkByteStringIsUtf8(byteString);
                    this.avatar_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            /* renamed from: setField */
            public Builder m4315setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setLid(String str) {
                if (str != null) {
                    this.lid_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setLidBytes(ByteString byteString) {
                if (byteString != null) {
                    LinkMultiUser.checkByteStringIsUtf8(byteString);
                    this.lid_ = byteString;
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
                    LinkMultiUser.checkByteStringIsUtf8(byteString);
                    this.name_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            /* renamed from: setRepeatedField */
            public Builder m4317setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setStreamId(String str) {
                if (str != null) {
                    this.streamId_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setStreamIdBytes(ByteString byteString) {
                if (byteString != null) {
                    LinkMultiUser.checkByteStringIsUtf8(byteString);
                    this.streamId_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setUid(long j) {
                this.uid_ = j;
                onChanged();
                return this;
            }

            /* renamed from: setUnknownFields */
            public final Builder m4319setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private LinkMultiUser() {
            this.memoizedIsInitialized = (byte) -1;
            this.name_ = "";
            this.streamId_ = "";
            this.avatar_ = "";
            this.lid_ = "";
        }

        private LinkMultiUser(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.uid_ = codedInputStream.readUInt64();
                            } else if (readTag == 18) {
                                this.name_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 26) {
                                this.streamId_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 34) {
                                this.avatar_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 42) {
                                this.lid_ = codedInputStream.readStringRequireUtf8();
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

        private LinkMultiUser(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static LinkMultiUser getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_LinkMultiUpdate_LinkMultiUser_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m4280toBuilder();
        }

        public static Builder newBuilder(LinkMultiUser linkMultiUser) {
            return DEFAULT_INSTANCE.m4280toBuilder().mergeFrom(linkMultiUser);
        }

        public static LinkMultiUser parseDelimitedFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static LinkMultiUser parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LinkMultiUser parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (LinkMultiUser) PARSER.parseFrom(byteString);
        }

        public static LinkMultiUser parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (LinkMultiUser) PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static LinkMultiUser parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static LinkMultiUser parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static LinkMultiUser parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static LinkMultiUser parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LinkMultiUser parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (LinkMultiUser) PARSER.parseFrom(byteBuffer);
        }

        public static LinkMultiUser parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (LinkMultiUser) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static LinkMultiUser parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (LinkMultiUser) PARSER.parseFrom(bArr);
        }

        public static LinkMultiUser parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (LinkMultiUser) PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<LinkMultiUser> parser() {
            return PARSER;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof LinkMultiUser) {
                LinkMultiUser linkMultiUser = (LinkMultiUser) obj;
                return getUid() == linkMultiUser.getUid() && getName().equals(linkMultiUser.getName()) && getStreamId().equals(linkMultiUser.getStreamId()) && getAvatar().equals(linkMultiUser.getAvatar()) && getLid().equals(linkMultiUser.getLid()) && this.unknownFields.equals(linkMultiUser.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // cn.irisgw.live.LinkMultiUpdate.LinkMultiUserOrBuilder
        public String getAvatar() {
            Object obj = this.avatar_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.avatar_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LinkMultiUpdate.LinkMultiUserOrBuilder
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
        public LinkMultiUser m4275getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // cn.irisgw.live.LinkMultiUpdate.LinkMultiUserOrBuilder
        public String getLid() {
            Object obj = this.lid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.lid_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LinkMultiUpdate.LinkMultiUserOrBuilder
        public ByteString getLidBytes() {
            Object obj = this.lid_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.lid_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.LinkMultiUpdate.LinkMultiUserOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LinkMultiUpdate.LinkMultiUserOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Parser<LinkMultiUser> getParserForType() {
            return PARSER;
        }

        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            long j = this.uid_;
            if (j != serialVersionUID) {
                i2 = 0 + CodedOutputStream.computeUInt64Size(1, j);
            }
            int i3 = i2;
            if (!getNameBytes().isEmpty()) {
                i3 = i2 + GeneratedMessageV3.computeStringSize(2, this.name_);
            }
            int i4 = i3;
            if (!getStreamIdBytes().isEmpty()) {
                i4 = i3 + GeneratedMessageV3.computeStringSize(3, this.streamId_);
            }
            int i5 = i4;
            if (!getAvatarBytes().isEmpty()) {
                i5 = i4 + GeneratedMessageV3.computeStringSize(4, this.avatar_);
            }
            int i6 = i5;
            if (!getLidBytes().isEmpty()) {
                i6 = i5 + GeneratedMessageV3.computeStringSize(5, this.lid_);
            }
            int serializedSize = i6 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // cn.irisgw.live.LinkMultiUpdate.LinkMultiUserOrBuilder
        public String getStreamId() {
            Object obj = this.streamId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.streamId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LinkMultiUpdate.LinkMultiUserOrBuilder
        public ByteString getStreamIdBytes() {
            Object obj = this.streamId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.streamId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.LinkMultiUpdate.LinkMultiUserOrBuilder
        public long getUid() {
            return this.uid_;
        }

        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(getUid())) * 37) + 2) * 53) + getName().hashCode()) * 37) + 3) * 53) + getStreamId().hashCode()) * 37) + 4) * 53) + getAvatar().hashCode()) * 37) + 5) * 53) + getLid().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_LinkMultiUpdate_LinkMultiUser_fieldAccessorTable.ensureFieldAccessorsInitialized(LinkMultiUser.class, Builder.class);
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
        public Builder m4278newBuilderForType() {
            return newBuilder();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: newBuilderForType */
        public Builder m4277newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new LinkMultiUser();
        }

        /* renamed from: toBuilder */
        public Builder m4280toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            long j = this.uid_;
            if (j != serialVersionUID) {
                codedOutputStream.writeUInt64(1, j);
            }
            if (!getNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.name_);
            }
            if (!getStreamIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.streamId_);
            }
            if (!getAvatarBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.avatar_);
            }
            if (!getLidBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.lid_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LinkMultiUpdate$LinkMultiUserOrBuilder.class */
    public interface LinkMultiUserOrBuilder extends MessageOrBuilder {
        String getAvatar();

        ByteString getAvatarBytes();

        String getLid();

        ByteString getLidBytes();

        String getName();

        ByteString getNameBytes();

        String getStreamId();

        ByteString getStreamIdBytes();

        long getUid();
    }

    private LinkMultiUpdate() {
        this.memoizedIsInitialized = (byte) -1;
        this.users_ = Collections.emptyList();
        this.action_ = 0;
        this.actionType_ = 0;
    }

    private LinkMultiUpdate(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        LinkMultiUser.Builder builder;
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
                                this.users_ = new ArrayList();
                                z4 = z2 | true;
                            }
                            this.users_.add((LinkMultiUser) codedInputStream.readMessage(LinkMultiUser.parser(), extensionRegistryLite));
                            z2 = z4;
                        } else if (readTag == 18) {
                            if (this.actionUsers_ != null) {
                                boolean z5 = z2;
                                builder = this.actionUsers_.m4280toBuilder();
                            } else {
                                builder = null;
                            }
                            LinkMultiUser readMessage = codedInputStream.readMessage(LinkMultiUser.parser(), extensionRegistryLite);
                            boolean z6 = z2;
                            this.actionUsers_ = readMessage;
                            if (builder != null) {
                                builder.mergeFrom(readMessage);
                                boolean z7 = z2;
                                this.actionUsers_ = builder.m4287buildPartial();
                            }
                        } else if (readTag == 24) {
                            this.action_ = codedInputStream.readEnum();
                        } else if (readTag == 32) {
                            this.actionType_ = codedInputStream.readEnum();
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
                    this.users_ = Collections.unmodifiableList(this.users_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                throw th;
            }
        }
        if (z2 & true) {
            this.users_ = Collections.unmodifiableList(this.users_);
        }
        this.unknownFields = newBuilder.build();
        makeExtensionsImmutable();
    }

    private LinkMultiUpdate(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static LinkMultiUpdate getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_LinkMultiUpdate_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m4229toBuilder();
    }

    public static Builder newBuilder(LinkMultiUpdate linkMultiUpdate) {
        return DEFAULT_INSTANCE.m4229toBuilder().mergeFrom(linkMultiUpdate);
    }

    public static LinkMultiUpdate parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static LinkMultiUpdate parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LinkMultiUpdate parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (LinkMultiUpdate) PARSER.parseFrom(byteString);
    }

    public static LinkMultiUpdate parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LinkMultiUpdate) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static LinkMultiUpdate parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static LinkMultiUpdate parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static LinkMultiUpdate parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static LinkMultiUpdate parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LinkMultiUpdate parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (LinkMultiUpdate) PARSER.parseFrom(byteBuffer);
    }

    public static LinkMultiUpdate parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LinkMultiUpdate) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static LinkMultiUpdate parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (LinkMultiUpdate) PARSER.parseFrom(bArr);
    }

    public static LinkMultiUpdate parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LinkMultiUpdate) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<LinkMultiUpdate> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LinkMultiUpdate) {
            LinkMultiUpdate linkMultiUpdate = (LinkMultiUpdate) obj;
            if (getUsersList().equals(linkMultiUpdate.getUsersList()) && hasActionUsers() == linkMultiUpdate.hasActionUsers()) {
                return (!hasActionUsers() || getActionUsers().equals(linkMultiUpdate.getActionUsers())) && this.action_ == linkMultiUpdate.action_ && this.actionType_ == linkMultiUpdate.actionType_ && this.unknownFields.equals(linkMultiUpdate.unknownFields);
            }
            return false;
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.LinkMultiUpdateOrBuilder
    public Action getAction() {
        Action valueOf = Action.valueOf(this.action_);
        Action action = valueOf;
        if (valueOf == null) {
            action = Action.UNRECOGNIZED;
        }
        return action;
    }

    @Override // cn.irisgw.live.LinkMultiUpdateOrBuilder
    public ActionType getActionType() {
        ActionType valueOf = ActionType.valueOf(this.actionType_);
        ActionType actionType = valueOf;
        if (valueOf == null) {
            actionType = ActionType.UNRECOGNIZED;
        }
        return actionType;
    }

    @Override // cn.irisgw.live.LinkMultiUpdateOrBuilder
    public int getActionTypeValue() {
        return this.actionType_;
    }

    @Override // cn.irisgw.live.LinkMultiUpdateOrBuilder
    public LinkMultiUser getActionUsers() {
        LinkMultiUser linkMultiUser = this.actionUsers_;
        LinkMultiUser linkMultiUser2 = linkMultiUser;
        if (linkMultiUser == null) {
            linkMultiUser2 = LinkMultiUser.getDefaultInstance();
        }
        return linkMultiUser2;
    }

    @Override // cn.irisgw.live.LinkMultiUpdateOrBuilder
    public LinkMultiUserOrBuilder getActionUsersOrBuilder() {
        return getActionUsers();
    }

    @Override // cn.irisgw.live.LinkMultiUpdateOrBuilder
    public int getActionValue() {
        return this.action_;
    }

    /* renamed from: getDefaultInstanceForType */
    public LinkMultiUpdate m4224getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public Parser<LinkMultiUpdate> getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.users_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(1, this.users_.get(i3));
        }
        int i4 = i2;
        if (this.actionUsers_ != null) {
            i4 = i2 + CodedOutputStream.computeMessageSize(2, getActionUsers());
        }
        int i5 = i4;
        if (this.action_ != Action.None.getNumber()) {
            i5 = i4 + CodedOutputStream.computeEnumSize(3, this.action_);
        }
        int i6 = i5;
        if (this.actionType_ != ActionType.Default.getNumber()) {
            i6 = i5 + CodedOutputStream.computeEnumSize(4, this.actionType_);
        }
        int serializedSize = i6 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // cn.irisgw.live.LinkMultiUpdateOrBuilder
    public LinkMultiUser getUsers(int i) {
        return this.users_.get(i);
    }

    @Override // cn.irisgw.live.LinkMultiUpdateOrBuilder
    public int getUsersCount() {
        return this.users_.size();
    }

    @Override // cn.irisgw.live.LinkMultiUpdateOrBuilder
    public List<LinkMultiUser> getUsersList() {
        return this.users_;
    }

    @Override // cn.irisgw.live.LinkMultiUpdateOrBuilder
    public LinkMultiUserOrBuilder getUsersOrBuilder(int i) {
        return this.users_.get(i);
    }

    @Override // cn.irisgw.live.LinkMultiUpdateOrBuilder
    public List<? extends LinkMultiUserOrBuilder> getUsersOrBuilderList() {
        return this.users_;
    }

    @Override // cn.irisgw.live.LinkMultiUpdateOrBuilder
    public boolean hasActionUsers() {
        return this.actionUsers_ != null;
    }

    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = 779 + getDescriptor().hashCode();
        int i = hashCode;
        if (getUsersCount() > 0) {
            i = (((hashCode * 37) + 1) * 53) + getUsersList().hashCode();
        }
        int i2 = i;
        if (hasActionUsers()) {
            i2 = (((i * 37) + 2) * 53) + getActionUsers().hashCode();
        }
        int hashCode2 = (((((((((i2 * 37) + 3) * 53) + this.action_) * 37) + 4) * 53) + this.actionType_) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_LinkMultiUpdate_fieldAccessorTable.ensureFieldAccessorsInitialized(LinkMultiUpdate.class, Builder.class);
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
    public Builder m4227newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m4226newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new LinkMultiUpdate();
    }

    /* renamed from: toBuilder */
    public Builder m4229toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.users_.size()) {
                break;
            }
            codedOutputStream.writeMessage(1, this.users_.get(i2));
            i = i2 + 1;
        }
        if (this.actionUsers_ != null) {
            codedOutputStream.writeMessage(2, getActionUsers());
        }
        if (this.action_ != Action.None.getNumber()) {
            codedOutputStream.writeEnum(3, this.action_);
        }
        if (this.actionType_ != ActionType.Default.getNumber()) {
            codedOutputStream.writeEnum(4, this.actionType_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
