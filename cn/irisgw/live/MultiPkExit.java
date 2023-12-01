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
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/MultiPkExit.class */
public final class MultiPkExit extends GeneratedMessageV3 implements MultiPkExitOrBuilder {
    public static final int ACTION_USERS_FIELD_NUMBER = 1;
    private static final MultiPkExit DEFAULT_INSTANCE = new MultiPkExit();
    private static final Parser<MultiPkExit> PARSER = new AbstractParser<MultiPkExit>() { // from class: cn.irisgw.live.MultiPkExit.1
        @Override // com.google.protobuf.Parser
        public MultiPkExit parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new MultiPkExit(codedInputStream, extensionRegistryLite);
        }
    };
    private static final long serialVersionUID = 0;
    private LinkMultiUser actionUsers_;
    private byte memoizedIsInitialized;

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/MultiPkExit$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MultiPkExitOrBuilder {
        private SingleFieldBuilderV3<LinkMultiUser, LinkMultiUser.Builder, LinkMultiUserOrBuilder> actionUsersBuilder_;
        private LinkMultiUser actionUsers_;

        private Builder() {
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            maybeForceBuilderInitialization();
        }

        private SingleFieldBuilderV3<LinkMultiUser, LinkMultiUser.Builder, LinkMultiUserOrBuilder> getActionUsersFieldBuilder() {
            if (this.actionUsersBuilder_ == null) {
                this.actionUsersBuilder_ = new SingleFieldBuilderV3<>(getActionUsers(), getParentForChildren(), isClean());
                this.actionUsers_ = null;
            }
            return this.actionUsersBuilder_;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_MultiPkExit_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = MultiPkExit.alwaysUseFieldBuilders;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public MultiPkExit build() {
            MultiPkExit buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public MultiPkExit buildPartial() {
            MultiPkExit multiPkExit = new MultiPkExit(this);
            SingleFieldBuilderV3<LinkMultiUser, LinkMultiUser.Builder, LinkMultiUserOrBuilder> singleFieldBuilderV3 = this.actionUsersBuilder_;
            if (singleFieldBuilderV3 == null) {
                multiPkExit.actionUsers_ = this.actionUsers_;
            } else {
                multiPkExit.actionUsers_ = singleFieldBuilderV3.build();
            }
            onBuilt();
            return multiPkExit;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            if (this.actionUsersBuilder_ == null) {
                this.actionUsers_ = null;
                return this;
            }
            this.actionUsers_ = null;
            this.actionUsersBuilder_ = null;
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

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
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

        @Override // cn.irisgw.live.MultiPkExitOrBuilder
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

        @Override // cn.irisgw.live.MultiPkExitOrBuilder
        public LinkMultiUserOrBuilder getActionUsersOrBuilder() {
            SingleFieldBuilderV3<LinkMultiUser, LinkMultiUser.Builder, LinkMultiUserOrBuilder> singleFieldBuilderV3 = this.actionUsersBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            LinkMultiUser linkMultiUser = this.actionUsers_;
            LinkMultiUser linkMultiUser2 = linkMultiUser;
            if (linkMultiUser == null) {
                linkMultiUser2 = LinkMultiUser.getDefaultInstance();
            }
            return linkMultiUser2;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MultiPkExit getDefaultInstanceForType() {
            return MultiPkExit.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_MultiPkExit_descriptor;
        }

        @Override // cn.irisgw.live.MultiPkExitOrBuilder
        public boolean hasActionUsers() {
            return (this.actionUsersBuilder_ == null && this.actionUsers_ == null) ? false : true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_MultiPkExit_fieldAccessorTable.ensureFieldAccessorsInitialized(MultiPkExit.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
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
                this.actionUsers_ = LinkMultiUser.newBuilder(linkMultiUser2).mergeFrom(linkMultiUser).buildPartial();
            } else {
                this.actionUsers_ = linkMultiUser;
            }
            onChanged();
            return this;
        }

        public Builder mergeFrom(MultiPkExit multiPkExit) {
            if (multiPkExit == MultiPkExit.getDefaultInstance()) {
                return this;
            }
            if (multiPkExit.hasActionUsers()) {
                mergeActionUsers(multiPkExit.getActionUsers());
            }
            mergeUnknownFields(multiPkExit.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.MultiPkExit.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.MultiPkExit.access$1800()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.MultiPkExit r0 = (cn.irisgw.live.MultiPkExit) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.MultiPkExit$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.MultiPkExit r0 = (cn.irisgw.live.MultiPkExit) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.MultiPkExit$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.MultiPkExit.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.MultiPkExit$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof MultiPkExit) {
                return mergeFrom((MultiPkExit) message);
            }
            super.mergeFrom(message);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setActionUsers(LinkMultiUser.Builder builder) {
            SingleFieldBuilderV3<LinkMultiUser, LinkMultiUser.Builder, LinkMultiUserOrBuilder> singleFieldBuilderV3 = this.actionUsersBuilder_;
            if (singleFieldBuilderV3 != null) {
                singleFieldBuilderV3.setMessage(builder.build());
                return this;
            }
            this.actionUsers_ = builder.build();
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

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
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

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/MultiPkExit$LinkMultiUser.class */
    public static final class LinkMultiUser extends GeneratedMessageV3 implements LinkMultiUserOrBuilder {
        public static final int GROUP_ID_FIELD_NUMBER = 4;
        public static final int IS_MULTI_PK_END_FIELD_NUMBER = 3;
        public static final int MSG_FIELD_NUMBER = 2;
        public static final int UID_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int groupId_;
        private int isMultiPkEnd_;
        private byte memoizedIsInitialized;
        private volatile Object msg_;
        private long uid_;
        private static final LinkMultiUser DEFAULT_INSTANCE = new LinkMultiUser();
        private static final Parser<LinkMultiUser> PARSER = new AbstractParser<LinkMultiUser>() { // from class: cn.irisgw.live.MultiPkExit.LinkMultiUser.1
            @Override // com.google.protobuf.Parser
            public LinkMultiUser parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new LinkMultiUser(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/MultiPkExit$LinkMultiUser$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LinkMultiUserOrBuilder {
            private int groupId_;
            private int isMultiPkEnd_;
            private Object msg_;
            private long uid_;

            private Builder() {
                this.msg_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.msg_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LiveConstants.internal_static_cn_irisgw_live_MultiPkExit_LinkMultiUser_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = LinkMultiUser.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LinkMultiUser build() {
                LinkMultiUser buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LinkMultiUser buildPartial() {
                LinkMultiUser linkMultiUser = new LinkMultiUser(this);
                linkMultiUser.uid_ = this.uid_;
                linkMultiUser.msg_ = this.msg_;
                linkMultiUser.isMultiPkEnd_ = this.isMultiPkEnd_;
                linkMultiUser.groupId_ = this.groupId_;
                onBuilt();
                return linkMultiUser;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.uid_ = 0L;
                this.msg_ = "";
                this.isMultiPkEnd_ = 0;
                this.groupId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearGroupId() {
                this.groupId_ = 0;
                onChanged();
                return this;
            }

            public Builder clearIsMultiPkEnd() {
                this.isMultiPkEnd_ = 0;
                onChanged();
                return this;
            }

            public Builder clearMsg() {
                this.msg_ = LinkMultiUser.getDefaultInstance().getMsg();
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

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public LinkMultiUser getDefaultInstanceForType() {
                return LinkMultiUser.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return LiveConstants.internal_static_cn_irisgw_live_MultiPkExit_LinkMultiUser_descriptor;
            }

            @Override // cn.irisgw.live.MultiPkExit.LinkMultiUserOrBuilder
            public int getGroupId() {
                return this.groupId_;
            }

            @Override // cn.irisgw.live.MultiPkExit.LinkMultiUserOrBuilder
            public int getIsMultiPkEnd() {
                return this.isMultiPkEnd_;
            }

            @Override // cn.irisgw.live.MultiPkExit.LinkMultiUserOrBuilder
            public String getMsg() {
                Object obj = this.msg_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.msg_ = stringUtf8;
                return stringUtf8;
            }

            @Override // cn.irisgw.live.MultiPkExit.LinkMultiUserOrBuilder
            public ByteString getMsgBytes() {
                Object obj = this.msg_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.msg_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // cn.irisgw.live.MultiPkExit.LinkMultiUserOrBuilder
            public long getUid() {
                return this.uid_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveConstants.internal_static_cn_irisgw_live_MultiPkExit_LinkMultiUser_fieldAccessorTable.ensureFieldAccessorsInitialized(LinkMultiUser.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(LinkMultiUser linkMultiUser) {
                if (linkMultiUser == LinkMultiUser.getDefaultInstance()) {
                    return this;
                }
                if (linkMultiUser.getUid() != 0) {
                    setUid(linkMultiUser.getUid());
                }
                if (!linkMultiUser.getMsg().isEmpty()) {
                    this.msg_ = linkMultiUser.msg_;
                    onChanged();
                }
                if (linkMultiUser.getIsMultiPkEnd() != 0) {
                    setIsMultiPkEnd(linkMultiUser.getIsMultiPkEnd());
                }
                if (linkMultiUser.getGroupId() != 0) {
                    setGroupId(linkMultiUser.getGroupId());
                }
                mergeUnknownFields(linkMultiUser.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.MultiPkExit.LinkMultiUser.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.MultiPkExit.LinkMultiUser.access$900()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.MultiPkExit$LinkMultiUser r0 = (cn.irisgw.live.MultiPkExit.LinkMultiUser) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.MultiPkExit$LinkMultiUser$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.MultiPkExit$LinkMultiUser r0 = (cn.irisgw.live.MultiPkExit.LinkMultiUser) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.MultiPkExit$LinkMultiUser$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.MultiPkExit.LinkMultiUser.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.MultiPkExit$LinkMultiUser$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof LinkMultiUser) {
                    return mergeFrom((LinkMultiUser) message);
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

            public Builder setGroupId(int i) {
                this.groupId_ = i;
                onChanged();
                return this;
            }

            public Builder setIsMultiPkEnd(int i) {
                this.isMultiPkEnd_ = i;
                onChanged();
                return this;
            }

            public Builder setMsg(String str) {
                if (str != null) {
                    this.msg_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setMsgBytes(ByteString byteString) {
                if (byteString != null) {
                    LinkMultiUser.checkByteStringIsUtf8(byteString);
                    this.msg_ = byteString;
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

        private LinkMultiUser() {
            this.memoizedIsInitialized = (byte) -1;
            this.msg_ = "";
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
                                this.msg_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 24) {
                                this.isMultiPkEnd_ = codedInputStream.readUInt32();
                            } else if (readTag == 32) {
                                this.groupId_ = codedInputStream.readUInt32();
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

        private LinkMultiUser(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static LinkMultiUser getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_MultiPkExit_LinkMultiUser_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(LinkMultiUser linkMultiUser) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(linkMultiUser);
        }

        public static LinkMultiUser parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (LinkMultiUser) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static LinkMultiUser parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LinkMultiUser) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LinkMultiUser parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static LinkMultiUser parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static LinkMultiUser parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (LinkMultiUser) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static LinkMultiUser parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LinkMultiUser) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static LinkMultiUser parseFrom(InputStream inputStream) throws IOException {
            return (LinkMultiUser) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static LinkMultiUser parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (LinkMultiUser) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static LinkMultiUser parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static LinkMultiUser parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static LinkMultiUser parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static LinkMultiUser parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<LinkMultiUser> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof LinkMultiUser) {
                LinkMultiUser linkMultiUser = (LinkMultiUser) obj;
                return getUid() == linkMultiUser.getUid() && getMsg().equals(linkMultiUser.getMsg()) && getIsMultiPkEnd() == linkMultiUser.getIsMultiPkEnd() && getGroupId() == linkMultiUser.getGroupId() && this.unknownFields.equals(linkMultiUser.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public LinkMultiUser getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // cn.irisgw.live.MultiPkExit.LinkMultiUserOrBuilder
        public int getGroupId() {
            return this.groupId_;
        }

        @Override // cn.irisgw.live.MultiPkExit.LinkMultiUserOrBuilder
        public int getIsMultiPkEnd() {
            return this.isMultiPkEnd_;
        }

        @Override // cn.irisgw.live.MultiPkExit.LinkMultiUserOrBuilder
        public String getMsg() {
            Object obj = this.msg_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.msg_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.MultiPkExit.LinkMultiUserOrBuilder
        public ByteString getMsgBytes() {
            Object obj = this.msg_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.msg_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<LinkMultiUser> getParserForType() {
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
            if (!getMsgBytes().isEmpty()) {
                i3 = i2 + GeneratedMessageV3.computeStringSize(2, this.msg_);
            }
            int i4 = this.isMultiPkEnd_;
            int i5 = i3;
            if (i4 != 0) {
                i5 = i3 + CodedOutputStream.computeUInt32Size(3, i4);
            }
            int i6 = this.groupId_;
            int i7 = i5;
            if (i6 != 0) {
                i7 = i5 + CodedOutputStream.computeUInt32Size(4, i6);
            }
            int serializedSize = i7 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // cn.irisgw.live.MultiPkExit.LinkMultiUserOrBuilder
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
            int hashCode = ((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(getUid())) * 37) + 2) * 53) + getMsg().hashCode()) * 37) + 3) * 53) + getIsMultiPkEnd()) * 37) + 4) * 53) + getGroupId()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_MultiPkExit_LinkMultiUser_fieldAccessorTable.ensureFieldAccessorsInitialized(LinkMultiUser.class, Builder.class);
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
            return new LinkMultiUser();
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
            if (!getMsgBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.msg_);
            }
            int i = this.isMultiPkEnd_;
            if (i != 0) {
                codedOutputStream.writeUInt32(3, i);
            }
            int i2 = this.groupId_;
            if (i2 != 0) {
                codedOutputStream.writeUInt32(4, i2);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/MultiPkExit$LinkMultiUserOrBuilder.class */
    public interface LinkMultiUserOrBuilder extends MessageOrBuilder {
        int getGroupId();

        int getIsMultiPkEnd();

        String getMsg();

        ByteString getMsgBytes();

        long getUid();
    }

    private MultiPkExit() {
        this.memoizedIsInitialized = (byte) -1;
    }

    private MultiPkExit(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            if (readTag == 10) {
                                LinkMultiUser.Builder builder = this.actionUsers_ != null ? this.actionUsers_.toBuilder() : null;
                                LinkMultiUser linkMultiUser = (LinkMultiUser) codedInputStream.readMessage(LinkMultiUser.parser(), extensionRegistryLite);
                                this.actionUsers_ = linkMultiUser;
                                if (builder != null) {
                                    builder.mergeFrom(linkMultiUser);
                                    this.actionUsers_ = builder.buildPartial();
                                }
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

    private MultiPkExit(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static MultiPkExit getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_MultiPkExit_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(MultiPkExit multiPkExit) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(multiPkExit);
    }

    public static MultiPkExit parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (MultiPkExit) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static MultiPkExit parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MultiPkExit) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static MultiPkExit parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static MultiPkExit parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static MultiPkExit parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (MultiPkExit) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static MultiPkExit parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MultiPkExit) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static MultiPkExit parseFrom(InputStream inputStream) throws IOException {
        return (MultiPkExit) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static MultiPkExit parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MultiPkExit) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static MultiPkExit parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static MultiPkExit parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static MultiPkExit parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static MultiPkExit parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<MultiPkExit> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MultiPkExit) {
            MultiPkExit multiPkExit = (MultiPkExit) obj;
            if (hasActionUsers() != multiPkExit.hasActionUsers()) {
                return false;
            }
            return (!hasActionUsers() || getActionUsers().equals(multiPkExit.getActionUsers())) && this.unknownFields.equals(multiPkExit.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.MultiPkExitOrBuilder
    public LinkMultiUser getActionUsers() {
        LinkMultiUser linkMultiUser = this.actionUsers_;
        LinkMultiUser linkMultiUser2 = linkMultiUser;
        if (linkMultiUser == null) {
            linkMultiUser2 = LinkMultiUser.getDefaultInstance();
        }
        return linkMultiUser2;
    }

    @Override // cn.irisgw.live.MultiPkExitOrBuilder
    public LinkMultiUserOrBuilder getActionUsersOrBuilder() {
        return getActionUsers();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public MultiPkExit getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<MultiPkExit> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.actionUsers_ != null) {
            i2 = 0 + CodedOutputStream.computeMessageSize(1, getActionUsers());
        }
        int serializedSize = i2 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // cn.irisgw.live.MultiPkExitOrBuilder
    public boolean hasActionUsers() {
        return this.actionUsers_ != null;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = 779 + getDescriptor().hashCode();
        int i = hashCode;
        if (hasActionUsers()) {
            i = (((hashCode * 37) + 1) * 53) + getActionUsers().hashCode();
        }
        int hashCode2 = (i * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_MultiPkExit_fieldAccessorTable.ensureFieldAccessorsInitialized(MultiPkExit.class, Builder.class);
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
        return new MultiPkExit();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (this.actionUsers_ != null) {
            codedOutputStream.writeMessage(1, getActionUsers());
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
