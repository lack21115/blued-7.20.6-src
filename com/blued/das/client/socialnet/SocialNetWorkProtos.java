package com.blued.das.client.socialnet;

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

/* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/socialnet/SocialNetWorkProtos.class */
public final class SocialNetWorkProtos {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019SocialNetWorkProtos.proto\u0012\u001ecom.blued.das.client.socialnet\"´\u0001\n\u0012SocialNetWorkProto\u00124\n\u0005event\u0018\u0001 \u0001(\u000e2%.com.blued.das.client.socialnet.Event\u0012\u0010\n\bgroup_id\u0018\u0002 \u0001(\t\u0012:\n\u0006source\u0018\u0003 \u0001(\u000e2*.com.blued.das.client.socialnet.SourceType\u0012\f\n\u0004name\u0018\u0004 \u0001(\t\u0012\f\n\u0004type\u0018\u0005 \u0001(\t*Ê\u0006\n\u0005Event\u0012\u0011\n\rUNKNOWN_EVENT\u0010��\u0012\u0014\n\u0010GROUP_JOIN_CLICK\u0010\u0001\u0012\u0013\n\u000fGROUP_CHAT_SHOW\u0010\u0002\u0012\u0016\n\u0012GROUP_PROFILE_SHOW\u0010\u0003\u0012\u0016\n\u0012GROUP_CREATE_CLICK\u0010\u0004\u0012\u001d\n\u0019GROUP_JOIN_LIMIT_POP_SHOW\u0010\u0005\u0012%\n!GROUP_JOIN_LIMIT_POP_INVITE_CLICK\u0010\u0006\u0012%\n!GROUP_JOIN_LIMIT_POP_WECHAT_CLICK\u0010\u0007\u0012\u001b\n\u0017GROUP_PASSWORD_POP_SHOW\u0010\b\u0012\u001d\n\u0019GROUP_PASSWORD_LOOK_CLICK\u0010\t\u0012 \n\u001cGROUP_PASSWORD_SUPPORT_CLICK\u0010\n\u0012\"\n\u001eGROUP_PASSWORD_SUPPORT_SUCCESS\u0010\u000b\u0012\u001f\n\u001bGROUP_PASSWORD_SUPPORT_FAIL\u0010\f\u0012'\n#GROUP_PASSWORD_EXTRA_TIMES_POP_SHOW\u0010\r\u0012\u000e\n\nGROUP_DRAW\u0010\u000e\u0012\u000f\n\u000bGROUP_CLICK\u0010\u000f\u0012\u001c\n\u0018GROUP_NEW_GUIDE_POP_SHOW\u0010\u0010\u0012!\n\u001dGROUP_NEW_GUIDE_POP_BUY_CLICK\u0010\u0011\u0012\u001c\n\u0018GROUP_OLD_GUIDE_POP_SHOW\u0010\u0012\u0012!\n\u001dGROUP_OLD_GUIDE_POP_BUY_CLICK\u0010\u0013\u0012\u001c\n\u0018GROUP_UP_LIMITE_POP_SHOW\u0010\u0014\u0012!\n\u001dGROUP_UP_LIMITE_POP_YES_CLICK\u0010\u0015\u0012&\n\"GROUP_INVITE_TASK_TRIGGER_POP_SHOW\u0010\u0016\u0012+\n'GROUP_INVITE_TASK_TRIGGER_POP_BUY_CLICK\u0010\u0017\u0012$\n GROUP_INVITE_TASK_DOING_POP_SHOW\u0010\u0018\u0012)\n%GROUP_INVITE_TASK_DOING_POP_BUY_CLICK\u0010\u0019\u0012\u0010\n\fGROUP_SEARCH\u0010\u001a*\u008b\u0001\n\nSourceType\u0012\u0017\n\u0013UNKNOWN_SOURCE_TYPE\u0010��\u0012\u000b\n\u0007MESSAGE\u0010\u0001\u0012\n\n\u0006CIRCLE\u0010\u0002\u0012\u000b\n\u0007MYGROUP\u0010\u0003\u0012\r\n\tGROUPINFO\u0010\u0004\u0012\n\n\u0006CREATE\u0010\u0005\u0012\b\n\u0004JOIN\u0010\u0006\u0012\n\n\u0006NEARBY\u0010\u0007\u0012\r\n\tRECOMMEND\u0010\bB\u0006¢\u0002\u0003SNSb\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_com_blued_das_client_socialnet_SocialNetWorkProto_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_client_socialnet_SocialNetWorkProto_fieldAccessorTable;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/socialnet/SocialNetWorkProtos$Event.class */
    public enum Event implements ProtocolMessageEnum {
        UNKNOWN_EVENT(0),
        GROUP_JOIN_CLICK(1),
        GROUP_CHAT_SHOW(2),
        GROUP_PROFILE_SHOW(3),
        GROUP_CREATE_CLICK(4),
        GROUP_JOIN_LIMIT_POP_SHOW(5),
        GROUP_JOIN_LIMIT_POP_INVITE_CLICK(6),
        GROUP_JOIN_LIMIT_POP_WECHAT_CLICK(7),
        GROUP_PASSWORD_POP_SHOW(8),
        GROUP_PASSWORD_LOOK_CLICK(9),
        GROUP_PASSWORD_SUPPORT_CLICK(10),
        GROUP_PASSWORD_SUPPORT_SUCCESS(11),
        GROUP_PASSWORD_SUPPORT_FAIL(12),
        GROUP_PASSWORD_EXTRA_TIMES_POP_SHOW(13),
        GROUP_DRAW(14),
        GROUP_CLICK(15),
        GROUP_NEW_GUIDE_POP_SHOW(16),
        GROUP_NEW_GUIDE_POP_BUY_CLICK(17),
        GROUP_OLD_GUIDE_POP_SHOW(18),
        GROUP_OLD_GUIDE_POP_BUY_CLICK(19),
        GROUP_UP_LIMITE_POP_SHOW(20),
        GROUP_UP_LIMITE_POP_YES_CLICK(21),
        GROUP_INVITE_TASK_TRIGGER_POP_SHOW(22),
        GROUP_INVITE_TASK_TRIGGER_POP_BUY_CLICK(23),
        GROUP_INVITE_TASK_DOING_POP_SHOW(24),
        GROUP_INVITE_TASK_DOING_POP_BUY_CLICK(25),
        GROUP_SEARCH(26),
        UNRECOGNIZED(-1);
        
