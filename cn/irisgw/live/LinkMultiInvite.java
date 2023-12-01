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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LinkMultiInvite.class */
public final class LinkMultiInvite extends GeneratedMessageV3 implements LinkMultiInviteOrBuilder {
    public static final int AVATAR_FIELD_NUMBER = 5;
    public static final int NAME_FIELD_NUMBER = 2;
    public static final int TIMEOUT_FIELD_NUMBER = 6;
    public static final int TYPE_FIELD_NUMBER = 3;
    public static final int UID_FIELD_NUMBER = 1;
    public static final int USERS_FIELD_NUMBER = 4;
    private static final long serialVersionUID = 0;
    private volatile Object avatar_;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private int timeout_;
    private int type_;
    private long uid_;
    private List<LinkMultiInviteUser> users_;
    private static final LinkMultiInvite DEFAULT_INSTANCE = new LinkMultiInvite();
    private static final Parser<LinkMultiInvite> PARSER = new AbstractParser<LinkMultiInvite>() { // from class: cn.irisgw.live.LinkMultiInvite.1
        @Override // com.google.protobuf.Parser
        public LinkMultiInvite parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new LinkMultiInvite(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LinkMultiInvite$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LinkMultiInviteOrBuilder {
        private Object avatar_;
        private int bitField0_;
        private Object name_;
        private int timeout_;
        private int type_;
        private long uid_;
        private RepeatedFieldBuilderV3<LinkMultiInviteUser, LinkMultiInviteUser.Builder, LinkMultiInviteUserOrBuilder> usersBuilder_;
        private List<LinkMultiInviteUser> users_;

        private Builder() {
            this.name_ = "";
            this.users_ = Collections.emptyList();
            this.avatar_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.name_ = "";
            this.users_ = Collections.emptyList();
            this.avatar_ = "";
            maybeForceBuilderInitialization();
        }

        private void ensureUsersIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.users_ = new ArrayList(this.users_);
                this.bitField0_ |= 1;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_LinkMultiInvite_descriptor;
        }

        private RepeatedFieldBuilderV3<LinkMultiInviteUser, LinkMultiInviteUser.Builder, LinkMultiInviteUserOrBuilder> getUsersFieldBuilder() {
            if (this.usersBuilder_ == null) {
                List<LinkMultiInviteUser> list = this.users_;
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
            if (LinkMultiInvite.alwaysUseFieldBuilders) {
                getUsersFieldBuilder();
            }
        }

        public Builder addAllUsers(Iterable<? extends LinkMultiInviteUser> iterable) {
            RepeatedFieldBuilderV3<LinkMultiInviteUser, LinkMultiInviteUser.Builder, LinkMultiInviteUserOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensureUsersIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.users_);
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        public Builder addUsers(int i, LinkMultiInviteUser.Builder builder) {
            RepeatedFieldBuilderV3<LinkMultiInviteUser, LinkMultiInviteUser.Builder, LinkMultiInviteUserOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.build());
                return this;
            }
            ensureUsersIsMutable();
            this.users_.add(i, builder.build());
            onChanged();
            return this;
        }

        public Builder addUsers(int i, LinkMultiInviteUser linkMultiInviteUser) {
            RepeatedFieldBuilderV3<LinkMultiInviteUser, LinkMultiInviteUser.Builder, LinkMultiInviteUserOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, linkMultiInviteUser);
                return this;
            } else if (linkMultiInviteUser != null) {
                ensureUsersIsMutable();
                this.users_.add(i, linkMultiInviteUser);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addUsers(LinkMultiInviteUser.Builder builder) {
            RepeatedFieldBuilderV3<LinkMultiInviteUser, LinkMultiInviteUser.Builder, LinkMultiInviteUserOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(builder.build());
                return this;
            }
            ensureUsersIsMutable();
            this.users_.add(builder.build());
            onChanged();
            return this;
        }

