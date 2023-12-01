package com.blued.das.client.userguide;

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

/* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/userguide/UserGuideProtos.class */
public final class UserGuideProtos {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015UserGuideProtos.proto\u0012\u001ecom.blued.das.client.userguide\"Ä\u0001\n\u000eUserGuideProto\u00124\n\u0005event\u0018\u0001 \u0001(\u000e2%.com.blued.das.client.userguide.Event\u00129\n\bpage_num\u0018\u0002 \u0001(\u000e2'.com.blued.das.client.userguide.PageNum\u0012A\n\ffeature_type\u0018\u0003 \u0001(\u000e2+.com.blued.das.client.userguide.FeatureType*4\n\u0005Event\u0012\u0011\n\rUNKNOWN_EVENT\u0010��\u0012\u0018\n\u0014USER_GUIDE_APGE_SHOW\u0010\u0001*>\n\u0007PageNum\u0012\u0014\n\u0010UNKNOWN_PAGE_NUM\u0010��\u0012\u000e\n\nFIRST_PAGE\u0010\u0001\u0012\r\n\tLAST_PAGE\u0010\u0002*:\n\u000bFeatureType\u0012\u0018\n\u0014UNKNOWN_FEATURE_TYPE\u0010��\u0012\u0011\n\rHOME_FEATURED\u0010\u0001B\r¢\u0002\nUSER_GUIDEb\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_com_blued_das_client_userguide_UserGuideProto_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_client_userguide_UserGuideProto_fieldAccessorTable;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/userguide/UserGuideProtos$Event.class */
    public enum Event implements ProtocolMessageEnum {
        UNKNOWN_EVENT(0),
        USER_GUIDE_APGE_SHOW(1),
        UNRECOGNIZED(-1);
        
