package com.blued.das.client.vote;

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

/* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/vote/VoteProtos.class */
public final class VoteProtos {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0010VoteProtos.proto\u0012\u0019com.blued.das.client.vote\"\u008f\u0002\n\tVoteProto\u0012/\n\u0005event\u0018\u0001 \u0001(\u000e2 .com.blued.das.client.vote.Event\u00126\n\tfeed_type\u0018\u0002 \u0001(\u000e2#.com.blued.das.client.vote.FeedType\u0012<\n\fphoto_option\u0018\u0003 \u0001(\u000e2&.com.blued.das.client.vote.PhotoOption\u0012\u0012\n\ntarget_uid\u0018\u0004 \u0001(\t\u0012\u000f\n\u0007feed_id\u0018\u0005 \u0001(\t\u00126\n\tfeed_page\u0018\u0006 \u0001(\u000e2#.com.blued.das.client.vote.FeedPage*þ\u0002\n\u0005Event\u0012\u0011\n\rUNKNOWN_EVENT\u0010��\u0012\u0012\n\u000eVOTE_BTN_CLICK\u0010\u0001\u0012\u0017\n\u0013VOTE_EDIT_PAGE_SHOW\u0010\u0002\u0012\u001f\n\u001bVOTE_EDIT_PAGE_UPLOAD_CLICK\u0010\u0003\u0012%\n!VOTE_PHOTO_PAGE_CONFIRM_BTN_CLICK\u0010\u0004\u0012 \n\u001cVOTE_EDIT_PAGE_BIG_BTN_CLICK\u0010\u0005\u0012\"\n\u001eVOTE_EDIT_PAGE_SMALL_BTN_CLICK\u0010\u0006\u0012!\n\u001dVOTE_EDIT_PAGE_TURN_BTN_CLICK\u0010\u0007\u0012#\n\u001fVOTE_EDIT_PAGE_CHANGE_BTN_CLICK\u0010\b\u0012\u001a\n\u0016VOTE_PUBLISH_BTN_CLICK\u0010\t\u0012 \n\u001cVOTE_FEED_CHOOSE_PHOTO_CLICK\u0010\n\u0012!\n\u001dVOTE_FEED_ENLARGE_PHOTO_CLICK\u0010\u000b*7\n\bFeedType\u0012\u0015\n\u0011UNKNOWN_FEED_TYPE\u0010��\u0012\n\n\u0006COMMON\u0010\u0001\u0012\b\n\u0004VOTE\u0010\u0002*A\n\u000bPhotoOption\u0012\u0018\n\u0014UNKNOWN_PHOTO_OPTION\u0010��\u0012\u000b\n\u0007PHOTO_A\u0010\u0001\u0012\u000b\n\u0007PHOTO_B\u0010\u0002*\u0080\u0001\n\bFeedPage\u0012\u0015\n\u0011UNKNOWN_FEED_PAGE\u0010��\u0012\u0013\n\u000fPLAZA_RECOMMEND\u0010\u0001\u0012\u0010\n\fPLAZA_NEARBY\u0010\u0002\u0012\r\n\tCITY_TIME\u0010\u0003\u0012\u0011\n\rPERSONAL_FEED\u0010\u0004\u0012\u0014\n\u0010FEED_DETAIL_MORE\u0010\u0005B\u0007¢\u0002\u0004VOTEb\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_com_blued_das_client_vote_VoteProto_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_das_client_vote_VoteProto_fieldAccessorTable;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/vote/VoteProtos$Event.class */
    public enum Event implements ProtocolMessageEnum {
        UNKNOWN_EVENT(0),
        VOTE_BTN_CLICK(1),
        VOTE_EDIT_PAGE_SHOW(2),
        VOTE_EDIT_PAGE_UPLOAD_CLICK(3),
        VOTE_PHOTO_PAGE_CONFIRM_BTN_CLICK(4),
        VOTE_EDIT_PAGE_BIG_BTN_CLICK(5),
        VOTE_EDIT_PAGE_SMALL_BTN_CLICK(6),
        VOTE_EDIT_PAGE_TURN_BTN_CLICK(7),
        VOTE_EDIT_PAGE_CHANGE_BTN_CLICK(8),
        VOTE_PUBLISH_BTN_CLICK(9),
        VOTE_FEED_CHOOSE_PHOTO_CLICK(10),
        VOTE_FEED_ENLARGE_PHOTO_CLICK(11),
        UNRECOGNIZED(-1);
        
