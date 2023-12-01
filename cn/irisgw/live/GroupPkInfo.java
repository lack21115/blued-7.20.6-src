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

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/GroupPkInfo.class */
public final class GroupPkInfo extends GeneratedMessageV3 implements GroupPkInfoOrBuilder {
    public static final int FROM_UID_FIELD_NUMBER = 4;
    public static final int GROUP_INFO_FIELD_NUMBER = 1;
    public static final int TEXT_FIELD_NUMBER = 2;
    public static final int TYPE_FIELD_NUMBER = 3;
    private static final long serialVersionUID = 0;
    private int fromUid_;
    private List<Group> groupInfo_;
    private byte memoizedIsInitialized;
    private volatile Object text_;
    private int type_;
    private static final GroupPkInfo DEFAULT_INSTANCE = new GroupPkInfo();
    private static final Parser<GroupPkInfo> PARSER = new AbstractParser<GroupPkInfo>() { // from class: cn.irisgw.live.GroupPkInfo.1
        @Override // com.google.protobuf.Parser
        public GroupPkInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new GroupPkInfo(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/GroupPkInfo$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GroupPkInfoOrBuilder {
        private int bitField0_;
        private int fromUid_;
        private RepeatedFieldBuilderV3<Group, Group.Builder, GroupOrBuilder> groupInfoBuilder_;
        private List<Group> groupInfo_;
        private Object text_;
        private int type_;

        private Builder() {
            this.groupInfo_ = Collections.emptyList();
            this.text_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.groupInfo_ = Collections.emptyList();
            this.text_ = "";
            maybeForceBuilderInitialization();
        }

        private void ensureGroupInfoIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.groupInfo_ = new ArrayList(this.groupInfo_);
                this.bitField0_ |= 1;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_GroupPkInfo_descriptor;
        }

        private RepeatedFieldBuilderV3<Group, Group.Builder, GroupOrBuilder> getGroupInfoFieldBuilder() {
            if (this.groupInfoBuilder_ == null) {
                List<Group> list = this.groupInfo_;
                boolean z = true;
                if ((this.bitField0_ & 1) == 0) {
                    z = false;
                }
                this.groupInfoBuilder_ = new RepeatedFieldBuilderV3<>(list, z, getParentForChildren(), isClean());
                this.groupInfo_ = null;
            }
            return this.groupInfoBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (GroupPkInfo.alwaysUseFieldBuilders) {
                getGroupInfoFieldBuilder();
            }
        }

        public Builder addAllGroupInfo(Iterable<? extends Group> iterable) {
            RepeatedFieldBuilderV3<Group, Group.Builder, GroupOrBuilder> repeatedFieldBuilderV3 = this.groupInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addAllMessages(iterable);
                return this;
            }
            ensureGroupInfoIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.groupInfo_);
            onChanged();
            return this;
        }

