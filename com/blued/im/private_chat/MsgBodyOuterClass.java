package com.blued.im.private_chat;

import com.blued.im.private_chat.MsgBodyExtraOuterClass;
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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/MsgBodyOuterClass.class */
public final class MsgBodyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\rMsgBody.proto\u0012\u0019com.blued.im.private_chat\u001a\u0012MsgBodyExtra.proto\"ë\u0001\n\u0007MsgBody\u0012\u0010\n\bcontents\u0018\u0001 \u0001(\t\u00123\n\u0007profile\u0018\u0002 \u0001(\u000b2\".com.blued.im.private_chat.Profile\u00122\n\u0005extra\u0018\u0003 \u0001(\u000b2#.com.blued.im.private_chat.MsgExtra\u0012\u0012\n\nextra_json\u0018\u0004 \u0001(\f\u00127\n\tmsgSource\u0018\u0005 \u0001(\u000b2$.com.blued.im.private_chat.MsgSource\u0012\u0018\n\u0010msg_receive_from\u0018\u0006 \u0001(\u0003\"ð\f\n\bMsgExtra\u00128\n\ntext_extra\u0018\u0001 \u0001(\u000b2$.com.blued.im.private_chat.TextExtra\u00126\n\timg_extra\u0018\u0002 \u0001(\u000b2#.com.blued.im.private_chat.ImgExtra\u0012@\n\u000elocation_extra\u0018\u0003 \u0001(\u000b2(.com.blued.im.private_chat.LocationExtra\u0012:\n\u000bvideo_extra\u0018\u0004 \u0001(\u000b2%.com.blued.im.private_chat.VideoExtra\u0012C\n\u0010group_card_extra\u0018\u0005 \u0001(\u000b2).com.blued.im.private_chat.GroupCardExtra\u0012C\n\u0010live_share_extra\u0018\u0006 \u0001(\u000b2).com.blued.im.private_chat.LiveShareExtra\u0012B\n\u000fimagetext_extra\u0018\u0007 \u0001(\u000b2).com.blued.im.private_chat.ImageTextExtra\u0012E\n\u0011hiden_album_extra\u0018\b \u0001(\u000b2*.com.blued.im.private_chat.HidenAlbumExtra\u0012:\n\u000bshare_extra\u0018\n \u0001(\u000b2%.com.blued.im.private_chat.ShareExtra\u00126\n\tvip_extra\u0018\u000b \u0001(\u000b2#.com.blued.im.private_chat.VipExtra\u00128\n\ngift_extra\u0018\f \u0001(\u000b2$.com.blued.im.private_chat.GiftExtra\u0012C\n\u0010sys_notice_extra\u0018\r \u0001(\u000b2).com.blued.im.private_chat.SysNoticeExtra\u0012M\n\u0013video_calling_extra\u0018\u000e \u0001(\u000b20.com.blued.im.private_chat.VideoChatCallingExtra\u0012E\n\u000fvideo_end_extra\u0018\u000f \u0001(\u000b2,.com.blued.im.private_chat.VideoChatEndExtra\u0012C\n\u0010feed_share_extra\u0018\u0010 \u0001(\u000b2).com.blued.im.private_chat.FeedShareExtra\u0012;\n\fsay_hi_extra\u0018\u0011 \u0001(\u000b2%.com.blued.im.private_chat.SayHiExtra\u0012N\n\u0016voice_room_share_extra\u0018\u0012 \u0001(\u000b2..com.blued.im.private_chat.VoiceRoomShareExtra\u0012^\n\u001elive_share_international_extra\u0018\u0013 \u0001(\u000b26.com.blued.im.private_chat.LiveShareInternationalExtra\u0012G\n\u0012doodle_share_extra\u0018\u0014 \u0001(\u000b2+.com.blued.im.private_chat.DoodleShareExtra\u0012<\n\fgroup_notice\u0018\u0015 \u0001(\u000b2&.com.blued.im.private_chat.GroupNotice\u0012D\n\u0010evaluation_extra\u0018\u0016 \u0001(\u000b2*.com.blued.im.private_chat.EvaluationExtra\u0012=\n\fsecureNotify\u0018\u0017 \u0001(\u000b2'.com.blued.im.private_chat.SecureNotify\u0012K\n\u0014activity_share_extra\u0018\u0018 \u0001(\u000b2-.com.blued.im.private_chat.ActivityShareExtra\u0012K\n\u0014friends_circle_extra\u0018\u0019 \u0001(\u000b2-.com.blued.im.private_chat.FriendsCircleExtra\"\u008d\u0001\n\fMsgBody_TEXT\u0012\u0010\n\bcontents\u0018\u0001 \u0001(\t\u00123\n\u0007profile\u0018\u0002 \u0001(\u000b2\".com.blued.im.private_chat.Profile\u00126\n\u0005extra\u0018\u0003 \u0001(\u000b2'.com.blued.im.private_chat.MsgBodyExtra\"N\n\rMsgBody_IMAGE\u0012\u0010\n\bcontents\u0018\u0001 \u0001(\t\u0012\u000e\n\u0006height\u0018\u0002 \u0001(\u0005\u0012\r\n\u0005width\u0018\u0003 \u0001(\u0005\u0012\f\n\u0004size\u0018\u0004 \u0001(\u0005B\u000e¢\u0002\u000bPrivateChatb\u0006proto3"}, new Descriptors.FileDescriptor[]{MsgBodyExtraOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_com_blued_im_private_chat_MsgBody_IMAGE_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_im_private_chat_MsgBody_IMAGE_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_blued_im_private_chat_MsgBody_TEXT_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_im_private_chat_MsgBody_TEXT_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_blued_im_private_chat_MsgBody_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_im_private_chat_MsgBody_fieldAccessorTable;
    private static final Descriptors.Descriptor internal_static_com_blued_im_private_chat_MsgExtra_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_im_private_chat_MsgExtra_fieldAccessorTable;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/MsgBodyOuterClass$MsgBody.class */
    public static final class MsgBody extends GeneratedMessageV3 implements MsgBodyOrBuilder {
        public static final int CONTENTS_FIELD_NUMBER = 1;
        public static final int EXTRA_FIELD_NUMBER = 3;
        public static final int EXTRA_JSON_FIELD_NUMBER = 4;
        public static final int MSGSOURCE_FIELD_NUMBER = 5;
        public static final int MSG_RECEIVE_FROM_FIELD_NUMBER = 6;
        public static final int PROFILE_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private volatile Object contents_;
        private ByteString extraJson_;
        private MsgExtra extra_;
        private byte memoizedIsInitialized;
        private long msgReceiveFrom_;
        private MsgBodyExtraOuterClass.MsgSource msgSource_;
        private MsgBodyExtraOuterClass.Profile profile_;
        private static final MsgBody DEFAULT_INSTANCE = new MsgBody();
        private static final Parser<MsgBody> PARSER = new AbstractParser<MsgBody>() { // from class: com.blued.im.private_chat.MsgBodyOuterClass.MsgBody.1
            @Override // com.google.protobuf.Parser
            public MsgBody parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new MsgBody(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/MsgBodyOuterClass$MsgBody$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MsgBodyOrBuilder {
            private Object contents_;
            private SingleFieldBuilderV3<MsgExtra, MsgExtra.Builder, MsgExtraOrBuilder> extraBuilder_;
            private ByteString extraJson_;
            private MsgExtra extra_;
            private long msgReceiveFrom_;
            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.MsgSource, MsgBodyExtraOuterClass.MsgSource.Builder, MsgBodyExtraOuterClass.MsgSourceOrBuilder> msgSourceBuilder_;
            private MsgBodyExtraOuterClass.MsgSource msgSource_;
            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.Profile, MsgBodyExtraOuterClass.Profile.Builder, MsgBodyExtraOuterClass.ProfileOrBuilder> profileBuilder_;
            private MsgBodyExtraOuterClass.Profile profile_;

            private Builder() {
                this.contents_ = "";
                this.extraJson_ = ByteString.EMPTY;
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.contents_ = "";
                this.extraJson_ = ByteString.EMPTY;
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return MsgBodyOuterClass.internal_static_com_blued_im_private_chat_MsgBody_descriptor;
            }

            private SingleFieldBuilderV3<MsgExtra, MsgExtra.Builder, MsgExtraOrBuilder> getExtraFieldBuilder() {
                if (this.extraBuilder_ == null) {
                    this.extraBuilder_ = new SingleFieldBuilderV3<>(getExtra(), getParentForChildren(), isClean());
                    this.extra_ = null;
                }
                return this.extraBuilder_;
            }

            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.MsgSource, MsgBodyExtraOuterClass.MsgSource.Builder, MsgBodyExtraOuterClass.MsgSourceOrBuilder> getMsgSourceFieldBuilder() {
                if (this.msgSourceBuilder_ == null) {
                    this.msgSourceBuilder_ = new SingleFieldBuilderV3<>(getMsgSource(), getParentForChildren(), isClean());
                    this.msgSource_ = null;
                }
                return this.msgSourceBuilder_;
            }

            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.Profile, MsgBodyExtraOuterClass.Profile.Builder, MsgBodyExtraOuterClass.ProfileOrBuilder> getProfileFieldBuilder() {
                if (this.profileBuilder_ == null) {
                    this.profileBuilder_ = new SingleFieldBuilderV3<>(getProfile(), getParentForChildren(), isClean());
                    this.profile_ = null;
                }
                return this.profileBuilder_;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = MsgBody.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MsgBody build() {
                MsgBody buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MsgBody buildPartial() {
                MsgBody msgBody = new MsgBody(this);
                msgBody.contents_ = this.contents_;
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.Profile, MsgBodyExtraOuterClass.Profile.Builder, MsgBodyExtraOuterClass.ProfileOrBuilder> singleFieldBuilderV3 = this.profileBuilder_;
                if (singleFieldBuilderV3 == null) {
                    msgBody.profile_ = this.profile_;
                } else {
                    msgBody.profile_ = singleFieldBuilderV3.build();
                }
                SingleFieldBuilderV3<MsgExtra, MsgExtra.Builder, MsgExtraOrBuilder> singleFieldBuilderV32 = this.extraBuilder_;
                if (singleFieldBuilderV32 == null) {
                    msgBody.extra_ = this.extra_;
                } else {
                    msgBody.extra_ = singleFieldBuilderV32.build();
                }
                msgBody.extraJson_ = this.extraJson_;
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.MsgSource, MsgBodyExtraOuterClass.MsgSource.Builder, MsgBodyExtraOuterClass.MsgSourceOrBuilder> singleFieldBuilderV33 = this.msgSourceBuilder_;
                if (singleFieldBuilderV33 == null) {
                    msgBody.msgSource_ = this.msgSource_;
                } else {
                    msgBody.msgSource_ = singleFieldBuilderV33.build();
                }
                msgBody.msgReceiveFrom_ = this.msgReceiveFrom_;
                onBuilt();
                return msgBody;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.contents_ = "";
                if (this.profileBuilder_ == null) {
                    this.profile_ = null;
                } else {
                    this.profile_ = null;
                    this.profileBuilder_ = null;
                }
                if (this.extraBuilder_ == null) {
                    this.extra_ = null;
                } else {
                    this.extra_ = null;
                    this.extraBuilder_ = null;
                }
                this.extraJson_ = ByteString.EMPTY;
                if (this.msgSourceBuilder_ == null) {
                    this.msgSource_ = null;
                } else {
                    this.msgSource_ = null;
                    this.msgSourceBuilder_ = null;
                }
                this.msgReceiveFrom_ = 0L;
                return this;
            }

            public Builder clearContents() {
                this.contents_ = MsgBody.getDefaultInstance().getContents();
                onChanged();
                return this;
            }

            public Builder clearExtra() {
                if (this.extraBuilder_ == null) {
                    this.extra_ = null;
                    onChanged();
                    return this;
                }
                this.extra_ = null;
                this.extraBuilder_ = null;
                return this;
            }

            public Builder clearExtraJson() {
                this.extraJson_ = MsgBody.getDefaultInstance().getExtraJson();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearMsgReceiveFrom() {
                this.msgReceiveFrom_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearMsgSource() {
                if (this.msgSourceBuilder_ == null) {
                    this.msgSource_ = null;
                    onChanged();
                    return this;
                }
                this.msgSource_ = null;
                this.msgSourceBuilder_ = null;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearProfile() {
                if (this.profileBuilder_ == null) {
                    this.profile_ = null;
                    onChanged();
                    return this;
                }
                this.profile_ = null;
                this.profileBuilder_ = null;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo2030clone() {
                return (Builder) super.mo2030clone();
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBodyOrBuilder
            public String getContents() {
                Object obj = this.contents_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.contents_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBodyOrBuilder
            public ByteString getContentsBytes() {
                Object obj = this.contents_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.contents_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MsgBody getDefaultInstanceForType() {
                return MsgBody.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MsgBodyOuterClass.internal_static_com_blued_im_private_chat_MsgBody_descriptor;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBodyOrBuilder
            public MsgExtra getExtra() {
                SingleFieldBuilderV3<MsgExtra, MsgExtra.Builder, MsgExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
                if (singleFieldBuilderV3 == null) {
                    MsgExtra msgExtra = this.extra_;
                    MsgExtra msgExtra2 = msgExtra;
                    if (msgExtra == null) {
                        msgExtra2 = MsgExtra.getDefaultInstance();
                    }
                    return msgExtra2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public MsgExtra.Builder getExtraBuilder() {
                onChanged();
                return getExtraFieldBuilder().getBuilder();
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBodyOrBuilder
            public ByteString getExtraJson() {
                return this.extraJson_;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBodyOrBuilder
            public MsgExtraOrBuilder getExtraOrBuilder() {
                SingleFieldBuilderV3<MsgExtra, MsgExtra.Builder, MsgExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                MsgExtra msgExtra = this.extra_;
                MsgExtra msgExtra2 = msgExtra;
                if (msgExtra == null) {
                    msgExtra2 = MsgExtra.getDefaultInstance();
                }
                return msgExtra2;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBodyOrBuilder
            public long getMsgReceiveFrom() {
                return this.msgReceiveFrom_;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBodyOrBuilder
            public MsgBodyExtraOuterClass.MsgSource getMsgSource() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.MsgSource, MsgBodyExtraOuterClass.MsgSource.Builder, MsgBodyExtraOuterClass.MsgSourceOrBuilder> singleFieldBuilderV3 = this.msgSourceBuilder_;
                if (singleFieldBuilderV3 == null) {
                    MsgBodyExtraOuterClass.MsgSource msgSource = this.msgSource_;
                    MsgBodyExtraOuterClass.MsgSource msgSource2 = msgSource;
                    if (msgSource == null) {
                        msgSource2 = MsgBodyExtraOuterClass.MsgSource.getDefaultInstance();
                    }
                    return msgSource2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public MsgBodyExtraOuterClass.MsgSource.Builder getMsgSourceBuilder() {
                onChanged();
                return getMsgSourceFieldBuilder().getBuilder();
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBodyOrBuilder
            public MsgBodyExtraOuterClass.MsgSourceOrBuilder getMsgSourceOrBuilder() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.MsgSource, MsgBodyExtraOuterClass.MsgSource.Builder, MsgBodyExtraOuterClass.MsgSourceOrBuilder> singleFieldBuilderV3 = this.msgSourceBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                MsgBodyExtraOuterClass.MsgSource msgSource = this.msgSource_;
                MsgBodyExtraOuterClass.MsgSource msgSource2 = msgSource;
                if (msgSource == null) {
                    msgSource2 = MsgBodyExtraOuterClass.MsgSource.getDefaultInstance();
                }
                return msgSource2;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBodyOrBuilder
            public MsgBodyExtraOuterClass.Profile getProfile() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.Profile, MsgBodyExtraOuterClass.Profile.Builder, MsgBodyExtraOuterClass.ProfileOrBuilder> singleFieldBuilderV3 = this.profileBuilder_;
                if (singleFieldBuilderV3 == null) {
                    MsgBodyExtraOuterClass.Profile profile = this.profile_;
                    MsgBodyExtraOuterClass.Profile profile2 = profile;
                    if (profile == null) {
                        profile2 = MsgBodyExtraOuterClass.Profile.getDefaultInstance();
                    }
                    return profile2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public MsgBodyExtraOuterClass.Profile.Builder getProfileBuilder() {
                onChanged();
                return getProfileFieldBuilder().getBuilder();
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBodyOrBuilder
            public MsgBodyExtraOuterClass.ProfileOrBuilder getProfileOrBuilder() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.Profile, MsgBodyExtraOuterClass.Profile.Builder, MsgBodyExtraOuterClass.ProfileOrBuilder> singleFieldBuilderV3 = this.profileBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                MsgBodyExtraOuterClass.Profile profile = this.profile_;
                MsgBodyExtraOuterClass.Profile profile2 = profile;
                if (profile == null) {
                    profile2 = MsgBodyExtraOuterClass.Profile.getDefaultInstance();
                }
                return profile2;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBodyOrBuilder
            public boolean hasExtra() {
                return (this.extraBuilder_ == null && this.extra_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBodyOrBuilder
            public boolean hasMsgSource() {
                return (this.msgSourceBuilder_ == null && this.msgSource_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBodyOrBuilder
            public boolean hasProfile() {
                return (this.profileBuilder_ == null && this.profile_ == null) ? false : true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MsgBodyOuterClass.internal_static_com_blued_im_private_chat_MsgBody_fieldAccessorTable.ensureFieldAccessorsInitialized(MsgBody.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeExtra(MsgExtra msgExtra) {
                SingleFieldBuilderV3<MsgExtra, MsgExtra.Builder, MsgExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(msgExtra);
                    return this;
                }
                MsgExtra msgExtra2 = this.extra_;
                if (msgExtra2 != null) {
                    this.extra_ = MsgExtra.newBuilder(msgExtra2).mergeFrom(msgExtra).buildPartial();
                } else {
                    this.extra_ = msgExtra;
                }
                onChanged();
                return this;
            }

            public Builder mergeFrom(MsgBody msgBody) {
                if (msgBody == MsgBody.getDefaultInstance()) {
                    return this;
                }
                if (!msgBody.getContents().isEmpty()) {
                    this.contents_ = msgBody.contents_;
                    onChanged();
                }
                if (msgBody.hasProfile()) {
                    mergeProfile(msgBody.getProfile());
                }
                if (msgBody.hasExtra()) {
                    mergeExtra(msgBody.getExtra());
                }
                if (msgBody.getExtraJson() != ByteString.EMPTY) {
                    setExtraJson(msgBody.getExtraJson());
                }
                if (msgBody.hasMsgSource()) {
                    mergeMsgSource(msgBody.getMsgSource());
                }
                if (msgBody.getMsgReceiveFrom() != 0) {
                    setMsgReceiveFrom(msgBody.getMsgReceiveFrom());
                }
                mergeUnknownFields(msgBody.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.im.private_chat.MsgBodyOuterClass.MsgBody.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.im.private_chat.MsgBodyOuterClass.MsgBody.access$1300()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.im.private_chat.MsgBodyOuterClass$MsgBody r0 = (com.blued.im.private_chat.MsgBodyOuterClass.MsgBody) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.im.private_chat.MsgBodyOuterClass$MsgBody$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.im.private_chat.MsgBodyOuterClass$MsgBody r0 = (com.blued.im.private_chat.MsgBodyOuterClass.MsgBody) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.im.private_chat.MsgBodyOuterClass$MsgBody$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.im.private_chat.MsgBodyOuterClass.MsgBody.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.im.private_chat.MsgBodyOuterClass$MsgBody$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof MsgBody) {
                    return mergeFrom((MsgBody) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeMsgSource(MsgBodyExtraOuterClass.MsgSource msgSource) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.MsgSource, MsgBodyExtraOuterClass.MsgSource.Builder, MsgBodyExtraOuterClass.MsgSourceOrBuilder> singleFieldBuilderV3 = this.msgSourceBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(msgSource);
                    return this;
                }
                MsgBodyExtraOuterClass.MsgSource msgSource2 = this.msgSource_;
                if (msgSource2 != null) {
                    this.msgSource_ = MsgBodyExtraOuterClass.MsgSource.newBuilder(msgSource2).mergeFrom(msgSource).buildPartial();
                } else {
                    this.msgSource_ = msgSource;
                }
                onChanged();
                return this;
            }

            public Builder mergeProfile(MsgBodyExtraOuterClass.Profile profile) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.Profile, MsgBodyExtraOuterClass.Profile.Builder, MsgBodyExtraOuterClass.ProfileOrBuilder> singleFieldBuilderV3 = this.profileBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(profile);
                    return this;
                }
                MsgBodyExtraOuterClass.Profile profile2 = this.profile_;
                if (profile2 != null) {
                    this.profile_ = MsgBodyExtraOuterClass.Profile.newBuilder(profile2).mergeFrom(profile).buildPartial();
                } else {
                    this.profile_ = profile;
                }
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder setContents(String str) {
                if (str != null) {
                    this.contents_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setContentsBytes(ByteString byteString) {
                if (byteString != null) {
                    MsgBody.checkByteStringIsUtf8(byteString);
                    this.contents_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setExtra(MsgExtra.Builder builder) {
                SingleFieldBuilderV3<MsgExtra, MsgExtra.Builder, MsgExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.extra_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setExtra(MsgExtra msgExtra) {
                SingleFieldBuilderV3<MsgExtra, MsgExtra.Builder, MsgExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(msgExtra);
                    return this;
                } else if (msgExtra != null) {
                    this.extra_ = msgExtra;
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }

            public Builder setExtraJson(ByteString byteString) {
                if (byteString != null) {
                    this.extraJson_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setMsgReceiveFrom(long j) {
                this.msgReceiveFrom_ = j;
                onChanged();
                return this;
            }

            public Builder setMsgSource(MsgBodyExtraOuterClass.MsgSource.Builder builder) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.MsgSource, MsgBodyExtraOuterClass.MsgSource.Builder, MsgBodyExtraOuterClass.MsgSourceOrBuilder> singleFieldBuilderV3 = this.msgSourceBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.msgSource_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setMsgSource(MsgBodyExtraOuterClass.MsgSource msgSource) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.MsgSource, MsgBodyExtraOuterClass.MsgSource.Builder, MsgBodyExtraOuterClass.MsgSourceOrBuilder> singleFieldBuilderV3 = this.msgSourceBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(msgSource);
                    return this;
                } else if (msgSource != null) {
                    this.msgSource_ = msgSource;
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }

            public Builder setProfile(MsgBodyExtraOuterClass.Profile.Builder builder) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.Profile, MsgBodyExtraOuterClass.Profile.Builder, MsgBodyExtraOuterClass.ProfileOrBuilder> singleFieldBuilderV3 = this.profileBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.profile_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setProfile(MsgBodyExtraOuterClass.Profile profile) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.Profile, MsgBodyExtraOuterClass.Profile.Builder, MsgBodyExtraOuterClass.ProfileOrBuilder> singleFieldBuilderV3 = this.profileBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(profile);
                    return this;
                } else if (profile != null) {
                    this.profile_ = profile;
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private MsgBody() {
            this.memoizedIsInitialized = (byte) -1;
            this.contents_ = "";
            this.extraJson_ = ByteString.EMPTY;
        }

        private MsgBody(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            if (readTag == 10) {
                                this.contents_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                MsgBodyExtraOuterClass.Profile.Builder builder = this.profile_ != null ? this.profile_.toBuilder() : null;
                                MsgBodyExtraOuterClass.Profile profile = (MsgBodyExtraOuterClass.Profile) codedInputStream.readMessage(MsgBodyExtraOuterClass.Profile.parser(), extensionRegistryLite);
                                this.profile_ = profile;
                                if (builder != null) {
                                    builder.mergeFrom(profile);
                                    this.profile_ = builder.buildPartial();
                                }
                            } else if (readTag == 26) {
                                MsgExtra.Builder builder2 = this.extra_ != null ? this.extra_.toBuilder() : null;
                                MsgExtra msgExtra = (MsgExtra) codedInputStream.readMessage(MsgExtra.parser(), extensionRegistryLite);
                                this.extra_ = msgExtra;
                                if (builder2 != null) {
                                    builder2.mergeFrom(msgExtra);
                                    this.extra_ = builder2.buildPartial();
                                }
                            } else if (readTag == 34) {
                                this.extraJson_ = codedInputStream.readBytes();
                            } else if (readTag == 42) {
                                MsgBodyExtraOuterClass.MsgSource.Builder builder3 = this.msgSource_ != null ? this.msgSource_.toBuilder() : null;
                                MsgBodyExtraOuterClass.MsgSource msgSource = (MsgBodyExtraOuterClass.MsgSource) codedInputStream.readMessage(MsgBodyExtraOuterClass.MsgSource.parser(), extensionRegistryLite);
                                this.msgSource_ = msgSource;
                                if (builder3 != null) {
                                    builder3.mergeFrom(msgSource);
                                    this.msgSource_ = builder3.buildPartial();
                                }
                            } else if (readTag == 48) {
                                this.msgReceiveFrom_ = codedInputStream.readInt64();
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

        private MsgBody(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static MsgBody getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MsgBodyOuterClass.internal_static_com_blued_im_private_chat_MsgBody_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MsgBody msgBody) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(msgBody);
        }

        public static MsgBody parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (MsgBody) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static MsgBody parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MsgBody) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static MsgBody parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static MsgBody parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static MsgBody parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (MsgBody) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static MsgBody parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MsgBody) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static MsgBody parseFrom(InputStream inputStream) throws IOException {
            return (MsgBody) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static MsgBody parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MsgBody) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static MsgBody parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static MsgBody parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static MsgBody parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static MsgBody parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<MsgBody> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof MsgBody) {
                MsgBody msgBody = (MsgBody) obj;
                if (getContents().equals(msgBody.getContents()) && hasProfile() == msgBody.hasProfile()) {
                    if ((!hasProfile() || getProfile().equals(msgBody.getProfile())) && hasExtra() == msgBody.hasExtra()) {
                        if ((!hasExtra() || getExtra().equals(msgBody.getExtra())) && getExtraJson().equals(msgBody.getExtraJson()) && hasMsgSource() == msgBody.hasMsgSource()) {
                            return (!hasMsgSource() || getMsgSource().equals(msgBody.getMsgSource())) && getMsgReceiveFrom() == msgBody.getMsgReceiveFrom() && this.unknownFields.equals(msgBody.unknownFields);
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return super.equals(obj);
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBodyOrBuilder
        public String getContents() {
            Object obj = this.contents_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.contents_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBodyOrBuilder
        public ByteString getContentsBytes() {
            Object obj = this.contents_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.contents_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MsgBody getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBodyOrBuilder
        public MsgExtra getExtra() {
            MsgExtra msgExtra = this.extra_;
            MsgExtra msgExtra2 = msgExtra;
            if (msgExtra == null) {
                msgExtra2 = MsgExtra.getDefaultInstance();
            }
            return msgExtra2;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBodyOrBuilder
        public ByteString getExtraJson() {
            return this.extraJson_;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBodyOrBuilder
        public MsgExtraOrBuilder getExtraOrBuilder() {
            return getExtra();
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBodyOrBuilder
        public long getMsgReceiveFrom() {
            return this.msgReceiveFrom_;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBodyOrBuilder
        public MsgBodyExtraOuterClass.MsgSource getMsgSource() {
            MsgBodyExtraOuterClass.MsgSource msgSource = this.msgSource_;
            MsgBodyExtraOuterClass.MsgSource msgSource2 = msgSource;
            if (msgSource == null) {
                msgSource2 = MsgBodyExtraOuterClass.MsgSource.getDefaultInstance();
            }
            return msgSource2;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBodyOrBuilder
        public MsgBodyExtraOuterClass.MsgSourceOrBuilder getMsgSourceOrBuilder() {
            return getMsgSource();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MsgBody> getParserForType() {
            return PARSER;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBodyOrBuilder
        public MsgBodyExtraOuterClass.Profile getProfile() {
            MsgBodyExtraOuterClass.Profile profile = this.profile_;
            MsgBodyExtraOuterClass.Profile profile2 = profile;
            if (profile == null) {
                profile2 = MsgBodyExtraOuterClass.Profile.getDefaultInstance();
            }
            return profile2;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBodyOrBuilder
        public MsgBodyExtraOuterClass.ProfileOrBuilder getProfileOrBuilder() {
            return getProfile();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (!getContentsBytes().isEmpty()) {
                i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.contents_);
            }
            int i3 = i2;
            if (this.profile_ != null) {
                i3 = i2 + CodedOutputStream.computeMessageSize(2, getProfile());
            }
            int i4 = i3;
            if (this.extra_ != null) {
                i4 = i3 + CodedOutputStream.computeMessageSize(3, getExtra());
            }
            int i5 = i4;
            if (!this.extraJson_.isEmpty()) {
                i5 = i4 + CodedOutputStream.computeBytesSize(4, this.extraJson_);
            }
            int i6 = i5;
            if (this.msgSource_ != null) {
                i6 = i5 + CodedOutputStream.computeMessageSize(5, getMsgSource());
            }
            long j = this.msgReceiveFrom_;
            int i7 = i6;
            if (j != 0) {
                i7 = i6 + CodedOutputStream.computeInt64Size(6, j);
            }
            int serializedSize = i7 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBodyOrBuilder
        public boolean hasExtra() {
            return this.extra_ != null;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBodyOrBuilder
        public boolean hasMsgSource() {
            return this.msgSource_ != null;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBodyOrBuilder
        public boolean hasProfile() {
            return this.profile_ != null;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getContents().hashCode();
            int i = hashCode;
            if (hasProfile()) {
                i = (((hashCode * 37) + 2) * 53) + getProfile().hashCode();
            }
            int i2 = i;
            if (hasExtra()) {
                i2 = (((i * 37) + 3) * 53) + getExtra().hashCode();
            }
            int hashCode2 = (((i2 * 37) + 4) * 53) + getExtraJson().hashCode();
            int i3 = hashCode2;
            if (hasMsgSource()) {
                i3 = (((hashCode2 * 37) + 5) * 53) + getMsgSource().hashCode();
            }
            int hashLong = (((((i3 * 37) + 6) * 53) + Internal.hashLong(getMsgReceiveFrom())) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashLong;
            return hashLong;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MsgBodyOuterClass.internal_static_com_blued_im_private_chat_MsgBody_fieldAccessorTable.ensureFieldAccessorsInitialized(MsgBody.class, Builder.class);
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
            return new MsgBody();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!getContentsBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.contents_);
            }
            if (this.profile_ != null) {
                codedOutputStream.writeMessage(2, getProfile());
            }
            if (this.extra_ != null) {
                codedOutputStream.writeMessage(3, getExtra());
            }
            if (!this.extraJson_.isEmpty()) {
                codedOutputStream.writeBytes(4, this.extraJson_);
            }
            if (this.msgSource_ != null) {
                codedOutputStream.writeMessage(5, getMsgSource());
            }
            long j = this.msgReceiveFrom_;
            if (j != 0) {
                codedOutputStream.writeInt64(6, j);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/MsgBodyOuterClass$MsgBodyOrBuilder.class */
    public interface MsgBodyOrBuilder extends MessageOrBuilder {
        String getContents();

        ByteString getContentsBytes();

        MsgExtra getExtra();

        ByteString getExtraJson();

        MsgExtraOrBuilder getExtraOrBuilder();

        long getMsgReceiveFrom();

        MsgBodyExtraOuterClass.MsgSource getMsgSource();

        MsgBodyExtraOuterClass.MsgSourceOrBuilder getMsgSourceOrBuilder();

        MsgBodyExtraOuterClass.Profile getProfile();

        MsgBodyExtraOuterClass.ProfileOrBuilder getProfileOrBuilder();

        boolean hasExtra();

        boolean hasMsgSource();

        boolean hasProfile();
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/MsgBodyOuterClass$MsgBody_IMAGE.class */
    public static final class MsgBody_IMAGE extends GeneratedMessageV3 implements MsgBody_IMAGEOrBuilder {
        public static final int CONTENTS_FIELD_NUMBER = 1;
        public static final int HEIGHT_FIELD_NUMBER = 2;
        public static final int SIZE_FIELD_NUMBER = 4;
        public static final int WIDTH_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private volatile Object contents_;
        private int height_;
        private byte memoizedIsInitialized;
        private int size_;
        private int width_;
        private static final MsgBody_IMAGE DEFAULT_INSTANCE = new MsgBody_IMAGE();
        private static final Parser<MsgBody_IMAGE> PARSER = new AbstractParser<MsgBody_IMAGE>() { // from class: com.blued.im.private_chat.MsgBodyOuterClass.MsgBody_IMAGE.1
            @Override // com.google.protobuf.Parser
            public MsgBody_IMAGE parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new MsgBody_IMAGE(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/MsgBodyOuterClass$MsgBody_IMAGE$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MsgBody_IMAGEOrBuilder {
            private Object contents_;
            private int height_;
            private int size_;
            private int width_;

            private Builder() {
                this.contents_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.contents_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return MsgBodyOuterClass.internal_static_com_blued_im_private_chat_MsgBody_IMAGE_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = MsgBody_IMAGE.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MsgBody_IMAGE build() {
                MsgBody_IMAGE buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MsgBody_IMAGE buildPartial() {
                MsgBody_IMAGE msgBody_IMAGE = new MsgBody_IMAGE(this);
                msgBody_IMAGE.contents_ = this.contents_;
                msgBody_IMAGE.height_ = this.height_;
                msgBody_IMAGE.width_ = this.width_;
                msgBody_IMAGE.size_ = this.size_;
                onBuilt();
                return msgBody_IMAGE;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.contents_ = "";
                this.height_ = 0;
                this.width_ = 0;
                this.size_ = 0;
                return this;
            }

            public Builder clearContents() {
                this.contents_ = MsgBody_IMAGE.getDefaultInstance().getContents();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearHeight() {
                this.height_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearSize() {
                this.size_ = 0;
                onChanged();
                return this;
            }

            public Builder clearWidth() {
                this.width_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo2030clone() {
                return (Builder) super.mo2030clone();
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBody_IMAGEOrBuilder
            public String getContents() {
                Object obj = this.contents_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.contents_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBody_IMAGEOrBuilder
            public ByteString getContentsBytes() {
                Object obj = this.contents_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.contents_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MsgBody_IMAGE getDefaultInstanceForType() {
                return MsgBody_IMAGE.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MsgBodyOuterClass.internal_static_com_blued_im_private_chat_MsgBody_IMAGE_descriptor;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBody_IMAGEOrBuilder
            public int getHeight() {
                return this.height_;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBody_IMAGEOrBuilder
            public int getSize() {
                return this.size_;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBody_IMAGEOrBuilder
            public int getWidth() {
                return this.width_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MsgBodyOuterClass.internal_static_com_blued_im_private_chat_MsgBody_IMAGE_fieldAccessorTable.ensureFieldAccessorsInitialized(MsgBody_IMAGE.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeFrom(MsgBody_IMAGE msgBody_IMAGE) {
                if (msgBody_IMAGE == MsgBody_IMAGE.getDefaultInstance()) {
                    return this;
                }
                if (!msgBody_IMAGE.getContents().isEmpty()) {
                    this.contents_ = msgBody_IMAGE.contents_;
                    onChanged();
                }
                if (msgBody_IMAGE.getHeight() != 0) {
                    setHeight(msgBody_IMAGE.getHeight());
                }
                if (msgBody_IMAGE.getWidth() != 0) {
                    setWidth(msgBody_IMAGE.getWidth());
                }
                if (msgBody_IMAGE.getSize() != 0) {
                    setSize(msgBody_IMAGE.getSize());
                }
                mergeUnknownFields(msgBody_IMAGE.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.im.private_chat.MsgBodyOuterClass.MsgBody_IMAGE.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.im.private_chat.MsgBodyOuterClass.MsgBody_IMAGE.access$7300()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.im.private_chat.MsgBodyOuterClass$MsgBody_IMAGE r0 = (com.blued.im.private_chat.MsgBodyOuterClass.MsgBody_IMAGE) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.im.private_chat.MsgBodyOuterClass$MsgBody_IMAGE$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.im.private_chat.MsgBodyOuterClass$MsgBody_IMAGE r0 = (com.blued.im.private_chat.MsgBodyOuterClass.MsgBody_IMAGE) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.im.private_chat.MsgBodyOuterClass$MsgBody_IMAGE$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.im.private_chat.MsgBodyOuterClass.MsgBody_IMAGE.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.im.private_chat.MsgBodyOuterClass$MsgBody_IMAGE$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof MsgBody_IMAGE) {
                    return mergeFrom((MsgBody_IMAGE) message);
                }
                super.mergeFrom(message);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder setContents(String str) {
                if (str != null) {
                    this.contents_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setContentsBytes(ByteString byteString) {
                if (byteString != null) {
                    MsgBody_IMAGE.checkByteStringIsUtf8(byteString);
                    this.contents_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            public Builder setHeight(int i) {
                this.height_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
            }

            public Builder setSize(int i) {
                this.size_ = i;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            public Builder setWidth(int i) {
                this.width_ = i;
                onChanged();
                return this;
            }
        }

        private MsgBody_IMAGE() {
            this.memoizedIsInitialized = (byte) -1;
            this.contents_ = "";
        }

        private MsgBody_IMAGE(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            if (readTag == 10) {
                                this.contents_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 16) {
                                this.height_ = codedInputStream.readInt32();
                            } else if (readTag == 24) {
                                this.width_ = codedInputStream.readInt32();
                            } else if (readTag == 32) {
                                this.size_ = codedInputStream.readInt32();
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

        private MsgBody_IMAGE(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static MsgBody_IMAGE getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MsgBodyOuterClass.internal_static_com_blued_im_private_chat_MsgBody_IMAGE_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MsgBody_IMAGE msgBody_IMAGE) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(msgBody_IMAGE);
        }

        public static MsgBody_IMAGE parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (MsgBody_IMAGE) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static MsgBody_IMAGE parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MsgBody_IMAGE) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static MsgBody_IMAGE parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static MsgBody_IMAGE parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static MsgBody_IMAGE parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (MsgBody_IMAGE) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static MsgBody_IMAGE parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MsgBody_IMAGE) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static MsgBody_IMAGE parseFrom(InputStream inputStream) throws IOException {
            return (MsgBody_IMAGE) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static MsgBody_IMAGE parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MsgBody_IMAGE) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static MsgBody_IMAGE parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static MsgBody_IMAGE parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static MsgBody_IMAGE parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static MsgBody_IMAGE parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<MsgBody_IMAGE> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof MsgBody_IMAGE) {
                MsgBody_IMAGE msgBody_IMAGE = (MsgBody_IMAGE) obj;
                return getContents().equals(msgBody_IMAGE.getContents()) && getHeight() == msgBody_IMAGE.getHeight() && getWidth() == msgBody_IMAGE.getWidth() && getSize() == msgBody_IMAGE.getSize() && this.unknownFields.equals(msgBody_IMAGE.unknownFields);
            }
            return super.equals(obj);
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBody_IMAGEOrBuilder
        public String getContents() {
            Object obj = this.contents_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.contents_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBody_IMAGEOrBuilder
        public ByteString getContentsBytes() {
            Object obj = this.contents_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.contents_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MsgBody_IMAGE getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBody_IMAGEOrBuilder
        public int getHeight() {
            return this.height_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MsgBody_IMAGE> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (!getContentsBytes().isEmpty()) {
                i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.contents_);
            }
            int i3 = this.height_;
            int i4 = i2;
            if (i3 != 0) {
                i4 = i2 + CodedOutputStream.computeInt32Size(2, i3);
            }
            int i5 = this.width_;
            int i6 = i4;
            if (i5 != 0) {
                i6 = i4 + CodedOutputStream.computeInt32Size(3, i5);
            }
            int i7 = this.size_;
            int i8 = i6;
            if (i7 != 0) {
                i8 = i6 + CodedOutputStream.computeInt32Size(4, i7);
            }
            int serializedSize = i8 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBody_IMAGEOrBuilder
        public int getSize() {
            return this.size_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBody_IMAGEOrBuilder
        public int getWidth() {
            return this.width_;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getContents().hashCode()) * 37) + 2) * 53) + getHeight()) * 37) + 3) * 53) + getWidth()) * 37) + 4) * 53) + getSize()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MsgBodyOuterClass.internal_static_com_blued_im_private_chat_MsgBody_IMAGE_fieldAccessorTable.ensureFieldAccessorsInitialized(MsgBody_IMAGE.class, Builder.class);
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
            return new MsgBody_IMAGE();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!getContentsBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.contents_);
            }
            int i = this.height_;
            if (i != 0) {
                codedOutputStream.writeInt32(2, i);
            }
            int i2 = this.width_;
            if (i2 != 0) {
                codedOutputStream.writeInt32(3, i2);
            }
            int i3 = this.size_;
            if (i3 != 0) {
                codedOutputStream.writeInt32(4, i3);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/MsgBodyOuterClass$MsgBody_IMAGEOrBuilder.class */
    public interface MsgBody_IMAGEOrBuilder extends MessageOrBuilder {
        String getContents();

        ByteString getContentsBytes();

        int getHeight();

        int getSize();

        int getWidth();
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/MsgBodyOuterClass$MsgBody_TEXT.class */
    public static final class MsgBody_TEXT extends GeneratedMessageV3 implements MsgBody_TEXTOrBuilder {
        public static final int CONTENTS_FIELD_NUMBER = 1;
        public static final int EXTRA_FIELD_NUMBER = 3;
        public static final int PROFILE_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private volatile Object contents_;
        private MsgBodyExtraOuterClass.MsgBodyExtra extra_;
        private byte memoizedIsInitialized;
        private MsgBodyExtraOuterClass.Profile profile_;
        private static final MsgBody_TEXT DEFAULT_INSTANCE = new MsgBody_TEXT();
        private static final Parser<MsgBody_TEXT> PARSER = new AbstractParser<MsgBody_TEXT>() { // from class: com.blued.im.private_chat.MsgBodyOuterClass.MsgBody_TEXT.1
            @Override // com.google.protobuf.Parser
            public MsgBody_TEXT parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new MsgBody_TEXT(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/MsgBodyOuterClass$MsgBody_TEXT$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MsgBody_TEXTOrBuilder {
            private Object contents_;
            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.MsgBodyExtra, MsgBodyExtraOuterClass.MsgBodyExtra.Builder, MsgBodyExtraOuterClass.MsgBodyExtraOrBuilder> extraBuilder_;
            private MsgBodyExtraOuterClass.MsgBodyExtra extra_;
            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.Profile, MsgBodyExtraOuterClass.Profile.Builder, MsgBodyExtraOuterClass.ProfileOrBuilder> profileBuilder_;
            private MsgBodyExtraOuterClass.Profile profile_;

            private Builder() {
                this.contents_ = "";
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.contents_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return MsgBodyOuterClass.internal_static_com_blued_im_private_chat_MsgBody_TEXT_descriptor;
            }

            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.MsgBodyExtra, MsgBodyExtraOuterClass.MsgBodyExtra.Builder, MsgBodyExtraOuterClass.MsgBodyExtraOrBuilder> getExtraFieldBuilder() {
                if (this.extraBuilder_ == null) {
                    this.extraBuilder_ = new SingleFieldBuilderV3<>(getExtra(), getParentForChildren(), isClean());
                    this.extra_ = null;
                }
                return this.extraBuilder_;
            }

            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.Profile, MsgBodyExtraOuterClass.Profile.Builder, MsgBodyExtraOuterClass.ProfileOrBuilder> getProfileFieldBuilder() {
                if (this.profileBuilder_ == null) {
                    this.profileBuilder_ = new SingleFieldBuilderV3<>(getProfile(), getParentForChildren(), isClean());
                    this.profile_ = null;
                }
                return this.profileBuilder_;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = MsgBody_TEXT.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MsgBody_TEXT build() {
                MsgBody_TEXT buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MsgBody_TEXT buildPartial() {
                MsgBody_TEXT msgBody_TEXT = new MsgBody_TEXT(this);
                msgBody_TEXT.contents_ = this.contents_;
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.Profile, MsgBodyExtraOuterClass.Profile.Builder, MsgBodyExtraOuterClass.ProfileOrBuilder> singleFieldBuilderV3 = this.profileBuilder_;
                if (singleFieldBuilderV3 == null) {
                    msgBody_TEXT.profile_ = this.profile_;
                } else {
                    msgBody_TEXT.profile_ = singleFieldBuilderV3.build();
                }
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.MsgBodyExtra, MsgBodyExtraOuterClass.MsgBodyExtra.Builder, MsgBodyExtraOuterClass.MsgBodyExtraOrBuilder> singleFieldBuilderV32 = this.extraBuilder_;
                if (singleFieldBuilderV32 == null) {
                    msgBody_TEXT.extra_ = this.extra_;
                } else {
                    msgBody_TEXT.extra_ = singleFieldBuilderV32.build();
                }
                onBuilt();
                return msgBody_TEXT;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.contents_ = "";
                if (this.profileBuilder_ == null) {
                    this.profile_ = null;
                } else {
                    this.profile_ = null;
                    this.profileBuilder_ = null;
                }
                if (this.extraBuilder_ == null) {
                    this.extra_ = null;
                    return this;
                }
                this.extra_ = null;
                this.extraBuilder_ = null;
                return this;
            }

            public Builder clearContents() {
                this.contents_ = MsgBody_TEXT.getDefaultInstance().getContents();
                onChanged();
                return this;
            }

            public Builder clearExtra() {
                if (this.extraBuilder_ == null) {
                    this.extra_ = null;
                    onChanged();
                    return this;
                }
                this.extra_ = null;
                this.extraBuilder_ = null;
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

            public Builder clearProfile() {
                if (this.profileBuilder_ == null) {
                    this.profile_ = null;
                    onChanged();
                    return this;
                }
                this.profile_ = null;
                this.profileBuilder_ = null;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo2030clone() {
                return (Builder) super.mo2030clone();
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBody_TEXTOrBuilder
            public String getContents() {
                Object obj = this.contents_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.contents_ = stringUtf8;
                return stringUtf8;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBody_TEXTOrBuilder
            public ByteString getContentsBytes() {
                Object obj = this.contents_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.contents_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MsgBody_TEXT getDefaultInstanceForType() {
                return MsgBody_TEXT.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MsgBodyOuterClass.internal_static_com_blued_im_private_chat_MsgBody_TEXT_descriptor;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBody_TEXTOrBuilder
            public MsgBodyExtraOuterClass.MsgBodyExtra getExtra() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.MsgBodyExtra, MsgBodyExtraOuterClass.MsgBodyExtra.Builder, MsgBodyExtraOuterClass.MsgBodyExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
                if (singleFieldBuilderV3 == null) {
                    MsgBodyExtraOuterClass.MsgBodyExtra msgBodyExtra = this.extra_;
                    MsgBodyExtraOuterClass.MsgBodyExtra msgBodyExtra2 = msgBodyExtra;
                    if (msgBodyExtra == null) {
                        msgBodyExtra2 = MsgBodyExtraOuterClass.MsgBodyExtra.getDefaultInstance();
                    }
                    return msgBodyExtra2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public MsgBodyExtraOuterClass.MsgBodyExtra.Builder getExtraBuilder() {
                onChanged();
                return getExtraFieldBuilder().getBuilder();
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBody_TEXTOrBuilder
            public MsgBodyExtraOuterClass.MsgBodyExtraOrBuilder getExtraOrBuilder() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.MsgBodyExtra, MsgBodyExtraOuterClass.MsgBodyExtra.Builder, MsgBodyExtraOuterClass.MsgBodyExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                MsgBodyExtraOuterClass.MsgBodyExtra msgBodyExtra = this.extra_;
                MsgBodyExtraOuterClass.MsgBodyExtra msgBodyExtra2 = msgBodyExtra;
                if (msgBodyExtra == null) {
                    msgBodyExtra2 = MsgBodyExtraOuterClass.MsgBodyExtra.getDefaultInstance();
                }
                return msgBodyExtra2;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBody_TEXTOrBuilder
            public MsgBodyExtraOuterClass.Profile getProfile() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.Profile, MsgBodyExtraOuterClass.Profile.Builder, MsgBodyExtraOuterClass.ProfileOrBuilder> singleFieldBuilderV3 = this.profileBuilder_;
                if (singleFieldBuilderV3 == null) {
                    MsgBodyExtraOuterClass.Profile profile = this.profile_;
                    MsgBodyExtraOuterClass.Profile profile2 = profile;
                    if (profile == null) {
                        profile2 = MsgBodyExtraOuterClass.Profile.getDefaultInstance();
                    }
                    return profile2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public MsgBodyExtraOuterClass.Profile.Builder getProfileBuilder() {
                onChanged();
                return getProfileFieldBuilder().getBuilder();
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBody_TEXTOrBuilder
            public MsgBodyExtraOuterClass.ProfileOrBuilder getProfileOrBuilder() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.Profile, MsgBodyExtraOuterClass.Profile.Builder, MsgBodyExtraOuterClass.ProfileOrBuilder> singleFieldBuilderV3 = this.profileBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                MsgBodyExtraOuterClass.Profile profile = this.profile_;
                MsgBodyExtraOuterClass.Profile profile2 = profile;
                if (profile == null) {
                    profile2 = MsgBodyExtraOuterClass.Profile.getDefaultInstance();
                }
                return profile2;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBody_TEXTOrBuilder
            public boolean hasExtra() {
                return (this.extraBuilder_ == null && this.extra_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBody_TEXTOrBuilder
            public boolean hasProfile() {
                return (this.profileBuilder_ == null && this.profile_ == null) ? false : true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MsgBodyOuterClass.internal_static_com_blued_im_private_chat_MsgBody_TEXT_fieldAccessorTable.ensureFieldAccessorsInitialized(MsgBody_TEXT.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeExtra(MsgBodyExtraOuterClass.MsgBodyExtra msgBodyExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.MsgBodyExtra, MsgBodyExtraOuterClass.MsgBodyExtra.Builder, MsgBodyExtraOuterClass.MsgBodyExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(msgBodyExtra);
                    return this;
                }
                MsgBodyExtraOuterClass.MsgBodyExtra msgBodyExtra2 = this.extra_;
                if (msgBodyExtra2 != null) {
                    this.extra_ = MsgBodyExtraOuterClass.MsgBodyExtra.newBuilder(msgBodyExtra2).mergeFrom(msgBodyExtra).buildPartial();
                } else {
                    this.extra_ = msgBodyExtra;
                }
                onChanged();
                return this;
            }

            public Builder mergeFrom(MsgBody_TEXT msgBody_TEXT) {
                if (msgBody_TEXT == MsgBody_TEXT.getDefaultInstance()) {
                    return this;
                }
                if (!msgBody_TEXT.getContents().isEmpty()) {
                    this.contents_ = msgBody_TEXT.contents_;
                    onChanged();
                }
                if (msgBody_TEXT.hasProfile()) {
                    mergeProfile(msgBody_TEXT.getProfile());
                }
                if (msgBody_TEXT.hasExtra()) {
                    mergeExtra(msgBody_TEXT.getExtra());
                }
                mergeUnknownFields(msgBody_TEXT.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.im.private_chat.MsgBodyOuterClass.MsgBody_TEXT.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.im.private_chat.MsgBodyOuterClass.MsgBody_TEXT.access$5900()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.im.private_chat.MsgBodyOuterClass$MsgBody_TEXT r0 = (com.blued.im.private_chat.MsgBodyOuterClass.MsgBody_TEXT) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.im.private_chat.MsgBodyOuterClass$MsgBody_TEXT$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.im.private_chat.MsgBodyOuterClass$MsgBody_TEXT r0 = (com.blued.im.private_chat.MsgBodyOuterClass.MsgBody_TEXT) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.im.private_chat.MsgBodyOuterClass$MsgBody_TEXT$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.im.private_chat.MsgBodyOuterClass.MsgBody_TEXT.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.im.private_chat.MsgBodyOuterClass$MsgBody_TEXT$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof MsgBody_TEXT) {
                    return mergeFrom((MsgBody_TEXT) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeProfile(MsgBodyExtraOuterClass.Profile profile) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.Profile, MsgBodyExtraOuterClass.Profile.Builder, MsgBodyExtraOuterClass.ProfileOrBuilder> singleFieldBuilderV3 = this.profileBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(profile);
                    return this;
                }
                MsgBodyExtraOuterClass.Profile profile2 = this.profile_;
                if (profile2 != null) {
                    this.profile_ = MsgBodyExtraOuterClass.Profile.newBuilder(profile2).mergeFrom(profile).buildPartial();
                } else {
                    this.profile_ = profile;
                }
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder setContents(String str) {
                if (str != null) {
                    this.contents_ = str;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setContentsBytes(ByteString byteString) {
                if (byteString != null) {
                    MsgBody_TEXT.checkByteStringIsUtf8(byteString);
                    this.contents_ = byteString;
                    onChanged();
                    return this;
                }
                throw null;
            }

            public Builder setExtra(MsgBodyExtraOuterClass.MsgBodyExtra.Builder builder) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.MsgBodyExtra, MsgBodyExtraOuterClass.MsgBodyExtra.Builder, MsgBodyExtraOuterClass.MsgBodyExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.extra_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setExtra(MsgBodyExtraOuterClass.MsgBodyExtra msgBodyExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.MsgBodyExtra, MsgBodyExtraOuterClass.MsgBodyExtra.Builder, MsgBodyExtraOuterClass.MsgBodyExtraOrBuilder> singleFieldBuilderV3 = this.extraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(msgBodyExtra);
                    return this;
                } else if (msgBodyExtra != null) {
                    this.extra_ = msgBodyExtra;
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

            public Builder setProfile(MsgBodyExtraOuterClass.Profile.Builder builder) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.Profile, MsgBodyExtraOuterClass.Profile.Builder, MsgBodyExtraOuterClass.ProfileOrBuilder> singleFieldBuilderV3 = this.profileBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.profile_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setProfile(MsgBodyExtraOuterClass.Profile profile) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.Profile, MsgBodyExtraOuterClass.Profile.Builder, MsgBodyExtraOuterClass.ProfileOrBuilder> singleFieldBuilderV3 = this.profileBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(profile);
                    return this;
                } else if (profile != null) {
                    this.profile_ = profile;
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }
        }

        private MsgBody_TEXT() {
            this.memoizedIsInitialized = (byte) -1;
            this.contents_ = "";
        }

        private MsgBody_TEXT(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.contents_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 18) {
                                    MsgBodyExtraOuterClass.Profile.Builder builder = this.profile_ != null ? this.profile_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.Profile profile = (MsgBodyExtraOuterClass.Profile) codedInputStream.readMessage(MsgBodyExtraOuterClass.Profile.parser(), extensionRegistryLite);
                                    this.profile_ = profile;
                                    if (builder != null) {
                                        builder.mergeFrom(profile);
                                        this.profile_ = builder.buildPartial();
                                    }
                                } else if (readTag == 26) {
                                    MsgBodyExtraOuterClass.MsgBodyExtra.Builder builder2 = this.extra_ != null ? this.extra_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.MsgBodyExtra msgBodyExtra = (MsgBodyExtraOuterClass.MsgBodyExtra) codedInputStream.readMessage(MsgBodyExtraOuterClass.MsgBodyExtra.parser(), extensionRegistryLite);
                                    this.extra_ = msgBodyExtra;
                                    if (builder2 != null) {
                                        builder2.mergeFrom(msgBodyExtra);
                                        this.extra_ = builder2.buildPartial();
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

        private MsgBody_TEXT(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static MsgBody_TEXT getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MsgBodyOuterClass.internal_static_com_blued_im_private_chat_MsgBody_TEXT_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MsgBody_TEXT msgBody_TEXT) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(msgBody_TEXT);
        }

        public static MsgBody_TEXT parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (MsgBody_TEXT) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static MsgBody_TEXT parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MsgBody_TEXT) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static MsgBody_TEXT parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static MsgBody_TEXT parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static MsgBody_TEXT parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (MsgBody_TEXT) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static MsgBody_TEXT parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MsgBody_TEXT) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static MsgBody_TEXT parseFrom(InputStream inputStream) throws IOException {
            return (MsgBody_TEXT) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static MsgBody_TEXT parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MsgBody_TEXT) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static MsgBody_TEXT parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static MsgBody_TEXT parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static MsgBody_TEXT parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static MsgBody_TEXT parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<MsgBody_TEXT> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof MsgBody_TEXT) {
                MsgBody_TEXT msgBody_TEXT = (MsgBody_TEXT) obj;
                if (getContents().equals(msgBody_TEXT.getContents()) && hasProfile() == msgBody_TEXT.hasProfile()) {
                    if ((!hasProfile() || getProfile().equals(msgBody_TEXT.getProfile())) && hasExtra() == msgBody_TEXT.hasExtra()) {
                        return (!hasExtra() || getExtra().equals(msgBody_TEXT.getExtra())) && this.unknownFields.equals(msgBody_TEXT.unknownFields);
                    }
                    return false;
                }
                return false;
            }
            return super.equals(obj);
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBody_TEXTOrBuilder
        public String getContents() {
            Object obj = this.contents_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.contents_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBody_TEXTOrBuilder
        public ByteString getContentsBytes() {
            Object obj = this.contents_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.contents_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MsgBody_TEXT getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBody_TEXTOrBuilder
        public MsgBodyExtraOuterClass.MsgBodyExtra getExtra() {
            MsgBodyExtraOuterClass.MsgBodyExtra msgBodyExtra = this.extra_;
            MsgBodyExtraOuterClass.MsgBodyExtra msgBodyExtra2 = msgBodyExtra;
            if (msgBodyExtra == null) {
                msgBodyExtra2 = MsgBodyExtraOuterClass.MsgBodyExtra.getDefaultInstance();
            }
            return msgBodyExtra2;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBody_TEXTOrBuilder
        public MsgBodyExtraOuterClass.MsgBodyExtraOrBuilder getExtraOrBuilder() {
            return getExtra();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MsgBody_TEXT> getParserForType() {
            return PARSER;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBody_TEXTOrBuilder
        public MsgBodyExtraOuterClass.Profile getProfile() {
            MsgBodyExtraOuterClass.Profile profile = this.profile_;
            MsgBodyExtraOuterClass.Profile profile2 = profile;
            if (profile == null) {
                profile2 = MsgBodyExtraOuterClass.Profile.getDefaultInstance();
            }
            return profile2;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBody_TEXTOrBuilder
        public MsgBodyExtraOuterClass.ProfileOrBuilder getProfileOrBuilder() {
            return getProfile();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (!getContentsBytes().isEmpty()) {
                i2 = 0 + GeneratedMessageV3.computeStringSize(1, this.contents_);
            }
            int i3 = i2;
            if (this.profile_ != null) {
                i3 = i2 + CodedOutputStream.computeMessageSize(2, getProfile());
            }
            int i4 = i3;
            if (this.extra_ != null) {
                i4 = i3 + CodedOutputStream.computeMessageSize(3, getExtra());
            }
            int serializedSize = i4 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBody_TEXTOrBuilder
        public boolean hasExtra() {
            return this.extra_ != null;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgBody_TEXTOrBuilder
        public boolean hasProfile() {
            return this.profile_ != null;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = ((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getContents().hashCode();
            int i = hashCode;
            if (hasProfile()) {
                i = (((hashCode * 37) + 2) * 53) + getProfile().hashCode();
            }
            int i2 = i;
            if (hasExtra()) {
                i2 = (((i * 37) + 3) * 53) + getExtra().hashCode();
            }
            int hashCode2 = (i2 * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MsgBodyOuterClass.internal_static_com_blued_im_private_chat_MsgBody_TEXT_fieldAccessorTable.ensureFieldAccessorsInitialized(MsgBody_TEXT.class, Builder.class);
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
            return new MsgBody_TEXT();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!getContentsBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.contents_);
            }
            if (this.profile_ != null) {
                codedOutputStream.writeMessage(2, getProfile());
            }
            if (this.extra_ != null) {
                codedOutputStream.writeMessage(3, getExtra());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/MsgBodyOuterClass$MsgBody_TEXTOrBuilder.class */
    public interface MsgBody_TEXTOrBuilder extends MessageOrBuilder {
        String getContents();

        ByteString getContentsBytes();

        MsgBodyExtraOuterClass.MsgBodyExtra getExtra();

        MsgBodyExtraOuterClass.MsgBodyExtraOrBuilder getExtraOrBuilder();

        MsgBodyExtraOuterClass.Profile getProfile();

        MsgBodyExtraOuterClass.ProfileOrBuilder getProfileOrBuilder();

        boolean hasExtra();

        boolean hasProfile();
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/MsgBodyOuterClass$MsgExtra.class */
    public static final class MsgExtra extends GeneratedMessageV3 implements MsgExtraOrBuilder {
        public static final int ACTIVITY_SHARE_EXTRA_FIELD_NUMBER = 24;
        public static final int DOODLE_SHARE_EXTRA_FIELD_NUMBER = 20;
        public static final int EVALUATION_EXTRA_FIELD_NUMBER = 22;
        public static final int FEED_SHARE_EXTRA_FIELD_NUMBER = 16;
        public static final int FRIENDS_CIRCLE_EXTRA_FIELD_NUMBER = 25;
        public static final int GIFT_EXTRA_FIELD_NUMBER = 12;
        public static final int GROUP_CARD_EXTRA_FIELD_NUMBER = 5;
        public static final int GROUP_NOTICE_FIELD_NUMBER = 21;
        public static final int HIDEN_ALBUM_EXTRA_FIELD_NUMBER = 8;
        public static final int IMAGETEXT_EXTRA_FIELD_NUMBER = 7;
        public static final int IMG_EXTRA_FIELD_NUMBER = 2;
        public static final int LIVE_SHARE_EXTRA_FIELD_NUMBER = 6;
        public static final int LIVE_SHARE_INTERNATIONAL_EXTRA_FIELD_NUMBER = 19;
        public static final int LOCATION_EXTRA_FIELD_NUMBER = 3;
        public static final int SAY_HI_EXTRA_FIELD_NUMBER = 17;
        public static final int SECURENOTIFY_FIELD_NUMBER = 23;
        public static final int SHARE_EXTRA_FIELD_NUMBER = 10;
        public static final int SYS_NOTICE_EXTRA_FIELD_NUMBER = 13;
        public static final int TEXT_EXTRA_FIELD_NUMBER = 1;
        public static final int VIDEO_CALLING_EXTRA_FIELD_NUMBER = 14;
        public static final int VIDEO_END_EXTRA_FIELD_NUMBER = 15;
        public static final int VIDEO_EXTRA_FIELD_NUMBER = 4;
        public static final int VIP_EXTRA_FIELD_NUMBER = 11;
        public static final int VOICE_ROOM_SHARE_EXTRA_FIELD_NUMBER = 18;
        private static final long serialVersionUID = 0;
        private MsgBodyExtraOuterClass.ActivityShareExtra activityShareExtra_;
        private MsgBodyExtraOuterClass.DoodleShareExtra doodleShareExtra_;
        private MsgBodyExtraOuterClass.EvaluationExtra evaluationExtra_;
        private MsgBodyExtraOuterClass.FeedShareExtra feedShareExtra_;
        private MsgBodyExtraOuterClass.FriendsCircleExtra friendsCircleExtra_;
        private MsgBodyExtraOuterClass.GiftExtra giftExtra_;
        private MsgBodyExtraOuterClass.GroupCardExtra groupCardExtra_;
        private MsgBodyExtraOuterClass.GroupNotice groupNotice_;
        private MsgBodyExtraOuterClass.HidenAlbumExtra hidenAlbumExtra_;
        private MsgBodyExtraOuterClass.ImageTextExtra imagetextExtra_;
        private MsgBodyExtraOuterClass.ImgExtra imgExtra_;
        private MsgBodyExtraOuterClass.LiveShareExtra liveShareExtra_;
        private MsgBodyExtraOuterClass.LiveShareInternationalExtra liveShareInternationalExtra_;
        private MsgBodyExtraOuterClass.LocationExtra locationExtra_;
        private byte memoizedIsInitialized;
        private MsgBodyExtraOuterClass.SayHiExtra sayHiExtra_;
        private MsgBodyExtraOuterClass.SecureNotify secureNotify_;
        private MsgBodyExtraOuterClass.ShareExtra shareExtra_;
        private MsgBodyExtraOuterClass.SysNoticeExtra sysNoticeExtra_;
        private MsgBodyExtraOuterClass.TextExtra textExtra_;
        private MsgBodyExtraOuterClass.VideoChatCallingExtra videoCallingExtra_;
        private MsgBodyExtraOuterClass.VideoChatEndExtra videoEndExtra_;
        private MsgBodyExtraOuterClass.VideoExtra videoExtra_;
        private MsgBodyExtraOuterClass.VipExtra vipExtra_;
        private MsgBodyExtraOuterClass.VoiceRoomShareExtra voiceRoomShareExtra_;
        private static final MsgExtra DEFAULT_INSTANCE = new MsgExtra();
        private static final Parser<MsgExtra> PARSER = new AbstractParser<MsgExtra>() { // from class: com.blued.im.private_chat.MsgBodyOuterClass.MsgExtra.1
            @Override // com.google.protobuf.Parser
            public MsgExtra parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new MsgExtra(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/MsgBodyOuterClass$MsgExtra$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MsgExtraOrBuilder {
            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.ActivityShareExtra, MsgBodyExtraOuterClass.ActivityShareExtra.Builder, MsgBodyExtraOuterClass.ActivityShareExtraOrBuilder> activityShareExtraBuilder_;
            private MsgBodyExtraOuterClass.ActivityShareExtra activityShareExtra_;
            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.DoodleShareExtra, MsgBodyExtraOuterClass.DoodleShareExtra.Builder, MsgBodyExtraOuterClass.DoodleShareExtraOrBuilder> doodleShareExtraBuilder_;
            private MsgBodyExtraOuterClass.DoodleShareExtra doodleShareExtra_;
            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.EvaluationExtra, MsgBodyExtraOuterClass.EvaluationExtra.Builder, MsgBodyExtraOuterClass.EvaluationExtraOrBuilder> evaluationExtraBuilder_;
            private MsgBodyExtraOuterClass.EvaluationExtra evaluationExtra_;
            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.FeedShareExtra, MsgBodyExtraOuterClass.FeedShareExtra.Builder, MsgBodyExtraOuterClass.FeedShareExtraOrBuilder> feedShareExtraBuilder_;
            private MsgBodyExtraOuterClass.FeedShareExtra feedShareExtra_;
            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.FriendsCircleExtra, MsgBodyExtraOuterClass.FriendsCircleExtra.Builder, MsgBodyExtraOuterClass.FriendsCircleExtraOrBuilder> friendsCircleExtraBuilder_;
            private MsgBodyExtraOuterClass.FriendsCircleExtra friendsCircleExtra_;
            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.GiftExtra, MsgBodyExtraOuterClass.GiftExtra.Builder, MsgBodyExtraOuterClass.GiftExtraOrBuilder> giftExtraBuilder_;
            private MsgBodyExtraOuterClass.GiftExtra giftExtra_;
            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupCardExtra, MsgBodyExtraOuterClass.GroupCardExtra.Builder, MsgBodyExtraOuterClass.GroupCardExtraOrBuilder> groupCardExtraBuilder_;
            private MsgBodyExtraOuterClass.GroupCardExtra groupCardExtra_;
            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupNotice, MsgBodyExtraOuterClass.GroupNotice.Builder, MsgBodyExtraOuterClass.GroupNoticeOrBuilder> groupNoticeBuilder_;
            private MsgBodyExtraOuterClass.GroupNotice groupNotice_;
            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.HidenAlbumExtra, MsgBodyExtraOuterClass.HidenAlbumExtra.Builder, MsgBodyExtraOuterClass.HidenAlbumExtraOrBuilder> hidenAlbumExtraBuilder_;
            private MsgBodyExtraOuterClass.HidenAlbumExtra hidenAlbumExtra_;
            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImageTextExtra, MsgBodyExtraOuterClass.ImageTextExtra.Builder, MsgBodyExtraOuterClass.ImageTextExtraOrBuilder> imagetextExtraBuilder_;
            private MsgBodyExtraOuterClass.ImageTextExtra imagetextExtra_;
            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImgExtra, MsgBodyExtraOuterClass.ImgExtra.Builder, MsgBodyExtraOuterClass.ImgExtraOrBuilder> imgExtraBuilder_;
            private MsgBodyExtraOuterClass.ImgExtra imgExtra_;
            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareExtra, MsgBodyExtraOuterClass.LiveShareExtra.Builder, MsgBodyExtraOuterClass.LiveShareExtraOrBuilder> liveShareExtraBuilder_;
            private MsgBodyExtraOuterClass.LiveShareExtra liveShareExtra_;
            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareInternationalExtra, MsgBodyExtraOuterClass.LiveShareInternationalExtra.Builder, MsgBodyExtraOuterClass.LiveShareInternationalExtraOrBuilder> liveShareInternationalExtraBuilder_;
            private MsgBodyExtraOuterClass.LiveShareInternationalExtra liveShareInternationalExtra_;
            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.LocationExtra, MsgBodyExtraOuterClass.LocationExtra.Builder, MsgBodyExtraOuterClass.LocationExtraOrBuilder> locationExtraBuilder_;
            private MsgBodyExtraOuterClass.LocationExtra locationExtra_;
            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.SayHiExtra, MsgBodyExtraOuterClass.SayHiExtra.Builder, MsgBodyExtraOuterClass.SayHiExtraOrBuilder> sayHiExtraBuilder_;
            private MsgBodyExtraOuterClass.SayHiExtra sayHiExtra_;
            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.SecureNotify, MsgBodyExtraOuterClass.SecureNotify.Builder, MsgBodyExtraOuterClass.SecureNotifyOrBuilder> secureNotifyBuilder_;
            private MsgBodyExtraOuterClass.SecureNotify secureNotify_;
            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.ShareExtra, MsgBodyExtraOuterClass.ShareExtra.Builder, MsgBodyExtraOuterClass.ShareExtraOrBuilder> shareExtraBuilder_;
            private MsgBodyExtraOuterClass.ShareExtra shareExtra_;
            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.SysNoticeExtra, MsgBodyExtraOuterClass.SysNoticeExtra.Builder, MsgBodyExtraOuterClass.SysNoticeExtraOrBuilder> sysNoticeExtraBuilder_;
            private MsgBodyExtraOuterClass.SysNoticeExtra sysNoticeExtra_;
            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.TextExtra, MsgBodyExtraOuterClass.TextExtra.Builder, MsgBodyExtraOuterClass.TextExtraOrBuilder> textExtraBuilder_;
            private MsgBodyExtraOuterClass.TextExtra textExtra_;
            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatCallingExtra, MsgBodyExtraOuterClass.VideoChatCallingExtra.Builder, MsgBodyExtraOuterClass.VideoChatCallingExtraOrBuilder> videoCallingExtraBuilder_;
            private MsgBodyExtraOuterClass.VideoChatCallingExtra videoCallingExtra_;
            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatEndExtra, MsgBodyExtraOuterClass.VideoChatEndExtra.Builder, MsgBodyExtraOuterClass.VideoChatEndExtraOrBuilder> videoEndExtraBuilder_;
            private MsgBodyExtraOuterClass.VideoChatEndExtra videoEndExtra_;
            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoExtra, MsgBodyExtraOuterClass.VideoExtra.Builder, MsgBodyExtraOuterClass.VideoExtraOrBuilder> videoExtraBuilder_;
            private MsgBodyExtraOuterClass.VideoExtra videoExtra_;
            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.VipExtra, MsgBodyExtraOuterClass.VipExtra.Builder, MsgBodyExtraOuterClass.VipExtraOrBuilder> vipExtraBuilder_;
            private MsgBodyExtraOuterClass.VipExtra vipExtra_;
            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.VoiceRoomShareExtra, MsgBodyExtraOuterClass.VoiceRoomShareExtra.Builder, MsgBodyExtraOuterClass.VoiceRoomShareExtraOrBuilder> voiceRoomShareExtraBuilder_;
            private MsgBodyExtraOuterClass.VoiceRoomShareExtra voiceRoomShareExtra_;

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.ActivityShareExtra, MsgBodyExtraOuterClass.ActivityShareExtra.Builder, MsgBodyExtraOuterClass.ActivityShareExtraOrBuilder> getActivityShareExtraFieldBuilder() {
                if (this.activityShareExtraBuilder_ == null) {
                    this.activityShareExtraBuilder_ = new SingleFieldBuilderV3<>(getActivityShareExtra(), getParentForChildren(), isClean());
                    this.activityShareExtra_ = null;
                }
                return this.activityShareExtraBuilder_;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return MsgBodyOuterClass.internal_static_com_blued_im_private_chat_MsgExtra_descriptor;
            }

            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.DoodleShareExtra, MsgBodyExtraOuterClass.DoodleShareExtra.Builder, MsgBodyExtraOuterClass.DoodleShareExtraOrBuilder> getDoodleShareExtraFieldBuilder() {
                if (this.doodleShareExtraBuilder_ == null) {
                    this.doodleShareExtraBuilder_ = new SingleFieldBuilderV3<>(getDoodleShareExtra(), getParentForChildren(), isClean());
                    this.doodleShareExtra_ = null;
                }
                return this.doodleShareExtraBuilder_;
            }

            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.EvaluationExtra, MsgBodyExtraOuterClass.EvaluationExtra.Builder, MsgBodyExtraOuterClass.EvaluationExtraOrBuilder> getEvaluationExtraFieldBuilder() {
                if (this.evaluationExtraBuilder_ == null) {
                    this.evaluationExtraBuilder_ = new SingleFieldBuilderV3<>(getEvaluationExtra(), getParentForChildren(), isClean());
                    this.evaluationExtra_ = null;
                }
                return this.evaluationExtraBuilder_;
            }

            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.FeedShareExtra, MsgBodyExtraOuterClass.FeedShareExtra.Builder, MsgBodyExtraOuterClass.FeedShareExtraOrBuilder> getFeedShareExtraFieldBuilder() {
                if (this.feedShareExtraBuilder_ == null) {
                    this.feedShareExtraBuilder_ = new SingleFieldBuilderV3<>(getFeedShareExtra(), getParentForChildren(), isClean());
                    this.feedShareExtra_ = null;
                }
                return this.feedShareExtraBuilder_;
            }

            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.FriendsCircleExtra, MsgBodyExtraOuterClass.FriendsCircleExtra.Builder, MsgBodyExtraOuterClass.FriendsCircleExtraOrBuilder> getFriendsCircleExtraFieldBuilder() {
                if (this.friendsCircleExtraBuilder_ == null) {
                    this.friendsCircleExtraBuilder_ = new SingleFieldBuilderV3<>(getFriendsCircleExtra(), getParentForChildren(), isClean());
                    this.friendsCircleExtra_ = null;
                }
                return this.friendsCircleExtraBuilder_;
            }

            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.GiftExtra, MsgBodyExtraOuterClass.GiftExtra.Builder, MsgBodyExtraOuterClass.GiftExtraOrBuilder> getGiftExtraFieldBuilder() {
                if (this.giftExtraBuilder_ == null) {
                    this.giftExtraBuilder_ = new SingleFieldBuilderV3<>(getGiftExtra(), getParentForChildren(), isClean());
                    this.giftExtra_ = null;
                }
                return this.giftExtraBuilder_;
            }

            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupCardExtra, MsgBodyExtraOuterClass.GroupCardExtra.Builder, MsgBodyExtraOuterClass.GroupCardExtraOrBuilder> getGroupCardExtraFieldBuilder() {
                if (this.groupCardExtraBuilder_ == null) {
                    this.groupCardExtraBuilder_ = new SingleFieldBuilderV3<>(getGroupCardExtra(), getParentForChildren(), isClean());
                    this.groupCardExtra_ = null;
                }
                return this.groupCardExtraBuilder_;
            }

            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupNotice, MsgBodyExtraOuterClass.GroupNotice.Builder, MsgBodyExtraOuterClass.GroupNoticeOrBuilder> getGroupNoticeFieldBuilder() {
                if (this.groupNoticeBuilder_ == null) {
                    this.groupNoticeBuilder_ = new SingleFieldBuilderV3<>(getGroupNotice(), getParentForChildren(), isClean());
                    this.groupNotice_ = null;
                }
                return this.groupNoticeBuilder_;
            }

            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.HidenAlbumExtra, MsgBodyExtraOuterClass.HidenAlbumExtra.Builder, MsgBodyExtraOuterClass.HidenAlbumExtraOrBuilder> getHidenAlbumExtraFieldBuilder() {
                if (this.hidenAlbumExtraBuilder_ == null) {
                    this.hidenAlbumExtraBuilder_ = new SingleFieldBuilderV3<>(getHidenAlbumExtra(), getParentForChildren(), isClean());
                    this.hidenAlbumExtra_ = null;
                }
                return this.hidenAlbumExtraBuilder_;
            }

            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImageTextExtra, MsgBodyExtraOuterClass.ImageTextExtra.Builder, MsgBodyExtraOuterClass.ImageTextExtraOrBuilder> getImagetextExtraFieldBuilder() {
                if (this.imagetextExtraBuilder_ == null) {
                    this.imagetextExtraBuilder_ = new SingleFieldBuilderV3<>(getImagetextExtra(), getParentForChildren(), isClean());
                    this.imagetextExtra_ = null;
                }
                return this.imagetextExtraBuilder_;
            }

            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImgExtra, MsgBodyExtraOuterClass.ImgExtra.Builder, MsgBodyExtraOuterClass.ImgExtraOrBuilder> getImgExtraFieldBuilder() {
                if (this.imgExtraBuilder_ == null) {
                    this.imgExtraBuilder_ = new SingleFieldBuilderV3<>(getImgExtra(), getParentForChildren(), isClean());
                    this.imgExtra_ = null;
                }
                return this.imgExtraBuilder_;
            }

            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareExtra, MsgBodyExtraOuterClass.LiveShareExtra.Builder, MsgBodyExtraOuterClass.LiveShareExtraOrBuilder> getLiveShareExtraFieldBuilder() {
                if (this.liveShareExtraBuilder_ == null) {
                    this.liveShareExtraBuilder_ = new SingleFieldBuilderV3<>(getLiveShareExtra(), getParentForChildren(), isClean());
                    this.liveShareExtra_ = null;
                }
                return this.liveShareExtraBuilder_;
            }

            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareInternationalExtra, MsgBodyExtraOuterClass.LiveShareInternationalExtra.Builder, MsgBodyExtraOuterClass.LiveShareInternationalExtraOrBuilder> getLiveShareInternationalExtraFieldBuilder() {
                if (this.liveShareInternationalExtraBuilder_ == null) {
                    this.liveShareInternationalExtraBuilder_ = new SingleFieldBuilderV3<>(getLiveShareInternationalExtra(), getParentForChildren(), isClean());
                    this.liveShareInternationalExtra_ = null;
                }
                return this.liveShareInternationalExtraBuilder_;
            }

            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.LocationExtra, MsgBodyExtraOuterClass.LocationExtra.Builder, MsgBodyExtraOuterClass.LocationExtraOrBuilder> getLocationExtraFieldBuilder() {
                if (this.locationExtraBuilder_ == null) {
                    this.locationExtraBuilder_ = new SingleFieldBuilderV3<>(getLocationExtra(), getParentForChildren(), isClean());
                    this.locationExtra_ = null;
                }
                return this.locationExtraBuilder_;
            }

            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.SayHiExtra, MsgBodyExtraOuterClass.SayHiExtra.Builder, MsgBodyExtraOuterClass.SayHiExtraOrBuilder> getSayHiExtraFieldBuilder() {
                if (this.sayHiExtraBuilder_ == null) {
                    this.sayHiExtraBuilder_ = new SingleFieldBuilderV3<>(getSayHiExtra(), getParentForChildren(), isClean());
                    this.sayHiExtra_ = null;
                }
                return this.sayHiExtraBuilder_;
            }

            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.SecureNotify, MsgBodyExtraOuterClass.SecureNotify.Builder, MsgBodyExtraOuterClass.SecureNotifyOrBuilder> getSecureNotifyFieldBuilder() {
                if (this.secureNotifyBuilder_ == null) {
                    this.secureNotifyBuilder_ = new SingleFieldBuilderV3<>(getSecureNotify(), getParentForChildren(), isClean());
                    this.secureNotify_ = null;
                }
                return this.secureNotifyBuilder_;
            }

            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.ShareExtra, MsgBodyExtraOuterClass.ShareExtra.Builder, MsgBodyExtraOuterClass.ShareExtraOrBuilder> getShareExtraFieldBuilder() {
                if (this.shareExtraBuilder_ == null) {
                    this.shareExtraBuilder_ = new SingleFieldBuilderV3<>(getShareExtra(), getParentForChildren(), isClean());
                    this.shareExtra_ = null;
                }
                return this.shareExtraBuilder_;
            }

            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.SysNoticeExtra, MsgBodyExtraOuterClass.SysNoticeExtra.Builder, MsgBodyExtraOuterClass.SysNoticeExtraOrBuilder> getSysNoticeExtraFieldBuilder() {
                if (this.sysNoticeExtraBuilder_ == null) {
                    this.sysNoticeExtraBuilder_ = new SingleFieldBuilderV3<>(getSysNoticeExtra(), getParentForChildren(), isClean());
                    this.sysNoticeExtra_ = null;
                }
                return this.sysNoticeExtraBuilder_;
            }

            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.TextExtra, MsgBodyExtraOuterClass.TextExtra.Builder, MsgBodyExtraOuterClass.TextExtraOrBuilder> getTextExtraFieldBuilder() {
                if (this.textExtraBuilder_ == null) {
                    this.textExtraBuilder_ = new SingleFieldBuilderV3<>(getTextExtra(), getParentForChildren(), isClean());
                    this.textExtra_ = null;
                }
                return this.textExtraBuilder_;
            }

            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatCallingExtra, MsgBodyExtraOuterClass.VideoChatCallingExtra.Builder, MsgBodyExtraOuterClass.VideoChatCallingExtraOrBuilder> getVideoCallingExtraFieldBuilder() {
                if (this.videoCallingExtraBuilder_ == null) {
                    this.videoCallingExtraBuilder_ = new SingleFieldBuilderV3<>(getVideoCallingExtra(), getParentForChildren(), isClean());
                    this.videoCallingExtra_ = null;
                }
                return this.videoCallingExtraBuilder_;
            }

            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatEndExtra, MsgBodyExtraOuterClass.VideoChatEndExtra.Builder, MsgBodyExtraOuterClass.VideoChatEndExtraOrBuilder> getVideoEndExtraFieldBuilder() {
                if (this.videoEndExtraBuilder_ == null) {
                    this.videoEndExtraBuilder_ = new SingleFieldBuilderV3<>(getVideoEndExtra(), getParentForChildren(), isClean());
                    this.videoEndExtra_ = null;
                }
                return this.videoEndExtraBuilder_;
            }

            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoExtra, MsgBodyExtraOuterClass.VideoExtra.Builder, MsgBodyExtraOuterClass.VideoExtraOrBuilder> getVideoExtraFieldBuilder() {
                if (this.videoExtraBuilder_ == null) {
                    this.videoExtraBuilder_ = new SingleFieldBuilderV3<>(getVideoExtra(), getParentForChildren(), isClean());
                    this.videoExtra_ = null;
                }
                return this.videoExtraBuilder_;
            }

            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.VipExtra, MsgBodyExtraOuterClass.VipExtra.Builder, MsgBodyExtraOuterClass.VipExtraOrBuilder> getVipExtraFieldBuilder() {
                if (this.vipExtraBuilder_ == null) {
                    this.vipExtraBuilder_ = new SingleFieldBuilderV3<>(getVipExtra(), getParentForChildren(), isClean());
                    this.vipExtra_ = null;
                }
                return this.vipExtraBuilder_;
            }

            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.VoiceRoomShareExtra, MsgBodyExtraOuterClass.VoiceRoomShareExtra.Builder, MsgBodyExtraOuterClass.VoiceRoomShareExtraOrBuilder> getVoiceRoomShareExtraFieldBuilder() {
                if (this.voiceRoomShareExtraBuilder_ == null) {
                    this.voiceRoomShareExtraBuilder_ = new SingleFieldBuilderV3<>(getVoiceRoomShareExtra(), getParentForChildren(), isClean());
                    this.voiceRoomShareExtra_ = null;
                }
                return this.voiceRoomShareExtraBuilder_;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = MsgExtra.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MsgExtra build() {
                MsgExtra buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MsgExtra buildPartial() {
                MsgExtra msgExtra = new MsgExtra(this);
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.TextExtra, MsgBodyExtraOuterClass.TextExtra.Builder, MsgBodyExtraOuterClass.TextExtraOrBuilder> singleFieldBuilderV3 = this.textExtraBuilder_;
                if (singleFieldBuilderV3 == null) {
                    msgExtra.textExtra_ = this.textExtra_;
                } else {
                    msgExtra.textExtra_ = singleFieldBuilderV3.build();
                }
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImgExtra, MsgBodyExtraOuterClass.ImgExtra.Builder, MsgBodyExtraOuterClass.ImgExtraOrBuilder> singleFieldBuilderV32 = this.imgExtraBuilder_;
                if (singleFieldBuilderV32 == null) {
                    msgExtra.imgExtra_ = this.imgExtra_;
                } else {
                    msgExtra.imgExtra_ = singleFieldBuilderV32.build();
                }
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.LocationExtra, MsgBodyExtraOuterClass.LocationExtra.Builder, MsgBodyExtraOuterClass.LocationExtraOrBuilder> singleFieldBuilderV33 = this.locationExtraBuilder_;
                if (singleFieldBuilderV33 == null) {
                    msgExtra.locationExtra_ = this.locationExtra_;
                } else {
                    msgExtra.locationExtra_ = singleFieldBuilderV33.build();
                }
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoExtra, MsgBodyExtraOuterClass.VideoExtra.Builder, MsgBodyExtraOuterClass.VideoExtraOrBuilder> singleFieldBuilderV34 = this.videoExtraBuilder_;
                if (singleFieldBuilderV34 == null) {
                    msgExtra.videoExtra_ = this.videoExtra_;
                } else {
                    msgExtra.videoExtra_ = singleFieldBuilderV34.build();
                }
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupCardExtra, MsgBodyExtraOuterClass.GroupCardExtra.Builder, MsgBodyExtraOuterClass.GroupCardExtraOrBuilder> singleFieldBuilderV35 = this.groupCardExtraBuilder_;
                if (singleFieldBuilderV35 == null) {
                    msgExtra.groupCardExtra_ = this.groupCardExtra_;
                } else {
                    msgExtra.groupCardExtra_ = singleFieldBuilderV35.build();
                }
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareExtra, MsgBodyExtraOuterClass.LiveShareExtra.Builder, MsgBodyExtraOuterClass.LiveShareExtraOrBuilder> singleFieldBuilderV36 = this.liveShareExtraBuilder_;
                if (singleFieldBuilderV36 == null) {
                    msgExtra.liveShareExtra_ = this.liveShareExtra_;
                } else {
                    msgExtra.liveShareExtra_ = singleFieldBuilderV36.build();
                }
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImageTextExtra, MsgBodyExtraOuterClass.ImageTextExtra.Builder, MsgBodyExtraOuterClass.ImageTextExtraOrBuilder> singleFieldBuilderV37 = this.imagetextExtraBuilder_;
                if (singleFieldBuilderV37 == null) {
                    msgExtra.imagetextExtra_ = this.imagetextExtra_;
                } else {
                    msgExtra.imagetextExtra_ = singleFieldBuilderV37.build();
                }
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.HidenAlbumExtra, MsgBodyExtraOuterClass.HidenAlbumExtra.Builder, MsgBodyExtraOuterClass.HidenAlbumExtraOrBuilder> singleFieldBuilderV38 = this.hidenAlbumExtraBuilder_;
                if (singleFieldBuilderV38 == null) {
                    msgExtra.hidenAlbumExtra_ = this.hidenAlbumExtra_;
                } else {
                    msgExtra.hidenAlbumExtra_ = singleFieldBuilderV38.build();
                }
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.ShareExtra, MsgBodyExtraOuterClass.ShareExtra.Builder, MsgBodyExtraOuterClass.ShareExtraOrBuilder> singleFieldBuilderV39 = this.shareExtraBuilder_;
                if (singleFieldBuilderV39 == null) {
                    msgExtra.shareExtra_ = this.shareExtra_;
                } else {
                    msgExtra.shareExtra_ = singleFieldBuilderV39.build();
                }
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.VipExtra, MsgBodyExtraOuterClass.VipExtra.Builder, MsgBodyExtraOuterClass.VipExtraOrBuilder> singleFieldBuilderV310 = this.vipExtraBuilder_;
                if (singleFieldBuilderV310 == null) {
                    msgExtra.vipExtra_ = this.vipExtra_;
                } else {
                    msgExtra.vipExtra_ = singleFieldBuilderV310.build();
                }
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.GiftExtra, MsgBodyExtraOuterClass.GiftExtra.Builder, MsgBodyExtraOuterClass.GiftExtraOrBuilder> singleFieldBuilderV311 = this.giftExtraBuilder_;
                if (singleFieldBuilderV311 == null) {
                    msgExtra.giftExtra_ = this.giftExtra_;
                } else {
                    msgExtra.giftExtra_ = singleFieldBuilderV311.build();
                }
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.SysNoticeExtra, MsgBodyExtraOuterClass.SysNoticeExtra.Builder, MsgBodyExtraOuterClass.SysNoticeExtraOrBuilder> singleFieldBuilderV312 = this.sysNoticeExtraBuilder_;
                if (singleFieldBuilderV312 == null) {
                    msgExtra.sysNoticeExtra_ = this.sysNoticeExtra_;
                } else {
                    msgExtra.sysNoticeExtra_ = singleFieldBuilderV312.build();
                }
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatCallingExtra, MsgBodyExtraOuterClass.VideoChatCallingExtra.Builder, MsgBodyExtraOuterClass.VideoChatCallingExtraOrBuilder> singleFieldBuilderV313 = this.videoCallingExtraBuilder_;
                if (singleFieldBuilderV313 == null) {
                    msgExtra.videoCallingExtra_ = this.videoCallingExtra_;
                } else {
                    msgExtra.videoCallingExtra_ = singleFieldBuilderV313.build();
                }
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatEndExtra, MsgBodyExtraOuterClass.VideoChatEndExtra.Builder, MsgBodyExtraOuterClass.VideoChatEndExtraOrBuilder> singleFieldBuilderV314 = this.videoEndExtraBuilder_;
                if (singleFieldBuilderV314 == null) {
                    msgExtra.videoEndExtra_ = this.videoEndExtra_;
                } else {
                    msgExtra.videoEndExtra_ = singleFieldBuilderV314.build();
                }
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.FeedShareExtra, MsgBodyExtraOuterClass.FeedShareExtra.Builder, MsgBodyExtraOuterClass.FeedShareExtraOrBuilder> singleFieldBuilderV315 = this.feedShareExtraBuilder_;
                if (singleFieldBuilderV315 == null) {
                    msgExtra.feedShareExtra_ = this.feedShareExtra_;
                } else {
                    msgExtra.feedShareExtra_ = singleFieldBuilderV315.build();
                }
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.SayHiExtra, MsgBodyExtraOuterClass.SayHiExtra.Builder, MsgBodyExtraOuterClass.SayHiExtraOrBuilder> singleFieldBuilderV316 = this.sayHiExtraBuilder_;
                if (singleFieldBuilderV316 == null) {
                    msgExtra.sayHiExtra_ = this.sayHiExtra_;
                } else {
                    msgExtra.sayHiExtra_ = singleFieldBuilderV316.build();
                }
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.VoiceRoomShareExtra, MsgBodyExtraOuterClass.VoiceRoomShareExtra.Builder, MsgBodyExtraOuterClass.VoiceRoomShareExtraOrBuilder> singleFieldBuilderV317 = this.voiceRoomShareExtraBuilder_;
                if (singleFieldBuilderV317 == null) {
                    msgExtra.voiceRoomShareExtra_ = this.voiceRoomShareExtra_;
                } else {
                    msgExtra.voiceRoomShareExtra_ = singleFieldBuilderV317.build();
                }
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareInternationalExtra, MsgBodyExtraOuterClass.LiveShareInternationalExtra.Builder, MsgBodyExtraOuterClass.LiveShareInternationalExtraOrBuilder> singleFieldBuilderV318 = this.liveShareInternationalExtraBuilder_;
                if (singleFieldBuilderV318 == null) {
                    msgExtra.liveShareInternationalExtra_ = this.liveShareInternationalExtra_;
                } else {
                    msgExtra.liveShareInternationalExtra_ = singleFieldBuilderV318.build();
                }
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.DoodleShareExtra, MsgBodyExtraOuterClass.DoodleShareExtra.Builder, MsgBodyExtraOuterClass.DoodleShareExtraOrBuilder> singleFieldBuilderV319 = this.doodleShareExtraBuilder_;
                if (singleFieldBuilderV319 == null) {
                    msgExtra.doodleShareExtra_ = this.doodleShareExtra_;
                } else {
                    msgExtra.doodleShareExtra_ = singleFieldBuilderV319.build();
                }
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupNotice, MsgBodyExtraOuterClass.GroupNotice.Builder, MsgBodyExtraOuterClass.GroupNoticeOrBuilder> singleFieldBuilderV320 = this.groupNoticeBuilder_;
                if (singleFieldBuilderV320 == null) {
                    msgExtra.groupNotice_ = this.groupNotice_;
                } else {
                    msgExtra.groupNotice_ = singleFieldBuilderV320.build();
                }
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.EvaluationExtra, MsgBodyExtraOuterClass.EvaluationExtra.Builder, MsgBodyExtraOuterClass.EvaluationExtraOrBuilder> singleFieldBuilderV321 = this.evaluationExtraBuilder_;
                if (singleFieldBuilderV321 == null) {
                    msgExtra.evaluationExtra_ = this.evaluationExtra_;
                } else {
                    msgExtra.evaluationExtra_ = singleFieldBuilderV321.build();
                }
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.SecureNotify, MsgBodyExtraOuterClass.SecureNotify.Builder, MsgBodyExtraOuterClass.SecureNotifyOrBuilder> singleFieldBuilderV322 = this.secureNotifyBuilder_;
                if (singleFieldBuilderV322 == null) {
                    msgExtra.secureNotify_ = this.secureNotify_;
                } else {
                    msgExtra.secureNotify_ = singleFieldBuilderV322.build();
                }
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.ActivityShareExtra, MsgBodyExtraOuterClass.ActivityShareExtra.Builder, MsgBodyExtraOuterClass.ActivityShareExtraOrBuilder> singleFieldBuilderV323 = this.activityShareExtraBuilder_;
                if (singleFieldBuilderV323 == null) {
                    msgExtra.activityShareExtra_ = this.activityShareExtra_;
                } else {
                    msgExtra.activityShareExtra_ = singleFieldBuilderV323.build();
                }
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.FriendsCircleExtra, MsgBodyExtraOuterClass.FriendsCircleExtra.Builder, MsgBodyExtraOuterClass.FriendsCircleExtraOrBuilder> singleFieldBuilderV324 = this.friendsCircleExtraBuilder_;
                if (singleFieldBuilderV324 == null) {
                    msgExtra.friendsCircleExtra_ = this.friendsCircleExtra_;
                } else {
                    msgExtra.friendsCircleExtra_ = singleFieldBuilderV324.build();
                }
                onBuilt();
                return msgExtra;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                if (this.textExtraBuilder_ == null) {
                    this.textExtra_ = null;
                } else {
                    this.textExtra_ = null;
                    this.textExtraBuilder_ = null;
                }
                if (this.imgExtraBuilder_ == null) {
                    this.imgExtra_ = null;
                } else {
                    this.imgExtra_ = null;
                    this.imgExtraBuilder_ = null;
                }
                if (this.locationExtraBuilder_ == null) {
                    this.locationExtra_ = null;
                } else {
                    this.locationExtra_ = null;
                    this.locationExtraBuilder_ = null;
                }
                if (this.videoExtraBuilder_ == null) {
                    this.videoExtra_ = null;
                } else {
                    this.videoExtra_ = null;
                    this.videoExtraBuilder_ = null;
                }
                if (this.groupCardExtraBuilder_ == null) {
                    this.groupCardExtra_ = null;
                } else {
                    this.groupCardExtra_ = null;
                    this.groupCardExtraBuilder_ = null;
                }
                if (this.liveShareExtraBuilder_ == null) {
                    this.liveShareExtra_ = null;
                } else {
                    this.liveShareExtra_ = null;
                    this.liveShareExtraBuilder_ = null;
                }
                if (this.imagetextExtraBuilder_ == null) {
                    this.imagetextExtra_ = null;
                } else {
                    this.imagetextExtra_ = null;
                    this.imagetextExtraBuilder_ = null;
                }
                if (this.hidenAlbumExtraBuilder_ == null) {
                    this.hidenAlbumExtra_ = null;
                } else {
                    this.hidenAlbumExtra_ = null;
                    this.hidenAlbumExtraBuilder_ = null;
                }
                if (this.shareExtraBuilder_ == null) {
                    this.shareExtra_ = null;
                } else {
                    this.shareExtra_ = null;
                    this.shareExtraBuilder_ = null;
                }
                if (this.vipExtraBuilder_ == null) {
                    this.vipExtra_ = null;
                } else {
                    this.vipExtra_ = null;
                    this.vipExtraBuilder_ = null;
                }
                if (this.giftExtraBuilder_ == null) {
                    this.giftExtra_ = null;
                } else {
                    this.giftExtra_ = null;
                    this.giftExtraBuilder_ = null;
                }
                if (this.sysNoticeExtraBuilder_ == null) {
                    this.sysNoticeExtra_ = null;
                } else {
                    this.sysNoticeExtra_ = null;
                    this.sysNoticeExtraBuilder_ = null;
                }
                if (this.videoCallingExtraBuilder_ == null) {
                    this.videoCallingExtra_ = null;
                } else {
                    this.videoCallingExtra_ = null;
                    this.videoCallingExtraBuilder_ = null;
                }
                if (this.videoEndExtraBuilder_ == null) {
                    this.videoEndExtra_ = null;
                } else {
                    this.videoEndExtra_ = null;
                    this.videoEndExtraBuilder_ = null;
                }
                if (this.feedShareExtraBuilder_ == null) {
                    this.feedShareExtra_ = null;
                } else {
                    this.feedShareExtra_ = null;
                    this.feedShareExtraBuilder_ = null;
                }
                if (this.sayHiExtraBuilder_ == null) {
                    this.sayHiExtra_ = null;
                } else {
                    this.sayHiExtra_ = null;
                    this.sayHiExtraBuilder_ = null;
                }
                if (this.voiceRoomShareExtraBuilder_ == null) {
                    this.voiceRoomShareExtra_ = null;
                } else {
                    this.voiceRoomShareExtra_ = null;
                    this.voiceRoomShareExtraBuilder_ = null;
                }
                if (this.liveShareInternationalExtraBuilder_ == null) {
                    this.liveShareInternationalExtra_ = null;
                } else {
                    this.liveShareInternationalExtra_ = null;
                    this.liveShareInternationalExtraBuilder_ = null;
                }
                if (this.doodleShareExtraBuilder_ == null) {
                    this.doodleShareExtra_ = null;
                } else {
                    this.doodleShareExtra_ = null;
                    this.doodleShareExtraBuilder_ = null;
                }
                if (this.groupNoticeBuilder_ == null) {
                    this.groupNotice_ = null;
                } else {
                    this.groupNotice_ = null;
                    this.groupNoticeBuilder_ = null;
                }
                if (this.evaluationExtraBuilder_ == null) {
                    this.evaluationExtra_ = null;
                } else {
                    this.evaluationExtra_ = null;
                    this.evaluationExtraBuilder_ = null;
                }
                if (this.secureNotifyBuilder_ == null) {
                    this.secureNotify_ = null;
                } else {
                    this.secureNotify_ = null;
                    this.secureNotifyBuilder_ = null;
                }
                if (this.activityShareExtraBuilder_ == null) {
                    this.activityShareExtra_ = null;
                } else {
                    this.activityShareExtra_ = null;
                    this.activityShareExtraBuilder_ = null;
                }
                if (this.friendsCircleExtraBuilder_ == null) {
                    this.friendsCircleExtra_ = null;
                    return this;
                }
                this.friendsCircleExtra_ = null;
                this.friendsCircleExtraBuilder_ = null;
                return this;
            }

            public Builder clearActivityShareExtra() {
                if (this.activityShareExtraBuilder_ == null) {
                    this.activityShareExtra_ = null;
                    onChanged();
                    return this;
                }
                this.activityShareExtra_ = null;
                this.activityShareExtraBuilder_ = null;
                return this;
            }

            public Builder clearDoodleShareExtra() {
                if (this.doodleShareExtraBuilder_ == null) {
                    this.doodleShareExtra_ = null;
                    onChanged();
                    return this;
                }
                this.doodleShareExtra_ = null;
                this.doodleShareExtraBuilder_ = null;
                return this;
            }

            public Builder clearEvaluationExtra() {
                if (this.evaluationExtraBuilder_ == null) {
                    this.evaluationExtra_ = null;
                    onChanged();
                    return this;
                }
                this.evaluationExtra_ = null;
                this.evaluationExtraBuilder_ = null;
                return this;
            }

            public Builder clearFeedShareExtra() {
                if (this.feedShareExtraBuilder_ == null) {
                    this.feedShareExtra_ = null;
                    onChanged();
                    return this;
                }
                this.feedShareExtra_ = null;
                this.feedShareExtraBuilder_ = null;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            public Builder clearFriendsCircleExtra() {
                if (this.friendsCircleExtraBuilder_ == null) {
                    this.friendsCircleExtra_ = null;
                    onChanged();
                    return this;
                }
                this.friendsCircleExtra_ = null;
                this.friendsCircleExtraBuilder_ = null;
                return this;
            }

            public Builder clearGiftExtra() {
                if (this.giftExtraBuilder_ == null) {
                    this.giftExtra_ = null;
                    onChanged();
                    return this;
                }
                this.giftExtra_ = null;
                this.giftExtraBuilder_ = null;
                return this;
            }

            public Builder clearGroupCardExtra() {
                if (this.groupCardExtraBuilder_ == null) {
                    this.groupCardExtra_ = null;
                    onChanged();
                    return this;
                }
                this.groupCardExtra_ = null;
                this.groupCardExtraBuilder_ = null;
                return this;
            }

            public Builder clearGroupNotice() {
                if (this.groupNoticeBuilder_ == null) {
                    this.groupNotice_ = null;
                    onChanged();
                    return this;
                }
                this.groupNotice_ = null;
                this.groupNoticeBuilder_ = null;
                return this;
            }

            public Builder clearHidenAlbumExtra() {
                if (this.hidenAlbumExtraBuilder_ == null) {
                    this.hidenAlbumExtra_ = null;
                    onChanged();
                    return this;
                }
                this.hidenAlbumExtra_ = null;
                this.hidenAlbumExtraBuilder_ = null;
                return this;
            }

            public Builder clearImagetextExtra() {
                if (this.imagetextExtraBuilder_ == null) {
                    this.imagetextExtra_ = null;
                    onChanged();
                    return this;
                }
                this.imagetextExtra_ = null;
                this.imagetextExtraBuilder_ = null;
                return this;
            }

            public Builder clearImgExtra() {
                if (this.imgExtraBuilder_ == null) {
                    this.imgExtra_ = null;
                    onChanged();
                    return this;
                }
                this.imgExtra_ = null;
                this.imgExtraBuilder_ = null;
                return this;
            }

            public Builder clearLiveShareExtra() {
                if (this.liveShareExtraBuilder_ == null) {
                    this.liveShareExtra_ = null;
                    onChanged();
                    return this;
                }
                this.liveShareExtra_ = null;
                this.liveShareExtraBuilder_ = null;
                return this;
            }

            public Builder clearLiveShareInternationalExtra() {
                if (this.liveShareInternationalExtraBuilder_ == null) {
                    this.liveShareInternationalExtra_ = null;
                    onChanged();
                    return this;
                }
                this.liveShareInternationalExtra_ = null;
                this.liveShareInternationalExtraBuilder_ = null;
                return this;
            }

            public Builder clearLocationExtra() {
                if (this.locationExtraBuilder_ == null) {
                    this.locationExtra_ = null;
                    onChanged();
                    return this;
                }
                this.locationExtra_ = null;
                this.locationExtraBuilder_ = null;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            public Builder clearSayHiExtra() {
                if (this.sayHiExtraBuilder_ == null) {
                    this.sayHiExtra_ = null;
                    onChanged();
                    return this;
                }
                this.sayHiExtra_ = null;
                this.sayHiExtraBuilder_ = null;
                return this;
            }

            public Builder clearSecureNotify() {
                if (this.secureNotifyBuilder_ == null) {
                    this.secureNotify_ = null;
                    onChanged();
                    return this;
                }
                this.secureNotify_ = null;
                this.secureNotifyBuilder_ = null;
                return this;
            }

            public Builder clearShareExtra() {
                if (this.shareExtraBuilder_ == null) {
                    this.shareExtra_ = null;
                    onChanged();
                    return this;
                }
                this.shareExtra_ = null;
                this.shareExtraBuilder_ = null;
                return this;
            }

            public Builder clearSysNoticeExtra() {
                if (this.sysNoticeExtraBuilder_ == null) {
                    this.sysNoticeExtra_ = null;
                    onChanged();
                    return this;
                }
                this.sysNoticeExtra_ = null;
                this.sysNoticeExtraBuilder_ = null;
                return this;
            }

            public Builder clearTextExtra() {
                if (this.textExtraBuilder_ == null) {
                    this.textExtra_ = null;
                    onChanged();
                    return this;
                }
                this.textExtra_ = null;
                this.textExtraBuilder_ = null;
                return this;
            }

            public Builder clearVideoCallingExtra() {
                if (this.videoCallingExtraBuilder_ == null) {
                    this.videoCallingExtra_ = null;
                    onChanged();
                    return this;
                }
                this.videoCallingExtra_ = null;
                this.videoCallingExtraBuilder_ = null;
                return this;
            }

            public Builder clearVideoEndExtra() {
                if (this.videoEndExtraBuilder_ == null) {
                    this.videoEndExtra_ = null;
                    onChanged();
                    return this;
                }
                this.videoEndExtra_ = null;
                this.videoEndExtraBuilder_ = null;
                return this;
            }

            public Builder clearVideoExtra() {
                if (this.videoExtraBuilder_ == null) {
                    this.videoExtra_ = null;
                    onChanged();
                    return this;
                }
                this.videoExtra_ = null;
                this.videoExtraBuilder_ = null;
                return this;
            }

            public Builder clearVipExtra() {
                if (this.vipExtraBuilder_ == null) {
                    this.vipExtra_ = null;
                    onChanged();
                    return this;
                }
                this.vipExtra_ = null;
                this.vipExtraBuilder_ = null;
                return this;
            }

            public Builder clearVoiceRoomShareExtra() {
                if (this.voiceRoomShareExtraBuilder_ == null) {
                    this.voiceRoomShareExtra_ = null;
                    onChanged();
                    return this;
                }
                this.voiceRoomShareExtra_ = null;
                this.voiceRoomShareExtraBuilder_ = null;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo2030clone() {
                return (Builder) super.mo2030clone();
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.ActivityShareExtra getActivityShareExtra() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.ActivityShareExtra, MsgBodyExtraOuterClass.ActivityShareExtra.Builder, MsgBodyExtraOuterClass.ActivityShareExtraOrBuilder> singleFieldBuilderV3 = this.activityShareExtraBuilder_;
                if (singleFieldBuilderV3 == null) {
                    MsgBodyExtraOuterClass.ActivityShareExtra activityShareExtra = this.activityShareExtra_;
                    MsgBodyExtraOuterClass.ActivityShareExtra activityShareExtra2 = activityShareExtra;
                    if (activityShareExtra == null) {
                        activityShareExtra2 = MsgBodyExtraOuterClass.ActivityShareExtra.getDefaultInstance();
                    }
                    return activityShareExtra2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public MsgBodyExtraOuterClass.ActivityShareExtra.Builder getActivityShareExtraBuilder() {
                onChanged();
                return getActivityShareExtraFieldBuilder().getBuilder();
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.ActivityShareExtraOrBuilder getActivityShareExtraOrBuilder() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.ActivityShareExtra, MsgBodyExtraOuterClass.ActivityShareExtra.Builder, MsgBodyExtraOuterClass.ActivityShareExtraOrBuilder> singleFieldBuilderV3 = this.activityShareExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                MsgBodyExtraOuterClass.ActivityShareExtra activityShareExtra = this.activityShareExtra_;
                MsgBodyExtraOuterClass.ActivityShareExtra activityShareExtra2 = activityShareExtra;
                if (activityShareExtra == null) {
                    activityShareExtra2 = MsgBodyExtraOuterClass.ActivityShareExtra.getDefaultInstance();
                }
                return activityShareExtra2;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MsgExtra getDefaultInstanceForType() {
                return MsgExtra.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MsgBodyOuterClass.internal_static_com_blued_im_private_chat_MsgExtra_descriptor;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.DoodleShareExtra getDoodleShareExtra() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.DoodleShareExtra, MsgBodyExtraOuterClass.DoodleShareExtra.Builder, MsgBodyExtraOuterClass.DoodleShareExtraOrBuilder> singleFieldBuilderV3 = this.doodleShareExtraBuilder_;
                if (singleFieldBuilderV3 == null) {
                    MsgBodyExtraOuterClass.DoodleShareExtra doodleShareExtra = this.doodleShareExtra_;
                    MsgBodyExtraOuterClass.DoodleShareExtra doodleShareExtra2 = doodleShareExtra;
                    if (doodleShareExtra == null) {
                        doodleShareExtra2 = MsgBodyExtraOuterClass.DoodleShareExtra.getDefaultInstance();
                    }
                    return doodleShareExtra2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public MsgBodyExtraOuterClass.DoodleShareExtra.Builder getDoodleShareExtraBuilder() {
                onChanged();
                return getDoodleShareExtraFieldBuilder().getBuilder();
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.DoodleShareExtraOrBuilder getDoodleShareExtraOrBuilder() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.DoodleShareExtra, MsgBodyExtraOuterClass.DoodleShareExtra.Builder, MsgBodyExtraOuterClass.DoodleShareExtraOrBuilder> singleFieldBuilderV3 = this.doodleShareExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                MsgBodyExtraOuterClass.DoodleShareExtra doodleShareExtra = this.doodleShareExtra_;
                MsgBodyExtraOuterClass.DoodleShareExtra doodleShareExtra2 = doodleShareExtra;
                if (doodleShareExtra == null) {
                    doodleShareExtra2 = MsgBodyExtraOuterClass.DoodleShareExtra.getDefaultInstance();
                }
                return doodleShareExtra2;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.EvaluationExtra getEvaluationExtra() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.EvaluationExtra, MsgBodyExtraOuterClass.EvaluationExtra.Builder, MsgBodyExtraOuterClass.EvaluationExtraOrBuilder> singleFieldBuilderV3 = this.evaluationExtraBuilder_;
                if (singleFieldBuilderV3 == null) {
                    MsgBodyExtraOuterClass.EvaluationExtra evaluationExtra = this.evaluationExtra_;
                    MsgBodyExtraOuterClass.EvaluationExtra evaluationExtra2 = evaluationExtra;
                    if (evaluationExtra == null) {
                        evaluationExtra2 = MsgBodyExtraOuterClass.EvaluationExtra.getDefaultInstance();
                    }
                    return evaluationExtra2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public MsgBodyExtraOuterClass.EvaluationExtra.Builder getEvaluationExtraBuilder() {
                onChanged();
                return getEvaluationExtraFieldBuilder().getBuilder();
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.EvaluationExtraOrBuilder getEvaluationExtraOrBuilder() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.EvaluationExtra, MsgBodyExtraOuterClass.EvaluationExtra.Builder, MsgBodyExtraOuterClass.EvaluationExtraOrBuilder> singleFieldBuilderV3 = this.evaluationExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                MsgBodyExtraOuterClass.EvaluationExtra evaluationExtra = this.evaluationExtra_;
                MsgBodyExtraOuterClass.EvaluationExtra evaluationExtra2 = evaluationExtra;
                if (evaluationExtra == null) {
                    evaluationExtra2 = MsgBodyExtraOuterClass.EvaluationExtra.getDefaultInstance();
                }
                return evaluationExtra2;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.FeedShareExtra getFeedShareExtra() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.FeedShareExtra, MsgBodyExtraOuterClass.FeedShareExtra.Builder, MsgBodyExtraOuterClass.FeedShareExtraOrBuilder> singleFieldBuilderV3 = this.feedShareExtraBuilder_;
                if (singleFieldBuilderV3 == null) {
                    MsgBodyExtraOuterClass.FeedShareExtra feedShareExtra = this.feedShareExtra_;
                    MsgBodyExtraOuterClass.FeedShareExtra feedShareExtra2 = feedShareExtra;
                    if (feedShareExtra == null) {
                        feedShareExtra2 = MsgBodyExtraOuterClass.FeedShareExtra.getDefaultInstance();
                    }
                    return feedShareExtra2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public MsgBodyExtraOuterClass.FeedShareExtra.Builder getFeedShareExtraBuilder() {
                onChanged();
                return getFeedShareExtraFieldBuilder().getBuilder();
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.FeedShareExtraOrBuilder getFeedShareExtraOrBuilder() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.FeedShareExtra, MsgBodyExtraOuterClass.FeedShareExtra.Builder, MsgBodyExtraOuterClass.FeedShareExtraOrBuilder> singleFieldBuilderV3 = this.feedShareExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                MsgBodyExtraOuterClass.FeedShareExtra feedShareExtra = this.feedShareExtra_;
                MsgBodyExtraOuterClass.FeedShareExtra feedShareExtra2 = feedShareExtra;
                if (feedShareExtra == null) {
                    feedShareExtra2 = MsgBodyExtraOuterClass.FeedShareExtra.getDefaultInstance();
                }
                return feedShareExtra2;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.FriendsCircleExtra getFriendsCircleExtra() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.FriendsCircleExtra, MsgBodyExtraOuterClass.FriendsCircleExtra.Builder, MsgBodyExtraOuterClass.FriendsCircleExtraOrBuilder> singleFieldBuilderV3 = this.friendsCircleExtraBuilder_;
                if (singleFieldBuilderV3 == null) {
                    MsgBodyExtraOuterClass.FriendsCircleExtra friendsCircleExtra = this.friendsCircleExtra_;
                    MsgBodyExtraOuterClass.FriendsCircleExtra friendsCircleExtra2 = friendsCircleExtra;
                    if (friendsCircleExtra == null) {
                        friendsCircleExtra2 = MsgBodyExtraOuterClass.FriendsCircleExtra.getDefaultInstance();
                    }
                    return friendsCircleExtra2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public MsgBodyExtraOuterClass.FriendsCircleExtra.Builder getFriendsCircleExtraBuilder() {
                onChanged();
                return getFriendsCircleExtraFieldBuilder().getBuilder();
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.FriendsCircleExtraOrBuilder getFriendsCircleExtraOrBuilder() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.FriendsCircleExtra, MsgBodyExtraOuterClass.FriendsCircleExtra.Builder, MsgBodyExtraOuterClass.FriendsCircleExtraOrBuilder> singleFieldBuilderV3 = this.friendsCircleExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                MsgBodyExtraOuterClass.FriendsCircleExtra friendsCircleExtra = this.friendsCircleExtra_;
                MsgBodyExtraOuterClass.FriendsCircleExtra friendsCircleExtra2 = friendsCircleExtra;
                if (friendsCircleExtra == null) {
                    friendsCircleExtra2 = MsgBodyExtraOuterClass.FriendsCircleExtra.getDefaultInstance();
                }
                return friendsCircleExtra2;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.GiftExtra getGiftExtra() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.GiftExtra, MsgBodyExtraOuterClass.GiftExtra.Builder, MsgBodyExtraOuterClass.GiftExtraOrBuilder> singleFieldBuilderV3 = this.giftExtraBuilder_;
                if (singleFieldBuilderV3 == null) {
                    MsgBodyExtraOuterClass.GiftExtra giftExtra = this.giftExtra_;
                    MsgBodyExtraOuterClass.GiftExtra giftExtra2 = giftExtra;
                    if (giftExtra == null) {
                        giftExtra2 = MsgBodyExtraOuterClass.GiftExtra.getDefaultInstance();
                    }
                    return giftExtra2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public MsgBodyExtraOuterClass.GiftExtra.Builder getGiftExtraBuilder() {
                onChanged();
                return getGiftExtraFieldBuilder().getBuilder();
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.GiftExtraOrBuilder getGiftExtraOrBuilder() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.GiftExtra, MsgBodyExtraOuterClass.GiftExtra.Builder, MsgBodyExtraOuterClass.GiftExtraOrBuilder> singleFieldBuilderV3 = this.giftExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                MsgBodyExtraOuterClass.GiftExtra giftExtra = this.giftExtra_;
                MsgBodyExtraOuterClass.GiftExtra giftExtra2 = giftExtra;
                if (giftExtra == null) {
                    giftExtra2 = MsgBodyExtraOuterClass.GiftExtra.getDefaultInstance();
                }
                return giftExtra2;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.GroupCardExtra getGroupCardExtra() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupCardExtra, MsgBodyExtraOuterClass.GroupCardExtra.Builder, MsgBodyExtraOuterClass.GroupCardExtraOrBuilder> singleFieldBuilderV3 = this.groupCardExtraBuilder_;
                if (singleFieldBuilderV3 == null) {
                    MsgBodyExtraOuterClass.GroupCardExtra groupCardExtra = this.groupCardExtra_;
                    MsgBodyExtraOuterClass.GroupCardExtra groupCardExtra2 = groupCardExtra;
                    if (groupCardExtra == null) {
                        groupCardExtra2 = MsgBodyExtraOuterClass.GroupCardExtra.getDefaultInstance();
                    }
                    return groupCardExtra2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public MsgBodyExtraOuterClass.GroupCardExtra.Builder getGroupCardExtraBuilder() {
                onChanged();
                return getGroupCardExtraFieldBuilder().getBuilder();
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.GroupCardExtraOrBuilder getGroupCardExtraOrBuilder() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupCardExtra, MsgBodyExtraOuterClass.GroupCardExtra.Builder, MsgBodyExtraOuterClass.GroupCardExtraOrBuilder> singleFieldBuilderV3 = this.groupCardExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                MsgBodyExtraOuterClass.GroupCardExtra groupCardExtra = this.groupCardExtra_;
                MsgBodyExtraOuterClass.GroupCardExtra groupCardExtra2 = groupCardExtra;
                if (groupCardExtra == null) {
                    groupCardExtra2 = MsgBodyExtraOuterClass.GroupCardExtra.getDefaultInstance();
                }
                return groupCardExtra2;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.GroupNotice getGroupNotice() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupNotice, MsgBodyExtraOuterClass.GroupNotice.Builder, MsgBodyExtraOuterClass.GroupNoticeOrBuilder> singleFieldBuilderV3 = this.groupNoticeBuilder_;
                if (singleFieldBuilderV3 == null) {
                    MsgBodyExtraOuterClass.GroupNotice groupNotice = this.groupNotice_;
                    MsgBodyExtraOuterClass.GroupNotice groupNotice2 = groupNotice;
                    if (groupNotice == null) {
                        groupNotice2 = MsgBodyExtraOuterClass.GroupNotice.getDefaultInstance();
                    }
                    return groupNotice2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public MsgBodyExtraOuterClass.GroupNotice.Builder getGroupNoticeBuilder() {
                onChanged();
                return getGroupNoticeFieldBuilder().getBuilder();
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.GroupNoticeOrBuilder getGroupNoticeOrBuilder() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupNotice, MsgBodyExtraOuterClass.GroupNotice.Builder, MsgBodyExtraOuterClass.GroupNoticeOrBuilder> singleFieldBuilderV3 = this.groupNoticeBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                MsgBodyExtraOuterClass.GroupNotice groupNotice = this.groupNotice_;
                MsgBodyExtraOuterClass.GroupNotice groupNotice2 = groupNotice;
                if (groupNotice == null) {
                    groupNotice2 = MsgBodyExtraOuterClass.GroupNotice.getDefaultInstance();
                }
                return groupNotice2;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.HidenAlbumExtra getHidenAlbumExtra() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.HidenAlbumExtra, MsgBodyExtraOuterClass.HidenAlbumExtra.Builder, MsgBodyExtraOuterClass.HidenAlbumExtraOrBuilder> singleFieldBuilderV3 = this.hidenAlbumExtraBuilder_;
                if (singleFieldBuilderV3 == null) {
                    MsgBodyExtraOuterClass.HidenAlbumExtra hidenAlbumExtra = this.hidenAlbumExtra_;
                    MsgBodyExtraOuterClass.HidenAlbumExtra hidenAlbumExtra2 = hidenAlbumExtra;
                    if (hidenAlbumExtra == null) {
                        hidenAlbumExtra2 = MsgBodyExtraOuterClass.HidenAlbumExtra.getDefaultInstance();
                    }
                    return hidenAlbumExtra2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public MsgBodyExtraOuterClass.HidenAlbumExtra.Builder getHidenAlbumExtraBuilder() {
                onChanged();
                return getHidenAlbumExtraFieldBuilder().getBuilder();
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.HidenAlbumExtraOrBuilder getHidenAlbumExtraOrBuilder() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.HidenAlbumExtra, MsgBodyExtraOuterClass.HidenAlbumExtra.Builder, MsgBodyExtraOuterClass.HidenAlbumExtraOrBuilder> singleFieldBuilderV3 = this.hidenAlbumExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                MsgBodyExtraOuterClass.HidenAlbumExtra hidenAlbumExtra = this.hidenAlbumExtra_;
                MsgBodyExtraOuterClass.HidenAlbumExtra hidenAlbumExtra2 = hidenAlbumExtra;
                if (hidenAlbumExtra == null) {
                    hidenAlbumExtra2 = MsgBodyExtraOuterClass.HidenAlbumExtra.getDefaultInstance();
                }
                return hidenAlbumExtra2;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.ImageTextExtra getImagetextExtra() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImageTextExtra, MsgBodyExtraOuterClass.ImageTextExtra.Builder, MsgBodyExtraOuterClass.ImageTextExtraOrBuilder> singleFieldBuilderV3 = this.imagetextExtraBuilder_;
                if (singleFieldBuilderV3 == null) {
                    MsgBodyExtraOuterClass.ImageTextExtra imageTextExtra = this.imagetextExtra_;
                    MsgBodyExtraOuterClass.ImageTextExtra imageTextExtra2 = imageTextExtra;
                    if (imageTextExtra == null) {
                        imageTextExtra2 = MsgBodyExtraOuterClass.ImageTextExtra.getDefaultInstance();
                    }
                    return imageTextExtra2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public MsgBodyExtraOuterClass.ImageTextExtra.Builder getImagetextExtraBuilder() {
                onChanged();
                return getImagetextExtraFieldBuilder().getBuilder();
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.ImageTextExtraOrBuilder getImagetextExtraOrBuilder() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImageTextExtra, MsgBodyExtraOuterClass.ImageTextExtra.Builder, MsgBodyExtraOuterClass.ImageTextExtraOrBuilder> singleFieldBuilderV3 = this.imagetextExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                MsgBodyExtraOuterClass.ImageTextExtra imageTextExtra = this.imagetextExtra_;
                MsgBodyExtraOuterClass.ImageTextExtra imageTextExtra2 = imageTextExtra;
                if (imageTextExtra == null) {
                    imageTextExtra2 = MsgBodyExtraOuterClass.ImageTextExtra.getDefaultInstance();
                }
                return imageTextExtra2;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.ImgExtra getImgExtra() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImgExtra, MsgBodyExtraOuterClass.ImgExtra.Builder, MsgBodyExtraOuterClass.ImgExtraOrBuilder> singleFieldBuilderV3 = this.imgExtraBuilder_;
                if (singleFieldBuilderV3 == null) {
                    MsgBodyExtraOuterClass.ImgExtra imgExtra = this.imgExtra_;
                    MsgBodyExtraOuterClass.ImgExtra imgExtra2 = imgExtra;
                    if (imgExtra == null) {
                        imgExtra2 = MsgBodyExtraOuterClass.ImgExtra.getDefaultInstance();
                    }
                    return imgExtra2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public MsgBodyExtraOuterClass.ImgExtra.Builder getImgExtraBuilder() {
                onChanged();
                return getImgExtraFieldBuilder().getBuilder();
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.ImgExtraOrBuilder getImgExtraOrBuilder() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImgExtra, MsgBodyExtraOuterClass.ImgExtra.Builder, MsgBodyExtraOuterClass.ImgExtraOrBuilder> singleFieldBuilderV3 = this.imgExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                MsgBodyExtraOuterClass.ImgExtra imgExtra = this.imgExtra_;
                MsgBodyExtraOuterClass.ImgExtra imgExtra2 = imgExtra;
                if (imgExtra == null) {
                    imgExtra2 = MsgBodyExtraOuterClass.ImgExtra.getDefaultInstance();
                }
                return imgExtra2;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.LiveShareExtra getLiveShareExtra() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareExtra, MsgBodyExtraOuterClass.LiveShareExtra.Builder, MsgBodyExtraOuterClass.LiveShareExtraOrBuilder> singleFieldBuilderV3 = this.liveShareExtraBuilder_;
                if (singleFieldBuilderV3 == null) {
                    MsgBodyExtraOuterClass.LiveShareExtra liveShareExtra = this.liveShareExtra_;
                    MsgBodyExtraOuterClass.LiveShareExtra liveShareExtra2 = liveShareExtra;
                    if (liveShareExtra == null) {
                        liveShareExtra2 = MsgBodyExtraOuterClass.LiveShareExtra.getDefaultInstance();
                    }
                    return liveShareExtra2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public MsgBodyExtraOuterClass.LiveShareExtra.Builder getLiveShareExtraBuilder() {
                onChanged();
                return getLiveShareExtraFieldBuilder().getBuilder();
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.LiveShareExtraOrBuilder getLiveShareExtraOrBuilder() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareExtra, MsgBodyExtraOuterClass.LiveShareExtra.Builder, MsgBodyExtraOuterClass.LiveShareExtraOrBuilder> singleFieldBuilderV3 = this.liveShareExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                MsgBodyExtraOuterClass.LiveShareExtra liveShareExtra = this.liveShareExtra_;
                MsgBodyExtraOuterClass.LiveShareExtra liveShareExtra2 = liveShareExtra;
                if (liveShareExtra == null) {
                    liveShareExtra2 = MsgBodyExtraOuterClass.LiveShareExtra.getDefaultInstance();
                }
                return liveShareExtra2;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.LiveShareInternationalExtra getLiveShareInternationalExtra() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareInternationalExtra, MsgBodyExtraOuterClass.LiveShareInternationalExtra.Builder, MsgBodyExtraOuterClass.LiveShareInternationalExtraOrBuilder> singleFieldBuilderV3 = this.liveShareInternationalExtraBuilder_;
                if (singleFieldBuilderV3 == null) {
                    MsgBodyExtraOuterClass.LiveShareInternationalExtra liveShareInternationalExtra = this.liveShareInternationalExtra_;
                    MsgBodyExtraOuterClass.LiveShareInternationalExtra liveShareInternationalExtra2 = liveShareInternationalExtra;
                    if (liveShareInternationalExtra == null) {
                        liveShareInternationalExtra2 = MsgBodyExtraOuterClass.LiveShareInternationalExtra.getDefaultInstance();
                    }
                    return liveShareInternationalExtra2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public MsgBodyExtraOuterClass.LiveShareInternationalExtra.Builder getLiveShareInternationalExtraBuilder() {
                onChanged();
                return getLiveShareInternationalExtraFieldBuilder().getBuilder();
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.LiveShareInternationalExtraOrBuilder getLiveShareInternationalExtraOrBuilder() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareInternationalExtra, MsgBodyExtraOuterClass.LiveShareInternationalExtra.Builder, MsgBodyExtraOuterClass.LiveShareInternationalExtraOrBuilder> singleFieldBuilderV3 = this.liveShareInternationalExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                MsgBodyExtraOuterClass.LiveShareInternationalExtra liveShareInternationalExtra = this.liveShareInternationalExtra_;
                MsgBodyExtraOuterClass.LiveShareInternationalExtra liveShareInternationalExtra2 = liveShareInternationalExtra;
                if (liveShareInternationalExtra == null) {
                    liveShareInternationalExtra2 = MsgBodyExtraOuterClass.LiveShareInternationalExtra.getDefaultInstance();
                }
                return liveShareInternationalExtra2;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.LocationExtra getLocationExtra() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.LocationExtra, MsgBodyExtraOuterClass.LocationExtra.Builder, MsgBodyExtraOuterClass.LocationExtraOrBuilder> singleFieldBuilderV3 = this.locationExtraBuilder_;
                if (singleFieldBuilderV3 == null) {
                    MsgBodyExtraOuterClass.LocationExtra locationExtra = this.locationExtra_;
                    MsgBodyExtraOuterClass.LocationExtra locationExtra2 = locationExtra;
                    if (locationExtra == null) {
                        locationExtra2 = MsgBodyExtraOuterClass.LocationExtra.getDefaultInstance();
                    }
                    return locationExtra2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public MsgBodyExtraOuterClass.LocationExtra.Builder getLocationExtraBuilder() {
                onChanged();
                return getLocationExtraFieldBuilder().getBuilder();
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.LocationExtraOrBuilder getLocationExtraOrBuilder() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.LocationExtra, MsgBodyExtraOuterClass.LocationExtra.Builder, MsgBodyExtraOuterClass.LocationExtraOrBuilder> singleFieldBuilderV3 = this.locationExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                MsgBodyExtraOuterClass.LocationExtra locationExtra = this.locationExtra_;
                MsgBodyExtraOuterClass.LocationExtra locationExtra2 = locationExtra;
                if (locationExtra == null) {
                    locationExtra2 = MsgBodyExtraOuterClass.LocationExtra.getDefaultInstance();
                }
                return locationExtra2;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.SayHiExtra getSayHiExtra() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.SayHiExtra, MsgBodyExtraOuterClass.SayHiExtra.Builder, MsgBodyExtraOuterClass.SayHiExtraOrBuilder> singleFieldBuilderV3 = this.sayHiExtraBuilder_;
                if (singleFieldBuilderV3 == null) {
                    MsgBodyExtraOuterClass.SayHiExtra sayHiExtra = this.sayHiExtra_;
                    MsgBodyExtraOuterClass.SayHiExtra sayHiExtra2 = sayHiExtra;
                    if (sayHiExtra == null) {
                        sayHiExtra2 = MsgBodyExtraOuterClass.SayHiExtra.getDefaultInstance();
                    }
                    return sayHiExtra2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public MsgBodyExtraOuterClass.SayHiExtra.Builder getSayHiExtraBuilder() {
                onChanged();
                return getSayHiExtraFieldBuilder().getBuilder();
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.SayHiExtraOrBuilder getSayHiExtraOrBuilder() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.SayHiExtra, MsgBodyExtraOuterClass.SayHiExtra.Builder, MsgBodyExtraOuterClass.SayHiExtraOrBuilder> singleFieldBuilderV3 = this.sayHiExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                MsgBodyExtraOuterClass.SayHiExtra sayHiExtra = this.sayHiExtra_;
                MsgBodyExtraOuterClass.SayHiExtra sayHiExtra2 = sayHiExtra;
                if (sayHiExtra == null) {
                    sayHiExtra2 = MsgBodyExtraOuterClass.SayHiExtra.getDefaultInstance();
                }
                return sayHiExtra2;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.SecureNotify getSecureNotify() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.SecureNotify, MsgBodyExtraOuterClass.SecureNotify.Builder, MsgBodyExtraOuterClass.SecureNotifyOrBuilder> singleFieldBuilderV3 = this.secureNotifyBuilder_;
                if (singleFieldBuilderV3 == null) {
                    MsgBodyExtraOuterClass.SecureNotify secureNotify = this.secureNotify_;
                    MsgBodyExtraOuterClass.SecureNotify secureNotify2 = secureNotify;
                    if (secureNotify == null) {
                        secureNotify2 = MsgBodyExtraOuterClass.SecureNotify.getDefaultInstance();
                    }
                    return secureNotify2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public MsgBodyExtraOuterClass.SecureNotify.Builder getSecureNotifyBuilder() {
                onChanged();
                return getSecureNotifyFieldBuilder().getBuilder();
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.SecureNotifyOrBuilder getSecureNotifyOrBuilder() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.SecureNotify, MsgBodyExtraOuterClass.SecureNotify.Builder, MsgBodyExtraOuterClass.SecureNotifyOrBuilder> singleFieldBuilderV3 = this.secureNotifyBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                MsgBodyExtraOuterClass.SecureNotify secureNotify = this.secureNotify_;
                MsgBodyExtraOuterClass.SecureNotify secureNotify2 = secureNotify;
                if (secureNotify == null) {
                    secureNotify2 = MsgBodyExtraOuterClass.SecureNotify.getDefaultInstance();
                }
                return secureNotify2;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.ShareExtra getShareExtra() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.ShareExtra, MsgBodyExtraOuterClass.ShareExtra.Builder, MsgBodyExtraOuterClass.ShareExtraOrBuilder> singleFieldBuilderV3 = this.shareExtraBuilder_;
                if (singleFieldBuilderV3 == null) {
                    MsgBodyExtraOuterClass.ShareExtra shareExtra = this.shareExtra_;
                    MsgBodyExtraOuterClass.ShareExtra shareExtra2 = shareExtra;
                    if (shareExtra == null) {
                        shareExtra2 = MsgBodyExtraOuterClass.ShareExtra.getDefaultInstance();
                    }
                    return shareExtra2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public MsgBodyExtraOuterClass.ShareExtra.Builder getShareExtraBuilder() {
                onChanged();
                return getShareExtraFieldBuilder().getBuilder();
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.ShareExtraOrBuilder getShareExtraOrBuilder() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.ShareExtra, MsgBodyExtraOuterClass.ShareExtra.Builder, MsgBodyExtraOuterClass.ShareExtraOrBuilder> singleFieldBuilderV3 = this.shareExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                MsgBodyExtraOuterClass.ShareExtra shareExtra = this.shareExtra_;
                MsgBodyExtraOuterClass.ShareExtra shareExtra2 = shareExtra;
                if (shareExtra == null) {
                    shareExtra2 = MsgBodyExtraOuterClass.ShareExtra.getDefaultInstance();
                }
                return shareExtra2;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.SysNoticeExtra getSysNoticeExtra() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.SysNoticeExtra, MsgBodyExtraOuterClass.SysNoticeExtra.Builder, MsgBodyExtraOuterClass.SysNoticeExtraOrBuilder> singleFieldBuilderV3 = this.sysNoticeExtraBuilder_;
                if (singleFieldBuilderV3 == null) {
                    MsgBodyExtraOuterClass.SysNoticeExtra sysNoticeExtra = this.sysNoticeExtra_;
                    MsgBodyExtraOuterClass.SysNoticeExtra sysNoticeExtra2 = sysNoticeExtra;
                    if (sysNoticeExtra == null) {
                        sysNoticeExtra2 = MsgBodyExtraOuterClass.SysNoticeExtra.getDefaultInstance();
                    }
                    return sysNoticeExtra2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public MsgBodyExtraOuterClass.SysNoticeExtra.Builder getSysNoticeExtraBuilder() {
                onChanged();
                return getSysNoticeExtraFieldBuilder().getBuilder();
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.SysNoticeExtraOrBuilder getSysNoticeExtraOrBuilder() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.SysNoticeExtra, MsgBodyExtraOuterClass.SysNoticeExtra.Builder, MsgBodyExtraOuterClass.SysNoticeExtraOrBuilder> singleFieldBuilderV3 = this.sysNoticeExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                MsgBodyExtraOuterClass.SysNoticeExtra sysNoticeExtra = this.sysNoticeExtra_;
                MsgBodyExtraOuterClass.SysNoticeExtra sysNoticeExtra2 = sysNoticeExtra;
                if (sysNoticeExtra == null) {
                    sysNoticeExtra2 = MsgBodyExtraOuterClass.SysNoticeExtra.getDefaultInstance();
                }
                return sysNoticeExtra2;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.TextExtra getTextExtra() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.TextExtra, MsgBodyExtraOuterClass.TextExtra.Builder, MsgBodyExtraOuterClass.TextExtraOrBuilder> singleFieldBuilderV3 = this.textExtraBuilder_;
                if (singleFieldBuilderV3 == null) {
                    MsgBodyExtraOuterClass.TextExtra textExtra = this.textExtra_;
                    MsgBodyExtraOuterClass.TextExtra textExtra2 = textExtra;
                    if (textExtra == null) {
                        textExtra2 = MsgBodyExtraOuterClass.TextExtra.getDefaultInstance();
                    }
                    return textExtra2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public MsgBodyExtraOuterClass.TextExtra.Builder getTextExtraBuilder() {
                onChanged();
                return getTextExtraFieldBuilder().getBuilder();
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.TextExtraOrBuilder getTextExtraOrBuilder() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.TextExtra, MsgBodyExtraOuterClass.TextExtra.Builder, MsgBodyExtraOuterClass.TextExtraOrBuilder> singleFieldBuilderV3 = this.textExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                MsgBodyExtraOuterClass.TextExtra textExtra = this.textExtra_;
                MsgBodyExtraOuterClass.TextExtra textExtra2 = textExtra;
                if (textExtra == null) {
                    textExtra2 = MsgBodyExtraOuterClass.TextExtra.getDefaultInstance();
                }
                return textExtra2;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.VideoChatCallingExtra getVideoCallingExtra() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatCallingExtra, MsgBodyExtraOuterClass.VideoChatCallingExtra.Builder, MsgBodyExtraOuterClass.VideoChatCallingExtraOrBuilder> singleFieldBuilderV3 = this.videoCallingExtraBuilder_;
                if (singleFieldBuilderV3 == null) {
                    MsgBodyExtraOuterClass.VideoChatCallingExtra videoChatCallingExtra = this.videoCallingExtra_;
                    MsgBodyExtraOuterClass.VideoChatCallingExtra videoChatCallingExtra2 = videoChatCallingExtra;
                    if (videoChatCallingExtra == null) {
                        videoChatCallingExtra2 = MsgBodyExtraOuterClass.VideoChatCallingExtra.getDefaultInstance();
                    }
                    return videoChatCallingExtra2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public MsgBodyExtraOuterClass.VideoChatCallingExtra.Builder getVideoCallingExtraBuilder() {
                onChanged();
                return getVideoCallingExtraFieldBuilder().getBuilder();
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.VideoChatCallingExtraOrBuilder getVideoCallingExtraOrBuilder() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatCallingExtra, MsgBodyExtraOuterClass.VideoChatCallingExtra.Builder, MsgBodyExtraOuterClass.VideoChatCallingExtraOrBuilder> singleFieldBuilderV3 = this.videoCallingExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                MsgBodyExtraOuterClass.VideoChatCallingExtra videoChatCallingExtra = this.videoCallingExtra_;
                MsgBodyExtraOuterClass.VideoChatCallingExtra videoChatCallingExtra2 = videoChatCallingExtra;
                if (videoChatCallingExtra == null) {
                    videoChatCallingExtra2 = MsgBodyExtraOuterClass.VideoChatCallingExtra.getDefaultInstance();
                }
                return videoChatCallingExtra2;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.VideoChatEndExtra getVideoEndExtra() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatEndExtra, MsgBodyExtraOuterClass.VideoChatEndExtra.Builder, MsgBodyExtraOuterClass.VideoChatEndExtraOrBuilder> singleFieldBuilderV3 = this.videoEndExtraBuilder_;
                if (singleFieldBuilderV3 == null) {
                    MsgBodyExtraOuterClass.VideoChatEndExtra videoChatEndExtra = this.videoEndExtra_;
                    MsgBodyExtraOuterClass.VideoChatEndExtra videoChatEndExtra2 = videoChatEndExtra;
                    if (videoChatEndExtra == null) {
                        videoChatEndExtra2 = MsgBodyExtraOuterClass.VideoChatEndExtra.getDefaultInstance();
                    }
                    return videoChatEndExtra2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public MsgBodyExtraOuterClass.VideoChatEndExtra.Builder getVideoEndExtraBuilder() {
                onChanged();
                return getVideoEndExtraFieldBuilder().getBuilder();
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.VideoChatEndExtraOrBuilder getVideoEndExtraOrBuilder() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatEndExtra, MsgBodyExtraOuterClass.VideoChatEndExtra.Builder, MsgBodyExtraOuterClass.VideoChatEndExtraOrBuilder> singleFieldBuilderV3 = this.videoEndExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                MsgBodyExtraOuterClass.VideoChatEndExtra videoChatEndExtra = this.videoEndExtra_;
                MsgBodyExtraOuterClass.VideoChatEndExtra videoChatEndExtra2 = videoChatEndExtra;
                if (videoChatEndExtra == null) {
                    videoChatEndExtra2 = MsgBodyExtraOuterClass.VideoChatEndExtra.getDefaultInstance();
                }
                return videoChatEndExtra2;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.VideoExtra getVideoExtra() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoExtra, MsgBodyExtraOuterClass.VideoExtra.Builder, MsgBodyExtraOuterClass.VideoExtraOrBuilder> singleFieldBuilderV3 = this.videoExtraBuilder_;
                if (singleFieldBuilderV3 == null) {
                    MsgBodyExtraOuterClass.VideoExtra videoExtra = this.videoExtra_;
                    MsgBodyExtraOuterClass.VideoExtra videoExtra2 = videoExtra;
                    if (videoExtra == null) {
                        videoExtra2 = MsgBodyExtraOuterClass.VideoExtra.getDefaultInstance();
                    }
                    return videoExtra2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public MsgBodyExtraOuterClass.VideoExtra.Builder getVideoExtraBuilder() {
                onChanged();
                return getVideoExtraFieldBuilder().getBuilder();
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.VideoExtraOrBuilder getVideoExtraOrBuilder() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoExtra, MsgBodyExtraOuterClass.VideoExtra.Builder, MsgBodyExtraOuterClass.VideoExtraOrBuilder> singleFieldBuilderV3 = this.videoExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                MsgBodyExtraOuterClass.VideoExtra videoExtra = this.videoExtra_;
                MsgBodyExtraOuterClass.VideoExtra videoExtra2 = videoExtra;
                if (videoExtra == null) {
                    videoExtra2 = MsgBodyExtraOuterClass.VideoExtra.getDefaultInstance();
                }
                return videoExtra2;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.VipExtra getVipExtra() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.VipExtra, MsgBodyExtraOuterClass.VipExtra.Builder, MsgBodyExtraOuterClass.VipExtraOrBuilder> singleFieldBuilderV3 = this.vipExtraBuilder_;
                if (singleFieldBuilderV3 == null) {
                    MsgBodyExtraOuterClass.VipExtra vipExtra = this.vipExtra_;
                    MsgBodyExtraOuterClass.VipExtra vipExtra2 = vipExtra;
                    if (vipExtra == null) {
                        vipExtra2 = MsgBodyExtraOuterClass.VipExtra.getDefaultInstance();
                    }
                    return vipExtra2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public MsgBodyExtraOuterClass.VipExtra.Builder getVipExtraBuilder() {
                onChanged();
                return getVipExtraFieldBuilder().getBuilder();
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.VipExtraOrBuilder getVipExtraOrBuilder() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.VipExtra, MsgBodyExtraOuterClass.VipExtra.Builder, MsgBodyExtraOuterClass.VipExtraOrBuilder> singleFieldBuilderV3 = this.vipExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                MsgBodyExtraOuterClass.VipExtra vipExtra = this.vipExtra_;
                MsgBodyExtraOuterClass.VipExtra vipExtra2 = vipExtra;
                if (vipExtra == null) {
                    vipExtra2 = MsgBodyExtraOuterClass.VipExtra.getDefaultInstance();
                }
                return vipExtra2;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.VoiceRoomShareExtra getVoiceRoomShareExtra() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.VoiceRoomShareExtra, MsgBodyExtraOuterClass.VoiceRoomShareExtra.Builder, MsgBodyExtraOuterClass.VoiceRoomShareExtraOrBuilder> singleFieldBuilderV3 = this.voiceRoomShareExtraBuilder_;
                if (singleFieldBuilderV3 == null) {
                    MsgBodyExtraOuterClass.VoiceRoomShareExtra voiceRoomShareExtra = this.voiceRoomShareExtra_;
                    MsgBodyExtraOuterClass.VoiceRoomShareExtra voiceRoomShareExtra2 = voiceRoomShareExtra;
                    if (voiceRoomShareExtra == null) {
                        voiceRoomShareExtra2 = MsgBodyExtraOuterClass.VoiceRoomShareExtra.getDefaultInstance();
                    }
                    return voiceRoomShareExtra2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public MsgBodyExtraOuterClass.VoiceRoomShareExtra.Builder getVoiceRoomShareExtraBuilder() {
                onChanged();
                return getVoiceRoomShareExtraFieldBuilder().getBuilder();
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public MsgBodyExtraOuterClass.VoiceRoomShareExtraOrBuilder getVoiceRoomShareExtraOrBuilder() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.VoiceRoomShareExtra, MsgBodyExtraOuterClass.VoiceRoomShareExtra.Builder, MsgBodyExtraOuterClass.VoiceRoomShareExtraOrBuilder> singleFieldBuilderV3 = this.voiceRoomShareExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                MsgBodyExtraOuterClass.VoiceRoomShareExtra voiceRoomShareExtra = this.voiceRoomShareExtra_;
                MsgBodyExtraOuterClass.VoiceRoomShareExtra voiceRoomShareExtra2 = voiceRoomShareExtra;
                if (voiceRoomShareExtra == null) {
                    voiceRoomShareExtra2 = MsgBodyExtraOuterClass.VoiceRoomShareExtra.getDefaultInstance();
                }
                return voiceRoomShareExtra2;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public boolean hasActivityShareExtra() {
                return (this.activityShareExtraBuilder_ == null && this.activityShareExtra_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public boolean hasDoodleShareExtra() {
                return (this.doodleShareExtraBuilder_ == null && this.doodleShareExtra_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public boolean hasEvaluationExtra() {
                return (this.evaluationExtraBuilder_ == null && this.evaluationExtra_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public boolean hasFeedShareExtra() {
                return (this.feedShareExtraBuilder_ == null && this.feedShareExtra_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public boolean hasFriendsCircleExtra() {
                return (this.friendsCircleExtraBuilder_ == null && this.friendsCircleExtra_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public boolean hasGiftExtra() {
                return (this.giftExtraBuilder_ == null && this.giftExtra_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public boolean hasGroupCardExtra() {
                return (this.groupCardExtraBuilder_ == null && this.groupCardExtra_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public boolean hasGroupNotice() {
                return (this.groupNoticeBuilder_ == null && this.groupNotice_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public boolean hasHidenAlbumExtra() {
                return (this.hidenAlbumExtraBuilder_ == null && this.hidenAlbumExtra_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public boolean hasImagetextExtra() {
                return (this.imagetextExtraBuilder_ == null && this.imagetextExtra_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public boolean hasImgExtra() {
                return (this.imgExtraBuilder_ == null && this.imgExtra_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public boolean hasLiveShareExtra() {
                return (this.liveShareExtraBuilder_ == null && this.liveShareExtra_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public boolean hasLiveShareInternationalExtra() {
                return (this.liveShareInternationalExtraBuilder_ == null && this.liveShareInternationalExtra_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public boolean hasLocationExtra() {
                return (this.locationExtraBuilder_ == null && this.locationExtra_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public boolean hasSayHiExtra() {
                return (this.sayHiExtraBuilder_ == null && this.sayHiExtra_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public boolean hasSecureNotify() {
                return (this.secureNotifyBuilder_ == null && this.secureNotify_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public boolean hasShareExtra() {
                return (this.shareExtraBuilder_ == null && this.shareExtra_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public boolean hasSysNoticeExtra() {
                return (this.sysNoticeExtraBuilder_ == null && this.sysNoticeExtra_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public boolean hasTextExtra() {
                return (this.textExtraBuilder_ == null && this.textExtra_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public boolean hasVideoCallingExtra() {
                return (this.videoCallingExtraBuilder_ == null && this.videoCallingExtra_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public boolean hasVideoEndExtra() {
                return (this.videoEndExtraBuilder_ == null && this.videoEndExtra_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public boolean hasVideoExtra() {
                return (this.videoExtraBuilder_ == null && this.videoExtra_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public boolean hasVipExtra() {
                return (this.vipExtraBuilder_ == null && this.vipExtra_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
            public boolean hasVoiceRoomShareExtra() {
                return (this.voiceRoomShareExtraBuilder_ == null && this.voiceRoomShareExtra_ == null) ? false : true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MsgBodyOuterClass.internal_static_com_blued_im_private_chat_MsgExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(MsgExtra.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeActivityShareExtra(MsgBodyExtraOuterClass.ActivityShareExtra activityShareExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.ActivityShareExtra, MsgBodyExtraOuterClass.ActivityShareExtra.Builder, MsgBodyExtraOuterClass.ActivityShareExtraOrBuilder> singleFieldBuilderV3 = this.activityShareExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(activityShareExtra);
                    return this;
                }
                MsgBodyExtraOuterClass.ActivityShareExtra activityShareExtra2 = this.activityShareExtra_;
                if (activityShareExtra2 != null) {
                    this.activityShareExtra_ = MsgBodyExtraOuterClass.ActivityShareExtra.newBuilder(activityShareExtra2).mergeFrom(activityShareExtra).buildPartial();
                } else {
                    this.activityShareExtra_ = activityShareExtra;
                }
                onChanged();
                return this;
            }

            public Builder mergeDoodleShareExtra(MsgBodyExtraOuterClass.DoodleShareExtra doodleShareExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.DoodleShareExtra, MsgBodyExtraOuterClass.DoodleShareExtra.Builder, MsgBodyExtraOuterClass.DoodleShareExtraOrBuilder> singleFieldBuilderV3 = this.doodleShareExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(doodleShareExtra);
                    return this;
                }
                MsgBodyExtraOuterClass.DoodleShareExtra doodleShareExtra2 = this.doodleShareExtra_;
                if (doodleShareExtra2 != null) {
                    this.doodleShareExtra_ = MsgBodyExtraOuterClass.DoodleShareExtra.newBuilder(doodleShareExtra2).mergeFrom(doodleShareExtra).buildPartial();
                } else {
                    this.doodleShareExtra_ = doodleShareExtra;
                }
                onChanged();
                return this;
            }

            public Builder mergeEvaluationExtra(MsgBodyExtraOuterClass.EvaluationExtra evaluationExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.EvaluationExtra, MsgBodyExtraOuterClass.EvaluationExtra.Builder, MsgBodyExtraOuterClass.EvaluationExtraOrBuilder> singleFieldBuilderV3 = this.evaluationExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(evaluationExtra);
                    return this;
                }
                MsgBodyExtraOuterClass.EvaluationExtra evaluationExtra2 = this.evaluationExtra_;
                if (evaluationExtra2 != null) {
                    this.evaluationExtra_ = MsgBodyExtraOuterClass.EvaluationExtra.newBuilder(evaluationExtra2).mergeFrom(evaluationExtra).buildPartial();
                } else {
                    this.evaluationExtra_ = evaluationExtra;
                }
                onChanged();
                return this;
            }

            public Builder mergeFeedShareExtra(MsgBodyExtraOuterClass.FeedShareExtra feedShareExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.FeedShareExtra, MsgBodyExtraOuterClass.FeedShareExtra.Builder, MsgBodyExtraOuterClass.FeedShareExtraOrBuilder> singleFieldBuilderV3 = this.feedShareExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(feedShareExtra);
                    return this;
                }
                MsgBodyExtraOuterClass.FeedShareExtra feedShareExtra2 = this.feedShareExtra_;
                if (feedShareExtra2 != null) {
                    this.feedShareExtra_ = MsgBodyExtraOuterClass.FeedShareExtra.newBuilder(feedShareExtra2).mergeFrom(feedShareExtra).buildPartial();
                } else {
                    this.feedShareExtra_ = feedShareExtra;
                }
                onChanged();
                return this;
            }

            public Builder mergeFriendsCircleExtra(MsgBodyExtraOuterClass.FriendsCircleExtra friendsCircleExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.FriendsCircleExtra, MsgBodyExtraOuterClass.FriendsCircleExtra.Builder, MsgBodyExtraOuterClass.FriendsCircleExtraOrBuilder> singleFieldBuilderV3 = this.friendsCircleExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(friendsCircleExtra);
                    return this;
                }
                MsgBodyExtraOuterClass.FriendsCircleExtra friendsCircleExtra2 = this.friendsCircleExtra_;
                if (friendsCircleExtra2 != null) {
                    this.friendsCircleExtra_ = MsgBodyExtraOuterClass.FriendsCircleExtra.newBuilder(friendsCircleExtra2).mergeFrom(friendsCircleExtra).buildPartial();
                } else {
                    this.friendsCircleExtra_ = friendsCircleExtra;
                }
                onChanged();
                return this;
            }

            public Builder mergeFrom(MsgExtra msgExtra) {
                if (msgExtra == MsgExtra.getDefaultInstance()) {
                    return this;
                }
                if (msgExtra.hasTextExtra()) {
                    mergeTextExtra(msgExtra.getTextExtra());
                }
                if (msgExtra.hasImgExtra()) {
                    mergeImgExtra(msgExtra.getImgExtra());
                }
                if (msgExtra.hasLocationExtra()) {
                    mergeLocationExtra(msgExtra.getLocationExtra());
                }
                if (msgExtra.hasVideoExtra()) {
                    mergeVideoExtra(msgExtra.getVideoExtra());
                }
                if (msgExtra.hasGroupCardExtra()) {
                    mergeGroupCardExtra(msgExtra.getGroupCardExtra());
                }
                if (msgExtra.hasLiveShareExtra()) {
                    mergeLiveShareExtra(msgExtra.getLiveShareExtra());
                }
                if (msgExtra.hasImagetextExtra()) {
                    mergeImagetextExtra(msgExtra.getImagetextExtra());
                }
                if (msgExtra.hasHidenAlbumExtra()) {
                    mergeHidenAlbumExtra(msgExtra.getHidenAlbumExtra());
                }
                if (msgExtra.hasShareExtra()) {
                    mergeShareExtra(msgExtra.getShareExtra());
                }
                if (msgExtra.hasVipExtra()) {
                    mergeVipExtra(msgExtra.getVipExtra());
                }
                if (msgExtra.hasGiftExtra()) {
                    mergeGiftExtra(msgExtra.getGiftExtra());
                }
                if (msgExtra.hasSysNoticeExtra()) {
                    mergeSysNoticeExtra(msgExtra.getSysNoticeExtra());
                }
                if (msgExtra.hasVideoCallingExtra()) {
                    mergeVideoCallingExtra(msgExtra.getVideoCallingExtra());
                }
                if (msgExtra.hasVideoEndExtra()) {
                    mergeVideoEndExtra(msgExtra.getVideoEndExtra());
                }
                if (msgExtra.hasFeedShareExtra()) {
                    mergeFeedShareExtra(msgExtra.getFeedShareExtra());
                }
                if (msgExtra.hasSayHiExtra()) {
                    mergeSayHiExtra(msgExtra.getSayHiExtra());
                }
                if (msgExtra.hasVoiceRoomShareExtra()) {
                    mergeVoiceRoomShareExtra(msgExtra.getVoiceRoomShareExtra());
                }
                if (msgExtra.hasLiveShareInternationalExtra()) {
                    mergeLiveShareInternationalExtra(msgExtra.getLiveShareInternationalExtra());
                }
                if (msgExtra.hasDoodleShareExtra()) {
                    mergeDoodleShareExtra(msgExtra.getDoodleShareExtra());
                }
                if (msgExtra.hasGroupNotice()) {
                    mergeGroupNotice(msgExtra.getGroupNotice());
                }
                if (msgExtra.hasEvaluationExtra()) {
                    mergeEvaluationExtra(msgExtra.getEvaluationExtra());
                }
                if (msgExtra.hasSecureNotify()) {
                    mergeSecureNotify(msgExtra.getSecureNotify());
                }
                if (msgExtra.hasActivityShareExtra()) {
                    mergeActivityShareExtra(msgExtra.getActivityShareExtra());
                }
                if (msgExtra.hasFriendsCircleExtra()) {
                    mergeFriendsCircleExtra(msgExtra.getFriendsCircleExtra());
                }
                mergeUnknownFields(msgExtra.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.im.private_chat.MsgBodyOuterClass.MsgExtra.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.im.private_chat.MsgBodyOuterClass.MsgExtra.access$4700()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.im.private_chat.MsgBodyOuterClass$MsgExtra r0 = (com.blued.im.private_chat.MsgBodyOuterClass.MsgExtra) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.im.private_chat.MsgBodyOuterClass$MsgExtra$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.im.private_chat.MsgBodyOuterClass$MsgExtra r0 = (com.blued.im.private_chat.MsgBodyOuterClass.MsgExtra) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.im.private_chat.MsgBodyOuterClass$MsgExtra$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.im.private_chat.MsgBodyOuterClass.MsgExtra.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.im.private_chat.MsgBodyOuterClass$MsgExtra$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof MsgExtra) {
                    return mergeFrom((MsgExtra) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeGiftExtra(MsgBodyExtraOuterClass.GiftExtra giftExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.GiftExtra, MsgBodyExtraOuterClass.GiftExtra.Builder, MsgBodyExtraOuterClass.GiftExtraOrBuilder> singleFieldBuilderV3 = this.giftExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(giftExtra);
                    return this;
                }
                MsgBodyExtraOuterClass.GiftExtra giftExtra2 = this.giftExtra_;
                if (giftExtra2 != null) {
                    this.giftExtra_ = MsgBodyExtraOuterClass.GiftExtra.newBuilder(giftExtra2).mergeFrom(giftExtra).buildPartial();
                } else {
                    this.giftExtra_ = giftExtra;
                }
                onChanged();
                return this;
            }

            public Builder mergeGroupCardExtra(MsgBodyExtraOuterClass.GroupCardExtra groupCardExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupCardExtra, MsgBodyExtraOuterClass.GroupCardExtra.Builder, MsgBodyExtraOuterClass.GroupCardExtraOrBuilder> singleFieldBuilderV3 = this.groupCardExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(groupCardExtra);
                    return this;
                }
                MsgBodyExtraOuterClass.GroupCardExtra groupCardExtra2 = this.groupCardExtra_;
                if (groupCardExtra2 != null) {
                    this.groupCardExtra_ = MsgBodyExtraOuterClass.GroupCardExtra.newBuilder(groupCardExtra2).mergeFrom(groupCardExtra).buildPartial();
                } else {
                    this.groupCardExtra_ = groupCardExtra;
                }
                onChanged();
                return this;
            }

            public Builder mergeGroupNotice(MsgBodyExtraOuterClass.GroupNotice groupNotice) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupNotice, MsgBodyExtraOuterClass.GroupNotice.Builder, MsgBodyExtraOuterClass.GroupNoticeOrBuilder> singleFieldBuilderV3 = this.groupNoticeBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(groupNotice);
                    return this;
                }
                MsgBodyExtraOuterClass.GroupNotice groupNotice2 = this.groupNotice_;
                if (groupNotice2 != null) {
                    this.groupNotice_ = MsgBodyExtraOuterClass.GroupNotice.newBuilder(groupNotice2).mergeFrom(groupNotice).buildPartial();
                } else {
                    this.groupNotice_ = groupNotice;
                }
                onChanged();
                return this;
            }

            public Builder mergeHidenAlbumExtra(MsgBodyExtraOuterClass.HidenAlbumExtra hidenAlbumExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.HidenAlbumExtra, MsgBodyExtraOuterClass.HidenAlbumExtra.Builder, MsgBodyExtraOuterClass.HidenAlbumExtraOrBuilder> singleFieldBuilderV3 = this.hidenAlbumExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(hidenAlbumExtra);
                    return this;
                }
                MsgBodyExtraOuterClass.HidenAlbumExtra hidenAlbumExtra2 = this.hidenAlbumExtra_;
                if (hidenAlbumExtra2 != null) {
                    this.hidenAlbumExtra_ = MsgBodyExtraOuterClass.HidenAlbumExtra.newBuilder(hidenAlbumExtra2).mergeFrom(hidenAlbumExtra).buildPartial();
                } else {
                    this.hidenAlbumExtra_ = hidenAlbumExtra;
                }
                onChanged();
                return this;
            }

            public Builder mergeImagetextExtra(MsgBodyExtraOuterClass.ImageTextExtra imageTextExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImageTextExtra, MsgBodyExtraOuterClass.ImageTextExtra.Builder, MsgBodyExtraOuterClass.ImageTextExtraOrBuilder> singleFieldBuilderV3 = this.imagetextExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(imageTextExtra);
                    return this;
                }
                MsgBodyExtraOuterClass.ImageTextExtra imageTextExtra2 = this.imagetextExtra_;
                if (imageTextExtra2 != null) {
                    this.imagetextExtra_ = MsgBodyExtraOuterClass.ImageTextExtra.newBuilder(imageTextExtra2).mergeFrom(imageTextExtra).buildPartial();
                } else {
                    this.imagetextExtra_ = imageTextExtra;
                }
                onChanged();
                return this;
            }

            public Builder mergeImgExtra(MsgBodyExtraOuterClass.ImgExtra imgExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImgExtra, MsgBodyExtraOuterClass.ImgExtra.Builder, MsgBodyExtraOuterClass.ImgExtraOrBuilder> singleFieldBuilderV3 = this.imgExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(imgExtra);
                    return this;
                }
                MsgBodyExtraOuterClass.ImgExtra imgExtra2 = this.imgExtra_;
                if (imgExtra2 != null) {
                    this.imgExtra_ = MsgBodyExtraOuterClass.ImgExtra.newBuilder(imgExtra2).mergeFrom(imgExtra).buildPartial();
                } else {
                    this.imgExtra_ = imgExtra;
                }
                onChanged();
                return this;
            }

            public Builder mergeLiveShareExtra(MsgBodyExtraOuterClass.LiveShareExtra liveShareExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareExtra, MsgBodyExtraOuterClass.LiveShareExtra.Builder, MsgBodyExtraOuterClass.LiveShareExtraOrBuilder> singleFieldBuilderV3 = this.liveShareExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(liveShareExtra);
                    return this;
                }
                MsgBodyExtraOuterClass.LiveShareExtra liveShareExtra2 = this.liveShareExtra_;
                if (liveShareExtra2 != null) {
                    this.liveShareExtra_ = MsgBodyExtraOuterClass.LiveShareExtra.newBuilder(liveShareExtra2).mergeFrom(liveShareExtra).buildPartial();
                } else {
                    this.liveShareExtra_ = liveShareExtra;
                }
                onChanged();
                return this;
            }

            public Builder mergeLiveShareInternationalExtra(MsgBodyExtraOuterClass.LiveShareInternationalExtra liveShareInternationalExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareInternationalExtra, MsgBodyExtraOuterClass.LiveShareInternationalExtra.Builder, MsgBodyExtraOuterClass.LiveShareInternationalExtraOrBuilder> singleFieldBuilderV3 = this.liveShareInternationalExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(liveShareInternationalExtra);
                    return this;
                }
                MsgBodyExtraOuterClass.LiveShareInternationalExtra liveShareInternationalExtra2 = this.liveShareInternationalExtra_;
                if (liveShareInternationalExtra2 != null) {
                    this.liveShareInternationalExtra_ = MsgBodyExtraOuterClass.LiveShareInternationalExtra.newBuilder(liveShareInternationalExtra2).mergeFrom(liveShareInternationalExtra).buildPartial();
                } else {
                    this.liveShareInternationalExtra_ = liveShareInternationalExtra;
                }
                onChanged();
                return this;
            }

            public Builder mergeLocationExtra(MsgBodyExtraOuterClass.LocationExtra locationExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.LocationExtra, MsgBodyExtraOuterClass.LocationExtra.Builder, MsgBodyExtraOuterClass.LocationExtraOrBuilder> singleFieldBuilderV3 = this.locationExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(locationExtra);
                    return this;
                }
                MsgBodyExtraOuterClass.LocationExtra locationExtra2 = this.locationExtra_;
                if (locationExtra2 != null) {
                    this.locationExtra_ = MsgBodyExtraOuterClass.LocationExtra.newBuilder(locationExtra2).mergeFrom(locationExtra).buildPartial();
                } else {
                    this.locationExtra_ = locationExtra;
                }
                onChanged();
                return this;
            }

            public Builder mergeSayHiExtra(MsgBodyExtraOuterClass.SayHiExtra sayHiExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.SayHiExtra, MsgBodyExtraOuterClass.SayHiExtra.Builder, MsgBodyExtraOuterClass.SayHiExtraOrBuilder> singleFieldBuilderV3 = this.sayHiExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(sayHiExtra);
                    return this;
                }
                MsgBodyExtraOuterClass.SayHiExtra sayHiExtra2 = this.sayHiExtra_;
                if (sayHiExtra2 != null) {
                    this.sayHiExtra_ = MsgBodyExtraOuterClass.SayHiExtra.newBuilder(sayHiExtra2).mergeFrom(sayHiExtra).buildPartial();
                } else {
                    this.sayHiExtra_ = sayHiExtra;
                }
                onChanged();
                return this;
            }

            public Builder mergeSecureNotify(MsgBodyExtraOuterClass.SecureNotify secureNotify) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.SecureNotify, MsgBodyExtraOuterClass.SecureNotify.Builder, MsgBodyExtraOuterClass.SecureNotifyOrBuilder> singleFieldBuilderV3 = this.secureNotifyBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(secureNotify);
                    return this;
                }
                MsgBodyExtraOuterClass.SecureNotify secureNotify2 = this.secureNotify_;
                if (secureNotify2 != null) {
                    this.secureNotify_ = MsgBodyExtraOuterClass.SecureNotify.newBuilder(secureNotify2).mergeFrom(secureNotify).buildPartial();
                } else {
                    this.secureNotify_ = secureNotify;
                }
                onChanged();
                return this;
            }

            public Builder mergeShareExtra(MsgBodyExtraOuterClass.ShareExtra shareExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.ShareExtra, MsgBodyExtraOuterClass.ShareExtra.Builder, MsgBodyExtraOuterClass.ShareExtraOrBuilder> singleFieldBuilderV3 = this.shareExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(shareExtra);
                    return this;
                }
                MsgBodyExtraOuterClass.ShareExtra shareExtra2 = this.shareExtra_;
                if (shareExtra2 != null) {
                    this.shareExtra_ = MsgBodyExtraOuterClass.ShareExtra.newBuilder(shareExtra2).mergeFrom(shareExtra).buildPartial();
                } else {
                    this.shareExtra_ = shareExtra;
                }
                onChanged();
                return this;
            }

            public Builder mergeSysNoticeExtra(MsgBodyExtraOuterClass.SysNoticeExtra sysNoticeExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.SysNoticeExtra, MsgBodyExtraOuterClass.SysNoticeExtra.Builder, MsgBodyExtraOuterClass.SysNoticeExtraOrBuilder> singleFieldBuilderV3 = this.sysNoticeExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(sysNoticeExtra);
                    return this;
                }
                MsgBodyExtraOuterClass.SysNoticeExtra sysNoticeExtra2 = this.sysNoticeExtra_;
                if (sysNoticeExtra2 != null) {
                    this.sysNoticeExtra_ = MsgBodyExtraOuterClass.SysNoticeExtra.newBuilder(sysNoticeExtra2).mergeFrom(sysNoticeExtra).buildPartial();
                } else {
                    this.sysNoticeExtra_ = sysNoticeExtra;
                }
                onChanged();
                return this;
            }

            public Builder mergeTextExtra(MsgBodyExtraOuterClass.TextExtra textExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.TextExtra, MsgBodyExtraOuterClass.TextExtra.Builder, MsgBodyExtraOuterClass.TextExtraOrBuilder> singleFieldBuilderV3 = this.textExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(textExtra);
                    return this;
                }
                MsgBodyExtraOuterClass.TextExtra textExtra2 = this.textExtra_;
                if (textExtra2 != null) {
                    this.textExtra_ = MsgBodyExtraOuterClass.TextExtra.newBuilder(textExtra2).mergeFrom(textExtra).buildPartial();
                } else {
                    this.textExtra_ = textExtra;
                }
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            public Builder mergeVideoCallingExtra(MsgBodyExtraOuterClass.VideoChatCallingExtra videoChatCallingExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatCallingExtra, MsgBodyExtraOuterClass.VideoChatCallingExtra.Builder, MsgBodyExtraOuterClass.VideoChatCallingExtraOrBuilder> singleFieldBuilderV3 = this.videoCallingExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(videoChatCallingExtra);
                    return this;
                }
                MsgBodyExtraOuterClass.VideoChatCallingExtra videoChatCallingExtra2 = this.videoCallingExtra_;
                if (videoChatCallingExtra2 != null) {
                    this.videoCallingExtra_ = MsgBodyExtraOuterClass.VideoChatCallingExtra.newBuilder(videoChatCallingExtra2).mergeFrom(videoChatCallingExtra).buildPartial();
                } else {
                    this.videoCallingExtra_ = videoChatCallingExtra;
                }
                onChanged();
                return this;
            }

            public Builder mergeVideoEndExtra(MsgBodyExtraOuterClass.VideoChatEndExtra videoChatEndExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatEndExtra, MsgBodyExtraOuterClass.VideoChatEndExtra.Builder, MsgBodyExtraOuterClass.VideoChatEndExtraOrBuilder> singleFieldBuilderV3 = this.videoEndExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(videoChatEndExtra);
                    return this;
                }
                MsgBodyExtraOuterClass.VideoChatEndExtra videoChatEndExtra2 = this.videoEndExtra_;
                if (videoChatEndExtra2 != null) {
                    this.videoEndExtra_ = MsgBodyExtraOuterClass.VideoChatEndExtra.newBuilder(videoChatEndExtra2).mergeFrom(videoChatEndExtra).buildPartial();
                } else {
                    this.videoEndExtra_ = videoChatEndExtra;
                }
                onChanged();
                return this;
            }

            public Builder mergeVideoExtra(MsgBodyExtraOuterClass.VideoExtra videoExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoExtra, MsgBodyExtraOuterClass.VideoExtra.Builder, MsgBodyExtraOuterClass.VideoExtraOrBuilder> singleFieldBuilderV3 = this.videoExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(videoExtra);
                    return this;
                }
                MsgBodyExtraOuterClass.VideoExtra videoExtra2 = this.videoExtra_;
                if (videoExtra2 != null) {
                    this.videoExtra_ = MsgBodyExtraOuterClass.VideoExtra.newBuilder(videoExtra2).mergeFrom(videoExtra).buildPartial();
                } else {
                    this.videoExtra_ = videoExtra;
                }
                onChanged();
                return this;
            }

            public Builder mergeVipExtra(MsgBodyExtraOuterClass.VipExtra vipExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.VipExtra, MsgBodyExtraOuterClass.VipExtra.Builder, MsgBodyExtraOuterClass.VipExtraOrBuilder> singleFieldBuilderV3 = this.vipExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(vipExtra);
                    return this;
                }
                MsgBodyExtraOuterClass.VipExtra vipExtra2 = this.vipExtra_;
                if (vipExtra2 != null) {
                    this.vipExtra_ = MsgBodyExtraOuterClass.VipExtra.newBuilder(vipExtra2).mergeFrom(vipExtra).buildPartial();
                } else {
                    this.vipExtra_ = vipExtra;
                }
                onChanged();
                return this;
            }

            public Builder mergeVoiceRoomShareExtra(MsgBodyExtraOuterClass.VoiceRoomShareExtra voiceRoomShareExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.VoiceRoomShareExtra, MsgBodyExtraOuterClass.VoiceRoomShareExtra.Builder, MsgBodyExtraOuterClass.VoiceRoomShareExtraOrBuilder> singleFieldBuilderV3 = this.voiceRoomShareExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(voiceRoomShareExtra);
                    return this;
                }
                MsgBodyExtraOuterClass.VoiceRoomShareExtra voiceRoomShareExtra2 = this.voiceRoomShareExtra_;
                if (voiceRoomShareExtra2 != null) {
                    this.voiceRoomShareExtra_ = MsgBodyExtraOuterClass.VoiceRoomShareExtra.newBuilder(voiceRoomShareExtra2).mergeFrom(voiceRoomShareExtra).buildPartial();
                } else {
                    this.voiceRoomShareExtra_ = voiceRoomShareExtra;
                }
                onChanged();
                return this;
            }

            public Builder setActivityShareExtra(MsgBodyExtraOuterClass.ActivityShareExtra.Builder builder) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.ActivityShareExtra, MsgBodyExtraOuterClass.ActivityShareExtra.Builder, MsgBodyExtraOuterClass.ActivityShareExtraOrBuilder> singleFieldBuilderV3 = this.activityShareExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.activityShareExtra_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setActivityShareExtra(MsgBodyExtraOuterClass.ActivityShareExtra activityShareExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.ActivityShareExtra, MsgBodyExtraOuterClass.ActivityShareExtra.Builder, MsgBodyExtraOuterClass.ActivityShareExtraOrBuilder> singleFieldBuilderV3 = this.activityShareExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(activityShareExtra);
                    return this;
                } else if (activityShareExtra != null) {
                    this.activityShareExtra_ = activityShareExtra;
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }

            public Builder setDoodleShareExtra(MsgBodyExtraOuterClass.DoodleShareExtra.Builder builder) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.DoodleShareExtra, MsgBodyExtraOuterClass.DoodleShareExtra.Builder, MsgBodyExtraOuterClass.DoodleShareExtraOrBuilder> singleFieldBuilderV3 = this.doodleShareExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.doodleShareExtra_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setDoodleShareExtra(MsgBodyExtraOuterClass.DoodleShareExtra doodleShareExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.DoodleShareExtra, MsgBodyExtraOuterClass.DoodleShareExtra.Builder, MsgBodyExtraOuterClass.DoodleShareExtraOrBuilder> singleFieldBuilderV3 = this.doodleShareExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(doodleShareExtra);
                    return this;
                } else if (doodleShareExtra != null) {
                    this.doodleShareExtra_ = doodleShareExtra;
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }

            public Builder setEvaluationExtra(MsgBodyExtraOuterClass.EvaluationExtra.Builder builder) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.EvaluationExtra, MsgBodyExtraOuterClass.EvaluationExtra.Builder, MsgBodyExtraOuterClass.EvaluationExtraOrBuilder> singleFieldBuilderV3 = this.evaluationExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.evaluationExtra_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setEvaluationExtra(MsgBodyExtraOuterClass.EvaluationExtra evaluationExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.EvaluationExtra, MsgBodyExtraOuterClass.EvaluationExtra.Builder, MsgBodyExtraOuterClass.EvaluationExtraOrBuilder> singleFieldBuilderV3 = this.evaluationExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(evaluationExtra);
                    return this;
                } else if (evaluationExtra != null) {
                    this.evaluationExtra_ = evaluationExtra;
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }

            public Builder setFeedShareExtra(MsgBodyExtraOuterClass.FeedShareExtra.Builder builder) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.FeedShareExtra, MsgBodyExtraOuterClass.FeedShareExtra.Builder, MsgBodyExtraOuterClass.FeedShareExtraOrBuilder> singleFieldBuilderV3 = this.feedShareExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.feedShareExtra_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setFeedShareExtra(MsgBodyExtraOuterClass.FeedShareExtra feedShareExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.FeedShareExtra, MsgBodyExtraOuterClass.FeedShareExtra.Builder, MsgBodyExtraOuterClass.FeedShareExtraOrBuilder> singleFieldBuilderV3 = this.feedShareExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(feedShareExtra);
                    return this;
                } else if (feedShareExtra != null) {
                    this.feedShareExtra_ = feedShareExtra;
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

            public Builder setFriendsCircleExtra(MsgBodyExtraOuterClass.FriendsCircleExtra.Builder builder) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.FriendsCircleExtra, MsgBodyExtraOuterClass.FriendsCircleExtra.Builder, MsgBodyExtraOuterClass.FriendsCircleExtraOrBuilder> singleFieldBuilderV3 = this.friendsCircleExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.friendsCircleExtra_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setFriendsCircleExtra(MsgBodyExtraOuterClass.FriendsCircleExtra friendsCircleExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.FriendsCircleExtra, MsgBodyExtraOuterClass.FriendsCircleExtra.Builder, MsgBodyExtraOuterClass.FriendsCircleExtraOrBuilder> singleFieldBuilderV3 = this.friendsCircleExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(friendsCircleExtra);
                    return this;
                } else if (friendsCircleExtra != null) {
                    this.friendsCircleExtra_ = friendsCircleExtra;
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }

            public Builder setGiftExtra(MsgBodyExtraOuterClass.GiftExtra.Builder builder) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.GiftExtra, MsgBodyExtraOuterClass.GiftExtra.Builder, MsgBodyExtraOuterClass.GiftExtraOrBuilder> singleFieldBuilderV3 = this.giftExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.giftExtra_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setGiftExtra(MsgBodyExtraOuterClass.GiftExtra giftExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.GiftExtra, MsgBodyExtraOuterClass.GiftExtra.Builder, MsgBodyExtraOuterClass.GiftExtraOrBuilder> singleFieldBuilderV3 = this.giftExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(giftExtra);
                    return this;
                } else if (giftExtra != null) {
                    this.giftExtra_ = giftExtra;
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }

            public Builder setGroupCardExtra(MsgBodyExtraOuterClass.GroupCardExtra.Builder builder) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupCardExtra, MsgBodyExtraOuterClass.GroupCardExtra.Builder, MsgBodyExtraOuterClass.GroupCardExtraOrBuilder> singleFieldBuilderV3 = this.groupCardExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.groupCardExtra_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setGroupCardExtra(MsgBodyExtraOuterClass.GroupCardExtra groupCardExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupCardExtra, MsgBodyExtraOuterClass.GroupCardExtra.Builder, MsgBodyExtraOuterClass.GroupCardExtraOrBuilder> singleFieldBuilderV3 = this.groupCardExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(groupCardExtra);
                    return this;
                } else if (groupCardExtra != null) {
                    this.groupCardExtra_ = groupCardExtra;
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }

            public Builder setGroupNotice(MsgBodyExtraOuterClass.GroupNotice.Builder builder) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupNotice, MsgBodyExtraOuterClass.GroupNotice.Builder, MsgBodyExtraOuterClass.GroupNoticeOrBuilder> singleFieldBuilderV3 = this.groupNoticeBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.groupNotice_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setGroupNotice(MsgBodyExtraOuterClass.GroupNotice groupNotice) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupNotice, MsgBodyExtraOuterClass.GroupNotice.Builder, MsgBodyExtraOuterClass.GroupNoticeOrBuilder> singleFieldBuilderV3 = this.groupNoticeBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(groupNotice);
                    return this;
                } else if (groupNotice != null) {
                    this.groupNotice_ = groupNotice;
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }

            public Builder setHidenAlbumExtra(MsgBodyExtraOuterClass.HidenAlbumExtra.Builder builder) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.HidenAlbumExtra, MsgBodyExtraOuterClass.HidenAlbumExtra.Builder, MsgBodyExtraOuterClass.HidenAlbumExtraOrBuilder> singleFieldBuilderV3 = this.hidenAlbumExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.hidenAlbumExtra_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setHidenAlbumExtra(MsgBodyExtraOuterClass.HidenAlbumExtra hidenAlbumExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.HidenAlbumExtra, MsgBodyExtraOuterClass.HidenAlbumExtra.Builder, MsgBodyExtraOuterClass.HidenAlbumExtraOrBuilder> singleFieldBuilderV3 = this.hidenAlbumExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(hidenAlbumExtra);
                    return this;
                } else if (hidenAlbumExtra != null) {
                    this.hidenAlbumExtra_ = hidenAlbumExtra;
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }

            public Builder setImagetextExtra(MsgBodyExtraOuterClass.ImageTextExtra.Builder builder) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImageTextExtra, MsgBodyExtraOuterClass.ImageTextExtra.Builder, MsgBodyExtraOuterClass.ImageTextExtraOrBuilder> singleFieldBuilderV3 = this.imagetextExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.imagetextExtra_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setImagetextExtra(MsgBodyExtraOuterClass.ImageTextExtra imageTextExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImageTextExtra, MsgBodyExtraOuterClass.ImageTextExtra.Builder, MsgBodyExtraOuterClass.ImageTextExtraOrBuilder> singleFieldBuilderV3 = this.imagetextExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(imageTextExtra);
                    return this;
                } else if (imageTextExtra != null) {
                    this.imagetextExtra_ = imageTextExtra;
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }

            public Builder setImgExtra(MsgBodyExtraOuterClass.ImgExtra.Builder builder) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImgExtra, MsgBodyExtraOuterClass.ImgExtra.Builder, MsgBodyExtraOuterClass.ImgExtraOrBuilder> singleFieldBuilderV3 = this.imgExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.imgExtra_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setImgExtra(MsgBodyExtraOuterClass.ImgExtra imgExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImgExtra, MsgBodyExtraOuterClass.ImgExtra.Builder, MsgBodyExtraOuterClass.ImgExtraOrBuilder> singleFieldBuilderV3 = this.imgExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(imgExtra);
                    return this;
                } else if (imgExtra != null) {
                    this.imgExtra_ = imgExtra;
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }

            public Builder setLiveShareExtra(MsgBodyExtraOuterClass.LiveShareExtra.Builder builder) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareExtra, MsgBodyExtraOuterClass.LiveShareExtra.Builder, MsgBodyExtraOuterClass.LiveShareExtraOrBuilder> singleFieldBuilderV3 = this.liveShareExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.liveShareExtra_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setLiveShareExtra(MsgBodyExtraOuterClass.LiveShareExtra liveShareExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareExtra, MsgBodyExtraOuterClass.LiveShareExtra.Builder, MsgBodyExtraOuterClass.LiveShareExtraOrBuilder> singleFieldBuilderV3 = this.liveShareExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(liveShareExtra);
                    return this;
                } else if (liveShareExtra != null) {
                    this.liveShareExtra_ = liveShareExtra;
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }

            public Builder setLiveShareInternationalExtra(MsgBodyExtraOuterClass.LiveShareInternationalExtra.Builder builder) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareInternationalExtra, MsgBodyExtraOuterClass.LiveShareInternationalExtra.Builder, MsgBodyExtraOuterClass.LiveShareInternationalExtraOrBuilder> singleFieldBuilderV3 = this.liveShareInternationalExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.liveShareInternationalExtra_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setLiveShareInternationalExtra(MsgBodyExtraOuterClass.LiveShareInternationalExtra liveShareInternationalExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareInternationalExtra, MsgBodyExtraOuterClass.LiveShareInternationalExtra.Builder, MsgBodyExtraOuterClass.LiveShareInternationalExtraOrBuilder> singleFieldBuilderV3 = this.liveShareInternationalExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(liveShareInternationalExtra);
                    return this;
                } else if (liveShareInternationalExtra != null) {
                    this.liveShareInternationalExtra_ = liveShareInternationalExtra;
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }

            public Builder setLocationExtra(MsgBodyExtraOuterClass.LocationExtra.Builder builder) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.LocationExtra, MsgBodyExtraOuterClass.LocationExtra.Builder, MsgBodyExtraOuterClass.LocationExtraOrBuilder> singleFieldBuilderV3 = this.locationExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.locationExtra_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setLocationExtra(MsgBodyExtraOuterClass.LocationExtra locationExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.LocationExtra, MsgBodyExtraOuterClass.LocationExtra.Builder, MsgBodyExtraOuterClass.LocationExtraOrBuilder> singleFieldBuilderV3 = this.locationExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(locationExtra);
                    return this;
                } else if (locationExtra != null) {
                    this.locationExtra_ = locationExtra;
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

            public Builder setSayHiExtra(MsgBodyExtraOuterClass.SayHiExtra.Builder builder) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.SayHiExtra, MsgBodyExtraOuterClass.SayHiExtra.Builder, MsgBodyExtraOuterClass.SayHiExtraOrBuilder> singleFieldBuilderV3 = this.sayHiExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.sayHiExtra_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setSayHiExtra(MsgBodyExtraOuterClass.SayHiExtra sayHiExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.SayHiExtra, MsgBodyExtraOuterClass.SayHiExtra.Builder, MsgBodyExtraOuterClass.SayHiExtraOrBuilder> singleFieldBuilderV3 = this.sayHiExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(sayHiExtra);
                    return this;
                } else if (sayHiExtra != null) {
                    this.sayHiExtra_ = sayHiExtra;
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }

            public Builder setSecureNotify(MsgBodyExtraOuterClass.SecureNotify.Builder builder) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.SecureNotify, MsgBodyExtraOuterClass.SecureNotify.Builder, MsgBodyExtraOuterClass.SecureNotifyOrBuilder> singleFieldBuilderV3 = this.secureNotifyBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.secureNotify_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setSecureNotify(MsgBodyExtraOuterClass.SecureNotify secureNotify) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.SecureNotify, MsgBodyExtraOuterClass.SecureNotify.Builder, MsgBodyExtraOuterClass.SecureNotifyOrBuilder> singleFieldBuilderV3 = this.secureNotifyBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(secureNotify);
                    return this;
                } else if (secureNotify != null) {
                    this.secureNotify_ = secureNotify;
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }

            public Builder setShareExtra(MsgBodyExtraOuterClass.ShareExtra.Builder builder) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.ShareExtra, MsgBodyExtraOuterClass.ShareExtra.Builder, MsgBodyExtraOuterClass.ShareExtraOrBuilder> singleFieldBuilderV3 = this.shareExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.shareExtra_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setShareExtra(MsgBodyExtraOuterClass.ShareExtra shareExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.ShareExtra, MsgBodyExtraOuterClass.ShareExtra.Builder, MsgBodyExtraOuterClass.ShareExtraOrBuilder> singleFieldBuilderV3 = this.shareExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(shareExtra);
                    return this;
                } else if (shareExtra != null) {
                    this.shareExtra_ = shareExtra;
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }

            public Builder setSysNoticeExtra(MsgBodyExtraOuterClass.SysNoticeExtra.Builder builder) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.SysNoticeExtra, MsgBodyExtraOuterClass.SysNoticeExtra.Builder, MsgBodyExtraOuterClass.SysNoticeExtraOrBuilder> singleFieldBuilderV3 = this.sysNoticeExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.sysNoticeExtra_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setSysNoticeExtra(MsgBodyExtraOuterClass.SysNoticeExtra sysNoticeExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.SysNoticeExtra, MsgBodyExtraOuterClass.SysNoticeExtra.Builder, MsgBodyExtraOuterClass.SysNoticeExtraOrBuilder> singleFieldBuilderV3 = this.sysNoticeExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(sysNoticeExtra);
                    return this;
                } else if (sysNoticeExtra != null) {
                    this.sysNoticeExtra_ = sysNoticeExtra;
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }

            public Builder setTextExtra(MsgBodyExtraOuterClass.TextExtra.Builder builder) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.TextExtra, MsgBodyExtraOuterClass.TextExtra.Builder, MsgBodyExtraOuterClass.TextExtraOrBuilder> singleFieldBuilderV3 = this.textExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.textExtra_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setTextExtra(MsgBodyExtraOuterClass.TextExtra textExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.TextExtra, MsgBodyExtraOuterClass.TextExtra.Builder, MsgBodyExtraOuterClass.TextExtraOrBuilder> singleFieldBuilderV3 = this.textExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(textExtra);
                    return this;
                } else if (textExtra != null) {
                    this.textExtra_ = textExtra;
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            public Builder setVideoCallingExtra(MsgBodyExtraOuterClass.VideoChatCallingExtra.Builder builder) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatCallingExtra, MsgBodyExtraOuterClass.VideoChatCallingExtra.Builder, MsgBodyExtraOuterClass.VideoChatCallingExtraOrBuilder> singleFieldBuilderV3 = this.videoCallingExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.videoCallingExtra_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setVideoCallingExtra(MsgBodyExtraOuterClass.VideoChatCallingExtra videoChatCallingExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatCallingExtra, MsgBodyExtraOuterClass.VideoChatCallingExtra.Builder, MsgBodyExtraOuterClass.VideoChatCallingExtraOrBuilder> singleFieldBuilderV3 = this.videoCallingExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(videoChatCallingExtra);
                    return this;
                } else if (videoChatCallingExtra != null) {
                    this.videoCallingExtra_ = videoChatCallingExtra;
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }

            public Builder setVideoEndExtra(MsgBodyExtraOuterClass.VideoChatEndExtra.Builder builder) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatEndExtra, MsgBodyExtraOuterClass.VideoChatEndExtra.Builder, MsgBodyExtraOuterClass.VideoChatEndExtraOrBuilder> singleFieldBuilderV3 = this.videoEndExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.videoEndExtra_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setVideoEndExtra(MsgBodyExtraOuterClass.VideoChatEndExtra videoChatEndExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatEndExtra, MsgBodyExtraOuterClass.VideoChatEndExtra.Builder, MsgBodyExtraOuterClass.VideoChatEndExtraOrBuilder> singleFieldBuilderV3 = this.videoEndExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(videoChatEndExtra);
                    return this;
                } else if (videoChatEndExtra != null) {
                    this.videoEndExtra_ = videoChatEndExtra;
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }

            public Builder setVideoExtra(MsgBodyExtraOuterClass.VideoExtra.Builder builder) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoExtra, MsgBodyExtraOuterClass.VideoExtra.Builder, MsgBodyExtraOuterClass.VideoExtraOrBuilder> singleFieldBuilderV3 = this.videoExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.videoExtra_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setVideoExtra(MsgBodyExtraOuterClass.VideoExtra videoExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoExtra, MsgBodyExtraOuterClass.VideoExtra.Builder, MsgBodyExtraOuterClass.VideoExtraOrBuilder> singleFieldBuilderV3 = this.videoExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(videoExtra);
                    return this;
                } else if (videoExtra != null) {
                    this.videoExtra_ = videoExtra;
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }

            public Builder setVipExtra(MsgBodyExtraOuterClass.VipExtra.Builder builder) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.VipExtra, MsgBodyExtraOuterClass.VipExtra.Builder, MsgBodyExtraOuterClass.VipExtraOrBuilder> singleFieldBuilderV3 = this.vipExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.vipExtra_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setVipExtra(MsgBodyExtraOuterClass.VipExtra vipExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.VipExtra, MsgBodyExtraOuterClass.VipExtra.Builder, MsgBodyExtraOuterClass.VipExtraOrBuilder> singleFieldBuilderV3 = this.vipExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(vipExtra);
                    return this;
                } else if (vipExtra != null) {
                    this.vipExtra_ = vipExtra;
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }

            public Builder setVoiceRoomShareExtra(MsgBodyExtraOuterClass.VoiceRoomShareExtra.Builder builder) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.VoiceRoomShareExtra, MsgBodyExtraOuterClass.VoiceRoomShareExtra.Builder, MsgBodyExtraOuterClass.VoiceRoomShareExtraOrBuilder> singleFieldBuilderV3 = this.voiceRoomShareExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.voiceRoomShareExtra_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setVoiceRoomShareExtra(MsgBodyExtraOuterClass.VoiceRoomShareExtra voiceRoomShareExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.VoiceRoomShareExtra, MsgBodyExtraOuterClass.VoiceRoomShareExtra.Builder, MsgBodyExtraOuterClass.VoiceRoomShareExtraOrBuilder> singleFieldBuilderV3 = this.voiceRoomShareExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(voiceRoomShareExtra);
                    return this;
                } else if (voiceRoomShareExtra != null) {
                    this.voiceRoomShareExtra_ = voiceRoomShareExtra;
                    onChanged();
                    return this;
                } else {
                    throw null;
                }
            }
        }

        private MsgExtra() {
            this.memoizedIsInitialized = (byte) -1;
        }

        private MsgExtra(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            switch (readTag) {
                                case 0:
                                    break;
                                case 10:
                                    MsgBodyExtraOuterClass.TextExtra.Builder builder = this.textExtra_ != null ? this.textExtra_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.TextExtra textExtra = (MsgBodyExtraOuterClass.TextExtra) codedInputStream.readMessage(MsgBodyExtraOuterClass.TextExtra.parser(), extensionRegistryLite);
                                    this.textExtra_ = textExtra;
                                    if (builder != null) {
                                        builder.mergeFrom(textExtra);
                                        this.textExtra_ = builder.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 18:
                                    MsgBodyExtraOuterClass.ImgExtra.Builder builder2 = this.imgExtra_ != null ? this.imgExtra_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.ImgExtra imgExtra = (MsgBodyExtraOuterClass.ImgExtra) codedInputStream.readMessage(MsgBodyExtraOuterClass.ImgExtra.parser(), extensionRegistryLite);
                                    this.imgExtra_ = imgExtra;
                                    if (builder2 != null) {
                                        builder2.mergeFrom(imgExtra);
                                        this.imgExtra_ = builder2.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 26:
                                    MsgBodyExtraOuterClass.LocationExtra.Builder builder3 = this.locationExtra_ != null ? this.locationExtra_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.LocationExtra locationExtra = (MsgBodyExtraOuterClass.LocationExtra) codedInputStream.readMessage(MsgBodyExtraOuterClass.LocationExtra.parser(), extensionRegistryLite);
                                    this.locationExtra_ = locationExtra;
                                    if (builder3 != null) {
                                        builder3.mergeFrom(locationExtra);
                                        this.locationExtra_ = builder3.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 34:
                                    MsgBodyExtraOuterClass.VideoExtra.Builder builder4 = this.videoExtra_ != null ? this.videoExtra_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.VideoExtra videoExtra = (MsgBodyExtraOuterClass.VideoExtra) codedInputStream.readMessage(MsgBodyExtraOuterClass.VideoExtra.parser(), extensionRegistryLite);
                                    this.videoExtra_ = videoExtra;
                                    if (builder4 != null) {
                                        builder4.mergeFrom(videoExtra);
                                        this.videoExtra_ = builder4.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 42:
                                    MsgBodyExtraOuterClass.GroupCardExtra.Builder builder5 = this.groupCardExtra_ != null ? this.groupCardExtra_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.GroupCardExtra groupCardExtra = (MsgBodyExtraOuterClass.GroupCardExtra) codedInputStream.readMessage(MsgBodyExtraOuterClass.GroupCardExtra.parser(), extensionRegistryLite);
                                    this.groupCardExtra_ = groupCardExtra;
                                    if (builder5 != null) {
                                        builder5.mergeFrom(groupCardExtra);
                                        this.groupCardExtra_ = builder5.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 50:
                                    MsgBodyExtraOuterClass.LiveShareExtra.Builder builder6 = this.liveShareExtra_ != null ? this.liveShareExtra_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.LiveShareExtra liveShareExtra = (MsgBodyExtraOuterClass.LiveShareExtra) codedInputStream.readMessage(MsgBodyExtraOuterClass.LiveShareExtra.parser(), extensionRegistryLite);
                                    this.liveShareExtra_ = liveShareExtra;
                                    if (builder6 != null) {
                                        builder6.mergeFrom(liveShareExtra);
                                        this.liveShareExtra_ = builder6.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 58:
                                    MsgBodyExtraOuterClass.ImageTextExtra.Builder builder7 = this.imagetextExtra_ != null ? this.imagetextExtra_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.ImageTextExtra imageTextExtra = (MsgBodyExtraOuterClass.ImageTextExtra) codedInputStream.readMessage(MsgBodyExtraOuterClass.ImageTextExtra.parser(), extensionRegistryLite);
                                    this.imagetextExtra_ = imageTextExtra;
                                    if (builder7 != null) {
                                        builder7.mergeFrom(imageTextExtra);
                                        this.imagetextExtra_ = builder7.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 66:
                                    MsgBodyExtraOuterClass.HidenAlbumExtra.Builder builder8 = this.hidenAlbumExtra_ != null ? this.hidenAlbumExtra_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.HidenAlbumExtra hidenAlbumExtra = (MsgBodyExtraOuterClass.HidenAlbumExtra) codedInputStream.readMessage(MsgBodyExtraOuterClass.HidenAlbumExtra.parser(), extensionRegistryLite);
                                    this.hidenAlbumExtra_ = hidenAlbumExtra;
                                    if (builder8 != null) {
                                        builder8.mergeFrom(hidenAlbumExtra);
                                        this.hidenAlbumExtra_ = builder8.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 82:
                                    MsgBodyExtraOuterClass.ShareExtra.Builder builder9 = this.shareExtra_ != null ? this.shareExtra_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.ShareExtra shareExtra = (MsgBodyExtraOuterClass.ShareExtra) codedInputStream.readMessage(MsgBodyExtraOuterClass.ShareExtra.parser(), extensionRegistryLite);
                                    this.shareExtra_ = shareExtra;
                                    if (builder9 != null) {
                                        builder9.mergeFrom(shareExtra);
                                        this.shareExtra_ = builder9.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 90:
                                    MsgBodyExtraOuterClass.VipExtra.Builder builder10 = this.vipExtra_ != null ? this.vipExtra_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.VipExtra vipExtra = (MsgBodyExtraOuterClass.VipExtra) codedInputStream.readMessage(MsgBodyExtraOuterClass.VipExtra.parser(), extensionRegistryLite);
                                    this.vipExtra_ = vipExtra;
                                    if (builder10 != null) {
                                        builder10.mergeFrom(vipExtra);
                                        this.vipExtra_ = builder10.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 98:
                                    MsgBodyExtraOuterClass.GiftExtra.Builder builder11 = this.giftExtra_ != null ? this.giftExtra_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.GiftExtra giftExtra = (MsgBodyExtraOuterClass.GiftExtra) codedInputStream.readMessage(MsgBodyExtraOuterClass.GiftExtra.parser(), extensionRegistryLite);
                                    this.giftExtra_ = giftExtra;
                                    if (builder11 != null) {
                                        builder11.mergeFrom(giftExtra);
                                        this.giftExtra_ = builder11.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 106:
                                    MsgBodyExtraOuterClass.SysNoticeExtra.Builder builder12 = this.sysNoticeExtra_ != null ? this.sysNoticeExtra_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.SysNoticeExtra sysNoticeExtra = (MsgBodyExtraOuterClass.SysNoticeExtra) codedInputStream.readMessage(MsgBodyExtraOuterClass.SysNoticeExtra.parser(), extensionRegistryLite);
                                    this.sysNoticeExtra_ = sysNoticeExtra;
                                    if (builder12 != null) {
                                        builder12.mergeFrom(sysNoticeExtra);
                                        this.sysNoticeExtra_ = builder12.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 114:
                                    MsgBodyExtraOuterClass.VideoChatCallingExtra.Builder builder13 = this.videoCallingExtra_ != null ? this.videoCallingExtra_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.VideoChatCallingExtra videoChatCallingExtra = (MsgBodyExtraOuterClass.VideoChatCallingExtra) codedInputStream.readMessage(MsgBodyExtraOuterClass.VideoChatCallingExtra.parser(), extensionRegistryLite);
                                    this.videoCallingExtra_ = videoChatCallingExtra;
                                    if (builder13 != null) {
                                        builder13.mergeFrom(videoChatCallingExtra);
                                        this.videoCallingExtra_ = builder13.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 122:
                                    MsgBodyExtraOuterClass.VideoChatEndExtra.Builder builder14 = this.videoEndExtra_ != null ? this.videoEndExtra_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.VideoChatEndExtra videoChatEndExtra = (MsgBodyExtraOuterClass.VideoChatEndExtra) codedInputStream.readMessage(MsgBodyExtraOuterClass.VideoChatEndExtra.parser(), extensionRegistryLite);
                                    this.videoEndExtra_ = videoChatEndExtra;
                                    if (builder14 != null) {
                                        builder14.mergeFrom(videoChatEndExtra);
                                        this.videoEndExtra_ = builder14.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 130:
                                    MsgBodyExtraOuterClass.FeedShareExtra.Builder builder15 = this.feedShareExtra_ != null ? this.feedShareExtra_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.FeedShareExtra feedShareExtra = (MsgBodyExtraOuterClass.FeedShareExtra) codedInputStream.readMessage(MsgBodyExtraOuterClass.FeedShareExtra.parser(), extensionRegistryLite);
                                    this.feedShareExtra_ = feedShareExtra;
                                    if (builder15 != null) {
                                        builder15.mergeFrom(feedShareExtra);
                                        this.feedShareExtra_ = builder15.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 138:
                                    MsgBodyExtraOuterClass.SayHiExtra.Builder builder16 = this.sayHiExtra_ != null ? this.sayHiExtra_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.SayHiExtra sayHiExtra = (MsgBodyExtraOuterClass.SayHiExtra) codedInputStream.readMessage(MsgBodyExtraOuterClass.SayHiExtra.parser(), extensionRegistryLite);
                                    this.sayHiExtra_ = sayHiExtra;
                                    if (builder16 != null) {
                                        builder16.mergeFrom(sayHiExtra);
                                        this.sayHiExtra_ = builder16.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 146:
                                    MsgBodyExtraOuterClass.VoiceRoomShareExtra.Builder builder17 = this.voiceRoomShareExtra_ != null ? this.voiceRoomShareExtra_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.VoiceRoomShareExtra voiceRoomShareExtra = (MsgBodyExtraOuterClass.VoiceRoomShareExtra) codedInputStream.readMessage(MsgBodyExtraOuterClass.VoiceRoomShareExtra.parser(), extensionRegistryLite);
                                    this.voiceRoomShareExtra_ = voiceRoomShareExtra;
                                    if (builder17 != null) {
                                        builder17.mergeFrom(voiceRoomShareExtra);
                                        this.voiceRoomShareExtra_ = builder17.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 154:
                                    MsgBodyExtraOuterClass.LiveShareInternationalExtra.Builder builder18 = this.liveShareInternationalExtra_ != null ? this.liveShareInternationalExtra_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.LiveShareInternationalExtra liveShareInternationalExtra = (MsgBodyExtraOuterClass.LiveShareInternationalExtra) codedInputStream.readMessage(MsgBodyExtraOuterClass.LiveShareInternationalExtra.parser(), extensionRegistryLite);
                                    this.liveShareInternationalExtra_ = liveShareInternationalExtra;
                                    if (builder18 != null) {
                                        builder18.mergeFrom(liveShareInternationalExtra);
                                        this.liveShareInternationalExtra_ = builder18.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 162:
                                    MsgBodyExtraOuterClass.DoodleShareExtra.Builder builder19 = this.doodleShareExtra_ != null ? this.doodleShareExtra_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.DoodleShareExtra doodleShareExtra = (MsgBodyExtraOuterClass.DoodleShareExtra) codedInputStream.readMessage(MsgBodyExtraOuterClass.DoodleShareExtra.parser(), extensionRegistryLite);
                                    this.doodleShareExtra_ = doodleShareExtra;
                                    if (builder19 != null) {
                                        builder19.mergeFrom(doodleShareExtra);
                                        this.doodleShareExtra_ = builder19.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 170:
                                    MsgBodyExtraOuterClass.GroupNotice.Builder builder20 = this.groupNotice_ != null ? this.groupNotice_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.GroupNotice groupNotice = (MsgBodyExtraOuterClass.GroupNotice) codedInputStream.readMessage(MsgBodyExtraOuterClass.GroupNotice.parser(), extensionRegistryLite);
                                    this.groupNotice_ = groupNotice;
                                    if (builder20 != null) {
                                        builder20.mergeFrom(groupNotice);
                                        this.groupNotice_ = builder20.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 178:
                                    MsgBodyExtraOuterClass.EvaluationExtra.Builder builder21 = this.evaluationExtra_ != null ? this.evaluationExtra_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.EvaluationExtra evaluationExtra = (MsgBodyExtraOuterClass.EvaluationExtra) codedInputStream.readMessage(MsgBodyExtraOuterClass.EvaluationExtra.parser(), extensionRegistryLite);
                                    this.evaluationExtra_ = evaluationExtra;
                                    if (builder21 != null) {
                                        builder21.mergeFrom(evaluationExtra);
                                        this.evaluationExtra_ = builder21.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 186:
                                    MsgBodyExtraOuterClass.SecureNotify.Builder builder22 = this.secureNotify_ != null ? this.secureNotify_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.SecureNotify secureNotify = (MsgBodyExtraOuterClass.SecureNotify) codedInputStream.readMessage(MsgBodyExtraOuterClass.SecureNotify.parser(), extensionRegistryLite);
                                    this.secureNotify_ = secureNotify;
                                    if (builder22 != null) {
                                        builder22.mergeFrom(secureNotify);
                                        this.secureNotify_ = builder22.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 194:
                                    MsgBodyExtraOuterClass.ActivityShareExtra.Builder builder23 = this.activityShareExtra_ != null ? this.activityShareExtra_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.ActivityShareExtra activityShareExtra = (MsgBodyExtraOuterClass.ActivityShareExtra) codedInputStream.readMessage(MsgBodyExtraOuterClass.ActivityShareExtra.parser(), extensionRegistryLite);
                                    this.activityShareExtra_ = activityShareExtra;
                                    if (builder23 != null) {
                                        builder23.mergeFrom(activityShareExtra);
                                        this.activityShareExtra_ = builder23.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 202:
                                    MsgBodyExtraOuterClass.FriendsCircleExtra.Builder builder24 = this.friendsCircleExtra_ != null ? this.friendsCircleExtra_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.FriendsCircleExtra friendsCircleExtra = (MsgBodyExtraOuterClass.FriendsCircleExtra) codedInputStream.readMessage(MsgBodyExtraOuterClass.FriendsCircleExtra.parser(), extensionRegistryLite);
                                    this.friendsCircleExtra_ = friendsCircleExtra;
                                    if (builder24 != null) {
                                        builder24.mergeFrom(friendsCircleExtra);
                                        this.friendsCircleExtra_ = builder24.buildPartial();
                                    } else {
                                        continue;
                                    }
                                default:
                                    if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                        break;
                                    } else {
                                        continue;
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

        private MsgExtra(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static MsgExtra getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MsgBodyOuterClass.internal_static_com_blued_im_private_chat_MsgExtra_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MsgExtra msgExtra) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(msgExtra);
        }

        public static MsgExtra parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (MsgExtra) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static MsgExtra parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MsgExtra) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static MsgExtra parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static MsgExtra parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static MsgExtra parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (MsgExtra) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static MsgExtra parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MsgExtra) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static MsgExtra parseFrom(InputStream inputStream) throws IOException {
            return (MsgExtra) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static MsgExtra parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MsgExtra) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static MsgExtra parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static MsgExtra parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static MsgExtra parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static MsgExtra parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<MsgExtra> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof MsgExtra) {
                MsgExtra msgExtra = (MsgExtra) obj;
                if (hasTextExtra() != msgExtra.hasTextExtra()) {
                    return false;
                }
                if ((!hasTextExtra() || getTextExtra().equals(msgExtra.getTextExtra())) && hasImgExtra() == msgExtra.hasImgExtra()) {
                    if ((!hasImgExtra() || getImgExtra().equals(msgExtra.getImgExtra())) && hasLocationExtra() == msgExtra.hasLocationExtra()) {
                        if ((!hasLocationExtra() || getLocationExtra().equals(msgExtra.getLocationExtra())) && hasVideoExtra() == msgExtra.hasVideoExtra()) {
                            if ((!hasVideoExtra() || getVideoExtra().equals(msgExtra.getVideoExtra())) && hasGroupCardExtra() == msgExtra.hasGroupCardExtra()) {
                                if ((!hasGroupCardExtra() || getGroupCardExtra().equals(msgExtra.getGroupCardExtra())) && hasLiveShareExtra() == msgExtra.hasLiveShareExtra()) {
                                    if ((!hasLiveShareExtra() || getLiveShareExtra().equals(msgExtra.getLiveShareExtra())) && hasImagetextExtra() == msgExtra.hasImagetextExtra()) {
                                        if ((!hasImagetextExtra() || getImagetextExtra().equals(msgExtra.getImagetextExtra())) && hasHidenAlbumExtra() == msgExtra.hasHidenAlbumExtra()) {
                                            if ((!hasHidenAlbumExtra() || getHidenAlbumExtra().equals(msgExtra.getHidenAlbumExtra())) && hasShareExtra() == msgExtra.hasShareExtra()) {
                                                if ((!hasShareExtra() || getShareExtra().equals(msgExtra.getShareExtra())) && hasVipExtra() == msgExtra.hasVipExtra()) {
                                                    if ((!hasVipExtra() || getVipExtra().equals(msgExtra.getVipExtra())) && hasGiftExtra() == msgExtra.hasGiftExtra()) {
                                                        if ((!hasGiftExtra() || getGiftExtra().equals(msgExtra.getGiftExtra())) && hasSysNoticeExtra() == msgExtra.hasSysNoticeExtra()) {
                                                            if ((!hasSysNoticeExtra() || getSysNoticeExtra().equals(msgExtra.getSysNoticeExtra())) && hasVideoCallingExtra() == msgExtra.hasVideoCallingExtra()) {
                                                                if ((!hasVideoCallingExtra() || getVideoCallingExtra().equals(msgExtra.getVideoCallingExtra())) && hasVideoEndExtra() == msgExtra.hasVideoEndExtra()) {
                                                                    if ((!hasVideoEndExtra() || getVideoEndExtra().equals(msgExtra.getVideoEndExtra())) && hasFeedShareExtra() == msgExtra.hasFeedShareExtra()) {
                                                                        if ((!hasFeedShareExtra() || getFeedShareExtra().equals(msgExtra.getFeedShareExtra())) && hasSayHiExtra() == msgExtra.hasSayHiExtra()) {
                                                                            if ((!hasSayHiExtra() || getSayHiExtra().equals(msgExtra.getSayHiExtra())) && hasVoiceRoomShareExtra() == msgExtra.hasVoiceRoomShareExtra()) {
                                                                                if ((!hasVoiceRoomShareExtra() || getVoiceRoomShareExtra().equals(msgExtra.getVoiceRoomShareExtra())) && hasLiveShareInternationalExtra() == msgExtra.hasLiveShareInternationalExtra()) {
                                                                                    if ((!hasLiveShareInternationalExtra() || getLiveShareInternationalExtra().equals(msgExtra.getLiveShareInternationalExtra())) && hasDoodleShareExtra() == msgExtra.hasDoodleShareExtra()) {
                                                                                        if ((!hasDoodleShareExtra() || getDoodleShareExtra().equals(msgExtra.getDoodleShareExtra())) && hasGroupNotice() == msgExtra.hasGroupNotice()) {
                                                                                            if ((!hasGroupNotice() || getGroupNotice().equals(msgExtra.getGroupNotice())) && hasEvaluationExtra() == msgExtra.hasEvaluationExtra()) {
                                                                                                if ((!hasEvaluationExtra() || getEvaluationExtra().equals(msgExtra.getEvaluationExtra())) && hasSecureNotify() == msgExtra.hasSecureNotify()) {
                                                                                                    if ((!hasSecureNotify() || getSecureNotify().equals(msgExtra.getSecureNotify())) && hasActivityShareExtra() == msgExtra.hasActivityShareExtra()) {
                                                                                                        if ((!hasActivityShareExtra() || getActivityShareExtra().equals(msgExtra.getActivityShareExtra())) && hasFriendsCircleExtra() == msgExtra.hasFriendsCircleExtra()) {
                                                                                                            return (!hasFriendsCircleExtra() || getFriendsCircleExtra().equals(msgExtra.getFriendsCircleExtra())) && this.unknownFields.equals(msgExtra.unknownFields);
                                                                                                        }
                                                                                                        return false;
                                                                                                    }
                                                                                                    return false;
                                                                                                }
                                                                                                return false;
                                                                                            }
                                                                                            return false;
                                                                                        }
                                                                                        return false;
                                                                                    }
                                                                                    return false;
                                                                                }
                                                                                return false;
                                                                            }
                                                                            return false;
                                                                        }
                                                                        return false;
                                                                    }
                                                                    return false;
                                                                }
                                                                return false;
                                                            }
                                                            return false;
                                                        }
                                                        return false;
                                                    }
                                                    return false;
                                                }
                                                return false;
                                            }
                                            return false;
                                        }
                                        return false;
                                    }
                                    return false;
                                }
                                return false;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return super.equals(obj);
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.ActivityShareExtra getActivityShareExtra() {
            MsgBodyExtraOuterClass.ActivityShareExtra activityShareExtra = this.activityShareExtra_;
            MsgBodyExtraOuterClass.ActivityShareExtra activityShareExtra2 = activityShareExtra;
            if (activityShareExtra == null) {
                activityShareExtra2 = MsgBodyExtraOuterClass.ActivityShareExtra.getDefaultInstance();
            }
            return activityShareExtra2;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.ActivityShareExtraOrBuilder getActivityShareExtraOrBuilder() {
            return getActivityShareExtra();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MsgExtra getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.DoodleShareExtra getDoodleShareExtra() {
            MsgBodyExtraOuterClass.DoodleShareExtra doodleShareExtra = this.doodleShareExtra_;
            MsgBodyExtraOuterClass.DoodleShareExtra doodleShareExtra2 = doodleShareExtra;
            if (doodleShareExtra == null) {
                doodleShareExtra2 = MsgBodyExtraOuterClass.DoodleShareExtra.getDefaultInstance();
            }
            return doodleShareExtra2;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.DoodleShareExtraOrBuilder getDoodleShareExtraOrBuilder() {
            return getDoodleShareExtra();
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.EvaluationExtra getEvaluationExtra() {
            MsgBodyExtraOuterClass.EvaluationExtra evaluationExtra = this.evaluationExtra_;
            MsgBodyExtraOuterClass.EvaluationExtra evaluationExtra2 = evaluationExtra;
            if (evaluationExtra == null) {
                evaluationExtra2 = MsgBodyExtraOuterClass.EvaluationExtra.getDefaultInstance();
            }
            return evaluationExtra2;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.EvaluationExtraOrBuilder getEvaluationExtraOrBuilder() {
            return getEvaluationExtra();
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.FeedShareExtra getFeedShareExtra() {
            MsgBodyExtraOuterClass.FeedShareExtra feedShareExtra = this.feedShareExtra_;
            MsgBodyExtraOuterClass.FeedShareExtra feedShareExtra2 = feedShareExtra;
            if (feedShareExtra == null) {
                feedShareExtra2 = MsgBodyExtraOuterClass.FeedShareExtra.getDefaultInstance();
            }
            return feedShareExtra2;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.FeedShareExtraOrBuilder getFeedShareExtraOrBuilder() {
            return getFeedShareExtra();
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.FriendsCircleExtra getFriendsCircleExtra() {
            MsgBodyExtraOuterClass.FriendsCircleExtra friendsCircleExtra = this.friendsCircleExtra_;
            MsgBodyExtraOuterClass.FriendsCircleExtra friendsCircleExtra2 = friendsCircleExtra;
            if (friendsCircleExtra == null) {
                friendsCircleExtra2 = MsgBodyExtraOuterClass.FriendsCircleExtra.getDefaultInstance();
            }
            return friendsCircleExtra2;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.FriendsCircleExtraOrBuilder getFriendsCircleExtraOrBuilder() {
            return getFriendsCircleExtra();
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.GiftExtra getGiftExtra() {
            MsgBodyExtraOuterClass.GiftExtra giftExtra = this.giftExtra_;
            MsgBodyExtraOuterClass.GiftExtra giftExtra2 = giftExtra;
            if (giftExtra == null) {
                giftExtra2 = MsgBodyExtraOuterClass.GiftExtra.getDefaultInstance();
            }
            return giftExtra2;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.GiftExtraOrBuilder getGiftExtraOrBuilder() {
            return getGiftExtra();
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.GroupCardExtra getGroupCardExtra() {
            MsgBodyExtraOuterClass.GroupCardExtra groupCardExtra = this.groupCardExtra_;
            MsgBodyExtraOuterClass.GroupCardExtra groupCardExtra2 = groupCardExtra;
            if (groupCardExtra == null) {
                groupCardExtra2 = MsgBodyExtraOuterClass.GroupCardExtra.getDefaultInstance();
            }
            return groupCardExtra2;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.GroupCardExtraOrBuilder getGroupCardExtraOrBuilder() {
            return getGroupCardExtra();
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.GroupNotice getGroupNotice() {
            MsgBodyExtraOuterClass.GroupNotice groupNotice = this.groupNotice_;
            MsgBodyExtraOuterClass.GroupNotice groupNotice2 = groupNotice;
            if (groupNotice == null) {
                groupNotice2 = MsgBodyExtraOuterClass.GroupNotice.getDefaultInstance();
            }
            return groupNotice2;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.GroupNoticeOrBuilder getGroupNoticeOrBuilder() {
            return getGroupNotice();
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.HidenAlbumExtra getHidenAlbumExtra() {
            MsgBodyExtraOuterClass.HidenAlbumExtra hidenAlbumExtra = this.hidenAlbumExtra_;
            MsgBodyExtraOuterClass.HidenAlbumExtra hidenAlbumExtra2 = hidenAlbumExtra;
            if (hidenAlbumExtra == null) {
                hidenAlbumExtra2 = MsgBodyExtraOuterClass.HidenAlbumExtra.getDefaultInstance();
            }
            return hidenAlbumExtra2;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.HidenAlbumExtraOrBuilder getHidenAlbumExtraOrBuilder() {
            return getHidenAlbumExtra();
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.ImageTextExtra getImagetextExtra() {
            MsgBodyExtraOuterClass.ImageTextExtra imageTextExtra = this.imagetextExtra_;
            MsgBodyExtraOuterClass.ImageTextExtra imageTextExtra2 = imageTextExtra;
            if (imageTextExtra == null) {
                imageTextExtra2 = MsgBodyExtraOuterClass.ImageTextExtra.getDefaultInstance();
            }
            return imageTextExtra2;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.ImageTextExtraOrBuilder getImagetextExtraOrBuilder() {
            return getImagetextExtra();
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.ImgExtra getImgExtra() {
            MsgBodyExtraOuterClass.ImgExtra imgExtra = this.imgExtra_;
            MsgBodyExtraOuterClass.ImgExtra imgExtra2 = imgExtra;
            if (imgExtra == null) {
                imgExtra2 = MsgBodyExtraOuterClass.ImgExtra.getDefaultInstance();
            }
            return imgExtra2;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.ImgExtraOrBuilder getImgExtraOrBuilder() {
            return getImgExtra();
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.LiveShareExtra getLiveShareExtra() {
            MsgBodyExtraOuterClass.LiveShareExtra liveShareExtra = this.liveShareExtra_;
            MsgBodyExtraOuterClass.LiveShareExtra liveShareExtra2 = liveShareExtra;
            if (liveShareExtra == null) {
                liveShareExtra2 = MsgBodyExtraOuterClass.LiveShareExtra.getDefaultInstance();
            }
            return liveShareExtra2;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.LiveShareExtraOrBuilder getLiveShareExtraOrBuilder() {
            return getLiveShareExtra();
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.LiveShareInternationalExtra getLiveShareInternationalExtra() {
            MsgBodyExtraOuterClass.LiveShareInternationalExtra liveShareInternationalExtra = this.liveShareInternationalExtra_;
            MsgBodyExtraOuterClass.LiveShareInternationalExtra liveShareInternationalExtra2 = liveShareInternationalExtra;
            if (liveShareInternationalExtra == null) {
                liveShareInternationalExtra2 = MsgBodyExtraOuterClass.LiveShareInternationalExtra.getDefaultInstance();
            }
            return liveShareInternationalExtra2;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.LiveShareInternationalExtraOrBuilder getLiveShareInternationalExtraOrBuilder() {
            return getLiveShareInternationalExtra();
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.LocationExtra getLocationExtra() {
            MsgBodyExtraOuterClass.LocationExtra locationExtra = this.locationExtra_;
            MsgBodyExtraOuterClass.LocationExtra locationExtra2 = locationExtra;
            if (locationExtra == null) {
                locationExtra2 = MsgBodyExtraOuterClass.LocationExtra.getDefaultInstance();
            }
            return locationExtra2;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.LocationExtraOrBuilder getLocationExtraOrBuilder() {
            return getLocationExtra();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MsgExtra> getParserForType() {
            return PARSER;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.SayHiExtra getSayHiExtra() {
            MsgBodyExtraOuterClass.SayHiExtra sayHiExtra = this.sayHiExtra_;
            MsgBodyExtraOuterClass.SayHiExtra sayHiExtra2 = sayHiExtra;
            if (sayHiExtra == null) {
                sayHiExtra2 = MsgBodyExtraOuterClass.SayHiExtra.getDefaultInstance();
            }
            return sayHiExtra2;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.SayHiExtraOrBuilder getSayHiExtraOrBuilder() {
            return getSayHiExtra();
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.SecureNotify getSecureNotify() {
            MsgBodyExtraOuterClass.SecureNotify secureNotify = this.secureNotify_;
            MsgBodyExtraOuterClass.SecureNotify secureNotify2 = secureNotify;
            if (secureNotify == null) {
                secureNotify2 = MsgBodyExtraOuterClass.SecureNotify.getDefaultInstance();
            }
            return secureNotify2;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.SecureNotifyOrBuilder getSecureNotifyOrBuilder() {
            return getSecureNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (this.textExtra_ != null) {
                i2 = 0 + CodedOutputStream.computeMessageSize(1, getTextExtra());
            }
            int i3 = i2;
            if (this.imgExtra_ != null) {
                i3 = i2 + CodedOutputStream.computeMessageSize(2, getImgExtra());
            }
            int i4 = i3;
            if (this.locationExtra_ != null) {
                i4 = i3 + CodedOutputStream.computeMessageSize(3, getLocationExtra());
            }
            int i5 = i4;
            if (this.videoExtra_ != null) {
                i5 = i4 + CodedOutputStream.computeMessageSize(4, getVideoExtra());
            }
            int i6 = i5;
            if (this.groupCardExtra_ != null) {
                i6 = i5 + CodedOutputStream.computeMessageSize(5, getGroupCardExtra());
            }
            int i7 = i6;
            if (this.liveShareExtra_ != null) {
                i7 = i6 + CodedOutputStream.computeMessageSize(6, getLiveShareExtra());
            }
            int i8 = i7;
            if (this.imagetextExtra_ != null) {
                i8 = i7 + CodedOutputStream.computeMessageSize(7, getImagetextExtra());
            }
            int i9 = i8;
            if (this.hidenAlbumExtra_ != null) {
                i9 = i8 + CodedOutputStream.computeMessageSize(8, getHidenAlbumExtra());
            }
            int i10 = i9;
            if (this.shareExtra_ != null) {
                i10 = i9 + CodedOutputStream.computeMessageSize(10, getShareExtra());
            }
            int i11 = i10;
            if (this.vipExtra_ != null) {
                i11 = i10 + CodedOutputStream.computeMessageSize(11, getVipExtra());
            }
            int i12 = i11;
            if (this.giftExtra_ != null) {
                i12 = i11 + CodedOutputStream.computeMessageSize(12, getGiftExtra());
            }
            int i13 = i12;
            if (this.sysNoticeExtra_ != null) {
                i13 = i12 + CodedOutputStream.computeMessageSize(13, getSysNoticeExtra());
            }
            int i14 = i13;
            if (this.videoCallingExtra_ != null) {
                i14 = i13 + CodedOutputStream.computeMessageSize(14, getVideoCallingExtra());
            }
            int i15 = i14;
            if (this.videoEndExtra_ != null) {
                i15 = i14 + CodedOutputStream.computeMessageSize(15, getVideoEndExtra());
            }
            int i16 = i15;
            if (this.feedShareExtra_ != null) {
                i16 = i15 + CodedOutputStream.computeMessageSize(16, getFeedShareExtra());
            }
            int i17 = i16;
            if (this.sayHiExtra_ != null) {
                i17 = i16 + CodedOutputStream.computeMessageSize(17, getSayHiExtra());
            }
            int i18 = i17;
            if (this.voiceRoomShareExtra_ != null) {
                i18 = i17 + CodedOutputStream.computeMessageSize(18, getVoiceRoomShareExtra());
            }
            int i19 = i18;
            if (this.liveShareInternationalExtra_ != null) {
                i19 = i18 + CodedOutputStream.computeMessageSize(19, getLiveShareInternationalExtra());
            }
            int i20 = i19;
            if (this.doodleShareExtra_ != null) {
                i20 = i19 + CodedOutputStream.computeMessageSize(20, getDoodleShareExtra());
            }
            int i21 = i20;
            if (this.groupNotice_ != null) {
                i21 = i20 + CodedOutputStream.computeMessageSize(21, getGroupNotice());
            }
            int i22 = i21;
            if (this.evaluationExtra_ != null) {
                i22 = i21 + CodedOutputStream.computeMessageSize(22, getEvaluationExtra());
            }
            int i23 = i22;
            if (this.secureNotify_ != null) {
                i23 = i22 + CodedOutputStream.computeMessageSize(23, getSecureNotify());
            }
            int i24 = i23;
            if (this.activityShareExtra_ != null) {
                i24 = i23 + CodedOutputStream.computeMessageSize(24, getActivityShareExtra());
            }
            int i25 = i24;
            if (this.friendsCircleExtra_ != null) {
                i25 = i24 + CodedOutputStream.computeMessageSize(25, getFriendsCircleExtra());
            }
            int serializedSize = i25 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.ShareExtra getShareExtra() {
            MsgBodyExtraOuterClass.ShareExtra shareExtra = this.shareExtra_;
            MsgBodyExtraOuterClass.ShareExtra shareExtra2 = shareExtra;
            if (shareExtra == null) {
                shareExtra2 = MsgBodyExtraOuterClass.ShareExtra.getDefaultInstance();
            }
            return shareExtra2;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.ShareExtraOrBuilder getShareExtraOrBuilder() {
            return getShareExtra();
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.SysNoticeExtra getSysNoticeExtra() {
            MsgBodyExtraOuterClass.SysNoticeExtra sysNoticeExtra = this.sysNoticeExtra_;
            MsgBodyExtraOuterClass.SysNoticeExtra sysNoticeExtra2 = sysNoticeExtra;
            if (sysNoticeExtra == null) {
                sysNoticeExtra2 = MsgBodyExtraOuterClass.SysNoticeExtra.getDefaultInstance();
            }
            return sysNoticeExtra2;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.SysNoticeExtraOrBuilder getSysNoticeExtraOrBuilder() {
            return getSysNoticeExtra();
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.TextExtra getTextExtra() {
            MsgBodyExtraOuterClass.TextExtra textExtra = this.textExtra_;
            MsgBodyExtraOuterClass.TextExtra textExtra2 = textExtra;
            if (textExtra == null) {
                textExtra2 = MsgBodyExtraOuterClass.TextExtra.getDefaultInstance();
            }
            return textExtra2;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.TextExtraOrBuilder getTextExtraOrBuilder() {
            return getTextExtra();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.VideoChatCallingExtra getVideoCallingExtra() {
            MsgBodyExtraOuterClass.VideoChatCallingExtra videoChatCallingExtra = this.videoCallingExtra_;
            MsgBodyExtraOuterClass.VideoChatCallingExtra videoChatCallingExtra2 = videoChatCallingExtra;
            if (videoChatCallingExtra == null) {
                videoChatCallingExtra2 = MsgBodyExtraOuterClass.VideoChatCallingExtra.getDefaultInstance();
            }
            return videoChatCallingExtra2;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.VideoChatCallingExtraOrBuilder getVideoCallingExtraOrBuilder() {
            return getVideoCallingExtra();
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.VideoChatEndExtra getVideoEndExtra() {
            MsgBodyExtraOuterClass.VideoChatEndExtra videoChatEndExtra = this.videoEndExtra_;
            MsgBodyExtraOuterClass.VideoChatEndExtra videoChatEndExtra2 = videoChatEndExtra;
            if (videoChatEndExtra == null) {
                videoChatEndExtra2 = MsgBodyExtraOuterClass.VideoChatEndExtra.getDefaultInstance();
            }
            return videoChatEndExtra2;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.VideoChatEndExtraOrBuilder getVideoEndExtraOrBuilder() {
            return getVideoEndExtra();
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.VideoExtra getVideoExtra() {
            MsgBodyExtraOuterClass.VideoExtra videoExtra = this.videoExtra_;
            MsgBodyExtraOuterClass.VideoExtra videoExtra2 = videoExtra;
            if (videoExtra == null) {
                videoExtra2 = MsgBodyExtraOuterClass.VideoExtra.getDefaultInstance();
            }
            return videoExtra2;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.VideoExtraOrBuilder getVideoExtraOrBuilder() {
            return getVideoExtra();
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.VipExtra getVipExtra() {
            MsgBodyExtraOuterClass.VipExtra vipExtra = this.vipExtra_;
            MsgBodyExtraOuterClass.VipExtra vipExtra2 = vipExtra;
            if (vipExtra == null) {
                vipExtra2 = MsgBodyExtraOuterClass.VipExtra.getDefaultInstance();
            }
            return vipExtra2;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.VipExtraOrBuilder getVipExtraOrBuilder() {
            return getVipExtra();
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.VoiceRoomShareExtra getVoiceRoomShareExtra() {
            MsgBodyExtraOuterClass.VoiceRoomShareExtra voiceRoomShareExtra = this.voiceRoomShareExtra_;
            MsgBodyExtraOuterClass.VoiceRoomShareExtra voiceRoomShareExtra2 = voiceRoomShareExtra;
            if (voiceRoomShareExtra == null) {
                voiceRoomShareExtra2 = MsgBodyExtraOuterClass.VoiceRoomShareExtra.getDefaultInstance();
            }
            return voiceRoomShareExtra2;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public MsgBodyExtraOuterClass.VoiceRoomShareExtraOrBuilder getVoiceRoomShareExtraOrBuilder() {
            return getVoiceRoomShareExtra();
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public boolean hasActivityShareExtra() {
            return this.activityShareExtra_ != null;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public boolean hasDoodleShareExtra() {
            return this.doodleShareExtra_ != null;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public boolean hasEvaluationExtra() {
            return this.evaluationExtra_ != null;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public boolean hasFeedShareExtra() {
            return this.feedShareExtra_ != null;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public boolean hasFriendsCircleExtra() {
            return this.friendsCircleExtra_ != null;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public boolean hasGiftExtra() {
            return this.giftExtra_ != null;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public boolean hasGroupCardExtra() {
            return this.groupCardExtra_ != null;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public boolean hasGroupNotice() {
            return this.groupNotice_ != null;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public boolean hasHidenAlbumExtra() {
            return this.hidenAlbumExtra_ != null;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public boolean hasImagetextExtra() {
            return this.imagetextExtra_ != null;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public boolean hasImgExtra() {
            return this.imgExtra_ != null;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public boolean hasLiveShareExtra() {
            return this.liveShareExtra_ != null;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public boolean hasLiveShareInternationalExtra() {
            return this.liveShareInternationalExtra_ != null;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public boolean hasLocationExtra() {
            return this.locationExtra_ != null;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public boolean hasSayHiExtra() {
            return this.sayHiExtra_ != null;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public boolean hasSecureNotify() {
            return this.secureNotify_ != null;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public boolean hasShareExtra() {
            return this.shareExtra_ != null;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public boolean hasSysNoticeExtra() {
            return this.sysNoticeExtra_ != null;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public boolean hasTextExtra() {
            return this.textExtra_ != null;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public boolean hasVideoCallingExtra() {
            return this.videoCallingExtra_ != null;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public boolean hasVideoEndExtra() {
            return this.videoEndExtra_ != null;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public boolean hasVideoExtra() {
            return this.videoExtra_ != null;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public boolean hasVipExtra() {
            return this.vipExtra_ != null;
        }

        @Override // com.blued.im.private_chat.MsgBodyOuterClass.MsgExtraOrBuilder
        public boolean hasVoiceRoomShareExtra() {
            return this.voiceRoomShareExtra_ != null;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hashCode = 779 + getDescriptor().hashCode();
            int i = hashCode;
            if (hasTextExtra()) {
                i = (((hashCode * 37) + 1) * 53) + getTextExtra().hashCode();
            }
            int i2 = i;
            if (hasImgExtra()) {
                i2 = (((i * 37) + 2) * 53) + getImgExtra().hashCode();
            }
            int i3 = i2;
            if (hasLocationExtra()) {
                i3 = (((i2 * 37) + 3) * 53) + getLocationExtra().hashCode();
            }
            int i4 = i3;
            if (hasVideoExtra()) {
                i4 = (((i3 * 37) + 4) * 53) + getVideoExtra().hashCode();
            }
            int i5 = i4;
            if (hasGroupCardExtra()) {
                i5 = (((i4 * 37) + 5) * 53) + getGroupCardExtra().hashCode();
            }
            int i6 = i5;
            if (hasLiveShareExtra()) {
                i6 = (((i5 * 37) + 6) * 53) + getLiveShareExtra().hashCode();
            }
            int i7 = i6;
            if (hasImagetextExtra()) {
                i7 = (((i6 * 37) + 7) * 53) + getImagetextExtra().hashCode();
            }
            int i8 = i7;
            if (hasHidenAlbumExtra()) {
                i8 = (((i7 * 37) + 8) * 53) + getHidenAlbumExtra().hashCode();
            }
            int i9 = i8;
            if (hasShareExtra()) {
                i9 = (((i8 * 37) + 10) * 53) + getShareExtra().hashCode();
            }
            int i10 = i9;
            if (hasVipExtra()) {
                i10 = (((i9 * 37) + 11) * 53) + getVipExtra().hashCode();
            }
            int i11 = i10;
            if (hasGiftExtra()) {
                i11 = (((i10 * 37) + 12) * 53) + getGiftExtra().hashCode();
            }
            int i12 = i11;
            if (hasSysNoticeExtra()) {
                i12 = (((i11 * 37) + 13) * 53) + getSysNoticeExtra().hashCode();
            }
            int i13 = i12;
            if (hasVideoCallingExtra()) {
                i13 = (((i12 * 37) + 14) * 53) + getVideoCallingExtra().hashCode();
            }
            int i14 = i13;
            if (hasVideoEndExtra()) {
                i14 = (((i13 * 37) + 15) * 53) + getVideoEndExtra().hashCode();
            }
            int i15 = i14;
            if (hasFeedShareExtra()) {
                i15 = (((i14 * 37) + 16) * 53) + getFeedShareExtra().hashCode();
            }
            int i16 = i15;
            if (hasSayHiExtra()) {
                i16 = (((i15 * 37) + 17) * 53) + getSayHiExtra().hashCode();
            }
            int i17 = i16;
            if (hasVoiceRoomShareExtra()) {
                i17 = (((i16 * 37) + 18) * 53) + getVoiceRoomShareExtra().hashCode();
            }
            int i18 = i17;
            if (hasLiveShareInternationalExtra()) {
                i18 = (((i17 * 37) + 19) * 53) + getLiveShareInternationalExtra().hashCode();
            }
            int i19 = i18;
            if (hasDoodleShareExtra()) {
                i19 = (((i18 * 37) + 20) * 53) + getDoodleShareExtra().hashCode();
            }
            int i20 = i19;
            if (hasGroupNotice()) {
                i20 = (((i19 * 37) + 21) * 53) + getGroupNotice().hashCode();
            }
            int i21 = i20;
            if (hasEvaluationExtra()) {
                i21 = (((i20 * 37) + 22) * 53) + getEvaluationExtra().hashCode();
            }
            int i22 = i21;
            if (hasSecureNotify()) {
                i22 = (((i21 * 37) + 23) * 53) + getSecureNotify().hashCode();
            }
            int i23 = i22;
            if (hasActivityShareExtra()) {
                i23 = (((i22 * 37) + 24) * 53) + getActivityShareExtra().hashCode();
            }
            int i24 = i23;
            if (hasFriendsCircleExtra()) {
                i24 = (((i23 * 37) + 25) * 53) + getFriendsCircleExtra().hashCode();
            }
            int hashCode2 = (i24 * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MsgBodyOuterClass.internal_static_com_blued_im_private_chat_MsgExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(MsgExtra.class, Builder.class);
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
            return new MsgExtra();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.textExtra_ != null) {
                codedOutputStream.writeMessage(1, getTextExtra());
            }
            if (this.imgExtra_ != null) {
                codedOutputStream.writeMessage(2, getImgExtra());
            }
            if (this.locationExtra_ != null) {
                codedOutputStream.writeMessage(3, getLocationExtra());
            }
            if (this.videoExtra_ != null) {
                codedOutputStream.writeMessage(4, getVideoExtra());
            }
            if (this.groupCardExtra_ != null) {
                codedOutputStream.writeMessage(5, getGroupCardExtra());
            }
            if (this.liveShareExtra_ != null) {
                codedOutputStream.writeMessage(6, getLiveShareExtra());
            }
            if (this.imagetextExtra_ != null) {
                codedOutputStream.writeMessage(7, getImagetextExtra());
            }
            if (this.hidenAlbumExtra_ != null) {
                codedOutputStream.writeMessage(8, getHidenAlbumExtra());
            }
            if (this.shareExtra_ != null) {
                codedOutputStream.writeMessage(10, getShareExtra());
            }
            if (this.vipExtra_ != null) {
                codedOutputStream.writeMessage(11, getVipExtra());
            }
            if (this.giftExtra_ != null) {
                codedOutputStream.writeMessage(12, getGiftExtra());
            }
            if (this.sysNoticeExtra_ != null) {
                codedOutputStream.writeMessage(13, getSysNoticeExtra());
            }
            if (this.videoCallingExtra_ != null) {
                codedOutputStream.writeMessage(14, getVideoCallingExtra());
            }
            if (this.videoEndExtra_ != null) {
                codedOutputStream.writeMessage(15, getVideoEndExtra());
            }
            if (this.feedShareExtra_ != null) {
                codedOutputStream.writeMessage(16, getFeedShareExtra());
            }
            if (this.sayHiExtra_ != null) {
                codedOutputStream.writeMessage(17, getSayHiExtra());
            }
            if (this.voiceRoomShareExtra_ != null) {
                codedOutputStream.writeMessage(18, getVoiceRoomShareExtra());
            }
            if (this.liveShareInternationalExtra_ != null) {
                codedOutputStream.writeMessage(19, getLiveShareInternationalExtra());
            }
            if (this.doodleShareExtra_ != null) {
                codedOutputStream.writeMessage(20, getDoodleShareExtra());
            }
            if (this.groupNotice_ != null) {
                codedOutputStream.writeMessage(21, getGroupNotice());
            }
            if (this.evaluationExtra_ != null) {
                codedOutputStream.writeMessage(22, getEvaluationExtra());
            }
            if (this.secureNotify_ != null) {
                codedOutputStream.writeMessage(23, getSecureNotify());
            }
            if (this.activityShareExtra_ != null) {
                codedOutputStream.writeMessage(24, getActivityShareExtra());
            }
            if (this.friendsCircleExtra_ != null) {
                codedOutputStream.writeMessage(25, getFriendsCircleExtra());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/MsgBodyOuterClass$MsgExtraOrBuilder.class */
    public interface MsgExtraOrBuilder extends MessageOrBuilder {
        MsgBodyExtraOuterClass.ActivityShareExtra getActivityShareExtra();

        MsgBodyExtraOuterClass.ActivityShareExtraOrBuilder getActivityShareExtraOrBuilder();

        MsgBodyExtraOuterClass.DoodleShareExtra getDoodleShareExtra();

        MsgBodyExtraOuterClass.DoodleShareExtraOrBuilder getDoodleShareExtraOrBuilder();

        MsgBodyExtraOuterClass.EvaluationExtra getEvaluationExtra();

        MsgBodyExtraOuterClass.EvaluationExtraOrBuilder getEvaluationExtraOrBuilder();

        MsgBodyExtraOuterClass.FeedShareExtra getFeedShareExtra();

        MsgBodyExtraOuterClass.FeedShareExtraOrBuilder getFeedShareExtraOrBuilder();

        MsgBodyExtraOuterClass.FriendsCircleExtra getFriendsCircleExtra();

        MsgBodyExtraOuterClass.FriendsCircleExtraOrBuilder getFriendsCircleExtraOrBuilder();

        MsgBodyExtraOuterClass.GiftExtra getGiftExtra();

        MsgBodyExtraOuterClass.GiftExtraOrBuilder getGiftExtraOrBuilder();

        MsgBodyExtraOuterClass.GroupCardExtra getGroupCardExtra();

        MsgBodyExtraOuterClass.GroupCardExtraOrBuilder getGroupCardExtraOrBuilder();

        MsgBodyExtraOuterClass.GroupNotice getGroupNotice();

        MsgBodyExtraOuterClass.GroupNoticeOrBuilder getGroupNoticeOrBuilder();

        MsgBodyExtraOuterClass.HidenAlbumExtra getHidenAlbumExtra();

        MsgBodyExtraOuterClass.HidenAlbumExtraOrBuilder getHidenAlbumExtraOrBuilder();

        MsgBodyExtraOuterClass.ImageTextExtra getImagetextExtra();

        MsgBodyExtraOuterClass.ImageTextExtraOrBuilder getImagetextExtraOrBuilder();

        MsgBodyExtraOuterClass.ImgExtra getImgExtra();

        MsgBodyExtraOuterClass.ImgExtraOrBuilder getImgExtraOrBuilder();

        MsgBodyExtraOuterClass.LiveShareExtra getLiveShareExtra();

        MsgBodyExtraOuterClass.LiveShareExtraOrBuilder getLiveShareExtraOrBuilder();

        MsgBodyExtraOuterClass.LiveShareInternationalExtra getLiveShareInternationalExtra();

        MsgBodyExtraOuterClass.LiveShareInternationalExtraOrBuilder getLiveShareInternationalExtraOrBuilder();

        MsgBodyExtraOuterClass.LocationExtra getLocationExtra();

        MsgBodyExtraOuterClass.LocationExtraOrBuilder getLocationExtraOrBuilder();

        MsgBodyExtraOuterClass.SayHiExtra getSayHiExtra();

        MsgBodyExtraOuterClass.SayHiExtraOrBuilder getSayHiExtraOrBuilder();

        MsgBodyExtraOuterClass.SecureNotify getSecureNotify();

        MsgBodyExtraOuterClass.SecureNotifyOrBuilder getSecureNotifyOrBuilder();

        MsgBodyExtraOuterClass.ShareExtra getShareExtra();

        MsgBodyExtraOuterClass.ShareExtraOrBuilder getShareExtraOrBuilder();

        MsgBodyExtraOuterClass.SysNoticeExtra getSysNoticeExtra();

        MsgBodyExtraOuterClass.SysNoticeExtraOrBuilder getSysNoticeExtraOrBuilder();

        MsgBodyExtraOuterClass.TextExtra getTextExtra();

        MsgBodyExtraOuterClass.TextExtraOrBuilder getTextExtraOrBuilder();

        MsgBodyExtraOuterClass.VideoChatCallingExtra getVideoCallingExtra();

        MsgBodyExtraOuterClass.VideoChatCallingExtraOrBuilder getVideoCallingExtraOrBuilder();

        MsgBodyExtraOuterClass.VideoChatEndExtra getVideoEndExtra();

        MsgBodyExtraOuterClass.VideoChatEndExtraOrBuilder getVideoEndExtraOrBuilder();

        MsgBodyExtraOuterClass.VideoExtra getVideoExtra();

        MsgBodyExtraOuterClass.VideoExtraOrBuilder getVideoExtraOrBuilder();

        MsgBodyExtraOuterClass.VipExtra getVipExtra();

        MsgBodyExtraOuterClass.VipExtraOrBuilder getVipExtraOrBuilder();

        MsgBodyExtraOuterClass.VoiceRoomShareExtra getVoiceRoomShareExtra();

        MsgBodyExtraOuterClass.VoiceRoomShareExtraOrBuilder getVoiceRoomShareExtraOrBuilder();

        boolean hasActivityShareExtra();

        boolean hasDoodleShareExtra();

        boolean hasEvaluationExtra();

        boolean hasFeedShareExtra();

        boolean hasFriendsCircleExtra();

        boolean hasGiftExtra();

        boolean hasGroupCardExtra();

        boolean hasGroupNotice();

        boolean hasHidenAlbumExtra();

        boolean hasImagetextExtra();

        boolean hasImgExtra();

        boolean hasLiveShareExtra();

        boolean hasLiveShareInternationalExtra();

        boolean hasLocationExtra();

        boolean hasSayHiExtra();

        boolean hasSecureNotify();

        boolean hasShareExtra();

        boolean hasSysNoticeExtra();

        boolean hasTextExtra();

        boolean hasVideoCallingExtra();

        boolean hasVideoEndExtra();

        boolean hasVideoExtra();

        boolean hasVipExtra();

        boolean hasVoiceRoomShareExtra();
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_blued_im_private_chat_MsgBody_descriptor = descriptor2;
        internal_static_com_blued_im_private_chat_MsgBody_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"Contents", "Profile", "Extra", "ExtraJson", "MsgSource", "MsgReceiveFrom"});
        Descriptors.Descriptor descriptor3 = getDescriptor().getMessageTypes().get(1);
        internal_static_com_blued_im_private_chat_MsgExtra_descriptor = descriptor3;
        internal_static_com_blued_im_private_chat_MsgExtra_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor3, new String[]{"TextExtra", "ImgExtra", "LocationExtra", "VideoExtra", "GroupCardExtra", "LiveShareExtra", "ImagetextExtra", "HidenAlbumExtra", "ShareExtra", "VipExtra", "GiftExtra", "SysNoticeExtra", "VideoCallingExtra", "VideoEndExtra", "FeedShareExtra", "SayHiExtra", "VoiceRoomShareExtra", "LiveShareInternationalExtra", "DoodleShareExtra", "GroupNotice", "EvaluationExtra", "SecureNotify", "ActivityShareExtra", "FriendsCircleExtra"});
        Descriptors.Descriptor descriptor4 = getDescriptor().getMessageTypes().get(2);
        internal_static_com_blued_im_private_chat_MsgBody_TEXT_descriptor = descriptor4;
        internal_static_com_blued_im_private_chat_MsgBody_TEXT_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor4, new String[]{"Contents", "Profile", "Extra"});
        Descriptors.Descriptor descriptor5 = getDescriptor().getMessageTypes().get(3);
        internal_static_com_blued_im_private_chat_MsgBody_IMAGE_descriptor = descriptor5;
        internal_static_com_blued_im_private_chat_MsgBody_IMAGE_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor5, new String[]{"Contents", "Height", "Width", "Size"});
        MsgBodyExtraOuterClass.getDescriptor();
    }

    private MsgBodyOuterClass() {
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