        public static final int UNKNOWN_EVENT_VALUE = 0;
        public static final int VOTE_BTN_CLICK_VALUE = 1;
        public static final int VOTE_EDIT_PAGE_BIG_BTN_CLICK_VALUE = 5;
        public static final int VOTE_EDIT_PAGE_CHANGE_BTN_CLICK_VALUE = 8;
        public static final int VOTE_EDIT_PAGE_SHOW_VALUE = 2;
        public static final int VOTE_EDIT_PAGE_SMALL_BTN_CLICK_VALUE = 6;
        public static final int VOTE_EDIT_PAGE_TURN_BTN_CLICK_VALUE = 7;
        public static final int VOTE_EDIT_PAGE_UPLOAD_CLICK_VALUE = 3;
        public static final int VOTE_FEED_CHOOSE_PHOTO_CLICK_VALUE = 10;
        public static final int VOTE_FEED_ENLARGE_PHOTO_CLICK_VALUE = 11;
        public static final int VOTE_PHOTO_PAGE_CONFIRM_BTN_CLICK_VALUE = 4;
        public static final int VOTE_PUBLISH_BTN_CLICK_VALUE = 9;
        private final int value;
        private static final Internal.EnumLiteMap<Event> internalValueMap = new Internal.EnumLiteMap<Event>() { // from class: com.blued.das.client.vote.VoteProtos.Event.1
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
                    return VOTE_BTN_CLICK;
                case 2:
                    return VOTE_EDIT_PAGE_SHOW;
                case 3:
                    return VOTE_EDIT_PAGE_UPLOAD_CLICK;
                case 4:
                    return VOTE_PHOTO_PAGE_CONFIRM_BTN_CLICK;
                case 5:
                    return VOTE_EDIT_PAGE_BIG_BTN_CLICK;
                case 6:
                    return VOTE_EDIT_PAGE_SMALL_BTN_CLICK;
                case 7:
                    return VOTE_EDIT_PAGE_TURN_BTN_CLICK;
                case 8:
                    return VOTE_EDIT_PAGE_CHANGE_BTN_CLICK;
                case 9:
                    return VOTE_PUBLISH_BTN_CLICK;
                case 10:
                    return VOTE_FEED_CHOOSE_PHOTO_CLICK;
                case 11:
                    return VOTE_FEED_ENLARGE_PHOTO_CLICK;
                default:
                    return null;
            }
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return VoteProtos.getDescriptor().getEnumTypes().get(0);
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

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/vote/VoteProtos$FeedPage.class */
    public enum FeedPage implements ProtocolMessageEnum {
        UNKNOWN_FEED_PAGE(0),
        PLAZA_RECOMMEND(1),
        PLAZA_NEARBY(2),
        CITY_TIME(3),
        PERSONAL_FEED(4),
        FEED_DETAIL_MORE(5),
        UNRECOGNIZED(-1);
        
        public static final int CITY_TIME_VALUE = 3;
        public static final int FEED_DETAIL_MORE_VALUE = 5;
        public static final int PERSONAL_FEED_VALUE = 4;
        public static final int PLAZA_NEARBY_VALUE = 2;
        public static final int PLAZA_RECOMMEND_VALUE = 1;
        public static final int UNKNOWN_FEED_PAGE_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<FeedPage> internalValueMap = new Internal.EnumLiteMap<FeedPage>() { // from class: com.blued.das.client.vote.VoteProtos.FeedPage.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public FeedPage findValueByNumber(int i) {
                return FeedPage.forNumber(i);
            }
        };
        private static final FeedPage[] VALUES = values();

