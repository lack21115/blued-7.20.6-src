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

/* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/PushBodyExtraOuterClass.class */
public final class PushBodyExtraOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0013PushBodyExtra.proto\u0012\u0019com.blued.im.private_chat\u001a\u0012MsgBodyExtra.proto\"º\r\n\rPushBodyExtra\u00127\n\tmsgSource\u0018\u0001 \u0001(\u000b2$.com.blued.im.private_chat.MsgSource\u0012=\n\fsecureNotify\u0018\u0002 \u0001(\u000b2'.com.blued.im.private_chat.SecureNotify\u00128\n\ntext_extra\u0018\u0003 \u0001(\u000b2$.com.blued.im.private_chat.TextExtra\u00126\n\timg_extra\u0018\u0004 \u0001(\u000b2#.com.blued.im.private_chat.ImgExtra\u0012\u0018\n\u0010msg_receive_from\u0018\u0005 \u0001(\u0003\u0012@\n\u000elocation_extra\u0018\u0006 \u0001(\u000b2(.com.blued.im.private_chat.LocationExtra\u0012:\n\u000bvideo_extra\u0018\u0007 \u0001(\u000b2%.com.blued.im.private_chat.VideoExtra\u0012C\n\u0010group_card_extra\u0018\b \u0001(\u000b2).com.blued.im.private_chat.GroupCardExtra\u0012C\n\u0010live_share_extra\u0018\t \u0001(\u000b2).com.blued.im.private_chat.LiveShareExtra\u0012B\n\u000fimagetext_extra\u0018\n \u0001(\u000b2).com.blued.im.private_chat.ImageTextExtra\u0012E\n\u0011hiden_album_extra\u0018\u000b \u0001(\u000b2*.com.blued.im.private_chat.HidenAlbumExtra\u0012:\n\u000bshare_extra\u0018\f \u0001(\u000b2%.com.blued.im.private_chat.ShareExtra\u00126\n\tvip_extra\u0018\r \u0001(\u000b2#.com.blued.im.private_chat.VipExtra\u00128\n\ngift_extra\u0018\u000e \u0001(\u000b2$.com.blued.im.private_chat.GiftExtra\u0012C\n\u0010sys_notice_extra\u0018\u000f \u0001(\u000b2).com.blued.im.private_chat.SysNoticeExtra\u0012M\n\u0013video_calling_extra\u0018\u0010 \u0001(\u000b20.com.blued.im.private_chat.VideoChatCallingExtra\u0012E\n\u000fvideo_end_extra\u0018\u0011 \u0001(\u000b2,.com.blued.im.private_chat.VideoChatEndExtra\u0012C\n\u0010feed_share_extra\u0018\u0012 \u0001(\u000b2).com.blued.im.private_chat.FeedShareExtra\u0012;\n\fsay_hi_extra\u0018\u0013 \u0001(\u000b2%.com.blued.im.private_chat.SayHiExtra\u0012N\n\u0016voice_room_share_extra\u0018\u0014 \u0001(\u000b2..com.blued.im.private_chat.VoiceRoomShareExtra\u0012^\n\u001elive_share_international_extra\u0018\u0015 \u0001(\u000b26.com.blued.im.private_chat.LiveShareInternationalExtra\u0012G\n\u0012doodle_share_extra\u0018\u0016 \u0001(\u000b2+.com.blued.im.private_chat.DoodleShareExtra\u0012<\n\fgroup_notice\u0018\u0017 \u0001(\u000b2&.com.blued.im.private_chat.GroupNotice\u0012K\n\u0014activity_share_extra\u0018\u0018 \u0001(\u000b2-.com.blued.im.private_chat.ActivityShareExtra\u0012K\n\u0014friends_circle_extra\u0018\u0019 \u0001(\u000b2-.com.blued.im.private_chat.FriendsCircleExtra\u00126\n\tpns_extra\u0018\u001a \u0001(\u000b2#.com.blued.im.private_chat.PnsExtraB\u000e¢\u0002\u000bPrivateChatb\u0006proto3"}, new Descriptors.FileDescriptor[]{MsgBodyExtraOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_com_blued_im_private_chat_PushBodyExtra_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_blued_im_private_chat_PushBodyExtra_fieldAccessorTable;

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra.class */
    public static final class PushBodyExtra extends GeneratedMessageV3 implements PushBodyExtraOrBuilder {
        public static final int ACTIVITY_SHARE_EXTRA_FIELD_NUMBER = 24;
        public static final int DOODLE_SHARE_EXTRA_FIELD_NUMBER = 22;
        public static final int FEED_SHARE_EXTRA_FIELD_NUMBER = 18;
        public static final int FRIENDS_CIRCLE_EXTRA_FIELD_NUMBER = 25;
        public static final int GIFT_EXTRA_FIELD_NUMBER = 14;
        public static final int GROUP_CARD_EXTRA_FIELD_NUMBER = 8;
        public static final int GROUP_NOTICE_FIELD_NUMBER = 23;
        public static final int HIDEN_ALBUM_EXTRA_FIELD_NUMBER = 11;
        public static final int IMAGETEXT_EXTRA_FIELD_NUMBER = 10;
        public static final int IMG_EXTRA_FIELD_NUMBER = 4;
        public static final int LIVE_SHARE_EXTRA_FIELD_NUMBER = 9;
        public static final int LIVE_SHARE_INTERNATIONAL_EXTRA_FIELD_NUMBER = 21;
        public static final int LOCATION_EXTRA_FIELD_NUMBER = 6;
        public static final int MSGSOURCE_FIELD_NUMBER = 1;
        public static final int MSG_RECEIVE_FROM_FIELD_NUMBER = 5;
        public static final int PNS_EXTRA_FIELD_NUMBER = 26;
        public static final int SAY_HI_EXTRA_FIELD_NUMBER = 19;
        public static final int SECURENOTIFY_FIELD_NUMBER = 2;
        public static final int SHARE_EXTRA_FIELD_NUMBER = 12;
        public static final int SYS_NOTICE_EXTRA_FIELD_NUMBER = 15;
        public static final int TEXT_EXTRA_FIELD_NUMBER = 3;
        public static final int VIDEO_CALLING_EXTRA_FIELD_NUMBER = 16;
        public static final int VIDEO_END_EXTRA_FIELD_NUMBER = 17;
        public static final int VIDEO_EXTRA_FIELD_NUMBER = 7;
        public static final int VIP_EXTRA_FIELD_NUMBER = 13;
        public static final int VOICE_ROOM_SHARE_EXTRA_FIELD_NUMBER = 20;
        private static final long serialVersionUID = 0;
        private MsgBodyExtraOuterClass.ActivityShareExtra activityShareExtra_;
        private MsgBodyExtraOuterClass.DoodleShareExtra doodleShareExtra_;
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
        private long msgReceiveFrom_;
        private MsgBodyExtraOuterClass.MsgSource msgSource_;
        private MsgBodyExtraOuterClass.PnsExtra pnsExtra_;
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
        private static final PushBodyExtra DEFAULT_INSTANCE = new PushBodyExtra();
        private static final Parser<PushBodyExtra> PARSER = new AbstractParser<PushBodyExtra>() { // from class: com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtra.1
            @Override // com.google.protobuf.Parser
            public PushBodyExtra parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new PushBodyExtra(codedInputStream, extensionRegistryLite);
            }
        };