        public static final int UNKNOWN_EVENT_VALUE = 0;
        public static final int USER_GUIDE_APGE_SHOW_VALUE = 1;
        private final int value;
        private static final Internal.EnumLiteMap<Event> internalValueMap = new Internal.EnumLiteMap<Event>() { // from class: com.blued.das.client.userguide.UserGuideProtos.Event.1
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
            if (i != 0) {
                if (i != 1) {
                    return null;
                }
                return USER_GUIDE_APGE_SHOW;
            }
            return UNKNOWN_EVENT;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return UserGuideProtos.getDescriptor().getEnumTypes().get(0);
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

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/userguide/UserGuideProtos$FeatureType.class */
    public enum FeatureType implements ProtocolMessageEnum {
        UNKNOWN_FEATURE_TYPE(0),
        HOME_FEATURED(1),
        UNRECOGNIZED(-1);
        
        public static final int HOME_FEATURED_VALUE = 1;
        public static final int UNKNOWN_FEATURE_TYPE_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<FeatureType> internalValueMap = new Internal.EnumLiteMap<FeatureType>() { // from class: com.blued.das.client.userguide.UserGuideProtos.FeatureType.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public FeatureType findValueByNumber(int i) {
                return FeatureType.forNumber(i);
            }
        };
        private static final FeatureType[] VALUES = values();

        FeatureType(int i) {
            this.value = i;
        }

        public static FeatureType forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    return null;
                }
                return HOME_FEATURED;
            }
            return UNKNOWN_FEATURE_TYPE;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return UserGuideProtos.getDescriptor().getEnumTypes().get(2);
        }

        public static Internal.EnumLiteMap<FeatureType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static FeatureType valueOf(int i) {
            return forNumber(i);
        }

        public static FeatureType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/userguide/UserGuideProtos$PageNum.class */
    public enum PageNum implements ProtocolMessageEnum {
        UNKNOWN_PAGE_NUM(0),
        FIRST_PAGE(1),
        LAST_PAGE(2),
        UNRECOGNIZED(-1);
        
        public static final int FIRST_PAGE_VALUE = 1;
        public static final int LAST_PAGE_VALUE = 2;
        public static final int UNKNOWN_PAGE_NUM_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<PageNum> internalValueMap = new Internal.EnumLiteMap<PageNum>() { // from class: com.blued.das.client.userguide.UserGuideProtos.PageNum.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public PageNum findValueByNumber(int i) {
                return PageNum.forNumber(i);
            }
        };
        private static final PageNum[] VALUES = values();

        PageNum(int i) {
            this.value = i;
        }

        public static PageNum forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return null;
                    }
                    return LAST_PAGE;
                }
                return FIRST_PAGE;
            }
            return UNKNOWN_PAGE_NUM;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return UserGuideProtos.getDescriptor().getEnumTypes().get(1);
        }

        public static Internal.EnumLiteMap<PageNum> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static PageNum valueOf(int i) {
            return forNumber(i);
        }

        public static PageNum valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/userguide/UserGuideProtos$UserGuideProto.class */
    public static final class UserGuideProto extends GeneratedMessageV3 implements UserGuideProtoOrBuilder {
        public static final int EVENT_FIELD_NUMBER = 1;
        public static final int FEATURE_TYPE_FIELD_NUMBER = 3;
        public static final int PAGE_NUM_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int event_;
        private int featureType_;
        private byte memoizedIsInitialized;
        private int pageNum_;
        private static final UserGuideProto DEFAULT_INSTANCE = new UserGuideProto();
        private static final Parser<UserGuideProto> PARSER = new AbstractParser<UserGuideProto>() { // from class: com.blued.das.client.userguide.UserGuideProtos.UserGuideProto.1
            @Override // com.google.protobuf.Parser
            public UserGuideProto parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new UserGuideProto(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/userguide/UserGuideProtos$UserGuideProto$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements UserGuideProtoOrBuilder {
            private int event_;
            private int featureType_;
            private int pageNum_;

            private Builder() {
                this.event_ = 0;
                this.pageNum_ = 0;
                this.featureType_ = 0;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.event_ = 0;
                this.pageNum_ = 0;
                this.featureType_ = 0;
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return UserGuideProtos.internal_static_com_blued_das_client_userguide_UserGuideProto_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = UserGuideProto.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public UserGuideProto build() {
                UserGuideProto buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public UserGuideProto buildPartial() {
                UserGuideProto userGuideProto = new UserGuideProto(this);
                userGuideProto.event_ = this.event_;
                userGuideProto.pageNum_ = this.pageNum_;
                userGuideProto.featureType_ = this.featureType_;
                onBuilt();
                return userGuideProto;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.event_ = 0;
                this.pageNum_ = 0;
                this.featureType_ = 0;
                return this;
            }

            public Builder clearEvent() {
                this.event_ = 0;
                onChanged();
                return this;
            }

            public Builder clearFeatureType() {
                this.featureType_ = 0;
                onChanged();
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

            public Builder clearPageNum() {
                this.pageNum_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo1800clone() {
                return (Builder) super.mo1800clone();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public UserGuideProto getDefaultInstanceForType() {
                return UserGuideProto.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return UserGuideProtos.internal_static_com_blued_das_client_userguide_UserGuideProto_descriptor;
            }

            @Override // com.blued.das.client.userguide.UserGuideProtos.UserGuideProtoOrBuilder
            public Event getEvent() {
                Event valueOf = Event.valueOf(this.event_);
                Event event = valueOf;
                if (valueOf == null) {
                    event = Event.UNRECOGNIZED;
                }
                return event;
            }

            @Override // com.blued.das.client.userguide.UserGuideProtos.UserGuideProtoOrBuilder
            public int getEventValue() {
                return this.event_;
            }

            @Override // com.blued.das.client.userguide.UserGuideProtos.UserGuideProtoOrBuilder
            public FeatureType getFeatureType() {
                FeatureType valueOf = FeatureType.valueOf(this.featureType_);
                FeatureType featureType = valueOf;
                if (valueOf == null) {
                    featureType = FeatureType.UNRECOGNIZED;
                }
                return featureType;
            }

            @Override // com.blued.das.client.userguide.UserGuideProtos.UserGuideProtoOrBuilder
            public int getFeatureTypeValue() {
                return this.featureType_;
            }

            @Override // com.blued.das.client.userguide.UserGuideProtos.UserGuideProtoOrBuilder
            public PageNum getPageNum() {
                PageNum valueOf = PageNum.valueOf(this.pageNum_);
                PageNum pageNum = valueOf;
                if (valueOf == null) {
                    pageNum = PageNum.UNRECOGNIZED;
                }
                return pageNum;
            }

            @Override // com.blued.das.client.userguide.UserGuideProtos.UserGuideProtoOrBuilder
            public int getPageNumValue() {
                return this.pageNum_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return UserGuideProtos.internal_static_com_blued_das_client_userguide_UserGuideProto_fieldAccessorTable.ensureFieldAccessorsInitialized(UserGuideProto.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(UserGuideProto userGuideProto) {
                if (userGuideProto == UserGuideProto.getDefaultInstance()) {
                    return this;
                }
                if (userGuideProto.event_ != 0) {
                    setEventValue(userGuideProto.getEventValue());
                }
                if (userGuideProto.pageNum_ != 0) {
                    setPageNumValue(userGuideProto.getPageNumValue());
                }
                if (userGuideProto.featureType_ != 0) {
                    setFeatureTypeValue(userGuideProto.getFeatureTypeValue());
                }
                mergeUnknownFields(userGuideProto.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.das.client.userguide.UserGuideProtos.UserGuideProto.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.das.client.userguide.UserGuideProtos.UserGuideProto.access$1000()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.das.client.userguide.UserGuideProtos$UserGuideProto r0 = (com.blued.das.client.userguide.UserGuideProtos.UserGuideProto) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.das.client.userguide.UserGuideProtos$UserGuideProto$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.das.client.userguide.UserGuideProtos$UserGuideProto r0 = (com.blued.das.client.userguide.UserGuideProtos.UserGuideProto) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.das.client.userguide.UserGuideProtos$UserGuideProto$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.das.client.userguide.UserGuideProtos.UserGuideProto.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.das.client.userguide.UserGuideProtos$UserGuideProto$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof UserGuideProto) {
                    return mergeFrom((UserGuideProto) message);
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

            public Builder setFeatureType(FeatureType featureType) {
                if (featureType != null) {
                    this.featureType_ = featureType.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setFeatureTypeValue(int i) {
                this.featureType_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setPageNum(PageNum pageNum) {
                if (pageNum != null) {
                    this.pageNum_ = pageNum.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setPageNumValue(int i) {
                this.pageNum_ = i;
                onChanged();
                return this;
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

        private UserGuideProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.event_ = 0;
            this.pageNum_ = 0;
            this.featureType_ = 0;
        }

        private UserGuideProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                } else if (readTag == 16) {
                                    this.pageNum_ = codedInputStream.readEnum();
                                } else if (readTag == 24) {
                                    this.featureType_ = codedInputStream.readEnum();
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

        private UserGuideProto(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static UserGuideProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return UserGuideProtos.internal_static_com_blued_das_client_userguide_UserGuideProto_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(UserGuideProto userGuideProto) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(userGuideProto);
        }

        public static UserGuideProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (UserGuideProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static UserGuideProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UserGuideProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static UserGuideProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static UserGuideProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static UserGuideProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (UserGuideProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static UserGuideProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UserGuideProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static UserGuideProto parseFrom(InputStream inputStream) throws IOException {
            return (UserGuideProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static UserGuideProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UserGuideProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static UserGuideProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static UserGuideProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static UserGuideProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static UserGuideProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<UserGuideProto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof UserGuideProto) {
                UserGuideProto userGuideProto = (UserGuideProto) obj;
                return this.event_ == userGuideProto.event_ && this.pageNum_ == userGuideProto.pageNum_ && this.featureType_ == userGuideProto.featureType_ && this.unknownFields.equals(userGuideProto.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public UserGuideProto getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.das.client.userguide.UserGuideProtos.UserGuideProtoOrBuilder
        public Event getEvent() {
            Event valueOf = Event.valueOf(this.event_);
            Event event = valueOf;
            if (valueOf == null) {
                event = Event.UNRECOGNIZED;
            }
            return event;
        }

        @Override // com.blued.das.client.userguide.UserGuideProtos.UserGuideProtoOrBuilder
        public int getEventValue() {
            return this.event_;
        }

        @Override // com.blued.das.client.userguide.UserGuideProtos.UserGuideProtoOrBuilder
        public FeatureType getFeatureType() {
            FeatureType valueOf = FeatureType.valueOf(this.featureType_);
            FeatureType featureType = valueOf;
            if (valueOf == null) {
                featureType = FeatureType.UNRECOGNIZED;
            }
            return featureType;
        }

        @Override // com.blued.das.client.userguide.UserGuideProtos.UserGuideProtoOrBuilder
        public int getFeatureTypeValue() {
            return this.featureType_;
        }

        @Override // com.blued.das.client.userguide.UserGuideProtos.UserGuideProtoOrBuilder
        public PageNum getPageNum() {
            PageNum valueOf = PageNum.valueOf(this.pageNum_);
            PageNum pageNum = valueOf;
            if (valueOf == null) {
                pageNum = PageNum.UNRECOGNIZED;
            }
            return pageNum;
        }

        @Override // com.blued.das.client.userguide.UserGuideProtos.UserGuideProtoOrBuilder
        public int getPageNumValue() {
            return this.pageNum_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<UserGuideProto> getParserForType() {
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
            if (this.pageNum_ != PageNum.UNKNOWN_PAGE_NUM.getNumber()) {
                i3 = i2 + CodedOutputStream.computeEnumSize(2, this.pageNum_);
            }
            int i4 = i3;
            if (this.featureType_ != FeatureType.UNKNOWN_FEATURE_TYPE.getNumber()) {
                i4 = i3 + CodedOutputStream.computeEnumSize(3, this.featureType_);
            }
            int serializedSize = i4 + this.unknownFields.getSerializedSize();
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
            int hashCode = ((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.event_) * 37) + 2) * 53) + this.pageNum_) * 37) + 3) * 53) + this.featureType_) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return UserGuideProtos.internal_static_com_blued_das_client_userguide_UserGuideProto_fieldAccessorTable.ensureFieldAccessorsInitialized(UserGuideProto.class, Builder.class);
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
            return new UserGuideProto();
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
            if (this.pageNum_ != PageNum.UNKNOWN_PAGE_NUM.getNumber()) {
                codedOutputStream.writeEnum(2, this.pageNum_);
            }
            if (this.featureType_ != FeatureType.UNKNOWN_FEATURE_TYPE.getNumber()) {
                codedOutputStream.writeEnum(3, this.featureType_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/userguide/UserGuideProtos$UserGuideProtoOrBuilder.class */
    public interface UserGuideProtoOrBuilder extends MessageOrBuilder {
        Event getEvent();

        int getEventValue();

        FeatureType getFeatureType();

        int getFeatureTypeValue();

        PageNum getPageNum();

        int getPageNumValue();
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_blued_das_client_userguide_UserGuideProto_descriptor = descriptor2;
        internal_static_com_blued_das_client_userguide_UserGuideProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Event", "PageNum", "FeatureType"});
    }

    private UserGuideProtos() {
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