        public Builder addUsers(LinkMultiInviteUser linkMultiInviteUser) {
            RepeatedFieldBuilderV3<LinkMultiInviteUser, LinkMultiInviteUser.Builder, LinkMultiInviteUserOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(linkMultiInviteUser);
                return this;
            } else if (linkMultiInviteUser != null) {
                ensureUsersIsMutable();
                this.users_.add(linkMultiInviteUser);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public LinkMultiInviteUser.Builder addUsersBuilder() {
            return getUsersFieldBuilder().addBuilder(LinkMultiInviteUser.getDefaultInstance());
        }

        public LinkMultiInviteUser.Builder addUsersBuilder(int i) {
            return getUsersFieldBuilder().addBuilder(i, LinkMultiInviteUser.getDefaultInstance());
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public LinkMultiInvite build() {
            LinkMultiInvite buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public LinkMultiInvite buildPartial() {
            LinkMultiInvite linkMultiInvite = new LinkMultiInvite(this);
            linkMultiInvite.uid_ = this.uid_;
            linkMultiInvite.name_ = this.name_;
            linkMultiInvite.type_ = this.type_;
            RepeatedFieldBuilderV3<LinkMultiInviteUser, LinkMultiInviteUser.Builder, LinkMultiInviteUserOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.users_ = Collections.unmodifiableList(this.users_);
                    this.bitField0_ &= -2;
                }
                linkMultiInvite.users_ = this.users_;
            } else {
                linkMultiInvite.users_ = repeatedFieldBuilderV3.build();
            }
            linkMultiInvite.avatar_ = this.avatar_;
            linkMultiInvite.timeout_ = this.timeout_;
            onBuilt();
            return linkMultiInvite;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.uid_ = 0L;
            this.name_ = "";
            this.type_ = 0;
            RepeatedFieldBuilderV3<LinkMultiInviteUser, LinkMultiInviteUser.Builder, LinkMultiInviteUserOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.users_ = Collections.emptyList();
                this.bitField0_ &= -2;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            this.avatar_ = "";
            this.timeout_ = 0;
            return this;
        }

        public Builder clearAvatar() {
            this.avatar_ = LinkMultiInvite.getDefaultInstance().getAvatar();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearName() {
            this.name_ = LinkMultiInvite.getDefaultInstance().getName();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearTimeout() {
            this.timeout_ = 0;
            onChanged();
            return this;
        }

        public Builder clearType() {
            this.type_ = 0;
            onChanged();
            return this;
        }

        public Builder clearUid() {
            this.uid_ = 0L;
            onChanged();
            return this;
        }

        public Builder clearUsers() {
            RepeatedFieldBuilderV3<LinkMultiInviteUser, LinkMultiInviteUser.Builder, LinkMultiInviteUserOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.users_ = Collections.emptyList();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo1800clone() {
            return (Builder) super.mo1800clone();
        }

        @Override // cn.irisgw.live.LinkMultiInviteOrBuilder
        public String getAvatar() {
            Object obj = this.avatar_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.avatar_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LinkMultiInviteOrBuilder
        public ByteString getAvatarBytes() {
            Object obj = this.avatar_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.avatar_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public LinkMultiInvite getDefaultInstanceForType() {
            return LinkMultiInvite.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_LinkMultiInvite_descriptor;
        }

        @Override // cn.irisgw.live.LinkMultiInviteOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LinkMultiInviteOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.LinkMultiInviteOrBuilder
        public int getTimeout() {
            return this.timeout_;
        }

        @Override // cn.irisgw.live.LinkMultiInviteOrBuilder
        public int getType() {
            return this.type_;
        }

        @Override // cn.irisgw.live.LinkMultiInviteOrBuilder
        public long getUid() {
            return this.uid_;
        }

        @Override // cn.irisgw.live.LinkMultiInviteOrBuilder
        public LinkMultiInviteUser getUsers(int i) {
            RepeatedFieldBuilderV3<LinkMultiInviteUser, LinkMultiInviteUser.Builder, LinkMultiInviteUserOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            return repeatedFieldBuilderV3 == null ? this.users_.get(i) : repeatedFieldBuilderV3.getMessage(i);
        }

        public LinkMultiInviteUser.Builder getUsersBuilder(int i) {
            return getUsersFieldBuilder().getBuilder(i);
        }

        public List<LinkMultiInviteUser.Builder> getUsersBuilderList() {
            return getUsersFieldBuilder().getBuilderList();
        }

        @Override // cn.irisgw.live.LinkMultiInviteOrBuilder
        public int getUsersCount() {
            RepeatedFieldBuilderV3<LinkMultiInviteUser, LinkMultiInviteUser.Builder, LinkMultiInviteUserOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            return repeatedFieldBuilderV3 == null ? this.users_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // cn.irisgw.live.LinkMultiInviteOrBuilder
        public List<LinkMultiInviteUser> getUsersList() {
            RepeatedFieldBuilderV3<LinkMultiInviteUser, LinkMultiInviteUser.Builder, LinkMultiInviteUserOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.users_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // cn.irisgw.live.LinkMultiInviteOrBuilder
        public LinkMultiInviteUserOrBuilder getUsersOrBuilder(int i) {
            RepeatedFieldBuilderV3<LinkMultiInviteUser, LinkMultiInviteUser.Builder, LinkMultiInviteUserOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            return repeatedFieldBuilderV3 == null ? this.users_.get(i) : repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // cn.irisgw.live.LinkMultiInviteOrBuilder
        public List<? extends LinkMultiInviteUserOrBuilder> getUsersOrBuilderList() {
            RepeatedFieldBuilderV3<LinkMultiInviteUser, LinkMultiInviteUser.Builder, LinkMultiInviteUserOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.users_);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_LinkMultiInvite_fieldAccessorTable.ensureFieldAccessorsInitialized(LinkMultiInvite.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(LinkMultiInvite linkMultiInvite) {
            if (linkMultiInvite == LinkMultiInvite.getDefaultInstance()) {
                return this;
            }
            if (linkMultiInvite.getUid() != 0) {
                setUid(linkMultiInvite.getUid());
            }
            if (!linkMultiInvite.getName().isEmpty()) {
                this.name_ = linkMultiInvite.name_;
                onChanged();
            }
            if (linkMultiInvite.getType() != 0) {
                setType(linkMultiInvite.getType());
            }
            if (this.usersBuilder_ == null) {
                if (!linkMultiInvite.users_.isEmpty()) {
                    if (this.users_.isEmpty()) {
                        this.users_ = linkMultiInvite.users_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureUsersIsMutable();
                        this.users_.addAll(linkMultiInvite.users_);
                    }
                    onChanged();
                }
            } else if (!linkMultiInvite.users_.isEmpty()) {
                if (this.usersBuilder_.isEmpty()) {
                    this.usersBuilder_.dispose();
                    RepeatedFieldBuilderV3<LinkMultiInviteUser, LinkMultiInviteUser.Builder, LinkMultiInviteUserOrBuilder> repeatedFieldBuilderV3 = null;
                    this.usersBuilder_ = null;
                    this.users_ = linkMultiInvite.users_;
                    this.bitField0_ &= -2;
                    if (LinkMultiInvite.alwaysUseFieldBuilders) {
                        repeatedFieldBuilderV3 = getUsersFieldBuilder();
                    }
                    this.usersBuilder_ = repeatedFieldBuilderV3;
                } else {
                    this.usersBuilder_.addAllMessages(linkMultiInvite.users_);
                }
            }
            if (!linkMultiInvite.getAvatar().isEmpty()) {
                this.avatar_ = linkMultiInvite.avatar_;
                onChanged();
            }
            if (linkMultiInvite.getTimeout() != 0) {
                setTimeout(linkMultiInvite.getTimeout());
            }
            mergeUnknownFields(linkMultiInvite.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.LinkMultiInvite.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.LinkMultiInvite.access$2400()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.LinkMultiInvite r0 = (cn.irisgw.live.LinkMultiInvite) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.LinkMultiInvite$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.LinkMultiInvite r0 = (cn.irisgw.live.LinkMultiInvite) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.LinkMultiInvite$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.LinkMultiInvite.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.LinkMultiInvite$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof LinkMultiInvite) {
                return mergeFrom((LinkMultiInvite) message);
            }
            super.mergeFrom(message);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder removeUsers(int i) {
            RepeatedFieldBuilderV3<LinkMultiInviteUser, LinkMultiInviteUser.Builder, LinkMultiInviteUserOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.remove(i);
                return this;
            }
            ensureUsersIsMutable();
            this.users_.remove(i);
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
                LinkMultiInvite.checkByteStringIsUtf8(byteString);
                this.avatar_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
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
                LinkMultiInvite.checkByteStringIsUtf8(byteString);
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

        public Builder setTimeout(int i) {
            this.timeout_ = i;
            onChanged();
            return this;
        }

        public Builder setType(int i) {
            this.type_ = i;
            onChanged();
            return this;
        }

        public Builder setUid(long j) {
            this.uid_ = j;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }

        public Builder setUsers(int i, LinkMultiInviteUser.Builder builder) {
            RepeatedFieldBuilderV3<LinkMultiInviteUser, LinkMultiInviteUser.Builder, LinkMultiInviteUserOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.build());
                return this;
            }
            ensureUsersIsMutable();
            this.users_.set(i, builder.build());
            onChanged();
            return this;
        }

        public Builder setUsers(int i, LinkMultiInviteUser linkMultiInviteUser) {
            RepeatedFieldBuilderV3<LinkMultiInviteUser, LinkMultiInviteUser.Builder, LinkMultiInviteUserOrBuilder> repeatedFieldBuilderV3 = this.usersBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, linkMultiInviteUser);
                return this;
            } else if (linkMultiInviteUser != null) {
                ensureUsersIsMutable();
                this.users_.set(i, linkMultiInviteUser);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LinkMultiInvite$LinkMultiInviteUser.class */
    public static final class LinkMultiInviteUser extends GeneratedMessageV3 implements LinkMultiInviteUserOrBuilder {
        public static final int AVATAR_FIELD_NUMBER = 3;
        public static final int NAME_FIELD_NUMBER = 2;
        public static final int UID_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private volatile Object avatar_;
        private byte memoizedIsInitialized;
        private volatile Object name_;
        private long uid_;
        private static final LinkMultiInviteUser DEFAULT_INSTANCE = new LinkMultiInviteUser();
        private static final Parser<LinkMultiInviteUser> PARSER = new AbstractParser<LinkMultiInviteUser>() { // from class: cn.irisgw.live.LinkMultiInvite.LinkMultiInviteUser.1
            @Override // com.google.protobuf.Parser
            public LinkMultiInviteUser parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new LinkMultiInviteUser(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LinkMultiInvite$LinkMultiInviteUser$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LinkMultiInviteUserOrBuilder {
            private Object avatar_;
            private Object name_;
            private long uid_;

            private Builder() {
                this.name_ = "";
                this.avatar_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.name_ = "";
                this.avatar_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LiveConstants.internal_static_cn_irisgw_live_LinkMultiInvite_LinkMultiInviteUser_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = LinkMultiInviteUser.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LinkMultiInviteUser build() {
                LinkMultiInviteUser buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LinkMultiInviteUser buildPartial() {
                LinkMultiInviteUser linkMultiInviteUser = new LinkMultiInviteUser(this);
                linkMultiInviteUser.uid_ = this.uid_;
                linkMultiInviteUser.name_ = this.name_;
                linkMultiInviteUser.avatar_ = this.avatar_;
                onBuilt();
                return linkMultiInviteUser;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.uid_ = 0L;
                this.name_ = "";
                this.avatar_ = "";
                return this;
            }

            public Builder clearAvatar() {
                this.avatar_ = LinkMultiInviteUser.getDefaultInstance().getAvatar();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearName() {
                this.name_ = LinkMultiInviteUser.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearUid() {
                this.uid_ = 0L;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1800clone() {
                return (Builder) super.mo1800clone();
            }

            @Override // cn.irisgw.live.LinkMultiInvite.LinkMultiInviteUserOrBuilder
            public String getAvatar() {
                Object obj = this.avatar_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.avatar_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.LinkMultiInvite.LinkMultiInviteUserOrBuilder
            public ByteString getAvatarBytes() {
                Object obj = this.avatar_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.avatar_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public LinkMultiInviteUser getDefaultInstanceForType() {
                return LinkMultiInviteUser.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return LiveConstants.internal_static_cn_irisgw_live_LinkMultiInvite_LinkMultiInviteUser_descriptor;
            }

            @Override // cn.irisgw.live.LinkMultiInvite.LinkMultiInviteUserOrBuilder
            public String getName() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.LinkMultiInvite.LinkMultiInviteUserOrBuilder
            public ByteString getNameBytes() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.name_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.LinkMultiInvite.LinkMultiInviteUserOrBuilder
            public long getUid() {
                return this.uid_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveConstants.internal_static_cn_irisgw_live_LinkMultiInvite_LinkMultiInviteUser_fieldAccessorTable.ensureFieldAccessorsInitialized(LinkMultiInviteUser.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(LinkMultiInviteUser linkMultiInviteUser) {
                if (linkMultiInviteUser == LinkMultiInviteUser.getDefaultInstance()) {
                    return this;
                }
                if (linkMultiInviteUser.getUid() != 0) {
                    setUid(linkMultiInviteUser.getUid());
                }
                if (!linkMultiInviteUser.getName().isEmpty()) {
                    this.name_ = linkMultiInviteUser.name_;
                    onChanged();
                }
                if (!linkMultiInviteUser.getAvatar().isEmpty()) {
                    this.avatar_ = linkMultiInviteUser.avatar_;
                    onChanged();
                }
                mergeUnknownFields(linkMultiInviteUser.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.LinkMultiInvite.LinkMultiInviteUser.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.LinkMultiInvite.LinkMultiInviteUser.access$800()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.LinkMultiInvite$LinkMultiInviteUser r0 = (cn.irisgw.live.LinkMultiInvite.LinkMultiInviteUser) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.LinkMultiInvite$LinkMultiInviteUser$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.LinkMultiInvite$LinkMultiInviteUser r0 = (cn.irisgw.live.LinkMultiInvite.LinkMultiInviteUser) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.LinkMultiInvite$LinkMultiInviteUser$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.LinkMultiInvite.LinkMultiInviteUser.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.LinkMultiInvite$LinkMultiInviteUser$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof LinkMultiInviteUser) {
                    return mergeFrom((LinkMultiInviteUser) message);
                }
                super.mergeFrom(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
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
                    LinkMultiInviteUser.checkByteStringIsUtf8(byteString);
                    this.avatar_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
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
                    LinkMultiInviteUser.checkByteStringIsUtf8(byteString);
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

            public Builder setUid(long j) {
                this.uid_ = j;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private LinkMultiInviteUser() {
            this.memoizedIsInitialized = (byte) -1;
            this.name_ = "";
            this.avatar_ = "";
        }

        private LinkMultiInviteUser(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.uid_ = codedInputStream.readUInt64();
                                } else if (readTag == 18) {
                                    this.name_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 26) {
                                    this.avatar_ = codedInputStream.readStringRequireUtf8();
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

        private LinkMultiInviteUser(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static LinkMultiInviteUser getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_LinkMultiInvite_LinkMultiInviteUser_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(LinkMultiInviteUser linkMultiInviteUser) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(linkMultiInviteUser);
        }

        public static LinkMultiInviteUser parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (LinkMultiInviteUser) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static LinkMultiInviteUser parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LinkMultiInviteUser) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LinkMultiInviteUser parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static LinkMultiInviteUser parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static LinkMultiInviteUser parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (LinkMultiInviteUser) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static LinkMultiInviteUser parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LinkMultiInviteUser) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static LinkMultiInviteUser parseFrom(InputStream inputStream) throws IOException {
            return (LinkMultiInviteUser) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static LinkMultiInviteUser parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LinkMultiInviteUser) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LinkMultiInviteUser parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static LinkMultiInviteUser parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static LinkMultiInviteUser parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static LinkMultiInviteUser parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<LinkMultiInviteUser> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof LinkMultiInviteUser) {
                LinkMultiInviteUser linkMultiInviteUser = (LinkMultiInviteUser) obj;
                return getUid() == linkMultiInviteUser.getUid() && getName().equals(linkMultiInviteUser.getName()) && getAvatar().equals(linkMultiInviteUser.getAvatar()) && this.unknownFields.equals(linkMultiInviteUser.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // cn.irisgw.live.LinkMultiInvite.LinkMultiInviteUserOrBuilder
        public String getAvatar() {
            Object obj = this.avatar_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.avatar_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LinkMultiInvite.LinkMultiInviteUserOrBuilder
        public ByteString getAvatarBytes() {
            Object obj = this.avatar_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.avatar_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public LinkMultiInviteUser getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // cn.irisgw.live.LinkMultiInvite.LinkMultiInviteUserOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.LinkMultiInvite.LinkMultiInviteUserOrBuilder
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
        public Parser<LinkMultiInviteUser> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            long j = this.uid_;
            if (j != 0) {
                i2 = 0 + CodedOutputStream.computeUInt64Size(1, j);
            }
            int i3 = i2;
            if (!getNameBytes().isEmpty()) {
                i3 = i2 + GeneratedMessageV3.computeStringSize(2, this.name_);
            }
            int i4 = i3;
            if (!getAvatarBytes().isEmpty()) {
                i4 = i3 + GeneratedMessageV3.computeStringSize(3, this.avatar_);
            }
            int serializedSize = i4 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // cn.irisgw.live.LinkMultiInvite.LinkMultiInviteUserOrBuilder
        public long getUid() {
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
            int hashCode = ((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(getUid())) * 37) + 2) * 53) + getName().hashCode()) * 37) + 3) * 53) + getAvatar().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_LinkMultiInvite_LinkMultiInviteUser_fieldAccessorTable.ensureFieldAccessorsInitialized(LinkMultiInviteUser.class, Builder.class);
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
            return new LinkMultiInviteUser();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            long j = this.uid_;
            if (j != 0) {
                codedOutputStream.writeUInt64(1, j);
            }
            if (!getNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.name_);
            }
            if (!getAvatarBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.avatar_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/LinkMultiInvite$LinkMultiInviteUserOrBuilder.class */
    public interface LinkMultiInviteUserOrBuilder extends MessageOrBuilder {
        String getAvatar();

        ByteString getAvatarBytes();

        String getName();

        ByteString getNameBytes();

        long getUid();
    }

    private LinkMultiInvite() {
        this.memoizedIsInitialized = (byte) -1;
        this.name_ = "";
        this.users_ = Collections.emptyList();
        this.avatar_ = "";
    }

    private LinkMultiInvite(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.uid_ = codedInputStream.readUInt64();
                            } else if (readTag == 18) {
                                this.name_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 24) {
                                this.type_ = codedInputStream.readUInt32();
                            } else if (readTag == 34) {
                                boolean z4 = z2;
                                if (!(z2 & true)) {
                                    this.users_ = new ArrayList();
                                    z4 = z2 | true;
                                }
                                this.users_.add((LinkMultiInviteUser) codedInputStream.readMessage(LinkMultiInviteUser.parser(), extensionRegistryLite));
                                z2 = z4;
                            } else if (readTag == 42) {
                                this.avatar_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 48) {
                                this.timeout_ = codedInputStream.readUInt32();
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

    private LinkMultiInvite(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static LinkMultiInvite getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_LinkMultiInvite_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(LinkMultiInvite linkMultiInvite) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(linkMultiInvite);
    }

    public static LinkMultiInvite parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (LinkMultiInvite) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static LinkMultiInvite parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LinkMultiInvite) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LinkMultiInvite parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static LinkMultiInvite parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static LinkMultiInvite parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (LinkMultiInvite) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static LinkMultiInvite parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LinkMultiInvite) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static LinkMultiInvite parseFrom(InputStream inputStream) throws IOException {
        return (LinkMultiInvite) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static LinkMultiInvite parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LinkMultiInvite) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static LinkMultiInvite parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static LinkMultiInvite parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static LinkMultiInvite parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static LinkMultiInvite parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<LinkMultiInvite> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LinkMultiInvite) {
            LinkMultiInvite linkMultiInvite = (LinkMultiInvite) obj;
            return getUid() == linkMultiInvite.getUid() && getName().equals(linkMultiInvite.getName()) && getType() == linkMultiInvite.getType() && getUsersList().equals(linkMultiInvite.getUsersList()) && getAvatar().equals(linkMultiInvite.getAvatar()) && getTimeout() == linkMultiInvite.getTimeout() && this.unknownFields.equals(linkMultiInvite.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.LinkMultiInviteOrBuilder
    public String getAvatar() {
        Object obj = this.avatar_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.avatar_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.LinkMultiInviteOrBuilder
    public ByteString getAvatarBytes() {
        Object obj = this.avatar_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.avatar_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public LinkMultiInvite getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.LinkMultiInviteOrBuilder
    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.LinkMultiInviteOrBuilder
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
    public Parser<LinkMultiInvite> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        long j = this.uid_;
        int computeUInt64Size = j != 0 ? CodedOutputStream.computeUInt64Size(1, j) + 0 : 0;
        int i2 = computeUInt64Size;
        if (!getNameBytes().isEmpty()) {
            i2 = computeUInt64Size + GeneratedMessageV3.computeStringSize(2, this.name_);
        }
        int i3 = this.type_;
        int i4 = i2;
        int i5 = 0;
        if (i3 != 0) {
            i4 = i2 + CodedOutputStream.computeUInt32Size(3, i3);
            i5 = 0;
        }
        while (i5 < this.users_.size()) {
            i4 += CodedOutputStream.computeMessageSize(4, this.users_.get(i5));
            i5++;
        }
        int i6 = i4;
        if (!getAvatarBytes().isEmpty()) {
            i6 = i4 + GeneratedMessageV3.computeStringSize(5, this.avatar_);
        }
        int i7 = this.timeout_;
        int i8 = i6;
        if (i7 != 0) {
            i8 = i6 + CodedOutputStream.computeUInt32Size(6, i7);
        }
        int serializedSize = i8 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.LinkMultiInviteOrBuilder
    public int getTimeout() {
        return this.timeout_;
    }

    @Override // cn.irisgw.live.LinkMultiInviteOrBuilder
    public int getType() {
        return this.type_;
    }

    @Override // cn.irisgw.live.LinkMultiInviteOrBuilder
    public long getUid() {
        return this.uid_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // cn.irisgw.live.LinkMultiInviteOrBuilder
    public LinkMultiInviteUser getUsers(int i) {
        return this.users_.get(i);
    }

    @Override // cn.irisgw.live.LinkMultiInviteOrBuilder
    public int getUsersCount() {
        return this.users_.size();
    }

    @Override // cn.irisgw.live.LinkMultiInviteOrBuilder
    public List<LinkMultiInviteUser> getUsersList() {
        return this.users_;
    }

    @Override // cn.irisgw.live.LinkMultiInviteOrBuilder
    public LinkMultiInviteUserOrBuilder getUsersOrBuilder(int i) {
        return this.users_.get(i);
    }

    @Override // cn.irisgw.live.LinkMultiInviteOrBuilder
    public List<? extends LinkMultiInviteUserOrBuilder> getUsersOrBuilderList() {
        return this.users_;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(getUid())) * 37) + 2) * 53) + getName().hashCode()) * 37) + 3) * 53) + getType();
        int i = hashCode;
        if (getUsersCount() > 0) {
            i = (((hashCode * 37) + 4) * 53) + getUsersList().hashCode();
        }
        int hashCode2 = (((((((((i * 37) + 5) * 53) + getAvatar().hashCode()) * 37) + 6) * 53) + getTimeout()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_LinkMultiInvite_fieldAccessorTable.ensureFieldAccessorsInitialized(LinkMultiInvite.class, Builder.class);
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
        return new LinkMultiInvite();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        long j = this.uid_;
        if (j != 0) {
            codedOutputStream.writeUInt64(1, j);
        }
        if (!getNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.name_);
        }
        int i = this.type_;
        if (i != 0) {
            codedOutputStream.writeUInt32(3, i);
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.users_.size()) {
                break;
            }
            codedOutputStream.writeMessage(4, this.users_.get(i3));
            i2 = i3 + 1;
        }
        if (!getAvatarBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 5, this.avatar_);
        }
        int i4 = this.timeout_;
        if (i4 != 0) {
            codedOutputStream.writeUInt32(6, i4);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