        FeedPage(int i) {
            this.value = i;
        }

        public static FeedPage forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                if (i != 5) {
                                    return null;
                                }
                                return FEED_DETAIL_MORE;
                            }
                            return PERSONAL_FEED;
                        }
                        return CITY_TIME;
                    }
                    return PLAZA_NEARBY;
                }
                return PLAZA_RECOMMEND;
            }
            return UNKNOWN_FEED_PAGE;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return VoteProtos.getDescriptor().getEnumTypes().get(3);
        }

        public static Internal.EnumLiteMap<FeedPage> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static FeedPage valueOf(int i) {
            return forNumber(i);
        }

        public static FeedPage valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/vote/VoteProtos$FeedType.class */
    public enum FeedType implements ProtocolMessageEnum {
        UNKNOWN_FEED_TYPE(0),
        COMMON(1),
        VOTE(2),
        UNRECOGNIZED(-1);
        
        public static final int COMMON_VALUE = 1;
        public static final int UNKNOWN_FEED_TYPE_VALUE = 0;
        public static final int VOTE_VALUE = 2;
        private final int value;
        private static final Internal.EnumLiteMap<FeedType> internalValueMap = new Internal.EnumLiteMap<FeedType>() { // from class: com.blued.das.client.vote.VoteProtos.FeedType.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public FeedType findValueByNumber(int i) {
                return FeedType.forNumber(i);
            }
        };
        private static final FeedType[] VALUES = values();

        FeedType(int i) {
            this.value = i;
        }

        public static FeedType forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return null;
                    }
                    return VOTE;
                }
                return COMMON;
            }
            return UNKNOWN_FEED_TYPE;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return VoteProtos.getDescriptor().getEnumTypes().get(1);
        }

        public static Internal.EnumLiteMap<FeedType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static FeedType valueOf(int i) {
            return forNumber(i);
        }

        public static FeedType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/vote/VoteProtos$PhotoOption.class */
    public enum PhotoOption implements ProtocolMessageEnum {
        UNKNOWN_PHOTO_OPTION(0),
        PHOTO_A(1),
        PHOTO_B(2),
        UNRECOGNIZED(-1);
        
        public static final int PHOTO_A_VALUE = 1;
        public static final int PHOTO_B_VALUE = 2;
        public static final int UNKNOWN_PHOTO_OPTION_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<PhotoOption> internalValueMap = new Internal.EnumLiteMap<PhotoOption>() { // from class: com.blued.das.client.vote.VoteProtos.PhotoOption.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public PhotoOption findValueByNumber(int i) {
                return PhotoOption.forNumber(i);
            }
        };
        private static final PhotoOption[] VALUES = values();

        PhotoOption(int i) {
            this.value = i;
        }

        public static PhotoOption forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return null;
                    }
                    return PHOTO_B;
                }
                return PHOTO_A;
            }
            return UNKNOWN_PHOTO_OPTION;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return VoteProtos.getDescriptor().getEnumTypes().get(2);
        }

        public static Internal.EnumLiteMap<PhotoOption> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static PhotoOption valueOf(int i) {
            return forNumber(i);
        }

        public static PhotoOption valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
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

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/vote/VoteProtos$VoteProto.class */
    public static final class VoteProto extends GeneratedMessageV3 implements VoteProtoOrBuilder {
        public static final int EVENT_FIELD_NUMBER = 1;
        public static final int FEED_ID_FIELD_NUMBER = 5;
        public static final int FEED_PAGE_FIELD_NUMBER = 6;
        public static final int FEED_TYPE_FIELD_NUMBER = 2;
        public static final int PHOTO_OPTION_FIELD_NUMBER = 3;
        public static final int TARGET_UID_FIELD_NUMBER = 4;
        private static final long serialVersionUID = 0;
        private int event_;
        private volatile Object feedId_;
        private int feedPage_;
        private int feedType_;
        private byte memoizedIsInitialized;
        private int photoOption_;
        private volatile Object targetUid_;
        private static final VoteProto DEFAULT_INSTANCE = new VoteProto();
        private static final Parser<VoteProto> PARSER = new AbstractParser<VoteProto>() { // from class: com.blued.das.client.vote.VoteProtos.VoteProto.1
            @Override // com.google.protobuf.Parser
            public VoteProto parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new VoteProto(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/vote/VoteProtos$VoteProto$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements VoteProtoOrBuilder {
            private int event_;
            private Object feedId_;
            private int feedPage_;
            private int feedType_;
            private int photoOption_;
            private Object targetUid_;

            private Builder() {
                this.event_ = 0;
                this.feedType_ = 0;
                this.photoOption_ = 0;
                this.targetUid_ = "";
                this.feedId_ = "";
                this.feedPage_ = 0;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.event_ = 0;
                this.feedType_ = 0;
                this.photoOption_ = 0;
                this.targetUid_ = "";
                this.feedId_ = "";
                this.feedPage_ = 0;
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return VoteProtos.internal_static_com_blued_das_client_vote_VoteProto_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = VoteProto.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public VoteProto build() {
                VoteProto buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public VoteProto buildPartial() {
                VoteProto voteProto = new VoteProto(this);
                voteProto.event_ = this.event_;
                voteProto.feedType_ = this.feedType_;
                voteProto.photoOption_ = this.photoOption_;
                voteProto.targetUid_ = this.targetUid_;
                voteProto.feedId_ = this.feedId_;
                voteProto.feedPage_ = this.feedPage_;
                onBuilt();
                return voteProto;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.event_ = 0;
                this.feedType_ = 0;
                this.photoOption_ = 0;
                this.targetUid_ = "";
                this.feedId_ = "";
                this.feedPage_ = 0;
                return this;
            }

            public Builder clearEvent() {
                this.event_ = 0;
                onChanged();
                return this;
            }

            public Builder clearFeedId() {
                this.feedId_ = VoteProto.getDefaultInstance().getFeedId();
                onChanged();
                return this;
            }

            public Builder clearFeedPage() {
                this.feedPage_ = 0;
                onChanged();
                return this;
            }

            public Builder clearFeedType() {
                this.feedType_ = 0;
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

            public Builder clearPhotoOption() {
                this.photoOption_ = 0;
                onChanged();
                return this;
            }

            public Builder clearTargetUid() {
                this.targetUid_ = VoteProto.getDefaultInstance().getTargetUid();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo2030clone() {
                return (Builder) super.mo2030clone();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public VoteProto getDefaultInstanceForType() {
                return VoteProto.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return VoteProtos.internal_static_com_blued_das_client_vote_VoteProto_descriptor;
            }

            @Override // com.blued.das.client.vote.VoteProtos.VoteProtoOrBuilder
            public Event getEvent() {
                Event valueOf = Event.valueOf(this.event_);
                Event event = valueOf;
                if (valueOf == null) {
                    event = Event.UNRECOGNIZED;
                }
                return event;
            }

            @Override // com.blued.das.client.vote.VoteProtos.VoteProtoOrBuilder
            public int getEventValue() {
                return this.event_;
            }

            @Override // com.blued.das.client.vote.VoteProtos.VoteProtoOrBuilder
            public String getFeedId() {
                Object obj = this.feedId_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.feedId_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.client.vote.VoteProtos.VoteProtoOrBuilder
            public ByteString getFeedIdBytes() {
                Object obj = this.feedId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.feedId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.blued.das.client.vote.VoteProtos.VoteProtoOrBuilder
            public FeedPage getFeedPage() {
                FeedPage valueOf = FeedPage.valueOf(this.feedPage_);
                FeedPage feedPage = valueOf;
                if (valueOf == null) {
                    feedPage = FeedPage.UNRECOGNIZED;
                }
                return feedPage;
            }

            @Override // com.blued.das.client.vote.VoteProtos.VoteProtoOrBuilder
            public int getFeedPageValue() {
                return this.feedPage_;
            }

            @Override // com.blued.das.client.vote.VoteProtos.VoteProtoOrBuilder
            public FeedType getFeedType() {
                FeedType valueOf = FeedType.valueOf(this.feedType_);
                FeedType feedType = valueOf;
                if (valueOf == null) {
                    feedType = FeedType.UNRECOGNIZED;
                }
                return feedType;
            }

            @Override // com.blued.das.client.vote.VoteProtos.VoteProtoOrBuilder
            public int getFeedTypeValue() {
                return this.feedType_;
            }

            @Override // com.blued.das.client.vote.VoteProtos.VoteProtoOrBuilder
            public PhotoOption getPhotoOption() {
                PhotoOption valueOf = PhotoOption.valueOf(this.photoOption_);
                PhotoOption photoOption = valueOf;
                if (valueOf == null) {
                    photoOption = PhotoOption.UNRECOGNIZED;
                }
                return photoOption;
            }

            @Override // com.blued.das.client.vote.VoteProtos.VoteProtoOrBuilder
            public int getPhotoOptionValue() {
                return this.photoOption_;
            }

            @Override // com.blued.das.client.vote.VoteProtos.VoteProtoOrBuilder
            public String getTargetUid() {
                Object obj = this.targetUid_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.targetUid_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.das.client.vote.VoteProtos.VoteProtoOrBuilder
            public ByteString getTargetUidBytes() {
                Object obj = this.targetUid_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.targetUid_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return VoteProtos.internal_static_com_blued_das_client_vote_VoteProto_fieldAccessorTable.ensureFieldAccessorsInitialized(VoteProto.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(VoteProto voteProto) {
                if (voteProto == VoteProto.getDefaultInstance()) {
                    return this;
                }
                if (voteProto.event_ != 0) {
                    setEventValue(voteProto.getEventValue());
                }
                if (voteProto.feedType_ != 0) {
                    setFeedTypeValue(voteProto.getFeedTypeValue());
                }
                if (voteProto.photoOption_ != 0) {
                    setPhotoOptionValue(voteProto.getPhotoOptionValue());
                }
                if (!voteProto.getTargetUid().isEmpty()) {
                    this.targetUid_ = voteProto.targetUid_;
                    onChanged();
                }
                if (!voteProto.getFeedId().isEmpty()) {
                    this.feedId_ = voteProto.feedId_;
                    onChanged();
                }
                if (voteProto.feedPage_ != 0) {
                    setFeedPageValue(voteProto.getFeedPageValue());
                }
                mergeUnknownFields(voteProto.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.das.client.vote.VoteProtos.VoteProto.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.das.client.vote.VoteProtos.VoteProto.access$1300()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.das.client.vote.VoteProtos$VoteProto r0 = (com.blued.das.client.vote.VoteProtos.VoteProto) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.das.client.vote.VoteProtos$VoteProto$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.das.client.vote.VoteProtos$VoteProto r0 = (com.blued.das.client.vote.VoteProtos.VoteProto) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.das.client.vote.VoteProtos$VoteProto$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.das.client.vote.VoteProtos.VoteProto.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.das.client.vote.VoteProtos$VoteProto$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof VoteProto) {
                    return mergeFrom((VoteProto) message);
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

            public Builder setFeedId(String str) {
                if (str != null) {
                    this.feedId_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setFeedIdBytes(ByteString byteString) {
                if (byteString != null) {
                    VoteProto.checkByteStringIsUtf8(byteString);
                    this.feedId_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setFeedPage(FeedPage feedPage) {
                if (feedPage != null) {
                    this.feedPage_ = feedPage.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setFeedPageValue(int i) {
                this.feedPage_ = i;
                onChanged();
                return this;
            }

            public Builder setFeedType(FeedType feedType) {
                if (feedType != null) {
                    this.feedType_ = feedType.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setFeedTypeValue(int i) {
                this.feedType_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setPhotoOption(PhotoOption photoOption) {
                if (photoOption != null) {
                    this.photoOption_ = photoOption.getNumber();
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setPhotoOptionValue(int i) {
                this.photoOption_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setTargetUid(String str) {
                if (str != null) {
                    this.targetUid_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setTargetUidBytes(ByteString byteString) {
                if (byteString != null) {
                    VoteProto.checkByteStringIsUtf8(byteString);
                    this.targetUid_ = byteString;
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

        private VoteProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.event_ = 0;
            this.feedType_ = 0;
            this.photoOption_ = 0;
            this.targetUid_ = "";
            this.feedId_ = "";
            this.feedPage_ = 0;
        }

        private VoteProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            } else if (readTag == 16) {
                                this.feedType_ = codedInputStream.readEnum();
                            } else if (readTag == 24) {
                                this.photoOption_ = codedInputStream.readEnum();
                            } else if (readTag == 34) {
                                this.targetUid_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 42) {
                                this.feedId_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 48) {
                                this.feedPage_ = codedInputStream.readEnum();
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

        private VoteProto(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static VoteProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return VoteProtos.internal_static_com_blued_das_client_vote_VoteProto_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(VoteProto voteProto) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(voteProto);
        }

        public static VoteProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (VoteProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static VoteProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (VoteProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static VoteProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static VoteProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static VoteProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (VoteProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static VoteProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (VoteProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static VoteProto parseFrom(InputStream inputStream) throws IOException {
            return (VoteProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static VoteProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (VoteProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static VoteProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static VoteProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static VoteProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static VoteProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<VoteProto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof VoteProto) {
                VoteProto voteProto = (VoteProto) obj;
                return this.event_ == voteProto.event_ && this.feedType_ == voteProto.feedType_ && this.photoOption_ == voteProto.photoOption_ && getTargetUid().equals(voteProto.getTargetUid()) && getFeedId().equals(voteProto.getFeedId()) && this.feedPage_ == voteProto.feedPage_ && this.unknownFields.equals(voteProto.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public VoteProto getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.das.client.vote.VoteProtos.VoteProtoOrBuilder
        public Event getEvent() {
            Event valueOf = Event.valueOf(this.event_);
            Event event = valueOf;
            if (valueOf == null) {
                event = Event.UNRECOGNIZED;
            }
            return event;
        }

        @Override // com.blued.das.client.vote.VoteProtos.VoteProtoOrBuilder
        public int getEventValue() {
            return this.event_;
        }

        @Override // com.blued.das.client.vote.VoteProtos.VoteProtoOrBuilder
        public String getFeedId() {
            Object obj = this.feedId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.feedId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.client.vote.VoteProtos.VoteProtoOrBuilder
        public ByteString getFeedIdBytes() {
            Object obj = this.feedId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.feedId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.blued.das.client.vote.VoteProtos.VoteProtoOrBuilder
        public FeedPage getFeedPage() {
            FeedPage valueOf = FeedPage.valueOf(this.feedPage_);
            FeedPage feedPage = valueOf;
            if (valueOf == null) {
                feedPage = FeedPage.UNRECOGNIZED;
            }
            return feedPage;
        }

        @Override // com.blued.das.client.vote.VoteProtos.VoteProtoOrBuilder
        public int getFeedPageValue() {
            return this.feedPage_;
        }

        @Override // com.blued.das.client.vote.VoteProtos.VoteProtoOrBuilder
        public FeedType getFeedType() {
            FeedType valueOf = FeedType.valueOf(this.feedType_);
            FeedType feedType = valueOf;
            if (valueOf == null) {
                feedType = FeedType.UNRECOGNIZED;
            }
            return feedType;
        }

        @Override // com.blued.das.client.vote.VoteProtos.VoteProtoOrBuilder
        public int getFeedTypeValue() {
            return this.feedType_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<VoteProto> getParserForType() {
            return PARSER;
        }

        @Override // com.blued.das.client.vote.VoteProtos.VoteProtoOrBuilder
        public PhotoOption getPhotoOption() {
            PhotoOption valueOf = PhotoOption.valueOf(this.photoOption_);
            PhotoOption photoOption = valueOf;
            if (valueOf == null) {
                photoOption = PhotoOption.UNRECOGNIZED;
            }
            return photoOption;
        }

        @Override // com.blued.das.client.vote.VoteProtos.VoteProtoOrBuilder
        public int getPhotoOptionValue() {
            return this.photoOption_;
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
            if (this.feedType_ != FeedType.UNKNOWN_FEED_TYPE.getNumber()) {
                i3 = i2 + CodedOutputStream.computeEnumSize(2, this.feedType_);
            }
            int i4 = i3;
            if (this.photoOption_ != PhotoOption.UNKNOWN_PHOTO_OPTION.getNumber()) {
                i4 = i3 + CodedOutputStream.computeEnumSize(3, this.photoOption_);
            }
            int i5 = i4;
            if (!getTargetUidBytes().isEmpty()) {
                i5 = i4 + GeneratedMessageV3.computeStringSize(4, this.targetUid_);
            }
            int i6 = i5;
            if (!getFeedIdBytes().isEmpty()) {
                i6 = i5 + GeneratedMessageV3.computeStringSize(5, this.feedId_);
            }
            int i7 = i6;
            if (this.feedPage_ != FeedPage.UNKNOWN_FEED_PAGE.getNumber()) {
                i7 = i6 + CodedOutputStream.computeEnumSize(6, this.feedPage_);
            }
            int serializedSize = i7 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.blued.das.client.vote.VoteProtos.VoteProtoOrBuilder
        public String getTargetUid() {
            Object obj = this.targetUid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.targetUid_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.das.client.vote.VoteProtos.VoteProtoOrBuilder
        public ByteString getTargetUidBytes() {
            Object obj = this.targetUid_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.targetUid_ = copyFromUtf8;
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
            int hashCode = ((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.event_) * 37) + 2) * 53) + this.feedType_) * 37) + 3) * 53) + this.photoOption_) * 37) + 4) * 53) + getTargetUid().hashCode()) * 37) + 5) * 53) + getFeedId().hashCode()) * 37) + 6) * 53) + this.feedPage_) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return VoteProtos.internal_static_com_blued_das_client_vote_VoteProto_fieldAccessorTable.ensureFieldAccessorsInitialized(VoteProto.class, Builder.class);
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
            return new VoteProto();
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
            if (this.feedType_ != FeedType.UNKNOWN_FEED_TYPE.getNumber()) {
                codedOutputStream.writeEnum(2, this.feedType_);
            }
            if (this.photoOption_ != PhotoOption.UNKNOWN_PHOTO_OPTION.getNumber()) {
                codedOutputStream.writeEnum(3, this.photoOption_);
            }
            if (!getTargetUidBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.targetUid_);
            }
            if (!getFeedIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.feedId_);
            }
            if (this.feedPage_ != FeedPage.UNKNOWN_FEED_PAGE.getNumber()) {
                codedOutputStream.writeEnum(6, this.feedPage_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/das/client/vote/VoteProtos$VoteProtoOrBuilder.class */
    public interface VoteProtoOrBuilder extends MessageOrBuilder {
        Event getEvent();

        int getEventValue();

        String getFeedId();

        ByteString getFeedIdBytes();

        FeedPage getFeedPage();

        int getFeedPageValue();

        FeedType getFeedType();

        int getFeedTypeValue();

        PhotoOption getPhotoOption();

        int getPhotoOptionValue();

        String getTargetUid();

        ByteString getTargetUidBytes();
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_blued_das_client_vote_VoteProto_descriptor = descriptor2;
        internal_static_com_blued_das_client_vote_VoteProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Event", "FeedType", "PhotoOption", "TargetUid", "FeedId", "FeedPage"});
    }

    private VoteProtos() {
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