        public static final int GROUP_CHAT_SHOW_VALUE = 2;
        public static final int GROUP_CLICK_VALUE = 15;
        public static final int GROUP_CREATE_CLICK_VALUE = 4;
        public static final int GROUP_DRAW_VALUE = 14;
        public static final int GROUP_INVITE_TASK_DOING_POP_BUY_CLICK_VALUE = 25;
        public static final int GROUP_INVITE_TASK_DOING_POP_SHOW_VALUE = 24;
        public static final int GROUP_INVITE_TASK_TRIGGER_POP_BUY_CLICK_VALUE = 23;
        public static final int GROUP_INVITE_TASK_TRIGGER_POP_SHOW_VALUE = 22;
        public static final int GROUP_JOIN_CLICK_VALUE = 1;
        public static final int GROUP_JOIN_LIMIT_POP_INVITE_CLICK_VALUE = 6;
        public static final int GROUP_JOIN_LIMIT_POP_SHOW_VALUE = 5;
        public static final int GROUP_JOIN_LIMIT_POP_WECHAT_CLICK_VALUE = 7;
        public static final int GROUP_NEW_GUIDE_POP_BUY_CLICK_VALUE = 17;
        public static final int GROUP_NEW_GUIDE_POP_SHOW_VALUE = 16;
        public static final int GROUP_OLD_GUIDE_POP_BUY_CLICK_VALUE = 19;
        public static final int GROUP_OLD_GUIDE_POP_SHOW_VALUE = 18;
        public static final int GROUP_PASSWORD_EXTRA_TIMES_POP_SHOW_VALUE = 13;
        public static final int GROUP_PASSWORD_LOOK_CLICK_VALUE = 9;
        public static final int GROUP_PASSWORD_POP_SHOW_VALUE = 8;
        public static final int GROUP_PASSWORD_SUPPORT_CLICK_VALUE = 10;
        public static final int GROUP_PASSWORD_SUPPORT_FAIL_VALUE = 12;
        public static final int GROUP_PASSWORD_SUPPORT_SUCCESS_VALUE = 11;
        public static final int GROUP_PROFILE_SHOW_VALUE = 3;
        public static final int GROUP_SEARCH_VALUE = 26;
        public static final int GROUP_UP_LIMITE_POP_SHOW_VALUE = 20;
        public static final int GROUP_UP_LIMITE_POP_YES_CLICK_VALUE = 21;
        public static final int UNKNOWN_EVENT_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<Event> internalValueMap = new Internal.EnumLiteMap<Event>() { // from class: com.blued.das.client.socialnet.SocialNetWorkProtos.Event.1
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
                    return GROUP_JOIN_CLICK;
                case 2:
                    return GROUP_CHAT_SHOW;
                case 3:
                    return GROUP_PROFILE_SHOW;
                case 4:
                    return GROUP_CREATE_CLICK;
                case 5:
                    return GROUP_JOIN_LIMIT_POP_SHOW;
                case 6:
                    return GROUP_JOIN_LIMIT_POP_INVITE_CLICK;
                case 7:
                    return GROUP_JOIN_LIMIT_POP_WECHAT_CLICK;
                case 8:
                    return GROUP_PASSWORD_POP_SHOW;
                case 9:
                    return GROUP_PASSWORD_LOOK_CLICK;
                case 10:
                    return GROUP_PASSWORD_SUPPORT_CLICK;
                case 11:
                    return GROUP_PASSWORD_SUPPORT_SUCCESS;
                case 12:
                    return GROUP_PASSWORD_SUPPORT_FAIL;
                case 13:
                    return GROUP_PASSWORD_EXTRA_TIMES_POP_SHOW;
                case 14:
                    return GROUP_DRAW;
                case 15:
                    return GROUP_CLICK;
                case 16:
                    return GROUP_NEW_GUIDE_POP_SHOW;
                case 17:
                    return GROUP_NEW_GUIDE_POP_BUY_CLICK;
                case 18:
                    return GROUP_OLD_GUIDE_POP_SHOW;
                case 19:
                    return GROUP_OLD_GUIDE_POP_BUY_CLICK;
                case 20:
                    return GROUP_UP_LIMITE_POP_SHOW;
                case 21:
                    return GROUP_UP_LIMITE_POP_YES_CLICK;
                case 22:
                    return GROUP_INVITE_TASK_TRIGGER_POP_SHOW;
                case 23:
                    return GROUP_INVITE_TASK_TRIGGER_POP_BUY_CLICK;
                case 24:
                    return GROUP_INVITE_TASK_DOING_POP_SHOW;
                case 25:
                    return GROUP_INVITE_TASK_DOING_POP_BUY_CLICK;
                case 26:
                    return GROUP_SEARCH;
                default:
                    return null;
            }
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return SocialNetWorkProtos.getDescriptor().getEnumTypes().get(0);
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

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/socialnet/SocialNetWorkProtos$SocialNetWorkProto.class */
    public static final class SocialNetWorkProto extends GeneratedMessageV3 implements SocialNetWorkProtoOrBuilder {
        public static final int EVENT_FIELD_NUMBER = 1;
        public static final int GROUP_ID_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 4;
        public static final int SOURCE_FIELD_NUMBER = 3;
        public static final int TYPE_FIELD_NUMBER = 5;
        private static final long serialVersionUID = 0;
        private int event_;
        private volatile Object groupId_;
        private byte memoizedIsInitialized;
        private volatile Object name_;
        private int source_;
        private volatile Object type_;
        private static final SocialNetWorkProto DEFAULT_INSTANCE = new SocialNetWorkProto();
        private static final Parser<SocialNetWorkProto> PARSER = new AbstractParser<SocialNetWorkProto>() { // from class: com.blued.das.client.socialnet.SocialNetWorkProtos.SocialNetWorkProto.1
            @Override // com.google.protobuf.Parser
            public SocialNetWorkProto parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new SocialNetWorkProto(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/socialnet/SocialNetWorkProtos$SocialNetWorkProto$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SocialNetWorkProtoOrBuilder {
            private int event_;
            private Object groupId_;
            private Object name_;
            private int source_;
            private Object type_;

            private Builder() {
                this.event_ = 0;
                this.groupId_ = "";
                this.source_ = 0;
                this.name_ = "";
                this.type_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.event_ = 0;
                this.groupId_ = "";
                this.source_ = 0;
                this.name_ = "";
                this.type_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return SocialNetWorkProtos.internal_static_com_blued_das_client_socialnet_SocialNetWorkProto_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = SocialNetWorkProto.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SocialNetWorkProto build() {
                SocialNetWorkProto buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SocialNetWorkProto buildPartial() {
                SocialNetWorkProto socialNetWorkProto = new SocialNetWorkProto(this);
                socialNetWorkProto.event_ = this.event_;
                socialNetWorkProto.groupId_ = this.groupId_;
                socialNetWorkProto.source_ = this.source_;
                socialNetWorkProto.name_ = this.name_;
                socialNetWorkProto.type_ = this.type_;
                onBuilt();
                return socialNetWorkProto;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.event_ = 0;
                this.groupId_ = "";
                this.source_ = 0;
                this.name_ = "";
                this.type_ = "";
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

            public Builder clearGroupId() {
                this.groupId_ = SocialNetWorkProto.getDefaultInstance().getGroupId();
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.name_ = SocialNetWorkProto.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearSource() {
                this.source_ = 0;
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.type_ = SocialNetWorkProto.getDefaultInstance().getType();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1800clone() {
                return (Builder) super.mo1800clone();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SocialNetWorkProto getDefaultInstanceForType() {
                return SocialNetWorkProto.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SocialNetWorkProtos.internal_static_com_blued_das_client_socialnet_SocialNetWorkProto_descriptor;
            }

            @Override // com.blued.das.client.socialnet.SocialNetWorkProtos.SocialNetWorkProtoOrBuilder
            public Event getEvent() {
                Event valueOf = Event.valueOf(this.event_);
                Event event = valueOf;
                if (valueOf == null) {
                    event = Event.UNRECOGNIZED;
                }
                return event;
            }

            @Override // com.blued.das.client.socialnet.SocialNetWorkProtos.SocialNetWorkProtoOrBuilder
            public int getEventValue() {
                return this.event_;
            }

            @Override // com.blued.das.client.socialnet.SocialNetWorkProtos.SocialNetWorkProtoOrBuilder
            public String getGroupId() {
                Object obj = this.groupId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.groupId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.client.socialnet.SocialNetWorkProtos.SocialNetWorkProtoOrBuilder
            public ByteString getGroupIdBytes() {
                Object obj = this.groupId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.groupId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.client.socialnet.SocialNetWorkProtos.SocialNetWorkProtoOrBuilder
            public String getName() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.client.socialnet.SocialNetWorkProtos.SocialNetWorkProtoOrBuilder
            public ByteString getNameBytes() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.name_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.client.socialnet.SocialNetWorkProtos.SocialNetWorkProtoOrBuilder
            public SourceType getSource() {
                SourceType valueOf = SourceType.valueOf(this.source_);
                SourceType sourceType = valueOf;
                if (valueOf == null) {
                    sourceType = SourceType.UNRECOGNIZED;
                }
                return sourceType;
            }

            @Override // com.blued.das.client.socialnet.SocialNetWorkProtos.SocialNetWorkProtoOrBuilder
            public int getSourceValue() {
                return this.source_;
            }

            @Override // com.blued.das.client.socialnet.SocialNetWorkProtos.SocialNetWorkProtoOrBuilder
            public String getType() {
                Object obj = this.type_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.type_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.client.socialnet.SocialNetWorkProtos.SocialNetWorkProtoOrBuilder
            public ByteString getTypeBytes() {
                Object obj = this.type_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.type_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SocialNetWorkProtos.internal_static_com_blued_das_client_socialnet_SocialNetWorkProto_fieldAccessorTable.ensureFieldAccessorsInitialized(SocialNetWorkProto.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(SocialNetWorkProto socialNetWorkProto) {
                if (socialNetWorkProto == SocialNetWorkProto.getDefaultInstance()) {
                    return this;
                }
                if (socialNetWorkProto.event_ != 0) {
                    setEventValue(socialNetWorkProto.getEventValue());
                }
                if (!socialNetWorkProto.getGroupId().isEmpty()) {
                    this.groupId_ = socialNetWorkProto.groupId_;
                    onChanged();
                }
                if (socialNetWorkProto.source_ != 0) {
                    setSourceValue(socialNetWorkProto.getSourceValue());
                }
                if (!socialNetWorkProto.getName().isEmpty()) {
                    this.name_ = socialNetWorkProto.name_;
                    onChanged();
                }
                if (!socialNetWorkProto.getType().isEmpty()) {
                    this.type_ = socialNetWorkProto.type_;
                    onChanged();
                }
                mergeUnknownFields(socialNetWorkProto.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.das.client.socialnet.SocialNetWorkProtos.SocialNetWorkProto.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.das.client.socialnet.SocialNetWorkProtos.SocialNetWorkProto.access$1200()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.das.client.socialnet.SocialNetWorkProtos$SocialNetWorkProto r0 = (com.blued.das.client.socialnet.SocialNetWorkProtos.SocialNetWorkProto) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.das.client.socialnet.SocialNetWorkProtos$SocialNetWorkProto$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.das.client.socialnet.SocialNetWorkProtos$SocialNetWorkProto r0 = (com.blued.das.client.socialnet.SocialNetWorkProtos.SocialNetWorkProto) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.das.client.socialnet.SocialNetWorkProtos$SocialNetWorkProto$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.das.client.socialnet.SocialNetWorkProtos.SocialNetWorkProto.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.das.client.socialnet.SocialNetWorkProtos$SocialNetWorkProto$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof SocialNetWorkProto) {
                    return mergeFrom((SocialNetWorkProto) message);
                }
                super.mergeFrom(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
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

            public Builder setGroupId(String str) {
                if (str != null) {
                    this.groupId_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setGroupIdBytes(ByteString byteString) {
                if (byteString != null) {
                    SocialNetWorkProto.checkByteStringIsUtf8(byteString);
                    this.groupId_ = byteString;
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
                    SocialNetWorkProto.checkByteStringIsUtf8(byteString);
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

            public Builder setSource(SourceType sourceType) {
                if (sourceType != null) {
                    this.source_ = sourceType.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setSourceValue(int i) {
                this.source_ = i;
                onChanged();
                return this;
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
                    SocialNetWorkProto.checkByteStringIsUtf8(byteString);
                    this.type_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private SocialNetWorkProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.event_ = 0;
            this.groupId_ = "";
            this.source_ = 0;
            this.name_ = "";
            this.type_ = "";
        }

        private SocialNetWorkProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.event_ = codedInputStream.readEnum();
                            } else if (readTag == 18) {
                                this.groupId_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 24) {
                                this.source_ = codedInputStream.readEnum();
                            } else if (readTag == 34) {
                                this.name_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 42) {
                                this.type_ = codedInputStream.readStringRequireUtf8();
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

        private SocialNetWorkProto(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static SocialNetWorkProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SocialNetWorkProtos.internal_static_com_blued_das_client_socialnet_SocialNetWorkProto_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SocialNetWorkProto socialNetWorkProto) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(socialNetWorkProto);
        }

        public static SocialNetWorkProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SocialNetWorkProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static SocialNetWorkProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SocialNetWorkProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static SocialNetWorkProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static SocialNetWorkProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static SocialNetWorkProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SocialNetWorkProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static SocialNetWorkProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SocialNetWorkProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static SocialNetWorkProto parseFrom(InputStream inputStream) throws IOException {
            return (SocialNetWorkProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static SocialNetWorkProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SocialNetWorkProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static SocialNetWorkProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static SocialNetWorkProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static SocialNetWorkProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static SocialNetWorkProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<SocialNetWorkProto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof SocialNetWorkProto) {
                SocialNetWorkProto socialNetWorkProto = (SocialNetWorkProto) obj;
                return this.event_ == socialNetWorkProto.event_ && getGroupId().equals(socialNetWorkProto.getGroupId()) && this.source_ == socialNetWorkProto.source_ && getName().equals(socialNetWorkProto.getName()) && getType().equals(socialNetWorkProto.getType()) && this.unknownFields.equals(socialNetWorkProto.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SocialNetWorkProto getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.das.client.socialnet.SocialNetWorkProtos.SocialNetWorkProtoOrBuilder
        public Event getEvent() {
            Event valueOf = Event.valueOf(this.event_);
            Event event = valueOf;
            if (valueOf == null) {
                event = Event.UNRECOGNIZED;
            }
            return event;
        }

        @Override // com.blued.das.client.socialnet.SocialNetWorkProtos.SocialNetWorkProtoOrBuilder
        public int getEventValue() {
            return this.event_;
        }

        @Override // com.blued.das.client.socialnet.SocialNetWorkProtos.SocialNetWorkProtoOrBuilder
        public String getGroupId() {
            Object obj = this.groupId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.groupId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.client.socialnet.SocialNetWorkProtos.SocialNetWorkProtoOrBuilder
        public ByteString getGroupIdBytes() {
            Object obj = this.groupId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.groupId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.client.socialnet.SocialNetWorkProtos.SocialNetWorkProtoOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.client.socialnet.SocialNetWorkProtos.SocialNetWorkProtoOrBuilder
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
        public Parser<SocialNetWorkProto> getParserForType() {
            return PARSER;
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
            if (!getGroupIdBytes().isEmpty()) {
                i3 = i2 + GeneratedMessageV3.computeStringSize(2, this.groupId_);
            }
            int i4 = i3;
            if (this.source_ != SourceType.UNKNOWN_SOURCE_TYPE.getNumber()) {
                i4 = i3 + CodedOutputStream.computeEnumSize(3, this.source_);
            }
            int i5 = i4;
            if (!getNameBytes().isEmpty()) {
                i5 = i4 + GeneratedMessageV3.computeStringSize(4, this.name_);
            }
            int i6 = i5;
            if (!getTypeBytes().isEmpty()) {
                i6 = i5 + GeneratedMessageV3.computeStringSize(5, this.type_);
            }
            int serializedSize = i6 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.blued.das.client.socialnet.SocialNetWorkProtos.SocialNetWorkProtoOrBuilder
        public SourceType getSource() {
            SourceType valueOf = SourceType.valueOf(this.source_);
            SourceType sourceType = valueOf;
            if (valueOf == null) {
                sourceType = SourceType.UNRECOGNIZED;
            }
            return sourceType;
        }

        @Override // com.blued.das.client.socialnet.SocialNetWorkProtos.SocialNetWorkProtoOrBuilder
        public int getSourceValue() {
            return this.source_;
        }

        @Override // com.blued.das.client.socialnet.SocialNetWorkProtos.SocialNetWorkProtoOrBuilder
        public String getType() {
            Object obj = this.type_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.type_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.client.socialnet.SocialNetWorkProtos.SocialNetWorkProtoOrBuilder
        public ByteString getTypeBytes() {
            Object obj = this.type_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.type_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
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
            int hashCode = ((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.event_) * 37) + 2) * 53) + getGroupId().hashCode()) * 37) + 3) * 53) + this.source_) * 37) + 4) * 53) + getName().hashCode()) * 37) + 5) * 53) + getType().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SocialNetWorkProtos.internal_static_com_blued_das_client_socialnet_SocialNetWorkProto_fieldAccessorTable.ensureFieldAccessorsInitialized(SocialNetWorkProto.class, Builder.class);
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
            return new SocialNetWorkProto();
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
            if (!getGroupIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.groupId_);
            }
            if (this.source_ != SourceType.UNKNOWN_SOURCE_TYPE.getNumber()) {
                codedOutputStream.writeEnum(3, this.source_);
            }
            if (!getNameBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.name_);
            }
            if (!getTypeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.type_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/socialnet/SocialNetWorkProtos$SocialNetWorkProtoOrBuilder.class */
    public interface SocialNetWorkProtoOrBuilder extends MessageOrBuilder {
        Event getEvent();

        int getEventValue();

        String getGroupId();

        ByteString getGroupIdBytes();

        String getName();

        ByteString getNameBytes();

        SourceType getSource();

        int getSourceValue();

        String getType();

        ByteString getTypeBytes();
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/socialnet/SocialNetWorkProtos$SourceType.class */
    public enum SourceType implements ProtocolMessageEnum {
        UNKNOWN_SOURCE_TYPE(0),
        MESSAGE(1),
        CIRCLE(2),
        MYGROUP(3),
        GROUPINFO(4),
        CREATE(5),
        JOIN(6),
        NEARBY(7),
        RECOMMEND(8),
        UNRECOGNIZED(-1);
        
        public static final int CIRCLE_VALUE = 2;
        public static final int CREATE_VALUE = 5;
        public static final int GROUPINFO_VALUE = 4;
        public static final int JOIN_VALUE = 6;
        public static final int MESSAGE_VALUE = 1;
        public static final int MYGROUP_VALUE = 3;
        public static final int NEARBY_VALUE = 7;
        public static final int RECOMMEND_VALUE = 8;
        public static final int UNKNOWN_SOURCE_TYPE_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<SourceType> internalValueMap = new Internal.EnumLiteMap<SourceType>() { // from class: com.blued.das.client.socialnet.SocialNetWorkProtos.SourceType.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public SourceType findValueByNumber(int i) {
                return SourceType.forNumber(i);
            }
        };
        private static final SourceType[] VALUES = values();

        SourceType(int i) {
            this.value = i;
        }

        public static SourceType forNumber(int i) {
            switch (i) {
                case 0:
                    return UNKNOWN_SOURCE_TYPE;
                case 1:
                    return MESSAGE;
                case 2:
                    return CIRCLE;
                case 3:
                    return MYGROUP;
                case 4:
                    return GROUPINFO;
                case 5:
                    return CREATE;
                case 6:
                    return JOIN;
                case 7:
                    return NEARBY;
                case 8:
                    return RECOMMEND;
                default:
                    return null;
            }
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return SocialNetWorkProtos.getDescriptor().getEnumTypes().get(1);
        }

        public static Internal.EnumLiteMap<SourceType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static SourceType valueOf(int i) {
            return forNumber(i);
        }

        public static SourceType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_blued_das_client_socialnet_SocialNetWorkProto_descriptor = descriptor2;
        internal_static_com_blued_das_client_socialnet_SocialNetWorkProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Event", "GroupId", "Source", "Name", "Type"});
    }

    private SocialNetWorkProtos() {
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