        /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtra$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PushBodyExtraOrBuilder {
            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.ActivityShareExtra, MsgBodyExtraOuterClass.ActivityShareExtra.Builder, MsgBodyExtraOuterClass.ActivityShareExtraOrBuilder> activityShareExtraBuilder_;
            private MsgBodyExtraOuterClass.ActivityShareExtra activityShareExtra_;
            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.DoodleShareExtra, MsgBodyExtraOuterClass.DoodleShareExtra.Builder, MsgBodyExtraOuterClass.DoodleShareExtraOrBuilder> doodleShareExtraBuilder_;
            private MsgBodyExtraOuterClass.DoodleShareExtra doodleShareExtra_;
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
            private long msgReceiveFrom_;
            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.MsgSource, MsgBodyExtraOuterClass.MsgSource.Builder, MsgBodyExtraOuterClass.MsgSourceOrBuilder> msgSourceBuilder_;
            private MsgBodyExtraOuterClass.MsgSource msgSource_;
            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.PnsExtra, MsgBodyExtraOuterClass.PnsExtra.Builder, MsgBodyExtraOuterClass.PnsExtraOrBuilder> pnsExtraBuilder_;
            private MsgBodyExtraOuterClass.PnsExtra pnsExtra_;
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
                return PushBodyExtraOuterClass.internal_static_com_blued_im_private_chat_PushBodyExtra_descriptor;
            }

            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.DoodleShareExtra, MsgBodyExtraOuterClass.DoodleShareExtra.Builder, MsgBodyExtraOuterClass.DoodleShareExtraOrBuilder> getDoodleShareExtraFieldBuilder() {
                if (this.doodleShareExtraBuilder_ == null) {
                    this.doodleShareExtraBuilder_ = new SingleFieldBuilderV3<>(getDoodleShareExtra(), getParentForChildren(), isClean());
                    this.doodleShareExtra_ = null;
                }
                return this.doodleShareExtraBuilder_;
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

            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.MsgSource, MsgBodyExtraOuterClass.MsgSource.Builder, MsgBodyExtraOuterClass.MsgSourceOrBuilder> getMsgSourceFieldBuilder() {
                if (this.msgSourceBuilder_ == null) {
                    this.msgSourceBuilder_ = new SingleFieldBuilderV3<>(getMsgSource(), getParentForChildren(), isClean());
                    this.msgSource_ = null;
                }
                return this.msgSourceBuilder_;
            }

            private SingleFieldBuilderV3<MsgBodyExtraOuterClass.PnsExtra, MsgBodyExtraOuterClass.PnsExtra.Builder, MsgBodyExtraOuterClass.PnsExtraOrBuilder> getPnsExtraFieldBuilder() {
                if (this.pnsExtraBuilder_ == null) {
                    this.pnsExtraBuilder_ = new SingleFieldBuilderV3<>(getPnsExtra(), getParentForChildren(), isClean());
                    this.pnsExtra_ = null;
                }
                return this.pnsExtraBuilder_;
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
                boolean unused = PushBodyExtra.alwaysUseFieldBuilders;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PushBodyExtra build() {
                PushBodyExtra buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PushBodyExtra buildPartial() {
                PushBodyExtra pushBodyExtra = new PushBodyExtra(this);
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.MsgSource, MsgBodyExtraOuterClass.MsgSource.Builder, MsgBodyExtraOuterClass.MsgSourceOrBuilder> singleFieldBuilderV3 = this.msgSourceBuilder_;
                if (singleFieldBuilderV3 == null) {
                    pushBodyExtra.msgSource_ = this.msgSource_;
                } else {
                    pushBodyExtra.msgSource_ = singleFieldBuilderV3.build();
                }
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.SecureNotify, MsgBodyExtraOuterClass.SecureNotify.Builder, MsgBodyExtraOuterClass.SecureNotifyOrBuilder> singleFieldBuilderV32 = this.secureNotifyBuilder_;
                if (singleFieldBuilderV32 == null) {
                    pushBodyExtra.secureNotify_ = this.secureNotify_;
                } else {
                    pushBodyExtra.secureNotify_ = singleFieldBuilderV32.build();
                }
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.TextExtra, MsgBodyExtraOuterClass.TextExtra.Builder, MsgBodyExtraOuterClass.TextExtraOrBuilder> singleFieldBuilderV33 = this.textExtraBuilder_;
                if (singleFieldBuilderV33 == null) {
                    pushBodyExtra.textExtra_ = this.textExtra_;
                } else {
                    pushBodyExtra.textExtra_ = singleFieldBuilderV33.build();
                }
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImgExtra, MsgBodyExtraOuterClass.ImgExtra.Builder, MsgBodyExtraOuterClass.ImgExtraOrBuilder> singleFieldBuilderV34 = this.imgExtraBuilder_;
                if (singleFieldBuilderV34 == null) {
                    pushBodyExtra.imgExtra_ = this.imgExtra_;
                } else {
                    pushBodyExtra.imgExtra_ = singleFieldBuilderV34.build();
                }
                pushBodyExtra.msgReceiveFrom_ = this.msgReceiveFrom_;
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.LocationExtra, MsgBodyExtraOuterClass.LocationExtra.Builder, MsgBodyExtraOuterClass.LocationExtraOrBuilder> singleFieldBuilderV35 = this.locationExtraBuilder_;
                if (singleFieldBuilderV35 == null) {
                    pushBodyExtra.locationExtra_ = this.locationExtra_;
                } else {
                    pushBodyExtra.locationExtra_ = singleFieldBuilderV35.build();
                }
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoExtra, MsgBodyExtraOuterClass.VideoExtra.Builder, MsgBodyExtraOuterClass.VideoExtraOrBuilder> singleFieldBuilderV36 = this.videoExtraBuilder_;
                if (singleFieldBuilderV36 == null) {
                    pushBodyExtra.videoExtra_ = this.videoExtra_;
                } else {
                    pushBodyExtra.videoExtra_ = singleFieldBuilderV36.build();
                }
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupCardExtra, MsgBodyExtraOuterClass.GroupCardExtra.Builder, MsgBodyExtraOuterClass.GroupCardExtraOrBuilder> singleFieldBuilderV37 = this.groupCardExtraBuilder_;
                if (singleFieldBuilderV37 == null) {
                    pushBodyExtra.groupCardExtra_ = this.groupCardExtra_;
                } else {
                    pushBodyExtra.groupCardExtra_ = singleFieldBuilderV37.build();
                }
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareExtra, MsgBodyExtraOuterClass.LiveShareExtra.Builder, MsgBodyExtraOuterClass.LiveShareExtraOrBuilder> singleFieldBuilderV38 = this.liveShareExtraBuilder_;
                if (singleFieldBuilderV38 == null) {
                    pushBodyExtra.liveShareExtra_ = this.liveShareExtra_;
                } else {
                    pushBodyExtra.liveShareExtra_ = singleFieldBuilderV38.build();
                }
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.ImageTextExtra, MsgBodyExtraOuterClass.ImageTextExtra.Builder, MsgBodyExtraOuterClass.ImageTextExtraOrBuilder> singleFieldBuilderV39 = this.imagetextExtraBuilder_;
                if (singleFieldBuilderV39 == null) {
                    pushBodyExtra.imagetextExtra_ = this.imagetextExtra_;
                } else {
                    pushBodyExtra.imagetextExtra_ = singleFieldBuilderV39.build();
                }
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.HidenAlbumExtra, MsgBodyExtraOuterClass.HidenAlbumExtra.Builder, MsgBodyExtraOuterClass.HidenAlbumExtraOrBuilder> singleFieldBuilderV310 = this.hidenAlbumExtraBuilder_;
                if (singleFieldBuilderV310 == null) {
                    pushBodyExtra.hidenAlbumExtra_ = this.hidenAlbumExtra_;
                } else {
                    pushBodyExtra.hidenAlbumExtra_ = singleFieldBuilderV310.build();
                }
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.ShareExtra, MsgBodyExtraOuterClass.ShareExtra.Builder, MsgBodyExtraOuterClass.ShareExtraOrBuilder> singleFieldBuilderV311 = this.shareExtraBuilder_;
                if (singleFieldBuilderV311 == null) {
                    pushBodyExtra.shareExtra_ = this.shareExtra_;
                } else {
                    pushBodyExtra.shareExtra_ = singleFieldBuilderV311.build();
                }
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.VipExtra, MsgBodyExtraOuterClass.VipExtra.Builder, MsgBodyExtraOuterClass.VipExtraOrBuilder> singleFieldBuilderV312 = this.vipExtraBuilder_;
                if (singleFieldBuilderV312 == null) {
                    pushBodyExtra.vipExtra_ = this.vipExtra_;
                } else {
                    pushBodyExtra.vipExtra_ = singleFieldBuilderV312.build();
                }
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.GiftExtra, MsgBodyExtraOuterClass.GiftExtra.Builder, MsgBodyExtraOuterClass.GiftExtraOrBuilder> singleFieldBuilderV313 = this.giftExtraBuilder_;
                if (singleFieldBuilderV313 == null) {
                    pushBodyExtra.giftExtra_ = this.giftExtra_;
                } else {
                    pushBodyExtra.giftExtra_ = singleFieldBuilderV313.build();
                }
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.SysNoticeExtra, MsgBodyExtraOuterClass.SysNoticeExtra.Builder, MsgBodyExtraOuterClass.SysNoticeExtraOrBuilder> singleFieldBuilderV314 = this.sysNoticeExtraBuilder_;
                if (singleFieldBuilderV314 == null) {
                    pushBodyExtra.sysNoticeExtra_ = this.sysNoticeExtra_;
                } else {
                    pushBodyExtra.sysNoticeExtra_ = singleFieldBuilderV314.build();
                }
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatCallingExtra, MsgBodyExtraOuterClass.VideoChatCallingExtra.Builder, MsgBodyExtraOuterClass.VideoChatCallingExtraOrBuilder> singleFieldBuilderV315 = this.videoCallingExtraBuilder_;
                if (singleFieldBuilderV315 == null) {
                    pushBodyExtra.videoCallingExtra_ = this.videoCallingExtra_;
                } else {
                    pushBodyExtra.videoCallingExtra_ = singleFieldBuilderV315.build();
                }
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.VideoChatEndExtra, MsgBodyExtraOuterClass.VideoChatEndExtra.Builder, MsgBodyExtraOuterClass.VideoChatEndExtraOrBuilder> singleFieldBuilderV316 = this.videoEndExtraBuilder_;
                if (singleFieldBuilderV316 == null) {
                    pushBodyExtra.videoEndExtra_ = this.videoEndExtra_;
                } else {
                    pushBodyExtra.videoEndExtra_ = singleFieldBuilderV316.build();
                }
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.FeedShareExtra, MsgBodyExtraOuterClass.FeedShareExtra.Builder, MsgBodyExtraOuterClass.FeedShareExtraOrBuilder> singleFieldBuilderV317 = this.feedShareExtraBuilder_;
                if (singleFieldBuilderV317 == null) {
                    pushBodyExtra.feedShareExtra_ = this.feedShareExtra_;
                } else {
                    pushBodyExtra.feedShareExtra_ = singleFieldBuilderV317.build();
                }
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.SayHiExtra, MsgBodyExtraOuterClass.SayHiExtra.Builder, MsgBodyExtraOuterClass.SayHiExtraOrBuilder> singleFieldBuilderV318 = this.sayHiExtraBuilder_;
                if (singleFieldBuilderV318 == null) {
                    pushBodyExtra.sayHiExtra_ = this.sayHiExtra_;
                } else {
                    pushBodyExtra.sayHiExtra_ = singleFieldBuilderV318.build();
                }
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.VoiceRoomShareExtra, MsgBodyExtraOuterClass.VoiceRoomShareExtra.Builder, MsgBodyExtraOuterClass.VoiceRoomShareExtraOrBuilder> singleFieldBuilderV319 = this.voiceRoomShareExtraBuilder_;
                if (singleFieldBuilderV319 == null) {
                    pushBodyExtra.voiceRoomShareExtra_ = this.voiceRoomShareExtra_;
                } else {
                    pushBodyExtra.voiceRoomShareExtra_ = singleFieldBuilderV319.build();
                }
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.LiveShareInternationalExtra, MsgBodyExtraOuterClass.LiveShareInternationalExtra.Builder, MsgBodyExtraOuterClass.LiveShareInternationalExtraOrBuilder> singleFieldBuilderV320 = this.liveShareInternationalExtraBuilder_;
                if (singleFieldBuilderV320 == null) {
                    pushBodyExtra.liveShareInternationalExtra_ = this.liveShareInternationalExtra_;
                } else {
                    pushBodyExtra.liveShareInternationalExtra_ = singleFieldBuilderV320.build();
                }
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.DoodleShareExtra, MsgBodyExtraOuterClass.DoodleShareExtra.Builder, MsgBodyExtraOuterClass.DoodleShareExtraOrBuilder> singleFieldBuilderV321 = this.doodleShareExtraBuilder_;
                if (singleFieldBuilderV321 == null) {
                    pushBodyExtra.doodleShareExtra_ = this.doodleShareExtra_;
                } else {
                    pushBodyExtra.doodleShareExtra_ = singleFieldBuilderV321.build();
                }
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.GroupNotice, MsgBodyExtraOuterClass.GroupNotice.Builder, MsgBodyExtraOuterClass.GroupNoticeOrBuilder> singleFieldBuilderV322 = this.groupNoticeBuilder_;
                if (singleFieldBuilderV322 == null) {
                    pushBodyExtra.groupNotice_ = this.groupNotice_;
                } else {
                    pushBodyExtra.groupNotice_ = singleFieldBuilderV322.build();
                }
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.ActivityShareExtra, MsgBodyExtraOuterClass.ActivityShareExtra.Builder, MsgBodyExtraOuterClass.ActivityShareExtraOrBuilder> singleFieldBuilderV323 = this.activityShareExtraBuilder_;
                if (singleFieldBuilderV323 == null) {
                    pushBodyExtra.activityShareExtra_ = this.activityShareExtra_;
                } else {
                    pushBodyExtra.activityShareExtra_ = singleFieldBuilderV323.build();
                }
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.FriendsCircleExtra, MsgBodyExtraOuterClass.FriendsCircleExtra.Builder, MsgBodyExtraOuterClass.FriendsCircleExtraOrBuilder> singleFieldBuilderV324 = this.friendsCircleExtraBuilder_;
                if (singleFieldBuilderV324 == null) {
                    pushBodyExtra.friendsCircleExtra_ = this.friendsCircleExtra_;
                } else {
                    pushBodyExtra.friendsCircleExtra_ = singleFieldBuilderV324.build();
                }
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.PnsExtra, MsgBodyExtraOuterClass.PnsExtra.Builder, MsgBodyExtraOuterClass.PnsExtraOrBuilder> singleFieldBuilderV325 = this.pnsExtraBuilder_;
                if (singleFieldBuilderV325 == null) {
                    pushBodyExtra.pnsExtra_ = this.pnsExtra_;
                } else {
                    pushBodyExtra.pnsExtra_ = singleFieldBuilderV325.build();
                }
                onBuilt();
                return pushBodyExtra;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                if (this.msgSourceBuilder_ == null) {
                    this.msgSource_ = null;
                } else {
                    this.msgSource_ = null;
                    this.msgSourceBuilder_ = null;
                }
                if (this.secureNotifyBuilder_ == null) {
                    this.secureNotify_ = null;
                } else {
                    this.secureNotify_ = null;
                    this.secureNotifyBuilder_ = null;
                }
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
                this.msgReceiveFrom_ = 0L;
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
                if (this.activityShareExtraBuilder_ == null) {
                    this.activityShareExtra_ = null;
                } else {
                    this.activityShareExtra_ = null;
                    this.activityShareExtraBuilder_ = null;
                }
                if (this.friendsCircleExtraBuilder_ == null) {
                    this.friendsCircleExtra_ = null;
                } else {
                    this.friendsCircleExtra_ = null;
                    this.friendsCircleExtraBuilder_ = null;
                }
                if (this.pnsExtraBuilder_ == null) {
                    this.pnsExtra_ = null;
                    return this;
                }
                this.pnsExtra_ = null;
                this.pnsExtraBuilder_ = null;
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

            public Builder clearPnsExtra() {
                if (this.pnsExtraBuilder_ == null) {
                    this.pnsExtra_ = null;
                    onChanged();
                    return this;
                }
                this.pnsExtra_ = null;
                this.pnsExtraBuilder_ = null;
                return this;
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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
            public PushBodyExtra getDefaultInstanceForType() {
                return PushBodyExtra.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PushBodyExtraOuterClass.internal_static_com_blued_im_private_chat_PushBodyExtra_descriptor;
            }

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
            public long getMsgReceiveFrom() {
                return this.msgReceiveFrom_;
            }

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
            public MsgBodyExtraOuterClass.PnsExtra getPnsExtra() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.PnsExtra, MsgBodyExtraOuterClass.PnsExtra.Builder, MsgBodyExtraOuterClass.PnsExtraOrBuilder> singleFieldBuilderV3 = this.pnsExtraBuilder_;
                if (singleFieldBuilderV3 == null) {
                    MsgBodyExtraOuterClass.PnsExtra pnsExtra = this.pnsExtra_;
                    MsgBodyExtraOuterClass.PnsExtra pnsExtra2 = pnsExtra;
                    if (pnsExtra == null) {
                        pnsExtra2 = MsgBodyExtraOuterClass.PnsExtra.getDefaultInstance();
                    }
                    return pnsExtra2;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public MsgBodyExtraOuterClass.PnsExtra.Builder getPnsExtraBuilder() {
                onChanged();
                return getPnsExtraFieldBuilder().getBuilder();
            }

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
            public MsgBodyExtraOuterClass.PnsExtraOrBuilder getPnsExtraOrBuilder() {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.PnsExtra, MsgBodyExtraOuterClass.PnsExtra.Builder, MsgBodyExtraOuterClass.PnsExtraOrBuilder> singleFieldBuilderV3 = this.pnsExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                MsgBodyExtraOuterClass.PnsExtra pnsExtra = this.pnsExtra_;
                MsgBodyExtraOuterClass.PnsExtra pnsExtra2 = pnsExtra;
                if (pnsExtra == null) {
                    pnsExtra2 = MsgBodyExtraOuterClass.PnsExtra.getDefaultInstance();
                }
                return pnsExtra2;
            }

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
            public boolean hasActivityShareExtra() {
                return (this.activityShareExtraBuilder_ == null && this.activityShareExtra_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
            public boolean hasDoodleShareExtra() {
                return (this.doodleShareExtraBuilder_ == null && this.doodleShareExtra_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
            public boolean hasFeedShareExtra() {
                return (this.feedShareExtraBuilder_ == null && this.feedShareExtra_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
            public boolean hasFriendsCircleExtra() {
                return (this.friendsCircleExtraBuilder_ == null && this.friendsCircleExtra_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
            public boolean hasGiftExtra() {
                return (this.giftExtraBuilder_ == null && this.giftExtra_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
            public boolean hasGroupCardExtra() {
                return (this.groupCardExtraBuilder_ == null && this.groupCardExtra_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
            public boolean hasGroupNotice() {
                return (this.groupNoticeBuilder_ == null && this.groupNotice_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
            public boolean hasHidenAlbumExtra() {
                return (this.hidenAlbumExtraBuilder_ == null && this.hidenAlbumExtra_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
            public boolean hasImagetextExtra() {
                return (this.imagetextExtraBuilder_ == null && this.imagetextExtra_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
            public boolean hasImgExtra() {
                return (this.imgExtraBuilder_ == null && this.imgExtra_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
            public boolean hasLiveShareExtra() {
                return (this.liveShareExtraBuilder_ == null && this.liveShareExtra_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
            public boolean hasLiveShareInternationalExtra() {
                return (this.liveShareInternationalExtraBuilder_ == null && this.liveShareInternationalExtra_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
            public boolean hasLocationExtra() {
                return (this.locationExtraBuilder_ == null && this.locationExtra_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
            public boolean hasMsgSource() {
                return (this.msgSourceBuilder_ == null && this.msgSource_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
            public boolean hasPnsExtra() {
                return (this.pnsExtraBuilder_ == null && this.pnsExtra_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
            public boolean hasSayHiExtra() {
                return (this.sayHiExtraBuilder_ == null && this.sayHiExtra_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
            public boolean hasSecureNotify() {
                return (this.secureNotifyBuilder_ == null && this.secureNotify_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
            public boolean hasShareExtra() {
                return (this.shareExtraBuilder_ == null && this.shareExtra_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
            public boolean hasSysNoticeExtra() {
                return (this.sysNoticeExtraBuilder_ == null && this.sysNoticeExtra_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
            public boolean hasTextExtra() {
                return (this.textExtraBuilder_ == null && this.textExtra_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
            public boolean hasVideoCallingExtra() {
                return (this.videoCallingExtraBuilder_ == null && this.videoCallingExtra_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
            public boolean hasVideoEndExtra() {
                return (this.videoEndExtraBuilder_ == null && this.videoEndExtra_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
            public boolean hasVideoExtra() {
                return (this.videoExtraBuilder_ == null && this.videoExtra_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
            public boolean hasVipExtra() {
                return (this.vipExtraBuilder_ == null && this.vipExtra_ == null) ? false : true;
            }

            @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
            public boolean hasVoiceRoomShareExtra() {
                return (this.voiceRoomShareExtraBuilder_ == null && this.voiceRoomShareExtra_ == null) ? false : true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PushBodyExtraOuterClass.internal_static_com_blued_im_private_chat_PushBodyExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(PushBodyExtra.class, Builder.class);
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

            public Builder mergeFrom(PushBodyExtra pushBodyExtra) {
                if (pushBodyExtra == PushBodyExtra.getDefaultInstance()) {
                    return this;
                }
                if (pushBodyExtra.hasMsgSource()) {
                    mergeMsgSource(pushBodyExtra.getMsgSource());
                }
                if (pushBodyExtra.hasSecureNotify()) {
                    mergeSecureNotify(pushBodyExtra.getSecureNotify());
                }
                if (pushBodyExtra.hasTextExtra()) {
                    mergeTextExtra(pushBodyExtra.getTextExtra());
                }
                if (pushBodyExtra.hasImgExtra()) {
                    mergeImgExtra(pushBodyExtra.getImgExtra());
                }
                if (pushBodyExtra.getMsgReceiveFrom() != 0) {
                    setMsgReceiveFrom(pushBodyExtra.getMsgReceiveFrom());
                }
                if (pushBodyExtra.hasLocationExtra()) {
                    mergeLocationExtra(pushBodyExtra.getLocationExtra());
                }
                if (pushBodyExtra.hasVideoExtra()) {
                    mergeVideoExtra(pushBodyExtra.getVideoExtra());
                }
                if (pushBodyExtra.hasGroupCardExtra()) {
                    mergeGroupCardExtra(pushBodyExtra.getGroupCardExtra());
                }
                if (pushBodyExtra.hasLiveShareExtra()) {
                    mergeLiveShareExtra(pushBodyExtra.getLiveShareExtra());
                }
                if (pushBodyExtra.hasImagetextExtra()) {
                    mergeImagetextExtra(pushBodyExtra.getImagetextExtra());
                }
                if (pushBodyExtra.hasHidenAlbumExtra()) {
                    mergeHidenAlbumExtra(pushBodyExtra.getHidenAlbumExtra());
                }
                if (pushBodyExtra.hasShareExtra()) {
                    mergeShareExtra(pushBodyExtra.getShareExtra());
                }
                if (pushBodyExtra.hasVipExtra()) {
                    mergeVipExtra(pushBodyExtra.getVipExtra());
                }
                if (pushBodyExtra.hasGiftExtra()) {
                    mergeGiftExtra(pushBodyExtra.getGiftExtra());
                }
                if (pushBodyExtra.hasSysNoticeExtra()) {
                    mergeSysNoticeExtra(pushBodyExtra.getSysNoticeExtra());
                }
                if (pushBodyExtra.hasVideoCallingExtra()) {
                    mergeVideoCallingExtra(pushBodyExtra.getVideoCallingExtra());
                }
                if (pushBodyExtra.hasVideoEndExtra()) {
                    mergeVideoEndExtra(pushBodyExtra.getVideoEndExtra());
                }
                if (pushBodyExtra.hasFeedShareExtra()) {
                    mergeFeedShareExtra(pushBodyExtra.getFeedShareExtra());
                }
                if (pushBodyExtra.hasSayHiExtra()) {
                    mergeSayHiExtra(pushBodyExtra.getSayHiExtra());
                }
                if (pushBodyExtra.hasVoiceRoomShareExtra()) {
                    mergeVoiceRoomShareExtra(pushBodyExtra.getVoiceRoomShareExtra());
                }
                if (pushBodyExtra.hasLiveShareInternationalExtra()) {
                    mergeLiveShareInternationalExtra(pushBodyExtra.getLiveShareInternationalExtra());
                }
                if (pushBodyExtra.hasDoodleShareExtra()) {
                    mergeDoodleShareExtra(pushBodyExtra.getDoodleShareExtra());
                }
                if (pushBodyExtra.hasGroupNotice()) {
                    mergeGroupNotice(pushBodyExtra.getGroupNotice());
                }
                if (pushBodyExtra.hasActivityShareExtra()) {
                    mergeActivityShareExtra(pushBodyExtra.getActivityShareExtra());
                }
                if (pushBodyExtra.hasFriendsCircleExtra()) {
                    mergeFriendsCircleExtra(pushBodyExtra.getFriendsCircleExtra());
                }
                if (pushBodyExtra.hasPnsExtra()) {
                    mergePnsExtra(pushBodyExtra.getPnsExtra());
                }
                mergeUnknownFields(pushBodyExtra.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtra.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    r7 = r0
                    com.google.protobuf.Parser r0 = com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtra.access$3300()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r1 = r5
                    r2 = r6
                    java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    com.blued.im.private_chat.PushBodyExtraOuterClass$PushBodyExtra r0 = (com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtra) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L1a
                    r0 = r4
                    r1 = r5
                    com.blued.im.private_chat.PushBodyExtraOuterClass$PushBodyExtra$Builder r0 = r0.mergeFrom(r1)
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
                    com.blued.im.private_chat.PushBodyExtraOuterClass$PushBodyExtra r0 = (com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtra) r0     // Catch: java.lang.Throwable -> L1c
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
                    com.blued.im.private_chat.PushBodyExtraOuterClass$PushBodyExtra$Builder r0 = r0.mergeFrom(r1)
                L3b:
                    r0 = r6
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtra.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.blued.im.private_chat.PushBodyExtraOuterClass$PushBodyExtra$Builder");
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof PushBodyExtra) {
                    return mergeFrom((PushBodyExtra) message);
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

            public Builder mergePnsExtra(MsgBodyExtraOuterClass.PnsExtra pnsExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.PnsExtra, MsgBodyExtraOuterClass.PnsExtra.Builder, MsgBodyExtraOuterClass.PnsExtraOrBuilder> singleFieldBuilderV3 = this.pnsExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.mergeFrom(pnsExtra);
                    return this;
                }
                MsgBodyExtraOuterClass.PnsExtra pnsExtra2 = this.pnsExtra_;
                if (pnsExtra2 != null) {
                    this.pnsExtra_ = MsgBodyExtraOuterClass.PnsExtra.newBuilder(pnsExtra2).mergeFrom(pnsExtra).buildPartial();
                } else {
                    this.pnsExtra_ = pnsExtra;
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

            public Builder setPnsExtra(MsgBodyExtraOuterClass.PnsExtra.Builder builder) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.PnsExtra, MsgBodyExtraOuterClass.PnsExtra.Builder, MsgBodyExtraOuterClass.PnsExtraOrBuilder> singleFieldBuilderV3 = this.pnsExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(builder.build());
                    return this;
                }
                this.pnsExtra_ = builder.build();
                onChanged();
                return this;
            }

            public Builder setPnsExtra(MsgBodyExtraOuterClass.PnsExtra pnsExtra) {
                SingleFieldBuilderV3<MsgBodyExtraOuterClass.PnsExtra, MsgBodyExtraOuterClass.PnsExtra.Builder, MsgBodyExtraOuterClass.PnsExtraOrBuilder> singleFieldBuilderV3 = this.pnsExtraBuilder_;
                if (singleFieldBuilderV3 != null) {
                    singleFieldBuilderV3.setMessage(pnsExtra);
                    return this;
                } else if (pnsExtra != null) {
                    this.pnsExtra_ = pnsExtra;
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

        private PushBodyExtra() {
            this.memoizedIsInitialized = (byte) -1;
        }

        private PushBodyExtra(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    MsgBodyExtraOuterClass.MsgSource.Builder builder = this.msgSource_ != null ? this.msgSource_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.MsgSource msgSource = (MsgBodyExtraOuterClass.MsgSource) codedInputStream.readMessage(MsgBodyExtraOuterClass.MsgSource.parser(), extensionRegistryLite);
                                    this.msgSource_ = msgSource;
                                    if (builder != null) {
                                        builder.mergeFrom(msgSource);
                                        this.msgSource_ = builder.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 18:
                                    MsgBodyExtraOuterClass.SecureNotify.Builder builder2 = this.secureNotify_ != null ? this.secureNotify_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.SecureNotify secureNotify = (MsgBodyExtraOuterClass.SecureNotify) codedInputStream.readMessage(MsgBodyExtraOuterClass.SecureNotify.parser(), extensionRegistryLite);
                                    this.secureNotify_ = secureNotify;
                                    if (builder2 != null) {
                                        builder2.mergeFrom(secureNotify);
                                        this.secureNotify_ = builder2.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 26:
                                    MsgBodyExtraOuterClass.TextExtra.Builder builder3 = this.textExtra_ != null ? this.textExtra_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.TextExtra textExtra = (MsgBodyExtraOuterClass.TextExtra) codedInputStream.readMessage(MsgBodyExtraOuterClass.TextExtra.parser(), extensionRegistryLite);
                                    this.textExtra_ = textExtra;
                                    if (builder3 != null) {
                                        builder3.mergeFrom(textExtra);
                                        this.textExtra_ = builder3.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 34:
                                    MsgBodyExtraOuterClass.ImgExtra.Builder builder4 = this.imgExtra_ != null ? this.imgExtra_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.ImgExtra imgExtra = (MsgBodyExtraOuterClass.ImgExtra) codedInputStream.readMessage(MsgBodyExtraOuterClass.ImgExtra.parser(), extensionRegistryLite);
                                    this.imgExtra_ = imgExtra;
                                    if (builder4 != null) {
                                        builder4.mergeFrom(imgExtra);
                                        this.imgExtra_ = builder4.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 40:
                                    this.msgReceiveFrom_ = codedInputStream.readInt64();
                                    continue;
                                case 50:
                                    MsgBodyExtraOuterClass.LocationExtra.Builder builder5 = this.locationExtra_ != null ? this.locationExtra_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.LocationExtra locationExtra = (MsgBodyExtraOuterClass.LocationExtra) codedInputStream.readMessage(MsgBodyExtraOuterClass.LocationExtra.parser(), extensionRegistryLite);
                                    this.locationExtra_ = locationExtra;
                                    if (builder5 != null) {
                                        builder5.mergeFrom(locationExtra);
                                        this.locationExtra_ = builder5.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 58:
                                    MsgBodyExtraOuterClass.VideoExtra.Builder builder6 = this.videoExtra_ != null ? this.videoExtra_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.VideoExtra videoExtra = (MsgBodyExtraOuterClass.VideoExtra) codedInputStream.readMessage(MsgBodyExtraOuterClass.VideoExtra.parser(), extensionRegistryLite);
                                    this.videoExtra_ = videoExtra;
                                    if (builder6 != null) {
                                        builder6.mergeFrom(videoExtra);
                                        this.videoExtra_ = builder6.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 66:
                                    MsgBodyExtraOuterClass.GroupCardExtra.Builder builder7 = this.groupCardExtra_ != null ? this.groupCardExtra_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.GroupCardExtra groupCardExtra = (MsgBodyExtraOuterClass.GroupCardExtra) codedInputStream.readMessage(MsgBodyExtraOuterClass.GroupCardExtra.parser(), extensionRegistryLite);
                                    this.groupCardExtra_ = groupCardExtra;
                                    if (builder7 != null) {
                                        builder7.mergeFrom(groupCardExtra);
                                        this.groupCardExtra_ = builder7.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 74:
                                    MsgBodyExtraOuterClass.LiveShareExtra.Builder builder8 = this.liveShareExtra_ != null ? this.liveShareExtra_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.LiveShareExtra liveShareExtra = (MsgBodyExtraOuterClass.LiveShareExtra) codedInputStream.readMessage(MsgBodyExtraOuterClass.LiveShareExtra.parser(), extensionRegistryLite);
                                    this.liveShareExtra_ = liveShareExtra;
                                    if (builder8 != null) {
                                        builder8.mergeFrom(liveShareExtra);
                                        this.liveShareExtra_ = builder8.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 82:
                                    MsgBodyExtraOuterClass.ImageTextExtra.Builder builder9 = this.imagetextExtra_ != null ? this.imagetextExtra_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.ImageTextExtra imageTextExtra = (MsgBodyExtraOuterClass.ImageTextExtra) codedInputStream.readMessage(MsgBodyExtraOuterClass.ImageTextExtra.parser(), extensionRegistryLite);
                                    this.imagetextExtra_ = imageTextExtra;
                                    if (builder9 != null) {
                                        builder9.mergeFrom(imageTextExtra);
                                        this.imagetextExtra_ = builder9.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 90:
                                    MsgBodyExtraOuterClass.HidenAlbumExtra.Builder builder10 = this.hidenAlbumExtra_ != null ? this.hidenAlbumExtra_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.HidenAlbumExtra hidenAlbumExtra = (MsgBodyExtraOuterClass.HidenAlbumExtra) codedInputStream.readMessage(MsgBodyExtraOuterClass.HidenAlbumExtra.parser(), extensionRegistryLite);
                                    this.hidenAlbumExtra_ = hidenAlbumExtra;
                                    if (builder10 != null) {
                                        builder10.mergeFrom(hidenAlbumExtra);
                                        this.hidenAlbumExtra_ = builder10.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 98:
                                    MsgBodyExtraOuterClass.ShareExtra.Builder builder11 = this.shareExtra_ != null ? this.shareExtra_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.ShareExtra shareExtra = (MsgBodyExtraOuterClass.ShareExtra) codedInputStream.readMessage(MsgBodyExtraOuterClass.ShareExtra.parser(), extensionRegistryLite);
                                    this.shareExtra_ = shareExtra;
                                    if (builder11 != null) {
                                        builder11.mergeFrom(shareExtra);
                                        this.shareExtra_ = builder11.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 106:
                                    MsgBodyExtraOuterClass.VipExtra.Builder builder12 = this.vipExtra_ != null ? this.vipExtra_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.VipExtra vipExtra = (MsgBodyExtraOuterClass.VipExtra) codedInputStream.readMessage(MsgBodyExtraOuterClass.VipExtra.parser(), extensionRegistryLite);
                                    this.vipExtra_ = vipExtra;
                                    if (builder12 != null) {
                                        builder12.mergeFrom(vipExtra);
                                        this.vipExtra_ = builder12.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 114:
                                    MsgBodyExtraOuterClass.GiftExtra.Builder builder13 = this.giftExtra_ != null ? this.giftExtra_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.GiftExtra giftExtra = (MsgBodyExtraOuterClass.GiftExtra) codedInputStream.readMessage(MsgBodyExtraOuterClass.GiftExtra.parser(), extensionRegistryLite);
                                    this.giftExtra_ = giftExtra;
                                    if (builder13 != null) {
                                        builder13.mergeFrom(giftExtra);
                                        this.giftExtra_ = builder13.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 122:
                                    MsgBodyExtraOuterClass.SysNoticeExtra.Builder builder14 = this.sysNoticeExtra_ != null ? this.sysNoticeExtra_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.SysNoticeExtra sysNoticeExtra = (MsgBodyExtraOuterClass.SysNoticeExtra) codedInputStream.readMessage(MsgBodyExtraOuterClass.SysNoticeExtra.parser(), extensionRegistryLite);
                                    this.sysNoticeExtra_ = sysNoticeExtra;
                                    if (builder14 != null) {
                                        builder14.mergeFrom(sysNoticeExtra);
                                        this.sysNoticeExtra_ = builder14.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 130:
                                    MsgBodyExtraOuterClass.VideoChatCallingExtra.Builder builder15 = this.videoCallingExtra_ != null ? this.videoCallingExtra_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.VideoChatCallingExtra videoChatCallingExtra = (MsgBodyExtraOuterClass.VideoChatCallingExtra) codedInputStream.readMessage(MsgBodyExtraOuterClass.VideoChatCallingExtra.parser(), extensionRegistryLite);
                                    this.videoCallingExtra_ = videoChatCallingExtra;
                                    if (builder15 != null) {
                                        builder15.mergeFrom(videoChatCallingExtra);
                                        this.videoCallingExtra_ = builder15.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 138:
                                    MsgBodyExtraOuterClass.VideoChatEndExtra.Builder builder16 = this.videoEndExtra_ != null ? this.videoEndExtra_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.VideoChatEndExtra videoChatEndExtra = (MsgBodyExtraOuterClass.VideoChatEndExtra) codedInputStream.readMessage(MsgBodyExtraOuterClass.VideoChatEndExtra.parser(), extensionRegistryLite);
                                    this.videoEndExtra_ = videoChatEndExtra;
                                    if (builder16 != null) {
                                        builder16.mergeFrom(videoChatEndExtra);
                                        this.videoEndExtra_ = builder16.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 146:
                                    MsgBodyExtraOuterClass.FeedShareExtra.Builder builder17 = this.feedShareExtra_ != null ? this.feedShareExtra_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.FeedShareExtra feedShareExtra = (MsgBodyExtraOuterClass.FeedShareExtra) codedInputStream.readMessage(MsgBodyExtraOuterClass.FeedShareExtra.parser(), extensionRegistryLite);
                                    this.feedShareExtra_ = feedShareExtra;
                                    if (builder17 != null) {
                                        builder17.mergeFrom(feedShareExtra);
                                        this.feedShareExtra_ = builder17.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 154:
                                    MsgBodyExtraOuterClass.SayHiExtra.Builder builder18 = this.sayHiExtra_ != null ? this.sayHiExtra_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.SayHiExtra sayHiExtra = (MsgBodyExtraOuterClass.SayHiExtra) codedInputStream.readMessage(MsgBodyExtraOuterClass.SayHiExtra.parser(), extensionRegistryLite);
                                    this.sayHiExtra_ = sayHiExtra;
                                    if (builder18 != null) {
                                        builder18.mergeFrom(sayHiExtra);
                                        this.sayHiExtra_ = builder18.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 162:
                                    MsgBodyExtraOuterClass.VoiceRoomShareExtra.Builder builder19 = this.voiceRoomShareExtra_ != null ? this.voiceRoomShareExtra_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.VoiceRoomShareExtra voiceRoomShareExtra = (MsgBodyExtraOuterClass.VoiceRoomShareExtra) codedInputStream.readMessage(MsgBodyExtraOuterClass.VoiceRoomShareExtra.parser(), extensionRegistryLite);
                                    this.voiceRoomShareExtra_ = voiceRoomShareExtra;
                                    if (builder19 != null) {
                                        builder19.mergeFrom(voiceRoomShareExtra);
                                        this.voiceRoomShareExtra_ = builder19.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 170:
                                    MsgBodyExtraOuterClass.LiveShareInternationalExtra.Builder builder20 = this.liveShareInternationalExtra_ != null ? this.liveShareInternationalExtra_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.LiveShareInternationalExtra liveShareInternationalExtra = (MsgBodyExtraOuterClass.LiveShareInternationalExtra) codedInputStream.readMessage(MsgBodyExtraOuterClass.LiveShareInternationalExtra.parser(), extensionRegistryLite);
                                    this.liveShareInternationalExtra_ = liveShareInternationalExtra;
                                    if (builder20 != null) {
                                        builder20.mergeFrom(liveShareInternationalExtra);
                                        this.liveShareInternationalExtra_ = builder20.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 178:
                                    MsgBodyExtraOuterClass.DoodleShareExtra.Builder builder21 = this.doodleShareExtra_ != null ? this.doodleShareExtra_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.DoodleShareExtra doodleShareExtra = (MsgBodyExtraOuterClass.DoodleShareExtra) codedInputStream.readMessage(MsgBodyExtraOuterClass.DoodleShareExtra.parser(), extensionRegistryLite);
                                    this.doodleShareExtra_ = doodleShareExtra;
                                    if (builder21 != null) {
                                        builder21.mergeFrom(doodleShareExtra);
                                        this.doodleShareExtra_ = builder21.buildPartial();
                                    } else {
                                        continue;
                                    }
                                case 186:
                                    MsgBodyExtraOuterClass.GroupNotice.Builder builder22 = this.groupNotice_ != null ? this.groupNotice_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.GroupNotice groupNotice = (MsgBodyExtraOuterClass.GroupNotice) codedInputStream.readMessage(MsgBodyExtraOuterClass.GroupNotice.parser(), extensionRegistryLite);
                                    this.groupNotice_ = groupNotice;
                                    if (builder22 != null) {
                                        builder22.mergeFrom(groupNotice);
                                        this.groupNotice_ = builder22.buildPartial();
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
                                case 210:
                                    MsgBodyExtraOuterClass.PnsExtra.Builder builder25 = this.pnsExtra_ != null ? this.pnsExtra_.toBuilder() : null;
                                    MsgBodyExtraOuterClass.PnsExtra pnsExtra = (MsgBodyExtraOuterClass.PnsExtra) codedInputStream.readMessage(MsgBodyExtraOuterClass.PnsExtra.parser(), extensionRegistryLite);
                                    this.pnsExtra_ = pnsExtra;
                                    if (builder25 != null) {
                                        builder25.mergeFrom(pnsExtra);
                                        this.pnsExtra_ = builder25.buildPartial();
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

        private PushBodyExtra(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static PushBodyExtra getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PushBodyExtraOuterClass.internal_static_com_blued_im_private_chat_PushBodyExtra_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PushBodyExtra pushBodyExtra) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(pushBodyExtra);
        }

        public static PushBodyExtra parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (PushBodyExtra) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static PushBodyExtra parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PushBodyExtra) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static PushBodyExtra parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static PushBodyExtra parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static PushBodyExtra parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (PushBodyExtra) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static PushBodyExtra parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PushBodyExtra) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        public static PushBodyExtra parseFrom(InputStream inputStream) throws IOException {
            return (PushBodyExtra) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static PushBodyExtra parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (PushBodyExtra) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static PushBodyExtra parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static PushBodyExtra parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        public static PushBodyExtra parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static PushBodyExtra parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Parser<PushBodyExtra> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof PushBodyExtra) {
                PushBodyExtra pushBodyExtra = (PushBodyExtra) obj;
                if (hasMsgSource() != pushBodyExtra.hasMsgSource()) {
                    return false;
                }
                if ((!hasMsgSource() || getMsgSource().equals(pushBodyExtra.getMsgSource())) && hasSecureNotify() == pushBodyExtra.hasSecureNotify()) {
                    if ((!hasSecureNotify() || getSecureNotify().equals(pushBodyExtra.getSecureNotify())) && hasTextExtra() == pushBodyExtra.hasTextExtra()) {
                        if ((!hasTextExtra() || getTextExtra().equals(pushBodyExtra.getTextExtra())) && hasImgExtra() == pushBodyExtra.hasImgExtra()) {
                            if ((!hasImgExtra() || getImgExtra().equals(pushBodyExtra.getImgExtra())) && getMsgReceiveFrom() == pushBodyExtra.getMsgReceiveFrom() && hasLocationExtra() == pushBodyExtra.hasLocationExtra()) {
                                if ((!hasLocationExtra() || getLocationExtra().equals(pushBodyExtra.getLocationExtra())) && hasVideoExtra() == pushBodyExtra.hasVideoExtra()) {
                                    if ((!hasVideoExtra() || getVideoExtra().equals(pushBodyExtra.getVideoExtra())) && hasGroupCardExtra() == pushBodyExtra.hasGroupCardExtra()) {
                                        if ((!hasGroupCardExtra() || getGroupCardExtra().equals(pushBodyExtra.getGroupCardExtra())) && hasLiveShareExtra() == pushBodyExtra.hasLiveShareExtra()) {
                                            if ((!hasLiveShareExtra() || getLiveShareExtra().equals(pushBodyExtra.getLiveShareExtra())) && hasImagetextExtra() == pushBodyExtra.hasImagetextExtra()) {
                                                if ((!hasImagetextExtra() || getImagetextExtra().equals(pushBodyExtra.getImagetextExtra())) && hasHidenAlbumExtra() == pushBodyExtra.hasHidenAlbumExtra()) {
                                                    if ((!hasHidenAlbumExtra() || getHidenAlbumExtra().equals(pushBodyExtra.getHidenAlbumExtra())) && hasShareExtra() == pushBodyExtra.hasShareExtra()) {
                                                        if ((!hasShareExtra() || getShareExtra().equals(pushBodyExtra.getShareExtra())) && hasVipExtra() == pushBodyExtra.hasVipExtra()) {
                                                            if ((!hasVipExtra() || getVipExtra().equals(pushBodyExtra.getVipExtra())) && hasGiftExtra() == pushBodyExtra.hasGiftExtra()) {
                                                                if ((!hasGiftExtra() || getGiftExtra().equals(pushBodyExtra.getGiftExtra())) && hasSysNoticeExtra() == pushBodyExtra.hasSysNoticeExtra()) {
                                                                    if ((!hasSysNoticeExtra() || getSysNoticeExtra().equals(pushBodyExtra.getSysNoticeExtra())) && hasVideoCallingExtra() == pushBodyExtra.hasVideoCallingExtra()) {
                                                                        if ((!hasVideoCallingExtra() || getVideoCallingExtra().equals(pushBodyExtra.getVideoCallingExtra())) && hasVideoEndExtra() == pushBodyExtra.hasVideoEndExtra()) {
                                                                            if ((!hasVideoEndExtra() || getVideoEndExtra().equals(pushBodyExtra.getVideoEndExtra())) && hasFeedShareExtra() == pushBodyExtra.hasFeedShareExtra()) {
                                                                                if ((!hasFeedShareExtra() || getFeedShareExtra().equals(pushBodyExtra.getFeedShareExtra())) && hasSayHiExtra() == pushBodyExtra.hasSayHiExtra()) {
                                                                                    if ((!hasSayHiExtra() || getSayHiExtra().equals(pushBodyExtra.getSayHiExtra())) && hasVoiceRoomShareExtra() == pushBodyExtra.hasVoiceRoomShareExtra()) {
                                                                                        if ((!hasVoiceRoomShareExtra() || getVoiceRoomShareExtra().equals(pushBodyExtra.getVoiceRoomShareExtra())) && hasLiveShareInternationalExtra() == pushBodyExtra.hasLiveShareInternationalExtra()) {
                                                                                            if ((!hasLiveShareInternationalExtra() || getLiveShareInternationalExtra().equals(pushBodyExtra.getLiveShareInternationalExtra())) && hasDoodleShareExtra() == pushBodyExtra.hasDoodleShareExtra()) {
                                                                                                if ((!hasDoodleShareExtra() || getDoodleShareExtra().equals(pushBodyExtra.getDoodleShareExtra())) && hasGroupNotice() == pushBodyExtra.hasGroupNotice()) {
                                                                                                    if ((!hasGroupNotice() || getGroupNotice().equals(pushBodyExtra.getGroupNotice())) && hasActivityShareExtra() == pushBodyExtra.hasActivityShareExtra()) {
                                                                                                        if ((!hasActivityShareExtra() || getActivityShareExtra().equals(pushBodyExtra.getActivityShareExtra())) && hasFriendsCircleExtra() == pushBodyExtra.hasFriendsCircleExtra()) {
                                                                                                            if ((!hasFriendsCircleExtra() || getFriendsCircleExtra().equals(pushBodyExtra.getFriendsCircleExtra())) && hasPnsExtra() == pushBodyExtra.hasPnsExtra()) {
                                                                                                                return (!hasPnsExtra() || getPnsExtra().equals(pushBodyExtra.getPnsExtra())) && this.unknownFields.equals(pushBodyExtra.unknownFields);
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
                return false;
            }
            return super.equals(obj);
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.ActivityShareExtra getActivityShareExtra() {
            MsgBodyExtraOuterClass.ActivityShareExtra activityShareExtra = this.activityShareExtra_;
            MsgBodyExtraOuterClass.ActivityShareExtra activityShareExtra2 = activityShareExtra;
            if (activityShareExtra == null) {
                activityShareExtra2 = MsgBodyExtraOuterClass.ActivityShareExtra.getDefaultInstance();
            }
            return activityShareExtra2;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.ActivityShareExtraOrBuilder getActivityShareExtraOrBuilder() {
            return getActivityShareExtra();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PushBodyExtra getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.DoodleShareExtra getDoodleShareExtra() {
            MsgBodyExtraOuterClass.DoodleShareExtra doodleShareExtra = this.doodleShareExtra_;
            MsgBodyExtraOuterClass.DoodleShareExtra doodleShareExtra2 = doodleShareExtra;
            if (doodleShareExtra == null) {
                doodleShareExtra2 = MsgBodyExtraOuterClass.DoodleShareExtra.getDefaultInstance();
            }
            return doodleShareExtra2;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.DoodleShareExtraOrBuilder getDoodleShareExtraOrBuilder() {
            return getDoodleShareExtra();
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.FeedShareExtra getFeedShareExtra() {
            MsgBodyExtraOuterClass.FeedShareExtra feedShareExtra = this.feedShareExtra_;
            MsgBodyExtraOuterClass.FeedShareExtra feedShareExtra2 = feedShareExtra;
            if (feedShareExtra == null) {
                feedShareExtra2 = MsgBodyExtraOuterClass.FeedShareExtra.getDefaultInstance();
            }
            return feedShareExtra2;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.FeedShareExtraOrBuilder getFeedShareExtraOrBuilder() {
            return getFeedShareExtra();
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.FriendsCircleExtra getFriendsCircleExtra() {
            MsgBodyExtraOuterClass.FriendsCircleExtra friendsCircleExtra = this.friendsCircleExtra_;
            MsgBodyExtraOuterClass.FriendsCircleExtra friendsCircleExtra2 = friendsCircleExtra;
            if (friendsCircleExtra == null) {
                friendsCircleExtra2 = MsgBodyExtraOuterClass.FriendsCircleExtra.getDefaultInstance();
            }
            return friendsCircleExtra2;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.FriendsCircleExtraOrBuilder getFriendsCircleExtraOrBuilder() {
            return getFriendsCircleExtra();
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.GiftExtra getGiftExtra() {
            MsgBodyExtraOuterClass.GiftExtra giftExtra = this.giftExtra_;
            MsgBodyExtraOuterClass.GiftExtra giftExtra2 = giftExtra;
            if (giftExtra == null) {
                giftExtra2 = MsgBodyExtraOuterClass.GiftExtra.getDefaultInstance();
            }
            return giftExtra2;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.GiftExtraOrBuilder getGiftExtraOrBuilder() {
            return getGiftExtra();
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.GroupCardExtra getGroupCardExtra() {
            MsgBodyExtraOuterClass.GroupCardExtra groupCardExtra = this.groupCardExtra_;
            MsgBodyExtraOuterClass.GroupCardExtra groupCardExtra2 = groupCardExtra;
            if (groupCardExtra == null) {
                groupCardExtra2 = MsgBodyExtraOuterClass.GroupCardExtra.getDefaultInstance();
            }
            return groupCardExtra2;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.GroupCardExtraOrBuilder getGroupCardExtraOrBuilder() {
            return getGroupCardExtra();
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.GroupNotice getGroupNotice() {
            MsgBodyExtraOuterClass.GroupNotice groupNotice = this.groupNotice_;
            MsgBodyExtraOuterClass.GroupNotice groupNotice2 = groupNotice;
            if (groupNotice == null) {
                groupNotice2 = MsgBodyExtraOuterClass.GroupNotice.getDefaultInstance();
            }
            return groupNotice2;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.GroupNoticeOrBuilder getGroupNoticeOrBuilder() {
            return getGroupNotice();
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.HidenAlbumExtra getHidenAlbumExtra() {
            MsgBodyExtraOuterClass.HidenAlbumExtra hidenAlbumExtra = this.hidenAlbumExtra_;
            MsgBodyExtraOuterClass.HidenAlbumExtra hidenAlbumExtra2 = hidenAlbumExtra;
            if (hidenAlbumExtra == null) {
                hidenAlbumExtra2 = MsgBodyExtraOuterClass.HidenAlbumExtra.getDefaultInstance();
            }
            return hidenAlbumExtra2;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.HidenAlbumExtraOrBuilder getHidenAlbumExtraOrBuilder() {
            return getHidenAlbumExtra();
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.ImageTextExtra getImagetextExtra() {
            MsgBodyExtraOuterClass.ImageTextExtra imageTextExtra = this.imagetextExtra_;
            MsgBodyExtraOuterClass.ImageTextExtra imageTextExtra2 = imageTextExtra;
            if (imageTextExtra == null) {
                imageTextExtra2 = MsgBodyExtraOuterClass.ImageTextExtra.getDefaultInstance();
            }
            return imageTextExtra2;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.ImageTextExtraOrBuilder getImagetextExtraOrBuilder() {
            return getImagetextExtra();
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.ImgExtra getImgExtra() {
            MsgBodyExtraOuterClass.ImgExtra imgExtra = this.imgExtra_;
            MsgBodyExtraOuterClass.ImgExtra imgExtra2 = imgExtra;
            if (imgExtra == null) {
                imgExtra2 = MsgBodyExtraOuterClass.ImgExtra.getDefaultInstance();
            }
            return imgExtra2;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.ImgExtraOrBuilder getImgExtraOrBuilder() {
            return getImgExtra();
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.LiveShareExtra getLiveShareExtra() {
            MsgBodyExtraOuterClass.LiveShareExtra liveShareExtra = this.liveShareExtra_;
            MsgBodyExtraOuterClass.LiveShareExtra liveShareExtra2 = liveShareExtra;
            if (liveShareExtra == null) {
                liveShareExtra2 = MsgBodyExtraOuterClass.LiveShareExtra.getDefaultInstance();
            }
            return liveShareExtra2;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.LiveShareExtraOrBuilder getLiveShareExtraOrBuilder() {
            return getLiveShareExtra();
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.LiveShareInternationalExtra getLiveShareInternationalExtra() {
            MsgBodyExtraOuterClass.LiveShareInternationalExtra liveShareInternationalExtra = this.liveShareInternationalExtra_;
            MsgBodyExtraOuterClass.LiveShareInternationalExtra liveShareInternationalExtra2 = liveShareInternationalExtra;
            if (liveShareInternationalExtra == null) {
                liveShareInternationalExtra2 = MsgBodyExtraOuterClass.LiveShareInternationalExtra.getDefaultInstance();
            }
            return liveShareInternationalExtra2;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.LiveShareInternationalExtraOrBuilder getLiveShareInternationalExtraOrBuilder() {
            return getLiveShareInternationalExtra();
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.LocationExtra getLocationExtra() {
            MsgBodyExtraOuterClass.LocationExtra locationExtra = this.locationExtra_;
            MsgBodyExtraOuterClass.LocationExtra locationExtra2 = locationExtra;
            if (locationExtra == null) {
                locationExtra2 = MsgBodyExtraOuterClass.LocationExtra.getDefaultInstance();
            }
            return locationExtra2;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.LocationExtraOrBuilder getLocationExtraOrBuilder() {
            return getLocationExtra();
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public long getMsgReceiveFrom() {
            return this.msgReceiveFrom_;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.MsgSource getMsgSource() {
            MsgBodyExtraOuterClass.MsgSource msgSource = this.msgSource_;
            MsgBodyExtraOuterClass.MsgSource msgSource2 = msgSource;
            if (msgSource == null) {
                msgSource2 = MsgBodyExtraOuterClass.MsgSource.getDefaultInstance();
            }
            return msgSource2;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.MsgSourceOrBuilder getMsgSourceOrBuilder() {
            return getMsgSource();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PushBodyExtra> getParserForType() {
            return PARSER;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.PnsExtra getPnsExtra() {
            MsgBodyExtraOuterClass.PnsExtra pnsExtra = this.pnsExtra_;
            MsgBodyExtraOuterClass.PnsExtra pnsExtra2 = pnsExtra;
            if (pnsExtra == null) {
                pnsExtra2 = MsgBodyExtraOuterClass.PnsExtra.getDefaultInstance();
            }
            return pnsExtra2;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.PnsExtraOrBuilder getPnsExtraOrBuilder() {
            return getPnsExtra();
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.SayHiExtra getSayHiExtra() {
            MsgBodyExtraOuterClass.SayHiExtra sayHiExtra = this.sayHiExtra_;
            MsgBodyExtraOuterClass.SayHiExtra sayHiExtra2 = sayHiExtra;
            if (sayHiExtra == null) {
                sayHiExtra2 = MsgBodyExtraOuterClass.SayHiExtra.getDefaultInstance();
            }
            return sayHiExtra2;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.SayHiExtraOrBuilder getSayHiExtraOrBuilder() {
            return getSayHiExtra();
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.SecureNotify getSecureNotify() {
            MsgBodyExtraOuterClass.SecureNotify secureNotify = this.secureNotify_;
            MsgBodyExtraOuterClass.SecureNotify secureNotify2 = secureNotify;
            if (secureNotify == null) {
                secureNotify2 = MsgBodyExtraOuterClass.SecureNotify.getDefaultInstance();
            }
            return secureNotify2;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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
            if (this.msgSource_ != null) {
                i2 = 0 + CodedOutputStream.computeMessageSize(1, getMsgSource());
            }
            int i3 = i2;
            if (this.secureNotify_ != null) {
                i3 = i2 + CodedOutputStream.computeMessageSize(2, getSecureNotify());
            }
            int i4 = i3;
            if (this.textExtra_ != null) {
                i4 = i3 + CodedOutputStream.computeMessageSize(3, getTextExtra());
            }
            int i5 = i4;
            if (this.imgExtra_ != null) {
                i5 = i4 + CodedOutputStream.computeMessageSize(4, getImgExtra());
            }
            long j = this.msgReceiveFrom_;
            int i6 = i5;
            if (j != 0) {
                i6 = i5 + CodedOutputStream.computeInt64Size(5, j);
            }
            int i7 = i6;
            if (this.locationExtra_ != null) {
                i7 = i6 + CodedOutputStream.computeMessageSize(6, getLocationExtra());
            }
            int i8 = i7;
            if (this.videoExtra_ != null) {
                i8 = i7 + CodedOutputStream.computeMessageSize(7, getVideoExtra());
            }
            int i9 = i8;
            if (this.groupCardExtra_ != null) {
                i9 = i8 + CodedOutputStream.computeMessageSize(8, getGroupCardExtra());
            }
            int i10 = i9;
            if (this.liveShareExtra_ != null) {
                i10 = i9 + CodedOutputStream.computeMessageSize(9, getLiveShareExtra());
            }
            int i11 = i10;
            if (this.imagetextExtra_ != null) {
                i11 = i10 + CodedOutputStream.computeMessageSize(10, getImagetextExtra());
            }
            int i12 = i11;
            if (this.hidenAlbumExtra_ != null) {
                i12 = i11 + CodedOutputStream.computeMessageSize(11, getHidenAlbumExtra());
            }
            int i13 = i12;
            if (this.shareExtra_ != null) {
                i13 = i12 + CodedOutputStream.computeMessageSize(12, getShareExtra());
            }
            int i14 = i13;
            if (this.vipExtra_ != null) {
                i14 = i13 + CodedOutputStream.computeMessageSize(13, getVipExtra());
            }
            int i15 = i14;
            if (this.giftExtra_ != null) {
                i15 = i14 + CodedOutputStream.computeMessageSize(14, getGiftExtra());
            }
            int i16 = i15;
            if (this.sysNoticeExtra_ != null) {
                i16 = i15 + CodedOutputStream.computeMessageSize(15, getSysNoticeExtra());
            }
            int i17 = i16;
            if (this.videoCallingExtra_ != null) {
                i17 = i16 + CodedOutputStream.computeMessageSize(16, getVideoCallingExtra());
            }
            int i18 = i17;
            if (this.videoEndExtra_ != null) {
                i18 = i17 + CodedOutputStream.computeMessageSize(17, getVideoEndExtra());
            }
            int i19 = i18;
            if (this.feedShareExtra_ != null) {
                i19 = i18 + CodedOutputStream.computeMessageSize(18, getFeedShareExtra());
            }
            int i20 = i19;
            if (this.sayHiExtra_ != null) {
                i20 = i19 + CodedOutputStream.computeMessageSize(19, getSayHiExtra());
            }
            int i21 = i20;
            if (this.voiceRoomShareExtra_ != null) {
                i21 = i20 + CodedOutputStream.computeMessageSize(20, getVoiceRoomShareExtra());
            }
            int i22 = i21;
            if (this.liveShareInternationalExtra_ != null) {
                i22 = i21 + CodedOutputStream.computeMessageSize(21, getLiveShareInternationalExtra());
            }
            int i23 = i22;
            if (this.doodleShareExtra_ != null) {
                i23 = i22 + CodedOutputStream.computeMessageSize(22, getDoodleShareExtra());
            }
            int i24 = i23;
            if (this.groupNotice_ != null) {
                i24 = i23 + CodedOutputStream.computeMessageSize(23, getGroupNotice());
            }
            int i25 = i24;
            if (this.activityShareExtra_ != null) {
                i25 = i24 + CodedOutputStream.computeMessageSize(24, getActivityShareExtra());
            }
            int i26 = i25;
            if (this.friendsCircleExtra_ != null) {
                i26 = i25 + CodedOutputStream.computeMessageSize(25, getFriendsCircleExtra());
            }
            int i27 = i26;
            if (this.pnsExtra_ != null) {
                i27 = i26 + CodedOutputStream.computeMessageSize(26, getPnsExtra());
            }
            int serializedSize = i27 + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.ShareExtra getShareExtra() {
            MsgBodyExtraOuterClass.ShareExtra shareExtra = this.shareExtra_;
            MsgBodyExtraOuterClass.ShareExtra shareExtra2 = shareExtra;
            if (shareExtra == null) {
                shareExtra2 = MsgBodyExtraOuterClass.ShareExtra.getDefaultInstance();
            }
            return shareExtra2;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.ShareExtraOrBuilder getShareExtraOrBuilder() {
            return getShareExtra();
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.SysNoticeExtra getSysNoticeExtra() {
            MsgBodyExtraOuterClass.SysNoticeExtra sysNoticeExtra = this.sysNoticeExtra_;
            MsgBodyExtraOuterClass.SysNoticeExtra sysNoticeExtra2 = sysNoticeExtra;
            if (sysNoticeExtra == null) {
                sysNoticeExtra2 = MsgBodyExtraOuterClass.SysNoticeExtra.getDefaultInstance();
            }
            return sysNoticeExtra2;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.SysNoticeExtraOrBuilder getSysNoticeExtraOrBuilder() {
            return getSysNoticeExtra();
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.TextExtra getTextExtra() {
            MsgBodyExtraOuterClass.TextExtra textExtra = this.textExtra_;
            MsgBodyExtraOuterClass.TextExtra textExtra2 = textExtra;
            if (textExtra == null) {
                textExtra2 = MsgBodyExtraOuterClass.TextExtra.getDefaultInstance();
            }
            return textExtra2;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.TextExtraOrBuilder getTextExtraOrBuilder() {
            return getTextExtra();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.VideoChatCallingExtra getVideoCallingExtra() {
            MsgBodyExtraOuterClass.VideoChatCallingExtra videoChatCallingExtra = this.videoCallingExtra_;
            MsgBodyExtraOuterClass.VideoChatCallingExtra videoChatCallingExtra2 = videoChatCallingExtra;
            if (videoChatCallingExtra == null) {
                videoChatCallingExtra2 = MsgBodyExtraOuterClass.VideoChatCallingExtra.getDefaultInstance();
            }
            return videoChatCallingExtra2;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.VideoChatCallingExtraOrBuilder getVideoCallingExtraOrBuilder() {
            return getVideoCallingExtra();
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.VideoChatEndExtra getVideoEndExtra() {
            MsgBodyExtraOuterClass.VideoChatEndExtra videoChatEndExtra = this.videoEndExtra_;
            MsgBodyExtraOuterClass.VideoChatEndExtra videoChatEndExtra2 = videoChatEndExtra;
            if (videoChatEndExtra == null) {
                videoChatEndExtra2 = MsgBodyExtraOuterClass.VideoChatEndExtra.getDefaultInstance();
            }
            return videoChatEndExtra2;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.VideoChatEndExtraOrBuilder getVideoEndExtraOrBuilder() {
            return getVideoEndExtra();
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.VideoExtra getVideoExtra() {
            MsgBodyExtraOuterClass.VideoExtra videoExtra = this.videoExtra_;
            MsgBodyExtraOuterClass.VideoExtra videoExtra2 = videoExtra;
            if (videoExtra == null) {
                videoExtra2 = MsgBodyExtraOuterClass.VideoExtra.getDefaultInstance();
            }
            return videoExtra2;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.VideoExtraOrBuilder getVideoExtraOrBuilder() {
            return getVideoExtra();
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.VipExtra getVipExtra() {
            MsgBodyExtraOuterClass.VipExtra vipExtra = this.vipExtra_;
            MsgBodyExtraOuterClass.VipExtra vipExtra2 = vipExtra;
            if (vipExtra == null) {
                vipExtra2 = MsgBodyExtraOuterClass.VipExtra.getDefaultInstance();
            }
            return vipExtra2;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.VipExtraOrBuilder getVipExtraOrBuilder() {
            return getVipExtra();
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.VoiceRoomShareExtra getVoiceRoomShareExtra() {
            MsgBodyExtraOuterClass.VoiceRoomShareExtra voiceRoomShareExtra = this.voiceRoomShareExtra_;
            MsgBodyExtraOuterClass.VoiceRoomShareExtra voiceRoomShareExtra2 = voiceRoomShareExtra;
            if (voiceRoomShareExtra == null) {
                voiceRoomShareExtra2 = MsgBodyExtraOuterClass.VoiceRoomShareExtra.getDefaultInstance();
            }
            return voiceRoomShareExtra2;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public MsgBodyExtraOuterClass.VoiceRoomShareExtraOrBuilder getVoiceRoomShareExtraOrBuilder() {
            return getVoiceRoomShareExtra();
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public boolean hasActivityShareExtra() {
            return this.activityShareExtra_ != null;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public boolean hasDoodleShareExtra() {
            return this.doodleShareExtra_ != null;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public boolean hasFeedShareExtra() {
            return this.feedShareExtra_ != null;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public boolean hasFriendsCircleExtra() {
            return this.friendsCircleExtra_ != null;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public boolean hasGiftExtra() {
            return this.giftExtra_ != null;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public boolean hasGroupCardExtra() {
            return this.groupCardExtra_ != null;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public boolean hasGroupNotice() {
            return this.groupNotice_ != null;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public boolean hasHidenAlbumExtra() {
            return this.hidenAlbumExtra_ != null;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public boolean hasImagetextExtra() {
            return this.imagetextExtra_ != null;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public boolean hasImgExtra() {
            return this.imgExtra_ != null;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public boolean hasLiveShareExtra() {
            return this.liveShareExtra_ != null;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public boolean hasLiveShareInternationalExtra() {
            return this.liveShareInternationalExtra_ != null;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public boolean hasLocationExtra() {
            return this.locationExtra_ != null;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public boolean hasMsgSource() {
            return this.msgSource_ != null;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public boolean hasPnsExtra() {
            return this.pnsExtra_ != null;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public boolean hasSayHiExtra() {
            return this.sayHiExtra_ != null;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public boolean hasSecureNotify() {
            return this.secureNotify_ != null;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public boolean hasShareExtra() {
            return this.shareExtra_ != null;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public boolean hasSysNoticeExtra() {
            return this.sysNoticeExtra_ != null;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public boolean hasTextExtra() {
            return this.textExtra_ != null;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public boolean hasVideoCallingExtra() {
            return this.videoCallingExtra_ != null;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public boolean hasVideoEndExtra() {
            return this.videoEndExtra_ != null;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public boolean hasVideoExtra() {
            return this.videoExtra_ != null;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
        public boolean hasVipExtra() {
            return this.vipExtra_ != null;
        }

        @Override // com.blued.im.private_chat.PushBodyExtraOuterClass.PushBodyExtraOrBuilder
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
            if (hasMsgSource()) {
                i = (((hashCode * 37) + 1) * 53) + getMsgSource().hashCode();
            }
            int i2 = i;
            if (hasSecureNotify()) {
                i2 = (((i * 37) + 2) * 53) + getSecureNotify().hashCode();
            }
            int i3 = i2;
            if (hasTextExtra()) {
                i3 = (((i2 * 37) + 3) * 53) + getTextExtra().hashCode();
            }
            int i4 = i3;
            if (hasImgExtra()) {
                i4 = (((i3 * 37) + 4) * 53) + getImgExtra().hashCode();
            }
            int hashLong = (((i4 * 37) + 5) * 53) + Internal.hashLong(getMsgReceiveFrom());
            int i5 = hashLong;
            if (hasLocationExtra()) {
                i5 = (((hashLong * 37) + 6) * 53) + getLocationExtra().hashCode();
            }
            int i6 = i5;
            if (hasVideoExtra()) {
                i6 = (((i5 * 37) + 7) * 53) + getVideoExtra().hashCode();
            }
            int i7 = i6;
            if (hasGroupCardExtra()) {
                i7 = (((i6 * 37) + 8) * 53) + getGroupCardExtra().hashCode();
            }
            int i8 = i7;
            if (hasLiveShareExtra()) {
                i8 = (((i7 * 37) + 9) * 53) + getLiveShareExtra().hashCode();
            }
            int i9 = i8;
            if (hasImagetextExtra()) {
                i9 = (((i8 * 37) + 10) * 53) + getImagetextExtra().hashCode();
            }
            int i10 = i9;
            if (hasHidenAlbumExtra()) {
                i10 = (((i9 * 37) + 11) * 53) + getHidenAlbumExtra().hashCode();
            }
            int i11 = i10;
            if (hasShareExtra()) {
                i11 = (((i10 * 37) + 12) * 53) + getShareExtra().hashCode();
            }
            int i12 = i11;
            if (hasVipExtra()) {
                i12 = (((i11 * 37) + 13) * 53) + getVipExtra().hashCode();
            }
            int i13 = i12;
            if (hasGiftExtra()) {
                i13 = (((i12 * 37) + 14) * 53) + getGiftExtra().hashCode();
            }
            int i14 = i13;
            if (hasSysNoticeExtra()) {
                i14 = (((i13 * 37) + 15) * 53) + getSysNoticeExtra().hashCode();
            }
            int i15 = i14;
            if (hasVideoCallingExtra()) {
                i15 = (((i14 * 37) + 16) * 53) + getVideoCallingExtra().hashCode();
            }
            int i16 = i15;
            if (hasVideoEndExtra()) {
                i16 = (((i15 * 37) + 17) * 53) + getVideoEndExtra().hashCode();
            }
            int i17 = i16;
            if (hasFeedShareExtra()) {
                i17 = (((i16 * 37) + 18) * 53) + getFeedShareExtra().hashCode();
            }
            int i18 = i17;
            if (hasSayHiExtra()) {
                i18 = (((i17 * 37) + 19) * 53) + getSayHiExtra().hashCode();
            }
            int i19 = i18;
            if (hasVoiceRoomShareExtra()) {
                i19 = (((i18 * 37) + 20) * 53) + getVoiceRoomShareExtra().hashCode();
            }
            int i20 = i19;
            if (hasLiveShareInternationalExtra()) {
                i20 = (((i19 * 37) + 21) * 53) + getLiveShareInternationalExtra().hashCode();
            }
            int i21 = i20;
            if (hasDoodleShareExtra()) {
                i21 = (((i20 * 37) + 22) * 53) + getDoodleShareExtra().hashCode();
            }
            int i22 = i21;
            if (hasGroupNotice()) {
                i22 = (((i21 * 37) + 23) * 53) + getGroupNotice().hashCode();
            }
            int i23 = i22;
            if (hasActivityShareExtra()) {
                i23 = (((i22 * 37) + 24) * 53) + getActivityShareExtra().hashCode();
            }
            int i24 = i23;
            if (hasFriendsCircleExtra()) {
                i24 = (((i23 * 37) + 25) * 53) + getFriendsCircleExtra().hashCode();
            }
            int i25 = i24;
            if (hasPnsExtra()) {
                i25 = (((i24 * 37) + 26) * 53) + getPnsExtra().hashCode();
            }
            int hashCode2 = (i25 * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PushBodyExtraOuterClass.internal_static_com_blued_im_private_chat_PushBodyExtra_fieldAccessorTable.ensureFieldAccessorsInitialized(PushBodyExtra.class, Builder.class);
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
            return new PushBodyExtra();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.msgSource_ != null) {
                codedOutputStream.writeMessage(1, getMsgSource());
            }
            if (this.secureNotify_ != null) {
                codedOutputStream.writeMessage(2, getSecureNotify());
            }
            if (this.textExtra_ != null) {
                codedOutputStream.writeMessage(3, getTextExtra());
            }
            if (this.imgExtra_ != null) {
                codedOutputStream.writeMessage(4, getImgExtra());
            }
            long j = this.msgReceiveFrom_;
            if (j != 0) {
                codedOutputStream.writeInt64(5, j);
            }
            if (this.locationExtra_ != null) {
                codedOutputStream.writeMessage(6, getLocationExtra());
            }
            if (this.videoExtra_ != null) {
                codedOutputStream.writeMessage(7, getVideoExtra());
            }
            if (this.groupCardExtra_ != null) {
                codedOutputStream.writeMessage(8, getGroupCardExtra());
            }
            if (this.liveShareExtra_ != null) {
                codedOutputStream.writeMessage(9, getLiveShareExtra());
            }
            if (this.imagetextExtra_ != null) {
                codedOutputStream.writeMessage(10, getImagetextExtra());
            }
            if (this.hidenAlbumExtra_ != null) {
                codedOutputStream.writeMessage(11, getHidenAlbumExtra());
            }
            if (this.shareExtra_ != null) {
                codedOutputStream.writeMessage(12, getShareExtra());
            }
            if (this.vipExtra_ != null) {
                codedOutputStream.writeMessage(13, getVipExtra());
            }
            if (this.giftExtra_ != null) {
                codedOutputStream.writeMessage(14, getGiftExtra());
            }
            if (this.sysNoticeExtra_ != null) {
                codedOutputStream.writeMessage(15, getSysNoticeExtra());
            }
            if (this.videoCallingExtra_ != null) {
                codedOutputStream.writeMessage(16, getVideoCallingExtra());
            }
            if (this.videoEndExtra_ != null) {
                codedOutputStream.writeMessage(17, getVideoEndExtra());
            }
            if (this.feedShareExtra_ != null) {
                codedOutputStream.writeMessage(18, getFeedShareExtra());
            }
            if (this.sayHiExtra_ != null) {
                codedOutputStream.writeMessage(19, getSayHiExtra());
            }
            if (this.voiceRoomShareExtra_ != null) {
                codedOutputStream.writeMessage(20, getVoiceRoomShareExtra());
            }
            if (this.liveShareInternationalExtra_ != null) {
                codedOutputStream.writeMessage(21, getLiveShareInternationalExtra());
            }
            if (this.doodleShareExtra_ != null) {
                codedOutputStream.writeMessage(22, getDoodleShareExtra());
            }
            if (this.groupNotice_ != null) {
                codedOutputStream.writeMessage(23, getGroupNotice());
            }
            if (this.activityShareExtra_ != null) {
                codedOutputStream.writeMessage(24, getActivityShareExtra());
            }
            if (this.friendsCircleExtra_ != null) {
                codedOutputStream.writeMessage(25, getFriendsCircleExtra());
            }
            if (this.pnsExtra_ != null) {
                codedOutputStream.writeMessage(26, getPnsExtra());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/im/private_chat/PushBodyExtraOuterClass$PushBodyExtraOrBuilder.class */
    public interface PushBodyExtraOrBuilder extends MessageOrBuilder {
        MsgBodyExtraOuterClass.ActivityShareExtra getActivityShareExtra();

        MsgBodyExtraOuterClass.ActivityShareExtraOrBuilder getActivityShareExtraOrBuilder();

        MsgBodyExtraOuterClass.DoodleShareExtra getDoodleShareExtra();

        MsgBodyExtraOuterClass.DoodleShareExtraOrBuilder getDoodleShareExtraOrBuilder();

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

        long getMsgReceiveFrom();

        MsgBodyExtraOuterClass.MsgSource getMsgSource();

        MsgBodyExtraOuterClass.MsgSourceOrBuilder getMsgSourceOrBuilder();

        MsgBodyExtraOuterClass.PnsExtra getPnsExtra();

        MsgBodyExtraOuterClass.PnsExtraOrBuilder getPnsExtraOrBuilder();

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

        boolean hasMsgSource();

        boolean hasPnsExtra();

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
        internal_static_com_blued_im_private_chat_PushBodyExtra_descriptor = descriptor2;
        internal_static_com_blued_im_private_chat_PushBodyExtra_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{"MsgSource", "SecureNotify", "TextExtra", "ImgExtra", "MsgReceiveFrom", "LocationExtra", "VideoExtra", "GroupCardExtra", "LiveShareExtra", "ImagetextExtra", "HidenAlbumExtra", "ShareExtra", "VipExtra", "GiftExtra", "SysNoticeExtra", "VideoCallingExtra", "VideoEndExtra", "FeedShareExtra", "SayHiExtra", "VoiceRoomShareExtra", "LiveShareInternationalExtra", "DoodleShareExtra", "GroupNotice", "ActivityShareExtra", "FriendsCircleExtra", "PnsExtra"});
        MsgBodyExtraOuterClass.getDescriptor();
    }

    private PushBodyExtraOuterClass() {
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