        public Builder addGroupInfo(int i, Group.Builder builder) {
            RepeatedFieldBuilderV3<Group, Group.Builder, GroupOrBuilder> repeatedFieldBuilderV3 = this.groupInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, builder.build());
                return this;
            }
            ensureGroupInfoIsMutable();
            this.groupInfo_.add(i, builder.build());
            onChanged();
            return this;
        }

        public Builder addGroupInfo(int i, Group group) {
            RepeatedFieldBuilderV3<Group, Group.Builder, GroupOrBuilder> repeatedFieldBuilderV3 = this.groupInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(i, group);
                return this;
            } else if (group != null) {
                ensureGroupInfoIsMutable();
                this.groupInfo_.add(i, group);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Builder addGroupInfo(Group.Builder builder) {
            RepeatedFieldBuilderV3<Group, Group.Builder, GroupOrBuilder> repeatedFieldBuilderV3 = this.groupInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(builder.build());
                return this;
            }
            ensureGroupInfoIsMutable();
            this.groupInfo_.add(builder.build());
            onChanged();
            return this;
        }

        public Builder addGroupInfo(Group group) {
            RepeatedFieldBuilderV3<Group, Group.Builder, GroupOrBuilder> repeatedFieldBuilderV3 = this.groupInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.addMessage(group);
                return this;
            } else if (group != null) {
                ensureGroupInfoIsMutable();
                this.groupInfo_.add(group);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        public Group.Builder addGroupInfoBuilder() {
            return getGroupInfoFieldBuilder().addBuilder(Group.getDefaultInstance());
        }

        public Group.Builder addGroupInfoBuilder(int i) {
            return getGroupInfoFieldBuilder().addBuilder(i, Group.getDefaultInstance());
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public GroupPkInfo build() {
            GroupPkInfo buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public GroupPkInfo buildPartial() {
            GroupPkInfo groupPkInfo = new GroupPkInfo(this);
            int i = this.bitField0_;
            RepeatedFieldBuilderV3<Group, Group.Builder, GroupOrBuilder> repeatedFieldBuilderV3 = this.groupInfoBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((i & 1) != 0) {
                    this.groupInfo_ = Collections.unmodifiableList(this.groupInfo_);
                    this.bitField0_ &= -2;
                }
                groupPkInfo.groupInfo_ = this.groupInfo_;
            } else {
                groupPkInfo.groupInfo_ = repeatedFieldBuilderV3.build();
            }
            groupPkInfo.text_ = this.text_;
            groupPkInfo.type_ = this.type_;
            groupPkInfo.fromUid_ = this.fromUid_;
            onBuilt();
            return groupPkInfo;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            RepeatedFieldBuilderV3<Group, Group.Builder, GroupOrBuilder> repeatedFieldBuilderV3 = this.groupInfoBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.groupInfo_ = Collections.emptyList();
                this.bitField0_ &= -2;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            this.text_ = "";
            this.type_ = 0;
            this.fromUid_ = 0;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearFromUid() {
            this.fromUid_ = 0;
            onChanged();
            return this;
        }

        public Builder clearGroupInfo() {
            RepeatedFieldBuilderV3<Group, Group.Builder, GroupOrBuilder> repeatedFieldBuilderV3 = this.groupInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.clear();
                return this;
            }
            this.groupInfo_ = Collections.emptyList();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearText() {
            this.text_ = GroupPkInfo.getDefaultInstance().getText();
            onChanged();
            return this;
        }

        public Builder clearType() {
            this.type_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo1800clone() {
            return (Builder) super.mo1800clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GroupPkInfo getDefaultInstanceForType() {
            return GroupPkInfo.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_GroupPkInfo_descriptor;
        }

        @Override // cn.irisgw.live.GroupPkInfoOrBuilder
        public int getFromUid() {
            return this.fromUid_;
        }

        @Override // cn.irisgw.live.GroupPkInfoOrBuilder
        public Group getGroupInfo(int i) {
            RepeatedFieldBuilderV3<Group, Group.Builder, GroupOrBuilder> repeatedFieldBuilderV3 = this.groupInfoBuilder_;
            return repeatedFieldBuilderV3 == null ? this.groupInfo_.get(i) : repeatedFieldBuilderV3.getMessage(i);
        }

        public Group.Builder getGroupInfoBuilder(int i) {
            return getGroupInfoFieldBuilder().getBuilder(i);
        }

        public List<Group.Builder> getGroupInfoBuilderList() {
            return getGroupInfoFieldBuilder().getBuilderList();
        }

        @Override // cn.irisgw.live.GroupPkInfoOrBuilder
        public int getGroupInfoCount() {
            RepeatedFieldBuilderV3<Group, Group.Builder, GroupOrBuilder> repeatedFieldBuilderV3 = this.groupInfoBuilder_;
            return repeatedFieldBuilderV3 == null ? this.groupInfo_.size() : repeatedFieldBuilderV3.getCount();
        }

        @Override // cn.irisgw.live.GroupPkInfoOrBuilder
        public List<Group> getGroupInfoList() {
            RepeatedFieldBuilderV3<Group, Group.Builder, GroupOrBuilder> repeatedFieldBuilderV3 = this.groupInfoBuilder_;
            return repeatedFieldBuilderV3 == null ? Collections.unmodifiableList(this.groupInfo_) : repeatedFieldBuilderV3.getMessageList();
        }

        @Override // cn.irisgw.live.GroupPkInfoOrBuilder
        public GroupOrBuilder getGroupInfoOrBuilder(int i) {
            RepeatedFieldBuilderV3<Group, Group.Builder, GroupOrBuilder> repeatedFieldBuilderV3 = this.groupInfoBuilder_;
            return repeatedFieldBuilderV3 == null ? this.groupInfo_.get(i) : repeatedFieldBuilderV3.getMessageOrBuilder(i);
        }

        @Override // cn.irisgw.live.GroupPkInfoOrBuilder
        public List<? extends GroupOrBuilder> getGroupInfoOrBuilderList() {
            RepeatedFieldBuilderV3<Group, Group.Builder, GroupOrBuilder> repeatedFieldBuilderV3 = this.groupInfoBuilder_;
            return repeatedFieldBuilderV3 != null ? repeatedFieldBuilderV3.getMessageOrBuilderList() : Collections.unmodifiableList(this.groupInfo_);
        }

        @Override // cn.irisgw.live.GroupPkInfoOrBuilder
        public String getText() {
            Object obj = this.text_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.text_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.GroupPkInfoOrBuilder
        public ByteString getTextBytes() {
            Object obj = this.text_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.text_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.GroupPkInfoOrBuilder
        public int getType() {
            return this.type_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_GroupPkInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(GroupPkInfo.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(GroupPkInfo groupPkInfo) {
            if (groupPkInfo == GroupPkInfo.getDefaultInstance()) {
                return this;
            }
            if (this.groupInfoBuilder_ == null) {
                if (!groupPkInfo.groupInfo_.isEmpty()) {
                    if (this.groupInfo_.isEmpty()) {
                        this.groupInfo_ = groupPkInfo.groupInfo_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureGroupInfoIsMutable();
                        this.groupInfo_.addAll(groupPkInfo.groupInfo_);
                    }
                    onChanged();
                }
            } else if (!groupPkInfo.groupInfo_.isEmpty()) {
                if (this.groupInfoBuilder_.isEmpty()) {
                    this.groupInfoBuilder_.dispose();
                    RepeatedFieldBuilderV3<Group, Group.Builder, GroupOrBuilder> repeatedFieldBuilderV3 = null;
                    this.groupInfoBuilder_ = null;
                    this.groupInfo_ = groupPkInfo.groupInfo_;
                    this.bitField0_ &= -2;
                    if (GroupPkInfo.alwaysUseFieldBuilders) {
                        repeatedFieldBuilderV3 = getGroupInfoFieldBuilder();
                    }
                    this.groupInfoBuilder_ = repeatedFieldBuilderV3;
                } else {
                    this.groupInfoBuilder_.addAllMessages(groupPkInfo.groupInfo_);
                }
            }
            if (!groupPkInfo.getText().isEmpty()) {
                this.text_ = groupPkInfo.text_;
                onChanged();
            }
            if (groupPkInfo.getType() != 0) {
                setType(groupPkInfo.getType());
            }
            if (groupPkInfo.getFromUid() != 0) {
                setFromUid(groupPkInfo.getFromUid());
            }
            mergeUnknownFields(groupPkInfo.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.GroupPkInfo.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.GroupPkInfo.access$1900()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.GroupPkInfo r0 = (cn.irisgw.live.GroupPkInfo) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.GroupPkInfo$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.GroupPkInfo r0 = (cn.irisgw.live.GroupPkInfo) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.GroupPkInfo$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.GroupPkInfo.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.GroupPkInfo$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof GroupPkInfo) {
                return mergeFrom((GroupPkInfo) message);
            }
            super.mergeFrom(message);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder removeGroupInfo(int i) {
            RepeatedFieldBuilderV3<Group, Group.Builder, GroupOrBuilder> repeatedFieldBuilderV3 = this.groupInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.remove(i);
                return this;
            }
            ensureGroupInfoIsMutable();
            this.groupInfo_.remove(i);
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setFromUid(int i) {
            this.fromUid_ = i;
            onChanged();
            return this;
        }

        public Builder setGroupInfo(int i, Group.Builder builder) {
            RepeatedFieldBuilderV3<Group, Group.Builder, GroupOrBuilder> repeatedFieldBuilderV3 = this.groupInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, builder.build());
                return this;
            }
            ensureGroupInfoIsMutable();
            this.groupInfo_.set(i, builder.build());
            onChanged();
            return this;
        }

        public Builder setGroupInfo(int i, Group group) {
            RepeatedFieldBuilderV3<Group, Group.Builder, GroupOrBuilder> repeatedFieldBuilderV3 = this.groupInfoBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                repeatedFieldBuilderV3.setMessage(i, group);
                return this;
            } else if (group != null) {
                ensureGroupInfoIsMutable();
                this.groupInfo_.set(i, group);
                onChanged();
                return this;
            } else {
                throw null;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
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
                GroupPkInfo.checkByteStringIsUtf8(byteString);
                this.text_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setType(int i) {
            this.type_ = i;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/GroupPkInfo$Group.class */
    public static final class Group extends GeneratedMessageV3 implements GroupOrBuilder {
        public static final int GROUP_ID_FIELD_NUMBER = 2;
        public static final int UID_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private int groupId_;
        private byte memoizedIsInitialized;
        private int uid_;
        private static final Group DEFAULT_INSTANCE = new Group();
        private static final Parser<Group> PARSER = new AbstractParser<Group>() { // from class: cn.irisgw.live.GroupPkInfo.Group.1
            @Override // com.google.protobuf.Parser
            public Group parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Group(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/GroupPkInfo$Group$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GroupOrBuilder {
            private int groupId_;
            private int uid_;

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return LiveConstants.internal_static_cn_irisgw_live_GroupPkInfo_Group_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = Group.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Group build() {
                Group buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Group buildPartial() {
                Group group = new Group(this);
                group.uid_ = this.uid_;
                group.groupId_ = this.groupId_;
                onBuilt();
                return group;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.uid_ = 0;
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearUid() {
                this.uid_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1800clone() {
                return (Builder) super.mo1800clone();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Group getDefaultInstanceForType() {
                return Group.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return LiveConstants.internal_static_cn_irisgw_live_GroupPkInfo_Group_descriptor;
            }

            @Override // cn.irisgw.live.GroupPkInfo.GroupOrBuilder
            public int getGroupId() {
                return this.groupId_;
            }

            @Override // cn.irisgw.live.GroupPkInfo.GroupOrBuilder
            public int getUid() {
                return this.uid_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LiveConstants.internal_static_cn_irisgw_live_GroupPkInfo_Group_fieldAccessorTable.ensureFieldAccessorsInitialized(Group.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(Group group) {
                if (group == Group.getDefaultInstance()) {
                    return this;
                }
                if (group.getUid() != 0) {
                    setUid(group.getUid());
                }
                if (group.getGroupId() != 0) {
                    setGroupId(group.getGroupId());
                }
                mergeUnknownFields(group.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public cn.irisgw.live.GroupPkInfo.Group.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = cn.irisgw.live.GroupPkInfo.Group.access$700()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    cn.irisgw.live.GroupPkInfo$Group r0 = (cn.irisgw.live.GroupPkInfo.Group) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    cn.irisgw.live.GroupPkInfo$Group$Builder r0 = r0.mergeFrom(r1)
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
                    cn.irisgw.live.GroupPkInfo$Group r0 = (cn.irisgw.live.GroupPkInfo.Group) r0     // Catch: java.lang.Throwable -> L1c
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
                    cn.irisgw.live.GroupPkInfo$Group$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.GroupPkInfo.Group.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.GroupPkInfo$Group$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof Group) {
                    return mergeFrom((Group) message);
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setUid(int i) {
                this.uid_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private Group() {
            this.memoizedIsInitialized = (byte) -1;
        }

        private Group(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.uid_ = codedInputStream.readUInt32();
                                } else if (readTag == 16) {
                                    this.groupId_ = codedInputStream.readUInt32();
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

        private Group(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Group getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_GroupPkInfo_Group_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Group group) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(group);
        }

        public static Group parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Group) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Group parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Group) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Group parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static Group parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static Group parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Group) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Group parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Group) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static Group parseFrom(InputStream inputStream) throws IOException {
            return (Group) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Group parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Group) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Group parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Group parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static Group parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static Group parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<Group> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Group) {
                Group group = (Group) obj;
                return getUid() == group.getUid() && getGroupId() == group.getGroupId() && this.unknownFields.equals(group.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Group getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // cn.irisgw.live.GroupPkInfo.GroupOrBuilder
        public int getGroupId() {
            return this.groupId_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Group> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            int i3 = this.uid_;
            if (i3 != 0) {
                i2 = 0 + CodedOutputStream.computeUInt32Size(1, i3);
            }
            int i4 = this.groupId_;
            int i5 = i2;
            if (i4 != 0) {
                i5 = i2 + CodedOutputStream.computeUInt32Size(2, i4);
            }
            int serializedSize = i5 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // cn.irisgw.live.GroupPkInfo.GroupOrBuilder
        public int getUid() {
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
            int hashCode = ((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getUid()) * 37) + 2) * 53) + getGroupId()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_GroupPkInfo_Group_fieldAccessorTable.ensureFieldAccessorsInitialized(Group.class, Builder.class);
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
            return new Group();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i = this.uid_;
            if (i != 0) {
                codedOutputStream.writeUInt32(1, i);
            }
            int i2 = this.groupId_;
            if (i2 != 0) {
                codedOutputStream.writeUInt32(2, i2);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/GroupPkInfo$GroupOrBuilder.class */
    public interface GroupOrBuilder extends MessageOrBuilder {
        int getGroupId();

        int getUid();
    }

    private GroupPkInfo() {
        this.memoizedIsInitialized = (byte) -1;
        this.groupInfo_ = Collections.emptyList();
        this.text_ = "";
    }

    private GroupPkInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.groupInfo_ = new ArrayList();
                                z4 = z2 | true;
                            }
                            this.groupInfo_.add((Group) codedInputStream.readMessage(Group.parser(), extensionRegistryLite));
                            z2 = z4;
                        } else if (readTag == 18) {
                            this.text_ = codedInputStream.readStringRequireUtf8();
                        } else if (readTag == 24) {
                            this.type_ = codedInputStream.readUInt32();
                        } else if (readTag == 32) {
                            this.fromUid_ = codedInputStream.readUInt32();
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
                    this.groupInfo_ = Collections.unmodifiableList(this.groupInfo_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                throw th;
            }
        }
        if (z2 & true) {
            this.groupInfo_ = Collections.unmodifiableList(this.groupInfo_);
        }
        this.unknownFields = newBuilder.build();
        makeExtensionsImmutable();
    }

    private GroupPkInfo(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static GroupPkInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_GroupPkInfo_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(GroupPkInfo groupPkInfo) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(groupPkInfo);
    }

    public static GroupPkInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (GroupPkInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static GroupPkInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GroupPkInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static GroupPkInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static GroupPkInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static GroupPkInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (GroupPkInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static GroupPkInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GroupPkInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static GroupPkInfo parseFrom(InputStream inputStream) throws IOException {
        return (GroupPkInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static GroupPkInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GroupPkInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static GroupPkInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static GroupPkInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static GroupPkInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static GroupPkInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<GroupPkInfo> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GroupPkInfo) {
            GroupPkInfo groupPkInfo = (GroupPkInfo) obj;
            return getGroupInfoList().equals(groupPkInfo.getGroupInfoList()) && getText().equals(groupPkInfo.getText()) && getType() == groupPkInfo.getType() && getFromUid() == groupPkInfo.getFromUid() && this.unknownFields.equals(groupPkInfo.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public GroupPkInfo getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.GroupPkInfoOrBuilder
    public int getFromUid() {
        return this.fromUid_;
    }

    @Override // cn.irisgw.live.GroupPkInfoOrBuilder
    public Group getGroupInfo(int i) {
        return this.groupInfo_.get(i);
    }

    @Override // cn.irisgw.live.GroupPkInfoOrBuilder
    public int getGroupInfoCount() {
        return this.groupInfo_.size();
    }

    @Override // cn.irisgw.live.GroupPkInfoOrBuilder
    public List<Group> getGroupInfoList() {
        return this.groupInfo_;
    }

    @Override // cn.irisgw.live.GroupPkInfoOrBuilder
    public GroupOrBuilder getGroupInfoOrBuilder(int i) {
        return this.groupInfo_.get(i);
    }

    @Override // cn.irisgw.live.GroupPkInfoOrBuilder
    public List<? extends GroupOrBuilder> getGroupInfoOrBuilderList() {
        return this.groupInfo_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<GroupPkInfo> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.groupInfo_.size(); i3++) {
            i2 += CodedOutputStream.computeMessageSize(1, this.groupInfo_.get(i3));
        }
        int i4 = i2;
        if (!getTextBytes().isEmpty()) {
            i4 = i2 + GeneratedMessageV3.computeStringSize(2, this.text_);
        }
        int i5 = this.type_;
        int i6 = i4;
        if (i5 != 0) {
            i6 = i4 + CodedOutputStream.computeUInt32Size(3, i5);
        }
        int i7 = this.fromUid_;
        int i8 = i6;
        if (i7 != 0) {
            i8 = i6 + CodedOutputStream.computeUInt32Size(4, i7);
        }
        int serializedSize = i8 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.GroupPkInfoOrBuilder
    public String getText() {
        Object obj = this.text_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.text_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.GroupPkInfoOrBuilder
    public ByteString getTextBytes() {
        Object obj = this.text_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.text_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.GroupPkInfoOrBuilder
    public int getType() {
        return this.type_;
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
        int hashCode = 779 + getDescriptor().hashCode();
        int i = hashCode;
        if (getGroupInfoCount() > 0) {
            i = (((hashCode * 37) + 1) * 53) + getGroupInfoList().hashCode();
        }
        int hashCode2 = (((((((((((((i * 37) + 2) * 53) + getText().hashCode()) * 37) + 3) * 53) + getType()) * 37) + 4) * 53) + getFromUid()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_GroupPkInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(GroupPkInfo.class, Builder.class);
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
        return new GroupPkInfo();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.groupInfo_.size()) {
                break;
            }
            codedOutputStream.writeMessage(1, this.groupInfo_.get(i2));
            i = i2 + 1;
        }
        if (!getTextBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.text_);
        }
        int i3 = this.type_;
        if (i3 != 0) {
            codedOutputStream.writeUInt32(3, i3);
        }
        int i4 = this.fromUid_;
        if (i4 != 0) {
            codedOutputStream.writeUInt32(4, i4);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
